package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbRequestMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.l;
import d.a.n0.e2.h.r;
/* loaded from: classes5.dex */
public class PbFakeFloorModel extends DataModel {

    /* renamed from: e  reason: collision with root package name */
    public String f19285e;

    /* renamed from: f  reason: collision with root package name */
    public r f19286f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19287g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f19288h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f19289i;
    public b j;
    public String k;
    public d.a.c.c.g.a l;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || PbFakeFloorModel.this.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            PbFakeFloorModel.this.f19287g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = PbFakeFloorModel.this.f19289i.getPageActivity().getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                PbFakeFloorModel.this.f19289i.showToast(errorString);
                return;
            }
            r rVar = null;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                rVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                rVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
            }
            if (rVar == null || rVar.k() == null) {
                return;
            }
            PostData postData = (PostData) ListUtils.getItem(rVar.k(), rVar.k().size() - 1);
            if (postData != null && PbFakeFloorModel.this.f19286f != null && PbFakeFloorModel.this.f19286f.i() != null) {
                if (PbFakeFloorModel.this.f19286f.l() != null && PbFakeFloorModel.this.f19286f.l().T() != null && postData.t() != null && (userId = PbFakeFloorModel.this.f19286f.l().T().getUserId()) != null && userId.equals(postData.t().getUserId())) {
                    z = true;
                }
                postData.z0(PbFakeFloorModel.this.f19289i, z);
            }
            if (PbFakeFloorModel.this.j != null) {
                PbFakeFloorModel.this.j.a(postData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(PostData postData);
    }

    public PbFakeFloorModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f19286f = null;
        this.f19287g = false;
        this.j = null;
        a aVar = new a(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.l = aVar;
        this.f19289i = tbPageContext;
        registerListener(aVar);
    }

    public void E(PostData postData) {
        if (postData != null) {
            this.f19286f.i().c(postData);
            this.f19286f.i().e(postData);
            this.f19286f.i().p0(true);
        }
    }

    public final SubPbRequestMessage F() {
        r rVar = this.f19286f;
        if (rVar != null && rVar.l() != null && this.f19286f.l().o0() != null && this.f19286f.i() != null && this.f19286f.i().E() != null) {
            this.f19287g = true;
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i2 = l.i(TbadkCoreApplication.getInst().getApp());
            long f3 = d.a.c.e.m.b.f(this.f19286f.i().E(), 0L);
            return new SubPbRequestMessage(this.f19289i.getPageActivity(), d.a.c.e.m.b.f(this.f19286f.l().o0(), 0L), f3, 0L, 1, k, i2, f2, "", 1);
        }
        this.f19287g = false;
        return null;
    }

    public void G() {
        if (this.f19287g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage F = F();
        this.f19288h = F;
        if (F == null) {
            return;
        }
        sendMessage(F);
    }

    public void H(b bVar) {
        this.j = bVar;
    }

    public void I(r rVar) {
        this.f19286f = rVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void setFromForumId(String str) {
        this.k = str;
    }

    public void setPostId(String str) {
        this.f19285e = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.l);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String w() {
        return this.f19285e;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData x(String str) {
        r rVar = this.f19286f;
        if (rVar == null || rVar.d() == null || this.f19286f.l() == null || this.f19286f.i() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean o2 = this.f19286f.l().o2();
        if (o2) {
            writeData.setVForumId(this.f19286f.d().getId());
            writeData.setVForumName(this.f19286f.d().getName());
        } else {
            writeData.setForumName(this.f19286f.d().getName());
            writeData.setForumId(this.f19286f.d().getId());
        }
        writeData.setFromForumId(this.k);
        writeData.setFloor(this.f19286f.i().E());
        writeData.setType(2);
        writeData.setCanNoForum(o2);
        writeData.setThreadId(this.f19286f.l().o0());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean y() {
        G();
        return true;
    }
}
