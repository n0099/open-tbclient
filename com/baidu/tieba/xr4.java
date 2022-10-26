package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tieba.gw6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xr4 implements Comparable {
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

    public xr4(int i, int i2) {
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

    public static xr4 b(TbLinkSpanGroup tbLinkSpanGroup, gw6 gw6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, gw6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            xr4 xr4Var = new xr4(tbLinkSpanGroup.e(), 2);
            if (gw6Var == null) {
                return xr4Var;
            }
            if (TextUtils.isEmpty(gw6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15d4);
            } else {
                str = gw6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f041f);
            }
            xr4Var.d = str;
            xr4Var.c = gw6Var.c();
            xr4Var.m = gw6Var.a();
            if (!ListUtils.isEmpty(gw6Var.b()) && gw6Var.b().get(0) != null) {
                xr4Var.e = ((gw6.a) gw6Var.b().get(0)).a();
            }
            xr4Var.l = gw6Var.f();
            xr4Var.f = gw6Var.d();
            if (gw6Var.e() != null) {
                xr4Var.j = gw6Var.e().a();
                xr4Var.k = gw6Var.e().b();
            }
            tbLinkSpanGroup.y(xr4Var);
            return xr4Var;
        }
        return (xr4) invokeLL.objValue;
    }

    public static xr4 c(TbLinkSpanGroup tbLinkSpanGroup, tz4 tz4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, tz4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            xr4 xr4Var = new xr4(tbLinkSpanGroup.e(), 1);
            if (tz4Var == null) {
                return xr4Var;
            }
            int i = tz4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = tz4Var.j;
                if (cardLinkInfoData != null) {
                    xr4Var.p = cardLinkInfoData;
                    xr4Var.c = cardLinkInfoData.title;
                    xr4Var.e = cardLinkInfoData.imageUrl;
                    xr4Var.l = cardLinkInfoData.tagText;
                    xr4Var.g = cardLinkInfoData.url;
                    xr4Var.i = false;
                    xr4Var.o = i;
                }
            } else {
                xr4Var.c = tz4Var.e;
                xr4Var.e = tz4Var.d;
                xr4Var.l = tz4Var.f;
                xr4Var.f = tz4Var.g;
                xr4Var.g = tz4Var.c;
                xr4Var.n = tz4Var.h;
                String str = tz4Var.i;
                if (i != 1) {
                    z = false;
                }
                xr4Var.i = z;
                xr4Var.o = tz4Var.b;
            }
            tbLinkSpanGroup.y(xr4Var);
            return xr4Var;
        }
        return (xr4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(xr4 xr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xr4Var)) == null) {
            return this.q - xr4Var.q;
        }
        return invokeL.intValue;
    }
}
