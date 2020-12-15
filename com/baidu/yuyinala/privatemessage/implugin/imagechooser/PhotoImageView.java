package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class PhotoImageView extends ImageView {
    private Point oNU;

    public PhotoImageView(Context context) {
        super(context);
        this.oNU = new Point();
    }

    public PhotoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oNU = new Point();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.oNU.x = getMeasuredWidth();
        this.oNU.y = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.oNU.x, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public Point getPoint() {
        return this.oNU;
    }
}
