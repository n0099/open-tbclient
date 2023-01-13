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
public final class xt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, vt<? extends ITaskModelData>> a;

    public xt() {
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
        eu euVar = new eu(this);
        this.a.put(euVar.b(), euVar);
        au auVar = new au(this);
        this.a.put(auVar.b(), auVar);
        fu fuVar = new fu(this);
        this.a.put(fuVar.c(), fuVar);
        cu cuVar = new cu(this);
        this.a.put(cuVar.b(), cuVar);
        bu buVar = new bu(this);
        this.a.put(buVar.c(), buVar);
        du duVar = new du(this);
        this.a.put(duVar.b(), duVar);
        wt wtVar = new wt(this);
        this.a.put(wtVar.b(), wtVar);
        ut utVar = new ut(this);
        this.a.put(utVar.c(), utVar);
    }

    public final <T extends ITaskModelData> vt<? extends T> a(String str) {
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
                vt<? extends ITaskModelData> vtVar = this.a.get(str);
                if (vtVar != null) {
                    return (vt<? extends T>) vtVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (vt) invokeL.objValue;
    }
}
