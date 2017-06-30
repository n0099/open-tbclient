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
public class fk {
    private boolean eAY;
    private boolean esq;
    private com.baidu.tieba.pb.data.f eyH;
    private int eyI;
    private String eyr;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aRD = 1;
    private int bGT = 1;
    private boolean eAX = false;
    private PbModel.a eyN = null;
    private com.baidu.adp.framework.listener.a dzD = new fl(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);

    public fk() {
        MessageManager.getInstance().registerListener(this.dzD);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dzD);
    }

    public boolean oS(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.eyr = str;
        return oT(1);
    }

    public boolean aPS() {
        this.eAY = !this.eAY;
        this.mPostId = aNT();
        oT(6);
        return true;
    }

    public boolean oT(int i) {
        oY(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.ayN);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eyr == null || this.eyr.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.c(this.eyr, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.ax.vA().vC() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(af));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.eAY) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aRD - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aRD - 1));
                    }
                } else if (this.aRD < this.bGT) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aRD + 1));
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
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.esq));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.m9getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aNT() {
        if (this.eyH == null || this.eyH.aMx() == null) {
            return "";
        }
        ArrayList<PostData> aMx = this.eyH.aMx();
        if (com.baidu.tbadk.core.util.z.s(aMx) == 0) {
            return "";
        }
        Iterator<PostData> it = aMx.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && oQ(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean oQ(String str) {
        if (getPbData() == null || getPbData().aMv() == null || getPbData().aMv().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aMv().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.eyN = aVar;
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
        oZ(i);
        if (fVar == null) {
            if (this.eyN != null) {
                this.eyN.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.qu() != null) {
            this.aRD = fVar.qu().qo();
            this.bGT = fVar.qu().ql();
            this.hasMore = fVar.qu().qq() != 0;
        }
        this.bGT = this.bGT < 1 ? 1 : this.bGT;
        if (this.eyH != null && this.eyH.aMx() != null) {
            arrayList = this.eyH.aMx();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.eyH.a(fVar.qu(), 1);
                d(fVar, arrayList);
                break;
            case 6:
                j(fVar);
                break;
        }
        if (this.eyN != null) {
            this.eyN.a(true, i2, i, 0, this.eyH, str, 1);
        }
    }

    private void j(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aMx() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(fVar.aMx(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aMx().remove(postData);
            }
            arrayList.addAll(fVar.aMx());
        }
    }

    private String al(ArrayList<PostData> arrayList) {
        int s = com.baidu.tbadk.core.util.z.s(arrayList);
        if (s <= 0) {
            return null;
        }
        for (int i = s - 1; i >= 0; i--) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(arrayList, i);
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
        this.eyH = fVar;
        if (fVar != null) {
            this.eyr = this.eyH.getThreadId();
        }
        if (fVar != null && fVar.qu() != null) {
            this.aRD = fVar.qu().qo();
            this.bGT = fVar.qu().ql();
            this.hasMore = fVar.qu().qq() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eyH;
    }

    public boolean aPT() {
        return this.isSquence;
    }

    public void jd(boolean z) {
        this.isSquence = z;
    }

    public boolean aPU() {
        return this.eAY;
    }

    public void setHostMode(boolean z) {
        this.eAY = z;
    }

    public void oY(int i) {
        this.mRequestType = i;
    }

    public void oZ(int i) {
        this.eyI = i;
    }

    public void je(boolean z) {
        this.esq = z;
    }

    public void setThreadId(String str) {
        this.eyr = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void jf(boolean z) {
        this.eAX = z;
    }
}
