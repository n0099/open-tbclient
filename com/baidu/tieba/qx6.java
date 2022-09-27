package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qx6 extends qn<x26, ThreadCardViewHolder<x26>> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public i26<x26> e;

    /* loaded from: classes5.dex */
    public class a extends i26<x26> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(qx6 qx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, x26 x26Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, x26Var) == null) || view2 == null || x26Var == null || x26Var.getThreadData() == null || StringUtils.isNull(x26Var.getThreadData().getTid())) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f092180 || id == R.id.obfuscated_res_0x7f092194) {
                sw6.b(view2, x26Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f092182) {
                sw6.b(view2, x26Var, 6);
            } else if (id == R.id.obfuscated_res_0x7f092488 || id == R.id.obfuscated_res_0x7f0924b6) {
                sw6.b(view2, x26Var, 1);
            } else if (id == R.id.obfuscated_res_0x7f090cd9) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (x26Var != null) {
                    statisticItem.param("tid", x26Var.g);
                    ThreadData threadData = x26Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cd4) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (x26Var != null) {
                    statisticItem2.param("tid", x26Var.g);
                    ThreadData threadData2 = x26Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.obfuscated_res_0x7f090cd7 || id == R.id.obfuscated_res_0x7f090cd8) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 1);
                if (x26Var != null) {
                    statisticItem3.param("tid", x26Var.g);
                    ThreadData threadData3 = x26Var.a;
                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                        statisticItem3.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if (id == R.id.obfuscated_res_0x7f090cd3) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 5);
                if (x26Var != null) {
                    statisticItem4.param("tid", x26Var.g);
                    ThreadData threadData4 = x26Var.a;
                    if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                        statisticItem4.param("pid", x26Var.a.getTopAgreePost().L());
                    }
                }
                TiebaStatic.log(statisticItem4);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a8f) {
                sw6.b(view2, x26Var, 7);
            } else if (view2 instanceof TbImageView) {
                if (view2.getTag(R.id.obfuscated_res_0x7f090cd5) instanceof Integer) {
                    StatisticItem statisticItem5 = new StatisticItem("c13423");
                    statisticItem5.param("obj_locate", 3);
                    if (x26Var != null) {
                        statisticItem5.param("tid", x26Var.g);
                        ThreadData threadData5 = x26Var.a;
                        if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                            statisticItem5.param("pid", x26Var.a.getTopAgreePost().L());
                        }
                    }
                    TiebaStatic.log(statisticItem5);
                    return;
                }
                sw6.b(view2, x26Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(qx6 qx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(yq4 yq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yq4Var, view2) == null) || yq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092488) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx6 a;

        public c(qx6 qx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof x26) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                x26 x26Var = (x26) cdo;
                x26Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), x26Var);
                }
                ThreadCardUtils.jumpToPB((yq4) x26Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = true;
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: t */
    public ThreadCardViewHolder<x26> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.b.getPageActivity());
            jx jxVar = new jx(this.b.getPageActivity());
            jxVar.u(this.a);
            jxVar.c(128);
            jxVar.d(1024);
            jxVar.t(new b(this));
            bVar.o(jxVar);
            xy xyVar = new xy(this.b.getPageActivity());
            bVar.n(xyVar);
            xyVar.v(2);
            bVar.h(new wy(this.b.getPageActivity()));
            bVar.h(new qx(this.b.getPageActivity()));
            ux uxVar = new ux(this.b.getPageActivity());
            uxVar.y(this.d);
            uxVar.x(ImageViewerConfig.FROM_CONCERN);
            bVar.h(uxVar);
            uy uyVar = new uy(this.b.getPageActivity());
            er4 er4Var = new er4();
            er4Var.b = 9;
            er4Var.h = 9;
            uyVar.w(er4Var);
            uyVar.y(9);
            uyVar.D(4);
            uyVar.z(1);
            uyVar.x(false);
            bVar.m(uyVar);
            sy i = bVar.i();
            i.r(1);
            ThreadCardViewHolder<x26> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, x26 x26Var, ThreadCardViewHolder<x26> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, x26Var, threadCardViewHolder})) == null) {
            if (x26Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || x26Var.a == null) {
                return null;
            }
            x26Var.I(x26Var.position + 1);
            b26.b().a(x26Var.f("c12351"));
            threadCardViewHolder.a().b(this.c);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.j();
            threadCardViewHolder.e(x26Var);
            threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().p(this.e);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
