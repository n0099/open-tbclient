package com.baidu.tieba.imageProblem.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ImageProblemItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f34123b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34124c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34125d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f34126e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f34127f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34128g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
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
        a();
        b(attributeSet);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d6, (ViewGroup) this, true);
            this.f34123b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.f34124c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.f34125d = (TextView) findViewById(R.id.obfuscated_res_0x7f092002);
            this.f34126e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902a4);
            this.f34127f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912ec);
            this.f34128g = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c1);
        }
    }

    public void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040543, R.attr.obfuscated_res_0x7f040544, R.attr.obfuscated_res_0x7f040545, R.attr.obfuscated_res_0x7f040546, R.attr.obfuscated_res_0x7f040547, R.attr.obfuscated_res_0x7f040548});
            String string = obtainStyledAttributes.getString(1);
            int color = obtainStyledAttributes.getColor(2, -1);
            String string2 = obtainStyledAttributes.getString(4);
            int color2 = obtainStyledAttributes.getColor(5, -1);
            if (string != null) {
                this.f34124c.setText(string);
            }
            if (color > -1) {
                this.f34124c.setTextColor(color);
            }
            if (string2 != null) {
                this.f34125d.setText(string2);
            }
            if (color2 > -1) {
                this.f34125d.setTextColor(color2);
            }
            obtainStyledAttributes.recycle();
            this.f34123b.setClickable(false);
            this.f34123b.setFocusable(false);
            this.f34126e.setVisibility(4);
        }
    }

    public void displayArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f34126e.setVisibility(0);
        }
    }

    public void displayTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (textView = this.f34125d) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34125d.getText() : (CharSequence) invokeV.objValue;
    }

    public void hideArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f34126e.setVisibility(8);
        }
    }

    public void hideTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.f34125d) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void setArrowImg(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f34126e.setImageResource(i);
        }
    }

    public void setHelpText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34127f.getLayoutParams();
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f0);
                this.f34127f.setLayoutParams(layoutParams);
                this.f34128g.setText("");
                this.f34128g.setVisibility(8);
                return;
            }
            this.f34127f.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f34127f.getLayoutParams();
            layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070229);
            this.f34127f.setLayoutParams(layoutParams2);
            this.f34128g.setText(str);
            this.f34128g.setVisibility(0);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 1) {
                this.f34124c.setTextColor(getResources().getColor(R.color.CAM_X0105));
            } else if (i == 2) {
                this.f34124c.setTextColor(getResources().getColor(R.color.CAM_X0305));
            } else if (i == 3) {
                this.f34124c.setTextColor(getResources().getColor(R.color.CAM_X0110));
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f34124c.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f34125d.setText(str);
        }
    }

    public void setTipBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.f34125d.setBackgroundDrawable(drawable);
        }
    }

    public void setTipColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (textView = this.f34125d) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f34124c.setText(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProblemItemView(Context context) {
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
}
