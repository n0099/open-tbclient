package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gv0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            gv0 gv0Var = new gv0();
            gv0Var.k(str2);
            gv0Var.l(fv0.c(bdVideo.getCurrentLength()) + "/" + fv0.c(bdVideo.getTotalLength()));
            gv0Var.p(bdVideoSeries.getVid());
            gv0Var.m(bdVideo.getType());
            gv0Var.j(System.currentTimeMillis());
            gv0Var.n(bdVideo.getTitle());
            gv0Var.o(str);
            gv0Var.r(bdVideoSeries.getPositionMs());
            gv0Var.q(bdVideo.getCurrentLength());
            gv0Var.s(bdVideo.getTotalLength());
            return gv0Var;
        }
        return (gv0) invokeLLLL.objValue;
    }
}
