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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageProblemItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18032e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18033f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18034g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18035h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f18036i;
    public LinearLayout j;
    public TextView k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
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
        this.f18032e = context;
        a();
        b(attributeSet);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f18032e).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
            this.f18033f = (LinearLayout) findViewById(R.id.container);
            this.f18034g = (TextView) findViewById(R.id.text);
            this.f18035h = (TextView) findViewById(R.id.tip);
            this.f18036i = (ImageView) findViewById(R.id.arrow2);
            this.j = (LinearLayout) findViewById(R.id.ll_container);
            this.k = (TextView) findViewById(R.id.tv_help);
        }
    }

    public void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f18032e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
            String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
            int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
            if (string != null) {
                this.f18034g.setText(string);
            }
            if (color > -1) {
                this.f18034g.setTextColor(color);
            }
            if (string2 != null) {
                this.f18035h.setText(string2);
            }
            if (color2 > -1) {
                this.f18035h.setTextColor(color2);
            }
            obtainStyledAttributes.recycle();
            this.f18033f.setClickable(false);
            this.f18033f.setFocusable(false);
            this.f18036i.setVisibility(4);
        }
    }

    public void displayArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18036i.setVisibility(0);
        }
    }

    public void displayTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (textView = this.f18035h) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18035h.getText() : (CharSequence) invokeV.objValue;
    }

    public void hideArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18036i.setVisibility(8);
        }
    }

    public void hideTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.f18035h) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void setArrowImg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f18036i.setImageResource(i2);
        }
    }

    public void setHelpText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
                this.j.setLayoutParams(layoutParams);
                this.k.setText("");
                this.k.setVisibility(8);
                return;
            }
            this.j.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
            this.j.setLayoutParams(layoutParams2);
            this.k.setText(str);
            this.k.setVisibility(0);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                this.f18034g.setTextColor(getResources().getColor(R.color.CAM_X0105));
            } else if (i2 == 2) {
                this.f18034g.setTextColor(getResources().getColor(R.color.CAM_X0305));
            } else if (i2 == 3) {
                this.f18034g.setTextColor(getResources().getColor(R.color.CAM_X0110));
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f18034g.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f18035h.setText(str);
        }
    }

    public void setTipBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.f18035h.setBackgroundDrawable(drawable);
        }
    }

    public void setTipColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.f18035h) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f18034g.setText(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18032e = context;
        a();
    }
}
