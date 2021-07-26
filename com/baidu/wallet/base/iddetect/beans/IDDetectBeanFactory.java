package com.baidu.wallet.base.iddetect.beans;

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
/* loaded from: classes5.dex */
public final class IDDetectBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_ID_DETECT = 57345;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.base.iddetect.beans.IDDetectBeanFactory$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static IDDetectBeanFactory f24229a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575206807, "Lcom/baidu/wallet/base/iddetect/beans/IDDetectBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1575206807, "Lcom/baidu/wallet/base/iddetect/beans/IDDetectBeanFactory$a;");
                    return;
                }
            }
            f24229a = new IDDetectBeanFactory(null);
        }
    }

    public /* synthetic */ IDDetectBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static IDDetectBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f24229a : (IDDetectBeanFactory) invokeV.objValue;
    }

    public IDDetectBeanFactory() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            com.baidu.wallet.base.iddetect.beans.a aVar = i2 != 57345 ? null : new com.baidu.wallet.base.iddetect.beans.a(context);
            if (aVar != null) {
                BeanManager.getInstance().addBean(str, aVar);
            }
            return aVar;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
