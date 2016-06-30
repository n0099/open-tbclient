package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.dg;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ej {
    private boolean dMr;
    private String dQO;
    private com.baidu.tieba.pb.data.h dRe;
    private int dRf;
    private boolean dTg;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean awp = false;
    private int Eu = 1;
    private int dQX = 1;
    private boolean dTf = false;
    private dg.a dRi = null;
    private com.baidu.adp.framework.listener.a div = new ek(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ej() {
        MessageManager.getInstance().registerListener(this.div);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.div);
    }

    public boolean nA(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.dQO = str;
        return nq(1);
    }

    public boolean aGJ() {
        this.dTg = !this.dTg;
        this.mPostId = aEU();
        nq(6);
        return true;
    }

    public boolean nq(int i) {
        nu(i);
        if (this.awp) {
            return false;
        }
        this.awp = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apj);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.dQO == null || this.dQO.length() == 0) {
            this.awp = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.dQO, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.uf().uh() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(A));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.dTg) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Eu - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Eu - 1));
                    }
                } else if (this.Eu < this.dQX) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Eu + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.dMr));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aEU() {
        if (this.dRe == null || this.dRe.aDP() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dRe.aDP();
        if (com.baidu.tbadk.core.util.y.s(aDP) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.s> it = aDP.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.s next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nz(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nz(String str) {
        if (getPbData() == null || getPbData().aDO() == null || getPbData().aDO().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aDO().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dg.a aVar) {
        this.dRi = aVar;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.awp = false;
        a(hVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList;
        nv(i);
        if (hVar == null) {
            if (this.dRi != null) {
                this.dRi.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (hVar.getPage() != null) {
            this.Eu = hVar.getPage().pC();
            this.dQX = hVar.getPage().pz();
            this.hasMore = hVar.getPage().pE() != 0;
        }
        this.dQX = this.dQX < 1 ? 1 : this.dQX;
        if (this.dRe != null && this.dRe.aDP() != null) {
            arrayList = this.dRe.aDP();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.dRe.a(hVar.getPage(), 1);
                a(hVar, arrayList);
                break;
            case 6:
                i(hVar);
                break;
        }
        if (this.dRi != null) {
            this.dRi.a(true, i2, i, 0, this.dRe, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.h hVar) {
        setPbData(hVar);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String aj;
        if (arrayList != null && hVar.aDP() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aDP(), 0);
            if (sVar != null && (aj = aj(arrayList)) != null && aj.equals(sVar.getId())) {
                hVar.aDP().remove(sVar);
            }
            arrayList.addAll(hVar.aDP());
        }
    }

    private String aj(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.h hVar) {
        this.dRe = hVar;
        if (hVar != null) {
            this.dQO = this.dRe.getThreadId();
        }
        if (hVar != null && hVar.getPage() != null) {
            this.Eu = hVar.getPage().pC();
            this.dQX = hVar.getPage().pz();
            this.hasMore = hVar.getPage().pE() != 0;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.dRe;
    }

    public boolean aGK() {
        return this.isSquence;
    }

    public void hF(boolean z) {
        this.isSquence = z;
    }

    public boolean aGL() {
        return this.dTg;
    }

    public void setHostMode(boolean z) {
        this.dTg = z;
    }

    public void nu(int i) {
        this.mRequestType = i;
    }

    public void nv(int i) {
        this.dRf = i;
    }

    public void hG(boolean z) {
        this.dMr = z;
    }

    public void setThreadId(String str) {
        this.dQO = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void hH(boolean z) {
        this.dTf = z;
    }
}
