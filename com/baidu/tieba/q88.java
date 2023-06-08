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
public class q88 {
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

    public q88() {
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

    public static q88 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            q88 q88Var = new q88();
            q88Var.a = item.itemId;
            q88Var.b = item.itemName;
            q88Var.c = item.iconSize;
            q88Var.d = item.iconUrl;
            q88Var.e = item.tags;
            q88Var.f = item.score;
            q88Var.g = item.star;
            q88Var.h = item.buttonName;
            q88Var.i = item.buttonLink;
            q88Var.j = item.itemAppid;
            q88Var.k = item.categoryId;
            q88Var.l = item.buttonLinkType;
            q88Var.m = item.apkName;
            q88Var.n = item.forumName;
            q88Var.o = ApkDetailPojo.U(item.apkDetail);
            return q88Var;
        }
        return (q88) invokeL.objValue;
    }

    public static q88 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            q88 q88Var = new q88();
            q88Var.a = item.item_id;
            q88Var.b = item.item_name;
            q88Var.c = item.icon_size;
            q88Var.d = item.icon_url;
            q88Var.e = item.tags;
            q88Var.f = item.score;
            q88Var.g = item.star;
            q88Var.h = item.button_name;
            q88Var.i = item.button_link;
            q88Var.j = item.item_appid;
            q88Var.k = item.category_id;
            q88Var.l = item.button_link_type;
            q88Var.m = item.apk_name;
            q88Var.n = item.forum_name;
            q88Var.o = ApkDetailPojo.V(item.apk_detail);
            return q88Var;
        }
        return (q88) invokeL.objValue;
    }
}
