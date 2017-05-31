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
public class fb {
    private boolean ejs;
    private String eph;
    private com.baidu.tieba.pb.data.f epx;
    private int epy;
    private boolean erN;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aQl = 1;
    private int bGb = 1;
    private boolean erM = false;
    private PbModel.a epD = null;
    private com.baidu.adp.framework.listener.a dqQ = new fc(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public fb() {
        MessageManager.getInstance().registerListener(this.dqQ);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dqQ);
    }

    public boolean nX(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.eph = str;
        return oC(1);
    }

    public boolean aLU() {
        this.erN = !this.erN;
        this.mPostId = aJW();
        oC(6);
        return true;
    }

    public boolean oC(int i) {
        oH(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.axL);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eph == null || this.eph.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eph, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.av.vl().vn() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.erN) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aQl - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aQl - 1));
                    }
                } else if (this.aQl < this.bGb) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aQl + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.ejs));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aJW() {
        if (this.epx == null || this.epx.aID() == null) {
            return "";
        }
        ArrayList<PostData> aID = this.epx.aID();
        if (com.baidu.tbadk.core.util.x.q(aID) == 0) {
            return "";
        }
        Iterator<PostData> it = aID.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && nV(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean nV(String str) {
        if (getPbData() == null || getPbData().aIB() == null || getPbData().aIB().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aIB().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.epD = aVar;
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
        oI(i);
        if (fVar == null) {
            if (this.epD != null) {
                this.epD.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.qx() != null) {
            this.aQl = fVar.qx().qr();
            this.bGb = fVar.qx().qo();
            this.hasMore = fVar.qx().qt() != 0;
        }
        this.bGb = this.bGb < 1 ? 1 : this.bGb;
        if (this.epx != null && this.epx.aID() != null) {
            arrayList = this.epx.aID();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.epx.a(fVar.qx(), 1);
                d(fVar, arrayList);
                break;
            case 6:
                j(fVar);
                break;
        }
        if (this.epD != null) {
            this.epD.a(true, i2, i, 0, this.epx, str, 1);
        }
    }

    private void j(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String aj;
        if (arrayList != null && fVar.aID() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aID(), 0);
            if (postData != null && (aj = aj(arrayList)) != null && aj.equals(postData.getId())) {
                fVar.aID().remove(postData);
            }
            arrayList.addAll(fVar.aID());
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

    public void n(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setPbData(com.baidu.tieba.pb.data.f fVar) {
        this.epx = fVar;
        if (fVar != null) {
            this.eph = this.epx.getThreadId();
        }
        if (fVar != null && fVar.qx() != null) {
            this.aQl = fVar.qx().qr();
            this.bGb = fVar.qx().qo();
            this.hasMore = fVar.qx().qt() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.epx;
    }

    public boolean aLV() {
        return this.isSquence;
    }

    public void iH(boolean z) {
        this.isSquence = z;
    }

    public boolean aLW() {
        return this.erN;
    }

    public void setHostMode(boolean z) {
        this.erN = z;
    }

    public void oH(int i) {
        this.mRequestType = i;
    }

    public void oI(int i) {
        this.epy = i;
    }

    public void iI(boolean z) {
        this.ejs = z;
    }

    public void setThreadId(String str) {
        this.eph = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void iJ(boolean z) {
        this.erM = z;
    }
}
