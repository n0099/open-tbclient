package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;
/* loaded from: classes7.dex */
public interface RequestListener {
    boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z);

    boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z);
}
