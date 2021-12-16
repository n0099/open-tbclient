package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
@TargetApi(11)
/* loaded from: classes13.dex */
public class BindCardHeadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f54498b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54499c;

    /* renamed from: d  reason: collision with root package name */
    public View f54500d;

    /* renamed from: e  reason: collision with root package name */
    public View f54501e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindCardHeadView(Context context) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_head_view"), this);
            this.a = (ImageView) findViewById(ResUtils.id(getContext(), "bind_card_img"));
            this.f54498b = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_title"));
            this.f54499c = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_subtitle"));
            this.f54500d = findViewById(ResUtils.id(getContext(), "bind_card_line"));
            this.f54501e = findViewById(ResUtils.id(getContext(), "bind_card_head_bottom_margin"));
        }
    }

    public void deleteSpan() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f54498b.getText() instanceof SpannableString)) {
            SpannableString spannableString = (SpannableString) this.f54498b.getText();
            for (ClickableSpan clickableSpan : (ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class)) {
                spannableString.removeSpan(clickableSpan);
            }
            this.f54498b.setText(spannableString);
        }
    }

    public void setImageSrcId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a.setImageResource(i2);
        }
    }

    public void setLineVisiable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f54500d.setVisibility(z ? 0 : 8);
            this.f54501e.setVisibility(z ? 8 : 0);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            this.f54499c.setText(charSequence);
        }
    }

    public void setSubTitleVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f54499c.setVisibility(i2);
        }
    }

    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.f54498b.setText(charSequence);
            if (charSequence instanceof Spannable) {
                this.f54498b.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    public void setTitleVisiable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f54498b.setVisibility(z ? 0 : 8);
            this.f54499c.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindCardHeadView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindCardHeadView(Context context, AttributeSet attributeSet, int i2) {
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
        a();
    }
}
