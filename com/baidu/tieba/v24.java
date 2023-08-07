package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Calendar;
import java.util.Collection;
/* loaded from: classes8.dex */
public class v24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v24 c;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public String b;

    public v24() {
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
        this.b = "com.baidu.gamenow";
        this.a = KVStorageFactory.getSharedPreferences("gamecenter_install_notification", 0);
    }

    public static v24 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (v24.class) {
                    if (c == null) {
                        c = new v24();
                    }
                }
            }
            return c;
        }
        return (v24) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return mn3.f(Long.valueOf(g()), Long.valueOf(System.currentTimeMillis()));
        }
        return invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (b()) {
                return null;
            }
            if (d()) {
                return "todayfirst";
            }
            if (!e()) {
                return null;
            }
            return "pushregularly";
        }
        return (String) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if ((System.currentTimeMillis() / 86400000) - (g() / 86400000) > 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (i() <= System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getLong("key_notification_time", 0L);
        }
        return invokeV.longValue;
    }

    public final long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long i = i();
            if (i < System.currentTimeMillis()) {
                return i + 86400000;
            }
            return i;
        }
        return invokeV.longValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 19);
            calendar.set(12, 30);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !TextUtils.isEmpty(c())) {
            n(c());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putLong("key_notification_time", System.currentTimeMillis());
            edit.apply();
        }
    }

    public void a(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, download) == null) {
            w24.a(AppRuntime.getAppContext(), Long.valueOf(download.getId().longValue()).intValue());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ((AlarmManager) AppRuntime.getAppContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, h(), PendingIntent.getBroadcast(AppRuntime.getAppContext(), 2147483646, InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ALARM), 0));
        }
    }

    public void m(Download download, boolean z, String str) {
        String format;
        String string;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{download, Boolean.valueOf(z), str}) == null) {
            try {
                String str3 = download.getRealDownloadDir() + File.separator + download.getFileName();
                PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str3, 1);
                if (packageArchiveInfo == null) {
                    return;
                }
                Context appContext = AppRuntime.getAppContext();
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str3;
                applicationInfo.publicSourceDir = str3;
                Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                String charSequence = packageManager.getApplicationLabel(applicationInfo).toString();
                PendingIntent broadcast = PendingIntent.getBroadcast(appContext, Long.valueOf(download.getId().longValue()).intValue(), InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ONE, download.getKeyByUser(), str), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                if (z) {
                    l();
                    format = String.format(appContext.getString(R.string.obfuscated_res_0x7f0f0211), charSequence);
                    string = appContext.getString(R.string.obfuscated_res_0x7f0f0149);
                } else {
                    format = String.format(appContext.getString(R.string.obfuscated_res_0x7f0f0211), charSequence);
                    string = appContext.getString(R.string.obfuscated_res_0x7f0f0149);
                }
                String str4 = format;
                try {
                    if (TextUtils.equals(download.getKeyByUser(), this.b)) {
                        str2 = appContext.getString(R.string.obfuscated_res_0x7f0f01b9);
                    } else {
                        str2 = string;
                    }
                    w24.c(appContext, Long.valueOf(download.getId().longValue()).intValue(), str4, str2, w24.b(applicationIcon), System.currentTimeMillis(), broadcast, str, download.getKeyByUser());
                } catch (Exception e) {
                    e = e;
                    if (ir1.a) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || b()) {
            return;
        }
        try {
            Collection<Download> t = new j24(DownloadManager.getInstance(AppRuntime.getAppContext())).t();
            if (t != null && t.size() != 0) {
                k();
                Download download = null;
                for (Download download2 : t) {
                    if (download2 != null) {
                        download = download2;
                    }
                }
                if (1 == t.size()) {
                    m(download, false, str);
                    return;
                }
                String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1);
                if (packageArchiveInfo == null) {
                    return;
                }
                Context appContext = AppRuntime.getAppContext();
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str2;
                applicationInfo.publicSourceDir = str2;
                w24.c(appContext, 0, String.format(appContext.getString(R.string.obfuscated_res_0x7f0f0212), Integer.valueOf(t.size())), appContext.getString(R.string.obfuscated_res_0x7f0f0149), w24.b(packageManager.getApplicationIcon(applicationInfo)), System.currentTimeMillis(), PendingIntent.getBroadcast(appContext, Integer.MAX_VALUE, InstallNotifyReceiver.createToDownloadPageIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_MULTIPLE).putExtra(InstallNotifyReceiver.OPPORTUNITY, str), SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), str, download.getKeyByUser());
            }
        } catch (Exception e) {
            if (ir1.a) {
                e.printStackTrace();
            }
        }
    }
}
