package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.TiebaLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragImageView extends ImageView {
    public static final int DECODE_STATUS_DECODED = 2;
    public static final int DECODE_STATUS_DECODING = 1;
    public static final int DECODE_STATUS_UNDECODE = 0;
    static final int DRAG = 1;
    public static final int GIF_DYNAMIC = 1;
    public static final int GIF_STATIC = 0;
    public static final int IMAGE_TYPE_DEFAULT = 2;
    public static final int IMAGE_TYPE_DYNAMIC = 1;
    public static final int IMAGE_TYPE_STATIC = 0;
    private static final int MAX_IMAGE_SIZE = 1300;
    static final int NORMAL = 0;
    static final int ZOOM = 2;
    private static final float ZOOM_IN_MULTIPLE = 1.25f;
    private DecelerateAnimation mAnimation;
    private View.OnClickListener mClick;
    private float mCurrentScale;
    private Interpolator mDecelerateInterpolater;
    public volatile int mDecodeStatus;
    private GestureDetector mGestureDetector;
    private Bitmap mGifCache;
    private volatile GifDecoder mGifDecoder;
    private int mGifIndex;
    private int mGifMaxUseableMem;
    private int mGifType;
    private boolean mHaveMove;
    private boolean mHaveZoom;
    private byte[] mImageData;
    private int mImageType;
    private float mInitScale;
    private boolean mIsTouched;
    private OnSizeChangedListener mListener;
    private Matrix mMatrix;
    private float mMaxScale;
    private int mMode;
    private float mOldDist;
    private float mOldScale;
    private OnGifSetListener mOnGifSetListener;
    private Paint mPaint;
    private boolean mPlayFlag;
    private float mResizedHeight;
    private float mResizedWidth;
    private ArrayList<Float> mScale;
    private int mViewHeight;
    private int mViewWidth;
    private volatile long time;

    /* loaded from: classes.dex */
    public interface OnGifSetListener {
        void gifSet(DragImageView dragImageView);
    }

    /* loaded from: classes.dex */
    public interface OnSizeChangedListener {
        void sizeChenged(DragImageView dragImageView, boolean z, boolean z2);
    }

    public DragImageView(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mDecodeStatus = 0;
        this.mGifType = 0;
        this.mGifDecoder = null;
        this.mGifCache = null;
        this.mGifIndex = 0;
        this.time = 0L;
        this.mPaint = new Paint(-16777216);
        this.mPlayFlag = false;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public DragImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mDecodeStatus = 0;
        this.mGifType = 0;
        this.mGifDecoder = null;
        this.mGifCache = null;
        this.mGifIndex = 0;
        this.time = 0L;
        this.mPaint = new Paint(-16777216);
        this.mPlayFlag = false;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public DragImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMatrix = new Matrix();
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mImageData = null;
        this.mGifMaxUseableMem = 0;
        this.mListener = null;
        this.mClick = null;
        this.mOnGifSetListener = null;
        this.mOldDist = 1.0f;
        this.mImageType = 0;
        this.mMode = 0;
        this.mHaveMove = false;
        this.mHaveZoom = false;
        this.mDecodeStatus = 0;
        this.mGifType = 0;
        this.mGifDecoder = null;
        this.mGifCache = null;
        this.mGifIndex = 0;
        this.time = 0L;
        this.mPaint = new Paint(-16777216);
        this.mPlayFlag = false;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    public int getImageType() {
        return this.mImageType;
    }

    public void setGifMaxUseableMem(int mem) {
        this.mGifMaxUseableMem = mem;
    }

    public void actionUp() {
        this.mHaveZoom = false;
        this.mIsTouched = false;
        this.mMode = 0;
        if (this.mCurrentScale < this.mInitScale) {
            this.mCurrentScale = this.mInitScale;
            resizeBitmap();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.mIsTouched = true;
                this.mHaveMove = false;
                this.mHaveZoom = false;
                break;
            case 1:
                actionUp();
                break;
            case 2:
                if (this.mMode == 0) {
                    this.mMode = 1;
                    break;
                }
                break;
        }
        if (action == CompatibleUtile.getActionPointerUp()) {
            this.mMode = 1;
        } else if (action == CompatibleUtile.getActionPointerDown()) {
            this.mOldDist = spacing(event);
            if (this.mOldDist > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.mGestureDetector.onTouchEvent(event)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.mHaveMove = true;
                        this.mHaveZoom = true;
                        if (this.mImageType != 1 && this.mImageType != 2) {
                            float newDist = spacing(event);
                            if (newDist >= 0.0f && Math.abs(this.mOldDist - newDist) >= 10.0f) {
                                if (Math.abs(this.mOldDist - newDist) > 100.0f) {
                                    this.mOldDist = newDist;
                                    break;
                                } else {
                                    float mScaleFactor = newDist / this.mOldDist;
                                    this.mOldDist = newDist;
                                    this.mOldScale = this.mCurrentScale;
                                    this.mCurrentScale *= mScaleFactor;
                                    if (this.mCurrentScale > this.mMaxScale) {
                                        this.mCurrentScale = this.mMaxScale;
                                    }
                                    if (this.mCurrentScale < this.mInitScale / 4.0f) {
                                        this.mCurrentScale = this.mInitScale / 4.0f;
                                    }
                                    resizeBitmap();
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            return super.onTouchEvent(event);
        }
        return true;
    }

    public float spacing(MotionEvent event) {
        return CompatibleUtile.getSpacing(event);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            this.mViewWidth = right - left;
            this.mViewHeight = bottom - top;
            reInitBitmap();
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public boolean pagerCantScroll() {
        return this.mInitScale == this.mCurrentScale;
    }

    private void reInitBitmap() {
        Bitmap bitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            float sx = this.mViewWidth / bitmap.getWidth();
            float sy = this.mViewHeight / bitmap.getHeight();
            if (bitmap.getWidth() <= this.mViewWidth && bitmap.getHeight() <= this.mViewHeight) {
                this.mInitScale = 1.0f;
            } else {
                this.mInitScale = Math.min(sx, sy);
                if (sx >= sy) {
                    sx = sy;
                }
                this.mInitScale = sx;
            }
            this.mMaxScale = 1690000 / (bitmap.getWidth() * bitmap.getHeight());
            this.mMaxScale = (float) Math.sqrt(this.mMaxScale);
            if (this.mMaxScale > 10.0f) {
                this.mMaxScale = 10.0f;
            }
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
            callChangeListener();
            return;
        }
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        this.mScale.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable dr = getDrawable();
        if (dr == null || !(dr instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) dr).getBitmap();
    }

    private void callChangeListener() {
        if (this.mListener != null) {
            this.mListener.sizeChenged(this, canZoomIn(), canZoomOut());
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener listener) {
        this.mListener = listener;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void stopDecode() {
        if (this.mGifDecoder != null) {
            this.mGifDecoder.stopDecode();
            this.mGifDecoder = null;
        }
        this.mPlayFlag = false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.view.DragImageView$1] */
    public void decode() {
        stopDecode();
        this.mGifIndex = 0;
        if (this.mImageData != null) {
            this.mDecodeStatus = 1;
            invalidate();
            new Thread() { // from class: com.baidu.tieba.view.DragImageView.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        DragImageView.this.mGifDecoder = new GifDecoder(DragImageView.this.mGifMaxUseableMem);
                        int type = DragImageView.this.mGifDecoder.read(new ByteArrayInputStream(DragImageView.this.mImageData));
                        if (type == 0) {
                            if (DragImageView.this.mGifDecoder.width == 0 || DragImageView.this.mGifDecoder.height == 0) {
                                DragImageView.this.mGifType = 0;
                            } else {
                                DragImageView.this.mGifType = 1;
                            }
                            if (!DragImageView.this.mGifDecoder.err()) {
                                DragImageView.this.postInvalidate();
                            }
                            DragImageView.this.time = System.currentTimeMillis();
                            DragImageView.this.mDecodeStatus = 2;
                            if (DragImageView.this.mPlayFlag && !DragImageView.this.mGifDecoder.isInterrupted()) {
                                DragImageView.this.postInvalidate();
                            }
                        }
                    } catch (Exception e) {
                        DragImageView.this.mDecodeStatus = 0;
                    }
                }
            }.start();
        }
    }

    public byte[] getImageData() {
        return this.mImageData;
    }

    public void setImageData(byte[] data) {
        this.mImageData = data;
    }

    public Bitmap getGifCache() {
        return this.mGifCache;
    }

    public void setGifCache(Bitmap cache) {
        this.mGifCache = cache;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mImageType == 1 && this.mGifCache != null && !this.mGifCache.isRecycled()) {
            int bw = this.mGifCache.getWidth();
            int bh = this.mGifCache.getHeight();
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
            if (this.mDecodeStatus == 2 && this.mGifType == 1 && this.mPlayFlag && this.mGifDecoder != null) {
                long now = System.currentTimeMillis();
                if (this.time + this.mGifDecoder.getDelay(this.mGifIndex) < now) {
                    this.time += this.mGifDecoder.getDelay(this.mGifIndex);
                    incrementFrameIndex();
                }
                Bitmap bitmap = this.mGifDecoder.getFrame(this.mGifIndex);
                if (bitmap != null) {
                    if (flag) {
                        canvas.drawBitmap(bitmap, x, y, (Paint) null);
                    } else {
                        canvas.drawBitmap(bitmap, this.mMatrix, this.mPaint);
                    }
                }
                invalidate();
            } else if (flag) {
                canvas.drawBitmap(this.mGifCache, x, y, (Paint) null);
            } else {
                canvas.drawBitmap(this.mGifCache, this.mMatrix, this.mPaint);
            }
        }
    }

    private void incrementFrameIndex() {
        if (this.mGifDecoder != null) {
            this.mGifIndex++;
            if (this.mGifIndex >= this.mGifDecoder.getFrameCount()) {
                this.mGifIndex = 0;
            }
        }
    }

    private void decrementFrameIndex() {
        if (this.mGifDecoder != null) {
            this.mGifIndex--;
            if (this.mGifIndex < 0) {
                this.mGifIndex = this.mGifDecoder.getFrameCount() - 1;
            }
        }
    }

    public void play() {
        if (this.mImageType == 1) {
            if (this.mDecodeStatus == 0) {
                decode();
            } else {
                this.time = System.currentTimeMillis();
                invalidate();
            }
            this.mPlayFlag = true;
        }
    }

    public void pause() {
        if (this.mImageType == 1) {
            TiebaLog.d(getClass().getName(), "pause", null);
            this.mPlayFlag = false;
            invalidate();
        }
    }

    public void stop() {
        if (this.mImageType == 1) {
            super.setImageBitmap(null);
            this.mPlayFlag = false;
            stopDecode();
            this.mDecodeStatus = 0;
            this.mGifIndex = 0;
            invalidate();
        }
    }

    public void nextFrame() {
        if (this.mDecodeStatus == 2) {
            incrementFrameIndex();
            invalidate();
        }
    }

    public void prevFrame() {
        if (this.mDecodeStatus == 2) {
            decrementFrameIndex();
            invalidate();
        }
    }

    private void initData() {
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mScale = new ArrayList<>();
        this.mInitScale = 1.0f;
        this.mMaxScale = 1.0f;
        this.mCurrentScale = 1.0f;
        this.mOldScale = this.mCurrentScale;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mAnimation = new DecelerateAnimation();
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.mGestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.DragImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (Math.abs(velocityX) > 200.0f || Math.abs(velocityY) > 200.0f) {
                    DragImageView.this.mAnimation.prepareAnimation(velocityX, velocityY);
                    DragImageView.this.startAnimation(DragImageView.this.mAnimation);
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                if (DragImageView.this.mClick != null && !DragImageView.this.mHaveMove) {
                    DragImageView.this.mClick.onClick(DragImageView.this);
                }
                return super.onSingleTapUp(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                DragImageView.this.mHaveMove = true;
                if (DragImageView.this.mHaveZoom) {
                    return false;
                }
                int sx = DragImageView.this.getScrollX();
                if (DragImageView.this.mResizedWidth > DragImageView.this.getWidth()) {
                    sx = (int) (sx + distanceX);
                    if (sx < 0) {
                        sx = 0;
                    }
                    if (DragImageView.this.getWidth() + sx > DragImageView.this.mResizedWidth) {
                        sx = (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth());
                    }
                }
                int sy = DragImageView.this.getScrollY();
                if (DragImageView.this.mResizedHeight > DragImageView.this.getHeight()) {
                    sy = (int) (sy + distanceY);
                    if (sy < 0) {
                        sy = 0;
                    }
                    if (DragImageView.this.getHeight() + sy > DragImageView.this.mResizedHeight) {
                        sy = (int) (DragImageView.this.mResizedHeight - DragImageView.this.getHeight());
                    }
                }
                if (sx == DragImageView.this.getScrollX() && sy == DragImageView.this.getScrollY()) {
                    return true;
                }
                DragImageView.this.scrollTo(sx, sy);
                DragImageView.this.invalidate();
                return true;
            }
        });
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.mResizedWidth;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.mResizedHeight;
    }

    public boolean onRightSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        if (this.mHaveZoom) {
            return false;
        }
        int sx = getScrollX();
        return sx >= ((int) (this.mResizedWidth - ((float) getWidth()))) + (-1);
    }

    public boolean onLeftSide() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return true;
        }
        if (this.mHaveZoom) {
            return false;
        }
        int sx = getScrollX();
        return sx <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        super.setImageBitmap(bitmap);
        reInitBitmap();
        this.mImageType = 0;
    }

    public void setGifData(byte[] data, Bitmap cache) {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        super.setImageBitmap(null);
        stopDecode();
        reInitBitmap();
        this.mImageType = 1;
        this.mDecodeStatus = 0;
        this.mGifCache = cache;
        this.mImageData = data;
        if (this.mOnGifSetListener != null) {
            this.mOnGifSetListener.gifSet(this);
        }
    }

    public void onDestroy() {
        super.setImageBitmap(null);
        stopDecode();
        this.mImageData = null;
        this.mDecodeStatus = 0;
        this.mGifCache = null;
        this.mPlayFlag = false;
    }

    public void release() {
        super.setImageBitmap(null);
        stopDecode();
        this.mDecodeStatus = 0;
        this.mGifCache = null;
        this.mPlayFlag = false;
    }

    public void setDefaultBitmap() {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        super.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.drgimage_fail));
        this.mImageType = 2;
        reInitBitmap();
    }

    public void zoomInBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 0) {
                float scale = this.mScale.get(size - 1).floatValue() * ZOOM_IN_MULTIPLE;
                this.mScale.add(Float.valueOf(scale));
            } else {
                this.mScale.add(Float.valueOf(this.mInitScale));
            }
            resizeBitmap();
            callChangeListener();
        }
    }

    public void zoomOutBitmap() {
        if (this.mImageType != 1 && this.mImageType != 2) {
            int size = this.mScale.size();
            if (size > 1) {
                this.mScale.remove(size - 1);
            }
            resizeBitmap();
            callChangeListener();
        }
    }

    public void restoreSize() {
        callChangeListener();
        if (this.mImageType != 1 && this.mImageType != 2 && this.mCurrentScale != this.mInitScale) {
            this.mScale.clear();
            this.mScale.add(Float.valueOf(this.mInitScale));
            this.mCurrentScale = this.mInitScale;
            this.mOldScale = this.mCurrentScale;
            resizeBitmap();
        }
    }

    public boolean canZoomIn() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap bitmap = getImageBitmap();
        if (bitmap == null || bitmap.isRecycled() || size <= 0) {
            return false;
        }
        float scale = this.mScale.get(size - 1).floatValue();
        int current_size = (int) (bitmap.getWidth() * bitmap.getHeight() * scale * scale);
        return (((float) current_size) * ZOOM_IN_MULTIPLE) * ZOOM_IN_MULTIPLE <= ((float) 1690000) && scale <= 5.0f;
    }

    public boolean canZoomOut() {
        if (this.mImageType == 1 || this.mImageType == 2) {
            return false;
        }
        int size = this.mScale.size();
        Bitmap bitmap = getImageBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    private void resizeBitmap() {
        float scale;
        Bitmap bitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.mScale.size();
                    if (size > 0) {
                        scale = this.mScale.get(size - 1).floatValue();
                    } else {
                        scale = this.mInitScale;
                    }
                    this.mCurrentScale = scale;
                }
                this.mMatrix.setScale(this.mCurrentScale, this.mCurrentScale);
                this.mResizedWidth = bitmap.getWidth() * this.mCurrentScale;
                this.mResizedHeight = bitmap.getHeight() * this.mCurrentScale;
                float oldWidth = bitmap.getWidth() * this.mOldScale;
                float oldHeight = bitmap.getHeight() * this.mOldScale;
                float x = 0.0f;
                if (this.mResizedWidth < this.mViewWidth) {
                    x = (int) ((this.mViewWidth - this.mResizedWidth) / 2.0f);
                }
                float y = this.mResizedHeight < ((float) this.mViewHeight) ? (int) ((this.mViewHeight - this.mResizedHeight) / 2.0f) : 0.0f;
                this.mMatrix.postTranslate(x, y);
                int sx = getScrollX();
                if (this.mMode == 2) {
                    sx += (int) ((this.mResizedWidth - oldWidth) / 2.0f);
                }
                if (this.mResizedWidth > getWidth()) {
                    if (getWidth() + sx > this.mResizedWidth) {
                        sx = (int) (this.mResizedWidth - getWidth());
                    }
                } else {
                    sx = 0;
                }
                int sy = getScrollY();
                if (this.mMode == 2) {
                    sy += (int) ((this.mResizedHeight - oldHeight) / 2.0f);
                }
                if (this.mResizedHeight > getHeight()) {
                    if (getHeight() + sy > this.mResizedHeight) {
                        sy = (int) (this.mResizedHeight - getHeight());
                    }
                } else {
                    sy = 0;
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (sx < 0) {
                    sx = 0;
                }
                if (sy < 0) {
                    sy = 0;
                }
                scrollTo(sx, sy);
                setImageMatrix(this.mMatrix);
            } catch (Exception ex) {
                TiebaLog.e("DragImageView", "resizeBitmap", "error = " + ex.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DecelerateAnimation extends Animation {
        static final long Decelerate = 2500;
        private int mStartX;
        private int mStartY;
        private long mTimeX;
        private long mTimeY;
        private long velocityX;
        private long velocityY;
        private boolean mIsAnimationInProgres = false;
        private boolean mStop = false;

        public DecelerateAnimation() {
        }

        public void prepareAnimation(float velocityX, float velocityY) {
            if (velocityX > 1500.0f) {
                velocityX = 1500.0f;
            } else if (velocityX < -1500.0f) {
                velocityX = -1500.0f;
            }
            if (velocityY > 1500.0f) {
                velocityY = 1500.0f;
            } else if (velocityY < -1500.0f) {
                velocityY = -1500.0f;
            }
            this.velocityX = velocityX;
            this.velocityY = velocityY;
            this.mTimeX = Math.abs((velocityX * 1000.0f) / 2500.0f);
            this.mTimeY = Math.abs((velocityY * 1000.0f) / 2500.0f);
            long max_time = Math.max(this.mTimeX, this.mTimeY);
            setDuration(max_time);
            setInterpolator(DragImageView.this.mDecelerateInterpolater);
            this.mStartX = DragImageView.this.getScrollX();
            this.mStartY = DragImageView.this.getScrollY();
            this.mIsAnimationInProgres = true;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, Transformation transformation) {
            long time;
            int distanceX;
            int distanceY;
            if (interpolatedTime > 1.0f) {
                interpolatedTime = 1.0f;
            }
            if (this.mTimeX > this.mTimeY) {
                time = ((float) this.mTimeX) * interpolatedTime;
            } else {
                time = ((float) this.mTimeY) * interpolatedTime;
            }
            float tmp = ((float) (time > this.mTimeX ? this.mTimeX : time)) / 1000.0f;
            if (this.velocityX > 0) {
                distanceX = this.mStartX - ((int) ((((float) this.velocityX) - ((2500.0f * tmp) / 2.0f)) * tmp));
            } else {
                distanceX = this.mStartX - ((int) ((((float) this.velocityX) + ((2500.0f * tmp) / 2.0f)) * tmp));
            }
            if (time > this.mTimeY) {
                time = this.mTimeY;
            }
            float tmp2 = ((float) time) / 1000.0f;
            if (this.velocityY > 0) {
                distanceY = this.mStartY - ((int) ((((float) this.velocityY) - ((2500.0f * tmp2) / 2.0f)) * tmp2));
            } else {
                distanceY = this.mStartY - ((int) ((((float) this.velocityY) + ((2500.0f * tmp2) / 2.0f)) * tmp2));
            }
            if (DragImageView.this.mResizedHeight > DragImageView.this.getHeight()) {
                if (DragImageView.this.getHeight() + distanceY > DragImageView.this.mResizedHeight) {
                    distanceY = (int) (DragImageView.this.mResizedHeight - DragImageView.this.getHeight());
                }
                if (distanceY < 0) {
                    distanceY = 0;
                }
            } else {
                distanceY = 0;
            }
            if (DragImageView.this.mResizedWidth > DragImageView.this.getWidth()) {
                if (DragImageView.this.getWidth() + distanceX > DragImageView.this.mResizedWidth) {
                    distanceX = (int) (DragImageView.this.mResizedWidth - DragImageView.this.getWidth());
                }
                if (distanceX < 0) {
                    distanceX = 0;
                }
            } else {
                distanceX = 0;
            }
            DragImageView.this.scrollTo(distanceX, distanceY);
            DragImageView.this.invalidate();
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long currentTime, Transformation outTransformation) {
            if (!this.mStop) {
                if (DragImageView.this.mIsTouched) {
                    this.mIsAnimationInProgres = false;
                    return false;
                } else if (!super.getTransformation(currentTime, outTransformation)) {
                    this.mIsAnimationInProgres = false;
                    return false;
                } else {
                    return true;
                }
            }
            this.mStop = false;
            this.mIsAnimationInProgres = false;
            return false;
        }

        public boolean getIsAnimationInProgre() {
            return this.mIsAnimationInProgres;
        }

        public void stopAnimation() {
            this.mStop = true;
        }
    }

    public void setImageOnClickListener(View.OnClickListener click) {
        this.mClick = click;
    }

    public void setGifSetListener(OnGifSetListener listener) {
        this.mOnGifSetListener = listener;
    }
}
