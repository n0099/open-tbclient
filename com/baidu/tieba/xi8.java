package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yi8;
import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class xi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yi8 a;
    public String b;
    public boolean c;
    public Context d;
    public yi8.a e;

    /* loaded from: classes6.dex */
    public class a implements yi8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi8 a;

        public a(xi8 xi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi8Var;
        }

        @Override // com.baidu.tieba.yi8.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.c) {
                return;
            }
            this.a.c = false;
        }
    }

    public xi8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = false;
        this.e = new a(this);
        this.d = context;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            String b = zi8.b();
            this.b = b;
            if (TextUtils.isEmpty(b)) {
                this.b = zi8.c();
            } else if (!this.b.endsWith(File.separator)) {
                this.b += File.separator;
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String c = c();
            if (TextUtils.isEmpty(c)) {
                return;
            }
            h();
            if (zi8.e(c) && f(c, TitanConstant.KEY_INSTANT_INIT_CLASS, true)) {
                this.c = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.baidu.tieba.yi8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.yi8, com.baidu.tieba.yi8$a] */
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            yi8 yi8Var = this.a;
            if (yi8Var != null) {
                try {
                    try {
                        yi8Var.c();
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                } finally {
                    this.a.b(null);
                    this.a = null;
                }
            }
            this.c = false;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h();
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            File file = new File(str);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    BdLog.d("folder mkdir success: " + str);
                } else if (!file.exists()) {
                    BdLog.d("folder mkdir failed");
                }
            }
            if (file.isDirectory()) {
                return;
            }
            throw new IllegalArgumentException("The logcat folder path is not a directory: " + str);
        }
    }

    public final boolean f(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, str, str2, z)) == null) {
            if (this.a != null) {
                return true;
            }
            e(str);
            yi8 yi8Var = new yi8(str, str2, z);
            this.a = yi8Var;
            yi8Var.b(this.e);
            try {
                this.a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e) {
                this.a = null;
                BdLog.e(e);
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
