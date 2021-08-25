package com.bytedance.sdk.component.image.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IImageHandler;
import com.bytedance.sdk.component.image.IImageLoader;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.IStepTracker;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.component.image.ImageThread;
import com.bytedance.sdk.component.image.ResultType;
import com.bytedance.sdk.component.image.b.e;
import com.bytedance.sdk.component.image.d.g;
import com.bytedance.sdk.component.image.d.h;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes9.dex */
public class a implements IImageHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Future<?> f64938a;

    /* renamed from: b  reason: collision with root package name */
    public String f64939b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.image.c.a.b f64940c;

    /* renamed from: d  reason: collision with root package name */
    public String f64941d;

    /* renamed from: e  reason: collision with root package name */
    public String f64942e;

    /* renamed from: f  reason: collision with root package name */
    public ILoaderListener f64943f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f64944g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap.Config f64945h;

    /* renamed from: i  reason: collision with root package name */
    public int f64946i;

    /* renamed from: j  reason: collision with root package name */
    public int f64947j;
    public ResultType k;
    public WeakReference<ImageView> l;
    public volatile boolean m;
    public boolean n;
    public boolean o;
    public IStepTracker p;
    public ImageThread q;
    public Queue<h> r;
    public final Handler s;
    public boolean t;
    public e u;

    /* renamed from: com.bytedance.sdk.component.image.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1888a implements ILoaderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64949a;

        /* renamed from: b  reason: collision with root package name */
        public ILoaderListener f64950b;

        public C1888a(a aVar, ILoaderListener iLoaderListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iLoaderListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64949a = aVar;
            this.f64950b = iLoaderListener;
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onFailed(int i2, String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, th) == null) {
                if (this.f64949a.q == ImageThread.MAIN) {
                    this.f64949a.s.post(new Runnable(this, i2, str, th) { // from class: com.bytedance.sdk.component.image.c.a.a.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f64956a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f64957b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Throwable f64958c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ C1888a f64959d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i2), str, th};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64959d = this;
                            this.f64956a = i2;
                            this.f64957b = str;
                            this.f64958c = th;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f64959d.f64950b == null) {
                                return;
                            }
                            this.f64959d.f64950b.onFailed(this.f64956a, this.f64957b, this.f64958c);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f64950b;
                if (iLoaderListener != null) {
                    iLoaderListener.onFailed(i2, str, th);
                }
            }
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onSuccess(ImageResponse imageResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                ImageView imageView = (ImageView) this.f64949a.l.get();
                if (imageView != null && this.f64949a.k == ResultType.BITMAP && a(imageView)) {
                    this.f64949a.s.post(new Runnable(this, imageView, (Bitmap) imageResponse.getResult()) { // from class: com.bytedance.sdk.component.image.c.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageView f64951a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f64952b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ C1888a f64953c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, imageView, r8};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64953c = this;
                            this.f64951a = imageView;
                            this.f64952b = r8;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f64951a.setImageBitmap(this.f64952b);
                            }
                        }
                    });
                }
                if (this.f64949a.q == ImageThread.MAIN) {
                    this.f64949a.s.post(new Runnable(this, imageResponse) { // from class: com.bytedance.sdk.component.image.c.a.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageResponse f64954a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ C1888a f64955b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, imageResponse};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64955b = this;
                            this.f64954a = imageResponse;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f64955b.f64950b == null) {
                                return;
                            }
                            this.f64955b.f64950b.onSuccess(this.f64954a);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f64950b;
                if (iLoaderListener != null) {
                    iLoaderListener.onSuccess(imageResponse);
                }
            }
        }

        private boolean a(ImageView imageView) {
            InterceptResult invokeL;
            Object tag;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imageView)) == null) ? (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f64949a.f64941d)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements IImageLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILoaderListener f65000a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f65001b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.image.c.a.b f65002c;

        /* renamed from: d  reason: collision with root package name */
        public String f65003d;

        /* renamed from: e  reason: collision with root package name */
        public String f65004e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView.ScaleType f65005f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap.Config f65006g;

        /* renamed from: h  reason: collision with root package name */
        public int f65007h;

        /* renamed from: i  reason: collision with root package name */
        public int f65008i;

        /* renamed from: j  reason: collision with root package name */
        public ResultType f65009j;
        public ImageThread k;
        public IStepTracker l;
        public boolean m;
        public boolean n;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader cache(boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.f65002c = new com.bytedance.sdk.component.image.c.a.b(z, z2);
                return this;
            }
            return (IImageLoader) invokeCommon.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader config(Bitmap.Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config)) == null) {
                this.f65006g = config;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader from(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f65004e = str;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader headers(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.m = z;
                return this;
            }
            return (IImageLoader) invokeZ.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader height(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f65008i = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader key(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f65003d = str;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader requestTime(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.n = z;
                return this;
            }
            return (IImageLoader) invokeZ.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader scaleType(ImageView.ScaleType scaleType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scaleType)) == null) {
                this.f65005f = scaleType;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ILoaderListener iLoaderListener, ImageThread imageThread) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, iLoaderListener, imageThread)) == null) {
                this.k = imageThread;
                return to(iLoaderListener);
            }
            return (IImageHandler) invokeLL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader track(IStepTracker iStepTracker) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iStepTracker)) == null) {
                this.l = iStepTracker;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader type(ResultType resultType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, resultType)) == null) {
                this.f65009j = resultType;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.f65007h = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader cache(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f65002c = new com.bytedance.sdk.component.image.c.a.b(z, true);
                return this;
            }
            return (IImageLoader) invokeZ.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ILoaderListener iLoaderListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iLoaderListener)) == null) {
                this.f65000a = iLoaderListener;
                return new a(this).o();
            }
            return (IImageHandler) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imageView)) == null) {
                this.f65001b = imageView;
                return new a(this).o();
            }
            return (IImageHandler) invokeL.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IImageHandler o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            try {
                ExecutorService g2 = com.bytedance.sdk.component.image.c.b.a().g();
                if (g2 != null) {
                    this.f64938a = g2.submit(new Runnable(this) { // from class: com.bytedance.sdk.component.image.c.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f64948a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64948a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            h hVar;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                while (!this.f64948a.m && (hVar = (h) this.f64948a.r.poll()) != null) {
                                    try {
                                        if (this.f64948a.p != null) {
                                            this.f64948a.p.onStepStart(hVar.a(), this.f64948a);
                                        }
                                        hVar.a(this.f64948a);
                                        if (this.f64948a.p != null) {
                                            this.f64948a.p.onStepEnd(hVar.a(), this.f64948a);
                                        }
                                    } catch (Throwable th) {
                                        this.f64948a.a(2000, th.getMessage(), th);
                                        if (this.f64948a.p != null) {
                                            this.f64948a.p.onStepEnd("exception", this.f64948a);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.f64948a.m) {
                                    this.f64948a.a(1003, "canceled", null);
                                }
                            }
                        }
                    });
                }
            } catch (Exception e2) {
                e2.getMessage();
                c.b(e2.getMessage());
            }
            return this;
        }
        return (IImageHandler) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.image.IImageHandler
    public boolean cancelRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.m = true;
            Future<?> future = this.f64938a;
            if (future != null) {
                return future.cancel(true);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ResultType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (ResultType) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.u : (e) invokeV.objValue;
    }

    public a(b bVar) {
        com.bytedance.sdk.component.image.c.a.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new LinkedBlockingQueue();
        this.s = new Handler(Looper.getMainLooper());
        this.t = true;
        this.f64939b = bVar.f65004e;
        this.f64943f = new C1888a(this, bVar.f65000a);
        this.l = new WeakReference<>(bVar.f65001b);
        if (bVar.f65002c != null) {
            bVar2 = bVar.f65002c;
        } else {
            bVar2 = com.bytedance.sdk.component.image.c.a.b.a();
        }
        this.f64940c = bVar2;
        this.f64944g = bVar.f65005f;
        this.f64945h = bVar.f65006g;
        this.f64946i = bVar.f65007h;
        this.f64947j = bVar.f65008i;
        this.k = bVar.f65009j == null ? ResultType.BITMAP : bVar.f65009j;
        this.q = bVar.k == null ? ImageThread.MAIN : bVar.k;
        this.p = bVar.l;
        if (!TextUtils.isEmpty(bVar.f65003d)) {
            b(bVar.f65003d);
            a(bVar.f65003d);
        }
        this.n = bVar.m;
        this.o = bVar.n;
        this.r.add(new com.bytedance.sdk.component.image.d.b());
    }

    public com.bytedance.sdk.component.image.c.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64940c : (com.bytedance.sdk.component.image.c.a.b) invokeV.objValue;
    }

    public ILoaderListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f64943f : (ILoaderListener) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64942e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64941d : (String) invokeV.objValue;
    }

    public ImageView.ScaleType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f64944g : (ImageView.ScaleType) invokeV.objValue;
    }

    public Bitmap.Config g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64945h : (Bitmap.Config) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f64946i : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f64947j : invokeV.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64939b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            WeakReference<ImageView> weakReference = this.l;
            if (weakReference != null && weakReference.get() != null) {
                this.l.get().setTag(1094453505, str);
            }
            this.f64941d = str;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f64942e = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.t = z;
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public boolean a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) {
            if (this.m) {
                return false;
            }
            return this.r.add(hVar);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, this, i2, str, th) == null) {
            new g(i2, str, th).a(this);
            this.r.clear();
        }
    }
}
