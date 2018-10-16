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
/* loaded from: classes3.dex */
public class ZXingView extends QRCodeView {
    private MultiFormatReader gBK;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bsK();
    }

    private void bsK() {
        this.gBK = new MultiFormatReader();
        this.gBK.setHints(a.gBJ);
    }

    @Override // com.baidu.tieba.qrcode.lib.core.c.a
    public String a(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect sU = this.gAE.sU(i2);
                if (sU != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, sU.left, sU.top, sU.width(), sU.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                }
                result = this.gBK.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e) {
                e.printStackTrace();
                this.gBK.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.gBK.reset();
        }
    }
}
