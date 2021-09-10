package com.baidu.wallet.paysdk.precashier.beans;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BeanManager;
/* loaded from: classes8.dex */
public class PrecashierBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_PRECASHIER_GET_DEFAULT_PAY_TYPE = 1;
    public static final int BEAN_ID_PRECASHIER_MODIFY_PAY_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.precashier.beans.PrecashierBeanFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PrecashierBeanFactory f62638a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-26926870, "Lcom/baidu/wallet/paysdk/precashier/beans/PrecashierBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-26926870, "Lcom/baidu/wallet/paysdk/precashier/beans/PrecashierBeanFactory$a;");
                    return;
                }
            }
            f62638a = new PrecashierBeanFactory(null);
        }
    }

    public /* synthetic */ PrecashierBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static PrecashierBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62638a : (PrecashierBeanFactory) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanFactory
    public ApollonBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, str)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (i2 == 1) {
                return new PrecashierDefaultPayTypeBean(applicationContext);
            }
            PrecashierModifyPayTypeBean precashierModifyPayTypeBean = i2 == 2 ? new PrecashierModifyPayTypeBean(applicationContext) : null;
            if (precashierModifyPayTypeBean != null) {
                BeanManager.getInstance().addBean(str, precashierModifyPayTypeBean);
            }
            return precashierModifyPayTypeBean;
        }
        return (ApollonBean) invokeLIL.objValue;
    }

    public PrecashierBeanFactory() {
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
}
