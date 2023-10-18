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
import com.baidu.tieba.d95;
import com.baidu.tieba.lp8;
import com.baidu.tieba.mq8;
import com.baidu.tieba.pp8;
import com.baidu.tieba.qp8;
import com.baidu.tieba.vp8;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<qp8>, NetModel.k<pp8, qp8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public pp8 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public lp8 e;
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
    public void onCacheDataWrite(WriteCacheRespMsg<List<qp8>> writeCacheRespMsg, WriteCacheMessage<qp8> writeCacheMessage) {
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
    public void H(MvcHttpResponsedMessage<qp8> mvcHttpResponsedMessage, MvcHttpMessage<pp8, qp8> mvcHttpMessage, MvcNetMessage<pp8, qp8> mvcNetMessage) {
        qp8 qp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            pp8 pp8Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                qp8Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    pp8Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    pp8Var = mvcNetMessage.getRequestData();
                }
            } else {
                d95.p0().m0(0);
                qp8Var = null;
            }
            if (pp8Var != null && qp8Var != null && T(pp8Var, qp8Var, false)) {
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
    public void v(MvcSocketResponsedMessage<qp8, ?> mvcSocketResponsedMessage, MvcSocketMessage<pp8, qp8> mvcSocketMessage, MvcNetMessage<pp8, qp8> mvcNetMessage) {
        qp8 qp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            pp8 pp8Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                qp8Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    pp8Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    pp8Var = mvcNetMessage.getRequestData();
                }
            } else {
                d95.p0().m0(0);
                qp8Var = null;
            }
            if (pp8Var != null && qp8Var != null && T(pp8Var, qp8Var, false)) {
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

    public boolean N() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                lp8 lp8Var = this.e;
                if (lp8Var != null && (arrayList = lp8Var.a) != null) {
                    arrayList.clear();
                }
                this.a.m2();
                this.a.y2(false, null);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.b.f(1);
            if (N()) {
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
                replyMeNetModel.p0(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.d;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.setCallback(null);
            }
        }
    }

    public void O(int i) {
        lp8 lp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (lp8Var = this.e) != null && lp8Var.a() != null && i < this.e.a().size()) {
            this.e.a().remove(i);
        }
    }

    public void setFrom(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.b.d(str);
        }
    }

    public void Q(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b = new pp8();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.p0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.setCallback(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new lp8();
        }
    }

    public void S(@NonNull mq8 mq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, mq8Var) == null) && !this.c.h0() && N()) {
            this.f = null;
            this.b.f(0);
            if (mq8Var.b() == 0) {
                this.b.g(mq8Var.c());
            }
            if (mq8Var.b() == 1) {
                this.b.h(mq8Var.c());
            }
            this.b.c();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.h0() || !N()) {
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

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c.h0() || !N()) {
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

    public boolean T(pp8 pp8Var, qp8 qp8Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, pp8Var, qp8Var, z)) == null) {
            if (pp8Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(qp8Var);
            boolean z3 = true;
            if (qp8Var != null && qp8Var.a() != null && qp8Var.a().size() > 0) {
                this.f = qp8Var.a().get(qp8Var.a().size() - 1);
                if (this.e.b() != null && this.e.b().b() != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (pp8Var.a() == 1) {
                    d95.p0().m0(0);
                }
                if (pp8Var != null) {
                    pp8Var.i();
                }
            } else {
                this.f = null;
                z3 = false;
                z2 = false;
            }
            d95.p0().o();
            ArrayList<yh> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                vp8 vp8Var = new vp8();
                vp8Var.C(it.next());
                if (z) {
                    vp8Var.E(false);
                }
                arrayList.add(vp8Var);
            }
            if (pp8Var != null && pp8Var.b() && qp8Var != null) {
                this.a.x2(qp8Var.b, qp8Var.c);
            }
            this.a.y2(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<qp8>> readCacheRespMsg, ReadCacheMessage<qp8> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                T(this.b, readCacheRespMsg.getData().get(0), true);
            }
            this.f = null;
            this.b.c();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
