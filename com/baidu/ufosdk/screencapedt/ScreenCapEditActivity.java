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
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.R;
import com.baidu.ufosdk.f.m;
import com.baidu.ufosdk.f.r;
import com.baidu.ufosdk.f.s;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes21.dex */
public class ScreenCapEditActivity extends Activity implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f3723a = b() + "/ufo/ufo_screen.jpeg";
    public static int b = SupportMenu.CATEGORY_MASK;
    public static int d = 0;
    private float A;
    private float B;
    private float C;
    private float D;
    private RelativeLayout F;
    private ImageView G;
    private ByteArrayOutputStream J;
    private ImageView O;
    private RelativeLayout P;
    private RelativeLayout Q;
    private Button R;
    private TextView S;
    private Button T;
    private TextView U;
    private TextView V;
    private ImageView e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Canvas m;
    private int o;
    private int p;
    private a u;
    private Bitmap v;
    private Bitmap w;
    private Bitmap x;
    private Bitmap y;
    private Bitmap z;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private Paint n = new Paint();
    private boolean q = true;
    private int r = 0;
    private Path s = new Path();
    public int c = 2;
    private HashMap t = null;
    private boolean E = false;
    private boolean H = false;
    private boolean I = false;
    private boolean K = false;
    private boolean L = false;
    private int M = -1;
    private Handler N = new i(this);

    private void a() {
        this.m = new Canvas(this.g);
        this.n.setColor(b);
        this.n.setStyle(Paint.Style.STROKE);
        if (this.n.getStrokeWidth() < d) {
            this.n.setStrokeWidth(d);
        }
    }

    private void a(float f, float f2, float f3, float f4) {
        this.n.setStrokeWidth(j.a(getApplicationContext(), 1.0f));
        this.n.setStyle(Paint.Style.FILL);
        this.n.setColor(-1);
        this.m.drawCircle(f, f2, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle(f, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f, f4, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle((f + f3) / 2.0f, f2, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle((f + f3) / 2.0f, f4, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f3, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f3, f4, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle(f3, f2, j.a(getApplicationContext(), 7.0f), this.n);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setColor(SupportMenu.CATEGORY_MASK);
        this.m.drawCircle(f, f2, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle(f, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f, f4, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle((f + f3) / 2.0f, f2, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle((f + f3) / 2.0f, f4, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f3, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), this.n);
        this.m.drawCircle(f3, f4, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawCircle(f3, f2, j.a(getApplicationContext(), 7.0f), this.n);
        this.m.drawLine(f3, f2, f3 - j.a(getApplicationContext(), 3.0f), f2 + j.a(getApplicationContext(), 3.0f), this.n);
        this.m.drawLine(f3, f2, f3 + j.a(getApplicationContext(), 3.0f), f2 - j.a(getApplicationContext(), 3.0f), this.n);
        this.m.drawLine(f3, f2, f3 - j.a(getApplicationContext(), 3.0f), f2 - j.a(getApplicationContext(), 3.0f), this.n);
        this.m.drawLine(f3, f2, f3 + j.a(getApplicationContext(), 3.0f), f2 + j.a(getApplicationContext(), 3.0f), this.n);
    }

    private void a(int i, float f, float f2, float f3, float f4) {
        switch (i) {
            case -1:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_NONE");
                return;
            case 0:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_MOVE");
                float f5 = f3 - f;
                float f6 = f4 - f2;
                this.u.a(this.A + f5);
                this.u.b(this.B + f6);
                this.u.c(f5 + this.C);
                this.u.d(f6 + this.D);
                a(false);
                for (Map.Entry entry : this.t.entrySet()) {
                    System.out.println("key= " + ((String) entry.getKey()) + " and value= " + entry.getValue());
                    this.m.drawRect(((a) entry.getValue()).b(), ((a) entry.getValue()).c(), ((a) entry.getValue()).d(), ((a) entry.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.x, (this.u.b() + this.u.d()) / 2.0f, (this.u.c() + this.u.e()) / 2.0f);
                return;
            case 1:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT");
                this.u.a((f3 - f) + this.A);
                a(false);
                for (Map.Entry entry2 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry2.getKey()) + " and value= " + entry2.getValue());
                    this.m.drawRect(((a) entry2.getValue()).b(), ((a) entry2.getValue()).c(), ((a) entry2.getValue()).d(), ((a) entry2.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.v, this.u.b(), (this.u.c() + this.u.e()) / 2.0f);
                return;
            case 2:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT");
                this.u.c((f3 - f) + this.C);
                a(false);
                for (Map.Entry entry3 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry3.getKey()) + " and value= " + entry3.getValue());
                    this.m.drawRect(((a) entry3.getValue()).b(), ((a) entry3.getValue()).c(), ((a) entry3.getValue()).d(), ((a) entry3.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.v, this.u.d(), (this.u.c() + this.u.e()) / 2.0f);
                return;
            case 3:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_TOP");
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_DOWN");
                this.u.b((f4 - f2) + this.B);
                a(false);
                for (Map.Entry entry4 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry4.getKey()) + " and value= " + entry4.getValue());
                    this.m.drawRect(((a) entry4.getValue()).b(), ((a) entry4.getValue()).c(), ((a) entry4.getValue()).d(), ((a) entry4.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.z, (this.u.b() + this.u.d()) / 2.0f, this.u.c());
                return;
            case 4:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_DOWN");
                this.u.d((f4 - f2) + this.D);
                a(false);
                for (Map.Entry entry5 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry5.getKey()) + " and value= " + entry5.getValue());
                    this.m.drawRect(((a) entry5.getValue()).b(), ((a) entry5.getValue()).c(), ((a) entry5.getValue()).d(), ((a) entry5.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.z, (this.u.b() + this.u.d()) / 2.0f, this.u.e());
                return;
            case 13:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT_TOP");
                this.u.a((f3 - f) + this.A);
                this.u.b((f4 - f2) + this.B);
                a(false);
                for (Map.Entry entry6 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry6.getKey()) + " and value= " + entry6.getValue());
                    this.m.drawRect(((a) entry6.getValue()).b(), ((a) entry6.getValue()).c(), ((a) entry6.getValue()).d(), ((a) entry6.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.w, this.u.b(), this.u.c());
                return;
            case 14:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_LEFT_DOWN");
                this.u.a((f3 - f) + this.A);
                this.u.d((f4 - f2) + this.D);
                a(false);
                for (Map.Entry entry7 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry7.getKey()) + " and value= " + entry7.getValue());
                    this.m.drawRect(((a) entry7.getValue()).b(), ((a) entry7.getValue()).c(), ((a) entry7.getValue()).d(), ((a) entry7.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.y, this.u.b(), this.u.e());
                return;
            case 23:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT_TOP");
                return;
            case 24:
                com.baidu.ufosdk.f.c.b("^v^ --> state : RectBean.OPERATION_RIGHT_DOWN");
                this.u.c((f3 - f) + this.C);
                this.u.d((f4 - f2) + this.D);
                a(false);
                for (Map.Entry entry8 : this.t.entrySet()) {
                    com.baidu.ufosdk.f.c.a("key= " + ((String) entry8.getKey()) + " and value= " + entry8.getValue());
                    this.m.drawRect(((a) entry8.getValue()).b(), ((a) entry8.getValue()).c(), ((a) entry8.getValue()).d(), ((a) entry8.getValue()).e(), this.n);
                }
                a(this.u.b(), this.u.c(), this.u.d(), this.u.e());
                a(this.w, this.u.d(), this.u.e());
                return;
            default:
                com.baidu.ufosdk.f.c.b("^v^ --> state default!");
                return;
        }
    }

    private void a(Bitmap bitmap, float f, float f2) {
        this.m.drawBitmap(bitmap, f - (bitmap.getWidth() / 2), f2 - (bitmap.getHeight() / 2), this.n);
    }

    private void a(Canvas canvas, Paint paint, float f, float f2, float f3, float f4) {
        paint.setStrokeWidth(j.a(getApplicationContext(), 1.0f));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        canvas.drawCircle(f, f2, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle(f, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f, f4, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle((f + f3) / 2.0f, f2, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle((f + f3) / 2.0f, f4, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f3, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f3, f4, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle(f3, f2, j.a(getApplicationContext(), 7.0f), paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle(f, f2, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle(f, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f, f4, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle((f + f3) / 2.0f, f2, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle((f + f3) / 2.0f, f4, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f3, (f2 + f4) / 2.0f, j.a(getApplicationContext(), 5.0f), paint);
        canvas.drawCircle(f3, f4, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawCircle(f3, f2, j.a(getApplicationContext(), 7.0f), paint);
        canvas.drawLine(f3, f2, f3 - j.a(getApplicationContext(), 3.0f), f2 + j.a(getApplicationContext(), 3.0f), paint);
        canvas.drawLine(f3, f2, f3 + j.a(getApplicationContext(), 3.0f), f2 - j.a(getApplicationContext(), 3.0f), paint);
        canvas.drawLine(f3, f2, f3 - j.a(getApplicationContext(), 3.0f), f2 - j.a(getApplicationContext(), 3.0f), paint);
        canvas.drawLine(f3, f2, f3 + j.a(getApplicationContext(), 3.0f), f2 + j.a(getApplicationContext(), 3.0f), paint);
        String str = System.currentTimeMillis() + UUID.randomUUID().toString();
        a aVar = new a(f, f2, f3, f4, str);
        this.t.put(str, aVar);
        this.u = aVar;
        a(aVar);
        this.H = false;
        if (this.H) {
            this.Q.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            return;
        }
        RelativeLayout relativeLayout = this.Q;
        getApplicationContext();
        relativeLayout.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ScreenCapEditActivity screenCapEditActivity, int i) {
        int i2 = 90;
        screenCapEditActivity.J = new ByteArrayOutputStream();
        if (screenCapEditActivity.g != null) {
            screenCapEditActivity.g.compress(Bitmap.CompressFormat.JPEG, 90, screenCapEditActivity.J);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d(screenCapEditActivity.J.toByteArray().length));
        int length = screenCapEditActivity.J.toByteArray().length;
        while (length > 300000 && i2 >= 0) {
            i2 -= 10;
            com.baidu.ufosdk.f.c.c("quality is " + i2);
            screenCapEditActivity.J = new ByteArrayOutputStream();
            screenCapEditActivity.g.compress(Bitmap.CompressFormat.JPEG, i2, screenCapEditActivity.J);
            length = screenCapEditActivity.J.toByteArray().length;
            com.baidu.ufosdk.f.c.c("streamLength is " + length);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d(screenCapEditActivity.J.toByteArray().length));
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
            int width = this.f.getWidth();
            int height = this.f.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
            this.g = Bitmap.createBitmap(this.f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
            this.e.setImageBitmap(this.g);
            a();
            this.e.invalidate();
            if (z) {
                this.t.clear();
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("clearCanvas error!", e);
            Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
            finish();
        } catch (OutOfMemoryError e2) {
            com.baidu.ufosdk.f.c.d("clearCanvas " + e2.getMessage());
            Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
            finish();
        }
    }

    private static String b() {
        File externalStorageDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null;
        if (externalStorageDirectory == null) {
            return null;
        }
        return externalStorageDirectory.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(ScreenCapEditActivity screenCapEditActivity) {
        int i = 90;
        screenCapEditActivity.J = new ByteArrayOutputStream();
        if (screenCapEditActivity.g != null) {
            screenCapEditActivity.g.compress(Bitmap.CompressFormat.JPEG, 90, screenCapEditActivity.J);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d(screenCapEditActivity.J.toByteArray().length));
        int length = screenCapEditActivity.J.toByteArray().length;
        while (length > 300000 && i >= 0) {
            i -= 10;
            com.baidu.ufosdk.f.c.c("quality is " + i);
            screenCapEditActivity.J = new ByteArrayOutputStream();
            screenCapEditActivity.g.compress(Bitmap.CompressFormat.JPEG, i, screenCapEditActivity.J);
            length = screenCapEditActivity.J.toByteArray().length;
            com.baidu.ufosdk.f.c.c("streamLength is " + length);
        }
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + screenCapEditActivity.J.toByteArray().length);
        com.baidu.ufosdk.f.c.c("stream.toByteArray() length is " + com.baidu.ufosdk.f.i.d(screenCapEditActivity.J.toByteArray().length));
        Intent intent = new Intent();
        intent.putExtra("shot", screenCapEditActivity.J.toByteArray());
        screenCapEditActivity.setResult(-1, intent);
        screenCapEditActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(ScreenCapEditActivity screenCapEditActivity) {
        String str = b() + "/ufo";
        try {
            File file = new File(str);
            f3723a = str + "/ufo_" + System.currentTimeMillis() + ".jpeg";
            com.baidu.ufosdk.f.c.b("--savePic--" + f3723a);
            File file2 = new File(f3723a);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            screenCapEditActivity.g.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(screenCapEditActivity, s.a("56"), 0).show();
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        FrameLayout.LayoutParams layoutParams;
        super.onCreate(bundle);
        requestWindowFeature(1);
        r.a(this, getWindow());
        r.a(getWindow(), com.baidu.ufosdk.b.L);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
        String stringExtra = getIntent().getStringExtra("shotUrl");
        this.K = getIntent().getBooleanExtra(UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT, false);
        this.L = getIntent().getBooleanExtra("from_app", false);
        this.M = getIntent().getIntExtra("extend_feedback_channel", -1);
        if (byteArrayExtra != null && byteArrayExtra.length > 0) {
            this.f = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            this.I = true;
            com.baidu.ufosdk.f.c.c("ScreenCapEditActivity --> bitmap via shot byte[] & bitmap size is " + (byteArrayExtra.length / 1024) + "kb");
        } else if (stringExtra != null && stringExtra.length() != 0) {
            this.f = BitmapFactory.decodeFile(stringExtra);
            this.I = true;
            com.baidu.ufosdk.f.c.c("ScreenCapEditActivity --> bitmap via shotUrl");
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
        } else if (!new File(b() + "/ufo/ufo_screen.jpeg").exists()) {
            com.baidu.ufosdk.f.c.d("getSDCardPath() != null & file not exists -> bitmap == null");
            Intent intent2 = new Intent();
            intent2.setClass(this, FeedbackEditActivity.class);
            intent2.putExtra("fromlist", "no");
            intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent2.putExtra("come_from", 2);
            startActivity(intent2);
            finish();
            return;
        } else {
            try {
                this.f = BitmapFactory.decodeFile(b() + "/ufo/ufo_screen.jpeg").copy(Bitmap.Config.RGB_565, true);
            } catch (OutOfMemoryError e) {
                com.baidu.ufosdk.f.c.d("clearCanvas " + e.getMessage());
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            }
            this.I = false;
            com.baidu.ufosdk.f.c.c("ScreenCapEditActivity --> bitmap via screenshot");
        }
        if (this.f == null) {
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
        int width = this.f.getWidth();
        int height = this.f.getHeight();
        com.baidu.ufosdk.f.c.b("图片尺寸 --> width = " + width + "; height = " + height);
        int i = width > height ? 3 : width * 4 > height * 3 ? 1 : width * 2 > height ? 0 : 2;
        this.F = new RelativeLayout(this);
        this.F.setFitsSystemWindows(true);
        this.F.setId(R.string.abc_action_bar_up_description);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.string.abc_action_menu_overflow_description);
        this.F.setBackgroundColor(-15066598);
        this.R = new Button(this);
        this.R.setText(s.a("36"));
        this.R.setTextSize(com.baidu.ufosdk.b.M);
        this.R.setTextColor(-1);
        this.R.setGravity(17);
        this.R.setTextColor(-1);
        this.R.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        Button button = this.R;
        getApplicationContext();
        button.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.R, layoutParams2);
        this.S = new TextView(this);
        this.S.setId(R.string.abc_activity_chooser_view_see_all);
        this.S.setText(s.a("50"));
        this.S.setTextColor(-1);
        this.S.setTextSize(com.baidu.ufosdk.b.T);
        this.S.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(13);
        relativeLayout.addView(this.S, layoutParams3);
        this.T = new Button(this);
        this.T.setText(s.a("51"));
        this.T.setId(R.string.abc_activitychooserview_choose_application);
        this.T.setTextColor(com.baidu.ufosdk.b.v);
        this.T.setTextSize(com.baidu.ufosdk.b.U);
        this.T.setGravity(17);
        this.T.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        Button button2 = this.T;
        getApplicationContext();
        button2.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        relativeLayout.addView(this.T, layoutParams4);
        relativeLayout.setBackgroundColor(-15066598);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 70.0f));
        layoutParams5.addRule(10);
        this.F.addView(relativeLayout, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(R.string.abc_capital_off);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-15066598);
        this.Q = new RelativeLayout(this);
        this.Q.setId(R.string.abc_searchview_description_clear);
        RelativeLayout relativeLayout2 = this.Q;
        getApplicationContext();
        relativeLayout2.setBackgroundDrawable(m.a(-15395563));
        this.G = new ImageView(this);
        this.G.setId(R.string.abc_toolbar_collapse_description);
        this.G.setBackgroundDrawable(new BitmapDrawable(m.a(getApplicationContext(), "rect_normal.png")));
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
        layoutParams6.addRule(14);
        layoutParams6.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.Q.addView(this.G, layoutParams6);
        this.U = new TextView(this);
        this.U.setId(R.string.search_menu_title);
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
        this.P = new RelativeLayout(this);
        this.P.setClickable(false);
        this.P.setId(R.string.status_bar_notification_info_overflow);
        RelativeLayout relativeLayout3 = this.P;
        getApplicationContext();
        relativeLayout3.setBackgroundDrawable(m.a((int) ViewCompat.MEASURED_STATE_MASK));
        this.P.setClickable(true);
        this.O = new ImageView(this);
        this.O.setId(R.string.sapi_sdk_common_retry_btn_text);
        this.O.setBackgroundDrawable(new BitmapDrawable(m.a(this, "delete_all_disable.png")));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f));
        layoutParams8.addRule(14);
        layoutParams8.setMargins(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.P.addView(this.O, layoutParams8);
        this.V = new TextView(this);
        this.V.setId(R.string.sapi_sdk_common_loading_timeout);
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
        frameLayout.setId(R.string.abc_search_hint);
        this.e = new ImageView(this);
        this.e.setId(R.string.abc_capital_on);
        this.e.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.baidu.ufosdk.f.c.a("^^ imgvStyle = " + i);
        switch (i) {
            case 0:
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                break;
            case 1:
            case 2:
            default:
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
                break;
            case 3:
                Pair a2 = j.a(this);
                float f = -2.0f;
                if (a2 != null) {
                    int intValue = ((Integer) a2.first).intValue() - com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f);
                    com.baidu.ufosdk.f.c.a("Measure ImageView width: " + intValue);
                    f = (intValue / this.f.getWidth()) * this.f.getHeight();
                    com.baidu.ufosdk.f.c.a("Measure ImageView height: " + f);
                }
                layoutParams = new FrameLayout.LayoutParams(-1, Math.round(f));
                break;
        }
        layoutParams.gravity = 17;
        frameLayout.addView(this.e, layoutParams);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-1, -1);
        if (i == 3) {
            layoutParams12.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
        } else {
            layoutParams12.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f));
        }
        layoutParams12.addRule(3, relativeLayout.getId());
        layoutParams12.addRule(2, linearLayout.getId());
        this.F.addView(frameLayout, layoutParams12);
        this.T.setOnClickListener(new d(this));
        this.R.setOnClickListener(new e(this));
        this.P.setOnClickListener(new f(this));
        this.O.setOnClickListener(new g(this));
        setContentView(this.F);
        this.e.getViewTreeObserver().addOnGlobalLayoutListener(this);
        if (this.f != null) {
            this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.e.setImageBitmap(this.f);
        }
        this.n.setColor(b);
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
        d = j.a(getApplicationContext(), this.c);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        com.baidu.ufosdk.f.c.a("onGlobalLayout --> onGlobalLayout!!!");
        if (this.r == 0) {
            try {
                this.r++;
                this.o = this.e.getMeasuredWidth();
                this.p = this.e.getMeasuredHeight();
                int width = this.f.getWidth();
                int height = this.f.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale((float) ((this.o * 1.0d) / width), (float) ((this.p * 1.0d) / height));
                this.g = Bitmap.createBitmap(this.f, 0, 0, width, height, matrix, true).copy(Bitmap.Config.RGB_565, true);
                a();
                this.e.setImageBitmap(this.g);
                this.e.setOnTouchListener(this);
                com.baidu.ufosdk.f.c.a("onGlobalLayout --> onGlobalLayout!!!--in");
            } catch (Exception e) {
                com.baidu.ufosdk.f.c.a("onGlobalLayout error!", e);
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            } catch (OutOfMemoryError e2) {
                com.baidu.ufosdk.f.c.d("onGlobalLayout " + e2.getMessage());
                Toast.makeText(getApplicationContext(), s.a(BaseUtils.METHOD_SENDMESSAGE), 0).show();
                finish();
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        this.R.setText(s.a("36"));
        this.S.setText(s.a("50"));
        this.T.setText(s.a("51"));
        this.U.setText(s.a("52"));
        this.V.setText(s.a("53"));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.k = motionEvent.getX();
                this.l = motionEvent.getY();
                this.i = motionEvent.getX();
                this.j = motionEvent.getY();
                this.s.moveTo(this.i, this.j);
                this.h = Bitmap.createBitmap(this.g);
                if (this.t.size() > 0 && this.u.f()) {
                    this.u.a(this.u.a(this.k, this.l, j.a(getApplicationContext(), 7.0f), j.a(getApplicationContext(), 7.0f)));
                    com.baidu.ufosdk.f.c.b("^#^ --> OperationTag: " + this.u.g());
                    if (this.u.g() == 23) {
                        a(false);
                        this.t.remove(this.u.a());
                        for (Map.Entry entry : this.t.entrySet()) {
                            com.baidu.ufosdk.f.c.a("key= " + ((String) entry.getKey()) + " and value= " + entry.getValue());
                            this.m.drawRect(((a) entry.getValue()).b(), ((a) entry.getValue()).c(), ((a) entry.getValue()).d(), ((a) entry.getValue()).e(), this.n);
                        }
                        return true;
                    }
                }
                break;
            case 1:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (this.q) {
                    this.N.obtainMessage(0).sendToTarget();
                    if (this.t.size() > 0) {
                        switch (this.u.g()) {
                            case 1:
                            case 2:
                                if (this.u.b() > this.u.d()) {
                                    float b2 = this.u.b();
                                    this.u.a(this.u.d());
                                    this.u.c(b2);
                                    break;
                                }
                                break;
                            case 3:
                            case 4:
                                if (this.u.c() > this.u.e()) {
                                    float c = this.u.c();
                                    this.u.b(this.u.e());
                                    this.u.d(c);
                                    break;
                                }
                                break;
                            case 13:
                            case 14:
                            case 24:
                                if (this.u.b() > this.u.d() && this.u.c() > this.u.e()) {
                                    float d2 = this.u.d();
                                    float e = this.u.e();
                                    this.u.c(this.u.b());
                                    this.u.d(this.u.c());
                                    this.u.a(d2);
                                    this.u.b(e);
                                }
                                if (this.u.b() < this.u.d() && this.u.c() > this.u.e()) {
                                    float c2 = this.u.c();
                                    this.u.b(this.u.e());
                                    this.u.d(c2);
                                }
                                if (this.u.b() > this.u.d() && this.u.c() < this.u.e()) {
                                    float b3 = this.u.b();
                                    this.u.a(this.u.d());
                                    this.u.c(b3);
                                    break;
                                }
                                break;
                        }
                        com.baidu.ufosdk.f.c.b("###selectedRect.getOperateTag(): " + this.u.g());
                    }
                    a(false);
                    for (Map.Entry entry2 : this.t.entrySet()) {
                        com.baidu.ufosdk.f.c.a("key= " + ((String) entry2.getKey()) + " and value= " + entry2.getValue());
                        this.m.drawRect(((a) entry2.getValue()).b(), ((a) entry2.getValue()).c(), ((a) entry2.getValue()).d(), ((a) entry2.getValue()).e(), this.n);
                        ((a) entry2.getValue()).a(false);
                        ((a) entry2.getValue()).a(-1);
                    }
                    if (Math.abs(x - this.k) > 20.0f || Math.abs(y - this.l) > 20.0f) {
                        if (this.E) {
                            this.m.drawRect(this.k, this.l, x, y, this.n);
                            float f = this.k;
                            float f2 = this.l;
                            if (x > f && y > f2) {
                                a(this.m, this.n, f, f2, x, y);
                            }
                            if (x > f && y < f2) {
                                a(this.m, this.n, f, y, x, f2);
                            }
                            if (x < f && y > f2) {
                                a(this.m, this.n, x, f2, f, y);
                            }
                            if (x < f && y < f2) {
                                a(this.m, this.n, x, y, f, f2);
                            }
                            if (x == f || y == f2) {
                                a(this.m, this.n, f, f2, x, y);
                            }
                        }
                        this.e.invalidate();
                        break;
                    } else {
                        Iterator it = this.t.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry3 = (Map.Entry) it.next();
                                com.baidu.ufosdk.f.c.a("key= " + ((String) entry3.getKey()) + " and value= " + entry3.getValue());
                                if (((a) entry3.getValue()).a(x, j.a(getApplicationContext(), 7.0f), y, j.a(getApplicationContext(), 7.0f))) {
                                    ((a) entry3.getValue()).a(true);
                                    ((a) entry3.getValue()).a(0);
                                    a(((a) entry3.getValue()).b(), ((a) entry3.getValue()).c(), ((a) entry3.getValue()).d(), ((a) entry3.getValue()).e());
                                    this.u = (a) entry3.getValue();
                                    a((a) entry3.getValue());
                                }
                            }
                        }
                        this.e.invalidate();
                        break;
                    }
                } else {
                    this.s.reset();
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (this.m != null && this.n != null) {
                    if (this.q) {
                        this.g = Bitmap.createBitmap(this.h);
                        this.e.setImageBitmap(this.g);
                        a();
                        if (this.t.size() > 0) {
                            a(this.u.g(), this.k, this.l, x2, y2);
                        }
                        if (this.H && (Math.abs(x2 - this.k) > 20.0f || Math.abs(y2 - this.l) > 20.0f)) {
                            if (this.t.size() <= 0) {
                                this.E = true;
                                this.m.drawRect(this.k, this.l, x2, y2, this.n);
                            } else if (this.u.f() && this.u.g() != -1) {
                                this.E = false;
                                return false;
                            } else {
                                this.E = true;
                                this.m.drawRect(this.k, this.l, x2, y2, this.n);
                            }
                        }
                        if (!this.H) {
                            this.E = false;
                        }
                    } else {
                        this.g = Bitmap.createBitmap(this.h);
                        this.e.setImageBitmap(this.g);
                        a();
                        this.s.lineTo(x2, y2);
                        this.m.drawPath(this.s, this.n);
                    }
                }
                this.i = x2;
                this.j = y2;
                this.e.invalidate();
                break;
        }
        return true;
    }
}
