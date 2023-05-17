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
public class y28 {
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

    public y28() {
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

    public static y28 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            y28 y28Var = new y28();
            y28Var.a = item.itemId;
            y28Var.b = item.itemName;
            y28Var.c = item.iconSize;
            y28Var.d = item.iconUrl;
            y28Var.e = item.tags;
            y28Var.f = item.score;
            y28Var.g = item.star;
            y28Var.h = item.buttonName;
            y28Var.i = item.buttonLink;
            y28Var.j = item.itemAppid;
            y28Var.k = item.categoryId;
            y28Var.l = item.buttonLinkType;
            y28Var.m = item.apkName;
            y28Var.n = item.forumName;
            y28Var.o = ApkDetailPojo.U(item.apkDetail);
            return y28Var;
        }
        return (y28) invokeL.objValue;
    }

    public static y28 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            y28 y28Var = new y28();
            y28Var.a = item.item_id;
            y28Var.b = item.item_name;
            y28Var.c = item.icon_size;
            y28Var.d = item.icon_url;
            y28Var.e = item.tags;
            y28Var.f = item.score;
            y28Var.g = item.star;
            y28Var.h = item.button_name;
            y28Var.i = item.button_link;
            y28Var.j = item.item_appid;
            y28Var.k = item.category_id;
            y28Var.l = item.button_link_type;
            y28Var.m = item.apk_name;
            y28Var.n = item.forum_name;
            y28Var.o = ApkDetailPojo.V(item.apk_detail);
            return y28Var;
        }
        return (y28) invokeL.objValue;
    }
}
