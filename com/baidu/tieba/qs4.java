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
public class qs4 implements Comparable<qs4> {
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

    public qs4(int i, int i2) {
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

    public static qs4 b(TbLinkSpanGroup tbLinkSpanGroup, by6 by6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, by6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            qs4 qs4Var = new qs4(tbLinkSpanGroup.e(), 2);
            if (by6Var == null) {
                return qs4Var;
            }
            if (TextUtils.isEmpty(by6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15f9);
            } else {
                str = by6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0422);
            }
            qs4Var.d = str;
            qs4Var.c = by6Var.c();
            qs4Var.m = by6Var.a();
            if (!ListUtils.isEmpty(by6Var.b()) && by6Var.b().get(0) != null) {
                qs4Var.e = by6Var.b().get(0).a();
            }
            qs4Var.l = by6Var.f();
            qs4Var.f = by6Var.d();
            if (by6Var.e() != null) {
                qs4Var.j = by6Var.e().a();
                qs4Var.k = by6Var.e().b();
            }
            tbLinkSpanGroup.y(qs4Var);
            return qs4Var;
        }
        return (qs4) invokeLL.objValue;
    }

    public static qs4 c(TbLinkSpanGroup tbLinkSpanGroup, p05 p05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, p05Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            qs4 qs4Var = new qs4(tbLinkSpanGroup.e(), 1);
            if (p05Var == null) {
                return qs4Var;
            }
            int i = p05Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = p05Var.j;
                if (cardLinkInfoData != null) {
                    qs4Var.p = cardLinkInfoData;
                    qs4Var.c = cardLinkInfoData.title;
                    qs4Var.e = cardLinkInfoData.imageUrl;
                    qs4Var.l = cardLinkInfoData.tagText;
                    qs4Var.g = cardLinkInfoData.url;
                    qs4Var.i = false;
                    qs4Var.o = i;
                }
            } else {
                qs4Var.c = p05Var.e;
                qs4Var.e = p05Var.d;
                qs4Var.l = p05Var.f;
                qs4Var.f = p05Var.g;
                qs4Var.g = p05Var.c;
                qs4Var.n = p05Var.h;
                String str = p05Var.i;
                if (i != 1) {
                    z = false;
                }
                qs4Var.i = z;
                qs4Var.o = p05Var.b;
            }
            tbLinkSpanGroup.y(qs4Var);
            return qs4Var;
        }
        return (qs4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull qs4 qs4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qs4Var)) == null) {
            return this.q - qs4Var.q;
        }
        return invokeL.intValue;
    }
}
