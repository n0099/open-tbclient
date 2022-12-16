package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ru0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fy0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            fy0 fy0Var = new fy0();
            fy0Var.k(str2);
            fy0Var.l(ey0.c(bdVideo.getCurrentLength()) + "/" + ey0.c(bdVideo.getTotalLength()));
            fy0Var.p(bdVideoSeries.getVid());
            fy0Var.m(bdVideo.getType());
            fy0Var.j(System.currentTimeMillis());
            fy0Var.n(bdVideo.getTitle());
            fy0Var.o(str);
            fy0Var.r(bdVideoSeries.getPositionMs());
            fy0Var.q(bdVideo.getCurrentLength());
            fy0Var.s(bdVideo.getTotalLength());
            return fy0Var;
        }
        return (fy0) invokeLLLL.objValue;
    }
}
