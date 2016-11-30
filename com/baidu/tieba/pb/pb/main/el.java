package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.dj;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class el {
    private boolean eAc;
    private boolean esE;
    private String ewZ;
    private com.baidu.tieba.pb.data.h exo;
    private int exp;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean aAG = false;
    private int Hj = 1;
    private int eke = 1;
    private boolean eAb = false;
    private dj.a exs = null;
    private com.baidu.adp.framework.listener.a dEb = new em(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public el() {
        MessageManager.getInstance().registerListener(this.dEb);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dEb);
    }

    public boolean py(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.ewZ = str;
        return oG(1);
    }

    public boolean aRx() {
        this.eAc = !this.eAc;
        this.mPostId = aPu();
        oG(6);
        return true;
    }

    public boolean oG(int i) {
        oL(i);
        if (this.aAG) {
            return false;
        }
        this.aAG = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atE);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ewZ == null || this.ewZ.length() == 0) {
            this.aAG = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.ewZ, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ay.vC().vE() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eAc) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Hj - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Hj - 1));
                    }
                } else if (this.Hj < this.eke) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Hj + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.esE));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aPu() {
        if (this.exo == null || this.exo.aOm() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.exo.aOm();
        if (com.baidu.tbadk.core.util.x.s(aOm) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.q> it = aOm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.q next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && px(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean px(String str) {
        if (getPbData() == null || getPbData().aOl() == null || getPbData().aOl().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aOl().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dj.a aVar) {
        this.exs = aVar;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.aAG = false;
        a(hVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList;
        oM(i);
        if (hVar == null) {
            if (this.exs != null) {
                this.exs.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (hVar.getPage() != null) {
            this.Hj = hVar.getPage().qB();
            this.eke = hVar.getPage().qy();
            this.hasMore = hVar.getPage().qD() != 0;
        }
        this.eke = this.eke < 1 ? 1 : this.eke;
        if (this.exo != null && this.exo.aOm() != null) {
            arrayList = this.exo.aOm();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.exo.a(hVar.getPage(), 1);
                a(hVar, arrayList);
                break;
            case 6:
                i(hVar);
                break;
        }
        if (this.exs != null) {
            this.exs.a(true, i2, i, 0, this.exo, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.h hVar) {
        setPbData(hVar);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String ao;
        if (arrayList != null && hVar.aOm() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(hVar.aOm(), 0);
            if (qVar != null && (ao = ao(arrayList)) != null && ao.equals(qVar.getId())) {
                hVar.aOm().remove(qVar);
            }
            arrayList.addAll(hVar.aOm());
        }
    }

    private String ao(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.x.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (qVar != null && !StringUtils.isNull(qVar.getId())) {
                return qVar.getId();
            }
        }
        return null;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.h hVar) {
        this.exo = hVar;
        if (hVar != null) {
            this.ewZ = this.exo.getThreadId();
        }
        if (hVar != null && hVar.getPage() != null) {
            this.Hj = hVar.getPage().qB();
            this.eke = hVar.getPage().qy();
            this.hasMore = hVar.getPage().qD() != 0;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.exo;
    }

    public boolean aRy() {
        return this.isSquence;
    }

    public void iN(boolean z) {
        this.isSquence = z;
    }

    public boolean aRz() {
        return this.eAc;
    }

    public void setHostMode(boolean z) {
        this.eAc = z;
    }

    public void oL(int i) {
        this.mRequestType = i;
    }

    public void oM(int i) {
        this.exp = i;
    }

    public void iO(boolean z) {
        this.esE = z;
    }

    public void setThreadId(String str) {
        this.ewZ = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iP(boolean z) {
        this.eAb = z;
    }
}
