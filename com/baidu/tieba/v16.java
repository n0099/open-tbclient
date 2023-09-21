package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ApkDetail;
import tbclient.TiebaPlusInfo;
/* loaded from: classes8.dex */
public class v16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, aja ajaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, ajaVar)) == null) {
            boolean z = false;
            if (context != null && ajaVar != null && ajaVar.b()) {
                TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
                TiebaPlusInfo a = ajaVar.a();
                if (a == null) {
                    return false;
                }
                tiePlusHelper.Q(a.app_id);
                tiePlusHelper.R(a.title);
                z = true;
                tiePlusHelper.Y(true);
                tiePlusHelper.W(a.download_url);
                tiePlusHelper.b0(a.app_package);
                tiePlusHelper.c0(a.app_power);
                tiePlusHelper.d0(a.app_privacy);
                tiePlusHelper.X(a.app_effect);
                l26 l26Var = new l26(context, tiePlusHelper, true);
                tiePlusHelper.U(l26Var);
                ItemData itemData = new ItemData();
                itemData.parseProto(a);
                itemData.fileType = "app";
                StringBuilder sb = new StringBuilder();
                sb.append(itemData.pkgName);
                sb.append(".v");
                ApkDetail apkDetail = itemData.apkDetail;
                if (apkDetail != null) {
                    sb.append(apkDetail.version);
                }
                DownloadData downloadData = new DownloadData(sb.toString());
                downloadData.setUrl(itemData.buttonLink);
                downloadData.setName(itemData.mTitle);
                downloadData.setSource(2);
                downloadData.setType(12);
                downloadData.setItemData(itemData);
                tiePlusHelper.Z(itemData);
                tiePlusHelper.V(downloadData);
                l26Var.g(a.app_company);
                l26Var.h(a.app_icon);
                l26Var.i(a.title);
                l26Var.j(a.app_version);
                l26Var.show();
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
