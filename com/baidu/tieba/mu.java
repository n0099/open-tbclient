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
/* loaded from: classes6.dex */
public final class mu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ku<? extends ITaskModelData>> a;

    public mu() {
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
        tu tuVar = new tu(this);
        this.a.put(tuVar.b(), tuVar);
        pu puVar = new pu(this);
        this.a.put(puVar.b(), puVar);
        uu uuVar = new uu(this);
        this.a.put(uuVar.c(), uuVar);
        ru ruVar = new ru(this);
        this.a.put(ruVar.b(), ruVar);
        qu quVar = new qu(this);
        this.a.put(quVar.c(), quVar);
        su suVar = new su(this);
        this.a.put(suVar.b(), suVar);
        lu luVar = new lu(this);
        this.a.put(luVar.b(), luVar);
        ju juVar = new ju(this);
        this.a.put(juVar.c(), juVar);
    }

    public final <T extends ITaskModelData> ku<? extends T> a(String str) {
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
                ku<? extends ITaskModelData> kuVar = this.a.get(str);
                if (kuVar != null) {
                    return (ku<? extends T>) kuVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (ku) invokeL.objValue;
    }
}
