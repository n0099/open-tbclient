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
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
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
/* loaded from: classes7.dex */
public class mw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public cw b;

    /* loaded from: classes7.dex */
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
                        kw.c(e);
                        return false;
                    }
                }
                return true;
            }
            return invokeLI.booleanValue;
        }
    }

    public mw(Context context, cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cwVar};
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
        this.b = cwVar;
    }

    public static void g(String str, String str2) {
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
            byte[] a2 = nv.a();
            fileWriter.write(dw.a(jv.c(a2, a2, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void l(String str) {
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

    public final lw a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            List<bw> h = this.b.h(context);
            lw lwVar = null;
            if (h != null) {
                String str = NetDiskFileMsg.JSON_KEY_FILES;
                File filesDir = context.getFilesDir();
                if (!NetDiskFileMsg.JSON_KEY_FILES.equals(filesDir.getName())) {
                    Log.e("CuidV266Manager", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str = filesDir.getName();
                }
                for (bw bwVar : h) {
                    if (!bwVar.d) {
                        File file = new File(new File(bwVar.a.dataDir, str), "libcuid.so");
                        if (file.exists() && (lwVar = lw.e(kw.a(file))) != null) {
                            break;
                        }
                    }
                }
            }
            return lwVar;
        }
        return (lw) invokeL.objValue;
    }

    public lw b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            lw a2 = a(this.a);
            if (a2 == null) {
                a2 = lw.e(k("com.baidu.deviceid.v2"));
            }
            boolean j = j(com.kuaishou.weapon.p0.g.i);
            if (a2 == null && j) {
                a2 = f();
            }
            if (a2 == null) {
                a2 = i();
            }
            boolean z = false;
            if (a2 == null && j) {
                z = true;
                a2 = n(m(""));
            }
            if (!z) {
                m("");
            }
            if (a2 != null) {
                a2.k();
            }
            return a2;
        }
        return (lw) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r0 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(lw lwVar) {
        boolean d;
        boolean j;
        lw n;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lwVar) == null) {
            File file = new File(this.a.getFilesDir(), "libcuid.so");
            String h = lwVar.h();
            if (file.exists()) {
                lw e = lw.e(kw.a(file));
                if (e != null) {
                    if (e.k()) {
                        h(e.h());
                    }
                }
                d = d();
                if (d) {
                    String k = k("com.baidu.deviceid.v2");
                    if (!TextUtils.isEmpty(k)) {
                        lw e2 = lw.e(k);
                        if (e2 != null) {
                            if (e2.k()) {
                                e("com.baidu.deviceid.v2", e2.h());
                            }
                        }
                    }
                    e("com.baidu.deviceid.v2", h);
                }
                j = j("android.permission.WRITE_EXTERNAL_STORAGE");
                if (j) {
                    if (new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2").exists()) {
                        lw f = f();
                        if (f != null) {
                            if (f.k()) {
                                h = f.h();
                            }
                        }
                    }
                    l(h);
                }
                if (d) {
                    String k2 = k("bd_setting_i");
                    if (lw.c(TextUtils.isEmpty(k2) ? 0 : k2.length())) {
                        str = "O";
                    } else {
                        str = lw.d(k2) ? "0" : "0";
                    }
                    e("bd_setting_i", str);
                }
                if (j || !new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid").exists() || (n = n(m(""))) == null || !n.k()) {
                    return;
                }
                g(n.b, n.a);
                return;
            }
            h(h);
            d = d();
            if (d) {
            }
            j = j("android.permission.WRITE_EXTERNAL_STORAGE");
            if (j) {
            }
            if (d) {
            }
            if (j) {
            }
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? j("android.permission.WRITE_SETTINGS") : invokeV.booleanValue;
    }

    public final boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return Settings.System.putString(this.a.getContentResolver(), str, str2);
            } catch (Exception e) {
                kw.c(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final lw f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (file.exists()) {
                return lw.e(kw.a(file));
            }
            return null;
        }
        return (lw) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    public final boolean h(String str) {
        InterceptResult invokeL;
        int i;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
                            kw.c(e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (i2 == 0 && DeviceId.sDataCuidInfoShable) {
                            i = RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR;
                            file = new File(this.a.getFilesDir(), "libcuid.so");
                        } else if (!DeviceId.sDataCuidInfoShable) {
                            i = 432;
                            file = new File(this.a.getFilesDir(), "libcuid.so");
                        }
                        return a.a(file.getAbsolutePath(), i);
                    }
                    return true;
                } catch (Exception e2) {
                    kw.c(e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            kw.c(e3);
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        kw.c(e4);
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public final lw i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? lw.a(k("com.baidu.deviceid"), k("bd_setting_i")) : (lw) invokeV.objValue;
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0 : invokeL.booleanValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return ApiReplaceUtil.getString(this.a.getContentResolver(), str);
            } catch (Exception e) {
                kw.c(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? "0" : (String) invokeL.objValue;
    }

    public final lw n(String str) {
        InterceptResult invokeL;
        String str2;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
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
                byte[] a2 = nv.a();
                split = new String(jv.d(a2, a2, dw.b(sb.toString().getBytes()))).split("=");
            } catch (FileNotFoundException | IOException | Exception unused) {
            }
            if (split != null && split.length == 2) {
                str2 = split[0];
                try {
                    str3 = split[1];
                } catch (FileNotFoundException | IOException | Exception unused2) {
                }
                return lw.a(str3, str2);
            }
            str2 = "";
            return lw.a(str3, str2);
        }
        return (lw) invokeL.objValue;
    }
}
