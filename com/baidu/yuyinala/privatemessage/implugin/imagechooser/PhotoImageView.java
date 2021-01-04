package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes11.dex */
public class PhotoImageView extends ImageView {
    private Point oUd;

    public PhotoImageView(Context context) {
        super(context);
        this.oUd = new Point();
    }

    public PhotoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oUd = new Point();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.oUd.x = getMeasuredWidth();
        this.oUd.y = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.oUd.x, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public Point getPoint() {
        return this.oUd;
    }
}
