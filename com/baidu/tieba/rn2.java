package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.tieba.ln2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class rn2<T extends ln2> extends nm2<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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

        public static a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return a(0, "");
            }
            return (a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return a(1, str);
            }
            return (a) invokeL.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127315, "Lcom/baidu/tieba/rn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127315, "Lcom/baidu/tieba/rn2;");
                return;
            }
        }
        b = ms1.a;
    }

    @Override // com.baidu.tieba.nm2
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new File(super.a(), "remote");
        }
        return (File) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k("0");
            j(0L);
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return qk3.a().getLong(this.a.b(), 0L);
        }
        return invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return qk3.a().getString(this.a.e(), "0");
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rn2(@NonNull T t) {
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
                super((ln2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        gs4.k(str);
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            qk3.a().putLong(this.a.b(), j);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            qk3.a().putString(this.a.e(), str);
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/baidu/tieba/in2;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull in2 in2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, in2Var)) == null) {
            if (b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote");
            }
            if (TextUtils.isEmpty(in2Var.c)) {
                if (b) {
                    Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
                }
                return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
            }
            a i = i(in2Var);
            if (b) {
                Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i);
            }
            d(in2Var.c);
            if (i.c()) {
                return null;
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by " + i.toString());
        }
        return (Exception) invokeL.objValue;
    }

    public final a i(@NonNull in2 in2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, in2Var)) == null) {
            if (b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + in2Var.a + " ,filePath: " + in2Var.c + " ,sign:" + in2Var.d);
            }
            long j = in2Var.b;
            if (j == 0) {
                return a.b("invalid version code : " + in2Var.a);
            } else if (!pp3.a(new File(in2Var.c), in2Var.d)) {
                return a.b("sign failed.");
            } else {
                if (!gs4.U(in2Var.c, b(j).getPath())) {
                    return a.b("unzip bundle failed.");
                }
                tn2.b(a(), g(), j);
                j(j);
                k(in2Var.a);
                if (b) {
                    Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
                }
                return a.d();
            }
        }
        return (a) invokeL.objValue;
    }
}
