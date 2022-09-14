package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class lk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, wl8 wl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, wl8Var)) == null) {
            if (context == null || wl8Var == null || !wl8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = wl8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.D(a.app_id);
            tiePlusHelper.E(a.title);
            tiePlusHelper.K(true);
            tiePlusHelper.I(a.download_url);
            tiePlusHelper.M(a.app_package);
            tiePlusHelper.N(a.app_power);
            tiePlusHelper.O(a.app_privacy);
            bl5 bl5Var = new bl5(context, tiePlusHelper, true);
            tiePlusHelper.H(bl5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.L(itemData);
            bl5Var.f(a.app_company);
            bl5Var.g(a.app_icon);
            bl5Var.h(a.title);
            bl5Var.i(a.app_version);
            bl5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
