package com.baidu.tieba.person;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditHeadsImageView extends com.baidu.tbadk.widget.a {
    private Paint cqd;
    private Paint cqe;
    private int cqf;
    private int cqg;
    private float cqh;
    private int cqi;
    private float cqj;

    public EditHeadsImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqd = null;
        this.cqe = null;
        this.cqf = 0;
        this.cqg = 0;
        this.cqh = 0.42857143f;
        this.cqi = 0;
        this.cqj = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqd = null;
        this.cqe = null;
        this.cqf = 0;
        this.cqg = 0;
        this.cqh = 0.42857143f;
        this.cqi = 0;
        this.cqj = 1.0f;
        init();
    }

    public EditHeadsImageView(Context context) {
        super(context);
        this.cqd = null;
        this.cqe = null;
        this.cqf = 0;
        this.cqg = 0;
        this.cqh = 0.42857143f;
        this.cqi = 0;
        this.cqj = 1.0f;
        init();
    }

    private void init() {
        this.cqd = new Paint();
        this.cqd.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.cqd.setAlpha(153);
        this.cqe = new Paint();
        this.cqe.setStyle(Paint.Style.STROKE);
        this.cqe.setColor(-1);
        this.cqi = getResources().getColor(i.c.editimage_bg);
        setDrawingCacheEnabled(true);
        setImageMode(1);
        CompatibleUtile.getInstance().noneViewGpu(this);
    }

    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float width = this.cqj * getWidth();
        if (width > getHeight()) {
            width = getHeight();
        }
        this.cqf = (int) (((i4 - i2) - width) * this.cqh);
        this.cqg = (int) (((i4 - i2) - width) * (1.0f - this.cqh));
        setOffset(0, this.cqf, 0, this.cqg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.cqi);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.cqf, this.cqd);
        canvas.drawRect(0.0f, getHeight() - this.cqg, getWidth(), getHeight(), this.cqd);
        canvas.drawRect(0.0f, this.cqf, getWidth() - 1, getHeight() - this.cqg, this.cqe);
    }

    public Bitmap eX(boolean z) {
        Bitmap bitmap = null;
        try {
            Bitmap visableBitmap = getVisableBitmap();
            if (visableBitmap != null) {
                Bitmap createBitmap = Bitmap.createBitmap(visableBitmap, 0, this.cqf, getWidth(), (getHeight() - this.cqg) - this.cqf);
                bitmap = z ? Bitmap.createScaledBitmap(createBitmap, TbConfig.HEAD_IMG_SIZE, TbConfig.HEAD_IMG_SIZE, false) : createBitmap;
                if (bitmap != createBitmap) {
                    createBitmap.recycle();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.toString());
        }
        return bitmap;
    }

    public void setCutImageHeightScale(float f) {
        this.cqj = f;
        invalidate();
    }
}
