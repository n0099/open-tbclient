package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f60820a;

    /* renamed from: b  reason: collision with root package name */
    public int f60821b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC1829a f60822c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1829a {
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
        this.f60821b = 0;
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
        InterfaceC1829a interfaceC1829a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (interfaceC1829a = this.f60822c) == null) {
            return;
        }
        interfaceC1829a.a(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            InterfaceC1829a interfaceC1829a = this.f60822c;
            if (interfaceC1829a != null) {
                interfaceC1829a.a();
            }
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f60821b = 1;
            } else if (action == 1) {
                this.f60821b = 0;
            } else if (action != 2) {
                if (action == 5) {
                    this.f60820a = a(motionEvent);
                    this.f60821b++;
                } else if (action == 6) {
                    this.f60821b--;
                }
            } else if (this.f60821b >= 2) {
                float a2 = a(motionEvent);
                if (a2 > this.f60820a) {
                    a();
                }
                if (a2 < this.f60820a) {
                    b();
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void a() {
        InterfaceC1829a interfaceC1829a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (interfaceC1829a = this.f60822c) == null) {
            return;
        }
        interfaceC1829a.a(true);
    }

    public void a(InterfaceC1829a interfaceC1829a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1829a) == null) {
            this.f60822c = interfaceC1829a;
        }
    }
}
