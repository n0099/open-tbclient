package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.adp.BdUniqueId;
import d.b.b.e.l.c;
import d.b.b.e.l.d;
/* loaded from: classes5.dex */
public class IrregularImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f22124e;

    /* renamed from: f  reason: collision with root package name */
    public int f22125f;

    /* renamed from: g  reason: collision with root package name */
    public final c<d.b.b.j.d.a> f22126g;

    /* loaded from: classes5.dex */
    public class a extends c<d.b.b.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            if (aVar == null) {
                if (IrregularImageView.this.f22125f != 0) {
                    Bitmap bitmap = null;
                    try {
                        bitmap = BitmapFactory.decodeResource(IrregularImageView.this.getResources(), IrregularImageView.this.f22125f);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (bitmap != null) {
                        IrregularImageView irregularImageView = IrregularImageView.this;
                        irregularImageView.setImage(bitmap, irregularImageView.f22124e);
                        return;
                    }
                    return;
                }
                return;
            }
            IrregularImageView.this.setImage(aVar.p(), IrregularImageView.this.f22124e);
        }
    }

    public IrregularImageView(Context context) {
        super(context);
        this.f22126g = new a();
    }

    public final Bitmap c(Bitmap bitmap, int i, int i2) {
        int i3;
        float f2;
        int i4;
        int i5;
        int i6;
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || i == 0 || i2 == 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f3 = i * 1.0f;
        float f4 = i2;
        float f5 = width;
        float f6 = height;
        if (f3 / f4 > (f5 * 1.0f) / f6) {
            f2 = f3 / f5;
            int i7 = (int) ((f4 * 1.0f) / f2);
            i4 = i7;
            i3 = width;
            i5 = (height - i7) / 2;
            i6 = 0;
        } else {
            float f7 = (f4 * 1.0f) / f6;
            int i8 = (int) (f3 / f7);
            i3 = i8;
            f2 = f7;
            i4 = height;
            i5 = 0;
            i6 = (width - i8) / 2;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
    }

    public void setErrorRes(int i) {
        this.f22125f = i;
    }

    public void setImage(String str, BdUniqueId bdUniqueId, int i) {
        this.f22124e = i;
        d.h().k(str, 10, this.f22126g, 0, 0, bdUniqueId, new Object[0]);
    }

    public IrregularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22126g = new a();
    }

    public void setImage(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        if (bitmap == null) {
            return;
        }
        try {
            bitmap2 = BitmapFactory.decodeResource(getResources(), i);
            try {
                bitmap3 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
                try {
                    bitmap4 = c(bitmap, bitmap2.getWidth(), bitmap2.getHeight());
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    bitmap4 = null;
                    if (bitmap2 != null) {
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmap3 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap2 = null;
            bitmap3 = null;
        }
        if (bitmap2 != null || bitmap3 == null || bitmap4 == null) {
            return;
        }
        Canvas canvas = new Canvas(bitmap3);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(bitmap4, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        setImageBitmap(bitmap3);
    }

    public IrregularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22126g = new a();
    }
}
