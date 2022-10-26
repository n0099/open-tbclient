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
import com.baidu.tieba.ez;
import com.baidu.tieba.kx;
import com.baidu.tieba.ty;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xx6 extends rn implements ap5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext b;
    public String c;
    public boolean d;
    public p26 e;

    /* loaded from: classes6.dex */
    public class a extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xx6 xx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx6Var};
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
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, e36 e36Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, e36Var) == null) && view2 != null && e36Var != null && e36Var.getThreadData() != null && !StringUtils.isNull(e36Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f09217d && id != R.id.obfuscated_res_0x7f092191) {
                    if (id == R.id.obfuscated_res_0x7f09217f) {
                        zw6.b(view2, e36Var, 6);
                        return;
                    } else if (id != R.id.obfuscated_res_0x7f092473 && id != R.id.obfuscated_res_0x7f0924a1) {
                        if (id == R.id.obfuscated_res_0x7f090ce3) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (e36Var != null) {
                                statisticItem.param("tid", e36Var.g);
                                ThreadData threadData = e36Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", e36Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.obfuscated_res_0x7f090cde) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (e36Var != null) {
                                statisticItem2.param("tid", e36Var.g);
                                ThreadData threadData2 = e36Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", e36Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.obfuscated_res_0x7f090ce1 && id != R.id.obfuscated_res_0x7f090ce2) {
                            if (id == R.id.obfuscated_res_0x7f090cdd) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (e36Var != null) {
                                    statisticItem3.param("tid", e36Var.g);
                                    ThreadData threadData3 = e36Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", e36Var.a.getTopAgreePost().M());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f090a99) {
                                zw6.b(view2, e36Var, 7);
                                return;
                            } else if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cdf) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (e36Var != null) {
                                        statisticItem4.param("tid", e36Var.g);
                                        ThreadData threadData4 = e36Var.a;
                                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                            statisticItem4.param("pid", e36Var.a.getTopAgreePost().M());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                zw6.b(view2, e36Var, 6);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (e36Var != null) {
                                statisticItem5.param("tid", e36Var.g);
                                ThreadData threadData5 = e36Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", e36Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    } else {
                        zw6.b(view2, e36Var, 1);
                        return;
                    }
                }
                zw6.b(view2, e36Var, 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements kx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(xx6 xx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kx.b
        public void a(ar4 ar4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, ar4Var, view2) == null) && ar4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0924a1) {
                    ar4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092473) {
                    ar4Var.objType = 4;
                } else {
                    ar4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements oo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx6 a;

        public c(xx6 xx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx6Var;
        }

        @Override // com.baidu.tieba.oo
        public void b(View view2, eo eoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, eoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (eoVar instanceof e36) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                e36 e36Var = (e36) eoVar;
                e36Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), e36Var);
                }
                ThreadCardUtils.jumpToPB((ar4) e36Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new ez.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xx6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.ap5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: t */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ty.b bVar = new ty.b(this.b.getPageActivity());
            kx kxVar = new kx(this.b.getPageActivity());
            kxVar.x(this.a);
            kxVar.f(128);
            kxVar.g(1024);
            kxVar.w(new b(this));
            bVar.o(kxVar);
            yy yyVar = new yy(this.b.getPageActivity());
            bVar.n(yyVar);
            yyVar.y(2);
            bVar.h(new xy(this.b.getPageActivity()));
            bVar.h(new rx(this.b.getPageActivity()));
            vx vxVar = new vx(this.b.getPageActivity());
            vxVar.B(this.d);
            vxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(vxVar);
            vy vyVar = new vy(this.b.getPageActivity());
            gr4 gr4Var = new gr4();
            gr4Var.b = 9;
            gr4Var.h = 9;
            vyVar.z(gr4Var);
            vyVar.B(9);
            vyVar.G(4);
            vyVar.C(1);
            vyVar.A(false);
            bVar.m(vyVar);
            ty i = bVar.i();
            i.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, e36 e36Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, e36Var, threadCardViewHolder})) == null) {
            if (e36Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && e36Var.a != null) {
                e36Var.I(e36Var.position + 1);
                i26.b().a(e36Var.f("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(e36Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
