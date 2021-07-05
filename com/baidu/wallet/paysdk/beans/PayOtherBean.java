package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestResponseEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.beans.OtherBean;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class PayOtherBean<T> extends OtherBean<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f25832a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayOtherBean(Context context) {
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
        this.f25832a = 0L;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f25832a;
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
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(String.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.OtherBean, com.baidu.apollon.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2) == null) {
            super.executeAndHandleResponse(cls, cls2);
            int i2 = this.mRetCode;
            if (i2 == -1) {
                i2 = -2;
            }
            a(i2);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
            a(-2);
            super.handleCommonErrors(exc);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean, com.baidu.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a(-8);
            super.handleNetworkFailureError();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<T1> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.wallet.core.beans.OtherBean, com.baidu.apollon.beans.ApollonBean
    public <T1, E> void handleResponse(Class<T1> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != null && restResponseEntity.getBody() != null) {
                a(restResponseEntity.getBody().ret);
            } else {
                a(-4);
            }
            super.handleResponse(cls, cls2, restResponseEntity);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2) == null) {
            this.f25832a = System.currentTimeMillis();
            super.execBean(cls, cls2);
        }
    }
}
