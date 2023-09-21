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
public class sj8 {
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

    public sj8() {
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

    public static sj8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            sj8 sj8Var = new sj8();
            sj8Var.a = item.itemId;
            sj8Var.b = item.itemName;
            sj8Var.c = item.iconSize;
            sj8Var.d = item.iconUrl;
            sj8Var.e = item.tags;
            sj8Var.f = item.score;
            sj8Var.g = item.star;
            sj8Var.h = item.buttonName;
            sj8Var.i = item.buttonLink;
            sj8Var.j = item.itemAppid;
            sj8Var.k = item.categoryId;
            sj8Var.l = item.buttonLinkType;
            sj8Var.m = item.apkName;
            sj8Var.n = item.forumName;
            sj8Var.o = ApkDetailPojo.M(item.apkDetail);
            return sj8Var;
        }
        return (sj8) invokeL.objValue;
    }

    public static sj8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            sj8 sj8Var = new sj8();
            sj8Var.a = item.item_id;
            sj8Var.b = item.item_name;
            sj8Var.c = item.icon_size;
            sj8Var.d = item.icon_url;
            sj8Var.e = item.tags;
            sj8Var.f = item.score;
            sj8Var.g = item.star;
            sj8Var.h = item.button_name;
            sj8Var.i = item.button_link;
            sj8Var.j = item.item_appid;
            sj8Var.k = item.category_id;
            sj8Var.l = item.button_link_type;
            sj8Var.m = item.apk_name;
            sj8Var.n = item.forum_name;
            sj8Var.o = ApkDetailPojo.N(item.apk_detail);
            return sj8Var;
        }
        return (sj8) invokeL.objValue;
    }
}
