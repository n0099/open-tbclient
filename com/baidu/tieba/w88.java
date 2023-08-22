package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes8.dex */
public class w88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;

    public w88() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TimeLineInfo timeLineInfo) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, timeLineInfo) != null) || timeLineInfo == null) {
            return;
        }
        this.b = timeLineInfo.tid.longValue();
        this.c = timeLineInfo.title;
        if (di.isEmpty(timeLineInfo.small_title)) {
            str = timeLineInfo.show_time;
        } else {
            str = timeLineInfo.small_title;
        }
        this.d = str;
        this.e = timeLineInfo.bg_color;
    }
}
