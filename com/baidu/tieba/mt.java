package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class mt extends wr<jv4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public int g;
    public ThreadCommentAndPraiseInfoLayout h;
    public jv4 i;

    /* loaded from: classes7.dex */
    public class c implements vt.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt a;

        /* loaded from: classes7.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    vt.a aVar = new vt.a(10);
                    aVar.d(2);
                    this.a.a.a.q(aVar);
                }
            }
        }

        public c(mt mtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mtVar;
        }

        @Override // com.baidu.tieba.vt.b
        public boolean a(vt.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (this.a.h != null) {
                    this.a.h.manualPraise(new a(this));
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt a;

        public a(mt mtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mtVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g() != null) {
                this.a.g().a(view2, this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements vt.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt a;

        public b(mt mtVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mtVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mtVar;
        }

        @Override // com.baidu.tieba.vt.b
        public boolean a(vt.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!(aVar.c() instanceof Boolean)) {
                    return false;
                }
                if (((Boolean) aVar.c()).booleanValue()) {
                    mt mtVar = this.a;
                    mtVar.f = mtVar.g;
                } else if ((this.a.f & 128) <= 0) {
                    mt.y(this.a, -5);
                    mt.z(this.a, 64);
                }
                this.a.h.setShowFlag(this.a.f);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mt(Context context) {
        this(context, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mt(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 11;
        this.g = 11;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().r instanceof ThreadCardBottomOpSegmentLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().r.getParent() == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().r;
            this.h = threadCommentAndPraiseInfoLayout;
            threadCommentAndPraiseInfoLayout.setContext(context);
        } else {
            this.h = new ThreadCardBottomOpSegmentLayout(context, z);
        }
        this.h.setReplyTimeVisible(false);
        this.h.setShowPraiseNum(true);
        this.h.setNeedAddPraiseIcon(true);
        this.h.setNeedAddReplyIcon(true);
        this.h.setShareVisible(true);
        this.h.setForumAfterClickListener(new a(this));
        if (this.h.getAgreeView() != null) {
            this.h.getAgreeView().setTextViewMinEmsWhenCard();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    /* renamed from: D */
    public void onBindDataToView(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv4Var) == null) {
            this.i = jv4Var;
            this.h.setData(jv4Var.getThreadData());
            C();
        }
    }

    public void E(pv4 pv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pv4Var) == null) {
            this.h.setAgreeStatisticData(pv4Var);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            J(true);
            O();
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.h.setFrom(i);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h.V = i;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.h.setGameId(i);
        }
    }

    public void J(boolean z) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
        }
    }

    public void K(ThreadCommentAndPraiseInfoLayout.m mVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(mVar);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.h.setShareReportFrom(i);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.h.setStType(str);
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.h.setTabName(str);
        }
    }

    @Override // com.baidu.tieba.wr
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            int i2 = i | this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.baidu.tieba.wr
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            int i2 = (~i) & this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    public static /* synthetic */ int y(mt mtVar, int i) {
        int i2 = i & mtVar.f;
        mtVar.f = i2;
        return i2;
    }

    public static /* synthetic */ int z(mt mtVar, int i) {
        int i2 = i | mtVar.f;
        mtVar.f = i2;
        return i2;
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, tbPageContext, i) == null) {
            this.h.onChangeSkinType();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = false;
            o(this.h, 0);
            wr g = this.a.g();
            if (g == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) g.k();
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i < childCount) {
                    if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                List<ds> j = this.a.j();
                if (!ListUtils.isEmpty(j)) {
                    for (ds dsVar : j) {
                        if (dsVar != null && dsVar.k() != null && dsVar.k().getVisibility() == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void O() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.setUseDynamicLikeRes();
        }
    }

    public void P() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null && threadCommentAndPraiseInfoLayout.getAgreeView() != null) {
            this.h.getAgreeView().V();
        }
    }

    public void Q() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.showFestivalCommentTip();
        }
    }

    public void R() {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.updateReplyNumDelay();
        }
    }

    @Override // com.baidu.tieba.wr
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wr
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.o(4, new b(this));
            this.a.o(9, new c(this));
        }
    }
}
