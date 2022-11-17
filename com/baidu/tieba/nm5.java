package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class nm5 extends NotificationHelper {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, b> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final nm5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-570761068, "Lcom/baidu/tieba/nm5$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-570761068, "Lcom/baidu/tieba/nm5$c;");
                    return;
                }
            }
            a = new nm5(null);
        }
    }

    public nm5() {
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
        b = new HashMap();
        this.a = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
    }

    public final PendingIntent d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.tieba.downloadmanager.DownloadManagerActivity");
                Intent intent = new Intent();
                intent.setClass(getContext(), cls);
                intent.putExtra(DownloadManagerActivityConfig.CURRENT_TAB, 3);
                return PendingIntent.getActivity(getContext(), 0, intent, 134217728);
            } catch (Exception unused) {
                return null;
            }
        }
        return (PendingIntent) invokeV.objValue;
    }

    public /* synthetic */ nm5(a aVar) {
        this();
    }

    public final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (g(str)) {
                return b.get(str).a;
            }
            return str.hashCode();
        }
        return invokeL.intValue;
    }

    public final boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return b.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && g(str)) {
            NotificationHelper.cancelNotification(getContext(), b(str));
            b.remove(str);
        }
    }

    public static nm5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c.a;
        }
        return (nm5) invokeV.objValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return TbadkCoreApplication.getInst().getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    public synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            synchronized (this) {
                if (g(str)) {
                    return;
                }
                b bVar = new b(null);
                bVar.a = b(str);
                bVar.b = str2;
                b.put(str, bVar);
            }
        }
    }

    public final void e(DownloadData downloadData, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, downloadData, z) == null) && downloadData.getId() != null && g(downloadData.getId())) {
            float length = ((float) downloadData.getLength()) / ((float) downloadData.getSize());
            if (z) {
                i = 100;
            } else {
                i = (int) (length * 100.0f);
            }
            b bVar = b.get(downloadData.getId());
            if (bVar != null) {
                NotificationHelper.showProgressNotification(getContext(), bVar.a, "", i, "", bVar.b, d(), false);
            }
            if (!z) {
                i(downloadData, i);
            }
        }
    }

    public void f(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, list) == null) && list != null && list.size() != 0) {
            for (DownloadData downloadData : list) {
                if (downloadData != null) {
                    int status = downloadData.getStatus();
                    if (status != 0) {
                        if (status == 1 || status == 5) {
                            e(downloadData, false);
                        }
                    } else {
                        e(downloadData, true);
                    }
                }
            }
        }
    }

    public final void i(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, downloadData, i) == null) && downloadData != null && g(downloadData.getId())) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putInt(downloadData.getId() + downloadData.getName(), i);
            edit.apply();
        }
    }
}
