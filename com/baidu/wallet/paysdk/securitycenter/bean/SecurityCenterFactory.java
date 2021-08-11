package com.baidu.wallet.paysdk.securitycenter.bean;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanFactory;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.OtherBean;
/* loaded from: classes8.dex */
public final class SecurityCenterFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_PAY_SET_LIST = 1;
    public static final int BEAN_ID_SECURITY_CENTER = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.securitycenter.bean.SecurityCenterFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static SecurityCenterFactory f62320a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1091207453, "Lcom/baidu/wallet/paysdk/securitycenter/bean/SecurityCenterFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1091207453, "Lcom/baidu/wallet/paysdk/securitycenter/bean/SecurityCenterFactory$a;");
                    return;
                }
            }
            f62320a = new SecurityCenterFactory(null);
        }
    }

    public /* synthetic */ SecurityCenterFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static SecurityCenterFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62320a : (SecurityCenterFactory) invokeV.objValue;
    }

    public SecurityCenterFactory() {
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
    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    @Override // com.dxmpay.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OtherBean<?> getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        OtherBean<?> securityCenterBean;
        OtherBean<?> otherBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            Context applicationContext = context.getApplicationContext();
            if (i2 == 0) {
                securityCenterBean = new SecurityCenterBean(applicationContext);
            } else if (i2 != 1) {
                otherBean = null;
                if (otherBean != null) {
                    BeanManager.getInstance().addBean(str, otherBean);
                }
                return otherBean;
            } else {
                securityCenterBean = new PaySetListBean(applicationContext);
            }
            otherBean = securityCenterBean;
            if (otherBean != null) {
            }
            return otherBean;
        }
        return (OtherBean) invokeLIL.objValue;
    }
}
