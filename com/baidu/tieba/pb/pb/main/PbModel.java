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
    private int bXI;
    private BaseActivity brJ;
    private final CheckRealNameModel byZ;
    private long cNF;
    private com.baidu.tieba.tbadkCore.d.b ckI;
    private int dWm;
    private com.baidu.adp.framework.listener.a dWw;
    protected String eNT;
    private String eNU;
    private boolean eNV;
    private boolean eNW;
    private boolean eNX;
    private boolean eNY;
    private boolean eNZ;
    private String eOA;
    private long eOB;
    private boolean eOC;
    private int eOD;
    private boolean eOE;
    private boolean eOF;
    private int eOG;
    private final v eOH;
    private final j eOI;
    private final o eOJ;
    private final PbFloorAgreeModel eOK;
    private final x eOL;
    private String eOM;
    private final AddExperiencedModel eON;
    private SuggestEmotionModel eOO;
    private GetSugMatchWordsModel eOP;
    private boolean eOQ;
    private int eOR;
    private String eOS;
    private PostData eOT;
    private PostData eOU;
    private int eOV;
    private int eOW;
    private CustomMessageListener eOX;
    private CustomMessageListener eOY;
    private PraiseData eOZ;
    private long eOa;
    private int eOb;
    private int eOc;
    private int eOd;
    private boolean eOe;
    private boolean eOf;
    private boolean eOg;
    private long eOh;
    private boolean eOi;
    private String eOj;
    protected com.baidu.tieba.pb.data.f eOk;
    private int eOl;
    private boolean eOm;
    private boolean eOn;
    private boolean eOo;
    private boolean eOp;
    private a eOq;
    private String eOr;
    private String eOs;
    private int eOt;
    private int eOu;
    private boolean eOv;
    private boolean eOw;
    private boolean eOx;
    private boolean eOy;
    private boolean eOz;
    private boolean elq;
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
    private static final int eNS = com.baidu.tbadk.data.b.BZ() / 30;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4);

        void f(com.baidu.tieba.pb.data.f fVar);
    }

    public void iS(boolean z) {
        this.eOC = z;
    }

    public PbModel(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.mStType = null;
        this.eNT = null;
        this.eNU = null;
        this.mForumId = null;
        this.eNV = false;
        this.eNW = false;
        this.eNX = true;
        this.eNY = true;
        this.eNZ = false;
        this.mIsGood = 0;
        this.dWm = 0;
        this.eOa = 0L;
        this.eOb = 1;
        this.eOc = 1;
        this.eOd = 1;
        this.bXI = 1;
        this.isAd = false;
        this.eOe = false;
        this.eOf = false;
        this.elq = false;
        this.isFromMark = false;
        this.eOg = false;
        this.eOh = 0L;
        this.eOi = false;
        this.eOj = null;
        this.eOk = null;
        this.isLoading = false;
        this.eOm = false;
        this.eOn = false;
        this.eOo = false;
        this.eOp = false;
        this.mLocate = null;
        this.mContext = null;
        this.eOq = null;
        this.opType = null;
        this.opUrl = null;
        this.eOr = null;
        this.eOs = null;
        this.eOt = -1;
        this.eOu = -1;
        this.ckI = null;
        this.eOw = false;
        this.eOx = false;
        this.postID = null;
        this.eOA = null;
        this.eOB = 0L;
        this.eOC = false;
        this.eOD = -1;
        this.eOF = false;
        this.eOQ = false;
        this.eOR = 0;
        this.eOX = new CustomMessageListener(CmdConfigCustom.PB_PAGE_CACHE_CMD) { // from class: com.baidu.tieba.pb.pb.main.PbModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                final PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage;
                final com.baidu.tieba.pb.data.f pbData;
                PbModel.this.eOz = true;
                if (customResponsedMessage != null && (customResponsedMessage instanceof PbPageReadLocalResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == PbModel.this.unique_id && (pbData = (pbPageReadLocalResponseMessage = (PbPageReadLocalResponseMessage) customResponsedMessage).getPbData()) != null) {
                    PbModel.this.n(pbData);
                    PbModel.this.h(pbData);
                    if (pbData.aPO() != null) {
                        pbData.aPO().bP(0);
                    }
                    if (PbModel.this.eOq != null && pbData != null) {
                        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.PbModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PbModel.this.eOq.a(true, 0, pbPageReadLocalResponseMessage.getUpdateType(), 0, pbData, pbPageReadLocalResponseMessage.getErrorString(), 0);
                            }
                        });
                    }
                }
            }
        };
        this.eOY = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.pb.pb.main.PbModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                    SignData signData = (SignData) customResponsedMessage.getData();
                    if (PbModel.this.getPbData() != null && PbModel.this.getPbData().aPM() != null && PbModel.this.getPbData().aPM().getSignData() != null && signData.forumId.equals(PbModel.this.getPbData().getForumId())) {
                        PbModel.this.getPbData().aPM().getSignData().is_signed = signData.is_signed;
                    }
                }
            }
        };
        this.dWw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.PbModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                long j;
                if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.j.hh()) {
                        PbModel.this.brJ.showToast(responsedMessage.getErrorString());
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
                    if (!PbModel.this.eOw || !PbModel.this.eOx) {
                        if (!PbModel.this.eOw) {
                            PbModel.this.eOw = true;
                        } else {
                            PbModel.this.eOx = true;
                        }
                        if (PbModel.this.eOq != null) {
                            PbModel.this.eOq.a(PbModel.this.aSw(), z, responsedMessage, PbModel.this.eOy, System.currentTimeMillis() - PbModel.this.cNF);
                        }
                    }
                }
            }
        };
        this.eOZ = null;
        registerListener(this.eOX);
        registerListener(this.dWw);
        registerListener(this.eOY);
        this.eOk = new com.baidu.tieba.pb.data.f();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.brJ = baseActivity;
        this.eOH = new v(this, this.brJ);
        this.eOI = new j(this, this.brJ);
        this.eOJ = new o(this, this.brJ);
        this.eOK = new PbFloorAgreeModel(this);
        this.eOL = new x(this, this.brJ);
        this.byZ = new CheckRealNameModel(this.brJ.getPageContext());
        this.eOO = new SuggestEmotionModel();
        this.eON = new AddExperiencedModel(this.brJ.getPageContext());
    }

    protected int aSw() {
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
        this.eNT = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.eNT)) {
            this.eNT = this.eOH.S(intent);
        }
        this.eOR = intent.getIntExtra(PbActivityConfig.KEY_START_FROM, 0);
        this.eNU = intent.getStringExtra("post_id");
        this.mForumId = intent.getStringExtra("forum_id");
        this.eNV = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eNW = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eNY = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dWm = intent.getIntExtra("is_top", 0);
        this.eOa = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.eOg = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.eOe = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eOi = intent.getBooleanExtra("is_pv", false);
        this.eOh = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eOj = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eOs = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.eOr = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.eOm = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eOn = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eOo = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eOu = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eOt = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eOf = intent.getBooleanExtra("from_frs", false);
        this.elq = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eOF = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eOp = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
        this.eOM = intent.getStringExtra(PbActivityConfig.KEY_POST_THREAD_TIP);
    }

    public void initWithBundle(Bundle bundle) {
        this.eOR = bundle.getInt(PbActivityConfig.KEY_START_FROM, 0);
        this.eNT = bundle.getString("thread_id");
        this.eNU = bundle.getString("post_id");
        this.mForumId = bundle.getString("forum_id");
        this.eNV = bundle.getBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, false);
        this.eNW = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.eNY = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.mStType = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dWm = bundle.getInt("is_top", 0);
        this.eOa = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.eOg = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.eOe = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.eOi = bundle.getBoolean("is_pv", false);
        this.eOh = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.eOj = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.eOs = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.eOm = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.eOn = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.eOo = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, false);
        this.eOu = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.eOt = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
        this.eOf = bundle.getBoolean("from_frs", false);
        this.elq = bundle.getBoolean(PbActivityConfig.KEY_FROM_MAINTAB, false);
        this.eOF = bundle.getBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, false);
        this.eOp = bundle.getBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, false);
    }

    public void t(Bundle bundle) {
        bundle.putString("thread_id", this.eNT);
        bundle.putString("post_id", this.eNU);
        bundle.putString("forum_id", this.mForumId);
        bundle.putInt(PbActivityConfig.KEY_START_FROM, this.eOR);
        bundle.putBoolean(PbActivityConfig.KEY_NEED_REPOST_RECOMMEND_FORUM, this.eNV);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.eNW);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.eNY);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dWm);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.eOa);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.eOg);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.eOe);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.eOi);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.eOh);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.eOs);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.eOm);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.eOn);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_MY_GOD, this.eOo);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.eOu);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.eOt);
        bundle.putBoolean("from_frs", this.eOf);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MAINTAB, this.elq);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_SMART_FRS, this.eOF);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_HOTTOPIC, this.eOp);
    }

    public String aSx() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.eNT);
        if (!this.eOg) {
            sb.append(this.eNU);
        }
        sb.append(this.eNW);
        sb.append(this.eNY);
        sb.append(this.mStType);
        sb.append(this.mIsGood);
        sb.append(this.dWm);
        sb.append(this.eOa);
        sb.append(this.eOf);
        sb.append(this.elq);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.eOe);
        sb.append(this.eOi);
        sb.append(this.eOh);
        sb.append(this.eOj);
        sb.append(this.mThreadType);
        sb.append(this.eOm);
        sb.append(this.eOn);
        sb.append(this.eOo);
        if (this.eOs != null) {
            sb.append(this.eOs);
        }
        return sb.toString();
    }

    public String aSy() {
        return this.eOj;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String getPostId() {
        return this.eNU;
    }

    public void pu(String str) {
        this.eNU = str;
    }

    public String aSz() {
        return this.eNT;
    }

    public boolean getHostMode() {
        return this.eNW;
    }

    public boolean aSA() {
        return this.eNY;
    }

    public boolean aSB() {
        return this.eOf;
    }

    public boolean aSC() {
        return this.eNZ;
    }

    public boolean aSD() {
        return this.elq;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aSE() {
        return "hot_topic".equals(this.mStType);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int aEH() {
        return this.dWm;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void it(int i) {
        this.dWm = i;
    }

    public boolean aSF() {
        return this.eOe;
    }

    public boolean aSG() {
        if (this.eOk == null) {
            return false;
        }
        return this.eOk.isValid();
    }

    public String rD() {
        if (this.eOk == null || !this.eOk.nC()) {
            return null;
        }
        return this.eOk.nB();
    }

    public boolean pD(int i) {
        this.eOb = i;
        if (this.eOb > this.eOk.qv().qm()) {
            this.eOb = this.eOk.qv().qm();
        }
        if (this.eOb < 1) {
            this.eOb = 1;
        }
        if (this.eNT == null) {
            return false;
        }
        return pH(5);
    }

    public boolean pE(int i) {
        int si = this.eOk.aPO().si();
        if (i <= si) {
            si = i;
        }
        int i2 = si >= 1 ? si : 1;
        if (this.eNT == null) {
            return false;
        }
        this.eOD = i2;
        return pH(7);
    }

    public void pF(int i) {
        this.eOb = i;
        this.eOc = i;
        this.eOd = i;
    }

    public void pG(int i) {
        if (this.eOc < i) {
            this.eOc = i;
            if (this.eOc - this.eOd >= eNS) {
                this.eOd = (this.eOc - eNS) + 1;
            }
        }
        if (this.eOd > i) {
            this.eOd = i;
            if (this.eOc - this.eOd >= eNS) {
                this.eOc = (this.eOd + eNS) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eOk;
    }

    public com.baidu.tbadk.core.data.ap atJ() {
        if (this.eOk == null) {
            return null;
        }
        return this.eOk.qv();
    }

    public boolean aSH() {
        if (this.eNY && this.eOk.qv().qr() == 0) {
            iT(true);
            return true;
        }
        return false;
    }

    public void pp(String str) {
        if (!StringUtils.isNull(str)) {
            this.eNT = str;
            this.eNU = null;
            this.eNW = false;
            this.eNY = true;
            LoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.eNT == null) {
            return false;
        }
        cancelLoadData();
        if (this.ckI == null) {
            this.ckI = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.ckI.start();
        }
        boolean pH = pH(3);
        if (this.opType != null) {
            this.opType = null;
            this.eOr = null;
            this.opUrl = null;
            return pH;
        }
        return pH;
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
        if (this.eOO != null) {
            this.eOO.cancelLoadData();
        }
        if (this.eOK != null) {
            this.eOK.cancelLoadData();
        }
        if (this.eOP != null) {
            this.eOP.cancelLoadData();
        }
        afn();
    }

    private void afn() {
        if (this.ckI != null) {
            this.ckI.destory();
            this.ckI = null;
        }
    }

    public boolean Ff() {
        return (this.eNU == null || this.eNU.equals("0") || this.eNU.length() == 0) ? LoadData() : aSK();
    }

    public void a(ForumData forumData, SuggestEmotionModel.a aVar) {
        if (forumData != null && !TextUtils.isEmpty(forumData.getId()) && !TextUtils.isEmpty(forumData.getName())) {
            this.eOO.a(forumData.getId(), forumData.getName(), aVar);
        }
    }

    public void a(GetSugMatchWordsModel.a aVar) {
        if (aVar != null) {
            if (this.eOP == null) {
                this.eOP = new GetSugMatchWordsModel(this.brJ.getPageContext());
            }
            this.eOP.b(aVar);
        }
    }

    public boolean pH(int i) {
        int i2;
        this.mRequestType = i;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        pI(i);
        final com.baidu.tieba.pb.data.f pbData = ag.aTG().getPbData();
        if (pbData != null && pbData.aPO() != null) {
            pbData.aPO().bP(0);
            this.eNY = ag.aTG().aSA();
            this.eNW = ag.aTG().aTL();
            this.eNZ = ag.aTG().aTM();
            this.eOT = ag.aTG().aTK();
            this.eOU = ag.aTG().aTJ();
            this.eOV = ag.aTG().aTI();
            this.eOQ = this.eNW;
            if (this.eNW || this.isFromMark) {
                this.eOv = false;
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
        if (i == 4 && !this.eOz) {
            a(aSP(), true, this.eNU, 3);
        }
        if (i == 3 && !this.eOz) {
            if (this.isFromMark) {
                a(aSP(), true, this.eNU, 3);
            } else {
                a(aSP(), false, this.eNU, 3);
            }
        }
        this.eOz = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aAi);
        if (this.eNW || this.isFromMark) {
            this.eOv = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eNT == null || this.eNT.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eNT, 0L));
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
        if (!this.eNY) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eNW) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.mStType != null) {
            pbPageRequestMessage.set_st_type(this.mStType);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.eOi) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.eOh));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.eOv) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.eOr, 0));
            pbPageRequestMessage.setOpMessageID(this.eOh);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<PostData> aPQ = this.eOk.aPQ();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.eNY) {
                        if (this.eOd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eOd - 1));
                        }
                    } else if (this.eOc < this.bXI) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eOc + 1));
                    }
                }
                if (aPQ != null && aPQ.size() > 0) {
                    int size = aPQ.size();
                    int i4 = 1;
                    while (size - i4 >= 0) {
                        PostData postData = aPQ.get(size - i4);
                        if (postData == null) {
                            i2 = i4 + 1;
                        } else {
                            this.eNU = postData.getId();
                            if (StringUtils.isNull(this.eNU)) {
                                i2 = i4 + 1;
                            }
                        }
                        i4 = i2;
                    }
                }
                if (this.eNU != null && this.eNU.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eNU, 0L));
                } else if (!this.eNY) {
                    pbPageRequestMessage.set_last(1);
                }
                b(pbPageRequestMessage);
                break;
            case 2:
                if (aPQ != null && aPQ.size() > 0 && aPQ.get(0) != null) {
                    this.eNU = aPQ.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.eNY) {
                        if (this.eOd - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.eOd - 1));
                        }
                    } else if (this.eOc < this.bXI) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.eOc + 1));
                    }
                }
                if (this.eNU != null && this.eNU.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eNU, 0L));
                }
                b(pbPageRequestMessage);
                break;
            case 3:
                if (this.isFromMark || this.eNW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                pbPageRequestMessage.set_back(0);
                if (this.eNY) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eNU, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.eOb));
                pbPageRequestMessage.set_banner(0);
                b(pbPageRequestMessage);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                if (!this.eNY && this.eOQ && !this.eNW) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eNU, 0L));
                }
                pbPageRequestMessage.set_back(0);
                if (this.eNW) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                b(pbPageRequestMessage);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.eOD);
                b(pbPageRequestMessage);
                break;
            case 8:
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.eOS, 0L));
                if (!this.eNY) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    break;
                }
                break;
        }
        this.eOQ = this.eNW;
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aSP());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.brJ != null && (this.brJ instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.brJ).aRi());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.eOC);
        pbPageRequestMessage.setFromSmartFrs(this.eOF ? 1 : 0);
        pbPageRequestMessage.setForumId(this.mForumId);
        pbPageRequestMessage.setNeedRepostRecommendForum(this.eNV);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    private void a(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSy()) && com.baidu.tieba.recapp.r.bja().biU() != null) {
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bja().biU().S(aSy(), true) + 1);
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bja().biU().T(aSy(), true));
        }
    }

    private void b(PbPageRequestMessage pbPageRequestMessage) {
        if (!TextUtils.isEmpty(aSy()) && com.baidu.tieba.recapp.r.bja().biU() != null) {
            pbPageRequestMessage.setLoadCount(com.baidu.tieba.recapp.r.bja().biU().T(aSy(), true) + 1);
            pbPageRequestMessage.setRefreshCount(com.baidu.tieba.recapp.r.bja().biU().S(aSy(), true));
        }
    }

    protected void pI(int i) {
        boolean z = false;
        pL(i);
        ArrayList<PostData> aPQ = this.eOk.aPQ();
        this.eOy = false;
        if (i == 1) {
            boolean z2 = false;
            while (aPQ.size() + 30 > com.baidu.tbadk.data.b.BZ()) {
                aPQ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eOk.qv().bL(1);
                if (this.eOq != null) {
                    this.eOq.f(this.eOk);
                }
            }
            this.cNF = System.currentTimeMillis();
            this.eOy = true;
        } else if (i == 2) {
            while (aPQ.size() + 30 > com.baidu.tbadk.data.b.BZ()) {
                aPQ.remove(aPQ.size() - 1);
                z = true;
            }
            if (z) {
                this.eOk.qv().bK(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.eOG = i2;
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
            if (this.eOo || this.eOm || this.eOn) {
                fVar = j(fVar);
            }
            i(fVar);
        }
    }

    protected void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            String k = k(fVar);
            for (int i = 0; i < fVar.aPQ().size(); i++) {
                PostData postData = fVar.aPQ().get(i);
                for (int i2 = 0; i2 < postData.bur().size(); i2++) {
                    postData.bur().get(i2).b(this.brJ.getPageContext(), k.equals(postData.bur().get(i2).rt().getUserId()));
                }
            }
            com.baidu.tieba.pb.data.n aPY = fVar.aPY();
            if (aPY != null && !com.baidu.tbadk.core.util.v.v(aPY.eHj)) {
                for (PostData postData2 : aPY.eHj) {
                    for (int i3 = 0; i3 < postData2.bur().size(); i3++) {
                        postData2.bur().get(i3).b(this.brJ.getPageContext(), k.equals(postData2.bur().get(i3).rt().getUserId()));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i) {
        if (fVar != null) {
            String k = k(fVar);
            com.baidu.tieba.pb.data.n aPY = fVar.aPY();
            if (aPY != null && !com.baidu.tbadk.core.util.v.v(aPY.eHj)) {
                for (PostData postData : aPY.eHj.subList(i, aPY.eHj.size())) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < postData.bur().size()) {
                            postData.bur().get(i3).b(this.brJ.getPageContext(), k.equals(postData.bur().get(i3).rt().getUserId()));
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
        bh aPO = fVar.aPO();
        aPO.bT(this.mIsGood);
        aPO.bS(this.dWm);
        if (this.eOa > 0) {
            aPO.m(this.eOa);
            return fVar;
        }
        return fVar;
    }

    protected String k(com.baidu.tieba.pb.data.f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        if (fVar.aPO() != null && fVar.aPO().rt() != null) {
            str = fVar.aPO().rt().getUserId();
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
        if (fVar.aPO() != null && fVar.aPO().rt() != null) {
            str = fVar.aPO().rt().getUserName();
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
        if (fVar.aPO() != null && fVar.aPO().rt() != null) {
            str = fVar.aPO().rt().getName_show();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aSI() {
        if (this.eOk == null || this.eOk.aPO() == null || this.eOk.aPO().rt() == null) {
            return null;
        }
        return this.eOk.aPO().rt();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        boolean z4 = !z;
        this.eOE = z3;
        this.eOl = i;
        if (this.ckI != null && !z3) {
            this.ckI.a(z2, z4, i2, str, i3, j, j2);
            this.ckI = null;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(aSy()) && com.baidu.tieba.recapp.r.bja().biU() != null) {
            com.baidu.tieba.recapp.r.bja().biU().f(aSy(), pJ(aSR()), true);
        }
        if (fVar == null || (this.eOb == 1 && i == 5 && fVar.aPQ() != null && fVar.aPQ().size() < 1)) {
            if (this.eOq != null) {
                this.eNY = this.eNX;
                this.eOq.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.eNX = this.eNY;
            this.eOi = false;
            if (fVar.qv() != null) {
                pG(fVar.qv().qp());
                this.bXI = fVar.qv().qm();
            }
            this.bXI = this.bXI < 1 ? 1 : this.bXI;
            ArrayList<PostData> aPQ = this.eOk.aPQ();
            switch (i) {
                case 1:
                    this.eOk.a(fVar.qv(), 1);
                    e(fVar, aPQ);
                    i4 = 0;
                    break;
                case 2:
                    if (fVar.aPQ() == null) {
                        i5 = 0;
                    } else {
                        int size = fVar.aPQ().size() + 1;
                        PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(aPQ, 0);
                        PostData postData2 = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPQ(), com.baidu.tbadk.core.util.v.u(fVar.aPQ()) - 1);
                        if (postData == null || postData2 == null || !postData.getId().equals(postData2.getId())) {
                            i5 = size;
                        } else {
                            fVar.aPQ().remove(postData2);
                            i5 = size - 1;
                        }
                        aPQ.addAll(0, fVar.aPQ());
                    }
                    this.eOk.a(fVar.qv(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.eNY && fVar.qv() != null) {
                        fVar.qv().bI(fVar.qv().qm());
                    }
                    n(fVar);
                    if (!z3 && this.mThreadType != 33 && this.eNY) {
                        aSJ();
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
                    if (fVar != null && !com.baidu.tbadk.core.util.v.v(fVar.aPQ()) && this.eOk != null && (!this.eNW || k(fVar).equals(fVar.aPQ().get(0).rt().getUserId()))) {
                        if (this.eOk.qv().qr() == 0) {
                            this.eOk.qv().bK(1);
                        }
                        aTg();
                        this.eOT = fVar.aPQ().get(0);
                        if (this.eNY) {
                            if (this.eOk.aPQ().size() - this.eOV >= 3) {
                                this.eOU = new PostData();
                                this.eOU.gpJ = true;
                                this.eOU.setPostType(53);
                                this.eOk.aPQ().add(this.eOU);
                            }
                            this.eOk.aPQ().add(this.eOT);
                            i4 = this.eOk.aPQ().size() - 1;
                            break;
                        } else {
                            if (this.eOV - this.eOW >= 3) {
                                this.eOU = new PostData();
                                this.eOU.gpJ = false;
                                this.eOU.setPostType(53);
                                this.eOk.aPQ().add(0, this.eOU);
                            }
                            this.eOk.aPQ().add(0, this.eOT);
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
            if (this.eOk != null && this.eOk.aPO() != null) {
                PraiseData ri = this.eOk.aPO().ri();
                if (this.eOZ != null && !ri.isPriaseDataValid()) {
                    this.eOk.aPO().a(this.eOZ);
                } else {
                    this.eOZ = this.eOk.aPO().ri();
                    this.eOZ.setPostId(this.eOk.aPO().rK());
                }
                if (fVar.qv() != null && fVar.qv().qp() == 1 && fVar.aPO() != null && fVar.aPO().rF() != null && fVar.aPO().rF().size() > 0) {
                    this.eOk.aPO().h(fVar.aPO().rF());
                }
                this.eOk.aPO().bQ(fVar.aPO().rl());
                this.eOk.aPO().bN(fVar.aPO().getAnchorLevel());
                this.eOk.aPO().bP(fVar.aPO().re());
                if (this.mThreadType == 33) {
                    this.eOk.aPO().rt().setHadConcerned(fVar.aPO().rt().hadConcerned());
                }
            }
            if (this.eOk != null && this.eOk.getUserData() != null && fVar.getUserData() != null) {
                this.eOk.getUserData().setBimg_end_time(fVar.getUserData().getBimg_end_time());
                this.eOk.getUserData().setBimg_url(fVar.getUserData().getBimg_url());
            }
            if (fVar.qv() != null && fVar.qv().qp() == 1 && fVar.aPX() != null) {
                this.eOk.c(fVar.aPX());
            }
            if (this.eOE && this.eOk.aPO() != null && this.eOk.aPO().rt() != null && this.eOk.aPQ() != null && com.baidu.tbadk.core.util.v.c(this.eOk.aPQ(), 0) != null) {
                PostData postData3 = (PostData) com.baidu.tbadk.core.util.v.c(this.eOk.aPQ(), 0);
                MetaData rt = this.eOk.aPO().rt();
                if (postData3.rt() != null && postData3.rt().getGodUserData() != null) {
                    if (this.eOt != -1) {
                        rt.setFansNum(this.eOt);
                        postData3.rt().setFansNum(this.eOt);
                    }
                    if (this.eOu != -1) {
                        rt.getGodUserData().setIsLike(this.eOu == 1);
                        postData3.rt().getGodUserData().setIsLike(this.eOu == 1);
                        rt.getGodUserData().setIsFromNetWork(false);
                        postData3.rt().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eOq != null) {
                this.eOq.a(true, getErrorCode(), i, i4, this.eOk, this.mErrorString, 1);
            }
        }
        if (this.eOk != null && this.eOk.aPO() != null && this.eOk.aPM() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.brJ;
            historyMessage.threadId = getPbData().aPO().getId();
            historyMessage.forumName = getPbData().aPM().getName();
            historyMessage.threadName = getPbData().aPO().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aSA();
            historyMessage.threadType = getPbData().aPO().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void e(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ai;
        if (arrayList != null && fVar.aPQ() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.v.c(fVar.aPQ(), 0);
            if (postData != null && (ai = ai(arrayList)) != null && ai.equals(postData.getId())) {
                fVar.aPQ().remove(postData);
            }
            arrayList.addAll(fVar.aPQ());
        }
    }

    private int pJ(int i) {
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
        fVar.pn(this.eOk.aQf());
        this.eOk = fVar;
        pF(fVar.qv().qp());
    }

    private void aSJ() {
        if (this.eOk != null && this.eOk.aPQ() != null && this.eOk.aQd() != null) {
            ArrayList<PostData> aPQ = this.eOk.aPQ();
            com.baidu.tieba.pb.data.a aQd = this.eOk.aQd();
            int aPE = aQd.aPE();
            if (aPE > 0) {
                if (aPE <= aPQ.size()) {
                    aPQ.add(aPE, aQd);
                } else {
                    aPQ.add(aQd);
                }
            }
        }
    }

    public boolean aSK() {
        if (this.eNT == null || this.eNU == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return pH(4);
        }
        return pH(6);
    }

    public boolean iT(boolean z) {
        if (this.eNT == null || this.eOk == null) {
            return false;
        }
        if (z || this.eOk.qv().qr() != 0) {
            return pH(1);
        }
        return false;
    }

    public boolean iU(boolean z) {
        if (this.eNT == null || this.eOk == null) {
            return false;
        }
        if ((z || this.eOk.qv().qs() != 0) && this.eOk.aPQ() != null && this.eOk.aPQ().size() >= 1) {
            return pH(2);
        }
        return false;
    }

    public boolean pv(String str) {
        this.eNW = !this.eNW;
        this.eNU = str;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0));
        if (pH(6)) {
            return true;
        }
        this.eNW = this.eNW ? false : true;
        return false;
    }

    public boolean j(boolean z, String str) {
        if (this.eNW == z) {
            return false;
        }
        this.eNW = z;
        this.eNU = str;
        if (z) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("pb_onlyowner_click").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
        if (pH(6)) {
            return true;
        }
        this.eNW = z ? false : true;
        return false;
    }

    public boolean aSL() {
        this.eNX = this.eNY;
        this.eNY = !this.eNY;
        if (this.isLoading || !LoadData()) {
            this.eNY = this.eNY ? false : true;
            return false;
        }
        return true;
    }

    public boolean aSM() {
        return this.eNY;
    }

    public boolean hasData() {
        return (this.eOk == null || this.eOk.aPM() == null || this.eOk.aPO() == null) ? false : true;
    }

    public boolean nC() {
        if (this.eOk == null) {
            return false;
        }
        return this.eOk.nC();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fP(String str) {
        if (this.eOk == null || this.eOk.aPO() == null || this.eOk.aPM() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.eOk.aPO().sH()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.eOk.aPM().getId());
            writeData.setForumName(this.eOk.aPM().getName());
        }
        writeData.setThreadId(this.eNT);
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

    public MarkData pK(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eOk == null) {
            return null;
        }
        ArrayList<PostData> aPQ = this.eOk.aPQ();
        if (com.baidu.tbadk.core.util.v.v(aPQ)) {
            return null;
        }
        if (aPQ.size() > 0 && i >= aPQ.size()) {
            i = aPQ.size() - 1;
        }
        return h(aPQ.get(i));
    }

    public MarkData aSN() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eNT);
        markData.setPostId(this.eOk.nB());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eNW);
        markData.setSequence(Boolean.valueOf(this.eNY));
        markData.setId(this.eNT);
        return markData;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.eNT);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.eNW);
        markData.setSequence(Boolean.valueOf(this.eNY));
        markData.setId(this.eNT);
        markData.setFloor(postData.buu());
        markData.setForumId(this.mForumId);
        if (postData instanceof com.baidu.tieba.pb.data.d) {
            markData.setApp(true);
        } else if (postData instanceof com.baidu.tieba.tbadkCore.data.l) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.l) postData).isApp());
        }
        return markData;
    }

    public void aSO() {
        i.aSn().M(aSP(), this.isFromMark);
    }

    private String aSP() {
        String str = this.eNT;
        if (this.eNW) {
            str = str + DB_KEY_HOST;
        }
        if (!this.eNY) {
            str = str + DB_KEY_REVER;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return str + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void iV(boolean z) {
        if (this.eOk != null) {
            this.eOk.ab(z);
        }
    }

    public void iW(boolean z) {
        this.eOv = z;
    }

    public boolean aSQ() {
        return this.eOv;
    }

    public void a(a aVar) {
        this.eOq = aVar;
    }

    public void oU(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dc() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Db() {
        return Ff();
    }

    public boolean pw(String str) {
        if (getPbData() == null || getPbData().aPO() == null || getPbData().aPO().rt() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPO().rt().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aSR() {
        return this.mRequestType;
    }

    public void aSS() {
        String aSP = aSP();
        i.aSn().M(aSP, false);
        i.aSn().M(aSP, true);
    }

    public void aST() {
        if ("personalize_page".equals(this.mStType)) {
            this.eOB = System.currentTimeMillis() / 1000;
        }
    }

    public void aSU() {
        if ("personalize_page".equals(this.mStType) && this.eOk != null && this.eOB != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c10754").ac(ImageViewerConfig.FORUM_ID, this.eOk.getForumId()).ac("tid", this.eNT).ac("obj_duration", String.valueOf(currentTimeMillis - this.eOB)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.eOB = 0L;
        }
    }

    public boolean aSV() {
        return this.eOE;
    }

    public int getErrorNo() {
        return this.eOG;
    }

    public com.baidu.tieba.pb.data.e getAppealInfo() {
        return this.mAppealInfo;
    }

    public j aSW() {
        return this.eOI;
    }

    public o aSX() {
        return this.eOJ;
    }

    public PbFloorAgreeModel aSY() {
        return this.eOK;
    }

    public x aSZ() {
        return this.eOL;
    }

    public CheckRealNameModel aTa() {
        return this.byZ;
    }

    public AddExperiencedModel aTb() {
        return this.eON;
    }

    public String aTc() {
        return this.eOA;
    }

    public void px(String str) {
        this.eOA = str;
    }

    public boolean aTd() {
        return this.eOF;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        if (kVar != null && this.eOk != null && this.eOk.aPQ() != null && this.eOk.aPQ().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.eOk.aPQ().size();
                for (int i = 0; i < size; i++) {
                    if (this.eOk.aPQ().get(i) != null && this.eOk.aPQ().get(i).rt() != null && currentAccount.equals(this.eOk.aPQ().get(i).rt().getUserId()) && this.eOk.aPQ().get(i).rt().getPendantData() != null) {
                        this.eOk.aPQ().get(i).rt().getPendantData().cF(kVar.pQ());
                        this.eOk.aPQ().get(i).rt().getPendantData().Q(kVar.Cj());
                    }
                }
            }
        }
    }

    public String aTe() {
        return this.eOM;
    }

    public int aTf() {
        return this.eOR;
    }

    public void py(String str) {
        if ((!this.eNW || pw(TbadkCoreApplication.getCurrentAccount())) && this.eOk.aPQ() != null) {
            this.eOk.qv().bK(1);
            if (this.eOk.qv().qr() == 0) {
                this.eOk.qv().bK(1);
            }
            this.eOS = str;
            pH(8);
        }
    }

    private void pL(int i) {
        if (i != 8) {
            this.eOS = "";
            if (this.eOT != null) {
                if (i == 1 && !this.eNY && !com.baidu.tbadk.core.util.v.v(getPbData().aPQ())) {
                    getPbData().aPQ().remove(this.eOT);
                    if (this.eOU != null) {
                        getPbData().aPQ().remove(this.eOU);
                    }
                    getPbData().aPQ().add(0, this.eOT);
                } else {
                    getPbData().aPQ().remove(this.eOT);
                    if (this.eOU != null) {
                        getPbData().aPQ().remove(this.eOU);
                    }
                }
            }
            this.eOU = null;
        }
    }

    public void aTg() {
        if (this.eOk != null && !com.baidu.tbadk.core.util.v.v(this.eOk.aPQ())) {
            if (this.eOU != null) {
                this.eOk.aPQ().remove(this.eOU);
                this.eOU = null;
            }
            if (this.eOT != null) {
                this.eOk.aPQ().remove(this.eOT);
                this.eOT = null;
            }
        }
    }

    public void bv(int i, int i2) {
        this.eOV = i;
        this.eOW = i2;
    }

    public PostData aTh() {
        return this.eOT;
    }

    public PostData aTi() {
        return this.eOU;
    }

    public int aTj() {
        return this.eOV;
    }
}
