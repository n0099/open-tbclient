package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
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
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.e;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.h3.f0;
/* loaded from: classes4.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public final int D;
    public boolean E;
    public int F;
    public boolean G;
    public d.a.p0.s.f0.n.b H;
    public d.a.p0.s.f0.n.b I;
    public LikeModel J;
    public f0 K;
    public b L;
    public boolean M;
    public Animation N;
    public String s;
    public long t;
    public TbPageContext<?> u;
    public TBSpecificationButtonConfig v;
    public TBSpecificationButtonConfig w;
    public e x;
    public f0.a y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f22292a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewFollowButton f22293b;

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
            this.f22293b = newFollowButton;
            this.f22292a = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f22293b.B(this.f22292a);
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

    /* loaded from: classes4.dex */
    public class b extends e implements f0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFollowButton f22294a;

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
            this.f22294a = newFollowButton;
        }

        @Override // d.a.q0.h3.f0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                if (this.f22294a.y != null) {
                    this.f22294a.y.a(str, j);
                }
                this.f22294a.M = false;
            }
        }

        @Override // d.a.q0.h3.f0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                NewFollowButton newFollowButton = this.f22294a;
                newFollowButton.F(false, newFollowButton.E);
                if (this.f22294a.y != null) {
                    this.f22294a.y.b(str, j);
                }
                this.f22294a.M = false;
            }
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                if (this.f22294a.J.getErrorCode() == 22) {
                    l.M(this.f22294a.u.getPageActivity(), this.f22294a.u.getString(R.string.had_liked_forum));
                    this.f22294a.M = false;
                } else if (obj == null) {
                    this.f22294a.M = false;
                } else if (this.f22294a.J.getErrorCode() != 0) {
                    l.M(this.f22294a.u.getPageActivity(), this.f22294a.J.getErrorString());
                    this.f22294a.M = false;
                } else {
                    NewFollowButton newFollowButton = this.f22294a;
                    newFollowButton.F(true, newFollowButton.E);
                    if (this.f22294a.x != null) {
                        this.f22294a.x.c(obj);
                    }
                    this.f22294a.M = false;
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.M || this.u == null) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.u.getPageActivity(), this.u.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.s) || this.t <= 0 || !ViewHelper.checkUpIsLogin(this.u.getPageActivity())) {
        } else {
            if (this.L == null) {
                this.L = new b(this, null);
            }
            if (this.K == null) {
                f0 f0Var = new f0();
                this.K = f0Var;
                f0Var.b(this.L);
            }
            this.M = true;
            this.K.c(this.s, this.t);
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.w;
                if (tBSpecificationButtonConfig == null) {
                    if (this.I == null) {
                        d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                        this.I = bVar;
                        bVar.r(R.color.CAM_X0109);
                        this.I.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    }
                    setConfig(this.I);
                } else {
                    setConfig(tBSpecificationButtonConfig);
                }
                setClickable(this.z);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.v;
                if (tBSpecificationButtonConfig2 == null) {
                    if (this.H == null) {
                        d.a.p0.s.f0.n.b bVar2 = new d.a.p0.s.f0.n.b();
                        this.H = bVar2;
                        bVar2.q(R.color.CAM_X0302);
                        if (this.C) {
                            this.H.g(this.B);
                            this.H.i(this.D, 0, TBSpecificationButtonConfig.IconType.SVG);
                            this.H.f(this.A);
                        }
                    }
                    setConfig(this.H);
                } else {
                    setConfig(tBSpecificationButtonConfig2);
                }
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
            k();
            this.G = z;
        }
    }

    public final void F(boolean z, boolean z2) {
        Animation animation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 && this.F != 0 && this.N == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.u.getPageActivity(), this.F);
                this.N = loadAnimation;
                loadAnimation.setAnimationListener(new a(this, z));
            }
            if (z2 && (animation = this.N) != null) {
                startAnimation(animation);
            } else {
                B(z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.G) {
                z();
            } else {
                A();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.M || this.u == null) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.u.getPageActivity(), this.u.getString(R.string.neterror));
        } else if (StringUtils.isNull(this.s) || this.t <= 0 || !ViewHelper.checkUpIsLogin(this.u.getPageActivity())) {
        } else {
            if (this.L == null) {
                this.L = new b(this, null);
            }
            if (this.J == null) {
                LikeModel likeModel = new LikeModel(this.u);
                this.J = likeModel;
                likeModel.setLoadDataCallBack(this.L);
            }
            if (k.isForumName(this.s)) {
                this.M = true;
                this.J.I();
                this.J.L(this.s, String.valueOf(this.t));
            }
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
        this.z = true;
        this.A = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.B = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.C = true;
        this.D = R.drawable.icon_pure_add12_svg;
        this.E = false;
        this.M = false;
        setOnClickListener(this);
    }
}
