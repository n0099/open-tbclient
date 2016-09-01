package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.dh;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ek {
    private boolean ekF;
    private String epi;
    private com.baidu.tieba.pb.data.h epx;
    private int epy;
    private boolean erC;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean aAl = false;
    private int Hh = 1;
    private int ecm = 1;
    private boolean erB = false;
    private dh.a epB = null;
    private com.baidu.adp.framework.listener.a dxc = new el(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ek() {
        MessageManager.getInstance().registerListener(this.dxc);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxc);
    }

    public boolean oW(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.epi = str;
        return om(1);
    }

    public boolean aON() {
        this.erC = !this.erC;
        this.mPostId = aMX();
        om(6);
        return true;
    }

    public boolean om(int i) {
        oq(i);
        if (this.aAl) {
            return false;
        }
        this.aAl = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.atg);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.epi == null || this.epi.length() == 0) {
            this.aAl = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.epi, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.vk().vm() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.erC) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.Hh - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.Hh - 1));
                    }
                } else if (this.Hh < this.ecm) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.Hh + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.ekF));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aMX() {
        if (this.epx == null || this.epx.aLR() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.epx.aLR();
        if (com.baidu.tbadk.core.util.y.s(aLR) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.q> it = aLR.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.q next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && oV(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean oV(String str) {
        if (getPbData() == null || getPbData().aLQ() == null || getPbData().aLQ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aLQ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dh.a aVar) {
        this.epB = aVar;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.aAl = false;
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
        or(i);
        if (hVar == null) {
            if (this.epB != null) {
                this.epB.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (hVar.getPage() != null) {
            this.Hh = hVar.getPage().qo();
            this.ecm = hVar.getPage().ql();
            this.hasMore = hVar.getPage().qq() != 0;
        }
        this.ecm = this.ecm < 1 ? 1 : this.ecm;
        if (this.epx != null && this.epx.aLR() != null) {
            arrayList = this.epx.aLR();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.epx.a(hVar.getPage(), 1);
                a(hVar, arrayList);
                break;
            case 6:
                i(hVar);
                break;
        }
        if (this.epB != null) {
            this.epB.a(true, i2, i, 0, this.epx, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.h hVar) {
        setPbData(hVar);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String al;
        if (arrayList != null && hVar.aLR() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aLR(), 0);
            if (qVar != null && (al = al(arrayList)) != null && al.equals(qVar.getId())) {
                hVar.aLR().remove(qVar);
            }
            arrayList.addAll(hVar.aLR());
        }
    }

    private String al(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(arrayList, i);
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
        this.epx = hVar;
        if (hVar != null) {
            this.epi = this.epx.getThreadId();
        }
        if (hVar != null && hVar.getPage() != null) {
            this.Hh = hVar.getPage().qo();
            this.ecm = hVar.getPage().ql();
            this.hasMore = hVar.getPage().qq() != 0;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.epx;
    }

    public boolean aOO() {
        return this.isSquence;
    }

    public void im(boolean z) {
        this.isSquence = z;
    }

    public boolean aOP() {
        return this.erC;
    }

    public void setHostMode(boolean z) {
        this.erC = z;
    }

    public void oq(int i) {
        this.mRequestType = i;
    }

    public void or(int i) {
        this.epy = i;
    }

    public void in(boolean z) {
        this.ekF = z;
    }

    public void setThreadId(String str) {
        this.epi = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void io(boolean z) {
        this.erB = z;
    }
}
