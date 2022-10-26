package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Search.DataRes;
/* loaded from: classes5.dex */
public class p06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public String c;
    public String d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String j;
    public boolean k;
    public long l;

    public p06() {
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

    public void a(DataRes dataRes) {
        long longValue;
        long longValue2;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        Long l = dataRes.uid;
        long j = 0;
        if (l == null) {
            longValue = 0;
        } else {
            longValue = l.longValue();
        }
        this.b = longValue;
        this.c = dataRes.portrait;
        this.d = dataRes.name_show;
        Long l2 = dataRes.apply_id;
        if (l2 == null) {
            longValue2 = 0;
        } else {
            longValue2 = l2.longValue();
        }
        this.e = longValue2;
        Integer num = dataRes.vote_num;
        boolean z = false;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.f = intValue;
        Integer num2 = dataRes.agree_num;
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        this.g = intValue2;
        Integer num3 = dataRes.thread_num;
        if (num3 == null) {
            intValue3 = 0;
        } else {
            intValue3 = num3.intValue();
        }
        this.h = intValue3;
        Integer num4 = dataRes.post_num;
        if (num4 == null) {
            intValue4 = 0;
        } else {
            intValue4 = num4.intValue();
        }
        this.i = intValue4;
        Boolean bool = dataRes.is_vote;
        if (bool != null) {
            z = bool.booleanValue();
        }
        this.k = z;
        Long l3 = dataRes.tid;
        if (l3 != null) {
            j = l3.longValue();
        }
        this.l = j;
    }
}
