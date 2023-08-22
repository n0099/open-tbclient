package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes8.dex */
public class x88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<w88> b;

    public x88() {
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

    public void a(long j, TimeLine timeLine) {
        Long l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048576, this, j, timeLine) == null) && timeLine != null && !ListUtils.isEmpty(timeLine.timeline_info)) {
            this.a = timeLine.title;
            this.b = new ArrayList();
            int i = 0;
            for (TimeLineInfo timeLineInfo : timeLine.timeline_info) {
                if (timeLineInfo != null && (((l = timeLineInfo.tid) != null && l.longValue() != 0) || !TextUtils.isEmpty(timeLineInfo.title) || !TextUtils.isEmpty(timeLineInfo.bg_color) || !TextUtils.isEmpty(timeLineInfo.show_time) || !TextUtils.isEmpty(timeLineInfo.small_title))) {
                    w88 w88Var = new w88();
                    w88Var.a = j;
                    w88Var.f = i;
                    w88Var.a(timeLineInfo);
                    this.b.add(w88Var);
                    i++;
                }
            }
        }
    }
}
