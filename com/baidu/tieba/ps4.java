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
public class ps4 implements Comparable<ps4> {
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

    public ps4(int i, int i2) {
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

    public static ps4 b(TbLinkSpanGroup tbLinkSpanGroup, ay6 ay6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, ay6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            ps4 ps4Var = new ps4(tbLinkSpanGroup.e(), 2);
            if (ay6Var == null) {
                return ps4Var;
            }
            if (TextUtils.isEmpty(ay6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15f9);
            } else {
                str = ay6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0422);
            }
            ps4Var.d = str;
            ps4Var.c = ay6Var.c();
            ps4Var.m = ay6Var.a();
            if (!ListUtils.isEmpty(ay6Var.b()) && ay6Var.b().get(0) != null) {
                ps4Var.e = ay6Var.b().get(0).a();
            }
            ps4Var.l = ay6Var.f();
            ps4Var.f = ay6Var.d();
            if (ay6Var.e() != null) {
                ps4Var.j = ay6Var.e().a();
                ps4Var.k = ay6Var.e().b();
            }
            tbLinkSpanGroup.y(ps4Var);
            return ps4Var;
        }
        return (ps4) invokeLL.objValue;
    }

    public static ps4 c(TbLinkSpanGroup tbLinkSpanGroup, o05 o05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, o05Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            ps4 ps4Var = new ps4(tbLinkSpanGroup.e(), 1);
            if (o05Var == null) {
                return ps4Var;
            }
            int i = o05Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = o05Var.j;
                if (cardLinkInfoData != null) {
                    ps4Var.p = cardLinkInfoData;
                    ps4Var.c = cardLinkInfoData.title;
                    ps4Var.e = cardLinkInfoData.imageUrl;
                    ps4Var.l = cardLinkInfoData.tagText;
                    ps4Var.g = cardLinkInfoData.url;
                    ps4Var.i = false;
                    ps4Var.o = i;
                }
            } else {
                ps4Var.c = o05Var.e;
                ps4Var.e = o05Var.d;
                ps4Var.l = o05Var.f;
                ps4Var.f = o05Var.g;
                ps4Var.g = o05Var.c;
                ps4Var.n = o05Var.h;
                String str = o05Var.i;
                if (i != 1) {
                    z = false;
                }
                ps4Var.i = z;
                ps4Var.o = o05Var.b;
            }
            tbLinkSpanGroup.y(ps4Var);
            return ps4Var;
        }
        return (ps4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull ps4 ps4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ps4Var)) == null) {
            return this.q - ps4Var.q;
        }
        return invokeL.intValue;
    }
}
