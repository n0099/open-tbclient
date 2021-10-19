package com.baidu.wallet.fastpay.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes8.dex */
public final class FastPayBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_BIND_INFO = 45316;
    public static final int BEAN_ID_CHARGE_RESULT_BANNER = 45317;
    public static final int BEAN_ID_GET_ORDER = 45314;
    public static final int BEAN_ID_PROMOTION_INFO = 45315;
    public static final int BEAN_ID_QUERY_LOCATION = 45313;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.fastpay.beans.FastPayBeanFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static FastPayBeanFactory f61207a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039269049, "Lcom/baidu/wallet/fastpay/beans/FastPayBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2039269049, "Lcom/baidu/wallet/fastpay/beans/FastPayBeanFactory$a;");
                    return;
                }
            }
            f61207a = new FastPayBeanFactory(null);
        }
    }

    public /* synthetic */ FastPayBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FastPayBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f61207a : (FastPayBeanFactory) invokeV.objValue;
    }

    public FastPayBeanFactory() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.beans.IBeanFactory
    public BaseBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        BaseBean<?> eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            switch (i2) {
                case BEAN_ID_QUERY_LOCATION /* 45313 */:
                    eVar = new e(context);
                    break;
                case BEAN_ID_GET_ORDER /* 45314 */:
                    eVar = new c(context);
                    break;
                case BEAN_ID_PROMOTION_INFO /* 45315 */:
                    eVar = new d(context);
                    break;
                case BEAN_ID_BIND_INFO /* 45316 */:
                    eVar = new com.baidu.wallet.fastpay.beans.a(context);
                    break;
                case BEAN_ID_CHARGE_RESULT_BANNER /* 45317 */:
                    eVar = new b(context);
                    break;
                default:
                    eVar = null;
                    break;
            }
            if (eVar != null) {
                BeanManager.getInstance().addBean(str, eVar);
            }
            return eVar;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
