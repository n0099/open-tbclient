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
public class m98 {
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

    public m98() {
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

    public static m98 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            m98 m98Var = new m98();
            m98Var.a = item.itemId;
            m98Var.b = item.itemName;
            m98Var.c = item.iconSize;
            m98Var.d = item.iconUrl;
            m98Var.e = item.tags;
            m98Var.f = item.score;
            m98Var.g = item.star;
            m98Var.h = item.buttonName;
            m98Var.i = item.buttonLink;
            m98Var.j = item.itemAppid;
            m98Var.k = item.categoryId;
            m98Var.l = item.buttonLinkType;
            m98Var.m = item.apkName;
            m98Var.n = item.forumName;
            m98Var.o = ApkDetailPojo.U(item.apkDetail);
            return m98Var;
        }
        return (m98) invokeL.objValue;
    }

    public static m98 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            m98 m98Var = new m98();
            m98Var.a = item.item_id;
            m98Var.b = item.item_name;
            m98Var.c = item.icon_size;
            m98Var.d = item.icon_url;
            m98Var.e = item.tags;
            m98Var.f = item.score;
            m98Var.g = item.star;
            m98Var.h = item.button_name;
            m98Var.i = item.button_link;
            m98Var.j = item.item_appid;
            m98Var.k = item.category_id;
            m98Var.l = item.button_link_type;
            m98Var.m = item.apk_name;
            m98Var.n = item.forum_name;
            m98Var.o = ApkDetailPojo.V(item.apk_detail);
            return m98Var;
        }
        return (m98) invokeL.objValue;
    }
}
