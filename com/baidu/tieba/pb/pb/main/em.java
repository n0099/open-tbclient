package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class em {
    private boolean eiu;
    private String enb;
    private com.baidu.tieba.pb.data.f ens;
    private int ent;
    private boolean eqf;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aPz = 1;
    private int bxV = 1;
    private boolean eqe = false;
    private PbModel.a enx = null;
    private com.baidu.adp.framework.listener.a dqC = new en(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public em() {
        MessageManager.getInstance().registerListener(this.dqC);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dqC);
    }

    public boolean nx(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.enb = str;
        return on(1);
    }

    public boolean aMy() {
        this.eqf = !this.eqf;
        this.mPostId = aKB();
        on(6);
        return true;
    }

    public boolean on(int i) {
        os(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axK);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.enb == null || this.enb.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.enb, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vD().vF() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eqf) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aPz - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aPz - 1));
                    }
                } else if (this.aPz < this.bxV) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aPz + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.eiu));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aKB() {
        if (this.ens == null || this.ens.aJs() == null) {
            return "";
        }
        ArrayList<PostData> aJs = this.ens.aJs();
        if (com.baidu.tbadk.core.util.x.p(aJs) == 0) {
            return "";
        }
        Iterator<PostData> it = aJs.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nv(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nv(String str) {
        if (getPbData() == null || getPbData().aJq() == null || getPbData().aJq().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJq().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.enx = aVar;
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
        ot(i);
        if (fVar == null) {
            if (this.enx != null) {
                this.enx.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.getPage() != null) {
            this.aPz = fVar.getPage().qO();
            this.bxV = fVar.getPage().qL();
            this.hasMore = fVar.getPage().qQ() != 0;
        }
        this.bxV = this.bxV < 1 ? 1 : this.bxV;
        if (this.ens != null && this.ens.aJs() != null) {
            arrayList = this.ens.aJs();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.ens.a(fVar.getPage(), 1);
                b(fVar, arrayList);
                break;
            case 6:
                i(fVar);
                break;
        }
        if (this.enx != null) {
            this.enx.a(true, i2, i, 0, this.ens, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aJs() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJs(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aJs().remove(postData);
            }
            arrayList.addAll(fVar.aJs());
        }
    }

    private String ak(ArrayList<PostData> arrayList) {
        int p = com.baidu.tbadk.core.util.x.p(arrayList);
        if (p <= 0) {
            return null;
        }
        for (int i = p - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    public void p(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.ens = fVar;
        if (fVar != null) {
            this.enb = this.ens.getThreadId();
        }
        if (fVar != null && fVar.getPage() != null) {
            this.aPz = fVar.getPage().qO();
            this.bxV = fVar.getPage().qL();
            this.hasMore = fVar.getPage().qQ() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ens;
    }

    public boolean aMz() {
        return this.isSquence;
    }

    public void iE(boolean z) {
        this.isSquence = z;
    }

    public boolean aMA() {
        return this.eqf;
    }

    public void setHostMode(boolean z) {
        this.eqf = z;
    }

    public void os(int i) {
        this.mRequestType = i;
    }

    public void ot(int i) {
        this.ent = i;
    }

    public void iF(boolean z) {
        this.eiu = z;
    }

    public void setThreadId(String str) {
        this.enb = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iG(boolean z) {
        this.eqe = z;
    }
}
