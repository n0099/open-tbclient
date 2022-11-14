package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pa1 a(Uri uri) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            pa1 pa1Var = new pa1();
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("downloaded_size");
                long j2 = 0;
                if (!TextUtils.isEmpty(queryParameter)) {
                    j = Long.valueOf(queryParameter).longValue();
                } else {
                    j = 0;
                }
                String queryParameter2 = uri.getQueryParameter(PackageTable.TOTAL_SIZE);
                if (!TextUtils.isEmpty(queryParameter2)) {
                    j2 = Long.valueOf(queryParameter2).longValue();
                }
                pa1Var.a = j;
                pa1Var.b = j2;
            }
            return pa1Var;
        }
        return (pa1) invokeL.objValue;
    }

    public static Uri b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new Uri.Builder().scheme("content").authority(BundleOpProvider.i(ContextHolder.getApplicationContext())).build();
        }
        return (Uri) invokeV.objValue;
    }

    public static Uri c(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return new Uri.Builder().scheme("content").authority(BundleOpProvider.i(ContextHolder.getApplicationContext())).path(str).appendQueryParameter("downloaded_size", String.valueOf(j)).appendQueryParameter(PackageTable.TOTAL_SIZE, String.valueOf(j2)).build();
        }
        return (Uri) invokeCommon.objValue;
    }

    public static Uri d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return new Uri.Builder().scheme("content").authority(BundleOpProvider.i(ContextHolder.getApplicationContext())).path(str).build();
        }
        return (Uri) invokeL.objValue;
    }

    public static Uri e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return new Uri.Builder().scheme("content").authority(BundleOpProvider.i(ContextHolder.getApplicationContext())).path(str).build();
        }
        return (Uri) invokeL.objValue;
    }
}
