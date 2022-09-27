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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.i25;
import com.baidu.tieba.ie7;
import com.baidu.tieba.r9;
import com.baidu.tieba.rd7;
import com.baidu.tieba.sd7;
import com.baidu.tieba.w9;
import com.baidu.tieba.xd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMeModelController extends BdBaseModel implements CacheModel.c<sd7>, NetModel.k<rd7, sd7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMessageFragment a;
    public rd7 b;
    public AtMeNetModel c;
    public AtMeCacheModel d;
    public FeedData e;
    public xd7 f;
    public final CustomMessageListener g;

    /* loaded from: classes4.dex */
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2000994);
        this.a = atMessageFragment;
    }

    public void A(int i) {
        xd7 xd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (xd7Var = this.f) == null || xd7Var.a() == null || i >= this.f.a().size()) {
            return;
        }
        this.f.a().remove(i);
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (z()) {
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.N1();
                }
                this.d.P(this.b);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.b = new rd7();
            AtMeNetModel atMeNetModel = new AtMeNetModel((TbPageContext) w9.a(this.a.getPageContext().getPageActivity()), this.b);
            this.c = atMeNetModel;
            atMeNetModel.b0(this);
            AtMessageFragment atMessageFragment = this.a;
            if (atMessageFragment != null) {
                this.c.setUniqueId(atMessageFragment.getUniqueId());
            }
            this.c.registerListener(this.g);
            AtMessageFragment atMessageFragment2 = this.a;
            if (atMessageFragment2 != null) {
                AtMeCacheModel atMeCacheModel = new AtMeCacheModel((TbPageContext) w9.a(atMessageFragment2.getPageContext().getPageActivity()));
                this.d = atMeCacheModel;
                atMeCacheModel.R(this);
                this.d.setUniqueId(this.a.getUniqueId());
            }
            this.f = new xd7();
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c.T() || !z()) {
                return false;
            }
            this.b.c(this.e);
            this.c.setNeedCache(false);
            this.c.loadData();
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean E(rd7 rd7Var, sd7 sd7Var, Boolean bool) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, rd7Var, sd7Var, bool)) == null) {
            if (rd7Var.a() != 4) {
                this.f.a().clear();
            }
            this.f.c(sd7Var);
            boolean z2 = true;
            if (sd7Var != null && sd7Var.a() != null && sd7Var.a().size() > 0) {
                this.e = sd7Var.a().get(sd7Var.a().size() - 1);
                z = this.f.b() == null || this.f.b().b() == 1;
                if (rd7Var != null) {
                    rd7Var.d();
                }
            } else {
                this.e = null;
                z = false;
                z2 = false;
            }
            i25.h0().j();
            if (!TbadkCoreApplication.isLogin()) {
                this.f.a().clear();
            }
            ArrayList<Cdo> arrayList = new ArrayList<>();
            Iterator<FeedData> it = this.f.a.iterator();
            while (it.hasNext()) {
                ie7 ie7Var = new ie7();
                ie7Var.H(it.next());
                if (bool.booleanValue()) {
                    ie7Var.J(false);
                }
                arrayList.add(ie7Var);
            }
            this.a.M1(z, arrayList);
            return z2;
        }
        return invokeLLL.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c.T() || !z()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void f(WriteCacheRespMsg<List<sd7>> writeCacheRespMsg, WriteCacheMessage<sd7> writeCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, writeCacheRespMsg, writeCacheMessage) == null) {
        }
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel.c
    public void h(ReadCacheRespMsg<List<sd7>> readCacheRespMsg, ReadCacheMessage<sd7> readCacheMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, readCacheRespMsg, readCacheMessage) == null) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null && readCacheRespMsg.getData().size() > 0) {
                E(this.b, readCacheRespMsg.getData().get(0), Boolean.TRUE);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage<sd7, ?> mvcSocketResponsedMessage, MvcSocketMessage<rd7, sd7> mvcSocketMessage, MvcNetMessage<rd7, sd7> mvcNetMessage) {
        sd7 sd7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            if (mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                sd7Var = mvcSocketResponsedMessage.getData();
                r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                i25.h0().Z(0);
                sd7Var = null;
            }
            if (r0 == null || sd7Var == null || !E(r0, sd7Var, Boolean.FALSE)) {
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
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            AtMeNetModel atMeNetModel = this.c;
            if (atMeNetModel != null) {
                atMeNetModel.b0(null);
            }
            AtMeCacheModel atMeCacheModel = this.d;
            if (atMeCacheModel != null) {
                atMeCacheModel.R(null);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage<sd7> mvcHttpResponsedMessage, MvcHttpMessage<rd7, sd7> mvcHttpMessage, MvcNetMessage<rd7, sd7> mvcNetMessage) {
        sd7 sd7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            if (mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                sd7Var = mvcHttpResponsedMessage.getData();
                r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r0 = mvcNetMessage.getRequestData();
                }
            } else {
                i25.h0().Z(0);
                sd7Var = null;
            }
            if (r0 == null || sd7Var == null || !E(r0, sd7Var, Boolean.FALSE)) {
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
    }

    public boolean z() {
        InterceptResult invokeV;
        ArrayList<FeedData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                return true;
            }
            xd7 xd7Var = this.f;
            if (xd7Var != null && (arrayList = xd7Var.a) != null) {
                arrayList.clear();
                AtMessageFragment atMessageFragment = this.a;
                if (atMessageFragment != null) {
                    atMessageFragment.C1();
                    this.a.M1(false, null);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
