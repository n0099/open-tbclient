package com.baidu.tts.chainofresponsibility.logger;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.tts.v;
import com.baidu.tts.x;
import com.baidu.tts.y;
import java.util.List;
/* loaded from: classes9.dex */
public class LoggerProxy {
    public static /* synthetic */ Interceptable $ic;
    public static x a;
    public static ILoggerUploadCallBack loggerUploadCallBack;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(539118313, "Lcom/baidu/tts/chainofresponsibility/logger/LoggerProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(539118313, "Lcom/baidu/tts/chainofresponsibility/logger/LoggerProxy;");
                return;
            }
        }
        if (x.g == null) {
            synchronized (x.class) {
                if (x.g == null) {
                    x.g = new x();
                }
            }
        }
        a = x.g;
    }

    public LoggerProxy() {
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

    public static void clearHandler() {
        List<v> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, null) == null) && (list = a.a) != null) {
            list.clear();
        }
    }

    public static void clearSpecifyStrings() {
        y yVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && (yVar = a.d) != null) {
            List<String> list = yVar.a;
            if (list != null) {
                list.clear();
            }
            List<String> list2 = yVar.b;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public static boolean isModeRelease() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            x.a aVar = a.e;
            if (aVar != null && aVar != x.a.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void setModeDevelop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            a.e = x.a.a;
        }
    }

    public static void setModeRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            a.e = x.a.b;
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            log(7, str, str2);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            log(3, str, str2);
            ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
            if (iLoggerUploadCallBack != null) {
                iLoggerUploadCallBack.loggerUpload(3, str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            log(6, str, str2);
            ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
            if (iLoggerUploadCallBack != null) {
                iLoggerUploadCallBack.loggerUpload(6, str, str2);
            }
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            log(4, str, str2);
            ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
            if (iLoggerUploadCallBack != null) {
                iLoggerUploadCallBack.loggerUpload(4, str, str2);
            }
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, str, str2) == null) {
            log(2, str, str2);
            ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
            if (iLoggerUploadCallBack != null) {
                iLoggerUploadCallBack.loggerUpload(2, str, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, str2) == null) {
            log(5, str, str2);
            ILoggerUploadCallBack iLoggerUploadCallBack = loggerUploadCallBack;
            if (iLoggerUploadCallBack != null) {
                iLoggerUploadCallBack.loggerUpload(5, str, str2);
            }
        }
    }

    public static void addPrintString(String str) {
        y yVar;
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && (yVar = a.d) != null && (list = yVar.a) != null && !list.contains(str)) {
            yVar.a.add(str);
        }
    }

    public static void addPrintStrings(List<String> list) {
        y yVar;
        List<String> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) && (yVar = a.d) != null && (list2 = yVar.a) != null) {
            list2.addAll(list);
        }
    }

    public static void addUnPrintString(String str) {
        y yVar;
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && (yVar = a.d) != null && (list = yVar.b) != null && !list.contains(str)) {
            yVar.b.add(str);
        }
    }

    public static boolean needPrint(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            if (!a.f && !Log.isLoggable("TTSLOG", i)) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static void printable(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            a.f = z;
            if (!z) {
                i = 1;
            } else {
                i = 6;
            }
            setNativeLogLevel(i);
        }
    }

    public static void saveNativeLogFile(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, null, str) == null) && !str.isEmpty()) {
            EmbeddedSynthesizerEngine.bdTTSSetLogFilePath(str);
        }
    }

    public static void setBaseTag(String str) {
        y yVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, str) == null) && (yVar = a.d) != null) {
            yVar.c = str;
        }
    }

    public static void setLoggerListener(ILoggerUploadCallBack iLoggerUploadCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, iLoggerUploadCallBack) == null) {
            loggerUploadCallBack = iLoggerUploadCallBack;
        }
    }

    public static void log(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65548, null, i, str, str2) == null) {
            try {
                a.a(i, str, str2);
            } catch (Exception e) {
                Log.e("LoggerProxy", "log exception=" + e.toString());
            }
        }
    }

    public static void setNativeLogLevel(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65556, null, i) == null) && i < 7 && i > 0) {
            EmbeddedSynthesizerEngine.bdTTSSetNativeLogLevel(i);
            SpeechDecoder.bdTTSSetNativeLogLevel(i);
            TtsLogLoad.bdTTSSetNativeLogLevel(i);
            d("LoggerProxy", "EngineVersion = " + SynthesizerTool.getEngineVersion() + " , EngineInfo = " + SynthesizerTool.getEngineInfo() + " , engineLib = " + SynthesizerTool.getEngineLibVersion() + " , logLib = " + SynthesizerTool.getLogLibVersion() + " , decoderLib = " + SynthesizerTool.getDecoderLibVersion());
        }
    }
}
