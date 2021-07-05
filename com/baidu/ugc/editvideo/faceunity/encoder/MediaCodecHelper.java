package com.baidu.ugc.editvideo.faceunity.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.misc.IMediaFormat;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
@RequiresApi(api = 16)
/* loaded from: classes6.dex */
public class MediaCodecHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIMEOUT_USEC = 10000;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaCodecHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static MediaExtractor createExtractor(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            return mediaExtractor;
        }
        return (MediaExtractor) invokeL.objValue;
    }

    public static MediaCodec createVideoDecoder(MediaFormat mediaFormat, Surface surface) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaFormat, surface)) == null) {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            return createDecoderByType;
        }
        return (MediaCodec) invokeLL.objValue;
    }

    @RequiresApi(api = 18)
    public static MediaCodec createVideoEncoder(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, mediaCodecInfo, mediaFormat, atomicReference)) == null) {
            MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
            createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            atomicReference.set(createByCodecName.createInputSurface());
            createByCodecName.start();
            return createByCodecName;
        }
        return (MediaCodec) invokeLLL.objValue;
    }

    public static int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, mediaExtractor)) == null) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                if (isVideoFormat(mediaExtractor.getTrackFormat(i2))) {
                    mediaExtractor.selectTrack(i2);
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String getMimeTypeFor(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, mediaFormat)) == null) ? mediaFormat.getString(IMediaFormat.KEY_MIME) : (String) invokeL.objValue;
    }

    public static boolean isAudioFormat(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, mediaFormat)) == null) ? getMimeTypeFor(mediaFormat).startsWith("audio/") : invokeL.booleanValue;
    }

    public static boolean isVideoFormat(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mediaFormat)) == null) ? getMimeTypeFor(mediaFormat).startsWith(FileUtils.VIDEO_FILE_START) : invokeL.booleanValue;
    }

    public static void setMediaFormatProperty(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65544, null, mediaFormat, mediaFormat2, str, i2) == null) {
            if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
                i2 = mediaFormat.getInteger(str);
            }
            if (mediaFormat2 != null) {
                mediaFormat2.setInteger(str, i2);
            }
        }
    }
}
