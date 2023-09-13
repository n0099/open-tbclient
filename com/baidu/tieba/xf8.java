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
public class xf8 {
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

    public xf8() {
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

    public static xf8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            xf8 xf8Var = new xf8();
            xf8Var.a = item.itemId;
            xf8Var.b = item.itemName;
            xf8Var.c = item.iconSize;
            xf8Var.d = item.iconUrl;
            xf8Var.e = item.tags;
            xf8Var.f = item.score;
            xf8Var.g = item.star;
            xf8Var.h = item.buttonName;
            xf8Var.i = item.buttonLink;
            xf8Var.j = item.itemAppid;
            xf8Var.k = item.categoryId;
            xf8Var.l = item.buttonLinkType;
            xf8Var.m = item.apkName;
            xf8Var.n = item.forumName;
            xf8Var.o = ApkDetailPojo.M(item.apkDetail);
            return xf8Var;
        }
        return (xf8) invokeL.objValue;
    }

    public static xf8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            xf8 xf8Var = new xf8();
            xf8Var.a = item.item_id;
            xf8Var.b = item.item_name;
            xf8Var.c = item.icon_size;
            xf8Var.d = item.icon_url;
            xf8Var.e = item.tags;
            xf8Var.f = item.score;
            xf8Var.g = item.star;
            xf8Var.h = item.button_name;
            xf8Var.i = item.button_link;
            xf8Var.j = item.item_appid;
            xf8Var.k = item.category_id;
            xf8Var.l = item.button_link_type;
            xf8Var.m = item.apk_name;
            xf8Var.n = item.forum_name;
            xf8Var.o = ApkDetailPojo.N(item.apk_detail);
            return xf8Var;
        }
        return (xf8) invokeL.objValue;
    }
}
