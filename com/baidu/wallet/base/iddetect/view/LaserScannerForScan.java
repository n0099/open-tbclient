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
    public Bitmap f23428a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f23429b;

    /* renamed from: c  reason: collision with root package name */
    public int f23430c;

    /* renamed from: d  reason: collision with root package name */
    public float f23431d;

    /* renamed from: e  reason: collision with root package name */
    public float f23432e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f23433f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23434g;

    /* renamed from: h  reason: collision with root package name */
    public a f23435h;

    /* renamed from: i  reason: collision with root package name */
    public int f23436i;
    public int j;
    public IdCardActivity k;

    public LaserScannerForScan(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        try {
            a a2 = b.a(context, 1, false);
            this.f23435h = a2;
            if (a2 == null && (idCardActivity = this.k) != null) {
                idCardActivity.dialogPermission();
                return;
            }
            if (this.f23429b == null) {
                this.f23429b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
            }
            this.f23428a = ((BitmapDrawable) this.f23429b).getBitmap();
            this.f23433f = new Matrix();
            this.f23434g = true;
            this.f23430c = 0;
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
        return this.f23436i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23434g) {
            this.f23433f.reset();
            Matrix matrix = this.f23433f;
            float f2 = this.f23432e;
            matrix.setScale(f2, f2);
            this.f23433f.setTranslate(this.f23431d, this.f23430c + this.j);
            canvas.drawBitmap(this.f23428a, this.f23433f, null);
            int height = canvas.getHeight() - this.j;
            this.f23430c = (this.f23430c + (height / 100)) % height;
            postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        a aVar = this.f23435h;
        int i4 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f23415c);
        this.f23436i = i4;
        setMeasuredDimension(size, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f23432e = i2 / this.f23428a.getWidth();
        Bitmap bitmap = this.f23428a;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
        this.f23428a = createScaledBitmap;
        this.f23431d = 0.0f;
        this.j = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.k = idCardActivity;
    }

    public void startScan() {
        this.f23434g = true;
        postInvalidate();
    }

    public void stopScan() {
        this.f23434g = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23429b = null;
        this.f23436i = -1;
        this.j = -1;
        a(context, attributeSet, i2);
    }
}
