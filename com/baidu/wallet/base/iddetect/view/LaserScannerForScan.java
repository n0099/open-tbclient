package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.base.iddetect.a;
import com.baidu.wallet.base.iddetect.utils.b;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class LaserScannerForScan extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f23655a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f23656b;

    /* renamed from: c  reason: collision with root package name */
    public int f23657c;

    /* renamed from: d  reason: collision with root package name */
    public float f23658d;

    /* renamed from: e  reason: collision with root package name */
    public float f23659e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f23660f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23661g;

    /* renamed from: h  reason: collision with root package name */
    public a f23662h;
    public int i;
    public int j;
    public IdCardActivity k;

    public LaserScannerForScan(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        IdCardActivity idCardActivity;
        try {
            a a2 = b.a(context, 1, false);
            this.f23662h = a2;
            if (a2 == null && (idCardActivity = this.k) != null) {
                idCardActivity.dialogPermission();
                return;
            }
            if (this.f23656b == null) {
                this.f23656b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
            }
            this.f23655a = ((BitmapDrawable) this.f23656b).getBitmap();
            this.f23660f = new Matrix();
            this.f23661g = true;
            this.f23657c = 0;
        } catch (Exception e2) {
            String simpleName = LaserScannerForScan.class.getSimpleName();
            LogUtil.errord(simpleName, "init failed exception = " + e2.getMessage());
            throw e2;
        }
    }

    public IdCardActivity getAttachedActivity() {
        return this.k;
    }

    public int getBankHeight() {
        return this.i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23661g) {
            this.f23660f.reset();
            Matrix matrix = this.f23660f;
            float f2 = this.f23659e;
            matrix.setScale(f2, f2);
            this.f23660f.setTranslate(this.f23658d, this.f23657c + this.j);
            canvas.drawBitmap(this.f23655a, this.f23660f, null);
            int height = canvas.getHeight() - this.j;
            this.f23657c = (this.f23657c + (height / 100)) % height;
            postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        a aVar = this.f23662h;
        int i3 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f23642c);
        this.i = i3;
        setMeasuredDimension(size, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f23659e = i / this.f23655a.getWidth();
        Bitmap bitmap = this.f23655a;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, bitmap.getHeight(), true);
        this.f23655a = createScaledBitmap;
        this.f23658d = 0.0f;
        this.j = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.k = idCardActivity;
    }

    public void startScan() {
        this.f23661g = true;
        postInvalidate();
    }

    public void stopScan() {
        this.f23661g = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23656b = null;
        this.i = -1;
        this.j = -1;
        a(context, attributeSet, i);
    }
}
