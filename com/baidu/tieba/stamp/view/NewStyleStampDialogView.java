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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.c45;
import com.baidu.tieba.rea;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.tieba.vea;
import com.baidu.tieba.wea;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class NewStyleStampDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public wea b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TBLottieAnimationView i;
    public TBLottieAnimationView j;
    public TbImageView k;
    public SignStampIconsView l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public ObjectAnimator o;
    public ObjectAnimator p;

    /* loaded from: classes8.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewStyleStampDialogView a;

        /* loaded from: classes8.dex */
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
                    newStyleStampDialogView.r(newStyleStampDialogView.j, R.raw.new_style_stamp_two, true);
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

    /* loaded from: classes8.dex */
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
                newStyleStampDialogView.r(newStyleStampDialogView.i, R.raw.new_style_stamp_one, false);
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static abstract class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    public View getImgStampDialogCancelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public View getStampDialogLookView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public View getStampDialogShareView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public wea getmStampData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (wea) invokeV.objValue;
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

    public final ObjectAnimator j(float f, float f2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.k, PropertyValuesHolder.ofFloat(Key.SCALE_X, f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, f2));
            ofPropertyValuesHolder.setDuration(j);
            ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    private void setStampIconsLayout(final List<c45.a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, list) == null) && !ListUtils.isEmpty(list)) {
            this.l.setVisibility(0);
            this.l.setStampIconsList(list);
            this.l.setSignStampIconClickListener(new vea() { // from class: com.baidu.tieba.yea
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vea
                public final void a(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        NewStyleStampDialogView.this.l(list, (c45.a) obj);
                    }
                }
            });
        }
    }

    public void setStampData(wea weaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, weaVar) == null) {
            this.b = weaVar;
            n();
        }
    }

    public /* synthetic */ void l(List list, c45.a aVar) {
        this.e.setText(aVar.b());
        this.k.startLoad(aVar.c(), 10, false);
        q();
        s(list, aVar);
    }

    public c45.a i(List<c45.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int size = list.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                c45.a aVar = list.get(i2);
                if (aVar != null) {
                    if (aVar.f()) {
                        return aVar;
                    }
                    if (aVar.e() == 1) {
                        i = i2;
                    }
                }
            }
            if (i <= -1) {
                return null;
            }
            list.get(i).h(true);
            return list.get(i);
        }
        return (c45.a) invokeL.objValue;
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.c = LayoutInflater.from(context).inflate(R.layout.new_sytle_stamp_dialog_view_layout, this);
            setOrientation(1);
            this.d = (ImageView) findViewById(R.id.img_stamp_dialog_cancel);
            this.e = (TextView) findViewById(R.id.tv_stamp_dialog_constellation);
            this.f = (TextView) findViewById(R.id.tv_stamp_dialog_tip);
            this.g = (TextView) findViewById(R.id.tv_stamp_dialog_look);
            this.h = (TextView) findViewById(R.id.tv_stamp_dialog_share);
            this.i = (TBLottieAnimationView) findViewById(R.id.animation_one);
            this.j = (TBLottieAnimationView) findViewById(R.id.animation_two);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.img_stamp);
            this.k = tbImageView;
            tbImageView.setDefaultResource(0);
            this.k.setDefaultBgResource(0);
            this.l = (SignStampIconsView) findViewById(R.id.stamp_dialog_level_icons);
            o();
            p();
            SafeHandler.getInst().postDelayed(new a(this), 80L);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            wea weaVar = this.b;
            if (weaVar instanceof rea) {
                rea reaVar = (rea) weaVar;
                this.e.setText(reaVar.b());
                this.k.startLoad(reaVar.a(), 10, false);
            } else if (weaVar instanceof c45) {
                c45 c45Var = (c45) weaVar;
                List<c45.a> a2 = c45Var.a();
                if (c45Var.b() == -1) {
                    this.f.setText(getResources().getString(R.string.stamp_full_level));
                } else {
                    this.f.setText(String.format(getResources().getString(R.string.stamp_next_level_days), Integer.valueOf(c45Var.b())));
                }
                if (!ListUtils.isEmpty(a2)) {
                    c45.a i = i(a2);
                    if (i != null) {
                        this.e.setText(i.b());
                        this.k.startLoad(i.c(), 10, false);
                    }
                    setStampIconsLayout(a2);
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            EMManager.from(this.e).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0103);
            EMManager.from(this.g).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0101).setCorner(R.string.J_X01);
            EMManager.from(this.h).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public final void r(final TBLottieAnimationView tBLottieAnimationView, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{tBLottieAnimationView, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            tBLottieAnimationView.setAnimation(i);
            tBLottieAnimationView.setImageAssetsFolder("lottie_stamp_dialog/");
            if (z) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            tBLottieAnimationView.setRepeatCount(i2);
            tBLottieAnimationView.post(new Runnable() { // from class: com.baidu.tieba.zea
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

    public final void s(List<c45.a> list, c45.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, aVar) == null) {
            for (c45.a aVar2 : list) {
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
}
