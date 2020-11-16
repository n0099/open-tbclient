package com.baidu.tieba.view;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends ShapeDrawable {
    private int color;

    public e(Path path, float f, float f2) {
        super(new PathShape(path, f, f2));
        this.color = TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0201);
    }

    public void setColor(int i) {
        this.color = i;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        getPaint().setColor(this.color);
        super.draw(canvas);
    }
}
