package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameCompetitionAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameRecommendGameAdapter;
import com.baidu.tieba.frs.gamerecommend.adapter.GameSpecialTopicAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class un7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<om> c;
    public String d;
    public String e;
    public jo6 f;

    /* loaded from: classes8.dex */
    public class a extends jo6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un7 b;

        public a(un7 un7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = un7Var;
        }

        @Override // com.baidu.tieba.jo6
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) {
                super.a(view2, baseCardInfo);
                this.b.b();
            }
        }
    }

    public un7(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.a = tbPageContext;
        this.b = bdTypeListView;
        this.d = str;
        this.e = str2;
        this.c = new ArrayList();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vn7 vn7Var = new vn7(this.a, this.d, this.e);
            vn7Var.z(this.f);
            this.c.add(vn7Var);
            wn7 wn7Var = new wn7(this.a, this.d);
            wn7Var.z(this.f);
            this.c.add(wn7Var);
            this.c.add(new zn7(this.a, this.d));
            this.c.add(new yn7(this.a, this.d));
            List<om> list = this.c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, ww6.b, tbPageContext.getUniqueId(), this.d));
            xn7 xn7Var = new xn7(this.a, this.d);
            xn7Var.x(this.f);
            this.c.add(xn7Var);
            List<om> list2 = this.c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, rw6.b, tbPageContext2.getUniqueId(), this.d));
            List<om> list3 = this.c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, uw6.b, tbPageContext3.getUniqueId(), this.d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, lh7.e, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.K();
            frsUserRecommendAdapter.J(this.d);
            this.c.add(frsUserRecommendAdapter);
            this.b.addAdapters(this.c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.b.getAdapter2() instanceof sm)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<bn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
