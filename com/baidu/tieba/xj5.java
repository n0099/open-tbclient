package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes9.dex */
public class xj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, downloadData) == null) {
            o65.a(downloadData, 400);
            i(downloadData).s(downloadData);
        }
    }

    public static boolean b(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, downloadData)) == null) {
            if (downloadData != null) {
                i = i(downloadData).q(downloadData);
            } else {
                i = 1;
            }
            if (i == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int c(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, downloadData)) == null) {
            return i(downloadData).q(downloadData);
        }
        return invokeL.intValue;
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            if (split.length == 2) {
                return split[1];
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    public static int h(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            int p = i(downloadData).p(downloadData);
            if (p >= 0 && p <= 100) {
                return p;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void j(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, downloadData) == null) {
            o65.a(downloadData, 800);
            String o = i(downloadData).o(downloadData);
            if (StringUtils.isNotNull(o)) {
                AdApkInstallHelper.a(o, downloadData);
            }
        }
    }

    public static void l(String str) {
        Context context;
        Intent f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, str) != null) || TextUtils.isEmpty(str) || (f = f((context = TbadkCoreApplication.getInst().getContext()), str)) == null) {
            return;
        }
        try {
            context.startActivity(f);
        } catch (Exception unused) {
        }
    }

    public static boolean m(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, downloadData)) == null) {
            if (BdUtilHelper.isNetOk()) {
                return i(downloadData).y(downloadData);
            }
            sd5.b(downloadData);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (td5.q().t(str)) {
                return 1;
            }
            if (td5.q().r(str)) {
                return 5;
            }
            File m = td5.q().m(str, str2);
            if (m != null && m.exists()) {
                return 7;
            }
            return 6;
        }
        return invokeLL.intValue;
    }

    public static PackageInfo e(String str) {
        InterceptResult invokeL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                packageInfo = TbadkApplication.getInst().getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!str.equals(packageInfo.packageName)) {
                return null;
            }
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static Intent f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static TbDownloadManager i(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadData)) == null) {
            TbDownloadManager tbDownloadManager = new TbDownloadManager();
            if (downloadData != null && downloadData.getItemData() != null) {
                if (downloadData.getItemData().isFromTbDownloaderTable) {
                    tbDownloadManager.w(1);
                } else if (downloadData.getItemData().mTbFileDownloaderType > 0) {
                    tbDownloadManager.w(downloadData.getItemData().mTbFileDownloaderType);
                } else {
                    tbDownloadManager.w(2);
                    if (tbDownloadManager.p(downloadData) <= 0) {
                        tbDownloadManager.w(1);
                        if (tbDownloadManager.p(downloadData) <= 0) {
                            tbDownloadManager.w(me7.a());
                        }
                    }
                }
            }
            return tbDownloadManager;
        }
        return (TbDownloadManager) invokeL.objValue;
    }

    public static DownloadData k(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, itemData)) == null) {
            String str = itemData.pkgName + ".v" + itemData.apkDetail.version;
            DownloadData downloadData = new DownloadData();
            downloadData.setType(12);
            downloadData.setId(str);
            downloadData.setName(itemData.mTitle);
            downloadData.setUniqueId(String.valueOf(itemData.itemId));
            downloadData.setUrl(itemData.buttonLink);
            downloadData.setNotifyId(mia.p(str).intValue());
            downloadData.setNeedInvokeApk(true);
            downloadData.setNeedNotify(false);
            downloadData.setItemData(itemData);
            ItemDownloadExtraData itemDownloadExtraData = new ItemDownloadExtraData(itemData.apkDetail.pkg_source.intValue());
            itemDownloadExtraData.appName = itemData.mTitle;
            itemDownloadExtraData.pkgName = itemData.pkgName;
            downloadData.setExtra(itemDownloadExtraData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}
