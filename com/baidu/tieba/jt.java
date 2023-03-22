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
public final class jt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ht<? extends ITaskModelData>> a;

    public jt() {
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
        qt qtVar = new qt(this);
        this.a.put(qtVar.b(), qtVar);
        mt mtVar = new mt(this);
        this.a.put(mtVar.b(), mtVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.c(), rtVar);
        ot otVar = new ot(this);
        this.a.put(otVar.b(), otVar);
        nt ntVar = new nt(this);
        this.a.put(ntVar.c(), ntVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.b(), ptVar);
        it itVar = new it(this);
        this.a.put(itVar.b(), itVar);
        gt gtVar = new gt(this);
        this.a.put(gtVar.c(), gtVar);
    }

    public final <T extends ITaskModelData> ht<? extends T> a(String str) {
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
                ht<? extends ITaskModelData> htVar = this.a.get(str);
                if (htVar != null) {
                    return (ht<? extends T>) htVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (ht) invokeL.objValue;
    }
}
