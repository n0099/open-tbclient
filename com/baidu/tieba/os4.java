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
public class os4 implements Comparable<os4> {
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

    public os4(int i, int i2) {
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

    public static os4 b(TbLinkSpanGroup tbLinkSpanGroup, px6 px6Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, px6Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            os4 os4Var = new os4(tbLinkSpanGroup.e(), 2);
            if (px6Var == null) {
                return os4Var;
            }
            if (TextUtils.isEmpty(px6Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15f2);
            } else {
                str = px6Var.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0421);
            }
            os4Var.d = str;
            os4Var.c = px6Var.c();
            os4Var.m = px6Var.a();
            if (!ListUtils.isEmpty(px6Var.b()) && px6Var.b().get(0) != null) {
                os4Var.e = px6Var.b().get(0).a();
            }
            os4Var.l = px6Var.f();
            os4Var.f = px6Var.d();
            if (px6Var.e() != null) {
                os4Var.j = px6Var.e().a();
                os4Var.k = px6Var.e().b();
            }
            tbLinkSpanGroup.y(os4Var);
            return os4Var;
        }
        return (os4) invokeLL.objValue;
    }

    public static os4 c(TbLinkSpanGroup tbLinkSpanGroup, j05 j05Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, j05Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            os4 os4Var = new os4(tbLinkSpanGroup.e(), 1);
            if (j05Var == null) {
                return os4Var;
            }
            int i = j05Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = j05Var.j;
                if (cardLinkInfoData != null) {
                    os4Var.p = cardLinkInfoData;
                    os4Var.c = cardLinkInfoData.title;
                    os4Var.e = cardLinkInfoData.imageUrl;
                    os4Var.l = cardLinkInfoData.tagText;
                    os4Var.g = cardLinkInfoData.url;
                    os4Var.i = false;
                    os4Var.o = i;
                }
            } else {
                os4Var.c = j05Var.e;
                os4Var.e = j05Var.d;
                os4Var.l = j05Var.f;
                os4Var.f = j05Var.g;
                os4Var.g = j05Var.c;
                os4Var.n = j05Var.h;
                String str = j05Var.i;
                if (i != 1) {
                    z = false;
                }
                os4Var.i = z;
                os4Var.o = j05Var.b;
            }
            tbLinkSpanGroup.y(os4Var);
            return os4Var;
        }
        return (os4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull os4 os4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, os4Var)) == null) {
            return this.q - os4Var.q;
        }
        return invokeL.intValue;
    }
}
