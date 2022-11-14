package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class su0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gy0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            gy0 gy0Var = new gy0();
            gy0Var.k(str2);
            gy0Var.l(fy0.c(bdVideo.getCurrentLength()) + "/" + fy0.c(bdVideo.getTotalLength()));
            gy0Var.p(bdVideoSeries.getVid());
            gy0Var.m(bdVideo.getType());
            gy0Var.j(System.currentTimeMillis());
            gy0Var.n(bdVideo.getTitle());
            gy0Var.o(str);
            gy0Var.r(bdVideoSeries.getPositionMs());
            gy0Var.q(bdVideo.getCurrentLength());
            gy0Var.s(bdVideo.getTotalLength());
            return gy0Var;
        }
        return (gy0) invokeLLLL.objValue;
    }
}
