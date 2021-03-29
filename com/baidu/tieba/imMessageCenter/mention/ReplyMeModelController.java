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
import d.b.b.j.e.n;
import d.b.h0.s.d.b;
import d.b.i0.e1.b.g;
import d.b.i0.e1.b.l;
import d.b.i0.e1.b.m;
import d.b.i0.e1.b.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<m>, NetModel.k<l, m> {

    /* renamed from: e  reason: collision with root package name */
    public ReplyMessageFragment f18338e;

    /* renamed from: f  reason: collision with root package name */
    public l f18339f;

    /* renamed from: g  reason: collision with root package name */
    public ReplyMeNetModel f18340g;

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeCacheModel f18341h;
    public g i;
    public FeedData j;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.f18338e = replyMessageFragment;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
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
                this.f18338e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
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
                this.f18338e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f18339f, readCacheRespMsg.getData().get(0), true);
        }
        this.j = null;
        this.f18339f.c();
        this.f18340g.setNeedCache(true);
        this.f18340g.N();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    public void onDestroy() {
        ReplyMeNetModel replyMeNetModel = this.f18340g;
        if (replyMeNetModel != null) {
            replyMeNetModel.V(null);
        }
        ReplyMeCacheModel replyMeCacheModel = this.f18341h;
        if (replyMeCacheModel != null) {
            replyMeCacheModel.K(null);
        }
    }

    public boolean s() {
        ArrayList<FeedData> arrayList;
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        g gVar = this.i;
        if (gVar != null && (arrayList = gVar.f54431e) != null) {
            arrayList.clear();
        }
        this.f18338e.P0();
        this.f18338e.V0(false, null);
        return false;
    }

    public void t(int i) {
        g gVar = this.i;
        if (gVar == null || gVar.b() == null || i >= this.i.b().size()) {
            return;
        }
        this.i.b().remove(i);
    }

    public boolean u() {
        if (s()) {
            this.f18341h.I(this.f18339f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f18339f = new l();
        ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.f18338e.getPageContext(), this.f18339f);
        this.f18340g = replyMeNetModel;
        replyMeNetModel.V(this);
        this.f18340g.setUniqueId(this.f18338e.getUniqueId());
        ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.f18338e.getPageContext());
        this.f18341h = replyMeCacheModel;
        replyMeCacheModel.K(this);
        this.f18341h.setUniqueId(this.f18338e.getUniqueId());
        this.i = new g();
    }

    public boolean w() {
        if (this.f18340g.M() || !s()) {
            return false;
        }
        this.f18339f.d(this.j);
        this.f18340g.setNeedCache(false);
        this.f18340g.N();
        return true;
    }

    public boolean x(l lVar, m mVar, boolean z) {
        boolean z2;
        if (lVar.b() != 4) {
            this.i.b().clear();
        }
        this.i.d(mVar);
        boolean z3 = true;
        if (mVar != null && mVar.b() != null && mVar.b().size() > 0) {
            this.j = mVar.b().get(mVar.b().size() - 1);
            z2 = this.i.c() == null || this.i.c().b() == 1;
            if (lVar.b() == 1) {
                b.g0().e0(0);
            }
            if (lVar != null) {
                lVar.f();
            }
        } else {
            this.j = null;
            z2 = false;
            z3 = false;
        }
        b.g0().p();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.i.f54431e.iterator();
        while (it.hasNext()) {
            a aVar = new a();
            aVar.F(it.next());
            if (z) {
                aVar.H(false);
            }
            arrayList.add(aVar);
        }
        this.f18338e.V0(z2, arrayList);
        return z3;
    }

    public boolean y() {
        if (this.f18340g.M() || !s()) {
            return false;
        }
        this.j = null;
        this.f18339f.c();
        this.f18340g.setNeedCache(true);
        this.f18340g.N();
        return true;
    }
}
