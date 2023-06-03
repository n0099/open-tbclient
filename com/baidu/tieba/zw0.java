package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            n01 n01Var = new n01();
            n01Var.k(str2);
            n01Var.l(m01.c(bdVideo.getCurrentLength()) + "/" + m01.c(bdVideo.getTotalLength()));
            n01Var.p(bdVideoSeries.getVid());
            n01Var.m(bdVideo.getType());
            n01Var.j(System.currentTimeMillis());
            n01Var.n(bdVideo.getTitle());
            n01Var.o(str);
            n01Var.r(bdVideoSeries.getPositionMs());
            n01Var.q(bdVideo.getCurrentLength());
            n01Var.s(bdVideo.getTotalLength());
            return n01Var;
        }
        return (n01) invokeLLLL.objValue;
    }
}
