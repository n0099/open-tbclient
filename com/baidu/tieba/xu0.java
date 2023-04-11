package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ly0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ly0 ly0Var = new ly0();
            ly0Var.k(str2);
            ly0Var.l(ky0.c(bdVideo.getCurrentLength()) + "/" + ky0.c(bdVideo.getTotalLength()));
            ly0Var.p(bdVideoSeries.getVid());
            ly0Var.m(bdVideo.getType());
            ly0Var.j(System.currentTimeMillis());
            ly0Var.n(bdVideo.getTitle());
            ly0Var.o(str);
            ly0Var.r(bdVideoSeries.getPositionMs());
            ly0Var.q(bdVideo.getCurrentLength());
            ly0Var.s(bdVideo.getTotalLength());
            return ly0Var;
        }
        return (ly0) invokeLLLL.objValue;
    }
}
