package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h7;
import com.baidu.tieba.k6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class l3 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h7<Texture> a;
    public final k6<a> b;

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final k6<p> a;
        public final k6<q> b;

        /* loaded from: classes5.dex */
        public interface o<T> {
            void a(T t);
        }

        /* loaded from: classes5.dex */
        public class a implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public a(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.i = Integer.parseInt(this.a[1]);
                    qVar.j = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public b(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.g = Integer.parseInt(this.a[1]);
                    qVar.h = Integer.parseInt(this.a[2]);
                    qVar.i = Integer.parseInt(this.a[3]);
                    qVar.j = Integer.parseInt(this.a[4]);
                }
            }
        }

        /* renamed from: com.baidu.tieba.l3$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0331c implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public C0331c(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    boolean z = true;
                    String str = this.a[1];
                    if (str.equals("true")) {
                        qVar.k = 90;
                    } else if (!str.equals("false")) {
                        qVar.k = Integer.parseInt(str);
                    }
                    if (qVar.k != 90) {
                        z = false;
                    }
                    qVar.l = z;
                }
            }
        }

        /* loaded from: classes5.dex */
        public class d implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;
            public final /* synthetic */ boolean[] b;

            public d(c cVar, String[] strArr, boolean[] zArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr, zArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
                this.b = zArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    int parseInt = Integer.parseInt(this.a[1]);
                    qVar.m = parseInt;
                    if (parseInt != -1) {
                        this.b[0] = true;
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class e implements Comparator<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(q qVar, q qVar2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, qVar2)) == null) {
                    int i = qVar.m;
                    int i2 = Integer.MAX_VALUE;
                    if (i == -1) {
                        i = Integer.MAX_VALUE;
                    }
                    int i3 = qVar2.m;
                    if (i3 != -1) {
                        i2 = i3;
                    }
                    return i - i2;
                }
                return invokeLL.intValue;
            }
        }

        /* loaded from: classes5.dex */
        public class f implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public f(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.c = Integer.parseInt(this.a[1]);
                    pVar.d = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class g implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public g(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.f = Pixmap.Format.valueOf(this.a[1]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class h implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public h(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.g = Texture.TextureFilter.valueOf(this.a[1]);
                    pVar.h = Texture.TextureFilter.valueOf(this.a[2]);
                    pVar.e = pVar.g.isMipMap();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class i implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public i(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    if (this.a[1].indexOf(120) != -1) {
                        pVar.i = Texture.TextureWrap.Repeat;
                    }
                    if (this.a[1].indexOf(121) != -1) {
                        pVar.j = Texture.TextureWrap.Repeat;
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class j implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public j(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.k = this.a[1].equals("true");
                }
            }
        }

        /* loaded from: classes5.dex */
        public class k implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public k(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.c = Integer.parseInt(this.a[1]);
                    qVar.d = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class l implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public l(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.e = Integer.parseInt(this.a[1]);
                    qVar.f = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class m implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public m(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.c = Integer.parseInt(this.a[1]);
                    qVar.d = Integer.parseInt(this.a[2]);
                    qVar.e = Integer.parseInt(this.a[3]);
                    qVar.f = Integer.parseInt(this.a[4]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class n implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public n(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.l3.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.g = Integer.parseInt(this.a[1]);
                    qVar.h = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes5.dex */
        public static class p {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public t2 a;
            public Texture b;
            public float c;
            public float d;
            public boolean e;
            public Pixmap.Format f;
            public Texture.TextureFilter g;
            public Texture.TextureFilter h;
            public Texture.TextureWrap i;
            public Texture.TextureWrap j;
            public boolean k;

            public p() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = Pixmap.Format.RGBA8888;
                Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
                this.g = textureFilter;
                this.h = textureFilter;
                Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
                this.i = textureWrap;
                this.j = textureWrap;
            }
        }

        /* loaded from: classes5.dex */
        public static class q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public p a;
            public String b;
            public int c;
            public int d;
            public int e;
            public int f;
            public float g;
            public float h;
            public int i;
            public int j;
            public int k;
            public boolean l;
            public int m;
            public String[] n;
            public int[][] o;
            public boolean p;

            public q() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.m = -1;
            }
        }

        public c(t2 t2Var, t2 t2Var2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t2Var, t2Var2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new k6<>();
            this.b = new k6<>();
            b(t2Var, t2Var2, z);
        }

        public static int c(String[] strArr, String str) throws IOException {
            InterceptResult invokeLL;
            int indexOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, strArr, str)) == null) {
                if (str == null) {
                    return 0;
                }
                String trim = str.trim();
                if (trim.length() == 0 || (indexOf = trim.indexOf(58)) == -1) {
                    return 0;
                }
                strArr[0] = trim.substring(0, indexOf).trim();
                int i2 = 1;
                int i3 = indexOf + 1;
                while (true) {
                    int indexOf2 = trim.indexOf(44, i3);
                    if (indexOf2 == -1) {
                        strArr[i2] = trim.substring(i3).trim();
                        return i2;
                    }
                    strArr[i2] = trim.substring(i3, indexOf2).trim();
                    i3 = indexOf2 + 1;
                    if (i2 == 4) {
                        return 4;
                    }
                    i2++;
                }
            } else {
                return invokeLL.intValue;
            }
        }

        public k6<p> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (k6) invokeV.objValue;
        }

        public void b(t2 t2Var, t2 t2Var2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t2Var, t2Var2, z) == null) {
                String[] strArr = new String[5];
                g7 g7Var = new g7(15, 0.99f);
                g7Var.i("size", new f(this, strArr));
                g7Var.i("format", new g(this, strArr));
                g7Var.i("filter", new h(this, strArr));
                g7Var.i("repeat", new i(this, strArr));
                g7Var.i("pma", new j(this, strArr));
                boolean z2 = true;
                boolean[] zArr = {false};
                g7 g7Var2 = new g7(127, 0.99f);
                g7Var2.i("xy", new k(this, strArr));
                g7Var2.i("size", new l(this, strArr));
                g7Var2.i("bounds", new m(this, strArr));
                g7Var2.i("offset", new n(this, strArr));
                g7Var2.i("orig", new a(this, strArr));
                g7Var2.i(SevenZipUtils.LZMA_META_KEY_OFFSET, new b(this, strArr));
                g7Var2.i("rotate", new C0331c(this, strArr));
                g7Var2.i("index", new d(this, strArr, zArr));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(t2Var.m()), 1024);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        while (readLine != null && readLine.trim().length() == 0) {
                            readLine = bufferedReader.readLine();
                        }
                        while (readLine != null && readLine.trim().length() != 0 && c(strArr, readLine) != 0) {
                            readLine = bufferedReader.readLine();
                        }
                        p pVar = null;
                        k6 k6Var = null;
                        k6 k6Var2 = null;
                        while (readLine != null) {
                            if (readLine.trim().length() == 0) {
                                readLine = bufferedReader.readLine();
                                pVar = null;
                            } else if (pVar == null) {
                                pVar = new p();
                                pVar.a = t2Var2.a(readLine);
                                while (true) {
                                    readLine = bufferedReader.readLine();
                                    if (c(strArr, readLine) == 0) {
                                        break;
                                    }
                                    o oVar = (o) g7Var.c(strArr[0]);
                                    if (oVar != null) {
                                        oVar.a(pVar);
                                    }
                                }
                                this.a.a(pVar);
                            } else {
                                q qVar = new q();
                                qVar.a = pVar;
                                qVar.b = readLine.trim();
                                if (z) {
                                    qVar.p = z2;
                                }
                                while (true) {
                                    readLine = bufferedReader.readLine();
                                    int c = c(strArr, readLine);
                                    if (c == 0) {
                                        break;
                                    }
                                    o oVar2 = (o) g7Var2.c(strArr[0]);
                                    if (oVar2 != null) {
                                        oVar2.a(qVar);
                                    } else {
                                        if (k6Var == null) {
                                            k6Var = new k6(8);
                                            k6Var2 = new k6(8);
                                        }
                                        k6Var.a(strArr[0]);
                                        int[] iArr = new int[c];
                                        int i2 = 0;
                                        while (i2 < c) {
                                            int i3 = i2 + 1;
                                            try {
                                                iArr[i2] = Integer.parseInt(strArr[i3]);
                                            } catch (NumberFormatException unused) {
                                            }
                                            i2 = i3;
                                        }
                                        k6Var2.a(iArr);
                                    }
                                    z2 = true;
                                }
                                if (qVar.i == 0 && qVar.j == 0) {
                                    qVar.i = qVar.e;
                                    qVar.j = qVar.f;
                                }
                                if (k6Var != null && k6Var.b > 0) {
                                    qVar.n = (String[]) k6Var.m(String.class);
                                    qVar.o = (int[][]) k6Var2.m(int[].class);
                                    k6Var.clear();
                                    k6Var2.clear();
                                }
                                this.b.a(qVar);
                            }
                        }
                        s7.a(bufferedReader);
                        if (zArr[0]) {
                            this.b.sort(new e(this));
                        }
                    } catch (Exception e2) {
                        throw new GdxRuntimeException("Error reading texture atlas file: " + t2Var, e2);
                    }
                } catch (Throwable th) {
                    s7.a(bufferedReader);
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends m3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int h;
        public String i;
        public float j;
        public float k;
        public int l;
        public int m;
        public int n;
        public int o;
        public boolean p;
        public int q;
        public String[] r;
        public int[][] s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Texture texture, int i, int i2, int i3, int i4) {
            super(texture, i, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {texture, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Texture) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = -1;
            this.n = i3;
            this.o = i4;
            this.l = i3;
            this.m = i4;
        }

        public a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.h = -1;
            i(aVar);
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.q = aVar.q;
            this.r = aVar.r;
            this.s = aVar.s;
        }

        @Override // com.baidu.tieba.m3
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                super.a(z, z2);
                if (z) {
                    this.j = (this.n - this.j) - m();
                }
                if (z2) {
                    this.k = (this.o - this.k) - l();
                }
            }
        }

        public int[] k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                String[] strArr = this.r;
                if (strArr != null) {
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        if (str.equals(this.r[i])) {
                            return this.s[i];
                        }
                    }
                    return null;
                }
                return null;
            }
            return (int[]) invokeL.objValue;
        }

        public float l() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.p) {
                    i = this.l;
                } else {
                    i = this.m;
                }
                return i;
            }
            return invokeV.floatValue;
        }

        public float m() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.p) {
                    i = this.m;
                } else {
                    i = this.l;
                }
                return i;
            }
            return invokeV.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends k3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a t;
        public float u;
        public float v;

        public b(a aVar) {
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
            this.t = new a(aVar);
            this.u = aVar.j;
            this.v = aVar.k;
            i(aVar);
            v(aVar.n / 2.0f, aVar.o / 2.0f);
            int c = aVar.c();
            int b = aVar.b();
            if (aVar.p) {
                super.q(true);
                super.s(aVar.j, aVar.k, b, c);
            } else {
                super.s(aVar.j, aVar.k, c, b);
            }
            t(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            r(bVar);
        }

        public float B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return super.k() / this.t.l();
            }
            return invokeV.floatValue;
        }

        public float C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return super.n() / this.t.m();
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return (super.k() / this.t.l()) * this.t.o;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return super.l() + this.t.j;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return super.m() + this.t.k;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return (super.n() / this.t.m()) * this.t.n;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return super.o() - this.t.j;
            }
            return invokeV.floatValue;
        }

        @Override // com.baidu.tieba.k3
        public float p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return super.p() - this.t.k;
            }
            return invokeV.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.t.toString();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.k3, com.baidu.tieba.m3
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.t.p) {
                    super.a(z2, z);
                } else {
                    super.a(z, z2);
                }
                float l = l();
                float m = m();
                a aVar = this.t;
                float f = aVar.j;
                float f2 = aVar.k;
                float C = C();
                float B = B();
                a aVar2 = this.t;
                aVar2.j = this.u;
                aVar2.k = this.v;
                aVar2.a(z, z2);
                a aVar3 = this.t;
                float f3 = aVar3.j;
                this.u = f3;
                float f4 = aVar3.k;
                this.v = f4;
                float f5 = f3 * C;
                aVar3.j = f5;
                float f6 = f4 * B;
                aVar3.k = f6;
                A(f5 - f, f6 - f2);
                v(l, m);
            }
        }

        @Override // com.baidu.tieba.k3
        public void q(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                super.q(z);
                float l = l();
                float m = m();
                a aVar = this.t;
                float f = aVar.j;
                float f2 = aVar.k;
                float C = C();
                float B = B();
                if (z) {
                    a aVar2 = this.t;
                    aVar2.j = f2;
                    aVar2.k = ((aVar2.o * B) - f) - (aVar2.l * C);
                } else {
                    a aVar3 = this.t;
                    aVar3.j = ((aVar3.n * C) - f2) - (aVar3.m * B);
                    aVar3.k = f;
                }
                a aVar4 = this.t;
                A(aVar4.j - f, aVar4.k - f2);
                v(l, m);
            }
        }

        @Override // com.baidu.tieba.k3
        public void s(float f, float f2, float f3, float f4) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                a aVar = this.t;
                float f5 = f3 / aVar.n;
                float f6 = f4 / aVar.o;
                aVar.j = this.u * f5;
                aVar.k = this.v * f6;
                if (aVar.p) {
                    i = aVar.m;
                } else {
                    i = aVar.l;
                }
                a aVar2 = this.t;
                if (aVar2.p) {
                    i2 = aVar2.l;
                } else {
                    i2 = aVar2.m;
                }
                a aVar3 = this.t;
                super.s(f + aVar3.j, f2 + aVar3.k, i * f5, i2 * f6);
            }
        }

        @Override // com.baidu.tieba.k3
        public void v(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                a aVar = this.t;
                super.v(f - aVar.j, f2 - aVar.k);
            }
        }

        @Override // com.baidu.tieba.k3
        public void z(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                s(o(), p(), f, f2);
            }
        }
    }

    public l3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new h7<>(4);
        this.b = new k6<>();
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h7.a<Texture> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
            this.a.b(0);
        }
    }

    public k6<a> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (k6) invokeV.objValue;
    }

    public l3(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new h7<>(4);
        this.b = new k6<>();
        h(cVar);
    }

    public k3 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.b.get(i2).i.equals(str)) {
                    return i(this.b.get(i2));
                }
            }
            return null;
        }
        return (k3) invokeL.objValue;
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.b.get(i2).i.equals(str)) {
                    return this.b.get(i2);
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public void h(c cVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.a.c(cVar.a.b);
            k6.b<c.p> it = cVar.a.iterator();
            while (it.hasNext()) {
                c.p next = it.next();
                if (next.b == null) {
                    next.b = new Texture(next.a, next.f, next.e);
                }
                next.b.l(next.g, next.h);
                next.b.m(next.i, next.j);
                this.a.add(next.b);
            }
            this.b.e(cVar.b.b);
            k6.b<c.q> it2 = cVar.b.iterator();
            while (it2.hasNext()) {
                c.q next2 = it2.next();
                Texture texture = next2.a.b;
                int i3 = next2.c;
                int i4 = next2.d;
                if (next2.l) {
                    i = next2.f;
                } else {
                    i = next2.e;
                }
                int i5 = i;
                if (next2.l) {
                    i2 = next2.e;
                } else {
                    i2 = next2.f;
                }
                a aVar = new a(texture, i3, i4, i5, i2);
                aVar.h = next2.m;
                aVar.i = next2.b;
                aVar.j = next2.g;
                aVar.k = next2.h;
                aVar.o = next2.j;
                aVar.n = next2.i;
                aVar.p = next2.l;
                aVar.q = next2.k;
                aVar.r = next2.n;
                aVar.s = next2.o;
                if (next2.p) {
                    aVar.a(false, true);
                }
                this.b.a(aVar);
            }
        }
    }

    public final k3 i(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar.l == aVar.n && aVar.m == aVar.o) {
                if (aVar.p) {
                    k3 k3Var = new k3(aVar);
                    k3Var.s(0.0f, 0.0f, aVar.b(), aVar.c());
                    k3Var.q(true);
                    return k3Var;
                }
                return new k3(aVar);
            }
            return new b(aVar);
        }
        return (k3) invokeL.objValue;
    }
}
