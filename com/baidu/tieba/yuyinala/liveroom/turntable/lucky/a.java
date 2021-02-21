package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class a {
    private FrameLayout hPd;
    private boolean hPh;

    public void oM(boolean z) {
        this.hPh = z;
        if (this.hPd != null && this.hPd.getParent() != null) {
            this.hPd.setVisibility(z ? 0 : 8);
        }
    }
}
