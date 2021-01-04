package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class a {
    private FrameLayout hPb;
    private boolean hPf;

    public void oG(boolean z) {
        this.hPf = z;
        if (this.hPb != null && this.hPb.getParent() != null) {
            this.hPb.setVisibility(z ? 0 : 8);
        }
    }
}
