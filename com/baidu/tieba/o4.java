package com.baidu.tieba;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short[] a;
    public final t6<p4> b;
    public final t6<ModelMaterial> c;
    public final t6<r4> d;
    public final t6<n4> e;

    public o4() {
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
        this.a = new short[2];
        this.b = new t6<>();
        this.c = new t6<>();
        this.d = new t6<>();
        this.e = new t6<>();
    }
}
