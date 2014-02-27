package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class co extends com.baidu.tbadk.widget.b {
    private int b;

    public co(Context context) {
        super(context);
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.b, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (TiebaApplication.g().ae() == 1) {
            this.b = getResources().getColor(R.color.pb_default_image_bg_1);
        } else {
            this.b = getResources().getColor(R.color.pb_default_image_bg);
        }
        if (getImage() == null && this.b != -1) {
            canvas.drawColor(this.b);
        }
        super.onDraw(canvas);
    }
}
