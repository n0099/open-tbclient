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
/* loaded from: classes7.dex */
public class yx4 implements Comparable<yx4> {
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

    public yx4(int i, int i2) {
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

    public static yx4 b(TbLinkSpanGroup tbLinkSpanGroup, cn7 cn7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, cn7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            yx4 yx4Var = new yx4(tbLinkSpanGroup.e(), 2);
            if (cn7Var == null) {
                return yx4Var;
            }
            if (TextUtils.isEmpty(cn7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = cn7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            yx4Var.d = str;
            yx4Var.c = cn7Var.c();
            yx4Var.m = cn7Var.a();
            if (!ListUtils.isEmpty(cn7Var.b()) && cn7Var.b().get(0) != null) {
                yx4Var.e = cn7Var.b().get(0).a();
            }
            yx4Var.l = cn7Var.f();
            yx4Var.f = cn7Var.d();
            if (cn7Var.e() != null) {
                yx4Var.j = cn7Var.e().a();
                yx4Var.k = cn7Var.e().b();
            }
            tbLinkSpanGroup.B(yx4Var);
            return yx4Var;
        }
        return (yx4) invokeLL.objValue;
    }

    public static yx4 c(TbLinkSpanGroup tbLinkSpanGroup, e75 e75Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, e75Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            yx4 yx4Var = new yx4(tbLinkSpanGroup.e(), 1);
            if (e75Var == null) {
                return yx4Var;
            }
            int i = e75Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = e75Var.j;
                if (cardLinkInfoData != null) {
                    yx4Var.p = cardLinkInfoData;
                    yx4Var.c = cardLinkInfoData.title;
                    yx4Var.e = cardLinkInfoData.imageUrl;
                    yx4Var.l = cardLinkInfoData.tagText;
                    yx4Var.g = cardLinkInfoData.url;
                    yx4Var.i = false;
                    yx4Var.o = i;
                }
            } else {
                yx4Var.p = e75Var.j;
                yx4Var.c = e75Var.e;
                yx4Var.e = e75Var.d;
                yx4Var.l = e75Var.f;
                yx4Var.f = e75Var.g;
                yx4Var.g = e75Var.c;
                yx4Var.n = e75Var.h;
                String str = e75Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                yx4Var.i = z;
                yx4Var.o = e75Var.b;
            }
            tbLinkSpanGroup.B(yx4Var);
            return yx4Var;
        }
        return (yx4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull yx4 yx4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yx4Var)) == null) {
            return this.q - yx4Var.q;
        }
        return invokeL.intValue;
    }
}
