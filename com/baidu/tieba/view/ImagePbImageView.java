package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.SDRamImage;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class ImagePbImageView extends ImageView {
    private static final int ANIM_SEPEED = 20;
    public static final int CENTER = 0;
    private static final int MAX_FRAME_COUNT = 10;
    public static final int TOP = 1;
    private boolean isFirst;
    private boolean isLoaded;
    private int mAnimFrameIndex;
    private Handler mHandler;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mScaleType;
    private Bitmap next;

    public void setScale(int scaleType) {
        this.mScaleType = scaleType;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    public void startAnim() {
        this.mAnimFrameIndex = 10;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 20L);
        invalidate();
    }

    public void stopAnim() {
        this.mAnimFrameIndex = 0;
        this.mHandler.removeMessages(1);
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void setFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    public ImagePbImageView(Context context) {
        super(context);
        this.mScaleType = 0;
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.isLoaded = false;
        this.isFirst = false;
        this.next = BitmapHelper.getCashBitmap(R.drawable.image_pb_next);
        this.mAnimFrameIndex = -1;
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.ImagePbImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ImagePbImageView imagePbImageView = ImagePbImageView.this;
                imagePbImageView.mAnimFrameIndex--;
                if (ImagePbImageView.this.mAnimFrameIndex >= 0) {
                    ImagePbImageView.this.mHandler.sendMessageDelayed(ImagePbImageView.this.mHandler.obtainMessage(1), 20L);
                    ImagePbImageView.this.invalidate();
                }
            }
        };
    }

    public ImagePbImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mScaleType = 0;
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.isLoaded = false;
        this.isFirst = false;
        this.next = BitmapHelper.getCashBitmap(R.drawable.image_pb_next);
        this.mAnimFrameIndex = -1;
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.ImagePbImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ImagePbImageView imagePbImageView = ImagePbImageView.this;
                imagePbImageView.mAnimFrameIndex--;
                if (ImagePbImageView.this.mAnimFrameIndex >= 0) {
                    ImagePbImageView.this.mHandler.sendMessageDelayed(ImagePbImageView.this.mHandler.obtainMessage(1), 20L);
                    ImagePbImageView.this.invalidate();
                }
            }
        };
    }

    public ImagePbImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mScaleType = 0;
        this.mMatrix = new Matrix();
        this.mPaint = new Paint();
        this.isLoaded = false;
        this.isFirst = false;
        this.next = BitmapHelper.getCashBitmap(R.drawable.image_pb_next);
        this.mAnimFrameIndex = -1;
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.ImagePbImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ImagePbImageView imagePbImageView = ImagePbImageView.this;
                imagePbImageView.mAnimFrameIndex--;
                if (ImagePbImageView.this.mAnimFrameIndex >= 0) {
                    ImagePbImageView.this.mHandler.sendMessageDelayed(ImagePbImageView.this.mHandler.obtainMessage(1), 20L);
                    ImagePbImageView.this.invalidate();
                }
            }
        };
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String url = String.valueOf((String) getTag()) + AsyncImageLoader.BIG;
        Bitmap bm = null;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null) {
            bm = sdramImage.getPic(url);
        }
        if (bm == null) {
            this.isLoaded = false;
            bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
        } else {
            this.isLoaded = true;
        }
        if (bm != null) {
            this.mPaint.setAlpha(MotionEventCompat.ACTION_MASK);
            if (this.mAnimFrameIndex >= 0) {
                int alpha = (this.mAnimFrameIndex * MotionEventCompat.ACTION_MASK) / 10;
                this.mPaint.setAlpha(255 - alpha);
            }
            int pading = UtilHelper.dip2px(getContext(), 8.0f);
            int bw = bm.getWidth();
            int bh = bm.getHeight();
            int wi = getWidth() - pading;
            int he = getHeight();
            this.mMatrix.reset();
            float x = ((wi + pading) - bw) >> 1;
            float y = 0.0f;
            if (!this.isLoaded || this.mScaleType == 0) {
                y = (he - bh) >> 1;
            }
            this.mMatrix.postTranslate(x, y);
            canvas.drawBitmap(bm, this.mMatrix, this.mPaint);
            if (this.isFirst && this.next != null && this.isLoaded) {
                this.mMatrix.reset();
                float x2 = (wi + pading) - this.next.getWidth();
                float y2 = (he - this.next.getHeight()) >> 1;
                this.mMatrix.postTranslate(x2, y2);
                canvas.drawBitmap(this.next, this.mMatrix, this.mPaint);
            }
        }
    }
}
