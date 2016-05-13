package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.cw;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ec {
    private com.baidu.tieba.pb.data.e dfY;
    private boolean dfy;
    private String dkY;
    private int dlp;
    private boolean dmP;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean avz = false;
    private int Eo = 1;
    private int dli = 1;
    private boolean dmO = false;
    private cw.a dlr = null;
    private com.baidu.adp.framework.listener.a cCX = new ed(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ec() {
        MessageManager.getInstance().registerListener(this.cCX);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cCX);
    }

    public boolean lZ(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.dkY = str;
        return lR(1);
    }

    public boolean ayA() {
        this.dmP = !this.dmP;
        this.mPostId = awN();
        lR(6);
        return true;
    }

    public boolean lR(int i) {
        lV(i);
        if (this.avz) {
            return false;
        }
        this.avz = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aov);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.dkY == null || this.dkY.length() == 0) {
            this.avz = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.dkY, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst().getApp());
        int C = com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getApp());
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.az.ug().ui() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(C));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.dmP) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Eo - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Eo - 1));
                    }
                } else if (this.Eo < this.dli) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Eo + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.dfy));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m11getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String awN() {
        if (this.dfY == null || this.dfY.avF() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfY.avF();
        if (com.baidu.tbadk.core.util.y.r(avF) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.s> it = avF.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.s next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && lY(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean lY(String str) {
        if (getPbData() == null || getPbData().avE() == null || getPbData().avE().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().avE().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(cw.a aVar) {
        this.dlr = aVar;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.avz = false;
        a(eVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList;
        lW(i);
        if (eVar == null) {
            if (this.dlr != null) {
                this.dlr.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (eVar.getPage() != null) {
            this.Eo = eVar.getPage().pI();
            this.dli = eVar.getPage().pF();
            this.hasMore = eVar.getPage().pK() != 0;
        }
        this.dli = this.dli < 1 ? 1 : this.dli;
        if (this.dfY != null && this.dfY.avF() != null) {
            arrayList = this.dfY.avF();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.dfY.a(eVar.getPage(), 1);
                a(eVar, arrayList);
                break;
            case 6:
                i(eVar);
                break;
        }
        if (this.dlr != null) {
            this.dlr.a(true, i2, i, 0, this.dfY, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        setPbData(eVar);
    }

    protected void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String Z;
        if (arrayList != null && eVar.avF() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(eVar.avF(), 0);
            if (sVar != null && (Z = Z(arrayList)) != null && Z.equals(sVar.getId())) {
                eVar.avF().remove(sVar);
            }
            arrayList.addAll(eVar.avF());
        }
    }

    private String Z(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int r = com.baidu.tbadk.core.util.y.r(arrayList);
        if (r <= 0) {
            return null;
        }
        for (int i = r - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (sVar != null && !StringUtils.isNull(sVar.getId())) {
                return sVar.getId();
            }
        }
        return null;
    }

    public void m(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.dfY = eVar;
        if (eVar != null) {
            this.dkY = this.dfY.getThreadId();
        }
        if (eVar != null && eVar.getPage() != null) {
            this.Eo = eVar.getPage().pI();
            this.dli = eVar.getPage().pF();
            this.hasMore = eVar.getPage().pK() != 0;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.dfY;
    }

    public boolean ayB() {
        return this.isSquence;
    }

    public void gM(boolean z) {
        this.isSquence = z;
    }

    public boolean ayC() {
        return this.dmP;
    }

    public void setHostMode(boolean z) {
        this.dmP = z;
    }

    public void lV(int i) {
        this.mRequestType = i;
    }

    public void lW(int i) {
        this.dlp = i;
    }

    public void gN(boolean z) {
        this.dfy = z;
    }

    public void setThreadId(String str) {
        this.dkY = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void gO(boolean z) {
        this.dmO = z;
    }
}
