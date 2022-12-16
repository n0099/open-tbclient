package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes7.dex */
public class zr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xr8> a;
    public ArrayList<yr8> b;

    public zr8() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
    }

    public void a(ActPost actPost) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, actPost) != null) || actPost == null) {
            return;
        }
        String str = actPost.list_head;
        for (ActHot actHot : actPost.act_hot) {
            if (actHot != null) {
                xr8 xr8Var = new xr8();
                xr8Var.g(actHot);
                this.a.add(xr8Var);
            }
        }
        List<LinkInfo> list = actPost.link_info;
        for (LinkInfo linkInfo : list) {
            if (list != null) {
                yr8 yr8Var = new yr8();
                yr8Var.a(linkInfo);
                this.b.add(yr8Var);
            }
        }
    }
}
