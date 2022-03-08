package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes6.dex */
public class BDResultStepsView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FAIL_2_STATE = 6;
    public static final int FAIL_3_STATE = 4;
    public static final int INIT_STATE = 0;
    public static final int MIDDLE_2_STATE = 5;
    public static final int NODE3_SUCCESS1_STATE = 17;
    public static final int NODE3_SUCCESS3_STATE = 18;
    public static final int SUCCESS_2_STATE = 2;
    public static final int SUCCESS_3_STATE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49164b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f49165c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49166d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f49167e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f49168f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f49169g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49170h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49171i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49172j;
    public TextView k;
    public LinearLayout mRootLayout;
    public ImageView mStep1Image;
    public ImageView mStep2Image;
    public ImageView mStep3Image;
    public int state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDResultStepsView(Context context) {
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
        this.state = 0;
        Context applicationContext = context.getApplicationContext();
        this.f49164b = applicationContext;
        this.a = LayoutInflater.from(applicationContext);
        a();
    }

    private void a(Canvas canvas, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, canvas, str) == null) {
            a(this.mStep1Image.getWidth() + a(this.mStep1Image), b(this.mStep1Image) + (this.mStep1Image.getHeight() / 2), a(this.mStep2Image), b(this.mStep2Image) + (this.mStep2Image.getHeight() / 2), canvas, str);
        }
    }

    private void b(Canvas canvas, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, canvas, str) == null) {
            a(this.mStep2Image.getWidth() + a(this.mStep2Image), b(this.mStep2Image) + (this.mStep2Image.getHeight() / 2), a(this.mStep3Image), b(this.mStep3Image) + (this.mStep3Image.getHeight() / 2), canvas, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    public void dispatchDraw(Canvas canvas) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            int right = (((this.mRootLayout.getRight() - this.mRootLayout.getLeft()) / 2) - (this.mStep2Image.getWidth() / 2)) + this.mRootLayout.getLeft();
            int i2 = this.state;
            if (i2 == 0) {
                if (this.mStep1Image == null || this.mStep2Image == null || this.mStep3Image == null) {
                    return;
                }
                a(imageView.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "dxm_wallet_base_mainColor1");
                a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "dxm_wallet_base_separate2Color1");
            } else if (i2 == 2) {
                a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "dxm_wallet_base_mainColor1");
            } else if (i2 == 3) {
                a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "dxm_wallet_base_mainColor1");
                a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "dxm_wallet_base_mainColor1");
            } else if (i2 == 4) {
                a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), right, this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), canvas, "dxm_wallet_base_mainColor1");
                a(right + this.mStep2Image.getWidth(), this.mStep2Image.getTop() + (this.mStep2Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "dxm_wallet_base_separate2Color1");
            } else if (i2 == 5) {
                int left = this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft();
                int top = this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2);
                int right2 = this.mRootLayout.getRight() - this.mStep3Image.getWidth();
                float f2 = left;
                float f3 = top;
                float f4 = left + ((right2 - left) / 2);
                float height = this.mStep3Image.getHeight() / 2;
                a(f2, f3, f4, height, canvas, "dxm_wallet_base_separate2Color1");
                a(f4, f3, right2, height, canvas, "dxm_wallet_base_separate2Color1");
            } else if (i2 == 6) {
                a(this.mStep1Image.getLeft() + this.mStep1Image.getWidth() + this.mRootLayout.getLeft(), this.mStep1Image.getTop() + (this.mStep1Image.getHeight() / 2), this.mRootLayout.getRight() - this.mStep3Image.getWidth(), this.mStep3Image.getHeight() / 2, canvas, "dxm_wallet_base_separate2Color1");
            } else if (i2 == 17) {
                this.mStep2Image.setImageResource(ResUtils.drawable(this.f49164b, "dxm_wallet_base_result_time_axis_wait"));
                a(canvas, "dxm_wallet_base_separate2Color1");
                b(canvas, "dxm_wallet_base_separate2Color1");
            } else if (i2 != 18) {
            } else {
                this.mStep3Image.setImageResource(ResUtils.drawable(this.f49164b, "dxm_wallet_base_result_time_axis_check_1"));
                a(canvas, "dxm_wallet_base_mainColor1");
                b(canvas, "dxm_wallet_base_mainColor1");
            }
        }
    }

    public LinearLayout getmStep2Layout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49168f : (LinearLayout) invokeV.objValue;
    }

    public TextView getmTips1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49165c : (TextView) invokeV.objValue;
    }

    public TextView getmTips2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49166d : (TextView) invokeV.objValue;
    }

    public TextView getmTips3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49170h : (TextView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            super.onAttachedToWindow();
            ImageView imageView = this.mStep1Image;
            if (imageView == null || this.mStep2Image == null || this.mStep3Image == null) {
                return;
            }
            imageView.getLocationOnScreen(iArr);
            this.mStep2Image.getLocationOnScreen(iArr2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"NewApi"})
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
        }
    }

    public void setStepTips(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            TextView textView = this.f49165c;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.f49166d;
            if (textView2 != null) {
                textView2.setText(str2);
            }
            TextView textView3 = this.f49170h;
            if (textView3 != null) {
                textView3.setText(str3);
            }
        }
    }

    public void setStepTipsTime(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            TextView textView = this.f49171i;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.f49172j;
            if (textView2 != null) {
                textView2.setText(str2);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                textView3.setText(str3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDResultStepsView(Context context, AttributeSet attributeSet) {
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
        this.state = 0;
        Context applicationContext = context.getApplicationContext();
        this.f49164b = applicationContext;
        this.a = LayoutInflater.from(applicationContext);
        a();
    }

    private int a(View view) {
        InterceptResult invokeL;
        int left;
        int left2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            if (view == null) {
                return 0;
            }
            ImageView imageView = this.mStep1Image;
            if (view == imageView) {
                left = imageView.getLeft() + this.f49167e.getLeft();
                left2 = this.mRootLayout.getLeft();
            } else {
                ImageView imageView2 = this.mStep2Image;
                if (view == imageView2) {
                    left = imageView2.getLeft() + this.f49168f.getLeft();
                    left2 = this.mRootLayout.getLeft();
                } else {
                    ImageView imageView3 = this.mStep3Image;
                    if (view != imageView3) {
                        return 0;
                    }
                    left = imageView3.getLeft() + this.f49169g.getLeft();
                    left2 = this.mRootLayout.getLeft();
                }
            }
            return left2 + left;
        }
        return invokeL.intValue;
    }

    private int b(View view) {
        InterceptResult invokeL;
        int top;
        int top2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, view)) == null) {
            if (view == null) {
                return 0;
            }
            ImageView imageView = this.mStep1Image;
            if (view == imageView) {
                top = imageView.getTop() + this.f49167e.getTop();
                top2 = this.mRootLayout.getTop();
            } else {
                ImageView imageView2 = this.mStep2Image;
                if (view == imageView2) {
                    top = imageView2.getTop() + this.f49168f.getTop();
                    top2 = this.mRootLayout.getTop();
                } else {
                    ImageView imageView3 = this.mStep3Image;
                    if (view != imageView3) {
                        return 0;
                    }
                    top = imageView3.getTop() + this.f49169g.getTop();
                    top2 = this.mRootLayout.getTop();
                }
            }
            return top2 + top;
        }
        return invokeL.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a.inflate(ResUtils.layout(this.f49164b, "wallet_base_result_step_layout"), this);
            this.mRootLayout = (LinearLayout) findViewById(ResUtils.id(this.f49164b, "root_layout"));
            this.mStep1Image = (ImageView) findViewById(ResUtils.id(this.f49164b, "step_image_1"));
            this.mStep2Image = (ImageView) findViewById(ResUtils.id(this.f49164b, "step_image_2"));
            this.mStep3Image = (ImageView) findViewById(ResUtils.id(this.f49164b, "step_image_3"));
            this.f49165c = (TextView) findViewById(ResUtils.id(this.f49164b, "step1_tips"));
            this.f49166d = (TextView) findViewById(ResUtils.id(this.f49164b, "step2_tips"));
            this.f49170h = (TextView) findViewById(ResUtils.id(this.f49164b, "step3_tips"));
            this.f49171i = (TextView) findViewById(ResUtils.id(this.f49164b, "step1_tips_time"));
            this.f49172j = (TextView) findViewById(ResUtils.id(this.f49164b, "step2_tips_time"));
            this.k = (TextView) findViewById(ResUtils.id(this.f49164b, "step3_tips_time"));
            this.f49168f = (LinearLayout) findViewById(ResUtils.id(this.f49164b, "step_2_layout"));
            this.f49167e = (LinearLayout) findViewById(ResUtils.id(this.f49164b, "step_1_layout"));
            this.f49169g = (LinearLayout) findViewById(ResUtils.id(this.f49164b, "step_3_layout"));
        }
    }

    private void a(float f2, float f3, float f4, float f5, Canvas canvas, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), canvas, str}) == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(2.0f);
            paint.setColor(getContext().getResources().getColor(ResUtils.color(getContext(), str)));
            if (canvas == null) {
                return;
            }
            canvas.drawLine(f2, f3, f4, f5, paint);
        }
    }
}
