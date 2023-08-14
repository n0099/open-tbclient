package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class ktb {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926032, "Lcom/baidu/tieba/ktb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926032, "Lcom/baidu/tieba/ktb;");
                return;
            }
        }
        a = Pattern.compile("[^0-9]");
    }

    public static void a(Context context) {
        ApplicationExitInfo next;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && Build.VERSION.SDK_INT > 29) {
            Iterator<ApplicationExitInfo> it = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(context.getPackageName(), 0, 3).iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                etb.d("CrashReportUtil", next.toString());
                try {
                    f(next.getTraceInputStream());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void f(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, inputStream) != null) || inputStream == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    etb.d("CrashReportUtil", byteArrayOutputStream.toString(StandardCharsets.UTF_8.name()));
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            etb.b("CrashReportUtil", th.getMessage());
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ls /proc/self/fd -al").getInputStream()), 1024);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                etb.d("CrashReportUtil", e.getMessage());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                for (File file : new File("/proc/self/task").listFiles()) {
                    if (file.isDirectory()) {
                        File file2 = new File(file.getAbsolutePath() + File.separator + "comm");
                        if (file2.isFile() && file2.exists()) {
                            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file2));
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            sb.append(file.getName());
                            sb.append("---");
                            while (true) {
                                int read = bufferedReader.read();
                                if (read <= 0) {
                                    break;
                                }
                                sb.append((char) read);
                            }
                            inputStreamReader.close();
                            bufferedReader.close();
                        }
                        file2.delete();
                    }
                }
            } catch (Exception e) {
                etb.d("CrashReportUtil", e.getMessage());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Exception e;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                i = 0;
                for (File file : new File("/proc/self/task").listFiles()) {
                    try {
                        if (file.isDirectory()) {
                            i++;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        etb.d("CrashReportUtil", e.getMessage());
                        return i;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                i = 0;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long j = -1;
            try {
                FileInputStream fileInputStream = new FileInputStream("/proc/" + Process.myPid() + "/status");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String lowerCase = readLine.toLowerCase();
                    if (lowerCase.contains("vmsize")) {
                        j = Integer.parseInt(a.matcher(lowerCase).replaceAll("").trim());
                        break;
                    }
                }
                fileInputStream.close();
                bufferedReader.close();
            } catch (Exception unused) {
                Log.e("CrashReportUtil", "read current status failed.");
            }
            return j;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x010a: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:67:0x010a */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x010b: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:67:0x010a */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe A[Catch: Exception -> 0x0076, TRY_ENTER, TryCatch #9 {Exception -> 0x0076, blocks: (B:60:0x00fe, B:62:0x0103, B:20:0x0072, B:24:0x007a), top: B:80:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0103 A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #9 {Exception -> 0x0076, blocks: (B:60:0x00fe, B:62:0x0103, B:20:0x0072, B:24:0x007a), top: B:80:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0116 A[Catch: Exception -> 0x0112, TRY_LEAVE, TryCatch #10 {Exception -> 0x0112, blocks: (B:69:0x010e, B:73:0x0116), top: B:86:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(String str) {
        FileChannel fileChannel;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        FileChannel fileChannel2;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            FileChannel fileChannel3 = null;
            BufferedReader bufferedReader3 = null;
            r3 = null;
            r3 = null;
            BufferedReader bufferedReader4 = null;
            fileChannel3 = null;
            try {
                try {
                    try {
                        try {
                            FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                            if (channel != null) {
                                try {
                                    InputStreamReader inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("showmap " + Process.myPid()).getInputStream());
                                    BufferedReader bufferedReader5 = new BufferedReader(inputStreamReader, 1024);
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader5.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            channel.write(ByteBuffer.wrap(readLine.getBytes()));
                                            channel.write(ByteBuffer.wrap("\n".getBytes()));
                                        } catch (Exception e) {
                                            e = e;
                                            etb.b("CrashReportUtil", e.getMessage());
                                            try {
                                                file = new File("/proc/self/smaps");
                                                fileChannel2 = new RandomAccessFile(str, "rw").getChannel();
                                                try {
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    bufferedReader2 = null;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    bufferedReader2 = null;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                bufferedReader2 = null;
                                            }
                                            if (file.isFile() && file.exists() && fileChannel2 != null) {
                                                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(file));
                                                bufferedReader2 = new BufferedReader(inputStreamReader2);
                                                while (true) {
                                                    try {
                                                        String readLine2 = bufferedReader2.readLine();
                                                        if (readLine2 == null) {
                                                            break;
                                                        }
                                                        fileChannel2.write(ByteBuffer.wrap(readLine2.getBytes()));
                                                        fileChannel2.write(ByteBuffer.wrap("\n".getBytes()));
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        fileChannel3 = fileChannel2;
                                                        try {
                                                            etb.b("CrashReportUtil", e.getMessage());
                                                            fileChannel2 = fileChannel3;
                                                            bufferedReader4 = bufferedReader2;
                                                            if (fileChannel2 != null) {
                                                            }
                                                            if (bufferedReader4 == null) {
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            if (fileChannel3 != null) {
                                                                try {
                                                                    fileChannel3.close();
                                                                } catch (Exception e5) {
                                                                    etb.b("CrashReportUtil", e5.getMessage());
                                                                    throw th;
                                                                }
                                                            }
                                                            if (bufferedReader2 != null) {
                                                                bufferedReader2.close();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        fileChannel3 = fileChannel2;
                                                        th = th;
                                                        if (fileChannel3 != null) {
                                                        }
                                                        if (bufferedReader2 != null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                inputStreamReader2.close();
                                                bufferedReader4 = bufferedReader2;
                                            }
                                            if (fileChannel2 != null) {
                                                fileChannel2.close();
                                            }
                                            if (bufferedReader4 == null) {
                                                bufferedReader4.close();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    inputStreamReader.close();
                                    bufferedReader3 = bufferedReader5;
                                } catch (Exception e6) {
                                    e = e6;
                                } catch (Throwable th4) {
                                    th = th4;
                                    bufferedReader2 = null;
                                    fileChannel3 = channel;
                                    if (fileChannel3 != null) {
                                    }
                                    if (bufferedReader2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                        } catch (Exception e7) {
                            e = e7;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader2 = null;
                    }
                } catch (Exception e8) {
                    etb.b("CrashReportUtil", e8.getMessage());
                }
            } catch (Throwable th6) {
                th = th6;
                fileChannel3 = fileChannel;
                bufferedReader2 = bufferedReader;
            }
        }
    }
}
