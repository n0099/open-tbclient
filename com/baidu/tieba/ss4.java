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
public class ss4 implements Comparable<ss4> {
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

    public ss4(int i, int i2) {
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

    public static ss4 b(TbLinkSpanGroup tbLinkSpanGroup, yy6 yy6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, yy6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ss4 ss4Var = new ss4(tbLinkSpanGroup.e(), 2);
            if (yy6Var == null) {
                return ss4Var;
            }
            if (TextUtils.isEmpty(yy6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = yy6Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            ss4Var.d = str;
            ss4Var.c = yy6Var.c();
            ss4Var.m = yy6Var.a();
            if (!ListUtils.isEmpty(yy6Var.b()) && yy6Var.b().get(0) != null) {
                ss4Var.e = yy6Var.b().get(0).a();
            }
            ss4Var.l = yy6Var.f();
            ss4Var.f = yy6Var.d();
            if (yy6Var.e() != null) {
                ss4Var.j = yy6Var.e().a();
                ss4Var.k = yy6Var.e().b();
            }
            tbLinkSpanGroup.z(ss4Var);
            return ss4Var;
        }
        return (ss4) invokeLL.objValue;
    }

    public static ss4 c(TbLinkSpanGroup tbLinkSpanGroup, p05 p05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, p05Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            ss4 ss4Var = new ss4(tbLinkSpanGroup.e(), 1);
            if (p05Var == null) {
                return ss4Var;
            }
            int i = p05Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = p05Var.j;
                if (cardLinkInfoData != null) {
                    ss4Var.p = cardLinkInfoData;
                    ss4Var.c = cardLinkInfoData.title;
                    ss4Var.e = cardLinkInfoData.imageUrl;
                    ss4Var.l = cardLinkInfoData.tagText;
                    ss4Var.g = cardLinkInfoData.url;
                    ss4Var.i = false;
                    ss4Var.o = i;
                }
            } else {
                ss4Var.p = p05Var.j;
                ss4Var.c = p05Var.e;
                ss4Var.e = p05Var.d;
                ss4Var.l = p05Var.f;
                ss4Var.f = p05Var.g;
                ss4Var.g = p05Var.c;
                ss4Var.n = p05Var.h;
                String str = p05Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                ss4Var.i = z;
                ss4Var.o = p05Var.b;
            }
            tbLinkSpanGroup.z(ss4Var);
            return ss4Var;
        }
        return (ss4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ss4 ss4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ss4Var)) == null) {
            return this.q - ss4Var.q;
        }
        return invokeL.intValue;
    }
}
