package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes8.dex */
public final class wvb {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285446, "Lcom/baidu/tieba/wvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285446, "Lcom/baidu/tieba/wvb;");
                return;
            }
        }
        a = new String[]{HlsPlaylistParser.METHOD_NONE, "PCM", "I420", "NV12", "RGB24", "AAC", "H264", "HEVC", "TEXTURE", "YYAAC", "YYH264", "YYHEVC"};
    }
}
