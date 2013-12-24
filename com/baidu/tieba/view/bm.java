package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bm extends com.baidu.tbadk.widget.b {
    private int b;

    public bm(Context context) {
        super(context);
        this.b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.b, com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (TiebaApplication.h().an() == 1) {
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
