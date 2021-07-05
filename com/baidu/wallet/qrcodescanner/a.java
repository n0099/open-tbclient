package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f27135a;

    /* renamed from: b  reason: collision with root package name */
    public int f27136b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0295a f27137c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0295a {
        void a();

        void a(boolean z);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27136b = 0;
    }

    private float a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, motionEvent)) == null) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    private void b() {
        InterfaceC0295a interfaceC0295a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (interfaceC0295a = this.f27137c) == null) {
            return;
        }
        interfaceC0295a.a(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            InterfaceC0295a interfaceC0295a = this.f27137c;
            if (interfaceC0295a != null) {
                interfaceC0295a.a();
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f27136b = 1;
            } else if (action == 1) {
                this.f27136b = 0;
            } else if (action != 2) {
                if (action == 5) {
                    this.f27135a = a(motionEvent);
                    this.f27136b++;
                } else if (action == 6) {
                    this.f27136b--;
                }
            } else if (this.f27136b >= 2) {
                float a2 = a(motionEvent);
                if (a2 > this.f27135a) {
                    a();
                }
                if (a2 < this.f27135a) {
                    b();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void a() {
        InterfaceC0295a interfaceC0295a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (interfaceC0295a = this.f27137c) == null) {
            return;
        }
        interfaceC0295a.a(true);
    }

    public void a(InterfaceC0295a interfaceC0295a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0295a) == null) {
            this.f27137c = interfaceC0295a;
        }
    }
}
