package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.util.BitmapHelper;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class GifView extends View {
    public static final int DECODE_STATUS_DECODED = 2;
    public static final int DECODE_STATUS_DECODING = 1;
    public static final int DECODE_STATUS_UNDECODE = 0;
    public static final int IMAGE_TYPE_DYNAMIC = 2;
    public static final int IMAGE_TYPE_STATIC = 1;
    public static final int IMAGE_TYPE_UNKNOWN = 0;
    private Bitmap bitmap;
    private byte[] data;
    public int decodeStatus;
    private GifDecoder decoder;
    private String filePath;
    private int height;
    public int imageType;
    private int index;
    Matrix mMatrix;
    Paint mPaint;
    private boolean playFlag;
    private int resId;
    private long time;
    private int width;

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.imageType = 0;
        this.decodeStatus = 0;
        this.playFlag = false;
        this.mMatrix = new Matrix();
        this.mPaint = new Paint(-1);
    }

    public GifView(Context context) {
        super(context);
        this.imageType = 0;
        this.decodeStatus = 0;
        this.playFlag = false;
        this.mMatrix = new Matrix();
        this.mPaint = new Paint(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream getInputStream() {
        if (this.data != null) {
            return new ByteArrayInputStream(this.data);
        }
        if (this.filePath != null) {
            try {
                return new FileInputStream(this.filePath);
            } catch (FileNotFoundException e) {
            }
        }
        if (this.resId > 0) {
            return getContext().getResources().openRawResource(this.resId);
        }
        return null;
    }

    public void setGif(byte[] data) {
        this.bitmap = BitmapHelper.Bytes2Bitmap(data);
        this.data = data;
        this.imageType = 0;
        this.decodeStatus = 0;
        this.playFlag = false;
    }

    public void setGif(String filePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        setGif(filePath, bitmap);
    }

    public void setGif(String filePath, Bitmap cacheImage) {
        this.resId = 0;
        this.filePath = filePath;
        this.imageType = 0;
        this.decodeStatus = 0;
        this.playFlag = false;
        this.bitmap = cacheImage;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
        setLayoutParams(new LinearLayout.LayoutParams(this.width, this.height));
    }

    public void setGif(int resId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        setGif(resId, bitmap);
    }

    public void setGif(int resId, Bitmap cacheImage) {
        this.filePath = null;
        this.resId = resId;
        this.imageType = 0;
        this.decodeStatus = 0;
        this.playFlag = false;
        this.bitmap = cacheImage;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
        setLayoutParams(new LinearLayout.LayoutParams(this.width, this.height));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.view.GifView$1] */
    private void decode() {
        release();
        this.index = 0;
        this.decodeStatus = 1;
        new Thread() { // from class: com.baidu.tieba.view.GifView.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                GifView.this.decoder = new GifDecoder();
                int type = GifView.this.decoder.read(GifView.this.getInputStream());
                if (type == 0 && GifView.this.decoder != null) {
                    if (GifView.this.decoder.width == 0 || GifView.this.decoder.height == 0) {
                        GifView.this.imageType = 1;
                    } else {
                        GifView.this.imageType = 2;
                    }
                    if (!GifView.this.decoder.err()) {
                        GifView.this.postInvalidate();
                    }
                    GifView.this.time = System.currentTimeMillis();
                    GifView.this.decodeStatus = 2;
                }
            }
        }.start();
    }

    public void release() {
        if (this.decoder != null) {
            this.decoder.stopDecode();
        }
        this.decoder = null;
        System.gc();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            int bw = this.bitmap.getWidth();
            int bh = this.bitmap.getHeight();
            int wi = getWidth();
            int he = getHeight();
            int x = (wi - bw) >> 1;
            int y = (he - bh) >> 1;
            int sw = bw;
            int sh = bh;
            boolean flag = false;
            if (x >= 0 && y >= 0) {
                flag = true;
            } else {
                float scale = Math.min(wi / bw, he / bh);
                this.mMatrix.setScale(scale, scale);
                x = (int) ((wi - (bw * scale)) / 2.0f);
                y = (int) ((he - (bh * scale)) / 2.0f);
                this.mMatrix.postTranslate(x, y);
                sw = (int) (bw * scale);
                sh = (int) (bh * scale);
            }
            canvas.clipRect(x, y, x + sw, y + sh);
            canvas.drawColor(-1);
            if (this.decodeStatus == 0) {
                if (flag) {
                    canvas.drawBitmap(this.bitmap, x, y, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bitmap, this.mMatrix, this.mPaint);
                }
                if (this.playFlag) {
                    decode();
                    invalidate();
                }
            } else if (this.decodeStatus == 1) {
                if (flag) {
                    canvas.drawBitmap(this.bitmap, x, y, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bitmap, this.mMatrix, this.mPaint);
                }
                invalidate();
            } else if (this.decodeStatus == 2) {
                if (this.imageType == 1) {
                    if (flag) {
                        canvas.drawBitmap(this.bitmap, x, y, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.bitmap, this.mMatrix, this.mPaint);
                    }
                } else if (this.imageType == 2) {
                    if (this.playFlag) {
                        long now = System.currentTimeMillis();
                        if (this.time + this.decoder.getDelay(this.index) < now) {
                            this.time += this.decoder.getDelay(this.index);
                            incrementFrameIndex();
                        }
                        Bitmap bitmap = this.decoder.getFrame(this.index);
                        if (bitmap != null) {
                            if (flag) {
                                canvas.drawBitmap(bitmap, x, y, (Paint) null);
                            } else {
                                canvas.drawBitmap(bitmap, this.mMatrix, this.mPaint);
                            }
                        }
                        invalidate();
                        return;
                    }
                    Bitmap bitmap2 = this.decoder.getFrame(this.index);
                    if (flag) {
                        canvas.drawBitmap(bitmap2, x, y, (Paint) null);
                    } else {
                        canvas.drawBitmap(bitmap2, this.mMatrix, this.mPaint);
                    }
                } else if (flag) {
                    canvas.drawBitmap(this.bitmap, x, y, (Paint) null);
                } else {
                    canvas.drawBitmap(this.bitmap, this.mMatrix, this.mPaint);
                }
            }
        }
    }

    private void incrementFrameIndex() {
        this.index++;
        if (this.index >= this.decoder.getFrameCount()) {
            this.index = 0;
        }
    }

    private void decrementFrameIndex() {
        this.index--;
        if (this.index < 0) {
            this.index = this.decoder.getFrameCount() - 1;
        }
    }

    public void play() {
        this.time = System.currentTimeMillis();
        this.playFlag = true;
        invalidate();
    }

    public void pause() {
        this.playFlag = false;
        invalidate();
    }

    public void stop() {
        this.playFlag = false;
        this.index = 0;
        invalidate();
    }

    public void nextFrame() {
        if (this.decodeStatus == 2) {
            incrementFrameIndex();
            invalidate();
        }
    }

    public void prevFrame() {
        if (this.decodeStatus == 2) {
            decrementFrameIndex();
            invalidate();
        }
    }
}
