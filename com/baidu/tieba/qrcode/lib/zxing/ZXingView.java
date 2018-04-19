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
    private MultiFormatReader fVm;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        biH();
    }

    private void biH() {
        this.fVm = new MultiFormatReader();
        this.fVm.setHints(a.fVl);
    }

    @Override // com.baidu.tieba.qrcode.lib.core.c.a
    public String a(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect rJ = this.fUg.rJ(i2);
                if (rJ != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, rJ.left, rJ.top, rJ.width(), rJ.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                }
                result = this.fVm.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e) {
                e.printStackTrace();
                this.fVm.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.fVm.reset();
        }
    }
}
