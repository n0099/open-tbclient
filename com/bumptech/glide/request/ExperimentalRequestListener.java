package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.Target;
@Deprecated
/* loaded from: classes8.dex */
public abstract class ExperimentalRequestListener<ResourceT> implements RequestListener<ResourceT> {
    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, DataSource dataSource, boolean z, boolean z2);
}
