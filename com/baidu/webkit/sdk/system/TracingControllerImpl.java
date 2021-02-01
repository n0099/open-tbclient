package com.baidu.webkit.sdk.system;

import android.os.Build;
import android.webkit.TracingConfig;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.TracingConfig;
import com.baidu.webkit.sdk.TracingController;
import java.io.OutputStream;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class TracingControllerImpl extends TracingController {
    @Override // com.baidu.webkit.sdk.TracingController
    public boolean isTracing() {
        if (Build.VERSION.SDK_INT >= 28) {
            return android.webkit.TracingController.getInstance().isTracing();
        }
        return true;
    }

    @Override // com.baidu.webkit.sdk.TracingController
    public void start(@NonNull TracingConfig tracingConfig) {
        if (Build.VERSION.SDK_INT >= 28) {
            android.webkit.TracingController.getInstance().start(new TracingConfig.Builder().addCategories(tracingConfig.getPredefinedCategories()).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
        }
    }

    @Override // com.baidu.webkit.sdk.TracingController
    public boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor) {
        if (Build.VERSION.SDK_INT >= 28) {
            return android.webkit.TracingController.getInstance().stop(outputStream, executor);
        }
        return true;
    }
}
