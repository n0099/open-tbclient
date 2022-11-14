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
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rz6 extends kn<a56, ThreadCardViewHolder<a56>> implements lq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public l46<a56> e;

    /* loaded from: classes5.dex */
    public class a extends l46<a56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(rz6 rz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz6Var};
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
        @Override // com.baidu.tieba.l46
        /* renamed from: d */
        public void a(View view2, a56 a56Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, a56Var) == null) && view2 != null && a56Var != null && a56Var.getThreadData() != null && !StringUtils.isNull(a56Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f0921dd && id != R.id.obfuscated_res_0x7f0921f1) {
                    if (id == R.id.obfuscated_res_0x7f0921df) {
                        ty6.b(view2, a56Var, 6);
                        return;
                    } else if (id != R.id.obfuscated_res_0x7f0924d7 && id != R.id.obfuscated_res_0x7f092505) {
                        if (id == R.id.obfuscated_res_0x7f090d03) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (a56Var != null) {
                                statisticItem.param("tid", a56Var.g);
                                ThreadData threadData = a56Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", a56Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.obfuscated_res_0x7f090cfe) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (a56Var != null) {
                                statisticItem2.param("tid", a56Var.g);
                                ThreadData threadData2 = a56Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", a56Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.obfuscated_res_0x7f090d01 && id != R.id.obfuscated_res_0x7f090d02) {
                            if (id == R.id.obfuscated_res_0x7f090cfd) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (a56Var != null) {
                                    statisticItem3.param("tid", a56Var.g);
                                    ThreadData threadData3 = a56Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", a56Var.a.getTopAgreePost().M());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f090aad) {
                                ty6.b(view2, a56Var, 7);
                                return;
                            } else if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f090cff) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (a56Var != null) {
                                        statisticItem4.param("tid", a56Var.g);
                                        ThreadData threadData4 = a56Var.a;
                                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                            statisticItem4.param("pid", a56Var.a.getTopAgreePost().M());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                ty6.b(view2, a56Var, 6);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (a56Var != null) {
                                statisticItem5.param("tid", a56Var.g);
                                ThreadData threadData5 = a56Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", a56Var.a.getTopAgreePost().M());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    } else {
                        ty6.b(view2, a56Var, 1);
                        return;
                    }
                }
                ty6.b(view2, a56Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(rz6 rz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz6Var};
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
        public void a(sr4 sr4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sr4Var, view2) == null) && sr4Var != null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092505) {
                    sr4Var.objType = 3;
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0924d7) {
                    sr4Var.objType = 4;
                } else {
                    sr4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz6 a;

        public c(rz6 rz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz6Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof a56) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                a56 a56Var = (a56) xnVar;
                a56Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), a56Var);
                }
                ThreadCardUtils.jumpToPB((sr4) a56Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rz6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.lq5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public ThreadCardViewHolder<a56> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity());
            dx dxVar = new dx(this.b.getPageActivity());
            dxVar.x(this.a);
            dxVar.f(128);
            dxVar.g(1024);
            dxVar.w(new b(this));
            bVar.o(dxVar);
            ty tyVar = new ty(this.b.getPageActivity());
            bVar.n(tyVar);
            tyVar.y(2);
            bVar.h(new sy(this.b.getPageActivity()));
            bVar.h(new kx(this.b.getPageActivity()));
            ox oxVar = new ox(this.b.getPageActivity());
            oxVar.B(this.d);
            oxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(oxVar);
            qy qyVar = new qy(this.b.getPageActivity());
            yr4 yr4Var = new yr4();
            yr4Var.b = 9;
            yr4Var.h = 9;
            qyVar.z(yr4Var);
            qyVar.B(9);
            qyVar.G(4);
            qyVar.C(1);
            qyVar.A(false);
            bVar.m(qyVar);
            oy i = bVar.i();
            i.r(1);
            ThreadCardViewHolder<a56> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, a56 a56Var, ThreadCardViewHolder<a56> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a56Var, threadCardViewHolder})) == null) {
            if (a56Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && a56Var.a != null) {
                a56Var.I(a56Var.position + 1);
                e46.b().a(a56Var.f("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(a56Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
