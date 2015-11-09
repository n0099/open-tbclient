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
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
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
public class ca extends com.baidu.tbadk.editortools.c.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private CustomMessageListener aGu;
    private com.baidu.tieba.tbadkCore.e.a aMt;
    private long aMu;
    private long aMv;
    private long aMw;
    private long aMx;
    private String aPl;
    private BaseActivity aSm;
    private boolean auq;
    protected com.baidu.tieba.pb.a.c chr;
    private boolean ckA;
    private boolean ckB;
    private boolean ckC;
    private int ckD;
    private int ckE;
    private long ckF;
    private int ckG;
    private int ckH;
    private int ckI;
    private int ckJ;
    private boolean ckK;
    private boolean ckL;
    private long ckM;
    private boolean ckN;
    protected int ckO;
    private a ckP;
    private String ckQ;
    private String ckR;
    private boolean ckS;
    private boolean ckT;
    private boolean ckU;
    private boolean ckV;
    private int ckW;
    private com.baidu.adp.framework.listener.a ckX;
    private PraiseData ckY;
    protected String cky;
    private String ckz;
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
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4);

        void b(com.baidu.tieba.pb.a.c cVar);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void ex(boolean z);
    }

    public void ez(boolean z) {
        this.ckV = z;
    }

    public ca(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aPl = null;
        this.cky = null;
        this.ckz = null;
        this.ckA = false;
        this.ckB = true;
        this.ckC = true;
        this.ckD = 0;
        this.ckE = 0;
        this.ckF = 0L;
        this.ckG = 1;
        this.ckH = 1;
        this.ckI = 1;
        this.ckJ = 1;
        this.isAd = false;
        this.ckK = false;
        this.ckL = false;
        this.isFromMark = false;
        this.ckM = 0L;
        this.ckN = false;
        this.mForumName = null;
        this.chr = null;
        this.auq = false;
        this.mContext = null;
        this.ckP = null;
        this.aMu = 0L;
        this.aMv = 0L;
        this.aMw = 0L;
        this.aMx = 0L;
        this.opType = null;
        this.opUrl = null;
        this.ckQ = null;
        this.ckR = null;
        this.aMt = null;
        this.ckT = false;
        this.postID = null;
        this.ckV = false;
        this.ckW = -1;
        this.aGu = new cb(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.ckX = new cd(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.ckY = null;
        registerListener(this.aGu);
        registerListener(this.ckX);
        this.chr = new com.baidu.tieba.pb.a.c();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aSm = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int agj() {
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
        this.cky = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.cky)) {
            this.cky = Q(intent);
        }
        this.ckz = intent.getStringExtra("post_id");
        this.ckA = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ckC = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aPl = intent.getStringExtra("st_type");
        this.ckD = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.ckE = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.ckF = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.ckL = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.ckK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ckN = intent.getBooleanExtra("is_pv", false);
        this.ckM = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.ckR = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.ckQ = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    private String Q(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.cky = bundle.getString("thread_id");
        this.ckz = bundle.getString("post_id");
        this.ckA = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.ckC = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aPl = bundle.getString("st_type");
        this.ckD = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.ckE = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.ckF = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.ckL = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.ckK = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.ckN = bundle.getBoolean("is_pv", false);
        this.ckM = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.ckR = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.cky);
        bundle.putString("post_id", this.ckz);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.ckA);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.ckC);
        bundle.putString("st_type", this.aPl);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.ckD);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.ckE);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.ckF);
        bundle.putBoolean("from_frs", this.ckL);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.ckK);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.ckN);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.ckM);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.ckR);
    }

    public String agk() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cky);
        sb.append(this.ckz);
        sb.append(this.ckA);
        sb.append(this.ckC);
        sb.append(this.aPl);
        sb.append(this.ckD);
        sb.append(this.ckE);
        sb.append(this.ckF);
        sb.append(this.ckL);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.ckK);
        sb.append(this.ckN);
        sb.append(this.ckM);
        sb.append(this.mForumName);
        if (this.ckR != null) {
            sb.append(this.ckR);
        }
        return sb.toString();
    }

    public String agl() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.ckz;
    }

    public String getThreadID() {
        return this.cky;
    }

    public boolean getHostMode() {
        return this.ckA;
    }

    public boolean agm() {
        return this.ckC;
    }

    public boolean agn() {
        return this.ckL;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean ago() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.aPl);
    }

    public int getIsGood() {
        return this.ckD;
    }

    public int agp() {
        return this.ckE;
    }

    public void setIsGood(int i) {
        this.ckD = i;
    }

    public void ja(int i) {
        this.ckE = i;
    }

    public boolean agq() {
        return this.ckK;
    }

    public boolean agr() {
        if (this.chr == null) {
            return false;
        }
        return this.chr.isValid();
    }

    public String sn() {
        if (this.chr == null || !this.chr.qi()) {
            return null;
        }
        return this.chr.qh();
    }

    public boolean jb(int i) {
        this.ckG = i;
        if (this.ckG > this.chr.getPage().rG()) {
            this.ckG = this.chr.getPage().rG();
        }
        if (this.ckG < 1) {
            this.ckG = 1;
        }
        if (this.cky == null) {
            return false;
        }
        return jf(5);
    }

    public boolean jc(int i) {
        int sC = this.chr.afh().sC();
        if (i <= sC) {
            sC = i;
        }
        int i2 = sC >= 1 ? sC : 1;
        if (this.cky == null) {
            return false;
        }
        this.ckW = i2;
        return jf(7);
    }

    public void jd(int i) {
        this.ckG = i;
        this.ckH = i;
        this.ckI = i;
    }

    public void je(int i) {
        if (this.ckH < i) {
            this.ckH = i;
            if (this.ckH - this.ckI >= MAX_PAGE_NUM) {
                this.ckI = (this.ckH - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.ckI > i) {
            this.ckI = i;
            if (this.ckH - this.ckI >= MAX_PAGE_NUM) {
                this.ckH = (this.ckI + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        return this.chr;
    }

    public com.baidu.tbadk.core.data.o Rn() {
        if (this.chr == null) {
            return null;
        }
        return this.chr.getPage();
    }

    public boolean ags() {
        if (this.ckC) {
            if (this.chr.getPage().rK() == 0) {
                eA(true);
                return true;
            }
        } else if (this.chr.getPage().rL() == 0) {
            eB(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cky == null) {
            return false;
        }
        cancelLoadData();
        if (this.aMt == null) {
            this.aMt = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aMt.start();
        }
        boolean jf = jf(3);
        if (this.opType != null) {
            this.opType = null;
            this.ckQ = null;
            this.opUrl = null;
            return jf;
        }
        return jf;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.auq = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        IO();
    }

    private void IO() {
        if (this.aMt != null) {
            this.aMt.destory();
            this.aMt = null;
        }
    }

    public boolean CI() {
        return (this.ckz == null || this.ckz.equals("0") || this.ckz.length() == 0) ? LoadData() : agt();
    }

    public boolean jf(int i) {
        this.mRequestType = i;
        if (this.auq) {
            return false;
        }
        this.auq = true;
        jg(i);
        com.baidu.tieba.pb.a.c pbData = cm.agF().getPbData();
        if (pbData != null && pbData.afh() != null) {
            this.ckC = cm.agF().agm();
            this.ckA = cm.agF().agH();
            if (!this.ckC || this.ckA || this.isFromMark) {
                this.ckS = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.ckP.ex(true);
            this.auq = false;
            return false;
        } else if (i == 4 && !this.ckU) {
            a(agy(), true, this.ckz, 3);
            this.auq = false;
            return true;
        } else if (i == 3 && !this.ckU) {
            if (this.isFromMark) {
                a(agy(), true, this.ckz, 3);
            } else {
                a(agy(), false, this.ckz, 3);
            }
            this.auq = false;
            return true;
        } else {
            this.ckU = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.anZ);
            if (!this.ckC || this.ckA || this.isFromMark) {
                this.ckS = false;
            }
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.cky == null || this.cky.length() == 0) {
                this.auq = false;
                return false;
            }
            pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.cky, 0L));
            pbPageRequestMessage.set_rn(30);
            pbPageRequestMessage.set_with_floor(1);
            int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
            float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = com.baidu.tbadk.core.util.at.uK().uM() ? 2 : 1;
            pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
            pbPageRequestMessage.set_scr_dip(f);
            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
            if (!this.ckC) {
                pbPageRequestMessage.set_r(1);
            }
            if (this.ckA) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.aPl != null) {
                pbPageRequestMessage.set_st_type(this.aPl);
            }
            if (this.ckN) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.ckM));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.ckS) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.opType != null) {
                pbPageRequestMessage.setOpType(this.opType);
                pbPageRequestMessage.setOpUrl(this.opUrl);
                pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.ckQ, 0));
                pbPageRequestMessage.setOpMessageID(this.ckM);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.ckO));
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.chr.afi();
            switch (i) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.isFromMark) {
                        if (!this.ckC) {
                            if (this.ckI - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.ckI - 1));
                            }
                        } else if (this.ckH < this.ckJ) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ckH + 1));
                        }
                    }
                    if (afi != null && afi.size() > 0) {
                        int size = afi.size();
                        int i3 = 1;
                        while (size - i3 >= 0) {
                            com.baidu.tieba.tbadkCore.data.o oVar = afi.get(size - i3);
                            if (oVar == null) {
                                i3++;
                            } else {
                                this.ckz = oVar.getId();
                                if (StringUtils.isNull(this.ckz)) {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (this.ckz != null && this.ckz.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ckz, 0L));
                        break;
                    } else if (!this.ckC) {
                        pbPageRequestMessage.set_last(1);
                        break;
                    }
                    break;
                case 2:
                    if (afi != null && afi.size() > 0 && afi.get(0) != null) {
                        this.ckz = afi.get(0).getId();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.isFromMark) {
                        if (this.ckC) {
                            if (this.ckI - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.ckI - 1));
                            }
                        } else if (this.ckH < this.ckJ) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.ckH + 1));
                        }
                    }
                    if (this.ckz != null && this.ckz.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ckz, 0L));
                        break;
                    }
                    break;
                case 3:
                    if (this.isFromMark) {
                        pbPageRequestMessage.set_banner(0);
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.ckC) {
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
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ckz, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.ckG));
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.ckz, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 7:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.setIsJumpFloor(true);
                    pbPageRequestMessage.setJumpFloorNum(this.ckW);
                    break;
            }
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
            pbPageRequestMessage.setCacheKey(agy());
            pbPageRequestMessage.setContext(this.mContext);
            pbPageRequestMessage.setIsSubPostDataReverse(this.ckV);
            sendMessage(pbPageRequestMessage);
            return true;
        }
    }

    protected void jg(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.chr.afi();
        if (i == 1) {
            boolean z2 = false;
            while (afi.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                afi.remove(0);
                z2 = true;
            }
            if (z2) {
                this.chr.getPage().bz(1);
                if (this.ckP != null) {
                    this.ckP.b(this.chr);
                }
            }
        } else if (i == 2) {
            while (afi.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                afi.remove(afi.size() - 1);
                z = true;
            }
            if (z) {
                this.chr.getPage().by(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.c cVar2 = z ? null : cVar;
        this.auq = false;
        if (cVar2 != null) {
            c(cVar2);
        }
        a(cVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            d(e(cVar));
        }
    }

    protected void d(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            String f = f(cVar);
            for (int i = 0; i < cVar.afi().size(); i++) {
                com.baidu.tieba.tbadkCore.data.o oVar = cVar.afi().get(i);
                for (int i2 = 0; i2 < oVar.axp().size(); i2++) {
                    oVar.axp().get(i2).a(this.aSm.getPageContext().getUniqueId(), f.equals(oVar.axp().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.c e(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.w afh = cVar.afh();
        afh.bB(this.ckD);
        afh.bA(this.ckE);
        if (this.ckF > 0) {
            afh.k(this.ckF);
            return cVar;
        }
        return cVar;
    }

    protected String f(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.afh() != null && cVar.afh().getAuthor() != null) {
            str = cVar.afh().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        String Q;
        boolean z4 = !z;
        if (this.aMt != null && !z3) {
            this.aMt.a(z2, z4, i2, str, i3, j, j2);
            this.aMt = null;
        }
        if (cVar == null) {
            if (this.ckP != null) {
                this.ckC = this.ckB;
                this.ckP.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.ckB = this.ckC;
            this.ckN = false;
            if (cVar.getPage() != null) {
                je(cVar.getPage().rI());
                this.ckJ = cVar.getPage().rG();
            }
            this.ckJ = this.ckJ < 1 ? 1 : this.ckJ;
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.chr.afi();
            switch (i) {
                case 1:
                    this.chr.a(cVar.getPage(), 1);
                    if (cVar.afi() != null) {
                        com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(cVar.afi(), 0);
                        if (oVar != null && (Q = Q(afi)) != null && Q.equals(oVar.getId())) {
                            cVar.afi().remove(oVar);
                        }
                        afi.addAll(cVar.afi());
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 2:
                    if (cVar.afi() == null) {
                        i4 = 0;
                    } else {
                        int size = cVar.afi().size() + 1;
                        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(afi, 0);
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(cVar.afi(), com.baidu.tbadk.core.util.u.m(cVar.afi()) - 1);
                        if (oVar2 == null || oVar3 == null || !oVar2.getId().equals(oVar3.getId())) {
                            i4 = size;
                        } else {
                            cVar.afi().remove(oVar3);
                            i4 = size - 1;
                        }
                        afi.addAll(0, cVar.afi());
                    }
                    this.chr.a(cVar.getPage(), 2);
                    i5 = i4;
                    break;
                case 3:
                    if (!this.ckC && cVar.getPage() != null) {
                        cVar.getPage().bw(cVar.getPage().rG());
                    }
                    g(cVar);
                    i5 = 0;
                    break;
                case 4:
                    g(cVar);
                    i5 = 0;
                    break;
                case 5:
                    g(cVar);
                    i5 = 0;
                    break;
                case 6:
                    g(cVar);
                    i5 = 0;
                    break;
                case 7:
                    g(cVar);
                    i5 = 0;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            if (this.chr != null && this.chr.afh() != null) {
                PraiseData praise = this.chr.afh().getPraise();
                if (this.ckY != null && !praise.isPriaseDataValid()) {
                    this.chr.afh().setPraise(this.ckY);
                } else {
                    this.ckY = this.chr.afh().getPraise();
                    this.ckY.setPostId(this.chr.afh().ss());
                }
                if (cVar.getPage() != null && cVar.getPage().rI() == 1 && cVar.afh() != null && cVar.afh().so() != null && cVar.afh().so().size() > 0) {
                    this.chr.afh().i(cVar.afh().so());
                }
                this.chr.afh().setReply_num(cVar.afh().getReply_num());
            }
            if (this.chr != null && this.chr.getUserData() != null && cVar.getUserData() != null) {
                this.chr.getUserData().setBimg_end_time(cVar.getUserData().getBimg_end_time());
                this.chr.getUserData().setBimg_url(cVar.getUserData().getBimg_url());
            }
            if (this.ckP != null) {
                this.ckP.a(true, getErrorCode(), i, i5, this.chr, this.mErrorString, 1);
            }
        }
        if (this.chr != null && this.chr.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.chr.getUserData().getIsMem())));
        }
        if (this.chr != null && this.chr.afh() != null && this.chr.afg() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aSm;
            historyMessage.threadId = getPbData().afh().getId();
            historyMessage.forumName = getPbData().afg().getName();
            historyMessage.threadName = getPbData().afh().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = agm();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private String Q(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        int m = com.baidu.tbadk.core.util.u.m(arrayList);
        if (m <= 0) {
            return null;
        }
        for (int i = m - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.u.b(arrayList, i);
            if (oVar != null && !StringUtils.isNull(oVar.getId())) {
                return oVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.pb.a.c cVar) {
        this.chr = cVar;
        jd(cVar.getPage().rI());
    }

    public boolean agt() {
        if (this.cky == null || this.ckz == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return jf(4);
        }
        return jf(6);
    }

    public boolean eA(boolean z) {
        if (this.cky == null || this.chr == null) {
            return false;
        }
        if (z || this.chr.getPage().rK() != 0) {
            return jf(1);
        }
        return false;
    }

    public boolean eB(boolean z) {
        if (this.cky == null || this.chr == null) {
            return false;
        }
        if ((z || this.chr.getPage().rL() != 0) && this.chr.afi() != null && this.chr.afi().size() >= 1) {
            return jf(2);
        }
        return false;
    }

    public boolean jQ(String str) {
        this.ckA = !this.ckA;
        this.ckz = str;
        jf(6);
        return true;
    }

    public boolean agu() {
        if (com.baidu.adp.lib.util.i.iN()) {
            this.ckB = this.ckC;
            this.ckC = !this.ckC;
        }
        return LoadData();
    }

    public boolean agv() {
        return this.ckC;
    }

    public boolean hasData() {
        return (this.chr == null || this.chr.afg() == null || this.chr.afh() == null) ? false : true;
    }

    public boolean qi() {
        if (this.chr == null) {
            return false;
        }
        return this.chr.qi();
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eW(String str) {
        if (this.chr == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.chr.afg().getId());
        writeData.setForumName(this.chr.afg().getName());
        writeData.setThreadId(this.cky);
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

    public MarkData jh(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.chr == null || this.chr.afi() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.chr.afi();
        if (afi.size() > 0 && i == afi.size()) {
            i = afi.size() - 1;
        }
        if (afi.size() <= 0 || i >= afi.size()) {
            return null;
        }
        return d(afi.get(i));
    }

    public MarkData agw() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cky);
        markData.setPostId(this.chr.qh());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ckA);
        markData.setSequence(Boolean.valueOf(this.ckC));
        markData.setId(this.cky);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.o oVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cky);
        markData.setPostId(oVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.ckA);
        markData.setSequence(Boolean.valueOf(this.ckC));
        markData.setId(this.cky);
        markData.setFloor(oVar.axt());
        if (oVar instanceof com.baidu.tieba.pb.a.b) {
            markData.setApp(true);
        } else if (oVar instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) oVar).isApp());
        }
        return markData;
    }

    public void agx() {
        bv.agi().z(agy(), this.isFromMark);
    }

    private String agy() {
        String str = this.cky;
        if (this.ckA) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.ckC) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void eC(boolean z) {
        if (this.chr != null) {
            this.chr.ab(z);
        }
    }

    public void eD(boolean z) {
        this.ckS = z;
    }

    public void a(a aVar) {
        this.ckP = aVar;
    }

    public void jx(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String AV() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean AU() {
        return CI();
    }

    public boolean jR(String str) {
        if (getPbData() == null || getPbData().afh() == null || getPbData().afh().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().afh().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }
}
