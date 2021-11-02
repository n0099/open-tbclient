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
import android.util.Pair;
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
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.f.m;
import com.baidu.ufosdk.f.r;
import com.baidu.ufosdk.f.s;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes10.dex */
public class ScreenCapEditActivity extends Activity implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f56704a;

    /* renamed from: b  reason: collision with root package name */
    public static int f56705b;

    /* renamed from: d  reason: collision with root package name */
    public static int f56706d;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public float D;
    public boolean E;
    public RelativeLayout F;
    public ImageView G;
    public boolean H;
    public boolean I;
    public ByteArrayOutputStream J;
    public boolean K;
    public boolean L;
    public int M;
    public Handler N;
    public ImageView O;
    public RelativeLayout P;
    public RelativeLayout Q;
    public Button R;
    public TextView S;
    public Button T;
    public TextView U;
    public TextView V;

    /* renamed from: c  reason: collision with root package name */
    public int f56707c;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56708e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f56709f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f56710g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f56711h;

    /* renamed from: i  reason: collision with root package name */
    public float f56712i;
    public float j;
    public float k;
    public float l;
    public Canvas m;
    public Paint n;
    public int o;
    public int p;
    public boolean q;
    public int r;
    public Path s;
    public HashMap t;
    public a u;
    public Bitmap v;
    public Bitmap w;
    public Bitmap x;
    public Bitmap y;
    public Bitmap z;

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
        f56704a = b() + "/ufo/ufo_screen.jpeg";
        f56705b = -65536;
        f56706d = 0;
    }

    public ScreenCapEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56712i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.n = new Paint();
        this.q = true;
        this.r = 0;
        this.s = new Path();
        this.f56707c = 2;
        this.t = null;
        this.E = false;
        this.H = false;
        this.I = false;
        this.K = false;
        this.L = false;
        this.M = -1;
        this.N = new i(this);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.m = new Canvas(this.f56710g);
            this.n.setColor(f56705b);
            this.n.setStyle(Paint.Style.STROKE);
            float strokeWidth = this.n.getStrokeWidth();
            int i2 = f56706d;
            if (strokeWidth < i2) {
                this.n.setStrokeWidth(i2);
            }
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.n.setStrokeWidth(j.a(getApplicationContext(), 1.0f));
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(-1);
            this.m.drawCircle(f2, f3, j.a(getApplicationContext(), 7.0f), this.n);
            float f6 = (f3 + f5) / 2.0f;
            this.m.drawCircle(f2, f6, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f2, f5, j.a(getApplicationContext(), 7.0f), this.n);
            float f7 = (f2 + f4) / 2.0f;
            this.m.drawCircle(f7, f3, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f7, f5, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f4, f6, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f4, f5, j.a(getApplicationContext(), 7.0f), this.n);
            this.m.drawCircle(f4, f3, j.a(getApplicationContext(), 7.0f), this.n);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setColor(-65536);
            this.m.drawCircle(f2, f3, j.a(getApplicationContext(), 7.0f), this.n);
            this.m.drawCircle(f2, f6, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f2, f5, j.a(getApplicationContext(), 7.0f), this.n);
            this.m.drawCircle(f7, f3, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f7, f5, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f4, f6, j.a(getApplicationContext(), 5.0f), this.n);
            this.m.drawCircle(f4, f5, j.a(getApplicationContext(), 7.0f), this.n);
            this.m.drawCircle(f4, f3, j.a(getApplicationContext(), 7.0f), this.n);
            this.m.drawLine(f4, f3, f4 - j.a(getApplicationContext(), 3.0f), f3 + j.a(getApplicationContext(), 3.0f), this.n);
            this.m.drawLine(f4, f3, f4 + j.a(getApplicationContext(), 3.0f), f3 - j.a(getApplicationContext(), 3.0f), this.n);
            this.m.drawLine(f4, f3, f4 - j.a(getApplicationContext(), 3.0f), f3 - j.a(getApplicationContext(), 3.0f), this.n);
            this.m.drawLine(f4, f3, f4 + j.a(getApplicationContext(), 3.0f), f3 + j.a(getApplicationContext(), 3.0f), this.n);
        }
    }

    private void a(int i2, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            if (i2 == -1) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_NONE");
            } else if (i2 == 0) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_MOVE");
                float f6 = f4 - f2;
                float f7 = f5 - f3;
                this.u.a(this.A + f6);
                this.u.b(this.B + f7);
                this.u.c(this.C + f6);
                this.u.d(this.D + f7);
                a(false);
                for (Map.Entry entry : this.t.entrySet()) {
                    PrintStream printStream = System.out;
                    printStream.println("key= " + ((String) entry.getKey()) + " and value= " + entry.getValue());
                    this.m.drawRect(((a) entry.getValue()).b(), ((a) entry.getValue()).c(), ((a) entry.getValue()).d(), ((a) entry.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.x, (this.u.b() + this.u.d()) / 2.0f, (this.u.c() + this.u.e()) / 2.0f);
            } else if (i2 == 1) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT");
                this.u.a(this.A + (f4 - f2));
                a(false);
                for (Map.Entry entry2 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry2.getKey()) + " and value= " + entry2.getValue());
                    this.m.drawRect(((a) entry2.getValue()).b(), ((a) entry2.getValue()).c(), ((a) entry2.getValue()).d(), ((a) entry2.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.v, this.u.b(), (this.u.c() + this.u.e()) / 2.0f);
            } else if (i2 == 2) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT");
                this.u.c(this.C + (f4 - f2));
                a(false);
                for (Map.Entry entry3 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry3.getKey()) + " and value= " + entry3.getValue());
                    this.m.drawRect(((a) entry3.getValue()).b(), ((a) entry3.getValue()).c(), ((a) entry3.getValue()).d(), ((a) entry3.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.v, this.u.d(), (this.u.c() + this.u.e()) / 2.0f);
            } else if (i2 == 3) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_TOP");
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_DOWN");
                this.u.b(this.B + (f5 - f3));
                a(false);
                for (Map.Entry entry4 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry4.getKey()) + " and value= " + entry4.getValue());
                    this.m.drawRect(((a) entry4.getValue()).b(), ((a) entry4.getValue()).c(), ((a) entry4.getValue()).d(), ((a) entry4.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.z, (this.u.b() + this.u.d()) / 2.0f, this.u.c());
            } else if (i2 == 4) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_DOWN");
                this.u.d(this.D + (f5 - f3));
                a(false);
                for (Map.Entry entry5 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry5.getKey()) + " and value= " + entry5.getValue());
                    this.m.drawRect(((a) entry5.getValue()).b(), ((a) entry5.getValue()).c(), ((a) entry5.getValue()).d(), ((a) entry5.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.z, (this.u.b() + this.u.d()) / 2.0f, this.u.e());
            } else if (i2 == 13) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT_TOP");
                this.u.a(this.A + (f4 - f2));
                this.u.b(this.B + (f5 - f3));
                a(false);
                for (Map.Entry entry6 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry6.getKey()) + " and value= " + entry6.getValue());
                    this.m.drawRect(((a) entry6.getValue()).b(), ((a) entry6.getValue()).c(), ((a) entry6.getValue()).d(), ((a) entry6.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.w, this.u.b(), this.u.c());
            } else if (i2 == 14) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT_DOWN");
                this.u.a(this.A + (f4 - f2));
                this.u.d(this.D + (f5 - f3));
                a(false);
                for (Map.Entry entry7 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry7.getKey()) + " and value= " + entry7.getValue());
                    this.m.drawRect(((a) entry7.getValue()).b(), ((a) entry7.getValue()).c(), ((a) entry7.getValue()).d(), ((a) entry7.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.y, this.u.b(), this.u.e());
            } else if (i2 == 23) {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT_TOP");
            } else if (i2 != 24) {
                com.baidu.ufosdk.f.c.b("^v^ --> state default!");
            } else {
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT_DOWN");
                this.u.c(this.C + (f4 - f2));
                this.u.d(this.D + (f5 - f3));
                a(false);
                for (Map.Entry entry8 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry8.getKey()) + " and value= " + entry8.getValue());
                    this.m.drawRect(((a) entry8.getValue()).b(), ((a) entry8.getValue()).c(), ((a) entry8.getValue()).d(), ((a) entry8.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.w, this.u.d(), this.u.e());
            }
        }
    }

    private void a(Bitmap bitmap, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{bitmap, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.m.drawBitmap(bitmap, f2 - (bitmap.getWidth() / 2), f3 - (bitmap.getHeight() / 2), this.n);
        }
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{canvas, paint, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            paint.setStrokeWidth(j.a(getApplicationContext(), 1.0f));
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-1);
            canvas.drawCircle(f2, f3, j.a(getApplicationContext(), 7.0f), paint);
            float f6 = (f3 + f5) / 2.0f;
            canvas.drawCircle(f2, f6, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f2, f5, j.a(getApplicationContext(), 7.0f), paint);
            float f7 = (f2 + f4) / 2.0f;
            canvas.drawCircle(f7, f3, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f7, f5, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f4, f6, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f4, f5, j.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f4, f3, j.a(getApplicationContext(), 7.0f), paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(-65536);
            canvas.drawCircle(f2, f3, j.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f2, f6, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f2, f5, j.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f7, f3, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f7, f5, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f4, f6, j.a(getApplicationContext(), 5.0f), paint);
            canvas.drawCircle(f4, f5, j.a(getApplicationContext(), 7.0f), paint);
            canvas.drawCircle(f4, f3, j.a(getApplicationContext(), 7.0f), paint);
            canvas.drawLine(f4, f3, f4 - j.a(getApplicationContext(), 3.0f), f3 + j.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f4, f3, f4 + j.a(getApplicationContext(), 3.0f), f3 - j.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f4, f3, f4 - j.a(getApplicationContext(), 3.0f), f3 - j.a(getApplicationContext(), 3.0f), paint);
            canvas.drawLine(f4, f3, f4 + j.a(getApplicationContext(), 3.0f), f3 + j.a(getApplicationContext(), 3.0f), paint);
            String str = System.currentTimeMillis() + UUID.randomUUID().toString();
            a aVar = new a(f2, f3, f4, f5, str);
            this.t.put(str, aVar);
            this.u = aVar;
            a(aVar);
            this.H = false;
            if (0 != 0) {
                this.Q.setBackgroundColor(-16777216);
                return;
            }
            RelativeLayout relativeLayout = this.Q;
            getApplicationContext();
            relativeLayout.setBackgroundDrawable(m.a(-16777216));
        }
    }

    public static /* synthetic */ void a(ScreenCapEditActivity screenCapEditActivity, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        screenCapEditActivity.J = byteArrayOutputStream;
        Bitmap bitmap = screenCapEditActivity.f56710g;
        int i3 = 90;
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        int length = screenCapEditActivity.J.toByteArray().length;
        while (length > 300000 && i3 >= 0) {
            i3 -= 10;
            com.baidu.ufosdk.f.c.c("quality is " + i3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            screenCapEditActivity.J = byteArrayOutputStream2;
            screenCapEditActivity.f56710g.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream2);
            length = screenCapEditActivity.J.toByteArray().length;
            com.baidu.ufosdk.f.c.c("streamLength is " + length);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        new h(screenCapEditActivity, i2).run();
    }

    private void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, aVar) == null) {
            this.A = aVar.b();
            this.B = aVar.c();
            this.C = aVar.d();
            this.D = aVar.e();
            com.baidu.ufosdk.f.c.b("------- set orignial value!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, this, z) == null) {
            try {
                int width = this.f56709f.getWidth();
                int height = this.f56709f.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
                Bitmap copy = Bitmap.createBitmap(this.f56709f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
                this.f56710g = copy;
                this.f56708e.setImageBitmap(copy);
                a();
                this.f56708e.invalidate();
                if (z) {
                    this.t.clear();
                }
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("clearCanvas error!", e2);
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            } catch (OutOfMemoryError e3) {
                com.baidu.ufosdk.f.c.d("clearCanvas " + e3.getMessage());
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
            if (externalStorageDirectory == null) {
                return null;
            }
            return externalStorageDirectory.toString();
        }
        return (String) invokeV.objValue;
    }

    public static /* synthetic */ void i(ScreenCapEditActivity screenCapEditActivity) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        screenCapEditActivity.J = byteArrayOutputStream;
        Bitmap bitmap = screenCapEditActivity.f56710g;
        int i2 = 90;
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        int length = screenCapEditActivity.J.toByteArray().length;
        while (length > 300000 && i2 >= 0) {
            i2 -= 10;
            com.baidu.ufosdk.f.c.c("quality is " + i2);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            screenCapEditActivity.J = byteArrayOutputStream2;
            screenCapEditActivity.f56710g.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream2);
            length = screenCapEditActivity.J.toByteArray().length;
            com.baidu.ufosdk.f.c.c("streamLength is " + length);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        Intent intent = new Intent();
        intent.putExtra("shot", screenCapEditActivity.J.toByteArray());
        screenCapEditActivity.setResult(-1, intent);
        screenCapEditActivity.finish();
    }

    public static /* synthetic */ void j(ScreenCapEditActivity screenCapEditActivity) {
        String str = b() + "/ufo";
        try {
            File file = new File(str);
            f56704a = str + "/ufo_" + System.currentTimeMillis() + ".jpeg";
            StringBuilder sb = new StringBuilder("--savePic--");
            sb.append(f56704a);
            com.baidu.ufosdk.f.c.b(sb.toString());
            File file2 = new File(f56704a);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            screenCapEditActivity.f56710g.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(screenCapEditActivity, s.a("56"), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                if (this.I && this.K) {
                    setResult(-77, new Intent());
                }
                finish();
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x061b  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        int i2;
        FrameLayout.LayoutParams layoutParams;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            r.a(this, getWindow());
            r.a(getWindow(), com.baidu.ufosdk.b.L);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            String stringExtra = getIntent().getStringExtra("shotUrl");
            this.K = getIntent().getBooleanExtra("direct", false);
            this.L = getIntent().getBooleanExtra("from_app", false);
            this.M = getIntent().getIntExtra("extend_feedback_channel", -1);
            if (byteArrayExtra != null && byteArrayExtra.length > 0) {
                this.f56709f = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
                this.I = true;
                str = "ScreenCapEditActivity --> bitmap via shot byte[] & bitmap size is " + (byteArrayExtra.length / 1024) + "kb";
            } else if (stringExtra != null && stringExtra.length() != 0) {
                this.f56709f = BitmapFactory.decodeFile(stringExtra);
                this.I = true;
                str = "ScreenCapEditActivity --> bitmap via shotUrl";
            } else if (b() == null) {
                com.baidu.ufosdk.f.c.d("ScreenCapEditActivity --> getSDCardPath() == null");
                Intent intent = new Intent();
                intent.setClass(this, FeedbackEditActivity.class);
                intent.putExtra("fromlist", "no");
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                intent.putExtra("come_from", 2);
                startActivity(intent);
                finish();
                return;
            } else {
                if (!new File(b() + "/ufo/ufo_screen.jpeg").exists()) {
                    com.baidu.ufosdk.f.c.d("getSDCardPath() != null & file not exists -> bitmap == null");
                    Intent intent2 = new Intent();
                    intent2.setClass(this, FeedbackEditActivity.class);
                    intent2.putExtra("fromlist", "no");
                    intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                    intent2.putExtra("come_from", 2);
                    startActivity(intent2);
                    finish();
                    return;
                }
                try {
                    this.f56709f = BitmapFactory.decodeFile(b() + "/ufo/ufo_screen.jpeg").copy(Bitmap.Config.RGB_565, true);
                } catch (OutOfMemoryError e2) {
                    com.baidu.ufosdk.f.c.d("clearCanvas " + e2.getMessage());
                    Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                    finish();
                }
                this.I = false;
                str = "ScreenCapEditActivity --> bitmap via screenshot";
            }
            com.baidu.ufosdk.f.c.c(str);
            Bitmap bitmap = this.f56709f;
            if (bitmap == null) {
                com.baidu.ufosdk.f.c.d("ScreenCapEditActivity --> [shot != null & bitmap == null]:decode shot to bitmap error!!");
                Intent intent3 = new Intent();
                intent3.setClass(this, FeedbackEditActivity.class);
                intent3.putExtra("fromlist", "no");
                intent3.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                intent3.putExtra("come_from", 2);
                startActivity(intent3);
                finish();
                return;
            }
            int width = bitmap.getWidth();
            int height = this.f56709f.getHeight();
            com.baidu.ufosdk.f.c.b("图片尺寸 --> width = " + width + "; height = " + height);
            int i4 = width > height ? 3 : width * 4 > height * 3 ? 1 : width * 2 > height ? 0 : 2;
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.F = relativeLayout;
            relativeLayout.setFitsSystemWindows(true);
            this.F.setId(R.id.App_Launch_Circle_Animation_View);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.App_Launch_Shimmer_Animation_View);
            this.F.setBackgroundColor(-15066598);
            Button button = new Button(this);
            this.R = button;
            button.setText(s.a(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
            this.R.setTextSize(com.baidu.ufosdk.b.M);
            this.R.setTextColor(-1);
            this.R.setGravity(17);
            this.R.setTextColor(-1);
            this.R.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
            Button button2 = this.R;
            getApplicationContext();
            button2.setBackgroundDrawable(m.a(-16777216));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
            relativeLayout2.addView(this.R, layoutParams2);
            TextView textView = new TextView(this);
            this.S = textView;
            textView.setId(R.id.BOTH);
            this.S.setText(s.a("50"));
            this.S.setTextColor(-1);
            this.S.setTextSize(com.baidu.ufosdk.b.T);
            this.S.setGravity(17);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(13);
            relativeLayout2.addView(this.S, layoutParams3);
            Button button3 = new Button(this);
            this.T = button3;
            button3.setText(s.a("51"));
            this.T.setId(R.id.BOTTOM);
            this.T.setTextColor(com.baidu.ufosdk.b.v);
            this.T.setTextSize(com.baidu.ufosdk.b.U);
            this.T.setGravity(17);
            this.T.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
            Button button4 = this.T;
            getApplicationContext();
            button4.setBackgroundDrawable(m.a(-16777216));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(11);
            layoutParams4.addRule(15);
            relativeLayout2.addView(this.T, layoutParams4);
            relativeLayout2.setBackgroundColor(-15066598);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 70.0f));
            layoutParams5.addRule(10);
            this.F.addView(relativeLayout2, layoutParams5);
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(R.id.BOTTOM_END);
            linearLayout.setOrientation(0);
            linearLayout.setBackgroundColor(-15066598);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            this.Q = relativeLayout3;
            relativeLayout3.setId(R.id.CTRL);
            RelativeLayout relativeLayout4 = this.Q;
            getApplicationContext();
            relativeLayout4.setBackgroundDrawable(m.a(-15395563));
            ImageView imageView = new ImageView(this);
            this.G = imageView;
            imageView.setId(R.id.META);
            this.G.setBackgroundDrawable(new BitmapDrawable(m.a(getApplicationContext(), "rect_normal.png")));
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
            layoutParams6.addRule(14);
            layoutParams6.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            this.Q.addView(this.G, layoutParams6);
            TextView textView2 = new TextView(this);
            this.U = textView2;
            textView2.setId(R.id.MULTI);
            this.U.setText(s.a("52"));
            this.U.setTextColor(-1);
            this.U.setTextSize(12.0f);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.addRule(14);
            layoutParams7.addRule(3, this.G.getId());
            this.Q.addView(this.U, layoutParams7);
            this.Q.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f));
            this.G.setOnClickListener(new b(this));
            this.Q.setOnClickListener(new c(this));
            RelativeLayout relativeLayout5 = new RelativeLayout(this);
            this.P = relativeLayout5;
            relativeLayout5.setClickable(false);
            this.P.setId(R.id.NONE);
            RelativeLayout relativeLayout6 = this.P;
            getApplicationContext();
            relativeLayout6.setBackgroundDrawable(m.a(-16777216));
            this.P.setClickable(true);
            ImageView imageView2 = new ImageView(this);
            this.O = imageView2;
            imageView2.setId(R.id.NO_DEBUG);
            this.O.setBackgroundDrawable(new BitmapDrawable(m.a(this, "delete_all_disable.png")));
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
            layoutParams8.addRule(14);
            layoutParams8.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            this.P.addView(this.O, layoutParams8);
            TextView textView3 = new TextView(this);
            this.V = textView3;
            textView3.setId(R.id.NORMAL);
            this.V.setText(s.a("53"));
            this.V.setTextColor(-10066330);
            this.V.setTextSize(12.0f);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(14);
            layoutParams9.addRule(3, this.O.getId());
            this.P.addView(this.V, layoutParams9);
            this.P.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams10.weight = 1.0f;
            linearLayout.addView(this.Q, layoutParams10);
            linearLayout.addView(this.P, layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 55.0f));
            layoutParams11.addRule(12);
            layoutParams11.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), 0);
            this.F.addView(linearLayout, layoutParams11);
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setId(R.id.Backward);
            ImageView imageView3 = new ImageView(this);
            this.f56708e = imageView3;
            imageView3.setId(R.id.BOTTOM_START);
            this.f56708e.setBackgroundColor(-16777216);
            com.baidu.ufosdk.f.c.a("^^ imgvStyle = " + i4);
            if (i4 == 0) {
                i2 = -1;
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (i4 != 3) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                i3 = 17;
                i2 = -1;
                layoutParams.gravity = i3;
                frameLayout.addView(this.f56708e, layoutParams);
                RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(i2, i2);
                if (i4 != 3) {
                    layoutParams12.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
                } else {
                    layoutParams12.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
                }
                layoutParams12.addRule(3, relativeLayout2.getId());
                layoutParams12.addRule(2, linearLayout.getId());
                this.F.addView(frameLayout, layoutParams12);
                this.T.setOnClickListener(new d(this));
                this.R.setOnClickListener(new e(this));
                this.P.setOnClickListener(new f(this));
                this.O.setOnClickListener(new g(this));
                setContentView(this.F);
                this.f56708e.getViewTreeObserver().addOnGlobalLayoutListener(this);
                if (this.f56709f != null) {
                    this.f56708e.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    this.f56708e.setImageBitmap(this.f56709f);
                }
                this.n.setColor(f56705b);
                this.n.setStyle(Paint.Style.STROKE);
                this.n.setStrokeCap(Paint.Cap.ROUND);
                this.n.setStrokeJoin(Paint.Join.ROUND);
                this.n.setAntiAlias(true);
                this.t = new HashMap();
                this.v = m.a(getApplicationContext(), "arrow_left_right.png");
                this.w = m.a(getApplicationContext(), "arrow_left_up.png");
                this.x = m.a(getApplicationContext(), "arrow_move.png");
                this.y = m.a(getApplicationContext(), "arrow_right_up.png");
                this.z = m.a(getApplicationContext(), "arrow_up_down.png");
                f56706d = j.a(getApplicationContext(), this.f56707c);
            } else {
                Pair a2 = j.a(this);
                float f2 = -2.0f;
                if (a2 != null) {
                    int intValue = ((Integer) a2.first).intValue() - com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f);
                    com.baidu.ufosdk.f.c.a("Measure ImageView width: " + intValue);
                    f2 = ((float) this.f56709f.getHeight()) * (((float) intValue) / ((float) this.f56709f.getWidth()));
                    com.baidu.ufosdk.f.c.a("Measure ImageView height: " + f2);
                }
                i2 = -1;
                layoutParams = new FrameLayout.LayoutParams(-1, Math.round(f2));
            }
            i3 = 17;
            layoutParams.gravity = i3;
            frameLayout.addView(this.f56708e, layoutParams);
            RelativeLayout.LayoutParams layoutParams122 = new RelativeLayout.LayoutParams(i2, i2);
            if (i4 != 3) {
            }
            layoutParams122.addRule(3, relativeLayout2.getId());
            layoutParams122.addRule(2, linearLayout.getId());
            this.F.addView(frameLayout, layoutParams122);
            this.T.setOnClickListener(new d(this));
            this.R.setOnClickListener(new e(this));
            this.P.setOnClickListener(new f(this));
            this.O.setOnClickListener(new g(this));
            setContentView(this.F);
            this.f56708e.getViewTreeObserver().addOnGlobalLayoutListener(this);
            if (this.f56709f != null) {
            }
            this.n.setColor(f56705b);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setStrokeCap(Paint.Cap.ROUND);
            this.n.setStrokeJoin(Paint.Join.ROUND);
            this.n.setAntiAlias(true);
            this.t = new HashMap();
            this.v = m.a(getApplicationContext(), "arrow_left_right.png");
            this.w = m.a(getApplicationContext(), "arrow_left_up.png");
            this.x = m.a(getApplicationContext(), "arrow_move.png");
            this.y = m.a(getApplicationContext(), "arrow_right_up.png");
            this.z = m.a(getApplicationContext(), "arrow_up_down.png");
            f56706d = j.a(getApplicationContext(), this.f56707c);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.baidu.ufosdk.f.c.a("onGlobalLayout --> onGlobalLayout!!!");
            int i2 = this.r;
            if (i2 == 0) {
                try {
                    this.r = i2 + 1;
                    this.o = this.f56708e.getMeasuredWidth();
                    this.p = this.f56708e.getMeasuredHeight();
                    int width = this.f56709f.getWidth();
                    int height = this.f56709f.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
                    this.f56710g = Bitmap.createBitmap(this.f56709f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
                    a();
                    this.f56708e.setImageBitmap(this.f56710g);
                    this.f56708e.setOnTouchListener(this);
                    com.baidu.ufosdk.f.c.a("onGlobalLayout --> onGlobalLayout!!!--in");
                } catch (Exception e2) {
                    com.baidu.ufosdk.f.c.a("onGlobalLayout error!", e2);
                    Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                    finish();
                } catch (OutOfMemoryError e3) {
                    com.baidu.ufosdk.f.c.d("onGlobalLayout " + e3.getMessage());
                    Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                    finish();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
            if (resumeCallBack != null) {
                resumeCallBack.onResumeCallback();
            }
            this.R.setText(s.a(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
            this.S.setText(s.a("50"));
            this.T.setText(s.a("51"));
            this.U.setText(s.a("52"));
            this.V.setText(s.a("53"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x01bf, code lost:
        if (r19.u.c() < r19.u.e()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f5, code lost:
        if (r19.u.b() > r19.u.d()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f7, code lost:
        r0 = r19.u.b();
        r4 = r19.u;
        r4.a(r4.d());
        r19.u.c(r0);
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        float f2;
        float f3;
        Canvas canvas;
        float f4;
        float f5;
        Paint paint;
        float f6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.k = motionEvent.getX();
                this.l = motionEvent.getY();
                this.f56712i = motionEvent.getX();
                float y = motionEvent.getY();
                this.j = y;
                this.s.moveTo(this.f56712i, y);
                this.f56711h = Bitmap.createBitmap(this.f56710g);
                if (this.t.size() > 0 && this.u.f()) {
                    a aVar = this.u;
                    aVar.a(aVar.a(this.k, this.l, j.a(getApplicationContext(), 7.0f), j.a(getApplicationContext(), 7.0f)));
                    com.baidu.ufosdk.f.c.b("^#^ --> OperationTag: " + this.u.g());
                    if (this.u.g() == 23) {
                        a(false);
                        this.t.remove(this.u.a());
                        for (Map.Entry entry : this.t.entrySet()) {
                            com.baidu.ufosdk.f.c.a("key= " + ((String) entry.getKey()) + " and value= " + entry.getValue());
                            this.m.drawRect(((a) entry.getValue()).b(), ((a) entry.getValue()).c(), ((a) entry.getValue()).d(), ((a) entry.getValue()).e(), this.n);
                        }
                    }
                }
            } else if (action == 1) {
                float x = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (this.q) {
                    this.N.obtainMessage(0).sendToTarget();
                    if (this.t.size() > 0) {
                        int g2 = this.u.g();
                        if (g2 != 1 && g2 != 2) {
                            if (g2 == 3 || g2 == 4) {
                                if (this.u.c() > this.u.e()) {
                                    float c2 = this.u.c();
                                    a aVar2 = this.u;
                                    aVar2.b(aVar2.e());
                                    this.u.d(c2);
                                }
                            } else if (g2 == 13 || g2 == 14 || g2 == 24) {
                                if (this.u.b() > this.u.d() && this.u.c() > this.u.e()) {
                                    float d2 = this.u.d();
                                    float e2 = this.u.e();
                                    a aVar3 = this.u;
                                    aVar3.c(aVar3.b());
                                    a aVar4 = this.u;
                                    aVar4.d(aVar4.c());
                                    this.u.a(d2);
                                    this.u.b(e2);
                                }
                                if (this.u.b() < this.u.d() && this.u.c() > this.u.e()) {
                                    float c3 = this.u.c();
                                    a aVar5 = this.u;
                                    aVar5.b(aVar5.e());
                                    this.u.d(c3);
                                }
                                if (this.u.b() > this.u.d()) {
                                }
                            }
                            com.baidu.ufosdk.f.c.b("###selectedRect.getOperateTag(): " + this.u.g());
                        }
                        this.f56708e.invalidate();
                    }
                    a(false);
                    for (Map.Entry entry2 : this.t.entrySet()) {
                        com.baidu.ufosdk.f.c.a("key= " + ((String) entry2.getKey()) + " and value= " + entry2.getValue());
                        this.m.drawRect(((a) entry2.getValue()).b(), ((a) entry2.getValue()).c(), ((a) entry2.getValue()).d(), ((a) entry2.getValue()).e(), this.n);
                        ((a) entry2.getValue()).a(false);
                        ((a) entry2.getValue()).a(-1);
                    }
                    if (Math.abs(x - this.k) <= 20.0f && Math.abs(y2 - this.l) <= 20.0f) {
                        Iterator it = this.t.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry3 = (Map.Entry) it.next();
                            com.baidu.ufosdk.f.c.a("key= " + ((String) entry3.getKey()) + " and value= " + entry3.getValue());
                            if (((a) entry3.getValue()).a(x, j.a(getApplicationContext(), 7.0f), y2, j.a(getApplicationContext(), 7.0f))) {
                                ((a) entry3.getValue()).a(true);
                                ((a) entry3.getValue()).a(0);
                                a(((a) entry3.getValue()).b(), ((a) entry3.getValue()).c(), ((a) entry3.getValue()).d(), ((a) entry3.getValue()).e());
                                this.u = (a) entry3.getValue();
                                a((a) entry3.getValue());
                                break;
                            }
                        }
                    } else if (this.E) {
                        this.m.drawRect(this.k, this.l, x, y2, this.n);
                        float f7 = this.k;
                        float f8 = this.l;
                        int i2 = (x > f7 ? 1 : (x == f7 ? 0 : -1));
                        if (i2 > 0 && y2 > f8) {
                            a(this.m, this.n, f7, f8, x, y2);
                        }
                        if (i2 > 0 && y2 < f8) {
                            a(this.m, this.n, f7, y2, x, f8);
                        }
                        int i3 = (x > f7 ? 1 : (x == f7 ? 0 : -1));
                        if (i3 < 0 && y2 > f8) {
                            a(this.m, this.n, x, f8, f7, y2);
                        }
                        if (i3 < 0 && y2 < f8) {
                            a(this.m, this.n, x, y2, f7, f8);
                        }
                        if (i2 == 0 || y2 == f8) {
                            a(this.m, this.n, f7, f8, x, y2);
                        }
                    }
                    this.f56708e.invalidate();
                } else {
                    this.s.reset();
                }
            } else if (action == 2) {
                float x2 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (this.m != null && this.n != null) {
                    if (this.q) {
                        Bitmap createBitmap = Bitmap.createBitmap(this.f56711h);
                        this.f56710g = createBitmap;
                        this.f56708e.setImageBitmap(createBitmap);
                        a();
                        if (this.t.size() > 0) {
                            a(this.u.g(), this.k, this.l, x2, y3);
                        }
                        if (!this.H || (Math.abs(x2 - this.k) <= 20.0f && Math.abs(y3 - this.l) <= 20.0f)) {
                            f2 = y3;
                            f3 = x2;
                        } else {
                            if (this.t.size() <= 0) {
                                f2 = y3;
                                f3 = x2;
                                this.E = true;
                                canvas = this.m;
                                f4 = this.k;
                                f5 = this.l;
                                paint = this.n;
                                f6 = f3;
                            } else if (this.u.f() && this.u.g() != -1) {
                                this.E = false;
                                return false;
                            } else {
                                this.E = true;
                                canvas = this.m;
                                f4 = this.k;
                                f5 = this.l;
                                paint = this.n;
                                f2 = y3;
                                f6 = x2;
                                f3 = x2;
                            }
                            canvas.drawRect(f4, f5, f6, f2, paint);
                        }
                        if (!this.H) {
                            this.E = false;
                        }
                        this.f56712i = f3;
                        this.j = f2;
                        this.f56708e.invalidate();
                    } else {
                        Bitmap createBitmap2 = Bitmap.createBitmap(this.f56711h);
                        this.f56710g = createBitmap2;
                        this.f56708e.setImageBitmap(createBitmap2);
                        a();
                        this.s.lineTo(x2, y3);
                        this.m.drawPath(this.s, this.n);
                    }
                }
                f2 = y3;
                f3 = x2;
                this.f56712i = f3;
                this.j = f2;
                this.f56708e.invalidate();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
