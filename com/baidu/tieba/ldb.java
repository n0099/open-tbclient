package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ldb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment a;
    public Activity b;
    public kdb c;

    public ldb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ldb c(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragment)) == null) {
            ldb ldbVar = new ldb();
            ldbVar.a = fragment;
            return ldbVar;
        }
        return (ldb) invokeL.objValue;
    }

    public void a(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, intent) != null) || i != 25069) {
            return;
        }
        if (i2 == -1) {
            kdb kdbVar = this.c;
            if (kdbVar != null) {
                kdbVar.a();
                return;
            }
            return;
        }
        kdb kdbVar2 = this.c;
        if (kdbVar2 != null) {
            kdbVar2.b();
        }
    }

    public void b(kdb kdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kdbVar) == null) {
            this.c = kdbVar;
            Fragment fragment = this.a;
            if (fragment != null) {
                Intent prepare = VpnService.prepare(fragment.getContext());
                if (prepare != null) {
                    this.a.startActivityForResult(prepare, 25069);
                    return;
                }
                kdb kdbVar2 = this.c;
                if (kdbVar2 != null) {
                    kdbVar2.a();
                    return;
                }
                return;
            }
            Activity activity = this.b;
            if (activity != null) {
                Intent prepare2 = VpnService.prepare(activity);
                if (prepare2 != null) {
                    this.b.startActivityForResult(prepare2, 25069);
                    return;
                }
                kdb kdbVar3 = this.c;
                if (kdbVar3 != null) {
                    kdbVar3.a();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Can not request VPN permission because no Fragment or Activity, please use static function with()");
        }
    }
}
