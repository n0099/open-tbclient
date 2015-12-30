package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class cf extends com.baidu.tbadk.editortools.d.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    public static int cHs = 1;
    private CustomMessageListener aKR;
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private long aUU;
    private long aUV;
    private long aUW;
    private long aUX;
    private String agB;
    private boolean axY;
    private BaseActivity bbA;
    protected com.baidu.tieba.pb.a.c cDt;
    private a cFR;
    protected String cGN;
    private String cGO;
    private boolean cGP;
    private boolean cGQ;
    private boolean cGR;
    private int cGS;
    private int cGT;
    private long cGU;
    private int cGV;
    private int cGW;
    private int cGX;
    private int cGY;
    private boolean cGZ;
    private boolean cHa;
    private long cHb;
    private boolean cHc;
    protected int cHd;
    private boolean cHe;
    private c cHf;
    private b cHg;
    private String cHh;
    private String cHi;
    private boolean cHj;
    private boolean cHk;
    private boolean cHl;
    private String cHm;
    private long cHn;
    private boolean cHo;
    private int cHp;
    private com.baidu.adp.framework.listener.a cHq;
    private PraiseData cHr;
    protected final HttpMessageListener cHt;
    private final HttpMessageListener cHu;
    private boolean isAd;
    private boolean isFromMark;
    protected Context mContext;
    private String mForumName;
    private String mLocate;
    private int mRequestType;
    private String opType;
    private String opUrl;
    private String postID;

    /* loaded from: classes.dex */
    public interface a {
        void f(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(int i, long j);

        void onError(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4);

        void b(com.baidu.tieba.pb.a.c cVar);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void eZ(boolean z);
    }

    public String alI() {
        return this.cHm;
    }

    public void kC(String str) {
        this.cHm = str;
    }

    public void fb(boolean z) {
        this.cHo = z;
    }

    public cf(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.agB = null;
        this.cGN = null;
        this.cGO = null;
        this.cGP = false;
        this.cGQ = true;
        this.cGR = true;
        this.cGS = 0;
        this.cGT = 0;
        this.cGU = 0L;
        this.cGV = 1;
        this.cGW = 1;
        this.cGX = 1;
        this.cGY = 1;
        this.isAd = false;
        this.cGZ = false;
        this.cHa = false;
        this.isFromMark = false;
        this.cHb = 0L;
        this.cHc = false;
        this.mForumName = null;
        this.cDt = null;
        this.axY = false;
        this.cHe = false;
        this.mLocate = null;
        this.mContext = null;
        this.cHf = null;
        this.cHg = null;
        this.aUU = 0L;
        this.aUV = 0L;
        this.aUW = 0L;
        this.aUX = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cHh = null;
        this.cHi = null;
        this.aUT = null;
        this.cHk = false;
        this.postID = null;
        this.cHm = null;
        this.cHn = 0L;
        this.cHo = false;
        this.cHp = -1;
        this.aKR = new cg(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cHq = new ci(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cHr = null;
        this.cFR = null;
        this.cHt = new cj(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.cHu = new ck(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        registerListener(this.aKR);
        registerListener(this.cHq);
        registerListener(this.cHt);
        this.cDt = new com.baidu.tieba.pb.a.c();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bbA = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int alJ() {
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
        this.cGN = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.cGN)) {
            this.cGN = Q(intent);
        }
        this.cGO = intent.getStringExtra("post_id");
        this.cGP = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cGR = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.agB = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.cGS = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cGT = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cGU = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.cHa = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.cGZ = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cHc = intent.getBooleanExtra("is_pv", false);
        this.cHb = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cHi = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cHh = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.cHe = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
    }

    private String Q(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.cGN = bundle.getString("thread_id");
        this.cGO = bundle.getString("post_id");
        this.cGP = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cGR = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.agB = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.cGS = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cGT = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cGU = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.cHa = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.cGZ = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cHc = bundle.getBoolean("is_pv", false);
        this.cHb = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cHi = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.cHe = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.cGN);
        bundle.putString("post_id", this.cGO);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cGP);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cGR);
        bundle.putString("st_type", this.agB);
        bundle.putString("locate", this.mLocate);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cGS);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cGT);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cGU);
        bundle.putBoolean("from_frs", this.cHa);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.cGZ);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cHc);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cHb);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cHi);
        bundle.putInt(PbActivityConfig.KEY_THREAD_TYPE, this.cHd);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.cHe);
    }

    public String alK() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cGN);
        sb.append(this.cGO);
        sb.append(this.cGP);
        sb.append(this.cGR);
        sb.append(this.agB);
        sb.append(this.cGS);
        sb.append(this.cGT);
        sb.append(this.cGU);
        sb.append(this.cHa);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.cGZ);
        sb.append(this.cHc);
        sb.append(this.cHb);
        sb.append(this.mForumName);
        sb.append(this.cHd);
        sb.append(this.cHe);
        if (this.cHi != null) {
            sb.append(this.cHi);
        }
        return sb.toString();
    }

    public String alL() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.cGO;
    }

    public void kD(String str) {
        this.cGO = str;
    }

    public String getThreadID() {
        return this.cGN;
    }

    public boolean getHostMode() {
        return this.cGP;
    }

    public boolean alM() {
        return this.cGR;
    }

    public boolean alN() {
        return this.cHa;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean alO() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.agB);
    }

    public int getIsGood() {
        return this.cGS;
    }

    public int alP() {
        return this.cGT;
    }

    public void setIsGood(int i) {
        this.cGS = i;
    }

    public void kp(int i) {
        this.cGT = i;
    }

    public boolean alQ() {
        return this.cGZ;
    }

    public boolean alR() {
        if (this.cDt == null) {
            return false;
        }
        return this.cDt.isValid();
    }

    public String sz() {
        if (this.cDt == null || !this.cDt.pN()) {
            return null;
        }
        return this.cDt.pM();
    }

    public boolean kq(int i) {
        this.cGV = i;
        if (this.cGV > this.cDt.getPage().rK()) {
            this.cGV = this.cDt.getPage().rK();
        }
        if (this.cGV < 1) {
            this.cGV = 1;
        }
        if (this.cGN == null) {
            return false;
        }
        return ku(5);
    }

    public boolean kr(int i) {
        int sN = this.cDt.akH().sN();
        if (i <= sN) {
            sN = i;
        }
        int i2 = sN >= 1 ? sN : 1;
        if (this.cGN == null) {
            return false;
        }
        this.cHp = i2;
        return ku(7);
    }

    public void ks(int i) {
        this.cGV = i;
        this.cGW = i;
        this.cGX = i;
    }

    public void kt(int i) {
        if (this.cGW < i) {
            this.cGW = i;
            if (this.cGW - this.cGX >= MAX_PAGE_NUM) {
                this.cGX = (this.cGW - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.cGX > i) {
            this.cGX = i;
            if (this.cGW - this.cGX >= MAX_PAGE_NUM) {
                this.cGW = (this.cGX + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        return this.cDt;
    }

    public com.baidu.tbadk.core.data.q VB() {
        if (this.cDt == null) {
            return null;
        }
        return this.cDt.getPage();
    }

    public boolean alS() {
        if (this.cGR) {
            if (this.cDt.getPage().rO() == 0) {
                fc(true);
                return true;
            }
        } else if (this.cDt.getPage().rP() == 0) {
            fd(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cGN == null) {
            return false;
        }
        cancelLoadData();
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("pbStat");
            this.aUT.start();
        }
        boolean ku = ku(3);
        if (this.opType != null) {
            this.opType = null;
            this.cHh = null;
            this.opUrl = null;
            return ku;
        }
        return ku;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.axY = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Kz();
    }

    private void Kz() {
        if (this.aUT != null) {
            this.aUT.destory();
            this.aUT = null;
        }
    }

    public boolean Dy() {
        return (this.cGO == null || this.cGO.equals("0") || this.cGO.length() == 0) ? LoadData() : alU();
    }

    public boolean ku(int i) {
        this.mRequestType = i;
        if (this.axY) {
            return false;
        }
        this.axY = true;
        kv(i);
        com.baidu.tieba.pb.a.c pbData = dd.amq().getPbData();
        if (pbData != null && pbData.akH() != null) {
            pbData.akH().bB(0);
            this.cGR = dd.amq().alM();
            this.cGP = dd.amq().ams();
            if (!this.cGR || this.cGP || this.isFromMark) {
                this.cHj = false;
            }
            com.baidu.adp.lib.h.h.hj().post(new cl(this, pbData));
            return false;
        }
        if (i == 4 && !this.cHl) {
            a(alZ(), true, this.cGO, 3);
        }
        if (i == 3 && !this.cHl) {
            if (this.isFromMark) {
                a(alZ(), true, this.cGO, 3);
            } else {
                a(alZ(), false, this.cGO, 3);
            }
        }
        this.cHl = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.art);
        if (!this.cGR || this.cGP || this.isFromMark) {
            this.cHj = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.cGN == null || this.cGN.length() == 0) {
            this.axY = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.cGN, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ay.va().vc() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.cGR) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.cGP) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.agB != null) {
            pbPageRequestMessage.set_st_type(this.agB);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.cHc) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cHb));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.cHj) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.cHh, 0));
            pbPageRequestMessage.setOpMessageID(this.cHb);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cHd));
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cDt.akI();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.cGR) {
                        if (this.cGX - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cGX - 1));
                        }
                    } else if (this.cGW < this.cGY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cGW + 1));
                    }
                }
                if (akI != null && akI.size() > 0) {
                    int size = akI.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.r rVar = akI.get(size - i3);
                        if (rVar == null) {
                            i3++;
                        } else {
                            this.cGO = rVar.getId();
                            if (StringUtils.isNull(this.cGO)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.cGO != null && this.cGO.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cGO, 0L));
                    break;
                } else if (!this.cGR) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (akI != null && akI.size() > 0 && akI.get(0) != null) {
                    this.cGO = akI.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.cGR) {
                        if (this.cGX - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cGX - 1));
                        }
                    } else if (this.cGW < this.cGY) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cGW + 1));
                    }
                }
                if (this.cGO != null && this.cGO.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cGO, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.cGR) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cGO, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.cGV));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cGO, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.cHp);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(alZ());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setIsSubPostDataReverse(this.cHo);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void kv(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cDt.akI();
        if (i == 1) {
            boolean z2 = false;
            while (akI.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                akI.remove(0);
                z2 = true;
            }
            if (z2) {
                this.cDt.getPage().bz(1);
                if (this.cHf != null) {
                    this.cHf.b(this.cDt);
                }
            }
        } else if (i == 2) {
            while (akI.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                akI.remove(akI.size() - 1);
                z = true;
            }
            if (z) {
                this.cDt.getPage().by(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.c cVar2 = z ? null : cVar;
        this.axY = false;
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
            if (this.cHe) {
                cVar = e(cVar);
            }
            d(cVar);
        }
    }

    protected void d(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            String f = f(cVar);
            for (int i = 0; i < cVar.akI().size(); i++) {
                com.baidu.tieba.tbadkCore.data.r rVar = cVar.akI().get(i);
                for (int i2 = 0; i2 < rVar.aFm().size(); i2++) {
                    rVar.aFm().get(i2).a(this.bbA.getPageContext().getUniqueId(), f.equals(rVar.aFm().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.c e(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.z akH = cVar.akH();
        akH.bD(this.cGS);
        akH.bC(this.cGT);
        if (this.cGU > 0) {
            akH.q(this.cGU);
            return cVar;
        }
        return cVar;
    }

    protected String f(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.akH() != null && cVar.akH().getAuthor() != null) {
            str = cVar.akH().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String g(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.akH() != null && cVar.akH().getAuthor() != null) {
            str = cVar.akH().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData alT() {
        if (this.cDt == null || this.cDt.akH() == null || this.cDt.akH().getAuthor() == null) {
            return null;
        }
        return this.cDt.akH().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aUT != null && !z3) {
            this.aUT.a(z2, z4, i2, str, i3, j, j2);
            this.aUT = null;
        }
        if (cVar == null) {
            if (this.cHf != null) {
                this.cGR = this.cGQ;
                this.cHf.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cGQ = this.cGR;
            this.cHc = false;
            if (cVar.getPage() != null) {
                kt(cVar.getPage().rM());
                this.cGY = cVar.getPage().rK();
            }
            this.cGY = this.cGY < 1 ? 1 : this.cGY;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cDt.akI();
            switch (i) {
                case 1:
                    this.cDt.a(cVar.getPage(), 1);
                    a(cVar, akI);
                    i4 = 0;
                    break;
                case 2:
                    if (cVar.akI() != null) {
                        int size = cVar.akI().size() + 1;
                        com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(akI, 0);
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(cVar.akI(), com.baidu.tbadk.core.util.y.l(cVar.akI()) - 1);
                        if (rVar == null || rVar2 == null || !rVar.getId().equals(rVar2.getId())) {
                            i5 = size;
                        } else {
                            cVar.akI().remove(rVar2);
                            i5 = size - 1;
                        }
                        akI.addAll(0, cVar.akI());
                    }
                    this.cDt.a(cVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.cGR && cVar.getPage() != null) {
                        cVar.getPage().bw(cVar.getPage().rK());
                    }
                    h(cVar);
                    i4 = 0;
                    break;
                case 4:
                    h(cVar);
                    i4 = 0;
                    break;
                case 5:
                    h(cVar);
                    i4 = 0;
                    break;
                case 6:
                    h(cVar);
                    i4 = 0;
                    break;
                case 7:
                    h(cVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.cDt != null && this.cDt.akH() != null) {
                PraiseData praise = this.cDt.akH().getPraise();
                if (this.cHr != null && !praise.isPriaseDataValid()) {
                    this.cDt.akH().setPraise(this.cHr);
                } else {
                    this.cHr = this.cDt.akH().getPraise();
                    this.cHr.setPostId(this.cDt.akH().sD());
                }
                if (cVar.getPage() != null && cVar.getPage().rM() == 1 && cVar.akH() != null && cVar.akH().sA() != null && cVar.akH().sA().size() > 0) {
                    this.cDt.akH().j(cVar.akH().sA());
                }
                this.cDt.akH().setReply_num(cVar.akH().getReply_num());
                this.cDt.akH().setAnchorLevel(cVar.akH().getAnchorLevel());
                this.cDt.akH().bB(cVar.akH().sq());
            }
            if (this.cDt != null && this.cDt.getUserData() != null && cVar.getUserData() != null) {
                this.cDt.getUserData().setBimg_end_time(cVar.getUserData().getBimg_end_time());
                this.cDt.getUserData().setBimg_url(cVar.getUserData().getBimg_url());
            }
            if (this.cHf != null) {
                this.cHf.a(true, getErrorCode(), i, i4, this.cDt, this.mErrorString, 1);
            }
        }
        if (this.cDt != null && this.cDt.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.cDt.getUserData().getIsMem())));
        }
        if (this.cDt != null && this.cDt.akH() != null && this.cDt.akG() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bbA;
            historyMessage.threadId = getPbData().akH().getId();
            historyMessage.forumName = getPbData().akG().getName();
            historyMessage.threadName = getPbData().akH().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = alM();
            historyMessage.threadType = getPbData().akH().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        String V;
        if (arrayList != null && cVar.akI() != null) {
            com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(cVar.akI(), 0);
            if (rVar != null && (V = V(arrayList)) != null && V.equals(rVar.getId())) {
                cVar.akI().remove(rVar);
            }
            arrayList.addAll(cVar.akI());
        }
    }

    private String V(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        int l = com.baidu.tbadk.core.util.y.l(arrayList);
        if (l <= 0) {
            return null;
        }
        for (int i = l - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.y.b(arrayList, i);
            if (rVar != null && !StringUtils.isNull(rVar.getId())) {
                return rVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.pb.a.c cVar) {
        this.cDt = cVar;
        ks(cVar.getPage().rM());
    }

    public boolean alU() {
        if (this.cGN == null || this.cGO == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return ku(4);
        }
        return ku(6);
    }

    public boolean fc(boolean z) {
        if (this.cGN == null || this.cDt == null) {
            return false;
        }
        if (z || this.cDt.getPage().rO() != 0) {
            return ku(1);
        }
        return false;
    }

    public boolean fd(boolean z) {
        if (this.cGN == null || this.cDt == null) {
            return false;
        }
        if ((z || this.cDt.getPage().rP() != 0) && this.cDt.akI() != null && this.cDt.akI().size() >= 1) {
            return ku(2);
        }
        return false;
    }

    public boolean kE(String str) {
        this.cGP = !this.cGP;
        this.cGO = str;
        ku(6);
        return true;
    }

    public boolean alV() {
        if (com.baidu.adp.lib.util.i.iQ()) {
            this.cGQ = this.cGR;
            this.cGR = !this.cGR;
        }
        return LoadData();
    }

    public boolean alW() {
        return this.cGR;
    }

    public boolean hasData() {
        return (this.cDt == null || this.cDt.akG() == null || this.cDt.akH() == null) ? false : true;
    }

    public boolean pN() {
        if (this.cDt == null) {
            return false;
        }
        return this.cDt.pN();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fp(String str) {
        if (this.cDt == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.cDt.akG().getId());
        writeData.setForumName(this.cDt.akG().getName());
        writeData.setThreadId(this.cGN);
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

    public MarkData kw(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.cDt == null || this.cDt.akI() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cDt.akI();
        if (akI.size() > 0 && i == akI.size()) {
            i = akI.size() - 1;
        }
        if (akI.size() <= 0 || i >= akI.size()) {
            return null;
        }
        return d(akI.get(i));
    }

    public MarkData alX() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cGN);
        markData.setPostId(this.cDt.pM());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cGP);
        markData.setSequence(Boolean.valueOf(this.cGR));
        markData.setId(this.cGN);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.r rVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cGN);
        markData.setPostId(rVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cGP);
        markData.setSequence(Boolean.valueOf(this.cGR));
        markData.setId(this.cGN);
        markData.setFloor(rVar.aFq());
        if (rVar instanceof com.baidu.tieba.pb.a.b) {
            markData.setApp(true);
        } else if (rVar instanceof com.baidu.tieba.tbadkCore.data.q) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.q) rVar).isApp());
        }
        return markData;
    }

    public void alY() {
        ca.alH().A(alZ(), this.isFromMark);
    }

    private String alZ() {
        String str = this.cGN;
        if (this.cGP) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cGR) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void fe(boolean z) {
        if (this.cDt != null) {
            this.cDt.Y(z);
        }
    }

    public void ff(boolean z) {
        this.cHj = z;
    }

    public boolean ama() {
        return this.cHj;
    }

    public void a(c cVar) {
        this.cHf = cVar;
    }

    public void ki(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BJ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BI() {
        return Dy();
    }

    public boolean kF(String str) {
        if (getPbData() == null || getPbData().akH() == null || getPbData().akH().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().akH().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void a(a aVar) {
        this.cFR = aVar;
    }

    public void kx(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.cGN);
        httpMessage.addParam("status", String.valueOf(i));
        sendMessage(httpMessage);
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public void a(b bVar) {
        this.cHg = bVar;
    }

    public void amb() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cHu);
    }

    public void bl(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        sendMessage(httpMessage);
    }

    public void amc() {
        String alZ = alZ();
        ca.alH().A(alZ, false);
        ca.alH().A(alZ, true);
    }

    public void amd() {
        if ("personalize_page".equals(this.agB)) {
            this.cHn = System.currentTimeMillis() / 1000;
        }
    }

    public void ame() {
        if ("personalize_page".equals(this.agB) && this.cDt != null && this.cHn != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10754").aa(ImageViewerConfig.FORUM_ID, this.cDt.getForumId()).aa("tid", this.cGN).aa("obj_duration", String.valueOf(currentTimeMillis - this.cHn)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.cHn = 0L;
        }
    }
}
