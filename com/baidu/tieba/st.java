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
/* loaded from: classes8.dex */
public final class st {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, qt<? extends ITaskModelData>> a;

    public st() {
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
        zt ztVar = new zt(this);
        this.a.put(ztVar.b(), ztVar);
        vt vtVar = new vt(this);
        this.a.put(vtVar.b(), vtVar);
        au auVar = new au(this);
        this.a.put(auVar.c(), auVar);
        xt xtVar = new xt(this);
        this.a.put(xtVar.b(), xtVar);
        wt wtVar = new wt(this);
        this.a.put(wtVar.c(), wtVar);
        yt ytVar = new yt(this);
        this.a.put(ytVar.b(), ytVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.b(), rtVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.c(), ptVar);
    }

    public final <T extends ITaskModelData> qt<? extends T> a(String str) {
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
                qt<? extends ITaskModelData> qtVar = this.a.get(str);
                if (qtVar != null) {
                    return (qt<? extends T>) qtVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (qt) invokeL.objValue;
    }
}
