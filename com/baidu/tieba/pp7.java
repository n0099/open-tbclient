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
public class pp7 {
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

    public pp7() {
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

    public static pp7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            pp7 pp7Var = new pp7();
            pp7Var.a = item.itemId;
            pp7Var.b = item.itemName;
            pp7Var.c = item.iconSize;
            pp7Var.d = item.iconUrl;
            pp7Var.e = item.tags;
            pp7Var.f = item.score;
            pp7Var.g = item.star;
            pp7Var.h = item.buttonName;
            pp7Var.i = item.buttonLink;
            pp7Var.j = item.itemAppid;
            pp7Var.k = item.categoryId;
            pp7Var.l = item.buttonLinkType;
            pp7Var.m = item.apkName;
            pp7Var.n = item.forumName;
            pp7Var.o = ApkDetailPojo.R(item.apkDetail);
            return pp7Var;
        }
        return (pp7) invokeL.objValue;
    }

    public static pp7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            pp7 pp7Var = new pp7();
            pp7Var.a = item.item_id;
            pp7Var.b = item.item_name;
            pp7Var.c = item.icon_size;
            pp7Var.d = item.icon_url;
            pp7Var.e = item.tags;
            pp7Var.f = item.score;
            pp7Var.g = item.star;
            pp7Var.h = item.button_name;
            pp7Var.i = item.button_link;
            pp7Var.j = item.item_appid;
            pp7Var.k = item.category_id;
            pp7Var.l = item.button_link_type;
            pp7Var.m = item.apk_name;
            pp7Var.n = item.forum_name;
            pp7Var.o = ApkDetailPojo.S(item.apk_detail);
            return pp7Var;
        }
        return (pp7) invokeL.objValue;
    }
}
