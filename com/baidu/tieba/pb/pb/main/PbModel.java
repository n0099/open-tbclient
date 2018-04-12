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
    private final CheckRealNameModel bQx;
    private BaseActivity bcJ;
    private com.baidu.tieba.tbadkCore.d.b cIA;
    private int cuJ;
    private long dmL;
    private boolean eEA;
    private boolean eoL;
    protected String fjV;
    private String fjW;
    private String fjX;
    private boolean fjY;
    private boolean fjZ;
    private boolean fkA;
    private boolean fkB;
    private boolean fkC;
    private String fkD;
    private long fkE;
    private boolean fkF;
    private int fkG;
    private boolean fkH;
    private boolean fkI;
    private int fkJ;
    private final w fkK;
    private final h fkL;
    private final m fkM;
    private final q fkN;
    private final y fkO;
    private String fkP;
    private final AddExperiencedModel fkQ;
    private SuggestEmotionModel fkR;
    private GetSugMatchWordsModel fkS;
    private boolean fkT;
    private int fkU;
    private String fkV;
    private PostData fkW;
    private PostData fkX;
    private int fkY;
    private int fkZ;
    private boolean fka;
    private boolean fkb;
    private boolean fkc;
    private int fkd;
    private long fke;
    private int fkf;
    private int fkg;
    private int fkh;
    private boolean fki;
    private boolean fkj;
    private long fkk;
    private boolean fkl;
    private String fkm;
    protected com.baidu.tieba.pb.data.d fkn;
    private int fko;
    private boolean fkp;
    private boolean fkq;
    private boolean fkr;
    private boolean fks;
    private a fkt;
    private String fku;
    private String fkv;
    private int fkw;
    private int fkx;
    private boolean fky;
    private boolean fkz;
    private String fla;
    private CustomMessageListener flb;
    private CustomMessageListener flc;
    private com.baidu.adp.framework.listener.a fld;
    private PraiseData fle;
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
    private static final int fjU = com.baidu.tbadk.data.d.Dc() / 30;
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
        this.fjV = null;
        this.fjW = null;
        this.fjX = null;
        this.mForumId = null;
        this.fjY = false;
        this.fjZ = false;
        this.fka = true;
        this.fkb = true;
        this.fkc = false;
        this.mIsGood = 0;
        this.fkd = 0;
        this.fke = 0L;
        this.fkf = 1;
        this.fkg = 1;
        this.fkh = 1;
        this.cuJ = 1;
        this.isAd = false;
        this.eoL = false;
        this.fki = false;
        this.eEA = false;
        this.isFromMark = false;
        this.fkj = false;
        this.fkk = 0L;
        this.fkl = false;
        this.fkm = null;
        this.fkn = null;
        this.isLoading = false;
        this.fkp = false;
        this.fkq = false;
        this.fkr = false;
        this.fks = false;
        this.mLocate = null;
        this.mContext = null;
        this.fkt = null;
        this.opType = null;
        this.opUrl = null;
        this.fku = null;
        this.fkv = null;
        this.fkw = -1;
        this.fkx = -1;
        this.cIA = null;
        this.fkz = false;
        this.fkA = false;
        this.postID = null;
        this.fkD = null;
        this.fkE = 0L;
        this.fkF = false;
        this.fkG = -1;
        this.fkI = false;
        this.fkT = false;
        this.fkU = 0;
        this.flb = new CustomMessageListener(2004003) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.d pbData;
                PbModel.this.fkC = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.m(pbData);
                    PbModel.this.i(pbData);
                    if (pbData.aVs() != null) {
                        pbData.aVs().bN(0);
                    }
                    if (PbModel.this.fkt != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.fkt.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.flc = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
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
        this.fld = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
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
                    if (!PbModel.this.fkz || !PbModel.this.fkA) {
                        if (!PbModel.this.fkz) {
                            PbModel.this.fkz = true;
                        } else {
                            PbModel.this.fkA = true;
                        }
                        if (PbModel.this.fkt != null) {
                            PbModel.this.fkt.a(PbModel.this.aYg(), z, responsedMessage, PbModel.this.fkB, System.currentTimeMillis() - PbModel.this.dmL);
                        }
                    }
                }
            }
        };
        this.fle = null;
        registerListener(this.flb);
        registerListener(this.fld);
        registerListener(this.flc);
        this.fkn = new com.baidu.tieba.pb.data.d();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bcJ = baseActivity;
        this.fkK = new w(this, this.bcJ);
        this.fkL = new h(this, this.bcJ);
        this.fkM = new m(this, this.bcJ);
        this.fkN = new q(this, getUniqueId());
        this.fkO = new y(this, this.bcJ);
        this.bQx = new CheckRealNameModel(this.bcJ.getPageContext());
        this.fkR = new SuggestEmotionModel();
        this.fkQ = new AddExperiencedModel(this.bcJ.getPageContext());
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
        this.fjV = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.fjV)) {
            this.fjV = this.fkK.U(intent);
            if (StringUtils.isNull(this.fjV) && intent.getData() != null) {
                this.fjV = intent.getData().getQueryParameter("thread_id");
            }
        }
        this.fkU = intent.getIntExtra("key_start_from", 0);
        if (this.fkU == 0) {
            this.fkU = this.fkK.flk;
        }
        this.fjX = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.fjW = intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fjY = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fjZ = intent.getBooleanExtra("host_only", false);
        this.fkb = intent.getBooleanExtra("squence", true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.fkd = intent.getIntExtra("is_top", 0);
        this.fke = intent.getLongExtra("thread_time", 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.fkj = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eoL = intent.getBooleanExtra("is_sub_pb", false);
        this.fkl = intent.getBooleanExtra("is_pv", false);
        this.fkk = intent.getLongExtra("msg_id", 0L);
        this.fkm = intent.getStringExtra("from_forum_name");
        this.fkv = intent.getStringExtra("extra_pb_cache_key");
        this.opType = intent.getStringExtra("op_type");
        this.opUrl = intent.getStringExtra("op_url");
        this.fku = intent.getStringExtra("op_stat");
        this.fkp = intent.getBooleanExtra("is_from_thread_config", false);
        this.fkq = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.fkr = intent.getBooleanExtra("is_from_my_god_config", false);
        this.fkx = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.fkw = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.fki = intent.getBooleanExtra("from_frs", false);
        this.eEA = intent.getBooleanExtra("from_maintab", false);
        this.fkI = intent.getBooleanExtra("from_smart_frs", false);
        this.fks = intent.getBooleanExtra("from_hottopic", false);
        this.fkP = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.mIsShareThread = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void initWithBundle(Bundle bundle) {
        this.fkU = bundle.getInt("key_start_from", 0);
        this.fjV = bundle.getString("thread_id");
        this.fjX = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.fjW = bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.fjY = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.fjZ = bundle.getBoolean("host_only", false);
        this.fkb = bundle.getBoolean("squence", true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.fkd = bundle.getInt("is_top", 0);
        this.fke = bundle.getLong("thread_time");
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.fkj = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eoL = bundle.getBoolean("is_sub_pb", false);
        this.fkl = bundle.getBoolean("is_pv", false);
        this.fkk = bundle.getLong("msg_id", 0L);
        this.fkm = bundle.getString("from_forum_name");
        this.fkv = bundle.getString("extra_pb_cache_key");
        this.fkp = bundle.getBoolean("is_from_thread_config", false);
        this.fkq = bundle.getBoolean("is_from_interview_live_config", false);
        this.fkr = bundle.getBoolean("is_from_my_god_config", false);
        this.fkx = bundle.getInt("extra_pb_is_attention_key", -1);
        this.fkw = bundle.getInt("extra_pb_funs_count_key", -1);
        this.fki = bundle.getBoolean("from_frs", false);
        this.eEA = bundle.getBoolean("from_maintab", false);
        this.fkI = bundle.getBoolean("from_smart_frs", false);
        this.fks = bundle.getBoolean("from_hottopic", false);
        this.mIsShareThread = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
    }

    public void y(Bundle bundle) {
        bundle.putString("thread_id", this.fjV);
        bundle.putString("post_id", this.fjX);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt("key_start_from", this.fkU);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.fjY);
        bundle.putBoolean("host_only", this.fjZ);
        bundle.putBoolean("squence", this.fkb);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.fkd);
        bundle.putLong("thread_time", this.fke);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean("is_pb_key_need_post_id", this.fkj);
        bundle.putBoolean("is_sub_pb", this.eoL);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.fkl);
        bundle.putLong("msg_id", this.fkk);
        bundle.putString("extra_pb_cache_key", this.fkv);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean("is_from_thread_config", this.fkp);
        bundle.putBoolean("is_from_interview_live_config", this.fkq);
        bundle.putBoolean("is_from_my_god_config", this.fkr);
        bundle.putInt("extra_pb_is_attention_key", this.fkx);
        bundle.putInt("extra_pb_funs_count_key", this.fkw);
        bundle.putBoolean("from_frs", this.fki);
        bundle.putBoolean("from_maintab", this.eEA);
        bundle.putBoolean("from_smart_frs", this.fkI);
        bundle.putBoolean("from_hottopic", this.fks);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.mIsShareThread);
    }

    public String aYh() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.fjV);
        if (!this.fkj) {
            sb.append(this.fjX);
        }
        sb.append(this.fjZ);
        sb.append(this.fkb);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.fkd);
        sb.append(this.fke);
        sb.append(this.fki);
        sb.append(this.eEA);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eoL);
        sb.append(this.fkl);
        sb.append(this.fkk);
        sb.append(this.fkm);
        sb.append(this.mThreadType);
        sb.append(this.fkp);
        sb.append(this.fkq);
        sb.append(this.fkr);
        if (this.fkv != null) {
            sb.append(this.fkv);
        }
        return sb.toString();
    }

    public String aYi() {
        return this.fkm;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.fjX;
    }

    public String aYj() {
        return this.fjV;
    }

    public boolean getHostMode() {
        return this.fjZ;
    }

    public boolean aYk() {
        return this.fkb;
    }

    public boolean isShareThread() {
        return this.mIsShareThread;
    }

    public boolean aYl() {
        return this.fki;
    }

    public boolean aYm() {
        return this.fkc;
    }

    public boolean aYn() {
        return this.eEA;
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
        return this.fkd;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void iZ(int i) {
        this.fkd = i;
    }

    public boolean aYq() {
        return this.eoL;
    }

    public boolean aYr() {
        if (this.fkn == null) {
            return false;
        }
        return this.fkn.isValid();
    }

    public String rZ() {
        if (this.fkn == null || !this.fkn.oI()) {
            return null;
        }
        return this.fkn.oH();
    }

    public boolean qo(int i) {
        this.fkf = i;
        if (this.fkf > this.fkn.rg().qX()) {
            this.fkf = this.fkn.rg().qX();
        }
        if (this.fkf < 1) {
            this.fkf = 1;
        }
        if (this.fjV == null) {
            return false;
        }
        return qq(5);
    }

    public void qp(int i) {
        this.fkf = i;
        this.fkg = i;
        this.fkh = i;
    }

    public void c(com.baidu.tbadk.core.data.am amVar) {
        if (amVar == null) {
            qp(1);
            return;
        }
        this.fkg = amVar.ra();
        this.fkh = amVar.ra();
        this.cuJ = amVar.qX();
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        return this.fkn;
    }

    public com.baidu.tbadk.core.data.am azo() {
        if (this.fkn == null) {
            return null;
        }
        return this.fkn.rg();
    }

    public boolean aYs() {
        if (this.fkb && this.fkn.rg().rc() == 0) {
            jM(true);
            return true;
        }
        return false;
    }

    public void qr(String str) {
        if (!StringUtils.isNull(str)) {
            this.fjV = str;
            this.fjX = null;
            this.fjZ = false;
            this.fkb = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.fjV == null) {
            return false;
        }
        cancelLoadData();
        if (this.cIA == null) {
            this.cIA = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.cIA.start();
        }
        boolean qq = qq(3);
        if (this.opType != null) {
            this.opType = null;
            this.fku = null;
            this.opUrl = null;
            return qq;
        }
        return qq;
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
        if (this.fkR != null) {
            this.fkR.cancelLoadData();
        }
        if (this.fkN != null) {
            this.fkN.cancelLoadData();
        }
        if (this.fkS != null) {
            this.fkS.cancelLoadData();
        }
        alh();
    }

    private void alh() {
        if (this.cIA != null) {
            this.cIA.destory();
            this.cIA = null;
        }
    }

    public boolean FY() {
        return (this.fjX == null || this.fjX.equals("0") || this.fjX.length() == 0) ? LoadData() : aYv();
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
                this.fkR.a(str, str2, aVar);
            }
        }
        str = str3;
        str2 = "";
        this.fkR.a(str, str2, aVar);
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.fkS == null) {
                this.fkS = new GetSugMatchWordsModel(this.bcJ.getPageContext());
            }
            this.fkS.b(aVar);
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
    public boolean qq(int i) {
        boolean z;
        int size;
        int i2;
        int i3;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        qr(i);
        final com.baidu.tieba.pb.data.d pbData = ai.aZr().getPbData();
        if (pbData != null && pbData.aVs() != null) {
            pbData.aVs().bN(0);
            this.fkb = ai.aZr().aYk();
            this.fjZ = ai.aZr().aZw();
            this.fkc = ai.aZr().aZx();
            this.fkW = ai.aZr().aZv();
            this.fkX = ai.aZr().aZu();
            this.fkY = ai.aZr().aZt();
            this.fkT = this.fjZ;
            if (this.fjZ || this.isFromMark) {
                this.fky = false;
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
        if (i == 4 && !this.fkC) {
            a(aYA(), true, this.fjX, 3);
        }
        if (i == 3 && !this.fkC) {
            if (this.isFromMark) {
                a(aYA(), true, this.fjX, 3);
            } else {
                a(aYA(), false, this.fjX, 3);
            }
        }
        this.fkC = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBR);
        if (this.fjZ || this.isFromMark) {
            this.fky = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.fjV == null || this.fjV.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.fjV, 0L));
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
        if (!this.fkb) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.fjZ) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.fkl) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.fkk));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.fky) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.fku, 0));
            pbPageRequestMessage.setOpMessageID(this.fkk);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aVu = this.fkn.aVu();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.fkb) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fkh - 1));
                        if (this.fkh - 1 <= 0) {
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
                                            this.fjX = postData.getId();
                                            if (StringUtils.isNull(this.fjX)) {
                                                i3 = i2 + 1;
                                            }
                                        }
                                        i2 = i3;
                                    }
                                }
                                if (this.fjX == null && this.fjX.length() > 0) {
                                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjX, 0L));
                                } else if (!this.fkb) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            b(pbPageRequestMessage);
                            break;
                        }
                    } else {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fkg + 1));
                        if (this.fkg >= this.cuJ) {
                            z = true;
                            if (!this.isFromMark) {
                            }
                            if (aVu != null) {
                                size = aVu.size();
                                i2 = 1;
                                while (size - i2 >= 0) {
                                }
                            }
                            if (this.fjX == null) {
                            }
                            if (!this.fkb) {
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
                if (this.fjX == null) {
                }
                if (!this.fkb) {
                }
                b(pbPageRequestMessage);
            case 2:
                if (aVu != null && aVu.size() > 0 && aVu.get(0) != null) {
                    this.fjX = aVu.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.fkb) {
                        if (this.fkh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.fkh - 1));
                        }
                    } else if (this.fkg < this.cuJ) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.fkg + 1));
                    }
                }
                if (this.fjX != null && this.fjX.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjX, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.fjZ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.fkb) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjX, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.fkf));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.fkb && this.fkT && !this.fjZ) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fjX, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.fjZ) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.fkG);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.fkV, 0L));
                if (!this.fkb) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.fkT = this.fjZ;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aYA());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setObjParam1(String.valueOf(this.fkU));
        pbPageRequestMessage.setIsSubPostDataReverse(this.fkF);
        pbPageRequestMessage.setFromSmartFrs(this.fkI ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.fjY);
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

    protected void qr(int i) {
        boolean z = false;
        qv(i);
        ArrayList<PostData> aVu = this.fkn.aVu();
        this.fkB = false;
        if (i == 1) {
            boolean z2 = false;
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Dc()) {
                aVu.remove(0);
                z2 = true;
            }
            if (z2) {
                this.fkn.rg().bJ(1);
                if (this.fkt != null) {
                    this.fkt.f(this.fkn);
                }
            }
            this.dmL = System.currentTimeMillis();
            this.fkB = true;
        } else if (i == 2) {
            while (aVu.size() + 30 > com.baidu.tbadk.data.d.Dc()) {
                aVu.remove(aVu.size() - 1);
                z = true;
            }
            if (z) {
                this.fkn.rg().bI(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.d dVar2 = z ? null : dVar;
        this.fkJ = i2;
        this.isLoading = false;
        if (dVar2 != null) {
            i(dVar2);
            h(dVar2);
        }
        a(dVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    private void h(com.baidu.tieba.pb.data.d dVar) {
        Long l;
        if (dVar != null && !StringUtils.isNull(this.fjW)) {
            try {
                Long valueOf = Long.valueOf(this.fjW);
                com.baidu.tieba.pb.data.l aVD = dVar.aVD();
                if (aVD != null && aVD.fcY != null) {
                    if (aVD.fcY.isEmpty() || !aVD.fcY.contains(valueOf)) {
                        try {
                            l = Long.valueOf(this.fjV);
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
            if (this.fkr || this.fkp || this.fkq) {
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
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.fcX)) {
                for (PostData postData2 : aVD.fcX) {
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
            if (aVD != null && !com.baidu.tbadk.core.util.v.w(aVD.fcX)) {
                for (PostData postData : aVD.fcX.subList(i, aVD.fcX.size())) {
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
        aVs.bR(this.mIsGood);
        aVs.bQ(this.fkd);
        if (this.fke > 0) {
            aVs.n(this.fke);
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
        if (this.fkn == null || this.fkn.aVs() == null || this.fkn.aVs().rQ() == null) {
            return null;
        }
        return this.fkn.aVs().rQ();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.d dVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        int i6;
        boolean z4 = !z;
        this.fkH = z3;
        this.fko = i;
        if (this.cIA != null && !z3) {
            this.cIA.a(z2, z4, i2, str, i3, j, j2);
            this.cIA = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aYi()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            com.baidu.tieba.recapp.r.bjl().bjf().f(aYi(), qs(getRequestType()), true);
        }
        if (dVar == null || (this.fkf == 1 && i == 5 && dVar.aVu() != null && dVar.aVu().size() < 1)) {
            if (this.fkt != null) {
                this.fkb = this.fka;
                this.fkt.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.fka = this.fkb;
            this.fkl = false;
            if (dVar.rg() != null) {
                c(dVar.rg());
            }
            this.cuJ = this.cuJ < 1 ? 1 : this.cuJ;
            ArrayList<PostData> aVu = this.fkn.aVu();
            switch (i) {
                case 1:
                    this.fkn.a(dVar.rg(), 1);
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
                    this.fkn.a(dVar.rg(), 2);
                    i5 = i6;
                    break;
                case 3:
                    if (!this.fkb && dVar.rg() != null) {
                        dVar.rg().bG(dVar.rg().qX());
                    }
                    m(dVar);
                    if (!z3 && this.mThreadType != 33 && this.fkb) {
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
                    if (dVar != null && !com.baidu.tbadk.core.util.v.w(dVar.aVu()) && this.fkn != null && (!this.fjZ || l(dVar).equals(dVar.aVu().get(0).rQ().getUserId()))) {
                        if (this.fkn.rg().rc() == 0) {
                            this.fkn.rg().bI(1);
                        }
                        aYQ();
                        this.fkW = dVar.aVu().get(0);
                        if (this.fkb) {
                            if (this.fkn.aVu().size() - this.fkY >= 3) {
                                this.fkX = new PostData();
                                this.fkX.gwT = true;
                                this.fkX.setPostType(53);
                                this.fkn.aVu().add(this.fkX);
                            }
                            this.fkn.aVu().add(this.fkW);
                            i4 = this.fkn.aVu().size() - 1;
                        } else {
                            if (this.fkY - this.fkZ >= 3) {
                                this.fkX = new PostData();
                                this.fkX.gwT = false;
                                this.fkX.setPostType(53);
                                this.fkn.aVu().add(0, this.fkX);
                            }
                            this.fkn.aVu().add(0, this.fkW);
                            i4 = 0;
                        }
                        if (!com.baidu.tbadk.core.util.an.O(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.fkW.gxg = this.fkn.aVR();
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
            if (this.fkn != null && this.fkn.aVs() != null) {
                PraiseData rF = this.fkn.aVs().rF();
                if (this.fle != null && !rF.isPriaseDataValid()) {
                    this.fkn.aVs().a(this.fle);
                } else {
                    this.fle = this.fkn.aVs().rF();
                    this.fle.setPostId(this.fkn.aVs().sg());
                }
                if (dVar.rg() != null && dVar.rg().ra() == 1 && dVar.aVs() != null && dVar.aVs().sb() != null && dVar.aVs().sb().size() > 0) {
                    this.fkn.aVs().h(dVar.aVs().sb());
                }
                this.fkn.aVs().bO(dVar.aVs().rI());
                this.fkn.aVs().bL(dVar.aVs().getAnchorLevel());
                this.fkn.aVs().bN(dVar.aVs().rC());
                if (this.mThreadType == 33) {
                    this.fkn.aVs().rQ().setHadConcerned(dVar.aVs().rQ().hadConcerned());
                }
                if (dVar != null && dVar.aVs() != null) {
                    this.fkn.aVs().bT(dVar.aVs().sf());
                }
            }
            if (this.fkn != null && this.fkn.getUserData() != null && dVar.getUserData() != null) {
                this.fkn.getUserData().setBimg_end_time(dVar.getUserData().getBimg_end_time());
                this.fkn.getUserData().setBimg_url(dVar.getUserData().getBimg_url());
            }
            if (dVar.rg() != null && dVar.rg().ra() == 1 && dVar.aVC() != null) {
                this.fkn.c(dVar.aVC());
            }
            if (this.fkH) {
                if (this.fkn.aVs() != null && this.fkn.aVs().rQ() != null && this.fkn.aVu() != null && com.baidu.tbadk.core.util.v.c(this.fkn.aVu(), 0) != null) {
                    PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.fkn.aVu(), 0);
                    MetaData rQ = this.fkn.aVs().rQ();
                    if (postData3.rQ() != null && postData3.rQ().getGodUserData() != null) {
                        if (this.fkw != -1) {
                            rQ.setFansNum(this.fkw);
                            postData3.rQ().setFansNum(this.fkw);
                        }
                        if (this.fkx != -1) {
                            rQ.getGodUserData().setIsLike(this.fkx == 1);
                            postData3.rQ().getGodUserData().setIsLike(this.fkx == 1);
                            rQ.getGodUserData().setIsFromNetWork(false);
                            postData3.rQ().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                this.fkn.fct = -1;
                this.fkn.fcs = -1;
            }
            if (this.fkt != null) {
                this.fkt.a(true, getErrorCode(), i, i5, this.fkn, this.mErrorString, 1);
            }
        }
        if (this.fkn != null && this.fkn.aVs() != null && this.fkn.aVq() != null) {
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

    private int qs(int i) {
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
        dVar.qq(this.fkn.aVJ());
        this.fkn = dVar;
        qp(dVar.rg().ra());
    }

    private void aYu() {
        if (this.fkn != null && this.fkn.aVu() != null && this.fkn.aVI() != null) {
            ArrayList<PostData> aVu = this.fkn.aVu();
            com.baidu.tieba.pb.data.a aVI = this.fkn.aVI();
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
        if (this.fjV == null || this.fjX == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return qq(4);
        }
        return qq(6);
    }

    public boolean jM(boolean z) {
        if (this.fjV == null || this.fkn == null) {
            return false;
        }
        if (z || this.fkn.rg().rc() != 0) {
            return qq(1);
        }
        return false;
    }

    public boolean jN(boolean z) {
        if (this.fjV == null || this.fkn == null) {
            return false;
        }
        if ((z || this.fkn.rg().rd() != 0) && this.fkn.aVu() != null && this.fkn.aVu().size() >= 1) {
            return qq(2);
        }
        return false;
    }

    public boolean qw(String str) {
        this.fjZ = !this.fjZ;
        this.fjX = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (qq(6)) {
            return true;
        }
        this.fjZ = this.fjZ ? false : true;
        return false;
    }

    public boolean l(boolean z, String str) {
        if (this.fjZ == z) {
            return false;
        }
        this.fjZ = z;
        this.fjX = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (qq(6)) {
            return true;
        }
        this.fjZ = z ? false : true;
        return false;
    }

    public boolean aYw() {
        this.fka = this.fkb;
        this.fkb = !this.fkb;
        if (this.isLoading || !LoadData()) {
            this.fkb = this.fkb ? false : true;
            return false;
        }
        return true;
    }

    public boolean aYx() {
        return this.fkb;
    }

    public boolean hasData() {
        return (this.fkn == null || this.fkn.aVq() == null || this.fkn.aVs() == null) ? false : true;
    }

    public boolean oI() {
        if (this.fkn == null) {
            return false;
        }
        return this.fkn.oI();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fkn == null || this.fkn.aVs() == null || this.fkn.aVq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.fkn.aVs().sY()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.fkn.aVq().getId());
            writeData.setForumName(this.fkn.aVq().getName());
        }
        writeData.sourceFrom = String.valueOf(this.fkU);
        writeData.setThreadId(this.fjV);
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

    public MarkData qt(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.fkn == null) {
            return null;
        }
        ArrayList<PostData> aVu = this.fkn.aVu();
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
        markData.setThreadId(this.fjV);
        markData.setPostId(this.fkn.oH());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fjZ);
        markData.setSequence(Boolean.valueOf(this.fkb));
        markData.setId(this.fjV);
        return markData;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fjV);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.fjZ);
        markData.setSequence(Boolean.valueOf(this.fkb));
        markData.setId(this.fjV);
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
        String str = this.fjV;
        if (this.fjZ) {
            str = str + DB_KEY_HOST;
        }
        if (!this.fkb) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jO(boolean z) {
        if (this.fkn != null) {
            this.fkn.ae(z);
        }
    }

    public void jP(boolean z) {
        this.fky = z;
    }

    public boolean aYB() {
        return this.fky;
    }

    public void a(a aVar) {
        this.fkt = aVar;
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
            this.fkE = System.currentTimeMillis() / 1000;
        }
    }

    public void aYE() {
        if ("personalize_page".equals(this.mStType) && this.fkn != null && this.fkE != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c10754").ac(ImageViewerConfig.FORUM_ID, this.fkn.getForumId()).ac("tid", this.fjV).ac("obj_duration", String.valueOf(currentTimeMillis - this.fkE)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.fkE = 0L;
        }
    }

    public boolean aYF() {
        return this.fkH;
    }

    public int getErrorNo() {
        return this.fkJ;
    }

    public com.baidu.tieba.pb.data.c getAppealInfo() {
        return this.mAppealInfo;
    }

    public h aYG() {
        return this.fkL;
    }

    public m aYH() {
        return this.fkM;
    }

    public q aYI() {
        return this.fkN;
    }

    public y aYJ() {
        return this.fkO;
    }

    public CheckRealNameModel aYK() {
        return this.bQx;
    }

    public AddExperiencedModel aYL() {
        return this.fkQ;
    }

    public String aYM() {
        return this.fkD;
    }

    public void qy(String str) {
        this.fkD = str;
    }

    public boolean aYN() {
        return this.fkI;
    }

    public void a(com.baidu.tbadk.data.h hVar) {
        if (hVar != null && this.fkn != null && this.fkn.aVu() != null && this.fkn.aVu().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.fkn.aVu().size();
                for (int i = 0; i < size; i++) {
                    if (this.fkn.aVu().get(i) != null && this.fkn.aVu().get(i).rQ() != null && currentAccount.equals(this.fkn.aVu().get(i).rQ().getUserId()) && this.fkn.aVu().get(i).rQ().getPendantData() != null) {
                        this.fkn.aVu().get(i).rQ().getPendantData().cL(hVar.qG());
                        this.fkn.aVu().get(i).rQ().getPendantData().T(hVar.Dk());
                    }
                }
            }
        }
    }

    public String aYO() {
        return this.fkP;
    }

    public int aYP() {
        return this.fkU;
    }

    public void qu(int i) {
        this.fkU = i;
    }

    public void qz(String str) {
        if ((!this.fjZ || qx(TbadkCoreApplication.getCurrentAccount())) && this.fkn.aVu() != null) {
            this.fkn.rg().bI(1);
            if (this.fkn.rg().rc() == 0) {
                this.fkn.rg().bI(1);
            }
            this.fkV = str;
            qq(8);
        }
    }

    private void qv(int i) {
        if (i != 8) {
            this.fkV = "";
            if (this.fkW != null) {
                if (i == 1 && !this.fkb && !com.baidu.tbadk.core.util.v.w(getPbData().aVu())) {
                    getPbData().aVu().remove(this.fkW);
                    if (this.fkX != null) {
                        getPbData().aVu().remove(this.fkX);
                    }
                    getPbData().aVu().add(0, this.fkW);
                } else {
                    getPbData().aVu().remove(this.fkW);
                    if (this.fkX != null) {
                        getPbData().aVu().remove(this.fkX);
                    }
                }
            }
            this.fkX = null;
        }
    }

    public void aYQ() {
        if (this.fkn != null && !com.baidu.tbadk.core.util.v.w(this.fkn.aVu())) {
            if (this.fkX != null) {
                this.fkn.aVu().remove(this.fkX);
                this.fkX = null;
            }
            if (this.fkW != null) {
                this.fkn.aVu().remove(this.fkW);
                this.fkW = null;
            }
        }
    }

    public void bp(int i, int i2) {
        this.fkY = i;
        this.fkZ = i2;
    }

    public PostData aYR() {
        return this.fkW;
    }

    public PostData aYS() {
        return this.fkX;
    }

    public int aYT() {
        return this.fkY;
    }

    public String aYU() {
        return this.fla;
    }

    public void qA(String str) {
        this.fla = str;
    }
}
