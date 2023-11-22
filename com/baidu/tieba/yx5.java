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
/* loaded from: classes9.dex */
public class yx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, wqa wqaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, wqaVar)) == null) {
            boolean z = false;
            if (context != null && wqaVar != null && wqaVar.b()) {
                TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
                TiebaPlusInfo a = wqaVar.a();
                if (a == null) {
                    return false;
                }
                tiePlusHelper.R(a.app_id);
                tiePlusHelper.S(a.title);
                z = true;
                tiePlusHelper.Z(true);
                tiePlusHelper.X(a.download_url);
                tiePlusHelper.b0(a.app_package);
                tiePlusHelper.c0(a.app_power);
                tiePlusHelper.d0(a.app_privacy);
                tiePlusHelper.Y(a.app_effect);
                py5 py5Var = new py5(context, tiePlusHelper, true);
                tiePlusHelper.V(py5Var);
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
                tiePlusHelper.a0(itemData);
                tiePlusHelper.W(downloadData);
                py5Var.g(a.app_company);
                py5Var.h(a.app_icon);
                py5Var.i(a.title);
                py5Var.j(a.app_version);
                py5Var.show();
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
