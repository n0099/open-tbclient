package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.TbPageContext;
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
import d.a.c.a.j;
import d.a.j0.f1.b.b;
import d.a.j0.f1.b.c;
import d.a.j0.f1.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<c>, NetModel.k<b, c> {

    /* renamed from: e  reason: collision with root package name */
    public AtMessageActivity f18326e;

    /* renamed from: f  reason: collision with root package name */
    public b f18327f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f18328g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f18329h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.g0.d.a f18330i;
    public FeedData j;
    public g k;
    public final CustomMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                AtMeModelController.this.f18326e.dismissPullRefresh();
            }
        }
    }

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        this.l = new a(2000994);
        this.f18326e = atMessageActivity;
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
    public void h(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f18326e.dismissPullRefresh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.i0.s.d.b.g0().Z(0);
            cVar = null;
        }
        if (r0 == null || cVar == null || !x(r0, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f18326e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f18326e.dismissPullRefresh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.i0.s.d.b.g0().Z(0);
            cVar = null;
        }
        if (r0 == null || cVar == null || !x(r0, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f18326e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f18327f, readCacheRespMsg.getData().get(0));
        }
        this.j = null;
        this.f18327f.b();
        this.f18328g.setNeedCache(true);
        this.f18328g.N();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    public boolean t() {
        ArrayList<FeedData> arrayList;
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        g gVar = this.k;
        if (gVar != null && (arrayList = gVar.f54175e) != null) {
            arrayList.clear();
        }
        this.f18326e.dismissPullRefresh();
        this.f18326e.onViewDataChanged(this.k);
        return false;
    }

    public boolean u() {
        if (t()) {
            AtMessageActivity atMessageActivity = this.f18326e;
            if (atMessageActivity != null) {
                atMessageActivity.showPullRefresh();
            }
            this.f18329h.I(this.f18327f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f18327f = new b();
        AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f18326e.getPageContext().getPageActivity()), this.f18327f);
        this.f18328g = atMeNetModel;
        atMeNetModel.V(this);
        AtMessageActivity atMessageActivity = this.f18326e;
        if (atMessageActivity != null) {
            this.f18328g.setUniqueId(atMessageActivity.getUniqueId());
        }
        this.f18328g.registerListener(this.l);
        AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f18326e.getPageContext().getPageActivity()));
        this.f18329h = atMeCacheModel;
        atMeCacheModel.K(this);
        AtMessageActivity atMessageActivity2 = this.f18326e;
        if (atMessageActivity2 != null) {
            this.f18329h.setUniqueId(atMessageActivity2.getUniqueId());
        }
        this.k = new g();
        this.f18330i = new d.a.i0.g0.d.a();
    }

    public boolean w() {
        if (!this.f18328g.M() && this.f18330i.a() && t()) {
            this.f18330i.f(true);
            this.f18330i.h(true);
            this.f18327f.d(this.j);
            this.f18328g.setNeedCache(false);
            this.f18328g.N();
            this.f18326e.onViewStateChanged(this.f18330i);
            return true;
        }
        return false;
    }

    public boolean x(b bVar, c cVar) {
        this.f18326e.hideNetRefreshView();
        if (bVar.a() != 4) {
            this.k.a().clear();
        }
        this.k.d(cVar);
        if (cVar != null && cVar.a() != null && cVar.a().size() > 0) {
            this.j = cVar.a().get(cVar.a().size() - 1);
            if (this.k.b() != null) {
                this.f18330i.e(this.k.b().b() == 1);
            } else {
                this.f18330i.e(true);
            }
            if (bVar != null) {
                bVar.e();
            }
            this.f18330i.h(true);
        } else {
            this.j = null;
            this.f18330i.e(false);
            this.f18330i.h(false);
        }
        this.f18330i.f(false);
        this.f18330i.g(false);
        d.a.i0.s.d.b.g0().k();
        if (!TbadkCoreApplication.isLogin()) {
            this.k.a().clear();
        } else {
            this.f18326e.onViewStateChanged(this.f18330i);
        }
        this.f18326e.onViewDataChanged(this.k);
        return false;
    }

    public boolean y() {
        if (this.f18328g.M() || !t()) {
            return false;
        }
        this.j = null;
        this.f18327f.b();
        this.f18328g.setNeedCache(true);
        this.f18328g.N();
        return true;
    }
}
