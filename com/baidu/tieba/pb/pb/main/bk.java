package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bk extends com.baidu.tbadk.editortools.c.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private CustomMessageListener aIj;
    private com.baidu.tieba.tbadkCore.e.a aMS;
    private long aMT;
    private long aMU;
    private long aMV;
    private long aMW;
    private String aPJ;
    private BaseActivity aSJ;
    private boolean avu;
    private String cbR;
    private String cbS;
    private boolean cbT;
    private boolean cbU;
    private int cbV;
    private int cbW;
    private long cbX;
    private int cbY;
    private int cbZ;
    private int cca;
    private int ccb;
    private boolean ccc;
    private boolean ccd;
    private long cce;
    private boolean ccf;
    protected com.baidu.tieba.pb.a.b ccg;
    protected int cch;
    private a cci;
    private String ccj;
    private String cck;
    private boolean ccl;
    private boolean ccm;
    private boolean ccn;
    private com.baidu.adp.framework.listener.a cco;
    private PraiseData ccp;
    private boolean isAd;
    private boolean isFromMark;
    protected Context mContext;
    private String mForumName;
    private int mRequestType;
    private String opType;
    private String opUrl;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.pb.a.b bVar);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void ef(boolean z);
    }

    public bk(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aPJ = null;
        this.cbR = null;
        this.cbS = null;
        this.cbT = false;
        this.cbU = true;
        this.cbV = 0;
        this.cbW = 0;
        this.cbX = 0L;
        this.cbY = 1;
        this.cbZ = 1;
        this.cca = 1;
        this.ccb = 1;
        this.isAd = false;
        this.ccc = false;
        this.ccd = false;
        this.isFromMark = false;
        this.cce = 0L;
        this.ccf = false;
        this.mForumName = null;
        this.ccg = null;
        this.avu = false;
        this.mContext = null;
        this.cci = null;
        this.aMT = 0L;
        this.aMU = 0L;
        this.aMV = 0L;
        this.aMW = 0L;
        this.opType = null;
        this.opUrl = null;
        this.ccj = null;
        this.cck = null;
        this.aMS = null;
        this.ccm = false;
        this.aIj = new bl(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cco = new bn(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ccp = null;
        registerListener(this.aIj);
        registerListener(this.cco);
        this.ccg = new com.baidu.tieba.pb.a.b();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aSJ = baseActivity;
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
        this.cbR = intent.getStringExtra("thread_id");
        this.cbS = intent.getStringExtra("post_id");
        this.cbT = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cbU = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aPJ = intent.getStringExtra("st_type");
        this.cbV = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cbW = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cbX = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.ccd = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.ccc = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ccf = intent.getBooleanExtra("is_pv", false);
        this.cce = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cck = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.ccj = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    public void initWithBundle(Bundle bundle) {
        this.cbR = bundle.getString("thread_id");
        this.cbS = bundle.getString("post_id");
        this.cbT = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cbU = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aPJ = bundle.getString("st_type");
        this.cbV = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cbW = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cbX = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.ccd = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ccc = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ccf = bundle.getBoolean("is_pv", false);
        this.cce = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cck = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.cbR);
        bundle.putString("post_id", this.cbS);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cbT);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cbU);
        bundle.putString("st_type", this.aPJ);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cbV);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cbW);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cbX);
        bundle.putBoolean("from_frs", this.ccd);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.ccc);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ccf);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cce);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cck);
    }

    public String adw() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cbR);
        sb.append(this.cbS);
        sb.append(this.cbT);
        sb.append(this.cbU);
        sb.append(this.aPJ);
        sb.append(this.cbV);
        sb.append(this.cbW);
        sb.append(this.cbX);
        sb.append(this.ccd);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ccc);
        sb.append(this.ccf);
        sb.append(this.cce);
        sb.append(this.mForumName);
        if (this.cck != null) {
            sb.append(this.cck);
        }
        return sb.toString();
    }

    public String adx() {
        return this.mForumName;
    }

    public String getThreadID() {
        return this.cbR;
    }

    public boolean getHostMode() {
        return this.cbT;
    }

    public boolean ady() {
        return this.cbU;
    }

    public boolean adz() {
        return this.ccd;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.cbV;
    }

    public int adA() {
        return this.cbW;
    }

    public void setIsGood(int i) {
        this.cbV = i;
    }

    public void iq(int i) {
        this.cbW = i;
    }

    public boolean adB() {
        return this.ccc;
    }

    public boolean adC() {
        if (this.ccg == null) {
            return false;
        }
        return this.ccg.isValid();
    }

    public String sr() {
        if (this.ccg == null || !this.ccg.qr()) {
            return null;
        }
        return this.ccg.qq();
    }

    public boolean ir(int i) {
        this.cbY = i;
        if (this.cbY > this.ccg.getPage().rP()) {
            this.cbY = this.ccg.getPage().rP();
        }
        if (this.cbY < 1) {
            this.cbY = 1;
        }
        if (this.cbR == null) {
            return false;
        }
        return iu(5);
    }

    public void is(int i) {
        this.cbY = i;
        this.cbZ = i;
        this.cca = i;
    }

    public void it(int i) {
        if (this.cbZ < i) {
            this.cbZ = i;
            if (this.cbZ - this.cca >= MAX_PAGE_NUM) {
                this.cca = (this.cbZ - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.cca > i) {
            this.cca = i;
            if (this.cbZ - this.cca >= MAX_PAGE_NUM) {
                this.cbZ = (this.cca + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.ccg;
    }

    public com.baidu.tbadk.core.data.p adD() {
        if (this.ccg == null) {
            return null;
        }
        return this.ccg.getPage();
    }

    public boolean adE() {
        if (this.cbU) {
            if (this.ccg.getPage().rT() == 0) {
                ek(true);
                return true;
            }
        } else if (this.ccg.getPage().rU() == 0) {
            el(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cbR == null) {
            return false;
        }
        cancelLoadData();
        if (this.aMS == null) {
            this.aMS = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aMS.start();
        }
        boolean iu = iu(3);
        if (this.opType != null) {
            this.opType = null;
            this.ccj = null;
            this.opUrl = null;
            return iu;
        }
        return iu;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.avu = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        IS();
    }

    private void IS() {
        if (this.aMS != null) {
            this.aMS.destory();
            this.aMS = null;
        }
    }

    public boolean CV() {
        return (this.cbS == null || this.cbS.equals("0") || this.cbS.length() == 0) ? LoadData() : adF();
    }

    public boolean iu(int i) {
        this.mRequestType = i;
        if (this.avu) {
            return false;
        }
        this.avu = true;
        iv(i);
        com.baidu.tieba.pb.a.b pbData = bw.adS().getPbData();
        if (pbData != null) {
            this.cbU = bw.adS().ady();
            this.cbT = bw.adS().adU();
            if (!this.cbU || this.cbT || this.isFromMark) {
                this.ccl = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.cci.ef(true);
            this.avu = false;
            return false;
        } else if (i == 4 && !this.ccn) {
            a(adL(), true, this.cbS, 3);
            this.avu = false;
            return true;
        } else if (i == 3 && !this.ccn) {
            if (this.isFromMark) {
                a(adL(), true, this.cbS, 3);
            } else {
                a(adL(), false, this.cbS, 3);
            }
            this.avu = false;
            return true;
        } else {
            this.ccn = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.anJ);
            if (!this.cbU || this.cbT || this.isFromMark) {
                this.ccl = false;
            }
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.cbR == null || this.cbR.length() == 0) {
                this.avu = false;
                return false;
            }
            pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.cbR, 0L));
            pbPageRequestMessage.set_rn(30);
            pbPageRequestMessage.set_with_floor(1);
            int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
            float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = com.baidu.tbadk.core.util.ar.uE().uG() ? 2 : 1;
            pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
            pbPageRequestMessage.set_scr_dip(f);
            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
            if (!this.cbU) {
                pbPageRequestMessage.set_r(1);
            }
            if (this.cbT) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.aPJ != null) {
                pbPageRequestMessage.set_st_type(this.aPJ);
            }
            if (this.ccf) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cce));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.ccl) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.opType != null) {
                pbPageRequestMessage.setOpType(this.opType);
                pbPageRequestMessage.setOpUrl(this.opUrl);
                pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.ccj, 0));
                pbPageRequestMessage.setOpMessageID(this.cce);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cch));
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.ccg.acI();
            switch (i) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.isFromMark) {
                        if (!this.cbU) {
                            if (this.cca - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cca - 1));
                            }
                        } else if (this.cbZ < this.ccb) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cbZ + 1));
                        }
                    }
                    if (acI != null && acI.size() > 0) {
                        int size = acI.size();
                        int i3 = 1;
                        while (size - i3 >= 0) {
                            com.baidu.tieba.tbadkCore.data.i iVar = acI.get(size - i3);
                            if (iVar == null) {
                                i3++;
                            } else {
                                this.cbS = iVar.getId();
                                if (StringUtils.isNull(this.cbS)) {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (this.cbS != null && this.cbS.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cbS, 0L));
                        break;
                    } else if (!this.cbU) {
                        pbPageRequestMessage.set_last(1);
                        break;
                    }
                    break;
                case 2:
                    if (acI != null && acI.size() > 0 && acI.get(0) != null) {
                        this.cbS = acI.get(0).getId();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.isFromMark) {
                        if (this.cbU) {
                            if (this.cca - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cca - 1));
                            }
                        } else if (this.cbZ < this.ccb) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cbZ + 1));
                        }
                    }
                    if (this.cbS != null && this.cbS.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cbS, 0L));
                        break;
                    }
                    break;
                case 3:
                    if (this.isFromMark) {
                        pbPageRequestMessage.set_banner(0);
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.cbU) {
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
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cbS, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.cbY));
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cbS, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
            }
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
            pbPageRequestMessage.setCacheKey(adL());
            pbPageRequestMessage.setContext(this.mContext);
            sendMessage(pbPageRequestMessage);
            return true;
        }
    }

    protected void iv(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.ccg.acI();
        if (i == 1) {
            boolean z2 = false;
            while (acI.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                acI.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ccg.getPage().by(1);
                if (this.cci != null) {
                    this.cci.a(this.ccg);
                }
            }
        } else if (i == 2) {
            while (acI.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                acI.remove(acI.size() - 1);
                z = true;
            }
            if (z) {
                this.ccg.getPage().bx(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.avu = false;
        if (bVar2 != null) {
            c(bVar2);
        }
        a(bVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(PbPageSocketResponseMessage pbPageSocketResponseMessage) {
        a(pbPageSocketResponseMessage.getPbData(), pbPageSocketResponseMessage.getUpdateType(), pbPageSocketResponseMessage.hasError(), pbPageSocketResponseMessage.getError(), pbPageSocketResponseMessage.getErrorString(), false, pbPageSocketResponseMessage.getDownSize(), 0L, pbPageSocketResponseMessage.getCostTime());
    }

    public void a(PbPageHttpResponseMessage pbPageHttpResponseMessage) {
        a(pbPageHttpResponseMessage.getPbData(), pbPageHttpResponseMessage.getUpdateType(), pbPageHttpResponseMessage.hasError(), pbPageHttpResponseMessage.getError(), pbPageHttpResponseMessage.getErrorString(), true, pbPageHttpResponseMessage.getDownSize(), pbPageHttpResponseMessage.getCostTime(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            d(e(bVar));
        }
    }

    protected void d(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            String f = f(bVar);
            for (int i = 0; i < bVar.acI().size(); i++) {
                com.baidu.tieba.tbadkCore.data.i iVar = bVar.acI().get(i);
                for (int i2 = 0; i2 < iVar.apS().size(); i2++) {
                    iVar.apS().get(i2).a(this.aSJ.getPageContext().getUniqueId(), f.equals(iVar.apS().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.b e(com.baidu.tieba.pb.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.v acH = bVar.acH();
        acH.bA(this.cbV);
        acH.bz(this.cbW);
        acH.k(this.cbX);
        return bVar;
    }

    protected String f(com.baidu.tieba.pb.a.b bVar) {
        String str = null;
        if (bVar == null) {
            return null;
        }
        if (bVar.acH() != null && bVar.acH().getAuthor() != null) {
            str = bVar.acH().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aMS != null && !z3) {
            this.aMS.a(z2, z4, i2, str, i3, j, j2);
            this.aMS = null;
        }
        if (bVar == null) {
            if (this.cci != null) {
                this.cci.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.ccf = false;
            if (bVar.getPage() != null) {
                it(bVar.getPage().rR());
                this.ccb = bVar.getPage().rP();
            }
            this.ccb = this.ccb < 1 ? 1 : this.ccb;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.ccg.acI();
            switch (i) {
                case 1:
                    this.ccg.a(bVar.getPage(), 1);
                    if (bVar.acI() != null) {
                        acI.addAll(bVar.acI());
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 2:
                    if (bVar.acI() != null) {
                        i5 = bVar.acI().size() + 1;
                        acI.addAll(0, bVar.acI());
                    }
                    this.ccg.a(bVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.cbU && bVar.getPage() != null) {
                        bVar.getPage().bv(bVar.getPage().rP());
                    }
                    g(bVar);
                    i4 = 0;
                    break;
                case 4:
                    g(bVar);
                    i4 = 0;
                    break;
                case 5:
                    g(bVar);
                    i4 = 0;
                    break;
                case 6:
                    g(bVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.ccg != null && this.ccg.acH() != null) {
                PraiseData praise = this.ccg.acH().getPraise();
                if (this.ccp != null && !praise.isPriaseDataValid()) {
                    this.ccg.acH().setPraise(this.ccp);
                } else {
                    this.ccp = this.ccg.acH().getPraise();
                    this.ccp.setPostId(this.ccg.acH().sv());
                }
                if (bVar.getPage() != null && bVar.getPage().rR() == 1) {
                    this.ccg.acH().j(bVar.acH().ss());
                }
                this.ccg.acH().setReply_num(bVar.acH().getReply_num());
            }
            if (this.cci != null) {
                this.cci.a(true, getErrorCode(), i, i4, this.ccg, this.mErrorString, 1);
            }
        }
        if (this.ccg != null && this.ccg.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.ccg.getUserData().getIsMem())));
        }
        if (this.ccg != null && this.ccg.acH() != null && this.ccg.acG() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aSJ;
            historyMessage.threadId = getPbData().acH().getId();
            historyMessage.forumName = getPbData().acG().getName();
            historyMessage.threadName = getPbData().acH().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = ady();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.pb.a.b bVar) {
        this.ccg = bVar;
        is(bVar.getPage().rR());
    }

    public boolean adF() {
        if (this.cbR == null || this.cbS == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return iu(4);
        }
        return iu(6);
    }

    public boolean ek(boolean z) {
        if (this.cbR == null || this.ccg == null) {
            return false;
        }
        if (z || this.ccg.getPage().rT() != 0) {
            return iu(1);
        }
        return false;
    }

    public boolean el(boolean z) {
        if (this.cbR == null || this.ccg == null) {
            return false;
        }
        if ((z || this.ccg.getPage().rU() != 0) && this.ccg.acI() != null && this.ccg.acI().size() >= 1) {
            return iu(2);
        }
        return false;
    }

    public boolean adG() {
        this.cbT = !this.cbT;
        LoadData();
        return true;
    }

    public boolean adH() {
        this.cbU = !this.cbU;
        return LoadData();
    }

    public boolean adI() {
        return this.cbU;
    }

    public boolean hasData() {
        return (this.ccg == null || this.ccg.acG() == null || this.ccg.acH() == null) ? false : true;
    }

    public boolean qr() {
        if (this.ccg == null) {
            return false;
        }
        return this.ccg.qr();
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eI(String str) {
        if (this.ccg == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ccg.acG().getId());
        writeData.setForumName(this.ccg.acG().getName());
        writeData.setThreadId(this.cbR);
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

    public MarkData iw(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ccg == null || this.ccg.acI() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.i> acI = this.ccg.acI();
        if (acI.size() > 0 && i == acI.size()) {
            i = acI.size() - 1;
        }
        if (acI.size() <= 0 || i >= acI.size()) {
            return null;
        }
        return c(acI.get(i));
    }

    public MarkData adJ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cbR);
        markData.setPostId(this.ccg.qq());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cbT);
        markData.setSequence(Boolean.valueOf(this.cbU));
        markData.setId(this.cbR);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.i iVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cbR);
        markData.setPostId(iVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cbT);
        markData.setSequence(Boolean.valueOf(this.cbU));
        markData.setId(this.cbR);
        markData.setFloor(iVar.apV());
        if (iVar instanceof com.baidu.tieba.pb.a.a) {
            markData.setApp(true);
        } else if (iVar instanceof com.baidu.tieba.tbadkCore.data.h) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.h) iVar).isApp());
        }
        return markData;
    }

    public void adK() {
        bi.adv().w(adL(), this.isFromMark);
    }

    private String adL() {
        String str = this.cbR;
        if (this.cbT) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cbU) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void em(boolean z) {
        if (this.ccg != null) {
            this.ccg.ab(z);
        }
    }

    public void en(boolean z) {
        this.ccl = z;
    }

    public void a(a aVar) {
        this.cci = aVar;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return null;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bk() {
        return CV();
    }
}
