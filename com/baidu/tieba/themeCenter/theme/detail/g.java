package com.baidu.tieba.themeCenter.theme.detail;

import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.view.HorizontalListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements HorizontalListView.a {
    final /* synthetic */ f dhd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dhd = fVar;
    }

    @Override // com.baidu.tbadk.core.view.HorizontalListView.a
    public void cI(int i) {
        IndicatorView indicatorView;
        IndicatorView indicatorView2;
        indicatorView = this.dhd.apA;
        if (indicatorView != null) {
            indicatorView2 = this.dhd.apA;
            indicatorView2.setPosition(i);
        }
    }
}
