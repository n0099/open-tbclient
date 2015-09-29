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
public class bl extends com.baidu.tbadk.editortools.c.a {
    private static final int MAX_PAGE_NUM = com.baidu.tbadk.data.b.getPbListItemMaxNum() / 30;
    private CustomMessageListener aHp;
    private com.baidu.tieba.tbadkCore.e.a aMa;
    private long aMb;
    private long aMc;
    private long aMd;
    private long aMe;
    private String aOS;
    private BaseActivity aRT;
    private boolean avB;
    protected String ciZ;
    private PraiseData cjA;
    private String cja;
    private boolean cjb;
    private boolean cjc;
    private boolean cjd;
    private int cje;
    private int cjf;
    private long cjg;
    private int cjh;
    private int cji;
    private int cjj;
    private int cjk;
    private boolean cjl;
    private boolean cjm;
    private long cjn;
    private boolean cjo;
    protected com.baidu.tieba.pb.a.b cjp;
    protected int cjq;
    private a cjr;
    private String cjs;
    private String cjt;
    private boolean cju;
    private boolean cjv;
    private boolean cjw;
    private boolean cjx;
    private int cjy;
    private com.baidu.adp.framework.listener.a cjz;
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
        void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.a.b bVar, String str, int i4);

        void b(com.baidu.tieba.pb.a.b bVar);

        void e(com.baidu.tbadk.performanceLog.t tVar);

        void eu(boolean z);
    }

    public void ew(boolean z) {
        this.cjx = z;
    }

    public bl(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aOS = null;
        this.ciZ = null;
        this.cja = null;
        this.cjb = false;
        this.cjc = true;
        this.cjd = true;
        this.cje = 0;
        this.cjf = 0;
        this.cjg = 0L;
        this.cjh = 1;
        this.cji = 1;
        this.cjj = 1;
        this.cjk = 1;
        this.isAd = false;
        this.cjl = false;
        this.cjm = false;
        this.isFromMark = false;
        this.cjn = 0L;
        this.cjo = false;
        this.mForumName = null;
        this.cjp = null;
        this.avB = false;
        this.mContext = null;
        this.cjr = null;
        this.aMb = 0L;
        this.aMc = 0L;
        this.aMd = 0L;
        this.aMe = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cjs = null;
        this.cjt = null;
        this.aMa = null;
        this.cjv = false;
        this.postID = null;
        this.cjx = false;
        this.cjy = -1;
        this.aHp = new bm(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cjz = new bo(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cjA = null;
        registerListener(this.aHp);
        registerListener(this.cjz);
        this.cjp = new com.baidu.tieba.pb.a.b();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aRT = baseActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int afI() {
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
        this.ciZ = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.ciZ)) {
            this.ciZ = Q(intent);
        }
        this.cja = intent.getStringExtra("post_id");
        this.cjb = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cjd = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aOS = intent.getStringExtra("st_type");
        this.cje = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cjf = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cjg = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.cjm = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.cjl = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cjo = intent.getBooleanExtra("is_pv", false);
        this.cjn = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cjt = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cjs = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
    }

    private String Q(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbpb://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10320").r("obj_locate", 3).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("tid=")) < 0 || (length = indexOf + "tid=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void initWithBundle(Bundle bundle) {
        this.ciZ = bundle.getString("thread_id");
        this.cja = bundle.getString("post_id");
        this.cjb = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cjd = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aOS = bundle.getString("st_type");
        this.cje = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cjf = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cjg = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.cjm = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.cjl = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cjo = bundle.getBoolean("is_pv", false);
        this.cjn = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cjt = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.ciZ);
        bundle.putString("post_id", this.cja);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cjb);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cjd);
        bundle.putString("st_type", this.aOS);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cje);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cjf);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cjg);
        bundle.putBoolean("from_frs", this.cjm);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.cjl);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cjo);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cjn);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cjt);
    }

    public String afJ() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.ciZ);
        sb.append(this.cja);
        sb.append(this.cjb);
        sb.append(this.cjd);
        sb.append(this.aOS);
        sb.append(this.cje);
        sb.append(this.cjf);
        sb.append(this.cjg);
        sb.append(this.cjm);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.cjl);
        sb.append(this.cjo);
        sb.append(this.cjn);
        sb.append(this.mForumName);
        if (this.cjt != null) {
            sb.append(this.cjt);
        }
        return sb.toString();
    }

    public String afK() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.cja;
    }

    public String getThreadID() {
        return this.ciZ;
    }

    public boolean getHostMode() {
        return this.cjb;
    }

    public boolean afL() {
        return this.cjd;
    }

    public boolean afM() {
        return this.cjm;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean afN() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.aOS);
    }

    public int getIsGood() {
        return this.cje;
    }

    public int afO() {
        return this.cjf;
    }

    public void setIsGood(int i) {
        this.cje = i;
    }

    public void iL(int i) {
        this.cjf = i;
    }

    public boolean afP() {
        return this.cjl;
    }

    public boolean afQ() {
        if (this.cjp == null) {
            return false;
        }
        return this.cjp.isValid();
    }

    public String sn() {
        if (this.cjp == null || !this.cjp.qk()) {
            return null;
        }
        return this.cjp.qj();
    }

    public boolean iM(int i) {
        this.cjh = i;
        if (this.cjh > this.cjp.getPage().rH()) {
            this.cjh = this.cjp.getPage().rH();
        }
        if (this.cjh < 1) {
            this.cjh = 1;
        }
        if (this.ciZ == null) {
            return false;
        }
        return iQ(5);
    }

    public boolean iN(int i) {
        int sC = this.cjp.aeO().sC();
        if (i <= sC) {
            sC = i;
        }
        int i2 = sC >= 1 ? sC : 1;
        if (this.ciZ == null) {
            return false;
        }
        this.cjy = i2;
        return iQ(7);
    }

    public void iO(int i) {
        this.cjh = i;
        this.cji = i;
        this.cjj = i;
    }

    public void iP(int i) {
        if (this.cji < i) {
            this.cji = i;
            if (this.cji - this.cjj >= MAX_PAGE_NUM) {
                this.cjj = (this.cji - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.cjj > i) {
            this.cjj = i;
            if (this.cji - this.cjj >= MAX_PAGE_NUM) {
                this.cji = (this.cjj + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.cjp;
    }

    public com.baidu.tbadk.core.data.n QV() {
        if (this.cjp == null) {
            return null;
        }
        return this.cjp.getPage();
    }

    public boolean afR() {
        if (this.cjd) {
            if (this.cjp.getPage().rL() == 0) {
                ex(true);
                return true;
            }
        } else if (this.cjp.getPage().rM() == 0) {
            ey(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.ciZ == null) {
            return false;
        }
        cancelLoadData();
        if (this.aMa == null) {
            this.aMa = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aMa.start();
        }
        boolean iQ = iQ(3);
        if (this.opType != null) {
            this.opType = null;
            this.cjs = null;
            this.opUrl = null;
            return iQ;
        }
        return iQ;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.avB = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        IC();
    }

    private void IC() {
        if (this.aMa != null) {
            this.aMa.destory();
            this.aMa = null;
        }
    }

    public boolean CS() {
        return (this.cja == null || this.cja.equals("0") || this.cja.length() == 0) ? LoadData() : afS();
    }

    public boolean iQ(int i) {
        this.mRequestType = i;
        if (this.avB) {
            return false;
        }
        this.avB = true;
        iR(i);
        com.baidu.tieba.pb.a.b pbData = bx.age().getPbData();
        if (pbData != null && pbData.aeO() != null) {
            this.cjd = bx.age().afL();
            this.cjb = bx.age().agg();
            if (!this.cjd || this.cjb || this.isFromMark) {
                this.cju = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.cjr.eu(true);
            this.avB = false;
            return false;
        } else if (i == 4 && !this.cjw) {
            a(afX(), true, this.cja, 3);
            this.avB = false;
            return true;
        } else if (i == 3 && !this.cjw) {
            if (this.isFromMark) {
                a(afX(), true, this.cja, 3);
            } else {
                a(afX(), false, this.cja, 3);
            }
            this.avB = false;
            return true;
        } else {
            this.cjw = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.anT);
            if (!this.cjd || this.cjb || this.isFromMark) {
                this.cju = false;
            }
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.ciZ == null || this.ciZ.length() == 0) {
                this.avB = false;
                return false;
            }
            pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ciZ, 0L));
            pbPageRequestMessage.set_rn(30);
            pbPageRequestMessage.set_with_floor(1);
            int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
            float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = com.baidu.tbadk.core.util.as.uI().uK() ? 2 : 1;
            pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
            pbPageRequestMessage.set_scr_dip(f);
            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
            if (!this.cjd) {
                pbPageRequestMessage.set_r(1);
            }
            if (this.cjb) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.aOS != null) {
                pbPageRequestMessage.set_st_type(this.aOS);
            }
            if (this.cjo) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cjn));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.cju) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.opType != null) {
                pbPageRequestMessage.setOpType(this.opType);
                pbPageRequestMessage.setOpUrl(this.opUrl);
                pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.cjs, 0));
                pbPageRequestMessage.setOpMessageID(this.cjn);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cjq));
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjp.aeP();
            switch (i) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.isFromMark) {
                        if (!this.cjd) {
                            if (this.cjj - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cjj - 1));
                            }
                        } else if (this.cji < this.cjk) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cji + 1));
                        }
                    }
                    if (aeP != null && aeP.size() > 0) {
                        int size = aeP.size();
                        int i3 = 1;
                        while (size - i3 >= 0) {
                            com.baidu.tieba.tbadkCore.data.k kVar = aeP.get(size - i3);
                            if (kVar == null) {
                                i3++;
                            } else {
                                this.cja = kVar.getId();
                                if (StringUtils.isNull(this.cja)) {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (this.cja != null && this.cja.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cja, 0L));
                        break;
                    } else if (!this.cjd) {
                        pbPageRequestMessage.set_last(1);
                        break;
                    }
                    break;
                case 2:
                    if (aeP != null && aeP.size() > 0 && aeP.get(0) != null) {
                        this.cja = aeP.get(0).getId();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.isFromMark) {
                        if (this.cjd) {
                            if (this.cjj - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cjj - 1));
                            }
                        } else if (this.cji < this.cjk) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cji + 1));
                        }
                    }
                    if (this.cja != null && this.cja.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cja, 0L));
                        break;
                    }
                    break;
                case 3:
                    if (this.isFromMark) {
                        pbPageRequestMessage.set_banner(0);
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.cjd) {
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
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cja, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.cjh));
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cja, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 7:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.setIsJumpFloor(true);
                    pbPageRequestMessage.setJumpFloorNum(this.cjy);
                    break;
            }
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
            pbPageRequestMessage.setCacheKey(afX());
            pbPageRequestMessage.setContext(this.mContext);
            pbPageRequestMessage.setIsSubPostDataReverse(this.cjx);
            sendMessage(pbPageRequestMessage);
            return true;
        }
    }

    protected void iR(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjp.aeP();
        if (i == 1) {
            boolean z2 = false;
            while (aeP.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aeP.remove(0);
                z2 = true;
            }
            if (z2) {
                this.cjp.getPage().bz(1);
                if (this.cjr != null) {
                    this.cjr.b(this.cjp);
                }
            }
        } else if (i == 2) {
            while (aeP.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aeP.remove(aeP.size() - 1);
                z = true;
            }
            if (z) {
                this.cjp.getPage().by(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.avB = false;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            d(e(bVar));
        }
    }

    protected void d(com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null) {
            String f = f(bVar);
            for (int i = 0; i < bVar.aeP().size(); i++) {
                com.baidu.tieba.tbadkCore.data.k kVar = bVar.aeP().get(i);
                for (int i2 = 0; i2 < kVar.awu().size(); i2++) {
                    kVar.awu().get(i2).a(this.aRT.getPageContext().getUniqueId(), f.equals(kVar.awu().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.b e(com.baidu.tieba.pb.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.v aeO = bVar.aeO();
        aeO.bB(this.cje);
        aeO.bA(this.cjf);
        if (this.cjg > 0) {
            aeO.m(this.cjg);
            return bVar;
        }
        return bVar;
    }

    protected String f(com.baidu.tieba.pb.a.b bVar) {
        String str = null;
        if (bVar == null) {
            return null;
        }
        if (bVar.aeO() != null && bVar.aeO().getAuthor() != null) {
            str = bVar.aeO().getAuthor().getUserId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        String Q;
        boolean z4 = !z;
        if (this.aMa != null && !z3) {
            this.aMa.a(z2, z4, i2, str, i3, j, j2);
            this.aMa = null;
        }
        if (bVar == null) {
            if (this.cjr != null) {
                this.cjd = this.cjc;
                this.cjr.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cjc = this.cjd;
            this.cjo = false;
            if (bVar.getPage() != null) {
                iP(bVar.getPage().rJ());
                this.cjk = bVar.getPage().rH();
            }
            this.cjk = this.cjk < 1 ? 1 : this.cjk;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjp.aeP();
            switch (i) {
                case 1:
                    this.cjp.a(bVar.getPage(), 1);
                    if (bVar.aeP() != null) {
                        com.baidu.tieba.tbadkCore.data.k kVar = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(bVar.aeP(), 0);
                        if (kVar != null && (Q = Q(aeP)) != null && Q.equals(kVar.getId())) {
                            bVar.aeP().remove(kVar);
                        }
                        aeP.addAll(bVar.aeP());
                        i5 = 0;
                        break;
                    }
                    i5 = 0;
                    break;
                case 2:
                    if (bVar.aeP() == null) {
                        i4 = 0;
                    } else {
                        int size = bVar.aeP().size() + 1;
                        com.baidu.tieba.tbadkCore.data.k kVar2 = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(aeP, 0);
                        com.baidu.tieba.tbadkCore.data.k kVar3 = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(bVar.aeP(), com.baidu.tbadk.core.util.u.l(bVar.aeP()) - 1);
                        if (kVar2 == null || kVar3 == null || !kVar2.getId().equals(kVar3.getId())) {
                            i4 = size;
                        } else {
                            bVar.aeP().remove(kVar3);
                            i4 = size - 1;
                        }
                        aeP.addAll(0, bVar.aeP());
                    }
                    this.cjp.a(bVar.getPage(), 2);
                    i5 = i4;
                    break;
                case 3:
                    if (!this.cjd && bVar.getPage() != null) {
                        bVar.getPage().bw(bVar.getPage().rH());
                    }
                    g(bVar);
                    i5 = 0;
                    break;
                case 4:
                    g(bVar);
                    i5 = 0;
                    break;
                case 5:
                    g(bVar);
                    i5 = 0;
                    break;
                case 6:
                    g(bVar);
                    i5 = 0;
                    break;
                case 7:
                    g(bVar);
                    i5 = 0;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            if (this.cjp != null && this.cjp.aeO() != null) {
                PraiseData praise = this.cjp.aeO().getPraise();
                if (this.cjA != null && !praise.isPriaseDataValid()) {
                    this.cjp.aeO().setPraise(this.cjA);
                } else {
                    this.cjA = this.cjp.aeO().getPraise();
                    this.cjA.setPostId(this.cjp.aeO().ss());
                }
                if (bVar.getPage() != null && bVar.getPage().rJ() == 1) {
                    this.cjp.aeO().i(bVar.aeO().so());
                }
                this.cjp.aeO().setReply_num(bVar.aeO().getReply_num());
            }
            if (this.cjp != null && this.cjp.getUserData() != null && bVar.getUserData() != null) {
                this.cjp.getUserData().setBimg_end_time(bVar.getUserData().getBimg_end_time());
                this.cjp.getUserData().setBimg_url(bVar.getUserData().getBimg_url());
            }
            if (this.cjr != null) {
                this.cjr.a(true, getErrorCode(), i, i5, this.cjp, this.mErrorString, 1);
            }
        }
        if (this.cjp != null && this.cjp.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.cjp.getUserData().getIsMem())));
        }
        if (this.cjp != null && this.cjp.aeO() != null && this.cjp.aeN() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aRT;
            historyMessage.threadId = getPbData().aeO().getId();
            historyMessage.forumName = getPbData().aeN().getName();
            historyMessage.threadName = getPbData().aeO().getTitle();
            historyMessage.isHostOnly = getHostMode();
            historyMessage.isSquence = afL();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    private String Q(ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        int l = com.baidu.tbadk.core.util.u.l(arrayList);
        if (l <= 0) {
            return null;
        }
        for (int i = l - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.k kVar = (com.baidu.tieba.tbadkCore.data.k) com.baidu.tbadk.core.util.u.b(arrayList, i);
            if (kVar != null && !StringUtils.isNull(kVar.getId())) {
                return kVar.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.pb.a.b bVar) {
        this.cjp = bVar;
        iO(bVar.getPage().rJ());
    }

    public boolean afS() {
        if (this.ciZ == null || this.cja == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return iQ(4);
        }
        return iQ(6);
    }

    public boolean ex(boolean z) {
        if (this.ciZ == null || this.cjp == null) {
            return false;
        }
        if (z || this.cjp.getPage().rL() != 0) {
            return iQ(1);
        }
        return false;
    }

    public boolean ey(boolean z) {
        if (this.ciZ == null || this.cjp == null) {
            return false;
        }
        if ((z || this.cjp.getPage().rM() != 0) && this.cjp.aeP() != null && this.cjp.aeP().size() >= 1) {
            return iQ(2);
        }
        return false;
    }

    public boolean jN(String str) {
        this.cjb = !this.cjb;
        this.cja = str;
        iQ(6);
        return true;
    }

    public boolean afT() {
        if (com.baidu.adp.lib.util.i.iM()) {
            this.cjc = this.cjd;
            this.cjd = !this.cjd;
        }
        return LoadData();
    }

    public boolean afU() {
        return this.cjd;
    }

    public boolean hasData() {
        return (this.cjp == null || this.cjp.aeN() == null || this.cjp.aeO() == null) ? false : true;
    }

    public boolean qk() {
        if (this.cjp == null) {
            return false;
        }
        return this.cjp.qk();
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
        if (this.cjp == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.cjp.aeN().getId());
        writeData.setForumName(this.cjp.aeN().getName());
        writeData.setThreadId(this.ciZ);
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

    public MarkData iS(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.cjp == null || this.cjp.aeP() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjp.aeP();
        if (aeP.size() > 0 && i == aeP.size()) {
            i = aeP.size() - 1;
        }
        if (aeP.size() <= 0 || i >= aeP.size()) {
            return null;
        }
        return d(aeP.get(i));
    }

    public MarkData afV() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ciZ);
        markData.setPostId(this.cjp.qj());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cjb);
        markData.setSequence(Boolean.valueOf(this.cjd));
        markData.setId(this.ciZ);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ciZ);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cjb);
        markData.setSequence(Boolean.valueOf(this.cjd));
        markData.setId(this.ciZ);
        markData.setFloor(kVar.awy());
        if (kVar instanceof com.baidu.tieba.pb.a.a) {
            markData.setApp(true);
        } else if (kVar instanceof com.baidu.tieba.tbadkCore.data.j) {
            markData.setApp(((com.baidu.tieba.tbadkCore.data.j) kVar).isApp());
        }
        return markData;
    }

    public void afW() {
        bj.afH().z(afX(), this.isFromMark);
    }

    private String afX() {
        String str = this.ciZ;
        if (this.cjb) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cjd) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ez(boolean z) {
        if (this.cjp != null) {
            this.cjp.ab(z);
        }
    }

    public void eA(boolean z) {
        this.cju = z;
    }

    public void a(a aVar) {
        this.cjr = aVar;
    }

    public void jv(String str) {
        this.postID = str;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return this.postID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bk() {
        return CS();
    }

    public boolean jO(String str) {
        if (getPbData() == null || getPbData().aeO() == null || getPbData().aeO().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aeO().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }
}
