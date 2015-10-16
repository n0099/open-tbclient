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
    private CustomMessageListener aHA;
    private com.baidu.tieba.tbadkCore.e.a aMl;
    private long aMm;
    private long aMn;
    private long aMo;
    private long aMp;
    private String aPd;
    private BaseActivity aSe;
    private boolean avC;
    protected com.baidu.tieba.pb.a.b cjA;
    protected int cjB;
    private a cjC;
    private String cjD;
    private String cjE;
    private boolean cjF;
    private boolean cjG;
    private boolean cjH;
    private boolean cjI;
    private int cjJ;
    private com.baidu.adp.framework.listener.a cjK;
    private PraiseData cjL;
    protected String cjk;
    private String cjl;
    private boolean cjm;
    private boolean cjn;
    private boolean cjo;
    private int cjp;
    private int cjq;
    private long cjr;
    private int cjs;
    private int cjt;
    private int cju;
    private int cjv;
    private boolean cjw;
    private boolean cjx;
    private long cjy;
    private boolean cjz;
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
        this.cjI = z;
    }

    public bl(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.aPd = null;
        this.cjk = null;
        this.cjl = null;
        this.cjm = false;
        this.cjn = true;
        this.cjo = true;
        this.cjp = 0;
        this.cjq = 0;
        this.cjr = 0L;
        this.cjs = 1;
        this.cjt = 1;
        this.cju = 1;
        this.cjv = 1;
        this.isAd = false;
        this.cjw = false;
        this.cjx = false;
        this.isFromMark = false;
        this.cjy = 0L;
        this.cjz = false;
        this.mForumName = null;
        this.cjA = null;
        this.avC = false;
        this.mContext = null;
        this.cjC = null;
        this.aMm = 0L;
        this.aMn = 0L;
        this.aMo = 0L;
        this.aMp = 0L;
        this.opType = null;
        this.opUrl = null;
        this.cjD = null;
        this.cjE = null;
        this.aMl = null;
        this.cjG = false;
        this.postID = null;
        this.cjI = false;
        this.cjJ = -1;
        this.aHA = new bm(this, CmdConfigCustom.PB_PAGE_CACHE_CMD);
        this.cjK = new bo(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.cjL = null;
        registerListener(this.aHA);
        registerListener(this.cjK);
        this.cjA = new com.baidu.tieba.pb.a.b();
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aSe = baseActivity;
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
        this.cjk = intent.getStringExtra("thread_id");
        if (StringUtils.isNull(this.cjk)) {
            this.cjk = Q(intent);
        }
        this.cjl = intent.getStringExtra("post_id");
        this.cjm = intent.getBooleanExtra(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cjo = intent.getBooleanExtra(PbActivityConfig.KEY_SQUENCE, true);
        this.aPd = intent.getStringExtra("st_type");
        this.cjp = intent.getIntExtra(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cjq = intent.getIntExtra(PbActivityConfig.KEY_IS_TOP, 0);
        this.cjr = intent.getLongExtra(PbActivityConfig.KEY_THREAD_TIME, 0L);
        this.cjx = intent.getBooleanExtra("from_frs", false);
        this.isFromMark = intent.getBooleanExtra("from_mark", false);
        this.isAd = intent.getBooleanExtra("is_ad", false);
        this.cjw = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cjz = intent.getBooleanExtra("is_pv", false);
        this.cjy = intent.getLongExtra(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = intent.getStringExtra("forum_name");
        this.cjE = intent.getStringExtra(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
        this.opType = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_TYPE);
        this.opUrl = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_URL);
        this.cjD = intent.getStringExtra(PbActivityConfig.KEY_MSG_OP_STAT);
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
        this.cjk = bundle.getString("thread_id");
        this.cjl = bundle.getString("post_id");
        this.cjm = bundle.getBoolean(PbActivityConfig.KEY_HOST_ONLY, false);
        this.cjo = bundle.getBoolean(PbActivityConfig.KEY_SQUENCE, true);
        this.aPd = bundle.getString("st_type");
        this.cjp = bundle.getInt(PbActivityConfig.KEY_IS_GOOD, 0);
        this.cjq = bundle.getInt(PbActivityConfig.KEY_IS_TOP, 0);
        this.cjr = bundle.getLong(PbActivityConfig.KEY_THREAD_TIME);
        this.cjx = bundle.getBoolean("from_frs", false);
        this.isFromMark = bundle.getBoolean("from_mark", false);
        this.isAd = bundle.getBoolean("is_ad", false);
        this.cjw = bundle.getBoolean(PbActivityConfig.KEY_IS_SUB_PB, false);
        this.cjz = bundle.getBoolean("is_pv", false);
        this.cjy = bundle.getLong(PbActivityConfig.KEY_MSG_ID, 0L);
        this.mForumName = bundle.getString("forum_name");
        this.cjE = bundle.getString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("thread_id", this.cjk);
        bundle.putString("post_id", this.cjl);
        bundle.putBoolean(PbActivityConfig.KEY_HOST_ONLY, this.cjm);
        bundle.putBoolean(PbActivityConfig.KEY_SQUENCE, this.cjo);
        bundle.putString("st_type", this.aPd);
        bundle.putInt(PbActivityConfig.KEY_IS_GOOD, this.cjp);
        bundle.putInt(PbActivityConfig.KEY_IS_TOP, this.cjq);
        bundle.putLong(PbActivityConfig.KEY_THREAD_TIME, this.cjr);
        bundle.putBoolean("from_frs", this.cjx);
        bundle.putBoolean("from_mark", this.isFromMark);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SUB_PB, this.cjw);
        bundle.putBoolean("is_ad", this.isAd);
        bundle.putBoolean("is_pv", this.cjz);
        bundle.putLong(PbActivityConfig.KEY_MSG_ID, this.cjy);
        bundle.putString(PbActivityConfig.KEY_INTENT_EXTRA_PB_CACHE_KEY, this.cjE);
    }

    public String afJ() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.cjk);
        sb.append(this.cjl);
        sb.append(this.cjm);
        sb.append(this.cjo);
        sb.append(this.aPd);
        sb.append(this.cjp);
        sb.append(this.cjq);
        sb.append(this.cjr);
        sb.append(this.cjx);
        sb.append(this.isFromMark);
        sb.append(this.isAd);
        sb.append(this.cjw);
        sb.append(this.cjz);
        sb.append(this.cjy);
        sb.append(this.mForumName);
        if (this.cjE != null) {
            sb.append(this.cjE);
        }
        return sb.toString();
    }

    public String afK() {
        return this.mForumName;
    }

    public String getPostId() {
        return this.cjl;
    }

    public String getThreadID() {
        return this.cjk;
    }

    public boolean getHostMode() {
        return this.cjm;
    }

    public boolean afL() {
        return this.cjo;
    }

    public boolean afM() {
        return this.cjx;
    }

    public boolean getIsFromMark() {
        return this.isFromMark;
    }

    public boolean afN() {
        return HotTopicActivityConfig.ST_TYPE.equals(this.aPd);
    }

    public int getIsGood() {
        return this.cjp;
    }

    public int afO() {
        return this.cjq;
    }

    public void setIsGood(int i) {
        this.cjp = i;
    }

    public void iL(int i) {
        this.cjq = i;
    }

    public boolean afP() {
        return this.cjw;
    }

    public boolean afQ() {
        if (this.cjA == null) {
            return false;
        }
        return this.cjA.isValid();
    }

    public String sn() {
        if (this.cjA == null || !this.cjA.qk()) {
            return null;
        }
        return this.cjA.qj();
    }

    public boolean iM(int i) {
        this.cjs = i;
        if (this.cjs > this.cjA.getPage().rH()) {
            this.cjs = this.cjA.getPage().rH();
        }
        if (this.cjs < 1) {
            this.cjs = 1;
        }
        if (this.cjk == null) {
            return false;
        }
        return iQ(5);
    }

    public boolean iN(int i) {
        int sC = this.cjA.aeO().sC();
        if (i <= sC) {
            sC = i;
        }
        int i2 = sC >= 1 ? sC : 1;
        if (this.cjk == null) {
            return false;
        }
        this.cjJ = i2;
        return iQ(7);
    }

    public void iO(int i) {
        this.cjs = i;
        this.cjt = i;
        this.cju = i;
    }

    public void iP(int i) {
        if (this.cjt < i) {
            this.cjt = i;
            if (this.cjt - this.cju >= MAX_PAGE_NUM) {
                this.cju = (this.cjt - MAX_PAGE_NUM) + 1;
            }
        }
        if (this.cju > i) {
            this.cju = i;
            if (this.cjt - this.cju >= MAX_PAGE_NUM) {
                this.cjt = (this.cju + MAX_PAGE_NUM) - 1;
            }
        }
    }

    public com.baidu.tieba.pb.a.b getPbData() {
        return this.cjA;
    }

    public com.baidu.tbadk.core.data.o QV() {
        if (this.cjA == null) {
            return null;
        }
        return this.cjA.getPage();
    }

    public boolean afR() {
        if (this.cjo) {
            if (this.cjA.getPage().rL() == 0) {
                ex(true);
                return true;
            }
        } else if (this.cjA.getPage().rM() == 0) {
            ey(true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cjk == null) {
            return false;
        }
        cancelLoadData();
        if (this.aMl == null) {
            this.aMl = new com.baidu.tieba.tbadkCore.e.a("pbStat");
            this.aMl.start();
        }
        boolean iQ = iQ(3);
        if (this.opType != null) {
            this.opType = null;
            this.cjD = null;
            this.opUrl = null;
            return iQ;
        }
        return iQ;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        this.avC = false;
        return true;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        IC();
    }

    private void IC() {
        if (this.aMl != null) {
            this.aMl.destory();
            this.aMl = null;
        }
    }

    public boolean CS() {
        return (this.cjl == null || this.cjl.equals("0") || this.cjl.length() == 0) ? LoadData() : afS();
    }

    public boolean iQ(int i) {
        this.mRequestType = i;
        if (this.avC) {
            return false;
        }
        this.avC = true;
        iR(i);
        com.baidu.tieba.pb.a.b pbData = bx.age().getPbData();
        if (pbData != null && pbData.aeO() != null) {
            this.cjo = bx.age().afL();
            this.cjm = bx.age().agg();
            if (!this.cjo || this.cjm || this.isFromMark) {
                this.cjF = false;
            }
            a(pbData, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.cjC.eu(true);
            this.avC = false;
            return false;
        } else if (i == 4 && !this.cjH) {
            a(afX(), true, this.cjl, 3);
            this.avC = false;
            return true;
        } else if (i == 3 && !this.cjH) {
            if (this.isFromMark) {
                a(afX(), true, this.cjl, 3);
            } else {
                a(afX(), false, this.cjl, 3);
            }
            this.avC = false;
            return true;
        } else {
            this.cjH = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.anU);
            if (!this.cjo || this.cjm || this.isFromMark) {
                this.cjF = false;
            }
            try {
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (this.cjk == null || this.cjk.length() == 0) {
                this.avC = false;
                return false;
            }
            pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.cjk, 0L));
            pbPageRequestMessage.set_rn(30);
            pbPageRequestMessage.set_with_floor(1);
            int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
            int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
            float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = com.baidu.tbadk.core.util.at.uJ().uL() ? 2 : 1;
            pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
            pbPageRequestMessage.set_scr_dip(f);
            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
            if (!this.cjo) {
                pbPageRequestMessage.set_r(1);
            }
            if (this.cjm) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.aPd != null) {
                pbPageRequestMessage.set_st_type(this.aPd);
            }
            if (this.cjz) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.cjy));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.cjF) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.opType != null) {
                pbPageRequestMessage.setOpType(this.opType);
                pbPageRequestMessage.setOpUrl(this.opUrl);
                pbPageRequestMessage.setOpStat(com.baidu.adp.lib.g.b.g(this.cjD, 0));
                pbPageRequestMessage.setOpMessageID(this.cjy);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.cjB));
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjA.aeP();
            switch (i) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.isFromMark) {
                        if (!this.cjo) {
                            if (this.cju - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cju - 1));
                            }
                        } else if (this.cjt < this.cjv) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cjt + 1));
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
                                this.cjl = kVar.getId();
                                if (StringUtils.isNull(this.cjl)) {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (this.cjl != null && this.cjl.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cjl, 0L));
                        break;
                    } else if (!this.cjo) {
                        pbPageRequestMessage.set_last(1);
                        break;
                    }
                    break;
                case 2:
                    if (aeP != null && aeP.size() > 0 && aeP.get(0) != null) {
                        this.cjl = aeP.get(0).getId();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.isFromMark) {
                        if (this.cjo) {
                            if (this.cju - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.cju - 1));
                            }
                        } else if (this.cjt < this.cjv) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.cjt + 1));
                        }
                    }
                    if (this.cjl != null && this.cjl.length() > 0) {
                        pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cjl, 0L));
                        break;
                    }
                    break;
                case 3:
                    if (this.isFromMark) {
                        pbPageRequestMessage.set_banner(0);
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.cjo) {
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
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cjl, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.cjs));
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.cjl, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    break;
                case 7:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.setIsJumpFloor(true);
                    pbPageRequestMessage.setJumpFloorNum(this.cjJ);
                    break;
            }
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.isFromMark));
            pbPageRequestMessage.setCacheKey(afX());
            pbPageRequestMessage.setContext(this.mContext);
            pbPageRequestMessage.setIsSubPostDataReverse(this.cjI);
            sendMessage(pbPageRequestMessage);
            return true;
        }
    }

    protected void iR(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjA.aeP();
        if (i == 1) {
            boolean z2 = false;
            while (aeP.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aeP.remove(0);
                z2 = true;
            }
            if (z2) {
                this.cjA.getPage().bz(1);
                if (this.cjC != null) {
                    this.cjC.b(this.cjA);
                }
            }
        } else if (i == 2) {
            while (aeP.size() + 30 > com.baidu.tbadk.data.b.getPbListItemMaxNum()) {
                aeP.remove(aeP.size() - 1);
                z = true;
            }
            if (z) {
                this.cjA.getPage().by(1);
            }
        }
    }

    public void a(com.baidu.tieba.pb.a.b bVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.b bVar2 = z ? null : bVar;
        this.avC = false;
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
                for (int i2 = 0; i2 < kVar.awE().size(); i2++) {
                    kVar.awE().get(i2).a(this.aSe.getPageContext().getUniqueId(), f.equals(kVar.awE().get(i2).getAuthor().getUserId()));
                }
            }
        }
    }

    protected com.baidu.tieba.pb.a.b e(com.baidu.tieba.pb.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.baidu.tbadk.core.data.w aeO = bVar.aeO();
        aeO.bB(this.cjp);
        aeO.bA(this.cjq);
        if (this.cjr > 0) {
            aeO.m(this.cjr);
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
        if (this.aMl != null && !z3) {
            this.aMl.a(z2, z4, i2, str, i3, j, j2);
            this.aMl = null;
        }
        if (bVar == null) {
            if (this.cjC != null) {
                this.cjo = this.cjn;
                this.cjC.a(false, i2, i, 0, null, str, 1);
            }
        } else {
            this.cjn = this.cjo;
            this.cjz = false;
            if (bVar.getPage() != null) {
                iP(bVar.getPage().rJ());
                this.cjv = bVar.getPage().rH();
            }
            this.cjv = this.cjv < 1 ? 1 : this.cjv;
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjA.aeP();
            switch (i) {
                case 1:
                    this.cjA.a(bVar.getPage(), 1);
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
                    this.cjA.a(bVar.getPage(), 2);
                    i5 = i4;
                    break;
                case 3:
                    if (!this.cjo && bVar.getPage() != null) {
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
            if (this.cjA != null && this.cjA.aeO() != null) {
                PraiseData praise = this.cjA.aeO().getPraise();
                if (this.cjL != null && !praise.isPriaseDataValid()) {
                    this.cjA.aeO().setPraise(this.cjL);
                } else {
                    this.cjL = this.cjA.aeO().getPraise();
                    this.cjL.setPostId(this.cjA.aeO().ss());
                }
                if (bVar.getPage() != null && bVar.getPage().rJ() == 1) {
                    this.cjA.aeO().i(bVar.aeO().so());
                }
                this.cjA.aeO().setReply_num(bVar.aeO().getReply_num());
            }
            if (this.cjA != null && this.cjA.getUserData() != null && bVar.getUserData() != null) {
                this.cjA.getUserData().setBimg_end_time(bVar.getUserData().getBimg_end_time());
                this.cjA.getUserData().setBimg_url(bVar.getUserData().getBimg_url());
            }
            if (this.cjC != null) {
                this.cjC.a(true, getErrorCode(), i, i5, this.cjA, this.mErrorString, 1);
            }
        }
        if (this.cjA != null && this.cjA.getUserData() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(this.cjA.getUserData().getIsMem())));
        }
        if (this.cjA != null && this.cjA.aeO() != null && this.cjA.aeN() != null) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.aSe;
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
        this.cjA = bVar;
        iO(bVar.getPage().rJ());
    }

    public boolean afS() {
        if (this.cjk == null || this.cjl == null) {
            return false;
        }
        cancelMessage();
        if (this.isFromMark) {
            return iQ(4);
        }
        return iQ(6);
    }

    public boolean ex(boolean z) {
        if (this.cjk == null || this.cjA == null) {
            return false;
        }
        if (z || this.cjA.getPage().rL() != 0) {
            return iQ(1);
        }
        return false;
    }

    public boolean ey(boolean z) {
        if (this.cjk == null || this.cjA == null) {
            return false;
        }
        if ((z || this.cjA.getPage().rM() != 0) && this.cjA.aeP() != null && this.cjA.aeP().size() >= 1) {
            return iQ(2);
        }
        return false;
    }

    public boolean jN(String str) {
        this.cjm = !this.cjm;
        this.cjl = str;
        iQ(6);
        return true;
    }

    public boolean afT() {
        if (com.baidu.adp.lib.util.i.iM()) {
            this.cjn = this.cjo;
            this.cjo = !this.cjo;
        }
        return LoadData();
    }

    public boolean afU() {
        return this.cjo;
    }

    public boolean hasData() {
        return (this.cjA == null || this.cjA.aeN() == null || this.cjA.aeO() == null) ? false : true;
    }

    public boolean qk() {
        if (this.cjA == null) {
            return false;
        }
        return this.cjA.qk();
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
        if (this.cjA == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.cjA.aeN().getId());
        writeData.setForumName(this.cjA.aeN().getName());
        writeData.setThreadId(this.cjk);
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
        if (this.cjA == null || this.cjA.aeP() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cjA.aeP();
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
        markData.setThreadId(this.cjk);
        markData.setPostId(this.cjA.qj());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cjm);
        markData.setSequence(Boolean.valueOf(this.cjo));
        markData.setId(this.cjk);
        return markData;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.cjk);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(this.cjm);
        markData.setSequence(Boolean.valueOf(this.cjo));
        markData.setId(this.cjk);
        markData.setFloor(kVar.awI());
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
        String str = this.cjk;
        if (this.cjm) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.cjo) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkCoreApplication.getCurrentAccount();
        }
        return str;
    }

    public void ez(boolean z) {
        if (this.cjA != null) {
            this.cjA.ab(z);
        }
    }

    public void eA(boolean z) {
        this.cjF = z;
    }

    public void a(a aVar) {
        this.cjC = aVar;
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
