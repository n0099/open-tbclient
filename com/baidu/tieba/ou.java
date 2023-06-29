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
public final class ou {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, mu<? extends ITaskModelData>> a;

    public ou() {
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
        vu vuVar = new vu(this);
        this.a.put(vuVar.b(), vuVar);
        ru ruVar = new ru(this);
        this.a.put(ruVar.b(), ruVar);
        wu wuVar = new wu(this);
        this.a.put(wuVar.c(), wuVar);
        tu tuVar = new tu(this);
        this.a.put(tuVar.b(), tuVar);
        su suVar = new su(this);
        this.a.put(suVar.c(), suVar);
        uu uuVar = new uu(this);
        this.a.put(uuVar.b(), uuVar);
        nu nuVar = new nu(this);
        this.a.put(nuVar.b(), nuVar);
        lu luVar = new lu(this);
        this.a.put(luVar.c(), luVar);
    }

    public final <T extends ITaskModelData> mu<? extends T> a(String str) {
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
                mu<? extends ITaskModelData> muVar = this.a.get(str);
                if (muVar != null) {
                    return (mu<? extends T>) muVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (mu) invokeL.objValue;
    }
}
