package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CustomGrid;
/* loaded from: classes5.dex */
public class os8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;
    public int e;
    public long f;
    public String g;
    public String h;

    public os8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(CustomGrid customGrid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, customGrid) == null) {
            this.a = customGrid.title;
            this.b = customGrid.action_uri;
            this.c = customGrid.action_type.intValue();
            this.d = customGrid.icon;
            this.e = customGrid.type.intValue();
            this.g = customGrid.desc;
            this.h = customGrid.mark_text;
            this.f = customGrid.red_point_version.longValue();
        }
    }

    public xs8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xs8 xs8Var = new xs8();
            xs8Var.e = this.a;
            xs8Var.n = true;
            xs8Var.l = this.d;
            xs8Var.g = this.b;
            xs8Var.a = this.e;
            xs8Var.m = this.c;
            zs8 zs8Var = new zs8();
            zs8Var.b = this.g;
            zs8Var.i = this.h;
            xs8Var.i = zs8Var;
            return xs8Var;
        }
        return (xs8) invokeV.objValue;
    }
}
