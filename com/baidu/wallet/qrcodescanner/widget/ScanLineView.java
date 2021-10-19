package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
/* loaded from: classes8.dex */
public class ScanLineView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static float f64026d = 50.0f;

    /* renamed from: e  reason: collision with root package name */
    public static int f64027e = 1800;

    /* renamed from: f  reason: collision with root package name */
    public static float f64028f = 50.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f64029a;

    /* renamed from: b  reason: collision with root package name */
    public a f64030b;

    /* renamed from: c  reason: collision with root package name */
    public int f64031c;

    /* renamed from: g  reason: collision with root package name */
    public int f64032g;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64033a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ScanLineView f64034b;

        public a(ScanLineView scanLineView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scanLineView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64034b = scanLineView;
            this.f64033a = true;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int left = this.f64034b.f64029a.getLeft();
                int top = this.f64034b.f64029a.getTop();
                int right = this.f64034b.f64029a.getRight();
                int bottom = this.f64034b.f64029a.getBottom();
                this.f64034b.f64029a.getWidth();
                this.f64034b.f64029a.getHeight();
                if (this.f64033a) {
                    this.f64034b.f64029a.setBackgroundResource(ResUtils.drawable(this.f64034b.getContext(), "wallet_qrscanner_line_down"));
                    i2 = top + this.f64034b.f64031c;
                    i3 = bottom + this.f64034b.f64031c;
                } else {
                    this.f64034b.f64029a.setBackgroundResource(ResUtils.drawable(this.f64034b.getContext(), "wallet_qrscanner_line_up"));
                    i2 = top - this.f64034b.f64031c;
                    i3 = bottom - this.f64034b.f64031c;
                }
                int i4 = 0;
                if (i3 < 0) {
                    i2 = -this.f64034b.f64029a.getHeight();
                    this.f64033a = true;
                    i3 = 0;
                }
                if (i2 > this.f64034b.getHeight()) {
                    i2 = -this.f64034b.f64029a.getHeight();
                    this.f64033a = true;
                } else {
                    i4 = i3;
                }
                this.f64034b.f64029a.layout(left, i2, right, i4);
                removeCallbacksAndMessages(null);
                sendEmptyMessageDelayed(1, this.f64034b.f64032g);
                super.dispatchMessage(message);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2008779647, "Lcom/baidu/wallet/qrcodescanner/widget/ScanLineView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2008779647, "Lcom/baidu/wallet/qrcodescanner/widget/ScanLineView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f64031c = 1;
        this.f64032g = (int) (f64027e / f64028f);
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            Rect rect = new Rect();
            rect.left = i2;
            rect.top = i3;
            rect.right = i4;
            rect.bottom = i5;
            if (getContext() instanceof QRScanCodeActivity) {
                ((QRScanCodeActivity) getContext()).relayoutUi(rect);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f64031c = (int) ((getMeasuredHeight() + DisplayUtils.dip2px(getContext(), 100.0f)) / f64026d);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f64030b == null) {
                this.f64030b = new a(this);
            }
            this.f64030b.removeCallbacksAndMessages(null);
            this.f64030b.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f64030b == null) {
                this.f64030b = new a(this);
            }
            this.f64030b.removeCallbacksAndMessages(null);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f64029a = imageView;
            imageView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_line_down"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 100.0f));
            layoutParams.topMargin = -DisplayUtils.dip2px(getContext(), 100.0f);
            addView(this.f64029a, layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanLineView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64031c = 1;
        this.f64032g = (int) (f64027e / f64028f);
        a();
    }
}
