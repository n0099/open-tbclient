package com.baidu.tieba;

import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final /* synthetic */ class u21 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        int[] iArr = new int[AdDownloadStatus.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[AdDownloadStatus.NONE.ordinal()] = 1;
        $EnumSwitchMapping$0[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
        int[] iArr2 = new int[AdDownloadStatus.values().length];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[AdDownloadStatus.INSTALLED.ordinal()] = 1;
    }
}
