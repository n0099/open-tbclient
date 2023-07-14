package com.baidu.tieba;

import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FixedNinePatchLoaderProc;
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
/* loaded from: classes8.dex */
public class v05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            sg.h().o(10, new SimpleLoaderProc(true, true, false, 10));
            sg.h().o(11, new SimpleLoaderProc(false, true, false, 10));
            sg.h().o(42, new SimpleLoaderProc(true, false, false, 10));
            sg.h().o(13, new SimpleLoaderProc(true, true, false, 13));
            sg.h().o(14, new SimpleLoaderProc(false, true, false, 13));
            sg.h().o(17, new SimpleLoaderProc(true, true, false, 17));
            sg.h().o(18, new SimpleLoaderProc(false, true, false, 17));
            sg.h().o(39, new SimpleBlurLoaderProc(true, 39));
            sg.h().o(12, new PortraitLoaderProc(false, false, 12));
            sg.h().o(26, new PortraitLoaderProc(true, false, 26));
            sg.h().o(28, new PortraitLoaderProc(false, false, 26));
            sg.h().o(40, new PortraitBlurLoaderProc(false, false, 40));
            sg.h().o(19, new NinePatchLoaderProc(19));
            sg.h().o(59, new FixedNinePatchLoaderProc(59));
            sg.h().o(24, new LocalPicDrawableLoaderProc(24));
            sg.h().o(25, new PortraitLoaderProc(false, true, 26));
            sg.h().o(27, new BigImageLoaderProc(27));
            sg.h().o(29, new SimpleForeverLoaderProc(true, 29));
            sg.h().o(32, new LocalFileDrawableLoaderProc(32));
            sg.h().o(23, new tc5());
            sg.h().o(33, new MemeLoaderProc2());
            sg.h().o(34, new EmotionShareLoaderProc());
            sg.h().o(35, new LocalFileImageLoaderProc(160, 160));
            sg.h().o(36, new LocalFileImageLoaderProc());
            sg.h().o(43, new LocalFileImageLoaderProc2());
            sg.h().o(37, new LocalVideoThumbLoaderProc());
            sg.h().o(38, new ImageLoaderProc());
            sg.h().o(41, new BigdayImageLoaderProc());
            sg.h().o(44, new FlutterLoaderProc(true, 44, false));
            sg.h().o(15, new SimpleLoaderProc(false, true, true, 15));
            sg.h().o(16, new SimpleLoaderProc(false, true, true, 16));
            sg.h().o(21, new SimpleLoaderProc(false, true, true, 21));
            sg.h().o(30, new SimpleLoaderProc(true, true, false, 30));
            sg.h().o(31, new SimpleLoaderProc(false, true, false, 30));
            sg.h().o(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            sg.h().o(46, new SimpleLoaderProc(true, true, false, 46));
            sg.h().o(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }
}
