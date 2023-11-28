package com.baidu.tieba;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.tieba.u11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v21 extends x21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ b c;
        public final /* synthetic */ int d;

        public a(String[] strArr, Activity activity, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, activity, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strArr;
            this.b = activity;
            this.c = bVar;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[this.a.length];
                PackageManager packageManager = this.b.getPackageManager();
                String packageName = this.b.getPackageName();
                int length = this.a.length;
                for (int i = 0; i < length; i++) {
                    iArr[i] = packageManager.checkPermission(this.a[i], packageName);
                }
                this.c.onRequestPermissionsResult(this.d, this.a, iArr);
            }
        }
    }

    public static void b(Activity activity, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, activity, strArr, i) == null) {
            if (u11.b.d()) {
                w21.a(activity, strArr, i);
            } else if (activity instanceof b) {
                c(activity, strArr, i, (b) activity);
            }
        }
    }

    public static void c(Activity activity, String[] strArr, int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, activity, strArr, i, bVar) == null) {
            if (u11.b.d()) {
                w21.a(activity, strArr, i);
            } else if (!activity.isFinishing() && bVar != null) {
                wf0.c(new a(strArr, activity, bVar, i));
            }
        }
    }

    public static boolean d(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, str)) == null) {
            if (u11.b.d() && w21.b(activity, str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
