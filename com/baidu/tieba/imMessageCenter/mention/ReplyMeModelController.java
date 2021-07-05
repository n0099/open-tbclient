package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.r0.s.d.b;
import d.a.s0.j1.b.g;
import d.a.s0.j1.b.l;
import d.a.s0.j1.b.m;
import d.a.s0.j1.b.p.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<m>, NetModel.k<l, m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReplyMessageFragment f17875e;

    /* renamed from: f  reason: collision with root package name */
    public l f17876f;

    /* renamed from: g  reason: collision with root package name */
    public ReplyMeNetModel f17877g;

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeCacheModel f17878h;

    /* renamed from: i  reason: collision with root package name */
    public g f17879i;
    public FeedData j;

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
        this.f17875e = replyMessageFragment;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f17877g.Q() || !w()) {
                return false;
            }
            this.f17876f.d(this.j);
            this.f17877g.setNeedCache(false);
            this.f17877g.R();
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
                this.f17879i.a().clear();
            }
            this.f17879i.d(mVar);
            boolean z3 = true;
            if (mVar != null && mVar.a() != null && mVar.a().size() > 0) {
                this.j = mVar.a().get(mVar.a().size() - 1);
                z2 = this.f17879i.c() == null || this.f17879i.c().b() == 1;
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
            Iterator<FeedData> it = this.f17879i.f62252e.iterator();
            while (it.hasNext()) {
                a aVar = new a();
                aVar.D(it.next());
                if (z) {
                    aVar.F(false);
                }
                arrayList.add(aVar);
            }
            this.f17875e.X0(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f17877g.Q() || !w()) {
                return false;
            }
            this.j = null;
            this.f17876f.c();
            this.f17877g.setNeedCache(true);
            this.f17877g.R();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
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
                    this.f17875e.onServerError(errorData);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
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
                B(this.f17876f, readCacheRespMsg.getData().get(0), true);
            }
            this.j = null;
            this.f17876f.c();
            this.f17877g.setNeedCache(true);
            this.f17877g.R();
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
            ReplyMeNetModel replyMeNetModel = this.f17877g;
            if (replyMeNetModel != null) {
                replyMeNetModel.Z(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.f17878h;
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
                    this.f17875e.onServerError(errorData);
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
            g gVar = this.f17879i;
            if (gVar != null && (arrayList = gVar.f62252e) != null) {
                arrayList.clear();
            }
            this.f17875e.R0();
            this.f17875e.X0(false, null);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x(int i2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (gVar = this.f17879i) == null || gVar.a() == null || i2 >= this.f17879i.a().size()) {
            return;
        }
        this.f17879i.a().remove(i2);
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (w()) {
                this.f17878h.M(this.f17876f);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            this.f17876f = new l();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.f17875e.getPageContext(), this.f17876f);
            this.f17877g = replyMeNetModel;
            replyMeNetModel.Z(this);
            this.f17877g.setUniqueId(this.f17875e.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.f17875e.getPageContext());
            this.f17878h = replyMeCacheModel;
            replyMeCacheModel.O(this);
            this.f17878h.setUniqueId(this.f17875e.getUniqueId());
            this.f17879i = new g();
        }
    }
}
