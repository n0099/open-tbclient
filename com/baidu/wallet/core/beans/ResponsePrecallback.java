package com.baidu.wallet.core.beans;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes6.dex */
public abstract class ResponsePrecallback implements IBeanResponseCallback, NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ResponseType {
        public static final /* synthetic */ ResponseType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ResponseType Fail;
        public static final ResponseType OkJson;
        public static final ResponseType OkString;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-299470577, "Lcom/baidu/wallet/core/beans/ResponsePrecallback$ResponseType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-299470577, "Lcom/baidu/wallet/core/beans/ResponsePrecallback$ResponseType;");
                    return;
                }
            }
            OkJson = new ResponseType("OkJson", 0);
            OkString = new ResponseType("OkString", 1);
            ResponseType responseType = new ResponseType(ActLog.TYPE_FAIL, 2);
            Fail = responseType;
            $VALUES = new ResponseType[]{OkJson, OkString, responseType};
        }

        public ResponseType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ResponseType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ResponseType) Enum.valueOf(ResponseType.class, str) : (ResponseType) invokeL.objValue;
        }

        public static ResponseType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ResponseType[]) $VALUES.clone() : (ResponseType[]) invokeV.objValue;
        }
    }

    public ResponsePrecallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getNotifyKeyName(Class cls, ResponseType responseType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, responseType)) == null) {
            if (cls != null) {
                if (responseType == null) {
                    responseType = ResponseType.OkJson;
                }
                return cls.getSimpleName() + responseType.name();
            }
            throw new NullPointerException("callbackClz null");
        }
        return (String) invokeLL.objValue;
    }

    public abstract void handleResponse(int i2, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            removeRequest();
            BeanErrorContent beanErrorContent = new BeanErrorContent(i2, i3, str, null);
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(eventBus, getNotifyKeyName(getClass(), ResponseType.Fail), beanErrorContent));
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            if (obj != null) {
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.post(new EventBus.Event(eventBus, getNotifyKeyName(getClass(), ResponseType.OkJson), obj));
            } else if (TextUtils.isEmpty(str)) {
                EventBus eventBus2 = EventBus.getInstance();
                eventBus2.getClass();
                eventBus2.post(new EventBus.Event(eventBus2, getNotifyKeyName(getClass(), ResponseType.OkString), str));
            }
            removeRequest();
            handleResponse(i2, obj, str);
        }
    }

    public abstract void removeRequest();
}
