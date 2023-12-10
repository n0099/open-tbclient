package com.baidu.tieba.immessagecenter.mention;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
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
import com.baidu.tieba.d69;
import com.baidu.tieba.f79;
import com.baidu.tieba.ga5;
import com.baidu.tieba.h69;
import com.baidu.tieba.i69;
import com.baidu.tieba.n69;
import com.baidu.tieba.pi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<i69>, NetModel.k<h69, i69> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public h69 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public d69 e;
    public FeedData f;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataWrite(WriteCacheRespMsg<List<i69>> writeCacheRespMsg, WriteCacheMessage<i69> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyMeModelController(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = replyMessageFragment;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage<i69> mvcHttpResponsedMessage, MvcHttpMessage<h69, i69> mvcHttpMessage, MvcNetMessage<h69, i69> mvcNetMessage) {
        i69 i69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            h69 h69Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                i69Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    h69Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    h69Var = mvcNetMessage.getRequestData();
                }
            } else {
                ga5.p0().m0(0);
                i69Var = null;
            }
            if (h69Var != null && i69Var != null && U(h69Var, i69Var, false)) {
                return;
            }
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.a.i(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage<i69, ?> mvcSocketResponsedMessage, MvcSocketMessage<h69, i69> mvcSocketMessage, MvcNetMessage<h69, i69> mvcNetMessage) {
        i69 i69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            h69 h69Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                i69Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    h69Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    h69Var = mvcNetMessage.getRequestData();
                }
            } else {
                ga5.p0().m0(0);
                i69Var = null;
            }
            if (h69Var != null && i69Var != null && U(h69Var, i69Var, false)) {
                return;
            }
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            if (this.mErrorCode != 0) {
                this.a.i(errorData);
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                d69 d69Var = this.e;
                if (d69Var != null && (arrayList = d69Var.a) != null) {
                    arrayList.clear();
                }
                this.a.Q2();
                this.a.c3(false, null);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.b.f(1);
            if (O()) {
                this.d.loadSingleCache(this.b);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ReplyMeNetModel replyMeNetModel = this.c;
            if (replyMeNetModel != null) {
                replyMeNetModel.q0(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.d;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.setCallback(null);
            }
        }
    }

    public void P(int i) {
        d69 d69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (d69Var = this.e) != null && d69Var.a() != null && i < this.e.a().size()) {
            this.e.a().remove(i);
        }
    }

    public void setFrom(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.b.d(str);
        }
    }

    public void R(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b = new h69();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.q0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.setCallback(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new d69();
        }
    }

    public void T(@NonNull f79 f79Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, f79Var) == null) && !this.c.i0() && O()) {
            this.f = null;
            this.b.f(0);
            if (f79Var.b() == 0) {
                this.b.g(f79Var.c());
            }
            if (f79Var.b() == 1) {
                this.b.h(f79Var.c());
            }
            this.b.c();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.i0() || !O()) {
                return false;
            }
            this.b.f(0);
            this.b.e(this.f);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c.i0() || !O()) {
                return false;
            }
            this.f = null;
            this.b.f(0);
            this.b.c();
            this.c.setNeedCache(true);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean U(h69 h69Var, i69 i69Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, h69Var, i69Var, z)) == null) {
            if (h69Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(i69Var);
            boolean z3 = true;
            if (i69Var != null && i69Var.a() != null && i69Var.a().size() > 0) {
                this.f = i69Var.a().get(i69Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (h69Var.a() == 1) {
                    ga5.p0().m0(0);
                }
                if (h69Var != null) {
                    h69Var.i();
                }
            } else {
                this.f = null;
                z3 = false;
                z2 = false;
            }
            ga5.p0().o();
            ArrayList<pi> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                n69 n69Var = new n69();
                n69Var.C(it.next());
                if (z) {
                    n69Var.E(false);
                }
                arrayList.add(n69Var);
            }
            if (h69Var != null && h69Var.b() && i69Var != null) {
                this.a.b3(i69Var.b, i69Var.c);
            }
            this.a.c3(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<i69>> readCacheRespMsg, ReadCacheMessage<i69> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                U(this.b, readCacheRespMsg.getData().get(0), true);
            }
            this.f = null;
            this.b.c();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
