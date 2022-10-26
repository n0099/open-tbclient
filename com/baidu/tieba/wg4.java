package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wg4 extends ph4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes6.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public a(String[] strArr, Activity activity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, activity, Integer.valueOf(i)};
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
            this.c = i;
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
                ((b) this.b).onRequestPermissionsResult(this.c, this.a, iArr);
            }
        }
    }

    public static void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, activity) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                xg4.a(activity);
            } else {
                activity.finish();
            }
        }
    }

    public static boolean f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return yg4.a(activity, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, activity, strArr, i) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                yg4.requestPermissions(activity, strArr, i);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i));
            }
        }
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, activity, intent, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                ah4.startActivity(activity, intent, bundle);
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, intent, i, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                ah4.startActivityForResult(activity, intent, i, bundle);
            } else {
                activity.startActivityForResult(intent, i);
            }
        }
    }
}
