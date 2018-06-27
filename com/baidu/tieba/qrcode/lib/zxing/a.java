package com.baidu.tieba.qrcode.lib.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.ar.util.IoUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class a {
    public static final Map<DecodeHintType, Object> glD = new EnumMap(DecodeHintType.class);

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.PDF_417);
        glD.put(DecodeHintType.TRY_HARDER, BarcodeFormat.QR_CODE);
        glD.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        glD.put(DecodeHintType.CHARACTER_SET, IoUtils.UTF_8);
    }

    public static String sC(String str) {
        return v(sD(str));
    }

    public static String v(Bitmap bitmap) {
        RGBLuminanceSource rGBLuminanceSource;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            RGBLuminanceSource rGBLuminanceSource2 = new RGBLuminanceSource(width, height, iArr);
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource2)), glD).getText();
            } catch (Exception e) {
                e = e;
                rGBLuminanceSource = rGBLuminanceSource2;
                e.printStackTrace();
                if (rGBLuminanceSource != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), glD).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            rGBLuminanceSource = null;
        }
    }

    private static Bitmap sD(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outHeight / HttpStatus.SC_BAD_REQUEST;
            options.inSampleSize = i > 0 ? i : 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            return null;
        }
    }
}
