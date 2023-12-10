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
/* loaded from: classes7.dex */
public class li2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mi2 a;
    public sd2 b;
    public pi2 c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ wi2 e;
        public final /* synthetic */ li2 f;

        /* renamed from: com.baidu.tieba.li2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0387a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ a b;

            public RunnableC0387a(a aVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    ii2 v = ui2.v(this.a, "mkdir:", this.b.d);
                    a aVar = this.b;
                    if (!ui2.a(v, aVar.e, hashMap, aVar.f.b)) {
                        return;
                    }
                    wi2 wi2Var = this.b.e;
                    wi2Var.errMsg = "mkdir:" + this.a.b;
                    a aVar2 = this.b;
                    ui2.b(aVar2.e, aVar2.d);
                }
            }
        }

        public a(li2 li2Var, String str, Boolean bool, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, bool, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = li2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new RunnableC0387a(this, this.f.a.o(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ wi2 f;
        public final /* synthetic */ li2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ b b;

            public a(b bVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "srcPath");
                    hashMap.put(Integer.valueOf(this.b.d), "destPath");
                    ii2 v = ui2.v(this.a, "copyFile:", this.b.e);
                    b bVar = this.b;
                    if (!ui2.a(v, bVar.f, hashMap, bVar.g.b)) {
                        return;
                    }
                    b bVar2 = this.b;
                    ui2.b(bVar2.f, bVar2.e);
                }
            }
        }

        public b(li2 li2Var, String str, String str2, int i, int i2, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = li2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.c(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public final /* synthetic */ wi2 h;
        public final /* synthetic */ li2 i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ c b;

            public a(c cVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    ii2 v = ui2.v(this.a, "appendFile:", this.b.d);
                    c cVar = this.b;
                    if (!ui2.a(v, cVar.h, hashMap, cVar.i.b)) {
                        return;
                    }
                    c cVar2 = this.b;
                    ui2.b(cVar2.h, cVar2.d);
                }
            }
        }

        public c(li2 li2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = li2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mi2 mi2Var = this.i.a;
                String str = this.a;
                if (TextUtils.isEmpty(this.b)) {
                    obj = this.c;
                } else {
                    obj = this.b;
                }
                ji2 b = mi2Var.b(str, obj, ui2.I(Http2Codec.ENCODING, this.d), false);
                if (!TextUtils.isEmpty(this.e)) {
                    b.b = this.e;
                    b.a = -2;
                    ui2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        b.b = "fail encoding must be a string";
                        b.a = -2;
                        ui2.d(this.i.b, b.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ d b;

            public a(d dVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    ii2 v = ui2.v(this.a, "access:", this.b.c);
                    d dVar = this.b;
                    if (!ui2.a(v, dVar.d, hashMap, dVar.e.b)) {
                        return;
                    }
                    d dVar2 = this.b;
                    ui2.b(dVar2.d, dVar2.c);
                }
            }
        }

        public d(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.a(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ e b;

            public a(e eVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "path");
                    ii2 v = ui2.v(this.a, "stat:", this.b.c);
                    e eVar = this.b;
                    if (!ui2.a(v, eVar.d, hashMap, eVar.e.b)) {
                        return;
                    }
                    cj2 cj2Var = new cj2();
                    ji2 ji2Var = this.a;
                    cj2Var.stats = ji2Var.d;
                    cj2Var.errMsg = ji2Var.b;
                    ui2.b(cj2Var, this.b.c);
                }
            }
        }

        public e(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.y(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ f b;

            public a(f fVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    ii2 v = ui2.v(this.a, "getFileInfo:", this.b.c);
                    f fVar = this.b;
                    if (!ui2.a(v, fVar.d, hashMap, fVar.e.b)) {
                        return;
                    }
                    xi2 xi2Var = new xi2();
                    xi2Var.errMsg = "getFileInfo:" + this.a.b;
                    ji2 ji2Var = this.a;
                    xi2Var.digest = ji2Var.g;
                    xi2Var.size = (int) ji2Var.e;
                    ui2.b(xi2Var, this.b.c);
                }
            }
        }

        public f(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.e(this.a)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ wi2 b;
        public final /* synthetic */ li2 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ g b;

            public a(g gVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size;
                ki2[] ki2VarArr;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ii2 v = ui2.v(this.a, "getSavedFileList:", this.b.a);
                    g gVar = this.b;
                    if (!ui2.a(v, gVar.b, null, gVar.c.b)) {
                        return;
                    }
                    yi2 yi2Var = new yi2();
                    List<ki2> list = this.a.f;
                    if (list == null) {
                        size = 0;
                    } else {
                        size = list.size();
                    }
                    if (size == 0) {
                        ki2VarArr = new ki2[0];
                    } else {
                        ki2VarArr = (ki2[]) this.a.f.toArray(new ki2[size]);
                    }
                    yi2Var.fileList = ki2VarArr;
                    g gVar2 = this.b;
                    yi2Var.errMsg = gVar2.b.errMsg;
                    ui2.b(yi2Var, gVar2.a);
                }
            }
        }

        public g(li2 li2Var, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = li2Var;
            this.a = map;
            this.b = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.runOnJSThread(new a(this, this.c.a.i()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ h b;

            public a(h hVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    ii2 v = ui2.v(this.a, "removeSavedFile:", this.b.c);
                    h hVar = this.b;
                    if (!ui2.a(v, hVar.d, hashMap, hVar.e.b)) {
                        return;
                    }
                    h hVar2 = this.b;
                    ui2.b(hVar2.d, hVar2.c);
                }
            }
        }

        public h(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.t(this.a)));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public final /* synthetic */ wi2 h;
        public final /* synthetic */ li2 i;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ i b;

            public a(i iVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.g), "filePath");
                    ii2 v = ui2.v(this.a, "writeFile:", this.b.d);
                    i iVar = this.b;
                    if (!ui2.a(v, iVar.h, hashMap, iVar.i.b)) {
                        return;
                    }
                    wi2 wi2Var = this.b.h;
                    wi2Var.errMsg = "writeFile:" + this.a.b;
                    i iVar2 = this.b;
                    ui2.b(iVar2.h, iVar2.d);
                }
            }
        }

        public i(li2 li2Var, String str, String str2, byte[] bArr, Map map, String str3, int i, int i2, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, bArr, map, str3, Integer.valueOf(i), Integer.valueOf(i2), wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = li2Var;
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = map;
            this.e = str3;
            this.f = i;
            this.g = i2;
            this.h = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mi2 mi2Var = this.i.a;
                String str = this.a;
                if (TextUtils.isEmpty(this.b)) {
                    obj = this.c;
                } else {
                    obj = this.b;
                }
                ji2 C = mi2Var.C(false, str, obj, ui2.I(Http2Codec.ENCODING, this.d));
                if (!TextUtils.isEmpty(this.e)) {
                    C.b = this.e;
                    C.a = -2;
                    ui2.d(this.i.b, this.e);
                } else {
                    int i = this.f;
                    if (i != 7 && i != 12) {
                        C.b = "fail encoding must be a string";
                        C.a = -2;
                        ui2.d(this.i.b, C.b);
                    }
                }
                this.i.b.runOnJSThread(new a(this, C));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ j b;

            public a(j jVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "filePath");
                    ii2 v = ui2.v(this.a, "unlink:", this.b.c);
                    j jVar = this.b;
                    if (!ui2.a(v, jVar.d, hashMap, jVar.e.b)) {
                        return;
                    }
                    wi2 wi2Var = this.b.d;
                    wi2Var.errMsg = "unlink:" + this.a.b;
                    j jVar2 = this.b;
                    ui2.b(jVar2.d, jVar2.c);
                }
            }
        }

        public j(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.z(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ wi2 f;
        public final /* synthetic */ li2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ k b;

            public a(k kVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "zipFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "targetPath");
                    ii2 v = ui2.v(this.a, "unzip:", this.b.e);
                    k kVar = this.b;
                    if (!ui2.a(v, kVar.f, hashMap, kVar.g.b)) {
                        return;
                    }
                    wi2 wi2Var = this.b.f;
                    wi2Var.errMsg = "unzip:" + this.a.b;
                    k kVar2 = this.b;
                    ui2.b(kVar2.f, kVar2.e);
                }
            }
        }

        public k(li2 li2Var, String str, String str2, int i, int i2, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = li2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.A(this.a, this.b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ wi2 f;
        public final /* synthetic */ li2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ l b;

            public a(l lVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "tempFilePath");
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    ii2 v = ui2.v(this.a, "saveFile:", this.b.e);
                    l lVar = this.b;
                    if (!ui2.a(v, lVar.f, hashMap, lVar.g.b)) {
                        return;
                    }
                    bj2 bj2Var = new bj2();
                    List<String> list = this.a.c;
                    if (list != null) {
                        str = list.get(0);
                    } else {
                        str = null;
                    }
                    bj2Var.savedFilePath = str;
                    bj2Var.errMsg = this.a.b;
                    ui2.b(bj2Var, this.b.e);
                }
            }
        }

        public l(li2 li2Var, String str, String str2, int i, int i2, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = li2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.x(this.a, this.b, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ wi2 d;
        public final /* synthetic */ li2 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ m b;

            public a(m mVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size;
                String[] strArr;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.b), "dirPath");
                    ii2 v = ui2.v(this.a, "readdir:", this.b.c);
                    m mVar = this.b;
                    if (!ui2.a(v, mVar.d, hashMap, mVar.e.b)) {
                        return;
                    }
                    zi2 zi2Var = new zi2();
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
                    zi2Var.files = strArr;
                    zi2Var.errMsg = this.a.b;
                    ui2.b(zi2Var, this.b.c);
                }
            }
        }

        public m(li2 li2Var, String str, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = li2Var;
            this.a = str;
            this.b = i;
            this.c = map;
            this.d = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.b.runOnJSThread(new a(this, this.e.a.s(this.a, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ wi2 e;
        public final /* synthetic */ li2 f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ n b;

            public a(n nVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "dirPath");
                    ii2 v = ui2.v(this.a, "rmdir:", this.b.d);
                    n nVar = this.b;
                    if (!ui2.a(v, nVar.e, hashMap, nVar.f.b)) {
                        return;
                    }
                    n nVar2 = this.b;
                    ui2.b(nVar2.e, nVar2.d);
                }
            }
        }

        public n(li2 li2Var, String str, Boolean bool, int i, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, bool, Integer.valueOf(i), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = li2Var;
            this.a = str;
            this.b = bool;
            this.c = i;
            this.d = map;
            this.e = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.b.runOnJSThread(new a(this, this.f.a.v(this.a, this.b.booleanValue(), false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ wi2 f;
        public final /* synthetic */ li2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ o b;

            public a(o oVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.d), "filePath");
                    ii2 v = ui2.v(this.a, "readFile:", this.b.e);
                    o oVar = this.b;
                    if (!ui2.a(v, oVar.f, hashMap, oVar.g.b)) {
                        return;
                    }
                    if (TextUtils.isEmpty(this.b.b)) {
                        vi2 vi2Var = new vi2();
                        ji2 ji2Var = this.a;
                        if (ji2Var.h == null) {
                            ji2Var.h = new byte[0];
                        }
                        byte[] bArr = this.a.h;
                        vi2Var.data = new JsArrayBuffer(bArr, bArr.length);
                        vi2Var.errMsg = this.a.b;
                        ui2.b(vi2Var, this.b.e);
                        return;
                    }
                    List<String> list = this.a.c;
                    if (list != null) {
                        str = list.get(0);
                    } else {
                        str = null;
                    }
                    aj2 aj2Var = new aj2();
                    aj2Var.data = str;
                    aj2Var.errMsg = this.a.b;
                    ui2.b(aj2Var, this.b.e);
                }
            }
        }

        public o(li2 li2Var, String str, String str2, int i, int i2, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = li2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji2 q = this.g.a.q(this.a, this.b, false);
                int i = this.c;
                if (i != 7 && i != 12) {
                    q.b = "fail encoding must be a string";
                    q.a = -2;
                    ui2.d(this.g.b, q.b);
                }
                this.g.b.runOnJSThread(new a(this, q));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ wi2 f;
        public final /* synthetic */ li2 g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ji2 a;
            public final /* synthetic */ p b;

            public a(p pVar, ji2 ji2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar, ji2Var};
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
                this.a = ji2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(this.b.c), "oldPath");
                    hashMap.put(Integer.valueOf(this.b.d), "newPath");
                    ii2 v = ui2.v(this.a, "rename:", this.b.e);
                    p pVar = this.b;
                    if (!ui2.a(v, pVar.f, hashMap, pVar.g.b)) {
                        return;
                    }
                    p pVar2 = this.b;
                    ui2.b(pVar2.f, pVar2.e);
                }
            }
        }

        public p(li2 li2Var, String str, String str2, int i, int i2, Map map, wi2 wi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li2Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), map, wi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = li2Var;
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = map;
            this.f = wi2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.g.b.runOnJSThread(new a(this, this.g.a.u(this.a, this.b, false)));
            }
        }
    }

    public li2(sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sd2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = sd2Var;
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
            return saveFileSync(str, hi2.USER_DATA_PATH);
        }
        return (String) invokeL.objValue;
    }

    @JavascriptInterface
    public void access(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("path", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "access:fail parameter error: parameter.path should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("path", J);
        this.c.h(new d(this, I, O, J, wi2Var), "aigamesaccess:", I);
    }

    @JavascriptInterface
    public void copyFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("srcPath", jsObject);
        int O2 = ui2.O("destPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "copyFile:fail parameter error: parameter.srcPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("srcPath", J);
        String I2 = ui2.I("destPath", J);
        this.c.h(new b(this, I, I2, O, O2, J, wi2Var), "aigamescopyFile:", I, I2);
    }

    @JavascriptInterface
    public void getFileInfo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = ui2.O("filePath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "getFileInfo:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("filePath", J);
        this.c.h(new f(this, I, O, J, wi2Var), "aigamesgetFileInfo:", I);
    }

    @JavascriptInterface
    public void mkdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = ui2.O("dirPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "mkdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("dirPath", J);
        this.c.h(new a(this, I, (Boolean) ui2.H("recursive", J, Boolean.FALSE), O, J, wi2Var), "aigamesmkdir:", I);
    }

    @JavascriptInterface
    public void readFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = ui2.O("filePath", jsObject);
        int O2 = ui2.O(Http2Codec.ENCODING, jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "readFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I(Http2Codec.ENCODING, J);
        String I2 = ui2.I("filePath", J);
        this.c.h(new o(this, I2, I, O2, O, J, wi2Var), "aigamesreadFile:", I2);
    }

    @JavascriptInterface
    public JsArrayBuffer readFileSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (!ui2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            ji2 q = this.a.q(str, null, true);
            ui2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
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
        if ((interceptable != null && interceptable.invokeL(1048594, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = ui2.O("dirPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "readdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("dirPath", J);
        this.c.h(new m(this, I, O, J, wi2Var), "aigamesreaddir:", I);
    }

    @JavascriptInterface
    public String[] readdirSync(String str) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!ui2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            ji2 s = this.a.s(str, true);
            ui2.d0(this.b, s, JSExceptionType.Error, "unknown error", "readdirSync:");
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
        if ((interceptable != null && interceptable.invokeL(1048596, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = ui2.O("filePath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "removeSavedFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        this.c.h(new h(this, ui2.I("filePath", J), O, J, wi2Var), "aigamesremoveSavedFile:", new String[0]);
    }

    @JavascriptInterface
    public void rename(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("oldPath", jsObject);
        int O2 = ui2.O("newPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "rename:fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("oldPath", J);
        String I2 = ui2.I("newPath", J);
        this.c.h(new p(this, I, I2, O, O2, J, wi2Var), "aigamesrename:", I, I2);
    }

    @JavascriptInterface
    public void rmdir(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = ui2.O("dirPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "rmdir:fail parameter error: parameter.dirPath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("dirPath", J);
        this.c.h(new n(this, I, (Boolean) ui2.H("recursive", J, Boolean.FALSE), O, J, wi2Var), "aigamesrmdir:", I);
    }

    @JavascriptInterface
    public void saveFile(JsObject jsObject) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("tempFilePath", jsObject);
        int O2 = ui2.O("filePath", jsObject);
        if (O2 == 12) {
            i2 = 7;
        } else {
            i2 = O2;
        }
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "saveFile:fail parameter error: parameter.tempFilePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("tempFilePath", J);
        String I2 = ui2.I("filePath", J);
        this.c.h(new l(this, I, I2, O, i2, J, wi2Var), "aigamessaveFile:", I, I2);
    }

    @JavascriptInterface
    public void stat(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("path", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "stat:fail parameter error: parameter.path should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("path", J);
        this.c.h(new e(this, I, O, J, wi2Var), "aigamesstat:", I);
    }

    @JavascriptInterface
    public void unlink(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = ui2.O("filePath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "unlink:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("filePath", J);
        this.c.h(new j(this, I, O, J, wi2Var), "aigamesunlink:", I);
    }

    @JavascriptInterface
    public void unzip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.path should be String instead of ")) {
            return;
        }
        int O = ui2.O("zipFilePath", jsObject);
        int O2 = ui2.O("targetPath", jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "unzip:fail parameter error: parameter.zipFilePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("zipFilePath", J);
        String I2 = ui2.I("targetPath", J);
        this.c.h(new k(this, I, I2, O, O2, J, wi2Var), "aigamesunzip:", I, I2);
    }

    @JavascriptInterface
    public void writeFile(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.dirPath should be String instead of ")) {
            return;
        }
        int O = ui2.O("filePath", jsObject);
        String w = ui2.w(ui2.O("data", jsObject));
        int O2 = ui2.O(Http2Codec.ENCODING, jsObject);
        byte[] r = ui2.r(jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "writeFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("data", J);
        String I2 = ui2.I("filePath", J);
        this.c.h(new i(this, I2, I, r, J, w, O2, O, wi2Var), "aigameswriteFile:", I2);
    }

    @JavascriptInterface
    public void accessSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.a(str, true), JSExceptionType.Error, "unknown error", "accessSync:");
    }

    @JavascriptInterface
    public void getSavedFileList(JsObject jsObject) {
        wi2 wi2Var;
        Map<String, Object> J;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ") || (J = ui2.J(this.a, jsObject, (wi2Var = new wi2()), "getSavedFileList:fail parameter error: parameter.filePath should be String instead of Undefined;")) == null) {
            return;
        }
        this.c.h(new g(this, J, wi2Var), "aigamesgetSavedFileList:", new String[0]);
    }

    @JavascriptInterface
    public qi2 statSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (!ui2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            ji2 y = this.a.y(str, true);
            ui2.d0(this.b, y, JSExceptionType.Error, "unknown error", "statSync:");
            if (y == null || y.a != 0) {
                return null;
            }
            return y.d;
        }
        return (qi2) invokeL.objValue;
    }

    @JavascriptInterface
    public void unlinkSync(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, str) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.z(str, true), JSExceptionType.Error, "unknown error", "unlinkSync:");
    }

    @JavascriptInterface
    public void appendFile(JsObject jsObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) != null) || !ui2.T(this.a, this.b, jsObject, "fail parameter error: parameter.filePath should be String instead of ")) {
            return;
        }
        int O = ui2.O(Http2Codec.ENCODING, jsObject);
        int O2 = ui2.O("filePath", jsObject);
        int O3 = ui2.O("data", jsObject);
        if (O3 != 5 && O3 != 2 && O3 != 3) {
            str = ui2.w(O3);
        } else {
            str = "fail data argument must not be a number";
        }
        String str2 = str;
        byte[] r = ui2.r(jsObject);
        wi2 wi2Var = new wi2();
        Map<String, Object> J = ui2.J(this.a, jsObject, wi2Var, "appendFile:fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (J == null) {
            return;
        }
        String I = ui2.I("data", J);
        String I2 = ui2.I("filePath", J);
        this.c.h(new c(this, I2, I, r, J, str2, O, O2, wi2Var), "aigamesappendFile:", I2);
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
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, str3) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.b(str, str2, str3, true), JSExceptionType.Error, "unknown error", "appendFileSync:");
    }

    @JavascriptInterface
    public void writeFileSync(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048614, this, str, str2, str3) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.C(true, str, str2, str3), JSExceptionType.Error, "unknown error", "writeFileSync:");
    }

    public final void c() {
        ne3 si2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k63 c0 = k63.c0();
            if (c0 != null) {
                si2Var = c0.i0();
            } else {
                si2Var = new si2();
            }
            this.a = new mi2(AppRuntime.getAppContext(), xr2.V().A(), si2Var);
            this.c = pi2.d();
        }
    }

    @JavascriptInterface
    public void copyFileSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, str2) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str, str2);
        ui2.d0(this.b, this.a.c(str, str2, true), JSExceptionType.Error, "unknown error", "copyFileSync:");
    }

    @JavascriptInterface
    public void mkdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, str, z) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.o(str, z, true), JSExceptionType.Error, "unknown error", "mkdirSync:");
    }

    @JavascriptInterface
    public void renameSync(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, str, str2) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str, str2);
        ui2.d0(this.b, this.a.u(str, str2, true), JSExceptionType.Error, "unknown error", "renameSync:");
    }

    @JavascriptInterface
    public void rmdirSync(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, str, z) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        ui2.d0(this.b, this.a.v(str, z, true), JSExceptionType.Error, "unknown error", "rmdirSync:");
    }

    @JavascriptInterface
    public void writeFileSync(String str, JsArrayBuffer jsArrayBuffer) {
        byte[] buffer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, str, jsArrayBuffer) != null) || !ui2.T(this.a, this.b, null, null)) {
            return;
        }
        this.c.k(str);
        mi2 mi2Var = this.a;
        if (jsArrayBuffer == null) {
            buffer = new byte[0];
        } else {
            buffer = jsArrayBuffer.buffer();
        }
        ui2.d0(this.b, mi2Var.C(true, str, buffer, null), JSExceptionType.Error, "unknown error", "writeFileSync:");
    }

    @JavascriptInterface
    public String readFileSync(String str, String str2) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            if (!ui2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str);
            ji2 q = this.a.q(str, str2, true);
            ui2.d0(this.b, q, JSExceptionType.Error, "unknown error", "readFileSync:");
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
            if (!ui2.T(this.a, this.b, null, null)) {
                return null;
            }
            this.c.k(str, str2);
            ji2 x = this.a.x(str, str2, true);
            ui2.d0(this.b, x, JSExceptionType.Error, "unknown error", "saveFileSync:");
            if (x == null || x.a != 0 || (list = x.c) == null) {
                return null;
            }
            return list.get(0);
        }
        return (String) invokeLL.objValue;
    }
}
