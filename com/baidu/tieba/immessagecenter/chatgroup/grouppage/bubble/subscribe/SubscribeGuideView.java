package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.subscribe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/bubble/subscribe/SubscribeGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIcon", "Landroid/widget/ImageView;", "arrowLp", "Landroid/widget/RelativeLayout$LayoutParams;", "tipTextLp", "tipTextView", "Landroid/widget/TextView;", "dismiss", "", "initView", "onSkinChanged", "showTip", "tip", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SubscribeGuideView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public RelativeLayout.LayoutParams b;
    public TextView c;
    public RelativeLayout.LayoutParams d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscribeGuideView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscribeGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SubscribeGuideView(Context context, AttributeSet attributeSet, int i) {
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
        b();
    }

    public /* synthetic */ SubscribeGuideView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(8);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            ImageView imageView = new ImageView(getContext());
            this.a = imageView;
            RelativeLayout.LayoutParams layoutParams = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView = null;
            }
            imageView.setId(R.id.arrow_icon);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(yi.g(getContext(), R.dimen.tbds42), yi.g(getContext(), R.dimen.tbds13));
            this.b = layoutParams2;
            if (layoutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams2 = null;
            }
            layoutParams2.addRule(11);
            RelativeLayout.LayoutParams layoutParams3 = this.b;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams3 = null;
            }
            layoutParams3.rightMargin = yi.g(getContext(), R.dimen.M_H_X007);
            ImageView imageView2 = this.a;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView2 = null;
            }
            RelativeLayout.LayoutParams layoutParams4 = this.b;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams4 = null;
            }
            addView(imageView2, layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            this.d = layoutParams5;
            if (layoutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
                layoutParams5 = null;
            }
            layoutParams5.addRule(3, R.id.arrow_icon);
            RelativeLayout.LayoutParams layoutParams6 = this.d;
            if (layoutParams6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
                layoutParams6 = null;
            }
            layoutParams6.addRule(11);
            TextView textView = new TextView(getContext());
            this.c = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView = null;
            }
            textView.setIncludeFontPadding(false);
            TextView textView2 = this.c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView2 = null;
            }
            textView2.setPadding(yi.g(getContext(), R.dimen.M_W_X005), yi.g(getContext(), R.dimen.M_H_X003), yi.g(getContext(), R.dimen.M_W_X005), yi.g(getContext(), R.dimen.M_H_X003));
            TextView textView3 = this.c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView3 = null;
            }
            RelativeLayout.LayoutParams layoutParams7 = this.d;
            if (layoutParams7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
            } else {
                layoutParams = layoutParams7;
            }
            addView(textView3, layoutParams);
            c();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.a;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView = null;
            }
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.pic_tip_purple_arrow_up));
            TextView textView2 = this.c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView2 = null;
            }
            textView2.setBackground(SkinManager.getDrawable(R.drawable.pic_tip_purple_bg));
            TextView textView3 = this.c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
            } else {
                textView = textView3;
            }
            d85 d = d85.d(textView);
            d.x(R.color.CAM_X0101);
            d.C(R.dimen.T_X09);
            d.D(R.string.F_X01);
        }
    }

    public final void d(String tip) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tip) == null) {
            Intrinsics.checkNotNullParameter(tip, "tip");
            TextView textView = this.c;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView = null;
            }
            textView.setText(tip);
            setVisibility(0);
        }
    }
}
