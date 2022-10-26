package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes7.dex */
public interface Target extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(Object obj, Transition transition);

    void removeCallback(SizeReadyCallback sizeReadyCallback);

    void setRequest(Request request);
}
