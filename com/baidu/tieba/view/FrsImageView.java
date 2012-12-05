package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.SDRamImage;
/* loaded from: classes.dex */
public class FrsImageView extends ImageView {
    private boolean isLoaded;
    private boolean isThree;
    private Matrix mMatrix;
    private Paint mPaint;
    private int type;

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void setIsThree(boolean src) {
        this.isThree = src;
    }

    public FrsImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.type = 0;
        this.isLoaded = false;
        this.isThree = false;
    }

    public FrsImageView(Context context, int type) {
        super(context);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.type = 0;
        this.isLoaded = false;
        this.isThree = false;
        this.type = type;
    }

    public FrsImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.type = 0;
        this.isLoaded = false;
        this.isThree = false;
    }

    public FrsImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.type = 0;
        this.isLoaded = false;
        this.isThree = false;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int x;
        super.onDraw(canvas);
        String url = String.valueOf((String) getTag()) + AsyncImageLoader.SMALL;
        Bitmap bm = null;
        boolean needResize = false;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            bm = sdramImage.getPic(url);
        }
        if (bm == null) {
            if (this.isLoaded) {
                needResize = true;
            }
            this.isLoaded = false;
            if (this.type == 5) {
                bm = BitmapHelper.getCashBitmap(R.drawable.video_pic);
                this.isLoaded = true;
            } else {
                bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
            }
        } else {
            if (!this.isLoaded) {
                needResize = true;
            }
            this.isLoaded = true;
        }
        if (bm != null) {
            int bw = bm.getWidth();
            int bh = bm.getHeight();
            int wi = getWidth();
            int he = getHeight();
            if (bw != 0 && bh != 0 && wi != 0 && he != 0) {
                float scale = Math.min(wi / bw, he / bh);
                if (scale > 1.0f) {
                    scale = 1.0f;
                }
                this.mMatrix.setScale(scale, scale);
                if (!this.isThree) {
                    x = 0;
                    if (needResize) {
                        int width = (int) (bw * scale);
                        ViewGroup.LayoutParams imageViewparams = getLayoutParams();
                        imageViewparams.width = width;
                        setLayoutParams(imageViewparams);
                    }
                } else {
                    x = ((int) (wi - (bw * scale))) / 2;
                }
                int y = (int) (he - (bh * scale));
                this.mMatrix.postTranslate(x, y);
                canvas.drawBitmap(bm, this.mMatrix, this.mPaint);
                this.mMatrix.reset();
            }
        }
    }
}
