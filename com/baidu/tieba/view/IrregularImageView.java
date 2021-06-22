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
import d.a.c.e.l.c;
import d.a.c.e.l.d;
/* loaded from: classes5.dex */
public class IrregularImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f21832e;

    /* renamed from: f  reason: collision with root package name */
    public int f21833f;

    /* renamed from: g  reason: collision with root package name */
    public final c<d.a.c.k.d.a> f21834g;

    /* loaded from: classes5.dex */
    public class a extends c<d.a.c.k.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            if (aVar == null) {
                if (IrregularImageView.this.f21833f != 0) {
                    Bitmap bitmap = null;
                    try {
                        bitmap = BitmapFactory.decodeResource(IrregularImageView.this.getResources(), IrregularImageView.this.f21833f);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (bitmap != null) {
                        IrregularImageView irregularImageView = IrregularImageView.this;
                        irregularImageView.setImage(bitmap, irregularImageView.f21832e);
                        return;
                    }
                    return;
                }
                return;
            }
            IrregularImageView.this.setImage(aVar.p(), IrregularImageView.this.f21832e);
        }
    }

    public IrregularImageView(Context context) {
        super(context);
        this.f21834g = new a();
    }

    public final Bitmap g(Bitmap bitmap, int i2, int i3) {
        int i4;
        float f2;
        int i5;
        int i6;
        int i7;
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || i2 == 0 || i3 == 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f3 = i2 * 1.0f;
        float f4 = i3;
        float f5 = width;
        float f6 = height;
        if (f3 / f4 > (f5 * 1.0f) / f6) {
            f2 = f3 / f5;
            int i8 = (int) ((f4 * 1.0f) / f2);
            i5 = i8;
            i4 = width;
            i6 = (height - i8) / 2;
            i7 = 0;
        } else {
            float f7 = (f4 * 1.0f) / f6;
            int i9 = (int) (f3 / f7);
            i4 = i9;
            f2 = f7;
            i5 = height;
            i6 = 0;
            i7 = (width - i9) / 2;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, i7, i6, i4, i5, matrix, false);
    }

    public void setErrorRes(int i2) {
        this.f21833f = i2;
    }

    public void setImage(String str, BdUniqueId bdUniqueId, int i2) {
        this.f21832e = i2;
        d.h().k(str, 10, this.f21834g, 0, 0, bdUniqueId, new Object[0]);
    }

    public IrregularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21834g = new a();
    }

    public void setImage(Bitmap bitmap, int i2) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        if (bitmap == null) {
            return;
        }
        try {
            bitmap2 = BitmapFactory.decodeResource(getResources(), i2);
            try {
                bitmap3 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
                try {
                    bitmap4 = g(bitmap, bitmap2.getWidth(), bitmap2.getHeight());
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

    public IrregularImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21834g = new a();
    }
}
