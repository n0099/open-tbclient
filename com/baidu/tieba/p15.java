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
public class p15 implements Comparable<p15> {
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

    public p15(int i, int i2) {
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

    public static p15 b(TbLinkSpanGroup tbLinkSpanGroup, qw7 qw7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, qw7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            p15 p15Var = new p15(tbLinkSpanGroup.e(), 2);
            if (qw7Var == null) {
                return p15Var;
            }
            if (TextUtils.isEmpty(qw7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = qw7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            p15Var.d = str;
            p15Var.c = qw7Var.c();
            p15Var.m = qw7Var.a();
            if (!ListUtils.isEmpty(qw7Var.b()) && qw7Var.b().get(0) != null) {
                p15Var.e = qw7Var.b().get(0).a();
            }
            p15Var.l = qw7Var.f();
            p15Var.f = qw7Var.d();
            if (qw7Var.e() != null) {
                p15Var.j = qw7Var.e().a();
                p15Var.k = qw7Var.e().b();
            }
            tbLinkSpanGroup.B(p15Var);
            return p15Var;
        }
        return (p15) invokeLL.objValue;
    }

    public static p15 c(TbLinkSpanGroup tbLinkSpanGroup, wa5 wa5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, wa5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            p15 p15Var = new p15(tbLinkSpanGroup.e(), 1);
            if (wa5Var == null) {
                return p15Var;
            }
            int i = wa5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = wa5Var.j;
                if (cardLinkInfoData != null) {
                    p15Var.p = cardLinkInfoData;
                    p15Var.c = cardLinkInfoData.title;
                    p15Var.e = cardLinkInfoData.imageUrl;
                    p15Var.l = cardLinkInfoData.tagText;
                    p15Var.g = cardLinkInfoData.url;
                    p15Var.i = false;
                    p15Var.o = i;
                }
            } else {
                p15Var.p = wa5Var.j;
                p15Var.c = wa5Var.e;
                p15Var.e = wa5Var.d;
                p15Var.l = wa5Var.f;
                p15Var.f = wa5Var.g;
                p15Var.g = wa5Var.c;
                p15Var.n = wa5Var.h;
                String str = wa5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                p15Var.i = z;
                p15Var.o = wa5Var.b;
            }
            tbLinkSpanGroup.B(p15Var);
            return p15Var;
        }
        return (p15) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull p15 p15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p15Var)) == null) {
            return this.q - p15Var.q;
        }
        return invokeL.intValue;
    }
}
