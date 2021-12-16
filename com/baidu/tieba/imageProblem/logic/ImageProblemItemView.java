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
/* loaded from: classes12.dex */
public class ImageProblemItemView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMON = 1;
    public static final int DISABLED = 3;
    public static final int ENABLED = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout container;
    public ImageView imageView;
    public LinearLayout ll_container;
    public Context mContext;
    public TextView textView;
    public TextView tipView;
    public TextView tv_help;

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
        this.mContext = context;
        initialieView();
        initializeStyle(attributeSet);
    }

    public void displayArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.imageView.setVisibility(0);
        }
    }

    public void displayTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tipView.getText() : (CharSequence) invokeV.objValue;
    }

    public void hideArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.imageView.setVisibility(8);
        }
    }

    public void hideTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void initialieView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(this.mContext).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
            this.container = (LinearLayout) findViewById(R.id.container);
            this.textView = (TextView) findViewById(R.id.text);
            this.tipView = (TextView) findViewById(R.id.tip);
            this.imageView = (ImageView) findViewById(R.id.arrow2);
            this.ll_container = (LinearLayout) findViewById(R.id.ll_container);
            this.tv_help = (TextView) findViewById(R.id.tv_help);
        }
    }

    public void initializeStyle(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
            String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
            int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
            if (string != null) {
                this.textView.setText(string);
            }
            if (color > -1) {
                this.textView.setTextColor(color);
            }
            if (string2 != null) {
                this.tipView.setText(string2);
            }
            if (color2 > -1) {
                this.tipView.setTextColor(color2);
            }
            obtainStyledAttributes.recycle();
            this.container.setClickable(false);
            this.container.setFocusable(false);
            this.imageView.setVisibility(4);
        }
    }

    public void setArrowImg(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.imageView.setImageResource(i2);
        }
    }

    public void setHelpText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ll_container.getLayoutParams();
                layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
                this.ll_container.setLayoutParams(layoutParams);
                this.tv_help.setText("");
                this.tv_help.setVisibility(8);
                return;
            }
            this.ll_container.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ll_container.getLayoutParams();
            layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
            this.ll_container.setLayoutParams(layoutParams2);
            this.tv_help.setText(str);
            this.tv_help.setVisibility(0);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                this.textView.setTextColor(getResources().getColor(R.color.CAM_X0105));
            } else if (i2 == 2) {
                this.textView.setTextColor(getResources().getColor(R.color.CAM_X0305));
            } else if (i2 == 3) {
                this.textView.setTextColor(getResources().getColor(R.color.CAM_X0110));
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.textView.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.tipView.setText(str);
        }
    }

    public void setTipBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.tipView.setBackgroundDrawable(drawable);
        }
    }

    public void setTipColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.textView.setText(i2);
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
        this.mContext = context;
        initialieView();
    }
}
