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
public class bq extends com.baidu.adp.base.f<PbActivity> {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private com.baidu.tieba.tbadkCore.e.a aDi;
    private long aDj;
    private long aDk;
    private long aDl;
    private long aDm;
    private String aFT;
    private boolean amT;
    private CustomMessageListener ayU;
    private PbActivity bIF;
    private String bIY;
    private String bIZ;
    private boolean bJa;
    private boolean bJb;
    private int bJc;
    private int bJd;
    private long bJe;
    private int bJf;
    private int bJg;
    private int bJh;
    private boolean bJi;
    private boolean bJj;
    private long bJk;
    private boolean bJl;
    private com.baidu.tieba.pb.a.b bJm;
    private bu bJn;
    private String bJo;
    private String bJp;
    private boolean bJq;
    private boolean bJr;
    private com.baidu.adp.framework.listener.a bJs;
    private PraiseData bJt;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;
    private int totalPage;

    public bq(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.aFT = null;
        this.bIY = null;
        this.bIZ = null;
        this.bJa = false;
        this.bJb = true;
        this.bJc = 0;
        this.bJd = 0;
        this.bJe = 0L;
        this.bJf = 1;
        this.bJg = 1;
        this.bJh = 1;
        this.totalPage = 1;
        this.isAd = false;
        this.bJi = false;
        this.bJj = false;
        this.isFromMark = false;
        this.bJk = 0L;
        this.bJl = false;
        this.mForumName = null;
        this.bJm = null;
        this.amT = false;
        this.mContext = null;
        this.bJn = null;
        this.aDj = 0L;
        this.aDk = 0L;
        this.aDl = 0L;
        this.aDm = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bJo = null;
        this.bJp = null;
        this.aDi = null;
        this.bJr = false;
        this.ayU = new br(this, 2004003);
        this.bJs = new bt(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bJt = null;
        registerListener(this.ayU);
        registerListener(this.bJs);
        this.bJm = new com.baidu.tieba.pb.a.b();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bIF = pbActivity;
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
        this.bIY = intent.getStringExtra("thread_id");
        this.bIZ = intent.getStringExtra("post_id");
        this.bJa = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bJb = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aFT = intent.getStringExtra("st_type");
        this.bJc = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bJd = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bJe = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bJj = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bJi = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bJl = intent.getBooleanExtra("is_pv", false);
        this.bJk = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bJp = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bJo = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bIY = bundle.getString("thread_id");
        this.bIZ = bundle.getString("post_id");
        this.bJa = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bJb = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aFT = bundle.getString("st_type");
        this.bJc = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bJd = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bJe = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bJj = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bJi = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bJl = bundle.getBoolean("is_pv", false);
        this.bJk = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bJp = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bIY);
        bundle.putString("post_id", this.bIZ);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bJa);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bJb);
        bundle.putString("st_type", this.aFT);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bJc);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bJd);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bJe);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bJj);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bJi);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bJl);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bJk);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bJp);
    }

    public String ZL() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bIY);
        sb.append(this.bIZ);
        sb.append(this.bJa);
        sb.append(this.bJb);
        sb.append(this.aFT);
        sb.append(this.bJc);
        sb.append(this.bJd);
        sb.append(this.bJe);
        sb.append(this.bJj);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bJi);
        sb.append(this.bJl);
        sb.append(this.bJk);
        sb.append(this.mForumName);
        if (this.bJp != null) {
            sb.append(this.bJp);
        }
        return sb.toString();
    }

    public String ZM() {
        return this.mForumName;
    }

    public String ZN() {
        return this.bIY;
    }

    public boolean getHostMode() {
        return this.bJa;
    }

    public boolean ZO() {
        return this.bJb;
    }

    public boolean ZP() {
        return this.bJj;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bJc;
    }

    public int getIsMem() {
        if (this.bJm == null || this.bJm.getUserData() == null) {
            return 0;
        }
        return this.bJm.getUserData().getIsMem();
    }

    public int ZQ() {
        return this.bJd;
    }

    public void setIsGood(int i) {
        this.bJc = i;
    }

    public void hj(int i) {
        this.bJd = i;
    }

    public boolean ZR() {
        return this.bJi;
    }

    public boolean ZS() {
        if (this.bJm == null) {
            return false;
        }
        return this.bJm.isValid();
    }

    public String qI() {
        if (this.bJm == null || !this.bJm.oQ()) {
            return null;
        }
        return this.bJm.oP();
    }

    public boolean hk(int i) {
        this.bJf = i;
        if (this.bJf > this.bJm.XE().qh()) {
            this.bJf = this.bJm.XE().qh();
        }
        if (this.bJf < 1) {
            this.bJf = 1;
        }
        if (this.bIY == null) {
            return false;
        }
        return hn(5);
    }

    public void hl(int i) {
        this.bJf = i;
        this.bJg = i;
        this.bJh = i;
    }

    public void hm(int i) {
        if (this.bJg < i) {
            this.bJg = i;
            if (this.bJg - this.bJh >= MAX_PAGE_NUM) {
                this.bJh = (this.bJg - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bJh > i) {
            this.bJh = i;
            if (this.bJg - this.bJh >= MAX_PAGE_NUM) {
                this.bJg = (this.bJh + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.bJm;
    }

    public com.baidu.tbadk.core.data.q ZT() {
        if (this.bJm == null) {
            return null;
        }
        return this.bJm.XE();
    }

    public boolean ZU() {
        if (this.bJb) {
            if (this.bJm.XE().ql() == 0) {
                dM(true);
                return true;
            }
        } else if (this.bJm.XE().qm() == 0) {
            dN(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bIY == null) {
            return false;
        }
        cancelLoadData();
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aDi.start();
        }
        boolean hn = hn(3);
        if (this.opType != null) {
            this.opType = null;
            this.bJo = null;
            this.opUrl = null;
            return hn;
        }
        return hn;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.amT = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        GW();
    }

    private void GW() {
        if (this.aDi != null) {
            this.aDi.destory();
            this.aDi = null;
        }
    }

    public boolean AT() {
        return (this.bIZ == null || this.bIZ.equals(GameInfoData.NOT_FROM_DETAIL) || this.bIZ.length() == 0) ? LoadData() : ZV();
    }

    public boolean hn(int i) {
        if (this.amT) {
            return false;
        }
        this.amT = true;
        ho(i);
        com.baidu.tieba.pb.a.b pbData = cd.aaj().getPbData();
        if (pbData != null) {
            this.bJb = cd.aaj().ZO();
            this.bJa = cd.aaj().aal();
            if (!this.bJb || this.bJa || this.isFromMark) {
                this.bJq = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bJn.dI(true);
            this.amT = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.aht);
        if (!this.bJb || this.bJa || this.isFromMark) {
            this.bJq = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bIY == null || this.bIY.length() == 0) {
            this.amT = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bIY, 0L));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        int N = com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.be.sY().ta() ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(M));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(N));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.bJb) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bJa) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aFT != null) {
            pbpagerequestmessage.set_st_type(this.aFT);
        }
        if (this.bJl) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bJk));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bJq) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bJo, 0));
            pbpagerequestmessage.setOpMessageID(this.bJk);
        }
        ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bJm.YQ();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bJb) {
                        if (this.bJh > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bJh - 1));
                        }
                    } else if (this.bJg < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bJg + 1));
                    }
                }
                if (YQ != null && YQ.size() > 0) {
                    int size = YQ.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.c.j jVar = YQ.get(size - i3);
                        if (jVar == null) {
                            i3++;
                        } else {
                            this.bIZ = jVar.getId();
                            if (StringUtils.isNull(this.bIZ)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.bIZ != null && this.bIZ.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bIZ, 0L));
                    break;
                } else if (!this.bJb) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (YQ != null && YQ.size() > 0 && YQ.get(0) != null) {
                    this.bIZ = YQ.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bJb) {
                        if (this.bJh > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bJh - 1));
                        }
                    } else if (this.bJg < this.totalPage) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bJg + 1));
                    }
                }
                if (this.bIZ != null && this.bIZ.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bIZ, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(aac(), true, this.bIZ, 3);
                } else {
                    a(aac(), false, this.bIZ, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bJb) {
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
                a(aac(), true, this.bIZ, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bIZ, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bJf));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bIZ, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(aac());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void ho(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bJm.YQ();
        if (i == 1) {
            boolean z2 = false;
            while (YQ.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                YQ.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bJm.XE().bs(1);
                if (this.bJn != null) {
                    this.bJn.a(this.bJm);
                }
            }
        } else if (i == 2) {
            while (YQ.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                YQ.remove(YQ.size() - 1);
                z = true;
            }
            if (z) {
                this.bJm.XE().br(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.amT = false;
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
            if (bVar.YP() != null && bVar.YP().getAuthor() != null) {
                str = bVar.YP().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.w YP = bVar.YP();
            YP.bu(this.bJc);
            YP.bt(this.bJd);
            YP.l(this.bJe);
            for (int i = 0; i < bVar.YQ().size(); i++) {
                com.baidu.tieba.tbadkCore.c.j jVar = bVar.YQ().get(i);
                for (int i2 = 0; i2 < jVar.amx().size(); i2++) {
                    jVar.amx().get(i2).b(this.bIF.getPageContext(), str2.equals(jVar.amx().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aDi != null && !z3) {
            this.aDi.a(z2, z4, i2, str, i3, j, j2);
            this.aDi = null;
        }
        if (bVar == null) {
            if (this.bJn != null) {
                this.bJn.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bJl = false;
            if (bVar.XE() != null) {
                hm(bVar.XE().qj());
                this.totalPage = bVar.XE().qh();
            }
            this.totalPage = this.totalPage < 1 ? 1 : this.totalPage;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bJm.YQ();
            switch (i) {
                case 1:
                    this.bJm.a(bVar.XE(), 1);
                    if (bVar.YQ() != null) {
                        YQ.addAll(bVar.YQ());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (bVar.YQ() != null) {
                        i5 = bVar.YQ().size() + 1;
                        YQ.addAll(0, bVar.YQ());
                    }
                    this.bJm.a(bVar.XE(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bJb && bVar.XE() != null) {
                        bVar.XE().bp(bVar.XE().qh());
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
            if (this.bJm != null && this.bJm.YP() != null) {
                PraiseData praise = this.bJm.YP().getPraise();
                if (this.bJt != null && !praise.isPriaseDataValid()) {
                    this.bJm.YP().setPraise(this.bJt);
                } else {
                    this.bJt = this.bJm.YP().getPraise();
                    this.bJt.setPostId(this.bJm.YP().qM());
                }
                if (bVar.XE() != null && bVar.XE().qj() == 1) {
                    this.bJm.YP().l(bVar.YP().qJ());
                }
                this.bJm.YP().setReply_num(bVar.YP().getReply_num());
            }
            if (this.bJn != null) {
                this.bJn.a(true, getErrorCode(), i, i4, this.bJm, this.mErrorString, 1);
            }
        }
        if (this.bJm != null && this.bJm.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bJm.getUserData().getIsMem())));
        }
        if (this.bJm != null && this.bJm.YP() != null && this.bJm.YO() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bIF;
            historyMessage.threadId = getPbData().YP().getId();
            historyMessage.forumName = getPbData().YO().getName();
            historyMessage.threadName = getPbData().YP().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = ZO();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void d(com.baidu.tieba.pb.a.b bVar) {
        this.bJm = bVar;
        hl(bVar.XE().qj());
    }

    public boolean ZV() {
        if (this.bIY == null || this.bIZ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hn(4);
        }
        return hn(6);
    }

    public boolean dM(boolean z) {
        if (this.bIY == null || this.bJm == null) {
            return false;
        }
        if (z || this.bJm.XE().ql() != 0) {
            return hn(1);
        }
        return false;
    }

    public boolean dN(boolean z) {
        if (this.bIY == null || this.bJm == null) {
            return false;
        }
        if ((z || this.bJm.XE().qm() != 0) && this.bJm.YQ() != null && this.bJm.YQ().size() >= 1) {
            return hn(2);
        }
        return false;
    }

    public boolean ZW() {
        this.bJa = !this.bJa;
        LoadData();
        return true;
    }

    public boolean ZX() {
        this.bJb = !this.bJb;
        return LoadData();
    }

    public boolean ZY() {
        return this.bJb;
    }

    public boolean ZZ() {
        return (this.bJm == null || this.bJm.YO() == null || this.bJm.YP() == null) ? false : true;
    }

    public boolean oQ() {
        if (this.bJm == null) {
            return false;
        }
        return this.bJm.oQ();
    }

    public WriteData hI(String str) {
        if (this.bJm == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bJm.YO().getId());
        writeData.setForumName(this.bJm.YO().getName());
        writeData.setThreadId(this.bIY);
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

    public com.baidu.tieba.pb.a.c c(com.baidu.tieba.tbadkCore.c.j jVar) {
        if (jVar == null) {
            return null;
        }
        com.baidu.tieba.pb.a.c cVar = new com.baidu.tieba.pb.a.c();
        cVar.b(this.bJm.YO());
        cVar.d(this.bJm.YP());
        cVar.a(jVar);
        cVar.K(jVar.amx());
        cVar.setTotalCount(jVar.amE());
        String oP = this.bJm.oP();
        String id = jVar.getId();
        if (oQ() && oP != null && id != null && oP.equals(id)) {
            cVar.W(true);
            return cVar;
        }
        cVar.W(false);
        return cVar;
    }

    public MarkData hp(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bJm == null || this.bJm.YQ() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bJm.YQ();
        if (YQ.size() > 0 && i == YQ.size()) {
            i = YQ.size() - 1;
        }
        if (YQ.size() <= 0 || i >= YQ.size()) {
            return null;
        }
        return d(YQ.get(i));
    }

    public MarkData aaa() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bIY);
        markData.setPostId(this.bJm.oP());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bJa);
        markData.setSequence(Boolean.valueOf(this.bJb));
        markData.setId(this.bIY);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.c.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bIY);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bJa);
        markData.setSequence(Boolean.valueOf(this.bJb));
        markData.setId(this.bIY);
        markData.setFloor(jVar.amA());
        return markData;
    }

    public void aab() {
        bo.ZJ().w(aac(), this.isFromMark);
    }

    private String aac() {
        String str = this.bIY;
        if (this.bJa) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bJb) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dO(boolean z) {
        if (this.bJm != null) {
            this.bJm.W(z);
        }
    }

    public void dP(boolean z) {
        this.bJq = z;
    }

    public void a(bu buVar) {
        this.bJn = buVar;
    }
}
