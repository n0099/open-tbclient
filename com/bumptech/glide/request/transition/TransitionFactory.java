package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
/* loaded from: classes14.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource dataSource, boolean z);
}
