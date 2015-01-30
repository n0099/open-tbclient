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
    private com.baidu.tieba.tbadkCore.d.a aDh;
    private boolean aeC;
    private String auC;
    private boolean bCA;
    private com.baidu.tieba.tbadkCore.b.i bCB;
    private bt bCC;
    private String bCD;
    private String bCE;
    private boolean bCF;
    private PbActivity bCG;
    private boolean bCH;
    private com.baidu.adp.framework.listener.a bCI;
    private PraiseData bCJ;
    private String bCn;
    private String bCo;
    private boolean bCp;
    private boolean bCq;
    private int bCr;
    private int bCs;
    private long bCt;
    private int bCu;
    private int bCv;
    private int bCw;
    private boolean bCx;
    private boolean bCy;
    private long bCz;
    private CustomMessageListener bnW;
    private long bum;
    private long bun;
    private long buo;
    private long bup;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;
    private int totalPage;

    public bq(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.auC = null;
        this.bCn = null;
        this.bCo = null;
        this.bCp = false;
        this.bCq = true;
        this.bCr = 0;
        this.bCs = 0;
        this.bCt = 0L;
        this.bCu = 1;
        this.bCv = 1;
        this.bCw = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bCx = false;
        this.bCy = false;
        this.isFromMark = false;
        this.bCz = 0L;
        this.bCA = false;
        this.mForumName = null;
        this.bCB = null;
        this.aeC = false;
        this.mContext = null;
        this.bCC = null;
        this.bum = 0L;
        this.bun = 0L;
        this.buo = 0L;
        this.bup = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bCD = null;
        this.bCE = null;
        this.aDh = null;
        this.bCH = false;
        this.bnW = new br(this, 2004003);
        this.bCI = new bs(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bCJ = null;
        registerListener(this.bnW);
        registerListener(this.bCI);
        this.bCB = new com.baidu.tieba.tbadkCore.b.i();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bCG = pbActivity;
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
        this.bCn = intent.getStringExtra("thread_id");
        this.bCo = intent.getStringExtra("post_id");
        this.bCp = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bCq = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.auC = intent.getStringExtra("st_type");
        this.bCr = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bCs = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bCt = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bCy = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bCx = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bCA = intent.getBooleanExtra("is_pv", false);
        this.bCz = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bCE = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bCD = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bCn = bundle.getString("thread_id");
        this.bCo = bundle.getString("post_id");
        this.bCp = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bCq = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.auC = bundle.getString("st_type");
        this.bCr = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bCs = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bCt = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bCy = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bCx = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bCA = bundle.getBoolean("is_pv", false);
        this.bCz = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bCE = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bCn);
        bundle.putString("post_id", this.bCo);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bCp);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bCq);
        bundle.putString("st_type", this.auC);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bCr);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bCs);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bCt);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bCy);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bCx);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bCA);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bCz);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bCE);
    }

    public String XI() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bCn);
        sb.append(this.bCo);
        sb.append(this.bCp);
        sb.append(this.bCq);
        sb.append(this.auC);
        sb.append(this.bCr);
        sb.append(this.bCs);
        sb.append(this.bCt);
        sb.append(this.bCy);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bCx);
        sb.append(this.bCA);
        sb.append(this.bCz);
        sb.append(this.mForumName);
        if (this.bCE != null) {
            sb.append(this.bCE);
        }
        return sb.toString();
    }

    public String XJ() {
        return this.mForumName;
    }

    public String XK() {
        return this.bCn;
    }

    public boolean getHostMode() {
        return this.bCp;
    }

    public boolean XL() {
        return this.bCq;
    }

    public boolean XM() {
        return this.bCy;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bCr;
    }

    public int getIsMem() {
        if (this.bCB == null || this.bCB.getUserData() == null) {
            return 0;
        }
        return this.bCB.getUserData().getIsMem();
    }

    public int XN() {
        return this.bCs;
    }

    public void setIsGood(int i) {
        this.bCr = i;
    }

    public void gZ(int i) {
        this.bCs = i;
    }

    public boolean XO() {
        return this.bCx;
    }

    public boolean XP() {
        if (this.bCB == null) {
            return false;
        }
        return this.bCB.isValid();
    }

    public String nz() {
        if (this.bCB == null || !this.bCB.li()) {
            return null;
        }
        return this.bCB.lk();
    }

    public boolean ha(int i) {
        this.bCu = i;
        if (this.bCu > this.bCB.na().mU()) {
            this.bCu = this.bCB.na().mU();
        }
        if (this.bCu < 1) {
            this.bCu = 1;
        }
        if (this.bCn == null) {
            return false;
        }
        return hd(5);
    }

    public void hb(int i) {
        this.bCu = i;
        this.bCv = i;
        this.bCw = i;
    }

    public void hc(int i) {
        if (this.bCv < i) {
            this.bCv = i;
            if (this.bCv - this.bCw >= MAX_PAGE_NUM) {
                this.bCw = (this.bCv - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bCw > i) {
            this.bCw = i;
            if (this.bCv - this.bCw >= MAX_PAGE_NUM) {
                this.bCv = (this.bCw + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        return this.bCB;
    }

    public com.baidu.tbadk.core.data.q XQ() {
        if (this.bCB == null) {
            return null;
        }
        return this.bCB.na();
    }

    public boolean XR() {
        if (this.bCq) {
            if (this.bCB.na().mY() == 0) {
                dQ(true);
                return true;
            }
        } else if (this.bCB.na().mZ() == 0) {
            dR(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bCn == null) {
            return false;
        }
        cancelLoadData();
        if (this.aDh == null) {
            this.aDh = new com.baidu.tieba.tbadkCore.d.a("pbStat");
            this.aDh.start();
        }
        boolean hd = hd(3);
        if (this.opType != null) {
            this.opType = null;
            this.bCD = null;
            this.opUrl = null;
            return hd;
        }
        return hd;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.aeC = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        UB();
    }

    private void UB() {
        if (this.aDh != null) {
            this.aDh.destory();
            this.aDh = null;
        }
    }

    public boolean xL() {
        return (this.bCo == null || this.bCo.equals("0") || this.bCo.length() == 0) ? LoadData() : XS();
    }

    public boolean hd(int i) {
        if (this.aeC) {
            return false;
        }
        this.aeC = true;
        he(i);
        com.baidu.tieba.tbadkCore.b.i pbData = bv.Ye().getPbData();
        if (pbData != null) {
            this.bCq = bv.Ye().XL();
            this.bCp = bv.Ye().Yg();
            if (!this.bCq || this.bCp || this.isFromMark) {
                this.bCF = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bCC.dM(true);
            this.aeC = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.Xq);
        if (!this.bCq || this.bCp || this.isFromMark) {
            this.bCF = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bCn == null || this.bCn.length() == 0) {
            this.aeC = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bCn, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        int N = com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp());
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bg.pI().pK() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(M));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(N));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bCq) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bCp) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.auC != null) {
            pbpagerequestmessage.set_st_type(this.auC);
        }
        if (this.bCA) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bCz));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bCF) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bCD, 0));
            pbpagerequestmessage.setOpMessageID(this.bCz);
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bCB.ahk();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bCq) {
                        if (this.bCw > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bCw - 1));
                        }
                    } else if (this.bCv < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bCv + 1));
                    }
                }
                if (ahk != null && ahk.size() > 0) {
                    this.bCo = ahk.get(ahk.size() - 1).getId();
                }
                if (this.bCo != null && this.bCo.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCo, 0L));
                    break;
                } else if (!this.bCq) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (ahk != null && ahk.size() > 0) {
                    this.bCo = ahk.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bCq) {
                        if (this.bCw > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bCw - 1));
                        }
                    } else if (this.bCv < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bCv + 1));
                    }
                }
                if (this.bCo != null && this.bCo.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCo, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(XY(), true, this.bCo, 3);
                } else {
                    a(XY(), false, this.bCo, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bCq) {
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
                a(XY(), true, this.bCo, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCo, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bCu));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCo, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(XY());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void he(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bCB.ahk();
        if (i == 1) {
            boolean z2 = false;
            while (ahk.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ahk.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bCB.na().bt(1);
                if (this.bCC != null) {
                    this.bCC.a(this.bCB);
                }
            }
        } else if (i == 2) {
            while (ahk.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ahk.remove(ahk.size() - 1);
                z = true;
            }
            if (z) {
                this.bCB.na().bs(1);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.tbadkCore.b.i iVar2 = z ? null : iVar;
        this.aeC = false;
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
            if (iVar.ahj() != null && iVar.ahj().getAuthor() != null) {
                str = iVar.ahj().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.x ahj = iVar.ahj();
            ahj.bv(this.bCr);
            ahj.bu(this.bCs);
            ahj.l(this.bCt);
            for (int i = 0; i < iVar.ahk().size(); i++) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahk().get(i);
                for (int i2 = 0; i2 < kVar.ahv().size(); i2++) {
                    kVar.ahv().get(i2).a(this.bCG.getPageContext(), str2.equals(kVar.ahv().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aDh != null && !z3) {
            this.aDh.a(z2, z4, i2, str, i3, j, j2);
            this.aDh = null;
        }
        if (iVar == null) {
            if (this.bCC != null) {
                this.bCC.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bCA = false;
            if (iVar.na() != null) {
                hc(iVar.na().mW());
                this.totalPage = iVar.na().mU();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bCB.ahk();
            switch (i) {
                case 1:
                    this.bCB.a(iVar.na(), 1);
                    if (iVar.ahk() != null) {
                        ahk.addAll(iVar.ahk());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (iVar.ahk() != null) {
                        i5 = iVar.ahk().size() + 1;
                        ahk.addAll(0, iVar.ahk());
                    }
                    this.bCB.a(iVar.na(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bCq && iVar.na() != null) {
                        iVar.na().bq(iVar.na().mU());
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
            if (this.bCB != null && this.bCB.ahj() != null) {
                PraiseData praise = this.bCB.ahj().getPraise();
                if (this.bCJ != null && !praise.isPriaseDataValid()) {
                    this.bCB.ahj().setPraise(this.bCJ);
                } else {
                    this.bCJ = this.bCB.ahj().getPraise();
                    this.bCJ.setPostId(this.bCB.ahj().nF());
                }
                if (iVar.na() != null && iVar.na().mW() == 1) {
                    this.bCB.ahj().p(iVar.ahj().nA());
                }
                this.bCB.ahj().setReply_num(iVar.ahj().getReply_num());
            }
            if (this.bCC != null) {
                this.bCC.a(true, getErrorCode(), i, i4, this.bCB, this.mErrorString, 1);
            }
        }
        if (this.bCB != null && this.bCB.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bCB.getUserData().getIsMem())));
        }
        if (this.bCB != null && this.bCB.ahj() != null && this.bCB.aeN() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this.bCG);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(getPbData().ahj().getId());
            bVar.setForumName(getPbData().aeN().getName());
            bVar.bD(getPbData().ahj().getTitle());
            bVar.Z(getHostMode());
            bVar.aa(XL());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bCB = iVar;
        hb(iVar.na().mW());
    }

    public boolean XS() {
        if (this.bCn == null || this.bCo == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hd(4);
        }
        return hd(6);
    }

    public boolean dQ(boolean z) {
        if (this.bCn == null || this.bCB == null) {
            return false;
        }
        if (z || this.bCB.na().mY() != 0) {
            return hd(1);
        }
        return false;
    }

    public boolean dR(boolean z) {
        if (this.bCn == null || this.bCB == null) {
            return false;
        }
        if ((z || this.bCB.na().mZ() != 0) && this.bCB.ahk() != null && this.bCB.ahk().size() >= 1) {
            return hd(2);
        }
        return false;
    }

    public boolean XT() {
        this.bCp = !this.bCp;
        if (this.bCp) {
            this.bCq = true;
        }
        LoadData();
        return true;
    }

    public boolean XU() {
        this.bCq = !this.bCq;
        if (!this.bCq) {
            this.bCp = false;
        }
        return LoadData();
    }

    public boolean XV() {
        return this.bCq;
    }

    public boolean UF() {
        return (this.bCB == null || this.bCB.aeN() == null || this.bCB.ahj() == null) ? false : true;
    }

    public boolean li() {
        if (this.bCB == null) {
            return false;
        }
        return this.bCB.li();
    }

    public WriteData hC(String str) {
        if (this.bCB == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bCB.aeN().getId());
        writeData.setForumName(this.bCB.aeN().getName());
        writeData.setThreadId(this.bCn);
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
        oVar.b(this.bCB.aeN());
        oVar.f(this.bCB.ahj());
        oVar.d(kVar);
        oVar.Q(kVar.ahv());
        oVar.setTotalCount(kVar.ahC());
        String lk = this.bCB.lk();
        String id = kVar.getId();
        if (li() && lk != null && id != null && lk.equals(id)) {
            oVar.Y(true);
            return oVar;
        }
        oVar.Y(false);
        return oVar;
    }

    public MarkData hf(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bCB == null || this.bCB.ahk() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahk = this.bCB.ahk();
        if (ahk.size() > 0 && i == ahk.size()) {
            i = ahk.size() - 1;
        }
        if (ahk.size() <= 0 || i >= ahk.size()) {
            return null;
        }
        return c(ahk.get(i));
    }

    public MarkData XW() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bCn);
        markData.setPostId(this.bCB.lk());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bCp);
        markData.setSequence(Boolean.valueOf(this.bCq));
        markData.setId(this.bCn);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.b.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bCn);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bCp);
        markData.setSequence(Boolean.valueOf(this.bCq));
        markData.setId(this.bCn);
        markData.setFloor(kVar.ahy());
        return markData;
    }

    public void XX() {
        bp.XG().w(XY(), this.isFromMark);
    }

    private String XY() {
        String str = this.bCn;
        if (this.bCp) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bCq) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dS(boolean z) {
        if (this.bCB != null) {
            this.bCB.Y(z);
        }
    }

    public void dT(boolean z) {
        this.bCF = z;
    }

    public void a(bt btVar) {
        this.bCC = btVar;
    }
}
