package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f11 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            f11 f11Var = new f11();
            f11Var.k(str2);
            f11Var.l(e11.c(bdVideo.getCurrentLength()) + "/" + e11.c(bdVideo.getTotalLength()));
            f11Var.p(bdVideoSeries.getVid());
            f11Var.m(bdVideo.getType());
            f11Var.j(System.currentTimeMillis());
            f11Var.n(bdVideo.getTitle());
            f11Var.o(str);
            f11Var.r(bdVideoSeries.getPositionMs());
            f11Var.q(bdVideo.getCurrentLength());
            f11Var.s(bdVideo.getTotalLength());
            return f11Var;
        }
        return (f11) invokeLLLL.objValue;
    }
}
