package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bk extends com.baidu.tbadk.editortools.c.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private CustomMessageListener aIw;
    private com.baidu.tieba.tbadkCore.e.a aNf;
    private long aNg;
    private long aNh;
    private long aNi;
    private long aNj;
    private String aPX;
    private BaseActivity aSX;
    private boolean axc;
    protected String ccM;
    private String ccN;
    private boolean ccO;
    private boolean ccP;
    private int ccQ;
    private int ccR;
    private long ccS;
    private int ccT;
    private int ccU;
    private int ccV;
    private int ccW;
    private boolean ccX;
    private boolean ccY;
    private long ccZ;
    private boolean cda;
    protected com.baidu.tieba.pb.a.b cdb;
    protected int cdc;
    private a cdd;
    private String cde;
    private String cdf;
    private boolean cdg;
    private boolean cdh;
    private boolean cdi;
    private boolean cdj;
    private int cdk;
    private com.baidu.adp.framework.listener.a cdl;
    private PraiseData cdm;
    private boolean isAd;
    private boolean isFromMark;
    protected Context mContext;
    private String mForumName;
    private int mRequestType;
    private String opType;
    private String opUrl;
    private String postID;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.pb.a.b bVar);

        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void em(boolean z);
    }

    public void er(boolean z) {
        this.cdj = z;
    }

    public bk(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aPX = null;
        this.ccM = null;
        this.ccN = null;
        this.ccO = false;
        this.ccP = true;
        this.ccQ = 0;
        this.ccR = 0;
        this.ccS = 0L;
        this.ccT = 1;
        this.ccU = 1;
        this.ccV = 1;
        this.ccW = 1;
        this.isAd = false;
        this.ccX = false;
        this.ccY = false;
        this.isFromMark = false;
        this.ccZ = 0L;
        this.cda = false;
        this.mForumName = null;
        this.cdb = null;
        this.axc = false;
        this.mContext = null;
        this.cdd = null;
        this.aNg = 0L;
        this.aNh = 0L;
        this.aNi = 0L;
        this.aNj = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cde = null;
        this.cdf = null;
        this.aNf = null;
        this.cdh = false;
        this.postID = null;
        this.cdj = false;
        this.cdk = -1;
        this.aIw = new bl(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cdl = new bn(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cdm = null;
        registerListener(this.aIw);
        registerListener(this.cdl);
        this.cdb = new com.baidu.tieba.pb.a.b();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aSX = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int adJ() {
        return BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES;
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
        this.ccM = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ccM)) {
            this.ccM = R(intent);
        }
        this.ccN = intent.getStringExtra("post_id");
        this.ccO = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ccP = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aPX = intent.getStringExtra("st_type");
        this.ccQ = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.ccR = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.ccS = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.ccY = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.ccX = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cda = intent.getBooleanExtra("is_pv", false);
        this.ccZ = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cdf = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cde = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    private String R(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.ccM = bundle.getString("thread_id");
        this.ccN = bundle.getString("post_id");
        this.ccO = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ccP = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aPX = bundle.getString("st_type");
        this.ccQ = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.ccR = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.ccS = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.ccY = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ccX = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cda = bundle.getBoolean("is_pv", false);
        this.ccZ = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cdf = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.ccM);
        bundle.putString("post_id", this.ccN);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ccO);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.ccP);
        bundle.putString("st_type", this.aPX);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.ccQ);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.ccR);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.ccS);
        bundle.putBoolean("from_frs", this.ccY);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.ccX);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cda);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.ccZ);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cdf);
    }

    public String adK() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ccM);
        sb.append(this.ccN);
        sb.append(this.ccO);
        sb.append(this.ccP);
        sb.append(this.aPX);
        sb.append(this.ccQ);
        sb.append(this.ccR);
        sb.append(this.ccS);
        sb.append(this.ccY);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ccX);
        sb.append(this.cda);
        sb.append(this.ccZ);
        sb.append(this.mForumName);
        if (this.cdf != null) {
            sb.append(this.cdf);
        }
        return sb.toString();
    }

    public String adL() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.ccN;
    }

    public String getThreadID() {
        return this.ccM;
    }

    public boolean getHostMode() {
        return this.ccO;
    }

    public boolean adM() {
        return this.ccP;
    }

    public boolean adN() {
        return this.ccY;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public int getIsGood() {
        return this.ccQ;
    }

    public int adO() {
        return this.ccR;
    }

    public void setIsGood(int i) {
        this.ccQ = i;
    }

    public void iB(int i) {
        this.ccR = i;
    }

    public boolean adP() {
        return this.ccX;
    }

    public boolean adQ() {
        if (this.cdb == null) {
            return false;
        }
        return this.cdb.isValid();
    }

    public String ss() {
        if (this.cdb == null || !this.cdb.qo()) {
            return null;
        }
        return this.cdb.qn();
    }

    public boolean iC(int i) {
        this.ccT = i;
        if (this.ccT > this.cdb.getPage().rM()) {
            this.ccT = this.cdb.getPage().rM();
        }
        if (this.ccT < 1) {
            this.ccT = 1;
        }
        if (this.ccM == null) {
            return false;
        }
        return iG(5);
    }

    public boolean iD(int i) {
        int sG = this.cdb.acQ().sG();
        if (i <= sG) {
            sG = i;
        }
        int i2 = sG >= 1 ? sG : 1;
        if (this.ccM == null) {
            return false;
        }
        this.cdk = i2;
        return iG(7);
    }

    public void iE(int i) {
        this.ccT = i;
        this.ccU = i;
        this.ccV = i;
    }

    public void iF(int i) {
        if (this.ccU < i) {
            this.ccU = i;
            if (this.ccU - this.ccV >= MAX_PAGE_NUM) {
                this.ccV = (this.ccU - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.ccV > i) {
            this.ccV = i;
            if (this.ccU - this.ccV >= MAX_PAGE_NUM) {
                this.ccU = (this.ccV + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.cdb;
    }

    public com.baidu.tbadk.core.data.o adR() {
        if (this.cdb == null) {
            return null;
        }
        return this.cdb.getPage();
    }

    public boolean adS() {
        if (this.ccP) {
            if (this.cdb.getPage().rQ() == 0) {
                es(true);
                return true;
            }
        } else if (this.cdb.getPage().rR() == 0) {
            et(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.ccM == null) {
            return false;
        }
        cancelLoadData();
        if (this.aNf == null) {
            this.aNf = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aNf.start();
        }
        boolean iG = iG(3);
        if (this.opType != null) {
            this.opType = null;
            this.cde = null;
            this.opUrl = null;
            return iG;
        }
        return iG;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.axc = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        IG();
    }

    private void IG() {
        if (this.aNf != null) {
            this.aNf.destory();
            this.aNf = null;
        }
    }

    public boolean Df() {
        return (this.ccN == null || this.ccN.equals("0") || this.ccN.length() == 0) ? LoadData() : adT();
    }

    public boolean iG(int i) {
        this.mRequestType = i;
        if (this.axc) {
            return false;
        }
        this.axc = true;
        iH(i);
        com.baidu.tieba.pb.a.b pbData = bw.aeg().getPbData();
        if (pbData != null) {
            this.ccP = bw.aeg().adM();
            this.ccO = bw.aeg().aei();
            if (!this.ccP || this.ccO || this.isFromMark) {
                this.cdg = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.cdd.em(true);
            this.axc = false;
            return false;
        } else if (i == 4 && !this.cdi) {
            a(adZ(), true, this.ccN, 3);
            this.axc = false;
            return true;
        } else if (i == 3 && !this.cdi) {
            if (this.isFromMark) {
                a(adZ(), true, this.ccN, 3);
            } else {
                a(adZ(), false, this.ccN, 3);
            }
            this.axc = false;
            return true;
        } else {
            this.cdi = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apu);
            if (!this.ccP || this.ccO || this.isFromMark) {
                this.cdg = false;
            }
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.ccM == null || this.ccM.length() == 0) {
                this.axc = false;
                return false;
            }
            pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ccM, 0L));
            pbPageRequestMessage.set_rn(30);
            pbPageRequestMessage.set_with_floor(1);
            int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
            float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = com.baidu.tbadk.core.util.ar.uK().uM() ? 2 : 1;
            pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
            pbPageRequestMessage.set_scr_dip(f);
            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
            if (!this.ccP) {
                pbPageRequestMessage.set_r(1);
            }
            if (this.ccO) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.aPX != null) {
                pbPageRequestMessage.set_st_type(this.aPX);
            }
            if (this.cda) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.ccZ));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.cdg) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.opType != null) {
                pbPageRequestMessage.setOpType(this.opType);
                pbPageRequestMessage.setOpUrl(this.opUrl);
                pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.cde, 0));
                pbPageRequestMessage.setOpMessageID(this.ccZ);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cdc));
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cdb.acR();
            switch (i) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.isFromMark) {
                        if (!this.ccP) {
                            if (this.ccV - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.ccV - 1));
                            }
                        } else if (this.ccU < this.ccW) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ccU + 1));
                        }
                    }
                    if (acR != null && acR.size() > 0) {
                        int size = acR.size();
                        int i3 = 1;
                        while (size - i3 >= 0) {
                            com.baidu.tieba.tbadkCore.data.i iVar = acR.get(size - i3);
                            if (iVar == null) {
                                i3++;
                            } else {
                                this.ccN = iVar.getId();
                                if (StringUtils.isNull(this.ccN)) {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (this.ccN != null && this.ccN.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ccN, 0L));
                        break;
                    } else if (!this.ccP) {
                        pbPageRequestMessage.set_last(1);
                        break;
                    }
                    break;
                case 2:
                    if (acR != null && acR.size() > 0 && acR.get(0) != null) {
                        this.ccN = acR.get(0).getId();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.isFromMark) {
                        if (this.ccP) {
                            if (this.ccV - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.ccV - 1));
                            }
                        } else if (this.ccU < this.ccW) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ccU + 1));
                        }
                    }
                    if (this.ccN != null && this.ccN.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ccN, 0L));
                        break;
                    }
                    break;
                case 3:
                    if (this.isFromMark) {
                        pbPageRequestMessage.set_banner(0);
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.ccP) {
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
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ccN, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.ccT));
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ccN, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 7:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.setIsJumpFloor(true);
                    pbPageRequestMessage.setJumpFloorNum(this.cdk);
                    break;
            }
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
            pbPageRequestMessage.setCacheKey(adZ());
            pbPageRequestMessage.setContext(this.mContext);
            pbPageRequestMessage.setIsSubPostDataReverse(this.cdj);
            sendMessage(pbPageRequestMessage);
            return true;
        }
    }

    protected void iH(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cdb.acR();
        if (i == 1) {
            boolean z2 = false;
            while (acR.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                acR.remove(0);
                z2 = true;
            }
            if (z2) {
                this.cdb.getPage().bz(1);
                if (this.cdd != null) {
                    this.cdd.a(this.cdb);
                }
            }
        } else if (i == 2) {
            while (acR.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                acR.remove(acR.size() - 1);
                z = true;
            }
            if (z) {
                this.cdb.getPage().by(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.axc = false;
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
            for (int i = 0; i < bVar.acR().size(); i++) {
                com.baidu.tieba.tbadkCore.data.i iVar = bVar.acR().get(i);
                for (int i2 = 0; i2 < iVar.auf().size(); i2++) {
                    iVar.auf().get(i2).a(this.aSX.getPageContext().getUniqueId(), f.equals(iVar.auf().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.b e(com.baidu.tieba.pb.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.x acQ = bVar.acQ();
        acQ.bB(this.ccQ);
        acQ.bA(this.ccR);
        if (this.ccS > 0) {
            acQ.k(this.ccS);
            return bVar;
        }
        return bVar;
    }

    protected String f(com.baidu.tieba.pb.a.b bVar) {
        String str = null;
        if (bVar == null) {
            return null;
        }
        if (bVar.acQ() != null && bVar.acQ().getAuthor() != null) {
            str = bVar.acQ().getAuthor().getUserId();
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
        if (this.aNf != null && !z3) {
            this.aNf.a(z2, z4, i2, str, i3, j, j2);
            this.aNf = null;
        }
        if (bVar == null) {
            if (this.cdd != null) {
                this.cdd.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cda = false;
            if (bVar.getPage() != null) {
                iF(bVar.getPage().rO());
                this.ccW = bVar.getPage().rM();
            }
            this.ccW = this.ccW < 1 ? 1 : this.ccW;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cdb.acR();
            switch (i) {
                case 1:
                    this.cdb.a(bVar.getPage(), 1);
                    if (bVar.acR() != null) {
                        acR.addAll(bVar.acR());
                        i4 = 0;
                        break;
                    }
                    i4 = 0;
                    break;
                case 2:
                    if (bVar.acR() != null) {
                        i5 = bVar.acR().size() + 1;
                        acR.addAll(0, bVar.acR());
                    }
                    this.cdb.a(bVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.ccP && bVar.getPage() != null) {
                        bVar.getPage().bw(bVar.getPage().rM());
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
                case 7:
                    g(bVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.cdb != null && this.cdb.acQ() != null) {
                PraiseData praise = this.cdb.acQ().getPraise();
                if (this.cdm != null && !praise.isPriaseDataValid()) {
                    this.cdb.acQ().setPraise(this.cdm);
                } else {
                    this.cdm = this.cdb.acQ().getPraise();
                    this.cdm.setPostId(this.cdb.acQ().sx());
                }
                if (bVar.getPage() != null && bVar.getPage().rO() == 1) {
                    this.cdb.acQ().i(bVar.acQ().st());
                }
                this.cdb.acQ().setReply_num(bVar.acQ().getReply_num());
            }
            if (this.cdd != null) {
                this.cdd.a(true, getErrorCode(), i, i4, this.cdb, this.mErrorString, 1);
            }
        }
        if (this.cdb != null && this.cdb.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.cdb.getUserData().getIsMem())));
        }
        if (this.cdb != null && this.cdb.acQ() != null && this.cdb.acP() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aSX;
            historyMessage.threadId = getPbData().acQ().getId();
            historyMessage.forumName = getPbData().acP().getName();
            historyMessage.threadName = getPbData().acQ().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = adM();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.pb.a.b bVar) {
        this.cdb = bVar;
        iE(bVar.getPage().rO());
    }

    public boolean adT() {
        if (this.ccM == null || this.ccN == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return iG(4);
        }
        return iG(6);
    }

    public boolean es(boolean z) {
        if (this.ccM == null || this.cdb == null) {
            return false;
        }
        if (z || this.cdb.getPage().rQ() != 0) {
            return iG(1);
        }
        return false;
    }

    public boolean et(boolean z) {
        if (this.ccM == null || this.cdb == null) {
            return false;
        }
        if ((z || this.cdb.getPage().rR() != 0) && this.cdb.acR() != null && this.cdb.acR().size() >= 1) {
            return iG(2);
        }
        return false;
    }

    public boolean adU() {
        this.ccO = !this.ccO;
        LoadData();
        return true;
    }

    public boolean adV() {
        this.ccP = !this.ccP;
        return LoadData();
    }

    public boolean adW() {
        return this.ccP;
    }

    public boolean hasData() {
        return (this.cdb == null || this.cdb.acP() == null || this.cdb.acQ() == null) ? false : true;
    }

    public boolean qo() {
        if (this.cdb == null) {
            return false;
        }
        return this.cdb.qo();
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eQ(String str) {
        if (this.cdb == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.cdb.acP().getId());
        writeData.setForumName(this.cdb.acP().getName());
        writeData.setThreadId(this.ccM);
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

    public MarkData iI(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.cdb == null || this.cdb.acR() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.cdb.acR();
        if (acR.size() > 0 && i == acR.size()) {
            i = acR.size() - 1;
        }
        if (acR.size() <= 0 || i >= acR.size()) {
            return null;
        }
        return c(acR.get(i));
    }

    public MarkData adX() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ccM);
        markData.setPostId(this.cdb.qn());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ccO);
        markData.setSequence(Boolean.valueOf(this.ccP));
        markData.setId(this.ccM);
        return markData;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.i iVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ccM);
        markData.setPostId(iVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ccO);
        markData.setSequence(Boolean.valueOf(this.ccP));
        markData.setId(this.ccM);
        markData.setFloor(iVar.auj());
        if (iVar instanceof com.baidu.tieba.pb.a.a) {
            markData.setApp(true);
        } else if (iVar instanceof com.baidu.tieba.tbadkCore.data.h) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.h) iVar).isApp());
        }
        return markData;
    }

    public void adY() {
        bi.adI().y(adZ(), this.isFromMark);
    }

    private String adZ() {
        String str = this.ccM;
        if (this.ccO) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.ccP) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void eu(boolean z) {
        if (this.cdb != null) {
            this.cdb.ab(z);
        }
    }

    public void ev(boolean z) {
        this.cdg = z;
    }

    public void a(a aVar) {
        this.cdd = aVar;
    }

    public void ji(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String By() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bx() {
        return Df();
    }
}
