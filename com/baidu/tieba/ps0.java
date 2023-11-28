package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ps0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yv0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            yv0 yv0Var = new yv0();
            yv0Var.k(str2);
            yv0Var.l(xv0.c(bdVideo.getCurrentLength()) + "/" + xv0.c(bdVideo.getTotalLength()));
            yv0Var.p(bdVideoSeries.getVid());
            yv0Var.m(bdVideo.getType());
            yv0Var.j(System.currentTimeMillis());
            yv0Var.n(bdVideo.getTitle());
            yv0Var.o(str);
            yv0Var.r(bdVideoSeries.getPositionMs());
            yv0Var.q(bdVideo.getCurrentLength());
            yv0Var.s(bdVideo.getTotalLength());
            return yv0Var;
        }
        return (yv0) invokeLLLL.objValue;
    }
}
