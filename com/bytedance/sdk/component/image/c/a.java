package com.bytedance.sdk.component.image.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes5.dex */
public class a implements IImageHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Future<?> f28876a;

    /* renamed from: b  reason: collision with root package name */
    public String f28877b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.image.c.a.b f28878c;

    /* renamed from: d  reason: collision with root package name */
    public String f28879d;

    /* renamed from: e  reason: collision with root package name */
    public String f28880e;

    /* renamed from: f  reason: collision with root package name */
    public ILoaderListener f28881f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f28882g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap.Config f28883h;

    /* renamed from: i  reason: collision with root package name */
    public int f28884i;
    public int j;
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
    /* loaded from: classes5.dex */
    public class C0324a implements ILoaderListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28886a;

        /* renamed from: b  reason: collision with root package name */
        public ILoaderListener f28887b;

        public C0324a(a aVar, ILoaderListener iLoaderListener) {
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
            this.f28886a = aVar;
            this.f28887b = iLoaderListener;
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onFailed(int i2, String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, th) == null) {
                if (this.f28886a.q == ImageThread.MAIN) {
                    this.f28886a.s.post(new Runnable(this, i2, str, th) { // from class: com.bytedance.sdk.component.image.c.a.a.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f28893a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f28894b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Throwable f28895c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ C0324a f28896d;

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
                            this.f28896d = this;
                            this.f28893a = i2;
                            this.f28894b = str;
                            this.f28895c = th;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f28896d.f28887b == null) {
                                return;
                            }
                            this.f28896d.f28887b.onFailed(this.f28893a, this.f28894b, this.f28895c);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f28887b;
                if (iLoaderListener != null) {
                    iLoaderListener.onFailed(i2, str, th);
                }
            }
        }

        @Override // com.bytedance.sdk.component.image.ILoaderListener
        public void onSuccess(ImageResponse imageResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                ImageView imageView = (ImageView) this.f28886a.l.get();
                if (imageView != null && this.f28886a.k == ResultType.BITMAP && a(imageView)) {
                    this.f28886a.s.post(new Runnable(this, imageView, (Bitmap) imageResponse.getResult()) { // from class: com.bytedance.sdk.component.image.c.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageView f28888a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f28889b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ C0324a f28890c;

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
                            this.f28890c = this;
                            this.f28888a = imageView;
                            this.f28889b = r8;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f28888a.setImageBitmap(this.f28889b);
                            }
                        }
                    });
                }
                if (this.f28886a.q == ImageThread.MAIN) {
                    this.f28886a.s.post(new Runnable(this, imageResponse) { // from class: com.bytedance.sdk.component.image.c.a.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageResponse f28891a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ C0324a f28892b;

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
                            this.f28892b = this;
                            this.f28891a = imageResponse;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f28892b.f28887b == null) {
                                return;
                            }
                            this.f28892b.f28887b.onSuccess(this.f28891a);
                        }
                    });
                    return;
                }
                ILoaderListener iLoaderListener = this.f28887b;
                if (iLoaderListener != null) {
                    iLoaderListener.onSuccess(imageResponse);
                }
            }
        }

        private boolean a(ImageView imageView) {
            InterceptResult invokeL;
            Object tag;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imageView)) == null) ? (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f28886a.f28879d)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements IImageLoader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ILoaderListener f28936a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f28937b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.image.c.a.b f28938c;

        /* renamed from: d  reason: collision with root package name */
        public String f28939d;

        /* renamed from: e  reason: collision with root package name */
        public String f28940e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView.ScaleType f28941f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap.Config f28942g;

        /* renamed from: h  reason: collision with root package name */
        public int f28943h;

        /* renamed from: i  reason: collision with root package name */
        public int f28944i;
        public ResultType j;
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
                this.f28938c = new com.bytedance.sdk.component.image.c.a.b(z, z2);
                return this;
            }
            return (IImageLoader) invokeCommon.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader config(Bitmap.Config config) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config)) == null) {
                this.f28942g = config;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader from(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f28940e = str;
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
                this.f28944i = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader key(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f28939d = str;
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
                this.f28941f = scaleType;
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
                this.j = resultType;
                return this;
            }
            return (IImageLoader) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader width(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.f28943h = i2;
                return this;
            }
            return (IImageLoader) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageLoader cache(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.f28938c = new com.bytedance.sdk.component.image.c.a.b(z, true);
                return this;
            }
            return (IImageLoader) invokeZ.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ILoaderListener iLoaderListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iLoaderListener)) == null) {
                this.f28936a = iLoaderListener;
                return new a(this).o();
            }
            return (IImageHandler) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.image.IImageLoader
        public IImageHandler to(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, imageView)) == null) {
                this.f28937b = imageView;
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
                    this.f28876a = g2.submit(new Runnable(this) { // from class: com.bytedance.sdk.component.image.c.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f28885a;

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
                            this.f28885a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            h hVar;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                while (!this.f28885a.m && (hVar = (h) this.f28885a.r.poll()) != null) {
                                    try {
                                        if (this.f28885a.p != null) {
                                            this.f28885a.p.onStepStart(hVar.a(), this.f28885a);
                                        }
                                        hVar.a(this.f28885a);
                                        if (this.f28885a.p != null) {
                                            this.f28885a.p.onStepEnd(hVar.a(), this.f28885a);
                                        }
                                    } catch (Throwable th) {
                                        this.f28885a.a(2000, th.getMessage(), th);
                                        if (this.f28885a.p != null) {
                                            this.f28885a.p.onStepEnd("exception", this.f28885a);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.f28885a.m) {
                                    this.f28885a.a(1003, "canceled", null);
                                }
                            }
                        }
                    });
                }
            } catch (Exception e2) {
                Log.e("ImageRequest", e2.getMessage());
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
            Future<?> future = this.f28876a;
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
        this.f28877b = bVar.f28940e;
        this.f28881f = new C0324a(this, bVar.f28936a);
        this.l = new WeakReference<>(bVar.f28937b);
        if (bVar.f28938c != null) {
            bVar2 = bVar.f28938c;
        } else {
            bVar2 = com.bytedance.sdk.component.image.c.a.b.a();
        }
        this.f28878c = bVar2;
        this.f28882g = bVar.f28941f;
        this.f28883h = bVar.f28942g;
        this.f28884i = bVar.f28943h;
        this.j = bVar.f28944i;
        this.k = bVar.j == null ? ResultType.BITMAP : bVar.j;
        this.q = bVar.k == null ? ImageThread.MAIN : bVar.k;
        this.p = bVar.l;
        if (!TextUtils.isEmpty(bVar.f28939d)) {
            b(bVar.f28939d);
            a(bVar.f28939d);
        }
        this.n = bVar.m;
        this.o = bVar.n;
        this.r.add(new com.bytedance.sdk.component.image.d.b());
    }

    public com.bytedance.sdk.component.image.c.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28878c : (com.bytedance.sdk.component.image.c.a.b) invokeV.objValue;
    }

    public ILoaderListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28881f : (ILoaderListener) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28880e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28879d : (String) invokeV.objValue;
    }

    public ImageView.ScaleType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28882g : (ImageView.ScaleType) invokeV.objValue;
    }

    public Bitmap.Config g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f28883h : (Bitmap.Config) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f28884i : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28877b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            WeakReference<ImageView> weakReference = this.l;
            if (weakReference != null && weakReference.get() != null) {
                this.l.get().setTag(1094453505, str);
            }
            this.f28879d = str;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f28880e = str;
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
