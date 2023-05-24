package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dx;
import com.baidu.tieba.py;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qu7 extends en<lk6, ThreadCardViewHolder<lk6>> implements c16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public NEGFeedBackView.b d;
    public wj6<lk6> e;

    @Override // com.baidu.tieba.c16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(qu7 qu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(jy4 jy4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, jy4Var, view2) == null) && jy4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    jy4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    jy4Var.objType = 4;
                } else {
                    jy4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu7 a;

        public b(qu7 qu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu7Var;
        }

        @Override // com.baidu.tieba.bo
        public void b(View view2, rn rnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            lk6 lk6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, rnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (rnVar instanceof lk6) && (lk6Var = (lk6) rnVar) != null && (threadData = lk6Var.a) != null && threadData.getSmartApp() != null) {
                this.a.C(lk6Var.a, view2);
                TiebaStatic.log(lk6Var.q());
                TiebaStatic.log(lk6Var.f());
                this.a.x(lk6Var.a, lk6Var.i());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends wj6<lk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu7 b;

        public c(qu7 qu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wj6
        /* renamed from: d */
        public boolean c(View view2, lk6 lk6Var, String str) {
            InterceptResult invokeLLL;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lk6Var, str)) == null) {
                if (lk6Var != null && (threadData = lk6Var.a) != null && threadData.getSmartApp() != null) {
                    this.b.C(lk6Var.a, view2);
                    TiebaStatic.log(lk6Var.q());
                    TiebaStatic.log(lk6Var.f());
                    this.b.x(lk6Var.a, lk6Var.i());
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.d = null;
        this.e = new c(this);
        this.b = tbPageContext;
        u();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lk6 lk6Var, ThreadCardViewHolder<lk6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lk6Var, threadCardViewHolder})) == null) {
            if (lk6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && lk6Var.a != null) {
                lk6Var.B(lk6Var.position + 1);
                lk6Var.a.statFloor = lk6Var.i();
                threadCardViewHolder.o(false).s(this.d);
                threadCardViewHolder.e(lk6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                pj6.b().a(lk6Var.s());
                a16.c().i("page_recommend", "show_", lk6Var.s());
                y(lk6Var.a, lk6Var.i());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void B(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void C(ThreadData threadData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, threadData, view2) == null) && threadData != null && threadData.getSmartApp() != null) {
            String str = threadData.getSmartApp().id;
            String str2 = threadData.getSmartApp().link;
            String str3 = threadData.getSmartApp().h5_url;
            Long l = threadData.getSmartApp().naws_app_id;
            long parseLong = Long.parseLong(threadData.getTid());
            long fid = threadData.getFid();
            String str4 = threadData.getSmartApp().name;
            o65.m().A("smart_app_tid", parseLong);
            o65.m().B("smart_app_name", str4);
            o65.m().B("smart_app_id", str);
            if (StringUtils.isNull(str)) {
                return;
            }
            if (!h46.b(str, str2, "1191008600000000", threadData.getSmartApp().is_game)) {
                if (StringUtils.isNull(str3)) {
                    return;
                }
                yu4.s(view2.getContext(), str3);
            }
            ij6.a(threadData.getTid());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", fid).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", threadData.getSmartApp().is_game.intValue()));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            lk6.d0 = "c13388";
            lk6.e0 = "c13389";
        }
    }

    public final void x(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, threadData, i) == null) && threadData != null && threadData.getSmartApp() != null) {
            up9.g().c(this.a, sp9.g(threadData, "a002", "common_click", 1, i, threadData.getSmartApp().id));
        }
    }

    public final void y(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData, i) == null) && threadData != null && threadData.getSmartApp() != null) {
            String str = threadData.getSmartApp().id;
            up9.g().d(this.a, sp9.b(threadData.getTid(), "", str, null), sp9.h(threadData, "a002", "common_exp", i, str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.en
    /* renamed from: z */
    public ThreadCardViewHolder<lk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            py.b bVar = new py.b(this.b.getPageActivity());
            dx dxVar = new dx(this.b.getPageActivity());
            dxVar.z(this.a);
            dxVar.x(false);
            dxVar.C(false);
            dxVar.g(1024);
            dxVar.y(new a(this));
            bVar.o(dxVar);
            by byVar = new by(this.b.getPageActivity());
            byVar.setFrom("index");
            byVar.t(this.c);
            bVar.n(byVar);
            bVar.m(new my(this.b.getPageActivity()));
            ThreadCardViewHolder<lk6> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
