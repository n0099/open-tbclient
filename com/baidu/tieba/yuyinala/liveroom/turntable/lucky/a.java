package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes10.dex */
public class a {
    private FrameLayout hQM;
    private boolean hQQ;

    public void oM(boolean z) {
        this.hQQ = z;
        if (this.hQM != null && this.hQM.getParent() != null) {
            this.hQM.setVisibility(z ? 0 : 8);
        }
    }
}
