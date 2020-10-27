package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout hnP;
    private boolean hnU;

    public void nC(boolean z) {
        this.hnU = z;
        if (this.hnP != null && this.hnP.getParent() != null) {
            this.hnP.setVisibility(z ? 0 : 8);
        }
    }
}
