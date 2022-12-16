package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class jn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, mr8 mr8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, mr8Var)) == null) {
            if (context == null || mr8Var == null || !mr8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = mr8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.D(a.app_id);
            tiePlusHelper.E(a.title);
            tiePlusHelper.K(true);
            tiePlusHelper.J(a.download_url);
            tiePlusHelper.M(a.app_package);
            tiePlusHelper.N(a.app_power);
            tiePlusHelper.O(a.app_privacy);
            zn5 zn5Var = new zn5(context, tiePlusHelper, true);
            tiePlusHelper.H(zn5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.L(itemData);
            zn5Var.f(a.app_company);
            zn5Var.g(a.app_icon);
            zn5Var.h(a.title);
            zn5Var.i(a.app_version);
            zn5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
