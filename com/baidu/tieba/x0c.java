package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.opensource.svgaplayer.proto.ShapeEntity;
/* loaded from: classes8.dex */
public final /* synthetic */ class x0c {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[ShapeEntity.ShapeType.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        $EnumSwitchMapping$0[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        $EnumSwitchMapping$0[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        $EnumSwitchMapping$0[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        int[] iArr2 = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        $EnumSwitchMapping$1[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        $EnumSwitchMapping$1[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        int[] iArr3 = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        $EnumSwitchMapping$2[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        $EnumSwitchMapping$2[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
