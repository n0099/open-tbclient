package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final /* synthetic */ class mya {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[ImageView.ScaleType.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
        $EnumSwitchMapping$0[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        $EnumSwitchMapping$0[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        $EnumSwitchMapping$0[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        $EnumSwitchMapping$0[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        $EnumSwitchMapping$0[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        $EnumSwitchMapping$0[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
