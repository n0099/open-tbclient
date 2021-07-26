package com.baidu.wallet.paysdk.fingerprint.bean;

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
public final class FingerprintBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_SYS_FINGERPRINT_CLOSE = 773;
    public static final int BEAN_ID_SYS_FINGERPRINT_OPEN = 772;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static FingerprintBeanFactory f26272a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-848611191, "Lcom/baidu/wallet/paysdk/fingerprint/bean/FingerprintBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-848611191, "Lcom/baidu/wallet/paysdk/fingerprint/bean/FingerprintBeanFactory$a;");
                    return;
                }
            }
            f26272a = new FingerprintBeanFactory(null);
        }
    }

    public /* synthetic */ FingerprintBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FingerprintBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f26272a : (FingerprintBeanFactory) invokeV.objValue;
    }

    public FingerprintBeanFactory() {
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
    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    @Override // com.baidu.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        BaseBean<?> bVar;
        BaseBean<?> baseBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            if (i2 == 772) {
                bVar = new b(context);
            } else if (i2 != 773) {
                baseBean = null;
                if (baseBean != null) {
                    BeanManager.getInstance().addBean(str, baseBean);
                }
                return baseBean;
            } else {
                bVar = new com.baidu.wallet.paysdk.fingerprint.bean.a(context);
            }
            baseBean = bVar;
            if (baseBean != null) {
            }
            return baseBean;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
