package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
    private com.baidu.tieba.tbadkCore.d.a aDe;
    private boolean aez;
    private String auz;
    private com.baidu.tieba.tbadkCore.b.i bCA;
    private bt bCB;
    private String bCC;
    private String bCD;
    private boolean bCE;
    private PbActivity bCF;
    private boolean bCG;
    private com.baidu.adp.framework.listener.a bCH;
    private PraiseData bCI;
    private String bCm;
    private String bCn;
    private boolean bCo;
    private boolean bCp;
    private int bCq;
    private int bCr;
    private long bCs;
    private int bCt;
    private int bCu;
    private int bCv;
    private boolean bCw;
    private boolean bCx;
    private long bCy;
    private boolean bCz;
    private CustomMessageListener bnV;
    private long bul;
    private long bum;
    private long bun;
    private long buo;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;
    private int totalPage;

    public bq(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.auz = null;
        this.bCm = null;
        this.bCn = null;
        this.bCo = false;
        this.bCp = true;
        this.bCq = 0;
        this.bCr = 0;
        this.bCs = 0L;
        this.bCt = 1;
        this.bCu = 1;
        this.bCv = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bCw = false;
        this.bCx = false;
        this.isFromMark = false;
        this.bCy = 0L;
        this.bCz = false;
        this.mForumName = null;
        this.bCA = null;
        this.aez = false;
        this.mContext = null;
        this.bCB = null;
        this.bul = 0L;
        this.bum = 0L;
        this.bun = 0L;
        this.buo = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bCC = null;
        this.bCD = null;
        this.aDe = null;
        this.bCG = false;
        this.bnV = new br(this, 2004003);
        this.bCH = new bs(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bCI = null;
        registerListener(this.bnV);
        registerListener(this.bCH);
        this.bCA = new com.baidu.tieba.tbadkCore.b.i();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bCF = pbActivity;
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
        this.bCm = intent.getStringExtra("thread_id");
        this.bCn = intent.getStringExtra("post_id");
        this.bCo = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bCp = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.auz = intent.getStringExtra("st_type");
        this.bCq = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bCr = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bCs = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bCx = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bCw = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bCz = intent.getBooleanExtra("is_pv", false);
        this.bCy = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bCD = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bCC = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bCm = bundle.getString("thread_id");
        this.bCn = bundle.getString("post_id");
        this.bCo = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bCp = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.auz = bundle.getString("st_type");
        this.bCq = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bCr = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bCs = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bCx = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bCw = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bCz = bundle.getBoolean("is_pv", false);
        this.bCy = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bCD = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bCm);
        bundle.putString("post_id", this.bCn);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bCo);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bCp);
        bundle.putString("st_type", this.auz);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bCq);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bCr);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bCs);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bCx);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bCw);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bCz);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bCy);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bCD);
    }

    public String XD() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bCm);
        sb.append(this.bCn);
        sb.append(this.bCo);
        sb.append(this.bCp);
        sb.append(this.auz);
        sb.append(this.bCq);
        sb.append(this.bCr);
        sb.append(this.bCs);
        sb.append(this.bCx);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bCw);
        sb.append(this.bCz);
        sb.append(this.bCy);
        sb.append(this.mForumName);
        if (this.bCD != null) {
            sb.append(this.bCD);
        }
        return sb.toString();
    }

    public String XE() {
        return this.mForumName;
    }

    public String XF() {
        return this.bCm;
    }

    public boolean getHostMode() {
        return this.bCo;
    }

    public boolean XG() {
        return this.bCp;
    }

    public boolean XH() {
        return this.bCx;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bCq;
    }

    public int getIsMem() {
        if (this.bCA == null || this.bCA.getUserData() == null) {
            return 0;
        }
        return this.bCA.getUserData().getIsMem();
    }

    public int XI() {
        return this.bCr;
    }

    public void setIsGood(int i) {
        this.bCq = i;
    }

    public void gZ(int i) {
        this.bCr = i;
    }

    public boolean XJ() {
        return this.bCw;
    }

    public boolean XK() {
        if (this.bCA == null) {
            return false;
        }
        return this.bCA.isValid();
    }

    public String ns() {
        if (this.bCA == null || !this.bCA.lb()) {
            return null;
        }
        return this.bCA.ld();
    }

    public boolean ha(int i) {
        this.bCt = i;
        if (this.bCt > this.bCA.mT().mN()) {
            this.bCt = this.bCA.mT().mN();
        }
        if (this.bCt < 1) {
            this.bCt = 1;
        }
        if (this.bCm == null) {
            return false;
        }
        return hd(5);
    }

    public void hb(int i) {
        this.bCt = i;
        this.bCu = i;
        this.bCv = i;
    }

    public void hc(int i) {
        if (this.bCu < i) {
            this.bCu = i;
            if (this.bCu - this.bCv >= MAX_PAGE_NUM) {
                this.bCv = (this.bCu - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bCv > i) {
            this.bCv = i;
            if (this.bCu - this.bCv >= MAX_PAGE_NUM) {
                this.bCu = (this.bCv + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.tbadkCore.b.i getPbData() {
        return this.bCA;
    }

    public com.baidu.tbadk.core.data.q XL() {
        if (this.bCA == null) {
            return null;
        }
        return this.bCA.mT();
    }

    public boolean XM() {
        if (this.bCp) {
            if (this.bCA.mT().mR() == 0) {
                dQ(true);
                return true;
            }
        } else if (this.bCA.mT().mS() == 0) {
            dR(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bCm == null) {
            return false;
        }
        cancelLoadData();
        if (this.aDe == null) {
            this.aDe = new com.baidu.tieba.tbadkCore.d.a("pbStat");
            this.aDe.start();
        }
        boolean hd = hd(3);
        if (this.opType != null) {
            this.opType = null;
            this.bCC = null;
            this.opUrl = null;
            return hd;
        }
        return hd;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.aez = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Uw();
    }

    private void Uw() {
        if (this.aDe != null) {
            this.aDe.destory();
            this.aDe = null;
        }
    }

    public boolean xF() {
        return (this.bCn == null || this.bCn.equals("0") || this.bCn.length() == 0) ? LoadData() : XN();
    }

    public boolean hd(int i) {
        if (this.aez) {
            return false;
        }
        this.aez = true;
        he(i);
        com.baidu.tieba.tbadkCore.b.i pbData = bv.XZ().getPbData();
        if (pbData != null) {
            this.bCp = bv.XZ().XG();
            this.bCo = bv.XZ().Yb();
            if (!this.bCp || this.bCo || this.isFromMark) {
                this.bCE = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bCB.dM(true);
            this.aez = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.Xn);
        if (!this.bCp || this.bCo || this.isFromMark) {
            this.bCE = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bCm == null || this.bCm.length() == 0) {
            this.aez = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bCm, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int M = com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
        int N = com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp());
        float f = TbadkCoreApplication.m255getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bg.pB().pD() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(M));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(N));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bCp) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bCo) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.auz != null) {
            pbpagerequestmessage.set_st_type(this.auz);
        }
        if (this.bCz) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bCy));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bCE) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bCC, 0));
            pbpagerequestmessage.setOpMessageID(this.bCy);
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bCA.ahf();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bCp) {
                        if (this.bCv > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bCv - 1));
                        }
                    } else if (this.bCu < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bCu + 1));
                    }
                }
                if (ahf != null && ahf.size() > 0) {
                    int size = ahf.size();
                    for (int i3 = 1; size - i3 >= 0; i3++) {
                        this.bCn = ahf.get(size - i3).getId();
                        if (StringUtils.isNull(this.bCn)) {
                        }
                    }
                }
                if (this.bCn != null && this.bCn.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCn, 0L));
                    break;
                } else if (!this.bCp) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (ahf != null && ahf.size() > 0 && ahf.get(0) != null) {
                    this.bCn = ahf.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bCp) {
                        if (this.bCv > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bCv - 1));
                        }
                    } else if (this.bCu < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bCu + 1));
                    }
                }
                if (this.bCn != null && this.bCn.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCn, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(XT(), true, this.bCn, 3);
                } else {
                    a(XT(), false, this.bCn, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bCp) {
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
                a(XT(), true, this.bCn, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCn, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bCt));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bCn, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(XT());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void he(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bCA.ahf();
        if (i == 1) {
            boolean z2 = false;
            while (ahf.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ahf.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bCA.mT().bt(1);
                if (this.bCB != null) {
                    this.bCB.a(this.bCA);
                }
            }
        } else if (i == 2) {
            while (ahf.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ahf.remove(ahf.size() - 1);
                z = true;
            }
            if (z) {
                this.bCA.mT().bs(1);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.tbadkCore.b.i iVar2 = z ? null : iVar;
        this.aez = false;
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
            if (iVar.ahe() != null && iVar.ahe().getAuthor() != null) {
                str = iVar.ahe().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.x ahe = iVar.ahe();
            ahe.bv(this.bCq);
            ahe.bu(this.bCr);
            ahe.l(this.bCs);
            for (int i = 0; i < iVar.ahf().size(); i++) {
                com.baidu.tieba.tbadkCore.b.k kVar = iVar.ahf().get(i);
                for (int i2 = 0; i2 < kVar.ahq().size(); i2++) {
                    kVar.ahq().get(i2).a(this.bCF.getPageContext(), str2.equals(kVar.ahq().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.tbadkCore.b.i iVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aDe != null && !z3) {
            this.aDe.a(z2, z4, i2, str, i3, j, j2);
            this.aDe = null;
        }
        if (iVar == null) {
            if (this.bCB != null) {
                this.bCB.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bCz = false;
            if (iVar.mT() != null) {
                hc(iVar.mT().mP());
                this.totalPage = iVar.mT().mN();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bCA.ahf();
            switch (i) {
                case 1:
                    this.bCA.a(iVar.mT(), 1);
                    if (iVar.ahf() != null) {
                        ahf.addAll(iVar.ahf());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (iVar.ahf() != null) {
                        i5 = iVar.ahf().size() + 1;
                        ahf.addAll(0, iVar.ahf());
                    }
                    this.bCA.a(iVar.mT(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bCp && iVar.mT() != null) {
                        iVar.mT().bq(iVar.mT().mN());
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
            if (this.bCA != null && this.bCA.ahe() != null) {
                PraiseData praise = this.bCA.ahe().getPraise();
                if (this.bCI != null && !praise.isPriaseDataValid()) {
                    this.bCA.ahe().setPraise(this.bCI);
                } else {
                    this.bCI = this.bCA.ahe().getPraise();
                    this.bCI.setPostId(this.bCA.ahe().ny());
                }
                if (iVar.mT() != null && iVar.mT().mP() == 1) {
                    this.bCA.ahe().p(iVar.ahe().nt());
                }
                this.bCA.ahe().setReply_num(iVar.ahe().getReply_num());
            }
            if (this.bCB != null) {
                this.bCB.a(true, getErrorCode(), i, i4, this.bCA, this.mErrorString, 1);
            }
        }
        if (this.bCA != null && this.bCA.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bCA.getUserData().getIsMem())));
        }
        if (this.bCA != null && this.bCA.ahe() != null && this.bCA.aeI() != null) {
            com.baidu.tbadk.b.a aVar = new com.baidu.tbadk.b.a(this.bCF);
            com.baidu.tbadk.b.b bVar = new com.baidu.tbadk.b.b();
            bVar.setThreadId(getPbData().ahe().getId());
            bVar.setForumName(getPbData().aeI().getName());
            bVar.bA(getPbData().ahe().getTitle());
            bVar.Z(getHostMode());
            bVar.aa(XG());
            aVar.a((com.baidu.tbadk.b.a) bVar);
        }
    }

    private void d(com.baidu.tieba.tbadkCore.b.i iVar) {
        this.bCA = iVar;
        hb(iVar.mT().mP());
    }

    public boolean XN() {
        if (this.bCm == null || this.bCn == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hd(4);
        }
        return hd(6);
    }

    public boolean dQ(boolean z) {
        if (this.bCm == null || this.bCA == null) {
            return false;
        }
        if (z || this.bCA.mT().mR() != 0) {
            return hd(1);
        }
        return false;
    }

    public boolean dR(boolean z) {
        if (this.bCm == null || this.bCA == null) {
            return false;
        }
        if ((z || this.bCA.mT().mS() != 0) && this.bCA.ahf() != null && this.bCA.ahf().size() >= 1) {
            return hd(2);
        }
        return false;
    }

    public boolean XO() {
        this.bCo = !this.bCo;
        if (this.bCo) {
            this.bCp = true;
        }
        LoadData();
        return true;
    }

    public boolean XP() {
        this.bCp = !this.bCp;
        if (!this.bCp) {
            this.bCo = false;
        }
        return LoadData();
    }

    public boolean XQ() {
        return this.bCp;
    }

    public boolean UA() {
        return (this.bCA == null || this.bCA.aeI() == null || this.bCA.ahe() == null) ? false : true;
    }

    public boolean lb() {
        if (this.bCA == null) {
            return false;
        }
        return this.bCA.lb();
    }

    public WriteData hz(String str) {
        if (this.bCA == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bCA.aeI().getId());
        writeData.setForumName(this.bCA.aeI().getName());
        writeData.setThreadId(this.bCm);
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
        oVar.b(this.bCA.aeI());
        oVar.f(this.bCA.ahe());
        oVar.d(kVar);
        oVar.Q(kVar.ahq());
        oVar.setTotalCount(kVar.ahx());
        String ld = this.bCA.ld();
        String id = kVar.getId();
        if (lb() && ld != null && id != null && ld.equals(id)) {
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
        if (this.bCA == null || this.bCA.ahf() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.b.k> ahf = this.bCA.ahf();
        if (ahf.size() > 0 && i == ahf.size()) {
            i = ahf.size() - 1;
        }
        if (ahf.size() <= 0 || i >= ahf.size()) {
            return null;
        }
        return c(ahf.get(i));
    }

    public MarkData XR() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bCm);
        markData.setPostId(this.bCA.ld());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bCo);
        markData.setSequence(Boolean.valueOf(this.bCp));
        markData.setId(this.bCm);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.b.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bCm);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bCo);
        markData.setSequence(Boolean.valueOf(this.bCp));
        markData.setId(this.bCm);
        markData.setFloor(kVar.aht());
        return markData;
    }

    public void XS() {
        bp.XB().w(XT(), this.isFromMark);
    }

    private String XT() {
        String str = this.bCm;
        if (this.bCo) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bCp) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dS(boolean z) {
        if (this.bCA != null) {
            this.bCA.Y(z);
        }
    }

    public void dT(boolean z) {
        this.bCE = z;
    }

    public void a(bt btVar) {
        this.bCB = btVar;
    }
}
