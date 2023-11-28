package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xg8 extends ci<an6, AutoVideoCardViewHolder<an6>> implements a26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public yh8 c;
    public String d;
    public vi e;
    public ku f;
    public im6<an6> g;

    /* loaded from: classes9.dex */
    public class a extends im6<an6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg8 b;

        public a(xg8 xg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.im6
        /* renamed from: d */
        public void a(View view2, an6 an6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, an6Var) == null) {
                am6.b().d(true);
                y16.c().h("page_recommend", "show_");
                if (this.b.c != null && an6Var != null && an6Var.getThreadData() != null && !StringUtils.isNull(an6Var.getThreadData().getTid())) {
                    if (an6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(an6Var.G(an6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !tf8.b(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L))) {
                        tf8.a(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(an6Var.getThreadData().getTid(), 0L), an6Var.u(), an6Var.k(), an6Var.h(), an6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, an6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, an6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;
        public final /* synthetic */ xg8 b;

        public b(xg8 xg8Var, ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg8Var, kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg8Var;
            this.a = kuVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(cw4 cw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cw4Var) != null) || cw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (cw4Var instanceof an6) {
                cw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(cw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(cw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg8 a;

        public c(xg8 xg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xg8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof an6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                an6 an6Var = (an6) piVar;
                an6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), an6Var);
                }
                if (!o36.a(view2.getContext(), an6Var.getThreadData())) {
                    ThreadCardUtils.jumpToPB((cw4) an6Var, view2.getContext(), 2, false, ss.a((vi) viewGroup, view2, i));
                    autoVideoCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        C();
    }

    public void F(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yh8Var) == null) {
            this.c = yh8Var;
        }
    }

    public void G(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viVar) == null) {
            this.e = viVar;
        }
    }

    @Override // com.baidu.tieba.a26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.d = str;
        }
    }

    public final cea A(an6 an6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, an6Var)) == null) {
            if (an6Var != null) {
                cea ceaVar = new cea();
                ceaVar.a = "1";
                ceaVar.c = an6Var.g;
                if (an6Var.getThreadData() != null) {
                    ceaVar.d = String.valueOf(an6Var.getThreadData().getFid());
                    ceaVar.v = an6Var.getThreadData().getNid();
                    if (an6Var.getThreadData().getThreadVideoInfo() != null) {
                        ceaVar.m = an6Var.getThreadData().getThreadVideoInfo().video_md5;
                        ceaVar.p = String.valueOf(an6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                ceaVar.k = an6Var.e();
                ceaVar.f = an6Var.k();
                ceaVar.l = an6Var.c();
                ceaVar.h = an6Var.u();
                ceaVar.e = TbadkCoreApplication.getCurrentAccount();
                ceaVar.q = String.valueOf(an6Var.h());
                if (an6Var.getThreadData() != null && an6Var.getThreadData().getBaijiahaoData() != null) {
                    ceaVar.t = an6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    ceaVar.u = an6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return ceaVar;
                }
                return ceaVar;
            }
            return null;
        }
        return (cea) invokeL.objValue;
    }

    public final void B(View view2, an6 an6Var) {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, an6Var) == null) && (kuVar = this.f) != null && kuVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, an6Var);
                di8.d(an6Var.a, this.a, an6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(an6Var.I()));
                di8.c(an6Var.a, an6Var.k(), an6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(an6Var.G(an6Var.a)));
                di8.c(an6Var.a, an6Var.k(), an6Var.h(), 1);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            an6.V = "c10708";
            an6.W = "c10735";
            an6.X = "c10709";
            an6.Y = "c10734";
            an6.Z = "c11929";
            an6.a0 = "c11928";
            an6.b0 = "c10756";
        }
    }

    public void onPause() {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (kuVar = this.f) != null) {
            kuVar.x();
        }
    }

    public void onResume() {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (kuVar = this.f) != null) {
            kuVar.y();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: D */
    public AutoVideoCardViewHolder<an6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            mi8 mi8Var = new mi8(this.b.getPageActivity());
            mi8Var.z(new b(this, mi8Var));
            this.f = mi8Var;
            mi8Var.o(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<an6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.g);
            k.t(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, an6 an6Var, AutoVideoCardViewHolder<an6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, an6Var, autoVideoCardViewHolder})) == null) {
            if (an6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            an6Var.B(an6Var.position + 1);
            an6Var.a.statFloor = an6Var.h();
            autoVideoCardViewHolder.a().s(i);
            an6Var.f1084T = 0;
            am6.b().a(an6Var.s());
            autoVideoCardViewHolder.z(A(an6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(an6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.g);
            di8.p(an6Var.a, this.a, an6Var.h());
            di8.o(an6Var.a, an6Var.k(), an6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
