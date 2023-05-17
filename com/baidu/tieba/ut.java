package com.baidu.tieba;

import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
/* loaded from: classes7.dex */
public final class ut {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, st<? extends ITaskModelData>> a;

    public ut() {
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
        this.a = new HashMap();
        bu buVar = new bu(this);
        this.a.put(buVar.b(), buVar);
        xt xtVar = new xt(this);
        this.a.put(xtVar.b(), xtVar);
        cu cuVar = new cu(this);
        this.a.put(cuVar.c(), cuVar);
        zt ztVar = new zt(this);
        this.a.put(ztVar.b(), ztVar);
        yt ytVar = new yt(this);
        this.a.put(ytVar.c(), ytVar);
        au auVar = new au(this);
        this.a.put(auVar.b(), auVar);
        tt ttVar = new tt(this);
        this.a.put(ttVar.b(), ttVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.c(), rtVar);
    }

    public final <T extends ITaskModelData> st<? extends T> a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                st<? extends ITaskModelData> stVar = this.a.get(str);
                if (stVar != null) {
                    return (st<? extends T>) stVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (st) invokeL.objValue;
    }
}
