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
import com.baidu.tieba.a39;
import com.baidu.tieba.oi;
import com.baidu.tieba.q29;
import com.baidu.tieba.r39;
import com.baidu.tieba.u29;
import com.baidu.tieba.v29;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<v29>, NetModel.k<u29, v29> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public u29 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public q29 e;
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
    public void onCacheDataWrite(WriteCacheRespMsg<List<v29>> writeCacheRespMsg, WriteCacheMessage<v29> writeCacheMessage) {
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
    public void I(MvcHttpResponsedMessage<v29> mvcHttpResponsedMessage, MvcHttpMessage<u29, v29> mvcHttpMessage, MvcNetMessage<u29, v29> mvcNetMessage) {
        v29 v29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            u29 u29Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                v29Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    u29Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    u29Var = mvcNetMessage.getRequestData();
                }
            } else {
                y95.p0().m0(0);
                v29Var = null;
            }
            if (u29Var != null && v29Var != null && U(u29Var, v29Var, false)) {
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
                this.a.f(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage<v29, ?> mvcSocketResponsedMessage, MvcSocketMessage<u29, v29> mvcSocketMessage, MvcNetMessage<u29, v29> mvcNetMessage) {
        v29 v29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            u29 u29Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                v29Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    u29Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    u29Var = mvcNetMessage.getRequestData();
                }
            } else {
                y95.p0().m0(0);
                v29Var = null;
            }
            if (u29Var != null && v29Var != null && U(u29Var, v29Var, false)) {
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
                this.a.f(errorData);
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                q29 q29Var = this.e;
                if (q29Var != null && (arrayList = q29Var.a) != null) {
                    arrayList.clear();
                }
                this.a.E2();
                this.a.Q2(false, null);
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
        q29 q29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (q29Var = this.e) != null && q29Var.a() != null && i < this.e.a().size()) {
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
            this.b = new u29();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.q0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.setCallback(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new q29();
        }
    }

    public void T(@NonNull r39 r39Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, r39Var) == null) && !this.c.i0() && O()) {
            this.f = null;
            this.b.f(0);
            if (r39Var.b() == 0) {
                this.b.g(r39Var.c());
            }
            if (r39Var.b() == 1) {
                this.b.h(r39Var.c());
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

    public boolean U(u29 u29Var, v29 v29Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, u29Var, v29Var, z)) == null) {
            if (u29Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(v29Var);
            boolean z3 = true;
            if (v29Var != null && v29Var.a() != null && v29Var.a().size() > 0) {
                this.f = v29Var.a().get(v29Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (u29Var.a() == 1) {
                    y95.p0().m0(0);
                }
                if (u29Var != null) {
                    u29Var.i();
                }
            } else {
                this.f = null;
                z3 = false;
                z2 = false;
            }
            y95.p0().o();
            ArrayList<oi> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                a39 a39Var = new a39();
                a39Var.C(it.next());
                if (z) {
                    a39Var.E(false);
                }
                arrayList.add(a39Var);
            }
            if (u29Var != null && u29Var.b() && v29Var != null) {
                this.a.P2(v29Var.b, v29Var.c);
            }
            this.a.Q2(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<v29>> readCacheRespMsg, ReadCacheMessage<v29> readCacheMessage) {
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
