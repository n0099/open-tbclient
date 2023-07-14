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
import com.baidu.tieba.ay;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x08 extends ln<kq6, ThreadCardViewHolder<kq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public up6<kq6> e;

    /* loaded from: classes8.dex */
    public class a extends up6<kq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
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
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, kq6Var) == null) && view2 != null && kq6Var != null && kq6Var.getThreadData() != null && !StringUtils.isNull(kq6Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                    if (id == R.id.thread_card_voice) {
                        a08.b(view2, kq6Var, 6);
                        return;
                    } else if (id != R.id.user_avatar && id != R.id.user_name) {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (kq6Var != null) {
                                statisticItem.param("tid", kq6Var.g);
                                ThreadData threadData = kq6Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", kq6Var.a.getTopAgreePost().S());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (kq6Var != null) {
                                statisticItem2.param("tid", kq6Var.g);
                                ThreadData threadData2 = kq6Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", kq6Var.a.getTopAgreePost().S());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (kq6Var != null) {
                                    statisticItem3.param("tid", kq6Var.g);
                                    ThreadData threadData3 = kq6Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", kq6Var.a.getTopAgreePost().S());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (view2.getId() == R.id.forum_name_text) {
                                a08.b(view2, kq6Var, 7);
                                return;
                            } else if (view2 instanceof TbImageView) {
                                if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (kq6Var != null) {
                                        statisticItem4.param("tid", kq6Var.g);
                                        ThreadData threadData4 = kq6Var.a;
                                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                            statisticItem4.param("pid", kq6Var.a.getTopAgreePost().S());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                a08.b(view2, kq6Var, 6);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (kq6Var != null) {
                                statisticItem5.param("tid", kq6Var.g);
                                ThreadData threadData5 = kq6Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", kq6Var.a.getTopAgreePost().S());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    } else {
                        a08.b(view2, kq6Var, 1);
                        return;
                    }
                }
                a08.b(view2, kq6Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && t15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    t15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    t15Var.objType = 4;
                } else {
                    t15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x08 a;

        public c(x08 x08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof kq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                kq6 kq6Var = (kq6) ynVar;
                kq6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), kq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) kq6Var, view2.getContext(), 1, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public ThreadCardViewHolder<kq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.r(this.a);
            ayVar.g(128);
            ayVar.h(1024);
            ayVar.A(new b(this));
            bVar.o(ayVar);
            rz rzVar = new rz(this.b.getPageActivity());
            bVar.n(rzVar);
            rzVar.C(2);
            bVar.h(new qz(this.b.getPageActivity()));
            bVar.h(new iy(this.b.getPageActivity()));
            my myVar = new my(this.b.getPageActivity());
            myVar.F(this.d);
            myVar.E(ImageViewerConfig.FROM_CONCERN);
            bVar.h(myVar);
            oz ozVar = new oz(this.b.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 9;
            z15Var.h = 9;
            ozVar.D(z15Var);
            ozVar.F(9);
            ozVar.L(4);
            ozVar.G(1);
            ozVar.E(false);
            bVar.m(ozVar);
            mz i = bVar.i();
            i.s(1);
            ThreadCardViewHolder<kq6> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, kq6 kq6Var, ThreadCardViewHolder<kq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, kq6Var, threadCardViewHolder})) == null) {
            if (kq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && kq6Var.a != null) {
                kq6Var.B(kq6Var.position + 1);
                np6.b().a(kq6Var.d("c12351"));
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.k();
                threadCardViewHolder.f(kq6Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.b().q(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
