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
public class j25 implements Comparable<j25> {
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

    public j25(int i, int i2) {
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

    public static j25 b(TbLinkSpanGroup tbLinkSpanGroup, ru7 ru7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, ru7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            j25 j25Var = new j25(tbLinkSpanGroup.e(), 2);
            if (ru7Var == null) {
                return j25Var;
            }
            if (TextUtils.isEmpty(ru7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = ru7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            j25Var.d = str;
            j25Var.c = ru7Var.c();
            j25Var.m = ru7Var.a();
            if (!ListUtils.isEmpty(ru7Var.b()) && ru7Var.b().get(0) != null) {
                j25Var.e = ru7Var.b().get(0).a();
            }
            j25Var.l = ru7Var.f();
            j25Var.f = ru7Var.d();
            if (ru7Var.e() != null) {
                j25Var.j = ru7Var.e().a();
                j25Var.k = ru7Var.e().b();
            }
            tbLinkSpanGroup.B(j25Var);
            return j25Var;
        }
        return (j25) invokeLL.objValue;
    }

    public static j25 c(TbLinkSpanGroup tbLinkSpanGroup, pb5 pb5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, pb5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            j25 j25Var = new j25(tbLinkSpanGroup.e(), 1);
            if (pb5Var == null) {
                return j25Var;
            }
            int i = pb5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = pb5Var.j;
                if (cardLinkInfoData != null) {
                    j25Var.p = cardLinkInfoData;
                    j25Var.c = cardLinkInfoData.title;
                    j25Var.e = cardLinkInfoData.imageUrl;
                    j25Var.l = cardLinkInfoData.tagText;
                    j25Var.g = cardLinkInfoData.url;
                    j25Var.i = false;
                    j25Var.o = i;
                }
            } else {
                j25Var.p = pb5Var.j;
                j25Var.c = pb5Var.e;
                j25Var.e = pb5Var.d;
                j25Var.l = pb5Var.f;
                j25Var.f = pb5Var.g;
                j25Var.g = pb5Var.c;
                j25Var.n = pb5Var.h;
                String str = pb5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                j25Var.i = z;
                j25Var.o = pb5Var.b;
            }
            tbLinkSpanGroup.B(j25Var);
            return j25Var;
        }
        return (j25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull j25 j25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j25Var)) == null) {
            return this.q - j25Var.q;
        }
        return invokeL.intValue;
    }
}
