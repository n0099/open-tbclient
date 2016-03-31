package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.df;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class el {
    private com.baidu.tieba.pb.data.e ddF;
    private boolean dde;
    private String diD;
    private int diV;
    private boolean dkq;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean azx = false;
    private int NY = 1;
    private int diO = 1;
    private boolean dkp = false;
    private df.c diX = null;
    private com.baidu.adp.framework.listener.a cBX = new em(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public el() {
        MessageManager.getInstance().registerListener(this.cBX);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cBX);
    }

    public boolean lZ(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.diD = str;
        return mc(1);
    }

    public boolean axY() {
        this.dkq = !this.dkq;
        this.mPostId = awC();
        mc(6);
        return true;
    }

    public boolean mc(int i) {
        mh(i);
        if (this.azx) {
            return false;
        }
        this.azx = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asE);
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
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.dkq) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.NY - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.NY - 1));
                    }
                } else if (this.NY < this.diO) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.NY + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.dde));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m411getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String awC() {
        if (this.ddF == null || this.ddF.avw() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddF.avw();
        if (com.baidu.tbadk.core.util.y.p(avw) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.s> it = avw.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.s next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && lY(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean lY(String str) {
        if (getPbData() == null || getPbData().avv() == null || getPbData().avv().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().avv().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(df.c cVar) {
        this.diX = cVar;
    }

    public void a(com.baidu.tieba.pb.data.e eVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.e eVar2 = z ? null : eVar;
        this.azx = false;
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
        mi(i);
        if (eVar == null) {
            if (this.diX != null) {
                this.diX.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (eVar.getPage() != null) {
            this.NY = eVar.getPage().so();
            this.diO = eVar.getPage().sl();
            this.hasMore = eVar.getPage().sq() != 0;
        }
        this.diO = this.diO < 1 ? 1 : this.diO;
        if (this.ddF != null && this.ddF.avw() != null) {
            arrayList = this.ddF.avw();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.ddF.a(eVar.getPage(), 1);
                a(eVar, arrayList);
                break;
            case 6:
                i(eVar);
                break;
        }
        if (this.diX != null) {
            this.diX.a(true, i2, i, 0, this.ddF, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.e eVar) {
        setPbData(eVar);
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

    public void m(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.e eVar) {
        this.ddF = eVar;
        if (eVar != null) {
            this.diD = this.ddF.getThreadId();
        }
        if (eVar != null && eVar.getPage() != null) {
            this.NY = eVar.getPage().so();
            this.diO = eVar.getPage().sl();
            this.hasMore = eVar.getPage().sq() != 0;
        }
    }

    public com.baidu.tieba.pb.data.e getPbData() {
        return this.ddF;
    }

    public boolean axZ() {
        return this.isSquence;
    }

    public void gj(boolean z) {
        this.isSquence = z;
    }

    public boolean axT() {
        return this.dkq;
    }

    public void setHostMode(boolean z) {
        this.dkq = z;
    }

    public void mh(int i) {
        this.mRequestType = i;
    }

    public void mi(int i) {
        this.diV = i;
    }

    public void gk(boolean z) {
        this.dde = z;
    }

    public void setThreadId(String str) {
        this.diD = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void gl(boolean z) {
        this.dkp = z;
    }
}
