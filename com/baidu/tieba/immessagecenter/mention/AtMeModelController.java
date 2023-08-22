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
import com.baidu.tieba.bn;
import com.baidu.tieba.es8;
import com.baidu.tieba.fs8;
import com.baidu.tieba.ie5;
import com.baidu.tieba.ks8;
import com.baidu.tieba.l9;
import com.baidu.tieba.vs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class AtMeModelController extends BdBaseModel implements CacheModel.CacheModelCallback<fs8>, NetModel.k<es8, fs8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageFragment a;
    public es8 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public FeedData e;
    public ks8 f;
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
    public void onCacheDataWrite(WriteCacheRespMsg<List<fs8>> writeCacheRespMsg, WriteCacheMessage<fs8> writeCacheMessage) {
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
    public void G(MvcHttpResponsedMessage<fs8> mvcHttpResponsedMessage, MvcHttpMessage<es8, fs8> mvcHttpMessage, MvcNetMessage<es8, fs8> mvcNetMessage) {
        fs8 fs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            es8 es8Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                fs8Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    es8Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    es8Var = mvcNetMessage.getRequestData();
                }
            } else {
                ie5.p0().g0(0);
                fs8Var = null;
            }
            if (es8Var != null && fs8Var != null && S(es8Var, fs8Var, Boolean.FALSE)) {
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
    public void v(MvcSocketResponsedMessage<fs8, ?> mvcSocketResponsedMessage, MvcSocketMessage<es8, fs8> mvcSocketMessage, MvcNetMessage<es8, fs8> mvcNetMessage) {
        fs8 fs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            es8 es8Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                fs8Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    es8Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    es8Var = mvcNetMessage.getRequestData();
                }
            } else {
                ie5.p0().g0(0);
                fs8Var = null;
            }
            if (es8Var != null && fs8Var != null && S(es8Var, fs8Var, Boolean.FALSE)) {
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
                ks8 ks8Var = this.f;
                if (ks8Var != null && (arrayList = ks8Var.a) != null) {
                    arrayList.clear();
                    AtMessageFragment atMessageFragment = this.a;
                    if (atMessageFragment != null) {
                        atMessageFragment.f2();
                        this.a.p2(false, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.h0() || !N()) {
                return false;
            }
            this.b.c(this.e);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.c.h0() && N()) {
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

    public void O(int i) {
        ks8 ks8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (ks8Var = this.f) != null && ks8Var.a() != null && i < this.f.a().size()) {
            this.f.a().remove(i);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (N()) {
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.q2();
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
                atMeNetModel.p0(null);
            }
            AtMeCacheModel atMeCacheModel = this.d;
            if (atMeCacheModel != null) {
                atMeCacheModel.setCallback(null);
            }
        }
    }

    public void Q(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.b = new es8();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) l9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.p0(this);
            AtMessageFragment atMessageFragment = this.a;
            if (atMessageFragment != null) {
                this.c.setUniqueId(atMessageFragment.getUniqueId());
            }
            this.c.registerListener(this.g);
            AtMessageFragment atMessageFragment2 = this.a;
            if (atMessageFragment2 != null) {
                AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) l9.a(atMessageFragment2.getPageContext().getPageActivity()));
                this.d = atMeCacheModel;
                atMeCacheModel.setCallback(this);
                this.d.setUniqueId(this.a.getUniqueId());
            }
            this.f = new ks8();
        }
    }

    public boolean S(es8 es8Var, fs8 fs8Var, Boolean bool) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, es8Var, fs8Var, bool)) == null) {
            if (es8Var.a() != 4) {
                this.f.a().clear();
            }
            this.f.c(fs8Var);
            boolean z2 = true;
            if (fs8Var != null && fs8Var.a() != null && fs8Var.a().size() > 0) {
                this.e = fs8Var.a().get(fs8Var.a().size() - 1);
                if (this.f.b() != null && this.f.b().b() != 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (es8Var != null) {
                    es8Var.d();
                }
            } else {
                this.e = null;
                z = false;
                z2 = false;
            }
            ie5.p0().j();
            if (!TbadkCoreApplication.isLogin()) {
                this.f.a().clear();
            }
            ArrayList<bn> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f.a.iterator();
            while (it.hasNext()) {
                vs8 vs8Var = new vs8();
                vs8Var.C(it.next());
                if (bool.booleanValue()) {
                    vs8Var.E(false);
                }
                arrayList.add(vs8Var);
            }
            this.a.p2(z, arrayList);
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
    public void onCacheDataGet(ReadCacheRespMsg<List<fs8>> readCacheRespMsg, ReadCacheMessage<fs8> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                S(this.b, readCacheRespMsg.getData().get(0), Boolean.TRUE);
            }
            this.e = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
