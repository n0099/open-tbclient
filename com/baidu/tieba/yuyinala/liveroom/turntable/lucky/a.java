package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class a {
    private FrameLayout hOP;
    private boolean hOT;

    public void oM(boolean z) {
        this.hOT = z;
        if (this.hOP != null && this.hOP.getParent() != null) {
            this.hOP.setVisibility(z ? 0 : 8);
        }
    }
}
