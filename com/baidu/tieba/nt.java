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
/* loaded from: classes5.dex */
public final class nt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, lt<? extends ITaskModelData>> a;

    public nt() {
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
        ut utVar = new ut(this);
        this.a.put(utVar.b(), utVar);
        qt qtVar = new qt(this);
        this.a.put(qtVar.b(), qtVar);
        vt vtVar = new vt(this);
        this.a.put(vtVar.c(), vtVar);
        st stVar = new st(this);
        this.a.put(stVar.b(), stVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.c(), rtVar);
        tt ttVar = new tt(this);
        this.a.put(ttVar.b(), ttVar);
        mt mtVar = new mt(this);
        this.a.put(mtVar.b(), mtVar);
        kt ktVar = new kt(this);
        this.a.put(ktVar.c(), ktVar);
    }

    public final <T extends ITaskModelData> lt<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                lt<? extends ITaskModelData> ltVar = this.a.get(str);
                if (ltVar != null) {
                    return (lt<? extends T>) ltVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (lt) invokeL.objValue;
    }
}
