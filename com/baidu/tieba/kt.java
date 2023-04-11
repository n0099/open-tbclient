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
public final class kt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, it<? extends ITaskModelData>> a;

    public kt() {
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
        rt rtVar = new rt(this);
        this.a.put(rtVar.b(), rtVar);
        nt ntVar = new nt(this);
        this.a.put(ntVar.b(), ntVar);
        st stVar = new st(this);
        this.a.put(stVar.c(), stVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.b(), ptVar);
        ot otVar = new ot(this);
        this.a.put(otVar.c(), otVar);
        qt qtVar = new qt(this);
        this.a.put(qtVar.b(), qtVar);
        jt jtVar = new jt(this);
        this.a.put(jtVar.b(), jtVar);
        ht htVar = new ht(this);
        this.a.put(htVar.c(), htVar);
    }

    public final <T extends ITaskModelData> it<? extends T> a(String str) {
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
                it<? extends ITaskModelData> itVar = this.a.get(str);
                if (itVar != null) {
                    return (it<? extends T>) itVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (it) invokeL.objValue;
    }
}
