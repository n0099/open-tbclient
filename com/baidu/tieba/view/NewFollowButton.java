package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.r0.y3.i0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public final int C;
    public boolean D;
    public int E;
    public boolean F;
    public c.a.q0.r.l0.n.b G;
    public c.a.q0.r.l0.n.b H;
    public LikeModel I;
    public i0 J;
    public b K;
    public boolean L;
    public Animation M;
    public String r;
    public long s;
    public TbPageContext<?> t;
    public TBSpecificationButtonConfig u;
    public TBSpecificationButtonConfig v;
    public e w;
    public i0.a x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFollowButton f47741b;

        public a(NewFollowButton newFollowButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFollowButton, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47741b = newFollowButton;
            this.a = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f47741b.updateLikeStatus(this.a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends e implements i0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFollowButton a;

        public b(NewFollowButton newFollowButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFollowButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFollowButton;
        }

        @Override // c.a.r0.y3.i0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                if (this.a.x != null) {
                    this.a.x.a(str, j2);
                }
                this.a.L = false;
            }
        }

        @Override // c.a.r0.y3.i0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                NewFollowButton newFollowButton = this.a;
                newFollowButton.u(false, newFollowButton.D);
                if (this.a.x != null) {
                    this.a.x.b(str, j2);
                }
                this.a.L = false;
            }
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                if (this.a.I.getErrorCode() == 22) {
                    n.N(this.a.t.getPageActivity(), this.a.t.getString(R.string.had_liked_forum));
                    this.a.L = false;
                } else if (obj == null) {
                    this.a.L = false;
                } else if (this.a.I.getErrorCode() != 0) {
                    n.N(this.a.t.getPageActivity(), this.a.I.getErrorString());
                    this.a.L = false;
                } else {
                    NewFollowButton newFollowButton = this.a;
                    newFollowButton.u(true, newFollowButton.D);
                    if (this.a.w != null) {
                        this.a.w.c(obj);
                    }
                    this.a.L = false;
                }
            }
        }

        public /* synthetic */ b(NewFollowButton newFollowButton, a aVar) {
            this(newFollowButton);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewFollowButton(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public NewFollowButton initConcernInfo(TbPageContext<?> tbPageContext, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, str, Long.valueOf(j2)})) == null) {
            this.t = tbPageContext;
            this.r = str;
            this.s = j2;
            return this;
        }
        return (NewFollowButton) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (this.F) {
                s();
            } else {
                t();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.L || this.t == null) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.t.getPageActivity(), this.t.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.r) || this.s <= 0 || !ViewHelper.checkUpIsLogin(this.t.getPageActivity())) {
        } else {
            if (this.K == null) {
                this.K = new b(this, null);
            }
            if (this.I == null) {
                LikeModel likeModel = new LikeModel(this.t);
                this.I = likeModel;
                likeModel.setLoadDataCallBack(this.K);
            }
            if (m.isForumName(this.r)) {
                this.L = true;
                this.I.J();
                this.I.N(this.r, String.valueOf(this.s));
            }
        }
    }

    public NewFollowButton setAddIcon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.B = z;
            c.a.q0.r.l0.n.b bVar = this.G;
            if (bVar != null) {
                bVar.i(z ? this.C : 0, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            return this;
        }
        return (NewFollowButton) invokeZ.objValue;
    }

    public NewFollowButton setAnimationId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.E = i2;
            return this;
        }
        return (NewFollowButton) invokeI.objValue;
    }

    public NewFollowButton setIconSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.A = i2;
            c.a.q0.r.l0.n.b bVar = this.G;
            if (bVar != null) {
                bVar.g(i2);
            }
            return this;
        }
        return (NewFollowButton) invokeI.objValue;
    }

    public NewFollowButton setLeftIconSpace(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.z = i2;
            c.a.q0.r.l0.n.b bVar = this.G;
            if (bVar != null) {
                bVar.f(i2);
            }
            return this;
        }
        return (NewFollowButton) invokeI.objValue;
    }

    public NewFollowButton setLikeConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tBSpecificationButtonConfig)) == null) {
            this.u = tBSpecificationButtonConfig;
            return this;
        }
        return (NewFollowButton) invokeL.objValue;
    }

    public NewFollowButton setLikeModelCallback(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar)) == null) {
            this.w = eVar;
            return this;
        }
        return (NewFollowButton) invokeL.objValue;
    }

    public NewFollowButton setUnLikeCallback(i0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            this.x = aVar;
            return this;
        }
        return (NewFollowButton) invokeL.objValue;
    }

    public NewFollowButton setUnLikeConfig(TBSpecificationButtonConfig tBSpecificationButtonConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, tBSpecificationButtonConfig)) == null) {
            this.v = tBSpecificationButtonConfig;
            return this;
        }
        return (NewFollowButton) invokeL.objValue;
    }

    public NewFollowButton setUnlikeClickable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.y = z;
            return this;
        }
        return (NewFollowButton) invokeZ.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.L || this.t == null) {
            return;
        }
        if (!n.C()) {
            UtilHelper.showToast(this.t.getPageActivity(), this.t.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.r) || this.s <= 0 || !ViewHelper.checkUpIsLogin(this.t.getPageActivity())) {
        } else {
            if (this.K == null) {
                this.K = new b(this, null);
            }
            if (this.J == null) {
                i0 i0Var = new i0();
                this.J = i0Var;
                i0Var.b(this.K);
            }
            this.L = true;
            this.J.c(this.r, this.s);
        }
    }

    public final void u(boolean z, boolean z2) {
        Animation animation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 && this.E != 0 && this.M == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.t.getPageActivity(), this.E);
                this.M = loadAnimation;
                loadAnimation.setAnimationListener(new a(this, z));
            }
            if (z2 && (animation = this.M) != null) {
                startAnimation(animation);
            } else {
                updateLikeStatus(z);
            }
        }
    }

    public final void updateLikeStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.v;
                if (tBSpecificationButtonConfig == null) {
                    if (this.H == null) {
                        c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
                        this.H = bVar;
                        bVar.t(R.color.CAM_X0109);
                        this.H.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    }
                    setConfig(this.H);
                } else {
                    setConfig(tBSpecificationButtonConfig);
                }
                setClickable(this.y);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.u;
                if (tBSpecificationButtonConfig2 == null) {
                    if (this.G == null) {
                        c.a.q0.r.l0.n.b bVar2 = new c.a.q0.r.l0.n.b();
                        this.G = bVar2;
                        bVar2.r(R.color.CAM_X0302);
                        if (this.B) {
                            this.G.g(this.A);
                            this.G.i(this.C, 0, TBSpecificationButtonConfig.IconType.SVG);
                            this.G.f(this.z);
                        }
                    }
                    setConfig(this.G);
                } else {
                    setConfig(tBSpecificationButtonConfig2);
                }
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
            changeSkinType();
            this.F = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.A = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.B = true;
        this.C = R.drawable.icon_pure_add12_svg;
        this.D = false;
        this.L = false;
        setOnClickListener(this);
    }
}
