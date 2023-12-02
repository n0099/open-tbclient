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
public class ri9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<ci> b;
    public ti9 c;
    public wi9 d;
    public ui9 e;
    public vi9 f;
    public xi9 g;

    public ri9(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new ti9(context, yi9.c);
            this.d = new wi9(context, bj9.l);
            this.e = new ui9(context, zi9.i);
            this.f = new vi9(context, aj9.g);
            this.g = new xi9(context, cj9.e);
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
            ti9 ti9Var = this.c;
            if (ti9Var != null) {
                ti9Var.notifyDataSetChanged();
            }
            wi9 wi9Var = this.d;
            if (wi9Var != null) {
                wi9Var.notifyDataSetChanged();
            }
            ui9 ui9Var = this.e;
            if (ui9Var != null) {
                ui9Var.notifyDataSetChanged();
            }
            vi9 vi9Var = this.f;
            if (vi9Var != null) {
                vi9Var.notifyDataSetChanged();
            }
            xi9 xi9Var = this.g;
            if (xi9Var != null) {
                xi9Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || this.a == null) {
            return;
        }
        List<pi> a = dj9.a(dataRes, str);
        if (!ListUtils.isEmpty(a)) {
            this.a.setData(a);
        }
    }
}
