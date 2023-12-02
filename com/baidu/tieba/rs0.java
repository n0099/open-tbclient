package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static aw0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            aw0 aw0Var = new aw0();
            aw0Var.k(str2);
            aw0Var.l(zv0.c(bdVideo.getCurrentLength()) + "/" + zv0.c(bdVideo.getTotalLength()));
            aw0Var.p(bdVideoSeries.getVid());
            aw0Var.m(bdVideo.getType());
            aw0Var.j(System.currentTimeMillis());
            aw0Var.n(bdVideo.getTitle());
            aw0Var.o(str);
            aw0Var.r(bdVideoSeries.getPositionMs());
            aw0Var.q(bdVideo.getCurrentLength());
            aw0Var.s(bdVideo.getTotalLength());
            return aw0Var;
        }
        return (aw0) invokeLLLL.objValue;
    }
}
