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
    private BaseActivity cVp;
    private final CheckRealNameModel dVy;
    private int eDK;
    private com.baidu.tieba.tbadkCore.d.b eTt;
    private long fGK;
    private boolean gQC;
    private int hJA;
    private int hJB;
    private int hJC;
    private boolean hJD;
    private boolean hJE;
    private boolean hJF;
    private boolean hJG;
    private long hJH;
    private boolean hJI;
    private String hJJ;
    protected com.baidu.tieba.pb.data.d hJK;
    private int hJL;
    private boolean hJM;
    private boolean hJN;
    private boolean hJO;
    private boolean hJP;
    private a hJQ;
    private String hJR;
    private String hJS;
    private int hJT;
    private int hJU;
    private boolean hJV;
    private boolean hJW;
    private boolean hJX;
    private boolean hJY;
    private boolean hJZ;
    protected String hJo;
    private String hJp;
    private String hJq;
    private String hJr;
    private boolean hJs;
    private boolean hJt;
    private boolean hJu;
    private boolean hJv;
    private int hJw;
    private boolean hJx;
    private int hJy;
    private long hJz;
    private com.baidu.adp.framework.listener.a hKA;
    private PraiseData hKB;
    private String hKa;
    private long hKb;
    private boolean hKc;
    private int hKd;
    private boolean hKe;
    private boolean hKf;
    private int hKg;
    private final x hKh;
    private final h hKi;
    private final m hKj;
    private final z hKk;
    private String hKl;
    private final AddExperiencedModel hKm;
    private SuggestEmotionModel hKn;
    private GetSugMatchWordsModel hKo;
    private boolean hKp;
    private int hKq;
    private String hKr;
    private PostData hKs;
    private PostData hKt;
    private int hKu;
    private int hKv;
    private String hKw;
    private com.baidu.tieba.tbadkCore.data.m hKx;
    private CustomMessageListener hKy;
    private CustomMessageListener hKz;
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
    private static final int hJn = com.baidu.tbadk.data.d.aqn() / 30;
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
        this.hJo = null;
        this.hJp = null;
        this.hJq = null;
        this.mForumId = null;
        this.hJr = null;
        this.hJs = false;
        this.hJt = false;
        this.hJu = true;
        this.hJv = true;
        this.mSortType = 0;
        this.hJw = 0;
        this.hJx = false;
        this.mIsGood = 0;
        this.hJy = 0;
        this.hJz = 0L;
        this.hJA = 1;
        this.hJB = 1;
        this.hJC = 1;
        this.eDK = 1;
        this.isAd = false;
        this.gQC = false;
        this.hJD = false;
        this.hJE = false;
        this.isFromMark = false;
        this.hJF = false;
        this.hJG = false;
        this.hJH = 0L;
        this.hJI = false;
        this.hJJ = null;
        this.hJK = null;
        this.isLoading = false;
        this.hJM = false;
        this.hJN = false;
        this.hJO = false;
        this.hJP = false;
        this.mLocate = null;
        this.mContext = null;
        this.hJQ = null;
        this.opType = null;
        this.opUrl = null;
        this.hJR = null;
        this.hJS = null;
        this.hJT = -1;
        this.hJU = -1;
        this.eTt = null;
        this.hJW = false;
        this.hJX = false;
        this.postID = null;
        this.hKa = null;
        this.hKb = 0L;
        this.hKc = false;
        this.hKd = -1;
        this.hKf = false;
        this.hKp = false;
        this.hKq = 0;
        this.hKy = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hJZ = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hBG == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bPL() != null) {
                        pbData.bPL().hb(0);
                    }
                    if (PbModel.this.hJQ != null && pbData != null) {
                        com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hJQ.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hKz = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hKA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.jS()) {
                        PbModel.this.cVp.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.hJW || !PbModel.this.hJX) {
                        if (!PbModel.this.hJW) {
                            PbModel.this.hJW = true;
                        } else {
                            PbModel.this.hJX = true;
                        }
                        if (PbModel.this.hJQ != null) {
                            PbModel.this.hJQ.a(PbModel.this.bSF(), z, responsedMessage, PbModel.this.hJY, System.currentTimeMillis() - PbModel.this.fGK);
                        }
                    }
                }
            }
        };
        this.hKB = null;
        registerListener(this.hKy);
        registerListener(this.hKA);
        registerListener(this.hKz);
        this.hJK = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cVp = baseActivity;
        this.hKh = new x(this, this.cVp);
        this.hKi = new h(this, this.cVp);
        this.hKj = new m(this, this.cVp);
        this.hKk = new z(this, this.cVp);
        this.dVy = new CheckRealNameModel(this.cVp.getPageContext());
        this.hKn = new SuggestEmotionModel();
        this.hKm = new AddExperiencedModel(this.cVp.getPageContext());
    }

    protected int bSF() {
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
            this.hJo = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.YA().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.byt) instanceof String)) {
                            PbModel.this.hJo = (String) hashMap.get(com.baidu.tbadk.BdToken.f.byt);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hJo)) {
                this.hJo = this.hKh.as(intent);
                if (StringUtils.isNull(this.hJo) && intent.getData() != null) {
                    this.hJo = data.getQueryParameter("thread_id");
                }
            }
            this.hKq = intent.getIntExtra("key_start_from", 0);
            if (this.hKq == 0) {
                this.hKq = this.hKh.hKH;
            }
            this.hJq = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hJp = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hJs = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hJt = intent.getBooleanExtra("host_only", false);
            this.hJv = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.auN().akJ() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hJq = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hJy = intent.getIntExtra("is_top", 0);
            this.hJz = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hJF = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hJG = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gQC = intent.getBooleanExtra("is_sub_pb", false);
            this.hJI = intent.getBooleanExtra("is_pv", false);
            this.hJH = intent.getLongExtra("msg_id", 0L);
            this.hJJ = intent.getStringExtra("from_forum_name");
            this.hJS = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hJR = intent.getStringExtra("op_stat");
            this.hJM = intent.getBooleanExtra("is_from_thread_config", false);
            this.hJN = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hJO = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hJU = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hJT = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hJD = intent.getBooleanExtra("from_frs", false);
            this.hJE = intent.getBooleanExtra("from_maintab", false);
            this.hKf = intent.getBooleanExtra("from_smart_frs", false);
            this.hJP = intent.getBooleanExtra("from_hottopic", false);
            this.hKl = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hJr = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hKq = bundle.getInt("key_start_from", 0);
        this.hJo = bundle.getString("thread_id");
        this.hJq = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hJp = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hJs = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hJt = bundle.getBoolean("host_only", false);
        this.hJv = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hJy = bundle.getInt("is_top", 0);
        this.hJz = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hJG = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gQC = bundle.getBoolean("is_sub_pb", false);
        this.hJI = bundle.getBoolean("is_pv", false);
        this.hJH = bundle.getLong("msg_id", 0L);
        this.hJJ = bundle.getString("from_forum_name");
        this.hJS = bundle.getString("extra_pb_cache_key");
        this.hJM = bundle.getBoolean("is_from_thread_config", false);
        this.hJN = bundle.getBoolean("is_from_interview_live_config", false);
        this.hJO = bundle.getBoolean("is_from_my_god_config", false);
        this.hJU = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hJT = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hJD = bundle.getBoolean("from_frs", false);
        this.hJE = bundle.getBoolean("from_maintab", false);
        this.hKf = bundle.getBoolean("from_smart_frs", false);
        this.hJP = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hJr = bundle.getString("high_light_post_id");
    }

    public void ab(Bundle bundle) {
        bundle.putString("thread_id", this.hJo);
        bundle.putString("post_id", this.hJq);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hKq);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hJs);
        bundle.putBoolean("host_only", this.hJt);
        bundle.putBoolean("squence", this.hJv);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hJy);
        bundle.putLong("thread_time", this.hJz);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hJG);
        bundle.putBoolean("is_sub_pb", this.gQC);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hJI);
        bundle.putLong("msg_id", this.hJH);
        bundle.putString("extra_pb_cache_key", this.hJS);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hJM);
        bundle.putBoolean("is_from_interview_live_config", this.hJN);
        bundle.putBoolean("is_from_my_god_config", this.hJO);
        bundle.putInt("extra_pb_is_attention_key", this.hJU);
        bundle.putInt("extra_pb_funs_count_key", this.hJT);
        bundle.putBoolean("from_frs", this.hJD);
        bundle.putBoolean("from_maintab", this.hJE);
        bundle.putBoolean("from_smart_frs", this.hKf);
        bundle.putBoolean("from_hottopic", this.hJP);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hJr);
    }

    public String bSG() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hJo);
        if (!this.hJG) {
            sb.append(this.hJq);
        }
        sb.append(this.hJt);
        sb.append(this.hJv);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hJy);
        sb.append(this.hJz);
        sb.append(this.hJD);
        sb.append(this.hJE);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gQC);
        sb.append(this.hJI);
        sb.append(this.hJH);
        sb.append(this.hJJ);
        sb.append(this.mThreadType);
        sb.append(this.hJM);
        sb.append(this.hJN);
        sb.append(this.hJO);
        if (this.hJS != null) {
            sb.append(this.hJS);
        }
        return sb.toString();
    }

    public String bQI() {
        return this.hJJ;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hJq;
    }

    public String bSH() {
        return this.hJr;
    }

    public String bSI() {
        return this.hJo;
    }

    public boolean getHostMode() {
        return this.hJt;
    }

    public boolean bSJ() {
        return bTw();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bSK() {
        return this.hJD;
    }

    public boolean bSL() {
        return this.hJx;
    }

    public boolean bSM() {
        return this.hJE;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bSN() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bdn() {
        return this.hJy;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pE(int i) {
        this.hJy = i;
    }

    public boolean bSO() {
        return this.gQC;
    }

    public boolean bSP() {
        if (this.hJK == null) {
            return false;
        }
        return this.hJK.isValid();
    }

    public String adE() {
        if (this.hJK == null || !this.hJK.ZC()) {
            return null;
        }
        return this.hJK.ZB();
    }

    public boolean xp(int i) {
        this.hJA = i;
        if (this.hJA > this.hJK.getPage().ack()) {
            this.hJA = this.hJK.getPage().ack();
        }
        if (this.hJA < 1) {
            this.hJA = 1;
        }
        if (this.hJo == null) {
            return false;
        }
        return xr(5);
    }

    public void xq(int i) {
        this.hJA = i;
        this.hJB = i;
        this.hJC = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            xq(1);
            return;
        }
        if (this.hJB < anVar.acn()) {
            this.hJB = anVar.acn();
        }
        if (this.hJC > anVar.acn()) {
            this.hJC = anVar.acn();
        }
        this.eDK = anVar.ack();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hJK;
    }

    public com.baidu.tieba.pb.data.d bSQ() {
        if (this.hJK == null) {
            return this.hJK;
        }
        if (!bSR() && this.hKx != null) {
            this.hJK.b(this.hKx);
        }
        return this.hJK;
    }

    private boolean bSR() {
        return (this.hJK.bQa() == null || this.hJK.bQa().cmk() == null || this.hJK.bQa().cmk().goods != null || this.hJK.bQa().cmk().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hJK == null) {
            return null;
        }
        return this.hJK.getPage();
    }

    public boolean bSS() {
        if (bTw() && this.hJK.getPage().acp() == 0) {
            on(true);
            return true;
        }
        return false;
    }

    public void AZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.hJo = str;
            this.hJq = null;
            this.hJt = false;
            this.hJv = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hJo == null) {
            return false;
        }
        cancelLoadData();
        if (this.eTt == null) {
            this.eTt = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eTt.start();
        }
        boolean xr = xr(3);
        if (this.opType != null) {
            this.opType = null;
            this.hJR = null;
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
        if (this.hKn != null) {
            this.hKn.cancelLoadData();
        }
        if (this.hKo != null) {
            this.hKo.cancelLoadData();
        }
        ben();
    }

    private void ben() {
        if (this.eTt != null) {
            this.eTt.destory();
            this.eTt = null;
        }
    }

    public boolean atv() {
        return (this.hJq == null || this.hJq.equals("0") || this.hJq.length() == 0) ? LoadData() : bSX();
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
                this.hKn.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hKn.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hKo == null) {
                this.hKo = new GetSugMatchWordsModel(this.cVp.getPageContext());
            }
            this.hKo.b(aVar);
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
        final com.baidu.tieba.pb.data.d pbData = aj.bTR().getPbData();
        if (pbData != null && pbData.bPL() != null) {
            pbData.bPL().hb(0);
            this.hJv = aj.bTR().bSJ();
            this.hJt = aj.bTR().bTW();
            this.hJx = aj.bTR().bTX();
            this.hKs = aj.bTR().bTV();
            this.hKt = aj.bTR().bTU();
            this.hKu = aj.bTR().bTT();
            this.hKp = this.hJt;
            if (this.hJt || this.isFromMark) {
                this.hJV = false;
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
        if (i == 4 && !this.hJZ) {
            a(bTc(), true, this.hJq, 3);
        }
        if (i == 3 && !this.hJZ) {
            if (this.isFromMark) {
                a(bTc(), true, this.hJq, 3);
            } else {
                a(bTc(), false, this.hJq, 3);
            }
        }
        this.hJZ = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hKx == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.cpP);
        if (this.hJt || this.isFromMark) {
            this.hJV = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hJo == null || this.hJo.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.hJo, 0L));
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
        if (!this.hJv) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hJt) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hJI) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hJH));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hJV) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.f(this.hJR, 0));
            pbPageRequestMessage.setOpMessageID(this.hJH);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bPN = this.hJK.bPN();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJC - 1));
                        if (this.hJC - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hJF) {
                                if (bPN != null && bPN.size() > 0) {
                                    size = bPN.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bPN.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hJq = postData.getId();
                                            if (StringUtils.isNull(this.hJq)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hJB + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hJq == null && this.hJq.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJq, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJB + 1));
                        if (this.hJB >= this.eDK) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bPN != null) {
                                size = bPN.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hJq == null) {
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
                if (bPN != null) {
                }
                if (this.hJq == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bPN != null && bPN.size() > 0 && bPN.get(0) != null) {
                    this.hJq = bPN.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bTw()) {
                        if (this.hJC - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hJC - 1));
                        }
                    } else if (this.hJB < this.eDK) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hJB + 1));
                    }
                }
                if (this.hJq != null && this.hJq.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJq, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hJt) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bTw()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eDK > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eDK));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJq, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hJA));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hKp && !this.hJt) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hJq, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hJt) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hKd);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hKr, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hKp = this.hJt;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bTc());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hKq));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hKc);
        pbPageRequestMessage.setFromSmartFrs(this.hKf ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hJs);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hJo);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bQH() {
        switch (bTq()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bPL() == null || !getPbData().bPL().aeN();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bQI()) && com.baidu.tieba.recapp.r.ceL().ceF() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ceL().ceF().at(bQI(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ceL().ceF().au(bQI(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bQI()) && com.baidu.tieba.recapp.r.ceL().ceF() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.ceL().ceF().au(bQI(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.ceL().ceF().at(bQI(), true));
        }
    }

    protected void xs(int i) {
        boolean z = false;
        xx(i);
        ArrayList<PostData> bPN = this.hJK.bPN();
        this.hJY = false;
        if (i == 1) {
            boolean z2 = false;
            while (bPN.size() + 30 > com.baidu.tbadk.data.d.aqn()) {
                bPN.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hJK.getPage().gY(1);
                if (this.hJQ != null) {
                    this.hJQ.e(this.hJK);
                }
            }
            this.fGK = System.currentTimeMillis();
            this.hJY = true;
        } else if (i == 2) {
            while (bPN.size() + 30 > com.baidu.tbadk.data.d.aqn()) {
                bPN.remove(bPN.size() - 1);
                z = true;
            }
            if (z) {
                this.hJK.getPage().gX(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hKg = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hKx != null && this.hKx.aCA()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bQa() != null && dVar.bQa().cmk() != null && dVar.bQa().cmk().goods != null && dVar.bQa().aCA() && dVar.bQa().cmk().goods.goods_style != 1001) {
            this.hKx = dVar.bQa();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bST() {
        return this.hKx;
    }

    public void bSU() {
        this.hKx = null;
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
            if (this.hJO || this.hJM || this.hJN) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bPN().size(); i++) {
                PostData postData = dVar.bPN().get(i);
                for (int i2 = 0; i2 < postData.cmt().size(); i2++) {
                    postData.cmt().get(i2).a(this.cVp.getPageContext(), k.equals(postData.cmt().get(i2).adv().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bPW = dVar.bPW();
            if (bPW != null && !com.baidu.tbadk.core.util.v.aa(bPW.hCn)) {
                for (PostData postData2 : bPW.hCn) {
                    for (int i3 = 0; i3 < postData2.cmt().size(); i3++) {
                        postData2.cmt().get(i3).a(this.cVp.getPageContext(), k.equals(postData2.cmt().get(i3).adv().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bPW = dVar.bPW();
            if (bPW != null && !com.baidu.tbadk.core.util.v.aa(bPW.hCn)) {
                for (PostData postData : bPW.hCn.subList(i, bPW.hCn.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cmt().size()) {
                            postData.cmt().get(i3).a(this.cVp.getPageContext(), k.equals(postData.cmt().get(i3).adv().getUserId()));
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
        bg bPL = dVar.bPL();
        bPL.hf(this.mIsGood);
        bPL.he(this.hJy);
        if (this.hJz > 0) {
            bPL.aq(this.hJz);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bPL() != null && dVar.bPL().adv() != null) {
            str = dVar.bPL().adv().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bSV() {
        if (this.hJK == null || this.hJK.bPL() == null || this.hJK.bPL().adv() == null) {
            return null;
        }
        return this.hJK.bPL().adv();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hKe = z3;
        this.hJL = i;
        if (this.eTt != null && !z3) {
            this.eTt.a(z2, z4, i2, str, i3, j, j2);
            this.eTt = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bQI()) && com.baidu.tieba.recapp.r.ceL().ceF() != null) {
            com.baidu.tieba.recapp.r.ceL().ceF().g(bQI(), xt(getRequestType()), true);
        }
        if (dVar == null || (this.hJA == 1 && i == 5 && dVar.bPN() != null && dVar.bPN().size() < 1)) {
            if (this.hJQ != null) {
                this.hJv = this.hJu;
                if (i2 != 350006) {
                    this.mSortType = this.hJw;
                }
                this.hJQ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hJu = this.hJv;
            if (i != 8) {
                this.hJw = this.mSortType;
                this.mSortType = dVar.hBF;
            }
            if (dVar.hBE != null && dVar.hBE.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cVp.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hBE = new ArrayList();
                dVar.hBE.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cVp.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hBE.add(builder2.build(false));
                this.mSortType = this.hJw;
                dVar.hBF = this.mSortType;
            }
            this.hJI = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eDK = this.eDK < 1 ? 1 : this.eDK;
            ArrayList<PostData> bPN = this.hJK.bPN();
            switch (i) {
                case 1:
                    this.hJK.a(dVar.getPage(), 1);
                    d(dVar, bPN);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bPN() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bPN().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bPN, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bPN(), com.baidu.tbadk.core.util.v.Z(dVar.bPN()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bPN().remove(postData2);
                            i6 = size - 1;
                        }
                        bPN.addAll(0, dVar.bPN());
                    }
                    this.hJK.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().gV(dVar.getPage().ack());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bTw()) {
                        bSW();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.aa(dVar.bPN()) && this.hJK != null && (!this.hJt || k(dVar).equals(dVar.bPN().get(0).adv().getUserId()))) {
                        if (this.hJK.getPage().acp() == 0) {
                            this.hJK.getPage().gX(1);
                        }
                        bTr();
                        this.hKs = dVar.bPN().get(0);
                        if (bTw()) {
                            if (this.hJK.bPN().size() - this.hKu >= 3) {
                                this.hKt = new PostData();
                                this.hKt.iZd = true;
                                this.hKt.setPostType(53);
                                this.hJK.bPN().add(this.hKt);
                            }
                            this.hJK.bPN().add(this.hKs);
                            i4 = this.hJK.bPN().size() - 1;
                        } else {
                            if (this.hKu - this.hKv >= 3) {
                                this.hKt = new PostData();
                                this.hKt.iZd = false;
                                this.hKt.setPostType(53);
                                this.hJK.bPN().add(0, this.hKt);
                            }
                            this.hJK.bPN().add(0, this.hKs);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.ap.bb(com.baidu.tbadk.core.sharedPref.b.agM().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hKs.iZp = this.hJK.bQk();
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
            if (this.hJK != null && this.hJK.bPL() != null) {
                PraiseData adh = this.hJK.bPL().adh();
                if (this.hKB != null && !adh.isPriaseDataValid()) {
                    this.hJK.bPL().a(this.hKB);
                } else {
                    this.hKB = this.hJK.bPL().adh();
                    this.hKB.setPostId(this.hJK.bPL().adL());
                }
                if (dVar.getPage() != null && dVar.getPage().acn() == 1 && dVar.bPL() != null && dVar.bPL().adG() != null && dVar.bPL().adG().size() > 0) {
                    this.hJK.bPL().q(dVar.bPL().adG());
                }
                this.hJK.bPL().hc(dVar.bPL().adm());
                this.hJK.bPL().gZ(dVar.bPL().getAnchorLevel());
                this.hJK.bPL().hb(dVar.bPL().add());
                if (this.mThreadType == 33) {
                    this.hJK.bPL().adv().setHadConcerned(dVar.bPL().adv().hadConcerned());
                }
                if (dVar != null && dVar.bPL() != null) {
                    this.hJK.bPL().hh(dVar.bPL().adK());
                }
            }
            if (this.hJK != null && this.hJK.getUserData() != null && dVar.getUserData() != null) {
                this.hJK.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hJK.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().acn() == 1 && dVar.bPV() != null) {
                this.hJK.d(dVar.bPV());
            }
            if (this.hKe) {
                if (this.hJK.bPL() != null && this.hJK.bPL().adv() != null && this.hJK.bPN() != null && com.baidu.tbadk.core.util.v.c(this.hJK.bPN(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hJK.bPN(), 0);
                    MetaData adv = this.hJK.bPL().adv();
                    if (postData3.adv() != null && postData3.adv().getGodUserData() != null) {
                        if (this.hJT != -1) {
                            adv.setFansNum(this.hJT);
                            postData3.adv().setFansNum(this.hJT);
                        }
                        if (this.hJU != -1) {
                            adv.getGodUserData().setIsLike(this.hJU == 1);
                            postData3.adv().getGodUserData().setIsLike(this.hJU == 1);
                            adv.getGodUserData().setIsFromNetWork(false);
                            postData3.adv().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hJK.hBD = -1;
                this.hJK.hBC = -1;
            }
            if (this.hJQ != null) {
                this.hJQ.a(true, getErrorCode(), i, i5, this.hJK, this.mErrorString, 1);
            }
        }
        if (this.hJK != null && this.hJK.bPL() != null && this.hJK.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cVp.getPageContext();
            historyMessage.threadId = getPbData().bPL().getId();
            if (this.mIsShareThread && getPbData().bPL().bKP != null) {
                historyMessage.threadName = getPbData().bPL().bKP.showText;
            } else {
                historyMessage.threadName = getPbData().bPL().getTitle();
            }
            if (this.mIsShareThread && !bQH()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bSJ();
            historyMessage.threadType = getPbData().bPL().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aw;
        if (arrayList != null && dVar.bPN() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bPN(), 0);
            if (postData != null && (aw = aw(arrayList)) != null && aw.equals(postData.getId())) {
                dVar.bPN().remove(postData);
            }
            arrayList.addAll(dVar.bPN());
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
        dVar.AW(this.hJK.bQd());
        this.hJK = dVar;
        xq(dVar.getPage().acn());
    }

    private void bSW() {
        if (this.hJK != null && this.hJK.bPN() != null && this.hJK.bQc() != null) {
            ArrayList<PostData> bPN = this.hJK.bPN();
            com.baidu.tieba.pb.data.a bQc = this.hJK.bQc();
            int bPI = bQc.bPI();
            if (bPI > 0) {
                if (bPI <= bPN.size()) {
                    bPN.add(bPI, bQc);
                } else {
                    bPN.add(bQc);
                }
            }
        }
    }

    public boolean bSX() {
        if (this.hJo == null || this.hJq == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return xr(4);
        }
        return xr(6);
    }

    public boolean on(boolean z) {
        if (this.hJo == null || this.hJK == null) {
            return false;
        }
        if (z || this.hJK.getPage().acp() != 0) {
            return xr(1);
        }
        return false;
    }

    public boolean oo(boolean z) {
        if (this.hJo == null || this.hJK == null) {
            return false;
        }
        if ((z || this.hJK.getPage().acq() != 0) && this.hJK.bPN() != null && this.hJK.bPN().size() >= 1) {
            return xr(2);
        }
        return false;
    }

    public boolean Bf(String str) {
        this.hJt = !this.hJt;
        this.hJq = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (xr(6)) {
            return true;
        }
        this.hJt = this.hJt ? false : true;
        return false;
    }

    public boolean t(boolean z, String str) {
        if (this.hJt == z) {
            return false;
        }
        this.hJt = z;
        this.hJq = str;
        if (this.mSortType == 2) {
            this.hJq = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (xr(6)) {
            return true;
        }
        this.hJt = z ? false : true;
        return false;
    }

    public boolean xu(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hJu = this.hJv;
        this.hJw = this.mSortType;
        this.mSortType = i;
        this.hJv = !this.hJv;
        if (i == 2 && this.isFromMark) {
            this.hJq = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hJv = this.hJv ? false : true;
            this.mSortType = this.hJw;
            return false;
        }
        return true;
    }

    public boolean bSY() {
        return bTw();
    }

    public int bSZ() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hJK == null || this.hJK.getForum() == null || this.hJK.bPL() == null) ? false : true;
    }

    public boolean ZC() {
        if (this.hJK == null) {
            return false;
        }
        return this.hJK.ZC();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hJK == null || this.hJK.bPL() == null || this.hJK.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hJK.bPL().aeN()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hJK.getForum().getId());
            writeData.setForumName(this.hJK.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hKq);
        writeData.setThreadId(this.hJo);
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
        if (this.hJK == null) {
            return null;
        }
        ArrayList<PostData> bPN = this.hJK.bPN();
        if (com.baidu.tbadk.core.util.v.aa(bPN)) {
            return null;
        }
        if (bPN.size() > 0 && i >= bPN.size()) {
            i = bPN.size() - 1;
        }
        return j(bPN.get(i));
    }

    public MarkData bTa() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hJo);
        markData.setPostId(this.hJK.ZB());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hJt);
        markData.setSequence(Boolean.valueOf(bTw()));
        markData.setId(this.hJo);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hJo);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hJt);
        markData.setSequence(Boolean.valueOf(bTw()));
        markData.setId(this.hJo);
        markData.setFloor(postData.cmw());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bTb() {
        g.bSs().ao(bTc(), this.isFromMark);
    }

    private String bTc() {
        String str = this.hJo;
        if (this.hJt) {
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
        if (this.hJK != null) {
            this.hJK.ds(z);
        }
    }

    public void oq(boolean z) {
        this.hJV = z;
    }

    public boolean bTd() {
        return this.hJV;
    }

    public void a(a aVar) {
        this.hJQ = aVar;
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
        if (getPbData() == null || getPbData().bPL() == null || getPbData().bPL().adv() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bPL().adv().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void bTe() {
        String bTc = bTc();
        g.bSs().ao(bTc, false);
        g.bSs().ao(bTc, true);
    }

    public void bTf() {
        if ("personalize_page".equals(this.mStType)) {
            this.hKb = System.currentTimeMillis() / 1000;
        }
    }

    public void bTg() {
        if ("personalize_page".equals(this.mStType) && this.hJK != null && this.hKb != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c10754").bT("fid", this.hJK.getForumId()).bT("tid", this.hJo).bT("obj_duration", String.valueOf(currentTimeMillis - this.hKb)).bT("obj_param3", String.valueOf(currentTimeMillis)));
            this.hKb = 0L;
        }
    }

    public boolean bTh() {
        return this.hKe;
    }

    public int getErrorNo() {
        return this.hKg;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bTi() {
        return this.hKi;
    }

    public m bTj() {
        return this.hKj;
    }

    public z bTk() {
        return this.hKk;
    }

    public CheckRealNameModel bTl() {
        return this.dVy;
    }

    public AddExperiencedModel bTm() {
        return this.hKm;
    }

    public String bTn() {
        return this.hKa;
    }

    public void Bh(String str) {
        this.hKa = str;
    }

    public boolean bTo() {
        return this.hKf;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hJK != null && this.hJK.bPN() != null && this.hJK.bPN().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hJK.bPN().size();
                for (int i = 0; i < size; i++) {
                    if (this.hJK.bPN().get(i) != null && this.hJK.bPN().get(i).adv() != null && currentAccount.equals(this.hJK.bPN().get(i).adv().getUserId()) && this.hJK.bPN().get(i).adv().getPendantData() != null) {
                        this.hJK.bPN().get(i).adv().getPendantData().ml(lVar.abS());
                        this.hJK.bPN().get(i).adv().getPendantData().bg(lVar.aqx());
                    }
                }
            }
        }
    }

    public String bTp() {
        return this.hKl;
    }

    public int bTq() {
        return this.hKq;
    }

    public void xw(int i) {
        this.hKq = i;
    }

    public void Bi(String str) {
        if ((!this.hJt || Bg(TbadkCoreApplication.getCurrentAccount())) && this.hJK.bPN() != null) {
            this.hJK.getPage().gX(1);
            if (this.hJK.getPage().acp() == 0) {
                this.hJK.getPage().gX(1);
            }
            this.hKr = str;
            xr(8);
        }
    }

    private void xx(int i) {
        if (i != 8) {
            this.hKr = "";
            if (this.hKs != null) {
                if (i == 1 && !this.hJv && !com.baidu.tbadk.core.util.v.aa(getPbData().bPN())) {
                    getPbData().bPN().remove(this.hKs);
                    if (this.hKt != null) {
                        getPbData().bPN().remove(this.hKt);
                    }
                    getPbData().bPN().add(0, this.hKs);
                } else {
                    getPbData().bPN().remove(this.hKs);
                    if (this.hKt != null) {
                        getPbData().bPN().remove(this.hKt);
                    }
                }
            }
            this.hKt = null;
        }
    }

    public void bTr() {
        if (this.hJK != null && !com.baidu.tbadk.core.util.v.aa(this.hJK.bPN())) {
            if (this.hKt != null) {
                this.hJK.bPN().remove(this.hKt);
                this.hKt = null;
            }
            if (this.hKs != null) {
                this.hJK.bPN().remove(this.hKs);
                this.hKs = null;
            }
        }
    }

    public void cb(int i, int i2) {
        this.hKu = i;
        this.hKv = i2;
    }

    public PostData bTs() {
        return this.hKs;
    }

    public PostData bTt() {
        return this.hKt;
    }

    public int bTu() {
        return this.hKu;
    }

    public String bTv() {
        return this.hKw;
    }

    public void Bj(String str) {
        this.hKw = str;
    }

    private boolean bTw() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bTx() {
        return this.hKq == 13 || this.hKq == 12;
    }
}
