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
    private BaseActivity bBf;
    private final CheckRealNameModel cuZ;
    private long dZA;
    private int daM;
    private com.baidu.tieba.tbadkCore.d.b dph;
    private a fYA;
    private String fYB;
    private String fYC;
    private int fYD;
    private int fYE;
    private boolean fYF;
    private boolean fYG;
    private boolean fYH;
    private boolean fYI;
    private boolean fYJ;
    private String fYK;
    private long fYL;
    private boolean fYM;
    private int fYN;
    private boolean fYO;
    private boolean fYP;
    private int fYQ;
    private final x fYR;
    private final h fYS;
    private final m fYT;
    private final z fYU;
    private String fYV;
    private final AddExperiencedModel fYW;
    private SuggestEmotionModel fYX;
    private GetSugMatchWordsModel fYY;
    private boolean fYZ;
    protected String fYa;
    private String fYb;
    private String fYc;
    private boolean fYd;
    private boolean fYe;
    private boolean fYf;
    private boolean fYg;
    private int fYh;
    private boolean fYi;
    private int fYj;
    private long fYk;
    private int fYl;
    private int fYm;
    private int fYn;
    private boolean fYo;
    private boolean fYp;
    private boolean fYq;
    private long fYr;
    private boolean fYs;
    private String fYt;
    protected com.baidu.tieba.pb.data.d fYu;
    private int fYv;
    private boolean fYw;
    private boolean fYx;
    private boolean fYy;
    private boolean fYz;
    private int fZa;
    private String fZb;
    private PostData fZc;
    private PostData fZd;
    private int fZe;
    private int fZf;
    private String fZg;
    private CustomMessageListener fZh;
    private CustomMessageListener fZi;
    private com.baidu.adp.framework.listener.a fZj;
    private PraiseData fZk;
    private boolean ffT;
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
    private static final int fXZ = com.baidu.tbadk.data.d.Lw() / 30;
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
        this.fYa = null;
        this.fYb = null;
        this.fYc = null;
        this.mForumId = null;
        this.fYd = false;
        this.fYe = false;
        this.fYf = true;
        this.fYg = true;
        this.mSortType = 0;
        this.fYh = 0;
        this.fYi = false;
        this.mIsGood = 0;
        this.fYj = 0;
        this.fYk = 0L;
        this.fYl = 1;
        this.fYm = 1;
        this.fYn = 1;
        this.daM = 1;
        this.isAd = false;
        this.ffT = false;
        this.fYo = false;
        this.fYp = false;
        this.isFromMark = false;
        this.fYq = false;
        this.fYr = 0L;
        this.fYs = false;
        this.fYt = null;
        this.fYu = null;
        this.isLoading = false;
        this.fYw = false;
        this.fYx = false;
        this.fYy = false;
        this.fYz = false;
        this.mLocate = null;
        this.mContext = null;
        this.fYA = null;
        this.opType = null;
        this.opUrl = null;
        this.fYB = null;
        this.fYC = null;
        this.fYD = -1;
        this.fYE = -1;
        this.dph = null;
        this.fYG = false;
        this.fYH = false;
        this.postID = null;
        this.fYK = null;
        this.fYL = 0L;
        this.fYM = false;
        this.fYN = -1;
        this.fYP = false;
        this.fYZ = false;
        this.fZa = 0;
        this.fZh = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fYJ = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.bgk() != null) {
                        pbData.bgk().cO(0);
                    }
                    if (PbModel.this.fYA != null && pbData != null) {
                        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fYA.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fZi = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().bgi() != null && PbModel.this.getPbData().bgi().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().bgi().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fZj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kV()) {
                        PbModel.this.bBf.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fYG || !PbModel.this.fYH) {
                        if (!PbModel.this.fYG) {
                            PbModel.this.fYG = true;
                        } else {
                            PbModel.this.fYH = true;
                        }
                        if (PbModel.this.fYA != null) {
                            PbModel.this.fYA.a(PbModel.this.bjc(), z, responsedMessage, PbModel.this.fYI, System.currentTimeMillis() - PbModel.this.dZA);
                        }
                    }
                }
            }
        };
        this.fZk = null;
        registerListener(this.fZh);
        registerListener(this.fZj);
        registerListener(this.fZi);
        this.fYu = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bBf = baseActivity;
        this.fYR = new x(this, this.bBf);
        this.fYS = new h(this, this.bBf);
        this.fYT = new m(this, this.bBf);
        this.fYU = new z(this, this.bBf);
        this.cuZ = new CheckRealNameModel(this.bBf.getPageContext());
        this.fYX = new SuggestEmotionModel();
        this.fYW = new AddExperiencedModel(this.bBf.getPageContext());
    }

    protected int bjc() {
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
            this.fYa = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.e(data)) {
                com.baidu.tbadk.BdToken.f.vF().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.akT) instanceof String)) {
                            PbModel.this.fYa = (String) hashMap.get(com.baidu.tbadk.BdToken.f.akT);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.fYa)) {
                this.fYa = this.fYR.Y(intent);
                if (StringUtils.isNull(this.fYa) && intent.getData() != null) {
                    this.fYa = data.getQueryParameter("thread_id");
                }
            }
            this.fZa = intent.getIntExtra("key_start_from", 0);
            if (this.fZa == 0) {
                this.fZa = this.fYR.fZq;
            }
            this.fYc = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.fYb = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.fYd = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.fYe = intent.getBooleanExtra("host_only", false);
            this.fYg = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.PH().Gf() ? 2 : 0);
            if (this.mSortType == 2) {
                this.fYc = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.fYj = intent.getIntExtra("is_top", 0);
            this.fYk = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.fYq = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.ffT = intent.getBooleanExtra("is_sub_pb", false);
            this.fYs = intent.getBooleanExtra("is_pv", false);
            this.fYr = intent.getLongExtra("msg_id", 0L);
            this.fYt = intent.getStringExtra("from_forum_name");
            this.fYC = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.fYB = intent.getStringExtra("op_stat");
            this.fYw = intent.getBooleanExtra("is_from_thread_config", false);
            this.fYx = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.fYy = intent.getBooleanExtra("is_from_my_god_config", false);
            this.fYE = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.fYD = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.fYo = intent.getBooleanExtra("from_frs", false);
            this.fYp = intent.getBooleanExtra("from_maintab", false);
            this.fYP = intent.getBooleanExtra("from_smart_frs", false);
            this.fYz = intent.getBooleanExtra("from_hottopic", false);
            this.fYV = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.fZa = bundle.getInt("key_start_from", 0);
        this.fYa = bundle.getString("thread_id");
        this.fYc = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.fYb = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fYd = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fYe = bundle.getBoolean("host_only", false);
        this.fYg = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fYj = bundle.getInt("is_top", 0);
        this.fYk = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fYq = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ffT = bundle.getBoolean("is_sub_pb", false);
        this.fYs = bundle.getBoolean("is_pv", false);
        this.fYr = bundle.getLong("msg_id", 0L);
        this.fYt = bundle.getString("from_forum_name");
        this.fYC = bundle.getString("extra_pb_cache_key");
        this.fYw = bundle.getBoolean("is_from_thread_config", false);
        this.fYx = bundle.getBoolean("is_from_interview_live_config", false);
        this.fYy = bundle.getBoolean("is_from_my_god_config", false);
        this.fYE = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fYD = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fYo = bundle.getBoolean("from_frs", false);
        this.fYp = bundle.getBoolean("from_maintab", false);
        this.fYP = bundle.getBoolean("from_smart_frs", false);
        this.fYz = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void G(Bundle bundle) {
        bundle.putString("thread_id", this.fYa);
        bundle.putString("post_id", this.fYc);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.fZa);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fYd);
        bundle.putBoolean("host_only", this.fYe);
        bundle.putBoolean("squence", this.fYg);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fYj);
        bundle.putLong("thread_time", this.fYk);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fYq);
        bundle.putBoolean("is_sub_pb", this.ffT);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fYs);
        bundle.putLong("msg_id", this.fYr);
        bundle.putString("extra_pb_cache_key", this.fYC);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fYw);
        bundle.putBoolean("is_from_interview_live_config", this.fYx);
        bundle.putBoolean("is_from_my_god_config", this.fYy);
        bundle.putInt("extra_pb_is_attention_key", this.fYE);
        bundle.putInt("extra_pb_funs_count_key", this.fYD);
        bundle.putBoolean("from_frs", this.fYo);
        bundle.putBoolean("from_maintab", this.fYp);
        bundle.putBoolean("from_smart_frs", this.fYP);
        bundle.putBoolean("from_hottopic", this.fYz);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String bjd() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fYa);
        if (!this.fYq) {
            sb.append(this.fYc);
        }
        sb.append(this.fYe);
        sb.append(this.fYg);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fYj);
        sb.append(this.fYk);
        sb.append(this.fYo);
        sb.append(this.fYp);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ffT);
        sb.append(this.fYs);
        sb.append(this.fYr);
        sb.append(this.fYt);
        sb.append(this.mThreadType);
        sb.append(this.fYw);
        sb.append(this.fYx);
        sb.append(this.fYy);
        if (this.fYC != null) {
            sb.append(this.fYC);
        }
        return sb.toString();
    }

    public String bhf() {
        return this.fYt;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.fYc;
    }

    public String bje() {
        return this.fYa;
    }

    public boolean getHostMode() {
        return this.fYe;
    }

    public boolean bjf() {
        return bjP();
    }

    public int abZ() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bjg() {
        return this.fYo;
    }

    public boolean bjh() {
        return this.fYi;
    }

    public boolean bji() {
        return this.fYp;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bjj() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bjk() {
        return this.fYj;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void kO(int i) {
        this.fYj = i;
    }

    public boolean bjl() {
        return this.ffT;
    }

    public boolean bjm() {
        if (this.fYu == null) {
            return false;
        }
        return this.fYu.isValid();
    }

    public String zQ() {
        if (this.fYu == null || !this.fYu.wq()) {
            return null;
        }
        return this.fYu.wp();
    }

    public boolean sn(int i) {
        this.fYl = i;
        if (this.fYl > this.fYu.yS().yK()) {
            this.fYl = this.fYu.yS().yK();
        }
        if (this.fYl < 1) {
            this.fYl = 1;
        }
        if (this.fYa == null) {
            return false;
        }
        return sp(5);
    }

    public void so(int i) {
        this.fYl = i;
        this.fYm = i;
        this.fYn = i;
    }

    public void c(com.baidu.tbadk.core.data.al alVar) {
        if (alVar == null) {
            so(1);
            return;
        }
        if (this.fYm < alVar.yN()) {
            this.fYm = alVar.yN();
        }
        if (this.fYn > alVar.yN()) {
            this.fYn = alVar.yN();
        }
        this.daM = alVar.yK();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fYu;
    }

    public com.baidu.tbadk.core.data.al getPageData() {
        if (this.fYu == null) {
            return null;
        }
        return this.fYu.yS();
    }

    public boolean bjn() {
        if (bjP() && this.fYu.yS().yP() == 0) {
            kU(true);
            return true;
        }
        return false;
    }

    public void sP(String str) {
        if (!StringUtils.isNull(str)) {
            this.fYa = str;
            this.fYc = null;
            this.fYe = false;
            this.fYg = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fYa == null) {
            return false;
        }
        cancelLoadData();
        if (this.dph == null) {
            this.dph = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.dph.start();
        }
        boolean sp = sp(3);
        if (this.opType != null) {
            this.opType = null;
            this.fYB = null;
            this.opUrl = null;
            return sp;
        }
        return sp;
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
        if (this.fYX != null) {
            this.fYX.cancelLoadData();
        }
        if (this.fYY != null) {
            this.fYY.cancelLoadData();
        }
        avC();
    }

    private void avC() {
        if (this.dph != null) {
            this.dph.destory();
            this.dph = null;
        }
    }

    public boolean Ow() {
        return (this.fYc == null || this.fYc.equals("0") || this.fYc.length() == 0) ? LoadData() : bjq();
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
                this.fYX.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fYX.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fYY == null) {
                this.fYY = new GetSugMatchWordsModel(this.bBf.getPageContext());
            }
            this.fYY.b(aVar);
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
    public boolean sp(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        sq(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bkm().getPbData();
        if (pbData != null && pbData.bgk() != null) {
            pbData.bgk().cO(0);
            this.fYg = aj.bkm().bjf();
            this.fYe = aj.bkm().bkr();
            this.fYi = aj.bkm().bks();
            this.fZc = aj.bkm().bkq();
            this.fZd = aj.bkm().bkp();
            this.fZe = aj.bkm().bko();
            this.fYZ = this.fYe;
            if (this.fYe || this.isFromMark) {
                this.fYF = false;
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
        if (i == 4 && !this.fYJ) {
            a(bjv(), true, this.fYc, 3);
        }
        if (i == 3 && !this.fYJ) {
            if (this.isFromMark) {
                a(bjv(), true, this.fYc, 3);
            } else {
                a(bjv(), false, this.fYc, 3);
            }
        }
        this.fYJ = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aXu);
        if (this.fYe || this.isFromMark) {
            this.fYF = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fYa == null || this.fYa.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.fYa, 0L));
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
        if (!this.fYg) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.fYe) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fYs) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fYr));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fYF) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.l(this.fYB, 0));
            pbPageRequestMessage.setOpMessageID(this.fYr);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bgm = this.fYu.bgm();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fYn - 1));
                        if (this.fYn - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (bgm != null && bgm.size() > 0) {
                                    size = bgm.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bgm.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fYc = postData.getId();
                                            if (StringUtils.isNull(this.fYc)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.fYm + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.fYc == null && this.fYc.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fYc, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fYm + 1));
                        if (this.fYm >= this.daM) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bgm != null) {
                                size = bgm.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.fYc == null) {
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
                if (bgm != null) {
                }
                if (this.fYc == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bgm != null && bgm.size() > 0 && bgm.get(0) != null) {
                    this.fYc = bgm.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bjP()) {
                        if (this.fYn - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fYn - 1));
                        }
                    } else if (this.fYm < this.daM) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fYm + 1));
                    }
                }
                if (this.fYc != null && this.fYc.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fYc, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fYe) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bjP()) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fYc, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fYl));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.fYZ && !this.fYe) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fYc, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.fYe) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fYN);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.fZb, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fYZ = this.fYe;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bjv());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fZa));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fYM);
        pbPageRequestMessage.setFromSmartFrs(this.fYP ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fYd);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bhe() {
        switch (bjJ()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bgk() == null || !getPbData().bgk().AR();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bhf()) && com.baidu.tieba.recapp.r.buz().but() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.buz().but().aa(bhf(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.buz().but().ab(bhf(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bhf()) && com.baidu.tieba.recapp.r.buz().but() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.buz().but().ab(bhf(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.buz().but().aa(bhf(), true));
        }
    }

    protected void sq(int i) {
        boolean z = false;
        sv(i);
        ArrayList<PostData> bgm = this.fYu.bgm();
        this.fYI = false;
        if (i == 1) {
            boolean z2 = false;
            while (bgm.size() + 30 > com.baidu.tbadk.data.d.Lw()) {
                bgm.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fYu.yS().cL(1);
                if (this.fYA != null) {
                    this.fYA.f(this.fYu);
                }
            }
            this.dZA = System.currentTimeMillis();
            this.fYI = true;
        } else if (i == 2) {
            while (bgm.size() + 30 > com.baidu.tbadk.data.d.Lw()) {
                bgm.remove(bgm.size() - 1);
                z = true;
            }
            if (z) {
                this.fYu.yS().cK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fYQ = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fYb)) {
            try {
                Long valueOf = Long.valueOf(this.fYb);
                com.baidu.tieba.pb.data.k bgv = dVar.bgv();
                if (bgv != null && bgv.fQV != null) {
                    if (bgv.fQV.isEmpty() || !bgv.fQV.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fYa);
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
            if (this.fYy || this.fYw || this.fYx) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.bgm().size(); i++) {
                PostData postData = dVar.bgm().get(i);
                for (int i2 = 0; i2 < postData.bDp().size(); i2++) {
                    postData.bDp().get(i2).a(this.bBf.getPageContext(), l.equals(postData.bDp().get(i2).zG().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.k bgv = dVar.bgv();
            if (bgv != null && !com.baidu.tbadk.core.util.v.I(bgv.fQU)) {
                for (PostData postData2 : bgv.fQU) {
                    for (int i3 = 0; i3 < postData2.bDp().size(); i3++) {
                        postData2.bDp().get(i3).a(this.bBf.getPageContext(), l.equals(postData2.bDp().get(i3).zG().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.k bgv = dVar.bgv();
            if (bgv != null && !com.baidu.tbadk.core.util.v.I(bgv.fQU)) {
                for (PostData postData : bgv.fQU.subList(i, bgv.fQU.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bDp().size()) {
                            postData.bDp().get(i3).a(this.bBf.getPageContext(), l.equals(postData.bDp().get(i3).zG().getUserId()));
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
        bb bgk = dVar.bgk();
        bgk.cS(this.mIsGood);
        bgk.cR(this.fYj);
        if (this.fYk > 0) {
            bgk.B(this.fYk);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bgk() != null && dVar.bgk().zG() != null) {
            str = dVar.bgk().zG().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bjo() {
        if (this.fYu == null || this.fYu.bgk() == null || this.fYu.bgk().zG() == null) {
            return null;
        }
        return this.fYu.bgk().zG();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fYO = z3;
        this.fYv = i;
        if (this.dph != null && !z3) {
            this.dph.a(z2, z4, i2, str, i3, j, j2);
            this.dph = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bhf()) && com.baidu.tieba.recapp.r.buz().but() != null) {
            com.baidu.tieba.recapp.r.buz().but().f(bhf(), sr(getRequestType()), true);
        }
        if (dVar == null || (this.fYl == 1 && i == 5 && dVar.bgm() != null && dVar.bgm().size() < 1)) {
            if (this.fYA != null) {
                this.fYg = this.fYf;
                this.mSortType = this.fYh;
                this.fYA.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fYf = this.fYg;
            if (i != 8) {
                this.fYh = this.mSortType;
                this.mSortType = dVar.fQv;
            }
            if (dVar.fQu != null && dVar.fQu.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.bBf.getResources().getString(e.j.default_sort);
                builder.sort_type = 0;
                dVar.fQu = new ArrayList();
                dVar.fQu.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.bBf.getResources().getString(e.j.view_reverse);
                builder2.sort_type = 1;
                dVar.fQu.add(builder2.build(false));
                this.mSortType = this.fYh;
                dVar.fQv = this.mSortType;
            }
            this.fYs = false;
            if (dVar.yS() != null && (this.mSortType != 2 || i != 8)) {
                c(dVar.yS());
            }
            this.daM = this.daM < 1 ? 1 : this.daM;
            ArrayList<PostData> bgm = this.fYu.bgm();
            switch (i) {
                case 1:
                    this.fYu.a(dVar.yS(), 1);
                    d(dVar, bgm);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bgm() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bgm().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(bgm, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bgm(), com.baidu.tbadk.core.util.v.H(dVar.bgm()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bgm().remove(postData2);
                            i6 = size - 1;
                        }
                        bgm.addAll(0, dVar.bgm());
                    }
                    this.fYu.a(dVar.yS(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.yS() != null) {
                        dVar.yS().cI(dVar.yS().yK());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && bjP()) {
                        bjp();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.I(dVar.bgm()) && this.fYu != null && (!this.fYe || l(dVar).equals(dVar.bgm().get(0).zG().getUserId()))) {
                        if (this.fYu.yS().yP() == 0) {
                            this.fYu.yS().cK(1);
                        }
                        bjK();
                        this.fZc = dVar.bgm().get(0);
                        if (bjP()) {
                            if (this.fYu.bgm().size() - this.fZe >= 3) {
                                this.fZd = new PostData();
                                this.fZd.hlM = true;
                                this.fZd.setPostType(53);
                                this.fYu.bgm().add(this.fZd);
                            }
                            this.fYu.bgm().add(this.fZc);
                            i4 = this.fYu.bgm().size() - 1;
                        } else {
                            if (this.fZe - this.fZf >= 3) {
                                this.fZd = new PostData();
                                this.fZd.hlM = false;
                                this.fZd.setPostType(53);
                                this.fYu.bgm().add(0, this.fZd);
                            }
                            this.fYu.bgm().add(0, this.fZc);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ao.aj(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fZc.hlY = this.fYu.bgL();
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
            if (this.fYu != null && this.fYu.bgk() != null) {
                PraiseData zt = this.fYu.bgk().zt();
                if (this.fZk != null && !zt.isPriaseDataValid()) {
                    this.fYu.bgk().a(this.fZk);
                } else {
                    this.fZk = this.fYu.bgk().zt();
                    this.fZk.setPostId(this.fYu.bgk().zX());
                }
                if (dVar.yS() != null && dVar.yS().yN() == 1 && dVar.bgk() != null && dVar.bgk().zS() != null && dVar.bgk().zS().size() > 0) {
                    this.fYu.bgk().l(dVar.bgk().zS());
                }
                this.fYu.bgk().cP(dVar.bgk().zx());
                this.fYu.bgk().cM(dVar.bgk().getAnchorLevel());
                this.fYu.bgk().cO(dVar.bgk().zp());
                if (this.mThreadType == 33) {
                    this.fYu.bgk().zG().setHadConcerned(dVar.bgk().zG().hadConcerned());
                }
                if (dVar != null && dVar.bgk() != null) {
                    this.fYu.bgk().cU(dVar.bgk().zW());
                }
            }
            if (this.fYu != null && this.fYu.getUserData() != null && dVar.getUserData() != null) {
                this.fYu.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fYu.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.yS() != null && dVar.yS().yN() == 1 && dVar.bgu() != null) {
                this.fYu.d(dVar.bgu());
            }
            if (this.fYO) {
                if (this.fYu.bgk() != null && this.fYu.bgk().zG() != null && this.fYu.bgm() != null && com.baidu.tbadk.core.util.v.d(this.fYu.bgm(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.d(this.fYu.bgm(), 0);
                    MetaData zG = this.fYu.bgk().zG();
                    if (postData3.zG() != null && postData3.zG().getGodUserData() != null) {
                        if (this.fYD != -1) {
                            zG.setFansNum(this.fYD);
                            postData3.zG().setFansNum(this.fYD);
                        }
                        if (this.fYE != -1) {
                            zG.getGodUserData().setIsLike(this.fYE == 1);
                            postData3.zG().getGodUserData().setIsLike(this.fYE == 1);
                            zG.getGodUserData().setIsFromNetWork(false);
                            postData3.zG().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fYu.fQt = -1;
                this.fYu.fQs = -1;
            }
            if (this.fYA != null) {
                this.fYA.a(true, getErrorCode(), i, i5, this.fYu, this.mErrorString, 1);
            }
        }
        if (this.fYu != null && this.fYu.bgk() != null && this.fYu.bgi() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bBf.getPageContext();
            historyMessage.threadId = getPbData().bgk().getId();
            if (this.mIsShareThread && getPbData().bgk().avt != null) {
                historyMessage.threadName = getPbData().bgk().avt.showText;
            } else {
                historyMessage.threadName = getPbData().bgk().getTitle();
            }
            if (this.mIsShareThread && !bhe()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().bgi().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bjf();
            historyMessage.threadType = getPbData().bgk().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String ao;
        if (arrayList != null && dVar.bgm() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.d(dVar.bgm(), 0);
            if (postData != null && (ao = ao(arrayList)) != null && ao.equals(postData.getId())) {
                dVar.bgm().remove(postData);
            }
            arrayList.addAll(dVar.bgm());
        }
    }

    private int sr(int i) {
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
        dVar.sM(this.fYu.bgD());
        this.fYu = dVar;
        so(dVar.yS().yN());
    }

    private void bjp() {
        if (this.fYu != null && this.fYu.bgm() != null && this.fYu.bgC() != null) {
            ArrayList<PostData> bgm = this.fYu.bgm();
            com.baidu.tieba.pb.data.a bgC = this.fYu.bgC();
            int bgg = bgC.bgg();
            if (bgg > 0) {
                if (bgg <= bgm.size()) {
                    bgm.add(bgg, bgC);
                } else {
                    bgm.add(bgC);
                }
            }
        }
    }

    public boolean bjq() {
        if (this.fYa == null || this.fYc == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return sp(4);
        }
        return sp(6);
    }

    public boolean kU(boolean z) {
        if (this.fYa == null || this.fYu == null) {
            return false;
        }
        if (z || this.fYu.yS().yP() != 0) {
            return sp(1);
        }
        return false;
    }

    public boolean kV(boolean z) {
        if (this.fYa == null || this.fYu == null) {
            return false;
        }
        if ((z || this.fYu.yS().yQ() != 0) && this.fYu.bgm() != null && this.fYu.bgm().size() >= 1) {
            return sp(2);
        }
        return false;
    }

    public boolean sU(String str) {
        this.fYe = !this.fYe;
        this.fYc = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (sp(6)) {
            return true;
        }
        this.fYe = this.fYe ? false : true;
        return false;
    }

    public boolean p(boolean z, String str) {
        if (this.fYe == z) {
            return false;
        }
        this.fYe = z;
        this.fYc = str;
        if (this.mSortType == 2) {
            this.fYc = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (sp(6)) {
            return true;
        }
        this.fYe = z ? false : true;
        return false;
    }

    public boolean ss(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.fYf = this.fYg;
        this.fYh = this.mSortType;
        this.mSortType = i;
        this.fYg = !this.fYg;
        if (i == 2 && this.isFromMark) {
            this.fYc = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.fYg = this.fYg ? false : true;
            this.mSortType = this.fYh;
            return false;
        }
        return true;
    }

    public boolean bjr() {
        return bjP();
    }

    public int bjs() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.fYu == null || this.fYu.bgi() == null || this.fYu.bgk() == null) ? false : true;
    }

    public boolean wq() {
        if (this.fYu == null) {
            return false;
        }
        return this.fYu.wq();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hK(String str) {
        if (this.fYu == null || this.fYu.bgk() == null || this.fYu.bgi() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fYu.bgk().AR()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fYu.bgi().getId());
            writeData.setForumName(this.fYu.bgi().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.fZa);
        writeData.setThreadId(this.fYa);
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

    public MarkData st(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fYu == null) {
            return null;
        }
        ArrayList<PostData> bgm = this.fYu.bgm();
        if (com.baidu.tbadk.core.util.v.I(bgm)) {
            return null;
        }
        if (bgm.size() > 0 && i >= bgm.size()) {
            i = bgm.size() - 1;
        }
        return h(bgm.get(i));
    }

    public MarkData bjt() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fYa);
        markData.setPostId(this.fYu.wp());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fYe);
        markData.setSequence(Boolean.valueOf(bjP()));
        markData.setId(this.fYa);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fYa);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fYe);
        markData.setSequence(Boolean.valueOf(bjP()));
        markData.setId(this.fYa);
        markData.setFloor(postData.bDs());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void bju() {
        g.biO().T(bjv(), this.isFromMark);
    }

    private String bjv() {
        String str = this.fYa;
        if (this.fYe) {
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

    public void kW(boolean z) {
        if (this.fYu != null) {
            this.fYu.aP(z);
        }
    }

    public void kX(boolean z) {
        this.fYF = z;
    }

    public boolean bjw() {
        return this.fYF;
    }

    public void a(a aVar) {
        this.fYA = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ms() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Mr() {
        return Ow();
    }

    public boolean sV(String str) {
        if (getPbData() == null || getPbData().bgk() == null || getPbData().bgk().zG() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bgk().zG().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bjx() {
        String bjv = bjv();
        g.biO().T(bjv, false);
        g.biO().T(bjv, true);
    }

    public void bjy() {
        if ("personalize_page".equals(this.mStType)) {
            this.fYL = System.currentTimeMillis() / 1000;
        }
    }

    public void bjz() {
        if ("personalize_page".equals(this.mStType) && this.fYu != null && this.fYL != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").aA(ImageViewerConfig.FORUM_ID, this.fYu.getForumId()).aA("tid", this.fYa).aA("obj_duration", String.valueOf(currentTimeMillis - this.fYL)).aA("obj_param3", String.valueOf(currentTimeMillis)));
            this.fYL = 0L;
        }
    }

    public boolean bjA() {
        return this.fYO;
    }

    public int getErrorNo() {
        return this.fYQ;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bjB() {
        return this.fYS;
    }

    public m bjC() {
        return this.fYT;
    }

    public z bjD() {
        return this.fYU;
    }

    public CheckRealNameModel bjE() {
        return this.cuZ;
    }

    public AddExperiencedModel bjF() {
        return this.fYW;
    }

    public String bjG() {
        return this.fYK;
    }

    public void sW(String str) {
        this.fYK = str;
    }

    public boolean bjH() {
        return this.fYP;
    }

    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null && this.fYu != null && this.fYu.bgm() != null && this.fYu.bgm().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fYu.bgm().size();
                for (int i = 0; i < size; i++) {
                    if (this.fYu.bgm().get(i) != null && this.fYu.bgm().get(i).zG() != null && currentAccount.equals(this.fYu.bgm().get(i).zG().getUserId()) && this.fYu.bgm().get(i).zG().getPendantData() != null) {
                        this.fYu.bgm().get(i).zG().getPendantData().ej(jVar.ys());
                        this.fYu.bgm().get(i).zG().getPendantData().ao(jVar.LE());
                    }
                }
            }
        }
    }

    public String bjI() {
        return this.fYV;
    }

    public int bjJ() {
        return this.fZa;
    }

    public void su(int i) {
        this.fZa = i;
    }

    public void sX(String str) {
        if ((!this.fYe || sV(TbadkCoreApplication.getCurrentAccount())) && this.fYu.bgm() != null) {
            this.fYu.yS().cK(1);
            if (this.fYu.yS().yP() == 0) {
                this.fYu.yS().cK(1);
            }
            this.fZb = str;
            sp(8);
        }
    }

    private void sv(int i) {
        if (i != 8) {
            this.fZb = "";
            if (this.fZc != null) {
                if (i == 1 && !this.fYg && !com.baidu.tbadk.core.util.v.I(getPbData().bgm())) {
                    getPbData().bgm().remove(this.fZc);
                    if (this.fZd != null) {
                        getPbData().bgm().remove(this.fZd);
                    }
                    getPbData().bgm().add(0, this.fZc);
                } else {
                    getPbData().bgm().remove(this.fZc);
                    if (this.fZd != null) {
                        getPbData().bgm().remove(this.fZd);
                    }
                }
            }
            this.fZd = null;
        }
    }

    public void bjK() {
        if (this.fYu != null && !com.baidu.tbadk.core.util.v.I(this.fYu.bgm())) {
            if (this.fZd != null) {
                this.fYu.bgm().remove(this.fZd);
                this.fZd = null;
            }
            if (this.fZc != null) {
                this.fYu.bgm().remove(this.fZc);
                this.fZc = null;
            }
        }
    }

    public void bx(int i, int i2) {
        this.fZe = i;
        this.fZf = i2;
    }

    public PostData bjL() {
        return this.fZc;
    }

    public PostData bjM() {
        return this.fZd;
    }

    public int bjN() {
        return this.fZe;
    }

    public String bjO() {
        return this.fZg;
    }

    public void sY(String str) {
        this.fZg = str;
    }

    private boolean bjP() {
        return this.mSortType == 0 || this.mSortType == 2;
    }
}
