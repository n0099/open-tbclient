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
/* loaded from: classes9.dex */
public class CountDownTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54324e;

    /* renamed from: f  reason: collision with root package name */
    public String f54325f;

    /* renamed from: g  reason: collision with root package name */
    public c f54326g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f54327h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f54328i;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f54329e;

        public /* synthetic */ b(CountDownTextView countDownTextView, a aVar) {
            this(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (countDownTextView = this.f54329e.get()) == null) {
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
            this.f54329e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes9.dex */
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
        this.f54324e = 0;
        this.f54325f = "";
        this.f54326g = null;
        this.f54327h = new Handler();
        this.f54328i = new b(this, null);
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = this.f54324e - i2;
            this.f54324e = i3;
            if (i3 == 0) {
                c cVar = this.f54326g;
                if (cVar != null) {
                    cVar.onTimeout(this);
                }
                this.f54327h.removeCallbacksAndMessages(null);
                return;
            }
            if (i3 > 0) {
                setText(String.format("%s %s", this.f54325f, Integer.valueOf(i3)));
            }
            this.f54327h.removeCallbacks(this.f54328i);
            this.f54327h.postDelayed(this.f54328i, 1000L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f54327h.removeCallbacksAndMessages(null);
        }
    }

    public void init(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f54325f = str;
            if (i2 > 0) {
                this.f54324e = i2;
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
            this.f54326g = cVar;
        }
    }
}
