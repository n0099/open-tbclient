package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static nx0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            nx0 nx0Var = new nx0();
            nx0Var.k(str2);
            nx0Var.l(mx0.c(bdVideo.getCurrentLength()) + "/" + mx0.c(bdVideo.getTotalLength()));
            nx0Var.p(bdVideoSeries.getVid());
            nx0Var.m(bdVideo.getType());
            nx0Var.j(System.currentTimeMillis());
            nx0Var.n(bdVideo.getTitle());
            nx0Var.o(str);
            nx0Var.r(bdVideoSeries.getPositionMs());
            nx0Var.q(bdVideo.getCurrentLength());
            nx0Var.s(bdVideo.getTotalLength());
            return nx0Var;
        }
        return (nx0) invokeLLLL.objValue;
    }
}
