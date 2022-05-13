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
import com.repackage.b9;
import com.repackage.ky4;
import com.repackage.la7;
import com.repackage.qa7;
import com.repackage.ra7;
import com.repackage.ro;
import com.repackage.wa7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ReplyMeModelController extends BdBaseModel implements CacheModel.c<ra7>, NetModel.k<qa7, ra7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMessageFragment a;
    public qa7 b;
    public ReplyMeNetModel c;
    public ReplyMeCacheModel d;
    public la7 e;
    public FeedData f;

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
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = replyMessageFragment;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (y()) {
                this.d.O(this.b);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.b = new qa7();
            ReplyMeNetModel replyMeNetModel = new ReplyMeNetModel(this.a.getPageContext(), this.b);
            this.c = replyMeNetModel;
            replyMeNetModel.a0(this);
            this.c.setUniqueId(this.a.getUniqueId());
            ReplyMeCacheModel replyMeCacheModel = new ReplyMeCacheModel(this.a.getPageContext());
            this.d = replyMeCacheModel;
            replyMeCacheModel.Q(this);
            this.d.setUniqueId(this.a.getUniqueId());
            this.e = new la7();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c.S() || !y()) {
                return false;
            }
            this.b.c(this.f);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D(qa7 qa7Var, ra7 ra7Var, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, qa7Var, ra7Var, z)) == null) {
            if (qa7Var.a() != 4) {
                this.e.a().clear();
            }
            this.e.c(ra7Var);
            boolean z3 = true;
            if (ra7Var != null && ra7Var.a() != null && ra7Var.a().size() > 0) {
                this.f = ra7Var.a().get(ra7Var.a().size() - 1);
                z2 = this.e.b() == null || this.e.b().b() == 1;
                if (qa7Var.a() == 1) {
                    ky4.h0().f0(0);
                }
                if (qa7Var != null) {
                    qa7Var.d();
                }
            } else {
                this.f = null;
                z2 = false;
                z3 = false;
            }
            ky4.h0().p();
            ArrayList<ro> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.e.a.iterator();
            while (it.hasNext()) {
                wa7 wa7Var = new wa7();
                wa7Var.F(it.next());
                if (z) {
                    wa7Var.H(false);
                }
                arrayList.add(wa7Var);
            }
            this.a.W0(z2, arrayList);
            return z3;
        }
        return invokeLLZ.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.S() || !y()) {
                return false;
            }
            this.f = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
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
    public void e(WriteCacheRespMsg<List<ra7>> writeCacheRespMsg, WriteCacheMessage<ra7> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void g(ReadCacheRespMsg<List<ra7>> readCacheRespMsg, ReadCacheMessage<ra7> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                D(this.b, readCacheRespMsg.getData().get(0), true);
            }
            this.f = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage<ra7, ?> mvcSocketResponsedMessage, MvcSocketMessage<qa7, ra7> mvcSocketMessage, MvcNetMessage<qa7, ra7> mvcNetMessage) {
        ra7 ra7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                ra7Var = mvcSocketResponsedMessage.getData();
                r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r1 = mvcNetMessage.getRequestData();
                }
            } else {
                ky4.h0().f0(0);
                ra7Var = null;
            }
            if (r1 == null || ra7Var == null || !D(r1, ra7Var, false)) {
                if (mvcSocketResponsedMessage != null) {
                    this.mErrorCode = mvcSocketResponsedMessage.getError();
                    this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.a.onServerError(errorData);
                }
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ReplyMeNetModel replyMeNetModel = this.c;
            if (replyMeNetModel != null) {
                replyMeNetModel.a0(null);
            }
            ReplyMeCacheModel replyMeCacheModel = this.d;
            if (replyMeCacheModel != null) {
                replyMeCacheModel.Q(null);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<ra7> mvcHttpResponsedMessage, MvcHttpMessage<qa7, ra7> mvcHttpMessage, MvcNetMessage<qa7, ra7> mvcNetMessage) {
        ra7 ra7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                ra7Var = mvcHttpResponsedMessage.getData();
                r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r1 = mvcNetMessage.getRequestData();
                }
            } else {
                ky4.h0().f0(0);
                ra7Var = null;
            }
            if (r1 == null || ra7Var == null || !D(r1, ra7Var, false)) {
                if (mvcHttpResponsedMessage != null) {
                    this.mErrorCode = mvcHttpResponsedMessage.getError();
                    this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.a.onServerError(errorData);
                }
            }
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            la7 la7Var = this.e;
            if (la7Var != null && (arrayList = la7Var.a) != null) {
                arrayList.clear();
            }
            this.a.M0();
            this.a.W0(false, null);
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(int i) {
        la7 la7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (la7Var = this.e) == null || la7Var.a() == null || i >= this.e.a().size()) {
            return;
        }
        this.e.a().remove(i);
    }
}
