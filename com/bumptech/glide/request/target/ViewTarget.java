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
import androidx.annotation.CallSuper;
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
@Deprecated
/* loaded from: classes9.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static final String TAG = "ViewTarget";
    public static boolean isTagUsedAtLeastOnce = false;
    public static int tagId = 2131300034;
    @Nullable
    public View.OnAttachStateChangeListener attachStateListener;
    public boolean isAttachStateListenerAdded;
    public boolean isClearedByUs;
    public final SizeDeterminer sizeDeterminer;

    /* renamed from: view  reason: collision with root package name */
    public final T f1188view;

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
        public final View f1189view;
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
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
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
            this.f1189view = view2;
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
                ViewTreeObserver viewTreeObserver = this.f1189view.getViewTreeObserver();
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
            if (this.waitForLayout && this.f1189view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1189view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return getMaxDisplayLength(this.f1189view.getContext());
        }

        private int getTargetHeight() {
            int i;
            int paddingTop = this.f1189view.getPaddingTop() + this.f1189view.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1189view.getLayoutParams();
            if (layoutParams != null) {
                i = layoutParams.height;
            } else {
                i = 0;
            }
            return getTargetDimen(this.f1189view.getHeight(), i, paddingTop);
        }

        private int getTargetWidth() {
            int i;
            int paddingLeft = this.f1189view.getPaddingLeft() + this.f1189view.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1189view.getLayoutParams();
            if (layoutParams != null) {
                i = layoutParams.width;
            } else {
                i = 0;
            }
            return getTargetDimen(this.f1189view.getWidth(), i, paddingLeft);
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
            ViewTreeObserver viewTreeObserver = this.f1189view.getViewTreeObserver();
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

    public ViewTarget(@NonNull T t) {
        this.f1188view = (T) Preconditions.checkNotNull(t);
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    private void setTag(@Nullable Object obj) {
        isTagUsedAtLeastOnce = true;
        this.f1188view.setTag(tagId, obj);
    }

    @Deprecated
    public static void setTagId(int i) {
        if (!isTagUsedAtLeastOnce) {
            tagId = i;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.getSize(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.clearCallbacksAndListener();
        if (!this.isClearedByUs) {
            maybeRemoveAttachStateListener();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        maybeAddAttachStateListener();
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.sizeDeterminer.removeCallback(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        setTag(request);
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }

    @Nullable
    private Object getTag() {
        return this.f1188view.getTag(tagId);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && !this.isAttachStateListenerAdded) {
            this.f1188view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener != null && this.isAttachStateListenerAdded) {
            this.f1188view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new View.OnAttachStateChangeListener() { // from class: com.bumptech.glide.request.target.ViewTarget.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                ViewTarget.this.resumeMyRequest();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                ViewTarget.this.pauseMyRequest();
            }
        };
        maybeAddAttachStateListener();
        return this;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        Object tag = getTag();
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @NonNull
    public T getView() {
        return this.f1188view;
    }

    public void pauseMyRequest() {
        Request request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    public void resumeMyRequest() {
        Request request = getRequest();
        if (request != null && request.isCleared()) {
            request.begin();
        }
    }

    public String toString() {
        return "Target for: " + this.f1188view;
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.waitForLayout = true;
        return this;
    }
}
