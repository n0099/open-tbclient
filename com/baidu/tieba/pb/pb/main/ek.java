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
public class ek {
    private boolean egB;
    private int elA;
    private String elj;
    private com.baidu.tieba.pb.data.f elz;
    private boolean eoo;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aPP = 1;
    private int bxO = 1;
    private boolean eon = false;
    private PbModel.a elF = null;
    private com.baidu.adp.framework.listener.a dpb = new el(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ek() {
        MessageManager.getInstance().registerListener(this.dpb);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dpb);
    }

    public boolean nD(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.elj = str;
        return ol(1);
    }

    public boolean aMH() {
        this.eoo = !this.eoo;
        this.mPostId = aKH();
        ol(6);
        return true;
    }

    public boolean ol(int i) {
        oq(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aya);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.elj == null || this.elj.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.elj, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.wa().wc() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eoo) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aPP - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aPP - 1));
                    }
                } else if (this.aPP < this.bxO) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aPP + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.egB));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aKH() {
        if (this.elz == null || this.elz.aJz() == null) {
            return "";
        }
        ArrayList<PostData> aJz = this.elz.aJz();
        if (com.baidu.tbadk.core.util.x.p(aJz) == 0) {
            return "";
        }
        Iterator<PostData> it = aJz.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nB(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nB(String str) {
        if (getPbData() == null || getPbData().aJx() == null || getPbData().aJx().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aJx().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.elF = aVar;
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
        or(i);
        if (fVar == null) {
            if (this.elF != null) {
                this.elF.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.rr() != null) {
            this.aPP = fVar.rr().rl();
            this.bxO = fVar.rr().ri();
            this.hasMore = fVar.rr().rn() != 0;
        }
        this.bxO = this.bxO < 1 ? 1 : this.bxO;
        if (this.elz != null && this.elz.aJz() != null) {
            arrayList = this.elz.aJz();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.elz.a(fVar.rr(), 1);
                b(fVar, arrayList);
                break;
            case 6:
                i(fVar);
                break;
        }
        if (this.elF != null) {
            this.elF.a(true, i2, i, 0, this.elz, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aJz() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aJz(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aJz().remove(postData);
            }
            arrayList.addAll(fVar.aJz());
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
        this.elz = fVar;
        if (fVar != null) {
            this.elj = this.elz.getThreadId();
        }
        if (fVar != null && fVar.rr() != null) {
            this.aPP = fVar.rr().rl();
            this.bxO = fVar.rr().ri();
            this.hasMore = fVar.rr().rn() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.elz;
    }

    public boolean aMI() {
        return this.isSquence;
    }

    public void iD(boolean z) {
        this.isSquence = z;
    }

    public boolean aMJ() {
        return this.eoo;
    }

    public void setHostMode(boolean z) {
        this.eoo = z;
    }

    public void oq(int i) {
        this.mRequestType = i;
    }

    public void or(int i) {
        this.elA = i;
    }

    public void iE(boolean z) {
        this.egB = z;
    }

    public void setThreadId(String str) {
        this.elj = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iF(boolean z) {
        this.eon = z;
    }
}
