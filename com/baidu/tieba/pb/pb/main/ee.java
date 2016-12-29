package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.dc;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ee {
    private boolean dXc;
    private com.baidu.tieba.pb.data.f ebE;
    private int ebF;
    private String ebo;
    private boolean eel;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean aAd = false;
    private int Hi = 1;
    private int dOM = 1;
    private boolean eek = false;
    private dc.a ebJ = null;
    private com.baidu.adp.framework.listener.a dgZ = new ef(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ee() {
        MessageManager.getInstance().registerListener(this.dgZ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dgZ);
    }

    public boolean nZ(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.ebo = str;
        return nI(1);
    }

    public boolean aLr() {
        this.eel = !this.eel;
        this.mPostId = aJt();
        nI(6);
        return true;
    }

    public boolean nI(int i) {
        nN(i);
        if (this.aAd) {
            return false;
        }
        this.aAd = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atj);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ebo == null || this.ebo.length() == 0) {
            this.aAd = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.ebo, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.aw.vm().vo() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(I));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(J));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eel) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Hi - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Hi - 1));
                    }
                } else if (this.Hi < this.dOM) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Hi + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.dXc));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aJt() {
        if (this.ebE == null || this.ebE.aIm() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.ebE.aIm();
        if (com.baidu.tbadk.core.util.x.s(aIm) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.q> it = aIm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.q next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nX(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nX(String str) {
        if (getPbData() == null || getPbData().aIl() == null || getPbData().aIl().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aIl().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dc.a aVar) {
        this.ebJ = aVar;
    }

    public void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.f fVar2 = z ? null : fVar;
        this.aAd = false;
        a(fVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList;
        nO(i);
        if (fVar == null) {
            if (this.ebJ != null) {
                this.ebJ.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.getPage() != null) {
            this.Hi = fVar.getPage().qC();
            this.dOM = fVar.getPage().qz();
            this.hasMore = fVar.getPage().qE() != 0;
        }
        this.dOM = this.dOM < 1 ? 1 : this.dOM;
        if (this.ebE != null && this.ebE.aIm() != null) {
            arrayList = this.ebE.aIm();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.ebE.a(fVar.getPage(), 1);
                a(fVar, arrayList);
                break;
            case 6:
                i(fVar);
                break;
        }
        if (this.ebJ != null) {
            this.ebJ.a(true, i2, i, 0, this.ebE, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String af;
        if (arrayList != null && fVar.aIm() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(fVar.aIm(), 0);
            if (qVar != null && (af = af(arrayList)) != null && af.equals(qVar.getId())) {
                fVar.aIm().remove(qVar);
            }
            arrayList.addAll(fVar.aIm());
        }
    }

    private String af(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
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

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.ebE = fVar;
        if (fVar != null) {
            this.ebo = this.ebE.getThreadId();
        }
        if (fVar != null && fVar.getPage() != null) {
            this.Hi = fVar.getPage().qC();
            this.dOM = fVar.getPage().qz();
            this.hasMore = fVar.getPage().qE() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ebE;
    }

    public boolean aLs() {
        return this.isSquence;
    }

    public void iz(boolean z) {
        this.isSquence = z;
    }

    public boolean aLt() {
        return this.eel;
    }

    public void setHostMode(boolean z) {
        this.eel = z;
    }

    public void nN(int i) {
        this.mRequestType = i;
    }

    public void nO(int i) {
        this.ebF = i;
    }

    public void iA(boolean z) {
        this.dXc = z;
    }

    public void setThreadId(String str) {
        this.ebo = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iB(boolean z) {
        this.eek = z;
    }
}
