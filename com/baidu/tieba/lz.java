package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public class lz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public iz b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Os.chmod(str, i);
                        return true;
                    } catch (Exception e) {
                        z00.c(e);
                        return false;
                    }
                }
                return true;
            }
            return invokeLI.booleanValue;
        }
    }

    public lz(Context context, iz izVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, izVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = izVar;
    }

    public static void d(String str, String str2) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            byte[] a2 = f00.a();
            fileWriter.write(t00.a(b00.d(a2, a2, (str + "=" + str2).getBytes()), IMAudioTransRequest.CHARSET));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void m(String str) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file3 = new File(file2, ".cuid2");
            try {
                if (file2.exists() && !file2.isDirectory()) {
                    Random random = new Random();
                    File parentFile = file2.getParentFile();
                    String name = file2.getName();
                    do {
                        file = new File(parentFile, name + random.nextInt() + ".tmp");
                    } while (file.exists());
                    file2.renameTo(file);
                    file.delete();
                }
                file2.mkdirs();
                FileWriter fileWriter = new FileWriter(file3, false);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    public final kz a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? kz.b(l("com.baidu.deviceid"), l("bd_setting_i")) : (kz) invokeV.objValue;
    }

    public final kz b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            List<hz> h = this.b.h(context);
            kz kzVar = null;
            if (h != null) {
                String str = "files";
                File filesDir = context.getFilesDir();
                if (!"files".equals(filesDir.getName())) {
                    Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str = filesDir.getName();
                }
                for (hz hzVar : h) {
                    if (!hzVar.d) {
                        File file = new File(new File(hzVar.a.dataDir, str), "libcuid.so");
                        if (file.exists() && (kzVar = kz.a(z00.a(file))) != null) {
                            break;
                        }
                    }
                }
            }
            return kzVar;
        }
        return (kz) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r0 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r2 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(kz kzVar) {
        boolean j;
        boolean e;
        kz k;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kzVar) == null) {
            File file = new File(this.a.getFilesDir(), "libcuid.so");
            String j2 = kzVar.j();
            if (file.exists()) {
                kz a2 = kz.a(z00.a(file));
                if (a2 != null) {
                    if (a2.c()) {
                        n(a2.j());
                    }
                }
                j = j();
                if (j) {
                    String l = l("com.baidu.deviceid.v2");
                    if (!TextUtils.isEmpty(l)) {
                        kz a3 = kz.a(l);
                        if (a3 != null) {
                            if (a3.c()) {
                                h("com.baidu.deviceid.v2", a3.j());
                            }
                        }
                    }
                    h("com.baidu.deviceid.v2", j2);
                }
                e = e("android.permission.WRITE_EXTERNAL_STORAGE");
                if (e) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        kz f = f();
                        if (f != null) {
                            if (f.c()) {
                                j2 = f.j();
                            }
                        }
                    }
                    m(j2);
                }
                if (j) {
                    String l2 = l("bd_setting_i");
                    if (kz.d(TextUtils.isEmpty(l2) ? 0 : l2.length())) {
                        str = "O";
                    } else {
                        str = kz.m(l2) ? "0" : "0";
                    }
                    h("bd_setting_i", str);
                }
                if (e || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists() || (k = k(i(""))) == null || !k.c()) {
                    return;
                }
                d(k.b, k.a);
                return;
            }
            n(j2);
            j = j();
            if (j) {
            }
            e = e("android.permission.WRITE_EXTERNAL_STORAGE");
            if (e) {
            }
            if (j) {
            }
            if (e) {
            }
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public final kz f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                return kz.a(z00.a(file));
            }
            return null;
        }
        return (kz) invokeV.objValue;
    }

    public kz g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            kz b = b(this.a);
            if (b == null) {
                b = kz.a(l("com.baidu.deviceid.v2"));
            }
            boolean e = e(com.kuaishou.weapon.p0.h.i);
            if (b == null && e) {
                b = f();
            }
            if (b == null) {
                b = a();
            }
            boolean z = false;
            if (b == null && e) {
                z = true;
                b = k(i(""));
            }
            if (!z) {
                i("");
            }
            if (b != null) {
                b.c();
            }
            return b;
        }
        return (kz) invokeL.objValue;
    }

    public final boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            try {
                return Settings.System.putString(this.a.getContentResolver(), str, str2);
            } catch (Exception e) {
                z00.c(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? e("android.permission.WRITE_SETTINGS") : invokeV.booleanValue;
    }

    public final kz k(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String str3 = "";
            File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\r\n");
                }
                bufferedReader.close();
                byte[] a2 = f00.a();
                split = new String(b00.c(a2, a2, t00.b(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return kz.b(str3, str2);
            }
            str2 = "";
            return kz.b(str3, str2);
        }
        return (kz) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                return ApiReplaceUtil.getString(this.a.getContentResolver(), str);
            } catch (Exception e) {
                z00.c(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    public final boolean n(String str) {
        InterceptResult invokeL;
        String absolutePath;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int i2 = (!DeviceId.sDataCuidInfoShable || Build.VERSION.SDK_INT >= 24) ? 0 : 1;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.a.openFileOutput("libcuid.so", i2);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            z00.c(e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (i2 == 0 && DeviceId.sDataCuidInfoShable) {
                            absolutePath = new File(this.a.getFilesDir(), "libcuid.so").getAbsolutePath();
                            i = 436;
                        } else if (!DeviceId.sDataCuidInfoShable) {
                            absolutePath = new File(this.a.getFilesDir(), "libcuid.so").getAbsolutePath();
                            i = 432;
                        }
                        return a.a(absolutePath, i);
                    }
                    return true;
                } catch (Exception e2) {
                    z00.c(e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            z00.c(e3);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        z00.c(e4);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }
}
