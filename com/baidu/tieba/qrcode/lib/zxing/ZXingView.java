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
import d.a.k0.p2.b.b.a;
/* loaded from: classes5.dex */
public class ZXingView extends QRCodeView {
    public MultiFormatReader n;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // d.a.k0.p2.b.a.c.a
    public String a(byte[] bArr, int i2, int i3, boolean z) {
        Result result;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                Rect h2 = this.f20188g.h(i3);
                if (h2 != null) {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, h2.left, h2.top, h2.width(), h2.height(), false);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3, false);
                }
                result = this.n.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
            } catch (Exception e2) {
                e2.printStackTrace();
                this.n.reset();
                result = null;
            }
            if (result != null) {
                return result.getText();
            }
            return null;
        } finally {
            this.n.reset();
        }
    }

    public final void o() {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.n = multiFormatReader;
        multiFormatReader.setHints(a.f58148a);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        o();
    }
}
