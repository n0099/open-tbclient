package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.uu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class om2 {
    public static /* synthetic */ Interceptable $ic;
    public static final File a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements uu2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        @Override // com.baidu.tieba.uu2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.uu2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y82.k("DebugDynamicLibControl", "debug动态库下载失败 url=" + this.c);
                if (this.a != null && !TextUtils.isEmpty(this.b)) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                }
            }
        }

        @Override // com.baidu.tieba.uu2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a != null && !TextUtils.isEmpty(this.b)) {
                    File j = om2.j();
                    y82.k("DebugDynamicLibControl", "debug动态库下载成功 file=" + j.getAbsolutePath());
                    Pair g = om2.g(j);
                    if (!((Boolean) g.first).booleanValue()) {
                        y82.k("DebugDynamicLibControl", "debug动态库解密失败 file=" + j.getAbsolutePath());
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解密失败").toString());
                        return;
                    } else if (((Boolean) om2.s((File) g.second).first).booleanValue()) {
                        om2.r(true);
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                        return;
                    } else {
                        y82.k("DebugDynamicLibControl", "debug动态库解压失败 file=" + j.getAbsolutePath());
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "debug动态库解压失败").toString());
                        return;
                    }
                }
                y82.k("DebugDynamicLibControl", "debug动态库下载成功，但是 handler=" + this.a + " cb=" + this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948036981, "Lcom/baidu/tieba/om2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948036981, "Lcom/baidu/tieba/om2;");
                return;
            }
        }
        a = uu2.q();
        b = "rMzurs3ur83vsM7vss/vtNHwt9LwuNPx".getBytes(StandardCharsets.UTF_8);
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            r(false);
            e();
        }
    }

    public static File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return new File(qw2.d().get(0).a, "debugDynamicLib.zip");
        }
        return (File) invokeV.objValue;
    }

    public static File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new File(qw2.d().get(0).a, "aiapps_debug_dynamic_lib");
        }
        return (File) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return mk3.a().getBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", false);
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return l();
        }
        return invokeV.booleanValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            r(true);
        }
    }

    public static void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            mk3.a().putBoolean("KEY_SWAN_APP_DEBUG_DYNAMIC_LIB_MODE", z);
        }
    }

    public static File d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return new File(a.getAbsolutePath() + File.separator + str + File.separator + "debug_dynamic");
        }
        return (File) invokeL.objValue;
    }

    public static Pair<Boolean, File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            File d = d(str);
            if (d.exists() && d.isDirectory()) {
                return new Pair<>(Boolean.TRUE, d);
            }
            return new Pair<>(Boolean.FALSE, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            cs4.j(j());
            cs4.j(k());
            for (File file : n()) {
                cs4.j(file);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static Pair<Boolean, File> g(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file != null && file.exists()) {
                File file2 = new File(file.getAbsolutePath() + ".zip");
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[16];
                        fileInputStream.skip(10L);
                        fileInputStream.read(bArr, 0, 10);
                        fileInputStream.skip(5L);
                        fileInputStream.read(bArr, 10, 6);
                        fileInputStream.skip(3L);
                        byte[] bArr2 = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr2);
                        file2.deleteOnExit();
                        file2.createNewFile();
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(b, "AES");
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(2, secretKeySpec, ivParameterSpec);
                        fileOutputStream.write(cipher.doFinal(bArr2));
                        fileOutputStream.flush();
                        Pair<Boolean, File> pair = new Pair<>(Boolean.TRUE, file2);
                        fileOutputStream.close();
                        fileInputStream.close();
                        return pair;
                    } finally {
                    }
                } catch (Exception e) {
                    y82.l("DebugDynamicLibControl", "debug动态库解密失败: ", e);
                    return new Pair<>(Boolean.FALSE, null);
                }
            } else {
                return new Pair<>(Boolean.FALSE, null);
            }
        } else {
            return (Pair) invokeL.objValue;
        }
    }

    public static synchronized void h(@NonNull String str, @Nullable CallbackHandler callbackHandler, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, callbackHandler, str2) == null) {
            synchronized (om2.class) {
                if (TextUtils.isEmpty(str)) {
                    y82.k("DebugDynamicLibControl", "download url is empty");
                } else {
                    uu2.H(str, new a(callbackHandler, str2, str));
                }
            }
        }
    }

    public static List<File> n() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : cs4.C(a)) {
                if (file.isDirectory()) {
                    File[] C2 = cs4.C(file);
                    int length = C2.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            File file2 = C2[i];
                            if (file2.isDirectory() && "debug_dynamic".equals(file2.getName())) {
                                arrayList.add(file2);
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public static List<String> o() {
        InterceptResult invokeV;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (File file : cs4.C(a)) {
                if (file.isDirectory()) {
                    File[] C2 = cs4.C(file);
                    int length = C2.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            File file2 = C2[i];
                            if (file2.isDirectory() && "debug_dynamic".equals(file2.getName())) {
                                arrayList.add(file.getName());
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static String q(File file) throws Exception {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 1 && listFiles[0].isDirectory()) {
                cs4.e(listFiles[0], file);
                cs4.j(listFiles[0]);
            }
            return (String) new JSONObject(cs4.E(new File(file, "dynamicLib.json"))).get("name");
        }
        return (String) invokeL.objValue;
    }

    public static Pair<Boolean, String> s(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, file)) == null) {
            String str = "";
            boolean z = false;
            try {
                File k = k();
                cs4.l(k);
                if (file.exists() && cs4.U(file.getAbsolutePath(), k.getAbsolutePath())) {
                    str = q(k);
                    File d = d(str);
                    if (d.exists()) {
                        cs4.j(d);
                    }
                    d.mkdirs();
                    cs4.e(k, d);
                    cs4.j(k);
                    cs4.j(file);
                    z = true;
                }
            } catch (Exception e) {
                y82.k("DebugDynamicLibControl", "debug动态库解压异常: " + e.toString());
            }
            y82.k("DebugDynamicLibControl", "debug动态库解压结果: unzipSuccess=" + z + " dynamicLibName=" + str);
            return new Pair<>(Boolean.valueOf(z), str);
        }
        return (Pair) invokeL.objValue;
    }
}
