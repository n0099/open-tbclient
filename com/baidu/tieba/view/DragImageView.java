package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class DragImageView extends View {
    private static final int DISAPPEAR_TIME = 2000;
    private DecelerateAnimation mAnimation;
    private Bitmap mBitmap;
    private View.OnClickListener mClick;
    private Interpolator mDecelerateInterpolater;
    private GestureDetector mGestureDetector;
    private float mInitScale;
    private boolean mIsTouched;
    private OnSizeChangedListener mListener;
    private Bitmap mResizeBitmap;
    private float mResizedHeight;
    private float mResizedWidth;
    private float mScale;
    private int mViewHeight;
    private int mViewWidth;
    Handler mhandler;
    Runnable runnable;

    /* loaded from: classes.dex */
    public interface OnSizeChangedListener {
        void sizeChenged(boolean z, boolean z2);
    }

    public DragImageView(Context context) {
        super(context);
        this.mBitmap = null;
        this.mResizeBitmap = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mListener = null;
        this.mClick = null;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mhandler = new Handler();
        this.runnable = new Runnable() { // from class: com.baidu.tieba.view.DragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                DragImageView.this.setHorizontalScrollBarEnabled(false);
                DragImageView.this.setVerticalScrollBarEnabled(false);
                DragImageView.this.invalidate();
            }
        };
        initData();
    }

    public DragImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBitmap = null;
        this.mResizeBitmap = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mListener = null;
        this.mClick = null;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mhandler = new Handler();
        this.runnable = new Runnable() { // from class: com.baidu.tieba.view.DragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                DragImageView.this.setHorizontalScrollBarEnabled(false);
                DragImageView.this.setVerticalScrollBarEnabled(false);
                DragImageView.this.invalidate();
            }
        };
        initData();
    }

    public DragImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mBitmap = null;
        this.mResizeBitmap = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsTouched = false;
        this.mListener = null;
        this.mClick = null;
        this.mDecelerateInterpolater = AnimationUtils.loadInterpolator(getContext(), 17432582);
        this.mhandler = new Handler();
        this.runnable = new Runnable() { // from class: com.baidu.tieba.view.DragImageView.1
            @Override // java.lang.Runnable
            public void run() {
                DragImageView.this.setHorizontalScrollBarEnabled(false);
                DragImageView.this.setVerticalScrollBarEnabled(false);
                DragImageView.this.invalidate();
            }
        };
        initData();
    }

    public Bitmap getResizeBmp() {
        return this.mResizeBitmap;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent me) {
        if (this.mGestureDetector.onTouchEvent(me)) {
            return true;
        }
        int action = me.getAction();
        switch (action) {
            case 0:
                int width = getWidth();
                int height = getHeight();
                this.mhandler.removeCallbacks(this.runnable);
                if (this.mResizedWidth > width) {
                    setHorizontalScrollBarEnabled(true);
                } else {
                    setHorizontalScrollBarEnabled(false);
                }
                if (this.mResizedHeight > height) {
                    setVerticalScrollBarEnabled(true);
                } else {
                    setVerticalScrollBarEnabled(false);
                }
                invalidate();
                this.mIsTouched = true;
                break;
            case 1:
                this.mhandler.removeCallbacks(this.runnable);
                this.mhandler.postDelayed(this.runnable, 2000L);
                this.mIsTouched = false;
                invalidate();
                break;
        }
        return super.onTouchEvent(me);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            this.mViewWidth = right - left;
            this.mViewHeight = bottom - top;
            if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                float sx = 1.0f;
                float sy = 1.0f;
                if (this.mBitmap.getWidth() > 0) {
                    sx = this.mViewWidth / this.mBitmap.getWidth();
                }
                if (this.mBitmap.getHeight() > 0) {
                    sy = this.mViewHeight / this.mBitmap.getHeight();
                }
                this.mScale = sx < sy ? sx : sy;
                this.mInitScale = this.mScale;
                resizeBitmap();
            }
            if (this.mListener != null) {
                this.mListener.sizeChenged(canZoomIn(), canZoomOut());
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = 0.0f;
        try {
            int width = getWidth();
            int height = getHeight();
            if (this.mResizedWidth < width) {
                x = (width - this.mResizedWidth) / 2.0f;
            }
            float y = this.mResizedHeight < ((float) height) ? (height - this.mResizedHeight) / 2.0f : 0.0f;
            if (this.mResizeBitmap != null) {
                canvas.drawBitmap(this.mResizeBitmap, x, y, (Paint) null);
            }
        } catch (Exception ex) {
            TiebaLog.e("DragImageView", "onDraw", "error = " + ex.getMessage());
        }
    }

    private void initData() {
        this.mResizedWidth = 0.0f;
        this.mResizedHeight = 0.0f;
        this.mScale = 1.0f;
        this.mInitScale = 1.0f;
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
                if (DragImageView.this.mClick != null) {
                    DragImageView.this.mClick.onClick(DragImageView.this);
                }
                return super.onSingleTapUp(e);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
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
                if (sx != DragImageView.this.getScrollX() || sy != DragImageView.this.getScrollY()) {
                    DragImageView.this.scrollTo(sx, sy);
                    DragImageView.this.invalidate();
                    return true;
                }
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

    public void releaseBitmap() {
        this.mBitmap = null;
        if (this.mResizeBitmap != null && !this.mResizeBitmap.isRecycled()) {
            this.mResizeBitmap.recycle();
        }
        this.mResizeBitmap = null;
    }

    public Bitmap getImageBitmap() {
        return this.mBitmap;
    }

    public void setImageBitmap(Bitmap bitmap) {
        if (this.mAnimation.getIsAnimationInProgre()) {
            this.mAnimation.stopAnimation();
        }
        releaseBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitmap = bitmap;
            if (this.mViewWidth != 0 && this.mViewHeight != 0) {
                float sx = 1.0f;
                float sy = 1.0f;
                if (this.mBitmap.getWidth() > 0) {
                    sx = this.mViewWidth / this.mBitmap.getWidth();
                }
                if (this.mBitmap.getHeight() > 0) {
                    sy = this.mViewHeight / this.mBitmap.getHeight();
                }
                this.mScale = sx > sy ? sy : sx;
                this.mInitScale = this.mScale;
                resizeBitmap();
            }
        } else {
            this.mBitmap = null;
            this.mResizeBitmap = null;
            this.mResizedWidth = 0.0f;
            this.mResizedHeight = 0.0f;
            this.mInitScale = 1.0f;
            this.mScale = 1.0f;
            this.mIsTouched = false;
        }
        if (this.mListener != null) {
            this.mListener.sizeChenged(canZoomIn(), canZoomOut());
        }
        super.invalidate();
    }

    public boolean zoomInBitmap() {
        this.mScale *= 1.25f;
        resizeBitmap();
        return canZoomIn();
    }

    public boolean zoomOutBitmap() {
        this.mScale *= 0.8f;
        if (this.mScale < this.mInitScale) {
            this.mScale = this.mInitScale;
        }
        resizeBitmap();
        return canZoomOut();
    }

    private boolean canZoomIn() {
        if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mResizeBitmap == null || this.mResizeBitmap.isRecycled()) {
            return false;
        }
        return this.mResizeBitmap.getWidth() * this.mResizeBitmap.getHeight() <= 640000 && this.mScale <= 10.0f;
    }

    private boolean canZoomOut() {
        if (this.mResizeBitmap == null || this.mResizeBitmap.isRecycled()) {
            return false;
        }
        return this.mResizeBitmap.getWidth() > this.mViewWidth || this.mResizeBitmap.getHeight() > this.mViewHeight;
    }

    private void resizeBitmap() {
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(this.mScale, this.mScale);
            if (this.mResizeBitmap != null && this.mResizeBitmap != this.mBitmap && !this.mResizeBitmap.isRecycled()) {
                this.mResizeBitmap.recycle();
            }
            this.mResizeBitmap = null;
            if (this.mScale != 1.0f) {
                this.mResizeBitmap = Bitmap.createBitmap(this.mBitmap, 0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), matrix, true);
            } else {
                this.mResizeBitmap = this.mBitmap;
            }
            this.mResizedWidth = this.mResizeBitmap.getWidth();
            this.mResizedHeight = this.mResizeBitmap.getHeight();
            int sx = getScrollX();
            if (this.mResizedWidth > getWidth()) {
                if (getWidth() + sx > this.mResizedWidth) {
                    sx = (int) (this.mResizedWidth - getWidth());
                }
            } else {
                sx = 0;
            }
            int sy = getScrollY();
            if (this.mResizedHeight > getHeight()) {
                if (getHeight() + sy > this.mResizedHeight) {
                    sy = (int) (this.mResizedHeight - getHeight());
                }
            } else {
                sy = 0;
            }
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            scrollTo(sx, sy);
            super.invalidate();
        } catch (Exception ex) {
            TiebaLog.e("DragImageView", "resizeBitmap", "error = " + ex.getMessage());
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
            float tmp2 = ((float) (time > this.mTimeY ? this.mTimeY : time)) / 1000.0f;
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
                } else if (super.getTransformation(currentTime, outTransformation)) {
                    return true;
                } else {
                    this.mIsAnimationInProgres = false;
                    return false;
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
}
