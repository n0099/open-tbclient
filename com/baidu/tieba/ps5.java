package com.baidu.tieba;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.stats.ZygoteSpeedStats;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public final class ps5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;

    public ps5() {
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
        this.a = -1L;
        this.b = -1L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = SystemClock.elapsedRealtime();
            Process.getElapsedCpuTime();
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == -1) {
                b();
            }
            return this.b;
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00b5: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:44:0x00b5 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        BufferedReader bufferedReader;
        NumberFormatException e;
        IOException e2;
        FileNotFoundException e3;
        Closeable closeable;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ns5.a().c();
            Closeable closeable2 = null;
            long j2 = -1;
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                    try {
                        String[] split = bufferedReader.readLine().split(" ");
                        if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
                            String str = split[21];
                            try {
                                SoLoader.load(AppRuntime.getAppContext(), "launch_native");
                                j = LaunchNativeUtils.getClkTck();
                            } catch (UnsatisfiedLinkError e4) {
                                Log.e(ZygoteSpeedStats.TAG, "load so failed, UnsatisfiedLinkError", e4);
                                j = 0;
                            }
                            Log.d(ZygoteSpeedStats.TAG, "_SC_CLK_TCK " + j);
                            if (j <= 0) {
                                j = 100;
                            }
                            j2 = (Long.parseLong(str) * 1000) / j;
                        }
                    } catch (FileNotFoundException e5) {
                        e3 = e5;
                        Log.e(ZygoteSpeedStats.TAG, "can't read process status file", e3);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        Log.e(ZygoteSpeedStats.TAG, "read process status failed", e2);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    } catch (NumberFormatException e7) {
                        e = e7;
                        Log.e(ZygoteSpeedStats.TAG, "parse status file failed", e);
                        Closeables.closeSafely(bufferedReader);
                        if (j2 <= 0) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    Closeables.closeSafely(closeable2);
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                bufferedReader = null;
                e3 = e8;
            } catch (IOException e9) {
                bufferedReader = null;
                e2 = e9;
            } catch (NumberFormatException e10) {
                bufferedReader = null;
                e = e10;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(closeable2);
                throw th;
            }
            Closeables.closeSafely(bufferedReader);
            if (j2 <= 0) {
                this.b = this.a - j2;
            }
        }
    }
}
