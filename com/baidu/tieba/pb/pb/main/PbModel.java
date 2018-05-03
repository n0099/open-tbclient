package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
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
    private final CheckRealNameModel bQw;
    private BaseActivity bcJ;
    private com.baidu.tieba.tbadkCore.d.b cIx;
    private int cuG;
    private long dmI;
    private boolean eEx;
    private boolean eoI;
    protected String fjS;
    private String fjT;
    private String fjU;
    private boolean fjV;
    private boolean fjW;
    private boolean fjX;
    private boolean fjY;
    private boolean fjZ;
    private String fkA;
    private long fkB;
    private boolean fkC;
    private int fkD;
    private boolean fkE;
    private boolean fkF;
    private int fkG;
    private final w fkH;
    private final h fkI;
    private final m fkJ;
    private final q fkK;
    private final y fkL;
    private String fkM;
    private final AddExperiencedModel fkN;
    private SuggestEmotionModel fkO;
    private GetSugMatchWordsModel fkP;
    private boolean fkQ;
    private int fkR;
    private String fkS;
    private PostData fkT;
    private PostData fkU;
    private int fkV;
    private int fkW;
    private String fkX;
    private CustomMessageListener fkY;
    private CustomMessageListener fkZ;
    private int fka;
    private long fkb;
    private int fkc;
    private int fkd;
    private int fke;
    private boolean fkf;
    private boolean fkg;
    private long fkh;
    private boolean fki;
    private String fkj;
    protected com.baidu.tieba.pb.data.d fkk;
    private int fkl;
    private boolean fkm;
    private boolean fkn;
    private boolean fko;
    private boolean fkp;
    private a fkq;
    private String fkr;
    private String fks;
    private int fkt;
    private int fku;
    private boolean fkv;
    private boolean fkw;
    private boolean fkx;
    private boolean fky;
    private boolean fkz;
    private com.baidu.adp.framework.listener.a fla;
    private PraiseData flb;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.c mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private int mIsGood;
    private boolean mIsShareThread;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int fjR = com.baidu.tbadk.data.d.Dc() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.d dVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.d dVar);
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.fjS = null;
        this.fjT = null;
        this.fjU = null;
        this.mForumId = null;
        this.fjV = false;
        this.fjW = false;
        this.fjX = true;
        this.fjY = true;
        this.fjZ = false;
        this.mIsGood = 0;
        this.fka = 0;
        this.fkb = 0L;
        this.fkc = 1;
        this.fkd = 1;
        this.fke = 1;
        this.cuG = 1;
        this.isAd = false;
        this.eoI = false;
        this.fkf = false;
        this.eEx = false;
        this.isFromMark = false;
        this.fkg = false;
        this.fkh = 0L;
        this.fki = false;
        this.fkj = null;
        this.fkk = null;
        this.isLoading = false;
        this.fkm = false;
        this.fkn = false;
        this.fko = false;
        this.fkp = false;
        this.mLocate = null;
        this.mContext = null;
        this.fkq = null;
        this.opType = null;
        this.opUrl = null;
        this.fkr = null;
        this.fks = null;
        this.fkt = -1;
        this.fku = -1;
        this.cIx = null;
        this.fkw = false;
        this.fkx = false;
        this.postID = null;
        this.fkA = null;
        this.fkB = 0L;
        this.fkC = false;
        this.fkD = -1;
        this.fkF = false;
        this.fkQ = false;
        this.fkR = 0;
        this.fkY = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fkz = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aVs() != null) {
                        pbData.aVs().bM(0);
                    }
                    if (PbModel.this.fkq != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fkq.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.fkZ = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aVq() != null && PbModel.this.getPbData().aVq().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aVq().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.fla = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.gP()) {
                        PbModel.this.bcJ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.fkw || !PbModel.this.fkx) {
                        if (!PbModel.this.fkw) {
                            PbModel.this.fkw = true;
                        } else {
                            PbModel.this.fkx = true;
                        }
                        if (PbModel.this.fkq != null) {
                            PbModel.this.fkq.a(PbModel.this.aYg(), z, responsedMessage, PbModel.this.fky, System.currentTimeMillis() - PbModel.this.dmI);
                        }
                    }
                }
            }
        };
        this.flb = null;
        registerListener(this.fkY);
        registerListener(this.fla);
        registerListener(this.fkZ);
        this.fkk = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bcJ = baseActivity;
        this.fkH = new w(this, this.bcJ);
        this.fkI = new h(this, this.bcJ);
        this.fkJ = new m(this, this.bcJ);
        this.fkK = new q(this, getUniqueId());
        this.fkL = new y(this, this.bcJ);
        this.bQw = new CheckRealNameModel(this.bcJ.getPageContext());
        this.fkO = new SuggestEmotionModel();
        this.fkN = new AddExperiencedModel(this.bcJ.getPageContext());
    }

    protected int aYg() {
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
        this.fjS = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fjS)) {
            this.fjS = this.fkH.U(intent);
            if (StringUtils.isNull(this.fjS) && intent.getData() != null) {
                this.fjS = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fkR = intent.getIntExtra("key_start_from", 0);
        if (this.fkR == 0) {
            this.fkR = this.fkH.flh;
        }
        this.fjU = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fjT = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fjV = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fjW = intent.getBooleanExtra("host_only", false);
        this.fjY = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fka = intent.getIntExtra("is_top", 0);
        this.fkb = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fkg = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eoI = intent.getBooleanExtra("is_sub_pb", false);
        this.fki = intent.getBooleanExtra("is_pv", false);
        this.fkh = intent.getLongExtra("msg_id", 0L);
        this.fkj = intent.getStringExtra("from_forum_name");
        this.fks = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fkr = intent.getStringExtra("op_stat");
        this.fkm = intent.getBooleanExtra("is_from_thread_config", false);
        this.fkn = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fko = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fku = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fkt = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fkf = intent.getBooleanExtra("from_frs", false);
        this.eEx = intent.getBooleanExtra("from_maintab", false);
        this.fkF = intent.getBooleanExtra("from_smart_frs", false);
        this.fkp = intent.getBooleanExtra("from_hottopic", false);
        this.fkM = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fkR = bundle.getInt("key_start_from", 0);
        this.fjS = bundle.getString("thread_id");
        this.fjU = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fjT = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fjV = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fjW = bundle.getBoolean("host_only", false);
        this.fjY = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fka = bundle.getInt("is_top", 0);
        this.fkb = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fkg = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eoI = bundle.getBoolean("is_sub_pb", false);
        this.fki = bundle.getBoolean("is_pv", false);
        this.fkh = bundle.getLong("msg_id", 0L);
        this.fkj = bundle.getString("from_forum_name");
        this.fks = bundle.getString("extra_pb_cache_key");
        this.fkm = bundle.getBoolean("is_from_thread_config", false);
        this.fkn = bundle.getBoolean("is_from_interview_live_config", false);
        this.fko = bundle.getBoolean("is_from_my_god_config", false);
        this.fku = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fkt = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fkf = bundle.getBoolean("from_frs", false);
        this.eEx = bundle.getBoolean("from_maintab", false);
        this.fkF = bundle.getBoolean("from_smart_frs", false);
        this.fkp = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void y(Bundle bundle) {
        bundle.putString("thread_id", this.fjS);
        bundle.putString("post_id", this.fjU);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fkR);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fjV);
        bundle.putBoolean("host_only", this.fjW);
        bundle.putBoolean("squence", this.fjY);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fka);
        bundle.putLong("thread_time", this.fkb);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fkg);
        bundle.putBoolean("is_sub_pb", this.eoI);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fki);
        bundle.putLong("msg_id", this.fkh);
        bundle.putString("extra_pb_cache_key", this.fks);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fkm);
        bundle.putBoolean("is_from_interview_live_config", this.fkn);
        bundle.putBoolean("is_from_my_god_config", this.fko);
        bundle.putInt("extra_pb_is_attention_key", this.fku);
        bundle.putInt("extra_pb_funs_count_key", this.fkt);
        bundle.putBoolean("from_frs", this.fkf);
        bundle.putBoolean("from_maintab", this.eEx);
        bundle.putBoolean("from_smart_frs", this.fkF);
        bundle.putBoolean("from_hottopic", this.fkp);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aYh() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fjS);
        if (!this.fkg) {
            sb.append(this.fjU);
        }
        sb.append(this.fjW);
        sb.append(this.fjY);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fka);
        sb.append(this.fkb);
        sb.append(this.fkf);
        sb.append(this.eEx);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eoI);
        sb.append(this.fki);
        sb.append(this.fkh);
        sb.append(this.fkj);
        sb.append(this.mThreadType);
        sb.append(this.fkm);
        sb.append(this.fkn);
        sb.append(this.fko);
        if (this.fks != null) {
            sb.append(this.fks);
        }
        return sb.toString();
    }

    public String aYi() {
        return this.fkj;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fjU;
    }

    public String aYj() {
        return this.fjS;
    }

    public boolean getHostMode() {
        return this.fjW;
    }

    public boolean aYk() {
        return this.fjY;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aYl() {
        return this.fkf;
    }

    public boolean aYm() {
        return this.fjZ;
    }

    public boolean aYn() {
        return this.eEx;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aYo() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aYp() {
        return this.fka;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iY(int i) {
        this.fka = i;
    }

    public boolean aYq() {
        return this.eoI;
    }

    public boolean aYr() {
        if (this.fkk == null) {
            return false;
        }
        return this.fkk.isValid();
    }

    public String rZ() {
        if (this.fkk == null || !this.fkk.oI()) {
            return null;
        }
        return this.fkk.oH();
    }

    public boolean qn(int i) {
        this.fkc = i;
        if (this.fkc > this.fkk.rg().qX()) {
            this.fkc = this.fkk.rg().qX();
        }
        if (this.fkc < 1) {
            this.fkc = 1;
        }
        if (this.fjS == null) {
            return false;
        }
        return qp(5);
    }

    public void qo(int i) {
        this.fkc = i;
        this.fkd = i;
        this.fke = i;
    }

    public void c(com.baidu.tbadk.core.data.am amVar) {
        if (amVar == null) {
            qo(1);
            return;
        }
        this.fkd = amVar.ra();
        this.fke = amVar.ra();
        this.cuG = amVar.qX();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fkk;
    }

    public com.baidu.tbadk.core.data.am azo() {
        if (this.fkk == null) {
            return null;
        }
        return this.fkk.rg();
    }

    public boolean aYs() {
        if (this.fjY && this.fkk.rg().rc() == 0) {
            jM(true);
            return true;
        }
        return false;
    }

    public void qr(String str) {
        if (!StringUtils.isNull(str)) {
            this.fjS = str;
            this.fjU = null;
            this.fjW = false;
            this.fjY = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fjS == null) {
            return false;
        }
        cancelLoadData();
        if (this.cIx == null) {
            this.cIx = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cIx.start();
        }
        boolean qp = qp(3);
        if (this.opType != null) {
            this.opType = null;
            this.fkr = null;
            this.opUrl = null;
            return qp;
        }
        return qp;
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
        if (this.fkO != null) {
            this.fkO.cancelLoadData();
        }
        if (this.fkK != null) {
            this.fkK.cancelLoadData();
        }
        if (this.fkP != null) {
            this.fkP.cancelLoadData();
        }
        alh();
    }

    private void alh() {
        if (this.cIx != null) {
            this.cIx.destory();
            this.cIx = null;
        }
    }

    public boolean FY() {
        return (this.fjU == null || this.fjU.equals("0") || this.fjU.length() == 0) ? LoadData() : aYv();
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
                this.fkO.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fkO.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fkP == null) {
                this.fkP = new GetSugMatchWordsModel(this.bcJ.getPageContext());
            }
            this.fkP.b(aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d9 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e8 A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x031e A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x033a A[Catch: Exception -> 0x0216, TryCatch #0 {Exception -> 0x0216, blocks: (B:32:0x00bc, B:34:0x00c0, B:39:0x00d8, B:41:0x0128, B:43:0x0145, B:44:0x014d, B:46:0x0151, B:47:0x0159, B:49:0x015d, B:50:0x0162, B:52:0x0166, B:53:0x016b, B:55:0x016f, B:56:0x017f, B:58:0x0183, B:59:0x018b, B:61:0x018f, B:62:0x01a8, B:63:0x01b7, B:64:0x01ba, B:67:0x01e6, B:69:0x01f9, B:74:0x0220, B:76:0x0236, B:78:0x023c, B:80:0x0243, B:81:0x0250, B:83:0x0264, B:85:0x0268, B:87:0x026e, B:94:0x0295, B:96:0x029b, B:88:0x0279, B:90:0x027d, B:92:0x0285, B:93:0x0290, B:97:0x02a7, B:99:0x02bb, B:101:0x02bf, B:104:0x02d1, B:128:0x0331, B:108:0x02d9, B:110:0x02df, B:111:0x02e4, B:113:0x02e8, B:115:0x02f2, B:120:0x0309, B:122:0x0317, B:123:0x031a, B:125:0x031e, B:127:0x0326, B:129:0x0336, B:131:0x033a, B:117:0x02f6, B:132:0x0343, B:133:0x0371, B:135:0x0375, B:145:0x03a4, B:138:0x0381, B:140:0x038d, B:141:0x0395, B:143:0x0399, B:144:0x039f, B:146:0x03ad, B:137:0x0379, B:147:0x03b6, B:149:0x03c2, B:151:0x03c6, B:153:0x03ca, B:154:0x03cf, B:156:0x03db, B:157:0x03e3, B:159:0x03f4, B:158:0x03e8, B:160:0x03fd, B:162:0x040c, B:36:0x00c8), top: B:166:0x00bc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean qp(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qq(i);
        final com.baidu.tieba.pb.data.d pbData = ai.aZr().getPbData();
        if (pbData != null && pbData.aVs() != null) {
            pbData.aVs().bM(0);
            this.fjY = ai.aZr().aYk();
            this.fjW = ai.aZr().aZw();
            this.fjZ = ai.aZr().aZx();
            this.fkT = ai.aZr().aZv();
            this.fkU = ai.aZr().aZu();
            this.fkV = ai.aZr().aZt();
            this.fkQ = this.fjW;
            if (this.fjW || this.isFromMark) {
                this.fkv = false;
            }
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.fkz) {
            a(aYA(), true, this.fjU, 3);
        }
        if (i == 3 && !this.fkz) {
            if (this.isFromMark) {
                a(aYA(), true, this.fjU, 3);
            } else {
                a(aYA(), false, this.fjU, 3);
            }
        }
        this.fkz = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBR);
        if (this.fjW || this.isFromMark) {
            this.fkv = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fjS == null || this.fjS.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fjS, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i4 = com.baidu.tbadk.core.util.ap.vQ().vS() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i4));
        if (!this.fjY) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fjW) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fki) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fkh));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fkv) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fkr, 0));
            pbPageRequestMessage.setOpMessageID(this.fkh);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aVu = this.fkk.aVu();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fjY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fke - 1));
                        if (this.fke - 1 <= 0) {
                            z = true;
                            if (!this.isFromMark || z) {
                                if (aVu != null && aVu.size() > 0) {
                                    size = aVu.size();
                                    i2 = 1;
                                    while (size - i2 >= 0) {
                                        PostData postData = aVu.get(size - i2);
                                        if (postData == null) {
                                            i3 = i2 + 1;
                                        } else {
                                            this.fjU = postData.getId();
                                            if (StringUtils.isNull(this.fjU)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fjU == null && this.fjU.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjU, 0L));
                                } else if (!this.fjY) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fkd + 1));
                        if (this.fkd >= this.cuG) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (aVu != null) {
                                size = aVu.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fjU == null) {
                            }
                            if (!this.fjY) {
                            }
                            b(pbPageRequestMessage);
                        }
                    }
                }
                z = false;
                if (!this.isFromMark) {
                }
                if (aVu != null) {
                }
                if (this.fjU == null) {
                }
                if (!this.fjY) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (aVu != null && aVu.size() > 0 && aVu.get(0) != null) {
                    this.fjU = aVu.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fjY) {
                        if (this.fke - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fke - 1));
                        }
                    } else if (this.fkd < this.cuG) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fkd + 1));
                    }
                }
                if (this.fjU != null && this.fjU.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjU, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fjW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fjY) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjU, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fkc));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fjY && this.fkQ && !this.fjW) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjU, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fjW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fkD);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fkS, 0L));
                if (!this.fjY) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fkQ = this.fjW;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aYA());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fkR));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fkC);
        pbPageRequestMessage.setFromSmartFrs(this.fkF ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fjV);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    public boolean aXy() {
        switch (aYP()) {
            case 3:
                return true;
            default:
                return getPbData() == null || getPbData().aVs() == null || !getPbData().aVs().sY();
        }
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjl().bjf().Q(aYi(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjl().bjf().R(aYi(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjl().bjf().R(aYi(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjl().bjf().Q(aYi(), true));
        }
    }

    protected void qq(int i) {
        boolean z = false;
        qu(i);
        ArrayList<PostData> aVu = this.fkk.aVu();
        this.fky = false;
        if (i == 1) {
            boolean z2 = false;
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Dc()) {
                aVu.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fkk.rg().bI(1);
                if (this.fkq != null) {
                    this.fkq.f(this.fkk);
                }
            }
            this.dmI = System.currentTimeMillis();
            this.fky = true;
        } else if (i == 2) {
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Dc()) {
                aVu.remove(aVu.size() - 1);
                z = true;
            }
            if (z) {
                this.fkk.rg().bH(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fkG = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fjT)) {
            try {
                Long valueOf = Long.valueOf(this.fjT);
                com.baidu.tieba.pb.data.l aVD = dVar.aVD();
                if (aVD != null && aVD.fcV != null) {
                    if (aVD.fcV.isEmpty() || !aVD.fcV.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fjS);
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
            if (this.fko || this.fkm || this.fkn) {
                dVar = k(dVar);
            }
            j(dVar);
        }
    }

    protected void j(com.baidu.tieba.pb.data.d dVar) {
        if (dVar != null) {
            String l = l(dVar);
            for (int i = 0; i < dVar.aVu().size(); i++) {
                PostData postData = dVar.aVu().get(i);
                for (int i2 = 0; i2 < postData.brW().size(); i2++) {
                    postData.brW().get(i2).b(this.bcJ.getPageContext(), l.equals(postData.brW().get(i2).rQ().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.l aVD = dVar.aVD();
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.fcU)) {
                for (PostData postData2 : aVD.fcU) {
                    for (int i3 = 0; i3 < postData2.brW().size(); i3++) {
                        postData2.brW().get(i3).b(this.bcJ.getPageContext(), l.equals(postData2.brW().get(i3).rQ().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i) {
        if (dVar != null) {
            String l = l(dVar);
            com.baidu.tieba.pb.data.l aVD = dVar.aVD();
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.fcU)) {
                for (PostData postData : aVD.fcU.subList(i, aVD.fcU.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.brW().size()) {
                            postData.brW().get(i3).b(this.bcJ.getPageContext(), l.equals(postData.brW().get(i3).rQ().getUserId()));
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
        bd aVs = dVar.aVs();
        aVs.bQ(this.mIsGood);
        aVs.bP(this.fka);
        if (this.fkb > 0) {
            aVs.n(this.fkb);
            return dVar;
        }
        return dVar;
    }

    protected String l(com.baidu.tieba.pb.data.d dVar) {
        String str = null;
        if (dVar == null) {
            return null;
        }
        if (dVar.aVs() != null && dVar.aVs().rQ() != null) {
            str = dVar.aVs().rQ().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aYt() {
        if (this.fkk == null || this.fkk.aVs() == null || this.fkk.aVs().rQ() == null) {
            return null;
        }
        return this.fkk.aVs().rQ();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fkE = z3;
        this.fkl = i;
        if (this.cIx != null && !z3) {
            this.cIx.a(z2, z4, i2, str, i3, j, j2);
            this.cIx = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            com.baidu.tieba.recapp.r.bjl().bjf().f(aYi(), qr(getRequestType()), true);
        }
        if (dVar == null || (this.fkc == 1 && i == 5 && dVar.aVu() != null && dVar.aVu().size() < 1)) {
            if (this.fkq != null) {
                this.fjY = this.fjX;
                this.fkq.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fjX = this.fjY;
            this.fki = false;
            if (dVar.rg() != null) {
                c(dVar.rg());
            }
            this.cuG = this.cuG < 1 ? 1 : this.cuG;
            ArrayList<PostData> aVu = this.fkk.aVu();
            switch (i) {
                case 1:
                    this.fkk.a(dVar.rg(), 1);
                    e(dVar, aVu);
                    i5 = 0;
                    break;
                case 2:
                    if (dVar.aVu() == null) {
                        i6 = 0;
                    } else {
                        int size = dVar.aVu().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aVu, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), com.baidu.tbadk.core.util.v.v(dVar.aVu()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i6 = size;
                        } else {
                            dVar.aVu().remove(postData2);
                            i6 = size - 1;
                        }
                        aVu.addAll(0, dVar.aVu());
                    }
                    this.fkk.a(dVar.rg(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fjY && dVar.rg() != null) {
                        dVar.rg().bF(dVar.rg().qX());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fjY) {
                        aYu();
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.w(dVar.aVu()) && this.fkk != null && (!this.fjW || l(dVar).equals(dVar.aVu().get(0).rQ().getUserId()))) {
                        if (this.fkk.rg().rc() == 0) {
                            this.fkk.rg().bH(1);
                        }
                        aYQ();
                        this.fkT = dVar.aVu().get(0);
                        if (this.fjY) {
                            if (this.fkk.aVu().size() - this.fkV >= 3) {
                                this.fkU = new PostData();
                                this.fkU.gwQ = true;
                                this.fkU.setPostType(53);
                                this.fkk.aVu().add(this.fkU);
                            }
                            this.fkk.aVu().add(this.fkT);
                            i4 = this.fkk.aVu().size() - 1;
                        } else {
                            if (this.fkV - this.fkW >= 3) {
                                this.fkU = new PostData();
                                this.fkU.gwQ = false;
                                this.fkU.setPostType(53);
                                this.fkk.aVu().add(0, this.fkU);
                            }
                            this.fkk.aVu().add(0, this.fkT);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.an.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fkT.gxd = this.fkk.aVR();
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
            if (this.fkk != null && this.fkk.aVs() != null) {
                PraiseData rF = this.fkk.aVs().rF();
                if (this.flb != null && !rF.isPriaseDataValid()) {
                    this.fkk.aVs().a(this.flb);
                } else {
                    this.flb = this.fkk.aVs().rF();
                    this.flb.setPostId(this.fkk.aVs().sg());
                }
                if (dVar.rg() != null && dVar.rg().ra() == 1 && dVar.aVs() != null && dVar.aVs().sb() != null && dVar.aVs().sb().size() > 0) {
                    this.fkk.aVs().h(dVar.aVs().sb());
                }
                this.fkk.aVs().bN(dVar.aVs().rI());
                this.fkk.aVs().bK(dVar.aVs().getAnchorLevel());
                this.fkk.aVs().bM(dVar.aVs().rC());
                if (this.mThreadType == 33) {
                    this.fkk.aVs().rQ().setHadConcerned(dVar.aVs().rQ().hadConcerned());
                }
                if (dVar != null && dVar.aVs() != null) {
                    this.fkk.aVs().bS(dVar.aVs().sf());
                }
            }
            if (this.fkk != null && this.fkk.getUserData() != null && dVar.getUserData() != null) {
                this.fkk.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fkk.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.rg() != null && dVar.rg().ra() == 1 && dVar.aVC() != null) {
                this.fkk.c(dVar.aVC());
            }
            if (this.fkE) {
                if (this.fkk.aVs() != null && this.fkk.aVs().rQ() != null && this.fkk.aVu() != null && com.baidu.tbadk.core.util.v.c(this.fkk.aVu(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.fkk.aVu(), 0);
                    MetaData rQ = this.fkk.aVs().rQ();
                    if (postData3.rQ() != null && postData3.rQ().getGodUserData() != null) {
                        if (this.fkt != -1) {
                            rQ.setFansNum(this.fkt);
                            postData3.rQ().setFansNum(this.fkt);
                        }
                        if (this.fku != -1) {
                            rQ.getGodUserData().setIsLike(this.fku == 1);
                            postData3.rQ().getGodUserData().setIsLike(this.fku == 1);
                            rQ.getGodUserData().setIsFromNetWork(false);
                            postData3.rQ().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fkk.fcq = -1;
                this.fkk.fcp = -1;
            }
            if (this.fkq != null) {
                this.fkq.a(true, getErrorCode(), i, i5, this.fkk, this.mErrorString, 1);
            }
        }
        if (this.fkk != null && this.fkk.aVs() != null && this.fkk.aVq() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bcJ;
            historyMessage.threadId = getPbData().aVs().getId();
            if (this.mIsShareThread && getPbData().aVs().abL != null) {
                historyMessage.threadName = getPbData().aVs().abL.showText;
            } else {
                historyMessage.threadName = getPbData().aVs().getTitle();
            }
            if (this.mIsShareThread && !aXy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = getPbData().aVq().getName();
            }
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aYk();
            historyMessage.threadType = getPbData().aVs().getThreadType();
            historyMessage.isShareThread = this.mIsShareThread;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.d dVar, ArrayList<PostData> arrayList) {
        String an;
        if (arrayList != null && dVar.aVu() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), 0);
            if (postData != null && (an = an(arrayList)) != null && an.equals(postData.getId())) {
                dVar.aVu().remove(postData);
            }
            arrayList.addAll(dVar.aVu());
        }
    }

    private int qr(int i) {
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

    private String an(ArrayList<PostData> arrayList) {
        int v = com.baidu.tbadk.core.util.v.v(arrayList);
        if (v <= 0) {
            return null;
        }
        for (int i = v - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tieba.pb.data.d dVar) {
        dVar.qq(this.fkk.aVJ());
        this.fkk = dVar;
        qo(dVar.rg().ra());
    }

    private void aYu() {
        if (this.fkk != null && this.fkk.aVu() != null && this.fkk.aVI() != null) {
            ArrayList<PostData> aVu = this.fkk.aVu();
            com.baidu.tieba.pb.data.a aVI = this.fkk.aVI();
            int aVo = aVI.aVo();
            if (aVo > 0) {
                if (aVo <= aVu.size()) {
                    aVu.add(aVo, aVI);
                } else {
                    aVu.add(aVI);
                }
            }
        }
    }

    public boolean aYv() {
        if (this.fjS == null || this.fjU == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qp(4);
        }
        return qp(6);
    }

    public boolean jM(boolean z) {
        if (this.fjS == null || this.fkk == null) {
            return false;
        }
        if (z || this.fkk.rg().rc() != 0) {
            return qp(1);
        }
        return false;
    }

    public boolean jN(boolean z) {
        if (this.fjS == null || this.fkk == null) {
            return false;
        }
        if ((z || this.fkk.rg().rd() != 0) && this.fkk.aVu() != null && this.fkk.aVu().size() >= 1) {
            return qp(2);
        }
        return false;
    }

    public boolean qw(String str) {
        this.fjW = !this.fjW;
        this.fjU = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qp(6)) {
            return true;
        }
        this.fjW = this.fjW ? false : true;
        return false;
    }

    public boolean l(boolean z, String str) {
        if (this.fjW == z) {
            return false;
        }
        this.fjW = z;
        this.fjU = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qp(6)) {
            return true;
        }
        this.fjW = z ? false : true;
        return false;
    }

    public boolean aYw() {
        this.fjX = this.fjY;
        this.fjY = !this.fjY;
        if (this.isLoading || !LoadData()) {
            this.fjY = this.fjY ? false : true;
            return false;
        }
        return true;
    }

    public boolean aYx() {
        return this.fjY;
    }

    public boolean hasData() {
        return (this.fkk == null || this.fkk.aVq() == null || this.fkk.aVs() == null) ? false : true;
    }

    public boolean oI() {
        if (this.fkk == null) {
            return false;
        }
        return this.fkk.oI();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fkk == null || this.fkk.aVs() == null || this.fkk.aVq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fkk.aVs().sY()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fkk.aVq().getId());
            writeData.setForumName(this.fkk.aVq().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fkR);
        writeData.setThreadId(this.fjS);
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

    public MarkData qs(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fkk == null) {
            return null;
        }
        ArrayList<PostData> aVu = this.fkk.aVu();
        if (com.baidu.tbadk.core.util.v.w(aVu)) {
            return null;
        }
        if (aVu.size() > 0 && i >= aVu.size()) {
            i = aVu.size() - 1;
        }
        return g(aVu.get(i));
    }

    public MarkData aYy() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fjS);
        markData.setPostId(this.fkk.oH());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fjW);
        markData.setSequence(Boolean.valueOf(this.fjY));
        markData.setId(this.fjS);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fjS);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fjW);
        markData.setSequence(Boolean.valueOf(this.fjY));
        markData.setId(this.fjS);
        markData.setFloor(postData.brZ());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.b) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aYz() {
        g.aXS().J(aYA(), this.isFromMark);
    }

    private String aYA() {
        String str = this.fjS;
        if (this.fjW) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fjY) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jO(boolean z) {
        if (this.fkk != null) {
            this.fkk.ae(z);
        }
    }

    public void jP(boolean z) {
        this.fkv = z;
    }

    public boolean aYB() {
        return this.fkv;
    }

    public void a(a aVar) {
        this.fkq = aVar;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ea() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DZ() {
        return FY();
    }

    public boolean qx(String str) {
        if (getPbData() == null || getPbData().aVs() == null || getPbData().aVs().rQ() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aVs().rQ().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void aYC() {
        String aYA = aYA();
        g.aXS().J(aYA, false);
        g.aXS().J(aYA, true);
    }

    public void aYD() {
        if ("personalize_page".equals(this.mStType)) {
            this.fkB = System.currentTimeMillis() / 1000;
        }
    }

    public void aYE() {
        if ("personalize_page".equals(this.mStType) && this.fkk != null && this.fkB != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10754").ac(ImageViewerConfig.FORUM_ID, this.fkk.getForumId()).ac("tid", this.fjS).ac("obj_duration", String.valueOf(currentTimeMillis - this.fkB)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.fkB = 0L;
        }
    }

    public boolean aYF() {
        return this.fkE;
    }

    public int getErrorNo() {
        return this.fkG;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h aYG() {
        return this.fkI;
    }

    public m aYH() {
        return this.fkJ;
    }

    public q aYI() {
        return this.fkK;
    }

    public y aYJ() {
        return this.fkL;
    }

    public CheckRealNameModel aYK() {
        return this.bQw;
    }

    public AddExperiencedModel aYL() {
        return this.fkN;
    }

    public String aYM() {
        return this.fkA;
    }

    public void qy(String str) {
        this.fkA = str;
    }

    public boolean aYN() {
        return this.fkF;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fkk != null && this.fkk.aVu() != null && this.fkk.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fkk.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.fkk.aVu().get(i) != null && this.fkk.aVu().get(i).rQ() != null && currentAccount.equals(this.fkk.aVu().get(i).rQ().getUserId()) && this.fkk.aVu().get(i).rQ().getPendantData() != null) {
                        this.fkk.aVu().get(i).rQ().getPendantData().cL(hVar.qG());
                        this.fkk.aVu().get(i).rQ().getPendantData().T(hVar.Dk());
                    }
                }
            }
        }
    }

    public String aYO() {
        return this.fkM;
    }

    public int aYP() {
        return this.fkR;
    }

    public void qt(int i) {
        this.fkR = i;
    }

    public void qz(String str) {
        if ((!this.fjW || qx(TbadkCoreApplication.getCurrentAccount())) && this.fkk.aVu() != null) {
            this.fkk.rg().bH(1);
            if (this.fkk.rg().rc() == 0) {
                this.fkk.rg().bH(1);
            }
            this.fkS = str;
            qp(8);
        }
    }

    private void qu(int i) {
        if (i != 8) {
            this.fkS = "";
            if (this.fkT != null) {
                if (i == 1 && !this.fjY && !com.baidu.tbadk.core.util.v.w(getPbData().aVu())) {
                    getPbData().aVu().remove(this.fkT);
                    if (this.fkU != null) {
                        getPbData().aVu().remove(this.fkU);
                    }
                    getPbData().aVu().add(0, this.fkT);
                } else {
                    getPbData().aVu().remove(this.fkT);
                    if (this.fkU != null) {
                        getPbData().aVu().remove(this.fkU);
                    }
                }
            }
            this.fkU = null;
        }
    }

    public void aYQ() {
        if (this.fkk != null && !com.baidu.tbadk.core.util.v.w(this.fkk.aVu())) {
            if (this.fkU != null) {
                this.fkk.aVu().remove(this.fkU);
                this.fkU = null;
            }
            if (this.fkT != null) {
                this.fkk.aVu().remove(this.fkT);
                this.fkT = null;
            }
        }
    }

    public void bo(int i, int i2) {
        this.fkV = i;
        this.fkW = i2;
    }

    public PostData aYR() {
        return this.fkT;
    }

    public PostData aYS() {
        return this.fkU;
    }

    public int aYT() {
        return this.fkV;
    }

    public String aYU() {
        return this.fkX;
    }

    public void qA(String str) {
        this.fkX = str;
    }
}
