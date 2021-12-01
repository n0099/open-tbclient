package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public int f54174b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1942a f54175c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC1942a {
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
        this.f54174b = 0;
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
        InterfaceC1942a interfaceC1942a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (interfaceC1942a = this.f54175c) == null) {
            return;
        }
        interfaceC1942a.a(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            InterfaceC1942a interfaceC1942a = this.f54175c;
            if (interfaceC1942a != null) {
                interfaceC1942a.a();
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f54174b = 1;
            } else if (action == 1) {
                this.f54174b = 0;
            } else if (action != 2) {
                if (action == 5) {
                    this.a = a(motionEvent);
                    this.f54174b++;
                } else if (action == 6) {
                    this.f54174b--;
                }
            } else if (this.f54174b >= 2) {
                float a = a(motionEvent);
                if (a > this.a) {
                    a();
                }
                if (a < this.a) {
                    b();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void a() {
        InterfaceC1942a interfaceC1942a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (interfaceC1942a = this.f54175c) == null) {
            return;
        }
        interfaceC1942a.a(true);
    }

    public void a(InterfaceC1942a interfaceC1942a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1942a) == null) {
            this.f54175c = interfaceC1942a;
        }
    }
}
