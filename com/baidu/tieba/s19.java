package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.DataRes;
/* loaded from: classes8.dex */
public class s19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<lh> b;
    public u19 c;
    public x19 d;
    public v19 e;
    public w19 f;
    public y19 g;

    public s19(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.c = new u19(context, z19.c);
            this.d = new x19(context, c29.l);
            this.e = new v19(context, a29.i);
            this.f = new w19(context, b29.g);
            this.g = new y19(context, d29.e);
            this.b.add(this.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.b.add(this.f);
            this.b.add(this.g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.addAdapters(this.b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u19 u19Var = this.c;
            if (u19Var != null) {
                u19Var.notifyDataSetChanged();
            }
            x19 x19Var = this.d;
            if (x19Var != null) {
                x19Var.notifyDataSetChanged();
            }
            v19 v19Var = this.e;
            if (v19Var != null) {
                v19Var.notifyDataSetChanged();
            }
            w19 w19Var = this.f;
            if (w19Var != null) {
                w19Var.notifyDataSetChanged();
            }
            y19 y19Var = this.g;
            if (y19Var != null) {
                y19Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || this.a == null) {
            return;
        }
        List<yh> a = e29.a(dataRes, str);
        if (!ListUtils.isEmpty(a)) {
            this.a.setData(a);
        }
    }
}
