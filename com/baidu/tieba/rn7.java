package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<pm> a;
    public BdTypeRecyclerView b;
    public un7 c;
    public tn7 d;
    public sn7 e;

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public rn7(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        a(forumRulesShowActivity, bdTypeRecyclerView);
    }

    public final void a(ForumRulesShowActivity forumRulesShowActivity, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumRulesShowActivity, bdTypeRecyclerView) == null) {
            this.b = bdTypeRecyclerView;
            this.c = new un7(forumRulesShowActivity, yn7.m);
            this.d = new tn7(forumRulesShowActivity, zn7.d);
            this.e = new sn7(forumRulesShowActivity, xn7.f);
            this.a.add(this.c);
            this.a.add(this.d);
            this.a.add(this.e);
            bdTypeRecyclerView.addAdapters(this.a);
        }
    }

    public void c(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.b;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setData(list);
            }
            tn7 tn7Var = this.d;
            if (tn7Var != null) {
                tn7Var.y(list);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            un7 un7Var = this.c;
            if (un7Var != null) {
                un7Var.setFrom(str);
            }
            sn7 sn7Var = this.e;
            if (sn7Var != null) {
                sn7Var.setFrom(str);
            }
        }
    }
}
