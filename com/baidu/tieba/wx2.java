package com.baidu.tieba;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class wx2 implements qo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap c;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final wx2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-303029382, "Lcom/baidu/tieba/wx2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-303029382, "Lcom/baidu/tieba/wx2$b;");
                    return;
                }
            }
            a = new wx2(null);
        }
    }

    public wx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap();
    }

    public static wx2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (wx2) invokeV.objValue;
    }

    public /* synthetic */ wx2(a aVar) {
        this();
    }

    public View b(int i, ViewGroup viewGroup, boolean z) {
        InterceptResult invokeCommon;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), viewGroup, Boolean.valueOf(z)})) == null) {
            View d = d(i);
            if (d != null && viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                ViewGroup.LayoutParams layoutParams2 = d.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
                } else {
                    layoutParams2.width = layoutParams.width;
                    layoutParams2.height = layoutParams.height;
                }
                d.setLayoutParams(layoutParams2);
            }
            if (d == null) {
                long currentTimeMillis = System.currentTimeMillis();
                View inflate = LayoutInflater.from(tm2.c()).inflate(i, viewGroup, z);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (qo2.a) {
                    Log.d("SwanPerformance", "getView resId = " + i + " ；inflate new view cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
                return inflate;
            }
            return d;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(int... iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) && iArr != null && iArr.length != 0) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int length = iArr.length;
                LayoutInflater from = LayoutInflater.from(tm2.c());
                for (int i : iArr) {
                    View inflate = from.inflate(i, (ViewGroup) null);
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.c.get(Integer.valueOf(i));
                    if (copyOnWriteArrayList == null) {
                        copyOnWriteArrayList = new CopyOnWriteArrayList();
                    }
                    copyOnWriteArrayList.add(inflate);
                    this.c.put(Integer.valueOf(i), copyOnWriteArrayList);
                }
                if (qo2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    Log.d("SwanPerformance", "inflateLayoutRes count = " + length + "; cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            } catch (Exception e) {
                if (qo2.a) {
                    Log.d("SwanPerformance", Log.getStackTraceString(e));
                }
            }
        }
    }

    public View d(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View view2 = null;
            try {
                List list = (List) this.c.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    view2 = (View) list.remove(0);
                }
            } catch (Exception e) {
                if (qo2.a) {
                    Log.d("SwanPerformance", Log.getStackTraceString(e));
                }
            }
            if (qo2.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("tryObtainLayoutByResId resId = ");
                sb.append(i);
                if (view2 == null) {
                    str = " cache view is null";
                } else {
                    str = " adopt cached view";
                }
                sb.append(str);
                Log.d("SwanPerformance", sb.toString());
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }
}
