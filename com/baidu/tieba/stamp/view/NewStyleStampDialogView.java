package com.baidu.tieba.stamp.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.o0.r.r.w1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes6.dex */
public class NewStyleStampDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w3.h.c f36048b;

    /* renamed from: c  reason: collision with root package name */
    public View f36049c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36050d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36051e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36052f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36053g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36054h;
    public TBLottieAnimationView i;
    public TBLottieAnimationView j;
    public TbImageView k;
    public SignStampIconsView l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public ObjectAnimator o;
    public ObjectAnimator p;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewStyleStampDialogView a;

        public a(NewStyleStampDialogView newStyleStampDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newStyleStampDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newStyleStampDialogView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NewStyleStampDialogView newStyleStampDialogView = this.a;
                newStyleStampDialogView.r(newStyleStampDialogView.i, R.raw.obfuscated_res_0x7f11004a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewStyleStampDialogView a;

        /* loaded from: classes6.dex */
        public class a extends d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.a.a;
                    newStyleStampDialogView.r(newStyleStampDialogView.j, R.raw.obfuscated_res_0x7f11004b, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewStyleStampDialogView newStyleStampDialogView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newStyleStampDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newStyleStampDialogView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.a.n == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.a;
                    newStyleStampDialogView.n = newStyleStampDialogView.j(1.0f, 1.0f, 500L);
                }
                this.a.n.addListener(new a(this));
                this.a.n.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewStyleStampDialogView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(NewStyleStampDialogView newStyleStampDialogView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newStyleStampDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newStyleStampDialogView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.a.p == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.a;
                    newStyleStampDialogView.p = newStyleStampDialogView.j(1.0f, 1.0f, 500L);
                }
                this.a.p.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1730804364, "Lcom/baidu/tieba/stamp/view/NewStyleStampDialogView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1730804364, "Lcom/baidu/tieba/stamp/view/NewStyleStampDialogView;");
                return;
            }
        }
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X017);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewStyleStampDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setStampIconsLayout(final List<w1.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.l.setVisibility(0);
        this.l.setStampIconsList(list);
        this.l.setSignStampIconClickListener(new c.a.p0.w3.h.b() { // from class: c.a.p0.w3.j.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.p0.w3.h.b
            public final void a(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    NewStyleStampDialogView.this.l(list, (w1.a) obj);
                }
            }
        });
    }

    public View getImgStampDialogCancelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36050d : (View) invokeV.objValue;
    }

    public View getStampDialogLookView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36053g : (View) invokeV.objValue;
    }

    public View getStampDialogShareView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36054h : (View) invokeV.objValue;
    }

    public c.a.p0.w3.h.c getmStampData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36048b : (c.a.p0.w3.h.c) invokeV.objValue;
    }

    public w1.a i(List<w1.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                w1.a aVar = list.get(i2);
                if (aVar != null) {
                    if (aVar.f()) {
                        return aVar;
                    }
                    if (aVar.e() == 1) {
                        i = i2;
                    }
                }
            }
            if (i > -1) {
                list.get(i).h(true);
                return list.get(i);
            }
            return null;
        }
        return (w1.a) invokeL.objValue;
    }

    public final ObjectAnimator j(float f2, float f3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.k, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3));
            ofPropertyValuesHolder.setDuration(j);
            ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f36049c = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d060a, this);
            setOrientation(1);
            this.f36050d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ed6);
            this.f36051e = (TextView) findViewById(R.id.obfuscated_res_0x7f09220d);
            this.f36052f = (TextView) findViewById(R.id.obfuscated_res_0x7f092210);
            this.f36053g = (TextView) findViewById(R.id.obfuscated_res_0x7f09220e);
            this.f36054h = (TextView) findViewById(R.id.obfuscated_res_0x7f09220f);
            this.i = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09026c);
            this.j = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09026d);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ed5);
            this.k = tbImageView;
            tbImageView.setDefaultResource(0);
            this.k.setDefaultBgResource(0);
            this.l = (SignStampIconsView) findViewById(R.id.obfuscated_res_0x7f091d91);
            o();
            p();
            e.a().postDelayed(new a(this), 80L);
        }
    }

    public /* synthetic */ void l(List list, w1.a aVar) {
        this.f36051e.setText(aVar.b());
        this.k.J(aVar.c(), 10, false);
        q();
        s(list, aVar);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.w3.h.c cVar = this.f36048b;
            if (cVar instanceof c.a.p0.w3.d) {
                c.a.p0.w3.d dVar = (c.a.p0.w3.d) cVar;
                this.f36051e.setText(dVar.b());
                this.k.J(dVar.a(), 10, false);
            } else if (cVar instanceof w1) {
                w1 w1Var = (w1) cVar;
                List<w1.a> a2 = w1Var.a();
                if (w1Var.b() == -1) {
                    this.f36052f.setText(getResources().getString(R.string.obfuscated_res_0x7f0f11b8));
                } else {
                    this.f36052f.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f11bc), Integer.valueOf(w1Var.b())));
                }
                if (ListUtils.isEmpty(a2)) {
                    return;
                }
                w1.a i = i(a2);
                if (i != null) {
                    this.f36051e.setText(i.b());
                    this.k.J(i.c(), 10, false);
                }
                setStampIconsLayout(a2);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f36051e);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0101);
            c.a.o0.r.v.c.d(this.f36052f).v(R.color.CAM_X0103);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f36053g);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0101);
            d3.n(R.string.J_X01);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.f36054h);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setPureDrawable(this.f36050d, R.drawable.obfuscated_res_0x7f0809b0, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k.setVisibility(0);
            if (this.m == null) {
                this.m = j(0.0f, 0.0f, 0L);
            }
            this.m.addListener(new b(this));
            this.m.start();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.setVisibility(0);
            if (this.o == null) {
                this.o = j(0.0f, 0.0f, 0L);
            }
            this.o.addListener(new c(this));
            this.o.start();
        }
    }

    public final void r(final TBLottieAnimationView tBLottieAnimationView, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{tBLottieAnimationView, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            tBLottieAnimationView.setAnimation(i);
            tBLottieAnimationView.setImageAssetsFolder("lottie_stamp_dialog/");
            tBLottieAnimationView.setRepeatCount(z ? -1 : 0);
            tBLottieAnimationView.post(new Runnable() { // from class: c.a.p0.w3.j.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TBLottieAnimationView.this.playAnimation();
                    }
                }
            });
        }
    }

    public final void s(List<w1.a> list, w1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, aVar) == null) {
            for (w1.a aVar2 : list) {
                if (aVar2 != null && !StringUtils.isNull(aVar2.b())) {
                    if (aVar2.b().equals(aVar.b())) {
                        aVar2.h(true);
                    } else {
                        aVar2.h(false);
                    }
                }
            }
        }
    }

    public void setStampData(c.a.p0.w3.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f36048b = cVar;
            n();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewStyleStampDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewStyleStampDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.a = context;
        k(context);
    }
}
