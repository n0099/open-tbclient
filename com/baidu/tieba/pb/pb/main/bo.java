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
    private CustomMessageListener aAO;
    private com.baidu.tieba.tbadkCore.e.a aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private long aFx;
    private String aIj;
    private boolean aoe;
    private int bLA;
    private int bLB;
    private int bLC;
    private int bLD;
    private boolean bLE;
    private boolean bLF;
    private long bLG;
    private boolean bLH;
    private com.baidu.tieba.pb.a.b bLI;
    private bs bLJ;
    private String bLK;
    private String bLL;
    private boolean bLM;
    private boolean bLN;
    private com.baidu.adp.framework.listener.a bLO;
    private PraiseData bLP;
    private PbActivity bLa;
    private String bLt;
    private String bLu;
    private boolean bLv;
    private boolean bLw;
    private int bLx;
    private int bLy;
    private long bLz;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;

    public bo(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.aIj = null;
        this.bLt = null;
        this.bLu = null;
        this.bLv = false;
        this.bLw = true;
        this.bLx = 0;
        this.bLy = 0;
        this.bLz = 0L;
        this.bLA = 1;
        this.bLB = 1;
        this.bLC = 1;
        this.bLD = 1;
        this.isAd = false;
        this.bLE = false;
        this.bLF = false;
        this.isFromMark = false;
        this.bLG = 0L;
        this.bLH = false;
        this.mForumName = null;
        this.bLI = null;
        this.aoe = false;
        this.mContext = null;
        this.bLJ = null;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.aFx = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bLK = null;
        this.bLL = null;
        this.aFt = null;
        this.bLN = false;
        this.aAO = new bp(this, 2004003);
        this.bLO = new br(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bLP = null;
        registerListener(this.aAO);
        registerListener(this.bLO);
        this.bLI = new com.baidu.tieba.pb.a.b();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bLa = pbActivity;
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
        this.bLt = intent.getStringExtra("thread_id");
        this.bLu = intent.getStringExtra("post_id");
        this.bLv = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bLw = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aIj = intent.getStringExtra("st_type");
        this.bLx = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bLy = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bLz = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bLF = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bLE = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bLH = intent.getBooleanExtra("is_pv", false);
        this.bLG = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bLL = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bLK = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bLt = bundle.getString("thread_id");
        this.bLu = bundle.getString("post_id");
        this.bLv = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bLw = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aIj = bundle.getString("st_type");
        this.bLx = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bLy = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bLz = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bLF = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bLE = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bLH = bundle.getBoolean("is_pv", false);
        this.bLG = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bLL = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bLt);
        bundle.putString("post_id", this.bLu);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bLv);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bLw);
        bundle.putString("st_type", this.aIj);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bLx);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bLy);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bLz);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bLF);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bLE);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bLH);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bLG);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bLL);
    }

    public String abn() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bLt);
        sb.append(this.bLu);
        sb.append(this.bLv);
        sb.append(this.bLw);
        sb.append(this.aIj);
        sb.append(this.bLx);
        sb.append(this.bLy);
        sb.append(this.bLz);
        sb.append(this.bLF);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bLE);
        sb.append(this.bLH);
        sb.append(this.bLG);
        sb.append(this.mForumName);
        if (this.bLL != null) {
            sb.append(this.bLL);
        }
        return sb.toString();
    }

    public String abo() {
        return this.mForumName;
    }

    public String abp() {
        return this.bLt;
    }

    public boolean getHostMode() {
        return this.bLv;
    }

    public boolean abq() {
        return this.bLw;
    }

    public boolean abr() {
        return this.bLF;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bLx;
    }

    public int getIsMem() {
        if (this.bLI == null || this.bLI.getUserData() == null) {
            return 0;
        }
        return this.bLI.getUserData().getIsMem();
    }

    public int abs() {
        return this.bLy;
    }

    public void setIsGood(int i) {
        this.bLx = i;
    }

    public void hz(int i) {
        this.bLy = i;
    }

    public boolean abt() {
        return this.bLE;
    }

    public boolean abu() {
        if (this.bLI == null) {
            return false;
        }
        return this.bLI.isValid();
    }

    public String ro() {
        if (this.bLI == null || !this.bLI.pq()) {
            return null;
        }
        return this.bLI.pp();
    }

    public boolean hA(int i) {
        this.bLA = i;
        if (this.bLA > this.bLI.Zq().qN()) {
            this.bLA = this.bLI.Zq().qN();
        }
        if (this.bLA < 1) {
            this.bLA = 1;
        }
        if (this.bLt == null) {
            return false;
        }
        return hD(5);
    }

    public void hB(int i) {
        this.bLA = i;
        this.bLB = i;
        this.bLC = i;
    }

    public void hC(int i) {
        if (this.bLB < i) {
            this.bLB = i;
            if (this.bLB - this.bLC >= MAX_PAGE_NUM) {
                this.bLC = (this.bLB - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bLC > i) {
            this.bLC = i;
            if (this.bLB - this.bLC >= MAX_PAGE_NUM) {
                this.bLB = (this.bLC + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.bLI;
    }

    public com.baidu.tbadk.core.data.q abv() {
        if (this.bLI == null) {
            return null;
        }
        return this.bLI.Zq();
    }

    public boolean abw() {
        if (this.bLw) {
            if (this.bLI.Zq().qR() == 0) {
                dV(true);
                return true;
            }
        } else if (this.bLI.Zq().qS() == 0) {
            dW(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bLt == null) {
            return false;
        }
        cancelLoadData();
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aFt.start();
        }
        boolean hD = hD(3);
        if (this.opType != null) {
            this.opType = null;
            this.bLK = null;
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
        If();
    }

    private void If() {
        if (this.aFt != null) {
            this.aFt.destory();
            this.aFt = null;
        }
    }

    public boolean BM() {
        return (this.bLu == null || this.bLu.equals(GameInfoData.NOT_FROM_DETAIL) || this.bLu.length() == 0) ? LoadData() : abx();
    }

    public boolean hD(int i) {
        if (this.aoe) {
            return false;
        }
        this.aoe = true;
        hE(i);
        com.baidu.tieba.pb.a.b pbData = cb.abL().getPbData();
        if (pbData != null) {
            this.bLw = cb.abL().abq();
            this.bLv = cb.abL().abN();
            if (!this.bLw || this.bLv || this.isFromMark) {
                this.bLM = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bLJ.dR(true);
            this.aoe = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.aiC);
        if (!this.bLw || this.bLv || this.isFromMark) {
            this.bLM = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bLt == null || this.bLt.length() == 0) {
            this.aoe = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.c(this.bLt, 0L));
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
        if (!this.bLw) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bLv) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aIj != null) {
            pbpagerequestmessage.set_st_type(this.aIj);
        }
        if (this.bLH) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bLG));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bLM) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bLK, 0));
            pbpagerequestmessage.setOpMessageID(this.bLG);
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bLI.aau();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bLw) {
                        if (this.bLC > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bLC - 1));
                        }
                    } else if (this.bLB < this.bLD) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bLB + 1));
                    }
                }
                if (aau != null && aau.size() > 0) {
                    int size = aau.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.j jVar = aau.get(size - i3);
                        if (jVar == null) {
                            i3++;
                        } else {
                            this.bLu = jVar.getId();
                            if (StringUtils.isNull(this.bLu)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.bLu != null && this.bLu.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLu, 0L));
                    break;
                } else if (!this.bLw) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aau != null && aau.size() > 0 && aau.get(0) != null) {
                    this.bLu = aau.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bLw) {
                        if (this.bLC > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bLC - 1));
                        }
                    } else if (this.bLB < this.bLD) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bLB + 1));
                    }
                }
                if (this.bLu != null && this.bLu.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLu, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(abE(), true, this.bLu, 3);
                } else {
                    a(abE(), false, this.bLu, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bLw) {
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
                a(abE(), true, this.bLu, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLu, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bLA));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.c(this.bLu, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(abE());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void hE(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bLI.aau();
        if (i == 1) {
            boolean z2 = false;
            while (aau.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aau.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bLI.Zq().bp(1);
                if (this.bLJ != null) {
                    this.bLJ.a(this.bLI);
                }
            }
        } else if (i == 2) {
            while (aau.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aau.remove(aau.size() - 1);
                z = true;
            }
            if (z) {
                this.bLI.Zq().bo(1);
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
            if (bVar.aat() != null && bVar.aat().getAuthor() != null) {
                str = bVar.aat().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.w aat = bVar.aat();
            aat.br(this.bLx);
            aat.bq(this.bLy);
            aat.m(this.bLz);
            for (int i = 0; i < bVar.aau().size(); i++) {
                com.baidu.tieba.tbadkCore.data.j jVar = bVar.aau().get(i);
                for (int i2 = 0; i2 < jVar.aoz().size(); i2++) {
                    jVar.aoz().get(i2).b(this.bLa.getPageContext(), str2.equals(jVar.aoz().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aFt != null && !z3) {
            this.aFt.a(z2, z4, i2, str, i3, j, j2);
            this.aFt = null;
        }
        if (bVar == null) {
            if (this.bLJ != null) {
                this.bLJ.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bLH = false;
            if (bVar.Zq() != null) {
                hC(bVar.Zq().qP());
                this.bLD = bVar.Zq().qN();
            }
            this.bLD = this.bLD < 1 ? 1 : this.bLD;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bLI.aau();
            switch (i) {
                case 1:
                    this.bLI.a(bVar.Zq(), 1);
                    if (bVar.aau() != null) {
                        aau.addAll(bVar.aau());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (bVar.aau() != null) {
                        i5 = bVar.aau().size() + 1;
                        aau.addAll(0, bVar.aau());
                    }
                    this.bLI.a(bVar.Zq(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bLw && bVar.Zq() != null) {
                        bVar.Zq().bm(bVar.Zq().qN());
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
            if (this.bLI != null && this.bLI.aat() != null) {
                PraiseData praise = this.bLI.aat().getPraise();
                if (this.bLP != null && !praise.isPriaseDataValid()) {
                    this.bLI.aat().setPraise(this.bLP);
                } else {
                    this.bLP = this.bLI.aat().getPraise();
                    this.bLP.setPostId(this.bLI.aat().rs());
                }
                if (bVar.Zq() != null && bVar.Zq().qP() == 1) {
                    this.bLI.aat().k(bVar.aat().rp());
                }
                this.bLI.aat().setReply_num(bVar.aat().getReply_num());
            }
            if (this.bLJ != null) {
                this.bLJ.a(true, getErrorCode(), i, i4, this.bLI, this.mErrorString, 1);
            }
        }
        if (this.bLI != null && this.bLI.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bLI.getUserData().getIsMem())));
        }
        if (this.bLI != null && this.bLI.aat() != null && this.bLI.aas() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bLa;
            historyMessage.threadId = getPbData().aat().getId();
            historyMessage.forumName = getPbData().aas().getName();
            historyMessage.threadName = getPbData().aat().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = abq();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void d(com.baidu.tieba.pb.a.b bVar) {
        this.bLI = bVar;
        hB(bVar.Zq().qP());
    }

    public boolean abx() {
        if (this.bLt == null || this.bLu == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hD(4);
        }
        return hD(6);
    }

    public boolean dV(boolean z) {
        if (this.bLt == null || this.bLI == null) {
            return false;
        }
        if (z || this.bLI.Zq().qR() != 0) {
            return hD(1);
        }
        return false;
    }

    public boolean dW(boolean z) {
        if (this.bLt == null || this.bLI == null) {
            return false;
        }
        if ((z || this.bLI.Zq().qS() != 0) && this.bLI.aau() != null && this.bLI.aau().size() >= 1) {
            return hD(2);
        }
        return false;
    }

    public boolean aby() {
        this.bLv = !this.bLv;
        LoadData();
        return true;
    }

    public boolean abz() {
        this.bLw = !this.bLw;
        return LoadData();
    }

    public boolean abA() {
        return this.bLw;
    }

    public boolean abB() {
        return (this.bLI == null || this.bLI.aas() == null || this.bLI.aat() == null) ? false : true;
    }

    public boolean pq() {
        if (this.bLI == null) {
            return false;
        }
        return this.bLI.pq();
    }

    public WriteData iq(String str) {
        if (this.bLI == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bLI.aas().getId());
        writeData.setForumName(this.bLI.aas().getName());
        writeData.setThreadId(this.bLt);
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
        if (this.bLI == null || this.bLI.aau() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bLI.aau();
        if (aau.size() > 0 && i == aau.size()) {
            i = aau.size() - 1;
        }
        if (aau.size() <= 0 || i >= aau.size()) {
            return null;
        }
        return c(aau.get(i));
    }

    public MarkData abC() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bLt);
        markData.setPostId(this.bLI.pp());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bLv);
        markData.setSequence(Boolean.valueOf(this.bLw));
        markData.setId(this.bLt);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bLt);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bLv);
        markData.setSequence(Boolean.valueOf(this.bLw));
        markData.setId(this.bLt);
        markData.setFloor(jVar.aoC());
        return markData;
    }

    public void abD() {
        bm.abl().w(abE(), this.isFromMark);
    }

    private String abE() {
        String str = this.bLt;
        if (this.bLv) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bLw) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dX(boolean z) {
        if (this.bLI != null) {
            this.bLI.Z(z);
        }
    }

    public void dY(boolean z) {
        this.bLM = z;
    }

    public void a(bs bsVar) {
        this.bLJ = bsVar;
    }
}
