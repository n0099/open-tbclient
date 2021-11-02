package com.baidu.wallet.core.beans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes10.dex */
public final class BeanManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<BaseBean<?>>> f57976a;

    /* renamed from: com.baidu.wallet.core.beans.BeanManager$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BeanManager f57977a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1649499659, "Lcom/baidu/wallet/core/beans/BeanManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1649499659, "Lcom/baidu/wallet/core/beans/BeanManager$a;");
                    return;
                }
            }
            f57977a = new BeanManager(null);
        }

        public a() {
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
    }

    public /* synthetic */ BeanManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BeanManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f57977a : (BeanManager) invokeV.objValue;
    }

    public synchronized void addBean(String str, BaseBean<?> baseBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, baseBean) == null) {
            synchronized (this) {
                ArrayList<BaseBean<?>> arrayList = this.f57976a.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f57976a.put(str, arrayList);
                }
                arrayList.add(baseBean);
            }
        }
    }

    public synchronized void removeAllBeans(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                ArrayList<BaseBean<?>> arrayList = this.f57976a.get(str);
                if (arrayList != null) {
                    Iterator<BaseBean<?>> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().destroyBean();
                    }
                    this.f57976a.remove(str);
                }
            }
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseBean) == null) {
            synchronized (this) {
                for (String str : this.f57976a.keySet()) {
                    ArrayList<BaseBean<?>> arrayList = this.f57976a.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<BaseBean<?>> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (baseBean == it.next()) {
                                    arrayList.remove(baseBean);
                                    baseBean.destroyBean();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public BeanManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57976a = new HashMap<>();
    }
}
