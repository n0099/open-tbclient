package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public class r16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, o3a o3aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, o3aVar)) == null) {
            if (context == null || o3aVar == null || !o3aVar.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = o3aVar.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.F(a.app_id);
            tiePlusHelper.G(a.title);
            tiePlusHelper.M(true);
            tiePlusHelper.K(a.download_url);
            tiePlusHelper.O(a.app_package);
            tiePlusHelper.P(a.app_power);
            tiePlusHelper.Q(a.app_privacy);
            h26 h26Var = new h26(context, tiePlusHelper, true);
            tiePlusHelper.J(h26Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.N(itemData);
            h26Var.f(a.app_company);
            h26Var.g(a.app_icon);
            h26Var.h(a.title);
            h26Var.i(a.app_version);
            h26Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
