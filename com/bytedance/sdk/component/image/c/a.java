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
    public Future<?> f65118a;

    /* renamed from: b  reason: collision with root package name */
    public String f65119b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.image.c.a.b f65120c;

    /* renamed from: d  reason: collision with root package name */
    public String f65121d;

    /* renamed from: e  reason: collision with root package name */
    public String f65122e;

    /* renamed from: f  reason: collision with root package name */
    public ILoaderListener f65123f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f65124g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap.Config f65125h;

    /* renamed from: i  reason: collision with root package name */
    public int f65126i;

    /* renamed from: j  reason: collision with root package name */
    public int f65127j;
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
        public final /* synthetic */ a f65129a;

        /* renamed from: b  reason: collision with root package name */
        public ILoaderListener f65130b;

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
            this.f65129a = aVar;
            this.f65130b = iLoaderListener;
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onFailed(int i2, String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, th) == null) {
                if (this.f65129a.q == ImageThread.MAIN) {
                    this.f65129a.s.post(new Runnable(this, i2, str, th) { // from class: com.bytedance.sdk.component.image.c.a.a.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f65136a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f65137b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Throwable f65138c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ C1888a f65139d;

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
                            this.f65139d = this;
                            this.f65136a = i2;
                            this.f65137b = str;
                            this.f65138c = th;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65139d.f65130b == null) {
                                return;
                            }
                            this.f65139d.f65130b.onFailed(this.f65136a, this.f65137b, this.f65138c);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f65130b;
                if (iLoaderListener != null) {
                    iLoaderListener.onFailed(i2, str, th);
                }
            }
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onSuccess(ImageResponse imageResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                ImageView imageView = (ImageView) this.f65129a.l.get();
                if (imageView != null && this.f65129a.k == ResultType.BITMAP && a(imageView)) {
                    this.f65129a.s.post(new Runnable(this, imageView, (Bitmap) imageResponse.getResult()) { // from class: com.bytedance.sdk.component.image.c.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageView f65131a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f65132b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ C1888a f65133c;

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
                            this.f65133c = this;
                            this.f65131a = imageView;
                            this.f65132b = r8;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f65131a.setImageBitmap(this.f65132b);
                            }
                        }
                    });
                }
                if (this.f65129a.q == ImageThread.MAIN) {
                    this.f65129a.s.post(new Runnable(this, imageResponse) { // from class: com.bytedance.sdk.component.image.c.a.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageResponse f65134a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ C1888a f65135b;

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
                            this.f65135b = this;
                            this.f65134a = imageResponse;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65135b.f65130b == null) {
                                return;
                            }
                            this.f65135b.f65130b.onSuccess(this.f65134a);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f65130b;
                if (iLoaderListener != null) {
                    iLoaderListener.onSuccess(imageResponse);
                }
            }
        }

        private boolean a(ImageView imageView) {
            InterceptResult invokeL;
            Object tag;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imageView)) == null) ? (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f65129a.f65121d)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements IImageLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILoaderListener f65180a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f65181b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.image.c.a.b f65182c;

        /* renamed from: d  reason: collision with root package name */
        public String f65183d;

        /* renamed from: e  reason: collision with root package name */
        public String f65184e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView.ScaleType f65185f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap.Config f65186g;

        /* renamed from: h  reason: collision with root package name */
        public int f65187h;

        /* renamed from: i  reason: collision with root package name */
        public int f65188i;

        /* renamed from: j  reason: collision with root package name */
        public ResultType f65189j;
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
                this.f65182c = new com.bytedance.sdk.component.image.c.a.b(z, z2);
                return this;
            }
            return (IImageLoader) invokeCommon.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader config(Bitmap.Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config)) == null) {
                this.f65186g = config;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader from(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f65184e = str;
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
                this.f65188i = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader key(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f65183d = str;
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
                this.f65185f = scaleType;
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
                this.f65189j = resultType;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.f65187h = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader cache(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f65182c = new com.bytedance.sdk.component.image.c.a.b(z, true);
                return this;
            }
            return (IImageLoader) invokeZ.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ILoaderListener iLoaderListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iLoaderListener)) == null) {
                this.f65180a = iLoaderListener;
                return new a(this).o();
            }
            return (IImageHandler) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imageView)) == null) {
                this.f65181b = imageView;
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
                    this.f65118a = g2.submit(new Runnable(this) { // from class: com.bytedance.sdk.component.image.c.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f65128a;

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
                            this.f65128a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            h hVar;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                while (!this.f65128a.m && (hVar = (h) this.f65128a.r.poll()) != null) {
                                    try {
                                        if (this.f65128a.p != null) {
                                            this.f65128a.p.onStepStart(hVar.a(), this.f65128a);
                                        }
                                        hVar.a(this.f65128a);
                                        if (this.f65128a.p != null) {
                                            this.f65128a.p.onStepEnd(hVar.a(), this.f65128a);
                                        }
                                    } catch (Throwable th) {
                                        this.f65128a.a(2000, th.getMessage(), th);
                                        if (this.f65128a.p != null) {
                                            this.f65128a.p.onStepEnd("exception", this.f65128a);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.f65128a.m) {
                                    this.f65128a.a(1003, "canceled", null);
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
            Future<?> future = this.f65118a;
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
        this.f65119b = bVar.f65184e;
        this.f65123f = new C1888a(this, bVar.f65180a);
        this.l = new WeakReference<>(bVar.f65181b);
        if (bVar.f65182c != null) {
            bVar2 = bVar.f65182c;
        } else {
            bVar2 = com.bytedance.sdk.component.image.c.a.b.a();
        }
        this.f65120c = bVar2;
        this.f65124g = bVar.f65185f;
        this.f65125h = bVar.f65186g;
        this.f65126i = bVar.f65187h;
        this.f65127j = bVar.f65188i;
        this.k = bVar.f65189j == null ? ResultType.BITMAP : bVar.f65189j;
        this.q = bVar.k == null ? ImageThread.MAIN : bVar.k;
        this.p = bVar.l;
        if (!TextUtils.isEmpty(bVar.f65183d)) {
            b(bVar.f65183d);
            a(bVar.f65183d);
        }
        this.n = bVar.m;
        this.o = bVar.n;
        this.r.add(new com.bytedance.sdk.component.image.d.b());
    }

    public com.bytedance.sdk.component.image.c.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f65120c : (com.bytedance.sdk.component.image.c.a.b) invokeV.objValue;
    }

    public ILoaderListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f65123f : (ILoaderListener) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f65122e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f65121d : (String) invokeV.objValue;
    }

    public ImageView.ScaleType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f65124g : (ImageView.ScaleType) invokeV.objValue;
    }

    public Bitmap.Config g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f65125h : (Bitmap.Config) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f65126i : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f65127j : invokeV.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65119b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            WeakReference<ImageView> weakReference = this.l;
            if (weakReference != null && weakReference.get() != null) {
                this.l.get().setTag(1094453505, str);
            }
            this.f65121d = str;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f65122e = str;
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
