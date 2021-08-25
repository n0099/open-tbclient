package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f57044e;

    /* renamed from: f  reason: collision with root package name */
    public String f57045f;

    /* renamed from: g  reason: collision with root package name */
    public c f57046g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f57047h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f57048i;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f57049e;

        public /* synthetic */ b(CountDownTextView countDownTextView, a aVar) {
            this(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTextView = this.f57049e.get()) == null) {
                return;
            }
            countDownTextView.b(1);
        }

        public b(CountDownTextView countDownTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57049e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onTimeout(View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTextView(Context context) {
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
        this.f57044e = 0;
        this.f57045f = "";
        this.f57046g = null;
        this.f57047h = new Handler();
        this.f57048i = new b(this, null);
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = this.f57044e - i2;
            this.f57044e = i3;
            if (i3 == 0) {
                c cVar = this.f57046g;
                if (cVar != null) {
                    cVar.onTimeout(this);
                }
                this.f57047h.removeCallbacksAndMessages(null);
                return;
            }
            if (i3 > 0) {
                setText(String.format("%s %s", this.f57045f, Integer.valueOf(i3)));
            }
            this.f57047h.removeCallbacks(this.f57048i);
            this.f57047h.postDelayed(this.f57048i, 1000L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57047h.removeCallbacksAndMessages(null);
        }
    }

    public void init(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f57045f = str;
            if (i2 > 0) {
                this.f57044e = i2;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            b(0);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            c();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 == 0) {
                b(0);
            } else {
                c();
            }
        }
    }

    public void setTimeoutListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f57046g = cVar;
        }
    }
}
