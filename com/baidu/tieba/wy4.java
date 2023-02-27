package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wy4 implements Comparable<wy4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public CardLinkInfoData p;
    public int q;

    public wy4(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
    }

    public static wy4 b(TbLinkSpanGroup tbLinkSpanGroup, da7 da7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, da7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            wy4 wy4Var = new wy4(tbLinkSpanGroup.e(), 2);
            if (da7Var == null) {
                return wy4Var;
            }
            if (TextUtils.isEmpty(da7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = da7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            wy4Var.d = str;
            wy4Var.c = da7Var.c();
            wy4Var.m = da7Var.a();
            if (!ListUtils.isEmpty(da7Var.b()) && da7Var.b().get(0) != null) {
                wy4Var.e = da7Var.b().get(0).a();
            }
            wy4Var.l = da7Var.f();
            wy4Var.f = da7Var.d();
            if (da7Var.e() != null) {
                wy4Var.j = da7Var.e().a();
                wy4Var.k = da7Var.e().b();
            }
            tbLinkSpanGroup.B(wy4Var);
            return wy4Var;
        }
        return (wy4) invokeLL.objValue;
    }

    public static wy4 c(TbLinkSpanGroup tbLinkSpanGroup, z65 z65Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, z65Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            wy4 wy4Var = new wy4(tbLinkSpanGroup.e(), 1);
            if (z65Var == null) {
                return wy4Var;
            }
            int i = z65Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = z65Var.j;
                if (cardLinkInfoData != null) {
                    wy4Var.p = cardLinkInfoData;
                    wy4Var.c = cardLinkInfoData.title;
                    wy4Var.e = cardLinkInfoData.imageUrl;
                    wy4Var.l = cardLinkInfoData.tagText;
                    wy4Var.g = cardLinkInfoData.url;
                    wy4Var.i = false;
                    wy4Var.o = i;
                }
            } else {
                wy4Var.p = z65Var.j;
                wy4Var.c = z65Var.e;
                wy4Var.e = z65Var.d;
                wy4Var.l = z65Var.f;
                wy4Var.f = z65Var.g;
                wy4Var.g = z65Var.c;
                wy4Var.n = z65Var.h;
                String str = z65Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                wy4Var.i = z;
                wy4Var.o = z65Var.b;
            }
            tbLinkSpanGroup.B(wy4Var);
            return wy4Var;
        }
        return (wy4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull wy4 wy4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wy4Var)) == null) {
            return this.q - wy4Var.q;
        }
        return invokeL.intValue;
    }
}
