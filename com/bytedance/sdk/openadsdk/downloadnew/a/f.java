package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.e.m;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mVar)) == null) {
            if (mVar == null) {
                return "";
            }
            com.bytedance.sdk.openadsdk.core.e.b al = mVar.al();
            if (al != null && !TextUtils.isEmpty(al.c())) {
                return al.c();
            }
            if (!TextUtils.isEmpty(mVar.W())) {
                return mVar.W();
            }
            if (TextUtils.isEmpty(mVar.ai())) {
                return !TextUtils.isEmpty(mVar.aC()) ? mVar.aC() : "";
            }
            return mVar.ai();
        }
        return (String) invokeL.objValue;
    }
}
