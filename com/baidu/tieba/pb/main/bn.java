package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.base.e {
    private static final int bww = com.baidu.tieba.data.e.yy() / 30;
    private com.baidu.tieba.b.a aAE;
    private String aok;
    private long azR;
    private long azS;
    private long azT;
    private long azU;
    private CustomMessageListener bhJ;
    private boolean bwA;
    private int bwB;
    private int bwC;
    private long bwD;
    private int bwE;
    private int bwF;
    private int bwG;
    private boolean bwH;
    private boolean bwI;
    private long bwJ;
    private boolean bwK;
    private com.baidu.tieba.data.ah bwL;
    private bq bwM;
    private String bwN;
    private String bwO;
    private boolean bwP;
    private PbActivity bwQ;
    private boolean bwR;
    private com.baidu.adp.framework.listener.a bwS;
    private PraiseData bwT;
    private String bwx;
    private String bwy;
    private boolean bwz;
    private boolean isAd;
    private boolean isFromMark;
    private boolean isLoading;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;
    private int totalPage;

    public bn(PbActivity pbActivity) {
        super(pbActivity);
        this.aok = null;
        this.bwx = null;
        this.bwy = null;
        this.bwz = false;
        this.bwA = true;
        this.bwB = 0;
        this.bwC = 0;
        this.bwD = 0L;
        this.bwE = 1;
        this.bwF = 1;
        this.bwG = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bwH = false;
        this.bwI = false;
        this.isFromMark = false;
        this.bwJ = 0L;
        this.bwK = false;
        this.mForumName = null;
        this.bwL = null;
        this.isLoading = false;
        this.mContext = null;
        this.bwM = null;
        this.azR = 0L;
        this.azS = 0L;
        this.azT = 0L;
        this.azU = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bwN = null;
        this.bwO = null;
        this.aAE = null;
        this.bwR = false;
        this.bhJ = new bo(this, 2004003);
        this.bwS = new bp(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bwT = null;
        registerListener(this.bhJ);
        registerListener(this.bwS);
        this.bwL = new com.baidu.tieba.data.ah();
        this.mContext = pbActivity;
        this.bwQ = pbActivity;
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
        this.bwx = intent.getStringExtra("thread_id");
        this.bwy = intent.getStringExtra("post_id");
        this.bwz = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bwA = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aok = intent.getStringExtra("st_type");
        this.bwB = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bwC = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bwD = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bwI = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bwH = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bwK = intent.getBooleanExtra("is_pv", false);
        this.bwJ = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bwO = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bwN = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bwx = bundle.getString("thread_id");
        this.bwy = bundle.getString("post_id");
        this.bwz = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bwA = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aok = bundle.getString("st_type");
        this.bwB = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bwC = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bwD = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bwI = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bwH = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bwK = bundle.getBoolean("is_pv", false);
        this.bwJ = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bwO = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bwx);
        bundle.putString("post_id", this.bwy);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bwz);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bwA);
        bundle.putString("st_type", this.aok);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bwB);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bwC);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bwD);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bwI);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bwH);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bwK);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bwJ);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bwO);
    }

    public String WD() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bwx);
        sb.append(this.bwy);
        sb.append(this.bwz);
        sb.append(this.bwA);
        sb.append(this.aok);
        sb.append(this.bwB);
        sb.append(this.bwC);
        sb.append(this.bwD);
        sb.append(this.bwI);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bwH);
        sb.append(this.bwK);
        sb.append(this.bwJ);
        sb.append(this.mForumName);
        if (this.bwO != null) {
            sb.append(this.bwO);
        }
        return sb.toString();
    }

    public String WE() {
        return this.mForumName;
    }

    public String WF() {
        return this.bwx;
    }

    public boolean getHostMode() {
        return this.bwz;
    }

    public boolean WG() {
        return this.bwA;
    }

    public boolean WH() {
        return this.bwI;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bwB;
    }

    public int getIsMem() {
        if (this.bwL == null || this.bwL.getUserData() == null) {
            return 0;
        }
        return this.bwL.getUserData().getIsMem();
    }

    public int WI() {
        return this.bwC;
    }

    public void setIsGood(int i) {
        this.bwB = i;
    }

    public void gK(int i) {
        this.bwC = i;
    }

    public boolean WJ() {
        return this.bwH;
    }

    public boolean WK() {
        if (this.bwL == null) {
            return false;
        }
        return this.bwL.isValid();
    }

    public String kD() {
        if (this.bwL == null || !this.bwL.zN()) {
            return null;
        }
        return this.bwL.zO();
    }

    public boolean gL(int i) {
        this.bwE = i;
        if (this.bwE > this.bwL.zM().kc()) {
            this.bwE = this.bwL.zM().kc();
        }
        if (this.bwE < 1) {
            this.bwE = 1;
        }
        if (this.bwx == null) {
            return false;
        }
        return gO(5);
    }

    public void gM(int i) {
        this.bwE = i;
        this.bwF = i;
        this.bwG = i;
    }

    public void gN(int i) {
        if (this.bwF < i) {
            this.bwF = i;
            if (this.bwF - this.bwG >= bww) {
                this.bwG = (this.bwF - bww) + 1;
            }
        }
        if (this.bwG > i) {
            this.bwG = i;
            if (this.bwF - this.bwG >= bww) {
                this.bwF = (this.bwG + bww) - 1;
            }
        }
    }

    public com.baidu.tieba.data.ah getPbData() {
        return this.bwL;
    }

    public com.baidu.tbadk.core.data.m WL() {
        if (this.bwL == null) {
            return null;
        }
        return this.bwL.zM();
    }

    public boolean WM() {
        if (this.bwA) {
            if (this.bwL.zM().kh() == 0) {
                dZ(true);
                return true;
            }
        } else if (this.bwL.zM().ki() == 0) {
            ea(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.bwx == null) {
            return false;
        }
        cancelLoadData();
        if (this.aAE == null) {
            this.aAE = new com.baidu.tieba.b.a("pbStat");
            this.aAE.start();
        }
        boolean gO = gO(3);
        if (this.opType != null) {
            this.opType = null;
            this.bwN = null;
            this.opUrl = null;
            return gO;
        }
        return gO;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void xY() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Tn();
    }

    private void Tn() {
        if (this.aAE != null) {
            this.aAE.xY();
            this.aAE = null;
        }
    }

    public boolean tL() {
        return (this.bwy == null || this.bwy.equals("0") || this.bwy.length() == 0) ? LoadData() : WN();
    }

    public boolean gO(int i) {
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        gP(i);
        com.baidu.tieba.data.ah pbData = bs.WZ().getPbData();
        if (pbData != null) {
            this.bwA = bs.WZ().WG();
            this.bwz = bs.WZ().Xb();
            if (!this.bwA || this.bwz || this.isFromMark) {
                this.bwP = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bwM.dV(true);
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.QI);
        if (!this.bwA || this.bwz || this.isFromMark) {
            this.bwP = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bwx == null || this.bwx.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bwx, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int n = com.baidu.adp.lib.util.m.n(com.baidu.tieba.aj.wk().getApp());
        int o = com.baidu.adp.lib.util.m.o(com.baidu.tieba.aj.wk().getApp());
        float f = com.baidu.tieba.aj.wk().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.az.mD().mF() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(n));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(o));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bwA) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bwz) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aok != null) {
            pbpagerequestmessage.set_st_type(this.aok);
        }
        if (this.bwK) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bwJ));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bwP) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.f(this.bwN, 0));
            pbpagerequestmessage.setOpMessageID(this.bwJ);
        }
        ArrayList<com.baidu.tieba.data.ak> zL = this.bwL.zL();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bwA) {
                        if (this.bwG > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bwG - 1));
                        }
                    } else if (this.bwF < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bwF + 1));
                    }
                }
                if (zL != null && zL.size() > 0) {
                    this.bwy = zL.get(zL.size() - 1).getId();
                }
                if (this.bwy != null && this.bwy.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwy, 0L));
                    break;
                } else if (!this.bwA) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (zL != null && zL.size() > 0) {
                    this.bwy = zL.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bwA) {
                        if (this.bwG > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bwG - 1));
                        }
                    } else if (this.bwF < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bwF + 1));
                    }
                }
                if (this.bwy != null && this.bwy.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwy, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(WT(), true, this.bwy, 3);
                } else {
                    a(WT(), false, this.bwy, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bwA) {
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
                a(WT(), true, this.bwy, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwy, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bwE));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwy, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(WT());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void gP(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.data.ak> zL = this.bwL.zL();
        if (i == 1) {
            boolean z2 = false;
            while (zL.size() + 30 > com.baidu.tieba.data.e.yy()) {
                zL.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bwL.zM().aS(1);
                if (this.bwM != null) {
                    this.bwM.a(this.bwL);
                }
            }
        } else if (i == 2) {
            while (zL.size() + 30 > com.baidu.tieba.data.e.yy()) {
                zL.remove(zL.size() - 1);
                z = true;
            }
            if (z) {
                this.bwL.zM().aR(1);
            }
        }
    }

    public void a(com.baidu.tieba.data.ah ahVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.data.ah ahVar2 = z ? null : ahVar;
        this.isLoading = false;
        if (ahVar2 != null) {
            c(ahVar2);
        }
        a(ahVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.data.ah ahVar) {
        if (ahVar != null) {
            String str = null;
            if (ahVar.zK() != null && ahVar.zK().getAuthor() != null) {
                str = ahVar.zK().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.q zK = ahVar.zK();
            zK.aU(this.bwB);
            zK.aT(this.bwC);
            zK.h(this.bwD);
            for (int i = 0; i < ahVar.zL().size(); i++) {
                com.baidu.tieba.data.ak akVar = ahVar.zL().get(i);
                for (int i2 = 0; i2 < akVar.Ab().size(); i2++) {
                    akVar.Ab().get(i2).a(this.mContext, str2.equals(akVar.Ab().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.data.ah ahVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aAE != null && !z3) {
            this.aAE.a(z2, z4, i2, str, i3, j, j2);
            this.aAE = null;
        }
        if (ahVar == null) {
            if (this.bwM != null) {
                this.bwM.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bwK = false;
            if (ahVar.zM() != null) {
                gN(ahVar.zM().kf());
                this.totalPage = ahVar.zM().kc();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.data.ak> zL = this.bwL.zL();
            switch (i) {
                case 1:
                    this.bwL.a(ahVar.zM(), 1);
                    if (ahVar.zL() != null) {
                        zL.addAll(ahVar.zL());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (ahVar.zL() != null) {
                        i5 = ahVar.zL().size() + 1;
                        zL.addAll(0, ahVar.zL());
                    }
                    this.bwL.a(ahVar.zM(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bwA && ahVar.zM() != null) {
                        ahVar.zM().aP(ahVar.zM().kc());
                    }
                    d(ahVar);
                    i4 = 0;
                    break;
                case 4:
                    d(ahVar);
                    i4 = 0;
                    break;
                case 5:
                    d(ahVar);
                    i4 = 0;
                    break;
                case 6:
                    d(ahVar);
                    i4 = 0;
                    break;
                default:
                    i4 = i5;
                    break;
            }
            if (this.bwL != null && this.bwL.zK() != null) {
                PraiseData praise = this.bwL.zK().getPraise();
                if (this.bwT != null && !praise.isPriaseDataValid()) {
                    this.bwL.zK().setPraise(this.bwT);
                } else {
                    this.bwT = this.bwL.zK().getPraise();
                    this.bwT.setPostId(this.bwL.zK().kG());
                }
                this.bwL.zK().setReply_num(ahVar.zK().getReply_num());
            }
            if (this.bwM != null) {
                this.bwM.a(true, getErrorCode(), i, i4, this.bwL, this.mErrorString, 1);
            }
        }
        if (this.bwL != null && this.bwL.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bwL.getUserData().getIsMem())));
        }
        if (this.bwL != null && this.bwL.zK() != null && this.bwL.zJ() != null) {
            com.baidu.tieba.pb.history.f fVar = new com.baidu.tieba.pb.history.f(this.bwQ);
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.setThreadId(getPbData().zK().getId());
            aiVar.setForumName(getPbData().zJ().getName());
            aiVar.ex(getPbData().zK().getTitle());
            aiVar.bt(getHostMode());
            aiVar.bu(WG());
            fVar.a((com.baidu.tieba.pb.history.f) aiVar);
        }
    }

    private void d(com.baidu.tieba.data.ah ahVar) {
        this.bwL = ahVar;
        gM(ahVar.zM().kf());
    }

    public boolean WN() {
        if (this.bwx == null || this.bwy == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return gO(4);
        }
        return gO(6);
    }

    public boolean dZ(boolean z) {
        if (this.bwx == null || this.bwL == null) {
            return false;
        }
        if (z || this.bwL.zM().kh() != 0) {
            return gO(1);
        }
        return false;
    }

    public boolean ea(boolean z) {
        if (this.bwx == null || this.bwL == null) {
            return false;
        }
        if ((z || this.bwL.zM().ki() != 0) && this.bwL.zL() != null && this.bwL.zL().size() >= 1) {
            return gO(2);
        }
        return false;
    }

    public boolean WO() {
        this.bwz = !this.bwz;
        if (this.bwz) {
            this.bwA = true;
        }
        LoadData();
        return true;
    }

    public boolean WP() {
        this.bwA = !this.bwA;
        if (!this.bwA) {
            this.bwz = false;
        }
        return LoadData();
    }

    public boolean WQ() {
        return this.bwA;
    }

    public boolean Tr() {
        return (this.bwL == null || this.bwL.zJ() == null || this.bwL.zK() == null) ? false : true;
    }

    public boolean zN() {
        if (this.bwL == null) {
            return false;
        }
        return this.bwL.zN();
    }

    public WriteData gW(String str) {
        if (this.bwL == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bwL.zJ().getId());
        writeData.setForumName(this.bwL.zJ().getName());
        writeData.setThreadId(this.bwx);
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

    public com.baidu.tieba.data.ar c(com.baidu.tieba.data.ak akVar) {
        if (akVar == null) {
            return null;
        }
        com.baidu.tieba.data.ar arVar = new com.baidu.tieba.data.ar();
        arVar.a(this.bwL.zJ());
        arVar.a(this.bwL.zK());
        arVar.a(akVar);
        arVar.l(akVar.Ab());
        arVar.setTotalCount(akVar.Ai());
        String zO = this.bwL.zO();
        String id = akVar.getId();
        if (zN() && zO != null && id != null && zO.equals(id)) {
            arVar.bs(true);
            return arVar;
        }
        arVar.bs(false);
        return arVar;
    }

    public MarkData gQ(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bwL == null || this.bwL.zL() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.ak> zL = this.bwL.zL();
        if (zL.size() > 0 && i == zL.size()) {
            i = zL.size() - 1;
        }
        if (zL.size() <= 0 || i >= zL.size()) {
            return null;
        }
        return d(zL.get(i));
    }

    public MarkData WR() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.bwx);
        markData.setPostId(this.bwL.zO());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bwz);
        markData.setSequence(Boolean.valueOf(this.bwA));
        markData.setId(this.bwx);
        return markData;
    }

    public MarkData d(com.baidu.tieba.data.ak akVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.bwx);
        markData.setPostId(akVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bwz);
        markData.setSequence(Boolean.valueOf(this.bwA));
        markData.setId(this.bwx);
        markData.setFloor(akVar.Ae());
        return markData;
    }

    public void WS() {
        bm.WB().y(WT(), this.isFromMark);
    }

    private String WT() {
        String str = this.bwx;
        if (this.bwz) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bwA) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkApplication.getCurrentAccount();
        }
        return str;
    }

    public void eb(boolean z) {
        if (this.bwL != null) {
            this.bwL.bs(z);
        }
    }

    public void ec(boolean z) {
        this.bwP = z;
    }

    public void a(bq bqVar) {
        this.bwM = bqVar;
    }
}
