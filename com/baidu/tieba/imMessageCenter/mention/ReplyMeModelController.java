package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.mvc.model.NetModel;
import d.a.c.j.e.n;
import d.a.j0.s.d.b;
import d.a.k0.f1.b.g;
import d.a.k0.f1.b.l;
import d.a.k0.f1.b.m;
import d.a.k0.f1.b.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<m>, NetModel.k<l, m> {

    /* renamed from: e  reason: collision with root package name */
    public ReplyMessageFragment f17681e;

    /* renamed from: f  reason: collision with root package name */
    public l f17682f;

    /* renamed from: g  reason: collision with root package name */
    public ReplyMeNetModel f17683g;

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeCacheModel f17684h;

    /* renamed from: i  reason: collision with root package name */
    public g f17685i;
    public FeedData j;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.f17681e = replyMessageFragment;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            mVar = mvcSocketResponsedMessage.getData();
            r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            b.g0().e0(0);
            mVar = null;
        }
        if (r1 == null || mVar == null || !x(r1, mVar, false)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.f17681e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            mVar = mvcHttpResponsedMessage.getData();
            r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r1 = mvcNetMessage.getRequestData();
            }
        } else {
            b.g0().e0(0);
            mVar = null;
        }
        if (r1 == null || mVar == null || !x(r1, mVar, false)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.f17681e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f17682f, readCacheRespMsg.getData().get(0), true);
        }
        this.j = null;
        this.f17682f.b();
        this.f17683g.setNeedCache(true);
        this.f17683g.N();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    public void onDestroy() {
        ReplyMeNetModel replyMeNetModel = this.f17683g;
        if (replyMeNetModel != null) {
            replyMeNetModel.V(null);
        }
        ReplyMeCacheModel replyMeCacheModel = this.f17684h;
        if (replyMeCacheModel != null) {
            replyMeCacheModel.K(null);
        }
    }

    public boolean s() {
        ArrayList<FeedData> arrayList;
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        g gVar = this.f17685i;
        if (gVar != null && (arrayList = gVar.f54882e) != null) {
            arrayList.clear();
        }
        this.f17681e.O0();
        this.f17681e.U0(false, null);
        return false;
    }

    public void t(int i2) {
        g gVar = this.f17685i;
        if (gVar == null || gVar.a() == null || i2 >= this.f17685i.a().size()) {
            return;
        }
        this.f17685i.a().remove(i2);
    }

    public boolean u() {
        if (s()) {
            this.f17684h.I(this.f17682f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f17682f = new l();
        ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.f17681e.getPageContext(), this.f17682f);
        this.f17683g = replyMeNetModel;
        replyMeNetModel.V(this);
        this.f17683g.setUniqueId(this.f17681e.getUniqueId());
        ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.f17681e.getPageContext());
        this.f17684h = replyMeCacheModel;
        replyMeCacheModel.K(this);
        this.f17684h.setUniqueId(this.f17681e.getUniqueId());
        this.f17685i = new g();
    }

    public boolean w() {
        if (this.f17683g.M() || !s()) {
            return false;
        }
        this.f17682f.d(this.j);
        this.f17683g.setNeedCache(false);
        this.f17683g.N();
        return true;
    }

    public boolean x(l lVar, m mVar, boolean z) {
        boolean z2;
        if (lVar.a() != 4) {
            this.f17685i.a().clear();
        }
        this.f17685i.d(mVar);
        boolean z3 = true;
        if (mVar != null && mVar.a() != null && mVar.a().size() > 0) {
            this.j = mVar.a().get(mVar.a().size() - 1);
            z2 = this.f17685i.b() == null || this.f17685i.b().b() == 1;
            if (lVar.a() == 1) {
                b.g0().e0(0);
            }
            if (lVar != null) {
                lVar.e();
            }
        } else {
            this.j = null;
            z2 = false;
            z3 = false;
        }
        b.g0().p();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.f17685i.f54882e.iterator();
        while (it.hasNext()) {
            a aVar = new a();
            aVar.F(it.next());
            if (z) {
                aVar.H(false);
            }
            arrayList.add(aVar);
        }
        this.f17681e.U0(z2, arrayList);
        return z3;
    }

    public boolean y() {
        if (this.f17683g.M() || !s()) {
            return false;
        }
        this.j = null;
        this.f17682f.b();
        this.f17683g.setNeedCache(true);
        this.f17683g.N();
        return true;
    }
}
