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
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class ScreenCapEditActivity extends Activity implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f22657a = b() + "/ufo/ufo_screen.jpeg";

    /* renamed from: b  reason: collision with root package name */
    public static int f22658b = -65536;

    /* renamed from: d  reason: collision with root package name */
    public static int f22659d = 0;
    public float A;
    public float B;
    public float C;
    public float D;
    public RelativeLayout F;
    public ImageView G;
    public ByteArrayOutputStream J;
    public ImageView O;
    public RelativeLayout P;
    public RelativeLayout Q;
    public Button R;
    public TextView S;
    public Button T;
    public TextView U;
    public TextView V;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f22661e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f22662f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f22663g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f22664h;
    public Canvas m;
    public int o;
    public int p;
    public a u;
    public Bitmap v;
    public Bitmap w;
    public Bitmap x;
    public Bitmap y;
    public Bitmap z;
    public float i = 0.0f;
    public float j = 0.0f;
    public float k = 0.0f;
    public float l = 0.0f;
    public Paint n = new Paint();
    public boolean q = true;
    public int r = 0;
    public Path s = new Path();

    /* renamed from: c  reason: collision with root package name */
    public int f22660c = 2;
    public HashMap t = null;
    public boolean E = false;
    public boolean H = false;
    public boolean I = false;
    public boolean K = false;
    public boolean L = false;
    public int M = -1;
    public Handler N = new i(this);

    private void a() {
        this.m = new Canvas(this.f22663g);
        this.n.setColor(f22658b);
        this.n.setStyle(Paint.Style.STROKE);
        float strokeWidth = this.n.getStrokeWidth();
        int i = f22659d;
        if (strokeWidth < i) {
            this.n.setStrokeWidth(i);
        }
    }

    private void a(float f2, float f3, float f4, float f5) {
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

    private void a(int i, float f2, float f3, float f4, float f5) {
        if (i == -1) {
            com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_NONE");
        } else if (i == 0) {
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
        } else if (i == 1) {
            com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT");
            this.u.a(this.A + (f4 - f2));
            a(false);
            for (Map.Entry entry2 : this.t.entrySet()) {
                com.baidu.ufosdk.f.c.a("key= " + ((String) entry2.getKey()) + " and value= " + entry2.getValue());
                this.m.drawRect(((a) entry2.getValue()).b(), ((a) entry2.getValue()).c(), ((a) entry2.getValue()).d(), ((a) entry2.getValue()).e(), this.n);
            }
            a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
            a(this.v, this.u.b(), (this.u.c() + this.u.e()) / 2.0f);
        } else if (i == 2) {
            com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT");
            this.u.c(this.C + (f4 - f2));
            a(false);
            for (Map.Entry entry3 : this.t.entrySet()) {
                com.baidu.ufosdk.f.c.a("key= " + ((String) entry3.getKey()) + " and value= " + entry3.getValue());
                this.m.drawRect(((a) entry3.getValue()).b(), ((a) entry3.getValue()).c(), ((a) entry3.getValue()).d(), ((a) entry3.getValue()).e(), this.n);
            }
            a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
            a(this.v, this.u.d(), (this.u.c() + this.u.e()) / 2.0f);
        } else if (i == 3) {
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
        } else if (i == 4) {
            com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_DOWN");
            this.u.d(this.D + (f5 - f3));
            a(false);
            for (Map.Entry entry5 : this.t.entrySet()) {
                com.baidu.ufosdk.f.c.a("key= " + ((String) entry5.getKey()) + " and value= " + entry5.getValue());
                this.m.drawRect(((a) entry5.getValue()).b(), ((a) entry5.getValue()).c(), ((a) entry5.getValue()).d(), ((a) entry5.getValue()).e(), this.n);
            }
            a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
            a(this.z, (this.u.b() + this.u.d()) / 2.0f, this.u.e());
        } else if (i == 13) {
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
        } else if (i == 14) {
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
        } else if (i == 23) {
            com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT_TOP");
        } else if (i != 24) {
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

    private void a(Bitmap bitmap, float f2, float f3) {
        this.m.drawBitmap(bitmap, f2 - (bitmap.getWidth() / 2), f3 - (bitmap.getHeight() / 2), this.n);
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, float f4, float f5) {
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

    public static /* synthetic */ void a(ScreenCapEditActivity screenCapEditActivity, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        screenCapEditActivity.J = byteArrayOutputStream;
        Bitmap bitmap = screenCapEditActivity.f22663g;
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
            screenCapEditActivity.f22663g.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream2);
            length = screenCapEditActivity.J.toByteArray().length;
            com.baidu.ufosdk.f.c.c("streamLength is " + length);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        new h(screenCapEditActivity, i).run();
    }

    private void a(a aVar) {
        this.A = aVar.b();
        this.B = aVar.c();
        this.C = aVar.d();
        this.D = aVar.e();
        com.baidu.ufosdk.f.c.b("------- set orignial value!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            int width = this.f22662f.getWidth();
            int height = this.f22662f.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
            Bitmap copy = Bitmap.createBitmap(this.f22662f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
            this.f22663g = copy;
            this.f22661e.setImageBitmap(copy);
            a();
            this.f22661e.invalidate();
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

    public static String b() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory == null) {
            return null;
        }
        return externalStorageDirectory.toString();
    }

    public static /* synthetic */ void i(ScreenCapEditActivity screenCapEditActivity) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        screenCapEditActivity.J = byteArrayOutputStream;
        Bitmap bitmap = screenCapEditActivity.f22663g;
        int i = 90;
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d((long) screenCapEditActivity.J.toByteArray().length));
        int length = screenCapEditActivity.J.toByteArray().length;
        while (length > 300000 && i >= 0) {
            i -= 10;
            com.baidu.ufosdk.f.c.c("quality is " + i);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            screenCapEditActivity.J = byteArrayOutputStream2;
            screenCapEditActivity.f22663g.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream2);
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
            f22657a = str + "/ufo_" + System.currentTimeMillis() + ".jpeg";
            StringBuilder sb = new StringBuilder("--savePic--");
            sb.append(f22657a);
            com.baidu.ufosdk.f.c.b(sb.toString());
            File file2 = new File(f22657a);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            screenCapEditActivity.f22663g.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(screenCapEditActivity, s.a("56"), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            if (this.I && this.K) {
                setResult(-77, new Intent());
            }
            finish();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0618  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        FrameLayout.LayoutParams layoutParams;
        int i2;
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
            this.f22662f = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            this.I = true;
            str = "ScreenCapEditActivity --> bitmap via shot byte[] & bitmap size is " + (byteArrayExtra.length / 1024) + "kb";
        } else if (stringExtra != null && stringExtra.length() != 0) {
            this.f22662f = BitmapFactory.decodeFile(stringExtra);
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
                this.f22662f = BitmapFactory.decodeFile(b() + "/ufo/ufo_screen.jpeg").copy(Bitmap.Config.RGB_565, true);
            } catch (OutOfMemoryError e2) {
                com.baidu.ufosdk.f.c.d("clearCanvas " + e2.getMessage());
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            }
            this.I = false;
            str = "ScreenCapEditActivity --> bitmap via screenshot";
        }
        com.baidu.ufosdk.f.c.c(str);
        Bitmap bitmap = this.f22662f;
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
        int height = this.f22662f.getHeight();
        com.baidu.ufosdk.f.c.b("图片尺寸 --> width = " + width + "; height = " + height);
        int i3 = width > height ? 3 : width * 4 > height * 3 ? 1 : width * 2 > height ? 0 : 2;
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.F = relativeLayout;
        relativeLayout.setFitsSystemWindows(true);
        this.F.setId(R.id.BLOCK);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setId(R.id.BOTH);
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
        textView.setId(R.id.Backward);
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
        this.T.setId(R.id.CTRL);
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
        linearLayout.setId(R.id.DOWN);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-15066598);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        this.Q = relativeLayout3;
        relativeLayout3.setId(R.id.Forward);
        RelativeLayout relativeLayout4 = this.Q;
        getApplicationContext();
        relativeLayout4.setBackgroundDrawable(m.a(-15395563));
        ImageView imageView = new ImageView(this);
        this.G = imageView;
        imageView.setId(R.id.SHIFT);
        this.G.setBackgroundDrawable(new BitmapDrawable(m.a(getApplicationContext(), "rect_normal.png")));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
        layoutParams6.addRule(14);
        layoutParams6.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.Q.addView(this.G, layoutParams6);
        TextView textView2 = new TextView(this);
        this.U = textView2;
        textView2.setId(R.id.STROKE);
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
        this.P.setId(R.id.SYM);
        RelativeLayout relativeLayout6 = this.P;
        getApplicationContext();
        relativeLayout6.setBackgroundDrawable(m.a(-16777216));
        this.P.setClickable(true);
        ImageView imageView2 = new ImageView(this);
        this.O = imageView2;
        imageView2.setId(R.id.TRIANGLE);
        this.O.setBackgroundDrawable(new BitmapDrawable(m.a(this, "delete_all_disable.png")));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
        layoutParams8.addRule(14);
        layoutParams8.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.P.addView(this.O, layoutParams8);
        TextView textView3 = new TextView(this);
        this.V = textView3;
        textView3.setId(R.id.TOP);
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
        frameLayout.setId(R.id.FUNCTION);
        ImageView imageView3 = new ImageView(this);
        this.f22661e = imageView3;
        imageView3.setId(R.id.FILL);
        this.f22661e.setBackgroundColor(-16777216);
        com.baidu.ufosdk.f.c.a("^^ imgvStyle = " + i3);
        if (i3 == 0) {
            i = -1;
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else if (i3 != 3) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
            i2 = 17;
            i = -1;
            layoutParams.gravity = i2;
            frameLayout.addView(this.f22661e, layoutParams);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(i, i);
            if (i3 != 3) {
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
            this.f22661e.getViewTreeObserver().addOnGlobalLayoutListener(this);
            if (this.f22662f != null) {
                this.f22661e.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f22661e.setImageBitmap(this.f22662f);
            }
            this.n.setColor(f22658b);
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
            f22659d = j.a(getApplicationContext(), this.f22660c);
        } else {
            Pair a2 = j.a(this);
            float f2 = -2.0f;
            if (a2 != null) {
                int intValue = ((Integer) a2.first).intValue() - com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f);
                com.baidu.ufosdk.f.c.a("Measure ImageView width: " + intValue);
                f2 = ((float) this.f22662f.getHeight()) * (((float) intValue) / ((float) this.f22662f.getWidth()));
                com.baidu.ufosdk.f.c.a("Measure ImageView height: " + f2);
            }
            i = -1;
            layoutParams = new FrameLayout.LayoutParams(-1, Math.round(f2));
        }
        i2 = 17;
        layoutParams.gravity = i2;
        frameLayout.addView(this.f22661e, layoutParams);
        RelativeLayout.LayoutParams layoutParams122 = new RelativeLayout.LayoutParams(i, i);
        if (i3 != 3) {
        }
        layoutParams122.addRule(3, relativeLayout2.getId());
        layoutParams122.addRule(2, linearLayout.getId());
        this.F.addView(frameLayout, layoutParams122);
        this.T.setOnClickListener(new d(this));
        this.R.setOnClickListener(new e(this));
        this.P.setOnClickListener(new f(this));
        this.O.setOnClickListener(new g(this));
        setContentView(this.F);
        this.f22661e.getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (this.f22662f != null) {
        }
        this.n.setColor(f22658b);
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
        f22659d = j.a(getApplicationContext(), this.f22660c);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.baidu.ufosdk.f.c.a("onGlobalLayout --> onGlobalLayout!!!");
        int i = this.r;
        if (i == 0) {
            try {
                this.r = i + 1;
                this.o = this.f22661e.getMeasuredWidth();
                this.p = this.f22661e.getMeasuredHeight();
                int width = this.f22662f.getWidth();
                int height = this.f22662f.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
                this.f22663g = Bitmap.createBitmap(this.f22662f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
                a();
                this.f22661e.setImageBitmap(this.f22663g);
                this.f22661e.setOnTouchListener(this);
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

    @Override // android.app.Activity
    public void onResume() {
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

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01bb, code lost:
        if (r19.u.c() < r19.u.e()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f1, code lost:
        if (r19.u.b() > r19.u.d()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01f3, code lost:
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
        float f2;
        float f3;
        Canvas canvas;
        float f4;
        float f5;
        Paint paint;
        float f6;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = motionEvent.getX();
            this.l = motionEvent.getY();
            this.i = motionEvent.getX();
            float y = motionEvent.getY();
            this.j = y;
            this.s.moveTo(this.i, y);
            this.f22664h = Bitmap.createBitmap(this.f22663g);
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
                    this.f22661e.invalidate();
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
                    int i = (x > f7 ? 1 : (x == f7 ? 0 : -1));
                    if (i > 0 && y2 > f8) {
                        a(this.m, this.n, f7, f8, x, y2);
                    }
                    if (i > 0 && y2 < f8) {
                        a(this.m, this.n, f7, y2, x, f8);
                    }
                    int i2 = (x > f7 ? 1 : (x == f7 ? 0 : -1));
                    if (i2 < 0 && y2 > f8) {
                        a(this.m, this.n, x, f8, f7, y2);
                    }
                    if (i2 < 0 && y2 < f8) {
                        a(this.m, this.n, x, y2, f7, f8);
                    }
                    if (i == 0 || y2 == f8) {
                        a(this.m, this.n, f7, f8, x, y2);
                    }
                }
                this.f22661e.invalidate();
            } else {
                this.s.reset();
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (this.m != null && this.n != null) {
                if (this.q) {
                    Bitmap createBitmap = Bitmap.createBitmap(this.f22664h);
                    this.f22663g = createBitmap;
                    this.f22661e.setImageBitmap(createBitmap);
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
                    this.i = f3;
                    this.j = f2;
                    this.f22661e.invalidate();
                } else {
                    Bitmap createBitmap2 = Bitmap.createBitmap(this.f22664h);
                    this.f22663g = createBitmap2;
                    this.f22661e.setImageBitmap(createBitmap2);
                    a();
                    this.s.lineTo(x2, y3);
                    this.m.drawPath(this.s, this.n);
                }
            }
            f2 = y3;
            f3 = x2;
            this.i = f3;
            this.j = f2;
            this.f22661e.invalidate();
        }
        return true;
    }
}
