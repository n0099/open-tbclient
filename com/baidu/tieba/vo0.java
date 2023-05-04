package com.baidu.tieba;

import com.baidu.nadcore.max.event.PanelEventTypeEnum;
import com.baidu.nadcore.max.event.PopEventTypeEnum;
import com.baidu.nadcore.max.event.VideoEventTypeEnum;
import com.baidu.nadcore.max.event.WebEventTypeEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final /* synthetic */ class vo0 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[WebEventTypeEnum.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[WebEventTypeEnum.WEB_INIT_SUCCESS.ordinal()] = 1;
        int[] iArr2 = new int[VideoEventTypeEnum.values().length];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[VideoEventTypeEnum.PLAY_SEEK_TO_END.ordinal()] = 1;
        $EnumSwitchMapping$1[VideoEventTypeEnum.LEFT_SLIDE_ON_VIDEO.ordinal()] = 2;
        int[] iArr3 = new int[PanelEventTypeEnum.values().length];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[PanelEventTypeEnum.CLICK_PANEL_UI.ordinal()] = 1;
        int[] iArr4 = new int[PopEventTypeEnum.values().length];
        $EnumSwitchMapping$3 = iArr4;
        iArr4[PopEventTypeEnum.CLICK_POP_UI.ordinal()] = 1;
    }
}
