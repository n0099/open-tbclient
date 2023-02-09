package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CustomGrid;
/* loaded from: classes7.dex */
public class zj8 {
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

    public zj8() {
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

    public ik8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ik8 ik8Var = new ik8();
            ik8Var.e = this.a;
            ik8Var.n = true;
            ik8Var.l = this.d;
            ik8Var.g = this.b;
            ik8Var.a = this.e;
            ik8Var.m = this.c;
            kk8 kk8Var = new kk8();
            kk8Var.b = this.g;
            kk8Var.i = this.h;
            ik8Var.i = kk8Var;
            return ik8Var;
        }
        return (ik8) invokeV.objValue;
    }
}
