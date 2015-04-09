package com.baidu.tieba.tblauncher;

import android.graphics.Canvas;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
class at implements SlidingMenu.CanvasTransformer {
    final /* synthetic */ ai csd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ai aiVar) {
        this.csd = aiVar;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
    public void transformCanvas(Canvas canvas, float f) {
        float f2 = (0.2f * f) + 0.8f;
        canvas.scale(f2, f2, 0.0f, canvas.getHeight() / 2);
    }
}
