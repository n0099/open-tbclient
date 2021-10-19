package com.baidu.tieba.square.view;

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
/* loaded from: classes7.dex */
public class BestStringsFitTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String[] f57059e;

    /* renamed from: f  reason: collision with root package name */
    public String f57060f;

    /* renamed from: g  reason: collision with root package name */
    public float f57061g;

    /* renamed from: h  reason: collision with root package name */
    public String f57062h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57063i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BestStringsFitTextView(Context context) {
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
        this.f57060f = " ";
        this.f57061g = 0.0f;
        this.f57062h = "";
        this.f57063i = false;
    }

    public void buildStringForArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57061g = (getWidth() - getPaddingLeft()) - getPaddingRight();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.f57059e.length; i2++) {
                if (i2 > 0) {
                    sb.append(this.f57060f);
                }
                sb.append(this.f57059e[i2]);
                String sb2 = sb.toString();
                if (this.f57061g < getPaint().measureText(sb2)) {
                    break;
                }
                this.f57063i = true;
                this.f57062h = sb2;
            }
            setText(this.f57062h);
        }
    }

    public String getSeperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57060f : (String) invokeV.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f57059e == null || this.f57063i) {
                return;
            }
            buildStringForArray();
        }
    }

    public void setSeperator(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f57060f = str;
        }
    }

    public void setTextArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            this.f57059e = strArr;
            buildStringForArray();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BestStringsFitTextView(Context context, AttributeSet attributeSet) {
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
        this.f57060f = " ";
        this.f57061g = 0.0f;
        this.f57062h = "";
        this.f57063i = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BestStringsFitTextView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f57060f = " ";
        this.f57061g = 0.0f;
        this.f57062h = "";
        this.f57063i = false;
    }
}
