package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Collection<Collection<c>> f62371a;

    /* renamed from: com.baidu.wallet.lightapp.multipage.g$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static g f62372a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549812090, "Lcom/baidu/wallet/lightapp/multipage/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549812090, "Lcom/baidu/wallet/lightapp/multipage/g$a;");
                    return;
                }
            }
            f62372a = new g(null);
        }
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62372a : (g) invokeV.objValue;
    }

    public void b(Collection<c> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, collection) == null) || collection == null) {
            return;
        }
        this.f62371a.remove(collection);
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Runtime runtime = Runtime.getRuntime();
            float maxMemory = (float) (((runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory()) / 1048576);
            LogUtil.d("LangbridgeRamMonitor", "FreeRam:" + maxMemory);
            return maxMemory;
        }
        return invokeV.floatValue;
    }

    public g() {
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
        this.f62371a = new Vector();
    }

    public void a(Collection<c> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, collection) == null) || collection == null) {
            return;
        }
        this.f62371a.add(collection);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = 0;
            for (Collection<c> collection : this.f62371a) {
                i2 += collection.size();
            }
            LogUtil.d("LangbridgeRamMonitor", "UsingCellCount:" + i2);
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            LangbridgeSettings a2 = i.a().a(context);
            boolean z = a2.MW_LANG_CELL_LIMIT == -1 || b() < a2.MW_LANG_CELL_LIMIT;
            boolean z2 = a2.MW_LANG_RAM_LIMIT == -1.0d || ((double) c()) > a2.MW_LANG_RAM_LIMIT;
            boolean z3 = z && z2;
            if (!z3) {
                String[] strArr = new String[1];
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "1" : "0");
                sb.append(z2 ? "1" : "0");
                strArr[0] = sb.toString();
                DXMSdkSAUtils.onEventWithValues("#MW_LRM_NoNewCell", Arrays.asList(strArr));
            }
            return z3;
        }
        return invokeL.booleanValue;
    }
}
