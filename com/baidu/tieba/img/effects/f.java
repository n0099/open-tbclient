package com.baidu.tieba.img.effects;

import android.graphics.Bitmap;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public class f extends b {
    private float a;

    @Override // com.baidu.tieba.img.effects.b
    public final String a() {
        return "round_corner";
    }

    @Override // com.baidu.tieba.img.effects.b
    public final void b(String str) {
        if (str != null) {
            this.a = com.baidu.adp.lib.f.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tieba.img.effects.b
    public final Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.a > 0.0f) {
            com.baidu.tbadk.imageManager.e.a().b(n.a(bitmap) * 2);
            return n.a(bitmap, this.a, z);
        }
        return bitmap;
    }
}
