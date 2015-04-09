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
public class br extends com.baidu.adp.base.f<PbActivity> {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private com.baidu.tieba.tbadkCore.e.a aDq;
    private long aDr;
    private long aDs;
    private long aDt;
    private long aDu;
    private String aGb;
    private boolean anb;
    private CustomMessageListener azc;
    private PbActivity bIT;
    private boolean bJA;
    private com.baidu.tieba.pb.a.b bJB;
    private bv bJC;
    private String bJD;
    private String bJE;
    private boolean bJF;
    private boolean bJG;
    private com.baidu.adp.framework.listener.a bJH;
    private PraiseData bJI;
    private String bJm;
    private String bJn;
    private boolean bJo;
    private boolean bJp;
    private int bJq;
    private int bJr;
    private long bJs;
    private int bJt;
    private int bJu;
    private int bJv;
    private int bJw;
    private boolean bJx;
    private boolean bJy;
    private long bJz;
    private boolean isAd;
    private boolean isFromMark;
    private Context mContext;
    private String mForumName;
    private String opType;
    private String opUrl;

    public br(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.aGb = null;
        this.bJm = null;
        this.bJn = null;
        this.bJo = false;
        this.bJp = true;
        this.bJq = 0;
        this.bJr = 0;
        this.bJs = 0L;
        this.bJt = 1;
        this.bJu = 1;
        this.bJv = 1;
        this.bJw = 1;
        this.isAd = false;
        this.bJx = false;
        this.bJy = false;
        this.isFromMark = false;
        this.bJz = 0L;
        this.bJA = false;
        this.mForumName = null;
        this.bJB = null;
        this.anb = false;
        this.mContext = null;
        this.bJC = null;
        this.aDr = 0L;
        this.aDs = 0L;
        this.aDt = 0L;
        this.aDu = 0L;
        this.opType = null;
        this.opUrl = null;
        this.bJD = null;
        this.bJE = null;
        this.aDq = null;
        this.bJG = false;
        this.azc = new bs(this, 2004003);
        this.bJH = new bu(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.bJI = null;
        registerListener(this.azc);
        registerListener(this.bJH);
        this.bJB = new com.baidu.tieba.pb.a.b();
        this.mContext = pbActivity.getPageContext().getPageActivity();
        this.bIT = pbActivity;
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
        this.bJm = intent.getStringExtra("thread_id");
        this.bJn = intent.getStringExtra("post_id");
        this.bJo = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bJp = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aGb = intent.getStringExtra("st_type");
        this.bJq = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bJr = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.bJs = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.bJy = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = intent.getBooleanExtra(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.bJx = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bJA = intent.getBooleanExtra("is_pv", false);
        this.bJz = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.bJE = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.bJD = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.bJm = bundle.getString("thread_id");
        this.bJn = bundle.getString("post_id");
        this.bJo = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.bJp = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aGb = bundle.getString("st_type");
        this.bJq = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.bJr = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.bJs = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.bJy = bundle.getBoolean(PbActivityConfig.KEY_FROM_FRS, false);
        this.isFromMark = bundle.getBoolean(PbActivityConfig.KEY_FROM_MARK, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.bJx = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.bJA = bundle.getBoolean("is_pv", false);
        this.bJz = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.bJE = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.bJm);
        bundle.putString("post_id", this.bJn);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.bJo);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.bJp);
        bundle.putString("st_type", this.aGb);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.bJq);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.bJr);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.bJs);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_FRS, this.bJy);
        bundle.putBoolean(PbActivityConfig.KEY_FROM_MARK, this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.bJx);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.bJA);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.bJz);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.bJE);
    }

    public String ZY() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.bJm);
        sb.append(this.bJn);
        sb.append(this.bJo);
        sb.append(this.bJp);
        sb.append(this.aGb);
        sb.append(this.bJq);
        sb.append(this.bJr);
        sb.append(this.bJs);
        sb.append(this.bJy);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.bJx);
        sb.append(this.bJA);
        sb.append(this.bJz);
        sb.append(this.mForumName);
        if (this.bJE != null) {
            sb.append(this.bJE);
        }
        return sb.toString();
    }

    public String ZZ() {
        return this.mForumName;
    }

    public String aaa() {
        return this.bJm;
    }

    public boolean getHostMode() {
        return this.bJo;
    }

    public boolean aab() {
        return this.bJp;
    }

    public boolean aac() {
        return this.bJy;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.bJq;
    }

    public int getIsMem() {
        if (this.bJB == null || this.bJB.getUserData() == null) {
            return 0;
        }
        return this.bJB.getUserData().getIsMem();
    }

    public int aad() {
        return this.bJr;
    }

    public void setIsGood(int i) {
        this.bJq = i;
    }

    public void hl(int i) {
        this.bJr = i;
    }

    public boolean aae() {
        return this.bJx;
    }

    public boolean aaf() {
        if (this.bJB == null) {
            return false;
        }
        return this.bJB.isValid();
    }

    public String qI() {
        if (this.bJB == null || !this.bJB.oQ()) {
            return null;
        }
        return this.bJB.oP();
    }

    public boolean hm(int i) {
        this.bJt = i;
        if (this.bJt > this.bJB.XQ().qh()) {
            this.bJt = this.bJB.XQ().qh();
        }
        if (this.bJt < 1) {
            this.bJt = 1;
        }
        if (this.bJm == null) {
            return false;
        }
        return hp(5);
    }

    public void hn(int i) {
        this.bJt = i;
        this.bJu = i;
        this.bJv = i;
    }

    public void ho(int i) {
        if (this.bJu < i) {
            this.bJu = i;
            if (this.bJu - this.bJv >= MAX_PAGE_NUM) {
                this.bJv = (this.bJu - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.bJv > i) {
            this.bJv = i;
            if (this.bJu - this.bJv >= MAX_PAGE_NUM) {
                this.bJu = (this.bJv + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.bJB;
    }

    public com.baidu.tbadk.core.data.q aag() {
        if (this.bJB == null) {
            return null;
        }
        return this.bJB.XQ();
    }

    public boolean aah() {
        if (this.bJp) {
            if (this.bJB.XQ().ql() == 0) {
                dK(true);
                return true;
            }
        } else if (this.bJB.XQ().qm() == 0) {
            dL(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bJm == null) {
            return false;
        }
        cancelLoadData();
        if (this.aDq == null) {
            this.aDq = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aDq.start();
        }
        boolean hp = hp(3);
        if (this.opType != null) {
            this.opType = null;
            this.bJD = null;
            this.opUrl = null;
            return hp;
        }
        return hp;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        this.anb = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Hc();
    }

    private void Hc() {
        if (this.aDq != null) {
            this.aDq.destory();
            this.aDq = null;
        }
    }

    public boolean AZ() {
        return (this.bJn == null || this.bJn.equals(GameInfoData.NOT_FROM_DETAIL) || this.bJn.length() == 0) ? LoadData() : aai();
    }

    public boolean hp(int i) {
        if (this.anb) {
            return false;
        }
        this.anb = true;
        hq(i);
        com.baidu.tieba.pb.a.b pbData = ce.aaw().getPbData();
        if (pbData != null) {
            this.bJp = ce.aaw().aab();
            this.bJo = ce.aaw().aay();
            if (!this.bJp || this.bJo || this.isFromMark) {
                this.bJF = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.bJC.dG(true);
            this.anb = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        pbpagerequestmessage.setLastids(com.baidu.tbadk.distribute.a.ahB);
        if (!this.bJp || this.bJo || this.isFromMark) {
            this.bJF = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.bJm == null || this.bJm.length() == 0) {
            this.anb = false;
            return false;
        }
        pbpagerequestmessage.set_kz(com.baidu.adp.lib.g.c.a(this.bJm, 0L));
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
        if (!this.bJp) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.bJo) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.aGb != null) {
            pbpagerequestmessage.set_st_type(this.aGb);
        }
        if (this.bJA) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.bJz));
            pbpagerequestmessage.set_message_click("1");
        }
        if (this.bJF) {
            pbpagerequestmessage.set_banner(1);
        }
        if (this.opType != null) {
            pbpagerequestmessage.setOpType(this.opType);
            pbpagerequestmessage.setOpUrl(this.opUrl);
            pbpagerequestmessage.setOpStat(com.baidu.adp.lib.g.c.toInt(this.bJD, 0));
            pbpagerequestmessage.setOpMessageID(this.bJz);
        }
        ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bJB.Zc();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.bJp) {
                        if (this.bJv > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bJv - 1));
                        }
                    } else if (this.bJu < this.bJw) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bJu + 1));
                    }
                }
                if (Zc != null && Zc.size() > 0) {
                    int size = Zc.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.c.j jVar = Zc.get(size - i3);
                        if (jVar == null) {
                            i3++;
                        } else {
                            this.bJn = jVar.getId();
                            if (StringUtils.isNull(this.bJn)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.bJn != null && this.bJn.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bJn, 0L));
                    break;
                } else if (!this.bJp) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (Zc != null && Zc.size() > 0 && Zc.get(0) != null) {
                    this.bJn = Zc.get(0).getId();
                }
                pbpagerequestmessage.set_back(1);
                pbpagerequestmessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.bJp) {
                        if (this.bJv > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.bJv - 1));
                        }
                    } else if (this.bJu < this.bJw) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.bJu + 1));
                    }
                }
                if (this.bJn != null && this.bJn.length() > 0) {
                    pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bJn, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbpagerequestmessage.set_banner(0);
                    a(aap(), true, this.bJn, 3);
                } else {
                    a(aap(), false, this.bJn, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.bJp) {
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
                a(aap(), true, this.bJn, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bJn, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.bJt));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(com.baidu.adp.lib.g.c.a(this.bJn, 0L));
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_banner(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbpagerequestmessage.setCacheKey(aap());
        pbpagerequestmessage.setContext(this.mContext);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void hq(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bJB.Zc();
        if (i == 1) {
            boolean z2 = false;
            while (Zc.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                Zc.remove(0);
                z2 = true;
            }
            if (z2) {
                this.bJB.XQ().bs(1);
                if (this.bJC != null) {
                    this.bJC.a(this.bJB);
                }
            }
        } else if (i == 2) {
            while (Zc.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                Zc.remove(Zc.size() - 1);
                z = true;
            }
            if (z) {
                this.bJB.XQ().br(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.anb = false;
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
            if (bVar.Zb() != null && bVar.Zb().getAuthor() != null) {
                str = bVar.Zb().getAuthor().getUserId();
            }
            String str2 = str == null ? "" : str;
            com.baidu.tbadk.core.data.w Zb = bVar.Zb();
            Zb.bu(this.bJq);
            Zb.bt(this.bJr);
            Zb.l(this.bJs);
            for (int i = 0; i < bVar.Zc().size(); i++) {
                com.baidu.tieba.tbadkCore.c.j jVar = bVar.Zc().get(i);
                for (int i2 = 0; i2 < jVar.amM().size(); i2++) {
                    jVar.amM().get(i2).b(this.bIT.getPageContext(), str2.equals(jVar.amM().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aDq != null && !z3) {
            this.aDq.a(z2, z4, i2, str, i3, j, j2);
            this.aDq = null;
        }
        if (bVar == null) {
            if (this.bJC != null) {
                this.bJC.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.bJA = false;
            if (bVar.XQ() != null) {
                ho(bVar.XQ().qj());
                this.bJw = bVar.XQ().qh();
            }
            this.bJw = this.bJw < 1 ? 1 : this.bJw;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bJB.Zc();
            switch (i) {
                case 1:
                    this.bJB.a(bVar.XQ(), 1);
                    if (bVar.Zc() != null) {
                        Zc.addAll(bVar.Zc());
                        i4 = 0;
                        break;
                    }
                    i4 = i5;
                    break;
                case 2:
                    if (bVar.Zc() != null) {
                        i5 = bVar.Zc().size() + 1;
                        Zc.addAll(0, bVar.Zc());
                    }
                    this.bJB.a(bVar.XQ(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.bJp && bVar.XQ() != null) {
                        bVar.XQ().bp(bVar.XQ().qh());
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
            if (this.bJB != null && this.bJB.Zb() != null) {
                PraiseData praise = this.bJB.Zb().getPraise();
                if (this.bJI != null && !praise.isPriaseDataValid()) {
                    this.bJB.Zb().setPraise(this.bJI);
                } else {
                    this.bJI = this.bJB.Zb().getPraise();
                    this.bJI.setPostId(this.bJB.Zb().qM());
                }
                if (bVar.XQ() != null && bVar.XQ().qj() == 1) {
                    this.bJB.Zb().l(bVar.Zb().qJ());
                }
                this.bJB.Zb().setReply_num(bVar.Zb().getReply_num());
            }
            if (this.bJC != null) {
                this.bJC.a(true, getErrorCode(), i, i4, this.bJB, this.mErrorString, 1);
            }
        }
        if (this.bJB != null && this.bJB.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.bJB.getUserData().getIsMem())));
        }
        if (this.bJB != null && this.bJB.Zb() != null && this.bJB.Za() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bIT;
            historyMessage.threadId = getPbData().Zb().getId();
            historyMessage.forumName = getPbData().Za().getName();
            historyMessage.threadName = getPbData().Zb().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = aab();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private void d(com.baidu.tieba.pb.a.b bVar) {
        this.bJB = bVar;
        hn(bVar.XQ().qj());
    }

    public boolean aai() {
        if (this.bJm == null || this.bJn == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return hp(4);
        }
        return hp(6);
    }

    public boolean dK(boolean z) {
        if (this.bJm == null || this.bJB == null) {
            return false;
        }
        if (z || this.bJB.XQ().ql() != 0) {
            return hp(1);
        }
        return false;
    }

    public boolean dL(boolean z) {
        if (this.bJm == null || this.bJB == null) {
            return false;
        }
        if ((z || this.bJB.XQ().qm() != 0) && this.bJB.Zc() != null && this.bJB.Zc().size() >= 1) {
            return hp(2);
        }
        return false;
    }

    public boolean aaj() {
        this.bJo = !this.bJo;
        LoadData();
        return true;
    }

    public boolean aak() {
        this.bJp = !this.bJp;
        return LoadData();
    }

    public boolean aal() {
        return this.bJp;
    }

    public boolean aam() {
        return (this.bJB == null || this.bJB.Za() == null || this.bJB.Zb() == null) ? false : true;
    }

    public boolean oQ() {
        if (this.bJB == null) {
            return false;
        }
        return this.bJB.oQ();
    }

    public WriteData hL(String str) {
        if (this.bJB == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.bJB.Za().getId());
        writeData.setForumName(this.bJB.Za().getName());
        writeData.setThreadId(this.bJm);
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
        cVar.b(this.bJB.Za());
        cVar.d(this.bJB.Zb());
        cVar.a(jVar);
        cVar.M(jVar.amM());
        cVar.setTotalCount(jVar.amT());
        String oP = this.bJB.oP();
        String id = jVar.getId();
        if (oQ() && oP != null && id != null && oP.equals(id)) {
            cVar.W(true);
            return cVar;
        }
        cVar.W(false);
        return cVar;
    }

    public MarkData hr(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.bJB == null || this.bJB.Zc() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bJB.Zc();
        if (Zc.size() > 0 && i == Zc.size()) {
            i = Zc.size() - 1;
        }
        if (Zc.size() <= 0 || i >= Zc.size()) {
            return null;
        }
        return d(Zc.get(i));
    }

    public MarkData aan() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bJm);
        markData.setPostId(this.bJB.oP());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bJo);
        markData.setSequence(Boolean.valueOf(this.bJp));
        markData.setId(this.bJm);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.c.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bJm);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.bJo);
        markData.setSequence(Boolean.valueOf(this.bJp));
        markData.setId(this.bJm);
        markData.setFloor(jVar.amP());
        return markData;
    }

    public void aao() {
        bp.ZW().w(aap(), this.isFromMark);
    }

    private String aap() {
        String str = this.bJm;
        if (this.bJo) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.bJp) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void dM(boolean z) {
        if (this.bJB != null) {
            this.bJB.W(z);
        }
    }

    public void dN(boolean z) {
        this.bJF = z;
    }

    public void a(bv bvVar) {
        this.bJC = bvVar;
    }
}
