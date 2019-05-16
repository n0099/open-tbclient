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
import com.baidu.tieba.R;
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
    private BaseActivity cVo;
    private final CheckRealNameModel dVx;
    private int eDJ;
    private com.baidu.tieba.tbadkCore.d.b eTs;
    private long fGJ;
    private boolean gQz;
    private boolean hJA;
    private boolean hJB;
    private boolean hJC;
    private boolean hJD;
    private long hJE;
    private boolean hJF;
    private String hJG;
    protected com.baidu.tieba.pb.data.d hJH;
    private int hJI;
    private boolean hJJ;
    private boolean hJK;
    private boolean hJL;
    private boolean hJM;
    private a hJN;
    private String hJO;
    private String hJP;
    private int hJQ;
    private int hJR;
    private boolean hJS;
    private boolean hJT;
    private boolean hJU;
    private boolean hJV;
    private boolean hJW;
    private String hJX;
    private long hJY;
    private boolean hJZ;
    protected String hJl;
    private String hJm;
    private String hJn;
    private String hJo;
    private boolean hJp;
    private boolean hJq;
    private boolean hJr;
    private boolean hJs;
    private int hJt;
    private boolean hJu;
    private int hJv;
    private long hJw;
    private int hJx;
    private int hJy;
    private int hJz;
    private int hKa;
    private boolean hKb;
    private boolean hKc;
    private int hKd;
    private final x hKe;
    private final h hKf;
    private final m hKg;
    private final z hKh;
    private String hKi;
    private final AddExperiencedModel hKj;
    private SuggestEmotionModel hKk;
    private GetSugMatchWordsModel hKl;
    private boolean hKm;
    private int hKn;
    private String hKo;
    private PostData hKp;
    private PostData hKq;
    private int hKr;
    private int hKs;
    private String hKt;
    private com.baidu.tieba.tbadkCore.data.m hKu;
    private CustomMessageListener hKv;
    private CustomMessageListener hKw;
    private com.baidu.adp.framework.listener.a hKx;
    private PraiseData hKy;
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
    private static final int hJk = com.baidu.tbadk.data.d.aqn() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void e(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.hJl = null;
        this.hJm = null;
        this.hJn = null;
        this.mForumId = null;
        this.hJo = null;
        this.hJp = false;
        this.hJq = false;
        this.hJr = true;
        this.hJs = true;
        this.mSortType = 0;
        this.hJt = 0;
        this.hJu = false;
        this.mIsGood = 0;
        this.hJv = 0;
        this.hJw = 0L;
        this.hJx = 1;
        this.hJy = 1;
        this.hJz = 1;
        this.eDJ = 1;
        this.isAd = false;
        this.gQz = false;
        this.hJA = false;
        this.hJB = false;
        this.isFromMark = false;
        this.hJC = false;
        this.hJD = false;
        this.hJE = 0L;
        this.hJF = false;
        this.hJG = null;
        this.hJH = null;
        this.isLoading = false;
        this.hJJ = false;
        this.hJK = false;
        this.hJL = false;
        this.hJM = false;
        this.mLocate = null;
        this.mContext = null;
        this.hJN = null;
        this.opType = null;
        this.opUrl = null;
        this.hJO = null;
        this.hJP = null;
        this.hJQ = -1;
        this.hJR = -1;
        this.eTs = null;
        this.hJT = false;
        this.hJU = false;
        this.postID = null;
        this.hJX = null;
        this.hJY = 0L;
        this.hJZ = false;
        this.hKa = -1;
        this.hKc = false;
        this.hKm = false;
        this.hKn = 0;
        this.hKv = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hJW = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hBD == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bPI() != null) {
                        pbData.bPI().hb(0);
                    }
                    if (PbModel.this.hJN != null && pbData != null) {
                        com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hJN.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hKw = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hKx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jS()) {
                        PbModel.this.cVo.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hJT || !PbModel.this.hJU) {
                        if (!PbModel.this.hJT) {
                            PbModel.this.hJT = true;
                        } else {
                            PbModel.this.hJU = true;
                        }
                        if (PbModel.this.hJN != null) {
                            PbModel.this.hJN.a(PbModel.this.bSC(), z, responsedMessage, PbModel.this.hJV, System.currentTimeMillis() - PbModel.this.fGJ);
                        }
                    }
                }
            }
        };
        this.hKy = null;
        registerListener(this.hKv);
        registerListener(this.hKx);
        registerListener(this.hKw);
        this.hJH = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cVo = baseActivity;
        this.hKe = new x(this, this.cVo);
        this.hKf = new h(this, this.cVo);
        this.hKg = new m(this, this.cVo);
        this.hKh = new z(this, this.cVo);
        this.dVx = new CheckRealNameModel(this.cVo.getPageContext());
        this.hKk = new SuggestEmotionModel();
        this.hKj = new AddExperiencedModel(this.cVo.getPageContext());
    }

    protected int bSC() {
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
            this.hJl = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.YA().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.byt) instanceof String)) {
                            PbModel.this.hJl = (String) hashMap.get(com.baidu.tbadk.BdToken.f.byt);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hJl)) {
                this.hJl = this.hKe.as(intent);
                if (StringUtils.isNull(this.hJl) && intent.getData() != null) {
                    this.hJl = data.getQueryParameter("thread_id");
                }
            }
            this.hKn = intent.getIntExtra("key_start_from", 0);
            if (this.hKn == 0) {
                this.hKn = this.hKe.hKE;
            }
            this.hJn = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hJm = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hJp = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hJq = intent.getBooleanExtra("host_only", false);
            this.hJs = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.auN().akJ() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hJn = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hJv = intent.getIntExtra("is_top", 0);
            this.hJw = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hJC = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hJD = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gQz = intent.getBooleanExtra("is_sub_pb", false);
            this.hJF = intent.getBooleanExtra("is_pv", false);
            this.hJE = intent.getLongExtra("msg_id", 0L);
            this.hJG = intent.getStringExtra("from_forum_name");
            this.hJP = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hJO = intent.getStringExtra("op_stat");
            this.hJJ = intent.getBooleanExtra("is_from_thread_config", false);
            this.hJK = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hJL = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hJR = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hJQ = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hJA = intent.getBooleanExtra("from_frs", false);
            this.hJB = intent.getBooleanExtra("from_maintab", false);
            this.hKc = intent.getBooleanExtra("from_smart_frs", false);
            this.hJM = intent.getBooleanExtra("from_hottopic", false);
            this.hKi = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hJo = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hKn = bundle.getInt("key_start_from", 0);
        this.hJl = bundle.getString("thread_id");
        this.hJn = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hJm = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hJp = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hJq = bundle.getBoolean("host_only", false);
        this.hJs = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hJv = bundle.getInt("is_top", 0);
        this.hJw = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hJD = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gQz = bundle.getBoolean("is_sub_pb", false);
        this.hJF = bundle.getBoolean("is_pv", false);
        this.hJE = bundle.getLong("msg_id", 0L);
        this.hJG = bundle.getString("from_forum_name");
        this.hJP = bundle.getString("extra_pb_cache_key");
        this.hJJ = bundle.getBoolean("is_from_thread_config", false);
        this.hJK = bundle.getBoolean("is_from_interview_live_config", false);
        this.hJL = bundle.getBoolean("is_from_my_god_config", false);
        this.hJR = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hJQ = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hJA = bundle.getBoolean("from_frs", false);
        this.hJB = bundle.getBoolean("from_maintab", false);
        this.hKc = bundle.getBoolean("from_smart_frs", false);
        this.hJM = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hJo = bundle.getString("high_light_post_id");
    }

    public void ab(Bundle bundle) {
        bundle.putString("thread_id", this.hJl);
        bundle.putString("post_id", this.hJn);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hKn);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hJp);
        bundle.putBoolean("host_only", this.hJq);
        bundle.putBoolean("squence", this.hJs);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hJv);
        bundle.putLong("thread_time", this.hJw);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hJD);
        bundle.putBoolean("is_sub_pb", this.gQz);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hJF);
        bundle.putLong("msg_id", this.hJE);
        bundle.putString("extra_pb_cache_key", this.hJP);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hJJ);
        bundle.putBoolean("is_from_interview_live_config", this.hJK);
        bundle.putBoolean("is_from_my_god_config", this.hJL);
        bundle.putInt("extra_pb_is_attention_key", this.hJR);
        bundle.putInt("extra_pb_funs_count_key", this.hJQ);
        bundle.putBoolean("from_frs", this.hJA);
        bundle.putBoolean("from_maintab", this.hJB);
        bundle.putBoolean("from_smart_frs", this.hKc);
        bundle.putBoolean("from_hottopic", this.hJM);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hJo);
    }

    public String bSD() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hJl);
        if (!this.hJD) {
            sb.append(this.hJn);
        }
        sb.append(this.hJq);
        sb.append(this.hJs);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hJv);
        sb.append(this.hJw);
        sb.append(this.hJA);
        sb.append(this.hJB);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gQz);
        sb.append(this.hJF);
        sb.append(this.hJE);
        sb.append(this.hJG);
        sb.append(this.mThreadType);
        sb.append(this.hJJ);
        sb.append(this.hJK);
        sb.append(this.hJL);
        if (this.hJP != null) {
            sb.append(this.hJP);
        }
        return sb.toString();
    }

    public String bQF() {
        return this.hJG;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hJn;
    }

    public String bSE() {
        return this.hJo;
    }

    public String bSF() {
        return this.hJl;
    }

    public boolean getHostMode() {
        return this.hJq;
    }

    public boolean bSG() {
        return bTt();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bSH() {
        return this.hJA;
    }

    public boolean bSI() {
        return this.hJu;
    }

    public boolean bSJ() {
        return this.hJB;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bSK() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdk() {
        return this.hJv;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pE(int i) {
        this.hJv = i;
    }

    public boolean bSL() {
        return this.gQz;
    }

    public boolean bSM() {
        if (this.hJH == null) {
            return false;
        }
        return this.hJH.isValid();
    }

    public String adE() {
        if (this.hJH == null || !this.hJH.ZC()) {
            return null;
        }
        return this.hJH.ZB();
    }

    public boolean xp(int i) {
        this.hJx = i;
        if (this.hJx > this.hJH.getPage().ack()) {
            this.hJx = this.hJH.getPage().ack();
        }
        if (this.hJx < 1) {
            this.hJx = 1;
        }
        if (this.hJl == null) {
            return false;
        }
        return xr(5);
    }

    public void xq(int i) {
        this.hJx = i;
        this.hJy = i;
        this.hJz = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            xq(1);
            return;
        }
        if (this.hJy < anVar.acn()) {
            this.hJy = anVar.acn();
        }
        if (this.hJz > anVar.acn()) {
            this.hJz = anVar.acn();
        }
        this.eDJ = anVar.ack();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hJH;
    }

    public com.baidu.tieba.pb.data.d bSN() {
        if (this.hJH == null) {
            return this.hJH;
        }
        if (!bSO() && this.hKu != null) {
            this.hJH.b(this.hKu);
        }
        return this.hJH;
    }

    private boolean bSO() {
        return (this.hJH.bPX() == null || this.hJH.bPX().cmi() == null || this.hJH.bPX().cmi().goods != null || this.hJH.bPX().cmi().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hJH == null) {
            return null;
        }
        return this.hJH.getPage();
    }

    public boolean bSP() {
        if (bTt() && this.hJH.getPage().acp() == 0) {
            on(true);
            return true;
        }
        return false;
    }

    public void AZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hJl = str;
            this.hJn = null;
            this.hJq = false;
            this.hJs = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hJl == null) {
            return false;
        }
        cancelLoadData();
        if (this.eTs == null) {
            this.eTs = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eTs.start();
        }
        boolean xr = xr(3);
        if (this.opType != null) {
            this.opType = null;
            this.hJO = null;
            this.opUrl = null;
            return xr;
        }
        return xr;
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
        if (this.hKk != null) {
            this.hKk.cancelLoadData();
        }
        if (this.hKl != null) {
            this.hKl.cancelLoadData();
        }
        bek();
    }

    private void bek() {
        if (this.eTs != null) {
            this.eTs.destory();
            this.eTs = null;
        }
    }

    public boolean atv() {
        return (this.hJn == null || this.hJn.equals("0") || this.hJn.length() == 0) ? LoadData() : bSU();
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
                this.hKk.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hKk.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hKl == null) {
                this.hKl = new GetSugMatchWordsModel(this.cVo.getPageContext());
            }
            this.hKl.b(aVar);
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
    public boolean xr(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        xs(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bTO().getPbData();
        if (pbData != null && pbData.bPI() != null) {
            pbData.bPI().hb(0);
            this.hJs = aj.bTO().bSG();
            this.hJq = aj.bTO().bTT();
            this.hJu = aj.bTO().bTU();
            this.hKp = aj.bTO().bTS();
            this.hKq = aj.bTO().bTR();
            this.hKr = aj.bTO().bTQ();
            this.hKm = this.hJq;
            if (this.hJq || this.isFromMark) {
                this.hJS = false;
            }
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.hJW) {
            a(bSZ(), true, this.hJn, 3);
        }
        if (i == 3 && !this.hJW) {
            if (this.isFromMark) {
                a(bSZ(), true, this.hJn, 3);
            } else {
                a(bSZ(), false, this.hJn, 3);
            }
        }
        this.hJW = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hKu == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.cpP);
        if (this.hJq || this.isFromMark) {
            this.hJS = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hJl == null || this.hJl.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.hJl, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ar.ail().ain() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hJs) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hJq) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hJF) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hJE));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hJS) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.f(this.hJO, 0));
            pbPageRequestMessage.setOpMessageID(this.hJE);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bPK = this.hJH.bPK();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJz - 1));
                        if (this.hJz - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hJC) {
                                if (bPK != null && bPK.size() > 0) {
                                    size = bPK.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bPK.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hJn = postData.getId();
                                            if (StringUtils.isNull(this.hJn)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hJy + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hJn == null && this.hJn.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJn, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJy + 1));
                        if (this.hJy >= this.eDJ) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bPK != null) {
                                size = bPK.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hJn == null) {
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
                if (bPK != null) {
                }
                if (this.hJn == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bPK != null && bPK.size() > 0 && bPK.get(0) != null) {
                    this.hJn = bPK.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bTt()) {
                        if (this.hJz - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hJz - 1));
                        }
                    } else if (this.hJy < this.eDJ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJy + 1));
                    }
                }
                if (this.hJn != null && this.hJn.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJn, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hJq) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bTt()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eDJ > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eDJ));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJn, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hJx));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hKm && !this.hJq) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJn, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hJq) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hKa);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hKo, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hKm = this.hJq;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bSZ());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hKn));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hJZ);
        pbPageRequestMessage.setFromSmartFrs(this.hKc ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hJp);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hJl);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bQE() {
        switch (bTn()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bPI() == null || !getPbData().bPI().aeN();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bQF()) && com.baidu.tieba.recapp.r.ceJ().ceD() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ceJ().ceD().at(bQF(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ceJ().ceD().au(bQF(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bQF()) && com.baidu.tieba.recapp.r.ceJ().ceD() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ceJ().ceD().au(bQF(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ceJ().ceD().at(bQF(), true));
        }
    }

    protected void xs(int i) {
        boolean z = false;
        xx(i);
        ArrayList<PostData> bPK = this.hJH.bPK();
        this.hJV = false;
        if (i == 1) {
            boolean z2 = false;
            while (bPK.size() + 30 > com.baidu.tbadk.data.d.aqn()) {
                bPK.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hJH.getPage().gY(1);
                if (this.hJN != null) {
                    this.hJN.e(this.hJH);
                }
            }
            this.fGJ = System.currentTimeMillis();
            this.hJV = true;
        } else if (i == 2) {
            while (bPK.size() + 30 > com.baidu.tbadk.data.d.aqn()) {
                bPK.remove(bPK.size() - 1);
                z = true;
            }
            if (z) {
                this.hJH.getPage().gX(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hKd = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hKu != null && this.hKu.aCx()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bPX() != null && dVar.bPX().cmi() != null && dVar.bPX().cmi().goods != null && dVar.bPX().aCx() && dVar.bPX().cmi().goods.goods_style != 1001) {
            this.hKu = dVar.bPX();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bSQ() {
        return this.hKu;
    }

    public void bSR() {
        this.hKu = null;
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

    protected void h(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            if (this.hJL || this.hJJ || this.hJK) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bPK().size(); i++) {
                PostData postData = dVar.bPK().get(i);
                for (int i2 = 0; i2 < postData.cmr().size(); i2++) {
                    postData.cmr().get(i2).a(this.cVo.getPageContext(), k.equals(postData.cmr().get(i2).adv().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bPT = dVar.bPT();
            if (bPT != null && !com.baidu.tbadk.core.util.v.aa(bPT.hCk)) {
                for (PostData postData2 : bPT.hCk) {
                    for (int i3 = 0; i3 < postData2.cmr().size(); i3++) {
                        postData2.cmr().get(i3).a(this.cVo.getPageContext(), k.equals(postData2.cmr().get(i3).adv().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bPT = dVar.bPT();
            if (bPT != null && !com.baidu.tbadk.core.util.v.aa(bPT.hCk)) {
                for (PostData postData : bPT.hCk.subList(i, bPT.hCk.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cmr().size()) {
                            postData.cmr().get(i3).a(this.cVo.getPageContext(), k.equals(postData.cmr().get(i3).adv().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.d j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null) {
            return null;
        }
        bg bPI = dVar.bPI();
        bPI.hf(this.mIsGood);
        bPI.he(this.hJv);
        if (this.hJw > 0) {
            bPI.aq(this.hJw);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPI() != null && dVar.bPI().adv() != null) {
            str = dVar.bPI().adv().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bSS() {
        if (this.hJH == null || this.hJH.bPI() == null || this.hJH.bPI().adv() == null) {
            return null;
        }
        return this.hJH.bPI().adv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hKb = z3;
        this.hJI = i;
        if (this.eTs != null && !z3) {
            this.eTs.a(z2, z4, i2, str, i3, j, j2);
            this.eTs = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bQF()) && com.baidu.tieba.recapp.r.ceJ().ceD() != null) {
            com.baidu.tieba.recapp.r.ceJ().ceD().g(bQF(), xt(getRequestType()), true);
        }
        if (dVar == null || (this.hJx == 1 && i == 5 && dVar.bPK() != null && dVar.bPK().size() < 1)) {
            if (this.hJN != null) {
                this.hJs = this.hJr;
                if (i2 != 350006) {
                    this.mSortType = this.hJt;
                }
                this.hJN.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hJr = this.hJs;
            if (i != 8) {
                this.hJt = this.mSortType;
                this.mSortType = dVar.hBC;
            }
            if (dVar.hBB != null && dVar.hBB.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cVo.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hBB = new ArrayList();
                dVar.hBB.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cVo.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hBB.add(builder2.build(false));
                this.mSortType = this.hJt;
                dVar.hBC = this.mSortType;
            }
            this.hJF = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eDJ = this.eDJ < 1 ? 1 : this.eDJ;
            ArrayList<PostData> bPK = this.hJH.bPK();
            switch (i) {
                case 1:
                    this.hJH.a(dVar.getPage(), 1);
                    d(dVar, bPK);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bPK() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bPK().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bPK, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bPK(), com.baidu.tbadk.core.util.v.Z(dVar.bPK()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bPK().remove(postData2);
                            i6 = size - 1;
                        }
                        bPK.addAll(0, dVar.bPK());
                    }
                    this.hJH.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().gV(dVar.getPage().ack());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bTt()) {
                        bST();
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 4:
                    l(dVar);
                    i5 = 0;
                    break;
                case 5:
                    l(dVar);
                    i5 = 0;
                    break;
                case 6:
                    l(dVar);
                    i5 = 0;
                    break;
                case 7:
                    l(dVar);
                    i5 = 0;
                    break;
                case 8:
                    if (dVar != null && !com.baidu.tbadk.core.util.v.aa(dVar.bPK()) && this.hJH != null && (!this.hJq || k(dVar).equals(dVar.bPK().get(0).adv().getUserId()))) {
                        if (this.hJH.getPage().acp() == 0) {
                            this.hJH.getPage().gX(1);
                        }
                        bTo();
                        this.hKp = dVar.bPK().get(0);
                        if (bTt()) {
                            if (this.hJH.bPK().size() - this.hKr >= 3) {
                                this.hKq = new PostData();
                                this.hKq.iZb = true;
                                this.hKq.setPostType(53);
                                this.hJH.bPK().add(this.hKq);
                            }
                            this.hJH.bPK().add(this.hKp);
                            i4 = this.hJH.bPK().size() - 1;
                        } else {
                            if (this.hKr - this.hKs >= 3) {
                                this.hKq = new PostData();
                                this.hKq.iZb = false;
                                this.hKq.setPostType(53);
                                this.hJH.bPK().add(0, this.hKq);
                            }
                            this.hJH.bPK().add(0, this.hKp);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.bb(com.baidu.tbadk.core.sharedPref.b.agM().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hKp.iZn = this.hJH.bQh();
                            com.baidu.tbadk.core.sharedPref.b.agM().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.hJH != null && this.hJH.bPI() != null) {
                PraiseData adh = this.hJH.bPI().adh();
                if (this.hKy != null && !adh.isPriaseDataValid()) {
                    this.hJH.bPI().a(this.hKy);
                } else {
                    this.hKy = this.hJH.bPI().adh();
                    this.hKy.setPostId(this.hJH.bPI().adL());
                }
                if (dVar.getPage() != null && dVar.getPage().acn() == 1 && dVar.bPI() != null && dVar.bPI().adG() != null && dVar.bPI().adG().size() > 0) {
                    this.hJH.bPI().q(dVar.bPI().adG());
                }
                this.hJH.bPI().hc(dVar.bPI().adm());
                this.hJH.bPI().gZ(dVar.bPI().getAnchorLevel());
                this.hJH.bPI().hb(dVar.bPI().add());
                if (this.mThreadType == 33) {
                    this.hJH.bPI().adv().setHadConcerned(dVar.bPI().adv().hadConcerned());
                }
                if (dVar != null && dVar.bPI() != null) {
                    this.hJH.bPI().hh(dVar.bPI().adK());
                }
            }
            if (this.hJH != null && this.hJH.getUserData() != null && dVar.getUserData() != null) {
                this.hJH.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hJH.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().acn() == 1 && dVar.bPS() != null) {
                this.hJH.d(dVar.bPS());
            }
            if (this.hKb) {
                if (this.hJH.bPI() != null && this.hJH.bPI().adv() != null && this.hJH.bPK() != null && com.baidu.tbadk.core.util.v.c(this.hJH.bPK(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hJH.bPK(), 0);
                    MetaData adv = this.hJH.bPI().adv();
                    if (postData3.adv() != null && postData3.adv().getGodUserData() != null) {
                        if (this.hJQ != -1) {
                            adv.setFansNum(this.hJQ);
                            postData3.adv().setFansNum(this.hJQ);
                        }
                        if (this.hJR != -1) {
                            adv.getGodUserData().setIsLike(this.hJR == 1);
                            postData3.adv().getGodUserData().setIsLike(this.hJR == 1);
                            adv.getGodUserData().setIsFromNetWork(false);
                            postData3.adv().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hJH.hBA = -1;
                this.hJH.hBz = -1;
            }
            if (this.hJN != null) {
                this.hJN.a(true, getErrorCode(), i, i5, this.hJH, this.mErrorString, 1);
            }
        }
        if (this.hJH != null && this.hJH.bPI() != null && this.hJH.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cVo.getPageContext();
            historyMessage.threadId = getPbData().bPI().getId();
            if (this.mIsShareThread && getPbData().bPI().bKP != null) {
                historyMessage.threadName = getPbData().bPI().bKP.showText;
            } else {
                historyMessage.threadName = getPbData().bPI().getTitle();
            }
            if (this.mIsShareThread && !bQE()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bSG();
            historyMessage.threadType = getPbData().bPI().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aw;
        if (arrayList != null && dVar.bPK() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bPK(), 0);
            if (postData != null && (aw = aw(arrayList)) != null && aw.equals(postData.getId())) {
                dVar.bPK().remove(postData);
            }
            arrayList.addAll(dVar.bPK());
        }
    }

    private int xt(int i) {
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

    private String aw(ArrayList<PostData> arrayList) {
        int Z = com.baidu.tbadk.core.util.v.Z(arrayList);
        if (Z <= 0) {
            return null;
        }
        for (int i = Z - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.tieba.pb.data.d dVar) {
        dVar.AW(this.hJH.bQa());
        this.hJH = dVar;
        xq(dVar.getPage().acn());
    }

    private void bST() {
        if (this.hJH != null && this.hJH.bPK() != null && this.hJH.bPZ() != null) {
            ArrayList<PostData> bPK = this.hJH.bPK();
            com.baidu.tieba.pb.data.a bPZ = this.hJH.bPZ();
            int bPF = bPZ.bPF();
            if (bPF > 0) {
                if (bPF <= bPK.size()) {
                    bPK.add(bPF, bPZ);
                } else {
                    bPK.add(bPZ);
                }
            }
        }
    }

    public boolean bSU() {
        if (this.hJl == null || this.hJn == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return xr(4);
        }
        return xr(6);
    }

    public boolean on(boolean z) {
        if (this.hJl == null || this.hJH == null) {
            return false;
        }
        if (z || this.hJH.getPage().acp() != 0) {
            return xr(1);
        }
        return false;
    }

    public boolean oo(boolean z) {
        if (this.hJl == null || this.hJH == null) {
            return false;
        }
        if ((z || this.hJH.getPage().acq() != 0) && this.hJH.bPK() != null && this.hJH.bPK().size() >= 1) {
            return xr(2);
        }
        return false;
    }

    public boolean Bf(String str) {
        this.hJq = !this.hJq;
        this.hJn = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (xr(6)) {
            return true;
        }
        this.hJq = this.hJq ? false : true;
        return false;
    }

    public boolean t(boolean z, String str) {
        if (this.hJq == z) {
            return false;
        }
        this.hJq = z;
        this.hJn = str;
        if (this.mSortType == 2) {
            this.hJn = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (xr(6)) {
            return true;
        }
        this.hJq = z ? false : true;
        return false;
    }

    public boolean xu(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hJr = this.hJs;
        this.hJt = this.mSortType;
        this.mSortType = i;
        this.hJs = !this.hJs;
        if (i == 2 && this.isFromMark) {
            this.hJn = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hJs = this.hJs ? false : true;
            this.mSortType = this.hJt;
            return false;
        }
        return true;
    }

    public boolean bSV() {
        return bTt();
    }

    public int bSW() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hJH == null || this.hJH.getForum() == null || this.hJH.bPI() == null) ? false : true;
    }

    public boolean ZC() {
        if (this.hJH == null) {
            return false;
        }
        return this.hJH.ZC();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hJH == null || this.hJH.bPI() == null || this.hJH.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hJH.bPI().aeN()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hJH.getForum().getId());
            writeData.setForumName(this.hJH.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hKn);
        writeData.setThreadId(this.hJl);
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

    public MarkData xv(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hJH == null) {
            return null;
        }
        ArrayList<PostData> bPK = this.hJH.bPK();
        if (com.baidu.tbadk.core.util.v.aa(bPK)) {
            return null;
        }
        if (bPK.size() > 0 && i >= bPK.size()) {
            i = bPK.size() - 1;
        }
        return j(bPK.get(i));
    }

    public MarkData bSX() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hJl);
        markData.setPostId(this.hJH.ZB());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hJq);
        markData.setSequence(Boolean.valueOf(bTt()));
        markData.setId(this.hJl);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hJl);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hJq);
        markData.setSequence(Boolean.valueOf(bTt()));
        markData.setId(this.hJl);
        markData.setFloor(postData.cmu());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bSY() {
        g.bSp().ao(bSZ(), this.isFromMark);
    }

    private String bSZ() {
        String str = this.hJl;
        if (this.hJq) {
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

    public void op(boolean z) {
        if (this.hJH != null) {
            this.hJH.ds(z);
        }
    }

    public void oq(boolean z) {
        this.hJS = z;
    }

    public boolean bTa() {
        return this.hJS;
    }

    public void a(a aVar) {
        this.hJN = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aro() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        return atv();
    }

    public boolean Bg(String str) {
        if (getPbData() == null || getPbData().bPI() == null || getPbData().bPI().adv() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bPI().adv().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bTb() {
        String bSZ = bSZ();
        g.bSp().ao(bSZ, false);
        g.bSp().ao(bSZ, true);
    }

    public void bTc() {
        if ("personalize_page".equals(this.mStType)) {
            this.hJY = System.currentTimeMillis() / 1000;
        }
    }

    public void bTd() {
        if ("personalize_page".equals(this.mStType) && this.hJH != null && this.hJY != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bT("fid", this.hJH.getForumId()).bT("tid", this.hJl).bT("obj_duration", String.valueOf(currentTimeMillis - this.hJY)).bT("obj_param3", String.valueOf(currentTimeMillis)));
            this.hJY = 0L;
        }
    }

    public boolean bTe() {
        return this.hKb;
    }

    public int getErrorNo() {
        return this.hKd;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bTf() {
        return this.hKf;
    }

    public m bTg() {
        return this.hKg;
    }

    public z bTh() {
        return this.hKh;
    }

    public CheckRealNameModel bTi() {
        return this.dVx;
    }

    public AddExperiencedModel bTj() {
        return this.hKj;
    }

    public String bTk() {
        return this.hJX;
    }

    public void Bh(String str) {
        this.hJX = str;
    }

    public boolean bTl() {
        return this.hKc;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hJH != null && this.hJH.bPK() != null && this.hJH.bPK().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hJH.bPK().size();
                for (int i = 0; i < size; i++) {
                    if (this.hJH.bPK().get(i) != null && this.hJH.bPK().get(i).adv() != null && currentAccount.equals(this.hJH.bPK().get(i).adv().getUserId()) && this.hJH.bPK().get(i).adv().getPendantData() != null) {
                        this.hJH.bPK().get(i).adv().getPendantData().ml(lVar.abS());
                        this.hJH.bPK().get(i).adv().getPendantData().bg(lVar.aqx());
                    }
                }
            }
        }
    }

    public String bTm() {
        return this.hKi;
    }

    public int bTn() {
        return this.hKn;
    }

    public void xw(int i) {
        this.hKn = i;
    }

    public void Bi(String str) {
        if ((!this.hJq || Bg(TbadkCoreApplication.getCurrentAccount())) && this.hJH.bPK() != null) {
            this.hJH.getPage().gX(1);
            if (this.hJH.getPage().acp() == 0) {
                this.hJH.getPage().gX(1);
            }
            this.hKo = str;
            xr(8);
        }
    }

    private void xx(int i) {
        if (i != 8) {
            this.hKo = "";
            if (this.hKp != null) {
                if (i == 1 && !this.hJs && !com.baidu.tbadk.core.util.v.aa(getPbData().bPK())) {
                    getPbData().bPK().remove(this.hKp);
                    if (this.hKq != null) {
                        getPbData().bPK().remove(this.hKq);
                    }
                    getPbData().bPK().add(0, this.hKp);
                } else {
                    getPbData().bPK().remove(this.hKp);
                    if (this.hKq != null) {
                        getPbData().bPK().remove(this.hKq);
                    }
                }
            }
            this.hKq = null;
        }
    }

    public void bTo() {
        if (this.hJH != null && !com.baidu.tbadk.core.util.v.aa(this.hJH.bPK())) {
            if (this.hKq != null) {
                this.hJH.bPK().remove(this.hKq);
                this.hKq = null;
            }
            if (this.hKp != null) {
                this.hJH.bPK().remove(this.hKp);
                this.hKp = null;
            }
        }
    }

    public void cb(int i, int i2) {
        this.hKr = i;
        this.hKs = i2;
    }

    public PostData bTp() {
        return this.hKp;
    }

    public PostData bTq() {
        return this.hKq;
    }

    public int bTr() {
        return this.hKr;
    }

    public String bTs() {
        return this.hKt;
    }

    public void Bj(String str) {
        this.hKt = str;
    }

    private boolean bTt() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bTu() {
        return this.hKn == 13 || this.hKn == 12;
    }
}
