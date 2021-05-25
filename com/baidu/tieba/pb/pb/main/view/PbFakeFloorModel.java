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
    public String f19208e;

    /* renamed from: f  reason: collision with root package name */
    public r f19209f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19210g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f19211h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f19212i;
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
            PbFakeFloorModel.this.f19210g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = PbFakeFloorModel.this.f19212i.getPageActivity().getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                PbFakeFloorModel.this.f19212i.showToast(errorString);
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
            if (postData != null && PbFakeFloorModel.this.f19209f != null && PbFakeFloorModel.this.f19209f.i() != null) {
                if (PbFakeFloorModel.this.f19209f.l() != null && PbFakeFloorModel.this.f19209f.l().T() != null && postData.t() != null && (userId = PbFakeFloorModel.this.f19209f.l().T().getUserId()) != null && userId.equals(postData.t().getUserId())) {
                    z = true;
                }
                postData.z0(PbFakeFloorModel.this.f19212i, z);
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
        this.f19209f = null;
        this.f19210g = false;
        this.j = null;
        a aVar = new a(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.l = aVar;
        this.f19212i = tbPageContext;
        registerListener(aVar);
    }

    public void A(PostData postData) {
        if (postData != null) {
            this.f19209f.i().e(postData);
            this.f19209f.i().f(postData);
            this.f19209f.i().p0(true);
        }
    }

    public final SubPbRequestMessage B() {
        r rVar = this.f19209f;
        if (rVar != null && rVar.l() != null && this.f19209f.l().o0() != null && this.f19209f.i() != null && this.f19209f.i().E() != null) {
            this.f19210g = true;
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i2 = l.i(TbadkCoreApplication.getInst().getApp());
            long f3 = d.a.c.e.m.b.f(this.f19209f.i().E(), 0L);
            return new SubPbRequestMessage(this.f19212i.getPageActivity(), d.a.c.e.m.b.f(this.f19209f.l().o0(), 0L), f3, 0L, 1, k, i2, f2, "", 1);
        }
        this.f19210g = false;
        return null;
    }

    public void C() {
        if (this.f19210g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage B = B();
        this.f19211h = B;
        if (B == null) {
            return;
        }
        sendMessage(B);
    }

    public void D(b bVar) {
        this.j = bVar;
    }

    public void E(r rVar) {
        this.f19209f = rVar;
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

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String s() {
        return this.f19208e;
    }

    public void setFromForumId(String str) {
        this.k = str;
    }

    public void setPostId(String str) {
        this.f19208e = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData t(String str) {
        r rVar = this.f19209f;
        if (rVar == null || rVar.d() == null || this.f19209f.l() == null || this.f19209f.i() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean n2 = this.f19209f.l().n2();
        if (n2) {
            writeData.setVForumId(this.f19209f.d().getId());
            writeData.setVForumName(this.f19209f.d().getName());
        } else {
            writeData.setForumName(this.f19209f.d().getName());
            writeData.setForumId(this.f19209f.d().getId());
        }
        writeData.setFromForumId(this.k);
        writeData.setFloor(this.f19209f.i().E());
        writeData.setType(2);
        writeData.setCanNoForum(n2);
        writeData.setThreadId(this.f19209f.l().o0());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean u() {
        C();
        return true;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
