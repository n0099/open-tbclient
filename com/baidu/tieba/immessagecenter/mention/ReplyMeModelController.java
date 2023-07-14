package com.baidu.tieba.immessagecenter.mention;

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
import com.baidu.tieba.br8;
import com.baidu.tieba.l9;
import com.baidu.tieba.nf5;
import com.baidu.tieba.qq8;
import com.baidu.tieba.vq8;
import com.baidu.tieba.wq8;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<wq8>, NetModel.k<vq8, wq8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public vq8 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public qq8 e;
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

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void m(WriteCacheRespMsg<List<wq8>> writeCacheRespMsg, WriteCacheMessage<wq8> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, writeCacheRespMsg, writeCacheMessage) == null) {
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
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = replyMessageFragment;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage<wq8, ?> mvcSocketResponsedMessage, MvcSocketMessage<vq8, wq8> mvcSocketMessage, MvcNetMessage<vq8, wq8> mvcNetMessage) {
        wq8 wq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            vq8 vq8Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                wq8Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    vq8Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    vq8Var = mvcNetMessage.getRequestData();
                }
            } else {
                nf5.p0().m0(0);
                wq8Var = null;
            }
            if (vq8Var != null && wq8Var != null && a0(vq8Var, wq8Var, false)) {
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

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void M(MvcHttpResponsedMessage<wq8> mvcHttpResponsedMessage, MvcHttpMessage<vq8, wq8> mvcHttpMessage, MvcNetMessage<vq8, wq8> mvcNetMessage) {
        wq8 wq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            vq8 vq8Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                wq8Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    vq8Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    vq8Var = mvcNetMessage.getRequestData();
                }
            } else {
                nf5.p0().m0(0);
                wq8Var = null;
            }
            if (vq8Var != null && wq8Var != null && a0(vq8Var, wq8Var, false)) {
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

    public boolean V() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                qq8 qq8Var = this.e;
                if (qq8Var != null && (arrayList = qq8Var.a) != null) {
                    arrayList.clear();
                }
                this.a.R1();
                this.a.b2(false, null);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (V()) {
                this.d.m0(this.b);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ReplyMeNetModel replyMeNetModel = this.c;
            if (replyMeNetModel != null) {
                replyMeNetModel.x0(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.d;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.o0(null);
            }
        }
    }

    public void W(int i) {
        qq8 qq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (qq8Var = this.e) != null && qq8Var.a() != null && i < this.e.a().size()) {
            this.e.a().remove(i);
        }
    }

    public void Y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.b = new vq8();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.x0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.o0(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new qq8();
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c.p0() || !V()) {
                return false;
            }
            this.b.c(this.f);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.c.p0() && V()) {
                this.f = null;
                this.b.b();
                this.c.setNeedCache(true);
                this.c.loadData();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a0(vq8 vq8Var, wq8 wq8Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, vq8Var, wq8Var, z)) == null) {
            if (vq8Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(wq8Var);
            boolean z3 = true;
            if (wq8Var != null && wq8Var.a() != null && wq8Var.a().size() > 0) {
                this.f = wq8Var.a().get(wq8Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (vq8Var.a() == 1) {
                    nf5.p0().m0(0);
                }
                if (vq8Var != null) {
                    vq8Var.d();
                }
            } else {
                this.f = null;
                z2 = false;
                z3 = false;
            }
            nf5.p0().o();
            ArrayList<yn> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                br8 br8Var = new br8();
                br8Var.C(it.next());
                if (z) {
                    br8Var.E(false);
                }
                arrayList.add(br8Var);
            }
            this.a.b2(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void r(ReadCacheRespMsg<List<wq8>> readCacheRespMsg, ReadCacheMessage<wq8> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                a0(this.b, readCacheRespMsg.getData().get(0), true);
            }
            this.f = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
