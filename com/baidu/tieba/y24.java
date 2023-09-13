package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public Download a;
    public JSONObject b;
    public d c;
    public a34 d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g24.n().t(this.b);
                g24.n().l(this.a);
                g24.n().k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Download a;
        public JSONObject b;
        public z24 c;

        public c(@NonNull Download download, JSONObject jSONObject, @NonNull z24 z24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {download, jSONObject, z24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = download;
            this.b = jSONObject;
            this.c = z24Var;
        }

        public /* synthetic */ c(Download download, JSONObject jSONObject, z24 z24Var, a aVar) {
            this(download, jSONObject, z24Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g24.n().G(this.b);
                i34.a(this.a.getKeyByUser(), "installApp", null, null, new g34(this.b));
                g24.n().r(AppRuntime.getAppContext(), this.a.getUrl(), this.a.getKeyByUser(), this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements z24 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ y24 c;

        public d(y24 y24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y24Var;
        }

        @Override // com.baidu.tieba.z24
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b = str;
            }
        }

        @Override // com.baidu.tieba.z24
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        @Override // com.baidu.tieba.a34
        public void a(c34 c34Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c34Var) == null) {
                if (y24.e) {
                    Log.d("InstallAppLocal", "onResult mPackageName:" + this.a);
                }
                this.c.setResult(c34Var);
                j24.d.execute(new b(this.b, this.a, null));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278254, "Lcom/baidu/tieba/y24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278254, "Lcom/baidu/tieba/y24;");
                return;
            }
        }
        e = rr1.a;
    }

    public y24(Download download, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = download;
        this.b = jSONObject;
        this.c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c34 c34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, c34Var) == null) {
            a34 a34Var = this.d;
            if (a34Var != null) {
                a34Var.a(c34Var);
            }
            if (c34Var != null && !c34Var.d()) {
                i34.a(this.a.getKeyByUser(), "installApp", "fail", String.valueOf(c34Var.c()), new g34(this.b));
            }
            if (this.c != null) {
                g24.n().B(this.a.getKeyByUser(), this.c);
                this.c = null;
            }
        }
    }

    public void c(a34 a34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a34Var) == null) {
            this.d = a34Var;
            j24.d.execute(new c(this.a, this.b, this.c, null));
        }
    }
}
