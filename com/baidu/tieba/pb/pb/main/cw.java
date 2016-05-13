package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
public class cw extends com.baidu.tbadk.editortools.d.a {
    private static final int dkW = com.baidu.tbadk.data.d.getPbListItemMaxNum() / 30;
    public static int dkX = 1;
    private CustomMessageListener aLb;
    private com.baidu.tieba.tbadkCore.d.b aXX;
    private String adl;
    private boolean avz;
    private BaseActivity bek;
    private long bsa;
    private com.baidu.adp.framework.listener.a cCX;
    protected com.baidu.tieba.pb.data.e dfY;
    protected String dkY;
    private String dkZ;
    private boolean dlA;
    private String dlB;
    private long dlC;
    private boolean dlD;
    private int dlE;
    private boolean dlF;
    private int dlG;
    private final dc dlH;
    private final cp dlI;
    private final cj dlJ;
    private final cn dlK;
    private CustomMessageListener dlL;
    private PraiseData dlM;
    private boolean dla;
    private boolean dlb;
    private boolean dlc;
    private int dld;
    private long dle;
    private int dlf;
    private int dlg;
    private int dlh;
    private int dli;
    private boolean dlj;
    private boolean dlk;
    private boolean dll;
    private long dlm;
    private boolean dln;
    private String dlo;
    private int dlp;
    private boolean dlq;
    private a dlr;
    private String dls;
    private String dlt;
    private int dlu;
    private int dlv;
    private boolean dlw;
    private boolean dlx;
    private boolean dly;
    private boolean dlz;
    private boolean isAd;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.d mAppealInfo;
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
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.e eVar);

        void d(com.baidu.tbadk.performanceLog.v vVar);
    }

    public String axA() {
        return this.dlB;
    }

    public void lV(String str) {
        this.dlB = str;
    }

    public void gD(boolean z) {
        this.dlD = z;
    }

    public cw(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.adl = null;
        this.dkY = null;
        this.dkZ = null;
        this.dla = false;
        this.dlb = true;
        this.dlc = true;
        this.mIsGood = 0;
        this.dld = 0;
        this.dle = 0L;
        this.dlf = 1;
        this.dlg = 1;
        this.dlh = 1;
        this.dli = 1;
        this.isAd = false;
        this.dlj = false;
        this.dlk = false;
        this.isFromMark = false;
        this.dll = false;
        this.dlm = 0L;
        this.dln = false;
        this.dlo = null;
        this.dfY = null;
        this.avz = false;
        this.dlq = false;
        this.mLocate = null;
        this.mContext = null;
        this.dlr = null;
        this.opType = null;
        this.opUrl = null;
        this.dls = null;
        this.dlt = null;
        this.dlu = -1;
        this.dlv = -1;
        this.aXX = null;
        this.dlx = false;
        this.dly = false;
        this.postID = null;
        this.dlB = null;
        this.dlC = 0L;
        this.dlD = false;
        this.dlE = -1;
        this.aLb = new cx(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.dlL = new cz(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.cCX = new da(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.dlM = null;
        registerListener(this.aLb);
        registerListener(this.cCX);
        registerListener(this.dlL);
        this.dfY = new com.baidu.tieba.pb.data.e();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bek = baseActivity;
        this.dlH = new dc(this, this.bek);
        this.dlI = new cp(this, this.bek);
        this.dlJ = new cj(this, this.bek);
        this.dlK = new cn(this, this.bek);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int axB() {
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
        this.dkY = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.dkY)) {
            this.dkY = this.dlH.t(intent);
        }
        this.dkZ = intent.getStringExtra("post_id");
        this.dla = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.dlc = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.adl = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.mIsGood = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.dld = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.dle = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.dlk = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.dll = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.dlj = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.dln = intent.getBooleanExtra("is_pv", false);
        this.dlm = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.dlo = intent.getStringExtra("forum_name");
        this.dlt = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.dls = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.dlq = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.dlv = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.dlu = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void initWithBundle(Bundle bundle) {
        this.dkY = bundle.getString("thread_id");
        this.dkZ = bundle.getString("post_id");
        this.dla = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.dlc = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.adl = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.mIsGood = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.dld = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.dle = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.dlk = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.dll = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.dlj = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.dln = bundle.getBoolean("is_pv", false);
        this.dlm = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.dlo = bundle.getString("forum_name");
        this.dlt = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.dlq = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.dlv = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.dlu = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void p(Bundle bundle) {
        bundle.putString("thread_id", this.dkY);
        bundle.putString("post_id", this.dkZ);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.dla);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.dlc);
        bundle.putString("st_type", this.adl);
        bundle.putString("locate", this.mLocate);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.mIsGood);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.dld);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.dle);
        bundle.putBoolean("from_frs", this.dlk);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.dll);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.dlj);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.dln);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.dlm);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.dlt);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.dlq);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.dlv);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.dlu);
    }

    public String axC() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.dkY);
        if (!this.dll) {
            sb.append(this.dkZ);
        }
        sb.append(this.dla);
        sb.append(this.dlc);
        sb.append(this.adl);
        sb.append(this.mIsGood);
        sb.append(this.dld);
        sb.append(this.dle);
        sb.append(this.dlk);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.dlj);
        sb.append(this.dln);
        sb.append(this.dlm);
        sb.append(this.dlo);
        sb.append(this.mThreadType);
        sb.append(this.dlq);
        if (this.dlt != null) {
            sb.append(this.dlt);
        }
        return sb.toString();
    }

    public String axD() {
        return this.dlo;
    }

    public String getPostId() {
        return this.dkZ;
    }

    public void lW(String str) {
        this.dkZ = str;
    }

    public String getThreadID() {
        return this.dkY;
    }

    public boolean getHostMode() {
        return this.dla;
    }

    public boolean axE() {
        return this.dlc;
    }

    public boolean axF() {
        return this.dlk;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean axG() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.adl);
    }

    public int getIsGood() {
        return this.mIsGood;
    }

    public int axH() {
        return this.dld;
    }

    public void setIsGood(int i) {
        this.mIsGood = i;
    }

    public void lM(int i) {
        this.dld = i;
    }

    public boolean axI() {
        return this.dlj;
    }

    public boolean axJ() {
        if (this.dfY == null) {
            return false;
        }
        return this.dfY.isValid();
    }

    public String qU() {
        if (this.dfY == null || !this.dfY.mP()) {
            return null;
        }
        return this.dfY.mO();
    }

    public boolean lN(int i) {
        this.dlf = i;
        if (this.dlf > this.dfY.getPage().pF()) {
            this.dlf = this.dfY.getPage().pF();
        }
        if (this.dlf < 1) {
            this.dlf = 1;
        }
        if (this.dkY == null) {
            return false;
        }
        return lR(5);
    }

    public boolean lO(int i) {
        int rp = this.dfY.avE().rp();
        if (i <= rp) {
            rp = i;
        }
        int i2 = rp >= 1 ? rp : 1;
        if (this.dkY == null) {
            return false;
        }
        this.dlE = i2;
        return lR(7);
    }

    public void lP(int i) {
        this.dlf = i;
        this.dlg = i;
        this.dlh = i;
    }

    public void lQ(int i) {
        if (this.dlg < i) {
            this.dlg = i;
            if (this.dlg - this.dlh >= dkW) {
                this.dlh = (this.dlg - dkW) + 1;
            }
        }
        if (this.dlh > i) {
            this.dlh = i;
            if (this.dlg - this.dlh >= dkW) {
                this.dlg = (this.dlh + dkW) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.dfY;
    }

    public com.baidu.tbadk.core.data.ad abu() {
        if (this.dfY == null) {
            return null;
        }
        return this.dfY.getPage();
    }

    public boolean axK() {
        if (this.dlc) {
            if (this.dfY.getPage().pK() == 0) {
                gE(true);
                return true;
            }
        } else if (this.dfY.getPage().pL() == 0) {
            gF(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.dkY == null) {
            return false;
        }
        cancelLoadData();
        if (this.aXX == null) {
            this.aXX = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.aXX.start();
        }
        boolean lR = lR(3);
        if (this.opType != null) {
            this.opType = null;
            this.dls = null;
            this.opUrl = null;
            return lR;
        }
        return lR;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.avz = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MT();
    }

    private void MT() {
        if (this.aXX != null) {
            this.aXX.destory();
            this.aXX = null;
        }
    }

    public boolean Dz() {
        return (this.dkZ == null || this.dkZ.equals("0") || this.dkZ.length() == 0) ? LoadData() : axM();
    }

    public boolean lR(int i) {
        this.mRequestType = i;
        if (this.avz) {
            return false;
        }
        this.avz = true;
        lS(i);
        com.baidu.tieba.pb.data.e pbData = ee.ayD().getPbData();
        if (pbData != null && pbData.avE() != null) {
            pbData.avE().bG(0);
            this.dlc = ee.ayD().axE();
            this.dla = ee.ayD().ayF();
            if (!this.dlc || this.dla || this.isFromMark) {
                this.dlw = false;
            }
            com.baidu.adp.lib.h.h.dL().post(new db(this, pbData));
            return false;
        }
        if (i == 4 && !this.dlA) {
            a(axR(), true, this.dkZ, 3);
        }
        if (i == 3 && !this.dlA) {
            if (this.isFromMark) {
                a(axR(), true, this.dkZ, 3);
            } else {
                a(axR(), false, this.dkZ, 3);
            }
        }
        this.dlA = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aov);
        if (!this.dlc || this.dla || this.isFromMark) {
            this.dlw = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.dkY == null || this.dkY.length() == 0) {
            this.avz = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.dkY, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst().getApp());
        int C = com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getApp());
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.az.ug().ui() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(C));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.dlc) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.dla) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.adl != null) {
            pbPageRequestMessage.set_st_type(this.adl);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.dln) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.dlm));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.dlw) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.dls, 0));
            pbPageRequestMessage.setOpMessageID(this.dlm);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfY.avF();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.dlc) {
                        if (this.dlh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.dlh - 1));
                        }
                    } else if (this.dlg < this.dli) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.dlg + 1));
                    }
                }
                if (avF != null && avF.size() > 0) {
                    int size = avF.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.s sVar = avF.get(size - i3);
                        if (sVar == null) {
                            i3++;
                        } else {
                            this.dkZ = sVar.getId();
                            if (StringUtils.isNull(this.dkZ)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.dkZ != null && this.dkZ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dkZ, 0L));
                    break;
                } else if (!this.dlc) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (avF != null && avF.size() > 0 && avF.get(0) != null) {
                    this.dkZ = avF.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.dlc) {
                        if (this.dlh - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.dlh - 1));
                        }
                    } else if (this.dlg < this.dli) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.dlg + 1));
                    }
                }
                if (this.dkZ != null && this.dkZ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dkZ, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.dlc) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dkZ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.dlf));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.dkZ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.dlE);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(axR());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setIsSubPostDataReverse(this.dlD);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void lS(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfY.avF();
        this.dlz = false;
        if (i == 1) {
            boolean z2 = false;
            while (avF.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                avF.remove(0);
                z2 = true;
            }
            if (z2) {
                this.dfY.getPage().bD(1);
                if (this.dlr != null) {
                    this.dlr.c(this.dfY);
                }
            }
            this.bsa = System.currentTimeMillis();
            this.dlz = true;
        } else if (i == 2) {
            while (avF.size() + 30 > com.baidu.tbadk.data.d.getPbListItemMaxNum()) {
                avF.remove(avF.size() - 1);
                z = true;
            }
            if (z) {
                this.dfY.getPage().bC(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.dlG = i2;
        this.avz = false;
        if (eVar2 != null) {
            d(eVar2);
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
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
    public void d(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (this.dlq) {
                eVar = f(eVar);
            }
            e(eVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String g = g(eVar);
            for (int i = 0; i < eVar.avF().size(); i++) {
                com.baidu.tieba.tbadkCore.data.s sVar = eVar.avF().get(i);
                for (int i2 = 0; i2 < sVar.aTU().size(); i2++) {
                    sVar.aTU().get(i2).b(this.bek.getPageContext(), g.equals(sVar.aTU().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.e f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.ax avE = eVar.avE();
        avE.bI(this.mIsGood);
        avE.bH(this.dld);
        if (this.dle > 0) {
            avE.u(this.dle);
            return eVar;
        }
        return eVar;
    }

    protected String g(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.avE() != null && eVar.avE().getAuthor() != null) {
            str = eVar.avE().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.avE() != null && eVar.avE().getAuthor() != null) {
            str = eVar.avE().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData axL() {
        if (this.dfY == null || this.dfY.avE() == null || this.dfY.avE().getAuthor() == null) {
            return null;
        }
        return this.dfY.avE().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.dlF = z3;
        this.dlp = i;
        if (this.aXX != null && !z3) {
            this.aXX.a(z2, z4, i2, str, i3, j, j2);
            this.aXX = null;
        }
        if (eVar == null || (this.dlf == 1 && i == 5 && eVar.avF() != null && eVar.avF().size() < 1)) {
            if (this.dlr != null) {
                this.dlc = this.dlb;
                this.dlr.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.dlb = this.dlc;
            this.dln = false;
            if (eVar.getPage() != null) {
                lQ(eVar.getPage().pI());
                this.dli = eVar.getPage().pF();
            }
            this.dli = this.dli < 1 ? 1 : this.dli;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfY.avF();
            switch (i) {
                case 1:
                    this.dfY.a(eVar.getPage(), 1);
                    a(eVar, avF);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.avF() != null) {
                        int size = eVar.avF().size() + 1;
                        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(avF, 0);
                        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(eVar.avF(), com.baidu.tbadk.core.util.y.r(eVar.avF()) - 1);
                        if (sVar == null || sVar2 == null || !sVar.getId().equals(sVar2.getId())) {
                            i5 = size;
                        } else {
                            eVar.avF().remove(sVar2);
                            i5 = size - 1;
                        }
                        avF.addAll(0, eVar.avF());
                    }
                    this.dfY.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.dlc && eVar.getPage() != null) {
                        eVar.getPage().bA(eVar.getPage().pF());
                    }
                    i(eVar);
                    i4 = 0;
                    break;
                case 4:
                    i(eVar);
                    i4 = 0;
                    break;
                case 5:
                    i(eVar);
                    i4 = 0;
                    break;
                case 6:
                    i(eVar);
                    i4 = 0;
                    break;
                case 7:
                    i(eVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.dfY != null && this.dfY.avE() != null) {
                PraiseData praise = this.dfY.avE().getPraise();
                if (this.dlM != null && !praise.isPriaseDataValid()) {
                    this.dfY.avE().setPraise(this.dlM);
                } else {
                    this.dlM = this.dfY.avE().getPraise();
                    this.dlM.setPostId(this.dfY.avE().ra());
                }
                if (eVar.getPage() != null && eVar.getPage().pI() == 1 && eVar.avE() != null && eVar.avE().qV() != null && eVar.avE().qV().size() > 0) {
                    this.dfY.avE().h(eVar.avE().qV());
                }
                this.dfY.avE().setReply_num(eVar.avE().getReply_num());
                this.dfY.avE().setAnchorLevel(eVar.avE().getAnchorLevel());
                this.dfY.avE().bG(eVar.avE().qL());
                if (this.mThreadType == 33) {
                    this.dfY.avE().getAuthor().setHadConcerned(eVar.avE().getAuthor().hadConcerned());
                }
            }
            if (this.dfY != null && this.dfY.getUserData() != null && eVar.getUserData() != null) {
                this.dfY.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.dfY.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (this.dlF && this.dfY.avE() != null && this.dfY.avE().getAuthor() != null && this.dfY.avF() != null && com.baidu.tbadk.core.util.y.c(this.dfY.avF(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(this.dfY.avF(), 0);
                MetaData author = this.dfY.avE().getAuthor();
                if (sVar3.getAuthor() != null && sVar3.getAuthor().getGodUserData() != null) {
                    if (this.dlu != -1) {
                        author.setFansNum(this.dlu);
                        sVar3.getAuthor().setFansNum(this.dlu);
                    }
                    if (this.dlv != -1) {
                        author.getGodUserData().setFollowed(this.dlv);
                        sVar3.getAuthor().getGodUserData().setFollowed(this.dlv);
                    }
                }
            }
            if (this.dfY != null && this.dfY.avB() != null && eVar.avB() != null) {
                this.dfY.avB().setItems(eVar.avB().getItems());
                this.dfY.avB().ak(eVar.avB().pt());
            }
            if (this.dlr != null) {
                this.dlr.a(true, getErrorCode(), i, i4, this.dfY, this.mErrorString, 1);
            }
        }
        if (this.dfY != null && this.dfY.avE() != null && this.dfY.avD() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bek;
            historyMessage.threadId = getPbData().avE().getId();
            historyMessage.forumName = getPbData().avD().getName();
            historyMessage.threadName = getPbData().avE().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = axE();
            historyMessage.threadType = getPbData().avE().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String Z;
        if (arrayList != null && eVar.avF() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(eVar.avF(), 0);
            if (sVar != null && (Z = Z(arrayList)) != null && Z.equals(sVar.getId())) {
                eVar.avF().remove(sVar);
            }
            arrayList.addAll(eVar.avF());
        }
    }

    private String Z(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int r = com.baidu.tbadk.core.util.y.r(arrayList);
        if (r <= 0) {
            return null;
        }
        for (int i = r - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.e eVar) {
        this.dfY = eVar;
        lP(eVar.getPage().pI());
    }

    public boolean axM() {
        if (this.dkY == null || this.dkZ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return lR(4);
        }
        return lR(6);
    }

    public boolean gE(boolean z) {
        if (this.dkY == null || this.dfY == null) {
            return false;
        }
        if (z || this.dfY.getPage().pK() != 0) {
            return lR(1);
        }
        return false;
    }

    public boolean gF(boolean z) {
        if (this.dkY == null || this.dfY == null) {
            return false;
        }
        if ((z || this.dfY.getPage().pL() != 0) && this.dfY.avF() != null && this.dfY.avF().size() >= 1) {
            return lR(2);
        }
        return false;
    }

    public boolean lX(String str) {
        this.dla = !this.dla;
        this.dkZ = str;
        lR(6);
        return true;
    }

    public boolean axN() {
        if (com.baidu.adp.lib.util.i.fq()) {
            this.dlb = this.dlc;
            this.dlc = !this.dlc;
        }
        return LoadData();
    }

    public boolean axO() {
        return this.dlc;
    }

    public boolean hasData() {
        return (this.dfY == null || this.dfY.avD() == null || this.dfY.avE() == null) ? false : true;
    }

    public boolean mP() {
        if (this.dfY == null) {
            return false;
        }
        return this.dfY.mP();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fs(String str) {
        if (this.dfY == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.dfY.avD().getId());
        writeData.setForumName(this.dfY.avD().getName());
        writeData.setThreadId(this.dkY);
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

    public MarkData lT(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.dfY == null || this.dfY.avF() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfY.avF();
        if (avF.size() > 0 && i == avF.size()) {
            i = avF.size() - 1;
        }
        if (avF.size() <= 0 || i >= avF.size()) {
            return null;
        }
        return e(avF.get(i));
    }

    public MarkData axP() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.dkY);
        markData.setPostId(this.dfY.mO());
        markData.setTime(date.getTime());
        markData.setHostMode(this.dla);
        markData.setSequence(Boolean.valueOf(this.dlc));
        markData.setId(this.dkY);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.dkY);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.dla);
        markData.setSequence(Boolean.valueOf(this.dlc));
        markData.setId(this.dkY);
        markData.setFloor(sVar.aTY());
        if (sVar instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.r) sVar).isApp());
        }
        return markData;
    }

    public void axQ() {
        cg.axk().D(axR(), this.isFromMark);
    }

    private String axR() {
        String str = this.dkY;
        if (this.dla) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.dlc) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void gG(boolean z) {
        if (this.dfY != null) {
            this.dfY.aa(z);
        }
    }

    public void gH(boolean z) {
        this.dlw = z;
    }

    public boolean axS() {
        return this.dlw;
    }

    public void a(a aVar) {
        this.dlr = aVar;
    }

    public void lm(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BC() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BB() {
        return Dz();
    }

    public boolean lY(String str) {
        if (getPbData() == null || getPbData().avE() == null || getPbData().avE().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().avE().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void axT() {
        String axR = axR();
        cg.axk().D(axR, false);
        cg.axk().D(axR, true);
    }

    public void axU() {
        if ("personalize_page".equals(this.adl)) {
            this.dlC = System.currentTimeMillis() / 1000;
        }
    }

    public void axV() {
        if ("personalize_page".equals(this.adl) && this.dfY != null && this.dlC != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10754").ac("fid", this.dfY.getForumId()).ac("tid", this.dkY).ac("obj_duration", String.valueOf(currentTimeMillis - this.dlC)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.dlC = 0L;
        }
    }

    public boolean axW() {
        return this.dlF;
    }

    public int axX() {
        return this.dlp;
    }

    public int getErrorNo() {
        return this.dlG;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public cp axY() {
        return this.dlI;
    }

    public cj axZ() {
        return this.dlJ;
    }

    public cn aya() {
        return this.dlK;
    }
}
