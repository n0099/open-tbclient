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
public final class pu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, nu<? extends ITaskModelData>> a;

    public pu() {
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
        wu wuVar = new wu(this);
        this.a.put(wuVar.b(), wuVar);
        su suVar = new su(this);
        this.a.put(suVar.b(), suVar);
        xu xuVar = new xu(this);
        this.a.put(xuVar.c(), xuVar);
        uu uuVar = new uu(this);
        this.a.put(uuVar.b(), uuVar);
        tu tuVar = new tu(this);
        this.a.put(tuVar.c(), tuVar);
        vu vuVar = new vu(this);
        this.a.put(vuVar.b(), vuVar);
        ou ouVar = new ou(this);
        this.a.put(ouVar.b(), ouVar);
        mu muVar = new mu(this);
        this.a.put(muVar.c(), muVar);
    }

    public final <T extends ITaskModelData> nu<? extends T> a(String str) {
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
                nu<? extends ITaskModelData> nuVar = this.a.get(str);
                if (nuVar != null) {
                    return (nu<? extends T>) nuVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (nu) invokeL.objValue;
    }
}
