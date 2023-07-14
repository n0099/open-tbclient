package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    public static final String TAG = "CustomViewTarget";
    @IdRes
    public static final int VIEW_TAG_ID = 2131299897;
    @Nullable
    public View.OnAttachStateChangeListener attachStateListener;
    public boolean isAttachStateListenerAdded;
    public boolean isClearedByUs;
    public final SizeDeterminer sizeDeterminer;

    /* renamed from: view  reason: collision with root package name */
    public final T f1196view;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    public abstract void onResourceCleared(@Nullable Drawable drawable);

    public void onResourceLoading(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(@IdRes int i) {
        return this;
    }

    @VisibleForTesting
    /* loaded from: classes9.dex */
    public static final class SizeDeterminer {
        public static final int PENDING_SIZE = 0;
        @Nullable
        @VisibleForTesting
        public static Integer maxDisplayLength;
        public final List<SizeReadyCallback> cbs = new ArrayList();
        @Nullable
        public SizeDeterminerLayoutListener layoutListener;

        /* renamed from: view  reason: collision with root package name */
        public final View f1197view;
        public boolean waitForLayout;

        private boolean isDimensionValid(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        /* loaded from: classes9.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.TAG, 2)) {
                    Log.v(CustomViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                if (sizeDeterminer != null) {
                    sizeDeterminer.checkCurrentDimens();
                    return true;
                }
                return true;
            }
        }

        public SizeDeterminer(@NonNull View view2) {
            this.f1197view = view2;
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.cbs.remove(sizeReadyCallback);
        }

        public static int getMaxDisplayLength(@NonNull Context context) {
            if (maxDisplayLength == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                maxDisplayLength = Integer.valueOf(Math.max(point.x, point.y));
            }
            return maxDisplayLength.intValue();
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
                sizeReadyCallback.onSizeReady(targetWidth, targetHeight);
                return;
            }
            if (!this.cbs.contains(sizeReadyCallback)) {
                this.cbs.add(sizeReadyCallback);
            }
            if (this.layoutListener == null) {
                ViewTreeObserver viewTreeObserver = this.f1197view.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.layoutListener = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        private int getTargetDimen(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.waitForLayout && this.f1197view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1197view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(CustomViewTarget.TAG, 4)) {
                Log.i(CustomViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return getMaxDisplayLength(this.f1197view.getContext());
        }

        private int getTargetHeight() {
            int i;
            int paddingTop = this.f1197view.getPaddingTop() + this.f1197view.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1197view.getLayoutParams();
            if (layoutParams != null) {
                i = layoutParams.height;
            } else {
                i = 0;
            }
            return getTargetDimen(this.f1197view.getHeight(), i, paddingTop);
        }

        private int getTargetWidth() {
            int i;
            int paddingLeft = this.f1197view.getPaddingLeft() + this.f1197view.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1197view.getLayoutParams();
            if (layoutParams != null) {
                i = layoutParams.width;
            } else {
                i = 0;
            }
            return getTargetDimen(this.f1197view.getWidth(), i, paddingLeft);
        }

        public void checkCurrentDimens() {
            if (this.cbs.isEmpty()) {
                return;
            }
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (!isViewStateAndSizeValid(targetWidth, targetHeight)) {
                return;
            }
            notifyCbs(targetWidth, targetHeight);
            clearCallbacksAndListener();
        }

        public void clearCallbacksAndListener() {
            ViewTreeObserver viewTreeObserver = this.f1197view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
            }
            this.layoutListener = null;
            this.cbs.clear();
        }

        private boolean isViewStateAndSizeValid(int i, int i2) {
            if (isDimensionValid(i) && isDimensionValid(i2)) {
                return true;
            }
            return false;
        }

        private void notifyCbs(int i, int i2) {
            Iterator it = new ArrayList(this.cbs).iterator();
            while (it.hasNext()) {
                ((SizeReadyCallback) it.next()).onSizeReady(i, i2);
            }
        }
    }

    public CustomViewTarget(@NonNull T t) {
        this.f1196view = (T) Preconditions.checkNotNull(t);
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    private void setTag(@Nullable Object obj) {
        this.f1196view.setTag(VIEW_TAG_ID, obj);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable drawable) {
        this.sizeDeterminer.clearCallbacksAndListener();
        onResourceCleared(drawable);
        if (!this.isClearedByUs) {
            maybeRemoveAttachStateListener();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable drawable) {
        maybeAddAttachStateListener();
        onResourceLoading(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.removeCallback(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        setTag(request);
    }

    @Nullable
    private Object getTag() {
        return this.f1196view.getTag(VIEW_TAG_ID);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && !this.isAttachStateListenerAdded) {
            this.f1196view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && this.isAttachStateListenerAdded) {
            this.f1196view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new View.OnAttachStateChangeListener() { // from class: com.bumptech.glide.request.target.CustomViewTarget.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                CustomViewTarget.this.resumeMyRequest();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                CustomViewTarget.this.pauseMyRequest();
            }
        };
        maybeAddAttachStateListener();
        return this;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        Object tag = getTag();
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @NonNull
    public final T getView() {
        return this.f1196view;
    }

    public final void pauseMyRequest() {
        Request request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    public final void resumeMyRequest() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    public String toString() {
        return "Target for: " + this.f1196view;
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
