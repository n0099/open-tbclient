package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes8.dex */
public class z28 {
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

    public z28() {
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

    public static z28 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            z28 z28Var = new z28();
            z28Var.a = item.itemId;
            z28Var.b = item.itemName;
            z28Var.c = item.iconSize;
            z28Var.d = item.iconUrl;
            z28Var.e = item.tags;
            z28Var.f = item.score;
            z28Var.g = item.star;
            z28Var.h = item.buttonName;
            z28Var.i = item.buttonLink;
            z28Var.j = item.itemAppid;
            z28Var.k = item.categoryId;
            z28Var.l = item.buttonLinkType;
            z28Var.m = item.apkName;
            z28Var.n = item.forumName;
            z28Var.o = ApkDetailPojo.U(item.apkDetail);
            return z28Var;
        }
        return (z28) invokeL.objValue;
    }

    public static z28 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            z28 z28Var = new z28();
            z28Var.a = item.item_id;
            z28Var.b = item.item_name;
            z28Var.c = item.icon_size;
            z28Var.d = item.icon_url;
            z28Var.e = item.tags;
            z28Var.f = item.score;
            z28Var.g = item.star;
            z28Var.h = item.button_name;
            z28Var.i = item.button_link;
            z28Var.j = item.item_appid;
            z28Var.k = item.category_id;
            z28Var.l = item.button_link_type;
            z28Var.m = item.apk_name;
            z28Var.n = item.forum_name;
            z28Var.o = ApkDetailPojo.V(item.apk_detail);
            return z28Var;
        }
        return (z28) invokeL.objValue;
    }
}
