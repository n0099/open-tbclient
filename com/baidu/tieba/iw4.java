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
public class iw4 implements Comparable<iw4> {
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

    public iw4(int i, int i2) {
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

    public static iw4 b(TbLinkSpanGroup tbLinkSpanGroup, iu7 iu7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, iu7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            iw4 iw4Var = new iw4(tbLinkSpanGroup.e(), 2);
            if (iu7Var == null) {
                return iw4Var;
            }
            if (TextUtils.isEmpty(iu7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = iu7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            iw4Var.d = str;
            iw4Var.c = iu7Var.c();
            iw4Var.m = iu7Var.a();
            if (!ListUtils.isEmpty(iu7Var.b()) && iu7Var.b().get(0) != null) {
                iw4Var.e = iu7Var.b().get(0).a();
            }
            iw4Var.l = iu7Var.f();
            iw4Var.f = iu7Var.d();
            if (iu7Var.e() != null) {
                iw4Var.j = iu7Var.e().a();
                iw4Var.k = iu7Var.e().b();
            }
            tbLinkSpanGroup.B(iw4Var);
            return iw4Var;
        }
        return (iw4) invokeLL.objValue;
    }

    public static iw4 c(TbLinkSpanGroup tbLinkSpanGroup, z55 z55Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, z55Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            iw4 iw4Var = new iw4(tbLinkSpanGroup.e(), 1);
            if (z55Var == null) {
                return iw4Var;
            }
            int i = z55Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = z55Var.j;
                if (cardLinkInfoData != null) {
                    iw4Var.p = cardLinkInfoData;
                    iw4Var.c = cardLinkInfoData.title;
                    iw4Var.e = cardLinkInfoData.imageUrl;
                    iw4Var.l = cardLinkInfoData.tagText;
                    iw4Var.g = cardLinkInfoData.url;
                    iw4Var.i = false;
                    iw4Var.o = i;
                }
            } else {
                iw4Var.p = z55Var.j;
                iw4Var.c = z55Var.e;
                iw4Var.e = z55Var.d;
                iw4Var.l = z55Var.f;
                iw4Var.f = z55Var.g;
                iw4Var.g = z55Var.c;
                iw4Var.n = z55Var.h;
                String str = z55Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                iw4Var.i = z;
                iw4Var.o = z55Var.b;
            }
            tbLinkSpanGroup.B(iw4Var);
            return iw4Var;
        }
        return (iw4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull iw4 iw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iw4Var)) == null) {
            return this.q - iw4Var.q;
        }
        return invokeL.intValue;
    }
}
