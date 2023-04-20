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
public class ix4 implements Comparable<ix4> {
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

    public ix4(int i, int i2) {
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

    public static ix4 b(TbLinkSpanGroup tbLinkSpanGroup, hl7 hl7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, hl7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ix4 ix4Var = new ix4(tbLinkSpanGroup.e(), 2);
            if (hl7Var == null) {
                return ix4Var;
            }
            if (TextUtils.isEmpty(hl7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = hl7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            ix4Var.d = str;
            ix4Var.c = hl7Var.c();
            ix4Var.m = hl7Var.a();
            if (!ListUtils.isEmpty(hl7Var.b()) && hl7Var.b().get(0) != null) {
                ix4Var.e = hl7Var.b().get(0).a();
            }
            ix4Var.l = hl7Var.f();
            ix4Var.f = hl7Var.d();
            if (hl7Var.e() != null) {
                ix4Var.j = hl7Var.e().a();
                ix4Var.k = hl7Var.e().b();
            }
            tbLinkSpanGroup.B(ix4Var);
            return ix4Var;
        }
        return (ix4) invokeLL.objValue;
    }

    public static ix4 c(TbLinkSpanGroup tbLinkSpanGroup, o65 o65Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, o65Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            ix4 ix4Var = new ix4(tbLinkSpanGroup.e(), 1);
            if (o65Var == null) {
                return ix4Var;
            }
            int i = o65Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = o65Var.j;
                if (cardLinkInfoData != null) {
                    ix4Var.p = cardLinkInfoData;
                    ix4Var.c = cardLinkInfoData.title;
                    ix4Var.e = cardLinkInfoData.imageUrl;
                    ix4Var.l = cardLinkInfoData.tagText;
                    ix4Var.g = cardLinkInfoData.url;
                    ix4Var.i = false;
                    ix4Var.o = i;
                }
            } else {
                ix4Var.p = o65Var.j;
                ix4Var.c = o65Var.e;
                ix4Var.e = o65Var.d;
                ix4Var.l = o65Var.f;
                ix4Var.f = o65Var.g;
                ix4Var.g = o65Var.c;
                ix4Var.n = o65Var.h;
                String str = o65Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                ix4Var.i = z;
                ix4Var.o = o65Var.b;
            }
            tbLinkSpanGroup.B(ix4Var);
            return ix4Var;
        }
        return (ix4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ix4 ix4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ix4Var)) == null) {
            return this.q - ix4Var.q;
        }
        return invokeL.intValue;
    }
}
