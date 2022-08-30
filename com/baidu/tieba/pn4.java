package com.baidu.tieba;

import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FlutterLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalPicDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalVideoThumbLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.MemeLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.NinePatchLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverMemoryLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleLoaderProc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            lg.h().o(10, new SimpleLoaderProc(true, true, false, 10));
            lg.h().o(11, new SimpleLoaderProc(false, true, false, 10));
            lg.h().o(42, new SimpleLoaderProc(true, false, false, 10));
            lg.h().o(13, new SimpleLoaderProc(true, true, false, 13));
            lg.h().o(14, new SimpleLoaderProc(false, true, false, 13));
            lg.h().o(17, new SimpleLoaderProc(true, true, false, 17));
            lg.h().o(18, new SimpleLoaderProc(false, true, false, 17));
            lg.h().o(39, new SimpleBlurLoaderProc(true, 39));
            lg.h().o(12, new PortraitLoaderProc(false, false, 12));
            lg.h().o(26, new PortraitLoaderProc(true, false, 26));
            lg.h().o(28, new PortraitLoaderProc(false, false, 26));
            lg.h().o(40, new PortraitBlurLoaderProc(false, false, 40));
            lg.h().o(19, new NinePatchLoaderProc(19));
            lg.h().o(24, new LocalPicDrawableLoaderProc(24));
            lg.h().o(25, new PortraitLoaderProc(false, true, 26));
            lg.h().o(27, new BigImageLoaderProc(27));
            lg.h().o(29, new SimpleForeverLoaderProc(true, 29));
            lg.h().o(32, new LocalFileDrawableLoaderProc(32));
            lg.h().o(23, new fx4());
            lg.h().o(33, new MemeLoaderProc2());
            lg.h().o(34, new EmotionShareLoaderProc());
            lg.h().o(35, new LocalFileImageLoaderProc(160, 160));
            lg.h().o(36, new LocalFileImageLoaderProc());
            lg.h().o(43, new LocalFileImageLoaderProc2());
            lg.h().o(37, new LocalVideoThumbLoaderProc());
            lg.h().o(38, new ImageLoaderProc());
            lg.h().o(41, new BigdayImageLoaderProc());
            lg.h().o(44, new FlutterLoaderProc(true, 44, false));
            lg.h().o(15, new SimpleLoaderProc(false, true, true, 15));
            lg.h().o(16, new SimpleLoaderProc(false, true, true, 16));
            lg.h().o(21, new SimpleLoaderProc(false, true, true, 21));
            lg.h().o(30, new SimpleLoaderProc(true, true, false, 30));
            lg.h().o(31, new SimpleLoaderProc(false, true, false, 30));
            lg.h().o(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            lg.h().o(46, new SimpleLoaderProc(true, true, false, 46));
            lg.h().o(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }
}
