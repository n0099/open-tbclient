package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l01 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            l01 l01Var = new l01();
            l01Var.k(str2);
            l01Var.l(k01.c(bdVideo.getCurrentLength()) + "/" + k01.c(bdVideo.getTotalLength()));
            l01Var.p(bdVideoSeries.getVid());
            l01Var.m(bdVideo.getType());
            l01Var.j(System.currentTimeMillis());
            l01Var.n(bdVideo.getTitle());
            l01Var.o(str);
            l01Var.r(bdVideoSeries.getPositionMs());
            l01Var.q(bdVideo.getCurrentLength());
            l01Var.s(bdVideo.getTotalLength());
            return l01Var;
        }
        return (l01) invokeLLLL.objValue;
    }
}
