package com.baidu.tieba.impersonal.components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.components.LoadingMsgView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\u00020\u001f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/tieba/impersonal/components/LoadingMsgView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emotionText", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "fakeTextView", "Landroid/widget/TextView;", "handler", "Landroid/os/Handler;", "hasShowEmotionText", "", "getHasShowEmotionText", "()Z", "setHasShowEmotionText", "(Z)V", "imageView", "Lcom/baidu/tbadk/widget/image/TbImage;", "showEmotionTextStatusListener", "Lcom/baidu/tieba/impersonal/components/LoadingMsgView$ShowEmotionTextStatusListener;", "getShowEmotionTextStatusListener", "()Lcom/baidu/tieba/impersonal/components/LoadingMsgView$ShowEmotionTextStatusListener;", "setShowEmotionTextStatusListener", "(Lcom/baidu/tieba/impersonal/components/LoadingMsgView$ShowEmotionTextStatusListener;)V", "textView", "initAnimation", "", "initEmotionText", "initFakeEmotionText", "initLoadingImage", "setAnimationId", "animationId", "", "setEmotionText", "Companion", "ShowEmotionTextStatusListener", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LoadingMsgView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public TbImage b;
    public TextView c;
    public TextView d;
    public Handler e;
    public boolean f;
    public a g;

    /* loaded from: classes6.dex */
    public interface a {
        void onShow();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1599642613, "Lcom/baidu/tieba/impersonal/components/LoadingMsgView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1599642613, "Lcom/baidu/tieba/impersonal/components/LoadingMsgView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingMsgView(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes6.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingMsgView a;
        public final /* synthetic */ ValueAnimator b;

        public b(LoadingMsgView loadingMsgView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingMsgView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingMsgView;
            this.b = valueAnimator;
        }

        public static final void a(LoadingMsgView this$0, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, valueAnimator) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.a.size() > 0) {
                    this$0.b.setVisibility(8);
                    this$0.c.setVisibility(0);
                    this$0.d.setVisibility(4);
                    this$0.setHasShowEmotionText(true);
                    a showEmotionTextStatusListener = this$0.getShowEmotionTextStatusListener();
                    if (showEmotionTextStatusListener != null) {
                        showEmotionTextStatusListener.onShow();
                    }
                    valueAnimator.start();
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b.setVisibility(0);
                this.a.c.setVisibility(8);
                this.a.d.setVisibility(8);
                if (!this.a.getHasShowEmotionText()) {
                    Handler handler = this.a.e;
                    final LoadingMsgView loadingMsgView = this.a;
                    final ValueAnimator valueAnimator = this.b;
                    handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.a09
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LoadingMsgView.b.a(LoadingMsgView.this, valueAnimator);
                            }
                        }
                    }, 7000L);
                } else if (this.a.a.size() > 0) {
                    this.a.b.setVisibility(8);
                    this.a.c.setVisibility(0);
                    this.a.d.setVisibility(4);
                    this.a.setHasShowEmotionText(true);
                    a showEmotionTextStatusListener = this.a.getShowEmotionTextStatusListener();
                    if (showEmotionTextStatusListener != null) {
                        showEmotionTextStatusListener.onShow();
                    }
                    this.b.start();
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.b.cancel();
                this.a.e.removeCallbacksAndMessages(null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoadingMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new ArrayList<>();
        this.b = new TbImage(context, null, 0, 6, null);
        this.c = new EMTextView(context);
        this.d = new EMTextView(context);
        this.e = new Handler(Looper.getMainLooper());
        j();
        h();
        i();
        f();
    }

    public /* synthetic */ LoadingMsgView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void setAnimationId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            TbImage tbImage = this.b;
            tbImage.l("res://drawable/" + i);
        }
    }

    public final void setEmotionText(ArrayList<String> emotionText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, emotionText) == null) {
            Intrinsics.checkNotNullParameter(emotionText, "emotionText");
            this.a = emotionText;
        }
    }

    public final void setHasShowEmotionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f = z;
        }
    }

    public final void setShowEmotionTextStatusListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public static final void g(LoadingMsgView this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int currentPlayTime = (int) (valueAnimator.getCurrentPlayTime() / valueAnimator.getDuration());
            int currentPlayTime2 = (((int) ((valueAnimator.getCurrentPlayTime() % valueAnimator.getDuration()) / 500)) % 3) + 1;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            this$0.b.setVisibility(8);
            this$0.c.setVisibility(0);
            if (this$0.a.size() > 0) {
                ArrayList<String> arrayList = this$0.a;
                sb.append(arrayList.get(currentPlayTime % arrayList.size()));
                ArrayList<String> arrayList2 = this$0.a;
                sb2.append(arrayList2.get(currentPlayTime % arrayList2.size()));
            }
            for (int i = 0; i < currentPlayTime2; i++) {
                sb.append(".");
            }
            sb2.append("...");
            if (!Intrinsics.areEqual(sb, this$0.c.getText())) {
                this$0.c.setText(sb);
            }
            if (!Intrinsics.areEqual(sb2, this$0.d.getText())) {
                this$0.d.setText(sb2);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(8000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yz8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        LoadingMsgView.g(LoadingMsgView.this, valueAnimator);
                    }
                }
            });
            addOnAttachStateChangeListener(new b(this, ofFloat));
        }
    }

    public final boolean getHasShowEmotionText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final a getShowEmotionTextStatusListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (a) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds103), UtilHelper.getDimenPixelSize(R.dimen.tbds83));
            this.b.setVisibility(0);
            addView(this.b, layoutParams);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.c.setVisibility(8);
            this.c.setTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
            this.c.setSingleLine();
            EMManager.from(this.c).setTextSize(R.dimen.T_X05);
            this.c.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003));
            addView(this.c, layoutParams);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.d.setVisibility(8);
            this.d.setTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
            this.d.setSingleLine();
            EMManager.from(this.d).setTextSize(R.dimen.T_X05);
            this.d.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003));
            addView(this.d, layoutParams);
        }
    }
}
