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
public class w59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<pm> b;
    public y59 c;
    public b69 d;
    public z59 e;
    public a69 f;
    public c69 g;

    public w59(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new y59(context, d69.c);
            this.d = new b69(context, g69.l);
            this.e = new z59(context, e69.i);
            this.f = new a69(context, f69.g);
            this.g = new c69(context, h69.e);
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
            y59 y59Var = this.c;
            if (y59Var != null) {
                y59Var.notifyDataSetChanged();
            }
            b69 b69Var = this.d;
            if (b69Var != null) {
                b69Var.notifyDataSetChanged();
            }
            z59 z59Var = this.e;
            if (z59Var != null) {
                z59Var.notifyDataSetChanged();
            }
            a69 a69Var = this.f;
            if (a69Var != null) {
                a69Var.notifyDataSetChanged();
            }
            c69 c69Var = this.g;
            if (c69Var != null) {
                c69Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || this.a == null) {
            return;
        }
        List<cn> a = i69.a(dataRes, str);
        if (!ListUtils.isEmpty(a)) {
            this.a.setData(a);
        }
    }
}
