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
public class df extends com.baidu.tbadk.editortools.d.a {
    private static final int diC = com.baidu.tbadk.data.c.getPbListItemMaxNum() / 30;
    public static int djr = 1;
    private CustomMessageListener aOR;
    private String ahu;
    private boolean azx;
    private com.baidu.tieba.tbadkCore.d.b bbO;
    private long bbP;
    private long bbQ;
    private long bbR;
    private long bbS;
    private BaseActivity bix;
    private long btk;
    private com.baidu.adp.framework.listener.a cBX;
    protected com.baidu.tieba.pb.data.e ddF;
    private a dho;
    protected String diD;
    private String diE;
    private boolean diF;
    private boolean diG;
    private boolean diH;
    private int diI;
    private int diJ;
    private long diK;
    private int diL;
    private int diM;
    private int diN;
    private int diO;
    private boolean diP;
    private boolean diQ;
    private boolean diR;
    private long diS;
    private boolean diT;
    private String diU;
    private int diV;
    private boolean diW;
    private c diX;
    private b diY;
    private String diZ;
    private String dja;
    private int djb;
    private int djc;
    private boolean djd;
    private boolean dje;
    private boolean djf;
    private boolean djg;
    private boolean djh;
    private String dji;
    private long djj;
    private boolean djk;
    private int djl;
    private boolean djm;
    private int djn;
    private final dc djo;
    private CustomMessageListener djp;
    private PraiseData djq;
    protected final HttpMessageListener djs;
    private final HttpMessageListener djt;
    private boolean isAd;
    private boolean isFromMark;
    private com.baidu.tieba.pb.data.d mAppealInfo;
    protected Context mContext;
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
        void i(int i, long j);

        void onError(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4);

        void c(com.baidu.tieba.pb.data.e eVar);

