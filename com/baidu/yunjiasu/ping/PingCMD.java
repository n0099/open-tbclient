package com.baidu.yunjiasu.ping;

import android.os.Build;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/yunjiasu/ping/PingCMD;", "", "()V", "TAG", "", "ping", "Lcom/baidu/yunjiasu/ping/PingStatistics;", "address", "Ljava/net/InetAddress;", "runCMD", "cmd", "tornadosdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class PingCMD {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PingCMD INSTANCE;
    public static final String TAG = "PingCMD";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(204282753, "Lcom/baidu/yunjiasu/ping/PingCMD;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(204282753, "Lcom/baidu/yunjiasu/ping/PingCMD;");
                return;
            }
        }
        INSTANCE = new PingCMD();
    }

    public PingCMD() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private final String runCMD(String str) {
        Process exec;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        exec = new ProcessBuilder((String[]) Arrays.copyOf(strArr, strArr.length)).redirectInput(ProcessBuilder.Redirect.PIPE).redirectOutput(ProcessBuilder.Redirect.PIPE).start();
                        Intrinsics.checkNotNullExpressionValue(exec, "ProcessBuilder(*cmd.spli…                 .start()");
                        exec.waitFor(PingSetting.INSTANCE.getTimeout(), TimeUnit.SECONDS);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    exec = Runtime.getRuntime().exec(str);
                    Intrinsics.checkNotNullExpressionValue(exec, "getRuntime().exec(cmd)");
                    exec.waitFor();
                }
                InputStream inputStream = exec.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "process.inputStream");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                String readText = TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                exec.destroy();
                return readText;
            } catch (Exception e) {
                Log.e(TAG, Intrinsics.stringPlus("runCMD() failed: Exception: ", e));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final PingStatistics ping(InetAddress address) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, address)) == null) {
            Intrinsics.checkNotNullParameter(address, "address");
            String str = address instanceof Inet6Address ? "ping6" : "ping";
            String runCMD = runCMD(str + " -c " + PingSetting.INSTANCE.getCount() + " -i " + (PingSetting.INSTANCE.getTimeMicros() / 1000.0f) + WebvttCueParser.CHAR_SPACE + ((Object) address.getHostAddress()));
            if (runCMD == null) {
                Log.e(TAG, "runCMD() failed");
                return null;
            }
            MatchResult find$default = Regex.find$default(new Regex("([\\d.]+)/([\\d.]+)/([\\d.]+)/([\\d.]+)"), runCMD, 0, 2, null);
            if (find$default == null) {
                Log.e(TAG, Intrinsics.stringPlus("Parse failed: ", runCMD));
                return null;
            }
            try {
                List<String> groupValues = find$default.getGroupValues();
                float parseFloat = Float.parseFloat(groupValues.get(1));
                float parseFloat2 = Float.parseFloat(groupValues.get(2));
                float parseFloat3 = Float.parseFloat(groupValues.get(3));
                float parseFloat4 = Float.parseFloat(groupValues.get(4));
                MatchResult find$default2 = Regex.find$default(new Regex("([\\d]+)[a-z\\s]+transmitted[,\\s]+([\\d]+)[a-z\\s]+received[,\\s]+([\\d]+)%[a-z\\s]+loss"), runCMD, 0, 2, null);
                if (find$default2 == null) {
                    return null;
                }
                List<String> groupValues2 = find$default2.getGroupValues();
                return new PingStatistics(address, Long.parseLong(groupValues2.get(2)), Long.parseLong(groupValues2.get(1)), Float.parseFloat(groupValues2.get(3)) / 100, parseFloat, parseFloat3, parseFloat2, parseFloat4);
            } catch (Exception e) {
                Log.e(TAG, Intrinsics.stringPlus("Parse failed: Exception: ", e));
                return null;
            }
        }
        return (PingStatistics) invokeL.objValue;
    }
}
