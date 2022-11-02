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
public class sb7 {
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

    public sb7() {
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

    public static sb7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            sb7 sb7Var = new sb7();
            sb7Var.a = item.itemId;
            sb7Var.b = item.itemName;
            sb7Var.c = item.iconSize;
            sb7Var.d = item.iconUrl;
            sb7Var.e = item.tags;
            sb7Var.f = item.score;
            sb7Var.g = item.star;
            sb7Var.h = item.buttonName;
            sb7Var.i = item.buttonLink;
            sb7Var.j = item.itemAppid;
            sb7Var.k = item.categoryId;
            sb7Var.l = item.buttonLinkType;
            sb7Var.m = item.apkName;
            sb7Var.n = item.forumName;
            sb7Var.o = ApkDetailPojo.z(item.apkDetail);
            return sb7Var;
        }
        return (sb7) invokeL.objValue;
    }

    public static sb7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            sb7 sb7Var = new sb7();
            sb7Var.a = item.item_id;
            sb7Var.b = item.item_name;
            sb7Var.c = item.icon_size;
            sb7Var.d = item.icon_url;
            sb7Var.e = item.tags;
            sb7Var.f = item.score;
            sb7Var.g = item.star;
            sb7Var.h = item.button_name;
            sb7Var.i = item.button_link;
            sb7Var.j = item.item_appid;
            sb7Var.k = item.category_id;
            sb7Var.l = item.button_link_type;
            sb7Var.m = item.apk_name;
            sb7Var.n = item.forum_name;
            sb7Var.o = ApkDetailPojo.A(item.apk_detail);
            return sb7Var;
        }
        return (sb7) invokeL.objValue;
    }
}
