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
import com.baidu.tieba.c69;
import com.baidu.tieba.e79;
import com.baidu.tieba.g69;
import com.baidu.tieba.ga5;
import com.baidu.tieba.h69;
import com.baidu.tieba.m69;
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
public class ReplyMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<h69>, NetModel.k<g69, h69> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public g69 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public c69 e;
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
    public void onCacheDataWrite(WriteCacheRespMsg<List<h69>> writeCacheRespMsg, WriteCacheMessage<h69> writeCacheMessage) {
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
    public void I(MvcHttpResponsedMessage<h69> mvcHttpResponsedMessage, MvcHttpMessage<g69, h69> mvcHttpMessage, MvcNetMessage<g69, h69> mvcNetMessage) {
        h69 h69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            g69 g69Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                h69Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    g69Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    g69Var = mvcNetMessage.getRequestData();
                }
            } else {
                ga5.p0().m0(0);
                h69Var = null;
            }
            if (g69Var != null && h69Var != null && U(g69Var, h69Var, false)) {
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
    public void u(MvcSocketResponsedMessage<h69, ?> mvcSocketResponsedMessage, MvcSocketMessage<g69, h69> mvcSocketMessage, MvcNetMessage<g69, h69> mvcNetMessage) {
        h69 h69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            g69 g69Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                h69Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    g69Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    g69Var = mvcNetMessage.getRequestData();
                }
            } else {
                ga5.p0().m0(0);
                h69Var = null;
            }
            if (g69Var != null && h69Var != null && U(g69Var, h69Var, false)) {
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
                c69 c69Var = this.e;
                if (c69Var != null && (arrayList = c69Var.a) != null) {
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
        c69 c69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (c69Var = this.e) != null && c69Var.a() != null && i < this.e.a().size()) {
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
            this.b = new g69();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.q0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.setCallback(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new c69();
        }
    }

    public void T(@NonNull e79 e79Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, e79Var) == null) && !this.c.i0() && O()) {
            this.f = null;
            this.b.f(0);
            if (e79Var.b() == 0) {
                this.b.g(e79Var.c());
            }
            if (e79Var.b() == 1) {
                this.b.h(e79Var.c());
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

    public boolean U(g69 g69Var, h69 h69Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, g69Var, h69Var, z)) == null) {
            if (g69Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(h69Var);
            boolean z3 = true;
            if (h69Var != null && h69Var.a() != null && h69Var.a().size() > 0) {
                this.f = h69Var.a().get(h69Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (g69Var.a() == 1) {
                    ga5.p0().m0(0);
                }
                if (g69Var != null) {
                    g69Var.i();
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
                m69 m69Var = new m69();
                m69Var.C(it.next());
                if (z) {
                    m69Var.E(false);
                }
                arrayList.add(m69Var);
            }
            if (g69Var != null && g69Var.b() && h69Var != null) {
                this.a.b3(h69Var.b, h69Var.c);
            }
            this.a.c3(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<h69>> readCacheRespMsg, ReadCacheMessage<h69> readCacheMessage) {
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
