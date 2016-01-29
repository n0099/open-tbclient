package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
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
public class cm extends com.baidu.tbadk.editortools.d.a {
    private static final int cOr = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    public static int cPa = 1;
    private CustomMessageListener aLW;
    private com.baidu.tieba.tbadkCore.d.b aXf;
    private long aXg;
    private long aXh;
    private long aXi;
    private long aXj;
    private String ahp;
    private boolean ayQ;
    private BaseActivity bdK;
    protected com.baidu.tieba.pb.a.c cKn;
    private a cNp;
    private int cOA;
    private int cOB;
    private int cOC;
    private int cOD;
    private boolean cOE;
    private boolean cOF;
    private boolean cOG;
    private long cOH;
    private boolean cOI;
    private int cOJ;
    private boolean cOK;
    private c cOL;
    private b cOM;
    private String cON;
    private String cOO;
    private int cOP;
    private int cOQ;
    private boolean cOR;
    private boolean cOS;
    private boolean cOT;
    private String cOU;
    private long cOV;
    private boolean cOW;
    private int cOX;
    private boolean cOY;
    private PraiseData cOZ;
    protected String cOs;
    private String cOt;
    private boolean cOu;
    private boolean cOv;
    private boolean cOw;
    private int cOx;
    private int cOy;
    private long cOz;
    protected final HttpMessageListener cPb;
    private final HttpMessageListener cPc;
    private com.baidu.adp.framework.listener.a crx;
    private boolean isAd;
    private boolean isFromMark;
    protected Context mContext;
    private String mForumName;
    private String mLocate;
    private int mRequestType;
    protected int mThreadType;
    private String opType;
    private String opUrl;
    private String postID;

    /* loaded from: classes.dex */
    public interface a {
        void g(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void h(int i, long j);

        void onError(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4);

        void c(com.baidu.tieba.pb.a.c cVar);

        void e(com.baidu.tbadk.performanceLog.v vVar);

        void fo(boolean z);
    }

    public String apL() {
        return this.cOU;
    }

    public void kI(String str) {
        this.cOU = str;
    }

    public void fq(boolean z) {
        this.cOW = z;
    }

