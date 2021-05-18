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
import d.a.k0.f1.b.b;
import d.a.k0.f1.b.c;
import d.a.k0.f1.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<c>, NetModel.k<b, c> {

    /* renamed from: e  reason: collision with root package name */
    public AtMessageActivity f17641e;

    /* renamed from: f  reason: collision with root package name */
    public b f17642f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f17643g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f17644h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.g0.d.a f17645i;
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
                AtMeModelController.this.f17641e.dismissPullRefresh();
            }
        }
    }

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        this.l = new a(2000994);
        this.f17641e = atMessageActivity;
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
        this.f17641e.dismissPullRefresh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.j0.s.d.b.g0().Z(0);
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
            this.f17641e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f17641e.dismissPullRefresh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.j0.s.d.b.g0().Z(0);
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
            this.f17641e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f17642f, readCacheRespMsg.getData().get(0));
        }
        this.j = null;
        this.f17642f.b();
        this.f17643g.setNeedCache(true);
        this.f17643g.N();
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
        if (gVar != null && (arrayList = gVar.f54882e) != null) {
            arrayList.clear();
        }
        this.f17641e.dismissPullRefresh();
        this.f17641e.onViewDataChanged(this.k);
        return false;
    }

    public boolean u() {
        if (t()) {
            AtMessageActivity atMessageActivity = this.f17641e;
            if (atMessageActivity != null) {
                atMessageActivity.showPullRefresh();
            }
            this.f17644h.I(this.f17642f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f17642f = new b();
        AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f17641e.getPageContext().getPageActivity()), this.f17642f);
        this.f17643g = atMeNetModel;
        atMeNetModel.V(this);
        AtMessageActivity atMessageActivity = this.f17641e;
        if (atMessageActivity != null) {
            this.f17643g.setUniqueId(atMessageActivity.getUniqueId());
        }
        this.f17643g.registerListener(this.l);
        AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f17641e.getPageContext().getPageActivity()));
        this.f17644h = atMeCacheModel;
        atMeCacheModel.K(this);
        AtMessageActivity atMessageActivity2 = this.f17641e;
        if (atMessageActivity2 != null) {
            this.f17644h.setUniqueId(atMessageActivity2.getUniqueId());
        }
        this.k = new g();
        this.f17645i = new d.a.j0.g0.d.a();
    }

    public boolean w() {
        if (!this.f17643g.M() && this.f17645i.a() && t()) {
            this.f17645i.f(true);
            this.f17645i.h(true);
            this.f17642f.d(this.j);
            this.f17643g.setNeedCache(false);
            this.f17643g.N();
            this.f17641e.onViewStateChanged(this.f17645i);
            return true;
        }
        return false;
    }

    public boolean x(b bVar, c cVar) {
        this.f17641e.hideNetRefreshView();
        if (bVar.a() != 4) {
            this.k.a().clear();
        }
        this.k.d(cVar);
        if (cVar != null && cVar.a() != null && cVar.a().size() > 0) {
            this.j = cVar.a().get(cVar.a().size() - 1);
            if (this.k.b() != null) {
                this.f17645i.e(this.k.b().b() == 1);
            } else {
                this.f17645i.e(true);
            }
            if (bVar != null) {
                bVar.e();
            }
            this.f17645i.h(true);
        } else {
            this.j = null;
            this.f17645i.e(false);
            this.f17645i.h(false);
        }
        this.f17645i.f(false);
        this.f17645i.g(false);
        d.a.j0.s.d.b.g0().k();
        if (!TbadkCoreApplication.isLogin()) {
            this.k.a().clear();
        } else {
            this.f17641e.onViewStateChanged(this.f17645i);
        }
        this.f17641e.onViewDataChanged(this.k);
        return false;
    }

    public boolean y() {
        if (this.f17643g.M() || !t()) {
            return false;
        }
        this.j = null;
        this.f17642f.b();
        this.f17643g.setNeedCache(true);
        this.f17643g.N();
        return true;
    }
}
