package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ScrollFragmentTabHost eaC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eaC = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        m mVar;
        m mVar2;
        a aVar2;
        this.eaC.topHeight = i2;
        aVar = this.eaC.eau;
        if (aVar != null) {
            aVar2 = this.eaC.eau;
            aVar2.b(view, i, i2, i3, i4);
        }
        mVar = this.eaC.eaw;
        if (mVar != null) {
            mVar2 = this.eaC.eaw;
            mVar2.ov(i2);
        }
    }
}
