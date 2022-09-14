package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.tieba.he2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class ne2<T extends he2> extends jd2<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }

        public static a a(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
                a aVar = new a();
                aVar.a = i;
                aVar.b = str;
                return aVar;
            }
            return (a) invokeIL.objValue;
        }

        public static a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(1, str) : (a) invokeL.objValue;
        }

        public static a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(0, "") : (a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a == 0 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.a + ", message='" + this.b + "'}";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947999502, "Lcom/baidu/tieba/ne2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947999502, "Lcom/baidu/tieba/ne2;");
                return;
            }
        }
        b = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne2(@NonNull T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((he2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.jd2
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(super.a(), "remote") : (File) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k("0");
            j(0L);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        cj4.k(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/tieba/ee2;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull ee2 ee2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ee2Var)) == null) {
            if (b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote");
            }
            if (TextUtils.isEmpty(ee2Var.c)) {
                if (b) {
                    Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
                }
                return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
            }
            a i = i(ee2Var);
            if (b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i);
            }
            d(ee2Var.c);
            if (i.c()) {
                return null;
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by " + i.toString());
        }
        return (Exception) invokeL.objValue;
    }

    @NonNull
    public ExtensionCore f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long g = g();
            extensionCore.extensionCoreVersionCode = g;
            extensionCore.extensionCoreVersionName = h();
            extensionCore.extensionCorePath = b(g).getPath();
            extensionCore.extensionCoreType = 1;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? mb3.a().getLong(this.a.b(), 0L) : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? mb3.a().getString(this.a.e(), "0") : (String) invokeV.objValue;
    }

    public final a i(@NonNull ee2 ee2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ee2Var)) == null) {
            if (b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + ee2Var.a + " ,filePath: " + ee2Var.c + " ,sign:" + ee2Var.d);
            }
            long j = ee2Var.b;
            if (j == 0) {
                return a.b("invalid version code : " + ee2Var.a);
            } else if (!lg3.a(new File(ee2Var.c), ee2Var.d)) {
                return a.b("sign failed.");
            } else {
                if (!cj4.U(ee2Var.c, b(j).getPath())) {
                    return a.b("unzip bundle failed.");
                }
                pe2.b(a(), g(), j);
                j(j);
                k(ee2Var.a);
                if (b) {
                    Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
                }
                return a.d();
            }
        }
        return (a) invokeL.objValue;
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            mb3.a().putLong(this.a.b(), j);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            mb3.a().putString(this.a.e(), str);
        }
    }
}
