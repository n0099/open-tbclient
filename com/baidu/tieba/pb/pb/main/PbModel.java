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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.pb.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
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
    private int bXV;
    private BaseActivity brT;
    private final CheckRealNameModel bzl;
    private long cNZ;
    private com.baidu.tieba.tbadkCore.d.b clb;
    private com.baidu.adp.framework.listener.a dWA;
    private int dWq;
    private boolean eOA;
    private long eOB;
    private boolean eOC;
    private String eOD;
    protected com.baidu.tieba.pb.data.f eOE;
    private int eOF;
    private boolean eOG;
    private boolean eOH;
    private boolean eOI;
    private boolean eOJ;
    private a eOK;
    private String eOL;
    private String eOM;
    private int eON;
    private int eOO;
    private boolean eOP;
    private boolean eOQ;
    private boolean eOR;
    private boolean eOS;
    private boolean eOT;
    private String eOU;
    private long eOV;
    private boolean eOW;
    private int eOX;
    private boolean eOY;
    private boolean eOZ;
    protected String eOn;
    private String eOo;
    private boolean eOp;
    private boolean eOq;
    private boolean eOr;
    private boolean eOs;
    private boolean eOt;
    private long eOu;
    private int eOv;
    private int eOw;
    private int eOx;
    private boolean eOy;
    private boolean eOz;
    private int ePa;
    private final v ePb;
    private final j ePc;
    private final o ePd;
    private final PbFloorAgreeModel ePe;
    private final x ePf;
    private String ePg;
    private final AddExperiencedModel ePh;
    private SuggestEmotionModel ePi;
    private GetSugMatchWordsModel ePj;
    private boolean ePk;
    private int ePl;
    private String ePm;
    private PostData ePn;
    private PostData ePo;
    private int ePp;
    private int ePq;
    private CustomMessageListener ePr;
    private CustomMessageListener ePs;
    private PraiseData ePt;
    private boolean elu;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private com.baidu.tieba.pb.data.e mAppealInfo;
    protected Context mContext;
    private String mForumId;
    private int mIsGood;
    private String mLocate;
    private int mRequestType;
    public String mStType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;
    private static final int eOm = com.baidu.tbadk.data.b.Cl() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void iY(boolean z) {
        this.eOW = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eOn = null;
        this.eOo = null;
        this.mForumId = null;
        this.eOp = false;
        this.eOq = false;
        this.eOr = true;
        this.eOs = true;
        this.eOt = false;
        this.mIsGood = 0;
        this.dWq = 0;
        this.eOu = 0L;
        this.eOv = 1;
        this.eOw = 1;
        this.eOx = 1;
        this.bXV = 1;
        this.isAd = false;
        this.eOy = false;
        this.eOz = false;
        this.elu = false;
        this.isFromMark = false;
        this.eOA = false;
        this.eOB = 0L;
        this.eOC = false;
        this.eOD = null;
        this.eOE = null;
        this.isLoading = false;
        this.eOG = false;
        this.eOH = false;
        this.eOI = false;
        this.eOJ = false;
        this.mLocate = null;
        this.mContext = null;
        this.eOK = null;
        this.opType = null;
        this.opUrl = null;
        this.eOL = null;
        this.eOM = null;
        this.eON = -1;
        this.eOO = -1;
        this.clb = null;
        this.eOQ = false;
        this.eOR = false;
        this.postID = null;
        this.eOU = null;
        this.eOV = 0L;
        this.eOW = false;
        this.eOX = -1;
        this.eOZ = false;
        this.ePk = false;
        this.ePl = 0;
        this.ePr = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eOT = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.n(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.aPW() != null) {
                        pbData.aPW().bP(0);
                    }
                    if (PbModel.this.eOK != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eOK.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.ePs = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPU() != null && PbModel.this.getPbData().aPU().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPU().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dWA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.brT.showToast(responsedMessage.getErrorString());
                    }
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagesocketresponsemessage);
                        pbpagesocketresponsemessage.getDownSize();
                    }
                    if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                        z = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        PbModel.this.a(pbpagehttpresponsemessage);
                        pbpagehttpresponsemessage.getDownSize();
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
                    if (!PbModel.this.eOQ || !PbModel.this.eOR) {
                        if (!PbModel.this.eOQ) {
                            PbModel.this.eOQ = true;
                        } else {
                            PbModel.this.eOR = true;
                        }
                        if (PbModel.this.eOK != null) {
                            PbModel.this.eOK.a(PbModel.this.aSE(), z, responsedMessage, PbModel.this.eOS, System.currentTimeMillis() - PbModel.this.cNZ);
                        }
                    }
                }
            }
        };
        this.ePt = null;
        registerListener(this.ePr);
        registerListener(this.dWA);
        registerListener(this.ePs);
        this.eOE = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.brT = baseActivity;
        this.ePb = new v(this, this.brT);
        this.ePc = new j(this, this.brT);
        this.ePd = new o(this, this.brT);
        this.ePe = new PbFloorAgreeModel(this);
        this.ePf = new x(this, this.brT);
        this.bzl = new CheckRealNameModel(this.brT.getPageContext());
        this.ePi = new SuggestEmotionModel();
        this.ePh = new AddExperiencedModel(this.brT.getPageContext());
    }

    protected int aSE() {
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
        this.eOn = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eOn)) {
            this.eOn = this.ePb.S(intent);
        }
        this.ePl = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eOo = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eOp = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eOq = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eOs = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dWq = intent.getIntExtra("is_top", 0);
        this.eOu = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eOA = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eOy = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eOC = intent.getBooleanExtra("is_pv", false);
        this.eOB = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eOD = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eOM = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eOL = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eOG = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eOH = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eOI = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eOO = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eON = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eOz = intent.getBooleanExtra("from_frs", false);
        this.elu = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eOZ = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eOJ = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.ePg = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.ePl = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eOn = bundle.getString("thread_id");
        this.eOo = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eOp = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eOq = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eOs = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dWq = bundle.getInt("is_top", 0);
        this.eOu = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eOA = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eOy = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eOC = bundle.getBoolean("is_pv", false);
        this.eOB = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eOD = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eOM = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eOG = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eOH = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eOI = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eOO = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eON = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eOz = bundle.getBoolean("from_frs", false);
        this.elu = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eOZ = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eOJ = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void t(Bundle bundle) {
        bundle.putString("thread_id", this.eOn);
        bundle.putString("post_id", this.eOo);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.ePl);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eOp);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eOq);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eOs);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dWq);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eOu);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eOA);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eOy);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eOC);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eOB);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eOM);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eOG);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eOH);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eOI);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eOO);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eON);
        bundle.putBoolean("from_frs", this.eOz);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.elu);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eOZ);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eOJ);
    }

    public String aSF() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eOn);
        if (!this.eOA) {
            sb.append(this.eOo);
        }
        sb.append(this.eOq);
        sb.append(this.eOs);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dWq);
        sb.append(this.eOu);
        sb.append(this.eOz);
        sb.append(this.elu);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eOy);
        sb.append(this.eOC);
        sb.append(this.eOB);
        sb.append(this.eOD);
        sb.append(this.mThreadType);
        sb.append(this.eOG);
        sb.append(this.eOH);
        sb.append(this.eOI);
        if (this.eOM != null) {
            sb.append(this.eOM);
        }
        return sb.toString();
    }

    public String aSG() {
        return this.eOD;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eOo;
    }

    public void py(String str) {
        this.eOo = str;
    }

    public String aSH() {
        return this.eOn;
    }

    public boolean getHostMode() {
        return this.eOq;
    }

    public boolean aSI() {
        return this.eOs;
    }

    public boolean aSJ() {
        return this.eOz;
    }

    public boolean aSK() {
        return this.eOt;
    }

    public boolean aSL() {
        return this.elu;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aSM() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aEL() {
        return this.dWq;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void ir(int i) {
        this.dWq = i;
    }

    public boolean aSN() {
        return this.eOy;
    }

    public boolean aSO() {
        if (this.eOE == null) {
            return false;
        }
        return this.eOE.isValid();
    }

    public String rD() {
        if (this.eOE == null || !this.eOE.nC()) {
            return null;
        }
        return this.eOE.nB();
    }

    public boolean pE(int i) {
        this.eOv = i;
        if (this.eOv > this.eOE.qv().qm()) {
            this.eOv = this.eOE.qv().qm();
        }
        if (this.eOv < 1) {
            this.eOv = 1;
        }
        if (this.eOn == null) {
            return false;
        }
        return pI(5);
    }

    public boolean pF(int i) {
        int si = this.eOE.aPW().si();
        if (i <= si) {
            si = i;
        }
        int i2 = si >= 1 ? si : 1;
        if (this.eOn == null) {
            return false;
        }
        this.eOX = i2;
        return pI(7);
    }

    public void pG(int i) {
        this.eOv = i;
        this.eOw = i;
        this.eOx = i;
    }

    public void pH(int i) {
        if (this.eOw < i) {
            this.eOw = i;
            if (this.eOw - this.eOx >= eOm) {
                this.eOx = (this.eOw - eOm) + 1;
            }
        }
        if (this.eOx > i) {
            this.eOx = i;
            if (this.eOw - this.eOx >= eOm) {
                this.eOw = (this.eOx + eOm) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eOE;
    }

    public com.baidu.tbadk.core.data.ap aua() {
        if (this.eOE == null) {
            return null;
        }
        return this.eOE.qv();
    }

    public boolean aSP() {
        if (this.eOs && this.eOE.qv().qr() == 0) {
            iZ(true);
            return true;
        }
        return false;
    }

    public void pt(String str) {
        if (!StringUtils.isNull(str)) {
            this.eOn = str;
            this.eOo = null;
            this.eOq = false;
            this.eOs = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eOn == null) {
            return false;
        }
        cancelLoadData();
        if (this.clb == null) {
            this.clb = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.clb.start();
        }
        boolean pI = pI(3);
        if (this.opType != null) {
            this.opType = null;
            this.eOL = null;
            this.opUrl = null;
            return pI;
        }
        return pI;
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
        if (this.ePi != null) {
            this.ePi.cancelLoadData();
        }
        if (this.ePe != null) {
            this.ePe.cancelLoadData();
        }
        if (this.ePj != null) {
            this.ePj.cancelLoadData();
        }
        afB();
    }

    private void afB() {
        if (this.clb != null) {
            this.clb.destory();
            this.clb = null;
        }
    }

    public boolean Fr() {
        return (this.eOo == null || this.eOo.equals("0") || this.eOo.length() == 0) ? LoadData() : aSS();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.ePi.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.ePj == null) {
                this.ePj = new GetSugMatchWordsModel(this.brT.getPageContext());
            }
            this.ePj.b(aVar);
        }
    }

    public boolean pI(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pJ(i);
        final com.baidu.tieba.pb.data.f pbData = ag.aTO().getPbData();
        if (pbData != null && pbData.aPW() != null) {
            pbData.aPW().bP(0);
            this.eOs = ag.aTO().aSI();
            this.eOq = ag.aTO().aTT();
            this.eOt = ag.aTO().aTU();
            this.ePn = ag.aTO().aTS();
            this.ePo = ag.aTO().aTR();
            this.ePp = ag.aTO().aTQ();
            this.ePk = this.eOq;
            if (this.eOq || this.isFromMark) {
                this.eOP = false;
            }
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.4
                @Override // java.lang.Runnable
                public void run() {
                    PbModel.this.a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
                    PbModel.this.isLoading = false;
                }
            });
            return false;
        }
        if (i == 4 && !this.eOT) {
            a(aSX(), true, this.eOo, 3);
        }
        if (i == 3 && !this.eOT) {
            if (this.isFromMark) {
                a(aSX(), true, this.eOo, 3);
            } else {
                a(aSX(), false, this.eOo, 3);
            }
        }
        this.eOT = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAq);
        if (this.eOq || this.isFromMark) {
            this.eOP = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eOn == null || this.eOn.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eOn, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i3 = com.baidu.tbadk.core.util.an.vs().vu() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ac));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ae));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
        if (!this.eOs) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eOq) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eOC) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eOB));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eOP) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eOL, 0));
            pbPageRequestMessage.setOpMessageID(this.eOB);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPY = this.eOE.aPY();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eOs) {
                        if (this.eOx - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eOx - 1));
                        }
                    } else if (this.eOw < this.bXV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eOw + 1));
                    }
                }
                if (aPY != null && aPY.size() > 0) {
                    int size = aPY.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPY.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eOo = postData.getId();
                            if (StringUtils.isNull(this.eOo)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eOo != null && this.eOo.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eOo, 0L));
                } else if (!this.eOs) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPY != null && aPY.size() > 0 && aPY.get(0) != null) {
                    this.eOo = aPY.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eOs) {
                        if (this.eOx - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eOx - 1));
                        }
                    } else if (this.eOw < this.bXV) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eOw + 1));
                    }
                }
                if (this.eOo != null && this.eOo.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eOo, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eOq) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eOs) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eOo, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eOv));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eOs && this.ePk && !this.eOq) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eOo, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eOq) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eOX);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ePm, 0L));
                if (!this.eOs) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.ePk = this.eOq;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aSX());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.brT != null && (this.brT instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.brT).aRq());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eOW);
        pbPageRequestMessage.setFromSmartFrs(this.eOZ ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eOp);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSG()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjl().bjf().S(aSG(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjl().bjf().T(aSG(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSG()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bjl().bjf().T(aSG(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bjl().bjf().S(aSG(), true));
        }
    }

    protected void pJ(int i) {
        boolean z = false;
        pM(i);
        ArrayList<PostData> aPY = this.eOE.aPY();
        this.eOS = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPY.size() + 30 > com.baidu.tbadk.data.b.Cl()) {
                aPY.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eOE.qv().bL(1);
                if (this.eOK != null) {
                    this.eOK.f(this.eOE);
                }
            }
            this.cNZ = System.currentTimeMillis();
            this.eOS = true;
        } else if (i == 2) {
            while (aPY.size() + 30 > com.baidu.tbadk.data.b.Cl()) {
                aPY.remove(aPY.size() - 1);
                z = true;
            }
            if (z) {
                this.eOE.qv().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.ePa = i2;
        this.isLoading = false;
        if (fVar2 != null) {
            h(fVar2);
        }
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
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

    protected void h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            if (this.eOI || this.eOG || this.eOH) {
                fVar = j(fVar);
            }
            i(fVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String k = k(fVar);
            for (int i = 0; i < fVar.aPY().size(); i++) {
                PostData postData = fVar.aPY().get(i);
                for (int i2 = 0; i2 < postData.buD().size(); i2++) {
                    postData.buD().get(i2).b(this.brT.getPageContext(), k.equals(postData.buD().get(i2).rt().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aQg = fVar.aQg();
            if (aQg != null && !com.baidu.tbadk.core.util.v.v(aQg.eHD)) {
                for (PostData postData2 : aQg.eHD) {
                    for (int i3 = 0; i3 < postData2.buD().size(); i3++) {
                        postData2.buD().get(i3).b(this.brT.getPageContext(), k.equals(postData2.buD().get(i3).rt().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String k = k(fVar);
            com.baidu.tieba.pb.data.n aQg = fVar.aQg();
            if (aQg != null && !com.baidu.tbadk.core.util.v.v(aQg.eHD)) {
                for (PostData postData : aQg.eHD.subList(i, aQg.eHD.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.buD().size()) {
                            postData.buD().get(i3).b(this.brT.getPageContext(), k.equals(postData.buD().get(i3).rt().getUserId()));
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.f j(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null) {
            return null;
        }
        bh aPW = fVar.aPW();
        aPW.bT(this.mIsGood);
        aPW.bS(this.dWq);
        if (this.eOu > 0) {
            aPW.m(this.eOu);
            return fVar;
        }
        return fVar;
    }

    protected String k(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPW() != null && fVar.aPW().rt() != null) {
            str = fVar.aPW().rt().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String l(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPW() != null && fVar.aPW().rt() != null) {
            str = fVar.aPW().rt().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String m(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPW() != null && fVar.aPW().rt() != null) {
            str = fVar.aPW().rt().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aSQ() {
        if (this.eOE == null || this.eOE.aPW() == null || this.eOE.aPW().rt() == null) {
            return null;
        }
        return this.eOE.aPW().rt();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        boolean z4 = !z;
        this.eOY = z3;
        this.eOF = i;
        if (this.clb != null && !z3) {
            this.clb.a(z2, z4, i2, str, i3, j, j2);
            this.clb = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aSG()) && com.baidu.tieba.recapp.r.bjl().bjf() != null) {
            com.baidu.tieba.recapp.r.bjl().bjf().f(aSG(), pK(aSZ()), true);
        }
        if (fVar == null || (this.eOv == 1 && i == 5 && fVar.aPY() != null && fVar.aPY().size() < 1)) {
            if (this.eOK != null) {
                this.eOs = this.eOr;
                this.eOK.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eOr = this.eOs;
            this.eOC = false;
            if (fVar.qv() != null) {
                pH(fVar.qv().qp());
                this.bXV = fVar.qv().qm();
            }
            this.bXV = this.bXV < 1 ? 1 : this.bXV;
            ArrayList<PostData> aPY = this.eOE.aPY();
            switch (i) {
                case 1:
                    this.eOE.a(fVar.qv(), 1);
                    e(fVar, aPY);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPY() == null) {
                        i5 = 0;
                    } else {
                        int size = fVar.aPY().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPY, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPY(), com.baidu.tbadk.core.util.v.u(fVar.aPY()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPY().remove(postData2);
                            i5 = size - 1;
                        }
                        aPY.addAll(0, fVar.aPY());
                    }
                    this.eOE.a(fVar.qv(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eOs && fVar.qv() != null) {
                        fVar.qv().bI(fVar.qv().qm());
                    }
                    n(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eOs) {
                        aSR();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    n(fVar);
                    i4 = 0;
                    break;
                case 5:
                    n(fVar);
                    i4 = 0;
                    break;
                case 6:
                    n(fVar);
                    i4 = 0;
                    break;
                case 7:
                    n(fVar);
                    i4 = 0;
                    break;
                case 8:
                    if (fVar != null && !com.baidu.tbadk.core.util.v.v(fVar.aPY()) && this.eOE != null && (!this.eOq || k(fVar).equals(fVar.aPY().get(0).rt().getUserId()))) {
                        if (this.eOE.qv().qr() == 0) {
                            this.eOE.qv().bK(1);
                        }
                        aTo();
                        this.ePn = fVar.aPY().get(0);
                        if (this.eOs) {
                            if (this.eOE.aPY().size() - this.ePp >= 3) {
                                this.ePo = new PostData();
                                this.ePo.gqM = true;
                                this.ePo.setPostType(53);
                                this.eOE.aPY().add(this.ePo);
                            }
                            this.eOE.aPY().add(this.ePn);
                            i4 = this.eOE.aPY().size() - 1;
                            break;
                        } else {
                            if (this.ePp - this.ePq >= 3) {
                                this.ePo = new PostData();
                                this.ePo.gqM = false;
                                this.ePo.setPostType(53);
                                this.eOE.aPY().add(0, this.ePo);
                            }
                            this.eOE.aPY().add(0, this.ePn);
                            i4 = 0;
                            break;
                        }
                    }
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.eOE != null && this.eOE.aPW() != null) {
                PraiseData ri = this.eOE.aPW().ri();
                if (this.ePt != null && !ri.isPriaseDataValid()) {
                    this.eOE.aPW().a(this.ePt);
                } else {
                    this.ePt = this.eOE.aPW().ri();
                    this.ePt.setPostId(this.eOE.aPW().rK());
                }
                if (fVar.qv() != null && fVar.qv().qp() == 1 && fVar.aPW() != null && fVar.aPW().rF() != null && fVar.aPW().rF().size() > 0) {
                    this.eOE.aPW().h(fVar.aPW().rF());
                }
                this.eOE.aPW().bQ(fVar.aPW().rl());
                this.eOE.aPW().bN(fVar.aPW().getAnchorLevel());
                this.eOE.aPW().bP(fVar.aPW().re());
                if (this.mThreadType == 33) {
                    this.eOE.aPW().rt().setHadConcerned(fVar.aPW().rt().hadConcerned());
                }
            }
            if (this.eOE != null && this.eOE.getUserData() != null && fVar.getUserData() != null) {
                this.eOE.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eOE.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qv() != null && fVar.qv().qp() == 1 && fVar.aQf() != null) {
                this.eOE.c(fVar.aQf());
            }
            if (this.eOY && this.eOE.aPW() != null && this.eOE.aPW().rt() != null && this.eOE.aPY() != null && com.baidu.tbadk.core.util.v.c(this.eOE.aPY(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eOE.aPY(), 0);
                MetaData rt = this.eOE.aPW().rt();
                if (postData3.rt() != null && postData3.rt().getGodUserData() != null) {
                    if (this.eON != -1) {
                        rt.setFansNum(this.eON);
                        postData3.rt().setFansNum(this.eON);
                    }
                    if (this.eOO != -1) {
                        rt.getGodUserData().setIsLike(this.eOO == 1);
                        postData3.rt().getGodUserData().setIsLike(this.eOO == 1);
                        rt.getGodUserData().setIsFromNetWork(false);
                        postData3.rt().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eOK != null) {
                this.eOK.a(true, getErrorCode(), i, i4, this.eOE, this.mErrorString, 1);
            }
        }
        if (this.eOE != null && this.eOE.aPW() != null && this.eOE.aPU() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.brT;
            historyMessage.threadId = getPbData().aPW().getId();
            historyMessage.forumName = getPbData().aPU().getName();
            historyMessage.threadName = getPbData().aPW().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aSI();
            historyMessage.threadType = getPbData().aPW().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ai;
        if (arrayList != null && fVar.aPY() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPY(), 0);
            if (postData != null && (ai = ai(arrayList)) != null && ai.equals(postData.getId())) {
                fVar.aPY().remove(postData);
            }
            arrayList.addAll(fVar.aPY());
        }
    }

    private int pK(int i) {
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

    private String ai(ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.v.u(arrayList);
        if (u <= 0) {
            return null;
        }
        for (int i = u - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.baidu.tieba.pb.data.f fVar) {
        fVar.pr(this.eOE.aQn());
        this.eOE = fVar;
        pG(fVar.qv().qp());
    }

    private void aSR() {
        if (this.eOE != null && this.eOE.aPY() != null && this.eOE.aQl() != null) {
            ArrayList<PostData> aPY = this.eOE.aPY();
            com.baidu.tieba.pb.data.a aQl = this.eOE.aQl();
            int aPM = aQl.aPM();
            if (aPM > 0) {
                if (aPM <= aPY.size()) {
                    aPY.add(aPM, aQl);
                } else {
                    aPY.add(aQl);
                }
            }
        }
    }

    public boolean aSS() {
        if (this.eOn == null || this.eOo == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pI(4);
        }
        return pI(6);
    }

    public boolean iZ(boolean z) {
        if (this.eOn == null || this.eOE == null) {
            return false;
        }
        if (z || this.eOE.qv().qr() != 0) {
            return pI(1);
        }
        return false;
    }

    public boolean ja(boolean z) {
        if (this.eOn == null || this.eOE == null) {
            return false;
        }
        if ((z || this.eOE.qv().qs() != 0) && this.eOE.aPY() != null && this.eOE.aPY().size() >= 1) {
            return pI(2);
        }
        return false;
    }

    public boolean pz(String str) {
        this.eOq = !this.eOq;
        this.eOo = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (pI(6)) {
            return true;
        }
        this.eOq = this.eOq ? false : true;
        return false;
    }

    public boolean k(boolean z, String str) {
        if (this.eOq == z) {
            return false;
        }
        this.eOq = z;
        this.eOo = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (pI(6)) {
            return true;
        }
        this.eOq = z ? false : true;
        return false;
    }

    public boolean aST() {
        this.eOr = this.eOs;
        this.eOs = !this.eOs;
        if (this.isLoading || !LoadData()) {
            this.eOs = this.eOs ? false : true;
            return false;
        }
        return true;
    }

    public boolean aSU() {
        return this.eOs;
    }

    public boolean hasData() {
        return (this.eOE == null || this.eOE.aPU() == null || this.eOE.aPW() == null) ? false : true;
    }

    public boolean nC() {
        if (this.eOE == null) {
            return false;
        }
        return this.eOE.nC();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eOE == null || this.eOE.aPW() == null || this.eOE.aPU() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eOE.aPW().sH()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eOE.aPU().getId());
            writeData.setForumName(this.eOE.aPU().getName());
        }
        writeData.setThreadId(this.eOn);
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

    public MarkData pL(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eOE == null) {
            return null;
        }
        ArrayList<PostData> aPY = this.eOE.aPY();
        if (com.baidu.tbadk.core.util.v.v(aPY)) {
            return null;
        }
        if (aPY.size() > 0 && i >= aPY.size()) {
            i = aPY.size() - 1;
        }
        return h(aPY.get(i));
    }

    public MarkData aSV() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eOn);
        markData.setPostId(this.eOE.nB());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eOq);
        markData.setSequence(Boolean.valueOf(this.eOs));
        markData.setId(this.eOn);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eOn);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eOq);
        markData.setSequence(Boolean.valueOf(this.eOs));
        markData.setId(this.eOn);
        markData.setFloor(postData.buG());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aSW() {
        i.aSv().M(aSX(), this.isFromMark);
    }

    private String aSX() {
        String str = this.eOn;
        if (this.eOq) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eOs) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void jb(boolean z) {
        if (this.eOE != null) {
            this.eOE.ab(z);
        }
    }

    public void jc(boolean z) {
        this.eOP = z;
    }

    public boolean aSY() {
        return this.eOP;
    }

    public void a(a aVar) {
        this.eOK = aVar;
    }

    public void oY(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Do() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dn() {
        return Fr();
    }

    public boolean pA(String str) {
        if (getPbData() == null || getPbData().aPW() == null || getPbData().aPW().rt() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPW().rt().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aSZ() {
        return this.mRequestType;
    }

    public void aTa() {
        String aSX = aSX();
        i.aSv().M(aSX, false);
        i.aSv().M(aSX, true);
    }

    public void aTb() {
        if ("personalize_page".equals(this.mStType)) {
            this.eOV = System.currentTimeMillis() / 1000;
        }
    }

    public void aTc() {
        if ("personalize_page".equals(this.mStType) && this.eOE != null && this.eOV != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac(ImageViewerConfig.FORUM_ID, this.eOE.getForumId()).ac("tid", this.eOn).ac("obj_duration", String.valueOf(currentTimeMillis - this.eOV)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eOV = 0L;
        }
    }

    public boolean aTd() {
        return this.eOY;
    }

    public int getErrorNo() {
        return this.ePa;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j aTe() {
        return this.ePc;
    }

    public o aTf() {
        return this.ePd;
    }

    public PbFloorAgreeModel aTg() {
        return this.ePe;
    }

    public x aTh() {
        return this.ePf;
    }

    public CheckRealNameModel aTi() {
        return this.bzl;
    }

    public AddExperiencedModel aTj() {
        return this.ePh;
    }

    public String aTk() {
        return this.eOU;
    }

    public void pB(String str) {
        this.eOU = str;
    }

    public boolean aTl() {
        return this.eOZ;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eOE != null && this.eOE.aPY() != null && this.eOE.aPY().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eOE.aPY().size();
                for (int i = 0; i < size; i++) {
                    if (this.eOE.aPY().get(i) != null && this.eOE.aPY().get(i).rt() != null && currentAccount.equals(this.eOE.aPY().get(i).rt().getUserId()) && this.eOE.aPY().get(i).rt().getPendantData() != null) {
                        this.eOE.aPY().get(i).rt().getPendantData().cF(kVar.pQ());
                        this.eOE.aPY().get(i).rt().getPendantData().Q(kVar.Cv());
                    }
                }
            }
        }
    }

    public String aTm() {
        return this.ePg;
    }

    public int aTn() {
        return this.ePl;
    }

    public void pC(String str) {
        if ((!this.eOq || pA(TbadkCoreApplication.getCurrentAccount())) && this.eOE.aPY() != null) {
            this.eOE.qv().bK(1);
            if (this.eOE.qv().qr() == 0) {
                this.eOE.qv().bK(1);
            }
            this.ePm = str;
            pI(8);
        }
    }

    private void pM(int i) {
        if (i != 8) {
            this.ePm = "";
            if (this.ePn != null) {
                if (i == 1 && !this.eOs && !com.baidu.tbadk.core.util.v.v(getPbData().aPY())) {
                    getPbData().aPY().remove(this.ePn);
                    if (this.ePo != null) {
                        getPbData().aPY().remove(this.ePo);
                    }
                    getPbData().aPY().add(0, this.ePn);
                } else {
                    getPbData().aPY().remove(this.ePn);
                    if (this.ePo != null) {
                        getPbData().aPY().remove(this.ePo);
                    }
                }
            }
            this.ePo = null;
        }
    }

    public void aTo() {
        if (this.eOE != null && !com.baidu.tbadk.core.util.v.v(this.eOE.aPY())) {
            if (this.ePo != null) {
                this.eOE.aPY().remove(this.ePo);
                this.ePo = null;
            }
            if (this.ePn != null) {
                this.eOE.aPY().remove(this.ePn);
                this.ePn = null;
            }
        }
    }

    public void bu(int i, int i2) {
        this.ePp = i;
        this.ePq = i2;
    }

    public PostData aTp() {
        return this.ePn;
    }

    public PostData aTq() {
        return this.ePo;
    }

    public int aTr() {
        return this.ePp;
    }
}
