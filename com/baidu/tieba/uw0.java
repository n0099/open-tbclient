package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            i01 i01Var = new i01();
            i01Var.k(str2);
            i01Var.l(h01.c(bdVideo.getCurrentLength()) + "/" + h01.c(bdVideo.getTotalLength()));
            i01Var.p(bdVideoSeries.getVid());
            i01Var.m(bdVideo.getType());
            i01Var.j(System.currentTimeMillis());
            i01Var.n(bdVideo.getTitle());
            i01Var.o(str);
            i01Var.r(bdVideoSeries.getPositionMs());
            i01Var.q(bdVideo.getCurrentLength());
            i01Var.s(bdVideo.getTotalLength());
            return i01Var;
        }
        return (i01) invokeLLLL.objValue;
    }
}
