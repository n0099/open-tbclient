package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.PbModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class el {
    private boolean efY;
    private String ekf;
    private com.baidu.tieba.pb.data.f ekv;
    private int ekw;
    private boolean eng;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int Gs = 1;
    private int bqV = 1;
    private boolean enf = false;
    private PbModel.a ekA = null;
    private com.baidu.adp.framework.listener.a doj = new em(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public el() {
        MessageManager.getInstance().registerListener(this.doj);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.doj);
    }

    public boolean oq(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.ekf = str;
        return oz(1);
    }

    public boolean aNf() {
        this.eng = !this.eng;
        this.mPostId = aLg();
        oz(6);
        return true;
    }

    public boolean oz(int i) {
        oE(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asp);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ekf == null || this.ekf.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ekf, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.au.vg().vi() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(I));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(J));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eng) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Gs - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Gs - 1));
                    }
                } else if (this.Gs < this.bqV) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Gs + 1));
                }
                if (this.mPostId != null && this.mPostId.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.mPostId, 0L));
                    break;
                } else if (!this.isSquence) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.c(this.mPostId, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.efY));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aLg() {
        if (this.ekv == null || this.ekv.aKb() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.ekv.aKb();
        if (com.baidu.tbadk.core.util.w.r(aKb) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.p> it = aKb.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.p next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && oo(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean oo(String str) {
        if (getPbData() == null || getPbData().aJZ() == null || getPbData().aJZ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJZ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.ekA = aVar;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.isLoading = false;
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList;
        oF(i);
        if (fVar == null) {
            if (this.ekA != null) {
                this.ekA.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.getPage() != null) {
            this.Gs = fVar.getPage().qv();
            this.bqV = fVar.getPage().qs();
            this.hasMore = fVar.getPage().qx() != 0;
        }
        this.bqV = this.bqV < 1 ? 1 : this.bqV;
        if (this.ekv != null && this.ekv.aKb() != null) {
            arrayList = this.ekv.aKb();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.ekv.a(fVar.getPage(), 1);
                b(fVar, arrayList);
                break;
            case 6:
                i(fVar);
                break;
        }
        if (this.ekA != null) {
            this.ekA.a(true, i2, i, 0, this.ekv, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        String ak;
        if (arrayList != null && fVar.aKb() != null) {
            com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(fVar.aKb(), 0);
            if (pVar != null && (ak = ak(arrayList)) != null && ak.equals(pVar.getId())) {
                fVar.aKb().remove(pVar);
            }
            arrayList.addAll(fVar.aKb());
        }
    }

    private String ak(ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        int r = com.baidu.tbadk.core.util.w.r(arrayList);
        if (r <= 0) {
            return null;
        }
        for (int i = r - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(arrayList, i);
            if (pVar != null && !StringUtils.isNull(pVar.getId())) {
                return pVar.getId();
            }
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.ekv = fVar;
        if (fVar != null) {
            this.ekf = this.ekv.getThreadId();
        }
        if (fVar != null && fVar.getPage() != null) {
            this.Gs = fVar.getPage().qv();
            this.bqV = fVar.getPage().qs();
            this.hasMore = fVar.getPage().qx() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ekv;
    }

    public boolean aNg() {
        return this.isSquence;
    }

    public void iJ(boolean z) {
        this.isSquence = z;
    }

    public boolean aNh() {
        return this.eng;
    }

    public void setHostMode(boolean z) {
        this.eng = z;
    }

    public void oE(int i) {
        this.mRequestType = i;
    }

    public void oF(int i) {
        this.ekw = i;
    }

    public void iK(boolean z) {
        this.efY = z;
    }

    public void setThreadId(String str) {
        this.ekf = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iL(boolean z) {
        this.enf = z;
    }
}
