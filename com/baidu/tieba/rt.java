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
public final class rt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, pt<? extends ITaskModelData>> a;

    public rt() {
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
        yt ytVar = new yt(this);
        this.a.put(ytVar.b(), ytVar);
        ut utVar = new ut(this);
        this.a.put(utVar.b(), utVar);
        zt ztVar = new zt(this);
        this.a.put(ztVar.c(), ztVar);
        wt wtVar = new wt(this);
        this.a.put(wtVar.b(), wtVar);
        vt vtVar = new vt(this);
        this.a.put(vtVar.c(), vtVar);
        xt xtVar = new xt(this);
        this.a.put(xtVar.b(), xtVar);
        qt qtVar = new qt(this);
        this.a.put(qtVar.b(), qtVar);
        ot otVar = new ot(this);
        this.a.put(otVar.c(), otVar);
    }

    public final <T extends ITaskModelData> pt<? extends T> a(String str) {
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
                pt<? extends ITaskModelData> ptVar = this.a.get(str);
                if (ptVar != null) {
                    return (pt<? extends T>) ptVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (pt) invokeL.objValue;
    }
}
