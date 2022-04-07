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
import com.repackage.a9;
import com.repackage.fk8;
import com.repackage.mu4;
import com.repackage.ni;
import com.repackage.oi;
/* loaded from: classes4.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public mu4 D;
    public mu4 E;
    public LikeModel F;
    public fk8 G;
    public b H;
    public boolean I;
    public Animation J;
    public String o;
    public long p;
    public TbPageContext<?> q;
    public TBSpecificationButtonConfig r;
    public TBSpecificationButtonConfig s;
    public a9 t;
    public fk8.a u;
    public boolean v;
    public int w;
    public int x;
    public boolean y;
    public final int z;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ NewFollowButton b;

        public a(NewFollowButton newFollowButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFollowButton, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFollowButton;
            this.a = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.C(this.a);
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
    public class b extends a9 implements fk8.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFollowButton;
        }

        @Override // com.repackage.fk8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                if (this.a.u != null) {
                    this.a.u.a(str, j);
                }
                this.a.I = false;
            }
        }

        @Override // com.repackage.fk8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                NewFollowButton newFollowButton = this.a;
                newFollowButton.D(false, newFollowButton.A);
                if (this.a.u != null) {
                    this.a.u.b(str, j);
                }
                this.a.I = false;
            }
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                if (this.a.F.getErrorCode() == 22) {
                    oi.N(this.a.q.getPageActivity(), this.a.q.getString(R.string.obfuscated_res_0x7f0f0803));
                    this.a.I = false;
                } else if (obj == null) {
                    this.a.I = false;
                } else if (this.a.F.getErrorCode() != 0) {
                    oi.N(this.a.q.getPageActivity(), this.a.F.getErrorString());
                    this.a.I = false;
                } else {
                    NewFollowButton newFollowButton = this.a;
                    newFollowButton.D(true, newFollowButton.A);
                    if (this.a.t != null) {
                        this.a.t.c(obj);
                    }
                    this.a.I = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.I || this.q == null) {
            return;
        }
        if (!oi.C()) {
            UtilHelper.showToast(this.q.getPageActivity(), this.q.getString(R.string.obfuscated_res_0x7f0f0c18));
        } else if (StringUtils.isNull(this.o) || this.p <= 0 || !ViewHelper.checkUpIsLogin(this.q.getPageActivity())) {
        } else {
            if (this.H == null) {
                this.H = new b(this, null);
            }
            if (this.F == null) {
                LikeModel likeModel = new LikeModel(this.q);
                this.F = likeModel;
                likeModel.setLoadDataCallBack(this.H);
            }
            if (ni.isForumName(this.o)) {
                this.I = true;
                this.F.L();
                this.F.P(this.o, String.valueOf(this.p));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.I || this.q == null) {
            return;
        }
        if (!oi.C()) {
            UtilHelper.showToast(this.q.getPageActivity(), this.q.getString(R.string.obfuscated_res_0x7f0f0c18));
        } else if (StringUtils.isNull(this.o) || this.p <= 0 || !ViewHelper.checkUpIsLogin(this.q.getPageActivity())) {
        } else {
            if (this.H == null) {
                this.H = new b(this, null);
            }
            if (this.G == null) {
                fk8 fk8Var = new fk8();
                this.G = fk8Var;
                fk8Var.b(this.H);
            }
            this.I = true;
            this.G.c(this.o, this.p);
        }
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                TBSpecificationButtonConfig tBSpecificationButtonConfig = this.s;
                if (tBSpecificationButtonConfig == null) {
                    if (this.E == null) {
                        mu4 mu4Var = new mu4();
                        this.E = mu4Var;
                        mu4Var.t(R.color.CAM_X0109);
                        this.E.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                    }
                    setConfig(this.E);
                } else {
                    setConfig(tBSpecificationButtonConfig);
                }
                setClickable(this.v);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6d));
            } else {
                TBSpecificationButtonConfig tBSpecificationButtonConfig2 = this.r;
                if (tBSpecificationButtonConfig2 == null) {
                    if (this.D == null) {
                        mu4 mu4Var2 = new mu4();
                        this.D = mu4Var2;
                        mu4Var2.r(R.color.CAM_X0302);
                        if (this.y) {
                            this.D.g(this.x);
                            this.D.i(this.z, 0, TBSpecificationButtonConfig.IconType.SVG);
                            this.D.f(this.w);
                        }
                    }
                    setConfig(this.D);
                } else {
                    setConfig(tBSpecificationButtonConfig2);
                }
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029c));
            }
            k();
            this.C = z;
        }
    }

    public final void D(boolean z, boolean z2) {
        Animation animation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2 && this.B != 0 && this.J == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.q.getPageActivity(), this.B);
                this.J = loadAnimation;
                loadAnimation.setAnimationListener(new a(this, z));
            }
            if (z2 && (animation = this.J) != null) {
                startAnimation(animation);
            } else {
                C(z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (this.C) {
                A();
            } else {
                B();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = true;
        this.w = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.x = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.y = true;
        this.z = R.drawable.icon_pure_add12_svg;
        this.A = false;
        this.I = false;
        setOnClickListener(this);
    }
}
