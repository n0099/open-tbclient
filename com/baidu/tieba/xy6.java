package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xy6 extends jn<o46, ThreadCardViewHolder<o46>> implements zp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public co e;
    public z36<o46> f;

    /* loaded from: classes6.dex */
    public class a extends z36<o46> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy6 b;

        public a(xy6 xy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xy6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, o46 o46Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, o46Var) == null) && view2 != null && o46Var != null && o46Var.getThreadData() != null && !StringUtils.isNull(o46Var.getThreadData().getTid())) {
                this.b.w(view2, o46Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy6 a;

        public b(xy6 xy6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy6Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof o46) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                o46 o46Var = (o46) wnVar;
                o46Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), o46Var);
                }
                ThreadCardUtils.jumpToPB((rr4) o46Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.zp5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void x(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, coVar) == null) {
            this.e = coVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            nx nxVar = new nx(this.b.getPageActivity());
            nxVar.B(this.d);
            nxVar.A(ImageViewerConfig.FROM_CONCERN);
            bVar.h(nxVar);
            ny k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o46Var.a != null) {
                o46Var.I(o46Var.position + 1);
                s36.b().a(new StatisticItem("c13424"));
                threadCardViewHolder.a().q(i);
                if (threadCardViewHolder.a() instanceof yp5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.e(o46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().p(this.f);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void w(View view2, o46 o46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, o46Var) == null) {
            int id = view2.getId();
            if (view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                iy6.b(view2, o46Var, 2);
            } else if (id == R.id.obfuscated_res_0x7f090d02) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (o46Var != null) {
                    statisticItem.param("tid", o46Var.g);
                    ThreadData threadData = o46Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", o46Var.a.getTopAgreePost().M());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.obfuscated_res_0x7f090cfd) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (o46Var != null) {
                    statisticItem2.param("tid", o46Var.g);
                    ThreadData threadData2 = o46Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", o46Var.a.getTopAgreePost().M());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.obfuscated_res_0x7f090d00 && id != R.id.obfuscated_res_0x7f090d01) {
                if (id == R.id.obfuscated_res_0x7f090cfc) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 5);
                    if (o46Var != null) {
                        statisticItem3.param("tid", o46Var.g);
                        ThreadData threadData3 = o46Var.a;
                        if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                            statisticItem3.param("pid", o46Var.a.getTopAgreePost().M());
                        }
                    }
                    TiebaStatic.log(statisticItem3);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.obfuscated_res_0x7f090cfe) instanceof Integer)) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 3);
                    if (o46Var != null) {
                        statisticItem4.param("tid", o46Var.g);
                        ThreadData threadData4 = o46Var.a;
                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                            statisticItem4.param("pid", o46Var.a.getTopAgreePost().M());
                        }
                    }
                    TiebaStatic.log(statisticItem4);
                }
            } else {
                StatisticItem statisticItem5 = new StatisticItem("c13423");
                statisticItem5.param("obj_locate", 1);
                if (o46Var != null) {
                    statisticItem5.param("tid", o46Var.g);
                    ThreadData threadData5 = o46Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", o46Var.a.getTopAgreePost().M());
                    }
                }
                TiebaStatic.log(statisticItem5);
            }
        }
    }
}
