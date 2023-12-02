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
public class mu8 {
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

    public mu8() {
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

    public static mu8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            mu8 mu8Var = new mu8();
            mu8Var.a = item.itemId;
            mu8Var.b = item.itemName;
            mu8Var.c = item.iconSize;
            mu8Var.d = item.iconUrl;
            mu8Var.e = item.tags;
            mu8Var.f = item.score;
            mu8Var.g = item.star;
            mu8Var.h = item.buttonName;
            mu8Var.i = item.buttonLink;
            mu8Var.j = item.itemAppid;
            mu8Var.k = item.categoryId;
            mu8Var.l = item.buttonLinkType;
            mu8Var.m = item.apkName;
            mu8Var.n = item.forumName;
            mu8Var.o = ApkDetailPojo.O(item.apkDetail);
            return mu8Var;
        }
        return (mu8) invokeL.objValue;
    }

    public static mu8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            mu8 mu8Var = new mu8();
            mu8Var.a = item.item_id;
            mu8Var.b = item.item_name;
            mu8Var.c = item.icon_size;
            mu8Var.d = item.icon_url;
            mu8Var.e = item.tags;
            mu8Var.f = item.score;
            mu8Var.g = item.star;
            mu8Var.h = item.button_name;
            mu8Var.i = item.button_link;
            mu8Var.j = item.item_appid;
            mu8Var.k = item.category_id;
            mu8Var.l = item.button_link_type;
            mu8Var.m = item.apk_name;
            mu8Var.n = item.forum_name;
            mu8Var.o = ApkDetailPojo.P(item.apk_detail);
            return mu8Var;
        }
        return (mu8) invokeL.objValue;
    }
}
