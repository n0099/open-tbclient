package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceView;
/* loaded from: classes6.dex */
public class SSSurfaceView extends SurfaceView {
    public SSSurfaceView(Context context) {
        super(context);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        if (i2 == 0) {
            super.onWindowVisibilityChanged(i2);
        }
    }
}
