package com.baidu.wallet.home.beans;

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
/* loaded from: classes6.dex */
public final class WalletHomeBeanFactory implements IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BEAN_ID_HOMETAB = 49158;
    public static final int BEAN_ID_HOME_CFG = 49157;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.home.beans.WalletHomeBeanFactory$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static WalletHomeBeanFactory f24877a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(802468816, "Lcom/baidu/wallet/home/beans/WalletHomeBeanFactory$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(802468816, "Lcom/baidu/wallet/home/beans/WalletHomeBeanFactory$a;");
                    return;
                }
            }
            f24877a = new WalletHomeBeanFactory(null);
        }
    }

    public /* synthetic */ WalletHomeBeanFactory(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static WalletHomeBeanFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f24877a : (WalletHomeBeanFactory) invokeV.objValue;
    }

    public WalletHomeBeanFactory() {
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
        BaseBean<?> homeCfgBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str)) == null) {
            switch (i2) {
                case BEAN_ID_HOME_CFG /* 49157 */:
                    homeCfgBean = new HomeCfgBean(context);
                    break;
                case BEAN_ID_HOMETAB /* 49158 */:
                    homeCfgBean = new HomeTabBean(context);
                    break;
                default:
                    homeCfgBean = null;
                    break;
            }
            if (homeCfgBean != null) {
                BeanManager.getInstance().addBean(str, homeCfgBean);
            }
            return homeCfgBean;
        }
        return (BaseBean) invokeLIL.objValue;
    }
}
