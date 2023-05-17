package com.baidu.tieba;

import com.baidu.nadcore.max.event.NestedEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final /* synthetic */ class np0 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[NestedEvent.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[NestedEvent.UP_SHOW_VIDEO.ordinal()] = 1;
        $EnumSwitchMapping$0[NestedEvent.UP_SHOW_WEB.ordinal()] = 2;
        $EnumSwitchMapping$0[NestedEvent.SCROLL_FINISH.ordinal()] = 3;
    }
}
