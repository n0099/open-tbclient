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
import com.baidu.tieba.gy;
import com.baidu.tieba.ry;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ko7 extends vm<yi6, ThreadCardViewHolder<yi6>> implements qz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public on e;
    public ji6<yi6> f;

    /* loaded from: classes5.dex */
    public class a extends ji6<yi6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko7 b;

        public a(ko7 ko7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ko7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ji6
        /* renamed from: d */
        public void a(View view2, yi6 yi6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yi6Var) == null) && view2 != null && yi6Var != null && yi6Var.getThreadData() != null && !StringUtils.isNull(yi6Var.getThreadData().getTid())) {
                this.b.y(view2, yi6Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements sn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko7 a;

        public b(ko7 ko7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ko7Var;
        }

        @Override // com.baidu.tieba.sn
        public void b(View view2, in inVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, inVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (inVar instanceof yi6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yi6 yi6Var = (yi6) inVar;
                yi6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), yi6Var);
                }
                ThreadCardUtils.jumpToPB((ax4) yi6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new ry.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.qz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void z(on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onVar) == null) {
            this.e = onVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            gy.b bVar = new gy.b(this.b.getPageActivity(), false);
            fx fxVar = new fx(this.b.getPageActivity());
            fxVar.D(this.d);
            fxVar.C(ImageViewerConfig.FROM_CONCERN);
            bVar.h(fxVar);
            gy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.s(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, yi6 yi6Var, ThreadCardViewHolder<yi6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yi6Var, threadCardViewHolder})) == null) {
            if (yi6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && yi6Var.a != null) {
                yi6Var.B(yi6Var.position + 1);
                ci6.b().a(new StatisticItem("c13424"));
                threadCardViewHolder.a().r(i);
                if (threadCardViewHolder.a() instanceof pz5) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.e(yi6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, yi6 yi6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, yi6Var) == null) {
            int id = view2.getId();
            if (view2.getId() == R.id.thread_card_root) {
                vn7.b(view2, yi6Var, 2);
            } else if (id == R.id.god_reply_voice_btn) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (yi6Var != null) {
                    statisticItem.param("tid", yi6Var.g);
                    ThreadData threadData = yi6Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", yi6Var.a.getTopAgreePost().N());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.god_reply_content) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (yi6Var != null) {
                    statisticItem2.param("tid", yi6Var.g);
                    ThreadData threadData2 = yi6Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", yi6Var.a.getTopAgreePost().N());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                if (id == R.id.god_reply_agree_view) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 5);
                    if (yi6Var != null) {
                        statisticItem3.param("tid", yi6Var.g);
                        ThreadData threadData3 = yi6Var.a;
                        if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                            statisticItem3.param("pid", yi6Var.a.getTopAgreePost().N());
                        }
                    }
                    TiebaStatic.log(statisticItem3);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 3);
                    if (yi6Var != null) {
                        statisticItem4.param("tid", yi6Var.g);
                        ThreadData threadData4 = yi6Var.a;
                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                            statisticItem4.param("pid", yi6Var.a.getTopAgreePost().N());
                        }
                    }
                    TiebaStatic.log(statisticItem4);
                }
            } else {
                StatisticItem statisticItem5 = new StatisticItem("c13423");
                statisticItem5.param("obj_locate", 1);
                if (yi6Var != null) {
                    statisticItem5.param("tid", yi6Var.g);
                    ThreadData threadData5 = yi6Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", yi6Var.a.getTopAgreePost().N());
                    }
                }
                TiebaStatic.log(statisticItem5);
            }
        }
    }
}
