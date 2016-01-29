package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.cm;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class dq {
    private boolean cJN;
    private com.baidu.tieba.pb.a.c cKn;
    private int cOJ;
    private String cOs;
    private boolean cPZ;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean ayQ = false;
    private int NQ = 1;
    private int cOD = 1;
    private boolean cPY = false;
    private cm.c cOL = null;
    private com.baidu.adp.framework.listener.a crx = new dr(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public dq() {
        MessageManager.getInstance().registerListener(this.crx);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.crx);
    }

    public boolean kM(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.cOs = str;
        return kU(1);
    }

    public boolean aqI() {
        this.cPZ = !this.cPZ;
        this.mPostId = apB();
        kU(6);
        return true;
    }

    public boolean kU(int i) {
        kZ(i);
        if (this.ayQ) {
            return false;
        }
        this.ayQ = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asm);
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
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.cPZ) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.NQ - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.NQ - 1));
                    }
                } else if (this.NQ < this.cOD) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.NQ + 1));
                }
                if (this.mPostId != null && this.mPostId.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.mPostId, 0L));
                    break;
                } else if (!this.isSquence) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.h.b.c(this.mPostId, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.cJN));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m411getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String apB() {
        if (this.cKn == null || this.cKn.aoG() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cKn.aoG();
        if (com.baidu.tbadk.core.util.x.o(aoG) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.r> it = aoG.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.r next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && kL(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean kL(String str) {
        if (getPbData() == null || getPbData().aoF() == null || getPbData().aoF().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aoF().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(cm.c cVar) {
        this.cOL = cVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.a.c cVar2 = z ? null : cVar;
        this.ayQ = false;
        a(cVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.a.c cVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList;
        la(i);
        if (cVar == null) {
            if (this.cOL != null) {
                this.cOL.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (cVar.getPage() != null) {
            this.NQ = cVar.getPage().st();
            this.cOD = cVar.getPage().sq();
            this.hasMore = cVar.getPage().sv() != 0;
        }
        this.cOD = this.cOD < 1 ? 1 : this.cOD;
        if (this.cKn != null && this.cKn.aoG() != null) {
            arrayList = this.cKn.aoG();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.cKn.a(cVar.getPage(), 1);
                a(cVar, arrayList);
                break;
            case 6:
                i(cVar);
                break;
        }
        if (this.cOL != null) {
            this.cOL.a(true, i2, i, 0, this.cKn, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.a.c cVar) {
        setPbData(cVar);
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

    public void l(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.a.c cVar) {
        this.cKn = cVar;
        if (cVar != null) {
            this.cOs = this.cKn.getThreadId();
        }
        if (cVar != null && cVar.getPage() != null) {
            this.NQ = cVar.getPage().st();
            this.cOD = cVar.getPage().sq();
            this.hasMore = cVar.getPage().sv() != 0;
        }
    }

    public com.baidu.tieba.pb.a.c getPbData() {
        return this.cKn;
    }

    public boolean aqJ() {
        return this.isSquence;
    }

    public void fz(boolean z) {
        this.isSquence = z;
    }

    public boolean aqD() {
        return this.cPZ;
    }

    public void setHostMode(boolean z) {
        this.cPZ = z;
    }

    public void kZ(int i) {
        this.mRequestType = i;
    }

    public void la(int i) {
        this.cOJ = i;
    }

    public void fA(boolean z) {
        this.cJN = z;
    }

    public void setThreadId(String str) {
        this.cOs = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void fB(boolean z) {
        this.cPY = z;
    }
}
