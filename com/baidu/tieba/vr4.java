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
public class vr4 implements Comparable<vr4> {
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

    public vr4(int i, int i2) {
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

    public static vr4 b(TbLinkSpanGroup tbLinkSpanGroup, zv6 zv6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, zv6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            vr4 vr4Var = new vr4(tbLinkSpanGroup.e(), 2);
            if (zv6Var == null) {
                return vr4Var;
            }
            if (TextUtils.isEmpty(zv6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15b9);
            } else {
                str = zv6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0418);
            }
            vr4Var.d = str;
            vr4Var.c = zv6Var.c();
            vr4Var.m = zv6Var.a();
            if (!ListUtils.isEmpty(zv6Var.b()) && zv6Var.b().get(0) != null) {
                vr4Var.e = zv6Var.b().get(0).a();
            }
            vr4Var.l = zv6Var.f();
            vr4Var.f = zv6Var.d();
            if (zv6Var.e() != null) {
                vr4Var.j = zv6Var.e().a();
                vr4Var.k = zv6Var.e().b();
            }
            tbLinkSpanGroup.A(vr4Var);
            return vr4Var;
        }
        return (vr4) invokeLL.objValue;
    }

    public static vr4 c(TbLinkSpanGroup tbLinkSpanGroup, oz4 oz4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, oz4Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            vr4 vr4Var = new vr4(tbLinkSpanGroup.e(), 1);
            if (oz4Var == null) {
                return vr4Var;
            }
            int i = oz4Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = oz4Var.j;
                if (cardLinkInfoData != null) {
                    vr4Var.p = cardLinkInfoData;
                    vr4Var.c = cardLinkInfoData.title;
                    vr4Var.e = cardLinkInfoData.imageUrl;
                    vr4Var.l = cardLinkInfoData.tagText;
                    vr4Var.g = cardLinkInfoData.url;
                    vr4Var.i = false;
                    vr4Var.o = i;
                }
            } else {
                vr4Var.c = oz4Var.e;
                vr4Var.e = oz4Var.d;
                vr4Var.l = oz4Var.f;
                vr4Var.f = oz4Var.g;
                vr4Var.g = oz4Var.c;
                vr4Var.n = oz4Var.h;
                String str = oz4Var.i;
                vr4Var.i = i == 1;
                vr4Var.o = oz4Var.b;
            }
            tbLinkSpanGroup.A(vr4Var);
            return vr4Var;
        }
        return (vr4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull vr4 vr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vr4Var)) == null) ? this.q - vr4Var.q : invokeL.intValue;
    }
}
