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
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes5.dex */
public class mf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nf2 a;
    public ta2 b;
    public qf2 c;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ xf2 e;
        public final /* synthetic */ mf2 f;

        /* renamed from: com.baidu.tieba.mf2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0337a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ a b;

            public RunnableC0337a(a aVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    jf2 v = vf2.v(this.a, "mkdir:", this.b.d);
                    a aVar = this.b;
                    if (vf2.a(v, aVar.e, hashMap, aVar.f.b)) {
                        xf2 xf2Var = this.b.e;
                        xf2Var.errMsg = "mkdir:" + this.a.b;
                        a aVar2 = this.b;
                        vf2.b(aVar2.e, aVar2.d);
                    }
                }
            }
        }

        public a(mf2 mf2Var, String str, Boolean bool, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, bool, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mf2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new RunnableC0337a(this, this.f.a.o(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ xf2 f;
        public final /* synthetic */ mf2 g;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ b b;

            public a(b bVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "srcPath");
                    hashMap.put(Integer.valueOf(this.b.d), "destPath");
                    jf2 v = vf2.v(this.a, "copyFile:", this.b.e);
                    b bVar = this.b;
                    if (vf2.a(v, bVar.f, hashMap, bVar.g.b)) {
                        b bVar2 = this.b;
                        vf2.b(bVar2.f, bVar2.e);
                    }
                }
            }
        }

        public b(mf2 mf2Var, String str, String str2, int i, int i2, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.c(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public final /* synthetic */ xf2 h;
        public final /* synthetic */ mf2 i;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ c b;

            public a(c cVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    jf2 v = vf2.v(this.a, "appendFile:", this.b.d);
                    c cVar = this.b;
                    if (vf2.a(v, cVar.h, hashMap, cVar.i.b)) {
                        c cVar2 = this.b;
                        vf2.b(cVar2.h, cVar2.d);
                    }
                }
            }
        }

        public c(mf2 mf2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf2 b = this.i.a.b(this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, vf2.I("encoding", this.d), false);
                if (!TextUtils.isEmpty(this.e)) {
                    b.b = this.e;
                    b.a = -2;
                    vf2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        b.b = "fail encoding must be a string";
                        b.a = -2;
                        vf2.d(this.i.b, b.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ d b;

            public a(d dVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    jf2 v = vf2.v(this.a, "access:", this.b.c);
                    d dVar = this.b;
                    if (vf2.a(v, dVar.d, hashMap, dVar.e.b)) {
                        d dVar2 = this.b;
                        vf2.b(dVar2.d, dVar2.c);
                    }
                }
            }
        }

        public d(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.a(this.a, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ e b;

            public a(e eVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    jf2 v = vf2.v(this.a, "stat:", this.b.c);
                    e eVar = this.b;
                    if (vf2.a(v, eVar.d, hashMap, eVar.e.b)) {
                        dg2 dg2Var = new dg2();
                        kf2 kf2Var = this.a;
                        dg2Var.stats = kf2Var.d;
                        dg2Var.errMsg = kf2Var.b;
                        vf2.b(dg2Var, this.b.c);
                    }
                }
            }
        }

        public e(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ f b;

            public a(f fVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    jf2 v = vf2.v(this.a, "getFileInfo:", this.b.c);
                    f fVar = this.b;
                    if (vf2.a(v, fVar.d, hashMap, fVar.e.b)) {
                        yf2 yf2Var = new yf2();
                        yf2Var.errMsg = "getFileInfo:" + this.a.b;
                        kf2 kf2Var = this.a;
                        yf2Var.digest = kf2Var.g;
                        yf2Var.size = (int) kf2Var.e;
                        vf2.b(yf2Var, this.b.c);
                    }
                }
            }
        }

        public f(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ xf2 b;
        public final /* synthetic */ mf2 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ g b;

            public a(g gVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    jf2 v = vf2.v(this.a, "getSavedFileList:", this.b.a);
                    g gVar = this.b;
                    if (vf2.a(v, gVar.b, null, gVar.c.b)) {
                        zf2 zf2Var = new zf2();
                        List<lf2> list = this.a.f;
                        int size = list == null ? 0 : list.size();
                        zf2Var.fileList = size == 0 ? new lf2[0] : (lf2[]) this.a.f.toArray(new lf2[size]);
                        g gVar2 = this.b;
                        zf2Var.errMsg = gVar2.b.errMsg;
                        vf2.b(zf2Var, gVar2.a);
                    }
                }
            }
        }

        public g(mf2 mf2Var, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mf2Var;
            this.a = map;
            this.b = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.runOnJSThread(new a(this, this.c.a.i()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ h b;

            public a(h hVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    jf2 v = vf2.v(this.a, "removeSavedFile:", this.b.c);
                    h hVar = this.b;
                    if (vf2.a(v, hVar.d, hashMap, hVar.e.b)) {
                        h hVar2 = this.b;
                        vf2.b(hVar2.d, hVar2.c);
                    }
                }
            }
        }

        public h(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public final /* synthetic */ xf2 h;
        public final /* synthetic */ mf2 i;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ i b;

            public a(i iVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    jf2 v = vf2.v(this.a, "writeFile:", this.b.d);
                    i iVar = this.b;
                    if (vf2.a(v, iVar.h, hashMap, iVar.i.b)) {
                        xf2 xf2Var = this.b.h;
                        xf2Var.errMsg = "writeFile:" + this.a.b;
                        i iVar2 = this.b;
                        vf2.b(iVar2.h, iVar2.d);
                    }
                }
            }
        }

        public i(mf2 mf2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf2 C = this.i.a.C(false, this.a, TextUtils.isEmpty(this.b) ? this.c : this.b, vf2.I("encoding", this.d));
                if (!TextUtils.isEmpty(this.e)) {
                    C.b = this.e;
                    C.a = -2;
                    vf2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        C.b = "fail encoding must be a string";
                        C.a = -2;
                        vf2.d(this.i.b, C.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ j b;

            public a(j jVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    jf2 v = vf2.v(this.a, "unlink:", this.b.c);
                    j jVar = this.b;
                    if (vf2.a(v, jVar.d, hashMap, jVar.e.b)) {
                        xf2 xf2Var = this.b.d;
                        xf2Var.errMsg = "unlink:" + this.a.b;
                        j jVar2 = this.b;
                        vf2.b(jVar2.d, jVar2.c);
                    }
                }
            }
        }

        public j(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ xf2 f;
        public final /* synthetic */ mf2 g;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ k b;

            public a(k kVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "targetPath");
                    jf2 v = vf2.v(this.a, "unzip:", this.b.e);
                    k kVar = this.b;
                    if (vf2.a(v, kVar.f, hashMap, kVar.g.b)) {
                        xf2 xf2Var = this.b.f;
                        xf2Var.errMsg = "unzip:" + this.a.b;
                        k kVar2 = this.b;
                        vf2.b(kVar2.f, kVar2.e);
                    }
                }
            }
        }

        public k(mf2 mf2Var, String str, String str2, int i, int i2, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.A(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ xf2 f;
        public final /* synthetic */ mf2 g;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ l b;

            public a(l lVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    jf2 v = vf2.v(this.a, "saveFile:", this.b.e);
                    l lVar = this.b;
                    if (vf2.a(v, lVar.f, hashMap, lVar.g.b)) {
                        cg2 cg2Var = new cg2();
                        List<String> list = this.a.c;
                        cg2Var.savedFilePath = list != null ? list.get(0) : null;
                        cg2Var.errMsg = this.a.b;
                        vf2.b(cg2Var, this.b.e);
                    }
                }
            }
        }

        public l(mf2 mf2Var, String str, String str2, int i, int i2, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.x(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ xf2 d;
        public final /* synthetic */ mf2 e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ m b;

            public a(m mVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "dirPath");
                    jf2 v = vf2.v(this.a, "readdir:", this.b.c);
                    m mVar = this.b;
                    if (vf2.a(v, mVar.d, hashMap, mVar.e.b)) {
                        ag2 ag2Var = new ag2();
                        List<String> list = this.a.c;
                        int size = list == null ? 0 : list.size();
                        ag2Var.files = size == 0 ? new String[0] : (String[]) this.a.c.toArray(new String[size]);
                        ag2Var.errMsg = this.a.b;
                        vf2.b(ag2Var, this.b.c);
                    }
                }
            }
        }

        public m(mf2 mf2Var, String str, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mf2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ xf2 e;
        public final /* synthetic */ mf2 f;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ n b;

            public a(n nVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    jf2 v = vf2.v(this.a, "rmdir:", this.b.d);
                    n nVar = this.b;
                    if (vf2.a(v, nVar.e, hashMap, nVar.f.b)) {
                        n nVar2 = this.b;
                        vf2.b(nVar2.e, nVar2.d);
                    }
                }
            }
        }

        public n(mf2 mf2Var, String str, Boolean bool, int i, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, bool, Integer.valueOf(i), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mf2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new a(this, this.f.a.v(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ xf2 f;
        public final /* synthetic */ mf2 g;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ o b;

            public a(o oVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    jf2 v = vf2.v(this.a, "readFile:", this.b.e);
                    o oVar = this.b;
                    if (vf2.a(v, oVar.f, hashMap, oVar.g.b)) {
                        if (TextUtils.isEmpty(this.b.b)) {
                            wf2 wf2Var = new wf2();
                            kf2 kf2Var = this.a;
                            if (kf2Var.h == null) {
                                kf2Var.h = new byte[0];
                            }
                            byte[] bArr = this.a.h;
                            wf2Var.data = new JsArrayBuffer(bArr, bArr.length);
                            wf2Var.errMsg = this.a.b;
                            vf2.b(wf2Var, this.b.e);
                            return;
                        }
                        List<String> list = this.a.c;
                        String str = list != null ? list.get(0) : null;
                        bg2 bg2Var = new bg2();
                        bg2Var.data = str;
                        bg2Var.errMsg = this.a.b;
                        vf2.b(bg2Var, this.b.e);
                    }
                }
            }
        }

        public o(mf2 mf2Var, String str, String str2, int i, int i2, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kf2 q = this.g.a.q(this.a, this.b, false);
                int i = this.c;
                if (i != 7 && i != 12) {
                    q.b = "fail encoding must be a string";
                    q.a = -2;
                    vf2.d(this.g.b, q.b);
                }
                this.g.b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ xf2 f;
        public final /* synthetic */ mf2 g;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kf2 a;
            public final /* synthetic */ p b;

            public a(p pVar, kf2 kf2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, kf2Var};
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
                this.a = kf2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "oldPath");
                    hashMap.put(Integer.valueOf(this.b.d), "newPath");
                    jf2 v = vf2.v(this.a, "rename:", this.b.e);
                    p pVar = this.b;
                    if (vf2.a(v, pVar.f, hashMap, pVar.g.b)) {
                        p pVar2 = this.b;
                        vf2.b(pVar2.f, pVar2.e);
                    }
                }
            }
        }

        public p(mf2 mf2Var, String str, String str2, int i, int i2, Map map, xf2 xf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, xf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = mf2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = xf2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.u(this.a, this.b, false)));
            }
        }
    }

    public mf2(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ta2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ta2Var;
        c();
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("path", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "access:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("path", J);
            this.c.h(new d(this, I, O, J, xf2Var), "aigamesaccess:", I);
        }
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
        }
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = vf2.O("encoding", jsObject);
            int O2 = vf2.O("filePath", jsObject);
            int O3 = vf2.O("data", jsObject);
            String w = (O3 == 5 || O3 == 2 || O3 == 3) ? "fail data argument must not be a number" : vf2.w(O3);
            byte[] r = vf2.r(jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("data", J);
            String I2 = vf2.I("filePath", J);
            this.c.h(new c(this, I2, I, r, J, w, O, O2, xf2Var), "aigamesappendFile:", I2);
        }
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
        }
    }

    public final void c() {
        ob3 tf2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l33 b0 = l33.b0();
            if (b0 != null) {
                tf2Var = b0.h0();
            } else {
                tf2Var = new tf2();
            }
            this.a = new nf2(AppRuntime.getAppContext(), yo2.U().z(), tf2Var);
            this.c = qf2.d();
        }
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("srcPath", jsObject);
            int O2 = vf2.O("destPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("srcPath", J);
            String I2 = vf2.I("destPath", J);
            this.c.h(new b(this, I, I2, O, O2, J, xf2Var), "aigamescopyFile:", I, I2);
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            vf2.d0(this.b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
        }
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = vf2.O("filePath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("filePath", J);
            this.c.h(new f(this, I, O, J, xf2Var), "aigamesgetFileInfo:", I);
        }
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        xf2 xf2Var;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") && (J = vf2.J(this.a, jsObject, (xf2Var = new xf2()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) != null) {
            this.c.h(new g(this, J, xf2Var), "aigamesgetSavedFileList:", new String[0]);
        }
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = vf2.O("dirPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("dirPath", J);
            this.c.h(new a(this, I, (Boolean) vf2.H("recursive", J, Boolean.FALSE), O, J, xf2Var), "aigamesmkdir:", I);
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            mkdirSync(str, false);
        }
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = vf2.O("filePath", jsObject);
            int O2 = vf2.O("encoding", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("encoding", J);
            String I2 = vf2.I("filePath", J);
            this.c.h(new o(this, I2, I, O2, O, J, xf2Var), "aigamesreadFile:", I2);
        }
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (vf2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                kf2 q = this.a.q(str, str2, true);
                vf2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q == null || q.a != 0 || (list = q.c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void readdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = vf2.O("dirPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("dirPath", J);
            this.c.h(new m(this, I, O, J, xf2Var), "aigamesreaddir:", I);
        }
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (vf2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                kf2 s = this.a.s(str, true);
                vf2.d0(this.b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
                if (s == null || s.a != 0) {
                    return new String[0];
                }
                List<String> list = s.c;
                int size = list == null ? 0 : list.size();
                return size == 0 ? new String[0] : (String[]) s.c.toArray(new String[size]);
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    @JavascriptInterface
    public void removeSavedFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = vf2.O("filePath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            this.c.h(new h(this, vf2.I("filePath", J), O, J, xf2Var), "aigamesremoveSavedFile:", new String[0]);
        }
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("oldPath", jsObject);
            int O2 = vf2.O("newPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("oldPath", J);
            String I2 = vf2.I("newPath", J);
            this.c.h(new p(this, I, I2, O, O2, J, xf2Var), "aigamesrename:", I, I2);
        }
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str, str2);
            vf2.d0(this.b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
        }
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = vf2.O("dirPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("dirPath", J);
            this.c.h(new n(this, I, (Boolean) vf2.H("recursive", J, Boolean.FALSE), O, J, xf2Var), "aigamesrmdir:", I);
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
    public void saveFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("tempFilePath", jsObject);
            int O2 = vf2.O("filePath", jsObject);
            int i2 = O2 == 12 ? 7 : O2;
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("tempFilePath", J);
            String I2 = vf2.I("filePath", J);
            this.c.h(new l(this, I, I2, O, i2, J, xf2Var), "aigamessaveFile:", I, I2);
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) ? saveFileSync(str, if2.USER_DATA_PATH) : (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("path", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("path", J);
            this.c.h(new e(this, I, O, J, xf2Var), "aigamesstat:", I);
        }
    }

    @JavascriptInterface
    public rf2 statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (vf2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                kf2 y = this.a.y(str, true);
                vf2.d0(this.b, y, JSExceptionType.Error, "unknown error", "statSync:");
                if (y == null || y.a != 0) {
                    return null;
                }
                return y.d;
            }
            return null;
        }
        return (rf2) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            int O = vf2.O("filePath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("filePath", J);
            this.c.h(new j(this, I, O, J, xf2Var), "aigamesunlink:", I);
        }
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
        }
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            int O = vf2.O("zipFilePath", jsObject);
            int O2 = vf2.O("targetPath", jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("zipFilePath", J);
            String I2 = vf2.I("targetPath", J);
            this.c.h(new k(this, I, I2, O, O2, J, xf2Var), "aigamesunzip:", I, I2);
        }
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, jsObject) == null) && vf2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            int O = vf2.O("filePath", jsObject);
            String w = vf2.w(vf2.O("data", jsObject));
            int O2 = vf2.O("encoding", jsObject);
            byte[] r = vf2.r(jsObject);
            xf2 xf2Var = new xf2();
            Map<String, Object> J = vf2.J(this.a, jsObject, xf2Var, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (J == null) {
                return;
            }
            String I = vf2.I("data", J);
            String I2 = vf2.I("filePath", J);
            this.c.h(new i(this, I2, I, r, J, w, O2, O, xf2Var), "aigameswriteFile:", I2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, str3) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
        }
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
        }
    }

    @JavascriptInterface
    public String saveFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            if (vf2.T(this.a, this.b, null, null)) {
                this.c.k(str, str2);
                kf2 x = this.a.x(str, str2, true);
                vf2.d0(this.b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
                if (x == null || x.a != 0 || (list = x.c) == null) {
                    return null;
                }
                return list.get(0);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            appendFileSync(str, str2, (String) null);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, jsArrayBuffer, str2) == null) {
            appendFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, str, jsArrayBuffer) == null) && vf2.T(this.a, this.b, null, null)) {
            this.c.k(str);
            vf2.d0(this.b, this.a.C(true, str, jsArrayBuffer == null ? new byte[0] : jsArrayBuffer.buffer(), null), JSExceptionType.Error, "unknown error", "writeFileSync:");
        }
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (vf2.T(this.a, this.b, null, null)) {
                this.c.k(str);
                kf2 q = this.a.q(str, null, true);
                vf2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
                if (q.h == null) {
                    q.h = new byte[0];
                }
                byte[] bArr = q.h;
                return new JsArrayBuffer(bArr, bArr.length);
            }
            return null;
        }
        return (JsArrayBuffer) invokeL.objValue;
    }

    @JavascriptInterface
    public void appendFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jsArrayBuffer) == null) {
            appendFileSync(str, jsArrayBuffer, (String) null);
        }
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, str, jsArrayBuffer, str2) == null) {
            writeFileSync(str, jsArrayBuffer == null ? null : new String(jsArrayBuffer.buffer()), str2);
        }
    }
}
