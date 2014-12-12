package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bq extends com.baidu.adp.base.f<PbActivity> {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private com.baidu.tieba.tbadkCore.d.a aCg;
    private boolean aef;
    private String atD;
    private String bAD;
    private String bAE;
    private boolean bAF;
    private boolean bAG;
    private int bAH;
    private int bAI;
    private long bAJ;
    private int bAK;
    private int bAL;
    private int bAM;
    private boolean bAN;
    private boolean bAO;
    private long bAP;
    private boolean bAQ;
    private com.baidu.tieba.tbadkCore.b.i bAR;
    private bt bAS;
    private String bAT;
    private String bAU;
    private boolean bAV;
    private PbActivity bAW;
    private boolean bAX;
    private com.baidu.adp.framework.listener.a bAY;
    private PraiseData bAZ;
    private CustomMessageListener bmz;
    private long bsO;
    private long bsP;
    private long bsQ;
    private long bsR;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;
    private int totalPage;

    public bq(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.atD = null;
        this.bAD = null;
        this.bAE = null;
        this.bAF = false;
        this.bAG = true;
        this.bAH = 0;
        this.bAI = 0;
        this.bAJ = 0L;
        this.bAK = 1;
        this.bAL = 1;
        this.bAM = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bAN = false;
        this.bAO = false;
        this.isFromMark = false;
        this.bAP = 0L;
        this.bAQ = false;
        this.mForumName = null;
        this.bAR = null;
        this.aef = false;
        this.mContext = null;
        this.bAS = null;
        this.bsO = 0L;
        this.bsP = 0L;
        this.bsQ = 0L;
        this.bsR = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bAT = null;
        this.bAU = null;
        this.aCg = null;
        this.bAX = false;
        this.bmz = new br(this, 2004003);
        this.bAY = new bs(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bAZ = null;
        registerListener(this.bmz);
        registerListener(this.bAY);
        this.bAR = new com.baidu.tieba.tbadkCore.b.i();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bAW = pbActivity;
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
        this.bAD = intent.getStringExtra("thread_id");
        this.bAE = intent.getStringExtra("post_id");
        this.bAF = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bAG = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.atD = intent.getStringExtra("st_type");
        this.bAH = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bAI = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bAJ = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bAO = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bAN = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bAQ = intent.getBooleanExtra("is_pv", false);
        this.bAP = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bAU = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bAT = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bAD = bundle.getString("thread_id");
        this.bAE = bundle.getString("post_id");
        this.bAF = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bAG = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.atD = bundle.getString("st_type");
        this.bAH = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bAI = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bAJ = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bAO = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bAN = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bAQ = bundle.getBoolean("is_pv", false);
        this.bAP = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bAU = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bAD);
        bundle.putString("post_id", this.bAE);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bAF);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bAG);
        bundle.putString("st_type", this.atD);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bAH);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bAI);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bAJ);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bAO);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bAN);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bAQ);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bAP);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bAU);
    }

    public String Xd() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bAD);
        sb.append(this.bAE);
        sb.append(this.bAF);
        sb.append(this.bAG);
        sb.append(this.atD);
        sb.append(this.bAH);
        sb.append(this.bAI);
        sb.append(this.bAJ);
        sb.append(this.bAO);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bAN);
        sb.append(this.bAQ);
        sb.append(this.bAP);
        sb.append(this.mForumName);
        if (this.bAU != null) {
            sb.append(this.bAU);
        }
        return sb.toString();
    }

    public String Xe() {
        return this.mForumName;
    }

    public String Xf() {
        return this.bAD;
    }

    public boolean getHostMode() {
        return this.bAF;
    }

    public boolean Xg() {
        return this.bAG;
    }

    public boolean Xh() {
        return this.bAO;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bAH;
    }

    public int getIsMem() {
        if (this.bAR == null || this.bAR.getUserData() == null) {
            return 0;
        }
        return this.bAR.getUserData().getIsMem();
    }

    public int Xi() {
        return this.bAI;
    }

    public void setIsGood(int i) {
        this.bAH = i;
    }

    public void gQ(int i) {
        this.bAI = i;
    }

    public boolean Xj() {
        return this.bAN;
    }

    public boolean Xk() {
        if (this.bAR == null) {
            return false;
        }
        return this.bAR.isValid();
    }

    public String nx() {
        if (this.bAR == null || !this.bAR.li()) {
            return null;
        }
        return this.bAR.lk();
    }

    public boolean gR(int i) {
        this.bAK = i;
        if (this.bAK > this.bAR.mY().mS()) {
            this.bAK = this.bAR.mY().mS();
        }
        if (this.bAK < 1) {
            this.bAK = 1;
        }
        if (this.bAD == null) {
            return false;
        }
        return gU(5);
    }

    public void gS(int i) {
        this.bAK = i;
        this.bAL = i;
        this.bAM = i;
    }

    public void gT(int i) {
        if (this.bAL < i) {
            this.bAL = i;
            if (this.bAL - this.bAM >= MAX_PAGE_NUM) {
                this.bAM = (this.bAL - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bAM > i) {
            this.bAM = i;
            if (this.bAL - this.bAM >= MAX_PAGE_NUM) {
                this.bAL = (this.bAM + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        return this.bAR;
    }

    public com.baidu.tbadk.core.data.p Xl() {
        if (this.bAR == null) {
            return null;
        }
        return this.bAR.mY();
    }

    public boolean Xm() {
        if (this.bAG) {
            if (this.bAR.mY().mW() == 0) {
                dK(true);
                return true;
            }
        } else if (this.bAR.mY().mX() == 0) {
            dL(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bAD == null) {
            return false;
        }
        cancelLoadData();
        if (this.aCg == null) {
            this.aCg = new com.baidu.tieba.tbadkCore.d.a("pbStat");
            this.aCg.start();
        }
        boolean gU = gU(3);
        if (this.opType != null) {
            this.opType = null;
            this.bAT = null;
            this.opUrl = null;
            return gU;
        }
        return gU;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.aef = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Ue();
    }

    private void Ue() {
        if (this.aCg != null) {
            this.aCg.destory();
            this.aCg = null;
        }
    }

    public boolean xv() {
        return (this.bAE == null || this.bAE.equals("0") || this.bAE.length() == 0) ? LoadData() : Xn();
    }

    public boolean gU(int i) {
        if (this.aef) {
            return false;
        }
        this.aef = true;
        gV(i);
        com.baidu.tieba.tbadkCore.b.i pbData = bv.Xz().getPbData();
        if (pbData != null) {
            this.bAG = bv.Xz().Xg();
            this.bAF = bv.Xz().XB();
            if (!this.bAG || this.bAF || this.isFromMark) {
                this.bAV = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bAS.dG(true);
            this.aef = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.WK);
        if (!this.bAG || this.bAF || this.isFromMark) {
            this.bAV = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bAD == null || this.bAD.length() == 0) {
            this.aef = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bAD, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        int N = com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp());
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.px().pz() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(M));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(N));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bAG) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bAF) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.atD != null) {
            pbpagerequestmessage.set_st_type(this.atD);
        }
        if (this.bAQ) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bAP));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bAV) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bAT, 0));
            pbpagerequestmessage.setOpMessageID(this.bAP);
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.bAR.agF();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bAG) {
                        if (this.bAM > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bAM - 1));
                        }
                    } else if (this.bAL < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bAL + 1));
                    }
                }
                if (agF != null && agF.size() > 0) {
                    this.bAE = agF.get(agF.size() - 1).getId();
                }
                if (this.bAE != null && this.bAE.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bAE, 0L));
                    break;
                } else if (!this.bAG) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (agF != null && agF.size() > 0) {
                    this.bAE = agF.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bAG) {
                        if (this.bAM > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bAM - 1));
                        }
                    } else if (this.bAL < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bAL + 1));
                    }
                }
                if (this.bAE != null && this.bAE.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bAE, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(Xt(), true, this.bAE, 3);
                } else {
                    a(Xt(), false, this.bAE, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bAG) {
                    pbpagerequestmessage.set_pn(1);
                } else {
                    pbpagerequestmessage.set_last(1);
                }
                if (this.isFromMark) {
                    pbpagerequestmessage.set_st_type("store_thread");
                    break;
                }
                break;
            case 4:
                a(Xt(), true, this.bAE, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bAE, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bAK));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bAE, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(Xt());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void gV(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.bAR.agF();
        if (i == 1) {
            boolean z2 = false;
            while (agF.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                agF.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bAR.mY().bo(1);
                if (this.bAS != null) {
                    this.bAS.a(this.bAR);
                }
            }
        } else if (i == 2) {
            while (agF.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                agF.remove(agF.size() - 1);
                z = true;
            }
            if (z) {
                this.bAR.mY().bn(1);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.tbadkCore.b.i iVar2 = z ? null : iVar;
        this.aef = false;
        if (iVar2 != null) {
            c(iVar2);
        }
        a(iVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(com.baidu.tieba.tbadkCore.b.i iVar) {
        if (iVar != null) {
            String str = null;
            if (iVar.agE() != null && iVar.agE().getAuthor() != null) {
                str = iVar.agE().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.w agE = iVar.agE();
            agE.bq(this.bAH);
            agE.bp(this.bAI);
            agE.l(this.bAJ);
            for (int i = 0; i < iVar.agF().size(); i++) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.agF().get(i);
                for (int i2 = 0; i2 < kVar.agQ().size(); i2++) {
                    kVar.agQ().get(i2).a(this.bAW.getPageContext(), str2.equals(kVar.agQ().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aCg != null && !z3) {
            this.aCg.a(z2, z4, i2, str, i3, j, j2);
            this.aCg = null;
        }
        if (iVar == null) {
            if (this.bAS != null) {
                this.bAS.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bAQ = false;
            if (iVar.mY() != null) {
                gT(iVar.mY().mU());
                this.totalPage = iVar.mY().mS();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.bAR.agF();
            switch (i) {
                case 1:
                    this.bAR.a(iVar.mY(), 1);
                    if (iVar.agF() != null) {
                        agF.addAll(iVar.agF());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (iVar.agF() != null) {
                        i5 = iVar.agF().size() + 1;
                        agF.addAll(0, iVar.agF());
                    }
                    this.bAR.a(iVar.mY(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bAG && iVar.mY() != null) {
                        iVar.mY().bl(iVar.mY().mS());
                    }
                    d(iVar);
                    i4 = 0;
                    break;
                case 4:
                    d(iVar);
                    i4 = 0;
                    break;
                case 5:
                    d(iVar);
                    i4 = 0;
                    break;
                case 6:
                    d(iVar);
                    i4 = 0;
                    break;
                default:
                    i4 = i5;
                    break;
            }
            if (this.bAR != null && this.bAR.agE() != null) {
                PraiseData praise = this.bAR.agE().getPraise();
                if (this.bAZ != null && !praise.isPriaseDataValid()) {
                    this.bAR.agE().setPraise(this.bAZ);
                } else {
                    this.bAZ = this.bAR.agE().getPraise();
                    this.bAZ.setPostId(this.bAR.agE().nD());
                }
                if (iVar.mY() != null && iVar.mY().mU() == 1) {
                    this.bAR.agE().p(iVar.agE().ny());
                }
                this.bAR.agE().setReply_num(iVar.agE().getReply_num());
            }
            if (this.bAS != null) {
                this.bAS.a(true, getErrorCode(), i, i4, this.bAR, this.mErrorString, 1);
            }
        }
        if (this.bAR != null && this.bAR.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bAR.getUserData().getIsMem())));
        }
        if (this.bAR != null && this.bAR.agE() != null && this.bAR.aej() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this.bAW);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(getPbData().agE().getId());
            bVar.setForumName(getPbData().aej().getName());
            bVar.bF(getPbData().agE().getTitle());
            bVar.Z(getHostMode());
            bVar.aa(Xg());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bAR = iVar;
        gS(iVar.mY().mU());
    }

    public boolean Xn() {
        if (this.bAD == null || this.bAE == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return gU(4);
        }
        return gU(6);
    }

    public boolean dK(boolean z) {
        if (this.bAD == null || this.bAR == null) {
            return false;
        }
        if (z || this.bAR.mY().mW() != 0) {
            return gU(1);
        }
        return false;
    }

    public boolean dL(boolean z) {
        if (this.bAD == null || this.bAR == null) {
            return false;
        }
        if ((z || this.bAR.mY().mX() != 0) && this.bAR.agF() != null && this.bAR.agF().size() >= 1) {
            return gU(2);
        }
        return false;
    }

    public boolean Xo() {
        this.bAF = !this.bAF;
        if (this.bAF) {
            this.bAG = true;
        }
        LoadData();
        return true;
    }

    public boolean Xp() {
        this.bAG = !this.bAG;
        if (!this.bAG) {
            this.bAF = false;
        }
        return LoadData();
    }

    public boolean Xq() {
        return this.bAG;
    }

    public boolean Ui() {
        return (this.bAR == null || this.bAR.aej() == null || this.bAR.agE() == null) ? false : true;
    }

    public boolean li() {
        if (this.bAR == null) {
            return false;
        }
        return this.bAR.li();
    }

    public WriteData hv(String str) {
        if (this.bAR == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bAR.aej().getId());
        writeData.setForumName(this.bAR.aej().getName());
        writeData.setThreadId(this.bAD);
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

    public com.baidu.tieba.tbadkCore.b.o b(com.baidu.tieba.tbadkCore.b.k kVar) {
        if (kVar == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.b.o oVar = new com.baidu.tieba.tbadkCore.b.o();
        oVar.b(this.bAR.aej());
        oVar.f(this.bAR.agE());
        oVar.d(kVar);
        oVar.P(kVar.agQ());
        oVar.setTotalCount(kVar.agX());
        String lk = this.bAR.lk();
        String id = kVar.getId();
        if (li() && lk != null && id != null && lk.equals(id)) {
            oVar.Y(true);
            return oVar;
        }
        oVar.Y(false);
        return oVar;
    }

    public MarkData gW(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bAR == null || this.bAR.agF() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> agF = this.bAR.agF();
        if (agF.size() > 0 && i == agF.size()) {
            i = agF.size() - 1;
        }
        if (agF.size() <= 0 || i >= agF.size()) {
            return null;
        }
        return c(agF.get(i));
    }

    public MarkData Xr() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bAD);
        markData.setPostId(this.bAR.lk());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bAF);
        markData.setSequence(Boolean.valueOf(this.bAG));
        markData.setId(this.bAD);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.b.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bAD);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bAF);
        markData.setSequence(Boolean.valueOf(this.bAG));
        markData.setId(this.bAD);
        markData.setFloor(kVar.agT());
        return markData;
    }

    public void Xs() {
        bp.Xb().w(Xt(), this.isFromMark);
    }

    private String Xt() {
        String str = this.bAD;
        if (this.bAF) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bAG) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dM(boolean z) {
        if (this.bAR != null) {
            this.bAR.Y(z);
        }
    }

    public void dN(boolean z) {
        this.bAV = z;
    }

    public void a(bt btVar) {
        this.bAS = btVar;
    }
}
