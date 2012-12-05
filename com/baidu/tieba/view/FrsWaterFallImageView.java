package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
/* loaded from: classes.dex */
public class FrsWaterFallImageView extends ImageView {
    private static final int ANIM_SEPEED = 20;
    private static final int MAX_FRAME_COUNT = 10;
    private Bitmap icon;
    private int mAnimFrameIndex;
    private Handler mHandler;
    private Paint mPaint;

    public FrsWaterFallImageView(Context context) {
        super(context);
        this.icon = BitmapHelper.getCashBitmap(R.drawable.icon_gif);
        this.mAnimFrameIndex = -1;
        this.mPaint = new Paint();
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.FrsWaterFallImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                FrsWaterFallImageView frsWaterFallImageView = FrsWaterFallImageView.this;
                frsWaterFallImageView.mAnimFrameIndex--;
                if (FrsWaterFallImageView.this.mAnimFrameIndex >= 0) {
                    FrsWaterFallImageView.this.mHandler.sendMessageDelayed(FrsWaterFallImageView.this.mHandler.obtainMessage(1), 20L);
                    FrsWaterFallImageView.this.invalidate();
                }
            }
        };
    }

    public FrsWaterFallImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.icon = BitmapHelper.getCashBitmap(R.drawable.icon_gif);
        this.mAnimFrameIndex = -1;
        this.mPaint = new Paint();
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.FrsWaterFallImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                FrsWaterFallImageView frsWaterFallImageView = FrsWaterFallImageView.this;
                frsWaterFallImageView.mAnimFrameIndex--;
                if (FrsWaterFallImageView.this.mAnimFrameIndex >= 0) {
                    FrsWaterFallImageView.this.mHandler.sendMessageDelayed(FrsWaterFallImageView.this.mHandler.obtainMessage(1), 20L);
                    FrsWaterFallImageView.this.invalidate();
                }
            }
        };
    }

    public FrsWaterFallImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.icon = BitmapHelper.getCashBitmap(R.drawable.icon_gif);
        this.mAnimFrameIndex = -1;
        this.mPaint = new Paint();
        this.mHandler = new Handler() { // from class: com.baidu.tieba.view.FrsWaterFallImageView.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                FrsWaterFallImageView frsWaterFallImageView = FrsWaterFallImageView.this;
                frsWaterFallImageView.mAnimFrameIndex--;
                if (FrsWaterFallImageView.this.mAnimFrameIndex >= 0) {
                    FrsWaterFallImageView.this.mHandler.sendMessageDelayed(FrsWaterFallImageView.this.mHandler.obtainMessage(1), 20L);
                    FrsWaterFallImageView.this.invalidate();
                }
            }
        };
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

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnim();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean isGif = false;
        Bitmap bm = null;
        String url = String.valueOf((String) getTag()) + AsyncImageLoader.WATER;
        SDRamImage sdramImage = TiebaApplication.app.getSdramImage();
        if (sdramImage != null && (bm = sdramImage.getPic(url)) != null) {
            isGif = sdramImage.isGif(url);
        }
        if (this.mAnimFrameIndex <= 0) {
            if (bm == null) {
                bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
            }
            if (bm != null) {
                float left = (getWidth() - bm.getWidth()) >> 1;
                float top = (getHeight() - bm.getHeight()) >> 1;
                canvas.drawBitmap(bm, left, top, (Paint) null);
                if (isGif) {
                    canvas.drawBitmap(this.icon, 0.0f, 0.0f, (Paint) null);
                }
            }
        } else if (bm != null) {
            int alpha = (this.mAnimFrameIndex * MotionEventCompat.ACTION_MASK) / 10;
            Bitmap def = BitmapHelper.getCashBitmap(R.drawable.image_default);
            float left2 = (getWidth() - def.getWidth()) >> 1;
            float top2 = (getHeight() - def.getHeight()) >> 1;
            this.mPaint.setAlpha(alpha);
            canvas.drawBitmap(def, left2, top2, this.mPaint);
            float left3 = (getWidth() - bm.getWidth()) >> 1;
            float top3 = (getHeight() - bm.getHeight()) >> 1;
            this.mPaint.setAlpha(255 - alpha);
            canvas.drawBitmap(bm, left3, top3, this.mPaint);
            if (isGif) {
                canvas.drawBitmap(this.icon, 0.0f, 0.0f, (Paint) null);
            }
        } else {
            Bitmap bm2 = BitmapHelper.getCashBitmap(R.drawable.image_default);
            float left4 = (getWidth() - bm2.getWidth()) >> 1;
            float top4 = (getHeight() - bm2.getHeight()) >> 1;
            canvas.drawBitmap(bm2, left4, top4, (Paint) null);
        }
    }
}
