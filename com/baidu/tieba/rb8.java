package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.tieba.rs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rb8 extends ci<dn6, ThreadCardViewHolder<dn6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vi d;
    public mm6<dn6> e;

    /* loaded from: classes8.dex */
    public class a extends mm6<dn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(rb8 rb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var};
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
                        za8.b(view2, dn6Var, 6);
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
                                za8.b(view2, dn6Var, 7);
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
                                za8.b(view2, dn6Var, 6);
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
                        za8.b(view2, dn6Var, 1);
                        return;
                    }
                }
                za8.b(view2, dn6Var, 2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(rb8 rb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var};
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
    public class c implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ xt b;
        public final /* synthetic */ rb8 c;

        public c(rb8 rb8Var, ju juVar, xt xtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var, juVar, xtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rb8Var;
            this.a = juVar;
            this.b = xtVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fw4Var) == null) && fw4Var != null && fw4Var.getThreadData() != null && fw4Var.getThreadData().originalThreadData != null) {
                yt5.b(1, this.c.mContext, fw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "concern_page", null, "concern_tab", "");
                za8.b(this.b.g(), fw4Var, 6);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ rb8 b;

        public d(rb8 rb8Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb8Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fw4Var) == null) && fw4Var != null && fw4Var.getThreadData() != null && fw4Var.getThreadData().originalThreadData != null) {
                yt5.b(1, this.b.mContext, fw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "concern_page", null, "concern_tab", "");
                za8.b(this.a.g(), fw4Var, 6);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements su {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ rb8 b;

        public e(rb8 rb8Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rb8Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.su
        public void a(fw4 fw4Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fw4Var) == null) && fw4Var != null && fw4Var.getThreadData() != null && fw4Var.getThreadData().originalThreadData != null) {
                boolean z2 = false;
                if (fw4Var.getThreadData().originalThreadData.r != null) {
                    if (fw4Var.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = false;
                }
                yt5.a(1, z, this.b.mContext, fw4Var.getThreadData(), 0, this.a.z(), "from_nani_video", "concern_page", null, "concern_tab", "");
                za8.b(this.a.g(), fw4Var, 6);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rb8 a;

        public f(rb8 rb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rb8Var;
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
                ThreadCardUtils.jumpToPB((fw4) dn6Var, view2.getContext(), 1, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public g(rb8 rb8Var, ViewGroup viewGroup, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rb8Var, viewGroup, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.n
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(ss.a((vi) this.a, this.b, this.c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void B(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viVar) == null) {
            this.d = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: A */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dn6 dn6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dn6Var, threadCardViewHolder})) == null) {
            if (dn6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && dn6Var.a != null) {
                dn6Var.B(dn6Var.position + 1);
                threadCardViewHolder.a().s(i);
                if (threadCardViewHolder.a().f() instanceof eu) {
                    ((eu) threadCardViewHolder.a().f()).I(new g(this, viewGroup, view2, i));
                }
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity());
            ju juVar = new ju(this.b.getPageActivity());
            rs rsVar = new rs(this.b.getPageActivity());
            rsVar.o(this.a);
            rsVar.b(128);
            rsVar.c(1024);
            rsVar.x(new b(this));
            bVar.o(rsVar);
            xt xtVar = new xt(this.b);
            xtVar.q(Boolean.FALSE);
            xtVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            bVar.l().i(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds28));
            bVar.n(xtVar);
            xt xtVar2 = new xt(this.b);
            xtVar2.q(Boolean.TRUE);
            xtVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
            xtVar2.C(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            xtVar2.A(new c(this, juVar, xtVar2));
            bVar.h(xtVar2);
            juVar.q(Boolean.TRUE);
            juVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            juVar.B(new d(this, juVar));
            juVar.C(new e(this, juVar));
            bVar.h(juVar);
            bVar.h(new gu(this.b.getPageActivity()));
            bVar.h(new zs(this.b.getPageActivity()));
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 9;
            lw4Var.h = 9;
            euVar.C(lw4Var);
            euVar.E(9);
            euVar.J(4);
            euVar.F(1);
            euVar.b(32);
            euVar.D(false);
            bVar.m(euVar);
            cu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }
}
