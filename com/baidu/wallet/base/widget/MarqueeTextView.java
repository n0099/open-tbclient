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
    public static final int f58511i = 2000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f58512a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58513b;

    /* renamed from: c  reason: collision with root package name */
    public int f58514c;

    /* renamed from: d  reason: collision with root package name */
    public int f58515d;

    /* renamed from: e  reason: collision with root package name */
    public int f58516e;

    /* renamed from: f  reason: collision with root package name */
    public int f58517f;

    /* renamed from: g  reason: collision with root package name */
    public int f58518g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58519h;

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
        this.f58513b = true;
        this.f58516e = 0;
        this.f58517f = 2;
        this.f58518g = 10;
        this.f58519h = false;
    }

    private int getTextWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int measureText = (int) getPaint().measureText(getText().toString());
            this.f58514c = measureText;
            return measureText;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f58519h) {
                int width = getWidth();
                this.f58515d = width;
                if (width > getTextWidth()) {
                    this.f58513b = true;
                    return;
                }
                int scrollX = getScrollX();
                this.f58516e = scrollX;
                this.f58512a = scrollX;
                this.f58519h = false;
            }
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            this.f58513b = true;
            removeCallbacks(this);
            int i5 = this.f58516e;
            this.f58512a = i5;
            scrollTo(i5, 0);
            super.onTextChanged(charSequence, i2, i3, i4);
            this.f58519h = true;
            this.f58513b = false;
            postDelayed(this, 2000L);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f58512a + this.f58517f;
            this.f58512a = i2;
            scrollTo(i2, 0);
            if (this.f58513b) {
                return;
            }
            if (getScrollX() >= this.f58514c - this.f58515d) {
                scrollTo(this.f58516e, 0);
                this.f58512a = this.f58516e;
                postDelayed(this, 2000L);
            } else if (getScrollX() >= (this.f58514c - this.f58515d) - this.f58517f) {
                postDelayed(this, 2000L);
            } else {
                postDelayed(this, this.f58518g);
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58513b = true;
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
        this.f58513b = true;
        this.f58516e = 0;
        this.f58517f = 2;
        this.f58518g = 10;
        this.f58519h = false;
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
        this.f58513b = true;
        this.f58516e = 0;
        this.f58517f = 2;
        this.f58518g = 10;
        this.f58519h = false;
    }
}
