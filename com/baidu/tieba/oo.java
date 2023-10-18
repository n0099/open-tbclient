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
public final class oo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, mo<? extends ITaskModelData>> a;

    public oo() {
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
        vo voVar = new vo(this);
        this.a.put(voVar.b(), voVar);
        ro roVar = new ro(this);
        this.a.put(roVar.b(), roVar);
        wo woVar = new wo(this);
        this.a.put(woVar.c(), woVar);
        to toVar = new to(this);
        this.a.put(toVar.b(), toVar);
        so soVar = new so(this);
        this.a.put(soVar.c(), soVar);
        uo uoVar = new uo(this);
        this.a.put(uoVar.b(), uoVar);
        no noVar = new no(this);
        this.a.put(noVar.b(), noVar);
        lo loVar = new lo(this);
        this.a.put(loVar.c(), loVar);
    }

    public final <T extends ITaskModelData> mo<? extends T> a(String str) {
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
                mo<? extends ITaskModelData> moVar = this.a.get(str);
                if (moVar != null) {
                    return (mo<? extends T>) moVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (mo) invokeL.objValue;
    }
}
