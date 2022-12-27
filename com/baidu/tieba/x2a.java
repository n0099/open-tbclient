package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;
/* compiled from: VideoDecoderFactory.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class x2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    @Deprecated
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory videoDecoderFactory, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, videoDecoderFactory, str)) == null) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
        return (VideoDecoder) invokeLL.objValue;
    }

    @Nullable
    @CalledByNative
    public static VideoDecoder $default$createDecoder(VideoDecoderFactory videoDecoderFactory, VideoCodecInfo videoCodecInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, videoDecoderFactory, videoCodecInfo)) == null) {
            return videoDecoderFactory.createDecoder(videoCodecInfo.getName());
        }
        return (VideoDecoder) invokeLL.objValue;
    }
}
