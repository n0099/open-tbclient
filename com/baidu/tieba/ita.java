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
/* loaded from: classes6.dex */
public class ita {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment a;
    public Activity b;
    public hta c;

    public ita() {
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

    public static ita c(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragment)) == null) {
            ita itaVar = new ita();
            itaVar.a = fragment;
            return itaVar;
        }
        return (ita) invokeL.objValue;
    }

    public void a(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, intent) != null) || i != 25069) {
            return;
        }
        if (i2 == -1) {
            hta htaVar = this.c;
            if (htaVar != null) {
                htaVar.a();
                return;
            }
            return;
        }
        hta htaVar2 = this.c;
        if (htaVar2 != null) {
            htaVar2.b();
        }
    }

    public void b(hta htaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, htaVar) == null) {
            this.c = htaVar;
            Fragment fragment = this.a;
            if (fragment != null) {
                Intent prepare = VpnService.prepare(fragment.getContext());
                if (prepare != null) {
                    this.a.startActivityForResult(prepare, 25069);
                    return;
                }
                hta htaVar2 = this.c;
                if (htaVar2 != null) {
                    htaVar2.a();
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
                hta htaVar3 = this.c;
                if (htaVar3 != null) {
                    htaVar3.a();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Can not request VPN permission because no Fragment or Activity, please use static function with()");
        }
    }
}
