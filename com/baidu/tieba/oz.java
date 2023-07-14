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
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class oz extends xx<t15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;
    public int g;
    public ThreadCommentAndPraiseInfoLayout h;
    public t15 i;

    /* loaded from: classes7.dex */
    public class c implements xz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz a;

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
                    xz.a aVar = new xz.a(10);
                    aVar.d(2);
                    this.a.a.a.p(aVar);
                }
            }
        }

        public c(oz ozVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ozVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ozVar;
        }

        @Override // com.baidu.tieba.xz.b
        public boolean a(xz.a aVar) {
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
        public final /* synthetic */ oz a;

        public a(oz ozVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ozVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ozVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i() != null) {
                this.a.i().a(view2, this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz a;

        public b(oz ozVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ozVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ozVar;
        }

        @Override // com.baidu.tieba.xz.b
        public boolean a(xz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (!(aVar.c() instanceof Boolean)) {
                    return false;
                }
                if (((Boolean) aVar.c()).booleanValue()) {
                    oz ozVar = this.a;
                    ozVar.f = ozVar.g;
                } else if ((this.a.f & 128) <= 0) {
                    this.a.f &= -5;
                    this.a.f |= 64;
                }
                this.a.h.setShowFlag(this.a.f);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oz(Context context) {
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
    public oz(Context context, boolean z) {
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
    @Override // com.baidu.tieba.ry
    /* renamed from: C */
    public void b(t15 t15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t15Var) == null) {
            this.i = t15Var;
            this.h.setData(t15Var.getThreadData());
            B();
        }
    }

    public void D(z15 z15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z15Var) == null) {
            this.h.setAgreeStatisticData(z15Var);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            I(true);
            O();
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.h.setFrom(i);
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h.V = i;
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.h.setGameId(i);
        }
    }

    public void I(boolean z) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (threadCommentAndPraiseInfoLayout = this.h) != null) {
            threadCommentAndPraiseInfoLayout.setNeedMatchStrategy(z);
        }
    }

    public void J(ThreadCommentAndPraiseInfoLayout.m mVar) {
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

    @Override // com.baidu.tieba.xx
    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            int i2 = i | this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.baidu.tieba.xx
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            int i2 = (~i) & this.f;
            this.f = i2;
            this.h.setShowFlag(i2);
            this.g = this.f;
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, tbPageContext, i) == null) {
            this.h.onChangeSkinType();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = false;
            p(this.h, 0);
            xx g = this.a.g();
            if (g == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) g.l();
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
                List<ey> i2 = this.a.i();
                if (!ListUtils.isEmpty(i2)) {
                    for (ey eyVar : i2) {
                        if (eyVar != null && eyVar.l() != null && eyVar.l().getVisibility() == 0) {
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
            this.h.getAgreeView().W();
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

    @Override // com.baidu.tieba.xx
    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xx
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.n(4, new b(this));
            this.a.n(9, new c(this));
        }
    }
}
