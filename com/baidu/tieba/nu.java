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
public final class nu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, lu<? extends ITaskModelData>> a;

    public nu() {
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
        uu uuVar = new uu(this);
        this.a.put(uuVar.b(), uuVar);
        qu quVar = new qu(this);
        this.a.put(quVar.b(), quVar);
        vu vuVar = new vu(this);
        this.a.put(vuVar.c(), vuVar);
        su suVar = new su(this);
        this.a.put(suVar.b(), suVar);
        ru ruVar = new ru(this);
        this.a.put(ruVar.c(), ruVar);
        tu tuVar = new tu(this);
        this.a.put(tuVar.b(), tuVar);
        mu muVar = new mu(this);
        this.a.put(muVar.b(), muVar);
        ku kuVar = new ku(this);
        this.a.put(kuVar.c(), kuVar);
    }

    public final <T extends ITaskModelData> lu<? extends T> a(String str) {
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
                lu<? extends ITaskModelData> luVar = this.a.get(str);
                if (luVar != null) {
                    return (lu<? extends T>) luVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (lu) invokeL.objValue;
    }
}
