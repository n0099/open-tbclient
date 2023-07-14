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
public class r25 implements Comparable<r25> {
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

    public r25(int i, int i2) {
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

    public static r25 b(TbLinkSpanGroup tbLinkSpanGroup, hz7 hz7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, hz7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            r25 r25Var = new r25(tbLinkSpanGroup.e(), 2);
            if (hz7Var == null) {
                return r25Var;
            }
            if (TextUtils.isEmpty(hz7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = hz7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            r25Var.d = str;
            r25Var.c = hz7Var.c();
            r25Var.m = hz7Var.a();
            if (!ListUtils.isEmpty(hz7Var.b()) && hz7Var.b().get(0) != null) {
                r25Var.e = hz7Var.b().get(0).a();
            }
            r25Var.l = hz7Var.f();
            r25Var.f = hz7Var.d();
            if (hz7Var.e() != null) {
                r25Var.j = hz7Var.e().a();
                r25Var.k = hz7Var.e().b();
            }
            tbLinkSpanGroup.B(r25Var);
            return r25Var;
        }
        return (r25) invokeLL.objValue;
    }

    public static r25 c(TbLinkSpanGroup tbLinkSpanGroup, hc5 hc5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, hc5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            r25 r25Var = new r25(tbLinkSpanGroup.e(), 1);
            if (hc5Var == null) {
                return r25Var;
            }
            int i = hc5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = hc5Var.j;
                if (cardLinkInfoData != null) {
                    r25Var.p = cardLinkInfoData;
                    r25Var.c = cardLinkInfoData.title;
                    r25Var.e = cardLinkInfoData.imageUrl;
                    r25Var.l = cardLinkInfoData.tagText;
                    r25Var.g = cardLinkInfoData.url;
                    r25Var.i = false;
                    r25Var.o = i;
                }
            } else {
                r25Var.p = hc5Var.j;
                r25Var.c = hc5Var.e;
                r25Var.e = hc5Var.d;
                r25Var.l = hc5Var.f;
                r25Var.f = hc5Var.g;
                r25Var.g = hc5Var.c;
                r25Var.n = hc5Var.h;
                String str = hc5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                r25Var.i = z;
                r25Var.o = hc5Var.b;
            }
            tbLinkSpanGroup.B(r25Var);
            return r25Var;
        }
        return (r25) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull r25 r25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r25Var)) == null) {
            return this.q - r25Var.q;
        }
        return invokeL.intValue;
    }
}
