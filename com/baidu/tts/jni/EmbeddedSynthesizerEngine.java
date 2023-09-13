package com.baidu.tts.jni;

import com.baidu.storage.swankv.SwanKV;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.w0;
/* loaded from: classes9.dex */
public class EmbeddedSynthesizerEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnNewDataListener mNewDataListener;
    public final String tag;

    /* loaded from: classes9.dex */
    public interface OnNewDataListener {
        int onNewData(byte[] bArr, int i);
    }

    public static native int bdTTSBindCore(String str);

    public static native int bdTTSCheckDomainFile(byte[] bArr);

    public static native String bdTTSGetDatParam(String str);

    public static native long bdTTSGetDomainSampleRate(byte[] bArr);

    public static native String bdTTSGetEngineLibVersion();

    public static native String bdTTSGetEngineParam();

    public static native long bdTTSGetSpeechSampleRate(byte[] bArr);

    public static native int bdTTSResEngineMatch(byte[] bArr);

    public static native int bdTTSSetLogFilePath(String str);

    public static native int bdTTSSetNativeLogLevel(int i);

    public static native int bdTTSVerifyDataFile(byte[] bArr);

    public static native synchronized LicenseInfo bdTTSVerifyLicense(String str, int i, String str2, String str3, String str4, String str5, byte[] bArr);

    public native int bdTTSDomainDataInit(byte[] bArr, long j);

    public native int bdTTSDomainDataUninit(long j);

    public native int bdTTSEngineInit(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, String str2, long[] jArr);

    public native int bdTTSEngineUninit(long j);

    public native long bdTTSGetParam(long j, int i);

    public native int bdTTSReInitData(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, long j);

    public native int bdTTSSetParam(long j, int i, long j2);

    public native int bdTTSSetParamFloat(long j, int i, float f);

    public native int bdTTSSetParamString(long j, String str, String str2);

    public native int bdTTSSynthesis(long j, byte[] bArr, int i);

    public native int loadSuitedEngine(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, String str2, long j);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1616320593, "Lcom/baidu/tts/jni/EmbeddedSynthesizerEngine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1616320593, "Lcom/baidu/tts/jni/EmbeddedSynthesizerEngine;");
                return;
            }
        }
        try {
            LoggerProxy.d("EmbeddedSynthesizerEngine", "before load c++_shared");
            System.loadLibrary(SwanKV.LIB_CPP_SHARED);
        } catch (Throwable unused) {
            LoggerProxy.e("EmbeddedSynthesizerEngine", "so file c++_shared load fail");
        }
        try {
            LoggerProxy.d("EmbeddedSynthesizerEngine", "before load BDSpeechDecoder_V1");
            System.loadLibrary("BDSpeechDecoder_V1");
        } catch (Throwable unused2) {
            LoggerProxy.e("EmbeddedSynthesizerEngine", "so file BDSpeechDecoder_V1 load fail");
        }
        try {
            LoggerProxy.d("EmbeddedSynthesizerEngine", "before load bd_etts");
            System.loadLibrary("bd_etts");
        } catch (Throwable unused3) {
            LoggerProxy.e("EmbeddedSynthesizerEngine", "so file bd_etts load fail");
        }
    }

    public EmbeddedSynthesizerEngine(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tag = w0.a("EmbeddedSynthesizerEngine", str);
    }

    public static String getSpeechInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            String bdTTSGetDatParam = bdTTSGetDatParam(str);
            if (bdTTSGetDatParam != null) {
                return bdTTSGetDatParam.replaceAll("\n", ",");
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void setOnNewDataListener(OnNewDataListener onNewDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onNewDataListener) == null) {
            this.mNewDataListener = onNewDataListener;
        }
    }

    public int newAudioDataCallback(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, bArr, i)) == null) {
            return this.mNewDataListener.onNewData(bArr, i);
        }
        return invokeLI.intValue;
    }
}
