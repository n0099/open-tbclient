package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ez0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ez0 ez0Var = new ez0();
            ez0Var.k(str2);
            ez0Var.l(dz0.c(bdVideo.getCurrentLength()) + "/" + dz0.c(bdVideo.getTotalLength()));
            ez0Var.p(bdVideoSeries.getVid());
            ez0Var.m(bdVideo.getType());
            ez0Var.j(System.currentTimeMillis());
            ez0Var.n(bdVideo.getTitle());
            ez0Var.o(str);
            ez0Var.r(bdVideoSeries.getPositionMs());
            ez0Var.q(bdVideo.getCurrentLength());
            ez0Var.s(bdVideo.getTotalLength());
            return ez0Var;
        }
        return (ez0) invokeLLLL.objValue;
    }
}
