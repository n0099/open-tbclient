package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.Resource;
/* loaded from: classes8.dex */
public class t38 extends wn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t38() {
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

    public void c(Resource resource) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, resource) != null) || resource == null) {
            return;
        }
        this.a = resource.res_id.longValue();
        this.b = resource.user_name;
        this.c = resource.user_image;
        this.d = resource.user_link;
        this.e = resource.res_title;
        this.f = resource.res_image;
        this.g = resource.res_link;
        this.h = resource.position.longValue();
        this.i = resource.icon_text;
    }
}
