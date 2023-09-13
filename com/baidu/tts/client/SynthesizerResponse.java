package com.baidu.tts.client;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface SynthesizerResponse {

    /* loaded from: classes9.dex */
    public interface SynthesizerData {
        byte[] getAudioData();

        int getAudioProgress();

        int getAudioSampleRate();

        int getEngineType();
    }

    /* loaded from: classes9.dex */
    public interface SynthesizerError {
        int getCode();

        String getDescription();
    }

    String getInstanceId();

    String getSn();

    SynthesizeType getSynthesizeType();

    SynthesizerData getSynthesizerData();

    SynthesizerError getSynthesizerError();

    String getUtteranceId();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class SynthesizeType {
        public static /* synthetic */ Interceptable $ic;
        public static final SynthesizeType PLAY_FINISH;
        public static final SynthesizeType PLAY_PROGRESS;
        public static final SynthesizeType PLAY_START;
        public static final SynthesizeType SYNTHESIZE_DATA_ARRIVED;
        public static final SynthesizeType SYNTHESIZE_ERROR;
        public static final SynthesizeType SYNTHESIZE_FINISH;
        public static final SynthesizeType SYNTHESIZE_START;
        public static final SynthesizeType SYNTHESIZE_STOP;
        public static final /* synthetic */ SynthesizeType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(637051170, "Lcom/baidu/tts/client/SynthesizerResponse$SynthesizeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(637051170, "Lcom/baidu/tts/client/SynthesizerResponse$SynthesizeType;");
                    return;
                }
            }
            SynthesizeType synthesizeType = new SynthesizeType("SYNTHESIZE_START", 0);
            SYNTHESIZE_START = synthesizeType;
            SynthesizeType synthesizeType2 = new SynthesizeType("SYNTHESIZE_DATA_ARRIVED", 1);
            SYNTHESIZE_DATA_ARRIVED = synthesizeType2;
            SynthesizeType synthesizeType3 = new SynthesizeType("SYNTHESIZE_STOP", 2);
            SYNTHESIZE_STOP = synthesizeType3;
            SynthesizeType synthesizeType4 = new SynthesizeType("SYNTHESIZE_FINISH", 3);
            SYNTHESIZE_FINISH = synthesizeType4;
            SynthesizeType synthesizeType5 = new SynthesizeType("SYNTHESIZE_ERROR", 4);
            SYNTHESIZE_ERROR = synthesizeType5;
            SynthesizeType synthesizeType6 = new SynthesizeType("PLAY_START", 5);
            PLAY_START = synthesizeType6;
            SynthesizeType synthesizeType7 = new SynthesizeType("PLAY_PROGRESS", 6);
            PLAY_PROGRESS = synthesizeType7;
            SynthesizeType synthesizeType8 = new SynthesizeType("PLAY_FINISH", 7);
            PLAY_FINISH = synthesizeType8;
            a = new SynthesizeType[]{synthesizeType, synthesizeType2, synthesizeType3, synthesizeType4, synthesizeType5, synthesizeType6, synthesizeType7, synthesizeType8};
        }

        public SynthesizeType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SynthesizeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SynthesizeType) Enum.valueOf(SynthesizeType.class, str);
            }
            return (SynthesizeType) invokeL.objValue;
        }

        public static SynthesizeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SynthesizeType[]) a.clone();
            }
            return (SynthesizeType[]) invokeV.objValue;
        }
    }
}
