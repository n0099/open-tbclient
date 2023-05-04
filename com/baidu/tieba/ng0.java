package com.baidu.tieba;

import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
/* loaded from: classes5.dex */
public final class ng0 extends rl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public String a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public String d;
    @JvmField
    public String e;
    @JvmField
    public String f;
    @JvmField
    public String g;
    @JvmField
    public boolean h;
    @JvmField
    public String i;

    public ng0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AdDownloadStatus adDownloadStatus = AdDownloadStatus.NONE;
    }
}
