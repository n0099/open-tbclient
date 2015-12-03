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
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class cc extends com.baidu.tbadk.editortools.d.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    public static int cDA = 1;
    private CustomMessageListener aJt;
    private com.baidu.tieba.tbadkCore.d.a aRc;
    private long aRd;
    private long aRe;
    private long aRf;
    private long aRg;
    private String aUo;
    private BaseActivity aXA;
    private boolean awu;
    protected String cCY;
    private String cCZ;
    private a cCl;
    protected final HttpMessageListener cDB;
    private boolean cDa;
    private boolean cDb;
    private boolean cDc;
    private int cDd;
    private int cDe;
    private long cDf;
    private int cDg;
    private int cDh;
    private int cDi;
    private int cDj;
    private boolean cDk;
    private boolean cDl;
    private long cDm;
    private boolean cDn;
    protected int cDo;
    private b cDp;
    private String cDq;
    private String cDr;
    private boolean cDs;
    private boolean cDt;
    private boolean cDu;
    private String cDv;
    private boolean cDw;
    private int cDx;
    private com.baidu.adp.framework.listener.a cDy;
    private PraiseData cDz;
    protected com.baidu.tieba.pb.a.c czO;
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
        void f(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.c cVar, String str, int i4);

        void b(com.baidu.tieba.pb.a.c cVar);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void fa(boolean z);
    }

    public String akB() {
        return this.cDv;
    }

    public void kF(String str) {
        this.cDv = str;
    }

    public void fc(boolean z) {
        this.cDw = z;
    }

    public cc(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aUo = null;
        this.cCY = null;
        this.cCZ = null;
        this.cDa = false;
        this.cDb = true;
        this.cDc = true;
        this.cDd = 0;
        this.cDe = 0;
        this.cDf = 0L;
        this.cDg = 1;
        this.cDh = 1;
        this.cDi = 1;
        this.cDj = 1;
        this.isAd = false;
        this.cDk = false;
        this.cDl = false;
        this.isFromMark = false;
        this.cDm = 0L;
        this.cDn = false;
        this.mForumName = null;
        this.czO = null;
        this.awu = false;
        this.mContext = null;
        this.cDp = null;
        this.aRd = 0L;
        this.aRe = 0L;
        this.aRf = 0L;
        this.aRg = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cDq = null;
        this.cDr = null;
        this.aRc = null;
        this.cDt = false;
        this.postID = null;
        this.cDv = null;
        this.cDw = false;
        this.cDx = -1;
        this.aJt = new cd(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cDy = new cf(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cDz = null;
        this.cCl = null;
        this.cDB = new cg(this, CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        registerListener(this.aJt);
        registerListener(this.cDy);
        registerListener(this.cDB);
        this.czO = new com.baidu.tieba.pb.a.c();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aXA = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int akC() {
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
        this.cCY = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.cCY)) {
            this.cCY = R(intent);
        }
        this.cCZ = intent.getStringExtra("post_id");
        this.cDa = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cDc = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aUo = intent.getStringExtra("st_type");
        this.cDd = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cDe = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cDf = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.cDl = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.cDk = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cDn = intent.getBooleanExtra("is_pv", false);
        this.cDm = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cDr = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cDq = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    private String R(Intent intent) {
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
        this.cCY = bundle.getString("thread_id");
        this.cCZ = bundle.getString("post_id");
        this.cDa = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cDc = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aUo = bundle.getString("st_type");
        this.cDd = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cDe = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cDf = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.cDl = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.cDk = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cDn = bundle.getBoolean("is_pv", false);
        this.cDm = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cDr = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.cCY);
        bundle.putString("post_id", this.cCZ);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cDa);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cDc);
        bundle.putString("st_type", this.aUo);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cDd);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cDe);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cDf);
        bundle.putBoolean("from_frs", this.cDl);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.cDk);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cDn);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cDm);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cDr);
    }

    public String akD() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cCY);
        sb.append(this.cCZ);
        sb.append(this.cDa);
        sb.append(this.cDc);
        sb.append(this.aUo);
        sb.append(this.cDd);
        sb.append(this.cDe);
        sb.append(this.cDf);
        sb.append(this.cDl);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.cDk);
        sb.append(this.cDn);
        sb.append(this.cDm);
        sb.append(this.mForumName);
        if (this.cDr != null) {
            sb.append(this.cDr);
        }
        return sb.toString();
    }

    public String akE() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.cCZ;
    }

    public void kG(String str) {
        this.cCZ = str;
    }

    public String getThreadID() {
        return this.cCY;
    }

    public boolean getHostMode() {
        return this.cDa;
    }

    public boolean akF() {
        return this.cDc;
    }

    public boolean akG() {
        return this.cDl;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean akH() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.aUo);
    }

    public int getIsGood() {
        return this.cDd;
    }

    public int akI() {
        return this.cDe;
    }

    public void setIsGood(int i) {
        this.cDd = i;
    }

    public void jS(int i) {
        this.cDe = i;
    }

    public boolean akJ() {
        return this.cDk;
    }

    public boolean akK() {
        if (this.czO == null) {
            return false;
        }
        return this.czO.isValid();
    }

    public String sP() {
        if (this.czO == null || !this.czO.qp()) {
            return null;
        }
        return this.czO.qo();
    }

    public boolean jT(int i) {
        this.cDg = i;
        if (this.cDg > this.czO.getPage().sb()) {
            this.cDg = this.czO.getPage().sb();
        }
        if (this.cDg < 1) {
            this.cDg = 1;
        }
        if (this.cCY == null) {
            return false;
        }
        return jX(5);
    }

    public boolean jU(int i) {
        int td = this.czO.ajz().td();
        if (i <= td) {
            td = i;
        }
        int i2 = td >= 1 ? td : 1;
        if (this.cCY == null) {
            return false;
        }
        this.cDx = i2;
        return jX(7);
    }

    public void jV(int i) {
        this.cDg = i;
        this.cDh = i;
        this.cDi = i;
    }

    public void jW(int i) {
        if (this.cDh < i) {
            this.cDh = i;
            if (this.cDh - this.cDi >= MAX_PAGE_NUM) {
                this.cDi = (this.cDh - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.cDi > i) {
            this.cDi = i;
            if (this.cDh - this.cDi >= MAX_PAGE_NUM) {
                this.cDh = (this.cDi + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        return this.czO;
    }

    public com.baidu.tbadk.core.data.q Uy() {
        if (this.czO == null) {
            return null;
        }
        return this.czO.getPage();
    }

    public boolean akL() {
        if (this.cDc) {
            if (this.czO.getPage().sf() == 0) {
                fd(true);
                return true;
            }
        } else if (this.czO.getPage().sg() == 0) {
            fe(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cCY == null) {
            return false;
        }
        cancelLoadData();
        if (this.aRc == null) {
            this.aRc = new com.baidu.tieba.tbadkCore.d.a("pbStat");
            this.aRc.start();
        }
        boolean jX = jX(3);
        if (this.opType != null) {
            this.opType = null;
            this.cDq = null;
            this.opUrl = null;
            return jX;
        }
        return jX;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.awu = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        Kg();
    }

    private void Kg() {
        if (this.aRc != null) {
            this.aRc.destory();
            this.aRc = null;
        }
    }

    public boolean DJ() {
        return (this.cCZ == null || this.cCZ.equals("0") || this.cCZ.length() == 0) ? LoadData() : akN();
    }

    public boolean jX(int i) {
        this.mRequestType = i;
        if (this.awu) {
            return false;
        }
        this.awu = true;
        jY(i);
        com.baidu.tieba.pb.a.c pbData = ct.ale().getPbData();
        if (pbData != null && pbData.ajz() != null) {
            pbData.ajz().bI(0);
            this.cDc = ct.ale().akF();
            this.cDa = ct.ale().alg();
            if (!this.cDc || this.cDa || this.isFromMark) {
                this.cDs = false;
            }
            com.baidu.adp.lib.h.h.hj().post(new ch(this, pbData));
            return false;
        }
        if (i == 4 && !this.cDu) {
            a(akS(), true, this.cCZ, 3);
        }
        if (i == 3 && !this.cDu) {
            if (this.isFromMark) {
                a(akS(), true, this.cCZ, 3);
            } else {
                a(akS(), false, this.cCZ, 3);
            }
        }
        this.cDu = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apR);
        if (!this.cDc || this.cDa || this.isFromMark) {
            this.cDs = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.cCY == null || this.cCY.length() == 0) {
            this.awu = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.cCY, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ay.vq().vs() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.cDc) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.cDa) {
            pbPageRequestMessage.set_lz(1);
        }
        if (this.aUo != null) {
            pbPageRequestMessage.set_st_type(this.aUo);
        }
        if (this.cDn) {
            pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cDm));
            pbPageRequestMessage.set_message_click("1");
        }
        if (this.cDs) {
            pbPageRequestMessage.set_banner(1);
        }
        if (this.opType != null) {
            pbPageRequestMessage.setOpType(this.opType);
            pbPageRequestMessage.setOpUrl(this.opUrl);
            pbPageRequestMessage.setOpStat(com.baidu.adp.lib.h.b.g(this.cDq, 0));
            pbPageRequestMessage.setOpMessageID(this.cDm);
        }
        pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cDo));
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.czO.ajA();
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isFromMark) {
                    if (!this.cDc) {
                        if (this.cDi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cDi - 1));
                        }
                    } else if (this.cDh < this.cDj) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cDh + 1));
                    }
                }
                if (ajA != null && ajA.size() > 0) {
                    int size = ajA.size();
                    int i3 = 1;
                    while (size - i3 >= 0) {
                        com.baidu.tieba.tbadkCore.data.o oVar = ajA.get(size - i3);
                        if (oVar == null) {
                            i3++;
                        } else {
                            this.cCZ = oVar.getId();
                            if (StringUtils.isNull(this.cCZ)) {
                                i3++;
                            }
                        }
                    }
                }
                if (this.cCZ != null && this.cCZ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cCZ, 0L));
                    break;
                } else if (!this.cDc) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 2:
                if (ajA != null && ajA.size() > 0 && ajA.get(0) != null) {
                    this.cCZ = ajA.get(0).getId();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.isFromMark) {
                    if (this.cDc) {
                        if (this.cDi - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cDi - 1));
                        }
                    } else if (this.cDh < this.cDj) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.cDh + 1));
                    }
                }
                if (this.cCZ != null && this.cCZ.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cCZ, 0L));
                    break;
                }
                break;
            case 3:
                if (this.isFromMark) {
                    pbPageRequestMessage.set_banner(0);
                }
                pbPageRequestMessage.set_back(0);
                if (this.cDc) {
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
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cCZ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.cDg));
                pbPageRequestMessage.set_banner(0);
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.cCZ, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.cDx);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
        pbPageRequestMessage.setCacheKey(akS());
        pbPageRequestMessage.setContext(this.mContext);
        pbPageRequestMessage.setIsSubPostDataReverse(this.cDw);
        sendMessage(pbPageRequestMessage);
        return true;
    }

    protected void jY(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.czO.ajA();
        if (i == 1) {
            boolean z2 = false;
            while (ajA.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ajA.remove(0);
                z2 = true;
            }
            if (z2) {
                this.czO.getPage().bG(1);
                if (this.cDp != null) {
                    this.cDp.b(this.czO);
                }
            }
        } else if (i == 2) {
            while (ajA.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                ajA.remove(ajA.size() - 1);
                z = true;
            }
            if (z) {
                this.czO.getPage().bF(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.c cVar2 = z ? null : cVar;
        this.awu = false;
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
            for (int i = 0; i < cVar.ajA().size(); i++) {
                com.baidu.tieba.tbadkCore.data.o oVar = cVar.ajA().get(i);
                for (int i2 = 0; i2 < oVar.aCZ().size(); i2++) {
                    oVar.aCZ().get(i2).a(this.aXA.getPageContext().getUniqueId(), f.equals(oVar.aCZ().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.c e(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.z ajz = cVar.ajz();
        ajz.bK(this.cDd);
        ajz.bJ(this.cDe);
        if (this.cDf > 0) {
            ajz.q(this.cDf);
            return cVar;
        }
        return cVar;
    }

    protected String f(com.baidu.tieba.pb.a.c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.ajz() != null && cVar.ajz().getAuthor() != null) {
            str = cVar.ajz().getAuthor().getUserId();
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
        if (cVar.ajz() != null && cVar.ajz().getAuthor() != null) {
            str = cVar.ajz().getAuthor().getUserName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MetaData akM() {
        if (this.czO == null || this.czO.ajz() == null || this.czO.ajz().getAuthor() == null) {
            return null;
        }
        return this.czO.ajz().getAuthor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4 = !z;
        if (this.aRc != null && !z3) {
            this.aRc.a(z2, z4, i2, str, i3, j, j2);
            this.aRc = null;
        }
        if (cVar == null) {
            if (this.cDp != null) {
                this.cDc = this.cDb;
                this.cDp.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cDb = this.cDc;
            this.cDn = false;
            if (cVar.getPage() != null) {
                jW(cVar.getPage().sd());
                this.cDj = cVar.getPage().sb();
            }
            this.cDj = this.cDj < 1 ? 1 : this.cDj;
            int i5 = 0;
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.czO.ajA();
            switch (i) {
                case 1:
                    this.czO.a(cVar.getPage(), 1);
                    a(cVar, ajA);
                    i4 = 0;
                    break;
                case 2:
                    if (cVar.ajA() != null) {
                        int size = cVar.ajA().size() + 1;
                        com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(ajA, 0);
                        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(cVar.ajA(), com.baidu.tbadk.core.util.y.k(cVar.ajA()) - 1);
                        if (oVar == null || oVar2 == null || !oVar.getId().equals(oVar2.getId())) {
                            i5 = size;
                        } else {
                            cVar.ajA().remove(oVar2);
                            i5 = size - 1;
                        }
                        ajA.addAll(0, cVar.ajA());
                    }
                    this.czO.a(cVar.getPage(), 2);
                    i4 = i5;
                    break;
                case 3:
                    if (!this.cDc && cVar.getPage() != null) {
                        cVar.getPage().bD(cVar.getPage().sb());
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
            if (this.czO != null && this.czO.ajz() != null) {
                PraiseData praise = this.czO.ajz().getPraise();
                if (this.cDz != null && !praise.isPriaseDataValid()) {
                    this.czO.ajz().setPraise(this.cDz);
                } else {
                    this.cDz = this.czO.ajz().getPraise();
                    this.cDz.setPostId(this.czO.ajz().sT());
                }
                if (cVar.getPage() != null && cVar.getPage().sd() == 1 && cVar.ajz() != null && cVar.ajz().sQ() != null && cVar.ajz().sQ().size() > 0) {
                    this.czO.ajz().j(cVar.ajz().sQ());
                }
                this.czO.ajz().setReply_num(cVar.ajz().getReply_num());
            }
            if (this.czO != null && this.czO.getUserData() != null && cVar.getUserData() != null) {
                this.czO.getUserData().setBimg_end_time(cVar.getUserData().getBimg_end_time());
                this.czO.getUserData().setBimg_url(cVar.getUserData().getBimg_url());
            }
            if (this.cDp != null) {
                this.cDp.a(true, getErrorCode(), i, i4, this.czO, this.mErrorString, 1);
            }
        }
        if (this.czO != null && this.czO.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.czO.getUserData().getIsMem())));
        }
        if (this.czO != null && this.czO.ajz() != null && this.czO.ajy() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aXA;
            historyMessage.threadId = getPbData().ajz().getId();
            historyMessage.forumName = getPbData().ajy().getName();
            historyMessage.threadName = getPbData().ajz().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = akF();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    protected void a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        String W;
        if (arrayList != null && cVar.ajA() != null) {
            com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(cVar.ajA(), 0);
            if (oVar != null && (W = W(arrayList)) != null && W.equals(oVar.getId())) {
                cVar.ajA().remove(oVar);
            }
            arrayList.addAll(cVar.ajA());
        }
    }

    private String W(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        int k = com.baidu.tbadk.core.util.y.k(arrayList);
        if (k <= 0) {
            return null;
        }
        for (int i = k - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.o oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tbadk.core.util.y.b(arrayList, i);
            if (oVar != null && !StringUtils.isNull(oVar.getId())) {
                return oVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.pb.a.c cVar) {
        this.czO = cVar;
        jV(cVar.getPage().sd());
    }

    public boolean akN() {
        if (this.cCY == null || this.cCZ == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return jX(4);
        }
        return jX(6);
    }

    public boolean fd(boolean z) {
        if (this.cCY == null || this.czO == null) {
            return false;
        }
        if (z || this.czO.getPage().sf() != 0) {
            return jX(1);
        }
        return false;
    }

    public boolean fe(boolean z) {
        if (this.cCY == null || this.czO == null) {
            return false;
        }
        if ((z || this.czO.getPage().sg() != 0) && this.czO.ajA() != null && this.czO.ajA().size() >= 1) {
            return jX(2);
        }
        return false;
    }

    public boolean kH(String str) {
        this.cDa = !this.cDa;
        this.cCZ = str;
        jX(6);
        return true;
    }

    public boolean akO() {
        if (com.baidu.adp.lib.util.i.iP()) {
            this.cDb = this.cDc;
            this.cDc = !this.cDc;
        }
        return LoadData();
    }

    public boolean akP() {
        return this.cDc;
    }

    public boolean hasData() {
        return (this.czO == null || this.czO.ajy() == null || this.czO.ajz() == null) ? false : true;
    }

    public boolean qp() {
        if (this.czO == null) {
            return false;
        }
        return this.czO.qp();
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fl(String str) {
        if (this.czO == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.czO.ajy().getId());
        writeData.setForumName(this.czO.ajy().getName());
        writeData.setThreadId(this.cCY);
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

    public MarkData jZ(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.czO == null || this.czO.ajA() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.czO.ajA();
        if (ajA.size() > 0 && i == ajA.size()) {
            i = ajA.size() - 1;
        }
        if (ajA.size() <= 0 || i >= ajA.size()) {
            return null;
        }
        return d(ajA.get(i));
    }

    public MarkData akQ() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cCY);
        markData.setPostId(this.czO.qo());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cDa);
        markData.setSequence(Boolean.valueOf(this.cDc));
        markData.setId(this.cCY);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.o oVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cCY);
        markData.setPostId(oVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cDa);
        markData.setSequence(Boolean.valueOf(this.cDc));
        markData.setId(this.cCY);
        markData.setFloor(oVar.aDd());
        if (oVar instanceof com.baidu.tieba.pb.a.b) {
            markData.setApp(true);
        } else if (oVar instanceof com.baidu.tieba.tbadkCore.data.n) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.n) oVar).isApp());
        }
        return markData;
    }

    public void akR() {
        bx.akA().B(akS(), this.isFromMark);
    }

    private String akS() {
        String str = this.cCY;
        if (this.cDa) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cDc) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ff(boolean z) {
        if (this.czO != null) {
            this.czO.ab(z);
        }
    }

    public void fg(boolean z) {
        this.cDs = z;
    }

    public boolean akT() {
        return this.cDs;
    }

    public void a(b bVar) {
        this.cDp = bVar;
    }

    public void jU(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BU() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BT() {
        return DJ();
    }

    public boolean kI(String str) {
        if (getPbData() == null || getPbData().ajz() == null || getPbData().ajz().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().ajz().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void a(a aVar) {
        this.cCl = aVar;
    }

    public void ka(int i) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_APPLY_COPY_THREAD);
        httpMessage.addParam("thread_id", this.cCY);
        httpMessage.addParam("status", String.valueOf(i));
        sendMessage(httpMessage);
    }

    public int getRequestType() {
        return this.mRequestType;
    }
}
