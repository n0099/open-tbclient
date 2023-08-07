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
public final class ot {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, mt<? extends ITaskModelData>> a;

    public ot() {
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
        vt vtVar = new vt(this);
        this.a.put(vtVar.b(), vtVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.b(), rtVar);
        wt wtVar = new wt(this);
        this.a.put(wtVar.c(), wtVar);
        tt ttVar = new tt(this);
        this.a.put(ttVar.b(), ttVar);
        st stVar = new st(this);
        this.a.put(stVar.c(), stVar);
        ut utVar = new ut(this);
        this.a.put(utVar.b(), utVar);
        nt ntVar = new nt(this);
        this.a.put(ntVar.b(), ntVar);
        lt ltVar = new lt(this);
        this.a.put(ltVar.c(), ltVar);
    }

    public final <T extends ITaskModelData> mt<? extends T> a(String str) {
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
                mt<? extends ITaskModelData> mtVar = this.a.get(str);
                if (mtVar != null) {
                    return (mt<? extends T>) mtVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (mt) invokeL.objValue;
    }
}
