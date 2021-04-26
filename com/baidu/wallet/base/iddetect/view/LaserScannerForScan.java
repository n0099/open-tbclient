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
    public Bitmap f24069a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f24070b;

    /* renamed from: c  reason: collision with root package name */
    public int f24071c;

    /* renamed from: d  reason: collision with root package name */
    public float f24072d;

    /* renamed from: e  reason: collision with root package name */
    public float f24073e;

    /* renamed from: f  reason: collision with root package name */
    public Matrix f24074f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24075g;

    /* renamed from: h  reason: collision with root package name */
    public a f24076h;

    /* renamed from: i  reason: collision with root package name */
    public int f24077i;
    public int j;
    public IdCardActivity k;

    public LaserScannerForScan(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        IdCardActivity idCardActivity;
        try {
            a a2 = b.a(context, 1, false);
            this.f24076h = a2;
            if (a2 == null && (idCardActivity = this.k) != null) {
                idCardActivity.dialogPermission();
                return;
            }
            if (this.f24070b == null) {
                this.f24070b = getResources().getDrawable(ResUtils.drawable(context, "wallet_base_id_detect_scan_line"));
            }
            this.f24069a = ((BitmapDrawable) this.f24070b).getBitmap();
            this.f24074f = new Matrix();
            this.f24075g = true;
            this.f24071c = 0;
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
        return this.f24077i;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f24075g) {
            this.f24074f.reset();
            Matrix matrix = this.f24074f;
            float f2 = this.f24073e;
            matrix.setScale(f2, f2);
            this.f24074f.setTranslate(this.f24072d, this.f24071c + this.j);
            canvas.drawBitmap(this.f24069a, this.f24074f, null);
            int height = canvas.getHeight() - this.j;
            this.f24071c = (this.f24071c + (height / 100)) % height;
            postInvalidateDelayed(10L, 0, 0, canvas.getWidth(), canvas.getHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        a aVar = this.f24076h;
        int i4 = aVar == null ? (int) (size * 1.0f * 0.6306f) : (int) (size * 1.0f * aVar.f24056c);
        this.f24077i = i4;
        setMeasuredDimension(size, i4);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f24073e = i2 / this.f24069a.getWidth();
        Bitmap bitmap = this.f24069a;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, bitmap.getHeight(), true);
        this.f24069a = createScaledBitmap;
        this.f24072d = 0.0f;
        this.j = -createScaledBitmap.getHeight();
    }

    public void setAttachedActivity(IdCardActivity idCardActivity) {
        this.k = idCardActivity;
    }

    public void startScan() {
        this.f24075g = true;
        postInvalidate();
    }

    public void stopScan() {
        this.f24075g = false;
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LaserScannerForScan(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24070b = null;
        this.f24077i = -1;
        this.j = -1;
        a(context, attributeSet, i2);
    }
}
