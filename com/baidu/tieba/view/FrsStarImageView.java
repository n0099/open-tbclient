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
import com.baidu.tieba.util.SDRamImage;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class FrsStarImageView extends ImageView {
    public static final int STAR_PHOTO = 1;
    public static final int STAR_PHOTO_MARGIN = 3;
    public static final int STAR_TOP_PIC = 0;
    private Bitmap mDefaultImage;
    private int mImageType;
    private Matrix mMatrix;
    private Paint mPaint;

    public void setImageType(int type) {
        this.mImageType = type;
    }

    public FrsStarImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mImageType = 0;
        this.mDefaultImage = null;
    }

    public FrsStarImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mImageType = 0;
        this.mDefaultImage = null;
    }

    public FrsStarImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.mImageType = 0;
        this.mDefaultImage = null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String url = (String) getTag();
        Bitmap bm = null;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            bm = sdramImage.getPic(url);
        }
        if (bm == null) {
            switch (this.mImageType) {
                case 0:
                    if (this.mDefaultImage == null) {
                        this.mDefaultImage = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.def_star_top_pic, null);
                    }
                    bm = this.mDefaultImage;
                    break;
                case 1:
                    if (this.mDefaultImage == null) {
                        this.mDefaultImage = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.def_star_photo, null);
                    }
                    bm = this.mDefaultImage;
                    break;
            }
        } else {
            this.mDefaultImage = null;
        }
        if (bm != null) {
            int bitmapW = bm.getWidth();
            int bitmapH = bm.getHeight();
            int viewW = getWidth();
            int viewH = getHeight();
            if (bitmapW != 0 && bitmapH != 0 && viewW != 0 && viewH != 0) {
                int margin = 0;
                if (this.mImageType == 1) {
                    margin = UtilHelper.dip2px(getContext(), 3.0f);
                }
                float scaleW = (viewW - (margin * 2)) / bitmapW;
                float scaleH = (viewH - (margin * 2)) / bitmapH;
                this.mMatrix.setScale(scaleW, scaleH);
                this.mMatrix.postTranslate(margin, margin);
                canvas.drawColor(-1);
                canvas.drawBitmap(bm, this.mMatrix, this.mPaint);
                this.mMatrix.reset();
            }
        }
    }
}
