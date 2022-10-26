package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p99 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948017017, "Lcom/baidu/tieba/p99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948017017, "Lcom/baidu/tieba/p99;");
                return;
            }
        }
        b = pa9.m();
    }

    public p99(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void h(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            if (b) {
                exc.printStackTrace();
            }
            ra9.a().h(Log.getStackTraceString(exc));
        }
    }

    public final boolean a(za9 za9Var) {
        InterceptResult invokeL;
        File[] listFiles;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, za9Var)) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "ubcdir", "proc");
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    BufferedReader bufferedReader = null;
                    try {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                            long j = Long.MAX_VALUE;
                            int i = 0;
                            long j2 = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                    if (jSONObject.has("abtest")) {
                                        za9Var.K("1");
                                    }
                                    long j3 = jSONObject.getLong("timestamp");
                                    if (j3 > 0) {
                                        if (j3 < j) {
                                            j = j3;
                                        }
                                        if (j3 > j2) {
                                            j2 = j3;
                                        }
                                    }
                                    if (b) {
                                        Log.d("UBCFileData", jSONObject.toString());
                                    }
                                    za9Var.b(jSONObject);
                                    i++;
                                    if (i >= 10) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    bufferedReader = bufferedReader2;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                            za9Var.J(j, j2);
                            if (b) {
                                Log.d("UBCFileData", "line num " + i + " delete file ");
                            }
                            try {
                                bufferedReader2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
        if (r5.exists() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
        r5.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c8, code lost:
        if (r5.exists() != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(za9 za9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, za9Var)) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            boolean z = false;
            if (!file2.exists()) {
                return false;
            }
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                    long j = Long.MAX_VALUE;
                    long j2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                za9Var.K("1");
                            }
                            long j3 = jSONObject.getLong("timestamp");
                            if (j3 > 0) {
                                if (j3 < j) {
                                    j = j3;
                                }
                                if (j3 > j2) {
                                    j2 = j3;
                                }
                            }
                            za9Var.b(jSONObject);
                            z = true;
                        } catch (Exception e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            if (b) {
                                Log.d("UBCFileData", "getExceptionList read fail:", e);
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    if (b) {
                                        Log.d("UBCFileData", "getExceptionList close fail:", e2);
                                    }
                                }
                            }
                            if (z) {
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            Throwable th2 = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e3) {
                                    if (b) {
                                        Log.d("UBCFileData", "getExceptionList close fail:", e3);
                                    }
                                }
                            }
                            if (z && file2.exists()) {
                                file2.delete();
                            }
                            throw th2;
                        }
                    }
                    za9Var.J(j, j2);
                    try {
                        bufferedReader2.close();
                    } catch (Exception e4) {
                        if (b) {
                            Log.d("UBCFileData", "getExceptionList close fail:", e4);
                        }
                    }
                    if (z) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final File b(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(file, "proc");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                return new File(file2, str);
            }
            if (z) {
                str2 = "filereal";
            } else {
                str2 = "filedata";
            }
            return new File(file, str2);
        }
        return (File) invokeLZ.objValue;
    }

    public void c(boolean z) {
        String str;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                return;
            }
            if (z) {
                str = "filereal";
            } else {
                str = "filedata";
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(file, "proc");
            if (file3.exists() && file3.isDirectory() && (listFiles = file3.listFiles()) != null && listFiles.length != 0) {
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public void d(ba9 ba9Var, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, ba9Var, file) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", ba9Var.l());
                jSONObject.put("timestamp", ba9Var.p());
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(ba9Var.f())) {
                    jSONObject.put("content", ba9Var.f());
                } else if (ba9Var.m() != null) {
                    jSONObject.put("content", ba9Var.m().toString());
                }
                if (!TextUtils.isEmpty(ba9Var.h())) {
                    jSONObject.put("abtest", ba9Var.h());
                }
                if (!TextUtils.isEmpty(ba9Var.e())) {
                    jSONObject.put("c", ba9Var.e());
                }
                if (ba9Var.q()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, u99.o().z(ba9Var.l()));
                JSONObject d = ba9Var.d();
                if (d != null) {
                    jSONObject.put("bizInfo", d);
                }
            } catch (JSONException e) {
                if (b) {
                    Log.d("UBCFileData", e.getMessage());
                }
            }
            if (b) {
                Log.d("UBCFileData", "saveEvent:" + jSONObject.toString());
            }
            byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(encode);
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    la9.f().a(ba9Var.l(), false);
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        la9.f().a(ba9Var.l(), false);
                    }
                }
                la9.f().a(ba9Var.l(), false);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                la9.f().a(ba9Var.l(), false);
                throw th;
            }
            la9.f().a(ba9Var.l(), false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (com.baidu.tieba.p99.b == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        android.util.Log.d("UBCFileData", "getExceptionList close fail:", r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0099, code lost:
        if (com.baidu.tieba.p99.b == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(za9 za9Var, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, za9Var, z)) == null) {
            if (!z) {
                z2 = a(za9Var);
            } else {
                z2 = false;
            }
            File b2 = b("", z);
            if (b2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(b2));
                        long j = Long.MAX_VALUE;
                        long j2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    za9Var.K("1");
                                }
                                long j3 = jSONObject.getLong("timestamp");
                                if (j3 > 0) {
                                    if (j3 < j) {
                                        j = j3;
                                    }
                                    if (j3 > j2) {
                                        j2 = j3;
                                    }
                                }
                                za9Var.b(jSONObject);
                                z2 = true;
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                if (b) {
                                    Log.d("UBCFileData", "getExceptionList read fail:", e);
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                }
                                return z2;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        if (b) {
                                            Log.d("UBCFileData", "getExceptionList close fail:", e3);
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        za9Var.J(j, j2);
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    public void g(ba9 ba9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, ba9Var, z) == null) {
            d(ba9Var, b(ba9Var.i(), z));
        }
    }

    public void i(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ba9Var) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            if (file2.length() > u99.o().p()) {
                if (!file2.delete()) {
                    return;
                }
                file2 = new File(file, "filequality");
            }
            d(ba9Var, file2);
        }
    }
}
