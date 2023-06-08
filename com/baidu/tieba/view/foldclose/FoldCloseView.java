package com.baidu.tieba.view.foldclose;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.StatKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.R;
import com.baidu.tieba.cx6;
import com.baidu.tieba.rca;
import com.baidu.tieba.sca;
import com.baidu.tieba.tbadkcore.databinding.FoldCloseViewBinding;
import com.baidu.tieba.tca;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.foldclose.FoldCloseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0006\u0010/\u001a\u00020,J\b\u00100\u001a\u00020,H\u0002J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u000bH\u0016J\u0010\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020*H\u0016J\u0006\u00105\u001a\u00020,J\u001e\u00106\u001a\u00020,2\u0006\u0010)\u001a\u00020*2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bJ\u000e\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0010J\u0006\u0010;\u001a\u00020,R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/tieba/view/foldclose/FoldCloseView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/FoldCloseViewBinding;", "foldCloseData", "Lcom/baidu/tieba/view/foldclose/FoldCloseData;", "<set-?>", "", "isFolded", "()Z", "onCloseClickListener", "getOnCloseClickListener", "()Landroid/view/View$OnClickListener;", "setOnCloseClickListener", "(Landroid/view/View$OnClickListener;)V", "onFoldCloseWidthChangeListener", "Lcom/baidu/tieba/view/foldclose/OnFoldCloseWidthChangeListener;", "getOnFoldCloseWidthChangeListener", "()Lcom/baidu/tieba/view/foldclose/OnFoldCloseWidthChangeListener;", "setOnFoldCloseWidthChangeListener", "(Lcom/baidu/tieba/view/foldclose/OnFoldCloseWidthChangeListener;)V", "onFoldStateChangeListener", "Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;", "getOnFoldStateChangeListener", "()Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;", "setOnFoldStateChangeListener", "(Lcom/baidu/tieba/view/foldclose/OnFoldStateChangeListener;)V", "onOtherClickListener", "getOnOtherClickListener", "setOnOtherClickListener", "view", "Landroid/view/View;", "doAnimation", "", "oldWidth", "newWidth", StatKey.EDITADDR_PASTE_ADDRESS_STAGE_FOLD, "init", "onChangeSkinType", "type", "onClick", "v", "resetWidth", "setChild", "width", "height", "setData", "data", "unfold", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FoldCloseView extends RelativeLayout implements View.OnClickListener, cx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCloseViewBinding a;
    public View b;
    public rca c;
    public boolean d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public tca g;
    public sca h;

    /* loaded from: classes8.dex */
    public static final class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCloseView a;
        public final /* synthetic */ int b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

        public a(FoldCloseView foldCloseView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCloseView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCloseView;
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                layoutParams.width = this.b;
                this.a.setLayoutParams(layoutParams);
                sca onFoldCloseWidthChangeListener = this.a.getOnFoldCloseWidthChangeListener();
                if (onFoldCloseWidthChangeListener != null) {
                    int i = this.b;
                    onFoldCloseWidthChangeListener.a(i, i);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FoldCloseView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, v) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            FoldCloseViewBinding foldCloseViewBinding = this.a;
            if (foldCloseViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                foldCloseViewBinding = null;
            }
            if (Intrinsics.areEqual(v, foldCloseViewBinding.c)) {
                View.OnClickListener onClickListener = this.e;
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                    return;
                }
                return;
            }
            View.OnClickListener onClickListener2 = this.f;
            if (onClickListener2 != null) {
                onClickListener2.onClick(v);
            }
            if (this.d) {
                g();
            } else {
                c();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FoldCloseView(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldCloseView(Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = new rca();
        this.d = true;
        d();
    }

    public static final void b(FoldCloseView this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                int i = layoutParams.width;
                layoutParams.width = intValue;
                this$0.setLayoutParams(layoutParams);
                sca scaVar = this$0.h;
                if (scaVar != null) {
                    scaVar.a(i, intValue);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            ValueAnimator widthAnim = ValueAnimator.ofInt(i, i2);
            widthAnim.setDuration(this.c.a());
            widthAnim.setInterpolator(new DecelerateInterpolator());
            widthAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.qca
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FoldCloseView.b(FoldCloseView.this, valueAnimator);
                    }
                }
            });
            Intrinsics.checkNotNullExpressionValue(widthAnim, "widthAnim");
            widthAnim.addListener(new a(this, i2));
            widthAnim.start();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d) {
            return;
        }
        this.d = true;
        tca tcaVar = this.g;
        if (tcaVar != null) {
            tcaVar.a(true);
        }
        a(this.c.d() + (this.c.c() * 2), this.c.b() + (this.c.c() * 2));
        FoldCloseViewBinding foldCloseViewBinding = this.a;
        if (foldCloseViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            foldCloseViewBinding = null;
        }
        foldCloseViewBinding.c.setClickable(false);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FoldCloseViewBinding c = FoldCloseViewBinding.c(LayoutInflater.from(getContext()), this, true);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
            this.a = c;
            FoldCloseViewBinding foldCloseViewBinding = null;
            if (c == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                c = null;
            }
            c.c.setOnClickListener(this);
            FoldCloseViewBinding foldCloseViewBinding2 = this.a;
            if (foldCloseViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                foldCloseViewBinding = foldCloseViewBinding2;
            }
            foldCloseViewBinding.c.setClickable(false);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.d) {
            return;
        }
        this.d = true;
        tca tcaVar = this.g;
        if (tcaVar != null) {
            tcaVar.a(true);
        }
        int b = this.c.b() + (this.c.c() * 2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = layoutParams.width;
        layoutParams.width = b;
        sca scaVar = this.h;
        if (scaVar != null) {
            scaVar.a(i, b);
        }
        setLayoutParams(layoutParams);
        FoldCloseViewBinding foldCloseViewBinding = this.a;
        if (foldCloseViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            foldCloseViewBinding = null;
        }
        foldCloseViewBinding.c.setClickable(false);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.d) {
            return;
        }
        this.d = false;
        tca tcaVar = this.g;
        if (tcaVar != null) {
            tcaVar.a(false);
        }
        a(this.c.b() + (this.c.c() * 2), this.c.d() + (this.c.c() * 2));
        FoldCloseViewBinding foldCloseViewBinding = this.a;
        if (foldCloseViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            foldCloseViewBinding = null;
        }
        foldCloseViewBinding.c.setClickable(true);
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final View.OnClickListener getOnCloseClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final sca getOnFoldCloseWidthChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (sca) invokeV.objValue;
    }

    public final tca getOnFoldStateChangeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (tca) invokeV.objValue;
    }

    public final View.OnClickListener getOnOtherClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cx6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            View view2 = this.b;
            if (view2 instanceof cx6) {
                if (view2 != null) {
                    ((cx6) view2).onChangeSkinType(i);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.edgefloat.IChangeSkinType");
                }
            }
            ShadowDrawable offsetY = TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0211).setShapeRadius(vi.g(getContext(), R.dimen.tbds65)).setShadowRadius(vi.g(getContext(), R.dimen.tbds25)).setShadowColor(R.color.CAM_X0804).setOffsetX(0).setOffsetY(vi.g(getContext(), R.dimen.tbds8));
            FoldCloseViewBinding foldCloseViewBinding = this.a;
            if (foldCloseViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                foldCloseViewBinding = null;
            }
            offsetY.into(foldCloseViewBinding.b);
            FoldCloseViewBinding foldCloseViewBinding2 = this.a;
            if (foldCloseViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                foldCloseViewBinding2 = null;
            }
            foldCloseViewBinding2.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_close12, SkinManager.getColor(R.color.CAM_X0107), null));
        }
    }

    public final void setChild(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, view2, i, i2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.b = view2;
            FoldCloseViewBinding foldCloseViewBinding = this.a;
            FoldCloseViewBinding foldCloseViewBinding2 = null;
            if (foldCloseViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                foldCloseViewBinding = null;
            }
            foldCloseViewBinding.d.removeAllViews();
            FoldCloseViewBinding foldCloseViewBinding3 = this.a;
            if (foldCloseViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                foldCloseViewBinding2 = foldCloseViewBinding3;
            }
            foldCloseViewBinding2.d.addView(view2, i, i2);
        }
    }

    public final void setData(rca data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.c = data;
        }
    }

    public final void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public final void setOnFoldCloseWidthChangeListener(sca scaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, scaVar) == null) {
            this.h = scaVar;
        }
    }

    public final void setOnFoldStateChangeListener(tca tcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tcaVar) == null) {
            this.g = tcaVar;
        }
    }

    public final void setOnOtherClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }
}
