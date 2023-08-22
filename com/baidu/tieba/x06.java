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
public class x06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, bfa bfaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, bfaVar)) == null) {
            boolean z = false;
            if (context != null && bfaVar != null && bfaVar.b()) {
                TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
                TiebaPlusInfo a = bfaVar.a();
                if (a == null) {
                    return false;
                }
                tiePlusHelper.Q(a.app_id);
                tiePlusHelper.R(a.title);
                z = true;
                tiePlusHelper.Y(true);
                tiePlusHelper.X(a.download_url);
                tiePlusHelper.a0(a.app_package);
                tiePlusHelper.b0(a.app_power);
                tiePlusHelper.c0(a.app_privacy);
                n16 n16Var = new n16(context, tiePlusHelper, true);
                tiePlusHelper.U(n16Var);
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
                tiePlusHelper.W(downloadData);
                n16Var.f(a.app_company);
                n16Var.g(a.app_icon);
                n16Var.h(a.title);
                n16Var.i(a.app_version);
                n16Var.show();
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
