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
public final class vt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, tt<? extends ITaskModelData>> a;

    public vt() {
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
        cu cuVar = new cu(this);
        this.a.put(cuVar.b(), cuVar);
        yt ytVar = new yt(this);
        this.a.put(ytVar.b(), ytVar);
        du duVar = new du(this);
        this.a.put(duVar.c(), duVar);
        au auVar = new au(this);
        this.a.put(auVar.b(), auVar);
        zt ztVar = new zt(this);
        this.a.put(ztVar.c(), ztVar);
        bu buVar = new bu(this);
        this.a.put(buVar.b(), buVar);
        ut utVar = new ut(this);
        this.a.put(utVar.b(), utVar);
        st stVar = new st(this);
        this.a.put(stVar.c(), stVar);
    }

    public final <T extends ITaskModelData> tt<? extends T> a(String str) {
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
                tt<? extends ITaskModelData> ttVar = this.a.get(str);
                if (ttVar != null) {
                    return (tt<? extends T>) ttVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (tt) invokeL.objValue;
    }
}
