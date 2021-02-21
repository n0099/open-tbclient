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
    private MultiFormatReader mPR;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dCO();
    }

    private void dCO() {
        this.mPR = new MultiFormatReader();
        this.mPR.setHints(a.mPQ);
    }

    @Override // com.baidu.tieba.qrcode.lib.core.c.a
    public String c(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect HG = this.mOL.HG(i2);
                if (HG != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, HG.left, HG.top, HG.width(), HG.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                }
                result = this.mPR.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e) {
                e.printStackTrace();
                this.mPR.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.mPR.reset();
        }
    }
}
