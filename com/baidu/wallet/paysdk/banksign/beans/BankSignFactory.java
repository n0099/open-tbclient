package com.baidu.wallet.paysdk.banksign.beans;

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
public final class BankSignFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_BIND_CARD = 771;
    public static final int BEAN_ID_GET_JUMP_URL = 768;
    public static final int BEAN_ID_POLLING = 769;
    public static final int BEAN_ID_QUERY = 770;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.paysdk.banksign.beans.BankSignFactory$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BankSignFactory f26091a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(386065242, "Lcom/baidu/wallet/paysdk/banksign/beans/BankSignFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(386065242, "Lcom/baidu/wallet/paysdk/banksign/beans/BankSignFactory$a;");
                    return;
                }
            }
            f26091a = new BankSignFactory(null);
        }
    }

    public /* synthetic */ BankSignFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankSignFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f26091a : (BankSignFactory) invokeV.objValue;
    }

    public BankSignFactory() {
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
        BaseBean<?> bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            Context applicationContext = context.getApplicationContext();
            switch (i2) {
                case 768:
                    bVar = new b(applicationContext);
                    break;
                case 769:
                    bVar = new c(applicationContext);
                    break;
                case BEAN_ID_QUERY /* 770 */:
                    bVar = new d(applicationContext);
                    break;
                case BEAN_ID_BIND_CARD /* 771 */:
                    bVar = new com.baidu.wallet.paysdk.banksign.beans.a(applicationContext);
                    break;
                default:
                    bVar = null;
                    break;
            }
            if (bVar != null) {
                BeanManager.getInstance().addBean(str, bVar);
            }
            return bVar;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
