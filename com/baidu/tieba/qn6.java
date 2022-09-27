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
/* loaded from: classes5.dex */
public class qn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<qn> c;
    public String d;
    public String e;
    public i26 f;

    /* loaded from: classes5.dex */
    public class a extends i26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn6 b;

        public a(qn6 qn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qn6Var;
        }

        @Override // com.baidu.tieba.i26
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) {
                super.a(view2, baseCardInfo);
                this.b.b();
            }
        }
    }

    public qn6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
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
            rn6 rn6Var = new rn6(this.a, this.d, this.e);
            rn6Var.x(this.f);
            this.c.add(rn6Var);
            sn6 sn6Var = new sn6(this.a, this.d);
            sn6Var.x(this.f);
            this.c.add(sn6Var);
            this.c.add(new vn6(this.a, this.d));
            this.c.add(new un6(this.a, this.d));
            List<qn> list = this.c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, g76.b, tbPageContext.getUniqueId(), this.d));
            tn6 tn6Var = new tn6(this.a, this.d);
            tn6Var.v(this.f);
            this.c.add(tn6Var);
            List<qn> list2 = this.c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, b76.b, tbPageContext2.getUniqueId(), this.d));
            List<qn> list3 = this.c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, e76.b, tbPageContext3.getUniqueId(), this.d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, qh6.e, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.I();
            frsUserRecommendAdapter.H(this.d);
            this.c.add(frsUserRecommendAdapter);
            this.b.a(this.c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.b.getAdapter2() instanceof un)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<Cdo> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
