package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class af {
    private boolean eDz;
    private String eJA;
    private com.baidu.tieba.pb.data.f eJQ;
    private int eJR;
    private boolean eMg;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aSM = 1;
    private int bLe = 1;
    private boolean eMf = false;
    private PbModel.a eJW = null;
    private com.baidu.adp.framework.listener.a dIf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.af.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && !af.this.eMf && responsedMessage.getOrginalMessage().getTag() == af.this.mTag && !responsedMessage.hasError()) {
                if (responsedMessage instanceof pbPageSocketResponseMessage) {
                    af.this.a((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    af.this.a((pbPageHttpResponseMessage) responsedMessage);
                }
            }
        }
    };

    public af() {
        MessageManager.getInstance().registerListener(this.dIf);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dIf);
    }

    public boolean pp(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.eJA = str;
        return pc(1);
    }

    public boolean aSv() {
        this.eMg = !this.eMg;
        this.mPostId = aQx();
        pc(6);
        return true;
    }

    public boolean pc(int i) {
        ph(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.azN);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eJA == null || this.eJA.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eJA, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.am.vG().vI() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eMg) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aSM - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aSM - 1));
                    }
                } else if (this.aSM < this.bLe) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aSM + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.eDz));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aQx() {
        if (this.eJQ == null || this.eJQ.aPa() == null) {
            return "";
        }
        ArrayList<PostData> aPa = this.eJQ.aPa();
        if (com.baidu.tbadk.core.util.u.u(aPa) == 0) {
            return "";
        }
        Iterator<PostData> it = aPa.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && pn(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean pn(String str) {
        if (getPbData() == null || getPbData().aOY() == null || getPbData().aOY().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aOY().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.eJW = aVar;
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
        ArrayList<PostData> arrayList;
        pi(i);
        if (fVar == null) {
            if (this.eJW != null) {
                this.eJW.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.qx() != null) {
            this.aSM = fVar.qx().qr();
            this.bLe = fVar.qx().qo();
            this.hasMore = fVar.qx().qt() != 0;
        }
        this.bLe = this.bLe < 1 ? 1 : this.bLe;
        if (this.eJQ != null && this.eJQ.aPa() != null) {
            arrayList = this.eJQ.aPa();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.eJQ.a(fVar.qx(), 1);
                d(fVar, arrayList);
                break;
            case 6:
                k(fVar);
                break;
        }
        if (this.eJW != null) {
            this.eJW.a(true, i2, i, 0, this.eJQ, str, 1);
        }
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPa() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPa(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPa().remove(postData);
            }
            arrayList.addAll(fVar.aPa());
        }
    }

    private String al(ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.u.u(arrayList);
        if (u <= 0) {
            return null;
        }
        for (int i = u - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.eJQ = fVar;
        if (fVar != null) {
            this.eJA = this.eJQ.getThreadId();
        }
        if (fVar != null && fVar.qx() != null) {
            this.aSM = fVar.qx().qr();
            this.bLe = fVar.qx().qo();
            this.hasMore = fVar.qx().qt() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eJQ;
    }

    public boolean aSw() {
        return this.isSquence;
    }

    public void jx(boolean z) {
        this.isSquence = z;
    }

    public boolean aSx() {
        return this.eMg;
    }

    public void setHostMode(boolean z) {
        this.eMg = z;
    }

    public void ph(int i) {
        this.mRequestType = i;
    }

    public void pi(int i) {
        this.eJR = i;
    }

    public void jy(boolean z) {
        this.eDz = z;
    }

    public void setThreadId(String str) {
        this.eJA = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void jz(boolean z) {
        this.eMf = z;
    }
}
