package com.baidu.tieba;

import com.baidu.tieba.bi2;
import com.baidu.tieba.dg2;
import com.baidu.tieba.gd2;
import com.baidu.tieba.mp1;
import com.baidu.tieba.ns2;
import com.baidu.tieba.re2;
import com.baidu.tieba.sl3;
import com.baidu.tieba.t52;
import com.baidu.tieba.tb2;
import com.baidu.tieba.wy1;
import com.baidu.tieba.yg3;
import com.baidu.tieba.za3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class sv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HashMap<Class, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            HashMap<Class, Object> hashMap = new HashMap<>();
            hashMap.put(za3.b.class, new za3.b());
            hashMap.put(re2.f.class, new re2.f());
            hashMap.put(re2.g.class, new re2.g());
            hashMap.put(tb2.a.class, new tb2.a());
            hashMap.put(gd2.a.class, new gd2.a());
            hashMap.put(sl3.c.class, new sl3.c());
            hashMap.put(yg3.b.class, new yg3.b());
            hashMap.put(ns2.c.class, new ns2.c());
            hashMap.put(gz2.class, new gz2());
            hashMap.put(cv1.class, new cv1());
            hashMap.put(dv1.class, new dv1());
            hashMap.put(fg3.class, new fg3());
            hashMap.put(eg3.class, new eg3());
            hashMap.put(ig3.class, new ig3());
            hashMap.put(xg2.class, new xg2());
            hashMap.put(dg2.c.class, new dg2.c());
            hashMap.put(qx2.class, new qx2());
            hashMap.put(wy1.b.class, new wy1.b());
            hashMap.put(mp1.a.class, new mp1.a());
            hashMap.put(d62.class, new d62());
            hashMap.put(bi2.a.class, new bi2.a());
            hashMap.put(bi2.b.class, new bi2.b());
            hashMap.put(t03.class, new t03());
            hashMap.put(t52.b.class, new t52.b());
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
