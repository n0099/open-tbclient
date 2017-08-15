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
    private boolean eGG;
    private String eMH;
    private com.baidu.tieba.pb.data.f eMX;
    private int eMY;
    private boolean ePn;
    private boolean hasMore;
    private boolean isSquence;
    private String mPostId;
    private int mRequestType;
    private BdUniqueId mTag;
    private boolean isLoading = false;
    private int aTZ = 1;
    private int bMX = 1;
    private boolean ePm = false;
    private PbModel.a eNd = null;
    private com.baidu.adp.framework.listener.a dLs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001) { // from class: com.baidu.tieba.pb.pb.main.af.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && !af.this.ePm && responsedMessage.getOrginalMessage().getTag() == af.this.mTag && !responsedMessage.hasError()) {
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
        MessageManager.getInstance().registerListener(this.dLs);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dLs);
    }

    public boolean px(String str) {
        if (str == null || !this.hasMore) {
            return false;
        }
        this.eMH = str;
        return pm(1);
    }

    public boolean aTn() {
        this.ePn = !this.ePn;
        this.mPostId = aRp();
        pm(6);
        return true;
    }

    public boolean pm(int i) {
        pr(i);
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i);
        pbPageRequestMessage.setLastids(com.baidu.tbadk.distribute.a.aBf);
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.eMH == null || this.eMH.length() == 0) {
            this.isLoading = false;
            return false;
        }
        pbPageRequestMessage.set_kz(com.baidu.adp.lib.g.b.d(this.eMH, 0L));
        pbPageRequestMessage.set_rn(30);
        pbPageRequestMessage.set_with_floor(1);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getApp());
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.am.vQ().vS() ? 2 : 1;
        pbPageRequestMessage.set_scr_w(Integer.valueOf(ag));
        pbPageRequestMessage.set_scr_h(Integer.valueOf(ah));
        pbPageRequestMessage.set_scr_dip(f);
        pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
        if (!this.isSquence) {
            pbPageRequestMessage.set_r(1);
        }
        if (this.ePn) {
            pbPageRequestMessage.set_lz(1);
        }
        switch (i) {
            case 1:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                if (!this.isSquence) {
                    if (this.aTZ - 1 > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.aTZ - 1));
                    }
                } else if (this.aTZ < this.bMX) {
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.aTZ + 1));
                }
                if (this.mPostId != null && this.mPostId.length() > 0) {
                    pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.mPostId, 0L));
                    break;
                } else if (!this.isSquence) {
                    pbPageRequestMessage.set_last(1);
                    break;
                }
                break;
            case 6:
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(com.baidu.adp.lib.g.b.d(this.mPostId, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                break;
        }
        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.eGG));
        pbPageRequestMessage.setTag(this.mTag);
        pbPageRequestMessage.setContext(TbadkCoreApplication.getInst().getContext());
        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
        return true;
    }

    private String aRp() {
        if (this.eMX == null || this.eMX.aPS() == null) {
            return "";
        }
        ArrayList<PostData> aPS = this.eMX.aPS();
        if (com.baidu.tbadk.core.util.u.u(aPS) == 0) {
            return "";
        }
        Iterator<PostData> it = aPS.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && next.getAuthor() != null && next.getAuthor().getUserId() != null && pv(next.getAuthor().getUserId())) {
                return next.getId();
            }
        }
        return "";
    }

    public boolean pv(String str) {
        if (getPbData() == null || getPbData().aPQ() == null || getPbData().aPQ().getAuthor() == null || StringUtils.isNull(str)) {
            return false;
        }
        String userId = getPbData().aPQ().getAuthor().getUserId();
        return !StringUtils.isNull(userId) && userId.equals(str);
    }

    public void b(PbModel.a aVar) {
        this.eNd = aVar;
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
        ps(i);
        if (fVar == null) {
            if (this.eNd != null) {
                this.eNd.a(false, i2, i, 0, null, str, 1);
                return;
            }
            return;
        }
        if (fVar.qH() != null) {
            this.aTZ = fVar.qH().qB();
            this.bMX = fVar.qH().qy();
            this.hasMore = fVar.qH().qD() != 0;
        }
        this.bMX = this.bMX < 1 ? 1 : this.bMX;
        if (this.eMX != null && this.eMX.aPS() != null) {
            arrayList = this.eMX.aPS();
        } else {
            arrayList = new ArrayList<>();
        }
        switch (i) {
            case 1:
                this.eMX.a(fVar.qH(), 1);
                d(fVar, arrayList);
                break;
            case 6:
                k(fVar);
                break;
        }
        if (this.eNd != null) {
            this.eNd.a(true, i2, i, 0, this.eMX, str, 1);
        }
    }

    private void k(com.baidu.tieba.pb.data.f fVar) {
        setPbData(fVar);
    }

    protected void d(com.baidu.tieba.pb.data.f fVar, ArrayList<PostData> arrayList) {
        String al;
        if (arrayList != null && fVar.aPS() != null) {
            PostData postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPS(), 0);
            if (postData != null && (al = al(arrayList)) != null && al.equals(postData.getId())) {
                fVar.aPS().remove(postData);
            }
            arrayList.addAll(fVar.aPS());
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
        this.eMX = fVar;
        if (fVar != null) {
            this.eMH = this.eMX.getThreadId();
        }
        if (fVar != null && fVar.qH() != null) {
            this.aTZ = fVar.qH().qB();
            this.bMX = fVar.qH().qy();
            this.hasMore = fVar.qH().qD() != 0;
        }
    }

    public com.baidu.tieba.pb.data.f getPbData() {
        return this.eMX;
    }

    public boolean aTo() {
        return this.isSquence;
    }

    public void jA(boolean z) {
        this.isSquence = z;
    }

    public boolean aTp() {
        return this.ePn;
    }

    public void setHostMode(boolean z) {
        this.ePn = z;
    }

    public void pr(int i) {
        this.mRequestType = i;
    }

    public void ps(int i) {
        this.eMY = i;
    }

    public void jB(boolean z) {
        this.eGG = z;
    }

    public void setThreadId(String str) {
        this.eMH = str;
    }

    public void setPostId(String str) {
        this.mPostId = str;
    }

    public void jC(boolean z) {
        this.ePm = z;
    }
}
