package com.baidu.webkit.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.OutputStream;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public abstract class TracingController {
    @NonNull
    public static TracingController getInstance() {
        return WebViewFactory.getProvider().getTracingController();
    }

    public abstract boolean isTracing();

    public abstract void start(@NonNull TracingConfig tracingConfig);

    public abstract boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);
}
