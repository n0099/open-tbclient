package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k2c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class l2c extends k2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b c;
    public final HashMap<String, Bitmap> d;
    public final a e;
    public final float[] f;
    public final h2c g;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final HashMap<SVGAVideoShapeEntity, Path> c;

        public a() {
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
            this.c = new HashMap<>();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVGAVideoShapeEntity)) == null) {
                if (!this.c.containsKey(sVGAVideoShapeEntity)) {
                    Path path = new Path();
                    path.set(sVGAVideoShapeEntity.b());
                    this.c.put(sVGAVideoShapeEntity, path);
                }
                Path path2 = this.c.get(sVGAVideoShapeEntity);
                if (path2 == null) {
                    Intrinsics.throwNpe();
                }
                return path2;
            }
            return (Path) invokeL.objValue;
        }

        public final void b(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
                if (this.a != canvas.getWidth() || this.b != canvas.getHeight()) {
                    this.c.clear();
                }
                this.a = canvas.getWidth();
                this.b = canvas.getHeight();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Paint a;
        public final Path b;
        public final Path c;
        public final Matrix d;
        public final Matrix e;

        public b() {
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
            this.a = new Paint();
            this.b = new Path();
            this.c = new Path();
            this.d = new Matrix();
            this.e = new Matrix();
        }

        public final Matrix a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.d.reset();
                return this.d;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Matrix b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.e.reset();
                return this.e;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Paint c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.a.reset();
                return this.a;
            }
            return (Paint) invokeV.objValue;
        }

        public final Path d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.b.reset();
                return this.b;
            }
            return (Path) invokeV.objValue;
        }

        public final Path e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.c.reset();
                return this.c;
            }
            return (Path) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2c(SVGAVideoEntity sVGAVideoEntity, h2c h2cVar) {
        super(sVGAVideoEntity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAVideoEntity, h2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SVGAVideoEntity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = h2cVar;
        this.c = new b();
        this.d = new HashMap<>();
        this.e = new a();
        this.f = new float[16];
    }

    @Override // com.baidu.tieba.k2c
    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, canvas, i, scaleType) == null) {
            super.a(canvas, i, scaleType);
            this.e.b(canvas);
            for (k2c.a aVar : d(i)) {
                h(aVar, canvas, i);
            }
            k(i);
        }
    }

    public final void h(k2c.a aVar, Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, aVar, canvas, i) == null) {
            f(aVar, canvas);
            g(aVar, canvas);
            e(aVar, canvas, i);
        }
    }

    public final void e(k2c.a aVar, Canvas canvas, int i) {
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, canvas, i) == null) && (b2 = aVar.b()) != null) {
            Function2<Canvas, Integer, Boolean> function2 = this.g.a().get(b2);
            if (function2 != null) {
                Matrix l = l(aVar.a().e());
                canvas.save();
                canvas.concat(l);
                function2.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.g.b().get(b2);
            if (function4 != null) {
                Matrix l2 = l(aVar.a().e());
                canvas.save();
                canvas.concat(l2);
                function4.invoke(canvas, Integer.valueOf(i), Integer.valueOf((int) aVar.a().b().b()), Integer.valueOf((int) aVar.a().b().a()));
                canvas.restore();
            }
        }
    }

    public final void f(k2c.a aVar, Canvas canvas) {
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, canvas) != null) || (b2 = aVar.b()) == null || Intrinsics.areEqual(this.g.c().get(b2), Boolean.TRUE)) {
            return;
        }
        Bitmap bitmap = this.g.d().get(b2);
        if (bitmap == null) {
            bitmap = c().e().get(b2);
        }
        if (bitmap != null) {
            Matrix l = l(aVar.a().e());
            Paint c = this.c.c();
            c.setAntiAlias(c().a());
            c.setFilterBitmap(c().a());
            c.setAlpha((int) (aVar.a().a() * 255));
            if (aVar.a().c() != null) {
                n2c c2 = aVar.a().c();
                if (c2 != null) {
                    canvas.save();
                    c.reset();
                    Path d = this.c.d();
                    c2.a(d);
                    d.transform(l);
                    canvas.clipPath(d);
                    l.preScale((float) (aVar.a().b().b() / bitmap.getWidth()), (float) (aVar.a().b().b() / bitmap.getWidth()));
                    canvas.drawBitmap(bitmap, l, c);
                    canvas.restore();
                } else {
                    return;
                }
            } else {
                l.preScale((float) (aVar.a().b().b() / bitmap.getWidth()), (float) (aVar.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c);
            }
            i(canvas, bitmap, aVar, l);
        }
    }

    public final void g(k2c.a aVar, Canvas canvas) {
        SVGAVideoShapeEntity.a c;
        float[] c2;
        String d;
        String b2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, canvas) == null) {
            Matrix l = l(aVar.a().e());
            for (SVGAVideoShapeEntity sVGAVideoShapeEntity : aVar.a().d()) {
                sVGAVideoShapeEntity.a();
                if (sVGAVideoShapeEntity.b() != null) {
                    Paint c3 = this.c.c();
                    c3.reset();
                    c3.setAntiAlias(c().a());
                    double d2 = 255;
                    c3.setAlpha((int) (aVar.a().a() * d2));
                    Path d3 = this.c.d();
                    d3.reset();
                    d3.addPath(this.e.a(sVGAVideoShapeEntity));
                    Matrix b3 = this.c.b();
                    b3.reset();
                    Matrix d4 = sVGAVideoShapeEntity.d();
                    if (d4 != null) {
                        b3.postConcat(d4);
                    }
                    b3.postConcat(l);
                    d3.transform(b3);
                    SVGAVideoShapeEntity.a c4 = sVGAVideoShapeEntity.c();
                    if (c4 != null && (a2 = c4.a()) != 0) {
                        c3.setStyle(Paint.Style.FILL);
                        c3.setColor(a2);
                        c3.setAlpha(Math.min(255, Math.max(0, (int) (aVar.a().a() * d2))));
                        if (aVar.a().c() != null) {
                            canvas.save();
                        }
                        n2c c5 = aVar.a().c();
                        if (c5 != null) {
                            Path e = this.c.e();
                            c5.a(e);
                            e.transform(l);
                            canvas.clipPath(e);
                        }
                        canvas.drawPath(d3, c3);
                        if (aVar.a().c() != null) {
                            canvas.restore();
                        }
                    }
                    SVGAVideoShapeEntity.a c6 = sVGAVideoShapeEntity.c();
                    if (c6 != null) {
                        float f = 0;
                        if (c6.g() > f) {
                            c3.setStyle(Paint.Style.STROKE);
                            SVGAVideoShapeEntity.a c7 = sVGAVideoShapeEntity.c();
                            if (c7 != null) {
                                c3.setColor(c7.f());
                                c3.setAlpha(Math.min(255, Math.max(0, (int) (aVar.a().a() * d2))));
                            }
                            float j = j(l);
                            SVGAVideoShapeEntity.a c8 = sVGAVideoShapeEntity.c();
                            if (c8 != null) {
                                c3.setStrokeWidth(c8.g() * j);
                            }
                            SVGAVideoShapeEntity.a c9 = sVGAVideoShapeEntity.c();
                            if (c9 != null && (b2 = c9.b()) != null) {
                                if (StringsKt__StringsJVMKt.equals(b2, "butt", true)) {
                                    c3.setStrokeCap(Paint.Cap.BUTT);
                                } else if (StringsKt__StringsJVMKt.equals(b2, "round", true)) {
                                    c3.setStrokeCap(Paint.Cap.ROUND);
                                } else if (StringsKt__StringsJVMKt.equals(b2, "square", true)) {
                                    c3.setStrokeCap(Paint.Cap.SQUARE);
                                }
                            }
                            SVGAVideoShapeEntity.a c10 = sVGAVideoShapeEntity.c();
                            if (c10 != null && (d = c10.d()) != null) {
                                if (StringsKt__StringsJVMKt.equals(d, "miter", true)) {
                                    c3.setStrokeJoin(Paint.Join.MITER);
                                } else if (StringsKt__StringsJVMKt.equals(d, "round", true)) {
                                    c3.setStrokeJoin(Paint.Join.ROUND);
                                } else if (StringsKt__StringsJVMKt.equals(d, "bevel", true)) {
                                    c3.setStrokeJoin(Paint.Join.BEVEL);
                                }
                            }
                            if (sVGAVideoShapeEntity.c() != null) {
                                c3.setStrokeMiter(c.e() * j);
                            }
                            SVGAVideoShapeEntity.a c11 = sVGAVideoShapeEntity.c();
                            if (c11 != null && (c2 = c11.c()) != null && c2.length == 3 && (c2[0] > f || c2[1] > f)) {
                                float[] fArr = new float[2];
                                float f2 = 1.0f;
                                if (c2[0] >= 1.0f) {
                                    f2 = c2[0];
                                }
                                fArr[0] = f2 * j;
                                float f3 = 0.1f;
                                if (c2[1] >= 0.1f) {
                                    f3 = c2[1];
                                }
                                fArr[1] = f3 * j;
                                c3.setPathEffect(new DashPathEffect(fArr, c2[2] * j));
                            }
                            if (aVar.a().c() != null) {
                                canvas.save();
                            }
                            n2c c12 = aVar.a().c();
                            if (c12 != null) {
                                Path e2 = this.c.e();
                                c12.a(e2);
                                e2.transform(l);
                                canvas.clipPath(e2);
                            }
                            canvas.drawPath(d3, c3);
                            if (aVar.a().c() != null) {
                                canvas.restore();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void i(Canvas canvas, Bitmap bitmap, k2c.a aVar, Matrix matrix) {
        TextPaint drawingTextPaint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, canvas, bitmap, aVar, matrix) == null) {
            if (this.g.h()) {
                this.d.clear();
                this.g.i(false);
            }
            String b2 = aVar.b();
            if (b2 != null) {
                Bitmap bitmap2 = null;
                String str = this.g.f().get(b2);
                if (str != null && (drawingTextPaint = this.g.g().get(b2)) != null && (bitmap2 = this.d.get(b2)) == null) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmap2);
                    Intrinsics.checkExpressionValueIsNotNull(drawingTextPaint, "drawingTextPaint");
                    drawingTextPaint.setAntiAlias(true);
                    Rect rect = new Rect();
                    drawingTextPaint.getTextBounds(str, 0, str.length(), rect);
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((bitmap.getHeight() + 0) - drawingTextPaint.getFontMetrics().bottom) - drawingTextPaint.getFontMetrics().top) / 2, drawingTextPaint);
                    HashMap<String, Bitmap> hashMap = this.d;
                    if (bitmap2 != null) {
                        hashMap.put(b2, bitmap2);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                }
                StaticLayout it = this.g.e().get(b2);
                if (it != null && (bitmap2 = this.d.get(b2)) == null) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    TextPaint paint = it.getPaint();
                    Intrinsics.checkExpressionValueIsNotNull(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout = new StaticLayout(it.getText(), 0, it.getText().length(), it.getPaint(), bitmap.getWidth(), it.getAlignment(), it.getSpacingMultiplier(), it.getSpacingAdd(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout.getHeight()) / 2);
                    staticLayout.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.d;
                    if (createBitmap != null) {
                        hashMap2.put(b2, createBitmap);
                        bitmap2 = createBitmap;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                }
                if (bitmap2 != null) {
                    Paint c = this.c.c();
                    c.setAntiAlias(c().a());
                    if (aVar.a().c() != null) {
                        n2c c2 = aVar.a().c();
                        if (c2 != null) {
                            canvas.save();
                            canvas.concat(matrix);
                            canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                            c.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                            Path d = this.c.d();
                            c2.a(d);
                            canvas.drawPath(d, c);
                            canvas.restore();
                            return;
                        }
                        return;
                    }
                    c.setFilterBitmap(c().a());
                    canvas.drawBitmap(bitmap2, matrix, c);
                }
            }
        }
    }

    public final float j(Matrix matrix) {
        InterceptResult invokeL;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, matrix)) == null) {
            matrix.getValues(this.f);
            float[] fArr = this.f;
            if (fArr[0] == 0.0f) {
                return 0.0f;
            }
            double d = fArr[0];
            double d2 = fArr[3];
            double d3 = fArr[1];
            double d4 = fArr[4];
            if (d * d4 == d2 * d3) {
                return 0.0f;
            }
            double sqrt = Math.sqrt((d * d) + (d2 * d2));
            double d5 = d / sqrt;
            double d6 = d2 / sqrt;
            double d7 = (d5 * d3) + (d6 * d4);
            double d8 = d3 - (d5 * d7);
            double d9 = d4 - (d7 * d6);
            double sqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
            if (d5 * (d9 / sqrt2) < d6 * (d8 / sqrt2)) {
                sqrt = -sqrt;
            }
            if (b().a()) {
                f = (float) sqrt;
            } else {
                f = (float) sqrt2;
            }
            return Math.abs(f);
        }
        return invokeL.floatValue;
    }

    public final void k(int i) {
        SoundPool f;
        Integer c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            for (m2c m2cVar : c().b()) {
                if (m2cVar.d() == i && (f = c().f()) != null && (c = m2cVar.c()) != null) {
                    m2cVar.e(Integer.valueOf(f.play(c.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                }
                if (m2cVar.a() <= i) {
                    Integer b2 = m2cVar.b();
                    if (b2 != null) {
                        int intValue = b2.intValue();
                        SoundPool f2 = c().f();
                        if (f2 != null) {
                            f2.stop(intValue);
                        }
                    }
                    m2cVar.e(null);
                }
            }
        }
    }

    public final Matrix l(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, matrix)) == null) {
            Matrix a2 = this.c.a();
            a2.postScale(b().b(), b().c());
            a2.postTranslate(b().d(), b().e());
            a2.preConcat(matrix);
            return a2;
        }
        return (Matrix) invokeL.objValue;
    }
}