        void d(com.baidu.tbadk.performanceLog.v vVar);
    }

    public String axa() {
        return this.dji;
    }

    public void lV(String str) {
        this.dji = str;
    }

    public void ga(boolean z) {
        this.djk = z;
    }

    public df(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.ahu = null;
        this.diD = null;
        this.diE = null;
        this.diF = false;
        this.diG = true;
        this.diH = true;
        this.diI = 0;
        this.diJ = 0;
        this.diK = 0L;
        this.diL = 1;
        this.diM = 1;
        this.diN = 1;
        this.diO = 1;
        this.isAd = false;
        this.diP = false;
        this.diQ = false;
        this.isFromMark = false;
        this.diR = false;
        this.diS = 0L;
        this.diT = false;
        this.diU = null;
        this.ddF = null;
        this.azx = false;
        this.diW = false;
        this.mLocate = null;
        this.mContext = null;
        this.diX = null;
        this.diY = null;
        this.bbP = 0L;
        this.bbQ = 0L;
        this.bbR = 0L;
        this.bbS = 0L;
        this.opType = null;
        this.opUrl = null;
        this.diZ = null;
        this.dja = null;
        this.djb = -1;
        this.djc = -1;
        this.bbO = null;
        this.dje = false;
        this.djf = false;
        this.postID = null;
        this.dji = null;
        this.djj = 0L;
        this.djk = false;
        this.djl = -1;
        this.aOR = new dg(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.djp = new di(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
        this.cBX = new dj(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.djq = null;
        this.dho = null;
        this.djs = new dk(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        this.djt = new dl(this, CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        registerListener(this.aOR);
        registerListener(this.cBX);
        registerListener(this.djs);
        registerListener(this.djp);
        this.ddF = new com.baidu.tieba.pb.data.e();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bix = baseActivity;
        this.djo = new dc(this, this.bix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int axb() {
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
        this.diD = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.diD)) {
            this.diD = r(intent);
        }
        this.diE = intent.getStringExtra("post_id");
        this.diF = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.diH = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.ahu = intent.getStringExtra("st_type");
        this.mLocate = intent.getStringExtra("locate");
        this.diI = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.diJ = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.diK = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.diQ = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.diR = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.diP = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.diT = intent.getBooleanExtra("is_pv", false);
        this.diS = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.diU = intent.getStringExtra("forum_name");
        this.dja = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.diZ = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
        this.diW = intent.getBooleanExtra(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.djc = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.djb = intent.getIntExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    private String r(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.diD = bundle.getString("thread_id");
        this.diE = bundle.getString("post_id");
        this.diF = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.diH = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.ahu = bundle.getString("st_type");
        this.mLocate = bundle.getString("locate");
        this.diI = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.diJ = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.diK = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.diQ = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.diR = bundle.getBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.diP = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.diT = bundle.getBoolean("is_pv", false);
        this.diS = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.diU = bundle.getString("forum_name");
        this.dja = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.diW = bundle.getBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, false);
        this.djc = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, -1);
        this.djb = bundle.getInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, -1);
    }

    public void o(Bundle bundle) {
        bundle.putString("thread_id", this.diD);
        bundle.putString("post_id", this.diE);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.diF);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.diH);
        bundle.putString("st_type", this.ahu);
        bundle.putString("locate", this.mLocate);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.diI);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.diJ);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.diK);
        bundle.putBoolean("from_frs", this.diQ);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_PB_KEY_NEED_POSTID, this.diR);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.diP);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.diT);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.diS);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.dja);
        bundle.putInt("thread_type", this.mThreadType);
        bundle.putBoolean(PbActivityConfig.KEY_IS_FROM_THREAD_CONFIG, this.diW);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, this.djc);
        bundle.putInt(PbActivityConfig.KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, this.djb);
    }

    public String axc() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.diD);
        if (!this.diR) {
            sb.append(this.diE);
        }
        sb.append(this.diF);
        sb.append(this.diH);
        sb.append(this.ahu);
        sb.append(this.diI);
        sb.append(this.diJ);
        sb.append(this.diK);
        sb.append(this.diQ);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.diP);
        sb.append(this.diT);
        sb.append(this.diS);
        sb.append(this.diU);
        sb.append(this.mThreadType);
        sb.append(this.diW);
        if (this.dja != null) {
            sb.append(this.dja);
        }
        return sb.toString();
    }

    public String axd() {
        return this.diU;
    }

    public String getPostId() {
        return this.diE;
    }

    public void lW(String str) {
        this.diE = str;
    }

    public String getThreadID() {
        return this.diD;
    }

    public boolean getHostMode() {
        return this.diF;
    }

    public boolean axe() {
        return this.diH;
    }

    public boolean axf() {
        return this.diQ;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean axg() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.ahu);
    }

    public int getIsGood() {
        return this.diI;
    }

    public int axh() {
        return this.diJ;
    }

    public void setIsGood(int i) {
        this.diI = i;
    }

    public void lX(int i) {
        this.diJ = i;
    }

    public boolean axi() {
        return this.diP;
    }

    public boolean axj() {
        if (this.ddF == null) {
            return false;
        }
        return this.ddF.isValid();
    }

    public String tv() {
        if (this.ddF == null || !this.ddF.pu()) {
            return null;
        }
        return this.ddF.ps();
    }

    public boolean lY(int i) {
        this.diL = i;
        if (this.diL > this.ddF.getPage().sl()) {
            this.diL = this.ddF.getPage().sl();
        }
        if (this.diL < 1) {
            this.diL = 1;
        }
        if (this.diD == null) {
            return false;
        }
        return mc(5);
    }

    public boolean lZ(int i) {
        int tQ = this.ddF.avv().tQ();
        if (i <= tQ) {
            tQ = i;
        }
        int i2 = tQ >= 1 ? tQ : 1;
        if (this.diD == null) {
            return false;
        }
        this.djl = i2;
        return mc(7);
    }

    public void ma(int i) {
        this.diL = i;
        this.diM = i;
        this.diN = i;
    }

    public void mb(int i) {
        if (this.diM < i) {
            this.diM = i;
            if (this.diM - this.diN >= diC) {
                this.diN = (this.diM - diC) + 1;
            }
        }
        if (this.diN > i) {
            this.diN = i;
            if (this.diM - this.diN >= diC) {
                this.diM = (this.diN + diC) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.ddF;
    }

    public com.baidu.tbadk.core.data.ac abt() {
        if (this.ddF == null) {
            return null;
        }
        return this.ddF.getPage();
    }

    public boolean axk() {
        if (this.diH) {
            if (this.ddF.getPage().sq() == 0) {
                gb(true);
                return true;
            }
        } else if (this.ddF.getPage().sr() == 0) {
            gc(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.diD == null) {
            return false;
        }
        cancelLoadData();
        if (this.bbO == null) {
            this.bbO = new com.baidu.tieba.tbadkCore.d.b("pbStat");
            this.bbO.start();
        }
        boolean mc = mc(3);
        if (this.opType != null) {
            this.opType = null;
            this.diZ = null;
            this.opUrl = null;
            return mc;
        }
        return mc;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.azx = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Oe();
    }

    private void Oe() {
        if (this.bbO != null) {
            this.bbO.destory();
            this.bbO = null;
        }
    }

    public boolean FG() {
        return (this.diE == null || this.diE.equals("0") || this.diE.length() == 0) ? LoadData() : axm();
    }

    public boolean mc(int i) {
        this.mRequestType = i;
        if (this.azx) {
            return false;
        }
        this.azx = true;
        md(i);
        com.baidu.tieba.pb.data.e pbData = en.aya().getPbData();
        if (pbData != null && pbData.avv() != null) {
            pbData.avv().bV(0);
            this.diH = en.aya().axe();
            this.diF = en.aya().ayc();
            if (!this.diH || this.diF || this.isFromMark) {
                this.djd = false;
            }
            com.baidu.adp.lib.h.h.hx().post(new dm(this, pbData));
            return false;
        }
        if (i == 4 && !this.djh) {
            a(axr(), true, this.diE, 3);
        }
        if (i == 3 && !this.djh) {
            if (this.isFromMark) {
                a(axr(), true, this.diE, 3);
            } else {
                a(axr(), false, this.diE, 3);
            }
        }
        this.djh = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asE);
        if (!this.diH || this.diF || this.isFromMark) {
            this.djd = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.diD == null || this.diD.length() == 0) {
            this.azx = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.diD, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp());
        int C = com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.az.wz().wB() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(C));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.diH) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.diF) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.ahu != null) {
            pbPageRequestMessage.set_st_type(this.ahu);
        }
        if (this.mLocate != null) {
            pbPageRequestMessage.setLocate(this.mLocate);
        }
        if (this.diT) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.diS));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.djd) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.diZ, 0));
            pbPageRequestMessage.setOpMessageID(this.diS);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.mThreadType));
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddF.avw();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.diH) {
                        if (this.diN - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.diN - 1));
                        }
                    } else if (this.diM < this.diO) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.diM + 1));
                    }
                }
                if (avw != null && avw.size() > 0) {
                    int size = avw.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.s sVar = avw.get(size - i3);
                        if (sVar == null) {
                            i3++;
                        } else {
                            this.diE = sVar.getId();
                            if (StringUtils.isNull(this.diE)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.diE != null && this.diE.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.diE, 0L));
                    break;
                } else if (!this.diH) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (avw != null && avw.size() > 0 && avw.get(0) != null) {
                    this.diE = avw.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.diH) {
                        if (this.diN - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.diN - 1));
                        }
                    } else if (this.diM < this.diO) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.diM + 1));
                    }
                }
                if (this.diE != null && this.diE.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.diE, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.diH) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.diE, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.diL));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.diE, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.djl);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(axr());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setIsSubPostDataReverse(this.djk);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void md(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddF.avw();
        this.djg = false;
        if (i == 1) {
            boolean z2 = false;
            while (avw.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                avw.remove(0);
                z2 = true;
            }
            if (z2) {
                this.ddF.getPage().bS(1);
                if (this.diX != null) {
                    this.diX.c(this.ddF);
                }
            }
            this.btk = System.currentTimeMillis();
            this.djg = true;
        } else if (i == 2) {
            while (avw.size() + 30 > com.baidu.tbadk.data.c.getPbListItemMaxNum()) {
                avw.remove(avw.size() - 1);
                z = true;
            }
            if (z) {
                this.ddF.getPage().bR(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.djn = i2;
        this.azx = false;
        if (eVar2 != null) {
            d(eVar2);
        }
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        int downSize = pbpagesocketresponsemessage.getDownSize();
        long costTime = pbpagesocketresponsemessage.getCostTime();
        if (pbpagesocketresponsemessage.getError() == 4) {
            this.mAppealInfo = pbpagesocketresponsemessage.getAppealInfo();
        }
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        int downSize = pbpagehttpresponsemessage.getDownSize();
        long costTime = pbpagehttpresponsemessage.getCostTime();
        if (pbpagehttpresponsemessage.getError() == 4) {
            this.mAppealInfo = pbpagehttpresponsemessage.getAppealInfo();
        }
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (this.diW) {
                eVar = f(eVar);
            }
            e(eVar);
        }
    }

    protected void e(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            String g = g(eVar);
            for (int i = 0; i < eVar.avw().size(); i++) {
                com.baidu.tieba.tbadkCore.data.s sVar = eVar.avw().get(i);
                for (int i2 = 0; i2 < sVar.aTo().size(); i2++) {
                    sVar.aTo().get(i2).b(this.bix.getPageContext(), g.equals(sVar.aTo().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.data.e f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.as avv = eVar.avv();
        avv.bX(this.diI);
        avv.bW(this.diJ);
        if (this.diK > 0) {
            avv.s(this.diK);
            return eVar;
        }
        return eVar;
    }

    protected String g(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.avv() != null && eVar.avv().getAuthor() != null) {
            str = eVar.avv().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String h(com.baidu.tieba.pb.data.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.avv() != null && eVar.avv().getAuthor() != null) {
            str = eVar.avv().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData axl() {
        if (this.ddF == null || this.ddF.avv() == null || this.ddF.avv().getAuthor() == null) {
            return null;
        }
        return this.ddF.avv().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        this.djm = z3;
        this.diV = i;
        if (this.bbO != null && !z3) {
            this.bbO.a(z2, z4, i2, str, i3, j, j2);
            this.bbO = null;
        }
        if (eVar == null || (this.diL == 1 && i == 5 && eVar.avw() != null && eVar.avw().size() < 1)) {
            if (this.diX != null) {
                this.diH = this.diG;
                this.diX.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.diG = this.diH;
            this.diT = false;
            if (eVar.getPage() != null) {
                mb(eVar.getPage().so());
                this.diO = eVar.getPage().sl();
            }
            this.diO = this.diO < 1 ? 1 : this.diO;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddF.avw();
            switch (i) {
                case 1:
                    this.ddF.a(eVar.getPage(), 1);
                    a(eVar, avw);
                    i4 = 0;
                    break;
                case 2:
                    if (eVar.avw() != null) {
                        int size = eVar.avw().size() + 1;
                        com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(avw, 0);
                        com.baidu.tieba.tbadkCore.data.s sVar2 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(eVar.avw(), com.baidu.tbadk.core.util.y.p(eVar.avw()) - 1);
                        if (sVar == null || sVar2 == null || !sVar.getId().equals(sVar2.getId())) {
                            i5 = size;
                        } else {
                            eVar.avw().remove(sVar2);
                            i5 = size - 1;
                        }
                        avw.addAll(0, eVar.avw());
                    }
                    this.ddF.a(eVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.diH && eVar.getPage() != null) {
                        eVar.getPage().bP(eVar.getPage().sl());
                    }
                    i(eVar);
                    i4 = 0;
                    break;
                case 4:
                    i(eVar);
                    i4 = 0;
                    break;
                case 5:
                    i(eVar);
                    i4 = 0;
                    break;
                case 6:
                    i(eVar);
                    i4 = 0;
                    break;
                case 7:
                    i(eVar);
                    i4 = 0;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (this.ddF != null && this.ddF.avv() != null) {
                PraiseData praise = this.ddF.avv().getPraise();
                if (this.djq != null && !praise.isPriaseDataValid()) {
                    this.ddF.avv().setPraise(this.djq);
                } else {
                    this.djq = this.ddF.avv().getPraise();
                    this.djq.setPostId(this.ddF.avv().tB());
                }
                if (eVar.getPage() != null && eVar.getPage().so() == 1 && eVar.avv() != null && eVar.avv().tw() != null && eVar.avv().tw().size() > 0) {
                    this.ddF.avv().h(eVar.avv().tw());
                }
                this.ddF.avv().setReply_num(eVar.avv().getReply_num());
                this.ddF.avv().setAnchorLevel(eVar.avv().getAnchorLevel());
                this.ddF.avv().bV(eVar.avv().tl());
                if (this.mThreadType == 33) {
                    this.ddF.avv().getAuthor().setHadConcerned(eVar.avv().getAuthor().hadConcerned());
                }
            }
            if (this.ddF != null && this.ddF.getUserData() != null && eVar.getUserData() != null) {
                this.ddF.getUserData().setBimg_end_time(eVar.getUserData().getBimg_end_time());
                this.ddF.getUserData().setBimg_url(eVar.getUserData().getBimg_url());
            }
            if (this.djm && this.ddF.avv() != null && this.ddF.avv().getAuthor() != null && this.ddF.avw() != null && com.baidu.tbadk.core.util.y.b(this.ddF.avw(), 0) != null) {
                com.baidu.tieba.tbadkCore.data.s sVar3 = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(this.ddF.avw(), 0);
                MetaData author = this.ddF.avv().getAuthor();
                if (sVar3.getAuthor() != null && sVar3.getAuthor().getGodUserData() != null) {
                    if (this.djb != -1) {
                        author.setFansNum(this.djb);
                        sVar3.getAuthor().setFansNum(this.djb);
                    }
                    if (this.djc != -1) {
                        author.getGodUserData().setFollowed(this.djc);
                        sVar3.getAuthor().getGodUserData().setFollowed(this.djc);
                    }
                }
            }
            if (this.ddF != null && this.ddF.avs() != null && eVar.avs() != null) {
                this.ddF.avs().setItems(eVar.avs().getItems());
                this.ddF.avs().ah(eVar.avs().sa());
            }
            if (this.diX != null) {
                this.diX.a(true, getErrorCode(), i, i4, this.ddF, this.mErrorString, 1);
            }
        }
        if (this.ddF != null && this.ddF.avv() != null && this.ddF.avu() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.bix;
            historyMessage.threadId = getPbData().avv().getId();
            historyMessage.forumName = getPbData().avu().getName();
            historyMessage.threadName = getPbData().avv().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = axe();
            historyMessage.threadType = getPbData().avv().getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String X;
        if (arrayList != null && eVar.avw() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(eVar.avw(), 0);
            if (sVar != null && (X = X(arrayList)) != null && X.equals(sVar.getId())) {
                eVar.avw().remove(sVar);
            }
            arrayList.addAll(eVar.avw());
        }
    }

    private String X(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int p = com.baidu.tbadk.core.util.y.p(arrayList);
        if (p <= 0) {
            return null;
        }
        for (int i = p - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.b(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.pb.data.e eVar) {
        this.ddF = eVar;
        ma(eVar.getPage().so());
    }

    public boolean axm() {
        if (this.diD == null || this.diE == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return mc(4);
        }
        return mc(6);
    }

    public boolean gb(boolean z) {
        if (this.diD == null || this.ddF == null) {
            return false;
        }
        if (z || this.ddF.getPage().sq() != 0) {
            return mc(1);
        }
        return false;
    }

    public boolean gc(boolean z) {
        if (this.diD == null || this.ddF == null) {
            return false;
        }
        if ((z || this.ddF.getPage().sr() != 0) && this.ddF.avw() != null && this.ddF.avw().size() >= 1) {
            return mc(2);
        }
        return false;
    }

    public boolean lX(String str) {
        this.diF = !this.diF;
        this.diE = str;
        mc(6);
        return true;
    }

    public boolean axn() {
        if (com.baidu.adp.lib.util.i.jf()) {
            this.diG = this.diH;
            this.diH = !this.diH;
        }
        return LoadData();
    }

    public boolean axo() {
        return this.diH;
    }

    public boolean hasData() {
        return (this.ddF == null || this.ddF.avu() == null || this.ddF.avv() == null) ? false : true;
    }

    public boolean pu() {
        if (this.ddF == null) {
            return false;
        }
        return this.ddF.pu();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fv(String str) {
        if (this.ddF == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.ddF.avu().getId());
        writeData.setForumName(this.ddF.avu().getName());
        writeData.setThreadId(this.diD);
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

    public MarkData me(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.ddF == null || this.ddF.avw() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddF.avw();
        if (avw.size() > 0 && i == avw.size()) {
            i = avw.size() - 1;
        }
        if (avw.size() <= 0 || i >= avw.size()) {
            return null;
        }
        return e(avw.get(i));
    }

    public MarkData axp() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.diD);
        markData.setPostId(this.ddF.ps());
        markData.setTime(date.getTime());
        markData.setHostMode(this.diF);
        markData.setSequence(Boolean.valueOf(this.diH));
        markData.setId(this.diD);
        return markData;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.diD);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.diF);
        markData.setSequence(Boolean.valueOf(this.diH));
        markData.setId(this.diD);
        markData.setFloor(sVar.aTs());
        if (sVar instanceof com.baidu.tieba.pb.data.c) {
            markData.setApp(true);
        } else if (sVar instanceof com.baidu.tieba.tbadkCore.data.r) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.r) sVar).isApp());
        }
        return markData;
    }

    public void axq() {
        cx.awR().B(axr(), this.isFromMark);
    }

    private String axr() {
        String str = this.diD;
        if (this.diF) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.diH) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void gd(boolean z) {
        if (this.ddF != null) {
            this.ddF.X(z);
        }
    }

    public void ge(boolean z) {
        this.djd = z;
    }

    public boolean axs() {
        return this.djd;
    }

    public void a(c cVar) {
        this.diX = cVar;
    }

    public void li(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String DH() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean DG() {
        return FG();
    }

    public boolean lY(String str) {
        if (getPbData() == null || getPbData().avv() == null || getPbData().avv().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().avv().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void a(a aVar) {
        this.dho = aVar;
    }

    public void mf(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.diD);
        httpMessage.addParam("status", String.valueOf(i));
        sendMessage(httpMessage);
    }

    public int axt() {
        return this.mRequestType;
    }

    public void a(b bVar) {
        this.diY = bVar;
    }

    public void axu() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.djt);
    }

    public void bE(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        sendMessage(httpMessage);
    }

    public void axv() {
        String axr = axr();
        cx.awR().B(axr, false);
        cx.awR().B(axr, true);
    }

    public void axw() {
        if ("personalize_page".equals(this.ahu)) {
            this.djj = System.currentTimeMillis() / 1000;
        }
    }

    public void axx() {
        if ("personalize_page".equals(this.ahu) && this.ddF != null && this.djj != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10754").ac("fid", this.ddF.getForumId()).ac("tid", this.diD).ac("obj_duration", String.valueOf(currentTimeMillis - this.djj)).ac("obj_param3", String.valueOf(currentTimeMillis)));
            this.djj = 0L;
        }
    }

    public boolean axy() {
        return this.djm;
    }

    public int axz() {
        return this.diV;
    }

    public int getErrorNo() {
        return this.djn;
    }

    public com.baidu.tieba.pb.data.d getAppealInfo() {
        return this.mAppealInfo;
    }

    public dc axA() {
        return this.djo;
    }
}
