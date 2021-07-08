package com.bytedance.sdk.component.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.l;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.err.VAdError;
import com.bytedance.sdk.component.adnet.face.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f27865a;

    /* renamed from: b  reason: collision with root package name */
    public final l f27866b;

    /* renamed from: c  reason: collision with root package name */
    public int f27867c;

    /* renamed from: d  reason: collision with root package name */
    public final b f27868d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, a> f27869e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, a> f27870f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f27871g;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Request<?> f27895a;

        /* renamed from: b  reason: collision with root package name */
        public m<Bitmap> f27896b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f27897c;

        /* renamed from: d  reason: collision with root package name */
        public VAdError f27898d;

        /* renamed from: e  reason: collision with root package name */
        public final List<c> f27899e;

        public a(Request<?> request, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {request, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            List<c> synchronizedList = Collections.synchronizedList(new ArrayList());
            this.f27899e = synchronizedList;
            this.f27895a = request;
            synchronizedList.add(cVar);
        }

        public m<Bitmap> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27896b : (m) invokeV.objValue;
        }

        public void a(VAdError vAdError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, vAdError) == null) {
                this.f27898d = vAdError;
            }
        }

        public VAdError a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27898d : (VAdError) invokeV.objValue;
        }

        public void a(m<Bitmap> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                this.f27896b = mVar;
            }
        }

        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                this.f27899e.add(cVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        String a(String str, int i2, int i3, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap, byte[] bArr);

        byte[] a(String str);

        Bitmap b(String str);
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27900a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f27901b;

        /* renamed from: c  reason: collision with root package name */
        public final e f27902c;

        /* renamed from: d  reason: collision with root package name */
        public final String f27903d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f27904e;

        /* renamed from: f  reason: collision with root package name */
        public final String f27905f;

        public c(d dVar, byte[] bArr, Bitmap bitmap, String str, String str2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bArr, bitmap, str, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27900a = dVar;
            this.f27904e = bArr;
            this.f27901b = bitmap;
            this.f27905f = str;
            this.f27903d = str2;
            this.f27902c = eVar;
        }

        public Bitmap a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27901b : (Bitmap) invokeV.objValue;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adnet.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0314d {
        Bitmap a(byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public interface e extends m.a<Bitmap> {
        void a();

        void a(c cVar, boolean z);

        boolean a(byte[] bArr);

        void b();
    }

    public d(l lVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27865a = Executors.newCachedThreadPool();
        this.f27867c = 50;
        this.f27869e = Collections.synchronizedMap(new HashMap());
        this.f27870f = Collections.synchronizedMap(new HashMap());
        this.f27871g = new Handler(Looper.getMainLooper());
        this.f27866b = lVar;
        this.f27868d = bVar == null ? new com.bytedance.sdk.component.adnet.b.a() : bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, e eVar, InterfaceC0314d interfaceC0314d, int i2, int i3, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, eVar, interfaceC0314d, Integer.valueOf(i2), Integer.valueOf(i3), scaleType}) == null) {
            this.f27871g.post(new Runnable(this, eVar) { // from class: com.bytedance.sdk.component.adnet.b.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f27879a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27880b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27880b = this;
                    this.f27879a = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27879a.a();
                    }
                }
            });
            String a2 = a(str, i2, i3, scaleType);
            Bitmap b2 = this.f27868d.b(a2);
            byte[] a3 = this.f27868d.a(a2);
            if (b2 == null && a3.length <= 0) {
                c cVar = new c(this, new byte[0], null, str, a2, eVar);
                a aVar = this.f27869e.get(a2);
                if (aVar == null) {
                    aVar = this.f27870f.get(a2);
                }
                if (aVar != null) {
                    aVar.a(cVar);
                    return;
                }
                Request<Bitmap> a4 = a(str, i2, i3, scaleType, a2, interfaceC0314d, eVar);
                this.f27866b.a(a4);
                this.f27869e.put(a2, new a(a4, cVar));
                return;
            }
            this.f27871g.post(new Runnable(this, eVar, new c(this, this.f27868d.a(a2), b2, str, null, null)) { // from class: com.bytedance.sdk.component.adnet.b.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f27881a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f27882b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f27883c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27883c = this;
                    this.f27881a = eVar;
                    this.f27882b = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27881a.a(this.f27882b, true);
                        this.f27881a.b();
                    }
                }
            });
        }
    }

    public void a(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar) == null) {
            a(str, eVar, 0, 0);
        }
    }

    public void a(String str, e eVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, str, eVar, i2, i3) == null) {
            a(str, eVar, null, i2, i3, ImageView.ScaleType.CENTER_INSIDE);
        }
    }

    public void a(String str, e eVar, InterfaceC0314d interfaceC0314d, int i2, int i3, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, eVar, interfaceC0314d, Integer.valueOf(i2), Integer.valueOf(i3), scaleType}) == null) {
            this.f27865a.execute(new Runnable(this, str, eVar, interfaceC0314d, i2, i3, scaleType) { // from class: com.bytedance.sdk.component.adnet.b.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f27872a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f27873b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ InterfaceC0314d f27874c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f27875d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f27876e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ ImageView.ScaleType f27877f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ d f27878g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, eVar, interfaceC0314d, Integer.valueOf(i2), Integer.valueOf(i3), scaleType};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27878g = this;
                    this.f27872a = str;
                    this.f27873b = eVar;
                    this.f27874c = interfaceC0314d;
                    this.f27875d = i2;
                    this.f27876e = i3;
                    this.f27877f = scaleType;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27878g.b(this.f27872a, this.f27873b, this.f27874c, this.f27875d, this.f27876e, this.f27877f);
                    }
                }
            });
        }
    }

    public Request<Bitmap> a(String str, int i2, int i3, ImageView.ScaleType scaleType, String str2, InterfaceC0314d interfaceC0314d, e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, str2, interfaceC0314d, eVar})) == null) ? new com.bytedance.sdk.component.adnet.b.e(this, str, new m.a<Bitmap>(this, str2, eVar) { // from class: com.bytedance.sdk.component.adnet.b.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f27884a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f27885b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f27886c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str2, eVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27886c = this;
                this.f27884a = str2;
                this.f27885b = eVar;
            }

            @Override // com.bytedance.sdk.component.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                    this.f27886c.f27865a.execute(new Runnable(this, mVar) { // from class: com.bytedance.sdk.component.adnet.b.d.4.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m f27887a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass4 f27888b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, mVar};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27888b = this;
                            this.f27887a = mVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass4 anonymousClass4 = this.f27888b;
                                anonymousClass4.f27886c.a(anonymousClass4.f27884a, this.f27887a, anonymousClass4.f27885b);
                            }
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.component.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                    this.f27886c.f27865a.execute(new Runnable(this, mVar) { // from class: com.bytedance.sdk.component.adnet.b.d.4.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m f27889a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass4 f27890b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, mVar};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f27890b = this;
                            this.f27889a = mVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass4 anonymousClass4 = this.f27890b;
                                anonymousClass4.f27886c.a(anonymousClass4.f27884a, this.f27889a);
                            }
                        }
                    });
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.ARGB_4444, interfaceC0314d) { // from class: com.bytedance.sdk.component.adnet.b.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ InterfaceC0314d f27891c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ d f27892d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, r16, i2, i3, scaleType, r20);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {this, str, r16, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, r20, interfaceC0314d};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], (m.a) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (ImageView.ScaleType) objArr2[4], (Bitmap.Config) objArr2[5]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27892d = this;
                this.f27891c = interfaceC0314d;
            }

            @Override // com.bytedance.sdk.component.adnet.b.e
            public Bitmap a(byte[] bArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bArr)) == null) {
                    InterfaceC0314d interfaceC0314d2 = this.f27891c;
                    return interfaceC0314d2 != null ? interfaceC0314d2.a(bArr) : super.a(bArr);
                }
                return (Bitmap) invokeL.objValue;
            }
        } : (Request) invokeCommon.objValue;
    }

    public void a(String str, m<Bitmap> mVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, mVar, eVar) == null) {
            a.C0316a c0316a = mVar.f28032b;
            this.f27868d.a(str, mVar.f28031a, (c0316a == null || !eVar.a(c0316a.f28067b)) ? new byte[0] : mVar.f28032b.f28067b);
            a remove = this.f27869e.remove(str);
            if (remove != null) {
                remove.f27897c = mVar.f28031a;
                remove.a(mVar);
                a(str, remove);
            }
        }
    }

    public void a(String str, m<Bitmap> mVar) {
        a remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, mVar) == null) || (remove = this.f27869e.remove(str)) == null) {
            return;
        }
        remove.a(mVar.f28033c);
        remove.a(mVar);
        a(str, remove);
    }

    private void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) {
            this.f27870f.put(str, aVar);
            this.f27871g.postDelayed(new Runnable(this, str) { // from class: com.bytedance.sdk.component.adnet.b.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f27893a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27894b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27894b = this;
                    this.f27893a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a aVar2 = (a) this.f27894b.f27870f.get(this.f27893a);
                        if (aVar2 != null) {
                            for (c cVar : aVar2.f27899e) {
                                if (cVar.f27902c != null) {
                                    if (aVar2.a() != null) {
                                        cVar.f27902c.b(aVar2.b());
                                    } else {
                                        cVar.f27904e = aVar2.f27896b.f28032b.f28067b;
                                        cVar.f27901b = aVar2.f27897c;
                                        cVar.f27902c.a(cVar, false);
                                    }
                                    cVar.f27902c.b();
                                }
                            }
                        }
                        this.f27894b.f27870f.remove(this.f27893a);
                    }
                }
            }, this.f27867c);
        }
    }

    private String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType})) == null) {
            String a2 = this.f27868d.a(str, i2, i3, scaleType);
            if (TextUtils.isEmpty(a2)) {
                StringBuilder sb = new StringBuilder(str.length() + 12);
                sb.append("#W");
                sb.append(i2);
                sb.append("#H");
                sb.append(i3);
                sb.append("#S");
                sb.append(scaleType.ordinal());
                sb.append(str);
                return sb.toString();
            }
            return a2;
        }
        return (String) invokeCommon.objValue;
    }
}
