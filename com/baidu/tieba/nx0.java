package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nx0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bdVideoSeries)) == null) {
            if (bdVideoSeries != null && bdVideoSeries.getSelectedVideo() != null) {
                return az0.c(bdVideoSeries.getSelectedVideo().getTotalLength());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void b(BdVideoSeries bdVideoSeries, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, null, bdVideoSeries, i, i2) == null) && bdVideoSeries != null && bdVideoSeries.getSelectedVideo() != null) {
            bdVideoSeries.setPositionMs(i);
            bdVideoSeries.setDurationMs(i2);
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            selectedVideo.setCurrentLength((i / 1000) + "");
            BdVideo selectedVideo2 = bdVideoSeries.getSelectedVideo();
            selectedVideo2.setTotalLength((i2 / 1000) + "");
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    int d = az0.d(str, -1);
                    if (d < 0) {
                        return "";
                    }
                    return az0.b(d, false);
                } catch (Exception e) {
                    ez0.k("toTimeString(" + str + SmallTailInfo.EMOTION_SUFFIX, e);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
