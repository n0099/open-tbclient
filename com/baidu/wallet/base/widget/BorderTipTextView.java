package com.baidu.wallet.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class BorderTipTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f52598b;

    /* renamed from: c  reason: collision with root package name */
    public int f52599c;

    /* renamed from: d  reason: collision with root package name */
    public int f52600d;

    /* renamed from: e  reason: collision with root package name */
    public ColorStateList f52601e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f52602f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = getPaddingLeft();
        this.f52598b = getPaddingRight();
        this.f52599c = getPaddingTop();
        this.f52600d = getPaddingBottom();
        this.f52601e = getTextColors();
        this.f52602f = getBackground();
    }

    public void setText(CharSequence charSequence, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, charSequence, z) == null) {
            if (z) {
                setBackgroundDrawable(ResUtils.getDrawable(getContext(), "wallet_base_tip_bg"));
                setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
                setText(charSequence);
                setPadding(6, 0, 6, 2);
                return;
            }
            setBackgroundDrawable(this.f52602f);
            setTextColor(this.f52601e);
            setText(charSequence);
            setPadding(this.a, this.f52599c, this.f52598b, this.f52600d);
        }
    }
}
