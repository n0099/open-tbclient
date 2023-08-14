package com.baidu.ufosdk.hybrid.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.p1;
/* loaded from: classes9.dex */
public class FeedbackTitleBar extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public RelativeLayout b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public ProgressBar f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackTitleBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"CustomViewStyleable"})
    public FeedbackTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UFOTitleBar);
        CharSequence text = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        a();
        if (text != null) {
            a(text);
        }
    }

    public FeedbackTitleBar a(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            this.d.setText(charSequence);
            return this;
        }
        return (FeedbackTitleBar) invokeL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0219, (ViewGroup) this, true);
            this.b = (RelativeLayout) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09259c);
            this.c = (LinearLayout) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918a8);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918a7);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918a9);
            this.d = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918c5);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918b3);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918b1);
            this.e = textView2;
            textView2.setTextColor(p1.a(-10066330, -5262406, -10066330, -10066330));
            ImageView imageView2 = (ImageView) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918b2);
            inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918b0);
            this.f = (ProgressBar) inflate.findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090781);
            setBackgroundColor(-65536);
            setGravity(16);
            setOrientation(0);
        }
    }
}
