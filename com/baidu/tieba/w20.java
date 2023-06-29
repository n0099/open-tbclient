package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BdAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class w20 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    @RequiresApi(api = 23)
    public static final String[] b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface g {
        void onRequestPermissionsResult(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a implements DangerousPermissionManager.RequestSystemPermissionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g b;
        public final /* synthetic */ WeakReference c;

        public a(int i, g gVar, WeakReference weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), gVar, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = gVar;
            this.c = weakReference;
        }

        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == this.a) {
                boolean z = true;
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (iArr[i2] == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                g gVar = this.b;
                if (gVar != null) {
                    gVar.onRequestPermissionsResult(z);
                    if (!z) {
                        int i3 = this.a;
                        if (i3 != 101) {
                            if (i3 == 102 && Build.VERSION.SDK_INT > 25) {
                                w20.g(this.c);
                            }
                        } else if (PreferenceUtils.getBoolean("download_storage_permission_dialog_show", false)) {
                            w20.i();
                        } else {
                            PreferenceUtils.setBoolean("download_storage_permission_dialog_show", true);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DangerousPermissionManager.RequestGrantPermissionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EventCallback a;
        public final /* synthetic */ String b;

        public b(EventCallback eventCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eventCallback, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eventCallback;
            this.b = str;
        }

        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestGrantPermissionCallBack
        public void isClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EventCallback eventCallback = this.a;
                if (eventCallback != null) {
                    eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_PERMISSION_SETTINGS_CLICK_NO));
                }
                UniversalToast.makeText(AppRuntime.getAppContext(), (int) R.string.download_permission_toast_tip).show();
                y20.o(this.b);
                y20.r(this.b, false);
            }
        }

        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestGrantPermissionCallBack
        public void isGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                EventCallback eventCallback = this.a;
                if (eventCallback != null) {
                    eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_PERMISSION_SETTINGS_CLICK_YES));
                }
                y20.r(this.b, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DangerousPermissionManager.RequestGrantPermissionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestGrantPermissionCallBack
        public void isClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y20.y(DownloadStatisticConstants.UBC_PERMISSION_DIALOG_CANCELL, "");
            }
        }

        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestGrantPermissionCallBack
        public void isGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y20.y(DownloadStatisticConstants.UBC_PERMISSION_DIALOG_CONFIRM, "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                y20.c(DownloadStatisticConstants.UBC_PERMISSION_INSTALL_DIALOG_PAGE, DownloadStatisticConstants.UBC_PERMISSION_DIALOG_INSTALL_OUT);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BdAlertDialog.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                w20.e();
                y20.c(DownloadStatisticConstants.UBC_PERMISSION_INSTALL_DIALOG_PAGE, DownloadStatisticConstants.UBC_PERMISSION_DIALOG_INSTALL_SET);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements BdAlertDialog.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.android.ext.widget.dialog.BdAlertDialog.OnItemClickListener
        public void onItemClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218548, "Lcom/baidu/tieba/w20;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218548, "Lcom/baidu/tieba/w20;");
                return;
            }
        }
        a = new String[]{com.kuaishou.weapon.p0.h.i, "android.permission.WRITE_EXTERNAL_STORAGE"};
        b = new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"};
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            j("download");
        }
    }

    public static boolean b(Activity activity, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, strArr)) == null) {
            return DangerousPermissionUtils.isPermissionGroupGranted(activity, strArr);
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(Activity activity, String[] strArr, g gVar, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, activity, strArr, gVar, i)) == null) {
            if (!b(activity, strArr)) {
                f(activity, strArr, gVar, i);
                return false;
            }
            if (gVar != null) {
                gVar.onRequestPermissionsResult(true);
            }
            return true;
        }
        return invokeLLLI.booleanValue;
    }

    public static void f(Activity activity, String[] strArr, g gVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65542, null, activity, strArr, gVar, i) == null) {
            DangerousPermissionUtils.requestPermissions("download", AppRuntime.getAppContext(), strArr, i, new a(i, gVar, new WeakReference(activity)));
        }
    }

    public static boolean d(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr)) == null) {
            Activity topActivity = BdBoxActivityManager.getTopActivity();
            if (topActivity != null) {
                return b(topActivity, strArr);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            y20.y(DownloadStatisticConstants.UBC_PERMISSION_DIALOG_SHOW, "");
            DangerousPermissionUtils.requestGrantPermissionsDialog(str, "storage", new c());
        }
    }

    @RequiresApi(26)
    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.fromParts("package", AppRuntime.getAppContext().getPackageName(), null));
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
        }
    }

    @RequiresApi(26)
    public static void g(WeakReference<Activity> weakReference) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, weakReference) == null) && weakReference != null && weakReference.get() != null && !weakReference.get().isFinishing()) {
            y20.c(DownloadStatisticConstants.UBC_PERMISSION_INSTALL_DIALOG_PAGE, DownloadStatisticConstants.UBC_PERMISSION_DIALOG_INSTALL_SHOW);
            String str = Build.MANUFACTURER;
            String string = weakReference.get().getString(R.string.common_install_permission_msg);
            if ("vivo".equalsIgnoreCase(str)) {
                string = weakReference.get().getString(R.string.vivo_install_permission_msg);
            } else if ("OPPO".equalsIgnoreCase(str)) {
                string = weakReference.get().getString(R.string.oppo_install_permission_msg);
            } else if (RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(str)) {
                string = weakReference.get().getString(R.string.xiaomi_install_permission_msg);
            }
            new BdAlertDialog.Builder(weakReference.get()).setTitle(R.string.install_permission_title).setMessage(weakReference.get().getString(R.string.install_permission_msg, new Object[]{string})).setButton(new BdAlertDialog.ButtonItem(weakReference.get().getString(R.string.download_permission_cancel), new f())).setButton(new BdAlertDialog.ButtonItem(weakReference.get().getString(R.string.download_permission_confirm), new e())).setOnDismissListener(new d()).create().show();
        }
    }

    public static void k(Context context, String str, EventCallback eventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, eventCallback) == null) {
            if (eventCallback != null) {
                eventCallback.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_PERMISSION_SETTINGS_SHOW));
            }
            y20.s(str);
            DangerousPermissionUtils.requestGrantPermissionsDialog(context, "download", "storage", new b(eventCallback, str));
        }
    }
}
