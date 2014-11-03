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
    private static final int bwK = com.baidu.tieba.data.e.yA() / 30;
    private com.baidu.tieba.b.a aAO;
    private long aAa;
    private long aAb;
    private long aAc;
    private long aAd;
    private String aot;
    private CustomMessageListener bhX;
    private String bwL;
    private String bwM;
    private boolean bwN;
    private boolean bwO;
    private int bwP;
    private int bwQ;
    private long bwR;
    private int bwS;
    private int bwT;
    private int bwU;
    private boolean bwV;
    private boolean bwW;
    private long bwX;
    private boolean bwY;
    private com.baidu.tieba.data.ah bwZ;
    private bq bxa;
    private String bxb;
    private String bxc;
    private boolean bxd;
    private PbActivity bxe;
    private boolean bxf;
    private com.baidu.adp.framework.listener.a bxg;
    private PraiseData bxh;
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
        this.aot = null;
        this.bwL = null;
        this.bwM = null;
        this.bwN = false;
        this.bwO = true;
        this.bwP = 0;
        this.bwQ = 0;
        this.bwR = 0L;
        this.bwS = 1;
        this.bwT = 1;
        this.bwU = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bwV = false;
        this.bwW = false;
        this.isFromMark = false;
        this.bwX = 0L;
        this.bwY = false;
        this.mForumName = null;
        this.bwZ = null;
        this.isLoading = false;
        this.mContext = null;
        this.bxa = null;
        this.aAa = 0L;
        this.aAb = 0L;
        this.aAc = 0L;
        this.aAd = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bxb = null;
        this.bxc = null;
        this.aAO = null;
        this.bxf = false;
        this.bhX = new bo(this, 2004003);
        this.bxg = new bp(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bxh = null;
        registerListener(this.bhX);
        registerListener(this.bxg);
        this.bwZ = new com.baidu.tieba.data.ah();
        this.mContext = pbActivity;
        this.bxe = pbActivity;
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
        this.bwL = intent.getStringExtra("thread_id");
        this.bwM = intent.getStringExtra("post_id");
        this.bwN = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bwO = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aot = intent.getStringExtra("st_type");
        this.bwP = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bwQ = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bwR = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bwW = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bwV = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bwY = intent.getBooleanExtra("is_pv", false);
        this.bwX = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bxc = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bxb = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bwL = bundle.getString("thread_id");
        this.bwM = bundle.getString("post_id");
        this.bwN = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bwO = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aot = bundle.getString("st_type");
        this.bwP = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bwQ = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bwR = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bwW = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bwV = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bwY = bundle.getBoolean("is_pv", false);
        this.bwX = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bxc = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bwL);
        bundle.putString("post_id", this.bwM);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bwN);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bwO);
        bundle.putString("st_type", this.aot);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bwP);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bwQ);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bwR);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bwW);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bwV);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bwY);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bwX);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bxc);
    }

    public String WG() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bwL);
        sb.append(this.bwM);
        sb.append(this.bwN);
        sb.append(this.bwO);
        sb.append(this.aot);
        sb.append(this.bwP);
        sb.append(this.bwQ);
        sb.append(this.bwR);
        sb.append(this.bwW);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bwV);
        sb.append(this.bwY);
        sb.append(this.bwX);
        sb.append(this.mForumName);
        if (this.bxc != null) {
            sb.append(this.bxc);
        }
        return sb.toString();
    }

    public String WH() {
        return this.mForumName;
    }

    public String WI() {
        return this.bwL;
    }

    public boolean getHostMode() {
        return this.bwN;
    }

    public boolean WJ() {
        return this.bwO;
    }

    public boolean WK() {
        return this.bwW;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bwP;
    }

    public int getIsMem() {
        if (this.bwZ == null || this.bwZ.getUserData() == null) {
            return 0;
        }
        return this.bwZ.getUserData().getIsMem();
    }

    public int WL() {
        return this.bwQ;
    }

    public void setIsGood(int i) {
        this.bwP = i;
    }

    public void gK(int i) {
        this.bwQ = i;
    }

    public boolean WM() {
        return this.bwV;
    }

    public boolean WN() {
        if (this.bwZ == null) {
            return false;
        }
        return this.bwZ.isValid();
    }

    public String kD() {
        if (this.bwZ == null || !this.bwZ.zP()) {
            return null;
        }
        return this.bwZ.zQ();
    }

    public boolean gL(int i) {
        this.bwS = i;
        if (this.bwS > this.bwZ.zO().kc()) {
            this.bwS = this.bwZ.zO().kc();
        }
        if (this.bwS < 1) {
            this.bwS = 1;
        }
        if (this.bwL == null) {
            return false;
        }
        return gO(5);
    }

    public void gM(int i) {
        this.bwS = i;
        this.bwT = i;
        this.bwU = i;
    }

    public void gN(int i) {
        if (this.bwT < i) {
            this.bwT = i;
            if (this.bwT - this.bwU >= bwK) {
                this.bwU = (this.bwT - bwK) + 1;
            }
        }
        if (this.bwU > i) {
            this.bwU = i;
            if (this.bwT - this.bwU >= bwK) {
                this.bwT = (this.bwU + bwK) - 1;
            }
        }
    }

    public com.baidu.tieba.data.ah getPbData() {
        return this.bwZ;
    }

    public com.baidu.tbadk.core.data.m WO() {
        if (this.bwZ == null) {
            return null;
        }
        return this.bwZ.zO();
    }

    public boolean WP() {
        if (this.bwO) {
            if (this.bwZ.zO().kh() == 0) {
                dZ(true);
                return true;
            }
        } else if (this.bwZ.zO().ki() == 0) {
            ea(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.bwL == null) {
            return false;
        }
        cancelLoadData();
        if (this.aAO == null) {
            this.aAO = new com.baidu.tieba.b.a("pbStat");
            this.aAO.start();
        }
        boolean gO = gO(3);
        if (this.opType != null) {
            this.opType = null;
            this.bxb = null;
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

    public void ya() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Tq();
    }

    private void Tq() {
        if (this.aAO != null) {
            this.aAO.ya();
            this.aAO = null;
        }
    }

    public boolean tN() {
        return (this.bwM == null || this.bwM.equals("0") || this.bwM.length() == 0) ? LoadData() : WQ();
    }

    public boolean gO(int i) {
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        gP(i);
        com.baidu.tieba.data.ah pbData = bs.Xc().getPbData();
        if (pbData != null) {
            this.bwO = bs.Xc().WJ();
            this.bwN = bs.Xc().Xe();
            if (!this.bwO || this.bwN || this.isFromMark) {
                this.bxd = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bxa.dV(true);
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.QM);
        if (!this.bwO || this.bwN || this.isFromMark) {
            this.bxd = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bwL == null || this.bwL.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bwL, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int n = com.baidu.adp.lib.util.m.n(com.baidu.tieba.aj.wm().getApp());
        int o = com.baidu.adp.lib.util.m.o(com.baidu.tieba.aj.wm().getApp());
        float f = com.baidu.tieba.aj.wm().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ba.mD().mF() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(n));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(o));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bwO) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bwN) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aot != null) {
            pbpagerequestmessage.set_st_type(this.aot);
        }
        if (this.bwY) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bwX));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bxd) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.f(this.bxb, 0));
            pbpagerequestmessage.setOpMessageID(this.bwX);
        }
        ArrayList<com.baidu.tieba.data.ak> zN = this.bwZ.zN();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bwO) {
                        if (this.bwU > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bwU - 1));
                        }
                    } else if (this.bwT < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bwT + 1));
                    }
                }
                if (zN != null && zN.size() > 0) {
                    this.bwM = zN.get(zN.size() - 1).getId();
                }
                if (this.bwM != null && this.bwM.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwM, 0L));
                    break;
                } else if (!this.bwO) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (zN != null && zN.size() > 0) {
                    this.bwM = zN.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bwO) {
                        if (this.bwU > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bwU - 1));
                        }
                    } else if (this.bwT < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bwT + 1));
                    }
                }
                if (this.bwM != null && this.bwM.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwM, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(WW(), true, this.bwM, 3);
                } else {
                    a(WW(), false, this.bwM, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bwO) {
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
                a(WW(), true, this.bwM, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwM, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bwS));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bwM, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(WW());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void gP(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.data.ak> zN = this.bwZ.zN();
        if (i == 1) {
            boolean z2 = false;
            while (zN.size() + 30 > com.baidu.tieba.data.e.yA()) {
                zN.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bwZ.zO().aS(1);
                if (this.bxa != null) {
                    this.bxa.a(this.bwZ);
                }
            }
        } else if (i == 2) {
            while (zN.size() + 30 > com.baidu.tieba.data.e.yA()) {
                zN.remove(zN.size() - 1);
                z = true;
            }
            if (z) {
                this.bwZ.zO().aR(1);
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
            if (ahVar.zM() != null && ahVar.zM().getAuthor() != null) {
                str = ahVar.zM().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.q zM = ahVar.zM();
            zM.aU(this.bwP);
            zM.aT(this.bwQ);
            zM.h(this.bwR);
            for (int i = 0; i < ahVar.zN().size(); i++) {
                com.baidu.tieba.data.ak akVar = ahVar.zN().get(i);
                for (int i2 = 0; i2 < akVar.Ad().size(); i2++) {
                    akVar.Ad().get(i2).a(this.mContext, str2.equals(akVar.Ad().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.data.ah ahVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aAO != null && !z3) {
            this.aAO.a(z2, z4, i2, str, i3, j, j2);
            this.aAO = null;
        }
        if (ahVar == null) {
            if (this.bxa != null) {
                this.bxa.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bwY = false;
            if (ahVar.zO() != null) {
                gN(ahVar.zO().kf());
                this.totalPage = ahVar.zO().kc();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.data.ak> zN = this.bwZ.zN();
            switch (i) {
                case 1:
                    this.bwZ.a(ahVar.zO(), 1);
                    if (ahVar.zN() != null) {
                        zN.addAll(ahVar.zN());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (ahVar.zN() != null) {
                        i5 = ahVar.zN().size() + 1;
                        zN.addAll(0, ahVar.zN());
                    }
                    this.bwZ.a(ahVar.zO(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bwO && ahVar.zO() != null) {
                        ahVar.zO().aP(ahVar.zO().kc());
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
            if (this.bwZ != null && this.bwZ.zM() != null) {
                PraiseData praise = this.bwZ.zM().getPraise();
                if (this.bxh != null && !praise.isPriaseDataValid()) {
                    this.bwZ.zM().setPraise(this.bxh);
                } else {
                    this.bxh = this.bwZ.zM().getPraise();
                    this.bxh.setPostId(this.bwZ.zM().kG());
                }
                this.bwZ.zM().setReply_num(ahVar.zM().getReply_num());
            }
            if (this.bxa != null) {
                this.bxa.a(true, getErrorCode(), i, i4, this.bwZ, this.mErrorString, 1);
            }
        }
        if (this.bwZ != null && this.bwZ.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bwZ.getUserData().getIsMem())));
        }
        if (this.bwZ != null && this.bwZ.zM() != null && this.bwZ.zL() != null) {
            com.baidu.tieba.pb.history.f fVar = new com.baidu.tieba.pb.history.f(this.bxe);
            com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
            aiVar.setThreadId(getPbData().zM().getId());
            aiVar.setForumName(getPbData().zL().getName());
            aiVar.ex(getPbData().zM().getTitle());
            aiVar.bt(getHostMode());
            aiVar.bu(WJ());
            fVar.a((com.baidu.tieba.pb.history.f) aiVar);
        }
    }

    private void d(com.baidu.tieba.data.ah ahVar) {
        this.bwZ = ahVar;
        gM(ahVar.zO().kf());
    }

    public boolean WQ() {
        if (this.bwL == null || this.bwM == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return gO(4);
        }
        return gO(6);
    }

    public boolean dZ(boolean z) {
        if (this.bwL == null || this.bwZ == null) {
            return false;
        }
        if (z || this.bwZ.zO().kh() != 0) {
            return gO(1);
        }
        return false;
    }

    public boolean ea(boolean z) {
        if (this.bwL == null || this.bwZ == null) {
            return false;
        }
        if ((z || this.bwZ.zO().ki() != 0) && this.bwZ.zN() != null && this.bwZ.zN().size() >= 1) {
            return gO(2);
        }
        return false;
    }

    public boolean WR() {
        this.bwN = !this.bwN;
        if (this.bwN) {
            this.bwO = true;
        }
        LoadData();
        return true;
    }

    public boolean WS() {
        this.bwO = !this.bwO;
        if (!this.bwO) {
            this.bwN = false;
        }
        return LoadData();
    }

    public boolean WT() {
        return this.bwO;
    }

    public boolean Tu() {
        return (this.bwZ == null || this.bwZ.zL() == null || this.bwZ.zM() == null) ? false : true;
    }

    public boolean zP() {
        if (this.bwZ == null) {
            return false;
        }
        return this.bwZ.zP();
    }

    public WriteData gW(String str) {
        if (this.bwZ == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bwZ.zL().getId());
        writeData.setForumName(this.bwZ.zL().getName());
        writeData.setThreadId(this.bwL);
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
        arVar.a(this.bwZ.zL());
        arVar.a(this.bwZ.zM());
        arVar.a(akVar);
        arVar.m(akVar.Ad());
        arVar.setTotalCount(akVar.Ak());
        String zQ = this.bwZ.zQ();
        String id = akVar.getId();
        if (zP() && zQ != null && id != null && zQ.equals(id)) {
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
        if (this.bwZ == null || this.bwZ.zN() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.ak> zN = this.bwZ.zN();
        if (zN.size() > 0 && i == zN.size()) {
            i = zN.size() - 1;
        }
        if (zN.size() <= 0 || i >= zN.size()) {
            return null;
        }
        return d(zN.get(i));
    }

    public MarkData WU() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.bwL);
        markData.setPostId(this.bwZ.zQ());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bwN);
        markData.setSequence(Boolean.valueOf(this.bwO));
        markData.setId(this.bwL);
        return markData;
    }

    public MarkData d(com.baidu.tieba.data.ak akVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.bwL);
        markData.setPostId(akVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bwN);
        markData.setSequence(Boolean.valueOf(this.bwO));
        markData.setId(this.bwL);
        markData.setFloor(akVar.Ag());
        return markData;
    }

    public void WV() {
        bm.WE().y(WW(), this.isFromMark);
    }

    private String WW() {
        String str = this.bwL;
        if (this.bwN) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bwO) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkApplication.getCurrentAccount();
        }
        return str;
    }

    public void eb(boolean z) {
        if (this.bwZ != null) {
            this.bwZ.bs(z);
        }
    }

    public void ec(boolean z) {
        this.bxd = z;
    }

    public void a(bq bqVar) {
        this.bxa = bqVar;
    }
}
