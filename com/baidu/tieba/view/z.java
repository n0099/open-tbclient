package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class z extends com.baidu.tbadk.widget.k {
    private int b;

    public z(Context context) {
        super(context);
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.k, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (TbadkApplication.j().l() == 1) {
            this.b = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg_1);
        } else {
            this.b = getResources().getColor(com.baidu.tieba.a.e.pb_default_image_bg);
        }
        if (getImage() == null && this.b != -1) {
            canvas.drawColor(this.b);
        }
        super.onDraw(canvas);
    }
}
