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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.tieba.ow;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jc7 extends tm<ag6, ThreadCardViewHolder<ag6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public mn d;
    public lf6<ag6> e;

    /* loaded from: classes5.dex */
    public class a extends lf6<ag6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jc7 jc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var};
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
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, ag6 ag6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ag6Var) == null) && view2 != null && ag6Var != null && ag6Var.getThreadData() != null && !StringUtils.isNull(ag6Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                    if (id != R.id.user_avatar && id != R.id.user_name) {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (ag6Var != null) {
                                statisticItem.param("tid", ag6Var.g);
                                ThreadData threadData = ag6Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", ag6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (ag6Var != null) {
                                statisticItem2.param("tid", ag6Var.g);
                                ThreadData threadData2 = ag6Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", ag6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (ag6Var != null) {
                                    statisticItem3.param("tid", ag6Var.g);
                                    ThreadData threadData3 = ag6Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", ag6Var.a.getTopAgreePost().O());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (id == R.id.forum_name_text) {
                                cc7.b(view2, ag6Var, 7);
                                return;
                            } else if (id != R.id.thread_card_title && id != R.id.thread_card_abstract) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem4 = new StatisticItem("c13423");
                                        statisticItem4.param("obj_locate", 3);
                                        if (ag6Var != null) {
                                            statisticItem4.param("tid", ag6Var.g);
                                            ThreadData threadData4 = ag6Var.a;
                                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                                statisticItem4.param("pid", ag6Var.a.getTopAgreePost().O());
                                            }
                                        }
                                        TiebaStatic.log(statisticItem4);
                                        return;
                                    }
                                    cc7.b(view2, ag6Var, 6);
                                    return;
                                }
                                return;
                            } else {
                                cc7.b(view2, ag6Var, 2);
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (ag6Var != null) {
                                statisticItem5.param("tid", ag6Var.g);
                                ThreadData threadData5 = ag6Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", ag6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    }
                    cc7.b(view2, ag6Var, 1);
                    return;
                }
                cc7.b(view2, ag6Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements rw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(jc7 jc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw.b
        public void a(hw4 hw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, hw4Var, view2) == null) && hw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    hw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    hw4Var.objType = 4;
                } else {
                    hw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx a;
        public final /* synthetic */ jc7 b;

        public c(jc7 jc7Var, xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var, xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc7Var;
            this.a = xxVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hw4Var) == null) && hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(hw4Var.getThreadData().originalThreadData, this.b.mContext, 1);
                cc7.b(this.a.k(), hw4Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ow.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ jc7 b;

        public d(jc7 jc7Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jc7Var;
            this.a = fyVar;
        }

        @Override // com.baidu.tieba.ow.a
        public void a(hw4 hw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hw4Var) == null) && hw4Var != null && hw4Var.getThreadData() != null && hw4Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(hw4Var.getThreadData().originalThreadData, this.b.mContext, 1);
                cc7.b(this.a.k(), hw4Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc7 a;

        public e(jc7 jc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jc7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (gnVar instanceof ag6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ag6 ag6Var = (ag6) gnVar;
                ag6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), ag6Var);
                }
                ThreadCardUtils.jumpToPB((hw4) ag6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void z(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mnVar) == null) {
            this.d = mnVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public ThreadCardViewHolder<ag6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity());
            rw rwVar = new rw(this.b.getPageActivity());
            rwVar.x(this.a);
            rwVar.f(128);
            rwVar.g(1024);
            rwVar.w(new b(this));
            bVar.o(rwVar);
            xx xxVar = new xx(this.b);
            xxVar.r(Boolean.FALSE);
            xxVar.z(ImageViewerConfig.FROM_CONCERN);
            bVar.l().i(hi.g(this.mContext, R.dimen.tbds28));
            bVar.n(xxVar);
            xx xxVar2 = new xx(this.b);
            xxVar2.r(Boolean.TRUE);
            xxVar2.z(ImageViewerConfig.FROM_CONCERN);
            xxVar2.C(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            xxVar2.A(new c(this, xxVar2));
            bVar.h(xxVar2);
            fy fyVar = new fy(this.b.getPageActivity());
            fyVar.r(Boolean.TRUE);
            fyVar.y(new d(this, fyVar));
            bVar.h(fyVar);
            bVar.h(new yw(this.b.getPageActivity()));
            ey eyVar = new ey(this.b.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 9;
            nw4Var.h = 9;
            eyVar.z(nw4Var);
            eyVar.B(9);
            eyVar.G(4);
            eyVar.C(1);
            eyVar.f(32);
            eyVar.A(false);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<ag6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ag6 ag6Var, ThreadCardViewHolder<ag6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ag6Var, threadCardViewHolder})) == null) {
            if (ag6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ag6Var.a != null) {
                ag6Var.E(ag6Var.position + 1);
                threadCardViewHolder.a().r(i);
                ef6.b().a(ag6Var.f("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(ag6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
