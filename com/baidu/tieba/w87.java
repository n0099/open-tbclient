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
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.fx;
import com.baidu.tieba.qy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w87 extends ln<o96, ThreadCardViewHolder<o96>> implements bs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public NEGFeedBackView.b d;
    public z86<o96> e;

    @Override // com.baidu.tieba.bs5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements fx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(w87 w87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.fx.b
        public void a(fs4 fs4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fs4Var, view2) == null) && fs4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fs4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fs4Var.objType = 4;
                } else {
                    fs4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w87 a;

        public b(w87 w87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w87Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            o96 o96Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof o96) && (o96Var = (o96) ynVar) != null && (threadData = o96Var.a) != null && threadData.getSmartApp() != null) {
                this.a.A(o96Var.a, view2);
                TiebaStatic.log(o96Var.v());
                TiebaStatic.log(o96Var.i());
                this.a.v(o96Var.a, o96Var.m());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends z86<o96> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w87 b;

        public c(w87 w87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z86
        /* renamed from: d */
        public boolean c(View view2, o96 o96Var, String str) {
            InterceptResult invokeLLL;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o96Var, str)) == null) {
                if (o96Var != null && (threadData = o96Var.a) != null && threadData.getSmartApp() != null) {
                    this.b.A(o96Var.a, view2);
                    TiebaStatic.log(o96Var.v());
                    TiebaStatic.log(o96Var.i());
                    this.b.v(o96Var.a, o96Var.m());
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w87(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(ThreadData threadData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, threadData, view2) == null) && threadData != null && threadData.getSmartApp() != null) {
            String str = threadData.getSmartApp().id;
            String str2 = threadData.getSmartApp().link;
            String str3 = threadData.getSmartApp().h5_url;
            Long l = threadData.getSmartApp().naws_app_id;
            long parseLong = Long.parseLong(threadData.getTid());
            long fid = threadData.getFid();
            String str4 = threadData.getSmartApp().name;
            cz4.l().y("smart_app_tid", parseLong);
            cz4.l().z("smart_app_name", str4);
            cz4.l().z("smart_app_id", str);
            if (StringUtils.isNull(str)) {
                return;
            }
            if (!ev5.b(str, str2, "1191008600000000", threadData.getSmartApp().is_game)) {
                if (StringUtils.isNull(str3)) {
                    return;
                }
                BrowserHelper.p(view2.getContext(), str3);
            }
            l86.a(threadData.getTid());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", fid).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", threadData.getSmartApp().is_game.intValue()));
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o96.c0 = "c13388";
            o96.d0 = "c13389";
        }
    }

    public final void v(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, threadData, i) == null) && threadData != null && threadData.getSmartApp() != null) {
            kv8.g().c(this.a, iv8.g(threadData, "a002", "common_click", 1, i, threadData.getSmartApp().id));
        }
    }

    public final void w(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, threadData, i) == null) && threadData != null && threadData.getSmartApp() != null) {
            String str = threadData.getSmartApp().id;
            kv8.g().d(this.a, iv8.b(threadData.getTid(), "", str, null), iv8.h(threadData, "a002", "common_exp", i, str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public ThreadCardViewHolder<o96> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            qy.b bVar = new qy.b(this.b.getPageActivity());
            fx fxVar = new fx(this.b.getPageActivity());
            fxVar.x(this.a);
            fxVar.v(false);
            fxVar.A(false);
            fxVar.g(1024);
            fxVar.w(new a(this));
            bVar.o(fxVar);
            cy cyVar = new cy(this.b.getPageActivity());
            cyVar.t("index");
            cyVar.u(this.c);
            bVar.n(cyVar);
            bVar.m(new ny(this.b.getPageActivity()));
            ThreadCardViewHolder<o96> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o96 o96Var, ThreadCardViewHolder<o96> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o96Var, threadCardViewHolder})) == null) {
            if (o96Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o96Var.a != null) {
                o96Var.I(o96Var.position + 1);
                o96Var.a.statFloor = o96Var.m();
                threadCardViewHolder.o(false).s(this.d);
                threadCardViewHolder.e(o96Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                s86.b().a(o96Var.x());
                zr5.c().i("page_recommend", "show_", o96Var.x());
                w(o96Var.a, o96Var.m());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
