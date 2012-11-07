package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.SDRamImage;
/* loaded from: classes.dex */
public class PbImageView extends ImageView {
    private Bitmap icon;
    private Matrix mMatrix;
    private Paint mPaint;

    public PbImageView(Context context) {
        super(context);
        this.icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gif);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
    }

    public PbImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gif);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
    }

    public PbImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.icon = BitmapFactory.decodeResource(getResources(), R.drawable.icon_gif);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String url = (String) getTag();
        boolean isGif = false;
        Bitmap bm = null;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null && (bm = sdramImage.getPic(url)) != null) {
            isGif = sdramImage.isGif(url);
        }
        if (bm == null) {
            bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
        }
        if (bm != null) {
            float left = (getWidth() - bm.getWidth()) >> 1;
            float top = (getHeight() - bm.getHeight()) >> 1;
            canvas.drawBitmap(bm, left, top, this.mPaint);
            this.mMatrix.reset();
            this.mMatrix.setTranslate(left, top);
            if (isGif && bm.getHeight() > this.icon.getHeight() && bm.getWidth() > this.icon.getWidth()) {
                canvas.drawBitmap(this.icon, this.mMatrix, this.mPaint);
            }
        }
    }
}