    public cm(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahp = null;
        this.cOs = null;
        this.cOt = null;
        this.cOu = false;
        this.cOv = true;
        this.cOw = true;
        this.cOx = 0;
        this.cOy = 0;
        this.cOz = 0L;
        this.cOA = 1;
        this.cOB = 1;
        this.cOC = 1;
        this.cOD = 1;
        this.isAd = false;
        this.cOE = false;
        this.cOF = false;
        this.isFromMark = false;
        this.cOG = false;
        this.cOH = 0L;
        this.cOI = false;
        this.mForumName = null;
        this.cKn = null;
        this.ayQ = false;
        this.cOK = false;
        this.mLocate = null;
        this.mContext = null;
        this.cOL = null;
        this.cOM = null;
        this.aXg = 0L;
        this.aXh = 0L;
        this.aXi = 0L;
        this.aXj = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cON = null;
        this.cOO = null;
        this.cOP = -1;
        this.cOQ = -1;
        this.aXf = null;
        this.cOS = false;
        this.postID = null;
        this.cOU = null;
        this.cOV = 0L;
        this.cOW = false;
        this.cOX = -1;
        this.aLW = new cn(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.crx = new cp(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cOZ = null;
        this.cNp = null;
        this.cPb = new cq(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.cPc = new cr(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        registerListener(this.aLW);
        registerListener(this.crx);
        registerListener(this.cPb);
        this.cKn = new com.baidu.tieba.pb.a.c();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bdK = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int apM() {
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
        this.cOs = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.cOs)) {
            this.cOs = T(intent);
        }
        this.cOt = intent.getStringExtra("post_id");
        this.cOu = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cOw = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahp = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.cOx = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cOy = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cOz = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.cOF = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.cOG = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.cOE = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cOI = intent.getBooleanExtra("is_pv", false);
        this.cOH = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cOO = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cON = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.cOK = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.cOQ = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.cOP = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    private String T(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.cOs = bundle.getString("thread_id");
        this.cOt = bundle.getString("post_id");
        this.cOu = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cOw = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahp = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.cOx = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cOy = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cOz = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.cOF = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.cOG = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.cOE = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cOI = bundle.getBoolean("is_pv", false);
        this.cOH = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cOO = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.cOK = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.cOQ = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.cOP = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void m(Bundle bundle) {
        bundle.putString("thread_id", this.cOs);
        bundle.putString("post_id", this.cOt);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cOu);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cOw);
        bundle.putString("st_type", this.ahp);
        bundle.putString("locate", this.mLocate);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cOx);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cOy);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cOz);
        bundle.putBoolean("from_frs", this.cOF);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.cOG);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.cOE);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cOI);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cOH);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cOO);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.cOK);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.cOQ);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.cOP);
    }

    public String apN() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cOs);
        if (!this.cOG) {
            sb.append(this.cOt);
        }
        sb.append(this.cOu);
        sb.append(this.cOw);
        sb.append(this.ahp);
        sb.append(this.cOx);
        sb.append(this.cOy);
        sb.append(this.cOz);
        sb.append(this.cOF);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.cOE);
        sb.append(this.cOI);
        sb.append(this.cOH);
        sb.append(this.mForumName);
        sb.append(this.mThreadType);
        sb.append(this.cOK);
        if (this.cOO != null) {
            sb.append(this.cOO);
        }
        return sb.toString();
    }

    public String apO() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.cOt;
    }

    public void kJ(String str) {
        this.cOt = str;
    }

    public String getThreadID() {
        return this.cOs;
    }

    public boolean getHostMode() {
        return this.cOu;
    }

    public boolean apP() {
        return this.cOw;
    }

    public boolean apQ() {
        return this.cOF;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean apR() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.ahp);
    }

    public int getIsGood() {
        return this.cOx;
    }

    public int apS() {
        return this.cOy;
    }

    public void setIsGood(int i) {
        this.cOx = i;
    }

    public void kP(int i) {
        this.cOy = i;
    }

    public boolean apT() {
        return this.cOE;
    }

    public boolean apU() {
        if (this.cKn == null) {
            return false;
        }
        return this.cKn.isValid();
    }

    public String ts() {
        if (this.cKn == null || !this.cKn.qg()) {
            return null;
        }
        return this.cKn.qf();
    }

    public boolean kQ(int i) {
        this.cOA = i;
        if (this.cOA > this.cKn.getPage().sq()) {
            this.cOA = this.cKn.getPage().sq();
        }
        if (this.cOA < 1) {
            this.cOA = 1;
        }
        if (this.cOs == null) {
            return false;
        }
        return kU(5);
    }

    public boolean kR(int i) {
        int tK = this.cKn.aoF().tK();
        if (i <= tK) {
            tK = i;
        }
        int i2 = tK >= 1 ? tK : 1;
        if (this.cOs == null) {
            return false;
        }
        this.cOX = i2;
        return kU(7);
    }

    public void kS(int i) {
        this.cOA = i;
        this.cOB = i;
        this.cOC = i;
    }

    public void kT(int i) {
        if (this.cOB < i) {
            this.cOB = i;
            if (this.cOB - this.cOC >= cOr) {
                this.cOC = (this.cOB - cOr) + 1;
            }
        }
        if (this.cOC > i) {
            this.cOC = i;
            if (this.cOB - this.cOC >= cOr) {
                this.cOB = (this.cOC + cOr) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        return this.cKn;
    }

    public com.baidu.tbadk.core.data.u XU() {
        if (this.cKn == null) {
            return null;
        }
        return this.cKn.getPage();
    }

    public boolean apV() {
        if (this.cOw) {
            if (this.cKn.getPage().sv() == 0) {
                fr(true);
                return true;
            }
        } else if (this.cKn.getPage().sw() == 0) {
            fs(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cOs == null) {
            return false;
        }
        cancelLoadData();
        if (this.aXf == null) {
            this.aXf = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.aXf.start();
        }
        boolean kU = kU(3);
        if (this.opType != null) {
            this.opType = null;
            this.cON = null;
            this.opUrl = null;
            return kU;
        }
        return kU;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.ayQ = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Mq();
    }

    private void Mq() {
        if (this.aXf != null) {
            this.aXf.destory();
            this.aXf = null;
        }
    }

    public boolean ET() {
        return (this.cOt == null || this.cOt.equals("0") || this.cOt.length() == 0) ? LoadData() : apX();
    }

    public boolean kU(int i) {
        this.mRequestType = i;
        if (this.ayQ) {
            return false;
        }
        this.ayQ = true;
        kV(i);
        com.baidu.tieba.pb.a.c pbData = ds.aqK().getPbData();
        if (pbData != null && pbData.aoF() != null) {
            pbData.aoF().bT(0);
            this.cOw = ds.aqK().apP();
            this.cOu = ds.aqK().aqM();
            if (!this.cOw || this.cOu || this.isFromMark) {
                this.cOR = false;
            }
            com.baidu.adp.lib.h.h.hr().post(new cs(this, pbData));
            return false;
        }
        if (i == 4 && !this.cOT) {
            a(aqc(), true, this.cOt, 3);
        }
        if (i == 3 && !this.cOT) {
            if (this.isFromMark) {
                a(aqc(), true, this.cOt, 3);
            } else {
                a(aqc(), false, this.cOt, 3);
            }
        }
        this.cOT = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asm);
        if (!this.cOw || this.cOu || this.isFromMark) {
            this.cOR = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.cOs == null || this.cOs.length() == 0) {
            this.ayQ = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.cOs, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ax.wg().wi() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.cOw) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.cOu) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahp != null) {
            pbPageRequestMessage.set_st_type(this.ahp);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.cOI) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cOH));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.cOR) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.cON, 0));
            pbPageRequestMessage.setOpMessageID(this.cOH);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cKn.aoG();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.cOw) {
                        if (this.cOC - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cOC - 1));
                        }
                    } else if (this.cOB < this.cOD) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cOB + 1));
                    }
                }
                if (aoG != null && aoG.size() > 0) {
                    int size = aoG.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.r rVar = aoG.get(size - i3);
                        if (rVar == null) {
                            i3++;
                        } else {
                            this.cOt = rVar.getId();
                            if (StringUtils.isNull(this.cOt)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.cOt != null && this.cOt.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cOt, 0L));
                    break;
                } else if (!this.cOw) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (aoG != null && aoG.size() > 0 && aoG.get(0) != null) {
                    this.cOt = aoG.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.cOw) {
                        if (this.cOC - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cOC - 1));
                        }
                    } else if (this.cOB < this.cOD) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cOB + 1));
                    }
                }
                if (this.cOt != null && this.cOt.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cOt, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.cOw) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cOt, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.cOA));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cOt, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.cOX);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(aqc());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setIsSubPostDataReverse(this.cOW);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void kV(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cKn.aoG();
        if (i == 1) {
            boolean z2 = false;
            while (aoG.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aoG.remove(0);
                z2 = true;
            }
            if (z2) {
                this.cKn.getPage().bQ(1);
                if (this.cOL != null) {
                    this.cOL.c(this.cKn);
                }
            }
        } else if (i == 2) {
            while (aoG.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aoG.remove(aoG.size() - 1);
                z = true;
            }
            if (z) {
                this.cKn.getPage().bP(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.c cVar2 = z ? null : cVar;
        this.ayQ = false;
        if (cVar2 != null) {
            d(cVar2);
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
    public void d(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            if (this.cOK) {
                cVar = f(cVar);
            }
            e(cVar);
        }
    }

    protected void e(com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null) {
            String g = g(cVar);
            for (int i = 0; i < cVar.aoG().size(); i++) {
                com.baidu.tieba.tbadkCore.data.r rVar = cVar.aoG().get(i);
                for (int i2 = 0; i2 < rVar.aMs().size(); i2++) {
                    rVar.aMs().get(i2).a(this.bdK.getPageContext().getUniqueId(), g.equals(rVar.aMs().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.c f(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.ah aoF = cVar.aoF();
        aoF.bV(this.cOx);
        aoF.bU(this.cOy);
        if (this.cOz > 0) {
            aoF.r(this.cOz);
            return cVar;
        }
        return cVar;
    }

    protected String g(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.aoF() != null && cVar.aoF().getAuthor() != null) {
            str = cVar.aoF().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.aoF() != null && cVar.aoF().getAuthor() != null) {
            str = cVar.aoF().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData apW() {
        if (this.cKn == null || this.cKn.aoF() == null || this.cKn.aoF().getAuthor() == null) {
            return null;
        }
        return this.cKn.aoF().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.cOY = z3;
        this.cOJ = i;
        if (this.aXf != null && !z3) {
            this.aXf.a(z2, z4, i2, str, i3, j, j2);
            this.aXf = null;
        }
        if (cVar == null) {
            if (this.cOL != null) {
                this.cOw = this.cOv;
                this.cOL.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cOv = this.cOw;
            this.cOI = false;
            if (cVar.getPage() != null) {
                kT(cVar.getPage().st());
                this.cOD = cVar.getPage().sq();
            }
            this.cOD = this.cOD < 1 ? 1 : this.cOD;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cKn.aoG();
            switch (i) {
                case 1:
                    this.cKn.a(cVar.getPage(), 1);
                    a(cVar, aoG);
                    i4 = 0;
                    break;
                case 2:
                    if (cVar.aoG() != null) {
                        int size = cVar.aoG().size() + 1;
                        com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(aoG, 0);
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(cVar.aoG(), com.baidu.tbadk.core.util.x.o(cVar.aoG()) - 1);
                        if (rVar == null || rVar2 == null || !rVar.getId().equals(rVar2.getId())) {
                            i5 = size;
                        } else {
                            cVar.aoG().remove(rVar2);
                            i5 = size - 1;
                        }
                        aoG.addAll(0, cVar.aoG());
                    }
                    this.cKn.a(cVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.cOw && cVar.getPage() != null) {
                        cVar.getPage().bN(cVar.getPage().sq());
                    }
                    i(cVar);
                    i4 = 0;
                    break;
                case 4:
                    i(cVar);
                    i4 = 0;
                    break;
                case 5:
                    i(cVar);
                    i4 = 0;
                    break;
                case 6:
                    i(cVar);
                    i4 = 0;
                    break;
                case 7:
                    i(cVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.cKn != null && this.cKn.aoF() != null) {
                PraiseData praise = this.cKn.aoF().getPraise();
                if (this.cOZ != null && !praise.isPriaseDataValid()) {
                    this.cKn.aoF().setPraise(this.cOZ);
                } else {
                    this.cOZ = this.cKn.aoF().getPraise();
                    this.cOZ.setPostId(this.cKn.aoF().ty());
                }
                if (cVar.getPage() != null && cVar.getPage().st() == 1 && cVar.aoF() != null && cVar.aoF().tt() != null && cVar.aoF().tt().size() > 0) {
                    this.cKn.aoF().k(cVar.aoF().tt());
                }
                this.cKn.aoF().setReply_num(cVar.aoF().getReply_num());
                this.cKn.aoF().setAnchorLevel(cVar.aoF().getAnchorLevel());
                this.cKn.aoF().bT(cVar.aoF().tj());
            }
            if (this.cKn != null && this.cKn.getUserData() != null && cVar.getUserData() != null) {
                this.cKn.getUserData().setBimg_end_time(cVar.getUserData().getBimg_end_time());
                this.cKn.getUserData().setBimg_url(cVar.getUserData().getBimg_url());
            }
            if (this.cOY && this.cKn.aoF() != null && this.cKn.aoF().getAuthor() != null && this.cKn.aoG() != null && com.baidu.tbadk.core.util.x.b(this.cKn.aoG(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(this.cKn.aoG(), 0);
                MetaData author = this.cKn.aoF().getAuthor();
                if (rVar3.getAuthor() != null && rVar3.getAuthor().getGodUserData() != null) {
                    if (this.cOP != -1) {
                        author.setFansNum(this.cOP);
                        rVar3.getAuthor().setFansNum(this.cOP);
                    }
                    if (this.cOQ != -1) {
                        author.getGodUserData().setFollowed(this.cOQ);
                        rVar3.getAuthor().getGodUserData().setFollowed(this.cOQ);
                    }
                }
            }
            if (this.cOL != null) {
                this.cOL.a(true, getErrorCode(), i, i4, this.cKn, this.mErrorString, 1);
            }
        }
        if (this.cKn != null && this.cKn.aoF() != null && this.cKn.aoE() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bdK;
            historyMessage.threadId = getPbData().aoF().getId();
            historyMessage.forumName = getPbData().aoE().getName();
            historyMessage.threadName = getPbData().aoF().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = apP();
            historyMessage.threadType = getPbData().aoF().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        String W;
        if (arrayList != null && cVar.aoG() != null) {
            com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(cVar.aoG(), 0);
            if (rVar != null && (W = W(arrayList)) != null && W.equals(rVar.getId())) {
                cVar.aoG().remove(rVar);
            }
            arrayList.addAll(cVar.aoG());
        }
    }

    private String W(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        int o = com.baidu.tbadk.core.util.x.o(arrayList);
        if (o <= 0) {
            return null;
        }
        for (int i = o - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.r rVar = (com.baidu.tieba.tbadkCore.data.r) com.baidu.tbadk.core.util.x.b(arrayList, i);
            if (rVar != null && !StringUtils.isNull(rVar.getId())) {
                return rVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.a.c cVar) {
        this.cKn = cVar;
        kS(cVar.getPage().st());
    }

    public boolean apX() {
        if (this.cOs == null || this.cOt == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return kU(4);
        }
        return kU(6);
    }

    public boolean fr(boolean z) {
        if (this.cOs == null || this.cKn == null) {
            return false;
        }
        if (z || this.cKn.getPage().sv() != 0) {
            return kU(1);
        }
        return false;
    }

    public boolean fs(boolean z) {
        if (this.cOs == null || this.cKn == null) {
            return false;
        }
        if ((z || this.cKn.getPage().sw() != 0) && this.cKn.aoG() != null && this.cKn.aoG().size() >= 1) {
            return kU(2);
        }
        return false;
    }

    public boolean kK(String str) {
        this.cOu = !this.cOu;
        this.cOt = str;
        kU(6);
        return true;
    }

    public boolean apY() {
        if (com.baidu.adp.lib.util.i.iZ()) {
            this.cOv = this.cOw;
            this.cOw = !this.cOw;
        }
        return LoadData();
    }

    public boolean apZ() {
        return this.cOw;
    }

    public boolean hasData() {
        return (this.cKn == null || this.cKn.aoE() == null || this.cKn.aoF() == null) ? false : true;
    }

    public boolean qg() {
        if (this.cKn == null) {
            return false;
        }
        return this.cKn.qg();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fn(String str) {
        if (this.cKn == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.cKn.aoE().getId());
        writeData.setForumName(this.cKn.aoE().getName());
        writeData.setThreadId(this.cOs);
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

    public MarkData kW(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.cKn == null || this.cKn.aoG() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cKn.aoG();
        if (aoG.size() > 0 && i == aoG.size()) {
            i = aoG.size() - 1;
        }
        if (aoG.size() <= 0 || i >= aoG.size()) {
            return null;
        }
        return e(aoG.get(i));
    }

    public MarkData aqa() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cOs);
        markData.setPostId(this.cKn.qf());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cOu);
        markData.setSequence(Boolean.valueOf(this.cOw));
        markData.setId(this.cOs);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.r rVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cOs);
        markData.setPostId(rVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cOu);
        markData.setSequence(Boolean.valueOf(this.cOw));
        markData.setId(this.cOs);
        markData.setFloor(rVar.aMw());
        if (rVar instanceof com.baidu.tieba.pb.a.b) {
            markData.setApp(true);
        } else if (rVar instanceof com.baidu.tieba.tbadkCore.data.q) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.q) rVar).isApp());
        }
        return markData;
    }

    public void aqb() {
        ch.apK().A(aqc(), this.isFromMark);
    }

    private String aqc() {
        String str = this.cOs;
        if (this.cOu) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cOw) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ft(boolean z) {
        if (this.cKn != null) {
            this.cKn.Y(z);
        }
    }

    public void fu(boolean z) {
        this.cOR = z;
    }

    public boolean aqd() {
        return this.cOR;
    }

    public void a(c cVar) {
        this.cOL = cVar;
    }

    public void kn(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String CZ() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean CY() {
        return ET();
    }

    public boolean kL(String str) {
        if (getPbData() == null || getPbData().aoF() == null || getPbData().aoF().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aoF().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void a(a aVar) {
        this.cNp = aVar;
    }

    public void kX(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.cOs);
        httpMessage.addParam("status", String.valueOf(i));
        sendMessage(httpMessage);
    }

    public int aqe() {
        return this.mRequestType;
    }

    public void a(b bVar) {
        this.cOM = bVar;
    }

    public void aqf() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cPc);
    }

    public void bn(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        sendMessage(httpMessage);
    }

    public void aqg() {
        String aqc = aqc();
        ch.apK().A(aqc, false);
        ch.apK().A(aqc, true);
    }

    public void aqh() {
        if ("personalize_page".equals(this.ahp)) {
            this.cOV = System.currentTimeMillis() / 1000;
        }
    }

    public void aqi() {
        if ("personalize_page".equals(this.ahp) && this.cKn != null && this.cOV != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10754").aa(ImageViewerConfig.FORUM_ID, this.cKn.getForumId()).aa("tid", this.cOs).aa("obj_duration", String.valueOf(currentTimeMillis - this.cOV)).aa("obj_param3", String.valueOf(currentTimeMillis)));
            this.cOV = 0L;
        }
    }

    public boolean aqj() {
        return this.cOY;
    }

    public int aqk() {
        return this.cOJ;
    }
}
