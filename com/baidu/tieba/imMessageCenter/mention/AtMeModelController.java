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
import d.b.b.a.j;
import d.b.i0.e1.b.b;
import d.b.i0.e1.b.c;
import d.b.i0.e1.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<c>, NetModel.k<b, c> {

    /* renamed from: e  reason: collision with root package name */
    public AtMessageActivity f18301e;

    /* renamed from: f  reason: collision with root package name */
    public b f18302f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f18303g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f18304h;
    public d.b.h0.g0.d.a i;
    public FeedData j;
    public g k;
    public final CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                AtMeModelController.this.f18301e.dismissPullRefresh();
            }
        }
    }

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        this.l = new a(2000994);
        this.f18301e = atMessageActivity;
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
    public void f(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f18301e.dismissPullRefresh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.b.h0.s.d.b.g0().Z(0);
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
            this.f18301e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f18301e.dismissPullRefresh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.b.h0.s.d.b.g0().Z(0);
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
            this.f18301e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f18302f, readCacheRespMsg.getData().get(0));
        }
        this.j = null;
        this.f18302f.c();
        this.f18303g.setNeedCache(true);
        this.f18303g.N();
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
        if (gVar != null && (arrayList = gVar.f54431e) != null) {
            arrayList.clear();
        }
        this.f18301e.dismissPullRefresh();
        this.f18301e.onViewDataChanged(this.k);
        return false;
    }

    public boolean u() {
        if (t()) {
            AtMessageActivity atMessageActivity = this.f18301e;
            if (atMessageActivity != null) {
                atMessageActivity.showPullRefresh();
            }
            this.f18304h.I(this.f18302f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f18302f = new b();
        AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f18301e.getPageContext().getPageActivity()), this.f18302f);
        this.f18303g = atMeNetModel;
        atMeNetModel.V(this);
        AtMessageActivity atMessageActivity = this.f18301e;
        if (atMessageActivity != null) {
            this.f18303g.setUniqueId(atMessageActivity.getUniqueId());
        }
        this.f18303g.registerListener(this.l);
        AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f18301e.getPageContext().getPageActivity()));
        this.f18304h = atMeCacheModel;
        atMeCacheModel.K(this);
        AtMessageActivity atMessageActivity2 = this.f18301e;
        if (atMessageActivity2 != null) {
            this.f18304h.setUniqueId(atMessageActivity2.getUniqueId());
        }
        this.k = new g();
        this.i = new d.b.h0.g0.d.a();
    }

    public boolean w() {
        if (!this.f18303g.M() && this.i.a() && t()) {
            this.i.f(true);
            this.i.h(true);
            this.f18302f.d(this.j);
            this.f18303g.setNeedCache(false);
            this.f18303g.N();
            this.f18301e.onViewStateChanged(this.i);
            return true;
        }
        return false;
    }

    public boolean x(b bVar, c cVar) {
        this.f18301e.hideNetRefreshView();
        if (bVar.b() != 4) {
            this.k.b().clear();
        }
        this.k.d(cVar);
        if (cVar != null && cVar.b() != null && cVar.b().size() > 0) {
            this.j = cVar.b().get(cVar.b().size() - 1);
            if (this.k.c() != null) {
                this.i.e(this.k.c().b() == 1);
            } else {
                this.i.e(true);
            }
            if (bVar != null) {
                bVar.f();
            }
            this.i.h(true);
        } else {
            this.j = null;
            this.i.e(false);
            this.i.h(false);
        }
        this.i.f(false);
        this.i.g(false);
        d.b.h0.s.d.b.g0().k();
        if (!TbadkCoreApplication.isLogin()) {
            this.k.b().clear();
        } else {
            this.f18301e.onViewStateChanged(this.i);
        }
        this.f18301e.onViewDataChanged(this.k);
        return false;
    }

    public boolean y() {
        if (this.f18303g.M() || !t()) {
            return false;
        }
        this.j = null;
        this.f18302f.c();
        this.f18303g.setNeedCache(true);
        this.f18303g.N();
        return true;
    }
}
