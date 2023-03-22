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
import com.baidu.tieba.a9;
import com.baidu.tieba.az7;
import com.baidu.tieba.bz7;
import com.baidu.tieba.gn;
import com.baidu.tieba.gz7;
import com.baidu.tieba.i85;
import com.baidu.tieba.vy7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<bz7>, NetModel.k<az7, bz7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public az7 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public vy7 e;
    public FeedData f;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void g(WriteCacheRespMsg<List<bz7>> writeCacheRespMsg, WriteCacheMessage<bz7> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = replyMessageFragment;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void F(MvcHttpResponsedMessage<bz7> mvcHttpResponsedMessage, MvcHttpMessage<az7, bz7> mvcHttpMessage, MvcNetMessage<az7, bz7> mvcNetMessage) {
        bz7 bz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            az7 az7Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                bz7Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    az7Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    az7Var = mvcNetMessage.getRequestData();
                }
            } else {
                i85.h0().f0(0);
                bz7Var = null;
            }
            if (az7Var != null && bz7Var != null && W(az7Var, bz7Var, false)) {
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
                this.a.g(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage<bz7, ?> mvcSocketResponsedMessage, MvcSocketMessage<az7, bz7> mvcSocketMessage, MvcNetMessage<az7, bz7> mvcNetMessage) {
        bz7 bz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            az7 az7Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                bz7Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    az7Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    az7Var = mvcNetMessage.getRequestData();
                }
            } else {
                i85.h0().f0(0);
                bz7Var = null;
            }
            if (az7Var != null && bz7Var != null && W(az7Var, bz7Var, false)) {
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
                this.a.g(errorData);
            }
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                vy7 vy7Var = this.e;
                if (vy7Var != null && (arrayList = vy7Var.a) != null) {
                    arrayList.clear();
                }
                this.a.O1();
                this.a.Y1(false, null);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (R()) {
                this.d.h0(this.b);
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
                replyMeNetModel.t0(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.d;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.j0(null);
            }
        }
    }

    public void S(int i) {
        vy7 vy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (vy7Var = this.e) != null && vy7Var.a() != null && i < this.e.a().size()) {
            this.e.a().remove(i);
        }
    }

    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b = new az7();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.t0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.j0(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new vy7();
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.l0() || !R()) {
                return false;
            }
            this.b.c(this.f);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.c.l0() && R()) {
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

    public boolean W(az7 az7Var, bz7 bz7Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, az7Var, bz7Var, z)) == null) {
            if (az7Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(bz7Var);
            boolean z3 = true;
            if (bz7Var != null && bz7Var.a() != null && bz7Var.a().size() > 0) {
                this.f = bz7Var.a().get(bz7Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (az7Var.a() == 1) {
                    i85.h0().f0(0);
                }
                if (az7Var != null) {
                    az7Var.d();
                }
            } else {
                this.f = null;
                z2 = false;
                z3 = false;
            }
            i85.h0().o();
            ArrayList<gn> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                gz7 gz7Var = new gz7();
                gz7Var.E(it.next());
                if (z) {
                    gz7Var.G(false);
                }
                arrayList.add(gz7Var);
            }
            this.a.Y1(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void k(ReadCacheRespMsg<List<bz7>> readCacheRespMsg, ReadCacheMessage<bz7> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                W(this.b, readCacheRespMsg.getData().get(0), true);
            }
            this.f = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
