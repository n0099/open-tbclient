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
import d.a.n0.g1.b.b;
import d.a.n0.g1.b.c;
import d.a.n0.g1.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<c>, NetModel.k<b, c> {

    /* renamed from: e  reason: collision with root package name */
    public AtMessageActivity f17627e;

    /* renamed from: f  reason: collision with root package name */
    public b f17628f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f17629g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f17630h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.g0.d.a f17631i;
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
                AtMeModelController.this.f17627e.dismissPullRefresh();
            }
        }
    }

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        this.l = new a(2000994);
        this.f17627e = atMessageActivity;
    }

    public boolean A() {
        if (!this.f17629g.Q() && this.f17631i.a() && x()) {
            this.f17631i.f(true);
            this.f17631i.h(true);
            this.f17628f.c(this.j);
            this.f17629g.setNeedCache(false);
            this.f17629g.R();
            this.f17627e.onViewStateChanged(this.f17631i);
            return true;
        }
        return false;
    }

    public boolean B(b bVar, c cVar) {
        this.f17627e.hideNetRefreshView();
        if (bVar.a() != 4) {
            this.k.a().clear();
        }
        this.k.c(cVar);
        if (cVar != null && cVar.a() != null && cVar.a().size() > 0) {
            this.j = cVar.a().get(cVar.a().size() - 1);
            if (this.k.b() != null) {
                this.f17631i.e(this.k.b().b() == 1);
            } else {
                this.f17631i.e(true);
            }
            if (bVar != null) {
                bVar.d();
            }
            this.f17631i.h(true);
        } else {
            this.j = null;
            this.f17631i.e(false);
            this.f17631i.h(false);
        }
        this.f17631i.f(false);
        this.f17631i.g(false);
        d.a.m0.s.d.b.g0().k();
        if (!TbadkCoreApplication.isLogin()) {
            this.k.a().clear();
        } else {
            this.f17627e.onViewStateChanged(this.f17631i);
        }
        this.f17627e.onViewDataChanged(this.k);
        return false;
    }

    public boolean C() {
        if (this.f17629g.Q() || !x()) {
            return false;
        }
        this.j = null;
        this.f17628f.b();
        this.f17629g.setNeedCache(true);
        this.f17629g.R();
        return true;
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
    public void k(MvcSocketResponsedMessage<c, ?> mvcSocketResponsedMessage, MvcSocketMessage<b, c> mvcSocketMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f17627e.dismissPullRefresh();
        if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
            cVar = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.m0.s.d.b.g0().Z(0);
            cVar = null;
        }
        if (r0 == null || cVar == null || !B(r0, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f17627e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            B(this.f17628f, readCacheRespMsg.getData().get(0));
        }
        this.j = null;
        this.f17628f.b();
        this.f17629g.setNeedCache(true);
        this.f17629g.R();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<c>> writeCacheRespMsg, WriteCacheMessage<c> writeCacheMessage) {
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f17627e.dismissPullRefresh();
        if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
            cVar = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r0 = mvcNetMessage.getRequestData();
            }
        } else {
            d.a.m0.s.d.b.g0().Z(0);
            cVar = null;
        }
        if (r0 == null || cVar == null || !B(r0, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f17627e.onServerError(errorData);
        }
    }

    public boolean x() {
        ArrayList<FeedData> arrayList;
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        g gVar = this.k;
        if (gVar != null && (arrayList = gVar.f58759e) != null) {
            arrayList.clear();
        }
        this.f17627e.dismissPullRefresh();
        this.f17627e.onViewDataChanged(this.k);
        return false;
    }

    public boolean y() {
        if (x()) {
            AtMessageActivity atMessageActivity = this.f17627e;
            if (atMessageActivity != null) {
                atMessageActivity.showPullRefresh();
            }
            this.f17630h.M(this.f17628f);
            return true;
        }
        return true;
    }

    public void z(Bundle bundle) {
        this.f17628f = new b();
        AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f17627e.getPageContext().getPageActivity()), this.f17628f);
        this.f17629g = atMeNetModel;
        atMeNetModel.Z(this);
        AtMessageActivity atMessageActivity = this.f17627e;
        if (atMessageActivity != null) {
            this.f17629g.setUniqueId(atMessageActivity.getUniqueId());
        }
        this.f17629g.registerListener(this.l);
        AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f17627e.getPageContext().getPageActivity()));
        this.f17630h = atMeCacheModel;
        atMeCacheModel.O(this);
        AtMessageActivity atMessageActivity2 = this.f17627e;
        if (atMessageActivity2 != null) {
            this.f17630h.setUniqueId(atMessageActivity2.getUniqueId());
        }
        this.k = new g();
        this.f17631i = new d.a.m0.g0.d.a();
    }
}
