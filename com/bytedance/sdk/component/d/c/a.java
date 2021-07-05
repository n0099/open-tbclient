package com.bytedance.sdk.component.d.c;

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
import com.bytedance.sdk.component.d.d.h;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.m;
import com.bytedance.sdk.component.d.n;
import com.bytedance.sdk.component.d.p;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.component.d.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Future<?> f28589a;

    /* renamed from: b  reason: collision with root package name */
    public String f28590b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.d.c.a.b f28591c;

    /* renamed from: d  reason: collision with root package name */
    public String f28592d;

    /* renamed from: e  reason: collision with root package name */
    public String f28593e;

    /* renamed from: f  reason: collision with root package name */
    public g f28594f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView.ScaleType f28595g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap.Config f28596h;

    /* renamed from: i  reason: collision with root package name */
    public int f28597i;
    public int j;
    public p k;
    public WeakReference<ImageView> l;
    public volatile boolean m;
    public boolean n;
    public k o;
    public n p;
    public Queue<h> q;
    public final Handler r;
    public boolean s;

    /* renamed from: com.bytedance.sdk.component.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0321a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28599a;

        /* renamed from: b  reason: collision with root package name */
        public g f28600b;

        public C0321a(a aVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28599a = aVar;
            this.f28600b = gVar;
        }

        @Override // com.bytedance.sdk.component.d.g
        public void a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                ImageView imageView = (ImageView) this.f28599a.l.get();
                if (imageView != null && this.f28599a.k == p.f28729a && a(imageView)) {
                    this.f28599a.r.post(new Runnable(this, imageView, (Bitmap) mVar.a()) { // from class: com.bytedance.sdk.component.d.c.a.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ ImageView f28601a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f28602b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ C0321a f28603c;

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
                            this.f28603c = this;
                            this.f28601a = imageView;
                            this.f28602b = r8;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f28601a.setImageBitmap(this.f28602b);
                            }
                        }
                    });
                }
                if (this.f28599a.p == n.f28711b) {
                    this.f28599a.r.post(new Runnable(this, mVar) { // from class: com.bytedance.sdk.component.d.c.a.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m f28604a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ C0321a f28605b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, mVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f28605b = this;
                            this.f28604a = mVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f28605b.f28600b == null) {
                                return;
                            }
                            this.f28605b.f28600b.a(this.f28604a);
                        }
                    });
                    return;
                }
                g gVar = this.f28600b;
                if (gVar != null) {
                    gVar.a(mVar);
                }
            }
        }

        private boolean a(ImageView imageView) {
            InterceptResult invokeL;
            Object tag;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, imageView)) == null) ? (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(this.f28599a.f28592d)) ? false : true : invokeL.booleanValue;
        }

        @Override // com.bytedance.sdk.component.d.g
        public void a(int i2, String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, th) == null) {
                if (this.f28599a.p == n.f28711b) {
                    this.f28599a.r.post(new Runnable(this, i2, str, th) { // from class: com.bytedance.sdk.component.d.c.a.a.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f28606a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f28607b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Throwable f28608c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ C0321a f28609d;

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
                            this.f28609d = this;
                            this.f28606a = i2;
                            this.f28607b = str;
                            this.f28608c = th;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f28609d.f28600b == null) {
                                return;
                            }
                            this.f28609d.f28600b.a(this.f28606a, this.f28607b, this.f28608c);
                        }
                    });
                    return;
                }
                g gVar = this.f28600b;
                if (gVar != null) {
                    gVar.a(i2, str, th);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public g f28647a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f28648b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.d.c.a.b f28649c;

        /* renamed from: d  reason: collision with root package name */
        public String f28650d;

        /* renamed from: e  reason: collision with root package name */
        public String f28651e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView.ScaleType f28652f;

        /* renamed from: g  reason: collision with root package name */
        public Bitmap.Config f28653g;

        /* renamed from: h  reason: collision with root package name */
        public int f28654h;

        /* renamed from: i  reason: collision with root package name */
        public int f28655i;
        public p j;
        public n k;
        public k l;
        public boolean m;

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

        @Override // com.bytedance.sdk.component.d.e
        public e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f28650d = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public e b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f28651e = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.d.e
        public e a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f28654h = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.d.e
        public e b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f28655i = i2;
                return this;
            }
            return (e) invokeI.objValue;
        }

        @Override // com.bytedance.sdk.component.d.e
        public e a(k kVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kVar)) == null) {
                this.l = kVar;
                return this;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.d.e
        public com.bytedance.sdk.component.d.d a(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) {
                this.f28647a = gVar;
                return new a(this).m();
            }
            return (com.bytedance.sdk.component.d.d) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.component.d.e
        public com.bytedance.sdk.component.d.d a(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageView)) == null) {
                this.f28648b = imageView;
                return new a(this).m();
            }
            return (com.bytedance.sdk.component.d.d) invokeL.objValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            try {
                ExecutorService g2 = com.bytedance.sdk.component.d.c.b.a().g();
                if (g2 != null) {
                    this.f28589a = g2.submit(new Runnable(this) { // from class: com.bytedance.sdk.component.d.c.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f28598a;

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
                            this.f28598a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            h hVar;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                while (!this.f28598a.m && (hVar = (h) this.f28598a.q.poll()) != null) {
                                    try {
                                        if (this.f28598a.o != null) {
                                            this.f28598a.o.a(hVar.a(), this.f28598a);
                                        }
                                        hVar.a(this.f28598a);
                                        if (this.f28598a.o != null) {
                                            this.f28598a.o.b(hVar.a(), this.f28598a);
                                        }
                                    } catch (Throwable th) {
                                        this.f28598a.a(2000, th.getMessage(), th);
                                        if (this.f28598a.o != null) {
                                            this.f28598a.o.b("exception", this.f28598a);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.f28598a.m) {
                                    this.f28598a.a(1003, "canceled", null);
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
        return (com.bytedance.sdk.component.d.d) invokeV.objValue;
    }

    public p j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (p) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public a(b bVar) {
        com.bytedance.sdk.component.d.c.a.b bVar2;
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
        this.q = new LinkedBlockingQueue();
        this.r = new Handler(Looper.getMainLooper());
        this.s = true;
        this.f28590b = bVar.f28651e;
        this.f28594f = new C0321a(this, bVar.f28647a);
        this.l = new WeakReference<>(bVar.f28648b);
        if (bVar.f28649c != null) {
            bVar2 = bVar.f28649c;
        } else {
            bVar2 = com.bytedance.sdk.component.d.c.a.b.a();
        }
        this.f28591c = bVar2;
        this.f28595g = bVar.f28652f;
        this.f28596h = bVar.f28653g;
        this.f28597i = bVar.f28654h;
        this.j = bVar.f28655i;
        this.k = bVar.j == null ? p.f28729a : bVar.j;
        this.p = bVar.k == null ? n.f28711b : bVar.k;
        this.o = bVar.l;
        if (!TextUtils.isEmpty(bVar.f28650d)) {
            b(bVar.f28650d);
            a(bVar.f28650d);
        }
        this.n = bVar.m;
        this.q.add(new com.bytedance.sdk.component.d.d.b());
    }

    public com.bytedance.sdk.component.d.c.a.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28591c : (com.bytedance.sdk.component.d.c.a.b) invokeV.objValue;
    }

    public g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28594f : (g) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28593e : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28592d : (String) invokeV.objValue;
    }

    public ImageView.ScaleType f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f28595g : (ImageView.ScaleType) invokeV.objValue;
    }

    public Bitmap.Config g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28596h : (Bitmap.Config) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28597i : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28590b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            WeakReference<ImageView> weakReference = this.l;
            if (weakReference != null && weakReference.get() != null) {
                this.l.get().setTag(1094453505, str);
            }
            this.f28592d = str;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f28593e = str;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.s = z;
        }
    }

    public boolean a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) {
            if (this.m) {
                return false;
            }
            return this.q.add(hVar);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, this, i2, str, th) == null) {
            new com.bytedance.sdk.component.d.d.g(i2, str, th).a(this);
            this.q.clear();
        }
    }
}
