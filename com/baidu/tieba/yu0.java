package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static my0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            my0 my0Var = new my0();
            my0Var.k(str2);
            my0Var.l(ly0.c(bdVideo.getCurrentLength()) + "/" + ly0.c(bdVideo.getTotalLength()));
            my0Var.p(bdVideoSeries.getVid());
            my0Var.m(bdVideo.getType());
            my0Var.j(System.currentTimeMillis());
            my0Var.n(bdVideo.getTitle());
            my0Var.o(str);
            my0Var.r(bdVideoSeries.getPositionMs());
            my0Var.q(bdVideo.getCurrentLength());
            my0Var.s(bdVideo.getTotalLength());
            return my0Var;
        }
        return (my0) invokeLLLL.objValue;
    }
}
