package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ax0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ax0 ax0Var = new ax0();
            ax0Var.k(str2);
            ax0Var.l(zw0.c(bdVideo.getCurrentLength()) + "/" + zw0.c(bdVideo.getTotalLength()));
            ax0Var.p(bdVideoSeries.getVid());
            ax0Var.m(bdVideo.getType());
            ax0Var.j(System.currentTimeMillis());
            ax0Var.n(bdVideo.getTitle());
            ax0Var.o(str);
            ax0Var.r(bdVideoSeries.getPositionMs());
            ax0Var.q(bdVideo.getCurrentLength());
            ax0Var.s(bdVideo.getTotalLength());
            return ax0Var;
        }
        return (ax0) invokeLLLL.objValue;
    }
}
