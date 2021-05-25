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
    public AtMessageActivity f17551e;

    /* renamed from: f  reason: collision with root package name */
    public b f17552f;

    /* renamed from: g  reason: collision with root package name */
    public AtMeNetModel f17553g;

    /* renamed from: h  reason: collision with root package name */
    public AtMeCacheModel f17554h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.g0.d.a f17555i;
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
                AtMeModelController.this.f17551e.dismissPullRefresh();
            }
        }
    }

    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(j.a(atMessageActivity.getPageContext().getPageActivity()));
        this.l = new a(2000994);
        this.f17551e = atMessageActivity;
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
        this.f17551e.dismissPullRefresh();
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
        if (r0 == null || cVar == null || !x(r0, cVar)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f17551e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage<c> mvcHttpResponsedMessage, MvcHttpMessage<b, c> mvcHttpMessage, MvcNetMessage<b, c> mvcNetMessage) {
        c cVar;
        this.f17551e.dismissPullRefresh();
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
        if (r0 == null || cVar == null || !x(r0, cVar)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            this.f17551e.onServerError(errorData);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<c>> readCacheRespMsg, ReadCacheMessage<c> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            x(this.f17552f, readCacheRespMsg.getData().get(0));
        }
        this.j = null;
        this.f17552f.b();
        this.f17553g.setNeedCache(true);
        this.f17553g.N();
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
        if (gVar != null && (arrayList = gVar.f55070e) != null) {
            arrayList.clear();
        }
        this.f17551e.dismissPullRefresh();
        this.f17551e.onViewDataChanged(this.k);
        return false;
    }

    public boolean u() {
        if (t()) {
            AtMessageActivity atMessageActivity = this.f17551e;
            if (atMessageActivity != null) {
                atMessageActivity.showPullRefresh();
            }
            this.f17554h.I(this.f17552f);
            return true;
        }
        return true;
    }

    public void v(Bundle bundle) {
        this.f17552f = new b();
        AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) j.a(this.f17551e.getPageContext().getPageActivity()), this.f17552f);
        this.f17553g = atMeNetModel;
        atMeNetModel.V(this);
        AtMessageActivity atMessageActivity = this.f17551e;
        if (atMessageActivity != null) {
            this.f17553g.setUniqueId(atMessageActivity.getUniqueId());
        }
        this.f17553g.registerListener(this.l);
        AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) j.a(this.f17551e.getPageContext().getPageActivity()));
        this.f17554h = atMeCacheModel;
        atMeCacheModel.K(this);
        AtMessageActivity atMessageActivity2 = this.f17551e;
        if (atMessageActivity2 != null) {
            this.f17554h.setUniqueId(atMessageActivity2.getUniqueId());
        }
        this.k = new g();
        this.f17555i = new d.a.m0.g0.d.a();
    }

    public boolean w() {
        if (!this.f17553g.M() && this.f17555i.a() && t()) {
            this.f17555i.f(true);
            this.f17555i.h(true);
            this.f17552f.d(this.j);
            this.f17553g.setNeedCache(false);
            this.f17553g.N();
            this.f17551e.onViewStateChanged(this.f17555i);
            return true;
        }
        return false;
    }

    public boolean x(b bVar, c cVar) {
        this.f17551e.hideNetRefreshView();
        if (bVar.a() != 4) {
            this.k.a().clear();
        }
        this.k.d(cVar);
        if (cVar != null && cVar.a() != null && cVar.a().size() > 0) {
            this.j = cVar.a().get(cVar.a().size() - 1);
            if (this.k.b() != null) {
                this.f17555i.e(this.k.b().b() == 1);
            } else {
                this.f17555i.e(true);
            }
            if (bVar != null) {
                bVar.e();
            }
            this.f17555i.h(true);
        } else {
            this.j = null;
            this.f17555i.e(false);
            this.f17555i.h(false);
        }
        this.f17555i.f(false);
        this.f17555i.g(false);
        d.a.m0.s.d.b.g0().k();
        if (!TbadkCoreApplication.isLogin()) {
            this.k.a().clear();
        } else {
            this.f17551e.onViewStateChanged(this.f17555i);
        }
        this.f17551e.onViewDataChanged(this.k);
        return false;
    }

    public boolean y() {
        if (this.f17553g.M() || !t()) {
            return false;
        }
        this.j = null;
        this.f17552f.b();
        this.f17553g.setNeedCache(true);
        this.f17553g.N();
        return true;
    }
}
