package com.bytedance.sdk.component.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f27755a;

    /* renamed from: b  reason: collision with root package name */
    public final l f27756b;

    /* renamed from: c  reason: collision with root package name */
    public int f27757c;

    /* renamed from: d  reason: collision with root package name */
    public final b f27758d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, a> f27759e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, a> f27760f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f27761g;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Request<?> f27785a;

        /* renamed from: b  reason: collision with root package name */
        public m<Bitmap> f27786b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f27787c;

        /* renamed from: d  reason: collision with root package name */
        public VAdError f27788d;

        /* renamed from: e  reason: collision with root package name */
        public final List<c> f27789e;

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
            this.f27789e = synchronizedList;
            this.f27785a = request;
            synchronizedList.add(cVar);
        }

        public m<Bitmap> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27786b : (m) invokeV.objValue;
        }

        public void a(VAdError vAdError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, vAdError) == null) {
                this.f27788d = vAdError;
            }
        }

        public VAdError a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27788d : (VAdError) invokeV.objValue;
        }

        public void a(m<Bitmap> mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
                this.f27786b = mVar;
            }
        }

        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                this.f27789e.add(cVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        String a(String str, int i2, int i3, ImageView.ScaleType scaleType);

        void a(String str, Bitmap bitmap, byte[] bArr);

        byte[] a(String str);

        Bitmap b(String str);
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f27790a;

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f27791b;

        /* renamed from: c  reason: collision with root package name */
        public final e f27792c;

        /* renamed from: d  reason: collision with root package name */
        public final String f27793d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f27794e;

        /* renamed from: f  reason: collision with root package name */
        public final String f27795f;

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
            this.f27790a = dVar;
            this.f27794e = bArr;
            this.f27791b = bitmap;
            this.f27795f = str;
            this.f27793d = str2;
            this.f27792c = eVar;
        }

        public Bitmap a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27791b : (Bitmap) invokeV.objValue;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adnet.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0314d {
        Bitmap a(byte[] bArr);
    }

    /* loaded from: classes6.dex */
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
        this.f27755a = Executors.newCachedThreadPool();
        this.f27757c = 50;
        this.f27759e = Collections.synchronizedMap(new HashMap());
        this.f27760f = Collections.synchronizedMap(new HashMap());
        this.f27761g = new Handler(Looper.getMainLooper());
        this.f27756b = lVar;
        this.f27758d = bVar == null ? new com.bytedance.sdk.component.adnet.b.a() : bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, e eVar, InterfaceC0314d interfaceC0314d, int i2, int i3, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, eVar, interfaceC0314d, Integer.valueOf(i2), Integer.valueOf(i3), scaleType}) == null) {
            this.f27761g.post(new Runnable(this, eVar) { // from class: com.bytedance.sdk.component.adnet.b.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f27769a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27770b;

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
                    this.f27770b = this;
                    this.f27769a = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27769a.a();
                    }
                }
            });
            String a2 = a(str, i2, i3, scaleType);
            Bitmap b2 = this.f27758d.b(a2);
            byte[] a3 = this.f27758d.a(a2);
            if (b2 == null && a3.length <= 0) {
                c cVar = new c(this, new byte[0], null, str, a2, eVar);
                a aVar = this.f27759e.get(a2);
                if (aVar == null) {
                    aVar = this.f27760f.get(a2);
                }
                if (aVar != null) {
                    aVar.a(cVar);
                    return;
                }
                Request<Bitmap> a4 = a(str, i2, i3, scaleType, a2, interfaceC0314d, eVar);
                this.f27756b.a(a4);
                this.f27759e.put(a2, new a(a4, cVar));
                return;
            }
            this.f27761g.post(new Runnable(this, eVar, new c(this, this.f27758d.a(a2), b2, str, null, null)) { // from class: com.bytedance.sdk.component.adnet.b.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f27771a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f27772b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f27773c;

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
                    this.f27773c = this;
                    this.f27771a = eVar;
                    this.f27772b = r8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27771a.a(this.f27772b, true);
                        this.f27771a.b();
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
            this.f27755a.execute(new Runnable(this, str, eVar, interfaceC0314d, i2, i3, scaleType) { // from class: com.bytedance.sdk.component.adnet.b.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f27762a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f27763b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ InterfaceC0314d f27764c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f27765d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f27766e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ ImageView.ScaleType f27767f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ d f27768g;

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
                    this.f27768g = this;
                    this.f27762a = str;
                    this.f27763b = eVar;
                    this.f27764c = interfaceC0314d;
                    this.f27765d = i2;
                    this.f27766e = i3;
                    this.f27767f = scaleType;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27768g.b(this.f27762a, this.f27763b, this.f27764c, this.f27765d, this.f27766e, this.f27767f);
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
            public final /* synthetic */ String f27774a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f27775b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f27776c;

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
                this.f27776c = this;
                this.f27774a = str2;
                this.f27775b = eVar;
            }

            @Override // com.bytedance.sdk.component.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                    this.f27776c.f27755a.execute(new Runnable(this, mVar) { // from class: com.bytedance.sdk.component.adnet.b.d.4.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m f27777a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass4 f27778b;

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
                            this.f27778b = this;
                            this.f27777a = mVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass4 anonymousClass4 = this.f27778b;
                                anonymousClass4.f27776c.a(anonymousClass4.f27774a, this.f27777a, anonymousClass4.f27775b);
                            }
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.component.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                    this.f27776c.f27755a.execute(new Runnable(this, mVar) { // from class: com.bytedance.sdk.component.adnet.b.d.4.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m f27779a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass4 f27780b;

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
                            this.f27780b = this;
                            this.f27779a = mVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass4 anonymousClass4 = this.f27780b;
                                anonymousClass4.f27776c.a(anonymousClass4.f27774a, this.f27779a);
                            }
                        }
                    });
                }
            }
        }, i2, i3, scaleType, Bitmap.Config.ARGB_4444, interfaceC0314d) { // from class: com.bytedance.sdk.component.adnet.b.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ InterfaceC0314d f27781c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ d f27782d;

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
                this.f27782d = this;
                this.f27781c = interfaceC0314d;
            }

            @Override // com.bytedance.sdk.component.adnet.b.e
            public Bitmap a(byte[] bArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bArr)) == null) {
                    InterfaceC0314d interfaceC0314d2 = this.f27781c;
                    return interfaceC0314d2 != null ? interfaceC0314d2.a(bArr) : super.a(bArr);
                }
                return (Bitmap) invokeL.objValue;
            }
        } : (Request) invokeCommon.objValue;
    }

    public void a(String str, m<Bitmap> mVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, mVar, eVar) == null) {
            a.C0316a c0316a = mVar.f27922b;
            this.f27758d.a(str, mVar.f27921a, (c0316a == null || !eVar.a(c0316a.f27957b)) ? new byte[0] : mVar.f27922b.f27957b);
            a remove = this.f27759e.remove(str);
            if (remove != null) {
                remove.f27787c = mVar.f27921a;
                remove.a(mVar);
                a(str, remove);
            }
        }
    }

    public void a(String str, m<Bitmap> mVar) {
        a remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, mVar) == null) || (remove = this.f27759e.remove(str)) == null) {
            return;
        }
        remove.a(mVar.f27923c);
        remove.a(mVar);
        a(str, remove);
    }

    private void a(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, this, str, aVar) == null) {
            this.f27760f.put(str, aVar);
            this.f27761g.postDelayed(new Runnable(this, str) { // from class: com.bytedance.sdk.component.adnet.b.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f27783a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f27784b;

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
                    this.f27784b = this;
                    this.f27783a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a aVar2 = (a) this.f27784b.f27760f.get(this.f27783a);
                        if (aVar2 != null) {
                            for (c cVar : aVar2.f27789e) {
                                if (cVar.f27792c != null) {
                                    if (aVar2.a() != null) {
                                        cVar.f27792c.b(aVar2.b());
                                    } else {
                                        cVar.f27794e = aVar2.f27786b.f27922b.f27957b;
                                        cVar.f27791b = aVar2.f27787c;
                                        cVar.f27792c.a(cVar, false);
                                    }
                                    cVar.f27792c.b();
                                }
                            }
                        }
                        this.f27784b.f27760f.remove(this.f27783a);
                    }
                }
            }, this.f27757c);
        }
    }

    private String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), scaleType})) == null) {
            String a2 = this.f27758d.a(str, i2, i3, scaleType);
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
