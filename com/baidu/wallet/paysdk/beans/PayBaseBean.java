package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class PayBaseBean<T> extends BaseBean<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f25826a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayBaseBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25826a = 0L;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f25826a;
            try {
                String path = new URL(getUrl()).getPath();
                List<String> collectData = StatHelper.collectData(path, i2 + "");
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(currentTimeMillis));
                StatisticManager.onEventWithValues(PayStatServiceEvent.CALL_INTERFACE, collectData, hashMap);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
            this.f25826a = System.currentTimeMillis();
            super.execBean(cls, cls2);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            a(-2);
            super.handleCommonErrors(exc);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(-8);
            super.handleNetworkFailureError();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<T1> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.apollon.beans.ApollonBean
    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != null && restResponseEntity.getBody() != null) {
                a(restResponseEntity.getBody().ret);
            } else {
                a(-4);
            }
            super.handleResponse(cls, cls2, restResponseEntity);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayBaseBean(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25826a = 0L;
    }
}
