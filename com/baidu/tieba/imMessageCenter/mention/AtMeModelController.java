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
import com.repackage.f9;
import com.repackage.fa7;
import com.repackage.ga7;
import com.repackage.ky4;
import com.repackage.la7;
import com.repackage.ro;
import com.repackage.wa7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class AtMeModelController extends BdBaseModel implements CacheModel.c<ga7>, NetModel.k<fa7, ga7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageFragment a;
    public fa7 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public FeedData e;
    public la7 f;
    public final CustomMessageListener g;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage) || customResponsedMessage.hasError()) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMeModelController(AtMessageFragment atMessageFragment) {
        super(atMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageFragment};
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
        this.g = new a(this, 2000994);
        this.a = atMessageFragment;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (y()) {
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.W0();
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
            this.b = new fa7();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) f9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.a0(this);
            AtMessageFragment atMessageFragment = this.a;
            if (atMessageFragment != null) {
                this.c.setUniqueId(atMessageFragment.getUniqueId());
            }
            this.c.registerListener(this.g);
            AtMessageFragment atMessageFragment2 = this.a;
            if (atMessageFragment2 != null) {
                AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) f9.a(atMessageFragment2.getPageContext().getPageActivity()));
                this.d = atMeCacheModel;
                atMeCacheModel.Q(this);
                this.d.setUniqueId(this.a.getUniqueId());
            }
            this.f = new la7();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c.S() || !y()) {
                return false;
            }
            this.b.c(this.e);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean D(fa7 fa7Var, ga7 ga7Var, Boolean bool) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fa7Var, ga7Var, bool)) == null) {
            if (fa7Var.a() != 4) {
                this.f.a().clear();
            }
            this.f.c(ga7Var);
            boolean z2 = true;
            if (ga7Var != null && ga7Var.a() != null && ga7Var.a().size() > 0) {
                this.e = ga7Var.a().get(ga7Var.a().size() - 1);
                z = this.f.b() == null || this.f.b().b() == 1;
                if (fa7Var != null) {
                    fa7Var.d();
                }
            } else {
                this.e = null;
                z = false;
                z2 = false;
            }
            ky4.h0().k();
            if (!TbadkCoreApplication.isLogin()) {
                this.f.a().clear();
            }
            ArrayList<ro> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f.a.iterator();
            while (it.hasNext()) {
                wa7 wa7Var = new wa7();
                wa7Var.F(it.next());
                if (bool.booleanValue()) {
                    wa7Var.H(false);
                }
                arrayList.add(wa7Var);
            }
            this.a.V0(z, arrayList);
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c.S() || !y()) {
                return false;
            }
            this.e = null;
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
    public void e(WriteCacheRespMsg<List<ga7>> writeCacheRespMsg, WriteCacheMessage<ga7> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void g(ReadCacheRespMsg<List<ga7>> readCacheRespMsg, ReadCacheMessage<ga7> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                D(this.b, readCacheRespMsg.getData().get(0), Boolean.TRUE);
            }
            this.e = null;
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
    public void m(MvcSocketResponsedMessage<ga7, ?> mvcSocketResponsedMessage, MvcSocketMessage<fa7, ga7> mvcSocketMessage, MvcNetMessage<fa7, ga7> mvcNetMessage) {
        ga7 ga7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                ga7Var = mvcSocketResponsedMessage.getData();
                r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                ky4.h0().a0(0);
                ga7Var = null;
            }
            if (r0 == null || ga7Var == null || !D(r0, ga7Var, Boolean.FALSE)) {
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
            AtMeNetModel atMeNetModel = this.c;
            if (atMeNetModel != null) {
                atMeNetModel.a0(null);
            }
            AtMeCacheModel atMeCacheModel = this.d;
            if (atMeCacheModel != null) {
                atMeCacheModel.Q(null);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage<ga7> mvcHttpResponsedMessage, MvcHttpMessage<fa7, ga7> mvcHttpMessage, MvcNetMessage<fa7, ga7> mvcNetMessage) {
        ga7 ga7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                ga7Var = mvcHttpResponsedMessage.getData();
                r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                ky4.h0().a0(0);
                ga7Var = null;
            }
            if (r0 == null || ga7Var == null || !D(r0, ga7Var, Boolean.FALSE)) {
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
            la7 la7Var = this.f;
            if (la7Var != null && (arrayList = la7Var.a) != null) {
                arrayList.clear();
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.L0();
                    this.a.V0(false, null);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z(int i) {
        la7 la7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (la7Var = this.f) == null || la7Var.a() == null || i >= this.f.a().size()) {
            return;
        }
        this.f.a().remove(i);
    }
}
