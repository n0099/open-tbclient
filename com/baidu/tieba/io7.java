package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes4.dex */
public class io7 {
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

    public io7() {
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

    public static io7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            io7 io7Var = new io7();
            io7Var.a = item.itemId;
            io7Var.b = item.itemName;
            io7Var.c = item.iconSize;
            io7Var.d = item.iconUrl;
            io7Var.e = item.tags;
            io7Var.f = item.score;
            io7Var.g = item.star;
            io7Var.h = item.buttonName;
            io7Var.i = item.buttonLink;
            io7Var.j = item.itemAppid;
            io7Var.k = item.categoryId;
            io7Var.l = item.buttonLinkType;
            io7Var.m = item.apkName;
            io7Var.n = item.forumName;
            io7Var.o = ApkDetailPojo.N(item.apkDetail);
            return io7Var;
        }
        return (io7) invokeL.objValue;
    }

    public static io7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            io7 io7Var = new io7();
            io7Var.a = item.item_id;
            io7Var.b = item.item_name;
            io7Var.c = item.icon_size;
            io7Var.d = item.icon_url;
            io7Var.e = item.tags;
            io7Var.f = item.score;
            io7Var.g = item.star;
            io7Var.h = item.button_name;
            io7Var.i = item.button_link;
            io7Var.j = item.item_appid;
            io7Var.k = item.category_id;
            io7Var.l = item.button_link_type;
            io7Var.m = item.apk_name;
            io7Var.n = item.forum_name;
            io7Var.o = ApkDetailPojo.O(item.apk_detail);
            return io7Var;
        }
        return (io7) invokeL.objValue;
    }
}
