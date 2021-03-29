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
import d.b.b.e.p.l;
import d.b.i0.c2.h.q;
/* loaded from: classes5.dex */
public class PbFakeFloorModel extends DataModel {

    /* renamed from: e  reason: collision with root package name */
    public String f19832e;

    /* renamed from: f  reason: collision with root package name */
    public q f19833f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19834g;

    /* renamed from: h  reason: collision with root package name */
    public SubPbRequestMessage f19835h;
    public TbPageContext i;
    public b j;
    public String k;
    public d.b.b.c.g.a l;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String userId;
            String errorString;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || PbFakeFloorModel.this.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            boolean z = false;
            PbFakeFloorModel.this.f19834g = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = PbFakeFloorModel.this.i.getPageActivity().getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                PbFakeFloorModel.this.i.showToast(errorString);
                return;
            }
            q qVar = null;
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                qVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                qVar = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
            }
            if (qVar == null || qVar.k() == null) {
                return;
            }
            PostData postData = (PostData) ListUtils.getItem(qVar.k(), qVar.k().size() - 1);
            if (postData != null && PbFakeFloorModel.this.f19833f != null && PbFakeFloorModel.this.f19833f.i() != null) {
                if (PbFakeFloorModel.this.f19833f.l() != null && PbFakeFloorModel.this.f19833f.l().T() != null && postData.s() != null && (userId = PbFakeFloorModel.this.f19833f.l().T().getUserId()) != null && userId.equals(postData.s().getUserId())) {
                    z = true;
                }
                postData.x0(PbFakeFloorModel.this.i, z);
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
        this.f19833f = null;
        this.f19834g = false;
        this.j = null;
        a aVar = new a(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.l = aVar;
        this.i = tbPageContext;
        registerListener(aVar);
    }

    public void A(PostData postData) {
        if (postData != null) {
            this.f19833f.i().e(postData);
            this.f19833f.i().f(postData);
            this.f19833f.i().n0(true);
        }
    }

    public final SubPbRequestMessage B() {
        q qVar = this.f19833f;
        if (qVar != null && qVar.l() != null && this.f19833f.l().o0() != null && this.f19833f.i() != null && this.f19833f.i().D() != null) {
            this.f19834g = true;
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int k = l.k(TbadkCoreApplication.getInst().getApp());
            int i = l.i(TbadkCoreApplication.getInst().getApp());
            long f3 = d.b.b.e.m.b.f(this.f19833f.i().D(), 0L);
            return new SubPbRequestMessage(this.i.getPageActivity(), d.b.b.e.m.b.f(this.f19833f.l().o0(), 0L), f3, 0L, 1, k, i, f2, "", 1);
        }
        this.f19834g = false;
        return null;
    }

    public void C() {
        if (this.f19834g) {
            return;
        }
        cancelMessage();
        SubPbRequestMessage B = B();
        this.f19835h = B;
        if (B == null) {
            return;
        }
        sendMessage(B);
    }

    public void D(b bVar) {
        this.j = bVar;
    }

    public void E(q qVar) {
        this.f19833f = qVar;
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
        return this.f19832e;
    }

    public void setFromForumId(String str) {
        this.k = str;
    }

    public void setPostId(String str) {
        this.f19832e = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void setUniqueId(BdUniqueId bdUniqueId) {
        super.setUniqueId(bdUniqueId);
        registerListener(this.l);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData t(String str) {
        q qVar = this.f19833f;
        if (qVar == null || qVar.d() == null || this.f19833f.l() == null || this.f19833f.i() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        boolean k2 = this.f19833f.l().k2();
        if (k2) {
            writeData.setVForumId(this.f19833f.d().getId());
            writeData.setVForumName(this.f19833f.d().getName());
        } else {
            writeData.setForumName(this.f19833f.d().getName());
            writeData.setForumId(this.f19833f.d().getId());
        }
        writeData.setFromForumId(this.k);
        writeData.setFloor(this.f19833f.i().D());
        writeData.setType(2);
        writeData.setCanNoForum(k2);
        writeData.setThreadId(this.f19833f.l().o0());
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
