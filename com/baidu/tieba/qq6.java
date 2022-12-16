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
public class qq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<kn> c;
    public String d;
    public String e;
    public h56 f;

    /* loaded from: classes5.dex */
    public class a extends h56 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq6 b;

        public a(qq6 qq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qq6Var;
        }

        @Override // com.baidu.tieba.h56
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) {
                super.a(view2, baseCardInfo);
                this.b.b();
            }
        }
    }

    public qq6(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, String str, String str2) {
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
            rq6 rq6Var = new rq6(this.a, this.d, this.e);
            rq6Var.x(this.f);
            this.c.add(rq6Var);
            sq6 sq6Var = new sq6(this.a, this.d);
            sq6Var.x(this.f);
            this.c.add(sq6Var);
            this.c.add(new vq6(this.a, this.d));
            this.c.add(new uq6(this.a, this.d));
            List<kn> list = this.c;
            TbPageContext tbPageContext = this.a;
            list.add(new GameSpecialTopicAdapter(tbPageContext, fa6.b, tbPageContext.getUniqueId(), this.d));
            tq6 tq6Var = new tq6(this.a, this.d);
            tq6Var.v(this.f);
            this.c.add(tq6Var);
            List<kn> list2 = this.c;
            TbPageContext tbPageContext2 = this.a;
            list2.add(new GameCompetitionAdapter(tbPageContext2, aa6.b, tbPageContext2.getUniqueId(), this.d));
            List<kn> list3 = this.c;
            TbPageContext tbPageContext3 = this.a;
            list3.add(new GameRecommendGameAdapter(tbPageContext3, da6.b, tbPageContext3.getUniqueId(), this.d));
            TbPageContext tbPageContext4 = this.a;
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(tbPageContext4, pk6.e, tbPageContext4.getUniqueId());
            frsUserRecommendAdapter.J();
            frsUserRecommendAdapter.H(this.d);
            this.c.add(frsUserRecommendAdapter);
            this.b.a(this.c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (this.b.getAdapter2() instanceof on)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(List<xn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
