package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ol6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public b e;
    public Handler.Callback f;
    public Handler g;

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, int i2);

        void b(int i, int i2);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol6 a;

        public a(ol6 ol6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol6Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.arg1;
                int i2 = message.arg2;
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                return false;
                            }
                            this.a.e.c(i, i2);
                            return true;
                        }
                        this.a.e.d(i, i2);
                        return true;
                    }
                    this.a.e.b(i, i2);
                    return true;
                }
                this.a.e.a(i, i2);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public ol6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new Handler(this.f);
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.g.removeMessages(2);
            if (!this.g.hasMessages(2)) {
                Message message = new Message();
                message.what = 2;
                message.arg1 = i;
                message.arg2 = i2;
                this.g.sendMessageDelayed(message, 60L);
            }
        }
    }

    public final void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.g.removeMessages(0);
            if (!this.g.hasMessages(1)) {
                Message message = new Message();
                message.what = 1;
                message.arg1 = i;
                message.arg2 = i2;
                this.g.sendMessageDelayed(message, 60L);
            }
        }
    }

    public final void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.g.removeMessages(3);
            if (!this.g.hasMessages(3)) {
                Message message = new Message();
                message.what = 3;
                message.arg1 = i;
                message.arg2 = i2;
                this.g.sendMessageDelayed(message, 60L);
            }
        }
    }

    public final void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.g.removeMessages(1);
            if (!this.g.hasMessages(0)) {
                Message message = new Message();
                message.what = 0;
                message.arg1 = i;
                message.arg2 = i2;
                this.g.sendMessageDelayed(message, 60L);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 != 3) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (this.c == 0.0f || this.d == 0.0f) {
                            this.c = motionEvent.getRawX();
                            float rawY2 = motionEvent.getRawY();
                            this.d = rawY2;
                            this.a = this.c;
                            this.b = rawY2;
                        }
                        int i = (int) (rawY - this.b);
                        int i2 = (int) (rawY - this.d);
                        if (this.e != null) {
                            if (i > 0) {
                                e(i2, i);
                            } else {
                                g(i2, i);
                            }
                        }
                        this.a = rawX;
                        this.b = rawY;
                    }
                }
                if (this.e != null) {
                    int i3 = (int) (this.a - this.c);
                    int i4 = (int) (this.b - this.d);
                    if (Math.abs(i3) >= Math.abs(i4)) {
                        f(i3, (int) this.c);
                    } else {
                        b(i3, i4);
                    }
                }
                this.c = 0.0f;
                this.d = 0.0f;
            } else {
                this.c = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                this.d = rawY3;
                this.a = this.c;
                this.b = rawY3;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
