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
    private boolean emH;
    private String erg;
    private com.baidu.tieba.pb.data.h erv;
    private int erw;
    private boolean etL;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean azO = false;
    private int Hh = 1;
    private int eeh = 1;
    private boolean etK = false;
    private dh.a erz = null;
    private com.baidu.adp.framework.listener.a dyx = new el(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ek() {
        MessageManager.getInstance().registerListener(this.dyx);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dyx);
    }

    public boolean pl(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.erg = str;
        return ow(1);
    }

    public boolean aPw() {
        this.etL = !this.etL;
        this.mPostId = aND();
        ow(6);
        return true;
    }

    public boolean ow(int i) {
        oA(i);
        if (this.azO) {
            return false;
        }
        this.azO = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.asJ);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.erg == null || this.erg.length() == 0) {
            this.azO = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.erg, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ba.vy().vA() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(K));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(L));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.etL) {
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
                } else if (this.Hh < this.eeh) {
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.emH));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aND() {
        if (this.erv == null || this.erv.aMt() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.erv.aMt();
        if (com.baidu.tbadk.core.util.y.s(aMt) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.q> it = aMt.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.q next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && pk(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean pk(String str) {
        if (getPbData() == null || getPbData().aMs() == null || getPbData().aMs().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aMs().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dh.a aVar) {
        this.erz = aVar;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.azO = false;
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
        oB(i);
        if (hVar == null) {
            if (this.erz != null) {
                this.erz.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (hVar.getPage() != null) {
            this.Hh = hVar.getPage().qz();
            this.eeh = hVar.getPage().qw();
            this.hasMore = hVar.getPage().qB() != 0;
        }
        this.eeh = this.eeh < 1 ? 1 : this.eeh;
        if (this.erv != null && this.erv.aMt() != null) {
            arrayList = this.erv.aMt();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.erv.a(hVar.getPage(), 1);
                a(hVar, arrayList);
                break;
            case 6:
                i(hVar);
                break;
        }
        if (this.erz != null) {
            this.erz.a(true, i2, i, 0, this.erv, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.h hVar) {
        setPbData(hVar);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        String al;
        if (arrayList != null && hVar.aMt() != null) {
            com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.y.c(hVar.aMt(), 0);
            if (qVar != null && (al = al(arrayList)) != null && al.equals(qVar.getId())) {
                hVar.aMt().remove(qVar);
            }
            arrayList.addAll(hVar.aMt());
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
        this.erv = hVar;
        if (hVar != null) {
            this.erg = this.erv.getThreadId();
        }
        if (hVar != null && hVar.getPage() != null) {
            this.Hh = hVar.getPage().qz();
            this.eeh = hVar.getPage().qw();
            this.hasMore = hVar.getPage().qB() != 0;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.erv;
    }

    public boolean aPx() {
        return this.isSquence;
    }

    public void ip(boolean z) {
        this.isSquence = z;
    }

    public boolean aPy() {
        return this.etL;
    }

    public void setHostMode(boolean z) {
        this.etL = z;
    }

    public void oA(int i) {
        this.mRequestType = i;
    }

    public void oB(int i) {
        this.erw = i;
    }

    public void iq(boolean z) {
        this.emH = z;
    }

    public void setThreadId(String str) {
        this.erg = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void ir(boolean z) {
        this.etK = z;
    }
}
