package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes15.dex */
public class IrregularImageView extends AppCompatImageView {
    protected final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dYv;
    private int mqD;
    private int mqE;

    public IrregularImageView(Context context) {
        super(context);
        this.dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.view.IrregularImageView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                Bitmap bitmap;
                if (aVar == null) {
                    if (IrregularImageView.this.mqE != 0) {
                        try {
                            bitmap = BitmapFactory.decodeResource(IrregularImageView.this.getResources(), IrregularImageView.this.mqE);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            IrregularImageView.this.setImage(bitmap, IrregularImageView.this.mqD);
                            return;
                        }
                        return;
                    }
                    return;
                }
                IrregularImageView.this.setImage(aVar.getRawBitmap(), IrregularImageView.this.mqD);
            }
        };
    }

    public IrregularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.view.IrregularImageView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                Bitmap bitmap;
                if (aVar == null) {
                    if (IrregularImageView.this.mqE != 0) {
                        try {
                            bitmap = BitmapFactory.decodeResource(IrregularImageView.this.getResources(), IrregularImageView.this.mqE);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            IrregularImageView.this.setImage(bitmap, IrregularImageView.this.mqD);
                            return;
                        }
                        return;
                    }
                    return;
                }
                IrregularImageView.this.setImage(aVar.getRawBitmap(), IrregularImageView.this.mqD);
            }
        };
    }

    public IrregularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.view.IrregularImageView.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                Bitmap bitmap;
                if (aVar == null) {
                    if (IrregularImageView.this.mqE != 0) {
                        try {
                            bitmap = BitmapFactory.decodeResource(IrregularImageView.this.getResources(), IrregularImageView.this.mqE);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            IrregularImageView.this.setImage(bitmap, IrregularImageView.this.mqD);
                            return;
                        }
                        return;
                    }
                    return;
                }
                IrregularImageView.this.setImage(aVar.getRawBitmap(), IrregularImageView.this.mqD);
            }
        };
    }

    public void setImage(String str, BdUniqueId bdUniqueId, int i) {
        this.mqD = i;
        com.baidu.adp.lib.e.c.ln().a(str, 10, this.dYv, 0, 0, bdUniqueId, new Object[0]);
    }

    public void setImage(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        if (bitmap != null) {
            try {
                bitmap3 = BitmapFactory.decodeResource(getResources(), i);
                try {
                    bitmap2 = Bitmap.createBitmap(bitmap3.getWidth(), bitmap3.getHeight(), Bitmap.Config.ARGB_8888);
                    try {
                        bitmap4 = g(bitmap, bitmap3.getWidth(), bitmap3.getHeight());
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        bitmap4 = null;
                        if (bitmap3 == null) {
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bitmap2 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmap2 = null;
                bitmap3 = null;
            }
            if (bitmap3 == null && bitmap2 != null && bitmap4 != null) {
                Canvas canvas = new Canvas(bitmap2);
                Paint paint = new Paint(1);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawBitmap(bitmap4, 0.0f, 0.0f, (Paint) null);
                canvas.drawBitmap(bitmap3, 0.0f, 0.0f, paint);
                paint.setXfermode(null);
                setImageBitmap(bitmap2);
            }
        }
    }

    private Bitmap g(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || i == 0 || i2 == 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if ((i * 1.0f) / i2 > (width * 1.0f) / height) {
            float f2 = (i * 1.0f) / width;
            i5 = (int) ((i2 * 1.0f) / f2);
            i4 = (height - i5) / 2;
            f = f2;
            i3 = 0;
        } else {
            float f3 = (i2 * 1.0f) / height;
            int i6 = (int) ((i * 1.0f) / f3);
            i3 = (width - i6) / 2;
            width = i6;
            i4 = 0;
            f = f3;
            i5 = height;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, i3, i4, width, i5, matrix, false);
    }

    public void setErrorRes(int i) {
        this.mqE = i;
    }
}
