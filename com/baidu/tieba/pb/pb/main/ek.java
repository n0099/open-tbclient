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
    private boolean eiR;
    private String enB;
    private com.baidu.tieba.pb.data.f enR;
    private int enS;
    private boolean eqF;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aPR = 1;
    private int bAf = 1;
    private boolean eqE = false;
    private PbModel.a enX = null;
    private com.baidu.adp.framework.listener.a drs = new el(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public ek() {
        MessageManager.getInstance().registerListener(this.drs);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.drs);
    }

    public boolean nE(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.enB = str;
        return or(1);
    }

    public boolean aNI() {
        this.eqF = !this.eqF;
        this.mPostId = aLH();
        or(6);
        return true;
    }

    public boolean or(int i) {
        ow(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ayc);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.enB == null || this.enB.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.enB, 0L));
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
        if (this.eqF) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aPR - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aPR - 1));
                    }
                } else if (this.aPR < this.bAf) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aPR + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.eiR));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aLH() {
        if (this.enR == null || this.enR.aKA() == null) {
            return "";
        }
        ArrayList<PostData> aKA = this.enR.aKA();
        if (com.baidu.tbadk.core.util.x.p(aKA) == 0) {
            return "";
        }
        Iterator<PostData> it = aKA.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nC(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nC(String str) {
        if (getPbData() == null || getPbData().aKy() == null || getPbData().aKy().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aKy().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.enX = aVar;
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
        ox(i);
        if (fVar == null) {
            if (this.enX != null) {
                this.enX.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.rr() != null) {
            this.aPR = fVar.rr().rl();
            this.bAf = fVar.rr().ri();
            this.hasMore = fVar.rr().rn() != 0;
        }
        this.bAf = this.bAf < 1 ? 1 : this.bAf;
        if (this.enR != null && this.enR.aKA() != null) {
            arrayList = this.enR.aKA();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.enR.a(fVar.rr(), 1);
                b(fVar, arrayList);
                break;
            case 6:
                i(fVar);
                break;
        }
        if (this.enX != null) {
            this.enX.a(true, i2, i, 0, this.enR, str, 1);
        }
    }

    private void i(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void b(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String ak;
        if (arrayList != null && fVar.aKA() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aKA(), 0);
            if (postData != null && (ak = ak(arrayList)) != null && ak.equals(postData.getId())) {
                fVar.aKA().remove(postData);
            }
            arrayList.addAll(fVar.aKA());
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
        this.enR = fVar;
        if (fVar != null) {
            this.enB = this.enR.getThreadId();
        }
        if (fVar != null && fVar.rr() != null) {
            this.aPR = fVar.rr().rl();
            this.bAf = fVar.rr().ri();
            this.hasMore = fVar.rr().rn() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.enR;
    }

    public boolean aNJ() {
        return this.isSquence;
    }

    public void iN(boolean z) {
        this.isSquence = z;
    }

    public boolean aNK() {
        return this.eqF;
    }

    public void setHostMode(boolean z) {
        this.eqF = z;
    }

    public void ow(int i) {
        this.mRequestType = i;
    }

    public void ox(int i) {
        this.enS = i;
    }

    public void iO(boolean z) {
        this.eiR = z;
    }

    public void setThreadId(String str) {
        this.enB = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iP(boolean z) {
        this.eqE = z;
    }
}
