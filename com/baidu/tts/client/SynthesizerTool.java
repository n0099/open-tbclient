package com.baidu.tts.client;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.LicenseInfo;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.tts.l2;
import com.baidu.tts.w0;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SynthesizerTool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SynthesizerTool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getDecoderLibVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return SpeechDecoder.bdTTSGetDecoderLibVersion();
        }
        return (String) invokeV.objValue;
    }

    public static String getEngineInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
        }
        return (String) invokeV.objValue;
    }

    public static String getEngineLibVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return EmbeddedSynthesizerEngine.bdTTSGetEngineLibVersion();
        }
        return (String) invokeV.objValue;
    }

    public static int getEngineVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                return new JSONObject(getEngineInfo()).getInt("version");
            } catch (JSONException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String getLogLibVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return TtsLogLoad.bdTTSGetLogLibVersion();
        }
        return (String) invokeV.objValue;
    }

    public static int checkDomainFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!w0.b(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return EmbeddedSynthesizerEngine.bdTTSCheckDomainFile(w0.d(str));
                }
                return -12;
            }
            return -12;
        }
        return invokeL.intValue;
    }

    public static long getDomainSampleRate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!w0.b(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return EmbeddedSynthesizerEngine.bdTTSGetDomainSampleRate(w0.d(str));
                }
                return -12L;
            }
            return -12L;
        }
        return invokeL.longValue;
    }

    public static String getModelInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!w0.b(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return EmbeddedSynthesizerEngine.bdTTSGetDatParam(str);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long getSpeechSampleRate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (!w0.b(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return EmbeddedSynthesizerEngine.bdTTSGetSpeechSampleRate(w0.d(str));
                }
                return -12L;
            }
            return -12L;
        }
        return invokeL.longValue;
    }

    public static int getLicenseLeftValidDays(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, context, str, str2, str3)) == null) {
            if (!w0.b(str) && new File(str).exists()) {
                String cuid = DeviceId.getCUID(context);
                LoggerProxy.d("PrivacyInfoTool", "cuid=" + cuid);
                String a = l2.a(context);
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                LicenseInfo bdTTSVerifyLicense = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(a, 1, str2, cuid, str3, str, new byte[32]);
                if (bdTTSVerifyLicense != null) {
                    int ret = bdTTSVerifyLicense.getRet();
                    Log.d("SynthesizerTool", "verify result=" + ret);
                    return ret;
                }
            }
            return -1;
        }
        return invokeLLLL.intValue;
    }

    public static int matchResEngine(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return EmbeddedSynthesizerEngine.bdTTSResEngineMatch(w0.d(str));
        }
        return invokeL.intValue;
    }

    public static boolean verifyModelFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (w0.b(str)) {
                return false;
            }
            try {
                if (EmbeddedSynthesizerEngine.bdTTSVerifyDataFile(w0.d(str)) != 0) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
