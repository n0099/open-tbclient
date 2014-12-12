package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class ax implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(an anVar) {
        this.ccc = anVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = 1.0f - (0.2f * f);
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
