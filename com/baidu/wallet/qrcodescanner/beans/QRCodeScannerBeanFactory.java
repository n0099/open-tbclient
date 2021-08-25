package com.baidu.wallet.qrcodescanner.beans;

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
public final class QRCodeScannerBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QRCODE_SHORT_URL = 2561;
    public static final int QRCODE_WHITE_LIST = 2560;

    /* renamed from: a  reason: collision with root package name */
    public static QRCodeScannerBeanFactory f63476a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static QRCodeScannerBeanFactory f63477a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(715046337, "Lcom/baidu/wallet/qrcodescanner/beans/QRCodeScannerBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(715046337, "Lcom/baidu/wallet/qrcodescanner/beans/QRCodeScannerBeanFactory$a;");
                    return;
                }
            }
            f63477a = new QRCodeScannerBeanFactory(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-933333090, "Lcom/baidu/wallet/qrcodescanner/beans/QRCodeScannerBeanFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-933333090, "Lcom/baidu/wallet/qrcodescanner/beans/QRCodeScannerBeanFactory;");
        }
    }

    public /* synthetic */ QRCodeScannerBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static QRCodeScannerBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f63477a : (QRCodeScannerBeanFactory) invokeV.objValue;
    }

    public QRCodeScannerBeanFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
            if (i2 == 2560) {
                bVar = new b(context);
            } else if (i2 != 2561) {
                baseBean = null;
                if (baseBean != null) {
                    BeanManager.getInstance().addBean(str, baseBean);
                }
                return baseBean;
            } else {
                bVar = new com.baidu.wallet.qrcodescanner.beans.a(context);
            }
            baseBean = bVar;
            if (baseBean != null) {
            }
            return baseBean;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
