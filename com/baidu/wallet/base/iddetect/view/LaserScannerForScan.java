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
    public Bitmap f23656a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f23657b;

    /* renamed from: c  reason: collision with root package name */
    public int f23658c;

    /* renamed from: d  reason: collision with root package name */
    public float f23659d;

    /* renamed from: e  reason: collision with root package name */
    public float f23660e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f23661f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23662g;

    /* renamed from: h  reason: collision with root package name */
    public a f23663h;
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
            this.f23663h = a2;
            if (a2 == null && (idCardActivity = this.k) != null) {
                idCardActivity.dialogPermission();
                return;
            }
            if (this.f23657b == null) {
                this.f23657b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
            }
            this.f23656a = ((BitmapDrawable) this.f23657b).getBitmap();
            this.f23661f = new Matrix();
            this.f23662g = true;
            this.f23658c = 0;
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
        if (this.f23662g) {
            this.f23661f.reset();
            Matrix matrix = this.f23661f;
            float f2 = this.f23660e;
            matrix.setScale(f2, f2);
            this.f23661f.setTranslate(this.f23659d, this.f23658c + this.j);
            canvas.drawBitmap(this.f23656a, this.f23661f, null);
            int height = canvas.getHeight() - this.j;
            this.f23658c = (this.f23658c + (height / 100)) % height;
            postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        a aVar = this.f23663h;
        int i3 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f23643c);
        this.i = i3;
        setMeasuredDimension(size, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f23660e = i / this.f23656a.getWidth();
        Bitmap bitmap = this.f23656a;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, bitmap.getHeight(), true);
        this.f23656a = createScaledBitmap;
        this.f23659d = 0.0f;
        this.j = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.k = idCardActivity;
    }

    public void startScan() {
        this.f23662g = true;
        postInvalidate();
    }

    public void stopScan() {
        this.f23662g = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23657b = null;
        this.i = -1;
        this.j = -1;
        a(context, attributeSet, i);
    }
}
