package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.f<PbActivity> {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private CustomMessageListener aAN;
    private com.baidu.tieba.tbadkCore.e.a aFs;
    private long aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private String aIi;
    private boolean aoe;
    private PbActivity bKZ;
    private int bLA;
    private int bLB;
    private int bLC;
    private boolean bLD;
    private boolean bLE;
    private long bLF;
    private boolean bLG;
    private com.baidu.tieba.pb.a.b bLH;
    private bs bLI;
    private String bLJ;
    private String bLK;
    private boolean bLL;
    private boolean bLM;
    private com.baidu.adp.framework.listener.a bLN;
    private PraiseData bLO;
    private String bLs;
    private String bLt;
    private boolean bLu;
    private boolean bLv;
    private int bLw;
    private int bLx;
    private long bLy;
    private int bLz;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;

    public bo(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.aIi = null;
        this.bLs = null;
        this.bLt = null;
        this.bLu = false;
        this.bLv = true;
        this.bLw = 0;
        this.bLx = 0;
        this.bLy = 0L;
        this.bLz = 1;
        this.bLA = 1;
        this.bLB = 1;
        this.bLC = 1;
        this.isAd = false;
        this.bLD = false;
        this.bLE = false;
        this.isFromMark = false;
        this.bLF = 0L;
        this.bLG = false;
        this.mForumName = null;
        this.bLH = null;
        this.aoe = false;
        this.mContext = null;
        this.bLI = null;
        this.aFt = 0L;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bLJ = null;
        this.bLK = null;
        this.aFs = null;
        this.bLM = false;
        this.aAN = new bp(this, 2004003);
        this.bLN = new br(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bLO = null;
        registerListener(this.aAN);
        registerListener(this.bLN);
        this.bLH = new com.baidu.tieba.pb.a.b();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bKZ = pbActivity;
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
        this.bLs = intent.getStringExtra("thread_id");
        this.bLt = intent.getStringExtra("post_id");
        this.bLu = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bLv = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aIi = intent.getStringExtra("st_type");
        this.bLw = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bLx = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bLy = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bLE = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bLD = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bLG = intent.getBooleanExtra("is_pv", false);
        this.bLF = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bLK = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bLJ = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bLs = bundle.getString("thread_id");
        this.bLt = bundle.getString("post_id");
        this.bLu = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bLv = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aIi = bundle.getString("st_type");
        this.bLw = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bLx = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bLy = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bLE = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bLD = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bLG = bundle.getBoolean("is_pv", false);
        this.bLF = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bLK = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bLs);
        bundle.putString("post_id", this.bLt);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bLu);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bLv);
        bundle.putString("st_type", this.aIi);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bLw);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bLx);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bLy);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bLE);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bLD);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bLG);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bLF);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bLK);
    }

    public String abm() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bLs);
        sb.append(this.bLt);
        sb.append(this.bLu);
        sb.append(this.bLv);
        sb.append(this.aIi);
        sb.append(this.bLw);
        sb.append(this.bLx);
        sb.append(this.bLy);
        sb.append(this.bLE);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bLD);
        sb.append(this.bLG);
        sb.append(this.bLF);
        sb.append(this.mForumName);
        if (this.bLK != null) {
            sb.append(this.bLK);
        }
        return sb.toString();
    }

    public String abn() {
        return this.mForumName;
    }

    public String abo() {
        return this.bLs;
    }

    public boolean getHostMode() {
        return this.bLu;
    }

    public boolean abp() {
        return this.bLv;
    }

    public boolean abq() {
        return this.bLE;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bLw;
    }

    public int getIsMem() {
        if (this.bLH == null || this.bLH.getUserData() == null) {
            return 0;
        }
        return this.bLH.getUserData().getIsMem();
    }

    public int abr() {
        return this.bLx;
    }

    public void setIsGood(int i) {
        this.bLw = i;
    }

    public void hz(int i) {
        this.bLx = i;
    }

    public boolean abs() {
        return this.bLD;
    }

    public boolean abt() {
        if (this.bLH == null) {
            return false;
        }
        return this.bLH.isValid();
    }

    public String ro() {
        if (this.bLH == null || !this.bLH.pq()) {
            return null;
        }
        return this.bLH.pp();
    }

    public boolean hA(int i) {
        this.bLz = i;
        if (this.bLz > this.bLH.Zp().qN()) {
            this.bLz = this.bLH.Zp().qN();
        }
        if (this.bLz < 1) {
            this.bLz = 1;
        }
        if (this.bLs == null) {
            return false;
        }
        return hD(5);
    }

    public void hB(int i) {
        this.bLz = i;
        this.bLA = i;
        this.bLB = i;
    }

    public void hC(int i) {
        if (this.bLA < i) {
            this.bLA = i;
            if (this.bLA - this.bLB >= MAX_PAGE_NUM) {
                this.bLB = (this.bLA - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bLB > i) {
            this.bLB = i;
            if (this.bLA - this.bLB >= MAX_PAGE_NUM) {
                this.bLA = (this.bLB + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.bLH;
    }

    public com.baidu.tbadk.core.data.q abu() {
        if (this.bLH == null) {
            return null;
        }
        return this.bLH.Zp();
    }

    public boolean abv() {
        if (this.bLv) {
            if (this.bLH.Zp().qR() == 0) {
                dV(true);
                return true;
            }
        } else if (this.bLH.Zp().qS() == 0) {
            dW(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bLs == null) {
            return false;
        }
        cancelLoadData();
        if (this.aFs == null) {
            this.aFs = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aFs.start();
        }
        boolean hD = hD(3);
        if (this.opType != null) {
            this.opType = null;
            this.bLJ = null;
            this.opUrl = null;
            return hD;
        }
        return hD;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.aoe = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Ie();
    }

    private void Ie() {
        if (this.aFs != null) {
            this.aFs.destory();
            this.aFs = null;
        }
    }

    public boolean BL() {
        return (this.bLt == null || this.bLt.equals(GameInfoData.NOT_FROM_DETAIL) || this.bLt.length() == 0) ? LoadData() : abw();
    }

    public boolean hD(int i) {
        if (this.aoe) {
            return false;
        }
        this.aoe = true;
        hE(i);
        com.baidu.tieba.pb.a.b pbData = cb.abK().getPbData();
        if (pbData != null) {
            this.bLv = cb.abK().abp();
            this.bLu = cb.abK().abM();
            if (!this.bLv || this.bLu || this.isFromMark) {
                this.bLL = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bLI.dR(true);
            this.aoe = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.aiC);
        if (!this.bLv || this.bLu || this.isFromMark) {
            this.bLL = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bLs == null || this.bLs.length() == 0) {
            this.aoe = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.c(this.bLs, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        int N = com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bc.tB().tD() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(M));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(N));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bLv) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bLu) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aIi != null) {
            pbpagerequestmessage.set_st_type(this.aIi);
        }
        if (this.bLG) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bLF));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bLL) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bLJ, 0));
            pbpagerequestmessage.setOpMessageID(this.bLF);
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bLH.aat();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bLv) {
                        if (this.bLB > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bLB - 1));
                        }
                    } else if (this.bLA < this.bLC) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bLA + 1));
                    }
                }
                if (aat != null && aat.size() > 0) {
                    int size = aat.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.j jVar = aat.get(size - i3);
                        if (jVar == null) {
                            i3++;
                        } else {
                            this.bLt = jVar.getId();
                            if (StringUtils.isNull(this.bLt)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.bLt != null && this.bLt.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLt, 0L));
                    break;
                } else if (!this.bLv) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aat != null && aat.size() > 0 && aat.get(0) != null) {
                    this.bLt = aat.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bLv) {
                        if (this.bLB > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bLB - 1));
                        }
                    } else if (this.bLA < this.bLC) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bLA + 1));
                    }
                }
                if (this.bLt != null && this.bLt.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLt, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(abD(), true, this.bLt, 3);
                } else {
                    a(abD(), false, this.bLt, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bLv) {
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
                a(abD(), true, this.bLt, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLt, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bLz));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLt, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(abD());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void hE(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bLH.aat();
        if (i == 1) {
            boolean z2 = false;
            while (aat.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aat.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bLH.Zp().bp(1);
                if (this.bLI != null) {
                    this.bLI.a(this.bLH);
                }
            }
        } else if (i == 2) {
            while (aat.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aat.remove(aat.size() - 1);
                z = true;
            }
            if (z) {
                this.bLH.Zp().bo(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.aoe = false;
        if (bVar2 != null) {
            c(bVar2);
        }
        a(bVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            String str = null;
            if (bVar.aas() != null && bVar.aas().getAuthor() != null) {
                str = bVar.aas().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.w aas = bVar.aas();
            aas.br(this.bLw);
            aas.bq(this.bLx);
            aas.m(this.bLy);
            for (int i = 0; i < bVar.aat().size(); i++) {
                com.baidu.tieba.tbadkCore.data.j jVar = bVar.aat().get(i);
                for (int i2 = 0; i2 < jVar.aoy().size(); i2++) {
                    jVar.aoy().get(i2).b(this.bKZ.getPageContext(), str2.equals(jVar.aoy().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aFs != null && !z3) {
            this.aFs.a(z2, z4, i2, str, i3, j, j2);
            this.aFs = null;
        }
        if (bVar == null) {
            if (this.bLI != null) {
                this.bLI.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bLG = false;
            if (bVar.Zp() != null) {
                hC(bVar.Zp().qP());
                this.bLC = bVar.Zp().qN();
            }
            this.bLC = this.bLC < 1 ? 1 : this.bLC;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bLH.aat();
            switch (i) {
                case 1:
                    this.bLH.a(bVar.Zp(), 1);
                    if (bVar.aat() != null) {
                        aat.addAll(bVar.aat());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (bVar.aat() != null) {
                        i5 = bVar.aat().size() + 1;
                        aat.addAll(0, bVar.aat());
                    }
                    this.bLH.a(bVar.Zp(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bLv && bVar.Zp() != null) {
                        bVar.Zp().bm(bVar.Zp().qN());
                    }
                    d(bVar);
                    i4 = 0;
                    break;
                case 4:
                    d(bVar);
                    i4 = 0;
                    break;
                case 5:
                    d(bVar);
                    i4 = 0;
                    break;
                case 6:
                    d(bVar);
                    i4 = 0;
                    break;
                default:
                    i4 = i5;
                    break;
            }
            if (this.bLH != null && this.bLH.aas() != null) {
                PraiseData praise = this.bLH.aas().getPraise();
                if (this.bLO != null && !praise.isPriaseDataValid()) {
                    this.bLH.aas().setPraise(this.bLO);
                } else {
                    this.bLO = this.bLH.aas().getPraise();
                    this.bLO.setPostId(this.bLH.aas().rs());
                }
                if (bVar.Zp() != null && bVar.Zp().qP() == 1) {
                    this.bLH.aas().k(bVar.aas().rp());
                }
                this.bLH.aas().setReply_num(bVar.aas().getReply_num());
            }
            if (this.bLI != null) {
                this.bLI.a(true, getErrorCode(), i, i4, this.bLH, this.mErrorString, 1);
            }
        }
        if (this.bLH != null && this.bLH.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bLH.getUserData().getIsMem())));
        }
        if (this.bLH != null && this.bLH.aas() != null && this.bLH.aar() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bKZ;
            historyMessage.threadId = getPbData().aas().getId();
            historyMessage.forumName = getPbData().aar().getName();
            historyMessage.threadName = getPbData().aas().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = abp();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void d(com.baidu.tieba.pb.a.b bVar) {
        this.bLH = bVar;
        hB(bVar.Zp().qP());
    }

    public boolean abw() {
        if (this.bLs == null || this.bLt == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hD(4);
        }
        return hD(6);
    }

    public boolean dV(boolean z) {
        if (this.bLs == null || this.bLH == null) {
            return false;
        }
        if (z || this.bLH.Zp().qR() != 0) {
            return hD(1);
        }
        return false;
    }

    public boolean dW(boolean z) {
        if (this.bLs == null || this.bLH == null) {
            return false;
        }
        if ((z || this.bLH.Zp().qS() != 0) && this.bLH.aat() != null && this.bLH.aat().size() >= 1) {
            return hD(2);
        }
        return false;
    }

    public boolean abx() {
        this.bLu = !this.bLu;
        LoadData();
        return true;
    }

    public boolean aby() {
        this.bLv = !this.bLv;
        return LoadData();
    }

    public boolean abz() {
        return this.bLv;
    }

    public boolean abA() {
        return (this.bLH == null || this.bLH.aar() == null || this.bLH.aas() == null) ? false : true;
    }

    public boolean pq() {
        if (this.bLH == null) {
            return false;
        }
        return this.bLH.pq();
    }

    public WriteData iq(String str) {
        if (this.bLH == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bLH.aar().getId());
        writeData.setForumName(this.bLH.aar().getName());
        writeData.setThreadId(this.bLs);
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

    public MarkData hF(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bLH == null || this.bLH.aat() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bLH.aat();
        if (aat.size() > 0 && i == aat.size()) {
            i = aat.size() - 1;
        }
        if (aat.size() <= 0 || i >= aat.size()) {
            return null;
        }
        return c(aat.get(i));
    }

    public MarkData abB() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bLs);
        markData.setPostId(this.bLH.pp());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bLu);
        markData.setSequence(Boolean.valueOf(this.bLv));
        markData.setId(this.bLs);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bLs);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bLu);
        markData.setSequence(Boolean.valueOf(this.bLv));
        markData.setId(this.bLs);
        markData.setFloor(jVar.aoB());
        return markData;
    }

    public void abC() {
        bm.abk().w(abD(), this.isFromMark);
    }

    private String abD() {
        String str = this.bLs;
        if (this.bLu) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bLv) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dX(boolean z) {
        if (this.bLH != null) {
            this.bLH.Z(z);
        }
    }

    public void dY(boolean z) {
        this.bLL = z;
    }

    public void a(bs bsVar) {
        this.bLI = bsVar;
    }
}
