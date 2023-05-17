package com.baidu.ufosdk.screencapedt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.a0;
import com.baidu.ufosdk.b;
import com.baidu.ufosdk.b0;
import com.baidu.ufosdk.c0;
import com.baidu.ufosdk.p1;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.baidu.ufosdk.w;
import com.baidu.ufosdk.x;
import com.baidu.ufosdk.y;
import com.baidu.ufosdk.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes8.dex */
public class ScreenCapEditActivity extends Activity implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;
    public static int Q;
    public static int R;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public boolean B;
    public RelativeLayout C;
    public ImageView D;
    public boolean E;
    public boolean F;
    public boolean G;
    public ByteArrayOutputStream H;
    public boolean I;
    public boolean J;
    public int K;
    public Handler L;
    public TextView M;
    public ImageView N;
    public RelativeLayout O;
    public RelativeLayout P;
    public ImageView a;
    public Bitmap b;
    public Bitmap c;
    public Bitmap d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Canvas i;
    public Paint j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public Path o;
    public int p;
    public HashMap<String, x> q;
    public x r;
    public Bitmap s;
    public Bitmap t;
    public Bitmap u;
    public Bitmap v;
    public Bitmap w;
    public float x;
    public float y;
    public float z;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScreenCapEditActivity a;

        public a(ScreenCapEditActivity screenCapEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {screenCapEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = screenCapEditActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 0) {
                    if (this.a.q.size() == 0) {
                        this.a.N.setBackgroundDrawable(new BitmapDrawable(p1.b(this.a, "delete_all_disable.png")));
                        this.a.M.setTextColor(-10066330);
                        this.a.O.setClickable(false);
                        return;
                    }
                    this.a.N.setBackgroundDrawable(new BitmapDrawable(p1.b(this.a, "delete_all.png")));
                    this.a.M.setTextColor(-1);
                    this.a.O.setClickable(true);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(740895383, "Lcom/baidu/ufosdk/screencapedt/ScreenCapEditActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(740895383, "Lcom/baidu/ufosdk/screencapedt/ScreenCapEditActivity;");
                return;
            }
        }
        String str = a() + "/ufo/ufo_screen.jpeg";
        Q = -65536;
        R = 0;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c != null) {
                this.i = new Canvas(this.c);
            }
            this.j.setColor(Q);
            this.j.setStyle(Paint.Style.STROKE);
            float strokeWidth = this.j.getStrokeWidth();
            float f = R;
            if (strokeWidth < f) {
                this.j.setStrokeWidth(f);
            }
        }
    }

    public ScreenCapEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.j = new Paint();
        this.m = true;
        this.n = 0;
        this.o = new Path();
        this.p = 2;
        this.q = null;
        this.B = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.K = -1;
        this.L = new a(this);
    }

    public static String a() {
        InterceptResult invokeV;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = null;
            }
            if (file == null) {
                return null;
            }
            return file.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void a(ScreenCapEditActivity screenCapEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, screenCapEditActivity) == null) {
            if (screenCapEditActivity != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                screenCapEditActivity.H = byteArrayOutputStream;
                Bitmap bitmap = screenCapEditActivity.c;
                int i = 70;
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                }
                String str = "stream.toByteArray() length is " + screenCapEditActivity.H.toByteArray().length;
                String str2 = "stream.toByteArray() length is " + p1.a(screenCapEditActivity.H.toByteArray().length);
                int length = screenCapEditActivity.H.toByteArray().length;
                while (screenCapEditActivity.c != null && length > 300000 && i >= 0) {
                    String str3 = "quality is " + i;
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    screenCapEditActivity.H = byteArrayOutputStream2;
                    screenCapEditActivity.c.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream2);
                    i -= 10;
                    length = screenCapEditActivity.H.toByteArray().length;
                    String str4 = "streamLength is " + length;
                }
                String str5 = "stream.toByteArray() length is " + screenCapEditActivity.H.toByteArray().length;
                String str6 = "stream.toByteArray() length is " + p1.a(screenCapEditActivity.H.toByteArray().length);
                Intent intent = new Intent();
                intent.putExtra("shot", screenCapEditActivity.H.toByteArray());
                intent.putExtra("editAgain", screenCapEditActivity.I);
                screenCapEditActivity.setResult(-1, intent);
                screenCapEditActivity.finish();
                return;
            }
            throw null;
        }
    }

    public static void a(ScreenCapEditActivity screenCapEditActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, screenCapEditActivity, i) == null) {
            if (screenCapEditActivity != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                screenCapEditActivity.H = byteArrayOutputStream;
                Bitmap bitmap = screenCapEditActivity.c;
                int i2 = 40;
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                }
                String str = "stream.toByteArray() length is " + screenCapEditActivity.H.toByteArray().length;
                String str2 = "stream.toByteArray() length is " + p1.a(screenCapEditActivity.H.toByteArray().length);
                int length = screenCapEditActivity.H.toByteArray().length;
                while (screenCapEditActivity.c != null && length > 300000 && i2 >= 0) {
                    String str3 = "quality is " + i2;
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    screenCapEditActivity.H = byteArrayOutputStream2;
                    screenCapEditActivity.c.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream2);
                    i2 -= 10;
                    length = screenCapEditActivity.H.toByteArray().length;
                    String str4 = "streamLength is " + length;
                }
                String str5 = "stream.toByteArray() length is " + screenCapEditActivity.H.toByteArray().length;
                String str6 = "stream.toByteArray() length is " + p1.a(screenCapEditActivity.H.toByteArray().length);
                c0 c0Var = new c0(screenCapEditActivity, i);
                if (screenCapEditActivity.c == null) {
                    c0Var.run();
                    return;
                } else {
                    c0Var.run();
                    return;
                }
            }
            throw null;
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            int i = (f3 > f ? 1 : (f3 == f ? 0 : -1));
            if (i > 0 && f4 > f2) {
                a(this.i, this.j, f, f2, f3, f4);
            }
            if (i > 0 && f4 < f2) {
                a(this.i, this.j, f, f4, f3, f2);
            }
            int i2 = (f3 > f ? 1 : (f3 == f ? 0 : -1));
            if (i2 < 0 && f4 > f2) {
                a(this.i, this.j, f3, f2, f, f4);
            }
            if (i2 < 0 && f4 < f2) {
                a(this.i, this.j, f3, f4, f, f2);
            }
            if (i == 0 || f4 == f2) {
                a(this.i, this.j, f, f2, f3, f4);
            }
        }
    }

    public final void a(int i, float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            if (i != 13) {
                if (i != 14) {
                    if (i != 24) {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (i == 4) {
                                            this.r.d = this.A + (f4 - f2);
                                            a(false);
                                            for (Map.Entry<String, x> entry : this.q.entrySet()) {
                                                String str = "key= " + entry.getKey() + " and value= " + entry.getValue();
                                                this.i.drawRect(entry.getValue().a, entry.getValue().b, entry.getValue().c, entry.getValue().d, this.j);
                                            }
                                            x xVar = this.r;
                                            b(xVar.a, xVar.b, xVar.c, xVar.d);
                                            Bitmap bitmap = this.w;
                                            x xVar2 = this.r;
                                            a(bitmap, (xVar2.a + xVar2.c) / 2.0f, xVar2.d);
                                            return;
                                        }
                                        return;
                                    }
                                    this.r.b = this.y + (f4 - f2);
                                    a(false);
                                    for (Map.Entry<String, x> entry2 : this.q.entrySet()) {
                                        String str2 = "key= " + entry2.getKey() + " and value= " + entry2.getValue();
                                        this.i.drawRect(entry2.getValue().a, entry2.getValue().b, entry2.getValue().c, entry2.getValue().d, this.j);
                                    }
                                    x xVar3 = this.r;
                                    b(xVar3.a, xVar3.b, xVar3.c, xVar3.d);
                                    Bitmap bitmap2 = this.w;
                                    x xVar4 = this.r;
                                    a(bitmap2, (xVar4.a + xVar4.c) / 2.0f, xVar4.b);
                                    return;
                                }
                                this.r.c = this.z + (f3 - f);
                                a(false);
                                for (Map.Entry<String, x> entry3 : this.q.entrySet()) {
                                    String str3 = "key= " + entry3.getKey() + " and value= " + entry3.getValue();
                                    this.i.drawRect(entry3.getValue().a, entry3.getValue().b, entry3.getValue().c, entry3.getValue().d, this.j);
                                }
                                x xVar5 = this.r;
                                b(xVar5.a, xVar5.b, xVar5.c, xVar5.d);
                                Bitmap bitmap3 = this.s;
                                x xVar6 = this.r;
                                a(bitmap3, xVar6.c, (xVar6.b + xVar6.d) / 2.0f);
                                return;
                            }
                            this.r.a = this.x + (f3 - f);
                            a(false);
                            for (Map.Entry<String, x> entry4 : this.q.entrySet()) {
                                String str4 = "key= " + entry4.getKey() + " and value= " + entry4.getValue();
                                this.i.drawRect(entry4.getValue().a, entry4.getValue().b, entry4.getValue().c, entry4.getValue().d, this.j);
                            }
                            x xVar7 = this.r;
                            b(xVar7.a, xVar7.b, xVar7.c, xVar7.d);
                            Bitmap bitmap4 = this.s;
                            x xVar8 = this.r;
                            a(bitmap4, xVar8.a, (xVar8.b + xVar8.d) / 2.0f);
                            return;
                        }
                        float f5 = f3 - f;
                        float f6 = f4 - f2;
                        x xVar9 = this.r;
                        xVar9.a = this.x + f5;
                        xVar9.b = this.y + f6;
                        xVar9.c = this.z + f5;
                        xVar9.d = this.A + f6;
                        a(false);
                        for (Map.Entry<String, x> entry5 : this.q.entrySet()) {
                            System.out.println("key= " + entry5.getKey() + " and value= " + entry5.getValue());
                            this.i.drawRect(entry5.getValue().a, entry5.getValue().b, entry5.getValue().c, entry5.getValue().d, this.j);
                        }
                        x xVar10 = this.r;
                        b(xVar10.a, xVar10.b, xVar10.c, xVar10.d);
                        Bitmap bitmap5 = this.u;
                        x xVar11 = this.r;
                        a(bitmap5, (xVar11.a + xVar11.c) / 2.0f, (xVar11.b + xVar11.d) / 2.0f);
                        return;
                    }
                    x xVar12 = this.r;
                    xVar12.c = this.z + (f3 - f);
                    xVar12.d = this.A + (f4 - f2);
                    a(false);
                    for (Map.Entry<String, x> entry6 : this.q.entrySet()) {
                        String str5 = "key= " + entry6.getKey() + " and value= " + entry6.getValue();
                        this.i.drawRect(entry6.getValue().a, entry6.getValue().b, entry6.getValue().c, entry6.getValue().d, this.j);
                    }
                    x xVar13 = this.r;
                    b(xVar13.a, xVar13.b, xVar13.c, xVar13.d);
                    Bitmap bitmap6 = this.t;
                    x xVar14 = this.r;
                    a(bitmap6, xVar14.c, xVar14.d);
                    return;
                }
                x xVar15 = this.r;
                xVar15.a = this.x + (f3 - f);
                xVar15.d = this.A + (f4 - f2);
                a(false);
                for (Map.Entry<String, x> entry7 : this.q.entrySet()) {
                    String str6 = "key= " + entry7.getKey() + " and value= " + entry7.getValue();
                    this.i.drawRect(entry7.getValue().a, entry7.getValue().b, entry7.getValue().c, entry7.getValue().d, this.j);
                }
                x xVar16 = this.r;
                b(xVar16.a, xVar16.b, xVar16.c, xVar16.d);
                Bitmap bitmap7 = this.v;
                x xVar17 = this.r;
                a(bitmap7, xVar17.a, xVar17.d);
                return;
            }
            x xVar18 = this.r;
            xVar18.a = this.x + (f3 - f);
            xVar18.b = this.y + (f4 - f2);
            a(false);
            for (Map.Entry<String, x> entry8 : this.q.entrySet()) {
                String str7 = "key= " + entry8.getKey() + " and value= " + entry8.getValue();
                this.i.drawRect(entry8.getValue().a, entry8.getValue().b, entry8.getValue().c, entry8.getValue().d, this.j);
            }
            x xVar19 = this.r;
            b(xVar19.a, xVar19.b, xVar19.c, xVar19.d);
            Bitmap bitmap8 = this.t;
            x xVar20 = this.r;
            a(bitmap8, xVar20.a, xVar20.b);
        }
    }

    public final void a(Bitmap bitmap, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.i.drawBitmap(bitmap, f - (bitmap.getWidth() / 2), f2 - (bitmap.getHeight() / 2), this.j);
        }
    }

    public final void a(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{canvas, paint, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            paint.setStrokeWidth(b.a(getApplicationContext(), 1.0f));
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1);
            canvas.drawCircle(f, f2, b.a(getApplicationContext(), 7.0f), paint);
            float f5 = (f2 + f4) / 2.0f;
            canvas.drawCircle(f, f5, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f, f4, b.a(getApplicationContext(), 7.0f), paint);
            float f6 = (f + f3) / 2.0f;
            canvas.drawCircle(f6, f2, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f6, f4, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f3, f5, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f3, f4, b.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f3, f2, b.a(getApplicationContext(), 7.0f), paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-65536);
            canvas.drawCircle(f, f2, b.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f, f5, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f, f4, b.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f6, f2, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f6, f4, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f3, f5, b.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f3, f4, b.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f3, f2, b.a(getApplicationContext(), 7.0f), paint);
            canvas.drawLine(f3, f2, f3 - b.a(getApplicationContext(), 3.0f), f2 + b.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f3, f2, f3 + b.a(getApplicationContext(), 3.0f), f2 - b.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f3, f2, f3 - b.a(getApplicationContext(), 3.0f), f2 - b.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f3, f2, f3 + b.a(getApplicationContext(), 3.0f), f2 + b.a(getApplicationContext(), 3.0f), paint);
            String str = System.currentTimeMillis() + UUID.randomUUID().toString();
            x xVar = new x(f, f2, f3, f4, true, str);
            this.q.put(str, xVar);
            this.r = xVar;
            this.x = xVar.a;
            this.y = xVar.b;
            this.z = xVar.c;
            this.A = xVar.d;
            this.E = false;
            this.P.setBackgroundDrawable(p1.a(getApplicationContext(), -15066598, -16777216));
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int width = this.b.getWidth();
            int height = this.b.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale((float) ((this.k * 1.0d) / width), (float) ((this.l * 1.0d) / height));
            try {
                this.c = Bitmap.createBitmap(this.b, 0, 0, width, height, matrix, true).copy(Bitmap.Config.ARGB_8888, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.a.setImageBitmap(this.c);
            b();
            this.a.invalidate();
            if (z) {
                this.q.clear();
            }
        }
    }

    public final void b(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.j.setStrokeWidth(b.a(getApplicationContext(), 1.0f));
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(-1);
            this.i.drawCircle(f, f2, b.a(getApplicationContext(), 7.0f), this.j);
            float f5 = (f2 + f4) / 2.0f;
            this.i.drawCircle(f, f5, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f, f4, b.a(getApplicationContext(), 7.0f), this.j);
            float f6 = (f + f3) / 2.0f;
            this.i.drawCircle(f6, f2, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f6, f4, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f3, f5, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f3, f4, b.a(getApplicationContext(), 7.0f), this.j);
            this.i.drawCircle(f3, f2, b.a(getApplicationContext(), 7.0f), this.j);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setColor(-65536);
            this.i.drawCircle(f, f2, b.a(getApplicationContext(), 7.0f), this.j);
            this.i.drawCircle(f, f5, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f, f4, b.a(getApplicationContext(), 7.0f), this.j);
            this.i.drawCircle(f6, f2, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f6, f4, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f3, f5, b.a(getApplicationContext(), 5.0f), this.j);
            this.i.drawCircle(f3, f4, b.a(getApplicationContext(), 7.0f), this.j);
            this.i.drawCircle(f3, f2, b.a(getApplicationContext(), 7.0f), this.j);
            this.i.drawLine(f3, f2, f3 - b.a(getApplicationContext(), 3.0f), f2 + b.a(getApplicationContext(), 3.0f), this.j);
            this.i.drawLine(f3, f2, f3 + b.a(getApplicationContext(), 3.0f), f2 - b.a(getApplicationContext(), 3.0f), this.j);
            this.i.drawLine(f3, f2, f3 - b.a(getApplicationContext(), 3.0f), f2 - b.a(getApplicationContext(), 3.0f), this.j);
            this.i.drawLine(f3, f2, f3 + b.a(getApplicationContext(), 3.0f), f2 + b.a(getApplicationContext(), 3.0f), this.j);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                if (this.F && this.I) {
                    setResult(-77, new Intent());
                }
                finish();
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            byte[] byteArrayExtra2 = getIntent().getByteArrayExtra("inputshot");
            String stringExtra = getIntent().getStringExtra("image_path");
            this.I = getIntent().getBooleanExtra("direct", false);
            this.G = getIntent().getBooleanExtra("input", false);
            this.J = getIntent().getBooleanExtra("from_app", false);
            this.K = getIntent().getIntExtra("extend_feedback_channel", 0);
            SoftReference<Bitmap> softReference = w.a().a;
            if (softReference == null) {
                bitmap = null;
            } else {
                bitmap = softReference.get();
            }
            if (bitmap != null) {
                this.b = bitmap;
                w a2 = w.a();
                SoftReference<Bitmap> softReference2 = a2.a;
                if (softReference2 != null) {
                    softReference2.clear();
                    a2.a = null;
                }
            } else if (byteArrayExtra2 != null && byteArrayExtra2.length > 0) {
                this.b = BitmapFactory.decodeByteArray(byteArrayExtra2, 0, byteArrayExtra2.length);
            } else if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.b = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
                this.F = true;
                String str = "ScreenCapEditActivity --> bitmap via shot byte[] & bitmap size is " + (byteArrayExtra.length / 1024) + "kb";
            } else if (!TextUtils.isEmpty(stringExtra)) {
                this.b = BitmapFactory.decodeFile(stringExtra);
                b.a(new File(stringExtra), true);
                this.F = true;
            } else if (a() == null) {
                Intent intent = new Intent();
                intent.setClass(this, FeedbackEditActivity.class);
                intent.putExtra("fromlist", "no");
                intent.putExtra("feedback_channel", b.h());
                intent.putExtra("come_from", 3);
                startActivity(intent);
                finish();
                return;
            } else {
                if (new File(a() + "/ufo/ufo_screen.jpeg").exists()) {
                    this.b = BitmapFactory.decodeFile(a() + "/ufo/ufo_screen.jpeg").copy(Bitmap.Config.ARGB_8888, true);
                    this.F = false;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, FeedbackEditActivity.class);
                    intent2.putExtra("fromlist", "no");
                    intent2.putExtra("feedback_channel", b.h());
                    intent2.putExtra("come_from", 3);
                    startActivity(intent2);
                    finish();
                    return;
                }
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 == null) {
                Intent intent3 = new Intent();
                intent3.setClass(this, FeedbackEditActivity.class);
                intent3.putExtra("fromlist", "no");
                intent3.putExtra("feedback_channel", b.h());
                intent3.putExtra("come_from", 3);
                startActivity(intent3);
                finish();
                return;
            }
            String str2 = "图片尺寸 --> width = " + bitmap2.getWidth() + "; height = " + this.b.getHeight();
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.C = relativeLayout;
            relativeLayout.setId(2030632961);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(2030632962);
            this.C.setBackgroundColor(-15066598);
            new RelativeLayout.LayoutParams(-1, -1);
            Button button = new Button(this);
            button.setText("取消");
            button.setTextSize(1, 16.0f);
            button.setTextColor(-1);
            button.setGravity(17);
            button.setTextColor(-1);
            button.setBackgroundDrawable(p1.a(getApplicationContext(), -15066598, -16777216));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            relativeLayout2.addView(button, layoutParams);
            TextView textView = new TextView(this);
            textView.setId(2030632964);
            textView.setText("问题标注");
            textView.setTextColor(-1);
            textView.setTextSize(1, 16.0f);
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.addRule(13);
            relativeLayout2.addView(textView, layoutParams2);
            Button button2 = new Button(this);
            button2.setText("下一步");
            button2.setId(2030632965);
            button2.setTextColor(-12814593);
            button2.setTextSize(1, 14.0f);
            button2.setGravity(17);
            button2.setPadding(p1.a(getApplicationContext(), 15.0f), 0, p1.a(getApplicationContext(), 15.0f), 0);
            button2.setBackgroundDrawable(p1.a(getApplicationContext(), -15066598, -16777216));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            relativeLayout2.addView(button2, layoutParams3);
            relativeLayout2.setBackgroundColor(-15066598);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 70.0f));
            layoutParams4.addRule(10);
            this.C.addView(relativeLayout2, layoutParams4);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(2030632966);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(-15066598);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.P = relativeLayout3;
            relativeLayout3.setId(2030632969);
            this.P.setBackgroundDrawable(p1.a(getApplicationContext(), -15066598, -15395563));
            ImageView imageView = new ImageView(this);
            this.D = imageView;
            imageView.setId(2030632976);
            this.D.setBackgroundDrawable(new BitmapDrawable(p1.b(getApplicationContext(), "rect_normal.png")));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 20.0f), p1.a(getApplicationContext(), 20.0f));
            layoutParams5.addRule(14);
            layoutParams5.setMargins(0, 0, 0, p1.a(getApplicationContext(), 5.0f));
            this.P.addView(this.D, layoutParams5);
            TextView textView2 = new TextView(this);
            textView2.setId(2030632977);
            textView2.setText("圈选反馈内容");
            textView2.setTextColor(-1);
            textView2.setTextSize(1, 12.0f);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(14);
            layoutParams6.addRule(3, this.D.getId());
            this.P.addView(textView2, layoutParams6);
            this.P.setPadding(p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 2.0f));
            this.P.setOnClickListener(new y(this));
            RelativeLayout relativeLayout4 = new RelativeLayout(this);
            this.O = relativeLayout4;
            relativeLayout4.setClickable(false);
            this.O.setId(2030632978);
            this.O.setBackgroundDrawable(p1.a(getApplicationContext(), -15066598, -16777216));
            this.O.setClickable(true);
            ImageView imageView2 = new ImageView(this);
            this.N = imageView2;
            imageView2.setId(2030632980);
            this.N.setBackgroundDrawable(new BitmapDrawable(p1.b(this, "delete_all_disable.png")));
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(p1.a(getApplicationContext(), 20.0f), p1.a(getApplicationContext(), 20.0f));
            layoutParams7.addRule(14);
            layoutParams7.setMargins(0, 0, 0, p1.a(getApplicationContext(), 5.0f));
            this.O.addView(this.N, layoutParams7);
            TextView textView3 = new TextView(this);
            this.M = textView3;
            textView3.setId(2030632979);
            this.M.setText("清除全部选框");
            this.M.setTextColor(-10066330);
            this.M.setTextSize(1, 12.0f);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.addRule(14);
            layoutParams8.addRule(3, this.N.getId());
            this.O.addView(this.M, layoutParams8);
            this.O.setPadding(p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 5.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams9.weight = 1.0f;
            linearLayout.addView(this.P, layoutParams9);
            linearLayout.addView(this.O, layoutParams9);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, p1.a(getApplicationContext(), 55.0f));
            layoutParams10.addRule(12);
            layoutParams10.setMargins(p1.a(getApplicationContext(), 20.0f), 0, p1.a(getApplicationContext(), 20.0f), 0);
            this.C.addView(linearLayout, layoutParams10);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setId(2030632968);
            ImageView imageView3 = new ImageView(this);
            this.a = imageView3;
            imageView3.setId(2030632967);
            this.a.setBackgroundColor(-16777216);
            FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams11.gravity = 17;
            frameLayout.addView(this.a, layoutParams11);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams12.setMargins(p1.a(getApplicationContext(), 40.0f), p1.a(getApplicationContext(), 0.0f), p1.a(getApplicationContext(), 40.0f), p1.a(getApplicationContext(), 10.0f));
            layoutParams12.addRule(3, relativeLayout2.getId());
            layoutParams12.addRule(2, linearLayout.getId());
            this.C.addView(frameLayout, layoutParams12);
            button2.setOnClickListener(new z(this, button2));
            button.setOnClickListener(new a0(this));
            this.O.setOnClickListener(new b0(this));
            setContentView(this.C);
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
            Bitmap bitmap3 = this.b;
            if (bitmap3 != null) {
                this.a.setImageBitmap(bitmap3);
            }
            this.j.setColor(Q);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setStrokeCap(Paint.Cap.ROUND);
            this.j.setStrokeJoin(Paint.Join.ROUND);
            this.j.setAntiAlias(true);
            this.q = new HashMap<>();
            this.s = p1.b(getApplicationContext(), "arrow_left_right.png");
            this.t = p1.b(getApplicationContext(), "arrow_left_up.png");
            this.u = p1.b(getApplicationContext(), "arrow_move.png");
            this.v = p1.b(getApplicationContext(), "arrow_right_up.png");
            this.w = p1.b(getApplicationContext(), "arrow_up_down.png");
            R = b.a(getApplicationContext(), this.p);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (i = this.n) == 0) {
            this.n = i + 1;
            this.k = this.a.getMeasuredWidth();
            this.l = this.a.getMeasuredHeight();
            int width = this.b.getWidth();
            int height = this.b.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale((float) ((this.k * 1.0d) / width), (float) ((this.l * 1.0d) / height));
            try {
                this.c = Bitmap.createBitmap(this.b, 0, 0, width, height, matrix, true).copy(Bitmap.Config.ARGB_8888, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            b();
            this.a.setImageBitmap(this.c);
            this.a.setOnTouchListener(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view2, motionEvent)) == null) {
            try {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX();
                            float y = motionEvent.getY();
                            if (this.i != null && this.j != null) {
                                if (!this.m) {
                                    Bitmap createBitmap = Bitmap.createBitmap(this.d);
                                    this.c = createBitmap;
                                    this.a.setImageBitmap(createBitmap);
                                    b();
                                    this.o.lineTo(x, y);
                                    this.i.drawPath(this.o, this.j);
                                } else {
                                    Bitmap createBitmap2 = Bitmap.createBitmap(this.d);
                                    this.c = createBitmap2;
                                    this.a.setImageBitmap(createBitmap2);
                                    b();
                                    if (this.q.size() > 0) {
                                        a(this.r.f, this.g, this.h, x, y);
                                    }
                                    if (this.E && (Math.abs(x - this.g) > 20.0f || Math.abs(y - this.h) > 20.0f)) {
                                        if (this.q.size() > 0) {
                                            if (this.r.e && this.r.f != -1) {
                                                this.B = false;
                                                return false;
                                            }
                                            this.B = true;
                                            f = y;
                                            f2 = x;
                                            this.i.drawRect(this.g, this.h, x, f, this.j);
                                        } else {
                                            f = y;
                                            f2 = x;
                                            this.B = true;
                                            this.i.drawRect(this.g, this.h, f2, f, this.j);
                                        }
                                    } else {
                                        f = y;
                                        f2 = x;
                                    }
                                    if (!this.E) {
                                        this.B = false;
                                    }
                                    this.e = f2;
                                    this.f = f;
                                    this.a.invalidate();
                                }
                            }
                            f = y;
                            f2 = x;
                            this.e = f2;
                            this.f = f;
                            this.a.invalidate();
                        }
                    } else {
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (this.m) {
                            this.L.obtainMessage(0).sendToTarget();
                            if (this.q.size() > 0) {
                                int i = this.r.f;
                                if (i != 13 && i != 14 && i != 24) {
                                    if (i != 1 && i != 2) {
                                        if ((i == 3 || i == 4) && this.r.b > this.r.d) {
                                            float f3 = this.r.b;
                                            this.r.b = this.r.d;
                                            this.r.d = f3;
                                        }
                                    } else if (this.r.a > this.r.c) {
                                        float f4 = this.r.a;
                                        this.r.a = this.r.c;
                                        this.r.c = f4;
                                    }
                                } else {
                                    if (this.r.a > this.r.c && this.r.b > this.r.d) {
                                        float f5 = this.r.c;
                                        float f6 = this.r.d;
                                        this.r.c = this.r.a;
                                        this.r.d = this.r.b;
                                        this.r.a = f5;
                                        this.r.b = f6;
                                    }
                                    if (this.r.a < this.r.c && this.r.b > this.r.d) {
                                        float f7 = this.r.b;
                                        this.r.b = this.r.d;
                                        this.r.d = f7;
                                    }
                                    if (this.r.a > this.r.c && this.r.b < this.r.d) {
                                        float f8 = this.r.a;
                                        this.r.a = this.r.c;
                                        this.r.c = f8;
                                    }
                                }
                                String str = "###selectedRect.getOperateTag(): " + this.r.f;
                            }
                            a(false);
                            for (Map.Entry<String, x> entry : this.q.entrySet()) {
                                String str2 = "key= " + entry.getKey() + " and value= " + entry.getValue();
                                this.i.drawRect(entry.getValue().a, entry.getValue().b, entry.getValue().c, entry.getValue().d, this.j);
                                entry.getValue().e = false;
                                entry.getValue().f = -1;
                            }
                            if (Math.abs(x2 - this.g) <= 20.0f && Math.abs(y2 - this.h) <= 20.0f) {
                                Iterator<Map.Entry<String, x>> it = this.q.entrySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Map.Entry<String, x> next = it.next();
                                    String str3 = "key= " + next.getKey() + " and value= " + next.getValue();
                                    if (next.getValue().a(x2, b.a(getApplicationContext(), 7.0f), y2, b.a(getApplicationContext(), 7.0f))) {
                                        next.getValue().e = true;
                                        next.getValue().f = 0;
                                        b(next.getValue().a, next.getValue().b, next.getValue().c, next.getValue().d);
                                        this.r = next.getValue();
                                        x value = next.getValue();
                                        this.x = value.a;
                                        this.y = value.b;
                                        this.z = value.c;
                                        this.A = value.d;
                                        break;
                                    }
                                }
                                this.a.invalidate();
                            }
                            if (this.B) {
                                this.i.drawRect(this.g, this.h, x2, y2, this.j);
                                a(this.g, this.h, x2, y2);
                            }
                            this.a.invalidate();
                        } else {
                            this.o.reset();
                        }
                    }
                } else {
                    this.g = motionEvent.getX();
                    this.h = motionEvent.getY();
                    this.e = motionEvent.getX();
                    float y3 = motionEvent.getY();
                    this.f = y3;
                    this.o.moveTo(this.e, y3);
                    this.d = Bitmap.createBitmap(this.c);
                    if (this.q.size() > 0 && this.r.e) {
                        this.r.f = this.r.a(this.g, this.h, (int) (getResources().getDisplayMetrics().density * 7.0f), (int) (getResources().getDisplayMetrics().density * 7.0f));
                        String str4 = "^#^ --> OperationTag: " + this.r.f;
                        if (this.r.f == 23) {
                            a(false);
                            this.q.remove(this.r.h);
                            for (Map.Entry<String, x> entry2 : this.q.entrySet()) {
                                String str5 = "key= " + entry2.getKey() + " and value= " + entry2.getValue();
                                this.i.drawRect(entry2.getValue().a, entry2.getValue().b, entry2.getValue().c, entry2.getValue().d, this.j);
                            }
                            return true;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
