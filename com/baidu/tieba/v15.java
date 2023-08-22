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
/* loaded from: classes8.dex */
public class v15 implements Comparable<v15> {
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

    public v15(int i, int i2) {
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

    public static v15 b(TbLinkSpanGroup tbLinkSpanGroup, ly7 ly7Var) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, ly7Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            v15 v15Var = new v15(tbLinkSpanGroup.e(), 2);
            if (ly7Var == null) {
                return v15Var;
            }
            if (TextUtils.isEmpty(ly7Var.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = ly7Var.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            v15Var.d = str;
            v15Var.c = ly7Var.c();
            v15Var.m = ly7Var.a();
            if (!ListUtils.isEmpty(ly7Var.b()) && ly7Var.b().get(0) != null) {
                v15Var.e = ly7Var.b().get(0).a();
            }
            v15Var.l = ly7Var.f();
            v15Var.f = ly7Var.d();
            if (ly7Var.e() != null) {
                v15Var.j = ly7Var.e().a();
                v15Var.k = ly7Var.e().b();
            }
            tbLinkSpanGroup.B(v15Var);
            return v15Var;
        }
        return (v15) invokeLL.objValue;
    }

    public static v15 c(TbLinkSpanGroup tbLinkSpanGroup, db5 db5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, db5Var)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            boolean z = true;
            v15 v15Var = new v15(tbLinkSpanGroup.e(), 1);
            if (db5Var == null) {
                return v15Var;
            }
            int i = db5Var.b;
            if (i == 4) {
                CardLinkInfoData cardLinkInfoData = db5Var.j;
                if (cardLinkInfoData != null) {
                    v15Var.p = cardLinkInfoData;
                    v15Var.c = cardLinkInfoData.title;
                    v15Var.e = cardLinkInfoData.imageUrl;
                    v15Var.l = cardLinkInfoData.tagText;
                    v15Var.g = cardLinkInfoData.url;
                    v15Var.i = false;
                    v15Var.o = i;
                }
            } else {
                v15Var.p = db5Var.j;
                v15Var.c = db5Var.e;
                v15Var.e = db5Var.d;
                v15Var.l = db5Var.f;
                v15Var.f = db5Var.g;
                v15Var.g = db5Var.c;
                v15Var.n = db5Var.h;
                String str = db5Var.i;
                if (i != 1 && i != 5) {
                    z = false;
                }
                v15Var.i = z;
                v15Var.o = db5Var.b;
            }
            tbLinkSpanGroup.B(v15Var);
            return v15Var;
        }
        return (v15) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull v15 v15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v15Var)) == null) {
            return this.q - v15Var.q;
        }
        return invokeL.intValue;
    }
}
