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
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vb8 extends ci<dn6, ThreadCardViewHolder<dn6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public mm6<dn6> e;

    /* loaded from: classes8.dex */
    public class a extends mm6<dn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(vb8 vb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb8Var};
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
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, dn6 dn6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dn6Var) == null) && view2 != null && dn6Var != null && dn6Var.getThreadData() != null && !StringUtils.isNull(dn6Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                    if (id == R.id.thread_card_voice) {
                        ya8.b(view2, dn6Var, 6);
                        return;
                    } else if (id != R.id.user_avatar && id != R.id.user_name) {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (dn6Var != null) {
                                statisticItem.param("tid", dn6Var.g);
                                ThreadData threadData = dn6Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", dn6Var.a.getTopAgreePost().U());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (dn6Var != null) {
                                statisticItem2.param("tid", dn6Var.g);
                                ThreadData threadData2 = dn6Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", dn6Var.a.getTopAgreePost().U());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (dn6Var != null) {
                                    statisticItem3.param("tid", dn6Var.g);
                                    ThreadData threadData3 = dn6Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", dn6Var.a.getTopAgreePost().U());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (view2.getId() == R.id.forum_name_text) {
                                ya8.b(view2, dn6Var, 7);
                                return;
                            } else if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (dn6Var != null) {
                                        statisticItem4.param("tid", dn6Var.g);
                                        ThreadData threadData4 = dn6Var.a;
                                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                            statisticItem4.param("pid", dn6Var.a.getTopAgreePost().U());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                ya8.b(view2, dn6Var, 6);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (dn6Var != null) {
                                statisticItem5.param("tid", dn6Var.g);
                                ThreadData threadData5 = dn6Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", dn6Var.a.getTopAgreePost().U());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    } else {
                        ya8.b(view2, dn6Var, 1);
                        return;
                    }
                }
                ya8.b(view2, dn6Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(vb8 vb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rs.b
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) && fw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fw4Var.objType = 4;
                } else {
                    fw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb8 a;

        public c(vb8 vb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vb8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof dn6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dn6 dn6Var = (dn6) piVar;
                dn6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), dn6Var);
                }
                ThreadCardUtils.jumpToPB((fw4) dn6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vb8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: u */
    public ThreadCardViewHolder<dn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity());
            rs rsVar = new rs(this.b.getPageActivity());
            rsVar.o(this.a);
            rsVar.b(128);
            rsVar.c(1024);
            rsVar.x(new b(this));
            bVar.o(rsVar);
            hu huVar = new hu(this.b.getPageActivity());
            bVar.n(huVar);
            huVar.z(2);
            bVar.h(new gu(this.b.getPageActivity()));
            bVar.h(new zs(this.b.getPageActivity()));
            dt dtVar = new dt(this.b.getPageActivity());
            dtVar.C(this.d);
            dtVar.B(ImageViewerConfig.FROM_CONCERN);
            bVar.h(dtVar);
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 9;
            lw4Var.h = 9;
            euVar.C(lw4Var);
            euVar.E(9);
            euVar.J(4);
            euVar.F(1);
            euVar.D(false);
            bVar.m(euVar);
            cu i = bVar.i();
            i.t(1);
            ThreadCardViewHolder<dn6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dn6 dn6Var, ThreadCardViewHolder<dn6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dn6Var, threadCardViewHolder})) == null) {
            if (dn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && dn6Var.a != null) {
                dn6Var.B(dn6Var.position + 1);
                em6.b().a(dn6Var.d("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.x(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.k();
                threadCardViewHolder.e(dn6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
