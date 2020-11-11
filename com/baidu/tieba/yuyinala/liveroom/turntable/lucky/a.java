package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout htN;
    private boolean htS;

    public void nL(boolean z) {
        this.htS = z;
        if (this.htN != null && this.htN.getParent() != null) {
            this.htN.setVisibility(z ? 0 : 8);
        }
    }
}
