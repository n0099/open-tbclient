package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes7.dex */
public class o88 {
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

    public o88() {
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

    public static o88 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            o88 o88Var = new o88();
            o88Var.a = item.itemId;
            o88Var.b = item.itemName;
            o88Var.c = item.iconSize;
            o88Var.d = item.iconUrl;
            o88Var.e = item.tags;
            o88Var.f = item.score;
            o88Var.g = item.star;
            o88Var.h = item.buttonName;
            o88Var.i = item.buttonLink;
            o88Var.j = item.itemAppid;
            o88Var.k = item.categoryId;
            o88Var.l = item.buttonLinkType;
            o88Var.m = item.apkName;
            o88Var.n = item.forumName;
            o88Var.o = ApkDetailPojo.U(item.apkDetail);
            return o88Var;
        }
        return (o88) invokeL.objValue;
    }

    public static o88 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            o88 o88Var = new o88();
            o88Var.a = item.item_id;
            o88Var.b = item.item_name;
            o88Var.c = item.icon_size;
            o88Var.d = item.icon_url;
            o88Var.e = item.tags;
            o88Var.f = item.score;
            o88Var.g = item.star;
            o88Var.h = item.button_name;
            o88Var.i = item.button_link;
            o88Var.j = item.item_appid;
            o88Var.k = item.category_id;
            o88Var.l = item.button_link_type;
            o88Var.m = item.apk_name;
            o88Var.n = item.forum_name;
            o88Var.o = ApkDetailPojo.V(item.apk_detail);
            return o88Var;
        }
        return (o88) invokeL.objValue;
    }
}
