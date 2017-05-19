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
public class es {
    private boolean edS;
    private com.baidu.tieba.pb.data.f ejL;
    private int ejM;
    private String ejv;
    private boolean ema;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aQk = 1;
    private int bAg = 1;
    private boolean elZ = false;
    private PbModel.a ejR = null;
    private com.baidu.adp.framework.listener.a dlw = new et(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public es() {
        MessageManager.getInstance().registerListener(this.dlw);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dlw);
    }

    public boolean nL(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.ejv = str;
        return oj(1);
    }

    public boolean aKY() {
        this.ema = !this.ema;
        this.mPostId = aJe();
        oj(6);
        return true;
    }

    public boolean oj(int i) {
        on(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axZ);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.ejv == null || this.ejv.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.ejv, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vo().vq() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ema) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aQk - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aQk - 1));
                    }
                } else if (this.aQk < this.bAg) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aQk + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.edS));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aJe() {
        if (this.ejL == null || this.ejL.aHI() == null) {
            return "";
        }
        ArrayList<PostData> aHI = this.ejL.aHI();
        if (com.baidu.tbadk.core.util.x.q(aHI) == 0) {
            return "";
        }
        Iterator<PostData> it = aHI.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nJ(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nJ(String str) {
        if (getPbData() == null || getPbData().aHG() == null || getPbData().aHG().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aHG().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.ejR = aVar;
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
        oo(i);
        if (fVar == null) {
            if (this.ejR != null) {
                this.ejR.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.qB() != null) {
            this.aQk = fVar.qB().qv();
            this.bAg = fVar.qB().qs();
            this.hasMore = fVar.qB().qx() != 0;
        }
        this.bAg = this.bAg < 1 ? 1 : this.bAg;
        if (this.ejL != null && this.ejL.aHI() != null) {
            arrayList = this.ejL.aHI();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.ejL.a(fVar.qB(), 1);
                d(fVar, arrayList);
                break;
            case 6:
                j(fVar);
                break;
        }
        if (this.ejR != null) {
            this.ejR.a(true, i2, i, 0, this.ejL, str, 1);
        }
    }

    private void j(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aj;
        if (arrayList != null && fVar.aHI() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aHI(), 0);
            if (postData != null && (aj = aj(arrayList)) != null && aj.equals(postData.getId())) {
                fVar.aHI().remove(postData);
            }
            arrayList.addAll(fVar.aHI());
        }
    }

    private String aj(ArrayList<PostData> arrayList) {
        int q = com.baidu.tbadk.core.util.x.q(arrayList);
        if (q <= 0) {
            return null;
        }
        for (int i = q - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (postData != null && !StringUtils.isNull(postData.getId())) {
                return postData.getId();
            }
        }
        return null;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.ejL = fVar;
        if (fVar != null) {
            this.ejv = this.ejL.getThreadId();
        }
        if (fVar != null && fVar.qB() != null) {
            this.aQk = fVar.qB().qv();
            this.bAg = fVar.qB().qs();
            this.hasMore = fVar.qB().qx() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.ejL;
    }

    public boolean aKZ() {
        return this.isSquence;
    }

    public void ir(boolean z) {
        this.isSquence = z;
    }

    public boolean aLa() {
        return this.ema;
    }

    public void setHostMode(boolean z) {
        this.ema = z;
    }

    public void on(int i) {
        this.mRequestType = i;
    }

    public void oo(int i) {
        this.ejM = i;
    }

    public void is(boolean z) {
        this.edS = z;
    }

    public void setThreadId(String str) {
        this.ejv = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void it(boolean z) {
        this.elZ = z;
    }
}
