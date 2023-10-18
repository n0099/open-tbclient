package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes7.dex */
public class pv3 implements x24 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "hasDownloadApk";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948075452, "Lcom/baidu/tieba/pv3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948075452, "Lcom/baidu/tieba/pv3;");
        }
    }

    public pv3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "com.baidu.gamenow";
    }

    @Override // com.baidu.tieba.x24
    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof Download)) {
                return false;
            }
            Download download = (Download) obj;
            if (TextUtils.equals(tv3.a, download.getKeyByUser())) {
                return true;
            }
            return TextUtils.isEmpty(pi3.d(download.getFromParam()).optString("apk_id"));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.x24
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) != null) || !(obj instanceof Download)) {
            return;
        }
        xv3 xv3Var = new xv3((Download) obj);
        lw3.n().f("reallyDownloaded", new kw3(), xv3Var.m(), xv3Var.j(), xv3Var.l());
    }

    @Override // com.baidu.tieba.x24
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) != null) || !(obj instanceof Download)) {
            return;
        }
        Download download = (Download) obj;
        xv3 xv3Var = new xv3(download);
        lw3.n().f("statusInstalled", new kw3(), download.getKeyByUser(), xv3Var.j(), xv3Var.l());
        if (TextUtils.equals(xv3Var.m(), this.a)) {
            de3.a().putBoolean(b, true);
            lw3.n().p(13, xv3Var.m(), xv3Var.h(), xv3Var.l());
        }
    }
}
