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
import d.a.c.k.e.n;
import d.a.n0.s.d.b;
import d.a.o0.g1.b.g;
import d.a.o0.g1.b.l;
import d.a.o0.g1.b.m;
import d.a.o0.g1.b.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<m>, NetModel.k<l, m> {

    /* renamed from: e  reason: collision with root package name */
    public ReplyMessageFragment f17749e;

    /* renamed from: f  reason: collision with root package name */
    public l f17750f;

    /* renamed from: g  reason: collision with root package name */
    public ReplyMeNetModel f17751g;

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeCacheModel f17752h;

    /* renamed from: i  reason: collision with root package name */
    public g f17753i;
    public FeedData j;

    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.f17749e = replyMessageFragment;
    }

    public boolean A() {
        if (this.f17751g.Q() || !w()) {
            return false;
        }
        this.f17750f.c(this.j);
        this.f17751g.setNeedCache(false);
        this.f17751g.R();
        return true;
    }

    public boolean B(l lVar, m mVar, boolean z) {
        boolean z2;
        if (lVar.a() != 4) {
            this.f17753i.a().clear();
        }
        this.f17753i.c(mVar);
        boolean z3 = true;
        if (mVar != null && mVar.a() != null && mVar.a().size() > 0) {
            this.j = mVar.a().get(mVar.a().size() - 1);
            z2 = this.f17753i.b() == null || this.f17753i.b().b() == 1;
            if (lVar.a() == 1) {
                b.g0().e0(0);
            }
            if (lVar != null) {
                lVar.d();
            }
        } else {
            this.j = null;
            z2 = false;
            z3 = false;
        }
        b.g0().p();
        ArrayList<n> arrayList = new ArrayList<>();
        Iterator<FeedData> it = this.f17753i.f58884e.iterator();
        while (it.hasNext()) {
            a aVar = new a();
            aVar.F(it.next());
            if (z) {
                aVar.H(false);
            }
            arrayList.add(aVar);
        }
        this.f17749e.X0(z2, arrayList);
        return z3;
    }

    public boolean C() {
        if (this.f17751g.Q() || !w()) {
            return false;
        }
        this.j = null;
        this.f17750f.b();
        this.f17751g.setNeedCache(true);
        this.f17751g.R();
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
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
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
        if (r1 == null || mVar == null || !B(r1, mVar, false)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.f17749e.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
            B(this.f17750f, readCacheRespMsg.getData().get(0), true);
        }
        this.j = null;
        this.f17750f.b();
        this.f17751g.setNeedCache(true);
        this.f17751g.R();
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
    }

    public void onDestroy() {
        ReplyMeNetModel replyMeNetModel = this.f17751g;
        if (replyMeNetModel != null) {
            replyMeNetModel.Z(null);
        }
        ReplyMeCacheModel replyMeCacheModel = this.f17752h;
        if (replyMeCacheModel != null) {
            replyMeCacheModel.O(null);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
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
        if (r1 == null || mVar == null || !B(r1, mVar, false)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.f17749e.onServerError(errorData);
            }
        }
    }

    public boolean w() {
        ArrayList<FeedData> arrayList;
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        g gVar = this.f17753i;
        if (gVar != null && (arrayList = gVar.f58884e) != null) {
            arrayList.clear();
        }
        this.f17749e.R0();
        this.f17749e.X0(false, null);
        return false;
    }

    public void x(int i2) {
        g gVar = this.f17753i;
        if (gVar == null || gVar.a() == null || i2 >= this.f17753i.a().size()) {
            return;
        }
        this.f17753i.a().remove(i2);
    }

    public boolean y() {
        if (w()) {
            this.f17752h.M(this.f17750f);
            return true;
        }
        return true;
    }

    public void z(Bundle bundle) {
        this.f17750f = new l();
        ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.f17749e.getPageContext(), this.f17750f);
        this.f17751g = replyMeNetModel;
        replyMeNetModel.Z(this);
        this.f17751g.setUniqueId(this.f17749e.getUniqueId());
        ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.f17749e.getPageContext());
        this.f17752h = replyMeCacheModel;
        replyMeCacheModel.O(this);
        this.f17752h.setUniqueId(this.f17749e.getUniqueId());
        this.f17753i = new g();
    }
}
