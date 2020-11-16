package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout htu;
    private boolean htz;

    public void nM(boolean z) {
        this.htz = z;
        if (this.htu != null && this.htu.getParent() != null) {
            this.htu.setVisibility(z ? 0 : 8);
        }
    }
}
