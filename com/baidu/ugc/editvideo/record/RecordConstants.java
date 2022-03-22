package com.baidu.ugc.editvideo.record;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class RecordConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static int AUDIO_ENCODE_BIT_RATE = 128000;
    public static final int AUDIO_ENCODE_CHANNEL_COUNT = 1;
    public static int AUDIO_ENCODE_SAMPLE_RATE = 44100;
    public static final int AUDIO_ENCODE_TIMEOUT_USEC = 10000;
    public static final int DEDAULT_REQUEST_THRESHOLD = 30;
    public static final int DEDAULT_REQUEST_THRESHOLD_SLOW_ONE = 20;
    public static final int DEDAULT_REQUEST_THRESHOLD_SLOW_TWO = 10;
    public static final int DEFAULT_BEAUTYLEVEL = 1;
    public static final int DEFAULT_BIT_RATE_BELOW_API18 = 2097152;
    public static int DEFAULT_BIT_RATE_GTE_API18 = 5242880;
    public static final int DEFAULT_BIT_RATE_GTE_API18_BIG = 4194304;
    public static final int DEFAULT_PREVIEW_HEIGHT = 960;
    public static final int DEFAULT_PREVIEW_WIDTH = 540;
    public static final int DEFAULT_QMBEAUTYLEVEL = 6;
    public static final int DEFAULT_VIDEO_HEIGHT_BELOW_API18 = 720;
    public static final int DEFAULT_VIDEO_WIDTH_BELOW_API18 = 1280;
    public static final int FFMPEG_RECORD_CONVERT_MIN_TIME = 8000;
    public static final int FRAMES_PER_BUFFER = 24;
    public static final int MAX_FRAME_CNT = 100;
    public static final float MIN_RECORD_TIME = 3000.0f;
    public static final int MOVIE_ENCODE_FRAMES_PER_BUFFER = 24;
    public static final int MOVIE_ENCODE_KSONG_SAMPLE_RATE = 16000;
    public static final int MOVIE_ENCODE_NORMAL_SAMPLE_RATE = 44100;
    public static final int MOVIE_ENCODE_SAMPLES_PER_FRAME = 2048;
    public static int MOVIE_ENCODE_SAMPLE_RATE = 44100;
    public static final int PREVIEW_MAX_FPS = 20000;
    public static final int PREVIEW_MIN_FPS = 15000;
    public static final int RESLTION_1080 = 1080;
    public static final int RESLTION_720 = 720;
    public static final int ROTATION_180_INT = 180;
    public static final int ROTATION_270_INT = 270;
    public static final int ROTATION_90_INT = 90;
    public static final int SAMPLES_PER_FRAME = 2048;
    public static int TIMEOUT_USEC = 10000;
    public static int VIDEO_CONSTANT_HEIGHT = 1280;
    public static final int VIDEO_CONSTANT_HEIGHT_MAX = 1280;
    public static final int VIDEO_CONSTANT_HEIGHT_OLD = 960;
    public static int VIDEO_CONSTANT_WIDTH = 720;
    public static final int VIDEO_CONSTANT_WIDTH_MAX = 720;
    public static final int VIDEO_CONSTANT_WIDTH_OLD = 544;
    public static final int VIDEO_ENCODE_FRAME_RATE = 30;
    public static final int VIDEO_ENCODE_FRAME_RATE60 = 60;
    public static final int VIDEO_ENCODE_HIGH_FRAME_RATE = 60;
    public static final int VIDEO_ENCODE_IFRAME_INTERVAL = 5;
    public static final int VIDEO_ENCODE_TIMEOUT_USEC = 10000;
    public static float VIDEO_RATIO_16_9 = 1.7777778f;
    public static float VIDEO_RATIO_9_16 = 0.5625f;
    public static String isNewRecordUser;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1287890447, "Lcom/baidu/ugc/editvideo/record/RecordConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1287890447, "Lcom/baidu/ugc/editvideo/record/RecordConstants;");
        }
    }

    public RecordConstants() {
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
}
