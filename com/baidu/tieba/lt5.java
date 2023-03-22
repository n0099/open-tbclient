package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class lt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, cb9 cb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, cb9Var)) == null) {
            if (context == null || cb9Var == null || !cb9Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = cb9Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.F(a.app_id);
            tiePlusHelper.G(a.title);
            tiePlusHelper.M(true);
            tiePlusHelper.L(a.download_url);
            tiePlusHelper.O(a.app_package);
            tiePlusHelper.P(a.app_power);
            tiePlusHelper.Q(a.app_privacy);
            bu5 bu5Var = new bu5(context, tiePlusHelper, true);
            tiePlusHelper.J(bu5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.N(itemData);
            bu5Var.f(a.app_company);
            bu5Var.g(a.app_icon);
            bu5Var.h(a.title);
            bu5Var.i(a.app_version);
            bu5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
