package com.baidu.tieba.qrcode.lib.zxing;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.baidu.tieba.qrcode.lib.core.QRCodeView;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
/* loaded from: classes8.dex */
public class ZXingView extends QRCodeView {
    private MultiFormatReader mLh;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dEo();
    }

    private void dEo() {
        this.mLh = new MultiFormatReader();
        this.mLh.setHints(a.mLg);
    }

    @Override // com.baidu.tieba.qrcode.lib.core.c.a
    public String c(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect IV = this.mKc.IV(i2);
                if (IV != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, IV.left, IV.top, IV.width(), IV.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                }
                result = this.mLh.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e) {
                e.printStackTrace();
                this.mLh.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.mLh.reset();
        }
    }
}
