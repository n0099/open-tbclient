package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class aw implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(aj ajVar) {
        this.cwo = ajVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = (0.2f * f) + 0.8f;
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
