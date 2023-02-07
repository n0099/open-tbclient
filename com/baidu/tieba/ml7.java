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
public class ml7 {
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

    public ml7() {
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

    public static ml7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ml7 ml7Var = new ml7();
            ml7Var.a = item.itemId;
            ml7Var.b = item.itemName;
            ml7Var.c = item.iconSize;
            ml7Var.d = item.iconUrl;
            ml7Var.e = item.tags;
            ml7Var.f = item.score;
            ml7Var.g = item.star;
            ml7Var.h = item.buttonName;
            ml7Var.i = item.buttonLink;
            ml7Var.j = item.itemAppid;
            ml7Var.k = item.categoryId;
            ml7Var.l = item.buttonLinkType;
            ml7Var.m = item.apkName;
            ml7Var.n = item.forumName;
            ml7Var.o = ApkDetailPojo.G(item.apkDetail);
            return ml7Var;
        }
        return (ml7) invokeL.objValue;
    }

    public static ml7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            ml7 ml7Var = new ml7();
            ml7Var.a = item.item_id;
            ml7Var.b = item.item_name;
            ml7Var.c = item.icon_size;
            ml7Var.d = item.icon_url;
            ml7Var.e = item.tags;
            ml7Var.f = item.score;
            ml7Var.g = item.star;
            ml7Var.h = item.button_name;
            ml7Var.i = item.button_link;
            ml7Var.j = item.item_appid;
            ml7Var.k = item.category_id;
            ml7Var.l = item.button_link_type;
            ml7Var.m = item.apk_name;
            ml7Var.n = item.forum_name;
            ml7Var.o = ApkDetailPojo.H(item.apk_detail);
            return ml7Var;
        }
        return (ml7) invokeL.objValue;
    }
}
