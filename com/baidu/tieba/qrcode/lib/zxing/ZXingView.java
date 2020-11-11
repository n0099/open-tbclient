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
/* loaded from: classes23.dex */
public class ZXingView extends QRCodeView {
    private MultiFormatReader mrm;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dzH();
    }

    private void dzH() {
        this.mrm = new MultiFormatReader();
        this.mrm.setHints(a.mrl);
    }

    @Override // com.baidu.tieba.qrcode.lib.core.c.a
    public String b(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect HM = this.mqh.HM(i2);
                if (HM != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, HM.left, HM.top, HM.width(), HM.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                }
                result = this.mrm.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e) {
                e.printStackTrace();
                this.mrm.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.mrm.reset();
        }
    }
}
