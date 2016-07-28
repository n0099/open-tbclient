package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class dh extends com.baidu.tbadk.editortools.d.a {
    private static final int edb = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int edc = 1;
    private CustomMessageListener aPt;
    private String aex;
    private boolean axe;
    private long bRq;
    private BaseActivity bem;
    private com.baidu.tieba.tbadkCore.d.b bwf;
    private int dQh;
    private int dlf;
    private com.baidu.adp.framework.listener.a dlu;
    private int edA;
    private boolean edB;
    private boolean edC;
    private boolean edD;
    private boolean edE;
    private boolean edF;
    private String edG;
    private long edH;
    private boolean edI;
    private int edJ;
    private boolean edK;
    private int edL;
    private final dn edM;
    private final da edN;
    private final cq edO;
    private final ct edP;
    private CustomMessageListener edQ;
    private PraiseData edR;
    protected String edd;
    private String ede;
    private boolean edf;
    private boolean edg;
    private boolean edh;
    private long edi;
    private int edj;
    private int edk;
    private int edl;
    private boolean edm;
    private boolean edn;
    private boolean edo;
    private long edp;
    private boolean edq;
    private String edr;
    protected com.baidu.tieba.pb.data.h eds;
    private int edt;
    private boolean edu;
    private boolean edv;
    private a edw;
    private String edx;
    private String edy;
    private int edz;
    private boolean isAd;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.g mAppealInfo;
    protected Context mContext;
    private int mIsGood;
    private String mLocate;
    private int mRequestType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.h hVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.h hVar);
    }

    public String aIT() {
        return this.edG;
    }

    public void oj(String str) {
        this.edG = str;
    }

    public void hG(boolean z) {
        this.edI = z;
    }

    public dh(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aex = null;
        this.edd = null;
        this.ede = null;
        this.edf = false;
        this.edg = true;
        this.edh = true;
        this.mIsGood = 0;
        this.dlf = 0;
        this.edi = 0L;
        this.edj = 1;
        this.edk = 1;
        this.edl = 1;
        this.dQh = 1;
        this.isAd = false;
        this.edm = false;
        this.edn = false;
        this.isFromMark = false;
        this.edo = false;
        this.edp = 0L;
        this.edq = false;
        this.edr = null;
        this.eds = null;
        this.axe = false;
        this.edu = false;
        this.edv = false;
        this.mLocate = null;
        this.mContext = null;
        this.edw = null;
        this.opType = null;
        this.opUrl = null;
        this.edx = null;
        this.edy = null;
        this.edz = -1;
        this.edA = -1;
        this.bwf = null;
        this.edC = false;
        this.edD = false;
        this.postID = null;
        this.edG = null;
        this.edH = 0L;
        this.edI = false;
        this.edJ = -1;
        this.aPt = new di(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.edQ = new dk(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.dlu = new dl(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.edR = null;
        registerListener(this.aPt);
        registerListener(this.dlu);
        registerListener(this.edQ);
        this.eds = new com.baidu.tieba.pb.data.h();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bem = baseActivity;
        this.edM = new dn(this, this.bem);
        this.edN = new da(this, this.bem);
        this.edO = new cq(this, this.bem);
        this.edP = new ct(this, this.bem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int aIU() {
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
        this.edd = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.edd)) {
            this.edd = this.edM.x(intent);
        }
        this.ede = intent.getStringExtra("post_id");
        this.edf = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.edh = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aex = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra("is_good", 0);
        this.dlf = intent.getIntExtra("is_top", 0);
        this.edi = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.edn = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.edo = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.edm = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.edq = intent.getBooleanExtra("is_pv", false);
        this.edp = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.edr = intent.getStringExtra(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.edy = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.edx = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.edu = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.edv = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.edA = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.edz = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.edd = bundle.getString("thread_id");
        this.ede = bundle.getString("post_id");
        this.edf = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.edh = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aex = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt("is_good", 0);
        this.dlf = bundle.getInt("is_top", 0);
        this.edi = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.edn = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.edo = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.edm = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.edq = bundle.getBoolean("is_pv", false);
        this.edp = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.edr = bundle.getString(PbActivityConfig.KEY_FROM_FORUM_NAME);
        this.edy = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.edu = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.edv = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, false);
        this.edA = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.edz = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void n(Bundle bundle) {
        bundle.putString("thread_id", this.edd);
        bundle.putString("post_id", this.ede);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.edf);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.edh);
        bundle.putString("st_type", this.aex);
        bundle.putString("locate", this.mLocate);
        bundle.putInt("is_good", this.mIsGood);
        bundle.putInt("is_top", this.dlf);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.edi);
        bundle.putBoolean("from_frs", this.edn);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.edo);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.edm);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.edq);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.edp);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.edy);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.edu);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_INTERVIEW_LIVE_CONFIG, this.edv);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.edA);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.edz);
    }

    public String aIV() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.edd);
        if (!this.edo) {
            sb.append(this.ede);
        }
        sb.append(this.edf);
        sb.append(this.edh);
        sb.append(this.aex);
        sb.append(this.mIsGood);
        sb.append(this.dlf);
        sb.append(this.edi);
        sb.append(this.edn);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.edm);
        sb.append(this.edq);
        sb.append(this.edp);
        sb.append(this.edr);
        sb.append(this.mThreadType);
        sb.append(this.edu);
        sb.append(this.edv);
        if (this.edy != null) {
            sb.append(this.edy);
        }
        return sb.toString();
    }

    public String aIW() {
        return this.edr;
    }

    public String getPostId() {
        return this.ede;
    }

    public void ok(String str) {
        this.ede = str;
    }

    public String getThreadID() {
        return this.edd;
    }

    public boolean getHostMode() {
        return this.edf;
    }

    public boolean aIX() {
        return this.edh;
    }

    public boolean aIY() {
        return this.edn;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean aIZ() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.aex);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int avI() {
        return this.dlf;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void nD(int i) {
        this.dlf = i;
    }

    public boolean aJa() {
        return this.edm;
    }

    public boolean aJb() {
        if (this.eds == null) {
            return false;
        }
        return this.eds.isValid();
    }

    public String qE() {
        if (this.eds == null || !this.eds.mA()) {
            return null;
        }
        return this.eds.mz();
    }

    public boolean nE(int i) {
        this.edj = i;
        if (this.edj > this.eds.getPage().pi()) {
            this.edj = this.eds.getPage().pi();
        }
        if (this.edj < 1) {
            this.edj = 1;
        }
        if (this.edd == null) {
            return false;
        }
        return nI(5);
    }

    public boolean nF(int i) {
        int rj = this.eds.aGY().rj();
        if (i <= rj) {
            rj = i;
        }
        int i2 = rj >= 1 ? rj : 1;
        if (this.edd == null) {
            return false;
        }
        this.edJ = i2;
        return nI(7);
    }

    public void nG(int i) {
        this.edj = i;
        this.edk = i;
        this.edl = i;
    }

    public void nH(int i) {
        if (this.edk < i) {
            this.edk = i;
            if (this.edk - this.edl >= edb) {
                this.edl = (this.edk - edb) + 1;
            }
        }
        if (this.edl > i) {
            this.edl = i;
            if (this.edk - this.edl >= edb) {
                this.edk = (this.edl + edb) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.eds;
    }

    public com.baidu.tbadk.core.data.aj akg() {
        if (this.eds == null) {
            return null;
        }
        return this.eds.getPage();
    }

    public boolean aJc() {
        if (this.edh) {
            if (this.eds.getPage().pn() == 0) {
                hH(true);
                return true;
            }
        } else if (this.eds.getPage().po() == 0) {
            hI(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.edd == null) {
            return false;
        }
        cancelLoadData();
        if (this.bwf == null) {
            this.bwf = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bwf.start();
        }
        boolean nI = nI(3);
        if (this.opType != null) {
            this.opType = null;
            this.edx = null;
            this.opUrl = null;
            return nI;
        }
        return nI;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.axe = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Td();
    }

    private void Td() {
        if (this.bwf != null) {
            this.bwf.destory();
            this.bwf = null;
        }
    }

    public boolean DG() {
        return (this.ede == null || this.ede.equals("0") || this.ede.length() == 0) ? LoadData() : aJf();
    }

    public boolean nI(int i) {
        this.mRequestType = i;
        if (this.axe) {
            return false;
        }
        this.axe = true;
        nJ(i);
        com.baidu.tieba.pb.data.h pbData = ep.aJZ().getPbData();
        if (pbData != null && pbData.aGY() != null) {
            pbData.aGY().bG(0);
            this.edh = ep.aJZ().aIX();
            this.edf = ep.aJZ().aKb();
            if (!this.edh || this.edf || this.isFromMark) {
                this.edB = false;
            }
            com.baidu.adp.lib.h.h.dL().post(new dm(this, pbData));
            return false;
        }
        if (i == 4 && !this.edF) {
            a(aJk(), true, this.ede, 3);
        }
        if (i == 3 && !this.edF) {
            if (this.isFromMark) {
                a(aJk(), true, this.ede, 3);
            } else {
                a(aJk(), false, this.ede, 3);
            }
        }
        this.edF = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apZ);
        if (!this.edh || this.edf || this.isFromMark) {
            this.edB = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.edd == null || this.edd.length() == 0) {
            this.axe = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.edd, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getApp());
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.ue().ug() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(A));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.edh) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.edf) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.aex != null) {
            pbPageRequestMessage.set_st_type(this.aex);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.edq) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.edp));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.edB) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.edx, 0));
            pbPageRequestMessage.setOpMessageID(this.edp);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.edh) {
                        if (this.edl - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.edl - 1));
                        }
                    } else if (this.edk < this.dQh) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.edk + 1));
                    }
                }
                if (aGZ != null && aGZ.size() > 0) {
                    int size = aGZ.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.s sVar = aGZ.get(size - i3);
                        if (sVar == null) {
                            i3++;
                        } else {
                            this.ede = sVar.getId();
                            if (StringUtils.isNull(this.ede)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.ede != null && this.ede.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ede, 0L));
                    break;
                } else if (!this.edh) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aGZ != null && aGZ.size() > 0 && aGZ.get(0) != null) {
                    this.ede = aGZ.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.edh) {
                        if (this.edl - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.edl - 1));
                        }
                    } else if (this.edk < this.dQh) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.edk + 1));
                    }
                }
                if (this.ede != null && this.ede.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ede, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.edh) {
                    pbPageRequestMessage.set_pn(1);
                } else {
                    pbPageRequestMessage.set_last(1);
                }
                if (this.isFromMark) {
                    pbPageRequestMessage.set_st_type("store_thread");
                    break;
                }
                break;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ede, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.edj));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.ede, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.edJ);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aJk());
        pbPageRequestMessage.setContext(this.mContext);
        if (this.bem != null && (this.bem instanceof PbActivity)) {
            pbPageRequestMessage.setObjParam1(((PbActivity) this.bem).aHL());
        }
        pbPageRequestMessage.setIsSubPostDataReverse(this.edI);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void nJ(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
        this.edE = false;
        if (i == 1) {
            boolean z2 = false;
            while (aGZ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aGZ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.eds.getPage().bD(1);
                if (this.edw != null) {
                    this.edw.c(this.eds);
                }
            }
            this.bRq = System.currentTimeMillis();
            this.edE = true;
        } else if (i == 2) {
            while (aGZ.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                aGZ.remove(aGZ.size() - 1);
                z = true;
            }
            if (z) {
                this.eds.getPage().bC(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.edL = i2;
        this.axe = false;
        if (hVar2 != null) {
            d(hVar2);
        }
        a(hVar2, i, z, i2, str, z2, i3, j, j2, false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            if (this.edu || this.edv) {
                hVar = f(hVar);
            }
            e(hVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null) {
            String g = g(hVar);
            for (int i = 0; i < hVar.aGZ().size(); i++) {
                com.baidu.tieba.tbadkCore.data.s sVar = hVar.aGZ().get(i);
                for (int i2 = 0; i2 < sVar.bfx().size(); i2++) {
                    sVar.bfx().get(i2).b(this.bem.getPageContext(), g.equals(sVar.bfx().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.h f(com.baidu.tieba.pb.data.h hVar) {
        if (hVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.be aGY = hVar.aGY();
        aGY.bJ(this.mIsGood);
        aGY.bI(this.dlf);
        if (this.edi > 0) {
            aGY.p(this.edi);
            return hVar;
        }
        return hVar;
    }

    protected String g(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aGY() != null && hVar.aGY().getAuthor() != null) {
            str = hVar.aGY().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.data.h hVar) {
        String str = null;
        if (hVar == null) {
            return null;
        }
        if (hVar.aGY() != null && hVar.aGY().getAuthor() != null) {
            str = hVar.aGY().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData aJd() {
        if (this.eds == null || this.eds.aGY() == null || this.eds.aGY().getAuthor() == null) {
            return null;
        }
        return this.eds.aGY().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.edK = z3;
        this.edt = i;
        if (this.bwf != null && !z3) {
            this.bwf.a(z2, z4, i2, str, i3, j, j2);
            this.bwf = null;
        }
        if (hVar == null || (this.edj == 1 && i == 5 && hVar.aGZ() != null && hVar.aGZ().size() < 1)) {
            if (this.edw != null) {
                this.edh = this.edg;
                this.edw.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.edg = this.edh;
            this.edq = false;
            if (hVar.getPage() != null) {
                nH(hVar.getPage().pl());
                this.dQh = hVar.getPage().pi();
            }
            this.dQh = this.dQh < 1 ? 1 : this.dQh;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
            switch (i) {
                case 1:
                    this.eds.a(hVar.getPage(), 1);
                    a(hVar, aGZ);
                    i4 = 0;
                    break;
                case 2:
                    if (hVar.aGZ() != null) {
                        int size = hVar.aGZ().size() + 1;
                        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(aGZ, 0);
                        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aGZ(), com.baidu.tbadk.core.util.y.s(hVar.aGZ()) - 1);
                        if (sVar == null || sVar2 == null || !sVar.getId().equals(sVar2.getId())) {
                            i5 = size;
                        } else {
                            hVar.aGZ().remove(sVar2);
                            i5 = size - 1;
                        }
                        aGZ.addAll(0, hVar.aGZ());
                    }
                    this.eds.a(hVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.edh && hVar.getPage() != null) {
                        hVar.getPage().bA(hVar.getPage().pi());
                    }
                    i(hVar);
                    if (!z3 && this.mThreadType != 33 && this.edh) {
                        aJe();
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 4:
                    i(hVar);
                    i4 = 0;
                    break;
                case 5:
                    i(hVar);
                    i4 = 0;
                    break;
                case 6:
                    i(hVar);
                    i4 = 0;
                    break;
                case 7:
                    i(hVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.eds != null && this.eds.aGY() != null) {
                PraiseData qp = this.eds.aGY().qp();
                if (this.edR != null && !qp.isPriaseDataValid()) {
                    this.eds.aGY().a(this.edR);
                } else {
                    this.edR = this.eds.aGY().qp();
                    this.edR.setPostId(this.eds.aGY().qL());
                }
                if (hVar.getPage() != null && hVar.getPage().pl() == 1 && hVar.aGY() != null && hVar.aGY().qG() != null && hVar.aGY().qG().size() > 0) {
                    this.eds.aGY().i(hVar.aGY().qG());
                }
                this.eds.aGY().bH(hVar.aGY().qr());
                this.eds.aGY().setAnchorLevel(hVar.aGY().getAnchorLevel());
                this.eds.aGY().bG(hVar.aGY().qn());
                if (this.mThreadType == 33) {
                    this.eds.aGY().getAuthor().setHadConcerned(hVar.aGY().getAuthor().hadConcerned());
                }
            }
            if (this.eds != null && this.eds.getUserData() != null && hVar.getUserData() != null) {
                this.eds.getUserData().setBimg_end_time(hVar.getUserData().getBimg_end_time());
                this.eds.getUserData().setBimg_url(hVar.getUserData().getBimg_url());
            }
            if (this.edK && this.eds.aGY() != null && this.eds.aGY().getAuthor() != null && this.eds.aGZ() != null && com.baidu.tbadk.core.util.y.c(this.eds.aGZ(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.eds.aGZ(), 0);
                MetaData author = this.eds.aGY().getAuthor();
                if (sVar3.getAuthor() != null && sVar3.getAuthor().getGodUserData() != null) {
                    if (this.edz != -1) {
                        author.setFansNum(this.edz);
                        sVar3.getAuthor().setFansNum(this.edz);
                    }
                    if (this.edA != -1) {
                        author.getGodUserData().setFollowed(this.edA);
                        sVar3.getAuthor().getGodUserData().setFollowed(this.edA);
                        author.getGodUserData().setIsFromNetWork(false);
                        sVar3.getAuthor().getGodUserData().setIsFromNetWork(false);
                    }
                }
            }
            if (this.eds != null && this.eds.aGV() != null && hVar.aGV() != null) {
                this.eds.aGV().n(hVar.aGV().getItems());
                this.eds.aGV().ak(hVar.aGV().oV());
            }
            if (this.edw != null) {
                this.edw.a(true, getErrorCode(), i, i4, this.eds, this.mErrorString, 1);
            }
        }
        if (this.eds != null && this.eds.aGY() != null && this.eds.aGX() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bem;
            historyMessage.threadId = getPbData().aGY().getId();
            historyMessage.forumName = getPbData().aGX().getName();
            historyMessage.threadName = getPbData().aGY().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aIX();
            historyMessage.threadType = getPbData().aGY().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String am;
        if (arrayList != null && hVar.aGZ() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aGZ(), 0);
            if (sVar != null && (am = am(arrayList)) != null && am.equals(sVar.getId())) {
                hVar.aGZ().remove(sVar);
            }
            arrayList.addAll(hVar.aGZ());
        }
    }

    private String am(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.h hVar) {
        this.eds = hVar;
        nG(hVar.getPage().pl());
    }

    private void aJe() {
        if (this.eds != null && this.eds.aGZ() != null && this.eds.aHk() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
            com.baidu.tieba.pb.data.c aHk = this.eds.aHk();
            int aGO = aHk.aGO();
            if (aGO > 0) {
                if (aGO <= aGZ.size()) {
                    aGZ.add(aGO, aHk);
                } else {
                    aGZ.add(aHk);
                }
            }
        }
    }

    public boolean aJf() {
        if (this.edd == null || this.ede == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return nI(4);
        }
        return nI(6);
    }

    public boolean hH(boolean z) {
        if (this.edd == null || this.eds == null) {
            return false;
        }
        if (z || this.eds.getPage().pn() != 0) {
            return nI(1);
        }
        return false;
    }

    public boolean hI(boolean z) {
        if (this.edd == null || this.eds == null) {
            return false;
        }
        if ((z || this.eds.getPage().po() != 0) && this.eds.aGZ() != null && this.eds.aGZ().size() >= 1) {
            return nI(2);
        }
        return false;
    }

    public boolean ol(String str) {
        this.edf = !this.edf;
        this.ede = str;
        nI(6);
        return true;
    }

    public boolean aJg() {
        if (com.baidu.adp.lib.util.i.fq()) {
            this.edg = this.edh;
            this.edh = !this.edh;
        }
        return LoadData();
    }

    public boolean aJh() {
        return this.edh;
    }

    public boolean hasData() {
        return (this.eds == null || this.eds.aGX() == null || this.eds.aGY() == null) ? false : true;
    }

    public boolean mA() {
        if (this.eds == null) {
            return false;
        }
        return this.eds.mA();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fw(String str) {
        if (this.eds == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.eds.aGX().getId());
        writeData.setForumName(this.eds.aGX().getName());
        writeData.setThreadId(this.edd);
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

    public MarkData nK(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.eds == null || this.eds.aGZ() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
        if (aGZ.size() > 0 && i == aGZ.size()) {
            i = aGZ.size() - 1;
        }
        if (aGZ.size() <= 0 || i >= aGZ.size()) {
            return null;
        }
        return e(aGZ.get(i));
    }

    public MarkData aJi() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.edd);
        markData.setPostId(this.eds.mz());
        markData.setTime(date.getTime());
        markData.setHostMode(this.edf);
        markData.setSequence(Boolean.valueOf(this.edh));
        markData.setId(this.edd);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.edd);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.edf);
        markData.setSequence(Boolean.valueOf(this.edh));
        markData.setId(this.edd);
        markData.setFloor(sVar.bfB());
        if (sVar instanceof com.baidu.tieba.pb.data.f) {
            markData.setApp(true);
        } else if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.r) sVar).isApp());
        }
        return markData;
    }

    public void aJj() {
        cp.aID().F(aJk(), this.isFromMark);
    }

    private String aJk() {
        String str = this.edd;
        if (this.edf) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.edh) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void hJ(boolean z) {
        if (this.eds != null) {
            this.eds.ab(z);
        }
    }

    public void hK(boolean z) {
        this.edB = z;
    }

    public boolean aJl() {
        return this.edB;
    }

    public void a(a aVar) {
        this.edw = aVar;
    }

    public void mS(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BL() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BK() {
        return DG();
    }

    public boolean om(String str) {
        if (getPbData() == null || getPbData().aGY() == null || getPbData().aGY().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aGY().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int aJm() {
        return this.mRequestType;
    }

    public void aJn() {
        String aJk = aJk();
        cp.aID().F(aJk, false);
        cp.aID().F(aJk, true);
    }

    public void aJo() {
        if ("personalize_page".equals(this.aex)) {
            this.edH = System.currentTimeMillis() / 1000;
        }
    }

    public void aJp() {
        if ("personalize_page".equals(this.aex) && this.eds != null && this.edH != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10754").ab("fid", this.eds.getForumId()).ab("tid", this.edd).ab("obj_duration", String.valueOf(currentTimeMillis - this.edH)).ab("obj_param3", String.valueOf(currentTimeMillis)));
            this.edH = 0L;
        }
    }

    public boolean aJq() {
        return this.edK;
    }

    public int aJr() {
        return this.edt;
    }

    public int getErrorNo() {
        return this.edL;
    }

    public com.baidu.tieba.pb.data.g getAppealInfo() {
        return this.mAppealInfo;
    }

    public da aJs() {
        return this.edN;
    }

    public cq aJt() {
        return this.edO;
    }

    public ct aJu() {
        return this.edP;
    }
}
