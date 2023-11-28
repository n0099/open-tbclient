package com.baidu.tieba;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes6.dex */
public class iu8 {
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

    public iu8() {
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

    public static iu8 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            iu8 iu8Var = new iu8();
            iu8Var.a = item.itemId;
            iu8Var.b = item.itemName;
            iu8Var.c = item.iconSize;
            iu8Var.d = item.iconUrl;
            iu8Var.e = item.tags;
            iu8Var.f = item.score;
            iu8Var.g = item.star;
            iu8Var.h = item.buttonName;
            iu8Var.i = item.buttonLink;
            iu8Var.j = item.itemAppid;
            iu8Var.k = item.categoryId;
            iu8Var.l = item.buttonLinkType;
            iu8Var.m = item.apkName;
            iu8Var.n = item.forumName;
            iu8Var.o = ApkDetailPojo.O(item.apkDetail);
            return iu8Var;
        }
        return (iu8) invokeL.objValue;
    }

    public static iu8 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            iu8 iu8Var = new iu8();
            iu8Var.a = item.item_id;
            iu8Var.b = item.item_name;
            iu8Var.c = item.icon_size;
            iu8Var.d = item.icon_url;
            iu8Var.e = item.tags;
            iu8Var.f = item.score;
            iu8Var.g = item.star;
            iu8Var.h = item.button_name;
            iu8Var.i = item.button_link;
            iu8Var.j = item.item_appid;
            iu8Var.k = item.category_id;
            iu8Var.l = item.button_link_type;
            iu8Var.m = item.apk_name;
            iu8Var.n = item.forum_name;
            iu8Var.o = ApkDetailPojo.P(item.apk_detail);
            return iu8Var;
        }
        return (iu8) invokeL.objValue;
    }
}
