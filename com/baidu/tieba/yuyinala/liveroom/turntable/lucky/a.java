package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a {
    private FrameLayout hKv;
    private boolean hKz;

    public void oC(boolean z) {
        this.hKz = z;
        if (this.hKv != null && this.hKv.getParent() != null) {
            this.hKv.setVisibility(z ? 0 : 8);
        }
    }
}
