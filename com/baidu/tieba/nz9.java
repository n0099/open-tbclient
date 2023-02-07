package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes5.dex */
public class nz9 {
    public static /* synthetic */ Interceptable $ic;
    public static HashSet<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;
    public float b;
    public SVG c;
    public h d;
    public Stack<h> e;
    public Stack<SVG.h0> f;
    public Stack<Matrix> g;
    public CSSParser.m h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948019900, "Lcom/baidu/tieba/nz9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948019900, "Lcom/baidu/tieba/nz9;");
        }
    }

    public static int C(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) {
            int i2 = (int) (f2 * 256.0f);
            if (i2 < 0) {
                return 0;
            }
            if (i2 > 255) {
                return 255;
            }
            return i2;
        }
        return invokeF.intValue;
    }

    public static void G(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, objArr) == null) {
        }
    }

    public final float L(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (f2 * f4) + (f3 * f5) : invokeCommon.floatValue;
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-558636193, "Lcom/baidu/tieba/nz9$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-558636193, "Lcom/baidu/tieba/nz9$a;");
                    return;
                }
            }
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            c = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            b = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            a = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c> a;
        public float b;
        public float c;
        public c d;
        public boolean e;
        public boolean f;
        public int g;
        public boolean h;
        public final /* synthetic */ nz9 i;

        public b(nz9 nz9Var, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = nz9Var;
            this.a = new ArrayList();
            this.d = null;
            this.e = false;
            this.f = true;
            this.g = -1;
            if (vVar == null) {
                return;
            }
            vVar.h(this);
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                if (this.h) {
                    this.d.b(this.a.get(this.g));
                    this.a.set(this.g, this.d);
                    this.h = false;
                }
                c cVar = this.d;
                if (cVar != null) {
                    this.a.add(cVar);
                }
                this.b = f;
                this.c = f2;
                this.d = new c(this.i, f, f2, 0.0f, 0.0f);
                this.g = this.a.size();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.d.a(f, f2);
                this.a.add(this.d);
                nz9 nz9Var = this.i;
                c cVar = this.d;
                this.d = new c(nz9Var, f, f2, f - cVar.a, f2 - cVar.b);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.d.a(f, f2);
                this.a.add(this.d);
                this.d = new c(this.i, f3, f4, f3 - f, f4 - f2);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.add(this.d);
                b(this.b, this.c);
                this.h = true;
            }
        }

        public List<c> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                if (this.f || this.e) {
                    this.d.a(f, f2);
                    this.a.add(this.d);
                    this.e = false;
                }
                this.d = new c(this.i, f5, f6, f5 - f3, f6 - f4);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.e = true;
                this.f = false;
                c cVar = this.d;
                nz9.m(cVar.a, cVar.b, f, f2, f3, z, z2, f4, f5, this);
                this.f = true;
                this.h = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public float d;
        public boolean e;

        public c(nz9 nz9Var, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = false;
            this.a = f;
            this.b = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.c = (float) (f3 / sqrt);
                this.d = (float) (f4 / sqrt);
            }
        }

        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                float f3 = f - this.a;
                float f4 = f2 - this.b;
                double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
                if (sqrt != 0.0d) {
                    f3 = (float) (f3 / sqrt);
                    f4 = (float) (f4 / sqrt);
                }
                if (f3 == (-this.c) && f4 == (-this.d)) {
                    this.e = true;
                    this.c = -f4;
                    this.d = f3;
                    return;
                }
                this.c += f3;
                this.d += f4;
            }
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar.c == (-this.c)) {
                    float f = cVar.d;
                    if (f == (-this.d)) {
                        this.e = true;
                        this.c = -f;
                        this.d = cVar.c;
                        return;
                    }
                }
                this.c += cVar.c;
                this.d += cVar.d;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "(" + this.a + "," + this.b + " " + this.c + "," + this.d + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Path a;
        public float b;
        public float c;

        public d(nz9 nz9Var, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Path();
            if (vVar == null) {
                return;
            }
            vVar.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.moveTo(f, f2);
                this.b = f;
                this.c = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.lineTo(f, f2);
                this.b = f;
                this.c = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.a.quadTo(f, f2, f3, f4);
                this.b = f3;
                this.c = f4;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.close();
            }
        }

        public Path f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a;
            }
            return (Path) invokeV.objValue;
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                this.a.cubicTo(f, f2, f3, f4, f5, f6);
                this.b = f5;
                this.c = f6;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                nz9.m(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
                this.b = f4;
                this.c = f5;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Path d;
        public final /* synthetic */ nz9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(nz9 nz9Var, Path path, float f, float f2) {
            super(nz9Var, f, f2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, path, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((nz9) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nz9Var;
            this.d = path;
        }

        @Override // com.baidu.tieba.nz9.f, com.baidu.tieba.nz9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.e.g1()) {
                    if (this.e.d.b) {
                        this.e.a.drawTextOnPath(str, this.d, this.a, this.b, this.e.d.d);
                    }
                    if (this.e.d.c) {
                        this.e.a.drawTextOnPath(str, this.d, this.a, this.b, this.e.d.e);
                    }
                }
                this.a += this.e.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public final /* synthetic */ nz9 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(nz9 nz9Var, float f, float f2) {
            super(nz9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((nz9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz9Var;
            this.a = f;
            this.b = f2;
        }

        @Override // com.baidu.tieba.nz9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            nz9.G("TextSequence render", new Object[0]);
            if (this.c.g1()) {
                if (this.c.d.b) {
                    this.c.a.drawText(str, this.a, this.b, this.c.d.d);
                }
                if (this.c.d.c) {
                    this.c.a.drawText(str, this.a, this.b, this.c.d.e);
                }
            }
            this.a += this.c.d.d.measureText(str);
        }
    }

    /* loaded from: classes5.dex */
    public class g extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public Path c;
        public final /* synthetic */ nz9 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(nz9 nz9Var, float f, float f2, Path path) {
            super(nz9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, Float.valueOf(f), Float.valueOf(f2), path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((nz9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz9Var;
            this.a = f;
            this.b = f2;
            this.c = path;
        }

        @Override // com.baidu.tieba.nz9.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (!(w0Var instanceof SVG.x0)) {
                    return true;
                }
                nz9.h1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.nz9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.d.g1()) {
                    Path path = new Path();
                    this.d.d.d.getTextPath(str, 0, str.length(), this.a, this.b, path);
                    this.c.addPath(path);
                }
                this.a += this.d.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG.Style a;
        public boolean b;
        public boolean c;
        public Paint d;
        public Paint e;
        public SVG.b f;
        public SVG.b g;
        public boolean h;

        public h(nz9 nz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Paint paint = new Paint();
            this.d = paint;
            paint.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.d.setHinting(0);
            }
            this.d.setStyle(Paint.Style.FILL);
            this.d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.e.setHinting(0);
            }
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.a();
        }

        public h(nz9 nz9Var, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, hVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = hVar.b;
            this.c = hVar.c;
            this.d = new Paint(hVar.d);
            this.e = new Paint(hVar.e);
            SVG.b bVar = hVar.f;
            if (bVar != null) {
                this.f = new SVG.b(bVar);
            }
            SVG.b bVar2 = hVar.g;
            if (bVar2 != null) {
                this.g = new SVG.b(bVar2);
            }
            this.h = hVar.h;
            try {
                this.a = (SVG.Style) hVar.a.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.a = SVG.Style.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public RectF c;
        public final /* synthetic */ nz9 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(nz9 nz9Var, float f, float f2) {
            super(nz9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((nz9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz9Var;
            this.c = new RectF();
            this.a = f;
            this.b = f2;
        }

        @Override // com.baidu.tieba.nz9.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (!(w0Var instanceof SVG.x0)) {
                    return true;
                }
                SVG.x0 x0Var = (SVG.x0) w0Var;
                SVG.l0 p = w0Var.a.p(x0Var.n);
                if (p != null) {
                    SVG.u uVar = (SVG.u) p;
                    Path f = new d(this.d, uVar.o).f();
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        f.transform(matrix);
                    }
                    RectF rectF = new RectF();
                    f.computeBounds(rectF, true);
                    this.c.union(rectF);
                    return false;
                }
                nz9.N("TextPath path reference '%s' not found", x0Var.n);
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.nz9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.d.g1()) {
                    Rect rect = new Rect();
                    this.d.d.d.getTextBounds(str, 0, str.length(), rect);
                    RectF rectF = new RectF(rect);
                    rectF.offset(this.a, this.b);
                    this.c.union(rectF);
                }
                this.a += this.d.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public abstract void b(String str);

        public j(nz9 nz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ j(nz9 nz9Var, a aVar) {
            this(nz9Var);
        }
    }

    /* loaded from: classes5.dex */
    public class k extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ nz9 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(nz9 nz9Var) {
            super(nz9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((nz9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nz9Var;
            this.a = 0.0f;
        }

        public /* synthetic */ k(nz9 nz9Var, a aVar) {
            this(nz9Var);
        }

        @Override // com.baidu.tieba.nz9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a += this.b.d.d.measureText(str);
            }
        }
    }

    public nz9(Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvas, Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.a = canvas;
        this.b = f2;
    }

    public static int F(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int i3 = 255;
            int round = Math.round(((i2 >> 24) & 255) * f2);
            if (round < 0) {
                i3 = 0;
            } else if (round <= 255) {
                i3 = round;
            }
            return (i2 & 16777215) | (i3 << 24);
        }
        return invokeCommon.intValue;
    }

    public final void J(SVG.i0 i0Var, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, i0Var, path) == null) {
            SVG.m0 m0Var = this.d.a.b;
            if (m0Var instanceof SVG.t) {
                SVG.l0 p = this.c.p(((SVG.t) m0Var).a);
                if (p instanceof SVG.x) {
                    T(i0Var, path, (SVG.x) p);
                    return;
                }
            }
            this.a.drawPath(path, this.d.d);
        }
    }

    public final void M(SVG.w0 w0Var, j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, w0Var, jVar) != null) || !I()) {
            return;
        }
        Iterator<SVG.l0> it = w0Var.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.l0 next = it.next();
            if (next instanceof SVG.a1) {
                jVar.b(b1(((SVG.a1) next).c, z, !it.hasNext()));
            } else {
                t0(next, jVar);
            }
            z = false;
        }
    }

    public final void O(SVG.w0 w0Var, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, w0Var, sb) == null) {
            Iterator<SVG.l0> it = w0Var.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.w0) {
                    O((SVG.w0) next, sb);
                } else if (next instanceof SVG.a1) {
                    sb.append(b1(((SVG.a1) next).c, z, !it.hasNext()));
                }
                z = false;
            }
        }
    }

    public final void R(SVG.o0 o0Var, SVG.o0 o0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, o0Var, o0Var2) == null) {
            if (o0Var.m == null) {
                o0Var.m = o0Var2.m;
            }
            if (o0Var.n == null) {
                o0Var.n = o0Var2.n;
            }
            if (o0Var.o == null) {
                o0Var.o = o0Var2.o;
            }
            if (o0Var.p == null) {
                o0Var.p = o0Var2.p;
            }
            if (o0Var.q == null) {
                o0Var.q = o0Var2.q;
            }
        }
    }

    public static double B(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < -1.0d) {
                return 3.141592653589793d;
            }
            if (d2 > 1.0d) {
                return 0.0d;
            }
            return Math.acos(d2);
        }
        return invokeCommon.doubleValue;
    }

    public final void J0(SVG.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, q0Var) == null) {
            G("Switch render", new Object[0]);
            e1(this.d, q0Var);
            if (!I()) {
                return;
            }
            Matrix matrix = q0Var.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(q0Var);
            boolean u0 = u0();
            S0(q0Var);
            if (u0) {
                r0(q0Var);
            }
            c1(q0Var);
        }
    }

    public final void x(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, i0Var) == null) {
            SVG.m0 m0Var = this.d.a.b;
            if (m0Var instanceof SVG.t) {
                H(true, i0Var.h, (SVG.t) m0Var);
            }
            SVG.m0 m0Var2 = this.d.a.e;
            if (m0Var2 instanceof SVG.t) {
                H(false, i0Var.h, (SVG.t) m0Var2);
            }
        }
    }

    public final void y0(SVG.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, lVar) == null) {
            G("Group render", new Object[0]);
            e1(this.d, lVar);
            if (!I()) {
                return;
            }
            Matrix matrix = lVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(lVar);
            boolean u0 = u0();
            N0(lVar, true);
            if (u0) {
                r0(lVar);
            }
            c1(lVar);
        }
    }

    public static void N(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, objArr) == null) {
            Log.e("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public static void h1(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, objArr) == null) {
            Log.w("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public final void G0(SVG.d0 d0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, d0Var, bVar) == null) {
            H0(d0Var, bVar, d0Var.o, d0Var.n);
        }
    }

    public final void N0(SVG.h0 h0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, h0Var, z) == null) {
            if (z) {
                q0(h0Var);
            }
            for (SVG.l0 l0Var : h0Var.getChildren()) {
                I0(l0Var);
            }
            if (z) {
                p0();
            }
        }
    }

    public final void Q(SVG.k0 k0Var, SVG.k0 k0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, k0Var, k0Var2) == null) {
            if (k0Var.m == null) {
                k0Var.m = k0Var2.m;
            }
            if (k0Var.n == null) {
                k0Var.n = k0Var2.n;
            }
            if (k0Var.o == null) {
                k0Var.o = k0Var2.o;
            }
            if (k0Var.p == null) {
                k0Var.p = k0Var2.p;
            }
        }
    }

    public final boolean e0(SVG.Style style, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048630, this, style, j2)) == null) {
            if ((style.a & j2) != 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final void v(SVG.i0 i0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048662, this, i0Var, bVar) != null) || this.d.a.E == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Path o = o(i0Var, bVar);
            if (o != null) {
                this.a.clipPath(o);
                return;
            }
            return;
        }
        w(i0Var, bVar);
    }

    public final void A(SVG.l0 l0Var) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, l0Var) == null) && (l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    public final void F0(SVG.d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d0Var) == null) {
            H0(d0Var, n0(d0Var.p, d0Var.q, d0Var.r, d0Var.s), d0Var.o, d0Var.n);
        }
    }

    public final h U(SVG.l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, l0Var)) == null) {
            h hVar = new h(this);
            d1(hVar, SVG.Style.a());
            V(l0Var, hVar);
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public final void q0(SVG.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, h0Var) == null) {
            this.f.push(h0Var);
            this.g.push(this.a.getMatrix());
        }
    }

    public final SVG.b r(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, path)) == null) {
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        return (SVG.b) invokeL.objValue;
    }

    public final void r0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, i0Var) == null) {
            s0(i0Var, i0Var.h);
        }
    }

    public final float s(SVG.w0 w0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, w0Var)) == null) {
            k kVar = new k(this, null);
            M(w0Var, kVar);
            return kVar.a;
        }
        return invokeL.floatValue;
    }

    public final void u(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, i0Var) == null) {
            v(i0Var, i0Var.h);
        }
    }

    public static synchronized void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (nz9.class) {
                HashSet<String> hashSet = new HashSet<>();
                i = hashSet;
                hashSet.add("Structure");
                i.add("BasicStructure");
                i.add("ConditionalProcessing");
                i.add("Image");
                i.add("Style");
                i.add("ViewportAttribute");
                i.add("Shape");
                i.add("BasicText");
                i.add("PaintAttribute");
                i.add("BasicPaintAttribute");
                i.add("OpacityAttribute");
                i.add("BasicGraphicsAttribute");
                i.add("Marker");
                i.add("Gradient");
                i.add("Pattern");
                i.add("Clip");
                i.add("BasicClip");
                i.add("Mask");
                i.add("View");
            }
        }
    }

    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        float f9;
        SVG.w wVar2;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f7), Float.valueOf(f8), wVar}) == null) {
            if (f2 == f7 && f3 == f8) {
                return;
            }
            if (f4 != 0.0f) {
                if (f5 == 0.0f) {
                    wVar2 = wVar;
                    f9 = f7;
                } else {
                    float abs = Math.abs(f4);
                    float abs2 = Math.abs(f5);
                    double radians = Math.toRadians(f6 % 360.0d);
                    double cos = Math.cos(radians);
                    double sin = Math.sin(radians);
                    double d4 = (f2 - f7) / 2.0d;
                    double d5 = (f3 - f8) / 2.0d;
                    double d6 = (cos * d4) + (sin * d5);
                    double d7 = ((-sin) * d4) + (d5 * cos);
                    double d8 = abs * abs;
                    double d9 = abs2 * abs2;
                    double d10 = d6 * d6;
                    double d11 = d7 * d7;
                    double d12 = (d10 / d8) + (d11 / d9);
                    if (d12 > 0.99999d) {
                        double sqrt = Math.sqrt(d12) * 1.00001d;
                        abs = (float) (abs * sqrt);
                        abs2 = (float) (sqrt * abs2);
                        d8 = abs * abs;
                        d9 = abs2 * abs2;
                    }
                    double d13 = -1.0d;
                    if (z == z2) {
                        d2 = -1.0d;
                    } else {
                        d2 = 1.0d;
                    }
                    double d14 = d8 * d9;
                    double d15 = d8 * d11;
                    double d16 = d9 * d10;
                    double d17 = ((d14 - d15) - d16) / (d15 + d16);
                    if (d17 < 0.0d) {
                        d17 = 0.0d;
                    }
                    double sqrt2 = d2 * Math.sqrt(d17);
                    double d18 = abs;
                    double d19 = abs2;
                    double d20 = ((d18 * d7) / d19) * sqrt2;
                    float f10 = abs;
                    float f11 = abs2;
                    double d21 = sqrt2 * (-((d19 * d6) / d18));
                    double d22 = ((f2 + f7) / 2.0d) + ((cos * d20) - (sin * d21));
                    double d23 = ((f3 + f8) / 2.0d) + (sin * d20) + (cos * d21);
                    double d24 = (d6 - d20) / d18;
                    double d25 = (d7 - d21) / d19;
                    double d26 = ((-d6) - d20) / d18;
                    double d27 = ((-d7) - d21) / d19;
                    double d28 = (d24 * d24) + (d25 * d25);
                    double sqrt3 = Math.sqrt(d28);
                    if (d25 < 0.0d) {
                        d3 = -1.0d;
                    } else {
                        d3 = 1.0d;
                    }
                    double acos = d3 * Math.acos(d24 / sqrt3);
                    double sqrt4 = Math.sqrt(d28 * ((d26 * d26) + (d27 * d27)));
                    double d29 = (d24 * d26) + (d25 * d27);
                    if ((d24 * d27) - (d25 * d26) >= 0.0d) {
                        d13 = 1.0d;
                    }
                    double B = d13 * B(d29 / sqrt4);
                    if (!z2 && B > 0.0d) {
                        B -= 6.283185307179586d;
                    } else if (z2 && B < 0.0d) {
                        B += 6.283185307179586d;
                    }
                    float[] n = n(acos % 6.283185307179586d, B % 6.283185307179586d);
                    Matrix matrix = new Matrix();
                    matrix.postScale(f10, f11);
                    matrix.postRotate(f6);
                    matrix.postTranslate((float) d22, (float) d23);
                    matrix.mapPoints(n);
                    n[n.length - 2] = f7;
                    n[n.length - 1] = f8;
                    for (int i2 = 0; i2 < n.length; i2 += 6) {
                        wVar.d(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
                    }
                    return;
                }
            } else {
                f9 = f7;
                wVar2 = wVar;
            }
            wVar2.b(f9, f8);
        }
    }

    public static float[] n(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            int ceil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
            double d4 = d3 / ceil;
            double d5 = d4 / 2.0d;
            double sin = (Math.sin(d5) * 1.3333333333333333d) / (Math.cos(d5) + 1.0d);
            float[] fArr = new float[ceil * 6];
            int i2 = 0;
            int i3 = 0;
            while (i2 < ceil) {
                double d6 = d2 + (i2 * d4);
                double cos = Math.cos(d6);
                double sin2 = Math.sin(d6);
                int i4 = i3 + 1;
                double d7 = d4;
                fArr[i3] = (float) (cos - (sin * sin2));
                int i5 = i4 + 1;
                fArr[i4] = (float) (sin2 + (cos * sin));
                double d8 = d6 + d7;
                double cos2 = Math.cos(d8);
                double sin3 = Math.sin(d8);
                int i6 = i5 + 1;
                fArr[i5] = (float) ((sin * sin3) + cos2);
                int i7 = i6 + 1;
                fArr[i6] = (float) (sin3 - (sin * cos2));
                int i8 = i7 + 1;
                fArr[i7] = (float) cos2;
                i3 = i8 + 1;
                fArr[i8] = (float) sin3;
                i2++;
                d4 = d7;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public final void S(SVG.x xVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, xVar, str) == null) {
            SVG.l0 p = xVar.a.p(str);
            if (p == null) {
                h1("Pattern reference '%s' not found", str);
            } else if (!(p instanceof SVG.x)) {
                N("Pattern href attributes must point to other pattern elements", new Object[0]);
            } else if (p == xVar) {
                N("Circular reference in pattern href attribute '%s'", str);
            } else {
                SVG.x xVar2 = (SVG.x) p;
                if (xVar.p == null) {
                    xVar.p = xVar2.p;
                }
                if (xVar.q == null) {
                    xVar.q = xVar2.q;
                }
                if (xVar.r == null) {
                    xVar.r = xVar2.r;
                }
                if (xVar.s == null) {
                    xVar.s = xVar2.s;
                }
                if (xVar.t == null) {
                    xVar.t = xVar2.t;
                }
                if (xVar.u == null) {
                    xVar.u = xVar2.u;
                }
                if (xVar.v == null) {
                    xVar.v = xVar2.v;
                }
                if (xVar.i.isEmpty()) {
                    xVar.i = xVar2.i;
                }
                if (xVar.o == null) {
                    xVar.o = xVar2.o;
                }
                if (xVar.n == null) {
                    xVar.n = xVar2.n;
                }
                String str2 = xVar2.w;
                if (str2 != null) {
                    S(xVar, str2);
                }
            }
        }
    }

    public final void Y0(boolean z, SVG.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048620, this, z, b0Var) == null) {
            boolean z2 = true;
            if (z) {
                if (e0(b0Var.e, 2147483648L)) {
                    h hVar = this.d;
                    SVG.Style style = hVar.a;
                    SVG.m0 m0Var = b0Var.e.H;
                    style.b = m0Var;
                    if (m0Var == null) {
                        z2 = false;
                    }
                    hVar.b = z2;
                }
                if (e0(b0Var.e, 4294967296L)) {
                    this.d.a.d = b0Var.e.I;
                }
                if (e0(b0Var.e, 6442450944L)) {
                    h hVar2 = this.d;
                    X0(hVar2, z, hVar2.a.b);
                    return;
                }
                return;
            }
            if (e0(b0Var.e, 2147483648L)) {
                h hVar3 = this.d;
                SVG.Style style2 = hVar3.a;
                SVG.m0 m0Var2 = b0Var.e.H;
                style2.e = m0Var2;
                if (m0Var2 == null) {
                    z2 = false;
                }
                hVar3.c = z2;
            }
            if (e0(b0Var.e, 4294967296L)) {
                this.d.a.f = b0Var.e.I;
            }
            if (e0(b0Var.e, 6442450944L)) {
                h hVar4 = this.d;
                X0(hVar4, z, hVar4.a.e);
            }
        }
    }

    @TargetApi(19)
    public final Path o(SVG.i0 i0Var, SVG.b bVar) {
        InterceptResult invokeLL;
        Path o0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, i0Var, bVar)) == null) {
            SVG.l0 p = i0Var.a.p(this.d.a.E);
            boolean z = false;
            if (p == null) {
                N("ClipPath reference '%s' not found", this.d.a.E);
                return null;
            }
            SVG.e eVar = (SVG.e) p;
            this.e.push(this.d);
            this.d = U(eVar);
            Boolean bool = eVar.o;
            z = (bool == null || bool.booleanValue()) ? true : true;
            Matrix matrix = new Matrix();
            if (!z) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = eVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path path = new Path();
            for (SVG.l0 l0Var : eVar.i) {
                if ((l0Var instanceof SVG.i0) && (o0 = o0((SVG.i0) l0Var, true)) != null) {
                    path.op(o0, Path.Op.UNION);
                }
            }
            if (this.d.a.E != null) {
                if (eVar.h == null) {
                    eVar.h = r(path);
                }
                Path o = o(eVar, eVar.h);
                if (o != null) {
                    path.op(o, Path.Op.INTERSECT);
                }
            }
            path.transform(matrix);
            this.d = this.e.pop();
            return path;
        }
        return (Path) invokeLL.objValue;
    }

    public final void s0(SVG.i0 i0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, i0Var, bVar) == null) {
            if (this.d.a.G != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                this.a.saveLayer(null, paint, 31);
                Paint paint2 = new Paint();
                paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
                this.a.saveLayer(null, paint2, 31);
                SVG.r rVar = (SVG.r) this.c.p(this.d.a.G);
                R0(rVar, i0Var, bVar);
                this.a.restore();
                Paint paint3 = new Paint();
                paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                this.a.saveLayer(null, paint3, 31);
                R0(rVar, i0Var, bVar);
                this.a.restore();
                this.a.restore();
            }
            Z0();
        }
    }

    public final void w(SVG.i0 i0Var, SVG.b bVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048664, this, i0Var, bVar) == null) {
            SVG.l0 p = i0Var.a.p(this.d.a.E);
            if (p == null) {
                N("ClipPath reference '%s' not found", this.d.a.E);
                return;
            }
            SVG.e eVar = (SVG.e) p;
            if (eVar.i.isEmpty()) {
                this.a.clipRect(0, 0, 0, 0);
                return;
            }
            Boolean bool = eVar.o;
            if (bool != null && !bool.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            if ((i0Var instanceof SVG.l) && !z) {
                h1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.n());
                return;
            }
            E();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
                this.a.concat(matrix);
            }
            Matrix matrix2 = eVar.n;
            if (matrix2 != null) {
                this.a.concat(matrix2);
            }
            this.d = U(eVar);
            u(eVar);
            Path path = new Path();
            for (SVG.l0 l0Var : eVar.i) {
                j(l0Var, true, path, new Matrix());
            }
            this.a.clipPath(path);
            D();
        }
    }

    public final void A0(SVG.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            G("Line render", new Object[0]);
            e1(this.d, pVar);
            if (!I() || !g1() || !this.d.c) {
                return;
            }
            Matrix matrix = pVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path i0 = i0(pVar);
            c1(pVar);
            x(pVar);
            u(pVar);
            boolean u0 = u0();
            K(i0);
            Q0(pVar);
            if (u0) {
                r0(pVar);
            }
        }
    }

    public final Path j0(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, yVar)) == null) {
            Path path = new Path();
            float[] fArr = yVar.o;
            path.moveTo(fArr[0], fArr[1]);
            int i2 = 2;
            while (true) {
                float[] fArr2 = yVar.o;
                if (i2 >= fArr2.length) {
                    break;
                }
                path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                i2 += 2;
            }
            if (yVar instanceof SVG.z) {
                path.close();
            }
            if (yVar.h == null) {
                yVar.h = r(path);
            }
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final List<c> p(SVG.p pVar) {
        InterceptResult invokeL;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            if (oVar != null) {
                f2 = oVar.e(this);
            } else {
                f2 = 0.0f;
            }
            SVG.o oVar2 = pVar.p;
            if (oVar2 != null) {
                f3 = oVar2.f(this);
            } else {
                f3 = 0.0f;
            }
            SVG.o oVar3 = pVar.q;
            if (oVar3 != null) {
                f4 = oVar3.e(this);
            } else {
                f4 = 0.0f;
            }
            SVG.o oVar4 = pVar.r;
            if (oVar4 != null) {
                f5 = oVar4.f(this);
            } else {
                f5 = 0.0f;
            }
            ArrayList arrayList = new ArrayList(2);
            float f6 = f4 - f2;
            float f7 = f5 - f3;
            arrayList.add(new c(this, f2, f3, f6, f7));
            arrayList.add(new c(this, f4, f5, f6, f7));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final Bitmap y(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, str)) == null) {
            if (!str.startsWith(WebGLImageLoader.DATA_URL) || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !DataUrlLoader.BASE64_TAG.equals(str.substring(indexOf - 7, indexOf))) {
                return null;
            }
            try {
                byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e2) {
                Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e2);
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void B0(SVG.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uVar) == null) {
            G("Path render", new Object[0]);
            if (uVar.o == null) {
                return;
            }
            e1(this.d, uVar);
            if (!I() || !g1()) {
                return;
            }
            h hVar = this.d;
            if (!hVar.c && !hVar.b) {
                return;
            }
            Matrix matrix = uVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path f2 = new d(this, uVar.o).f();
            if (uVar.h == null) {
                uVar.h = r(f2);
            }
            c1(uVar);
            x(uVar);
            u(uVar);
            boolean u0 = u0();
            if (this.d.b) {
                f2.setFillType(c0());
                J(uVar, f2);
            }
            if (this.d.c) {
                K(f2);
            }
            Q0(uVar);
            if (u0) {
                r0(uVar);
            }
        }
    }

    public final void C0(SVG.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yVar) == null) {
            G("PolyLine render", new Object[0]);
            e1(this.d, yVar);
            if (!I() || !g1()) {
                return;
            }
            h hVar = this.d;
            if (!hVar.c && !hVar.b) {
                return;
            }
            Matrix matrix = yVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            if (yVar.o.length < 2) {
                return;
            }
            Path j0 = j0(yVar);
            c1(yVar);
            j0.setFillType(c0());
            x(yVar);
            u(yVar);
            boolean u0 = u0();
            if (this.d.b) {
                J(yVar, j0);
            }
            if (this.d.c) {
                K(j0);
            }
            Q0(yVar);
            if (u0) {
                r0(yVar);
            }
        }
    }

    public final void D0(SVG.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            G("Polygon render", new Object[0]);
            e1(this.d, zVar);
            if (!I() || !g1()) {
                return;
            }
            h hVar = this.d;
            if (!hVar.c && !hVar.b) {
                return;
            }
            Matrix matrix = zVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            if (zVar.o.length < 2) {
                return;
            }
            Path j0 = j0(zVar);
            c1(zVar);
            x(zVar);
            u(zVar);
            boolean u0 = u0();
            if (this.d.b) {
                J(zVar, j0);
            }
            if (this.d.c) {
                K(j0);
            }
            Q0(zVar);
            if (u0) {
                r0(zVar);
            }
        }
    }

    public final void E0(SVG.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a0Var) == null) {
            G("Rect render", new Object[0]);
            SVG.o oVar = a0Var.q;
            if (oVar != null && a0Var.r != null && !oVar.h() && !a0Var.r.h()) {
                e1(this.d, a0Var);
                if (!I() || !g1()) {
                    return;
                }
                Matrix matrix = a0Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path k0 = k0(a0Var);
                c1(a0Var);
                x(a0Var);
                u(a0Var);
                boolean u0 = u0();
                if (this.d.b) {
                    J(a0Var, k0);
                }
                if (this.d.c) {
                    K(k0);
                }
                if (u0) {
                    r0(a0Var);
                }
            }
        }
    }

    public final void K(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, path) == null) {
            h hVar = this.d;
            if (hVar.a.L == SVG.Style.VectorEffect.NonScalingStroke) {
                Matrix matrix = this.a.getMatrix();
                Path path2 = new Path();
                path.transform(matrix, path2);
                this.a.setMatrix(new Matrix());
                Shader shader = this.d.e.getShader();
                Matrix matrix2 = new Matrix();
                if (shader != null) {
                    shader.getLocalMatrix(matrix2);
                    Matrix matrix3 = new Matrix(matrix2);
                    matrix3.postConcat(matrix);
                    shader.setLocalMatrix(matrix3);
                }
                this.a.drawPath(path2, this.d.e);
                this.a.setMatrix(matrix);
                if (shader != null) {
                    shader.setLocalMatrix(matrix2);
                    return;
                }
                return;
            }
            this.a.drawPath(path, hVar.e);
        }
    }

    public final Path g0(SVG.d dVar) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, dVar)) == null) {
            SVG.o oVar = dVar.o;
            float f3 = 0.0f;
            if (oVar != null) {
                f2 = oVar.e(this);
            } else {
                f2 = 0.0f;
            }
            SVG.o oVar2 = dVar.p;
            if (oVar2 != null) {
                f3 = oVar2.f(this);
            }
            float c2 = dVar.q.c(this);
            float f4 = f2 - c2;
            float f5 = f3 - c2;
            float f6 = f2 + c2;
            float f7 = f3 + c2;
            if (dVar.h == null) {
                float f8 = 2.0f * c2;
                dVar.h = new SVG.b(f4, f5, f8, f8);
            }
            float f9 = 0.5522848f * c2;
            Path path = new Path();
            path.moveTo(f2, f5);
            float f10 = f2 + f9;
            float f11 = f3 - f9;
            path.cubicTo(f10, f5, f6, f11, f6, f3);
            float f12 = f3 + f9;
            path.cubicTo(f6, f12, f10, f7, f2, f7);
            float f13 = f2 - f9;
            path.cubicTo(f13, f7, f4, f12, f4, f3);
            path.cubicTo(f4, f11, f13, f5, f2, f5);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path i0(SVG.p pVar) {
        InterceptResult invokeL;
        float e2;
        float f2;
        float e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float f3 = 0.0f;
            if (oVar == null) {
                e2 = 0.0f;
            } else {
                e2 = oVar.e(this);
            }
            SVG.o oVar2 = pVar.p;
            if (oVar2 == null) {
                f2 = 0.0f;
            } else {
                f2 = oVar2.f(this);
            }
            SVG.o oVar3 = pVar.q;
            if (oVar3 == null) {
                e3 = 0.0f;
            } else {
                e3 = oVar3.e(this);
            }
            SVG.o oVar4 = pVar.r;
            if (oVar4 != null) {
                f3 = oVar4.f(this);
            }
            if (pVar.h == null) {
                pVar.h = new SVG.b(Math.min(e2, e3), Math.min(f2, f3), Math.abs(e3 - e2), Math.abs(f3 - f2));
            }
            Path path = new Path();
            path.moveTo(e2, f2);
            path.lineTo(e3, f3);
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void w0(SVG.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, dVar) == null) {
            G("Circle render", new Object[0]);
            SVG.o oVar = dVar.q;
            if (oVar != null && !oVar.h()) {
                e1(this.d, dVar);
                if (!I() || !g1()) {
                    return;
                }
                Matrix matrix = dVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path g0 = g0(dVar);
                c1(dVar);
                x(dVar);
                u(dVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(dVar, g0);
                }
                if (this.d.c) {
                    K(g0);
                }
                if (u0) {
                    r0(dVar);
                }
            }
        }
    }

    public final void x0(SVG.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, iVar) == null) {
            G("Ellipse render", new Object[0]);
            SVG.o oVar = iVar.q;
            if (oVar != null && iVar.r != null && !oVar.h() && !iVar.r.h()) {
                e1(this.d, iVar);
                if (!I() || !g1()) {
                    return;
                }
                Matrix matrix = iVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path h0 = h0(iVar);
                c1(iVar);
                x(iVar);
                u(iVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(iVar, h0);
                }
                if (this.d.c) {
                    K(h0);
                }
                if (u0) {
                    r0(iVar);
                }
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.restore();
            this.d = this.e.pop();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            iz9.a(this.a, iz9.a);
            this.e.push(this.d);
            this.d = new h(this, this.d);
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Boolean bool = this.d.a.A;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.d.a.m.floatValue() >= 1.0f && this.d.a.G == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final SVG.Style.TextAnchor W() {
        InterceptResult invokeV;
        SVG.Style.TextAnchor textAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            SVG.Style style = this.d.a;
            if (style.t != SVG.Style.TextDirection.LTR && (textAnchor = style.u) != SVG.Style.TextAnchor.Middle) {
                SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
                if (textAnchor == textAnchor2) {
                    return SVG.Style.TextAnchor.End;
                }
                return textAnchor2;
            }
            return this.d.a.u;
        }
        return (SVG.Style.TextAnchor) invokeV.objValue;
    }

    public final Path.FillType X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SVG.Style.FillRule fillRule = this.d.a.F;
            if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
                return Path.FillType.EVEN_ODD;
            }
            return Path.FillType.WINDING;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public float Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.d.d.getTextSize();
        }
        return invokeV.floatValue;
    }

    public float Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.d.d.getTextSize() / 2.0f;
        }
        return invokeV.floatValue;
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.restore();
            this.d = this.e.pop();
        }
    }

    public SVG.b a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            h hVar = this.d;
            SVG.b bVar = hVar.g;
            if (bVar != null) {
                return bVar;
            }
            return hVar.f;
        }
        return (SVG.b) invokeV.objValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.a.save();
            this.e.push(this.d);
            this.d = new h(this, this.d);
        }
    }

    public float b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public final Path.FillType c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            SVG.Style.FillRule fillRule = this.d.a.c;
            if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
                return Path.FillType.EVEN_ODD;
            }
            return Path.FillType.WINDING;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Boolean bool = this.d.a.B;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.f.pop();
            this.g.pop();
        }
    }

    public final void H(boolean z, SVG.b bVar, SVG.t tVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), bVar, tVar}) == null) {
            SVG.l0 p = this.c.p(tVar.a);
            if (p == null) {
                Object[] objArr = new Object[2];
                if (z) {
                    str = "Fill";
                } else {
                    str = "Stroke";
                }
                objArr[0] = str;
                objArr[1] = tVar.a;
                N("%s reference '%s' not found", objArr);
                SVG.m0 m0Var = tVar.b;
                if (m0Var != null) {
                    X0(this.d, z, m0Var);
                } else if (z) {
                    this.d.b = false;
                } else {
                    this.d.c = false;
                }
            } else if (p instanceof SVG.k0) {
                f0(z, bVar, (SVG.k0) p);
            } else if (p instanceof SVG.o0) {
                m0(z, bVar, (SVG.o0) p);
            } else if (p instanceof SVG.b0) {
                Y0(z, (SVG.b0) p);
            }
        }
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path j0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048636, this, kVar, path, matrix) == null) {
            e1(this.d, kVar);
            if (!I() || !g1()) {
                return;
            }
            Matrix matrix2 = kVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (kVar instanceof SVG.a0) {
                j0 = k0((SVG.a0) kVar);
            } else if (kVar instanceof SVG.d) {
                j0 = g0((SVG.d) kVar);
            } else if (kVar instanceof SVG.i) {
                j0 = h0((SVG.i) kVar);
            } else if (kVar instanceof SVG.y) {
                j0 = j0((SVG.y) kVar);
            } else {
                return;
            }
            u(kVar);
            path.setFillType(X());
            path.addPath(j0, matrix);
        }
    }

    public final void H0(SVG.d0 d0Var, SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, d0Var, bVar, bVar2, preserveAspectRatio) == null) {
            G("Svg render", new Object[0]);
            if (bVar.c != 0.0f && bVar.d != 0.0f) {
                if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                    preserveAspectRatio = PreserveAspectRatio.d;
                }
                e1(this.d, d0Var);
                if (!I()) {
                    return;
                }
                h hVar = this.d;
                hVar.f = bVar;
                if (!hVar.a.v.booleanValue()) {
                    SVG.b bVar3 = this.d.f;
                    W0(bVar3.a, bVar3.b, bVar3.c, bVar3.d);
                }
                v(d0Var, this.d.f);
                if (bVar2 != null) {
                    this.a.concat(t(this.d.f, bVar2, preserveAspectRatio));
                    this.d.g = d0Var.o;
                } else {
                    Canvas canvas = this.a;
                    SVG.b bVar4 = this.d.f;
                    canvas.translate(bVar4.a, bVar4.b);
                }
                boolean u0 = u0();
                f1();
                N0(d0Var, true);
                if (u0) {
                    r0(d0Var);
                }
                c1(d0Var);
            }
        }
    }

    public final void W0(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            SVG.c cVar = this.d.a.w;
            if (cVar != null) {
                f2 += cVar.d.e(this);
                f3 += this.d.a.w.a.f(this);
                f6 -= this.d.a.w.b.e(this);
                f7 -= this.d.a.w.c.f(this);
            }
            this.a.clipRect(f2, f3, f6, f7);
        }
    }

    public final void j(SVG.l0 l0Var, boolean z, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048640, this, new Object[]{l0Var, Boolean.valueOf(z), path, matrix}) != null) || !I()) {
            return;
        }
        E();
        if (l0Var instanceof SVG.b1) {
            if (z) {
                l((SVG.b1) l0Var, path, matrix);
            } else {
                N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
        } else if (l0Var instanceof SVG.u) {
            i((SVG.u) l0Var, path, matrix);
        } else if (l0Var instanceof SVG.u0) {
            k((SVG.u0) l0Var, path, matrix);
        } else if (l0Var instanceof SVG.k) {
            h((SVG.k) l0Var, path, matrix);
        } else {
            N("Invalid %s element found in clipPath definition", l0Var.toString());
        }
        D();
    }

    public final void I0(SVG.l0 l0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, l0Var) != null) || (l0Var instanceof SVG.s)) {
            return;
        }
        a1();
        A(l0Var);
        if (l0Var instanceof SVG.d0) {
            F0((SVG.d0) l0Var);
        } else if (l0Var instanceof SVG.b1) {
            M0((SVG.b1) l0Var);
        } else if (l0Var instanceof SVG.q0) {
            J0((SVG.q0) l0Var);
        } else if (l0Var instanceof SVG.l) {
            y0((SVG.l) l0Var);
        } else if (l0Var instanceof SVG.n) {
            z0((SVG.n) l0Var);
        } else if (l0Var instanceof SVG.u) {
            B0((SVG.u) l0Var);
        } else if (l0Var instanceof SVG.a0) {
            E0((SVG.a0) l0Var);
        } else if (l0Var instanceof SVG.d) {
            w0((SVG.d) l0Var);
        } else if (l0Var instanceof SVG.i) {
            x0((SVG.i) l0Var);
        } else if (l0Var instanceof SVG.p) {
            A0((SVG.p) l0Var);
        } else if (l0Var instanceof SVG.z) {
            D0((SVG.z) l0Var);
        } else if (l0Var instanceof SVG.y) {
            C0((SVG.y) l0Var);
        } else if (l0Var instanceof SVG.u0) {
            L0((SVG.u0) l0Var);
        }
        Z0();
    }

    public final void T0(SVG.x0 x0Var) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, x0Var) == null) {
            G("TextPath render", new Object[0]);
            e1(this.d, x0Var);
            if (!I() || !g1()) {
                return;
            }
            SVG.l0 p = x0Var.a.p(x0Var.n);
            if (p == null) {
                N("TextPath reference '%s' not found", x0Var.n);
                return;
            }
            SVG.u uVar = (SVG.u) p;
            Path f3 = new d(this, uVar.o).f();
            Matrix matrix = uVar.n;
            if (matrix != null) {
                f3.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(f3, false);
            SVG.o oVar = x0Var.o;
            if (oVar != null) {
                f2 = oVar.d(this, pathMeasure.getLength());
            } else {
                f2 = 0.0f;
            }
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(x0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                f2 -= s;
            }
            x((SVG.i0) x0Var.c());
            boolean u0 = u0();
            M(x0Var, new e(this, f3, f2, 0.0f));
            if (u0) {
                r0(x0Var);
            }
        }
    }

    public final Path h0(SVG.i iVar) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, iVar)) == null) {
            SVG.o oVar = iVar.o;
            float f3 = 0.0f;
            if (oVar != null) {
                f2 = oVar.e(this);
            } else {
                f2 = 0.0f;
            }
            SVG.o oVar2 = iVar.p;
            if (oVar2 != null) {
                f3 = oVar2.f(this);
            }
            float e2 = iVar.q.e(this);
            float f4 = iVar.r.f(this);
            float f5 = f2 - e2;
            float f6 = f3 - f4;
            float f7 = f2 + e2;
            float f8 = f3 + f4;
            if (iVar.h == null) {
                iVar.h = new SVG.b(f5, f6, e2 * 2.0f, 2.0f * f4);
            }
            float f9 = e2 * 0.5522848f;
            float f10 = 0.5522848f * f4;
            Path path = new Path();
            path.moveTo(f2, f6);
            float f11 = f2 + f9;
            float f12 = f3 - f10;
            path.cubicTo(f11, f6, f7, f12, f7, f3);
            float f13 = f10 + f3;
            path.cubicTo(f7, f13, f11, f8, f2, f8);
            float f14 = f2 - f9;
            path.cubicTo(f14, f8, f5, f13, f5, f3);
            path.cubicTo(f5, f12, f14, f6, f2, f6);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path l0(SVG.u0 u0Var) {
        InterceptResult invokeL;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, u0Var)) == null) {
            List<SVG.o> list = u0Var.n;
            float f5 = 0.0f;
            if (list != null && list.size() != 0) {
                f2 = u0Var.n.get(0).e(this);
            } else {
                f2 = 0.0f;
            }
            List<SVG.o> list2 = u0Var.o;
            if (list2 != null && list2.size() != 0) {
                f3 = u0Var.o.get(0).f(this);
            } else {
                f3 = 0.0f;
            }
            List<SVG.o> list3 = u0Var.p;
            if (list3 != null && list3.size() != 0) {
                f4 = u0Var.p.get(0).e(this);
            } else {
                f4 = 0.0f;
            }
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f5 = u0Var.q.get(0).f(this);
            }
            if (this.d.a.u != SVG.Style.TextAnchor.Start) {
                float s = s(u0Var);
                if (this.d.a.u == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                f2 -= s;
            }
            if (u0Var.h == null) {
                i iVar = new i(this, f2, f3);
                M(u0Var, iVar);
                RectF rectF = iVar.c;
                u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            Path path = new Path();
            M(u0Var, new g(this, f2 + f4, f3 + f5, path));
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final List<c> q(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, yVar)) == null) {
            int length = yVar.o.length;
            int i2 = 2;
            if (length < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            float[] fArr = yVar.o;
            c cVar = new c(this, fArr[0], fArr[1], 0.0f, 0.0f);
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (i2 < length) {
                float[] fArr2 = yVar.o;
                float f4 = fArr2[i2];
                float f5 = fArr2[i2 + 1];
                cVar.a(f4, f5);
                arrayList.add(cVar);
                i2 += 2;
                cVar = new c(this, f4, f5, f4 - cVar.a, f5 - cVar.b);
                f3 = f5;
                f2 = f4;
            }
            if (yVar instanceof SVG.z) {
                float[] fArr3 = yVar.o;
                if (f2 != fArr3[0] && f3 != fArr3[1]) {
                    float f6 = fArr3[0];
                    float f7 = fArr3[1];
                    cVar.a(f6, f7);
                    arrayList.add(cVar);
                    c cVar2 = new c(this, f6, f7, f6 - cVar.a, f7 - cVar.b);
                    cVar2.b((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            } else {
                arrayList.add(cVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void K0(SVG.r0 r0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, r0Var, bVar) == null) {
            G("Symbol render", new Object[0]);
            if (bVar.c != 0.0f && bVar.d != 0.0f) {
                PreserveAspectRatio preserveAspectRatio = r0Var.n;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.d;
                }
                e1(this.d, r0Var);
                h hVar = this.d;
                hVar.f = bVar;
                if (!hVar.a.v.booleanValue()) {
                    SVG.b bVar2 = this.d.f;
                    W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
                }
                SVG.b bVar3 = r0Var.o;
                if (bVar3 != null) {
                    this.a.concat(t(this.d.f, bVar3, preserveAspectRatio));
                    this.d.g = r0Var.o;
                } else {
                    Canvas canvas = this.a;
                    SVG.b bVar4 = this.d.f;
                    canvas.translate(bVar4.a, bVar4.b);
                }
                boolean u0 = u0();
                N0(r0Var, true);
                if (u0) {
                    r0(r0Var);
                }
                c1(r0Var);
            }
        }
    }

    public final void P(SVG.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, jVar, str) == null) {
            SVG.l0 p = jVar.a.p(str);
            if (p == null) {
                h1("Gradient reference '%s' not found", str);
            } else if (!(p instanceof SVG.j)) {
                N("Gradient href attributes must point to other gradient elements", new Object[0]);
            } else if (p == jVar) {
                N("Circular reference in gradient href attribute '%s'", str);
            } else {
                SVG.j jVar2 = (SVG.j) p;
                if (jVar.i == null) {
                    jVar.i = jVar2.i;
                }
                if (jVar.j == null) {
                    jVar.j = jVar2.j;
                }
                if (jVar.k == null) {
                    jVar.k = jVar2.k;
                }
                if (jVar.h.isEmpty()) {
                    jVar.h = jVar2.h;
                }
                try {
                    if (jVar instanceof SVG.k0) {
                        Q((SVG.k0) jVar, (SVG.k0) p);
                    } else {
                        R((SVG.o0) jVar, (SVG.o0) p);
                    }
                } catch (ClassCastException unused) {
                }
                String str2 = jVar2.l;
                if (str2 != null) {
                    P(jVar, str2);
                }
            }
        }
    }

    public final void L0(SVG.u0 u0Var) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, u0Var) == null) {
            G("Text render", new Object[0]);
            e1(this.d, u0Var);
            if (!I()) {
                return;
            }
            Matrix matrix = u0Var.r;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            List<SVG.o> list = u0Var.n;
            float f5 = 0.0f;
            if (list != null && list.size() != 0) {
                f2 = u0Var.n.get(0).e(this);
            } else {
                f2 = 0.0f;
            }
            List<SVG.o> list2 = u0Var.o;
            if (list2 != null && list2.size() != 0) {
                f3 = u0Var.o.get(0).f(this);
            } else {
                f3 = 0.0f;
            }
            List<SVG.o> list3 = u0Var.p;
            if (list3 != null && list3.size() != 0) {
                f4 = u0Var.p.get(0).e(this);
            } else {
                f4 = 0.0f;
            }
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f5 = u0Var.q.get(0).f(this);
            }
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(u0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                f2 -= s;
            }
            if (u0Var.h == null) {
                i iVar = new i(this, f2, f3);
                M(u0Var, iVar);
                RectF rectF = iVar.c;
                u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            c1(u0Var);
            x(u0Var);
            u(u0Var);
            boolean u0 = u0();
            M(u0Var, new f(this, f2 + f4, f3 + f5));
            if (u0) {
                r0(u0Var);
            }
        }
    }

    public final void M0(SVG.b1 b1Var) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b1Var) == null) {
            G("Use render", new Object[0]);
            SVG.o oVar = b1Var.r;
            if (oVar == null || !oVar.h()) {
                SVG.o oVar2 = b1Var.s;
                if (oVar2 != null && oVar2.h()) {
                    return;
                }
                e1(this.d, b1Var);
                if (!I()) {
                    return;
                }
                SVG.l0 p = b1Var.a.p(b1Var.o);
                if (p == null) {
                    N("Use reference '%s' not found", b1Var.o);
                    return;
                }
                Matrix matrix = b1Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                SVG.o oVar3 = b1Var.p;
                float f3 = 0.0f;
                if (oVar3 != null) {
                    f2 = oVar3.e(this);
                } else {
                    f2 = 0.0f;
                }
                SVG.o oVar4 = b1Var.q;
                if (oVar4 != null) {
                    f3 = oVar4.f(this);
                }
                this.a.translate(f2, f3);
                u(b1Var);
                boolean u0 = u0();
                q0(b1Var);
                if (p instanceof SVG.d0) {
                    SVG.b n0 = n0(null, null, b1Var.r, b1Var.s);
                    a1();
                    G0((SVG.d0) p, n0);
                    Z0();
                } else if (p instanceof SVG.r0) {
                    SVG.o oVar5 = b1Var.r;
                    if (oVar5 == null) {
                        oVar5 = new SVG.o(100.0f, SVG.Unit.percent);
                    }
                    SVG.o oVar6 = b1Var.s;
                    if (oVar6 == null) {
                        oVar6 = new SVG.o(100.0f, SVG.Unit.percent);
                    }
                    SVG.b n02 = n0(null, null, oVar5, oVar6);
                    a1();
                    K0((SVG.r0) p, n02);
                    Z0();
                } else {
                    I0(p);
                }
                p0();
                if (u0) {
                    r0(b1Var);
                }
                c1(b1Var);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q0(SVG.k kVar) {
        SVG.q qVar;
        String str;
        SVG.q qVar2;
        String str2;
        SVG.q qVar3;
        List<c> q;
        int size;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, kVar) == null) {
            SVG.Style style = this.d.a;
            if (style.x == null && style.y == null && style.z == null) {
                return;
            }
            String str3 = this.d.a.x;
            if (str3 != null) {
                SVG.l0 p = kVar.a.p(str3);
                if (p != null) {
                    qVar = (SVG.q) p;
                    str = this.d.a.y;
                    if (str != null) {
                        SVG.l0 p2 = kVar.a.p(str);
                        if (p2 != null) {
                            qVar2 = (SVG.q) p2;
                            str2 = this.d.a.z;
                            if (str2 != null) {
                                SVG.l0 p3 = kVar.a.p(str2);
                                if (p3 != null) {
                                    qVar3 = (SVG.q) p3;
                                    if (!(kVar instanceof SVG.u)) {
                                        q = new b(this, ((SVG.u) kVar).o).f();
                                    } else if (kVar instanceof SVG.p) {
                                        q = p((SVG.p) kVar);
                                    } else {
                                        q = q((SVG.y) kVar);
                                    }
                                    if (q != null || (size = q.size()) == 0) {
                                        return;
                                    }
                                    SVG.Style style2 = this.d.a;
                                    style2.z = null;
                                    style2.y = null;
                                    style2.x = null;
                                    if (qVar != null) {
                                        P0(qVar, q.get(0));
                                    }
                                    if (qVar2 != null && q.size() > 2) {
                                        c cVar = q.get(1);
                                        i2 = 1;
                                        c cVar2 = q.get(0);
                                        c cVar3 = cVar;
                                        while (i2 < size - 1) {
                                            i2++;
                                            c cVar4 = q.get(i2);
                                            if (cVar3.e) {
                                                v0(cVar2, cVar3, cVar4);
                                            }
                                            P0(qVar2, cVar3);
                                            cVar2 = cVar3;
                                            cVar3 = cVar4;
                                        }
                                    }
                                    if (qVar3 == null) {
                                        P0(qVar3, q.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                N("Marker reference '%s' not found", this.d.a.z);
                            }
                            qVar3 = null;
                            if (!(kVar instanceof SVG.u)) {
                            }
                            if (q != null) {
                                return;
                            }
                            SVG.Style style22 = this.d.a;
                            style22.z = null;
                            style22.y = null;
                            style22.x = null;
                            if (qVar != null) {
                            }
                            if (qVar2 != null) {
                                c cVar5 = q.get(1);
                                i2 = 1;
                                c cVar22 = q.get(0);
                                c cVar32 = cVar5;
                                while (i2 < size - 1) {
                                }
                            }
                            if (qVar3 == null) {
                            }
                        } else {
                            N("Marker reference '%s' not found", this.d.a.y);
                        }
                    }
                    qVar2 = null;
                    str2 = this.d.a.z;
                    if (str2 != null) {
                    }
                    qVar3 = null;
                    if (!(kVar instanceof SVG.u)) {
                    }
                    if (q != null) {
                    }
                } else {
                    N("Marker reference '%s' not found", this.d.a.x);
                }
            }
            qVar = null;
            str = this.d.a.y;
            if (str != null) {
            }
            qVar2 = null;
            str2 = this.d.a.z;
            if (str2 != null) {
            }
            qVar3 = null;
            if (!(kVar instanceof SVG.u)) {
            }
            if (q != null) {
            }
        }
    }

    public final void S0(SVG.q0 q0Var) {
        Set<String> f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, q0Var) == null) {
            String language = Locale.getDefault().getLanguage();
            oz9 g2 = SVG.g();
            for (SVG.l0 l0Var : q0Var.getChildren()) {
                if (l0Var instanceof SVG.e0) {
                    SVG.e0 e0Var = (SVG.e0) l0Var;
                    if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                        Set<String> h2 = e0Var.h();
                        if (h2 != null) {
                            if (i == null) {
                                d0();
                            }
                            if (!h2.isEmpty() && i.containsAll(h2)) {
                            }
                        }
                        Set<String> e2 = e0Var.e();
                        if (e2 != null) {
                            if (!e2.isEmpty() && g2 != null) {
                                for (String str : e2) {
                                    if (!g2.a(str)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> m = e0Var.m();
                        if (m != null) {
                            if (!m.isEmpty() && g2 != null) {
                                for (String str2 : m) {
                                    if (g2.c(str2, this.d.a.q.intValue(), String.valueOf(this.d.a.r)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        I0(l0Var);
                        return;
                    }
                }
            }
        }
    }

    public final void c1(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, i0Var) != null) || i0Var.b == null || i0Var.h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.g.peek().invert(matrix)) {
            SVG.b bVar = i0Var.h;
            SVG.b bVar2 = i0Var.h;
            SVG.b bVar3 = i0Var.h;
            float[] fArr = {bVar.a, bVar.b, bVar.b(), bVar2.b, bVar2.b(), i0Var.h.c(), bVar3.a, bVar3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.i0 i0Var2 = (SVG.i0) this.f.peek();
            SVG.b bVar4 = i0Var2.h;
            if (bVar4 == null) {
                i0Var2.h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.d(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public final Path k0(SVG.a0 a0Var) {
        InterceptResult invokeL;
        float e2;
        float f2;
        float f3;
        float f4;
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, a0Var)) == null) {
            if (a0Var.s == null && a0Var.t == null) {
                e2 = 0.0f;
                f2 = 0.0f;
            } else {
                SVG.o oVar = a0Var.s;
                if (oVar == null) {
                    e2 = a0Var.t.f(this);
                } else if (a0Var.t == null) {
                    e2 = oVar.e(this);
                } else {
                    e2 = oVar.e(this);
                    f2 = a0Var.t.f(this);
                }
                f2 = e2;
            }
            float min = Math.min(e2, a0Var.q.e(this) / 2.0f);
            float min2 = Math.min(f2, a0Var.r.f(this) / 2.0f);
            SVG.o oVar2 = a0Var.o;
            if (oVar2 != null) {
                f3 = oVar2.e(this);
            } else {
                f3 = 0.0f;
            }
            SVG.o oVar3 = a0Var.p;
            if (oVar3 != null) {
                f4 = oVar3.f(this);
            } else {
                f4 = 0.0f;
            }
            float e3 = a0Var.q.e(this);
            float f5 = a0Var.r.f(this);
            if (a0Var.h == null) {
                a0Var.h = new SVG.b(f3, f4, e3, f5);
            }
            float f6 = f3 + e3;
            float f7 = f4 + f5;
            Path path2 = new Path();
            if (min != 0.0f && min2 != 0.0f) {
                float f8 = min * 0.5522848f;
                float f9 = 0.5522848f * min2;
                float f10 = f4 + min2;
                path2.moveTo(f3, f10);
                float f11 = f10 - f9;
                float f12 = f3 + min;
                float f13 = f12 - f8;
                path2.cubicTo(f3, f11, f13, f4, f12, f4);
                float f14 = f6 - min;
                path2.lineTo(f14, f4);
                float f15 = f14 + f8;
                path2.cubicTo(f15, f4, f6, f11, f6, f10);
                float f16 = f7 - min2;
                path2.lineTo(f6, f16);
                float f17 = f16 + f9;
                path = path2;
                path2.cubicTo(f6, f17, f15, f7, f14, f7);
                path.lineTo(f12, f7);
                path.cubicTo(f13, f7, f3, f17, f3, f16);
                path.lineTo(f3, f10);
            } else {
                path = path2;
                path.moveTo(f3, f4);
                path.lineTo(f6, f4);
                path.lineTo(f6, f7);
                path.lineTo(f3, f7);
                path.lineTo(f3, f4);
            }
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void z0(SVG.n nVar) {
        SVG.o oVar;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, nVar) == null) {
            int i2 = 0;
            G("Image render", new Object[0]);
            SVG.o oVar2 = nVar.r;
            if (oVar2 == null || oVar2.h() || (oVar = nVar.s) == null || oVar.h() || nVar.o == null) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = nVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.d;
            }
            Bitmap y = y(nVar.o);
            if (y == null) {
                oz9 g2 = SVG.g();
                if (g2 == null) {
                    return;
                }
                y = g2.d(nVar.o);
            }
            if (y == null) {
                N("Could not locate image '%s'", nVar.o);
                return;
            }
            SVG.b bVar = new SVG.b(0.0f, 0.0f, y.getWidth(), y.getHeight());
            e1(this.d, nVar);
            if (!I() || !g1()) {
                return;
            }
            Matrix matrix = nVar.t;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            SVG.o oVar3 = nVar.p;
            if (oVar3 != null) {
                f2 = oVar3.e(this);
            } else {
                f2 = 0.0f;
            }
            SVG.o oVar4 = nVar.q;
            if (oVar4 != null) {
                f3 = oVar4.f(this);
            } else {
                f3 = 0.0f;
            }
            this.d.f = new SVG.b(f2, f3, nVar.r.e(this), nVar.s.e(this));
            if (!this.d.a.v.booleanValue()) {
                SVG.b bVar2 = this.d.f;
                W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
            }
            nVar.h = this.d.f;
            c1(nVar);
            u(nVar);
            boolean u0 = u0();
            f1();
            this.a.save();
            this.a.concat(t(this.d.f, bVar, preserveAspectRatio));
            if (this.d.a.M != SVG.Style.RenderQuality.optimizeSpeed) {
                i2 = 2;
            }
            this.a.drawBitmap(y, 0.0f, 0.0f, new Paint(i2));
            this.a.restore();
            if (u0) {
                r0(nVar);
            }
        }
    }

    public void O0(SVG svg, mz9 mz9Var) {
        SVG.b bVar;
        SVG.b bVar2;
        PreserveAspectRatio preserveAspectRatio;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, svg, mz9Var) == null) {
            if (mz9Var != null) {
                this.c = svg;
                SVG.d0 l = svg.l();
                if (l == null) {
                    h1("Nothing to render. Document is empty.", new Object[0]);
                    return;
                }
                if (mz9Var.e()) {
                    SVG.j0 f2 = this.c.f(mz9Var.e);
                    if (f2 != null && (f2 instanceof SVG.c1)) {
                        SVG.c1 c1Var = (SVG.c1) f2;
                        bVar2 = c1Var.o;
                        if (bVar2 == null) {
                            Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", mz9Var.e));
                            return;
                        }
                        preserveAspectRatio = c1Var.n;
                    } else {
                        Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", mz9Var.e));
                        return;
                    }
                } else {
                    if (mz9Var.f()) {
                        bVar = mz9Var.d;
                    } else {
                        bVar = l.o;
                    }
                    bVar2 = bVar;
                    if (mz9Var.c()) {
                        preserveAspectRatio = mz9Var.b;
                    } else {
                        preserveAspectRatio = l.n;
                    }
                }
                if (mz9Var.b()) {
                    svg.a(mz9Var.a);
                }
                if (mz9Var.d()) {
                    CSSParser.m mVar = new CSSParser.m();
                    this.h = mVar;
                    mVar.a = svg.f(mz9Var.c);
                }
                V0();
                A(l);
                a1();
                SVG.b bVar3 = new SVG.b(mz9Var.f);
                SVG.o oVar = l.r;
                if (oVar != null) {
                    bVar3.c = oVar.d(this, bVar3.c);
                }
                SVG.o oVar2 = l.s;
                if (oVar2 != null) {
                    bVar3.d = oVar2.d(this, bVar3.d);
                }
                H0(l, bVar3, bVar2, preserveAspectRatio);
                Z0();
                if (mz9Var.b()) {
                    svg.b();
                    return;
                }
                return;
            }
            throw new NullPointerException("renderOptions shouldn't be null");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x010c, code lost:
        if (r7 != 8) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P0(SVG.q qVar, c cVar) {
        float f2;
        float b2;
        SVG.o oVar;
        float f3;
        SVG.o oVar2;
        float f4;
        SVG.o oVar3;
        float f5;
        SVG.o oVar4;
        SVG.b bVar;
        boolean u0;
        float f6;
        float f7;
        float f8;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, qVar, cVar) == null) {
            a1();
            Float f9 = qVar.u;
            float f10 = 0.0f;
            if (f9 != null) {
                if (Float.isNaN(f9.floatValue())) {
                    if (cVar.c != 0.0f || cVar.d != 0.0f) {
                        f2 = (float) Math.toDegrees(Math.atan2(cVar.d, cVar.c));
                    }
                } else {
                    f2 = qVar.u.floatValue();
                }
                if (!qVar.p) {
                    b2 = 1.0f;
                } else {
                    b2 = this.d.a.g.b(this.b);
                }
                this.d = U(qVar);
                Matrix matrix = new Matrix();
                matrix.preTranslate(cVar.a, cVar.b);
                matrix.preRotate(f2);
                matrix.preScale(b2, b2);
                oVar = qVar.q;
                if (oVar == null) {
                    f3 = oVar.e(this);
                } else {
                    f3 = 0.0f;
                }
                oVar2 = qVar.r;
                if (oVar2 == null) {
                    f4 = oVar2.f(this);
                } else {
                    f4 = 0.0f;
                }
                oVar3 = qVar.s;
                float f11 = 3.0f;
                if (oVar3 == null) {
                    f5 = oVar3.e(this);
                } else {
                    f5 = 3.0f;
                }
                oVar4 = qVar.t;
                if (oVar4 != null) {
                    f11 = oVar4.f(this);
                }
                bVar = qVar.o;
                if (bVar == null) {
                    float f12 = f5 / bVar.c;
                    float f13 = f11 / bVar.d;
                    PreserveAspectRatio preserveAspectRatio = qVar.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.d;
                    }
                    if (!preserveAspectRatio.equals(PreserveAspectRatio.c)) {
                        if (preserveAspectRatio.b() == PreserveAspectRatio.Scale.slice) {
                            min = Math.max(f12, f13);
                        } else {
                            min = Math.min(f12, f13);
                        }
                        f12 = min;
                        f13 = f12;
                    }
                    matrix.preTranslate((-f3) * f12, (-f4) * f13);
                    this.a.concat(matrix);
                    SVG.b bVar2 = qVar.o;
                    float f14 = bVar2.c * f12;
                    float f15 = bVar2.d * f13;
                    switch (a.a[preserveAspectRatio.a().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            f6 = (f5 - f14) / 2.0f;
                            f7 = 0.0f - f6;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            f6 = f5 - f14;
                            f7 = 0.0f - f6;
                            break;
                        default:
                            f7 = 0.0f;
                            break;
                    }
                    int i2 = a.a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 != 7) {
                                    }
                                }
                            }
                        }
                        f8 = f11 - f15;
                        f10 = 0.0f - f8;
                        if (!this.d.a.v.booleanValue()) {
                            W0(f7, f10, f5, f11);
                        }
                        matrix.reset();
                        matrix.preScale(f12, f13);
                        this.a.concat(matrix);
                    }
                    f8 = (f11 - f15) / 2.0f;
                    f10 = 0.0f - f8;
                    if (!this.d.a.v.booleanValue()) {
                    }
                    matrix.reset();
                    matrix.preScale(f12, f13);
                    this.a.concat(matrix);
                } else {
                    matrix.preTranslate(-f3, -f4);
                    this.a.concat(matrix);
                    if (!this.d.a.v.booleanValue()) {
                        W0(0.0f, 0.0f, f5, f11);
                    }
                }
                u0 = u0();
                N0(qVar, false);
                if (u0) {
                    r0(qVar);
                }
                Z0();
            }
            f2 = 0.0f;
            if (!qVar.p) {
            }
            this.d = U(qVar);
            Matrix matrix2 = new Matrix();
            matrix2.preTranslate(cVar.a, cVar.b);
            matrix2.preRotate(f2);
            matrix2.preScale(b2, b2);
            oVar = qVar.q;
            if (oVar == null) {
            }
            oVar2 = qVar.r;
            if (oVar2 == null) {
            }
            oVar3 = qVar.s;
            float f112 = 3.0f;
            if (oVar3 == null) {
            }
            oVar4 = qVar.t;
            if (oVar4 != null) {
            }
            bVar = qVar.o;
            if (bVar == null) {
            }
            u0 = u0();
            N0(qVar, false);
            if (u0) {
            }
            Z0();
        }
    }

    @TargetApi(19)
    public final Path o0(SVG.i0 i0Var, boolean z) {
        InterceptResult invokeLZ;
        Path l0;
        Path o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048649, this, i0Var, z)) == null) {
            this.e.push(this.d);
            h hVar = new h(this, this.d);
            this.d = hVar;
            e1(hVar, i0Var);
            if (I() && g1()) {
                if (i0Var instanceof SVG.b1) {
                    if (!z) {
                        N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                    }
                    SVG.b1 b1Var = (SVG.b1) i0Var;
                    SVG.l0 p = i0Var.a.p(b1Var.o);
                    if (p == null) {
                        N("Use reference '%s' not found", b1Var.o);
                        this.d = this.e.pop();
                        return null;
                    } else if (!(p instanceof SVG.i0)) {
                        this.d = this.e.pop();
                        return null;
                    } else {
                        l0 = o0((SVG.i0) p, false);
                        if (l0 == null) {
                            return null;
                        }
                        if (b1Var.h == null) {
                            b1Var.h = r(l0);
                        }
                        Matrix matrix = b1Var.n;
                        if (matrix != null) {
                            l0.transform(matrix);
                        }
                    }
                } else if (i0Var instanceof SVG.k) {
                    SVG.k kVar = (SVG.k) i0Var;
                    if (i0Var instanceof SVG.u) {
                        l0 = new d(this, ((SVG.u) i0Var).o).f();
                        if (i0Var.h == null) {
                            i0Var.h = r(l0);
                        }
                    } else {
                        l0 = i0Var instanceof SVG.a0 ? k0((SVG.a0) i0Var) : i0Var instanceof SVG.d ? g0((SVG.d) i0Var) : i0Var instanceof SVG.i ? h0((SVG.i) i0Var) : i0Var instanceof SVG.y ? j0((SVG.y) i0Var) : null;
                    }
                    if (l0 == null) {
                        return null;
                    }
                    if (kVar.h == null) {
                        kVar.h = r(l0);
                    }
                    Matrix matrix2 = kVar.n;
                    if (matrix2 != null) {
                        l0.transform(matrix2);
                    }
                    l0.setFillType(X());
                } else if (i0Var instanceof SVG.u0) {
                    SVG.u0 u0Var = (SVG.u0) i0Var;
                    l0 = l0(u0Var);
                    if (l0 == null) {
                        return null;
                    }
                    Matrix matrix3 = u0Var.r;
                    if (matrix3 != null) {
                        l0.transform(matrix3);
                    }
                    l0.setFillType(X());
                } else {
                    N("Invalid %s element found in clipPath definition", i0Var.n());
                    return null;
                }
                if (this.d.a.E != null && (o = o(i0Var, i0Var.h)) != null) {
                    l0.op(o, Path.Op.INTERSECT);
                }
                this.d = this.e.pop();
                return l0;
            }
            this.d = this.e.pop();
            return null;
        }
        return (Path) invokeLZ.objValue;
    }

    public final void t0(SVG.l0 l0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        SVG.Style.TextAnchor W;
        float e2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048659, this, l0Var, jVar) != null) || !jVar.a((SVG.w0) l0Var)) {
            return;
        }
        if (l0Var instanceof SVG.x0) {
            a1();
            T0((SVG.x0) l0Var);
            Z0();
            return;
        }
        boolean z = true;
        if (l0Var instanceof SVG.t0) {
            G("TSpan render", new Object[0]);
            a1();
            SVG.t0 t0Var = (SVG.t0) l0Var;
            e1(this.d, t0Var);
            if (I()) {
                List<SVG.o> list = t0Var.n;
                z = (list == null || list.size() <= 0) ? false : false;
                boolean z2 = jVar instanceof f;
                float f5 = 0.0f;
                if (z2) {
                    if (!z) {
                        e2 = ((f) jVar).a;
                    } else {
                        e2 = t0Var.n.get(0).e(this);
                    }
                    List<SVG.o> list2 = t0Var.o;
                    if (list2 != null && list2.size() != 0) {
                        f3 = t0Var.o.get(0).f(this);
                    } else {
                        f3 = ((f) jVar).b;
                    }
                    List<SVG.o> list3 = t0Var.p;
                    if (list3 != null && list3.size() != 0) {
                        f4 = t0Var.p.get(0).e(this);
                    } else {
                        f4 = 0.0f;
                    }
                    List<SVG.o> list4 = t0Var.q;
                    if (list4 != null && list4.size() != 0) {
                        f5 = t0Var.q.get(0).f(this);
                    }
                    f2 = f5;
                    f5 = e2;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                }
                if (z && (W = W()) != SVG.Style.TextAnchor.Start) {
                    float s = s(t0Var);
                    if (W == SVG.Style.TextAnchor.Middle) {
                        s /= 2.0f;
                    }
                    f5 -= s;
                }
                x((SVG.i0) t0Var.c());
                if (z2) {
                    f fVar = (f) jVar;
                    fVar.a = f5 + f4;
                    fVar.b = f3 + f2;
                }
                boolean u0 = u0();
                M(t0Var, jVar);
                if (u0) {
                    r0(t0Var);
                }
            }
            Z0();
        } else if (l0Var instanceof SVG.s0) {
            a1();
            SVG.s0 s0Var = (SVG.s0) l0Var;
            e1(this.d, s0Var);
            if (I()) {
                x((SVG.i0) s0Var.c());
                SVG.l0 p = l0Var.a.p(s0Var.n);
                if (p != null && (p instanceof SVG.w0)) {
                    StringBuilder sb = new StringBuilder();
                    O((SVG.w0) p, sb);
                    if (sb.length() > 0) {
                        jVar.b(sb.toString());
                    }
                } else {
                    N("Tref reference '%s' not found", s0Var.n);
                }
            }
            Z0();
        }
    }

    public final void R0(SVG.r rVar, SVG.i0 i0Var, SVG.b bVar) {
        boolean z;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, rVar, i0Var, bVar) == null) {
            G("Mask render", new Object[0]);
            Boolean bool = rVar.n;
            boolean z2 = true;
            if (bool != null && bool.booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                SVG.o oVar = rVar.r;
                if (oVar != null) {
                    f3 = oVar.e(this);
                } else {
                    f3 = bVar.c;
                }
                SVG.o oVar2 = rVar.s;
                if (oVar2 != null) {
                    f4 = oVar2.f(this);
                } else {
                    f4 = bVar.d;
                }
            } else {
                SVG.o oVar3 = rVar.r;
                float f5 = 1.2f;
                if (oVar3 != null) {
                    f2 = oVar3.d(this, 1.0f);
                } else {
                    f2 = 1.2f;
                }
                SVG.o oVar4 = rVar.s;
                if (oVar4 != null) {
                    f5 = oVar4.d(this, 1.0f);
                }
                f3 = f2 * bVar.c;
                f4 = f5 * bVar.d;
            }
            if (f3 != 0.0f && f4 != 0.0f) {
                a1();
                h U = U(rVar);
                this.d = U;
                U.a.m = Float.valueOf(1.0f);
                boolean u0 = u0();
                this.a.save();
                Boolean bool2 = rVar.o;
                if (bool2 != null && !bool2.booleanValue()) {
                    z2 = false;
                }
                if (!z2) {
                    this.a.translate(bVar.a, bVar.b);
                    this.a.scale(bVar.c, bVar.d);
                }
                N0(rVar, false);
                this.a.restore();
                if (u0) {
                    s0(i0Var, bVar);
                }
                Z0();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r11 != 8) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix t(SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        InterceptResult invokeLLL;
        float min;
        int i2;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048658, this, bVar, bVar2, preserveAspectRatio)) == null) {
            Matrix matrix = new Matrix();
            if (preserveAspectRatio != null && preserveAspectRatio.a() != null) {
                float f4 = bVar.c / bVar2.c;
                float f5 = bVar.d / bVar2.d;
                float f6 = -bVar2.a;
                float f7 = -bVar2.b;
                if (preserveAspectRatio.equals(PreserveAspectRatio.c)) {
                    matrix.preTranslate(bVar.a, bVar.b);
                    matrix.preScale(f4, f5);
                    matrix.preTranslate(f6, f7);
                    return matrix;
                }
                if (preserveAspectRatio.b() == PreserveAspectRatio.Scale.slice) {
                    min = Math.max(f4, f5);
                } else {
                    min = Math.min(f4, f5);
                }
                float f8 = bVar.c / min;
                float f9 = bVar.d / min;
                switch (a.a[preserveAspectRatio.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f3 = (bVar2.c - f8) / 2.0f;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 5) {
                                    if (i2 != 6) {
                                        if (i2 != 7) {
                                            break;
                                        }
                                    }
                                }
                            }
                            f2 = bVar2.d - f9;
                            f7 -= f2;
                            matrix.preTranslate(bVar.a, bVar.b);
                            matrix.preScale(min, min);
                            matrix.preTranslate(f6, f7);
                            break;
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(min, min);
                        matrix.preTranslate(f6, f7);
                    case 4:
                    case 5:
                    case 6:
                        f3 = bVar2.c - f8;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(min, min);
                        matrix.preTranslate(f6, f7);
                        break;
                    default:
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(min, min);
                        matrix.preTranslate(f6, f7);
                        break;
                }
            }
            return matrix;
        }
        return (Matrix) invokeLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (r7.equals(com.google.android.exoplayer2.C.SERIF_NAME) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Typeface z(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048670, this, str, num, fontStyle)) == null) {
            char c2 = 0;
            if (fontStyle == SVG.Style.FontStyle.Italic) {
                z = true;
            } else {
                z = false;
            }
            if (num.intValue() > 500) {
                if (z) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
            } else if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            switch (str.hashCode()) {
                case -1536685117:
                    if (str.equals("sans-serif")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1431958525:
                    if (str.equals("monospace")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1081737434:
                    if (str.equals("fantasy")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109326717:
                    break;
                case 1126973893:
                    if (str.equals("cursive")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                return null;
                            }
                            return Typeface.create(Typeface.SANS_SERIF, i2);
                        }
                        return Typeface.create(Typeface.SANS_SERIF, i2);
                    }
                    return Typeface.create(Typeface.MONOSPACE, i2);
                }
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            return Typeface.create(Typeface.SERIF, i2);
        }
        return (Typeface) invokeLLL.objValue;
    }

    public final void T(SVG.i0 i0Var, Path path, SVG.x xVar) {
        boolean z;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, i0Var, path, xVar) == null) {
            Boolean bool = xVar.p;
            if (bool != null && bool.booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            String str = xVar.w;
            if (str != null) {
                S(xVar, str);
            }
            if (z) {
                SVG.o oVar = xVar.s;
                if (oVar != null) {
                    f6 = oVar.e(this);
                } else {
                    f6 = 0.0f;
                }
                SVG.o oVar2 = xVar.t;
                if (oVar2 != null) {
                    f8 = oVar2.f(this);
                } else {
                    f8 = 0.0f;
                }
                SVG.o oVar3 = xVar.u;
                if (oVar3 != null) {
                    f9 = oVar3.e(this);
                } else {
                    f9 = 0.0f;
                }
                SVG.o oVar4 = xVar.v;
                if (oVar4 != null) {
                    f7 = oVar4.f(this);
                } else {
                    f7 = 0.0f;
                }
            } else {
                SVG.o oVar5 = xVar.s;
                if (oVar5 != null) {
                    f2 = oVar5.d(this, 1.0f);
                } else {
                    f2 = 0.0f;
                }
                SVG.o oVar6 = xVar.t;
                if (oVar6 != null) {
                    f3 = oVar6.d(this, 1.0f);
                } else {
                    f3 = 0.0f;
                }
                SVG.o oVar7 = xVar.u;
                if (oVar7 != null) {
                    f4 = oVar7.d(this, 1.0f);
                } else {
                    f4 = 0.0f;
                }
                SVG.o oVar8 = xVar.v;
                if (oVar8 != null) {
                    f5 = oVar8.d(this, 1.0f);
                } else {
                    f5 = 0.0f;
                }
                SVG.b bVar = i0Var.h;
                float f11 = bVar.a;
                float f12 = bVar.c;
                f6 = (f2 * f12) + f11;
                float f13 = bVar.b;
                float f14 = bVar.d;
                float f15 = f4 * f12;
                f7 = f5 * f14;
                f8 = (f3 * f14) + f13;
                f9 = f15;
            }
            if (f9 != 0.0f && f7 != 0.0f) {
                PreserveAspectRatio preserveAspectRatio = xVar.n;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.d;
                }
                a1();
                this.a.clipPath(path);
                h hVar = new h(this);
                d1(hVar, SVG.Style.a());
                hVar.a.v = Boolean.FALSE;
                V(xVar, hVar);
                this.d = hVar;
                SVG.b bVar2 = i0Var.h;
                Matrix matrix = xVar.r;
                if (matrix != null) {
                    this.a.concat(matrix);
                    Matrix matrix2 = new Matrix();
                    if (xVar.r.invert(matrix2)) {
                        SVG.b bVar3 = i0Var.h;
                        SVG.b bVar4 = i0Var.h;
                        SVG.b bVar5 = i0Var.h;
                        float[] fArr = {bVar3.a, bVar3.b, bVar3.b(), bVar4.b, bVar4.b(), i0Var.h.c(), bVar5.a, bVar5.c()};
                        matrix2.mapPoints(fArr);
                        RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                        for (int i2 = 2; i2 <= 6; i2 += 2) {
                            if (fArr[i2] < rectF.left) {
                                rectF.left = fArr[i2];
                            }
                            if (fArr[i2] > rectF.right) {
                                rectF.right = fArr[i2];
                            }
                            int i3 = i2 + 1;
                            if (fArr[i3] < rectF.top) {
                                rectF.top = fArr[i3];
                            }
                            if (fArr[i3] > rectF.bottom) {
                                rectF.bottom = fArr[i3];
                            }
                        }
                        float f16 = rectF.left;
                        float f17 = rectF.top;
                        bVar2 = new SVG.b(f16, f17, rectF.right - f16, rectF.bottom - f17);
                    }
                }
                float floor = f6 + (((float) Math.floor((bVar2.a - f6) / f9)) * f9);
                float b2 = bVar2.b();
                float c2 = bVar2.c();
                SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f9, f7);
                boolean u0 = u0();
                for (float floor2 = f8 + (((float) Math.floor((bVar2.b - f8) / f7)) * f7); floor2 < c2; floor2 += f7) {
                    float f18 = floor;
                    while (f18 < b2) {
                        bVar6.a = f18;
                        bVar6.b = floor2;
                        a1();
                        if (!this.d.a.v.booleanValue()) {
                            f10 = floor;
                            W0(bVar6.a, bVar6.b, bVar6.c, bVar6.d);
                        } else {
                            f10 = floor;
                        }
                        SVG.b bVar7 = xVar.o;
                        if (bVar7 != null) {
                            this.a.concat(t(bVar6, bVar7, preserveAspectRatio));
                        } else {
                            Boolean bool2 = xVar.q;
                            if (bool2 != null && !bool2.booleanValue()) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            this.a.translate(f18, floor2);
                            if (!z2) {
                                Canvas canvas = this.a;
                                SVG.b bVar8 = i0Var.h;
                                canvas.scale(bVar8.c, bVar8.d);
                            }
                        }
                        for (SVG.l0 l0Var : xVar.i) {
                            I0(l0Var);
                        }
                        Z0();
                        f18 += f9;
                        floor = f10;
                    }
                }
                if (u0) {
                    r0(xVar);
                }
                Z0();
            }
        }
    }

    public final void f0(boolean z, SVG.b bVar, SVG.k0 k0Var) {
        boolean z2;
        Paint paint;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), bVar, k0Var}) == null) {
            String str = k0Var.l;
            if (str != null) {
                P(k0Var, str);
            }
            Boolean bool = k0Var.i;
            int i2 = 0;
            if (bool != null && bool.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
            h hVar = this.d;
            if (z) {
                paint = hVar.d;
            } else {
                paint = hVar.e;
            }
            if (z2) {
                SVG.b a0 = a0();
                SVG.o oVar = k0Var.m;
                if (oVar != null) {
                    f11 = oVar.e(this);
                } else {
                    f11 = 0.0f;
                }
                SVG.o oVar2 = k0Var.n;
                if (oVar2 != null) {
                    f12 = oVar2.f(this);
                } else {
                    f12 = 0.0f;
                }
                SVG.o oVar3 = k0Var.o;
                if (oVar3 != null) {
                    f13 = oVar3.e(this);
                } else {
                    f13 = a0.c;
                }
                SVG.o oVar4 = k0Var.p;
                if (oVar4 != null) {
                    f14 = oVar4.f(this);
                } else {
                    f14 = 0.0f;
                }
                f9 = f13;
                f6 = f11;
                f8 = f12;
                f7 = f14;
            } else {
                SVG.o oVar5 = k0Var.m;
                if (oVar5 != null) {
                    f2 = oVar5.d(this, 1.0f);
                } else {
                    f2 = 0.0f;
                }
                SVG.o oVar6 = k0Var.n;
                if (oVar6 != null) {
                    f3 = oVar6.d(this, 1.0f);
                } else {
                    f3 = 0.0f;
                }
                SVG.o oVar7 = k0Var.o;
                if (oVar7 != null) {
                    f4 = oVar7.d(this, 1.0f);
                } else {
                    f4 = 1.0f;
                }
                SVG.o oVar8 = k0Var.p;
                if (oVar8 != null) {
                    f5 = oVar8.d(this, 1.0f);
                } else {
                    f5 = 0.0f;
                }
                f6 = f2;
                f7 = f5;
                f8 = f3;
                f9 = f4;
            }
            a1();
            this.d = U(k0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = k0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = k0Var.h.size();
            if (size == 0) {
                Z0();
                if (z) {
                    this.d.b = false;
                    return;
                } else {
                    this.d.c = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f15 = -1.0f;
            Iterator<SVG.l0> it = k0Var.h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f16 = c0Var.h;
                if (f16 != null) {
                    f10 = f16.floatValue();
                } else {
                    f10 = 0.0f;
                }
                if (i2 != 0 && f10 < f15) {
                    fArr[i2] = f15;
                } else {
                    fArr[i2] = f10;
                    f15 = f10;
                }
                a1();
                e1(this.d, c0Var);
                SVG.f fVar = (SVG.f) this.d.a.C;
                if (fVar == null) {
                    fVar = SVG.f.b;
                }
                iArr[i2] = F(fVar.a, this.d.a.D.floatValue());
                i2++;
                Z0();
            }
            if ((f6 == f9 && f8 == f7) || size == 1) {
                Z0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Z0();
            LinearGradient linearGradient = new LinearGradient(f6, f8, f9, f7, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            paint.setAlpha(C(this.d.a.d.floatValue()));
        }
    }

    public final h V(SVG.l0 l0Var, h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, l0Var, hVar)) == null) {
            ArrayList<SVG.j0> arrayList = new ArrayList();
            while (true) {
                if (l0Var instanceof SVG.j0) {
                    arrayList.add(0, (SVG.j0) l0Var);
                }
                SVG.h0 h0Var = l0Var.b;
                if (h0Var == null) {
                    break;
                }
                l0Var = (SVG.l0) h0Var;
            }
            for (SVG.j0 j0Var : arrayList) {
                e1(hVar, j0Var);
            }
            h hVar2 = this.d;
            hVar.g = hVar2.g;
            hVar.f = hVar2.f;
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void e1(h hVar, SVG.j0 j0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, hVar, j0Var) == null) {
            if (j0Var.b == null) {
                z = true;
            } else {
                z = false;
            }
            hVar.a.b(z);
            SVG.Style style = j0Var.e;
            if (style != null) {
                d1(hVar, style);
            }
            if (this.c.m()) {
                for (CSSParser.l lVar : this.c.d()) {
                    if (CSSParser.l(this.h, lVar.a, j0Var)) {
                        d1(hVar, lVar.b);
                    }
                }
            }
            SVG.Style style2 = j0Var.f;
            if (style2 != null) {
                d1(hVar, style2);
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.d = new h(this);
            this.e = new Stack<>();
            d1(this.d, SVG.Style.a());
            h hVar = this.d;
            hVar.f = null;
            hVar.h = false;
            this.e.push(new h(this, hVar));
            this.g = new Stack<>();
            this.f = new Stack<>();
        }
    }

    public final void X0(h hVar, boolean z, SVG.m0 m0Var) {
        Float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{hVar, Boolean.valueOf(z), m0Var}) == null) {
            SVG.Style style = hVar.a;
            if (z) {
                f2 = style.d;
            } else {
                f2 = style.f;
            }
            float floatValue = f2.floatValue();
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).a;
            } else if (m0Var instanceof SVG.g) {
                i2 = hVar.a.n.a;
            } else {
                return;
            }
            int F = F(i2, floatValue);
            if (z) {
                hVar.d.setColor(F);
            } else {
                hVar.e.setColor(F);
            }
        }
    }

    public final String b1(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.d.h) {
                return str.replaceAll("[\\n\\t]", " ");
            }
            String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
            if (z) {
                replaceAll = replaceAll.replaceAll("^\\s+", "");
            }
            if (z2) {
                replaceAll = replaceAll.replaceAll("\\s+$", "");
            }
            return replaceAll.replaceAll("\\s{2,}", " ");
        }
        return (String) invokeCommon.objValue;
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048638, this, uVar, path, matrix) == null) {
            e1(this.d, uVar);
            if (!I() || !g1()) {
                return;
            }
            Matrix matrix2 = uVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path f2 = new d(this, uVar.o).f();
            if (uVar.h == null) {
                uVar.h = r(f2);
            }
            u(uVar);
            path.setFillType(X());
            path.addPath(f2, matrix);
        }
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048644, this, b1Var, path, matrix) == null) {
            e1(this.d, b1Var);
            if (!I() || !g1()) {
                return;
            }
            Matrix matrix2 = b1Var.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.l0 p = b1Var.a.p(b1Var.o);
            if (p == null) {
                N("Use reference '%s' not found", b1Var.o);
                return;
            }
            u(b1Var);
            j(p, false, path, matrix);
        }
    }

    public final c v0(c cVar, c cVar2, c cVar3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048663, this, cVar, cVar2, cVar3)) == null) {
            float L = L(cVar2.c, cVar2.d, cVar2.a - cVar.a, cVar2.b - cVar.b);
            if (L == 0.0f) {
                L = L(cVar2.c, cVar2.d, cVar3.a - cVar2.a, cVar3.b - cVar2.b);
            }
            int i2 = (L > 0.0f ? 1 : (L == 0.0f ? 0 : -1));
            if (i2 > 0) {
                return cVar2;
            }
            if (i2 == 0 && (cVar2.c > 0.0f || cVar2.d >= 0.0f)) {
                return cVar2;
            }
            cVar2.c = -cVar2.c;
            cVar2.d = -cVar2.d;
            return cVar2;
        }
        return (c) invokeLLL.objValue;
    }

    public final void d1(h hVar, SVG.Style style) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, hVar, style) == null) {
            if (e0(style, 4096L)) {
                hVar.a.n = style.n;
            }
            if (e0(style, 2048L)) {
                hVar.a.m = style.m;
            }
            boolean z6 = false;
            if (e0(style, 1L)) {
                hVar.a.b = style.b;
                SVG.m0 m0Var = style.b;
                if (m0Var != null && m0Var != SVG.f.c) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                hVar.b = z5;
            }
            if (e0(style, 4L)) {
                hVar.a.d = style.d;
            }
            if (e0(style, 6149L)) {
                X0(hVar, true, hVar.a.b);
            }
            if (e0(style, 2L)) {
                hVar.a.c = style.c;
            }
            if (e0(style, 8L)) {
                hVar.a.e = style.e;
                SVG.m0 m0Var2 = style.e;
                if (m0Var2 != null && m0Var2 != SVG.f.c) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                hVar.c = z4;
            }
            if (e0(style, 16L)) {
                hVar.a.f = style.f;
            }
            if (e0(style, 6168L)) {
                X0(hVar, false, hVar.a.e);
            }
            if (e0(style, 34359738368L)) {
                hVar.a.L = style.L;
            }
            if (e0(style, 32L)) {
                SVG.Style style2 = hVar.a;
                SVG.o oVar = style.g;
                style2.g = oVar;
                hVar.e.setStrokeWidth(oVar.c(this));
            }
            if (e0(style, 64L)) {
                hVar.a.h = style.h;
                int i3 = a.b[style.h.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            hVar.e.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    } else {
                        hVar.e.setStrokeCap(Paint.Cap.ROUND);
                    }
                } else {
                    hVar.e.setStrokeCap(Paint.Cap.BUTT);
                }
            }
            if (e0(style, 128L)) {
                hVar.a.i = style.i;
                int i4 = a.c[style.i.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            hVar.e.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    } else {
                        hVar.e.setStrokeJoin(Paint.Join.ROUND);
                    }
                } else {
                    hVar.e.setStrokeJoin(Paint.Join.MITER);
                }
            }
            if (e0(style, 256L)) {
                hVar.a.j = style.j;
                hVar.e.setStrokeMiter(style.j.floatValue());
            }
            if (e0(style, 512L)) {
                hVar.a.k = style.k;
            }
            if (e0(style, 1024L)) {
                hVar.a.l = style.l;
            }
            Typeface typeface = null;
            if (e0(style, 1536L)) {
                SVG.o[] oVarArr = hVar.a.k;
                if (oVarArr == null) {
                    hVar.e.setPathEffect(null);
                } else {
                    int length = oVarArr.length;
                    if (length % 2 == 0) {
                        i2 = length;
                    } else {
                        i2 = length * 2;
                    }
                    float[] fArr = new float[i2];
                    float f2 = 0.0f;
                    for (int i5 = 0; i5 < i2; i5++) {
                        fArr[i5] = hVar.a.k[i5 % length].c(this);
                        f2 += fArr[i5];
                    }
                    if (f2 == 0.0f) {
                        hVar.e.setPathEffect(null);
                    } else {
                        float c2 = hVar.a.l.c(this);
                        if (c2 < 0.0f) {
                            c2 = (c2 % f2) + f2;
                        }
                        hVar.e.setPathEffect(new DashPathEffect(fArr, c2));
                    }
                }
            }
            if (e0(style, 16384L)) {
                float Y = Y();
                hVar.a.p = style.p;
                hVar.d.setTextSize(style.p.d(this, Y));
                hVar.e.setTextSize(style.p.d(this, Y));
            }
            if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
                hVar.a.o = style.o;
            }
            if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                if (style.q.intValue() == -1 && hVar.a.q.intValue() > 100) {
                    SVG.Style style3 = hVar.a;
                    style3.q = Integer.valueOf(style3.q.intValue() - 100);
                } else if (style.q.intValue() == 1 && hVar.a.q.intValue() < 900) {
                    SVG.Style style4 = hVar.a;
                    style4.q = Integer.valueOf(style4.q.intValue() + 100);
                } else {
                    hVar.a.q = style.q;
                }
            }
            if (e0(style, 65536L)) {
                hVar.a.r = style.r;
            }
            if (e0(style, 106496L)) {
                if (hVar.a.o != null && this.c != null) {
                    oz9 g2 = SVG.g();
                    for (String str : hVar.a.o) {
                        SVG.Style style5 = hVar.a;
                        Typeface z7 = z(str, style5.q, style5.r);
                        if (z7 == null && g2 != null) {
                            typeface = g2.c(str, hVar.a.q.intValue(), String.valueOf(hVar.a.r));
                            continue;
                        } else {
                            typeface = z7;
                            continue;
                        }
                        if (typeface != null) {
                            break;
                        }
                    }
                }
                if (typeface == null) {
                    SVG.Style style6 = hVar.a;
                    typeface = z(C.SERIF_NAME, style6.q, style6.r);
                }
                hVar.d.setTypeface(typeface);
                hVar.e.setTypeface(typeface);
            }
            if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
                hVar.a.s = style.s;
                Paint paint = hVar.d;
                if (style.s == SVG.Style.TextDecoration.LineThrough) {
                    z = true;
                } else {
                    z = false;
                }
                paint.setStrikeThruText(z);
                Paint paint2 = hVar.d;
                if (style.s == SVG.Style.TextDecoration.Underline) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                paint2.setUnderlineText(z2);
                if (Build.VERSION.SDK_INT >= 17) {
                    Paint paint3 = hVar.e;
                    if (style.s == SVG.Style.TextDecoration.LineThrough) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    paint3.setStrikeThruText(z3);
                    Paint paint4 = hVar.e;
                    if (style.s == SVG.Style.TextDecoration.Underline) {
                        z6 = true;
                    }
                    paint4.setUnderlineText(z6);
                }
            }
            if (e0(style, 68719476736L)) {
                hVar.a.t = style.t;
            }
            if (e0(style, 262144L)) {
                hVar.a.u = style.u;
            }
            if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
                hVar.a.v = style.v;
            }
            if (e0(style, 2097152L)) {
                hVar.a.x = style.x;
            }
            if (e0(style, 4194304L)) {
                hVar.a.y = style.y;
            }
            if (e0(style, 8388608L)) {
                hVar.a.z = style.z;
            }
            if (e0(style, 16777216L)) {
                hVar.a.A = style.A;
            }
            if (e0(style, 33554432L)) {
                hVar.a.B = style.B;
            }
            if (e0(style, 1048576L)) {
                hVar.a.w = style.w;
            }
            if (e0(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
                hVar.a.E = style.E;
            }
            if (e0(style, 536870912L)) {
                hVar.a.F = style.F;
            }
            if (e0(style, 1073741824L)) {
                hVar.a.G = style.G;
            }
            if (e0(style, 67108864L)) {
                hVar.a.C = style.C;
            }
            if (e0(style, 134217728L)) {
                hVar.a.D = style.D;
            }
            if (e0(style, 8589934592L)) {
                hVar.a.J = style.J;
            }
            if (e0(style, 17179869184L)) {
                hVar.a.K = style.K;
            }
            if (e0(style, 137438953472L)) {
                hVar.a.M = style.M;
            }
        }
    }

    public final void f1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            SVG.Style style = this.d.a;
            SVG.m0 m0Var = style.J;
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).a;
            } else if (m0Var instanceof SVG.g) {
                i2 = style.n.a;
            } else {
                return;
            }
            Float f2 = this.d.a.K;
            if (f2 != null) {
                i2 = F(i2, f2.floatValue());
            }
            this.a.drawColor(i2);
        }
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, u0Var, path, matrix) == null) {
            e1(this.d, u0Var);
            if (!I()) {
                return;
            }
            Matrix matrix2 = u0Var.r;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.o> list = u0Var.n;
            float f5 = 0.0f;
            if (list != null && list.size() != 0) {
                f2 = u0Var.n.get(0).e(this);
            } else {
                f2 = 0.0f;
            }
            List<SVG.o> list2 = u0Var.o;
            if (list2 != null && list2.size() != 0) {
                f3 = u0Var.o.get(0).f(this);
            } else {
                f3 = 0.0f;
            }
            List<SVG.o> list3 = u0Var.p;
            if (list3 != null && list3.size() != 0) {
                f4 = u0Var.p.get(0).e(this);
            } else {
                f4 = 0.0f;
            }
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f5 = u0Var.q.get(0).f(this);
            }
            if (this.d.a.u != SVG.Style.TextAnchor.Start) {
                float s = s(u0Var);
                if (this.d.a.u == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                f2 -= s;
            }
            if (u0Var.h == null) {
                i iVar = new i(this, f2, f3);
                M(u0Var, iVar);
                RectF rectF = iVar.c;
                u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            u(u0Var);
            Path path2 = new Path();
            M(u0Var, new g(this, f2 + f4, f3 + f5, path2));
            path.setFillType(X());
            path.addPath(path2, matrix);
        }
    }

    public final void m0(boolean z, SVG.b bVar, SVG.o0 o0Var) {
        boolean z2;
        Paint paint;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float e2;
        float f8;
        float c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Boolean.valueOf(z), bVar, o0Var}) == null) {
            String str = o0Var.l;
            if (str != null) {
                P(o0Var, str);
            }
            Boolean bool = o0Var.i;
            int i2 = 0;
            if (bool != null && bool.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
            h hVar = this.d;
            if (z) {
                paint = hVar.d;
            } else {
                paint = hVar.e;
            }
            if (z2) {
                SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
                SVG.o oVar2 = o0Var.m;
                if (oVar2 != null) {
                    e2 = oVar2.e(this);
                } else {
                    e2 = oVar.e(this);
                }
                SVG.o oVar3 = o0Var.n;
                if (oVar3 != null) {
                    f8 = oVar3.f(this);
                } else {
                    f8 = oVar.f(this);
                }
                SVG.o oVar4 = o0Var.o;
                if (oVar4 != null) {
                    c2 = oVar4.c(this);
                } else {
                    c2 = oVar.c(this);
                }
                f6 = c2;
                f5 = e2;
                f7 = f8;
            } else {
                SVG.o oVar5 = o0Var.m;
                if (oVar5 != null) {
                    f2 = oVar5.d(this, 1.0f);
                } else {
                    f2 = 0.5f;
                }
                SVG.o oVar6 = o0Var.n;
                if (oVar6 != null) {
                    f3 = oVar6.d(this, 1.0f);
                } else {
                    f3 = 0.5f;
                }
                SVG.o oVar7 = o0Var.o;
                if (oVar7 != null) {
                    f4 = oVar7.d(this, 1.0f);
                } else {
                    f4 = 0.5f;
                }
                f5 = f2;
                f6 = f4;
                f7 = f3;
            }
            a1();
            this.d = U(o0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = o0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = o0Var.h.size();
            if (size == 0) {
                Z0();
                if (z) {
                    this.d.b = false;
                    return;
                } else {
                    this.d.c = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f9 = -1.0f;
            Iterator<SVG.l0> it = o0Var.h.iterator();
            while (true) {
                float f10 = 0.0f;
                if (!it.hasNext()) {
                    break;
                }
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f11 = c0Var.h;
                if (f11 != null) {
                    f10 = f11.floatValue();
                }
                if (i2 != 0 && f10 < f9) {
                    fArr[i2] = f9;
                } else {
                    fArr[i2] = f10;
                    f9 = f10;
                }
                a1();
                e1(this.d, c0Var);
                SVG.f fVar = (SVG.f) this.d.a.C;
                if (fVar == null) {
                    fVar = SVG.f.b;
                }
                iArr[i2] = F(fVar.a, this.d.a.D.floatValue());
                i2++;
                Z0();
            }
            if (f6 != 0.0f && size != 1) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                SVG.GradientSpread gradientSpread = o0Var.k;
                if (gradientSpread != null) {
                    if (gradientSpread == SVG.GradientSpread.reflect) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (gradientSpread == SVG.GradientSpread.repeat) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                Z0();
                RadialGradient radialGradient = new RadialGradient(f5, f7, f6, iArr, fArr, tileMode);
                radialGradient.setLocalMatrix(matrix);
                paint.setShader(radialGradient);
                paint.setAlpha(C(this.d.a.d.floatValue()));
                return;
            }
            Z0();
            paint.setColor(iArr[size - 1]);
        }
    }

    public final SVG.b n0(SVG.o oVar, SVG.o oVar2, SVG.o oVar3, SVG.o oVar4) {
        InterceptResult invokeLLLL;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048647, this, oVar, oVar2, oVar3, oVar4)) == null) {
            float f5 = 0.0f;
            if (oVar != null) {
                f2 = oVar.e(this);
            } else {
                f2 = 0.0f;
            }
            if (oVar2 != null) {
                f5 = oVar2.f(this);
            }
            SVG.b a0 = a0();
            if (oVar3 != null) {
                f3 = oVar3.e(this);
            } else {
                f3 = a0.c;
            }
            if (oVar4 != null) {
                f4 = oVar4.f(this);
            } else {
                f4 = a0.d;
            }
            return new SVG.b(f2, f5, f3, f4);
        }
        return (SVG.b) invokeLLLL.objValue;
    }

    public final boolean u0() {
        InterceptResult invokeV;
        SVG.l0 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (!U0()) {
                return false;
            }
            this.a.saveLayerAlpha(null, C(this.d.a.m.floatValue()), 31);
            this.e.push(this.d);
            h hVar = new h(this, this.d);
            this.d = hVar;
            String str = hVar.a.G;
            if (str != null && ((p = this.c.p(str)) == null || !(p instanceof SVG.r))) {
                N("Mask reference '%s' not found", this.d.a.G);
                this.d.a.G = null;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
