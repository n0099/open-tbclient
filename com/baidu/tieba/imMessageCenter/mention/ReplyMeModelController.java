package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.s0.t.d.b;
import c.a.t0.t1.b.g;
import c.a.t0.t1.b.l;
import c.a.t0.t1.b.m;
import c.a.t0.t1.b.p.a;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<m>, NetModel.k<l, m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReplyMessageFragment f45308e;

    /* renamed from: f  reason: collision with root package name */
    public l f45309f;

    /* renamed from: g  reason: collision with root package name */
    public ReplyMeNetModel f45310g;

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeCacheModel f45311h;

    /* renamed from: i  reason: collision with root package name */
    public g f45312i;

    /* renamed from: j  reason: collision with root package name */
    public FeedData f45313j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45308e = replyMessageFragment;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f45310g.Q() || !w()) {
                return false;
            }
            this.f45309f.c(this.f45313j);
            this.f45310g.setNeedCache(false);
            this.f45310g.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean B(l lVar, m mVar, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, mVar, z)) == null) {
            if (lVar.a() != 4) {
                this.f45312i.a().clear();
            }
            this.f45312i.c(mVar);
            boolean z3 = true;
            if (mVar != null && mVar.a() != null && mVar.a().size() > 0) {
                this.f45313j = mVar.a().get(mVar.a().size() - 1);
                z2 = this.f45312i.b() == null || this.f45312i.b().b() == 1;
                if (lVar.a() == 1) {
                    b.g0().e0(0);
                }
                if (lVar != null) {
                    lVar.d();
                }
            } else {
                this.f45313j = null;
                z2 = false;
                z3 = false;
            }
            b.g0().p();
            ArrayList<n> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f45312i.f23767e.iterator();
            while (it.hasNext()) {
                a aVar = new a();
                aVar.G(it.next());
                if (z) {
                    aVar.I(false);
                }
                arrayList.add(aVar);
            }
            this.f45308e.onViewDataChange(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f45310g.Q() || !w()) {
                return false;
            }
            this.f45313j = null;
            this.f45309f.b();
            this.f45310g.setNeedCache(true);
            this.f45310g.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
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
                    this.f45308e.onServerError(errorData);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataGet(ReadCacheRespMsg<List<m>> readCacheRespMsg, ReadCacheMessage<m> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                B(this.f45309f, readCacheRespMsg.getData().get(0), true);
            }
            this.f45313j = null;
            this.f45309f.b();
            this.f45310g.setNeedCache(true);
            this.f45310g.loadData();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void onCacheDataWrite(WriteCacheRespMsg<List<m>> writeCacheRespMsg, WriteCacheMessage<m> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ReplyMeNetModel replyMeNetModel = this.f45310g;
            if (replyMeNetModel != null) {
                replyMeNetModel.Y(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.f45311h;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.O(null);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
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
                    this.f45308e.onServerError(errorData);
                }
            }
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            g gVar = this.f45312i;
            if (gVar != null && (arrayList = gVar.f23767e) != null) {
                arrayList.clear();
            }
            this.f45308e.interruptRefreshing();
            this.f45308e.onViewDataChange(false, null);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (gVar = this.f45312i) == null || gVar.a() == null || i2 >= this.f45312i.a().size()) {
            return;
        }
        this.f45312i.a().remove(i2);
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (w()) {
                this.f45311h.M(this.f45309f);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            this.f45309f = new l();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.f45308e.getPageContext(), this.f45309f);
            this.f45310g = replyMeNetModel;
            replyMeNetModel.Y(this);
            this.f45310g.setUniqueId(this.f45308e.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.f45308e.getPageContext());
            this.f45311h = replyMeCacheModel;
            replyMeCacheModel.O(this);
            this.f45311h.setUniqueId(this.f45308e.getUniqueId());
            this.f45312i = new g();
        }
    }
}
