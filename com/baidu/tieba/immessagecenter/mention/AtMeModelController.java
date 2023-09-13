package com.baidu.tieba.immessagecenter.mention;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
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
import com.baidu.tieba.cn;
import com.baidu.tieba.gt8;
import com.baidu.tieba.ht8;
import com.baidu.tieba.m9;
import com.baidu.tieba.mt8;
import com.baidu.tieba.re5;
import com.baidu.tieba.xt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class AtMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<ht8>, NetModel.k<gt8, ht8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageFragment a;
    public gt8 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public FeedData e;
    public mt8 f;
    public final CustomMessageListener g;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataWrite(WriteCacheRespMsg<List<ht8>> writeCacheRespMsg, WriteCacheMessage<ht8> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    /* loaded from: classes6.dex */
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2000994);
        this.a = atMessageFragment;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void G(MvcHttpResponsedMessage<ht8> mvcHttpResponsedMessage, MvcHttpMessage<gt8, ht8> mvcHttpMessage, MvcNetMessage<gt8, ht8> mvcNetMessage) {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            gt8 gt8Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                ht8Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    gt8Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    gt8Var = mvcNetMessage.getRequestData();
                }
            } else {
                re5.p0().g0(0);
                ht8Var = null;
            }
            if (gt8Var != null && ht8Var != null && R(gt8Var, ht8Var, Boolean.FALSE)) {
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
    public void v(MvcSocketResponsedMessage<ht8, ?> mvcSocketResponsedMessage, MvcSocketMessage<gt8, ht8> mvcSocketMessage, MvcNetMessage<gt8, ht8> mvcNetMessage) {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            gt8 gt8Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                ht8Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    gt8Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    gt8Var = mvcNetMessage.getRequestData();
                }
            } else {
                re5.p0().g0(0);
                ht8Var = null;
            }
            if (gt8Var != null && ht8Var != null && R(gt8Var, ht8Var, Boolean.FALSE)) {
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

    public boolean M() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                mt8 mt8Var = this.f;
                if (mt8Var != null && (arrayList = mt8Var.a) != null) {
                    arrayList.clear();
                    AtMessageFragment atMessageFragment = this.a;
                    if (atMessageFragment != null) {
                        atMessageFragment.h2();
                        this.a.r2(false, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.g0() || !M()) {
                return false;
            }
            this.b.c(this.e);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.c.g0() && M()) {
                this.e = null;
                this.b.b();
                this.c.setNeedCache(true);
                this.c.loadData();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void N(int i) {
        mt8 mt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (mt8Var = this.f) != null && mt8Var.a() != null && i < this.f.a().size()) {
            this.f.a().remove(i);
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (M()) {
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.s2();
                }
                this.d.loadSingleCache(this.b);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AtMeNetModel atMeNetModel = this.c;
            if (atMeNetModel != null) {
                atMeNetModel.o0(null);
            }
            AtMeCacheModel atMeCacheModel = this.d;
            if (atMeCacheModel != null) {
                atMeCacheModel.setCallback(null);
            }
        }
    }

    public void P(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b = new gt8();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) m9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.o0(this);
            AtMessageFragment atMessageFragment = this.a;
            if (atMessageFragment != null) {
                this.c.setUniqueId(atMessageFragment.getUniqueId());
            }
            this.c.registerListener(this.g);
            AtMessageFragment atMessageFragment2 = this.a;
            if (atMessageFragment2 != null) {
                AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) m9.a(atMessageFragment2.getPageContext().getPageActivity()));
                this.d = atMeCacheModel;
                atMeCacheModel.setCallback(this);
                this.d.setUniqueId(this.a.getUniqueId());
            }
            this.f = new mt8();
        }
    }

    public boolean R(gt8 gt8Var, ht8 ht8Var, Boolean bool) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, gt8Var, ht8Var, bool)) == null) {
            if (gt8Var.a() != 4) {
                this.f.a().clear();
            }
            this.f.c(ht8Var);
            boolean z2 = true;
            if (ht8Var != null && ht8Var.a() != null && ht8Var.a().size() > 0) {
                this.e = ht8Var.a().get(ht8Var.a().size() - 1);
                if (this.f.b() != null && this.f.b().b() != 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (gt8Var != null) {
                    gt8Var.d();
                }
            } else {
                this.e = null;
                z = false;
                z2 = false;
            }
            re5.p0().j();
            if (!TbadkCoreApplication.isLogin()) {
                this.f.a().clear();
            }
            ArrayList<cn> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f.a.iterator();
            while (it.hasNext()) {
                xt8 xt8Var = new xt8();
                xt8Var.C(it.next());
                if (bool.booleanValue()) {
                    xt8Var.E(false);
                }
                arrayList.add(xt8Var);
            }
            this.a.r2(z, arrayList);
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<ht8>> readCacheRespMsg, ReadCacheMessage<ht8> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                R(this.b, readCacheRespMsg.getData().get(0), Boolean.TRUE);
            }
            this.e = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
