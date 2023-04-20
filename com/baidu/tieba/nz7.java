package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes5.dex */
public class nz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;
    public String b;
    public Double c;
    public String d;
    public List<String> e;
    public Double f;
    public Integer g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public Integer l;
    public String m;
    public String n;
    public ApkDetailPojo o;

    public nz7() {
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

    public static nz7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            nz7 nz7Var = new nz7();
            nz7Var.a = item.itemId;
            nz7Var.b = item.itemName;
            nz7Var.c = item.iconSize;
            nz7Var.d = item.iconUrl;
            nz7Var.e = item.tags;
            nz7Var.f = item.score;
            nz7Var.g = item.star;
            nz7Var.h = item.buttonName;
            nz7Var.i = item.buttonLink;
            nz7Var.j = item.itemAppid;
            nz7Var.k = item.categoryId;
            nz7Var.l = item.buttonLinkType;
            nz7Var.m = item.apkName;
            nz7Var.n = item.forumName;
            nz7Var.o = ApkDetailPojo.Q(item.apkDetail);
            return nz7Var;
        }
        return (nz7) invokeL.objValue;
    }

    public static nz7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            nz7 nz7Var = new nz7();
            nz7Var.a = item.item_id;
            nz7Var.b = item.item_name;
            nz7Var.c = item.icon_size;
            nz7Var.d = item.icon_url;
            nz7Var.e = item.tags;
            nz7Var.f = item.score;
            nz7Var.g = item.star;
            nz7Var.h = item.button_name;
            nz7Var.i = item.button_link;
            nz7Var.j = item.item_appid;
            nz7Var.k = item.category_id;
            nz7Var.l = item.button_link_type;
            nz7Var.m = item.apk_name;
            nz7Var.n = item.forum_name;
            nz7Var.o = ApkDetailPojo.R(item.apk_detail);
            return nz7Var;
        }
        return (nz7) invokeL.objValue;
    }
}
