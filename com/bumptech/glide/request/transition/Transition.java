package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public interface Transition {

    /* loaded from: classes7.dex */
    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean transition(Object obj, ViewAdapter viewAdapter);
}
