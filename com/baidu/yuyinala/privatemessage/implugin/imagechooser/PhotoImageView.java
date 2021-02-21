package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class PhotoImageView extends ImageView {
    private Point pan;

    public PhotoImageView(Context context) {
        super(context);
        this.pan = new Point();
    }

    public PhotoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pan = new Point();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pan.x = getMeasuredWidth();
        this.pan.y = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.pan.x, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public Point getPoint() {
        return this.pan;
    }
}
