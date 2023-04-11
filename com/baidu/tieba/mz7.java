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
public class mz7 {
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

    public mz7() {
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

    public static mz7 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            mz7 mz7Var = new mz7();
            mz7Var.a = item.itemId;
            mz7Var.b = item.itemName;
            mz7Var.c = item.iconSize;
            mz7Var.d = item.iconUrl;
            mz7Var.e = item.tags;
            mz7Var.f = item.score;
            mz7Var.g = item.star;
            mz7Var.h = item.buttonName;
            mz7Var.i = item.buttonLink;
            mz7Var.j = item.itemAppid;
            mz7Var.k = item.categoryId;
            mz7Var.l = item.buttonLinkType;
            mz7Var.m = item.apkName;
            mz7Var.n = item.forumName;
            mz7Var.o = ApkDetailPojo.Q(item.apkDetail);
            return mz7Var;
        }
        return (mz7) invokeL.objValue;
    }

    public static mz7 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            mz7 mz7Var = new mz7();
            mz7Var.a = item.item_id;
            mz7Var.b = item.item_name;
            mz7Var.c = item.icon_size;
            mz7Var.d = item.icon_url;
            mz7Var.e = item.tags;
            mz7Var.f = item.score;
            mz7Var.g = item.star;
            mz7Var.h = item.button_name;
            mz7Var.i = item.button_link;
            mz7Var.j = item.item_appid;
            mz7Var.k = item.category_id;
            mz7Var.l = item.button_link_type;
            mz7Var.m = item.apk_name;
            mz7Var.n = item.forum_name;
            mz7Var.o = ApkDetailPojo.R(item.apk_detail);
            return mz7Var;
        }
        return (mz7) invokeL.objValue;
    }
}
