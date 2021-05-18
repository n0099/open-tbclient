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
    public Bitmap f23314a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f23315b;

    /* renamed from: c  reason: collision with root package name */
    public int f23316c;

    /* renamed from: d  reason: collision with root package name */
    public float f23317d;

    /* renamed from: e  reason: collision with root package name */
    public float f23318e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f23319f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23320g;

    /* renamed from: h  reason: collision with root package name */
    public a f23321h;

    /* renamed from: i  reason: collision with root package name */
    public int f23322i;
    public int j;
    public IdCardActivity k;

    public LaserScannerForScan(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        try {
            a a2 = b.a(context, 1, false);
            this.f23321h = a2;
            if (a2 == null && (idCardActivity = this.k) != null) {
                idCardActivity.dialogPermission();
                return;
            }
            if (this.f23315b == null) {
                this.f23315b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
            }
            this.f23314a = ((BitmapDrawable) this.f23315b).getBitmap();
            this.f23319f = new Matrix();
            this.f23320g = true;
            this.f23316c = 0;
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
        return this.f23322i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23320g) {
            this.f23319f.reset();
            Matrix matrix = this.f23319f;
            float f2 = this.f23318e;
            matrix.setScale(f2, f2);
            this.f23319f.setTranslate(this.f23317d, this.f23316c + this.j);
            canvas.drawBitmap(this.f23314a, this.f23319f, null);
            int height = canvas.getHeight() - this.j;
            this.f23316c = (this.f23316c + (height / 100)) % height;
            postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        a aVar = this.f23321h;
        int i4 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f23301c);
        this.f23322i = i4;
        setMeasuredDimension(size, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f23318e = i2 / this.f23314a.getWidth();
        Bitmap bitmap = this.f23314a;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
        this.f23314a = createScaledBitmap;
        this.f23317d = 0.0f;
        this.j = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.k = idCardActivity;
    }

    public void startScan() {
        this.f23320g = true;
        postInvalidate();
    }

    public void stopScan() {
        this.f23320g = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23315b = null;
        this.f23322i = -1;
        this.j = -1;
        a(context, attributeSet, i2);
    }
}
