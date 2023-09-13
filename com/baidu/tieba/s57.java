package com.baidu.tieba;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class s57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public final List<pm> c;
    public r57 d;
    public t57 e;
    public final List<cn> f;

    public s57(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, forumEmotionModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.f = new ArrayList();
        this.a = tbPageContext;
        this.b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.b != null) {
            this.f.addAll(list);
            this.b.setData(this.f);
        }
        d();
    }

    public void f(q57 q57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q57Var) == null) {
            this.d.u(q57Var);
            this.e.u(q57Var);
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f.size();
        }
        return invokeV.intValue;
    }

    public void d() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeListView = this.b) != null && bdTypeListView.getAdapter2() != null && (this.b.getAdapter2() instanceof BaseAdapter)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumEmotionModel) == null) {
            r57 r57Var = new r57(this.a, forumEmotionModel.O(), w57.b);
            this.d = r57Var;
            this.c.add(r57Var);
            t57 t57Var = new t57(this.a, forumEmotionModel.O(), u57.a);
            this.e = t57Var;
            this.c.add(t57Var);
            this.b.addAdapters(this.c);
        }
    }

    public void e(List<cn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f)) {
            this.f.clear();
        }
        BdTypeListView bdTypeListView = this.b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f.addAll(list);
        }
        d();
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, forumEmotionPackageData) != null) || forumEmotionPackageData == null || ListUtils.isEmpty(this.f)) {
            return;
        }
        for (cn cnVar : this.f) {
            if (cnVar != null && (cnVar instanceof w57) && (forumEmotionPackageData2 = ((w57) cnVar).a) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
