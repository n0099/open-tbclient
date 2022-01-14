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
import c.a.s0.s.q.z1;
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
/* loaded from: classes12.dex */
public class NewStyleStampDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48081e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.t3.h.c f48082f;

    /* renamed from: g  reason: collision with root package name */
    public View f48083g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f48084h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48085i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f48086j;
    public TextView k;
    public TextView l;
    public TBLottieAnimationView m;
    public TBLottieAnimationView n;
    public TbImageView o;
    public SignStampIconsView p;
    public ObjectAnimator q;
    public ObjectAnimator r;
    public ObjectAnimator s;
    public ObjectAnimator t;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewStyleStampDialogView f48087e;

        public a(NewStyleStampDialogView newStyleStampDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newStyleStampDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48087e = newStyleStampDialogView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NewStyleStampDialogView newStyleStampDialogView = this.f48087e;
                newStyleStampDialogView.q(newStyleStampDialogView.m, R.raw.new_style_stamp_one, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewStyleStampDialogView f48088e;

        /* loaded from: classes12.dex */
        public class a extends d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f48089e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar) {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48089e = bVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.f48089e.f48088e;
                    newStyleStampDialogView.q(newStyleStampDialogView.n, R.raw.new_style_stamp_two, true);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48088e = newStyleStampDialogView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f48088e.r == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.f48088e;
                    newStyleStampDialogView.r = newStyleStampDialogView.i(1.0f, 1.0f, 500L);
                }
                this.f48088e.r.addListener(new a(this));
                this.f48088e.r.start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewStyleStampDialogView f48090e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(NewStyleStampDialogView newStyleStampDialogView) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newStyleStampDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48090e = newStyleStampDialogView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.f48090e.t == null) {
                    NewStyleStampDialogView newStyleStampDialogView = this.f48090e;
                    newStyleStampDialogView.t = newStyleStampDialogView.i(1.0f, 1.0f, 500L);
                }
                this.f48090e.t.start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static abstract class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setStampIconsLayout(final List<z1.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.p.setVisibility(0);
        this.p.setStampIconsList(list);
        this.p.setSignStampIconClickListener(new c.a.t0.t3.h.b() { // from class: c.a.t0.t3.j.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.t0.t3.h.b
            public final void a(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    NewStyleStampDialogView.this.k(list, (z1.a) obj);
                }
            }
        });
    }

    public View getImgStampDialogCancelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48084h : (View) invokeV.objValue;
    }

    public z1.a getSelectedStampInfo(List<z1.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                z1.a aVar = list.get(i3);
                if (aVar != null) {
                    if (aVar.f()) {
                        return aVar;
                    }
                    if (aVar.e() == 1) {
                        i2 = i3;
                    }
                }
            }
            if (i2 > -1) {
                list.get(i2).m(true);
                return list.get(i2);
            }
            return null;
        }
        return (z1.a) invokeL.objValue;
    }

    public View getStampDialogLookView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public View getStampDialogShareView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public c.a.t0.t3.h.c getmStampData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48082f : (c.a.t0.t3.h.c) invokeV.objValue;
    }

    public final ObjectAnimator i(float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.o, PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f3));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f48083g = LayoutInflater.from(context).inflate(R.layout.new_sytle_stamp_dialog_view_layout, this);
            setOrientation(1);
            this.f48084h = (ImageView) findViewById(R.id.img_stamp_dialog_cancel);
            this.f48085i = (TextView) findViewById(R.id.tv_stamp_dialog_constellation);
            this.f48086j = (TextView) findViewById(R.id.tv_stamp_dialog_tip);
            this.k = (TextView) findViewById(R.id.tv_stamp_dialog_look);
            this.l = (TextView) findViewById(R.id.tv_stamp_dialog_share);
            this.m = (TBLottieAnimationView) findViewById(R.id.animation_one);
            this.n = (TBLottieAnimationView) findViewById(R.id.animation_two);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.img_stamp);
            this.o = tbImageView;
            tbImageView.setDefaultResource(0);
            this.o.setDefaultBgResource(0);
            this.p = (SignStampIconsView) findViewById(R.id.stamp_dialog_level_icons);
            n();
            o();
            e.a().postDelayed(new a(this), 80L);
        }
    }

    public /* synthetic */ void k(List list, z1.a aVar) {
        this.f48085i.setText(aVar.b());
        this.o.startLoad(aVar.c(), 10, false);
        p();
        r(list, aVar);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.t0.t3.h.c cVar = this.f48082f;
            if (cVar instanceof c.a.t0.t3.d) {
                c.a.t0.t3.d dVar = (c.a.t0.t3.d) cVar;
                this.f48085i.setText(dVar.b());
                this.o.startLoad(dVar.a(), 10, false);
            } else if (cVar instanceof z1) {
                z1 z1Var = (z1) cVar;
                List<z1.a> a2 = z1Var.a();
                if (z1Var.b() == -1) {
                    this.f48086j.setText(getResources().getString(R.string.stamp_full_level));
                } else {
                    this.f48086j.setText(String.format(getResources().getString(R.string.stamp_next_level_days), Integer.valueOf(z1Var.b())));
                }
                if (ListUtils.isEmpty(a2)) {
                    return;
                }
                z1.a selectedStampInfo = getSelectedStampInfo(a2);
                if (selectedStampInfo != null) {
                    this.f48085i.setText(selectedStampInfo.b());
                    this.o.startLoad(selectedStampInfo.c(), 10, false);
                }
                setStampIconsLayout(a2);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f48085i);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.f48086j).v(R.color.CAM_X0103);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(this.k);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0101);
            d3.n(R.string.J_X01);
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(this.l);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            WebPManager.setPureDrawable(this.f48084h, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.setVisibility(0);
            if (this.q == null) {
                this.q = i(0.0f, 0.0f, 0L);
            }
            this.q.addListener(new b(this));
            this.q.start();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.setVisibility(0);
            if (this.s == null) {
                this.s = i(0.0f, 0.0f, 0L);
            }
            this.s.addListener(new c(this));
            this.s.start();
        }
    }

    public final void q(final TBLottieAnimationView tBLottieAnimationView, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{tBLottieAnimationView, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            tBLottieAnimationView.setAnimation(i2);
            tBLottieAnimationView.setImageAssetsFolder("lottie_stamp_dialog/");
            tBLottieAnimationView.setRepeatCount(z ? -1 : 0);
            tBLottieAnimationView.post(new Runnable() { // from class: c.a.t0.t3.j.a
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

    public final void r(List<z1.a> list, z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, aVar) == null) {
            for (z1.a aVar2 : list) {
                if (aVar2 != null && !StringUtils.isNull(aVar2.b())) {
                    if (aVar2.b().equals(aVar.b())) {
                        aVar2.m(true);
                    } else {
                        aVar2.m(false);
                    }
                }
            }
        }
    }

    public void setStampData(c.a.t0.t3.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.f48082f = cVar;
            m();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewStyleStampDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.f48081e = context;
        j(context);
    }
}
