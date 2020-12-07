package com.baidu.webkit.sdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.OutputStream;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public abstract class TracingController {
    @NonNull
    public static TracingController getInstance() {
        return WebViewFactory.getProvider().getTracingController();
    }

    public abstract boolean isTracing();

    public abstract void start(@NonNull TracingConfig tracingConfig);

    public abstract boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);
}
