package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class os0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xv0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            xv0 xv0Var = new xv0();
            xv0Var.k(str2);
            xv0Var.l(wv0.c(bdVideo.getCurrentLength()) + "/" + wv0.c(bdVideo.getTotalLength()));
            xv0Var.p(bdVideoSeries.getVid());
            xv0Var.m(bdVideo.getType());
            xv0Var.j(System.currentTimeMillis());
            xv0Var.n(bdVideo.getTitle());
            xv0Var.o(str);
            xv0Var.r(bdVideoSeries.getPositionMs());
            xv0Var.q(bdVideo.getCurrentLength());
            xv0Var.s(bdVideo.getTotalLength());
            return xv0Var;
        }
        return (xv0) invokeLLLL.objValue;
    }
}
