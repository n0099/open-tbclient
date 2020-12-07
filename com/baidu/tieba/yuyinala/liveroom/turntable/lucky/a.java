package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout hCY;
    private boolean hDc;

    public void oh(boolean z) {
        this.hDc = z;
        if (this.hCY != null && this.hCY.getParent() != null) {
            this.hCY.setVisibility(z ? 0 : 8);
        }
    }
}
