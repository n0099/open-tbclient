package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout hDa;
    private boolean hDe;

    public void oh(boolean z) {
        this.hDe = z;
        if (this.hDa != null && this.hDa.getParent() != null) {
            this.hDa.setVisibility(z ? 0 : 8);
        }
    }
}
