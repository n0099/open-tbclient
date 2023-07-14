package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes8.dex */
public class v26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, zba zbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, zbaVar)) == null) {
            if (context == null || zbaVar == null || !zbaVar.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = zbaVar.a();
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
            l36 l36Var = new l36(context, tiePlusHelper, true);
            tiePlusHelper.J(l36Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.N(itemData);
            l36Var.f(a.app_company);
            l36Var.g(a.app_icon);
            l36Var.h(a.title);
            l36Var.i(a.app_version);
            l36Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
