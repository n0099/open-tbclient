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
/* loaded from: classes4.dex */
public class ir4 implements Comparable<ir4> {
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

    public ir4(int i, int i2) {
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

    public static ir4 b(TbLinkSpanGroup tbLinkSpanGroup, lv6 lv6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, lv6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ir4 ir4Var = new ir4(tbLinkSpanGroup.e(), 2);
            if (lv6Var == null) {
                return ir4Var;
            }
            if (TextUtils.isEmpty(lv6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15b9);
            } else {
                str = lv6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0418);
            }
            ir4Var.d = str;
            ir4Var.c = lv6Var.c();
            ir4Var.m = lv6Var.a();
            if (!ListUtils.isEmpty(lv6Var.b()) && lv6Var.b().get(0) != null) {
                ir4Var.e = lv6Var.b().get(0).a();
            }
            ir4Var.l = lv6Var.f();
            ir4Var.f = lv6Var.d();
            if (lv6Var.e() != null) {
                ir4Var.j = lv6Var.e().a();
                ir4Var.k = lv6Var.e().b();
            }
            tbLinkSpanGroup.A(ir4Var);
            return ir4Var;
        }
        return (ir4) invokeLL.objValue;
    }

    public static ir4 c(TbLinkSpanGroup tbLinkSpanGroup, bz4 bz4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, bz4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ir4 ir4Var = new ir4(tbLinkSpanGroup.e(), 1);
            if (bz4Var == null) {
                return ir4Var;
            }
            int i = bz4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = bz4Var.j;
                if (cardLinkInfoData != null) {
                    ir4Var.p = cardLinkInfoData;
                    ir4Var.c = cardLinkInfoData.title;
                    ir4Var.e = cardLinkInfoData.imageUrl;
                    ir4Var.l = cardLinkInfoData.tagText;
                    ir4Var.g = cardLinkInfoData.url;
                    ir4Var.i = false;
                    ir4Var.o = i;
                }
            } else {
                ir4Var.c = bz4Var.e;
                ir4Var.e = bz4Var.d;
                ir4Var.l = bz4Var.f;
                ir4Var.f = bz4Var.g;
                ir4Var.g = bz4Var.c;
                ir4Var.n = bz4Var.h;
                String str = bz4Var.i;
                ir4Var.i = i == 1;
                ir4Var.o = bz4Var.b;
            }
            tbLinkSpanGroup.A(ir4Var);
            return ir4Var;
        }
        return (ir4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ir4 ir4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ir4Var)) == null) ? this.q - ir4Var.q : invokeL.intValue;
    }
}
