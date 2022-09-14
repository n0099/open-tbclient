package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.sdk.container.widget.BDSplashActionView;
import com.baidu.sdk.container.widget.CircleTextProgressbar;
import com.baidu.sdk.container.widget.DisplayInfoView;
import com.baidu.sdk.container.widget.RectangleCountDownView;
import com.baidu.tieba.bd1;
import com.baidu.tieba.g21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class lf1 implements wf1, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String c0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public int J;
    public JSONObject K;
    public boolean L;
    public boolean M;
    public boolean N;
    public SensorManager O;
    public boolean P;
    public boolean Q;
    public String R;
    public int S;
    public AtomicBoolean T;
    public float U;
    public LottieAnimationView V;
    public BDSplashActionView W;
    public int X;
    public int Y;
    public float Z;
    public Context a;
    public int a0;
    public int b;
    public final Handler b0;
    public ImageView c;
    public ImageView d;
    public AbsCountDownView e;
    public boolean f;
    public boolean g;
    public if1 h;
    public JSONObject i;
    public JSONObject j;
    public AdView k;
    public fg1 l;
    public TextView m;
    public vf1 n;
    public xf1 o;
    public int p;
    public String q;
    public String r;
    public int s;
    public String t;
    public boolean u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a implements bd1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ lf1 c;

        /* renamed from: com.baidu.tieba.lf1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0323a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0323a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.c.L();
                }
            }
        }

        public a(lf1 lf1Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lf1Var;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.tieba.bd1.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.c.V.setVisibility(0);
                        this.c.V.setComposition(lottieComposition);
                        this.c.V.playAnimation();
                        this.c.n(this.c.V, this.a, this.b, "click_float_lottie", this.c.K);
                        this.c.V.setOnClickListener(new View$OnClickListenerC0323a(this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.c.i.put("displayMantle", true);
                    this.c.t();
                }
            }
        }

        @Override // com.baidu.tieba.bd1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                lf1 lf1Var = this.c;
                if (lf1Var.b == 2 || lf1Var.a == null) {
                    return;
                }
                try {
                    lf1Var.i.put("displayMantle", true);
                    this.c.t();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public b(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements bd1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ lf1 b;

        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;
            public float b;
            public final /* synthetic */ d c;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = dVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a = motionEvent.getX();
                        this.b = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float k = g21.c.k(this.c.b.a, motionEvent.getY() - this.b);
                        if (Math.abs(g21.c.k(this.c.b.a, x - this.a)) > this.c.b.S || Math.abs(k) > this.c.b.S) {
                            BaseVM.r("2");
                            this.c.b.L();
                        }
                    } else if (motionEvent.getAction() == 1) {
                        lf1 lf1Var = this.c.b;
                        if (lf1Var.J == 0) {
                            lf1Var.L();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        public d(lf1 lf1Var, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lf1Var;
            this.a = lottieAnimationView;
        }

        @Override // com.baidu.tieba.bd1.f
        @SuppressLint({"ClickableViewAccessibility"})
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    this.a.setVisibility(0);
                    this.a.setComposition(lottieComposition);
                    this.a.playAnimation();
                    this.a.setRepeatCount(-1);
                    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.a != null && (this.a.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                    this.b.k.addView(this.a, layoutParams);
                    this.b.x();
                    if (this.b.L) {
                        this.a.setOnTouchListener(new a(this));
                    }
                } catch (Throwable unused) {
                    this.a.setVisibility(8);
                }
            }
        }

        @Override // com.baidu.tieba.bd1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public e(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public f(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public g(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public h(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements pf1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lf1 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    i iVar = this.a;
                    iVar.c.F(iVar.a, iVar.b);
                }
            }
        }

        public i(lf1 lf1Var, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lf1Var;
            this.a = imageView;
            this.b = str;
        }

        @Override // com.baidu.tieba.pf1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                this.c.M("Fetch Ad icon image load failed.");
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.c.F(this.a, this.b);
                } else {
                    aj0.b(new a(this));
                }
            }
        }

        @Override // com.baidu.tieba.pf1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public j(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.O();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public k(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.O();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public l(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V();
                this.a.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf1 a;

        public m(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf1Var;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g) {
                this.a.z("time_end");
            }
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(lf1 lf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947940850, "Lcom/baidu/tieba/lf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947940850, "Lcom/baidu/tieba/lf1;");
                return;
            }
        }
        c0 = lf1.class.getSimpleName();
    }

    public lf1(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = null;
        this.d = null;
        this.f = false;
        this.p = 4;
        this.q = "";
        this.r = "image";
        this.s = 5000;
        this.t = "";
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.F = 16;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.T = new AtomicBoolean(false);
        this.Z = 1.0f;
        this.b0 = new Handler(Looper.getMainLooper());
        this.a = context.getApplicationContext();
        this.i = jSONObject;
        AdView adView = new AdView(this.a);
        this.k = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.k.setListener(this);
        this.h = new if1(this.a);
        this.l = new fg1(this.a);
        U();
    }

    public abstract void A();

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && hg1.b && this.a != null) {
            TextView textView = new TextView(this.a);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + hg1.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.k.addView(textView, layoutParams);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.x) {
            u();
            this.e.setTimeMillis(this.s);
            this.e.b();
            int i2 = this.p;
            if (i2 == 5) {
                this.e.setVisibility(0);
            } else if (i2 == 1) {
                this.e.setVisibility(0);
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            v();
            t();
            l();
            C();
            r();
            q();
            B();
            s();
            o();
            w();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void F(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, imageView, str) == null) || this.k == null || this.a == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setId(16972527);
        if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
            imageView.setTag("BAIDU_LOGO");
            m(imageView, g21.c.a(this.a, 13.0f), g21.c.a(this.a, 13.0f), "bd_logo");
        } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
            imageView.setTag("AD_LOGO");
            m(imageView, g21.c.a(this.a, 25.0f), g21.c.a(this.a, 13.0f), "ad_logo");
        }
        this.c = (ImageView) this.k.findViewWithTag("BAIDU_LOGO");
        ImageView imageView2 = (ImageView) this.k.findViewWithTag("AD_LOGO");
        this.d = imageView2;
        this.f = false;
        if (this.c == null || imageView2 == null) {
            return;
        }
        imageView2.setOnClickListener(new j(this));
        this.c.setOnClickListener(new k(this));
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.Y;
            if (i2 <= 0) {
                return 2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.X;
            if (i2 <= 0) {
                return 67;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void I(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.T.compareAndSet(false, true)) {
                this.U = f2;
            }
            if (Math.abs(f2 - this.U) * 9.0f > this.S) {
                if (ag0.a) {
                    n11.a().showToast(this.k.getContext(), "摇一摇1.0");
                }
                BaseVM.r("1");
                L();
            }
        }
    }

    public final void J(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sensorEvent) == null) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            if (Math.pow(f2, 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) < Math.pow(this.S, 2.0d)) {
                return;
            }
            if (this.Z * f2 >= 0.0f) {
                this.Z = f2;
                return;
            }
            this.Z = f2;
            int i2 = this.a0 + 1;
            this.a0 = i2;
            if (i2 >= G()) {
                if (ag0.a) {
                    n11.a().showToast(this.k.getContext(), "摇一摇 *3.0*");
                }
                BaseVM.r("7");
                L();
            }
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            AdImageView adImageView = new AdImageView(this.a);
            MaterialLoader.k(this.a).q(adImageView, str, new i(this, adImageView, str));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.P) {
            return;
        }
        vf1 vf1Var = this.n;
        if (vf1Var != null) {
            vf1Var.a();
        }
        Y();
        this.P = true;
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            xf1 xf1Var = this.o;
            if (xf1Var != null) {
                xf1Var.onAdError(str);
            }
            Y();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            xf1 xf1Var = this.o;
            if (xf1Var != null) {
                xf1Var.d();
            }
            BaseVM.q();
        }
    }

    public void O() {
        vf1 vf1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (vf1Var = this.n) == null) {
            return;
        }
        vf1Var.f();
    }

    public void P() {
        xf1 xf1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (xf1Var = this.o) == null) {
            return;
        }
        xf1Var.g();
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            xf1 xf1Var = this.o;
            if (xf1Var != null) {
                xf1Var.h(str);
            }
            Y();
        }
    }

    public void R() {
        vf1 vf1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (vf1Var = this.n) == null) {
            return;
        }
        vf1Var.b();
    }

    public void S() {
        vf1 vf1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (vf1Var = this.n) == null) {
            return;
        }
        vf1Var.c();
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            vf1 vf1Var = this.n;
            if (vf1Var != null) {
                vf1Var.e();
            }
            Y();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            try {
                this.q = this.i.optString("prod");
                this.t = this.i.optString("material_url");
                this.j = this.i.optJSONObject("style");
                this.K = this.i.optJSONObject("inner_style");
                boolean z = true;
                this.g = this.i.optBoolean("countDownNew", true);
                this.z = this.i.optBoolean("Display_Down_Info");
                this.u = this.i.optBoolean("popDialogIfDl", false);
                this.v = this.i.optString("publisher");
                this.w = this.i.optString("app_version");
                this.y = this.i.optBoolean("show_wifi_view", "video".equals(this.r));
                this.x = this.i.optBoolean("show_skip", "rsplash".equals(this.q));
                this.s = this.i.optInt("skipTime", 5000);
                this.A = this.i.optBoolean("hide_ad_logo", true);
                this.B = this.i.optBoolean("hide_bd_logo", false);
                this.C = this.i.optBoolean("full_screen", true);
                this.D = this.i.optBoolean("show_host_small_logo", false);
                this.E = this.i.optInt("skip_btn_type");
                this.p = this.i.optInt("close_type");
                this.F = this.i.optInt("bitmapDisplayMode");
                this.G = this.i.optString("host_big_logo_res_id");
                this.R = this.i.optString("gesture_lottie_url");
                this.M = this.i.optInt("gesture_lottie_type") == 1;
                this.N = this.i.optInt("gesture_lottie_type") == 7;
                this.X = this.i.optInt("shake_update_interval", 0);
                this.Y = this.i.optInt("shake_direction_count", 0);
                boolean z2 = this.i.optInt("gesture_lottie_type") == 2;
                this.L = z2;
                if (!this.M && !this.N && (!z2 || TextUtils.isEmpty(this.R))) {
                    z = false;
                }
                this.Q = z;
                this.S = this.i.optInt("gesture_lottie_sensitivity");
            } catch (Exception unused) {
            }
        }
    }

    public void V() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (absCountDownView = this.e) == null) {
            return;
        }
        absCountDownView.c();
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            aj0.b(new f(this));
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.b = 2;
            aj0.b(new g(this));
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            SensorManager sensorManager = this.O;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.b0.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.baidu.tieba.wf1
    public void a(xf1 xf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, xf1Var) == null) {
            this.o = xf1Var;
        }
    }

    @Override // com.baidu.tieba.wf1
    public void c(vf1 vf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, vf1Var) == null) {
            this.n = vf1Var;
        }
    }

    @Override // com.baidu.tieba.wf1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            int optInt = this.i.optInt("ad_label_width", 25);
            int optInt2 = this.i.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            m(textView, g21.c.a(this.a, optInt), g21.c.a(this.a, optInt2), "label");
        }
    }

    public void k(View view2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, view2, layoutParams) == null) {
            if (this.C) {
                this.k.addView(view2, layoutParams);
                return;
            }
            p();
            layoutParams.addRule(2, 15);
            this.k.addView(view2, layoutParams);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || !this.z || this.u || TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.v)) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        DisplayInfoView.c cVar = new DisplayInfoView.c(this.a);
        cVar.a(this.w, this.v);
        cVar.c(-10066330);
        cVar.b(new h(this));
        DisplayInfoView d2 = cVar.d();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        d2.setGravity(17);
        relativeLayout.addView(d2, layoutParams);
        m(relativeLayout, -1, -2, "download_desc");
    }

    @Override // com.baidu.tieba.wf1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.b = 1;
        }
    }

    public void m(View view2, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            n(view2, i2, i3, str, this.j);
        }
    }

    public void n(View view2, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) || this.k == null || view2 == null || view2.getParent() != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        this.l.g(layoutParams, new gg1().b(jSONObject, str, this.C));
        this.k.addView(view2, layoutParams);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.Q) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
            lottieAnimationView.setFailureListener(new c(this));
            bd1.c().b(this.R, new d(this, lottieAnimationView));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, sensor, i2) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            Y();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, sensorEvent) == null) || sensorEvent == null || sensorEvent.values == null) {
            return;
        }
        if (this.N) {
            J(sensorEvent);
        } else {
            I(sensorEvent);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || TextUtils.isEmpty(this.G)) {
            return;
        }
        int optInt = this.i.optInt("bottom_logo_height", gg1.a);
        if (optInt != gg1.a) {
            gg1.a = optInt;
        }
        try {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, g21.c.a(this.a, optInt));
            layoutParams.addRule(12);
            relativeLayout.setId(15);
            AdImageView adImageView = new AdImageView(this.a);
            adImageView.setImageResource(Integer.parseInt(this.G));
            adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            relativeLayout.setClickable(true);
            relativeLayout.addView(adImageView, layoutParams2);
            this.k.addView(relativeLayout, layoutParams);
        } catch (Throwable unused) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.D) {
            String optString = this.i.optString("host_small_logo_res_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            int optInt = this.i.optInt("small_logo_width", -2);
            int optInt2 = this.i.optInt("small_logo_height", -2);
            try {
                AdImageView adImageView = new AdImageView(this.a);
                adImageView.setImageResource(Integer.parseInt(optString));
                adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                m(adImageView, g21.c.a(this.a, optInt), g21.c.a(this.a, optInt2), "logo");
            } catch (Throwable unused) {
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.A) {
            String optString = this.i.optString("ad_label");
            if (!TextUtils.isEmpty(optString)) {
                j(optString);
            } else {
                K("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
            }
            if (this.B) {
                K("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.H = this.i.optString("lottie_url");
            this.I = this.i.optBoolean("lottie_show");
            int optInt = this.i.optInt("ad_click_opt");
            this.J = optInt;
            if (optInt == 1) {
                A();
            }
            if (TextUtils.isEmpty(this.H) || !this.I) {
                return;
            }
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
            this.V = lottieAnimationView;
            lottieAnimationView.setFailureListener(new n(this));
            JSONObject optJSONObject = this.K.optJSONObject("click_float_lottie");
            double optDouble = optJSONObject != null ? optJSONObject.optDouble("floatW_screenW_ratio", 0.69d) : 0.69d;
            double optDouble2 = optJSONObject != null ? optJSONObject.optDouble("floatH_floatW_ratio", 0.419d) : 0.419d;
            int e2 = (int) (g21.c.e(this.a) * optDouble);
            bd1.c().b(this.H, new a(this, e2, (int) (e2 * optDouble2)));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.i.optBoolean("displayMantle", false)) {
            String optString = this.i.optString("mantleActionText");
            int optInt = this.i.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.C);
            aVar.n(new b(this));
            BDSplashActionView k2 = aVar.k(this.a);
            this.W = k2;
            k2.a(this.k);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            try {
                if (this.E == 1) {
                    this.e = new RectangleCountDownView(this.a);
                } else {
                    this.e = new CircleTextProgressbar(this.a);
                }
                this.e.setVisibility(4);
                this.e.setOnClickListener(new l(this));
                this.e.setCountdownProgressListener(new m(this));
                m(this.e, g21.c.a(this.a, this.i.optInt("skip_btn_width", 40)), g21.c.a(this.a, this.i.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.y) {
            TextView textView = new TextView(this.a);
            this.m = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.m.setTextColor(Color.parseColor("#999999"));
            this.m.setTextSize(0, g21.c.a(this.a, 11.0f));
            m(this.m, -2, -2, "wifi_tip");
        }
    }

    public void w() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.M || this.N) {
                if (this.O == null) {
                    try {
                        this.O = (SensorManager) this.a.getSystemService("sensor");
                    } catch (Exception unused) {
                        return;
                    }
                }
                SensorManager sensorManager = this.O;
                if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(1)) != null) {
                    this.O.registerListener(this, defaultSensor, y());
                }
                this.b0.postDelayed(new e(this), 5000L);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            LottieAnimationView lottieAnimationView = this.V;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.W;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            int H = H();
            if (H < 0 || H >= 20) {
                if (H < 20 || H >= 67) {
                    return ((H < 67 || H >= 200) && H >= 200) ? 3 : 2;
                }
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            Q(str);
        }
    }
}
