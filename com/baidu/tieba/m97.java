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
public class m97 {
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

    public m97() {
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

    public static m97 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            m97 m97Var = new m97();
            m97Var.a = item.itemId;
            m97Var.b = item.itemName;
            m97Var.c = item.iconSize;
            m97Var.d = item.iconUrl;
            m97Var.e = item.tags;
            m97Var.f = item.score;
            m97Var.g = item.star;
            m97Var.h = item.buttonName;
            m97Var.i = item.buttonLink;
            m97Var.j = item.itemAppid;
            m97Var.k = item.categoryId;
            m97Var.l = item.buttonLinkType;
            m97Var.m = item.apkName;
            m97Var.n = item.forumName;
            m97Var.o = ApkDetailPojo.z(item.apkDetail);
            return m97Var;
        }
        return (m97) invokeL.objValue;
    }

    public static m97 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            m97 m97Var = new m97();
            m97Var.a = item.item_id;
            m97Var.b = item.item_name;
            m97Var.c = item.icon_size;
            m97Var.d = item.icon_url;
            m97Var.e = item.tags;
            m97Var.f = item.score;
            m97Var.g = item.star;
            m97Var.h = item.button_name;
            m97Var.i = item.button_link;
            m97Var.j = item.item_appid;
            m97Var.k = item.category_id;
            m97Var.l = item.button_link_type;
            m97Var.m = item.apk_name;
            m97Var.n = item.forum_name;
            m97Var.o = ApkDetailPojo.A(item.apk_detail);
            return m97Var;
        }
        return (m97) invokeL.objValue;
    }
}
