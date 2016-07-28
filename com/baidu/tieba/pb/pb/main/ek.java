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
    private boolean dYB;
    private String edd;
    private com.baidu.tieba.pb.data.h eds;
    private int edt;
    private boolean efx;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean axe = false;
    private int EU = 1;
    private int dQh = 1;
    private boolean efw = false;
    private dh.a edw = null;
    private com.baidu.adp.framework.listener.a dlu = new el(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ek() {
        MessageManager.getInstance().registerListener(this.dlu);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dlu);
    }

    public boolean on(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.edd = str;
        return nI(1);
    }

    public boolean aJW() {
        this.efx = !this.efx;
        this.mPostId = aIf();
        nI(6);
        return true;
    }

    public boolean nI(int i) {
        nM(i);
        if (this.axe) {
            return false;
        }
        this.axe = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.apZ);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.edd == null || this.edd.length() == 0) {
            this.axe = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.h.b.c(this.edd, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getApp());
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.ue().ug() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(A));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(B));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.efx) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.EU - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.EU - 1));
                    }
                } else if (this.EU < this.dQh) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.EU + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.dYB));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m10getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aIf() {
        if (this.eds == null || this.eds.aGZ() == null) {
            return "";
        }
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.eds.aGZ();
        if (com.baidu.tbadk.core.util.y.s(aGZ) == 0) {
            return "";
        }
        Iterator<com.baidu.tieba.tbadkCore.data.s> it = aGZ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.tbadkCore.data.s next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && om(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean om(String str) {
        if (getPbData() == null || getPbData().aGY() == null || getPbData().aGY().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aGY().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(dh.a aVar) {
        this.edw = aVar;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.pb.data.h hVar2 = z ? null : hVar;
        this.axe = false;
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
        nN(i);
        if (hVar == null) {
            if (this.edw != null) {
                this.edw.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (hVar.getPage() != null) {
            this.EU = hVar.getPage().pl();
            this.dQh = hVar.getPage().pi();
            this.hasMore = hVar.getPage().pn() != 0;
        }
        this.dQh = this.dQh < 1 ? 1 : this.dQh;
        if (this.eds != null && this.eds.aGZ() != null) {
            arrayList = this.eds.aGZ();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.eds.a(hVar.getPage(), 1);
                a(hVar, arrayList);
                break;
            case 6:
                i(hVar);
                break;
        }
        if (this.edw != null) {
            this.edw.a(true, i2, i, 0, this.eds, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.h hVar) {
        setPbData(hVar);
    }

    protected void a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        String am;
        if (arrayList != null && hVar.aGZ() != null) {
            com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) com.baidu.tbadk.core.util.y.c(hVar.aGZ(), 0);
            if (sVar != null && (am = am(arrayList)) != null && am.equals(sVar.getId())) {
                hVar.aGZ().remove(sVar);
            }
            arrayList.addAll(hVar.aGZ());
        }
    }

    private String am(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
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
        this.eds = hVar;
        if (hVar != null) {
            this.edd = this.eds.getThreadId();
        }
        if (hVar != null && hVar.getPage() != null) {
            this.EU = hVar.getPage().pl();
            this.dQh = hVar.getPage().pi();
            this.hasMore = hVar.getPage().pn() != 0;
        }
    }

    public com.baidu.tieba.pb.data.h getPbData() {
        return this.eds;
    }

    public boolean aJX() {
        return this.isSquence;
    }

    public void hR(boolean z) {
        this.isSquence = z;
    }

    public boolean aJY() {
        return this.efx;
    }

    public void setHostMode(boolean z) {
        this.efx = z;
    }

    public void nM(int i) {
        this.mRequestType = i;
    }

    public void nN(int i) {
        this.edt = i;
    }

    public void hS(boolean z) {
        this.dYB = z;
    }

    public void setThreadId(String str) {
        this.edd = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void hT(boolean z) {
        this.efw = z;
    }
}
