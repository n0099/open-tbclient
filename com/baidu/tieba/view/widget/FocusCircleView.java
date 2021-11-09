package com.baidu.tieba.view.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class FocusCircleView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f55546e;

    /* renamed from: f  reason: collision with root package name */
    public int f55547f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f55548g;

    /* renamed from: h  reason: collision with root package name */
    public ObjectAnimator f55549h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55550i;
    public Bitmap j;

    /* loaded from: classes9.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FocusCircleView f55551e;

        /* renamed from: com.baidu.tieba.view.widget.FocusCircleView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1766a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f55552e;

            public C1766a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55552e = aVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f55552e.f55551e.f55550i = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }
        }

        public a(FocusCircleView focusCircleView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {focusCircleView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55551e = focusCircleView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f55551e.f55549h == null) {
                    FocusCircleView focusCircleView = this.f55551e;
                    focusCircleView.f55549h = ObjectAnimator.ofFloat(focusCircleView, Key.ALPHA, 1.0f, 0.0f);
                    this.f55551e.f55549h.setDuration(960L);
                    this.f55551e.f55549h.addListener(new C1766a(this));
                }
                this.f55551e.f55549h.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f55551e.setAlpha(1.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusCircleView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55547f = 4;
        this.f55550i = false;
        d(context);
    }

    public void beginFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55550i = true;
            AnimatorSet animatorSet = this.f55548g;
            if (animatorSet == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, Key.SCALE_X, 3.0f, 2.0f, 1.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, Key.SCALE_Y, 3.0f, 2.0f, 1.0f);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f55548g = animatorSet2;
                animatorSet2.play(ofFloat).with(ofFloat2);
                this.f55548g.setInterpolator(new LinearInterpolator());
                this.f55548g.setDuration(500L);
                this.f55548g.addListener(new a(this));
            } else {
                if (animatorSet.isRunning()) {
                    this.f55548g.cancel();
                }
                ObjectAnimator objectAnimator = this.f55549h;
                if (objectAnimator != null && objectAnimator.isRunning()) {
                    this.f55549h.cancel();
                }
            }
            this.f55548g.start();
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Paint paint = new Paint();
            this.f55546e = paint;
            paint.setAntiAlias(true);
            this.f55546e.setStyle(Paint.Style.STROKE);
            this.f55546e.setColor(Color.parseColor("#ffffffff"));
            this.f55546e.setStrokeWidth(this.f55547f);
            setAlpha(0.0f);
            this.j = BitmapHelper.resizeBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.camera_focus), 180);
        }
    }

    public void disappearImmediately() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(4);
            AnimatorSet animatorSet = this.f55548g;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f55548g.cancel();
            }
            ObjectAnimator objectAnimator = this.f55549h;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                return;
            }
            this.f55549h.cancel();
        }
    }

    public boolean isFocusing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55550i : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            canvas.drawBitmap(this.j, (getWidth() / 2) - 80, (getHeight() / 2) - 80, this.f55546e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55547f = 4;
        this.f55550i = false;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusCircleView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f55547f = 4;
        this.f55550i = false;
        d(context);
    }
}
