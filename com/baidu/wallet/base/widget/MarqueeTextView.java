package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class MarqueeTextView extends TextView implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static final int f57590i = 2000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f57591a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57592b;

    /* renamed from: c  reason: collision with root package name */
    public int f57593c;

    /* renamed from: d  reason: collision with root package name */
    public int f57594d;

    /* renamed from: e  reason: collision with root package name */
    public int f57595e;

    /* renamed from: f  reason: collision with root package name */
    public int f57596f;

    /* renamed from: g  reason: collision with root package name */
    public int f57597g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57598h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context) {
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
        this.f57592b = true;
        this.f57595e = 0;
        this.f57596f = 2;
        this.f57597g = 10;
        this.f57598h = false;
    }

    private int getTextWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int measureText = (int) getPaint().measureText(getText().toString());
            this.f57593c = measureText;
            return measureText;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f57598h) {
                int width = getWidth();
                this.f57594d = width;
                if (width > getTextWidth()) {
                    this.f57592b = true;
                    return;
                }
                int scrollX = getScrollX();
                this.f57595e = scrollX;
                this.f57591a = scrollX;
                this.f57598h = false;
            }
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            this.f57592b = true;
            removeCallbacks(this);
            int i5 = this.f57595e;
            this.f57591a = i5;
            scrollTo(i5, 0);
            super.onTextChanged(charSequence, i2, i3, i4);
            this.f57598h = true;
            this.f57592b = false;
            postDelayed(this, 2000L);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f57591a + this.f57596f;
            this.f57591a = i2;
            scrollTo(i2, 0);
            if (this.f57592b) {
                return;
            }
            if (getScrollX() >= this.f57593c - this.f57594d) {
                scrollTo(this.f57595e, 0);
                this.f57591a = this.f57595e;
                postDelayed(this, 2000L);
            } else if (getScrollX() >= (this.f57593c - this.f57594d) - this.f57596f) {
                postDelayed(this, 2000L);
            } else {
                postDelayed(this, this.f57597g);
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57592b = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context, AttributeSet attributeSet) {
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
        this.f57592b = true;
        this.f57595e = 0;
        this.f57596f = 2;
        this.f57597g = 10;
        this.f57598h = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f57592b = true;
        this.f57595e = 0;
        this.f57596f = 2;
        this.f57597g = 10;
        this.f57598h = false;
    }
}
