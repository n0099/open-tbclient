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
/* loaded from: classes5.dex */
public class px4 implements Comparable<px4> {
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

    public px4(int i, int i2) {
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

    public static px4 b(TbLinkSpanGroup tbLinkSpanGroup, h77 h77Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, h77Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            px4 px4Var = new px4(tbLinkSpanGroup.e(), 2);
            if (h77Var == null) {
                return px4Var;
            }
            if (TextUtils.isEmpty(h77Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = h77Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            px4Var.d = str;
            px4Var.c = h77Var.c();
            px4Var.m = h77Var.a();
            if (!ListUtils.isEmpty(h77Var.b()) && h77Var.b().get(0) != null) {
                px4Var.e = h77Var.b().get(0).a();
            }
            px4Var.l = h77Var.f();
            px4Var.f = h77Var.d();
            if (h77Var.e() != null) {
                px4Var.j = h77Var.e().a();
                px4Var.k = h77Var.e().b();
            }
            tbLinkSpanGroup.B(px4Var);
            return px4Var;
        }
        return (px4) invokeLL.objValue;
    }

    public static px4 c(TbLinkSpanGroup tbLinkSpanGroup, n55 n55Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, n55Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            px4 px4Var = new px4(tbLinkSpanGroup.e(), 1);
            if (n55Var == null) {
                return px4Var;
            }
            int i = n55Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = n55Var.j;
                if (cardLinkInfoData != null) {
                    px4Var.p = cardLinkInfoData;
                    px4Var.c = cardLinkInfoData.title;
                    px4Var.e = cardLinkInfoData.imageUrl;
                    px4Var.l = cardLinkInfoData.tagText;
                    px4Var.g = cardLinkInfoData.url;
                    px4Var.i = false;
                    px4Var.o = i;
                }
            } else {
                px4Var.p = n55Var.j;
                px4Var.c = n55Var.e;
                px4Var.e = n55Var.d;
                px4Var.l = n55Var.f;
                px4Var.f = n55Var.g;
                px4Var.g = n55Var.c;
                px4Var.n = n55Var.h;
                String str = n55Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                px4Var.i = z;
                px4Var.o = n55Var.b;
            }
            tbLinkSpanGroup.B(px4Var);
            return px4Var;
        }
        return (px4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull px4 px4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, px4Var)) == null) {
            return this.q - px4Var.q;
        }
        return invokeL.intValue;
    }
}
