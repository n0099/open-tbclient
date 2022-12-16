package com.bigkoo.svprogresshud.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
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
/* loaded from: classes7.dex */
public class SVProgressDefaultView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SVCircleProgressBar circleProgressBar;
    public ImageView ivBigLoading;
    public ImageView ivSmallLoading;
    public RotateAnimation mRotateAnimation;
    public int resBigLoading;
    public int resError;
    public int resInfo;
    public int resSuccess;
    public TextView tvMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVProgressDefaultView(Context context) {
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
        this.resBigLoading = R.drawable.obfuscated_res_0x7f08067e;
        this.resInfo = R.drawable.obfuscated_res_0x7f08067d;
        this.resSuccess = R.drawable.obfuscated_res_0x7f08067f;
        this.resError = R.drawable.obfuscated_res_0x7f08067c;
        initViews();
        init();
    }

    private void clearAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.ivBigLoading.clearAnimation();
            this.ivSmallLoading.clearAnimation();
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            clearAnimations();
        }
    }

    public SVCircleProgressBar getCircleProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.circleProgressBar;
        }
        return (SVCircleProgressBar) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            this.mRotateAnimation = rotateAnimation;
            rotateAnimation.setDuration(1000L);
            this.mRotateAnimation.setInterpolator(new LinearInterpolator());
            this.mRotateAnimation.setRepeatCount(-1);
            this.mRotateAnimation.setRepeatMode(1);
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            clearAnimations();
            this.ivBigLoading.setImageResource(this.resBigLoading);
            this.ivBigLoading.setVisibility(0);
            this.ivSmallLoading.setVisibility(8);
            this.circleProgressBar.setVisibility(8);
            this.tvMsg.setVisibility(8);
            this.ivBigLoading.startAnimation(this.mRotateAnimation);
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0926, (ViewGroup) this, true);
            this.ivBigLoading = (ImageView) findViewById(R.id.obfuscated_res_0x7f09107c);
            this.ivSmallLoading = (ImageView) findViewById(R.id.obfuscated_res_0x7f09107e);
            this.circleProgressBar = (SVCircleProgressBar) findViewById(R.id.obfuscated_res_0x7f090666);
            this.tvMsg = (TextView) findViewById(R.id.obfuscated_res_0x7f092412);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.tvMsg.setText(str);
        }
    }

    public void showErrorWithStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            showBaseStatus(this.resError, str);
        }
    }

    public void showInfoWithStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            showBaseStatus(this.resInfo, str);
        }
    }

    public void showProgress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            clearAnimations();
            this.tvMsg.setText(str);
            this.ivBigLoading.setVisibility(8);
            this.ivSmallLoading.setVisibility(8);
            this.circleProgressBar.setVisibility(0);
            this.tvMsg.setVisibility(0);
        }
    }

    public void showSuccessWithStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            showBaseStatus(this.resSuccess, str);
        }
    }

    public void showWithProgress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            showProgress(str);
        }
    }

    public void showWithStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (str == null) {
                show();
                return;
            }
            showBaseStatus(this.resBigLoading, str);
            this.ivSmallLoading.startAnimation(this.mRotateAnimation);
        }
    }

    public void showBaseStatus(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            clearAnimations();
            this.ivSmallLoading.setImageResource(i);
            this.tvMsg.setText(str);
            this.ivBigLoading.setVisibility(8);
            this.circleProgressBar.setVisibility(8);
            this.ivSmallLoading.setVisibility(0);
            this.tvMsg.setVisibility(0);
        }
    }
}
