package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ky0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ky0 ky0Var = new ky0();
            ky0Var.k(str2);
            ky0Var.l(jy0.c(bdVideo.getCurrentLength()) + "/" + jy0.c(bdVideo.getTotalLength()));
            ky0Var.p(bdVideoSeries.getVid());
            ky0Var.m(bdVideo.getType());
            ky0Var.j(System.currentTimeMillis());
            ky0Var.n(bdVideo.getTitle());
            ky0Var.o(str);
            ky0Var.r(bdVideoSeries.getPositionMs());
            ky0Var.q(bdVideo.getCurrentLength());
            ky0Var.s(bdVideo.getTotalLength());
            return ky0Var;
        }
        return (ky0) invokeLLLL.objValue;
    }
}
