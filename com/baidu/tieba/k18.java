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
public class k18 {
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

    public k18() {
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

    public static k18 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            k18 k18Var = new k18();
            k18Var.a = item.itemId;
            k18Var.b = item.itemName;
            k18Var.c = item.iconSize;
            k18Var.d = item.iconUrl;
            k18Var.e = item.tags;
            k18Var.f = item.score;
            k18Var.g = item.star;
            k18Var.h = item.buttonName;
            k18Var.i = item.buttonLink;
            k18Var.j = item.itemAppid;
            k18Var.k = item.categoryId;
            k18Var.l = item.buttonLinkType;
            k18Var.m = item.apkName;
            k18Var.n = item.forumName;
            k18Var.o = ApkDetailPojo.V(item.apkDetail);
            return k18Var;
        }
        return (k18) invokeL.objValue;
    }

    public static k18 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            k18 k18Var = new k18();
            k18Var.a = item.item_id;
            k18Var.b = item.item_name;
            k18Var.c = item.icon_size;
            k18Var.d = item.icon_url;
            k18Var.e = item.tags;
            k18Var.f = item.score;
            k18Var.g = item.star;
            k18Var.h = item.button_name;
            k18Var.i = item.button_link;
            k18Var.j = item.item_appid;
            k18Var.k = item.category_id;
            k18Var.l = item.button_link_type;
            k18Var.m = item.apk_name;
            k18Var.n = item.forum_name;
            k18Var.o = ApkDetailPojo.W(item.apk_detail);
            return k18Var;
        }
        return (k18) invokeL.objValue;
    }
}
