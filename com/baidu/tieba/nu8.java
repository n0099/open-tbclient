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
public class nu8 {
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

    public nu8() {
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

    public static nu8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            nu8 nu8Var = new nu8();
            nu8Var.a = item.itemId;
            nu8Var.b = item.itemName;
            nu8Var.c = item.iconSize;
            nu8Var.d = item.iconUrl;
            nu8Var.e = item.tags;
            nu8Var.f = item.score;
            nu8Var.g = item.star;
            nu8Var.h = item.buttonName;
            nu8Var.i = item.buttonLink;
            nu8Var.j = item.itemAppid;
            nu8Var.k = item.categoryId;
            nu8Var.l = item.buttonLinkType;
            nu8Var.m = item.apkName;
            nu8Var.n = item.forumName;
            nu8Var.o = ApkDetailPojo.O(item.apkDetail);
            return nu8Var;
        }
        return (nu8) invokeL.objValue;
    }

    public static nu8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            nu8 nu8Var = new nu8();
            nu8Var.a = item.item_id;
            nu8Var.b = item.item_name;
            nu8Var.c = item.icon_size;
            nu8Var.d = item.icon_url;
            nu8Var.e = item.tags;
            nu8Var.f = item.score;
            nu8Var.g = item.star;
            nu8Var.h = item.button_name;
            nu8Var.i = item.button_link;
            nu8Var.j = item.item_appid;
            nu8Var.k = item.category_id;
            nu8Var.l = item.button_link_type;
            nu8Var.m = item.apk_name;
            nu8Var.n = item.forum_name;
            nu8Var.o = ApkDetailPojo.P(item.apk_detail);
            return nu8Var;
        }
        return (nu8) invokeL.objValue;
    }
}
