package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class DottedLine extends ImageView {
    private Context a;
    private Bitmap b;
    private Rect c;
    private Rect d;

    public DottedLine(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public DottedLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DottedLine(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.c = new Rect();
        this.d = new Rect();
    }

    public void setNight(boolean z) {
        if (z) {
            this.b = BitmapFactory.decodeResource(this.a.getResources(), R.drawable.line_frs_dotted_line_1);
        } else {
            this.b = BitmapFactory.decodeResource(this.a.getResources(), R.drawable.line_frs_dotted_line);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            com.baidu.adp.lib.h.e.d("The bitmap not set by setNight() yet.");
            return;
        }
        int width = getWidth() - getPaddingRight();
        int height = getHeight();
        int width2 = this.b.getWidth();
        this.c.set(0, 0, width2, this.b.getHeight());
        int paddingLeft = getPaddingLeft();
        while (paddingLeft <= width) {
            this.d.set(paddingLeft, 0, paddingLeft + width2, height);
            paddingLeft += width2;
            canvas.drawBitmap(this.b, this.c, this.d, (Paint) null);
        }
    }
}
