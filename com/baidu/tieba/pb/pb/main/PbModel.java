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
    private BaseActivity bBW;
    private final CheckRealNameModel cwQ;
    private int der;
    private com.baidu.tieba.tbadkCore.d.b dsH;
    private long ecY;
    private boolean fjC;
    protected String gbQ;
    private String gbR;
    private String gbS;
    private boolean gbT;
    private boolean gbU;
    private boolean gbV;
    private boolean gbW;
    private int gbX;
    private boolean gbY;
    private int gbZ;
    private String gcA;
    private long gcB;
    private boolean gcC;
    private int gcD;
    private boolean gcE;
    private boolean gcF;
    private int gcG;
    private final x gcH;
    private final h gcI;
    private final m gcJ;
    private final z gcK;
    private String gcL;
    private final AddExperiencedModel gcM;
    private SuggestEmotionModel gcN;
    private GetSugMatchWordsModel gcO;
    private boolean gcP;
    private int gcQ;
    private String gcR;
    private PostData gcS;
    private PostData gcT;
    private int gcU;
    private int gcV;
    private String gcW;
    private com.baidu.tieba.tbadkCore.data.l gcX;
    private CustomMessageListener gcY;
    private CustomMessageListener gcZ;
    private long gca;
    private int gcb;
    private int gcc;
    private int gcd;
    private boolean gce;
    private boolean gcf;
    private boolean gcg;
    private long gch;
    private boolean gci;
    private String gcj;
    protected com.baidu.tieba.pb.data.d gck;
    private int gcl;
    private boolean gcm;
    private boolean gcn;
    private boolean gco;
    private boolean gcp;
    private a gcq;
    private String gcr;
    private String gcs;
    private int gct;
    private int gcu;
    private boolean gcv;
    private boolean gcw;
    private boolean gcx;
    private boolean gcy;
    private boolean gcz;
    private com.baidu.adp.framework.listener.a gda;
    private PraiseData gdb;
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
    private static final int gbP = com.baidu.tbadk.data.d.LM() / 30;
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
        this.gbQ = null;
        this.gbR = null;
        this.gbS = null;
        this.mForumId = null;
        this.gbT = false;
        this.gbU = false;
        this.gbV = true;
        this.gbW = true;
        this.mSortType = 0;
        this.gbX = 0;
        this.gbY = false;
        this.mIsGood = 0;
        this.gbZ = 0;
        this.gca = 0L;
        this.gcb = 1;
        this.gcc = 1;
        this.gcd = 1;
        this.der = 1;
        this.isAd = false;
        this.fjC = false;
        this.gce = false;
        this.gcf = false;
        this.isFromMark = false;
        this.gcg = false;
        this.gch = 0L;
        this.gci = false;
        this.gcj = null;
        this.gck = null;
        this.isLoading = false;
        this.gcm = false;
        this.gcn = false;
        this.gco = false;
        this.gcp = false;
        this.mLocate = null;
        this.mContext = null;
        this.gcq = null;
        this.opType = null;
        this.opUrl = null;
        this.gcr = null;
        this.gcs = null;
        this.gct = -1;
        this.gcu = -1;
        this.dsH = null;
        this.gcw = false;
        this.gcx = false;
        this.postID = null;
        this.gcA = null;
        this.gcB = 0L;
        this.gcC = false;
        this.gcD = -1;
        this.gcF = false;
        this.gcP = false;
        this.gcQ = 0;
        this.gcY = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.gcz = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.n(pbData);
                    PbModel.this.j(pbData);
                    if (pbData.bhz() != null) {
                        pbData.bhz().cO(0);
                    }
                    if (PbModel.this.gcq != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.gcq.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.gcZ = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bhx() != null && PbModel.this.getPbData().bhx().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bhx().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.gda = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kV()) {
                        PbModel.this.bBW.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.gcw || !PbModel.this.gcx) {
                        if (!PbModel.this.gcw) {
                            PbModel.this.gcw = true;
                        } else {
                            PbModel.this.gcx = true;
                        }
                        if (PbModel.this.gcq != null) {
                            PbModel.this.gcq.a(PbModel.this.bkr(), z, responsedMessage, PbModel.this.gcy, System.currentTimeMillis() - PbModel.this.ecY);
                        }
                    }
                }
            }
        };
        this.gdb = null;
        registerListener(this.gcY);
        registerListener(this.gda);
        registerListener(this.gcZ);
        this.gck = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bBW = baseActivity;
        this.gcH = new x(this, this.bBW);
        this.gcI = new h(this, this.bBW);
        this.gcJ = new m(this, this.bBW);
        this.gcK = new z(this, this.bBW);
        this.cwQ = new CheckRealNameModel(this.bBW.getPageContext());
        this.gcN = new SuggestEmotionModel();
        this.gcM = new AddExperiencedModel(this.bBW.getPageContext());
    }

    protected int bkr() {
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
            this.gbQ = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.e(data)) {
                com.baidu.tbadk.BdToken.f.vJ().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.ald) instanceof String)) {
                            PbModel.this.gbQ = (String) hashMap.get(com.baidu.tbadk.BdToken.f.ald);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.gbQ)) {
                this.gbQ = this.gcH.Y(intent);
                if (StringUtils.isNull(this.gbQ) && intent.getData() != null) {
                    this.gbQ = data.getQueryParameter("thread_id");
                }
            }
            this.gcQ = intent.getIntExtra("key_start_from", 0);
            if (this.gcQ == 0) {
                this.gcQ = this.gcH.gdh;
            }
            this.gbS = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.gbR = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.gbT = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.gbU = intent.getBooleanExtra("host_only", false);
            this.gbW = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.Qb().Gt() ? 2 : 0);
            if (this.mSortType == 2) {
                this.gbS = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.gbZ = intent.getIntExtra("is_top", 0);
            this.gca = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.gcg = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.fjC = intent.getBooleanExtra("is_sub_pb", false);
            this.gci = intent.getBooleanExtra("is_pv", false);
            this.gch = intent.getLongExtra("msg_id", 0L);
            this.gcj = intent.getStringExtra("from_forum_name");
            this.gcs = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.gcr = intent.getStringExtra("op_stat");
            this.gcm = intent.getBooleanExtra("is_from_thread_config", false);
            this.gcn = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.gco = intent.getBooleanExtra("is_from_my_god_config", false);
            this.gcu = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.gct = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.gce = intent.getBooleanExtra("from_frs", false);
            this.gcf = intent.getBooleanExtra("from_maintab", false);
            this.gcF = intent.getBooleanExtra("from_smart_frs", false);
            this.gcp = intent.getBooleanExtra("from_hottopic", false);
            this.gcL = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.gcQ = bundle.getInt("key_start_from", 0);
        this.gbQ = bundle.getString("thread_id");
        this.gbS = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.gbR = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.gbT = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.gbU = bundle.getBoolean("host_only", false);
        this.gbW = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.gbZ = bundle.getInt("is_top", 0);
        this.gca = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.gcg = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.fjC = bundle.getBoolean("is_sub_pb", false);
        this.gci = bundle.getBoolean("is_pv", false);
        this.gch = bundle.getLong("msg_id", 0L);
        this.gcj = bundle.getString("from_forum_name");
        this.gcs = bundle.getString("extra_pb_cache_key");
        this.gcm = bundle.getBoolean("is_from_thread_config", false);
        this.gcn = bundle.getBoolean("is_from_interview_live_config", false);
        this.gco = bundle.getBoolean("is_from_my_god_config", false);
        this.gcu = bundle.getInt("extra_pb_is_attention_key", -1);
        this.gct = bundle.getInt("extra_pb_funs_count_key", -1);
        this.gce = bundle.getBoolean("from_frs", false);
        this.gcf = bundle.getBoolean("from_maintab", false);
        this.gcF = bundle.getBoolean("from_smart_frs", false);
        this.gcp = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void G(Bundle bundle) {
        bundle.putString("thread_id", this.gbQ);
        bundle.putString("post_id", this.gbS);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.gcQ);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.gbT);
        bundle.putBoolean("host_only", this.gbU);
        bundle.putBoolean("squence", this.gbW);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.gbZ);
        bundle.putLong("thread_time", this.gca);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.gcg);
        bundle.putBoolean("is_sub_pb", this.fjC);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.gci);
        bundle.putLong("msg_id", this.gch);
        bundle.putString("extra_pb_cache_key", this.gcs);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.gcm);
        bundle.putBoolean("is_from_interview_live_config", this.gcn);
        bundle.putBoolean("is_from_my_god_config", this.gco);
        bundle.putInt("extra_pb_is_attention_key", this.gcu);
        bundle.putInt("extra_pb_funs_count_key", this.gct);
        bundle.putBoolean("from_frs", this.gce);
        bundle.putBoolean("from_maintab", this.gcf);
        bundle.putBoolean("from_smart_frs", this.gcF);
        bundle.putBoolean("from_hottopic", this.gcp);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bks() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.gbQ);
        if (!this.gcg) {
            sb.append(this.gbS);
        }
        sb.append(this.gbU);
        sb.append(this.gbW);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.gbZ);
        sb.append(this.gca);
        sb.append(this.gce);
        sb.append(this.gcf);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.fjC);
        sb.append(this.gci);
        sb.append(this.gch);
        sb.append(this.gcj);
        sb.append(this.mThreadType);
        sb.append(this.gcm);
        sb.append(this.gcn);
        sb.append(this.gco);
        if (this.gcs != null) {
            sb.append(this.gcs);
        }
        return sb.toString();
    }

    public String biu() {
        return this.gcj;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.gbS;
    }

    public String bkt() {
        return this.gbQ;
    }

    public boolean getHostMode() {
        return this.gbU;
    }

    public boolean bku() {
        return bli();
    }

    public int acy() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bkv() {
        return this.gce;
    }

    public boolean bkw() {
        return this.gbY;
    }

    public boolean bkx() {
        return this.gcf;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bky() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bkz() {
        return this.gbZ;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lc(int i) {
        this.gbZ = i;
    }

    public boolean bkA() {
        return this.fjC;
    }

    public boolean bkB() {
        if (this.gck == null) {
            return false;
        }
        return this.gck.isValid();
    }

    public String Ad() {
        if (this.gck == null || !this.gck.wx()) {
            return null;
        }
        return this.gck.ww();
    }

    public boolean sE(int i) {
        this.gcb = i;
        if (this.gcb > this.gck.zf().yX()) {
            this.gcb = this.gck.zf().yX();
        }
        if (this.gcb < 1) {
            this.gcb = 1;
        }
        if (this.gbQ == null) {
            return false;
        }
        return sG(5);
    }

    public void sF(int i) {
        this.gcb = i;
        this.gcc = i;
        this.gcd = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            sF(1);
            return;
        }
        if (this.gcc < alVar.za()) {
            this.gcc = alVar.za();
        }
        if (this.gcd > alVar.za()) {
            this.gcd = alVar.za();
        }
        this.der = alVar.yX();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.gck;
    }

    public com.baidu.tieba.pb.data.d bkC() {
        if (this.gck == null) {
            return this.gck;
        }
        if (!bkD() && this.gcX != null) {
            this.gck.b(this.gcX);
        }
        return this.gck;
    }

    private boolean bkD() {
        return (this.gck.bhP() == null || this.gck.bhP().bEG() == null || this.gck.bhP().bEG().goods != null || this.gck.bhP().bEG().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.gck == null) {
            return null;
        }
        return this.gck.zf();
    }

    public boolean bkE() {
        if (bli() && this.gck.zf().zc() == 0) {
            kX(true);
            return true;
        }
        return false;
    }

    public void ti(String str) {
        if (!StringUtils.isNull(str)) {
            this.gbQ = str;
            this.gbS = null;
            this.gbU = false;
            this.gbW = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gbQ == null) {
            return false;
        }
        cancelLoadData();
        if (this.dsH == null) {
            this.dsH = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dsH.start();
        }
        boolean sG = sG(3);
        if (this.opType != null) {
            this.opType = null;
            this.gcr = null;
            this.opUrl = null;
            return sG;
        }
        return sG;
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
        if (this.gcN != null) {
            this.gcN.cancelLoadData();
        }
        if (this.gcO != null) {
            this.gcO.cancelLoadData();
        }
        awO();
    }

    private void awO() {
        if (this.dsH != null) {
            this.dsH.destory();
            this.dsH = null;
        }
    }

    public boolean OP() {
        return (this.gbS == null || this.gbS.equals("0") || this.gbS.length() == 0) ? LoadData() : bkJ();
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
                this.gcN.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.gcN.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.gcO == null) {
                this.gcO = new GetSugMatchWordsModel(this.bBW.getPageContext());
            }
            this.gcO.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0315 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:137:0x0385, B:112:0x0315, B:114:0x031b, B:115:0x0320, B:117:0x0324, B:119:0x032e, B:124:0x0345, B:126:0x0353, B:127:0x0356, B:129:0x035a, B:130:0x0365, B:132:0x0369, B:134:0x0371, B:136:0x0380, B:138:0x038a, B:140:0x038e, B:121:0x0332, B:141:0x0397, B:142:0x03c5, B:144:0x03c9, B:154:0x03fa, B:147:0x03d5, B:149:0x03e3, B:150:0x03eb, B:152:0x03ef, B:153:0x03f5, B:155:0x0403, B:146:0x03cd, B:156:0x040c, B:158:0x0418, B:160:0x041c, B:162:0x0420, B:163:0x0425, B:165:0x0431, B:166:0x0439, B:170:0x0453, B:167:0x043e, B:169:0x044d, B:171:0x045c, B:173:0x046b, B:38:0x00ce), top: B:177:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0324 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:137:0x0385, B:112:0x0315, B:114:0x031b, B:115:0x0320, B:117:0x0324, B:119:0x032e, B:124:0x0345, B:126:0x0353, B:127:0x0356, B:129:0x035a, B:130:0x0365, B:132:0x0369, B:134:0x0371, B:136:0x0380, B:138:0x038a, B:140:0x038e, B:121:0x0332, B:141:0x0397, B:142:0x03c5, B:144:0x03c9, B:154:0x03fa, B:147:0x03d5, B:149:0x03e3, B:150:0x03eb, B:152:0x03ef, B:153:0x03f5, B:155:0x0403, B:146:0x03cd, B:156:0x040c, B:158:0x0418, B:160:0x041c, B:162:0x0420, B:163:0x0425, B:165:0x0431, B:166:0x0439, B:170:0x0453, B:167:0x043e, B:169:0x044d, B:171:0x045c, B:173:0x046b, B:38:0x00ce), top: B:177:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x035a A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:137:0x0385, B:112:0x0315, B:114:0x031b, B:115:0x0320, B:117:0x0324, B:119:0x032e, B:124:0x0345, B:126:0x0353, B:127:0x0356, B:129:0x035a, B:130:0x0365, B:132:0x0369, B:134:0x0371, B:136:0x0380, B:138:0x038a, B:140:0x038e, B:121:0x0332, B:141:0x0397, B:142:0x03c5, B:144:0x03c9, B:154:0x03fa, B:147:0x03d5, B:149:0x03e3, B:150:0x03eb, B:152:0x03ef, B:153:0x03f5, B:155:0x0403, B:146:0x03cd, B:156:0x040c, B:158:0x0418, B:160:0x041c, B:162:0x0420, B:163:0x0425, B:165:0x0431, B:166:0x0439, B:170:0x0453, B:167:0x043e, B:169:0x044d, B:171:0x045c, B:173:0x046b, B:38:0x00ce), top: B:177:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0369 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:137:0x0385, B:112:0x0315, B:114:0x031b, B:115:0x0320, B:117:0x0324, B:119:0x032e, B:124:0x0345, B:126:0x0353, B:127:0x0356, B:129:0x035a, B:130:0x0365, B:132:0x0369, B:134:0x0371, B:136:0x0380, B:138:0x038a, B:140:0x038e, B:121:0x0332, B:141:0x0397, B:142:0x03c5, B:144:0x03c9, B:154:0x03fa, B:147:0x03d5, B:149:0x03e3, B:150:0x03eb, B:152:0x03ef, B:153:0x03f5, B:155:0x0403, B:146:0x03cd, B:156:0x040c, B:158:0x0418, B:160:0x041c, B:162:0x0420, B:163:0x0425, B:165:0x0431, B:166:0x0439, B:170:0x0453, B:167:0x043e, B:169:0x044d, B:171:0x045c, B:173:0x046b, B:38:0x00ce), top: B:177:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x038e A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:34:0x00c2, B:36:0x00c6, B:45:0x00ea, B:48:0x013b, B:50:0x0158, B:51:0x0160, B:53:0x016d, B:54:0x0175, B:56:0x0179, B:57:0x017e, B:59:0x0182, B:60:0x0187, B:62:0x018b, B:63:0x019b, B:65:0x019f, B:66:0x01a7, B:68:0x01ab, B:69:0x01c4, B:70:0x01d3, B:71:0x01d6, B:74:0x0202, B:75:0x0232, B:76:0x024f, B:78:0x0267, B:80:0x026d, B:82:0x0274, B:83:0x0281, B:85:0x0295, B:87:0x029b, B:89:0x02a1, B:98:0x02d1, B:100:0x02d7, B:90:0x02ac, B:92:0x02b0, B:94:0x02b8, B:96:0x02c7, B:97:0x02cc, B:101:0x02e3, B:103:0x02f7, B:105:0x02fb, B:108:0x030d, B:137:0x0385, B:112:0x0315, B:114:0x031b, B:115:0x0320, B:117:0x0324, B:119:0x032e, B:124:0x0345, B:126:0x0353, B:127:0x0356, B:129:0x035a, B:130:0x0365, B:132:0x0369, B:134:0x0371, B:136:0x0380, B:138:0x038a, B:140:0x038e, B:121:0x0332, B:141:0x0397, B:142:0x03c5, B:144:0x03c9, B:154:0x03fa, B:147:0x03d5, B:149:0x03e3, B:150:0x03eb, B:152:0x03ef, B:153:0x03f5, B:155:0x0403, B:146:0x03cd, B:156:0x040c, B:158:0x0418, B:160:0x041c, B:162:0x0420, B:163:0x0425, B:165:0x0431, B:166:0x0439, B:170:0x0453, B:167:0x043e, B:169:0x044d, B:171:0x045c, B:173:0x046b, B:38:0x00ce), top: B:177:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sG(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sH(i);
        final com.baidu.tieba.pb.data.d pbData = aj.blF().getPbData();
        if (pbData != null && pbData.bhz() != null) {
            pbData.bhz().cO(0);
            this.gbW = aj.blF().bku();
            this.gbU = aj.blF().blK();
            this.gbY = aj.blF().blL();
            this.gcS = aj.blF().blJ();
            this.gcT = aj.blF().blI();
            this.gcU = aj.blF().blH();
            this.gcP = this.gbU;
            if (this.gbU || this.isFromMark) {
                this.gcv = false;
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
        if (i == 4 && !this.gcz) {
            a(bkO(), true, this.gbS, 3);
        }
        if (i == 3 && !this.gcz) {
            if (this.isFromMark) {
                a(bkO(), true, this.gbS, 3);
            } else {
                a(bkO(), false, this.gbS, 3);
            }
        }
        this.gcz = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.gcX == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aYi);
        if (this.gbU || this.isFromMark) {
            this.gcv = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.gbQ == null || this.gbQ.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.gbQ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.aq.Ee().Eg() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(aO));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(aQ));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.gbW) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.gbU) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.gci) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.gch));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.gcv) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.gcr, 0));
            pbPageRequestMessage.setOpMessageID(this.gch);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bhB = this.gck.bhB();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gcd - 1));
                        if (this.gcd - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (bhB != null && bhB.size() > 0) {
                                    size = bhB.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bhB.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.gbS = postData.getId();
                                            if (StringUtils.isNull(this.gbS)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.gcc + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.gbS == null && this.gbS.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gbS, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gcc + 1));
                        if (this.gcc >= this.der) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bhB != null) {
                                size = bhB.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.gbS == null) {
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
                if (bhB != null) {
                }
                if (this.gbS == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bhB != null && bhB.size() > 0 && bhB.get(0) != null) {
                    this.gbS = bhB.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bli()) {
                        if (this.gcd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.gcd - 1));
                        }
                    } else if (this.gcc < this.der) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.gcc + 1));
                    }
                }
                if (this.gbS != null && this.gbS.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gbS, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.gbU) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bli()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gbS, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.gcb));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.gcP && !this.gbU) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gbS, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.gbU) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.gcD);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.gcR, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.gcP = this.gbU;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bkO());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.gcQ));
        pbPageRequestMessage.setIsSubPostDataReverse(this.gcC);
        pbPageRequestMessage.setFromSmartFrs(this.gcF ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.gbT);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.gbQ);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bit() {
        switch (blc()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bhz() == null || !getPbData().bhz().Be();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(biu()) && com.baidu.tieba.recapp.r.bvT().bvN() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bvT().bvN().Z(biu(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bvT().bvN().aa(biu(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(biu()) && com.baidu.tieba.recapp.r.bvT().bvN() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bvT().bvN().aa(biu(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bvT().bvN().Z(biu(), true));
        }
    }

    protected void sH(int i) {
        boolean z = false;
        sM(i);
        ArrayList<PostData> bhB = this.gck.bhB();
        this.gcy = false;
        if (i == 1) {
            boolean z2 = false;
            while (bhB.size() + 30 > com.baidu.tbadk.data.d.LM()) {
                bhB.remove(0);
                z2 = true;
            }
            if (z2) {
                this.gck.zf().cL(1);
                if (this.gcq != null) {
                    this.gcq.f(this.gck);
                }
            }
            this.ecY = System.currentTimeMillis();
            this.gcy = true;
        } else if (i == 2) {
            while (bhB.size() + 30 > com.baidu.tbadk.data.d.LM()) {
                bhB.remove(bhB.size() - 1);
                z = true;
            }
            if (z) {
                this.gck.zf().cK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.gcG = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            j(dVar2);
            i(dVar2);
        }
        h(dVar2);
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bhP() != null && dVar.bhP().bEG() != null && dVar.bhP().bEG().goods != null && dVar.bhP().Xu() && dVar.bhP().bEG().goods.goods_style != 1001) {
            this.gcX = dVar.bhP();
        }
    }

    public com.baidu.tieba.tbadkCore.data.l bkF() {
        return this.gcX;
    }

    public void bkG() {
        this.gcX = null;
    }

    private void i(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.gbR)) {
            try {
                Long valueOf = Long.valueOf(this.gbR);
                com.baidu.tieba.pb.data.k bhK = dVar.bhK();
                if (bhK != null && bhK.fUL != null) {
                    if (bhK.fUL.isEmpty() || !bhK.fUL.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.gbQ);
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
            if (this.gco || this.gcm || this.gcn) {
                dVar = l(dVar);
            }
            k(dVar);
        }
    }

    protected void k(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String m = m(dVar);
            for (int i = 0; i < dVar.bhB().size(); i++) {
                PostData postData = dVar.bhB().get(i);
                for (int i2 = 0; i2 < postData.bEP().size(); i2++) {
                    postData.bEP().get(i2).a(this.bBW.getPageContext(), m.equals(postData.bEP().get(i2).zT().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bhK = dVar.bhK();
            if (bhK != null && !com.baidu.tbadk.core.util.v.I(bhK.fUK)) {
                for (PostData postData2 : bhK.fUK) {
                    for (int i3 = 0; i3 < postData2.bEP().size(); i3++) {
                        postData2.bEP().get(i3).a(this.bBW.getPageContext(), m.equals(postData2.bEP().get(i3).zT().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String m = m(dVar);
            com.baidu.tieba.pb.data.k bhK = dVar.bhK();
            if (bhK != null && !com.baidu.tbadk.core.util.v.I(bhK.fUK)) {
                for (PostData postData : bhK.fUK.subList(i, bhK.fUK.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bEP().size()) {
                            postData.bEP().get(i3).a(this.bBW.getPageContext(), m.equals(postData.bEP().get(i3).zT().getUserId()));
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
        bb bhz = dVar.bhz();
        bhz.cS(this.mIsGood);
        bhz.cR(this.gbZ);
        if (this.gca > 0) {
            bhz.B(this.gca);
            return dVar;
        }
        return dVar;
    }

    protected String m(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bhz() != null && dVar.bhz().zT() != null) {
            str = dVar.bhz().zT().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bkH() {
        if (this.gck == null || this.gck.bhz() == null || this.gck.bhz().zT() == null) {
            return null;
        }
        return this.gck.bhz().zT();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.gcE = z3;
        this.gcl = i;
        if (this.dsH != null && !z3) {
            this.dsH.a(z2, z4, i2, str, i3, j, j2);
            this.dsH = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(biu()) && com.baidu.tieba.recapp.r.bvT().bvN() != null) {
            com.baidu.tieba.recapp.r.bvT().bvN().f(biu(), sI(getRequestType()), true);
        }
        if (dVar == null || (this.gcb == 1 && i == 5 && dVar.bhB() != null && dVar.bhB().size() < 1)) {
            if (this.gcq != null) {
                this.gbW = this.gbV;
                this.mSortType = this.gbX;
                this.gcq.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.gbV = this.gbW;
            if (i != 8) {
                this.gbX = this.mSortType;
                this.mSortType = dVar.fUl;
            }
            if (dVar.fUk != null && dVar.fUk.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bBW.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fUk = new ArrayList();
                dVar.fUk.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bBW.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fUk.add(builder2.build(false));
                this.mSortType = this.gbX;
                dVar.fUl = this.mSortType;
            }
            this.gci = false;
            if (dVar.zf() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.zf());
            }
            this.der = this.der < 1 ? 1 : this.der;
            ArrayList<PostData> bhB = this.gck.bhB();
            switch (i) {
                case 1:
                    this.gck.a(dVar.zf(), 1);
                    d(dVar, bhB);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bhB() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bhB().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bhB, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bhB(), com.baidu.tbadk.core.util.v.H(dVar.bhB()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bhB().remove(postData2);
                            i6 = size - 1;
                        }
                        bhB.addAll(0, dVar.bhB());
                    }
                    this.gck.a(dVar.zf(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.zf() != null) {
                        dVar.zf().cI(dVar.zf().yX());
                    }
                    n(dVar);
                    if (!z3 && this.mThreadType != 33 && bli()) {
                        bkI();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.I(dVar.bhB()) && this.gck != null && (!this.gbU || m(dVar).equals(dVar.bhB().get(0).zT().getUserId()))) {
                        if (this.gck.zf().zc() == 0) {
                            this.gck.zf().cK(1);
                        }
                        bld();
                        this.gcS = dVar.bhB().get(0);
                        if (bli()) {
                            if (this.gck.bhB().size() - this.gcU >= 3) {
                                this.gcT = new PostData();
                                this.gcT.hqd = true;
                                this.gcT.setPostType(53);
                                this.gck.bhB().add(this.gcT);
                            }
                            this.gck.bhB().add(this.gcS);
                            i4 = this.gck.bhB().size() - 1;
                        } else {
                            if (this.gcU - this.gcV >= 3) {
                                this.gcT = new PostData();
                                this.gcT.hqd = false;
                                this.gcT.setPostType(53);
                                this.gck.bhB().add(0, this.gcT);
                            }
                            this.gck.bhB().add(0, this.gcS);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.ak(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.gcS.hqp = this.gck.bia();
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
            if (this.gck != null && this.gck.bhz() != null) {
                PraiseData zG = this.gck.bhz().zG();
                if (this.gdb != null && !zG.isPriaseDataValid()) {
                    this.gck.bhz().a(this.gdb);
                } else {
                    this.gdb = this.gck.bhz().zG();
                    this.gdb.setPostId(this.gck.bhz().Ak());
                }
                if (dVar.zf() != null && dVar.zf().za() == 1 && dVar.bhz() != null && dVar.bhz().Af() != null && dVar.bhz().Af().size() > 0) {
                    this.gck.bhz().l(dVar.bhz().Af());
                }
                this.gck.bhz().cP(dVar.bhz().zK());
                this.gck.bhz().cM(dVar.bhz().getAnchorLevel());
                this.gck.bhz().cO(dVar.bhz().zC());
                if (this.mThreadType == 33) {
                    this.gck.bhz().zT().setHadConcerned(dVar.bhz().zT().hadConcerned());
                }
                if (dVar != null && dVar.bhz() != null) {
                    this.gck.bhz().cU(dVar.bhz().Aj());
                }
            }
            if (this.gck != null && this.gck.getUserData() != null && dVar.getUserData() != null) {
                this.gck.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.gck.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.zf() != null && dVar.zf().za() == 1 && dVar.bhJ() != null) {
                this.gck.d(dVar.bhJ());
            }
            if (this.gcE) {
                if (this.gck.bhz() != null && this.gck.bhz().zT() != null && this.gck.bhB() != null && com.baidu.tbadk.core.util.v.d(this.gck.bhB(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.gck.bhB(), 0);
                    MetaData zT = this.gck.bhz().zT();
                    if (postData3.zT() != null && postData3.zT().getGodUserData() != null) {
                        if (this.gct != -1) {
                            zT.setFansNum(this.gct);
                            postData3.zT().setFansNum(this.gct);
                        }
                        if (this.gcu != -1) {
                            zT.getGodUserData().setIsLike(this.gcu == 1);
                            postData3.zT().getGodUserData().setIsLike(this.gcu == 1);
                            zT.getGodUserData().setIsFromNetWork(false);
                            postData3.zT().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.gck.fUj = -1;
                this.gck.fUi = -1;
            }
            if (this.gcq != null) {
                this.gcq.a(true, getErrorCode(), i, i5, this.gck, this.mErrorString, 1);
            }
        }
        if (this.gck != null && this.gck.bhz() != null && this.gck.bhx() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bBW.getPageContext();
            historyMessage.threadId = getPbData().bhz().getId();
            if (this.mIsShareThread && getPbData().bhz().avW != null) {
                historyMessage.threadName = getPbData().bhz().avW.showText;
            } else {
                historyMessage.threadName = getPbData().bhz().getTitle();
            }
            if (this.mIsShareThread && !bit()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bhx().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bku();
            historyMessage.threadType = getPbData().bhz().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ao;
        if (arrayList != null && dVar.bhB() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bhB(), 0);
            if (postData != null && (ao = ao(arrayList)) != null && ao.equals(postData.getId())) {
                dVar.bhB().remove(postData);
            }
            arrayList.addAll(dVar.bhB());
        }
    }

    private int sI(int i) {
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
    public void n(com.baidu.tieba.pb.data.d dVar) {
        dVar.tf(this.gck.bhS());
        this.gck = dVar;
        sF(dVar.zf().za());
    }

    private void bkI() {
        if (this.gck != null && this.gck.bhB() != null && this.gck.bhR() != null) {
            ArrayList<PostData> bhB = this.gck.bhB();
            com.baidu.tieba.pb.data.a bhR = this.gck.bhR();
            int bhv = bhR.bhv();
            if (bhv > 0) {
                if (bhv <= bhB.size()) {
                    bhB.add(bhv, bhR);
                } else {
                    bhB.add(bhR);
                }
            }
        }
    }

    public boolean bkJ() {
        if (this.gbQ == null || this.gbS == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sG(4);
        }
        return sG(6);
    }

    public boolean kX(boolean z) {
        if (this.gbQ == null || this.gck == null) {
            return false;
        }
        if (z || this.gck.zf().zc() != 0) {
            return sG(1);
        }
        return false;
    }

    public boolean kY(boolean z) {
        if (this.gbQ == null || this.gck == null) {
            return false;
        }
        if ((z || this.gck.zf().zd() != 0) && this.gck.bhB() != null && this.gck.bhB().size() >= 1) {
            return sG(2);
        }
        return false;
    }

    public boolean tn(String str) {
        this.gbU = !this.gbU;
        this.gbS = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sG(6)) {
            return true;
        }
        this.gbU = this.gbU ? false : true;
        return false;
    }

    public boolean p(boolean z, String str) {
        if (this.gbU == z) {
            return false;
        }
        this.gbU = z;
        this.gbS = str;
        if (this.mSortType == 2) {
            this.gbS = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sG(6)) {
            return true;
        }
        this.gbU = z ? false : true;
        return false;
    }

    public boolean sJ(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.gbV = this.gbW;
        this.gbX = this.mSortType;
        this.mSortType = i;
        this.gbW = !this.gbW;
        if (i == 2 && this.isFromMark) {
            this.gbS = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.gbW = this.gbW ? false : true;
            this.mSortType = this.gbX;
            return false;
        }
        return true;
    }

    public boolean bkK() {
        return bli();
    }

    public int bkL() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.gck == null || this.gck.bhx() == null || this.gck.bhz() == null) ? false : true;
    }

    public boolean wx() {
        if (this.gck == null) {
            return false;
        }
        return this.gck.wx();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hZ(String str) {
        if (this.gck == null || this.gck.bhz() == null || this.gck.bhx() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.gck.bhz().Be()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.gck.bhx().getId());
            writeData.setForumName(this.gck.bhx().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.gcQ);
        writeData.setThreadId(this.gbQ);
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

    public MarkData sK(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.gck == null) {
            return null;
        }
        ArrayList<PostData> bhB = this.gck.bhB();
        if (com.baidu.tbadk.core.util.v.I(bhB)) {
            return null;
        }
        if (bhB.size() > 0 && i >= bhB.size()) {
            i = bhB.size() - 1;
        }
        return j(bhB.get(i));
    }

    public MarkData bkM() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gbQ);
        markData.setPostId(this.gck.ww());
        markData.setTime(date.getTime());
        markData.setHostMode(this.gbU);
        markData.setSequence(Boolean.valueOf(bli()));
        markData.setId(this.gbQ);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gbQ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.gbU);
        markData.setSequence(Boolean.valueOf(bli()));
        markData.setId(this.gbQ);
        markData.setFloor(postData.bES());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bkN() {
        g.bkd().S(bkO(), this.isFromMark);
    }

    private String bkO() {
        String str = this.gbQ;
        if (this.gbU) {
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
        if (this.gck != null) {
            this.gck.aQ(z);
        }
    }

    public void la(boolean z) {
        this.gcv = z;
    }

    public boolean bkP() {
        return this.gcv;
    }

    public void a(a aVar) {
        this.gcq = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String MK() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean MJ() {
        return OP();
    }

    public boolean to(String str) {
        if (getPbData() == null || getPbData().bhz() == null || getPbData().bhz().zT() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bhz().zT().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bkQ() {
        String bkO = bkO();
        g.bkd().S(bkO, false);
        g.bkd().S(bkO, true);
    }

    public void bkR() {
        if ("personalize_page".equals(this.mStType)) {
            this.gcB = System.currentTimeMillis() / 1000;
        }
    }

    public void bkS() {
        if ("personalize_page".equals(this.mStType) && this.gck != null && this.gcB != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").aB(ImageViewerConfig.FORUM_ID, this.gck.getForumId()).aB("tid", this.gbQ).aB("obj_duration", String.valueOf(currentTimeMillis - this.gcB)).aB("obj_param3", String.valueOf(currentTimeMillis)));
            this.gcB = 0L;
        }
    }

    public boolean bkT() {
        return this.gcE;
    }

    public int getErrorNo() {
        return this.gcG;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bkU() {
        return this.gcI;
    }

    public m bkV() {
        return this.gcJ;
    }

    public z bkW() {
        return this.gcK;
    }

    public CheckRealNameModel bkX() {
        return this.cwQ;
    }

    public AddExperiencedModel bkY() {
        return this.gcM;
    }

    public String bkZ() {
        return this.gcA;
    }

    public void tp(String str) {
        this.gcA = str;
    }

    public boolean bla() {
        return this.gcF;
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.gck != null && this.gck.bhB() != null && this.gck.bhB().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.gck.bhB().size();
                for (int i = 0; i < size; i++) {
                    if (this.gck.bhB().get(i) != null && this.gck.bhB().get(i).zT() != null && currentAccount.equals(this.gck.bhB().get(i).zT().getUserId()) && this.gck.bhB().get(i).zT().getPendantData() != null) {
                        this.gck.bhB().get(i).zT().getPendantData().es(lVar.yF());
                        this.gck.bhB().get(i).zT().getPendantData().ap(lVar.LW());
                    }
                }
            }
        }
    }

    public String blb() {
        return this.gcL;
    }

    public int blc() {
        return this.gcQ;
    }

    public void sL(int i) {
        this.gcQ = i;
    }

    public void tq(String str) {
        if ((!this.gbU || to(TbadkCoreApplication.getCurrentAccount())) && this.gck.bhB() != null) {
            this.gck.zf().cK(1);
            if (this.gck.zf().zc() == 0) {
                this.gck.zf().cK(1);
            }
            this.gcR = str;
            sG(8);
        }
    }

    private void sM(int i) {
        if (i != 8) {
            this.gcR = "";
            if (this.gcS != null) {
                if (i == 1 && !this.gbW && !com.baidu.tbadk.core.util.v.I(getPbData().bhB())) {
                    getPbData().bhB().remove(this.gcS);
                    if (this.gcT != null) {
                        getPbData().bhB().remove(this.gcT);
                    }
                    getPbData().bhB().add(0, this.gcS);
                } else {
                    getPbData().bhB().remove(this.gcS);
                    if (this.gcT != null) {
                        getPbData().bhB().remove(this.gcT);
                    }
                }
            }
            this.gcT = null;
        }
    }

    public void bld() {
        if (this.gck != null && !com.baidu.tbadk.core.util.v.I(this.gck.bhB())) {
            if (this.gcT != null) {
                this.gck.bhB().remove(this.gcT);
                this.gcT = null;
            }
            if (this.gcS != null) {
                this.gck.bhB().remove(this.gcS);
                this.gcS = null;
            }
        }
    }

    public void by(int i, int i2) {
        this.gcU = i;
        this.gcV = i2;
    }

    public PostData ble() {
        return this.gcS;
    }

    public PostData blf() {
        return this.gcT;
    }

    public int blg() {
        return this.gcU;
    }

    public String blh() {
        return this.gcW;
    }

    public void tr(String str) {
        this.gcW = str;
    }

    private boolean bli() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
