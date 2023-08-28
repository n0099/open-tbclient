package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public abstract class jzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public abstract void f(Bundle bundle);

    public abstract boolean g(Bundle bundle);

    public abstract String h(Bundle bundle);

    public abstract void i(String str);

    public abstract boolean j(String str);

    public abstract String k(String str);

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final kzb<String> m(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                if (str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return izb.f.a().j(this.a, str);
                }
            }
            return new kzb<>(false, "sendData2MainProcessForStr null");
        }
        return (kzb) invokeL.objValue;
    }
}
