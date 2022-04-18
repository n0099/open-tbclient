package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import com.repackage.ea7;
import com.repackage.f9;
import com.repackage.u65;
import com.repackage.wx4;
import com.repackage.y97;
import com.repackage.z97;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AtMeModelController extends BdBaseModel<AtMessageActivity> implements CacheModel.c<z97>, NetModel.k<y97, z97> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageActivity a;
    public y97 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public u65 e;
    public FeedData f;
    public ea7 g;
    public final CustomMessageListener h;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMeModelController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AtMeModelController atMeModelController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMeModelController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atMeModelController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.a.a.dismissPullRefresh();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMeModelController(AtMessageActivity atMessageActivity) {
        super(f9.a(atMessageActivity.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageActivity};
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
        this.h = new a(this, 2000994);
        this.a = atMessageActivity;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (z()) {
                AtMessageActivity atMessageActivity = this.a;
                if (atMessageActivity != null) {
                    atMessageActivity.showPullRefresh();
                }
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
            this.b = new y97();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) f9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.a0(this);
            AtMessageActivity atMessageActivity = this.a;
            if (atMessageActivity != null) {
                this.c.setUniqueId(atMessageActivity.getUniqueId());
            }
            this.c.registerListener(this.h);
            AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) f9.a(this.a.getPageContext().getPageActivity()));
            this.d = atMeCacheModel;
            atMeCacheModel.Q(this);
            AtMessageActivity atMessageActivity2 = this.a;
            if (atMessageActivity2 != null) {
                this.d.setUniqueId(atMessageActivity2.getUniqueId());
            }
            this.g = new ea7();
            this.e = new u65();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c.S() && this.e.a() && z()) {
                this.e.f(true);
                this.e.h(true);
                this.b.c(this.f);
                this.c.setNeedCache(false);
                this.c.loadData();
                this.a.onViewStateChanged(this.e);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean D(y97 y97Var, z97 z97Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, y97Var, z97Var)) == null) {
            this.a.hideNetRefreshView();
            if (y97Var.a() != 4) {
                this.g.a().clear();
            }
            this.g.c(z97Var);
            if (z97Var != null && z97Var.a() != null && z97Var.a().size() > 0) {
                this.f = z97Var.a().get(z97Var.a().size() - 1);
                if (this.g.b() != null) {
                    this.e.e(this.g.b().b() == 1);
                } else {
                    this.e.e(true);
                }
                if (y97Var != null) {
                    y97Var.d();
                }
                this.e.h(true);
            } else {
                this.f = null;
                this.e.e(false);
                this.e.h(false);
            }
            this.e.f(false);
            this.e.g(false);
            wx4.g0().k();
            if (!TbadkCoreApplication.isLogin()) {
                this.g.a().clear();
            } else {
                this.a.onViewStateChanged(this.e);
            }
            this.a.onViewDataChanged(this.g);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.S() || !z()) {
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
    public void e(WriteCacheRespMsg<List<z97>> writeCacheRespMsg, WriteCacheMessage<z97> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void g(ReadCacheRespMsg<List<z97>> readCacheRespMsg, ReadCacheMessage<z97> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                D(this.b, readCacheRespMsg.getData().get(0));
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
    public void m(MvcSocketResponsedMessage<z97, ?> mvcSocketResponsedMessage, MvcSocketMessage<y97, z97> mvcSocketMessage, MvcNetMessage<y97, z97> mvcNetMessage) {
        z97 z97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.a.dismissPullRefresh();
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                z97Var = mvcSocketResponsedMessage.getData();
                r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                wx4.g0().Z(0);
                z97Var = null;
            }
            if (r0 == null || z97Var == null || !D(r0, z97Var)) {
                if (mvcSocketResponsedMessage != null) {
                    this.mErrorCode = mvcSocketResponsedMessage.getError();
                    this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.a.onServerError(errorData);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<z97> mvcHttpResponsedMessage, MvcHttpMessage<y97, z97> mvcHttpMessage, MvcNetMessage<y97, z97> mvcNetMessage) {
        z97 z97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.a.dismissPullRefresh();
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                z97Var = mvcHttpResponsedMessage.getData();
                r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                wx4.g0().Z(0);
                z97Var = null;
            }
            if (r0 == null || z97Var == null || !D(r0, z97Var)) {
                if (mvcHttpResponsedMessage != null) {
                    this.mErrorCode = mvcHttpResponsedMessage.getError();
                    this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.a.onServerError(errorData);
            }
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            ea7 ea7Var = this.g;
            if (ea7Var != null && (arrayList = ea7Var.a) != null) {
                arrayList.clear();
            }
            this.a.dismissPullRefresh();
            this.a.onViewDataChanged(this.g);
            return false;
        }
        return invokeV.booleanValue;
    }
}
