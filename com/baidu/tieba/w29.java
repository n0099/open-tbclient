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
public class w29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<ln> b;
    public y29 c;
    public b39 d;
    public z29 e;
    public a39 f;
    public c39 g;

    public w29(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new y29(context, d39.c);
            this.d = new b39(context, g39.l);
            this.e = new z29(context, e39.i);
            this.f = new a39(context, f39.g);
            this.g = new c39(context, h39.e);
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
            y29 y29Var = this.c;
            if (y29Var != null) {
                y29Var.notifyDataSetChanged();
            }
            b39 b39Var = this.d;
            if (b39Var != null) {
                b39Var.notifyDataSetChanged();
            }
            z29 z29Var = this.e;
            if (z29Var != null) {
                z29Var.notifyDataSetChanged();
            }
            a39 a39Var = this.f;
            if (a39Var != null) {
                a39Var.notifyDataSetChanged();
            }
            c39 c39Var = this.g;
            if (c39Var != null) {
                c39Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || this.a == null) {
            return;
        }
        List<yn> a = i39.a(dataRes, str);
        if (!ListUtils.isEmpty(a)) {
            this.a.setData(a);
        }
    }
}
