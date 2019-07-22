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
    private BaseActivity cWM;
    private final CheckRealNameModel dZq;
    private int eIG;
    private com.baidu.tieba.tbadkCore.d.b eYu;
    private long fLK;
    private boolean gWO;
    protected String hPC;
    private String hPD;
    private String hPE;
    private String hPF;
    private boolean hPG;
    private boolean hPH;
    private boolean hPI;
    private boolean hPJ;
    private int hPK;
    private boolean hPL;
    private int hPM;
    private long hPN;
    private int hPO;
    private int hPP;
    private int hPQ;
    private boolean hPR;
    private boolean hPS;
    private boolean hPT;
    private boolean hPU;
    private long hPV;
    private boolean hPW;
    private String hPX;
    protected com.baidu.tieba.pb.data.d hPY;
    private int hPZ;
    private final AddExperiencedModel hQA;
    private SuggestEmotionModel hQB;
    private GetSugMatchWordsModel hQC;
    private boolean hQD;
    private int hQE;
    private String hQF;
    private PostData hQG;
    private PostData hQH;
    private int hQI;
    private int hQJ;
    private String hQK;
    private com.baidu.tieba.tbadkCore.data.m hQL;
    private CustomMessageListener hQM;
    private CustomMessageListener hQN;
    private com.baidu.adp.framework.listener.a hQO;
    private PraiseData hQP;
    private boolean hQa;
    private boolean hQb;
    private boolean hQc;
    private boolean hQd;
    private a hQe;
    private String hQf;
    private String hQg;
    private int hQh;
    private int hQi;
    private boolean hQj;
    private boolean hQk;
    private boolean hQl;
    private boolean hQm;
    private boolean hQn;
    private String hQo;
    private long hQp;
    private boolean hQq;
    private int hQr;
    private boolean hQs;
    private boolean hQt;
    private int hQu;
    private final x hQv;
    private final h hQw;
    private final m hQx;
    private final z hQy;
    private String hQz;
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
    private static final int hPB = com.baidu.tbadk.data.d.ars() / 30;
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
        this.hPC = null;
        this.hPD = null;
        this.hPE = null;
        this.mForumId = null;
        this.hPF = null;
        this.hPG = false;
        this.hPH = false;
        this.hPI = true;
        this.hPJ = true;
        this.mSortType = 0;
        this.hPK = 0;
        this.hPL = false;
        this.mIsGood = 0;
        this.hPM = 0;
        this.hPN = 0L;
        this.hPO = 1;
        this.hPP = 1;
        this.hPQ = 1;
        this.eIG = 1;
        this.isAd = false;
        this.gWO = false;
        this.hPR = false;
        this.hPS = false;
        this.isFromMark = false;
        this.hPT = false;
        this.hPU = false;
        this.hPV = 0L;
        this.hPW = false;
        this.hPX = null;
        this.hPY = null;
        this.isLoading = false;
        this.hQa = false;
        this.hQb = false;
        this.hQc = false;
        this.hQd = false;
        this.mLocate = null;
        this.mContext = null;
        this.hQe = null;
        this.opType = null;
        this.opUrl = null;
        this.hQf = null;
        this.hQg = null;
        this.hQh = -1;
        this.hQi = -1;
        this.eYu = null;
        this.hQk = false;
        this.hQl = false;
        this.postID = null;
        this.hQo = null;
        this.hQp = 0L;
        this.hQq = false;
        this.hQr = -1;
        this.hQt = false;
        this.hQD = false;
        this.hQE = 0;
        this.hQM = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.hQn = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null && pbData.hHV == null) {
                    PbModel.this.l(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.bSx() != null) {
                        pbData.bSx().hg(0);
                    }
                    if (PbModel.this.hQe != null && pbData != null) {
                        com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.hQe.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.hQN = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.hQO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.kc()) {
                        PbModel.this.cWM.showToast(responsedMessage.getErrorString());
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
                        com.baidu.tbadk.core.e.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (!PbModel.this.hQk || !PbModel.this.hQl) {
                        if (!PbModel.this.hQk) {
                            PbModel.this.hQk = true;
                        } else {
                            PbModel.this.hQl = true;
                        }
                        if (PbModel.this.hQe != null) {
                            PbModel.this.hQe.a(PbModel.this.bVs(), z, responsedMessage, PbModel.this.hQm, System.currentTimeMillis() - PbModel.this.fLK);
                        }
                    }
                }
            }
        };
        this.hQP = null;
        registerListener(this.hQM);
        registerListener(this.hQO);
        registerListener(this.hQN);
        this.hPY = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.cWM = baseActivity;
        this.hQv = new x(this, this.cWM);
        this.hQw = new h(this, this.cWM);
        this.hQx = new m(this, this.cWM);
        this.hQy = new z(this, this.cWM);
        this.dZq = new CheckRealNameModel(this.cWM.getPageContext());
        this.hQB = new SuggestEmotionModel();
        this.hQA = new AddExperiencedModel(this.cWM.getPageContext());
    }

    protected int bVs() {
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
            this.hPC = intent.getStringExtra("thread_id");
            Uri data = intent.getData();
            if (com.baidu.tbadk.BdToken.f.m(data)) {
                com.baidu.tbadk.BdToken.f.Zw().c(data, new f.a() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.bzm) instanceof String)) {
                            PbModel.this.hPC = (String) hashMap.get(com.baidu.tbadk.BdToken.f.bzm);
                        }
                    }
                });
            } else if (StringUtils.isNull(this.hPC)) {
                this.hPC = this.hQv.as(intent);
                if (StringUtils.isNull(this.hPC) && intent.getData() != null) {
                    this.hPC = data.getQueryParameter("thread_id");
                }
            }
            this.hQE = intent.getIntExtra("key_start_from", 0);
            if (this.hQE == 0) {
                this.hQE = this.hQv.hQV;
            }
            this.hPE = intent.getStringExtra("post_id");
            this.mForumId = intent.getStringExtra("forum_id");
            this.mFromForumId = intent.getStringExtra("from_forum_id");
            this.hPD = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.hPG = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.hPH = intent.getBooleanExtra("host_only", false);
            this.hPJ = intent.getBooleanExtra("squence", true);
            this.mSortType = intent.getIntExtra(PbActivityConfig.KEY_SORTTYPE, com.baidu.tbadk.util.a.avW().alO() ? 2 : 0);
            if (this.mSortType == 2) {
                this.hPE = "0";
            }
            this.mStType = intent.getStringExtra("st_type");
            this.mLocate = intent.getStringExtra("locate");
            this.mIsGood = intent.getIntExtra("is_good", 0);
            this.hPM = intent.getIntExtra("is_top", 0);
            this.hPN = intent.getLongExtra("thread_time", 0L);
            this.isFromMark = intent.getBooleanExtra("from_mark", false);
            this.hPT = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
            this.hPU = intent.getBooleanExtra("is_pb_key_need_post_id", false);
            this.isAd = intent.getBooleanExtra("is_ad", false);
            this.gWO = intent.getBooleanExtra("is_sub_pb", false);
            this.hPW = intent.getBooleanExtra("is_pv", false);
            this.hPV = intent.getLongExtra("msg_id", 0L);
            this.hPX = intent.getStringExtra("from_forum_name");
            this.hQg = intent.getStringExtra("extra_pb_cache_key");
            this.opType = intent.getStringExtra("op_type");
            this.opUrl = intent.getStringExtra("op_url");
            this.hQf = intent.getStringExtra("op_stat");
            this.hQa = intent.getBooleanExtra("is_from_thread_config", false);
            this.hQb = intent.getBooleanExtra("is_from_interview_live_config", false);
            this.hQc = intent.getBooleanExtra("is_from_my_god_config", false);
            this.hQi = intent.getIntExtra("extra_pb_is_attention_key", -1);
            this.hQh = intent.getIntExtra("extra_pb_funs_count_key", -1);
            this.hPR = intent.getBooleanExtra("from_frs", false);
            this.hPS = intent.getBooleanExtra("from_maintab", false);
            this.hQt = intent.getBooleanExtra("from_smart_frs", false);
            this.hQd = intent.getBooleanExtra("from_hottopic", false);
            this.hQz = intent.getStringExtra("KEY_POST_THREAD_TIP");
            this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.hPF = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        this.hQE = bundle.getInt("key_start_from", 0);
        this.hPC = bundle.getString("thread_id");
        this.hPE = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.mFromForumId = bundle.getString("from_forum_id");
        this.hPD = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.hPG = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.hPH = bundle.getBoolean("host_only", false);
        this.hPJ = bundle.getBoolean("squence", true);
        this.mSortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.hPM = bundle.getInt("is_top", 0);
        this.hPN = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.hPU = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.gWO = bundle.getBoolean("is_sub_pb", false);
        this.hPW = bundle.getBoolean("is_pv", false);
        this.hPV = bundle.getLong("msg_id", 0L);
        this.hPX = bundle.getString("from_forum_name");
        this.hQg = bundle.getString("extra_pb_cache_key");
        this.hQa = bundle.getBoolean("is_from_thread_config", false);
        this.hQb = bundle.getBoolean("is_from_interview_live_config", false);
        this.hQc = bundle.getBoolean("is_from_my_god_config", false);
        this.hQi = bundle.getInt("extra_pb_is_attention_key", -1);
        this.hQh = bundle.getInt("extra_pb_funs_count_key", -1);
        this.hPR = bundle.getBoolean("from_frs", false);
        this.hPS = bundle.getBoolean("from_maintab", false);
        this.hQt = bundle.getBoolean("from_smart_frs", false);
        this.hQd = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.hPF = bundle.getString("high_light_post_id");
    }

    public void ab(Bundle bundle) {
        bundle.putString("thread_id", this.hPC);
        bundle.putString("post_id", this.hPE);
        bundle.putString("forum_id", this.mForumId);
        bundle.putString("from_forum_id", this.mFromForumId);
        bundle.putInt("key_start_from", this.hQE);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.hPG);
        bundle.putBoolean("host_only", this.hPH);
        bundle.putBoolean("squence", this.hPJ);
        bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.mSortType);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.hPM);
        bundle.putLong("thread_time", this.hPN);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.hPU);
        bundle.putBoolean("is_sub_pb", this.gWO);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.hPW);
        bundle.putLong("msg_id", this.hPV);
        bundle.putString("extra_pb_cache_key", this.hQg);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.hQa);
        bundle.putBoolean("is_from_interview_live_config", this.hQb);
        bundle.putBoolean("is_from_my_god_config", this.hQc);
        bundle.putInt("extra_pb_is_attention_key", this.hQi);
        bundle.putInt("extra_pb_funs_count_key", this.hQh);
        bundle.putBoolean("from_frs", this.hPR);
        bundle.putBoolean("from_maintab", this.hPS);
        bundle.putBoolean("from_smart_frs", this.hQt);
        bundle.putBoolean("from_hottopic", this.hQd);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
        bundle.putString("high_light_post_id", this.hPF);
    }

    public String bVt() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.hPC);
        if (!this.hPU) {
            sb.append(this.hPE);
        }
        sb.append(this.hPH);
        sb.append(this.hPJ);
        sb.append(this.mSortType);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.hPM);
        sb.append(this.hPN);
        sb.append(this.hPR);
        sb.append(this.hPS);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.gWO);
        sb.append(this.hPW);
        sb.append(this.hPV);
        sb.append(this.hPX);
        sb.append(this.mThreadType);
        sb.append(this.hQa);
        sb.append(this.hQb);
        sb.append(this.hQc);
        if (this.hQg != null) {
            sb.append(this.hQg);
        }
        return sb.toString();
    }

    public String bTu() {
        return this.hPX;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getFromForumId() {
        return this.mFromForumId;
    }

    public String getPostId() {
        return this.hPE;
    }

    public String bVu() {
        return this.hPF;
    }

    public String bVv() {
        return this.hPC;
    }

    public boolean getHostMode() {
        return this.hPH;
    }

    public boolean bVw() {
        return bWk();
    }

    public int getSortType() {
        return this.mSortType;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean bVx() {
        return this.hPR;
    }

    public boolean bVy() {
        return this.hPL;
    }

    public boolean bVz() {
        return this.hPS;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean bVA() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int bfp() {
        return this.hPM;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void pU(int i) {
        this.hPM = i;
    }

    public boolean bVB() {
        return this.gWO;
    }

    public boolean bVC() {
        if (this.hPY == null) {
            return false;
        }
        return this.hPY.isValid();
    }

    public String aeG() {
        if (this.hPY == null || !this.hPY.aaB()) {
            return null;
        }
        return this.hPY.aaA();
    }

    public boolean xT(int i) {
        this.hPO = i;
        if (this.hPO > this.hPY.getPage().adm()) {
            this.hPO = this.hPY.getPage().adm();
        }
        if (this.hPO < 1) {
            this.hPO = 1;
        }
        if (this.hPC == null) {
            return false;
        }
        return xV(5);
    }

    public void xU(int i) {
        this.hPO = i;
        this.hPP = i;
        this.hPQ = i;
    }

    public void b(com.baidu.tbadk.core.data.an anVar) {
        if (anVar == null) {
            xU(1);
            return;
        }
        if (this.hPP < anVar.adp()) {
            this.hPP = anVar.adp();
        }
        if (this.hPQ > anVar.adp()) {
            this.hPQ = anVar.adp();
        }
        this.eIG = anVar.adm();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.hPY;
    }

    public com.baidu.tieba.pb.data.d bVD() {
        if (this.hPY == null) {
            return this.hPY;
        }
        if (!bVE() && this.hQL != null) {
            this.hPY.b(this.hQL);
        }
        return this.hPY;
    }

    private boolean bVE() {
        return (this.hPY.bSM() == null || this.hPY.bSM().cpd() == null || this.hPY.bSM().cpd().goods != null || this.hPY.bSM().cpd().goods.goods_style == 1001) ? false : true;
    }

    public com.baidu.tbadk.core.data.an getPageData() {
        if (this.hPY == null) {
            return null;
        }
        return this.hPY.getPage();
    }

    public boolean bVF() {
        if (bWk() && this.hPY.getPage().adr() == 0) {
            oC(true);
            return true;
        }
        return false;
    }

    public void BN(String str) {
        if (!StringUtils.isNull(str)) {
            this.hPC = str;
            this.hPE = null;
            this.hPH = false;
            this.hPJ = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hPC == null) {
            return false;
        }
        cancelLoadData();
        if (this.eYu == null) {
            this.eYu = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.eYu.start();
        }
        boolean xV = xV(3);
        if (this.opType != null) {
            this.opType = null;
            this.hQf = null;
            this.opUrl = null;
            return xV;
        }
        return xV;
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
        if (this.hQB != null) {
            this.hQB.cancelLoadData();
        }
        if (this.hQC != null) {
            this.hQC.cancelLoadData();
        }
        bgq();
    }

    private void bgq() {
        if (this.eYu != null) {
            this.eYu.destory();
            this.eYu = null;
        }
    }

    public boolean auD() {
        return (this.hPE == null || this.hPE.equals("0") || this.hPE.length() == 0) ? LoadData() : bVK();
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
                this.hQB.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.hQB.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.hQC == null) {
                this.hQC = new GetSugMatchWordsModel(this.cWM.getPageContext());
            }
            this.hQC.b(aVar);
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
    public boolean xV(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        xW(i);
        final com.baidu.tieba.pb.data.d pbData = aj.bWF().getPbData();
        if (pbData != null && pbData.bSx() != null) {
            pbData.bSx().hg(0);
            this.hPJ = aj.bWF().bVw();
            this.hPH = aj.bWF().bWK();
            this.hPL = aj.bWF().bWL();
            this.hQG = aj.bWF().bWJ();
            this.hQH = aj.bWF().bWI();
            this.hQI = aj.bWF().bWH();
            this.hQD = this.hPH;
            if (this.hPH || this.isFromMark) {
                this.hQj = false;
            }
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.5
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.hQn) {
            a(bVP(), true, this.hPE, 3);
        }
        if (i == 3 && !this.hQn) {
            if (this.isFromMark) {
                a(bVP(), true, this.hPE, 3);
            } else {
                a(bVP(), false, this.hPE, 3);
            }
        }
        this.hQn = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setIsReqAd(this.hQL == null ? 1 : 0);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.crd);
        if (this.hPH || this.isFromMark) {
            this.hQj = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.hPC == null || this.hPC.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.hPC, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.as.ajo().ajq() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.hPJ) {
            pbPageRequestMessage.set_r(1);
        }
        pbPageRequestMessage.set_r(Integer.valueOf(this.mSortType));
        if (this.hPH) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.hPW) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.hPV));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.hQj) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.f(this.hQf, 0));
            pbPageRequestMessage.setOpMessageID(this.hPV);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> bSz = this.hPY.bSz();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (this.mSortType == 1) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hPQ - 1));
                        if (this.hPQ - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z || this.hPT) {
                                if (bSz != null && bSz.size() > 0) {
                                    size = bSz.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = bSz.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.hPE = postData.getId();
                                            if (StringUtils.isNull(this.hPE)) {
                                                i3 = i2 + 1;
                                            } else if (this.mSortType == 2) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.hPP + 1));
                                            }
                                        }
                                        i2 = i3;
                                    }
                                    if (this.mSortType == 2) {
                                    }
                                }
                                if (this.hPE == null && this.hPE.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hPE, 0L));
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
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hPP + 1));
                        if (this.hPP >= this.eIG) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (bSz != null) {
                                size = bSz.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                                if (this.mSortType == 2) {
                                }
                            }
                            if (this.hPE == null) {
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
                if (bSz != null) {
                }
                if (this.hPE == null) {
                }
                if (this.mSortType == 1) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (bSz != null && bSz.size() > 0 && bSz.get(0) != null) {
                    this.hPE = bSz.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (bWk()) {
                        if (this.hPQ - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.hPQ - 1));
                        }
                    } else if (this.hPP < this.eIG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.hPP + 1));
                    }
                }
                if (this.hPE != null && this.hPE.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hPE, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.hPH) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (bWk()) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                    if (this.eIG > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eIG));
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hPE, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.hPO));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (this.mSortType == 1 && this.hQD && !this.hPH) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hPE, 0L));
                    if (this.mSortType == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (this.hPH) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.hQr);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.hQF, 0L));
                if (this.mSortType == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.hQD = this.hPH;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(bVP());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.hQE));
        pbPageRequestMessage.setIsSubPostDataReverse(this.hQq);
        pbPageRequestMessage.setFromSmartFrs(this.hQt ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.hPG);
        pbPageRequestMessage.setTag(this.unique_id);
        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.hPC);
        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean bTt() {
        switch (bWe()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().bSx() == null || !getPbData().bSx().afP();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bTu()) && com.baidu.tieba.recapp.r.chD().chx() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.chD().chx().ax(bTu(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.chD().chx().ay(bTu(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(bTu()) && com.baidu.tieba.recapp.r.chD().chx() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.chD().chx().ay(bTu(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.chD().chx().ax(bTu(), true));
        }
    }

    protected void xW(int i) {
        boolean z = false;
        yb(i);
        ArrayList<PostData> bSz = this.hPY.bSz();
        this.hQm = false;
        if (i == 1) {
            boolean z2 = false;
            while (bSz.size() + 30 > com.baidu.tbadk.data.d.ars()) {
                bSz.remove(0);
                z2 = true;
            }
            if (z2) {
                this.hPY.getPage().hd(1);
                if (this.hQe != null) {
                    this.hQe.e(this.hPY);
                }
            }
            this.fLK = System.currentTimeMillis();
            this.hQm = true;
        } else if (i == 2) {
            while (bSz.size() + 30 > com.baidu.tbadk.data.d.ars()) {
                bSz.remove(bSz.size() - 1);
                z = true;
            }
            if (z) {
                this.hPY.getPage().hc(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.hQu = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            h(dVar2);
        }
        g(dVar2);
        if (this.hQL != null && this.hQL.aDQ()) {
            TiebaStatic.log(com.baidu.tieba.q.a.b("a005", "common_fill", true, 1));
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null && dVar.bSM() != null && dVar.bSM().cpd() != null && dVar.bSM().cpd().goods != null && dVar.bSM().aDQ() && dVar.bSM().cpd().goods.goods_style != 1001) {
            this.hQL = dVar.bSM();
        }
    }

    public com.baidu.tieba.tbadkCore.data.m bVG() {
        return this.hQL;
    }

    public void bVH() {
        this.hQL = null;
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
            if (this.hQc || this.hQa || this.hQb) {
                dVar = j(dVar);
            }
            i(dVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String k = k(dVar);
            for (int i = 0; i < dVar.bSz().size(); i++) {
                PostData postData = dVar.bSz().get(i);
                for (int i2 = 0; i2 < postData.cpm().size(); i2++) {
                    postData.cpm().get(i2).a(this.cWM.getPageContext(), k.equals(postData.cpm().get(i2).aex().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.m bSI = dVar.bSI();
            if (bSI != null && !com.baidu.tbadk.core.util.v.aa(bSI.hIB)) {
                for (PostData postData2 : bSI.hIB) {
                    for (int i3 = 0; i3 < postData2.cpm().size(); i3++) {
                        postData2.cpm().get(i3).a(this.cWM.getPageContext(), k.equals(postData2.cpm().get(i3).aex().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String k = k(dVar);
            com.baidu.tieba.pb.data.m bSI = dVar.bSI();
            if (bSI != null && !com.baidu.tbadk.core.util.v.aa(bSI.hIB)) {
                for (PostData postData : bSI.hIB.subList(i, bSI.hIB.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.cpm().size()) {
                            postData.cpm().get(i3).a(this.cWM.getPageContext(), k.equals(postData.cpm().get(i3).aex().getUserId()));
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
        bg bSx = dVar.bSx();
        bSx.hl(this.mIsGood);
        bSx.hk(this.hPM);
        if (this.hPN > 0) {
            bSx.ar(this.hPN);
            return dVar;
        }
        return dVar;
    }

    protected String k(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.bSx() != null && dVar.bSx().aex() != null) {
            str = dVar.bSx().aex().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData bVI() {
        if (this.hPY == null || this.hPY.bSx() == null || this.hPY.bSx().aex() == null) {
            return null;
        }
        return this.hPY.bSx().aex();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.hQs = z3;
        this.hPZ = i;
        if (this.eYu != null && !z3) {
            this.eYu.a(z2, z4, i2, str, i3, j, j2);
            this.eYu = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(bTu()) && com.baidu.tieba.recapp.r.chD().chx() != null) {
            com.baidu.tieba.recapp.r.chD().chx().g(bTu(), xX(bVR()), true);
        }
        if (dVar == null || (this.hPO == 1 && i == 5 && dVar.bSz() != null && dVar.bSz().size() < 1)) {
            if (this.hQe != null) {
                this.hPJ = this.hPI;
                if (i2 != 350006) {
                    this.mSortType = this.hPK;
                }
                this.hQe.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.hPI = this.hPJ;
            if (i != 8) {
                this.hPK = this.mSortType;
                this.mSortType = dVar.hHU;
            }
            if (dVar.hHT != null && dVar.hHT.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.cWM.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                dVar.hHT = new ArrayList();
                dVar.hHT.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.cWM.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                dVar.hHT.add(builder2.build(false));
                this.mSortType = this.hPK;
                dVar.hHU = this.mSortType;
            }
            this.hPW = false;
            if (dVar.getPage() != null && (this.mSortType != 2 || i != 8)) {
                b(dVar.getPage());
            }
            this.eIG = this.eIG < 1 ? 1 : this.eIG;
            ArrayList<PostData> bSz = this.hPY.bSz();
            switch (i) {
                case 1:
                    this.hPY.a(dVar.getPage(), 1);
                    d(dVar, bSz);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.bSz() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.bSz().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(bSz, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bSz(), com.baidu.tbadk.core.util.v.Z(dVar.bSz()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.bSz().remove(postData2);
                            i6 = size - 1;
                        }
                        bSz.addAll(0, dVar.bSz());
                    }
                    this.hPY.a(dVar.getPage(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (this.mSortType == 1 && dVar.getPage() != null) {
                        dVar.getPage().ha(dVar.getPage().adm());
                    }
                    l(dVar);
                    if (!z3 && this.mThreadType != 33 && bWk()) {
                        bVJ();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.aa(dVar.bSz()) && this.hPY != null && (!this.hPH || k(dVar).equals(dVar.bSz().get(0).aex().getUserId()))) {
                        if (this.hPY.getPage().adr() == 0) {
                            this.hPY.getPage().hc(1);
                        }
                        bWf();
                        this.hQG = dVar.bSz().get(0);
                        if (bWk()) {
                            if (this.hPY.bSz().size() - this.hQI >= 3) {
                                this.hQH = new PostData();
                                this.hQH.jfy = true;
                                this.hQH.setPostType(53);
                                this.hPY.bSz().add(this.hQH);
                            }
                            this.hPY.bSz().add(this.hQG);
                            i4 = this.hPY.bSz().size() - 1;
                        } else {
                            if (this.hQI - this.hQJ >= 3) {
                                this.hQH = new PostData();
                                this.hQH.jfy = false;
                                this.hQH.setPostType(53);
                                this.hPY.bSz().add(0, this.hQH);
                            }
                            this.hPY.bSz().add(0, this.hQG);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.aq.bc(com.baidu.tbadk.core.sharedPref.b.ahO().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.hQG.jfK = this.hPY.bSW();
                            com.baidu.tbadk.core.sharedPref.b.ahO().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
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
            if (this.hPY != null && this.hPY.bSx() != null) {
                PraiseData aej = this.hPY.bSx().aej();
                if (this.hQP != null && !aej.isPriaseDataValid()) {
                    this.hPY.bSx().a(this.hQP);
                } else {
                    this.hQP = this.hPY.bSx().aej();
                    this.hQP.setPostId(this.hPY.bSx().aeN());
                }
                if (dVar.getPage() != null && dVar.getPage().adp() == 1 && dVar.bSx() != null && dVar.bSx().aeI() != null && dVar.bSx().aeI().size() > 0) {
                    this.hPY.bSx().q(dVar.bSx().aeI());
                }
                this.hPY.bSx().hi(dVar.bSx().aeo());
                this.hPY.bSx().he(dVar.bSx().getAnchorLevel());
                this.hPY.bSx().hg(dVar.bSx().aef());
                if (this.mThreadType == 33) {
                    this.hPY.bSx().aex().setHadConcerned(dVar.bSx().aex().hadConcerned());
                }
                if (dVar != null && dVar.bSx() != null) {
                    this.hPY.bSx().hn(dVar.bSx().aeM());
                }
            }
            if (this.hPY != null && this.hPY.getUserData() != null && dVar.getUserData() != null) {
                this.hPY.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.hPY.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.getPage() != null && dVar.getPage().adp() == 1 && dVar.bSH() != null) {
                this.hPY.d(dVar.bSH());
            }
            if (this.hQs) {
                if (this.hPY.bSx() != null && this.hPY.bSx().aex() != null && this.hPY.bSz() != null && com.baidu.tbadk.core.util.v.c(this.hPY.bSz(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.hPY.bSz(), 0);
                    MetaData aex = this.hPY.bSx().aex();
                    if (postData3.aex() != null && postData3.aex().getGodUserData() != null) {
                        if (this.hQh != -1) {
                            aex.setFansNum(this.hQh);
                            postData3.aex().setFansNum(this.hQh);
                        }
                        if (this.hQi != -1) {
                            aex.getGodUserData().setIsLike(this.hQi == 1);
                            postData3.aex().getGodUserData().setIsLike(this.hQi == 1);
                            aex.getGodUserData().setIsFromNetWork(false);
                            postData3.aex().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.hPY.hHS = -1;
                this.hPY.hHR = -1;
            }
            if (this.hQe != null) {
                this.hQe.a(true, getErrorCode(), i, i5, this.hPY, this.mErrorString, 1);
            }
        }
        if (this.hPY != null && this.hPY.bSx() != null && this.hPY.getForum() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.cWM.getPageContext();
            historyMessage.threadId = getPbData().bSx().getId();
            if (this.mIsShareThread && getPbData().bSx().bLQ != null) {
                historyMessage.threadName = getPbData().bSx().bLQ.showText;
            } else {
                historyMessage.threadName = getPbData().bSx().getTitle();
            }
            if (this.mIsShareThread && !bTt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().getForum().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = bVw();
            historyMessage.threadType = getPbData().bSx().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void d(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String aw;
        if (arrayList != null && dVar.bSz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.bSz(), 0);
            if (postData != null && (aw = aw(arrayList)) != null && aw.equals(postData.getId())) {
                dVar.bSz().remove(postData);
            }
            arrayList.addAll(dVar.bSz());
        }
    }

    private int xX(int i) {
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
        dVar.BK(this.hPY.bSP());
        this.hPY = dVar;
        xU(dVar.getPage().adp());
    }

    private void bVJ() {
        if (this.hPY != null && this.hPY.bSz() != null && this.hPY.bSO() != null) {
            ArrayList<PostData> bSz = this.hPY.bSz();
            com.baidu.tieba.pb.data.a bSO = this.hPY.bSO();
            int bSu = bSO.bSu();
            if (bSu > 0) {
                if (bSu <= bSz.size()) {
                    bSz.add(bSu, bSO);
                } else {
                    bSz.add(bSO);
                }
            }
        }
    }

    public boolean bVK() {
        if (this.hPC == null || this.hPE == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return xV(4);
        }
        return xV(6);
    }

    public boolean oC(boolean z) {
        if (this.hPC == null || this.hPY == null) {
            return false;
        }
        if (z || this.hPY.getPage().adr() != 0) {
            return xV(1);
        }
        return false;
    }

    public boolean oD(boolean z) {
        if (this.hPC == null || this.hPY == null) {
            return false;
        }
        if ((z || this.hPY.getPage().ads() != 0) && this.hPY.bSz() != null && this.hPY.bSz().size() >= 1) {
            return xV(2);
        }
        return false;
    }

    public boolean BT(String str) {
        this.hPH = !this.hPH;
        this.hPE = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (xV(6)) {
            return true;
        }
        this.hPH = this.hPH ? false : true;
        return false;
    }

    public boolean u(boolean z, String str) {
        if (this.hPH == z) {
            return false;
        }
        this.hPH = z;
        this.hPE = str;
        if (this.mSortType == 2) {
            this.hPE = "";
        }
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("pb_onlyowner_click").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (xV(6)) {
            return true;
        }
        this.hPH = z ? false : true;
        return false;
    }

    public boolean xY(int i) {
        if (i == this.mSortType) {
            return false;
        }
        this.hPI = this.hPJ;
        this.hPK = this.mSortType;
        this.mSortType = i;
        this.hPJ = !this.hPJ;
        if (i == 2 && this.isFromMark) {
            this.hPE = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.hPJ = this.hPJ ? false : true;
            this.mSortType = this.hPK;
            return false;
        }
        return true;
    }

    public boolean bVL() {
        return bWk();
    }

    public int bVM() {
        return this.mSortType;
    }

    public boolean hasData() {
        return (this.hPY == null || this.hPY.getForum() == null || this.hPY.bSx() == null) ? false : true;
    }

    public boolean aaB() {
        if (this.hPY == null) {
            return false;
        }
        return this.hPY.aaB();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hPY == null || this.hPY.bSx() == null || this.hPY.getForum() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.hPY.bSx().afP()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.hPY.getForum().getId());
            writeData.setForumName(this.hPY.getForum().getName());
        }
        writeData.setFromForumId(this.mFromForumId);
        writeData.sourceFrom = String.valueOf(this.hQE);
        writeData.setThreadId(this.hPC);
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

    public MarkData xZ(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.hPY == null) {
            return null;
        }
        ArrayList<PostData> bSz = this.hPY.bSz();
        if (com.baidu.tbadk.core.util.v.aa(bSz)) {
            return null;
        }
        if (bSz.size() > 0 && i >= bSz.size()) {
            i = bSz.size() - 1;
        }
        return j(bSz.get(i));
    }

    public MarkData bVN() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hPC);
        markData.setPostId(this.hPY.aaA());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hPH);
        markData.setSequence(Boolean.valueOf(bWk()));
        markData.setId(this.hPC);
        return markData;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hPC);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.hPH);
        markData.setSequence(Boolean.valueOf(bWk()));
        markData.setId(this.hPC);
        markData.setFloor(postData.cpp());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.m) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.m) postData).isApp());
        }
        return markData;
    }

    public void bVO() {
        g.bVf().as(bVP(), this.isFromMark);
    }

    private String bVP() {
        String str = this.hPC;
        if (this.hPH) {
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

    public void oE(boolean z) {
        if (this.hPY != null) {
            this.hPY.dx(z);
        }
    }

    public void oF(boolean z) {
        this.hQj = z;
    }

    public boolean bVQ() {
        return this.hQj;
    }

    public void a(a aVar) {
        this.hQe = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asu() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean ast() {
        return auD();
    }

    public boolean BU(String str) {
        if (getPbData() == null || getPbData().bSx() == null || getPbData().bSx().aex() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().bSx().aex().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int bVR() {
        return this.mRequestType;
    }

    public void bVS() {
        String bVP = bVP();
        g.bVf().as(bVP, false);
        g.bVf().as(bVP, true);
    }

    public void bVT() {
        if ("personalize_page".equals(this.mStType)) {
            this.hQp = System.currentTimeMillis() / 1000;
        }
    }

    public void bVU() {
        if ("personalize_page".equals(this.mStType) && this.hPY != null && this.hQp != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c10754").bT("fid", this.hPY.getForumId()).bT("tid", this.hPC).bT("obj_duration", String.valueOf(currentTimeMillis - this.hQp)).bT("obj_param3", String.valueOf(currentTimeMillis)));
            this.hQp = 0L;
        }
    }

    public boolean bVV() {
        return this.hQs;
    }

    public int getErrorNo() {
        return this.hQu;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h bVW() {
        return this.hQw;
    }

    public m bVX() {
        return this.hQx;
    }

    public z bVY() {
        return this.hQy;
    }

    public CheckRealNameModel bVZ() {
        return this.dZq;
    }

    public AddExperiencedModel bWa() {
        return this.hQA;
    }

    public String bWb() {
        return this.hQo;
    }

    public void BV(String str) {
        this.hQo = str;
    }

    public boolean bWc() {
        return this.hQt;
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hPY != null && this.hPY.bSz() != null && this.hPY.bSz().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hPY.bSz().size();
                for (int i = 0; i < size; i++) {
                    if (this.hPY.bSz().get(i) != null && this.hPY.bSz().get(i).aex() != null && currentAccount.equals(this.hPY.bSz().get(i).aex().getUserId()) && this.hPY.bSz().get(i).aex().getPendantData() != null) {
                        this.hPY.bSz().get(i).aex().getPendantData().mv(lVar.acU());
                        this.hPY.bSz().get(i).aex().getPendantData().bh(lVar.arC());
                    }
                }
            }
        }
    }

    public String bWd() {
        return this.hQz;
    }

    public int bWe() {
        return this.hQE;
    }

    public void ya(int i) {
        this.hQE = i;
    }

    public void BW(String str) {
        if ((!this.hPH || BU(TbadkCoreApplication.getCurrentAccount())) && this.hPY.bSz() != null) {
            this.hPY.getPage().hc(1);
            if (this.hPY.getPage().adr() == 0) {
                this.hPY.getPage().hc(1);
            }
            this.hQF = str;
            xV(8);
        }
    }

    private void yb(int i) {
        if (i != 8) {
            this.hQF = "";
            if (this.hQG != null) {
                if (i == 1 && !this.hPJ && !com.baidu.tbadk.core.util.v.aa(getPbData().bSz())) {
                    getPbData().bSz().remove(this.hQG);
                    if (this.hQH != null) {
                        getPbData().bSz().remove(this.hQH);
                    }
                    getPbData().bSz().add(0, this.hQG);
                } else {
                    getPbData().bSz().remove(this.hQG);
                    if (this.hQH != null) {
                        getPbData().bSz().remove(this.hQH);
                    }
                }
            }
            this.hQH = null;
        }
    }

    public void bWf() {
        if (this.hPY != null && !com.baidu.tbadk.core.util.v.aa(this.hPY.bSz())) {
            if (this.hQH != null) {
                this.hPY.bSz().remove(this.hQH);
                this.hQH = null;
            }
            if (this.hQG != null) {
                this.hPY.bSz().remove(this.hQG);
                this.hQG = null;
            }
        }
    }

    public void ch(int i, int i2) {
        this.hQI = i;
        this.hQJ = i2;
    }

    public PostData bWg() {
        return this.hQG;
    }

    public PostData bWh() {
        return this.hQH;
    }

    public int bWi() {
        return this.hQI;
    }

    public String bWj() {
        return this.hQK;
    }

    public void BX(String str) {
        this.hQK = str;
    }

    private boolean bWk() {
        return this.mSortType == 0 || this.mSortType == 2;
    }

    public boolean bWl() {
        return this.hQE == 13 || this.hQE == 12;
    }
}
