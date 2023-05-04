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
public class xx3 implements f54 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "hasDownloadApk";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948315702, "Lcom/baidu/tieba/xx3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948315702, "Lcom/baidu/tieba/xx3;");
        }
    }

    public xx3() {
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

    @Override // com.baidu.tieba.f54
    public boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof Download)) {
                return false;
            }
            Download download = (Download) obj;
            if (TextUtils.equals(by3.a, download.getKeyByUser())) {
                return true;
            }
            return TextUtils.isEmpty(xk3.d(download.getFromParam()).optString("apk_id"));
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.f54
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) != null) || !(obj instanceof Download)) {
            return;
        }
        fy3 fy3Var = new fy3((Download) obj);
        ty3.n().f("reallyDownloaded", new sy3(), fy3Var.m(), fy3Var.j(), fy3Var.l());
    }

    @Override // com.baidu.tieba.f54
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) != null) || !(obj instanceof Download)) {
            return;
        }
        Download download = (Download) obj;
        fy3 fy3Var = new fy3(download);
        ty3.n().f("statusInstalled", new sy3(), download.getKeyByUser(), fy3Var.j(), fy3Var.l());
        if (TextUtils.equals(fy3Var.m(), this.a)) {
            lg3.a().putBoolean(b, true);
            ty3.n().p(13, fy3Var.m(), fy3Var.h(), fy3Var.l());
        }
    }
}
