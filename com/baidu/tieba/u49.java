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
public class u49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<om> b;
    public w49 c;
    public z49 d;
    public x49 e;
    public y49 f;
    public a59 g;

    public u49(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new w49(context, b59.c);
            this.d = new z49(context, e59.l);
            this.e = new x49(context, c59.i);
            this.f = new y49(context, d59.g);
            this.g = new a59(context, f59.e);
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
            w49 w49Var = this.c;
            if (w49Var != null) {
                w49Var.notifyDataSetChanged();
            }
            z49 z49Var = this.d;
            if (z49Var != null) {
                z49Var.notifyDataSetChanged();
            }
            x49 x49Var = this.e;
            if (x49Var != null) {
                x49Var.notifyDataSetChanged();
            }
            y49 y49Var = this.f;
            if (y49Var != null) {
                y49Var.notifyDataSetChanged();
            }
            a59 a59Var = this.g;
            if (a59Var != null) {
                a59Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || this.a == null) {
            return;
        }
        List<bn> a = g59.a(dataRes, str);
        if (!ListUtils.isEmpty(a)) {
            this.a.setData(a);
        }
    }
}
