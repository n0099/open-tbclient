package com.baidu.tieba.immessagecenter.mention;

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
import com.baidu.tieba.br8;
import com.baidu.tieba.kq8;
import com.baidu.tieba.l9;
import com.baidu.tieba.lq8;
import com.baidu.tieba.nf5;
import com.baidu.tieba.qq8;
import com.baidu.tieba.r9;
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
public class AtMeModelController extends BdBaseModel implements CacheModel.c<lq8>, NetModel.k<kq8, lq8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageFragment a;
    public kq8 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public FeedData e;
    public qq8 f;
    public final CustomMessageListener g;

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
    public void m(WriteCacheRespMsg<List<lq8>> writeCacheRespMsg, WriteCacheMessage<lq8> writeCacheMessage) {
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
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2000994);
        this.a = atMessageFragment;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void A(MvcSocketResponsedMessage<lq8, ?> mvcSocketResponsedMessage, MvcSocketMessage<kq8, lq8> mvcSocketMessage, MvcNetMessage<kq8, lq8> mvcNetMessage) {
        lq8 lq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            kq8 kq8Var = null;
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                lq8Var = mvcSocketResponsedMessage.getData();
                if (mvcSocketMessage != null) {
                    kq8Var = mvcSocketMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    kq8Var = mvcNetMessage.getRequestData();
                }
            } else {
                nf5.p0().g0(0);
                lq8Var = null;
            }
            if (kq8Var != null && lq8Var != null && a0(kq8Var, lq8Var, Boolean.FALSE)) {
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
    public void M(MvcHttpResponsedMessage<lq8> mvcHttpResponsedMessage, MvcHttpMessage<kq8, lq8> mvcHttpMessage, MvcNetMessage<kq8, lq8> mvcNetMessage) {
        lq8 lq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            kq8 kq8Var = null;
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                lq8Var = mvcHttpResponsedMessage.getData();
                if (mvcHttpMessage != null) {
                    kq8Var = mvcHttpMessage.getRequestData();
                }
                if (mvcNetMessage != null) {
                    kq8Var = mvcNetMessage.getRequestData();
                }
            } else {
                nf5.p0().g0(0);
                lq8Var = null;
            }
            if (kq8Var != null && lq8Var != null && a0(kq8Var, lq8Var, Boolean.FALSE)) {
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
                qq8 qq8Var = this.f;
                if (qq8Var != null && (arrayList = qq8Var.a) != null) {
                    arrayList.clear();
                    AtMessageFragment atMessageFragment = this.a;
                    if (atMessageFragment != null) {
                        atMessageFragment.S1();
                        this.a.c2(false, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c.p0() || !V()) {
                return false;
            }
            this.b.c(this.e);
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

    public void W(int i) {
        qq8 qq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (qq8Var = this.f) != null && qq8Var.a() != null && i < this.f.a().size()) {
            this.f.a().remove(i);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (V()) {
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.d2();
                }
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
            AtMeNetModel atMeNetModel = this.c;
            if (atMeNetModel != null) {
                atMeNetModel.x0(null);
            }
            AtMeCacheModel atMeCacheModel = this.d;
            if (atMeCacheModel != null) {
                atMeCacheModel.o0(null);
            }
        }
    }

    public void Y(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.b = new kq8();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) r9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.x0(this);
            AtMessageFragment atMessageFragment = this.a;
            if (atMessageFragment != null) {
                this.c.setUniqueId(atMessageFragment.getUniqueId());
            }
            this.c.registerListener(this.g);
            AtMessageFragment atMessageFragment2 = this.a;
            if (atMessageFragment2 != null) {
                AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) r9.a(atMessageFragment2.getPageContext().getPageActivity()));
                this.d = atMeCacheModel;
                atMeCacheModel.o0(this);
                this.d.setUniqueId(this.a.getUniqueId());
            }
            this.f = new qq8();
        }
    }

    public boolean a0(kq8 kq8Var, lq8 lq8Var, Boolean bool) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, kq8Var, lq8Var, bool)) == null) {
            if (kq8Var.a() != 4) {
                this.f.a().clear();
            }
            this.f.c(lq8Var);
            boolean z2 = true;
            if (lq8Var != null && lq8Var.a() != null && lq8Var.a().size() > 0) {
                this.e = lq8Var.a().get(lq8Var.a().size() - 1);
                if (this.f.b() != null && this.f.b().b() != 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (kq8Var != null) {
                    kq8Var.d();
                }
            } else {
                this.e = null;
                z = false;
                z2 = false;
            }
            nf5.p0().j();
            if (!TbadkCoreApplication.isLogin()) {
                this.f.a().clear();
            }
            ArrayList<yn> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f.a.iterator();
            while (it.hasNext()) {
                br8 br8Var = new br8();
                br8Var.C(it.next());
                if (bool.booleanValue()) {
                    br8Var.E(false);
                }
                arrayList.add(br8Var);
            }
            this.a.c2(z, arrayList);
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void r(ReadCacheRespMsg<List<lq8>> readCacheRespMsg, ReadCacheMessage<lq8> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                a0(this.b, readCacheRespMsg.getData().get(0), Boolean.TRUE);
            }
            this.e = null;
            this.b.b();
            this.c.setNeedCache(true);
            this.c.loadData();
        }
    }
}
