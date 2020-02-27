package com.baidu.tieba.qrcode.lib.zxing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public static final Map<EncodeHintType, Object> jEf = new EnumMap(EncodeHintType.class);

    static {
        jEf.put(EncodeHintType.CHARACTER_SET, "utf-8");
        jEf.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        jEf.put(EncodeHintType.MARGIN, 0);
    }

    public static Bitmap bn(String str, int i) {
        return a(str, i, ViewCompat.MEASURED_STATE_MASK, -1, null);
    }

    public static Bitmap a(String str, int i, int i2, int i3, Bitmap bitmap) {
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i, i, jEf);
            int[] iArr = new int[i * i];
            for (int i4 = 0; i4 < i; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    if (encode.get(i5, i4)) {
                        iArr[(i4 * i) + i5] = i2;
                    } else {
                        iArr[(i4 * i) + i5] = i3;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return b(createBitmap, bitmap);
        } catch (Exception e) {
            return null;
        }
    }

    private static Bitmap b(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        float f = ((width * 1.0f) / 5.0f) / width2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f, f, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save(31);
            canvas.restore();
            return createBitmap;
        } catch (Exception e) {
            return null;
        }
    }
}
