package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Http2Codec;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes8.dex */
public class zn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ao2 a;
    public gj2 b;
    public do2 c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ ko2 e;
        public final /* synthetic */ zn2 f;

        /* renamed from: com.baidu.tieba.zn2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0540a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ a b;

            public RunnableC0540a(a aVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    wn2 v = io2.v(this.a, "mkdir:", this.b.d);
                    a aVar = this.b;
                    if (!io2.a(v, aVar.e, hashMap, aVar.f.b)) {
                        return;
                    }
                    ko2 ko2Var = this.b.e;
                    ko2Var.errMsg = "mkdir:" + this.a.b;
                    a aVar2 = this.b;
                    io2.b(aVar2.e, aVar2.d);
                }
            }
        }

        public a(zn2 zn2Var, String str, Boolean bool, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, bool, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zn2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new RunnableC0540a(this, this.f.a.o(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ ko2 f;
        public final /* synthetic */ zn2 g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ b b;

            public a(b bVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "srcPath");
                    hashMap.put(Integer.valueOf(this.b.d), "destPath");
                    wn2 v = io2.v(this.a, "copyFile:", this.b.e);
                    b bVar = this.b;
                    if (!io2.a(v, bVar.f, hashMap, bVar.g.b)) {
                        return;
                    }
                    b bVar2 = this.b;
                    io2.b(bVar2.f, bVar2.e);
                }
            }
        }

        public b(zn2 zn2Var, String str, String str2, int i, int i2, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.c(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ ko2 h;
        public final /* synthetic */ zn2 i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ c b;

            public a(c cVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    wn2 v = io2.v(this.a, "appendFile:", this.b.d);
                    c cVar = this.b;
                    if (!io2.a(v, cVar.h, hashMap, cVar.i.b)) {
                        return;
                    }
                    c cVar2 = this.b;
                    io2.b(cVar2.h, cVar2.d);
                }
            }
        }

        public c(zn2 zn2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ao2 ao2Var = this.i.a;
                String str = this.a;
                if (TextUtils.isEmpty(this.b)) {
                    obj = this.c;
                } else {
                    obj = this.b;
                }
                xn2 b = ao2Var.b(str, obj, io2.I(Http2Codec.ENCODING, this.d), false);
                if (!TextUtils.isEmpty(this.e)) {
                    b.b = this.e;
                    b.a = -2;
                    io2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        b.b = "fail encoding must be a string";
                        b.a = -2;
                        io2.d(this.i.b, b.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ d b;

            public a(d dVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    wn2 v = io2.v(this.a, "access:", this.b.c);
                    d dVar = this.b;
                    if (!io2.a(v, dVar.d, hashMap, dVar.e.b)) {
                        return;
                    }
                    d dVar2 = this.b;
                    io2.b(dVar2.d, dVar2.c);
                }
            }
        }

        public d(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.a(this.a, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ e b;

            public a(e eVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    wn2 v = io2.v(this.a, "stat:", this.b.c);
                    e eVar = this.b;
                    if (!io2.a(v, eVar.d, hashMap, eVar.e.b)) {
                        return;
                    }
                    qo2 qo2Var = new qo2();
                    xn2 xn2Var = this.a;
                    qo2Var.stats = xn2Var.d;
                    qo2Var.errMsg = xn2Var.b;
                    io2.b(qo2Var, this.b.c);
                }
            }
        }

        public e(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ f b;

            public a(f fVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    wn2 v = io2.v(this.a, "getFileInfo:", this.b.c);
                    f fVar = this.b;
                    if (!io2.a(v, fVar.d, hashMap, fVar.e.b)) {
                        return;
                    }
                    lo2 lo2Var = new lo2();
                    lo2Var.errMsg = "getFileInfo:" + this.a.b;
                    xn2 xn2Var = this.a;
                    lo2Var.digest = xn2Var.g;
                    lo2Var.size = (int) xn2Var.e;
                    io2.b(lo2Var, this.b.c);
                }
            }
        }

        public f(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ ko2 b;
        public final /* synthetic */ zn2 c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ g b;

            public a(g gVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size;
                yn2[] yn2VarArr;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    wn2 v = io2.v(this.a, "getSavedFileList:", this.b.a);
                    g gVar = this.b;
                    if (!io2.a(v, gVar.b, null, gVar.c.b)) {
                        return;
                    }
                    mo2 mo2Var = new mo2();
                    List<yn2> list = this.a.f;
                    if (list == null) {
                        size = 0;
                    } else {
                        size = list.size();
                    }
                    if (size == 0) {
                        yn2VarArr = new yn2[0];
                    } else {
                        yn2VarArr = (yn2[]) this.a.f.toArray(new yn2[size]);
                    }
                    mo2Var.fileList = yn2VarArr;
                    g gVar2 = this.b;
                    mo2Var.errMsg = gVar2.b.errMsg;
                    io2.b(mo2Var, gVar2.a);
                }
            }
        }

        public g(zn2 zn2Var, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zn2Var;
            this.a = map;
            this.b = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.runOnJSThread(new a(this, this.c.a.i()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ h b;

            public a(h hVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    wn2 v = io2.v(this.a, "removeSavedFile:", this.b.c);
                    h hVar = this.b;
                    if (!io2.a(v, hVar.d, hashMap, hVar.e.b)) {
                        return;
                    }
                    h hVar2 = this.b;
                    io2.b(hVar2.d, hVar2.c);
                }
            }
        }

        public h(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ ko2 h;
        public final /* synthetic */ zn2 i;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ i b;

            public a(i iVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    wn2 v = io2.v(this.a, "writeFile:", this.b.d);
                    i iVar = this.b;
                    if (!io2.a(v, iVar.h, hashMap, iVar.i.b)) {
                        return;
                    }
                    ko2 ko2Var = this.b.h;
                    ko2Var.errMsg = "writeFile:" + this.a.b;
                    i iVar2 = this.b;
                    io2.b(iVar2.h, iVar2.d);
                }
            }
        }

        public i(zn2 zn2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ao2 ao2Var = this.i.a;
                String str = this.a;
                if (TextUtils.isEmpty(this.b)) {
                    obj = this.c;
                } else {
                    obj = this.b;
                }
                xn2 C = ao2Var.C(false, str, obj, io2.I(Http2Codec.ENCODING, this.d));
                if (!TextUtils.isEmpty(this.e)) {
                    C.b = this.e;
                    C.a = -2;
                    io2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        C.b = "fail encoding must be a string";
                        C.a = -2;
                        io2.d(this.i.b, C.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ j b;

            public a(j jVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    wn2 v = io2.v(this.a, "unlink:", this.b.c);
                    j jVar = this.b;
                    if (!io2.a(v, jVar.d, hashMap, jVar.e.b)) {
                        return;
                    }
                    ko2 ko2Var = this.b.d;
                    ko2Var.errMsg = "unlink:" + this.a.b;
                    j jVar2 = this.b;
                    io2.b(jVar2.d, jVar2.c);
                }
            }
        }

        public j(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ ko2 f;
        public final /* synthetic */ zn2 g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ k b;

            public a(k kVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = kVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "targetPath");
                    wn2 v = io2.v(this.a, "unzip:", this.b.e);
                    k kVar = this.b;
                    if (!io2.a(v, kVar.f, hashMap, kVar.g.b)) {
                        return;
                    }
                    ko2 ko2Var = this.b.f;
                    ko2Var.errMsg = "unzip:" + this.a.b;
                    k kVar2 = this.b;
                    io2.b(kVar2.f, kVar2.e);
                }
            }
        }

        public k(zn2 zn2Var, String str, String str2, int i, int i2, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.A(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ ko2 f;
        public final /* synthetic */ zn2 g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ l b;

            public a(l lVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    wn2 v = io2.v(this.a, "saveFile:", this.b.e);
                    l lVar = this.b;
                    if (!io2.a(v, lVar.f, hashMap, lVar.g.b)) {
                        return;
                    }
                    po2 po2Var = new po2();
                    List<String> list = this.a.c;
                    if (list != null) {
                        str = list.get(0);
                    } else {
                        str = null;
                    }
                    po2Var.savedFilePath = str;
                    po2Var.errMsg = this.a.b;
                    io2.b(po2Var, this.b.e);
                }
            }
        }

        public l(zn2 zn2Var, String str, String str2, int i, int i2, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.x(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ ko2 d;
        public final /* synthetic */ zn2 e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ m b;

            public a(m mVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size;
                String[] strArr;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "dirPath");
                    wn2 v = io2.v(this.a, "readdir:", this.b.c);
                    m mVar = this.b;
                    if (!io2.a(v, mVar.d, hashMap, mVar.e.b)) {
                        return;
                    }
                    no2 no2Var = new no2();
                    List<String> list = this.a.c;
                    if (list == null) {
                        size = 0;
                    } else {
                        size = list.size();
                    }
                    if (size == 0) {
                        strArr = new String[0];
                    } else {
                        strArr = (String[]) this.a.c.toArray(new String[size]);
                    }
                    no2Var.files = strArr;
                    no2Var.errMsg = this.a.b;
                    io2.b(no2Var, this.b.c);
                }
            }
        }

        public m(zn2 zn2Var, String str, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zn2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ ko2 e;
        public final /* synthetic */ zn2 f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ n b;

            public a(n nVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    wn2 v = io2.v(this.a, "rmdir:", this.b.d);
                    n nVar = this.b;
                    if (!io2.a(v, nVar.e, hashMap, nVar.f.b)) {
                        return;
                    }
                    n nVar2 = this.b;
                    io2.b(nVar2.e, nVar2.d);
                }
            }
        }

        public n(zn2 zn2Var, String str, Boolean bool, int i, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, bool, Integer.valueOf(i), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zn2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new a(this, this.f.a.v(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ ko2 f;
        public final /* synthetic */ zn2 g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ o b;

            public a(o oVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = oVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    wn2 v = io2.v(this.a, "readFile:", this.b.e);
                    o oVar = this.b;
                    if (!io2.a(v, oVar.f, hashMap, oVar.g.b)) {
                        return;
                    }
                    if (TextUtils.isEmpty(this.b.b)) {
                        jo2 jo2Var = new jo2();
                        xn2 xn2Var = this.a;
                        if (xn2Var.h == null) {
                            xn2Var.h = new byte[0];
                        }
                        byte[] bArr = this.a.h;
                        jo2Var.data = new JsArrayBuffer(bArr, bArr.length);
                        jo2Var.errMsg = this.a.b;
                        io2.b(jo2Var, this.b.e);
                        return;
                    }
                    List<String> list = this.a.c;
                    if (list != null) {
                        str = list.get(0);
                    } else {
                        str = null;
                    }
                    oo2 oo2Var = new oo2();
                    oo2Var.data = str;
                    oo2Var.errMsg = this.a.b;
                    io2.b(oo2Var, this.b.e);
                }
            }
        }

        public o(zn2 zn2Var, String str, String str2, int i, int i2, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xn2 q = this.g.a.q(this.a, this.b, false);
                int i = this.c;
                if (i != 7 && i != 12) {
                    q.b = "fail encoding must be a string";
                    q.a = -2;
                    io2.d(this.g.b, q.b);
                }
                this.g.b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ ko2 f;
        public final /* synthetic */ zn2 g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xn2 a;
            public final /* synthetic */ p b;

            public a(p pVar, xn2 xn2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, xn2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = pVar;
                this.a = xn2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "oldPath");
                    hashMap.put(Integer.valueOf(this.b.d), "newPath");
                    wn2 v = io2.v(this.a, "rename:", this.b.e);
                    p pVar = this.b;
                    if (!io2.a(v, pVar.f, hashMap, pVar.g.b)) {
                        return;
                    }
                    p pVar2 = this.b;
                    io2.b(pVar2.f, pVar2.e);
                }
            }
        }

        public p(zn2 zn2Var, String str, String str2, int i, int i2, Map map, ko2 ko2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, ko2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zn2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = ko2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.u(this.a, this.b, false)));
            }
        }
    }

    public zn2(gj2 gj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gj2Var;
        c();
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            mkdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            rmdirSync(str, false);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return saveFileSync(str, vn2.USER_DATA_PATH);
        }
        return (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("path", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "access:fail parameter error: parameter.path should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("path", J);
        this.c.h(new d(this, I, O, J, ko2Var), "aigamesaccess:", I);
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("srcPath", jsObject);
        int O2 = io2.O("destPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("srcPath", J);
        String I2 = io2.I("destPath", J);
        this.c.h(new b(this, I, I2, O, O2, J, ko2Var), "aigamescopyFile:", I, I2);
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = io2.O("filePath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("filePath", J);
        this.c.h(new f(this, I, O, J, ko2Var), "aigamesgetFileInfo:", I);
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = io2.O("dirPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("dirPath", J);
        this.c.h(new a(this, I, (Boolean) io2.H("recursive", J, Boolean.FALSE), O, J, ko2Var), "aigamesmkdir:", I);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = io2.O("filePath", jsObject);
        int O2 = io2.O(Http2Codec.ENCODING, jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I(Http2Codec.ENCODING, J);
        String I2 = io2.I("filePath", J);
        this.c.h(new o(this, I2, I, O2, O, J, ko2Var), "aigamesreadFile:", I2);
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (!io2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            xn2 q = this.a.q(str, null, true);
            io2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q.h == null) {
                q.h = new byte[0];
            }
            byte[] bArr = q.h;
            return new JsArrayBuffer(bArr, bArr.length);
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = io2.O("dirPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("dirPath", J);
        this.c.h(new m(this, I, O, J, ko2Var), "aigamesreaddir:", I);
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!io2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            xn2 s = this.a.s(str, true);
            io2.d0(this.b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
            if (s != null && s.a == 0) {
                List<String> list = s.c;
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                }
                if (size == 0) {
                    return new String[0];
                }
                return (String[]) s.c.toArray(new String[size]);
            }
            return new String[0];
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = io2.O("filePath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        this.c.h(new h(this, io2.I("filePath", J), O, J, ko2Var), "aigamesremoveSavedFile:", new String[0]);
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("oldPath", jsObject);
        int O2 = io2.O("newPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("oldPath", J);
        String I2 = io2.I("newPath", J);
        this.c.h(new p(this, I, I2, O, O2, J, ko2Var), "aigamesrename:", I, I2);
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = io2.O("dirPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("dirPath", J);
        this.c.h(new n(this, I, (Boolean) io2.H("recursive", J, Boolean.FALSE), O, J, ko2Var), "aigamesrmdir:", I);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("tempFilePath", jsObject);
        int O2 = io2.O("filePath", jsObject);
        if (O2 == 12) {
            i2 = 7;
        } else {
            i2 = O2;
        }
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("tempFilePath", J);
        String I2 = io2.I("filePath", J);
        this.c.h(new l(this, I, I2, O, i2, J, ko2Var), "aigamessaveFile:", I, I2);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("path", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("path", J);
        this.c.h(new e(this, I, O, J, ko2Var), "aigamesstat:", I);
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = io2.O("filePath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("filePath", J);
        this.c.h(new j(this, I, O, J, ko2Var), "aigamesunlink:", I);
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = io2.O("zipFilePath", jsObject);
        int O2 = io2.O("targetPath", jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("zipFilePath", J);
        String I2 = io2.I("targetPath", J);
        this.c.h(new k(this, I, I2, O, O2, J, ko2Var), "aigamesunzip:", I, I2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = io2.O("filePath", jsObject);
        String w = io2.w(io2.O("data", jsObject));
        int O2 = io2.O(Http2Codec.ENCODING, jsObject);
        byte[] r = io2.r(jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("data", J);
        String I2 = io2.I("filePath", J);
        this.c.h(new i(this, I2, I, r, J, w, O2, O, ko2Var), "aigameswriteFile:", I2);
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        ko2 ko2Var;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") || (J = io2.J(this.a, jsObject, (ko2Var = new ko2()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) == null) {
            return;
        }
        this.c.h(new g(this, J, ko2Var), "aigamesgetSavedFileList:", new String[0]);
    }

    @JavascriptInterface
    public eo2 statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (!io2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            xn2 y = this.a.y(str, true);
            io2.d0(this.b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.a != 0) {
                return null;
            }
            return y.d;
        }
        return (eo2) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, str) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) != null) || !io2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = io2.O(Http2Codec.ENCODING, jsObject);
        int O2 = io2.O("filePath", jsObject);
        int O3 = io2.O("data", jsObject);
        if (O3 != 5 && O3 != 2 && O3 != 3) {
            str = io2.w(O3);
        } else {
            str = "fail data argument must not be a number";
        }
        String str2 = str;
        byte[] r = io2.r(jsObject);
        ko2 ko2Var = new ko2();
        Map<String, Object> J = io2.J(this.a, jsObject, ko2Var, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = io2.I("data", J);
        String I2 = io2.I("filePath", J);
        this.c.h(new c(this, I2, I, r, J, str2, O, O2, ko2Var), "aigamesappendFile:", I2);
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jsArrayBuffer) == null) {
            appendFileSync(str, jsArrayBuffer, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            writeFileSync(str, str2, "");
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, jsArrayBuffer, str2) == null) {
            if (jsArrayBuffer == null) {
                str3 = null;
            } else {
                str3 = new String(jsArrayBuffer.buffer());
            }
            appendFileSync(str, str3, str2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, str, jsArrayBuffer, str2) == null) {
            if (jsArrayBuffer == null) {
                str3 = null;
            } else {
                str3 = new String(jsArrayBuffer.buffer());
            }
            writeFileSync(str, str3, str2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            appendFileSync(str, str2, (String) null);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, str3) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048614, this, str, str2, str3) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
    }

    public final void c() {
        bk3 go2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yb3 b0 = yb3.b0();
            if (b0 != null) {
                go2Var = b0.h0();
            } else {
                go2Var = new go2();
            }
            this.a = new ao2(AppRuntime.getAppContext(), lx2.T().z(), go2Var);
            this.c = do2.d();
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, str2) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str, str2);
        io2.d0(this.b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, str, z) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, str, str2) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str, str2);
        io2.d0(this.b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, str, z) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        io2.d0(this.b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        byte[] buffer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, str, jsArrayBuffer) != null) || !io2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ao2 ao2Var = this.a;
        if (jsArrayBuffer == null) {
            buffer = new byte[0];
        } else {
            buffer = jsArrayBuffer.buffer();
        }
        io2.d0(this.b, ao2Var.C(true, str, buffer, null), JSExceptionType.Error, "unknown error", "writeFileSync:");
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (!io2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            xn2 q = this.a.q(str, str2, true);
            io2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
            if (q == null || q.a != 0 || (list = q.c) == null) {
                return null;
            }
            return list.get(0);
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (!io2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str, str2);
            xn2 x = this.a.x(str, str2, true);
            io2.d0(this.b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.a != 0 || (list = x.c) == null) {
                return null;
            }
            return list.get(0);
        }
        return (String) invokeLL.objValue;
    }
}
